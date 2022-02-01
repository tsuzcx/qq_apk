package com.tencent.live2.jsplugin.pusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager.TXMusicPlayObserver;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.impl.V2TXLivePusherImpl;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.a.e;
import com.tencent.live2.impl.a.f;
import com.tencent.live2.impl.a.g;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class V2TXLivePusherJSAdapter
  extends com.tencent.live2.impl.a.b
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int BGM_ID = 1234567;
  private static final String TAG = "V2TXLivePusherJSAdapter";
  private TXLivePusher.ITXAudioVolumeEvaluationListener mAudioVolumeListener;
  private TXLivePusher.OnBGMNotify mBGMNotifyListener;
  private V2TXLivePusherJSConfig mConfig;
  private Context mContext;
  private boolean mIsBGMPlaying;
  private boolean mIsBGMPlayingWhenPausePusher;
  private boolean mIsCameraOpened;
  private boolean mIsFlashLightOpened;
  private boolean mIsInit;
  private boolean mIsMicrophoneOpened;
  private int mLastAngle;
  private ITXLivePushListener mLivePushListener;
  private final List<String> mMainStreamUserIdList;
  private Handler mMainThreadHandler;
  private boolean mNeedCompressSnapshot;
  private V2TXLivePusher mPusher;
  private V2TXLiveDef.V2TXLiveMode mPusherMode;
  private a.d mRTCProtocolType;
  private TXLivePusher.ITXSnapshotListener mSnapshotListener;
  private final List<String> mSubStreamUserIdList;
  private Surface mSurface;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private int mTRTCNetworkQuality;
  private Handler mThreadHandler;
  private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
  private TXCloudVideoView mVideoView;
  
  static
  {
    AppMethodBeat.i(211591);
    h.d();
    AppMethodBeat.o(211591);
  }
  
  public V2TXLivePusherJSAdapter(Context paramContext)
  {
    AppMethodBeat.i(211367);
    this.mLastAngle = 0;
    this.mContext = paramContext.getApplicationContext();
    this.mThreadHandler = new Handler(Looper.getMainLooper());
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.mConfig = new V2TXLivePusherJSConfig();
    this.mMainStreamUserIdList = new ArrayList();
    this.mSubStreamUserIdList = new ArrayList();
    this.mTRTCNetworkQuality = 2;
    AppMethodBeat.o(211367);
  }
  
  private int adjustHomeOrientation(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      if (!paramBoolean) {}
    }
    do
    {
      return 0;
      return 3;
      if (paramInt == 3)
      {
        if (paramBoolean) {
          break label45;
        }
        return 1;
      }
      if (paramInt != 0) {
        break;
      }
    } while (!paramBoolean);
    return 1;
    if (paramInt == 2)
    {
      if (paramBoolean) {
        return 3;
      }
      label45:
      return 2;
    }
    return -2147483648;
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211491);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "V2TXLivePusherJSAdapter(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(211491);
      return;
    }
    TXCLog.e("V2TXLivePusherJSAdapter", "V2TXLivePusherJSAdapter(" + hashCode() + ")" + str);
    AppMethodBeat.o(211491);
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211495);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (paramBoolean)
    {
      Monitor.a(1, "V2TXLivePusherJSAdapter(" + hashCode() + ")", str, 0);
      AppMethodBeat.o(211495);
      return;
    }
    TXCLog.i("V2TXLivePusherJSAdapter", "V2TXLivePusherJSAdapter(" + hashCode() + ")" + str);
    AppMethodBeat.o(211495);
  }
  
  private void callbackSDKVersion()
  {
    AppMethodBeat.i(211465);
    if (this.mLivePushListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", TXLiveBase.getSDKVersionStr());
      localBundle.putLong("EVT_TIME", System.currentTimeMillis());
      this.mLivePushListener.onPushEvent(-9999999, localBundle);
    }
    AppMethodBeat.o(211465);
  }
  
  private void createPusherInstance(V2TXLiveDef.V2TXLiveMode paramV2TXLiveMode)
  {
    AppMethodBeat.i(211378);
    this.mPusherMode = paramV2TXLiveMode;
    this.mPusher = new V2TXLivePusherImpl(this.mContext, this.mPusherMode);
    this.mPusher.setObserver(this);
    paramV2TXLiveMode = this.mPusher;
    if (this.mVideoCustomProcessListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramV2TXLiveMode.enableCustomVideoProcess(bool, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
      AppMethodBeat.o(211378);
      return;
    }
  }
  
  private void createPusherInstance(String paramString)
  {
    AppMethodBeat.i(211384);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211384);
      return;
    }
    createPusherInstance(com.tencent.live2.impl.b.a(paramString));
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      if (paramString.startsWith("trtc://"))
      {
        this.mRTCProtocolType = a.d.b;
        AppMethodBeat.o(211384);
        return;
      }
      if (paramString.startsWith("room://"))
      {
        this.mRTCProtocolType = a.d.a;
        AppMethodBeat.o(211384);
        return;
      }
      this.mRTCProtocolType = null;
    }
    AppMethodBeat.o(211384);
  }
  
  private String generateURL(String paramString, int paramInt)
  {
    AppMethodBeat.i(211516);
    StringBuilder localStringBuilder = new StringBuilder("room://cloud.tencent.com/rtc?userid=").append(paramString).append("&streamtype=");
    if (paramInt == 2) {}
    for (paramString = "aux";; paramString = "main")
    {
      paramString = paramString;
      AppMethodBeat.o(211516);
      return paramString;
    }
  }
  
  private JSONObject getAudioAvailableJSONObject(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(211540);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      localJSONObject.put("hasaudio", paramBoolean);
      AppMethodBeat.o(211540);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(211540);
    }
    return null;
  }
  
  private JSONObject getUserJSONObject(String paramString)
  {
    AppMethodBeat.i(211523);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString);
      AppMethodBeat.o(211523);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(211523);
    }
    return null;
  }
  
  private JSONObject getVideoAvailableJSONObject(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211534);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("userid", paramString1);
      localJSONObject.put("playurl", paramString2);
      if (paramInt == 2) {}
      for (paramString1 = "aux";; paramString1 = "main")
      {
        localJSONObject.put("streamtype", paramString1);
        localJSONObject.put("hasvideo", paramBoolean);
        AppMethodBeat.o(211534);
        return localJSONObject;
      }
      return null;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(211534);
    }
  }
  
  private V2TXJSAdapterError initLivePusherInner(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(211372);
    if (paramBundle == null)
    {
      apiOnlineError("init pusher inner fail. invalid bundle params.", false);
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(211372);
      return paramTXCloudVideoView;
    }
    if (this.mIsInit)
    {
      apiOnlineError("invalid operation. already init.", false);
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid operation. already init.");
      AppMethodBeat.o(211372);
      return paramTXCloudVideoView;
    }
    this.mIsInit = true;
    apiOnlineLog("init pusher.", true);
    this.mVideoView = paramTXCloudVideoView;
    this.mConfig.updateFromBundle(paramBundle);
    if (TextUtils.isEmpty(this.mConfig.url))
    {
      apiOnlineLog("can't find url. init default rtmp pusher instance.", false);
      createPusherInstance(V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP);
    }
    for (;;)
    {
      setFullParam(this.mConfig);
      if (this.mConfig.isAutoPush) {
        startPushInner(this.mConfig.url);
      }
      paramTXCloudVideoView = new V2TXJSAdapterError();
      AppMethodBeat.o(211372);
      return paramTXCloudVideoView;
      createPusherInstance(this.mConfig.url);
    }
  }
  
  private boolean isRTCProtocolType()
  {
    return this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
  }
  
  private boolean isRTCRoomProtocolType()
  {
    return (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC) && (this.mRTCProtocolType == a.d.a);
  }
  
  /* Error */
  private void notifyFullUserList()
  {
    // Byte code:
    //   0: ldc_w 393
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 319	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 320	org/json/JSONObject:<init>	()V
    //   13: astore_1
    //   14: new 395	org/json/JSONArray
    //   17: dup
    //   18: invokespecial 396	org/json/JSONArray:<init>	()V
    //   21: astore_2
    //   22: aload_1
    //   23: ldc_w 398
    //   26: aload_2
    //   27: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 119	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:mMainStreamUserIdList	Ljava/util/List;
    //   37: invokeinterface 404 1 0
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 409 1 0
    //   49: ifeq +88 -> 137
    //   52: aload_3
    //   53: invokeinterface 413 1 0
    //   58: checkcast 286	java/lang/String
    //   61: astore 4
    //   63: new 319	org/json/JSONObject
    //   66: dup
    //   67: invokespecial 320	org/json/JSONObject:<init>	()V
    //   70: astore 5
    //   72: aload 5
    //   74: ldc_w 322
    //   77: aload 4
    //   79: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   82: pop
    //   83: aload 5
    //   85: ldc_w 328
    //   88: aload_0
    //   89: aload 4
    //   91: iconst_0
    //   92: invokespecial 415	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:generateURL	(Ljava/lang/String;I)Ljava/lang/String;
    //   95: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   98: pop
    //   99: aload_2
    //   100: aload 5
    //   102: invokevirtual 418	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   105: pop
    //   106: goto -63 -> 43
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: ldc_w 393
    //   115: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: ldc 17
    //   123: ldc_w 420
    //   126: aload_1
    //   127: invokestatic 423	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: ldc_w 393
    //   133: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: aload_0
    //   138: monitorexit
    //   139: new 395	org/json/JSONArray
    //   142: dup
    //   143: invokespecial 396	org/json/JSONArray:<init>	()V
    //   146: astore_2
    //   147: aload_1
    //   148: ldc_w 425
    //   151: aload_2
    //   152: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload_0
    //   157: monitorenter
    //   158: aload_0
    //   159: getfield 121	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:mSubStreamUserIdList	Ljava/util/List;
    //   162: invokeinterface 404 1 0
    //   167: astore_3
    //   168: aload_3
    //   169: invokeinterface 409 1 0
    //   174: ifeq +71 -> 245
    //   177: aload_3
    //   178: invokeinterface 413 1 0
    //   183: checkcast 286	java/lang/String
    //   186: astore 4
    //   188: new 319	org/json/JSONObject
    //   191: dup
    //   192: invokespecial 320	org/json/JSONObject:<init>	()V
    //   195: astore 5
    //   197: aload 5
    //   199: ldc_w 322
    //   202: aload 4
    //   204: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 5
    //   210: ldc_w 328
    //   213: aload_0
    //   214: aload 4
    //   216: iconst_2
    //   217: invokespecial 415	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:generateURL	(Ljava/lang/String;I)Ljava/lang/String;
    //   220: invokevirtual 326	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   223: pop
    //   224: aload_2
    //   225: aload 5
    //   227: invokevirtual 418	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   230: pop
    //   231: goto -63 -> 168
    //   234: astore_1
    //   235: aload_0
    //   236: monitorexit
    //   237: ldc_w 393
    //   240: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_1
    //   244: athrow
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_0
    //   248: sipush 1020
    //   251: aload_1
    //   252: iconst_0
    //   253: invokespecial 429	com/tencent/live2/jsplugin/pusher/V2TXLivePusherJSAdapter:sendEventNotify	(ILorg/json/JSONObject;Z)V
    //   256: ldc_w 393
    //   259: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	V2TXLivePusherJSAdapter
    //   13	10	1	localJSONObject1	JSONObject
    //   109	10	1	localObject	Object
    //   120	28	1	localException	Exception
    //   234	18	1	localJSONObject2	JSONObject
    //   21	204	2	localJSONArray	JSONArray
    //   42	136	3	localIterator	java.util.Iterator
    //   61	154	4	str	String
    //   70	156	5	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   33	43	109	finally
    //   43	106	109	finally
    //   137	139	109	finally
    //   6	33	120	java/lang/Exception
    //   110	120	120	java/lang/Exception
    //   139	158	120	java/lang/Exception
    //   235	245	120	java/lang/Exception
    //   247	256	120	java/lang/Exception
    //   158	168	234	finally
    //   168	231	234	finally
    //   245	247	234	finally
  }
  
  private void runOnLivePusherThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(211471);
    Handler localHandler = this.mThreadHandler;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
    AppMethodBeat.o(211471);
  }
  
  private void sendEventNotify(int paramInt, String paramString)
  {
    AppMethodBeat.i(211548);
    apiOnlineLog("sendEventNotify [eventId:" + paramInt + "][message:" + paramString + "]", false);
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", paramString);
      localITXLivePushListener.onPushEvent(paramInt, localBundle);
    }
    AppMethodBeat.o(211548);
  }
  
  private void sendEventNotify(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(211557);
    Object localObject1 = String.valueOf(paramInt);
    Object localObject2;
    switch (paramInt)
    {
    default: 
      localObject2 = new StringBuilder("sendEventNotify [eventName:").append((String)localObject1).append("][params:");
      if (paramJSONObject == null) {
        break;
      }
    }
    for (localObject1 = paramJSONObject.toString();; localObject1 = "")
    {
      apiOnlineLog((String)localObject1 + "]", false);
      if (paramJSONObject != null) {
        break label176;
      }
      AppMethodBeat.o(211557);
      return;
      localObject1 = "VideoStateUpdate";
      break;
      localObject1 = "UserEnter";
      break;
      localObject1 = "UserExit";
      break;
      localObject1 = "AudioStateUpdate";
      break;
      localObject1 = "UserList";
      break;
    }
    label176:
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(paramJSONObject);
        paramJSONObject = new JSONObject();
        paramJSONObject.put("userlist", localObject1);
        paramJSONObject = paramJSONObject.toString();
        localObject1 = this.mLivePushListener;
        if (localObject1 != null)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("EVT_MSG", paramJSONObject);
          ((ITXLivePushListener)localObject1).onPushEvent(paramInt, (Bundle)localObject2);
        }
        AppMethodBeat.o(211557);
        return;
      }
      catch (Exception paramJSONObject)
      {
        AppMethodBeat.o(211557);
      }
      paramJSONObject = paramJSONObject.toString();
    }
  }
  
  private void setDiffParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig1, V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig2)
  {
    AppMethodBeat.i(211403);
    Object localObject = paramV2TXLivePusherJSConfig2.diffConfig(paramV2TXLivePusherJSConfig1);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      apiOnlineLog("set diff config. diff:".concat(String.valueOf(localObject)), true);
    }
    if (paramV2TXLivePusherJSConfig1.enableDebugView != paramV2TXLivePusherJSConfig2.enableDebugView) {
      this.mPusher.showDebugView(paramV2TXLivePusherJSConfig2.enableDebugView);
    }
    if (paramV2TXLivePusherJSConfig1.isFrontCamera != paramV2TXLivePusherJSConfig2.isFrontCamera) {
      this.mPusher.getDeviceManager().switchCamera(paramV2TXLivePusherJSConfig2.isFrontCamera);
    }
    if (paramV2TXLivePusherJSConfig1.enableAutoFocus != paramV2TXLivePusherJSConfig2.enableAutoFocus) {
      this.mPusher.getDeviceManager().enableCameraAutoFocus(paramV2TXLivePusherJSConfig2.enableAutoFocus);
    }
    if (paramV2TXLivePusherJSConfig1.enableZoom != paramV2TXLivePusherJSConfig2.enableZoom) {
      this.mPusher.setProperty("enableCameraZoom", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableZoom));
    }
    if (paramV2TXLivePusherJSConfig1.enableRemoteMirror != paramV2TXLivePusherJSConfig2.enableRemoteMirror) {
      this.mPusher.setEncoderMirror(paramV2TXLivePusherJSConfig2.enableRemoteMirror);
    }
    if (paramV2TXLivePusherJSConfig1.mirrorType != paramV2TXLivePusherJSConfig2.mirrorType) {
      this.mPusher.setRenderMirror(paramV2TXLivePusherJSConfig2.mirrorType);
    }
    if ((paramV2TXLivePusherJSConfig1.isVerticalOrientation != paramV2TXLivePusherJSConfig2.isVerticalOrientation) && (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP))
    {
      if (paramV2TXLivePusherJSConfig2.isVerticalOrientation) {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0);
      }
    }
    else
    {
      if ((paramV2TXLivePusherJSConfig1.isVerticalOrientation != paramV2TXLivePusherJSConfig2.isVerticalOrientation) || (paramV2TXLivePusherJSConfig1.aspect != paramV2TXLivePusherJSConfig2.aspect) || (paramV2TXLivePusherJSConfig1.width != paramV2TXLivePusherJSConfig2.width) || (paramV2TXLivePusherJSConfig1.height != paramV2TXLivePusherJSConfig2.height) || (paramV2TXLivePusherJSConfig1.mode != paramV2TXLivePusherJSConfig2.mode) || (paramV2TXLivePusherJSConfig1.minBitrate != paramV2TXLivePusherJSConfig2.minBitrate) || (paramV2TXLivePusherJSConfig1.maxBitrate != paramV2TXLivePusherJSConfig2.maxBitrate)) {
        setVideoEncParam(paramV2TXLivePusherJSConfig2);
      }
      if (paramV2TXLivePusherJSConfig1.enableCamera == paramV2TXLivePusherJSConfig2.enableCamera) {
        break label928;
      }
      localObject = this.mPusher;
      if (paramV2TXLivePusherJSConfig2.enableCamera) {
        break label916;
      }
      bool = true;
      label337:
      ((V2TXLivePusher)localObject).setProperty("setPureAudioPushMode", Boolean.valueOf(bool));
      if (!paramV2TXLivePusherJSConfig2.enableCamera) {
        break label921;
      }
      startCameraInner(paramV2TXLivePusherJSConfig2.isFrontCamera);
      label365:
      if (paramV2TXLivePusherJSConfig1.isMuteAudio != paramV2TXLivePusherJSConfig2.isMuteAudio) {
        this.mPusher.setProperty("muteAudio", Boolean.valueOf(paramV2TXLivePusherJSConfig2.isMuteAudio));
      }
      if (paramV2TXLivePusherJSConfig1.enableAGC != paramV2TXLivePusherJSConfig2.enableAGC) {
        this.mPusher.setProperty("enableAudioAGC", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableAGC));
      }
      if (paramV2TXLivePusherJSConfig1.enableANS != paramV2TXLivePusherJSConfig2.enableANS) {
        this.mPusher.setProperty("enableAudioANS", Boolean.valueOf(paramV2TXLivePusherJSConfig2.enableANS));
      }
      if (paramV2TXLivePusherJSConfig1.enableEarMonitor != paramV2TXLivePusherJSConfig2.enableEarMonitor) {
        this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(paramV2TXLivePusherJSConfig2.enableEarMonitor);
      }
      if (paramV2TXLivePusherJSConfig1.volumeNotifyIntervals != paramV2TXLivePusherJSConfig2.volumeNotifyIntervals) {
        this.mPusher.enableVolumeEvaluation(paramV2TXLivePusherJSConfig2.volumeNotifyIntervals);
      }
      if (paramV2TXLivePusherJSConfig1.volumeType != paramV2TXLivePusherJSConfig2.volumeType) {
        this.mPusher.getDeviceManager().setSystemVolumeType(paramV2TXLivePusherJSConfig2.volumeType);
      }
      if (paramV2TXLivePusherJSConfig1.reverbType != paramV2TXLivePusherJSConfig2.reverbType) {
        this.mPusher.getAudioEffectManager().setVoiceReverbType(paramV2TXLivePusherJSConfig2.reverbType);
      }
      if (paramV2TXLivePusherJSConfig1.audioQuality != paramV2TXLivePusherJSConfig2.audioQuality) {
        this.mPusher.setAudioQuality(paramV2TXLivePusherJSConfig1.audioQuality);
      }
      if (paramV2TXLivePusherJSConfig1.enableMicrophone == paramV2TXLivePusherJSConfig2.enableMicrophone) {
        break label960;
      }
      if (!paramV2TXLivePusherJSConfig2.enableMicrophone) {
        break label953;
      }
      startMicrophoneInner();
      label602:
      if (paramV2TXLivePusherJSConfig1.beautyStyle != paramV2TXLivePusherJSConfig2.beautyStyle) {
        this.mPusher.getBeautyManager().setBeautyStyle(paramV2TXLivePusherJSConfig1.beautyStyle);
      }
      if (paramV2TXLivePusherJSConfig1.beautyLevel != paramV2TXLivePusherJSConfig2.beautyLevel) {
        this.mPusher.getBeautyManager().setBeautyLevel(paramV2TXLivePusherJSConfig2.beautyLevel);
      }
      if (paramV2TXLivePusherJSConfig1.whitenessLevel != paramV2TXLivePusherJSConfig2.whitenessLevel) {
        this.mPusher.getBeautyManager().setWhitenessLevel(paramV2TXLivePusherJSConfig2.whitenessLevel);
      }
      if ((paramV2TXLivePusherJSConfig2.filterImagePath != null) && (!paramV2TXLivePusherJSConfig2.filterImagePath.equals(paramV2TXLivePusherJSConfig1.filterImagePath)))
      {
        if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.filterImagePath)) {
          break label981;
        }
        this.mPusher.getBeautyManager().setFilter(null);
      }
      label729:
      if (((paramV2TXLivePusherJSConfig2.watermarkImagePath != null) && (!paramV2TXLivePusherJSConfig2.watermarkImagePath.equals(paramV2TXLivePusherJSConfig1.watermarkImagePath))) || (paramV2TXLivePusherJSConfig1.watermarkWidth != paramV2TXLivePusherJSConfig2.watermarkWidth) || (paramV2TXLivePusherJSConfig1.watermarkLeft != paramV2TXLivePusherJSConfig2.watermarkLeft) || (paramV2TXLivePusherJSConfig1.watermarkTop != paramV2TXLivePusherJSConfig2.watermarkTop))
      {
        if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.watermarkImagePath)) {
          break label1007;
        }
        this.mPusher.setWatermark(null, 0.0F, 0.0F, 0.0F);
      }
    }
    for (;;)
    {
      if ((paramV2TXLivePusherJSConfig2.backgroundImagePath != null) && (!paramV2TXLivePusherJSConfig2.backgroundImagePath.equals(paramV2TXLivePusherJSConfig1.backgroundImagePath)))
      {
        if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.backgroundImagePath)) {
          break label1041;
        }
        this.mPusher.setProperty("setPauseParam", null);
      }
      if ((paramV2TXLivePusherJSConfig2.isAutoPush) && (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig2.url)) && (this.mPusher.isPushing() != 1))
      {
        apiOnlineLog("stat auto push.", false);
        startPushInner(paramV2TXLivePusherJSConfig2.url);
      }
      AppMethodBeat.o(211403);
      return;
      this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90);
      break;
      label916:
      bool = false;
      break label337;
      label921:
      stopCameraInner();
      break label365;
      label928:
      if ((!paramV2TXLivePusherJSConfig2.enableCamera) || (this.mIsCameraOpened)) {
        break label365;
      }
      startCameraInner(paramV2TXLivePusherJSConfig2.isFrontCamera);
      break label365;
      label953:
      stopMicrophoneInner();
      break label602;
      label960:
      if ((!paramV2TXLivePusherJSConfig2.enableMicrophone) || (this.mIsMicrophoneOpened)) {
        break label602;
      }
      startMicrophoneInner();
      break label602;
      label981:
      localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.filterImagePath);
      this.mPusher.getBeautyManager().setFilter((Bitmap)localObject);
      break label729;
      label1007:
      localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.watermarkImagePath);
      this.mPusher.setWatermark((Bitmap)localObject, paramV2TXLivePusherJSConfig2.watermarkLeft, paramV2TXLivePusherJSConfig2.watermarkTop, paramV2TXLivePusherJSConfig2.watermarkWidth);
    }
    label1041:
    paramV2TXLivePusherJSConfig1 = new a.c();
    paramV2TXLivePusherJSConfig1.a = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig2.backgroundImagePath);
    if (!paramV2TXLivePusherJSConfig2.isVOIP) {}
    for (boolean bool = true;; bool = false)
    {
      paramV2TXLivePusherJSConfig1.d = bool;
      paramV2TXLivePusherJSConfig1.c = true;
      paramV2TXLivePusherJSConfig1.e = -1;
      this.mPusher.setProperty("setPauseParam", paramV2TXLivePusherJSConfig1);
      break;
    }
  }
  
  private void setFullParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    boolean bool2 = false;
    AppMethodBeat.i(211391);
    apiOnlineLog("set full config:".concat(String.valueOf(paramV2TXLivePusherJSConfig)), true);
    this.mPusher.showDebugView(paramV2TXLivePusherJSConfig.enableDebugView);
    this.mPusher.getDeviceManager().enableCameraAutoFocus(paramV2TXLivePusherJSConfig.enableAutoFocus);
    this.mPusher.setProperty("enableCameraZoom", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableZoom));
    this.mPusher.setEncoderMirror(paramV2TXLivePusherJSConfig.enableRemoteMirror);
    this.mPusher.setRenderMirror(paramV2TXLivePusherJSConfig.mirrorType);
    boolean bool1;
    label208:
    label236:
    label374:
    a.c localc;
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      if (paramV2TXLivePusherJSConfig.isVerticalOrientation) {
        this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0);
      }
    }
    else
    {
      setVideoEncParam(paramV2TXLivePusherJSConfig);
      if (this.mVideoView != null) {
        this.mPusher.setRenderView(this.mVideoView);
      }
      if (this.mSurface != null)
      {
        this.mPusher.setProperty("setSurface", this.mSurface);
        this.mPusher.setProperty("setSurfaceSize", new a.a(this.mSurfaceWidth, this.mSurfaceHeight));
      }
      localObject = this.mPusher;
      if (paramV2TXLivePusherJSConfig.enableCamera) {
        break label561;
      }
      bool1 = true;
      ((V2TXLivePusher)localObject).setProperty("setPureAudioPushMode", Boolean.valueOf(bool1));
      if (!paramV2TXLivePusherJSConfig.enableCamera) {
        break label566;
      }
      startCameraInner(paramV2TXLivePusherJSConfig.isFrontCamera);
      this.mPusher.setProperty("muteAudio", Boolean.valueOf(paramV2TXLivePusherJSConfig.isMuteAudio));
      this.mPusher.setProperty("enableAudioAGC", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableAGC));
      this.mPusher.setProperty("enableAudioANS", Boolean.valueOf(paramV2TXLivePusherJSConfig.enableANS));
      this.mPusher.getAudioEffectManager().enableVoiceEarMonitor(paramV2TXLivePusherJSConfig.enableEarMonitor);
      this.mPusher.enableVolumeEvaluation(paramV2TXLivePusherJSConfig.volumeNotifyIntervals);
      this.mPusher.getDeviceManager().setSystemVolumeType(paramV2TXLivePusherJSConfig.volumeType);
      this.mPusher.getAudioEffectManager().setVoiceReverbType(paramV2TXLivePusherJSConfig.reverbType);
      this.mPusher.setAudioQuality(paramV2TXLivePusherJSConfig.audioQuality);
      if (!paramV2TXLivePusherJSConfig.enableMicrophone) {
        break label573;
      }
      startMicrophoneInner();
      this.mPusher.getBeautyManager().setBeautyStyle(paramV2TXLivePusherJSConfig.beautyStyle);
      this.mPusher.getBeautyManager().setBeautyLevel(paramV2TXLivePusherJSConfig.beautyLevel);
      this.mPusher.getBeautyManager().setWhitenessLevel(paramV2TXLivePusherJSConfig.whitenessLevel);
      if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig.filterImagePath)) {
        break label580;
      }
      this.mPusher.getBeautyManager().setFilter(null);
      label447:
      if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig.watermarkImagePath)) {
        break label606;
      }
      this.mPusher.setWatermark(null, 0.0F, 0.0F, 0.0F);
      label469:
      localc = new a.c();
      if (!TextUtils.isEmpty(paramV2TXLivePusherJSConfig.backgroundImagePath)) {
        break label640;
      }
    }
    label640:
    for (Object localObject = null;; localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.backgroundImagePath))
    {
      localc.a = ((Bitmap)localObject);
      bool1 = bool2;
      if (!paramV2TXLivePusherJSConfig.isVOIP) {
        bool1 = true;
      }
      localc.d = bool1;
      localc.c = true;
      localc.e = -1;
      this.mPusher.setProperty("setPauseParam", localc);
      AppMethodBeat.o(211391);
      return;
      this.mPusher.setRenderRotation(V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation90);
      break;
      label561:
      bool1 = false;
      break label208;
      label566:
      stopCameraInner();
      break label236;
      label573:
      stopMicrophoneInner();
      break label374;
      label580:
      localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.filterImagePath);
      this.mPusher.getBeautyManager().setFilter((Bitmap)localObject);
      break label447;
      label606:
      localObject = BitmapFactory.decodeFile(paramV2TXLivePusherJSConfig.watermarkImagePath);
      this.mPusher.setWatermark((Bitmap)localObject, paramV2TXLivePusherJSConfig.watermarkLeft, paramV2TXLivePusherJSConfig.watermarkTop, paramV2TXLivePusherJSConfig.watermarkWidth);
      break label469;
    }
  }
  
  private void setVideoEncParam(V2TXLivePusherJSConfig paramV2TXLivePusherJSConfig)
  {
    int i1 = 0;
    int i3 = 0;
    AppMethodBeat.i(211457);
    V2TXLivePusher localV2TXLivePusher = this.mPusher;
    if (localV2TXLivePusher == null)
    {
      apiOnlineError("set video encoder fail. pusher is null.", false);
      AppMethodBeat.o(211457);
      return;
    }
    int i4 = adjustHomeOrientation(this.mLastAngle, paramV2TXLivePusherJSConfig.isVerticalOrientation);
    int j;
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      if ((i4 == 0) || (i4 == 2)) {
        j = Math.max(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
      }
      for (i = Math.min(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);; i = Math.max(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height))
      {
        a.g localg = new a.g();
        localg.a = j;
        localg.b = i;
        localg.d = Math.max(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
        localg.c = 15;
        localV2TXLivePusher.setProperty("setCustomVideoEncParam", localg);
        AppMethodBeat.o(211457);
        return;
        j = Math.min(paramV2TXLivePusherJSConfig.width, paramV2TXLivePusherJSConfig.height);
      }
    }
    int i2;
    label266:
    int m;
    if (this.mPusherMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      localV2TXLivePusher.setProperty("setVideoQuality", new a.f(paramV2TXLivePusherJSConfig.mode, true, false));
      if ((paramV2TXLivePusherJSConfig.mode == 4) || (paramV2TXLivePusherJSConfig.mode == 5))
      {
        apiOnlineLog("ignore set main publisher or sub publisher gop and bitrate", false);
        AppMethodBeat.o(211457);
        return;
      }
      if ((paramV2TXLivePusherJSConfig.minBitrate <= 0) || (paramV2TXLivePusherJSConfig.maxBitrate <= 0)) {
        break label398;
      }
      i2 = 1;
      m = Math.min(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
      j = Math.max(paramV2TXLivePusherJSConfig.minBitrate, paramV2TXLivePusherJSConfig.maxBitrate);
      if (m == j) {
        break label404;
      }
    }
    int k;
    label398:
    label404:
    for (int i = 0;; i = -1) {
      switch (paramV2TXLivePusherJSConfig.mode)
      {
      case 4: 
      case 5: 
      default: 
        i1 = 5;
        n = i;
        k = j;
        j = m;
        i = i1;
        m = i3;
        localV2TXLivePusher.setProperty("setCustomVideoEncParam", new a.e(m, 15, i, j, k, i4, n));
        AppMethodBeat.o(211457);
        return;
        i2 = 0;
        break label266;
      }
    }
    if (i2 == 0)
    {
      k = 500;
      j = 900;
    }
    for (int n = 0;; n = i)
    {
      i = 5;
      i1 = j;
      m = i3;
      j = k;
      k = i1;
      break;
      i1 = m;
      k = j;
      n = i;
      if (i2 == 0)
      {
        i1 = 800;
        k = 1500;
        n = 0;
      }
      i = 5;
      m = 1;
      j = i1;
      break;
      i1 = m;
      k = j;
      n = i;
      if (i2 == 0)
      {
        i1 = 1000;
        k = 1800;
        n = 0;
      }
      i = 5;
      m = 2;
      j = i1;
      break;
      i1 = m;
      k = j;
      n = i;
      if (i2 == 0)
      {
        i1 = 3000;
        k = 3500;
        n = 0;
      }
      m = 30;
      i = 5;
      j = i1;
      break;
      n = m;
      k = j;
      if (i2 == 0)
      {
        n = 190;
        k = 810;
      }
      if (paramV2TXLivePusherJSConfig.aspect == 1) {
        m = 13;
      }
      for (;;)
      {
        i1 = 5;
        i = 1;
        j = n;
        n = i1;
        break;
        m = i1;
        if (paramV2TXLivePusherJSConfig.aspect == 2) {
          m = i1;
        }
      }
      k = m;
    }
  }
  
  private void startCameraInner(boolean paramBoolean)
  {
    AppMethodBeat.i(211410);
    if (this.mPusher == null)
    {
      apiOnlineError("start camera fail. pusher is null.", false);
      AppMethodBeat.o(211410);
      return;
    }
    if (this.mIsCameraOpened)
    {
      apiOnlineLog("already start camera.", false);
      AppMethodBeat.o(211410);
      return;
    }
    this.mIsCameraOpened = true;
    this.mPusher.startCamera(paramBoolean);
    AppMethodBeat.o(211410);
  }
  
  private void startMicrophoneInner()
  {
    AppMethodBeat.i(211422);
    if (this.mPusher == null)
    {
      apiOnlineError("start microphone fail. pusher is null.", false);
      AppMethodBeat.o(211422);
      return;
    }
    if (this.mIsMicrophoneOpened)
    {
      apiOnlineLog("already start microphone.", false);
      AppMethodBeat.o(211422);
      return;
    }
    this.mIsMicrophoneOpened = true;
    this.mPusher.startMicrophone();
    TXCAudioEngine.setAudioRoute(V2TXLivePlayerJSConfig.sAudioRoute);
    AppMethodBeat.o(211422);
  }
  
  private void startPushInner(String paramString)
  {
    AppMethodBeat.i(211436);
    if (this.mPusher == null)
    {
      apiOnlineError("start push fail. pusher is null.", false);
      AppMethodBeat.o(211436);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      apiOnlineError("start push inner fail.url is empty.", false);
      AppMethodBeat.o(211436);
      return;
    }
    apiOnlineLog("startPushInner", false);
    if ((this.mConfig.enableMicrophone) && (!this.mIsMicrophoneOpened)) {
      startMicrophoneInner();
    }
    if ((this.mConfig.enableCamera) && (!this.mIsCameraOpened)) {
      startCameraInner(this.mConfig.isFrontCamera);
    }
    this.mPusher.startPush(paramString);
    AppMethodBeat.o(211436);
  }
  
  private void stopCameraInner()
  {
    AppMethodBeat.i(211415);
    if (this.mPusher == null)
    {
      apiOnlineError("stop camera fail. pusher is null.", false);
      AppMethodBeat.o(211415);
      return;
    }
    if (!this.mIsCameraOpened)
    {
      apiOnlineLog("already stop camera.", false);
      AppMethodBeat.o(211415);
      return;
    }
    this.mIsCameraOpened = false;
    this.mPusher.stopCamera();
    AppMethodBeat.o(211415);
  }
  
  private void stopMicrophoneInner()
  {
    AppMethodBeat.i(211429);
    if (this.mPusher == null)
    {
      apiOnlineError("stop microphone fail. pusher is null.", false);
      AppMethodBeat.o(211429);
      return;
    }
    if (!this.mIsMicrophoneOpened)
    {
      apiOnlineLog("already stop microphone.", false);
      AppMethodBeat.o(211429);
      return;
    }
    this.mIsMicrophoneOpened = false;
    this.mPusher.stopMicrophone();
    AppMethodBeat.o(211429);
  }
  
  private void stopPushInner()
  {
    AppMethodBeat.i(211444);
    apiOnlineLog("stopPushInner", false);
    this.mIsBGMPlaying = false;
    this.mIsBGMPlayingWhenPausePusher = false;
    this.mIsFlashLightOpened = false;
    this.mIsMicrophoneOpened = false;
    this.mIsCameraOpened = false;
    if (this.mPusher != null)
    {
      this.mPusher.getAudioEffectManager().stopPlayMusic(1234567);
      this.mPusher.getAudioEffectManager().setMusicObserver(1234567, null);
      this.mPusher.stopPush();
    }
    AppMethodBeat.o(211444);
  }
  
  public int getMaxZoom()
  {
    AppMethodBeat.i(211733);
    if (this.mPusher == null)
    {
      AppMethodBeat.o(211733);
      return 0;
    }
    int i = (int)this.mPusher.getDeviceManager().getCameraZoomMaxRatio();
    AppMethodBeat.o(211733);
    return i;
  }
  
  public V2TXJSAdapterError initLivePusher(Bundle paramBundle)
  {
    AppMethodBeat.i(211636);
    callbackSDKVersion();
    paramBundle = initLivePusherInner(null, paramBundle);
    AppMethodBeat.o(211636);
    return paramBundle;
  }
  
  public V2TXJSAdapterError initLivePusher(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(211646);
    if (paramTXCloudVideoView == null)
    {
      paramTXCloudVideoView = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(211646);
      return paramTXCloudVideoView;
    }
    paramTXCloudVideoView = initLivePusherInner(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(211646);
    return paramTXCloudVideoView;
  }
  
  public boolean isPushing()
  {
    AppMethodBeat.i(211672);
    if (this.mPusher == null)
    {
      AppMethodBeat.o(211672);
      return false;
    }
    if (this.mPusher.isPushing() == 1)
    {
      AppMethodBeat.o(211672);
      return true;
    }
    AppMethodBeat.o(211672);
    return false;
  }
  
  public void notifyOrientationChanged(final int paramInt)
  {
    AppMethodBeat.i(211745);
    this.mMainThreadHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211357);
        if (V2TXLivePusherJSAdapter.this.mLastAngle != paramInt)
        {
          V2TXLivePusherJSAdapter.access$100(V2TXLivePusherJSAdapter.this, "notify orientation changed. [angle:" + paramInt + "]", true);
          V2TXLivePusherJSAdapter.access$002(V2TXLivePusherJSAdapter.this, paramInt);
          V2TXLivePusherJSAdapter.access$300(V2TXLivePusherJSAdapter.this, V2TXLivePusherJSAdapter.this.mConfig);
        }
        AppMethodBeat.o(211357);
      }
    });
    AppMethodBeat.o(211745);
  }
  
  public void onCaptureFirstAudioFrame()
  {
    AppMethodBeat.i(211798);
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onCaptureFirstAudioFrame: isn't rtc protocol,ignore", false);
      AppMethodBeat.o(211798);
      return;
    }
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener == null)
    {
      AppMethodBeat.o(211798);
      return;
    }
    localITXLivePushListener.onPushEvent(2027, new Bundle());
    AppMethodBeat.o(211798);
  }
  
  public void onCaptureFirstVideoFrame()
  {
    AppMethodBeat.i(211792);
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onCaptureFirstVideoFrame: isn't rtc protocol,ignore", false);
      AppMethodBeat.o(211792);
      return;
    }
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener == null)
    {
      AppMethodBeat.o(211792);
      return;
    }
    localITXLivePushListener.onPushEvent(1003, new Bundle());
    localITXLivePushListener.onPushEvent(1007, new Bundle());
    localITXLivePushListener.onPushEvent(1008, new Bundle());
    AppMethodBeat.o(211792);
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211873);
    Object localObject = this.mConfig;
    if ((1234567 == paramInt1) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMComplete(paramInt2);
      }
    }
    AppMethodBeat.o(211873);
  }
  
  public void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(211810);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onEnterRoom: isn't room protocol,ignore", false);
      AppMethodBeat.o(211810);
      return;
    }
    this.mMainStreamUserIdList.clear();
    this.mSubStreamUserIdList.clear();
    if (paramLong > 0L)
    {
      sendEventNotify(1018, "onEnterRoom success, time cost[" + paramLong + "]");
      AppMethodBeat.o(211810);
      return;
    }
    sendEventNotify(1022, "onEnterRoom failed, error code[" + paramLong + "]");
    sendEventNotify(-3301, "onEnterRoom failed, error code[" + paramLong + "]");
    if (paramLong == -100018L) {
      sendEventNotify(-100018, "onEnterRoom failed, user sign invalid.");
    }
    AppMethodBeat.o(211810);
  }
  
  public void onExitRoom(int paramInt)
  {
    AppMethodBeat.i(211816);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onExitRoom: isn't room protocol,ignore", false);
      AppMethodBeat.o(211816);
      return;
    }
    this.mMainStreamUserIdList.clear();
    this.mSubStreamUserIdList.clear();
    sendEventNotify(1019, "onExitRoom reason[" + paramInt + "]");
    AppMethodBeat.o(211816);
  }
  
  public void onGLContextCreated()
  {
    AppMethodBeat.i(211756);
    super.onGLContextCreated();
    AppMethodBeat.o(211756);
  }
  
  public void onGLContextDestroyed()
  {
    AppMethodBeat.i(211760);
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.mVideoCustomProcessListener;
    if (localVideoCustomProcessListener != null) {
      localVideoCustomProcessListener.onTextureDestoryed();
    }
    AppMethodBeat.o(211760);
  }
  
  public void onMicrophoneVolumeUpdate(int paramInt)
  {
    AppMethodBeat.i(211748);
    TXLivePusher.ITXAudioVolumeEvaluationListener localITXAudioVolumeEvaluationListener = this.mAudioVolumeListener;
    if (localITXAudioVolumeEvaluationListener != null) {
      localITXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(paramInt);
    }
    AppMethodBeat.o(211748);
  }
  
  public void onNetworkQuality(int paramInt)
  {
    this.mTRTCNetworkQuality = paramInt;
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(211867);
    Object localObject = this.mConfig;
    if ((1234567 == paramInt) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMProgress(paramLong1, paramLong2);
      }
    }
    AppMethodBeat.o(211867);
  }
  
  public int onProcessVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame1, V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame2)
  {
    AppMethodBeat.i(211764);
    TXLivePusher.VideoCustomProcessListener localVideoCustomProcessListener = this.mVideoCustomProcessListener;
    if (localVideoCustomProcessListener != null)
    {
      int i = localVideoCustomProcessListener.onTextureCustomProcess(paramV2TXLiveVideoFrame1.texture.textureId, paramV2TXLiveVideoFrame1.width, paramV2TXLiveVideoFrame1.height);
      paramV2TXLiveVideoFrame2.texture.textureId = i;
    }
    AppMethodBeat.o(211764);
    return 0;
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(211773);
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener != null) {
      localITXLivePushListener.onPushEvent(paramInt, paramBundle);
    }
    AppMethodBeat.o(211773);
  }
  
  public void onPushNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(211777);
    ITXLivePushListener localITXLivePushListener = this.mLivePushListener;
    if (localITXLivePushListener != null) {
      localITXLivePushListener.onNetStatus(paramBundle);
    }
    AppMethodBeat.o(211777);
  }
  
  public void onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus paramV2TXLivePushStatus, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(211785);
    apiOnlineLog("onPushStatusUpdate: [status:" + paramV2TXLivePushStatus + "]", false);
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onPushStatusUpdate: isn't rtc protocol,ignore", false);
      AppMethodBeat.o(211785);
      return;
    }
    paramString = this.mLivePushListener;
    if (paramString == null)
    {
      AppMethodBeat.o(211785);
      return;
    }
    switch (2.$SwitchMap$com$tencent$live2$V2TXLiveDef$V2TXLivePushStatus[paramV2TXLivePushStatus.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211785);
      return;
      paramString.onPushEvent(-1307, paramBundle);
      AppMethodBeat.o(211785);
      return;
      paramString.onPushEvent(1102, paramBundle);
      AppMethodBeat.o(211785);
      return;
      paramString.onPushEvent(1001, paramBundle);
      paramString.onPushEvent(1002, paramBundle);
    }
  }
  
  public void onRemoteUserEnter(String paramString)
  {
    AppMethodBeat.i(211821);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onRemoteUserEnter: isn't room protocol,ignore", false);
      AppMethodBeat.o(211821);
      return;
    }
    sendEventNotify(1031, getUserJSONObject(paramString), true);
    AppMethodBeat.o(211821);
  }
  
  public void onRemoteUserExit(String paramString, int paramInt)
  {
    AppMethodBeat.i(211827);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onRemoteUserExit: isn't room protocol,ignore", false);
      AppMethodBeat.o(211827);
      return;
    }
    sendEventNotify(1032, getUserJSONObject(paramString), true);
    AppMethodBeat.o(211827);
  }
  
  public void onSnapshotComplete(Bitmap paramBitmap)
  {
    AppMethodBeat.i(211768);
    TXLivePusher.ITXSnapshotListener localITXSnapshotListener = this.mSnapshotListener;
    if (localITXSnapshotListener == null)
    {
      AppMethodBeat.o(211768);
      return;
    }
    if (paramBitmap != null)
    {
      if (this.mNeedCompressSnapshot)
      {
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Matrix localMatrix = new Matrix();
        localMatrix.setScale(0.5F, 0.5F);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, false);
        localITXSnapshotListener.onSnapshot(paramBitmap);
        if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
          paramBitmap.recycle();
        }
        AppMethodBeat.o(211768);
        return;
      }
      localITXSnapshotListener.onSnapshot(paramBitmap);
      AppMethodBeat.o(211768);
      return;
    }
    localITXSnapshotListener.onSnapshot(paramBitmap);
    AppMethodBeat.o(211768);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211862);
    Object localObject = this.mConfig;
    if ((1234567 == paramInt1) && (((V2TXLivePusherJSConfig)localObject).enableBGMEventCallback))
    {
      localObject = this.mBGMNotifyListener;
      if (localObject != null) {
        ((TXLivePusher.OnBGMNotify)localObject).onBGMStart();
      }
    }
    AppMethodBeat.o(211862);
  }
  
  public void onStatisticsUpdate(V2TXLiveDef.V2TXLivePusherStatistics paramV2TXLivePusherStatistics)
  {
    AppMethodBeat.i(211855);
    Object localObject = String.format("%d%%|%d%%", new Object[] { Integer.valueOf(paramV2TXLivePusherStatistics.appCpu), Integer.valueOf(paramV2TXLivePusherStatistics.systemCpu) });
    String str = TXCStatus.b("18446744073709551615", 10001);
    int i = paramV2TXLivePusherStatistics.width;
    int j = paramV2TXLivePusherStatistics.height;
    int k = paramV2TXLivePusherStatistics.fps;
    int m = paramV2TXLivePusherStatistics.videoBitrate;
    int n = paramV2TXLivePusherStatistics.audioBitrate;
    paramV2TXLivePusherStatistics = new Bundle();
    paramV2TXLivePusherStatistics.putString("CPU_USAGE", (String)localObject);
    paramV2TXLivePusherStatistics.putInt("VIDEO_WIDTH", i);
    paramV2TXLivePusherStatistics.putInt("VIDEO_HEIGHT", j);
    paramV2TXLivePusherStatistics.putInt("VIDEO_FPS", k);
    paramV2TXLivePusherStatistics.putInt("NET_SPEED", n + m);
    paramV2TXLivePusherStatistics.putInt("VIDEO_BITRATE", m);
    paramV2TXLivePusherStatistics.putInt("AUDIO_BITRATE", n);
    paramV2TXLivePusherStatistics.putString("SERVER_IP", str);
    paramV2TXLivePusherStatistics.putInt("NET_QUALITY_LEVEL", this.mTRTCNetworkQuality);
    paramV2TXLivePusherStatistics.putInt("VIDEO_GOP", 1);
    paramV2TXLivePusherStatistics.putString("AUDIO_PLAY_INFO", "");
    localObject = this.mLivePushListener;
    if (localObject != null) {
      ((ITXLivePushListener)localObject).onNetStatus(paramV2TXLivePusherStatistics);
    }
    AppMethodBeat.o(211855);
  }
  
  public void onUserAudioAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211840);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onUserAudioAvailable: isn't room protocol,ignore", false);
      AppMethodBeat.o(211840);
      return;
    }
    sendEventNotify(1034, getAudioAvailableJSONObject(paramString, generateURL(paramString, 0), paramBoolean), true);
    AppMethodBeat.o(211840);
  }
  
  public void onUserVideoAvailable(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211833);
    if (!isRTCRoomProtocolType())
    {
      apiOnlineLog("onUserVideoAvailable: isn't room protocol,ignore", false);
      AppMethodBeat.o(211833);
      return;
    }
    sendEventNotify(1033, getVideoAvailableJSONObject(paramString, generateURL(paramString, paramInt), paramInt, paramBoolean), true);
    List localList;
    if (paramInt == 2)
    {
      localList = this.mSubStreamUserIdList;
      if (!paramBoolean) {
        break label93;
      }
      localList.add(paramString);
    }
    for (;;)
    {
      notifyFullUserList();
      AppMethodBeat.o(211833);
      return;
      localList = this.mMainStreamUserIdList;
      break;
      label93:
      localList.remove(paramString);
    }
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(211805);
    if (!isRTCProtocolType())
    {
      apiOnlineLog("onWarning: isn't rtc protocol,ignore", false);
      AppMethodBeat.o(211805);
      return;
    }
    paramString = this.mLivePushListener;
    if (paramString == null)
    {
      AppMethodBeat.o(211805);
      return;
    }
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramString.onPushEvent(paramInt, paramBundle);
      }
      AppMethodBeat.o(211805);
      return;
      paramInt = -1301;
      continue;
      paramInt = -1314;
      continue;
      paramInt = -1302;
      continue;
      paramInt = -1317;
    }
  }
  
  public V2TXJSAdapterError operateLivePusher(String paramString, JSONObject paramJSONObject)
  {
    int i = 0;
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(211691);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(211691);
      return paramString;
    }
    if ((!this.mIsInit) || (this.mPusher == null))
    {
      if ((paramString.equals("start")) || (paramString.equals("stop")) || (paramString.equals("resume")) || (paramString.equals("pause")) || (paramString.equals("startPreview")) || (paramString.equals("stopPreview")))
      {
        bool1 = true;
        paramString = new StringBuilder("operate live pusher fail. init pusher first.[operateName:").append(paramString).append("][isInit:").append(this.mIsInit).append("][hasPusher:");
        if (this.mPusher == null) {
          break label211;
        }
      }
      for (;;)
      {
        apiOnlineError(bool2 + "]", bool1);
        paramString = new V2TXJSAdapterError(-3, "uninited livePusher");
        AppMethodBeat.o(211691);
        return paramString;
        bool1 = false;
        break;
        label211:
        bool2 = false;
      }
    }
    if (paramString.equalsIgnoreCase("start"))
    {
      paramString = new StringBuilder("start push. url:");
      if (!TextUtils.isEmpty(this.mConfig.url)) {}
      for (bool1 = true;; bool1 = false)
      {
        apiOnlineLog(bool1 + ", isPushing: " + this.mPusher.isPushing(), true);
        if ((this.mPusher.isPushing() != 1) && (!TextUtils.isEmpty(this.mConfig.url))) {
          break;
        }
        apiOnlineLog("start push failed.", false);
        paramString = new V2TXJSAdapterError(-2, "fail");
        AppMethodBeat.o(211691);
        return paramString;
      }
      startPushInner(this.mConfig.url);
    }
    for (;;)
    {
      paramString = new V2TXJSAdapterError();
      AppMethodBeat.o(211691);
      return paramString;
      if (paramString.equalsIgnoreCase("stop"))
      {
        apiOnlineLog("stop push.", true);
        stopPushInner();
      }
      else
      {
        if (paramString.equalsIgnoreCase("pause"))
        {
          apiOnlineLog("pause push. isCameraOpened: " + this.mIsCameraOpened + ", isMicrophoneOpened: " + this.mIsMicrophoneOpened, true);
          if ((this.mIsCameraOpened) || (this.mIsMicrophoneOpened)) {
            this.mPusher.setProperty("pausePusher", Boolean.TRUE);
          }
          for (;;)
          {
            this.mIsBGMPlayingWhenPausePusher = this.mIsBGMPlaying;
            if (!this.mIsBGMPlayingWhenPausePusher) {
              break;
            }
            operateLivePusher("pauseBGM", null);
            break;
            apiOnlineLog("pause push failed.", false);
          }
        }
        label911:
        label922:
        label956:
        label965:
        label972:
        if (paramString.equalsIgnoreCase("resume"))
        {
          apiOnlineLog("resume push. isCameraOpened: " + this.mIsCameraOpened + ", isMicrophoneOpened: " + this.mIsMicrophoneOpened, true);
          if ((this.mIsCameraOpened) || (this.mIsMicrophoneOpened)) {
            this.mPusher.setProperty("pausePusher", Boolean.FALSE);
          }
          for (;;)
          {
            if (!this.mIsBGMPlayingWhenPausePusher) {
              break label613;
            }
            operateLivePusher("resumeBGM", null);
            break;
            apiOnlineLog("resume push failed.", false);
          }
        }
        else
        {
          label613:
          if (paramString.equalsIgnoreCase("startPreview"))
          {
            apiOnlineLog("start camera.", true);
            if (this.mPusher.isPushing() == 1)
            {
              apiOnlineLog("do not support startPreview when pushing", false);
              paramString = new V2TXJSAdapterError(-2, "fail");
              AppMethodBeat.o(211691);
              return paramString;
            }
            startCameraInner(this.mConfig.isFrontCamera);
          }
          else if (paramString.equalsIgnoreCase("stopPreview"))
          {
            apiOnlineLog("stop camera.", true);
            if (this.mPusher.isPushing() == 1)
            {
              apiOnlineLog("do not support stopPreview when pushing", false);
              paramString = new V2TXJSAdapterError(-2, "fail");
              AppMethodBeat.o(211691);
              return paramString;
            }
            stopCameraInner();
          }
          else
          {
            if (paramString.equalsIgnoreCase("switchCamera"))
            {
              paramString = this.mConfig;
              if (!this.mConfig.isFrontCamera) {}
              for (;;)
              {
                paramString.isFrontCamera = bool1;
                this.mPusher.getDeviceManager().switchCamera(this.mConfig.isFrontCamera);
                break;
                bool1 = false;
              }
            }
            if (paramString.equalsIgnoreCase("snapshot"))
            {
              this.mNeedCompressSnapshot = false;
              if (paramJSONObject != null)
              {
                paramString = paramJSONObject.optString("quality");
                if ((paramString != null) && (paramString.equalsIgnoreCase("compressed"))) {
                  this.mNeedCompressSnapshot = true;
                }
              }
              this.mPusher.snapshot();
            }
            else
            {
              if (paramString.equalsIgnoreCase("toggleTorch"))
              {
                if (!this.mIsFlashLightOpened)
                {
                  bool1 = bool3;
                  bool2 = this.mPusher.getDeviceManager().enableCameraTorch(bool1);
                  if (!bool2) {
                    break label956;
                  }
                  this.mIsFlashLightOpened = bool1;
                  if (!bool2) {
                    break label965;
                  }
                  if (!bool2) {
                    break label972;
                  }
                }
                for (paramString = "Success";; paramString = "Failed")
                {
                  paramString = new V2TXJSAdapterError(i, paramString);
                  AppMethodBeat.o(211691);
                  return paramString;
                  bool1 = false;
                  break;
                  bool1 = this.mIsFlashLightOpened;
                  break label911;
                  i = -2;
                  break label922;
                }
              }
              if (paramString.equalsIgnoreCase("playBGM"))
              {
                paramString = "";
                if (paramJSONObject != null) {
                  paramString = paramJSONObject.optString("BGMFilePath", "");
                }
                if (TextUtils.isEmpty(paramString))
                {
                  apiOnlineLog("playBGM failed. bgm url is empty.", false);
                  paramString = new V2TXJSAdapterError(-2, "fail");
                  AppMethodBeat.o(211691);
                  return paramString;
                }
                this.mIsBGMPlaying = true;
                paramString = new TXAudioEffectManager.AudioMusicParam(1234567, paramString);
                paramString.publish = true;
                this.mPusher.getAudioEffectManager().setMusicObserver(1234567, this);
                this.mPusher.getAudioEffectManager().startPlayMusic(paramString);
              }
              else if (paramString.equalsIgnoreCase("stopBGM"))
              {
                this.mIsBGMPlaying = false;
                this.mPusher.getAudioEffectManager().setMusicObserver(1234567, null);
                this.mPusher.getAudioEffectManager().stopPlayMusic(1234567);
              }
              else if (paramString.equalsIgnoreCase("pauseBGM"))
              {
                this.mIsBGMPlaying = false;
                this.mPusher.getAudioEffectManager().pausePlayMusic(1234567);
              }
              else if (paramString.equalsIgnoreCase("resumeBGM"))
              {
                this.mIsBGMPlaying = true;
                this.mPusher.getAudioEffectManager().resumePlayMusic(1234567);
              }
              else
              {
                double d;
                if (paramString.equalsIgnoreCase("setBGMVolume"))
                {
                  d = 1.0D;
                  if (paramJSONObject != null) {
                    d = paramJSONObject.optDouble("volume", 1.0D);
                  }
                  this.mPusher.getAudioEffectManager().setMusicPlayoutVolume(1234567, (int)(100.0D * d));
                  this.mPusher.getAudioEffectManager().setMusicPublishVolume(1234567, (int)(d * 100.0D));
                }
                else
                {
                  if (!paramString.equalsIgnoreCase("setMICVolume")) {
                    break;
                  }
                  d = 1.0D;
                  if (paramJSONObject != null) {
                    d = paramJSONObject.optDouble("volume", 1.0D);
                  }
                  this.mPusher.getAudioEffectManager().setVoiceCaptureVolume((int)(d * 100.0D));
                }
              }
            }
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("sendMessage"))
    {
      paramString = null;
      if (paramJSONObject != null) {
        paramString = paramJSONObject.optString("msg");
      }
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new V2TXJSAdapterError(-2, "fail");
        AppMethodBeat.o(211691);
        return paramString;
      }
      this.mPusher.setProperty("sendSEIMessage", paramString.getBytes());
      paramString = new V2TXJSAdapterError(0, "Success");
      AppMethodBeat.o(211691);
      return paramString;
    }
    paramString = new V2TXJSAdapterError(-4, "invalid operate command");
    AppMethodBeat.o(211691);
    return paramString;
  }
  
  public void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.mAudioVolumeListener = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.mBGMNotifyListener = paramOnBGMNotify;
  }
  
  public V2TXJSAdapterError setFocusPosition(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(211714);
    if (this.mPusher == null)
    {
      localV2TXJSAdapterError = new V2TXJSAdapterError(-3, "uninited livePusher");
      AppMethodBeat.o(211714);
      return localV2TXJSAdapterError;
    }
    this.mPusher.getDeviceManager().setCameraFocusPosition((int)paramFloat1, (int)paramFloat2);
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(211714);
    return localV2TXJSAdapterError;
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.mLivePushListener = paramITXLivePushListener;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.mSnapshotListener = paramITXSnapshotListener;
  }
  
  public V2TXJSAdapterError setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(211699);
    StringBuilder localStringBuilder = new StringBuilder("set surface:");
    if (paramSurface != null) {}
    for (Object localObject = Integer.valueOf(paramSurface.hashCode());; localObject = "0")
    {
      apiOnlineLog(localObject, false);
      this.mSurface = paramSurface;
      if (this.mPusher != null) {
        this.mPusher.setProperty("setSurface", paramSurface);
      }
      paramSurface = new V2TXJSAdapterError();
      AppMethodBeat.o(211699);
      return paramSurface;
    }
  }
  
  public V2TXJSAdapterError setSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211707);
    apiOnlineLog("set surface size: [width:" + paramInt1 + "][height:" + paramInt2 + "]", false);
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mPusher != null) {
      this.mPusher.setProperty("setSurfaceSize", new a.a(paramInt1, paramInt2));
    }
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(211707);
    return localV2TXJSAdapterError;
  }
  
  public void setThreadHandler(Handler paramHandler)
  {
    this.mThreadHandler = paramHandler;
  }
  
  public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener paramVideoCustomProcessListener)
  {
    AppMethodBeat.i(211622);
    this.mVideoCustomProcessListener = paramVideoCustomProcessListener;
    V2TXLivePusher localV2TXLivePusher;
    if (this.mPusher != null)
    {
      localV2TXLivePusher = this.mPusher;
      if (paramVideoCustomProcessListener == null) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      localV2TXLivePusher.enableCustomVideoProcess(bool, V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D, V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture);
      AppMethodBeat.o(211622);
      return;
    }
  }
  
  public V2TXJSAdapterError setZoom(int paramInt)
  {
    AppMethodBeat.i(211720);
    if (this.mPusher == null)
    {
      localV2TXJSAdapterError = new V2TXJSAdapterError(-3, "uninited livePusher");
      AppMethodBeat.o(211720);
      return localV2TXJSAdapterError;
    }
    this.mPusher.getDeviceManager().setCameraZoomRatio(paramInt);
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(211720);
    return localV2TXJSAdapterError;
  }
  
  public void takePhoto(boolean paramBoolean, TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(211738);
    if (this.mPusher != null)
    {
      this.mNeedCompressSnapshot = paramBoolean;
      this.mSnapshotListener = paramITXSnapshotListener;
      this.mPusher.snapshot();
    }
    AppMethodBeat.o(211738);
  }
  
  public V2TXJSAdapterError unInitLivePusher()
  {
    AppMethodBeat.i(211665);
    if (!this.mIsInit)
    {
      localV2TXJSAdapterError = new V2TXJSAdapterError(-3, "uninited livePusher");
      AppMethodBeat.o(211665);
      return localV2TXJSAdapterError;
    }
    apiOnlineLog("un init pusher.", true);
    stopPushInner();
    this.mIsInit = false;
    V2TXJSAdapterError localV2TXJSAdapterError = new V2TXJSAdapterError();
    AppMethodBeat.o(211665);
    return localV2TXJSAdapterError;
  }
  
  public V2TXJSAdapterError updateLivePusher(Bundle paramBundle)
  {
    AppMethodBeat.i(211657);
    if (paramBundle == null)
    {
      paramBundle = new V2TXJSAdapterError(-1, "invalid params");
      AppMethodBeat.o(211657);
      return paramBundle;
    }
    if (!this.mIsInit)
    {
      paramBundle = new V2TXJSAdapterError(-3, "uninited livePusher");
      AppMethodBeat.o(211657);
      return paramBundle;
    }
    apiOnlineLog("update pusher params:" + paramBundle.toString(), false);
    V2TXLivePusherJSConfig localV2TXLivePusherJSConfig = new V2TXLivePusherJSConfig(this.mConfig);
    localV2TXLivePusherJSConfig.updateFromBundle(paramBundle);
    if ((!TextUtils.isEmpty(localV2TXLivePusherJSConfig.url)) && (!localV2TXLivePusherJSConfig.url.equals(this.mConfig.url)))
    {
      apiOnlineLog("update url to:" + localV2TXLivePusherJSConfig.url, false);
      stopPushInner();
      createPusherInstance(localV2TXLivePusherJSConfig.url);
      setFullParam(localV2TXLivePusherJSConfig);
      this.mConfig = localV2TXLivePusherJSConfig;
      if (localV2TXLivePusherJSConfig.isAutoPush)
      {
        apiOnlineLog("auto push", true);
        startPushInner(localV2TXLivePusherJSConfig.url);
      }
      paramBundle = new V2TXJSAdapterError();
      AppMethodBeat.o(211657);
      return paramBundle;
    }
    if (this.mPusher != null) {
      setDiffParam(this.mConfig, localV2TXLivePusherJSConfig);
    }
    for (;;)
    {
      this.mConfig = localV2TXLivePusherJSConfig;
      break;
      apiOnlineError("pusher no init yet.ignore set diff param", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter
 * JD-Core Version:    0.7.0.1
 */