package com.tencent.live2.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayerStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCAudioFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCQuality;
import com.tencent.trtc.TRTCCloudDef.TRTCRenderParams;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCCloudListener.TRTCAudioFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import com.tencent.trtc.TRTCStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCLocalStatistics;
import com.tencent.trtc.TRTCStatistics.TRTCRemoteStatistics;
import com.tencent.trtc.TRTCSubCloud;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class f
  extends TRTCCloudListener
  implements TRTCCloudListener.TRTCAudioFrameListener, TRTCCloudListener.TRTCVideoRenderListener
{
  private static Method A;
  private static Method B;
  private static Method C;
  private static final Map<String, f> a;
  private static TRTCCloud b;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private static boolean h;
  private static boolean i;
  private static Method y;
  private static Method z;
  private final Handler c;
  private final TRTCCloud d;
  private final Map<String, b> j;
  private final Map<String, b> k;
  private final Map<String, c> l;
  private a.d m;
  private boolean n;
  private boolean o;
  private int p;
  private b q;
  private boolean r;
  private Context s;
  private a t;
  private V2TXLivePusherObserver u;
  private boolean v;
  private boolean w;
  private Map<String, Integer> x;
  
  static
  {
    AppMethodBeat.i(211801);
    a = new HashMap();
    o();
    AppMethodBeat.o(211801);
  }
  
  public f(Context paramContext, a.d paramd, a parama)
  {
    AppMethodBeat.i(211417);
    this.s = paramContext.getApplicationContext();
    this.t = parama;
    if (paramd == a.d.b) {}
    for (this.d = TRTCCloud.sharedInstance(paramContext).createSubCloud();; this.d = b)
    {
      this.d.setListener(this);
      this.c = new Handler(Looper.getMainLooper());
      this.j = new ConcurrentHashMap();
      this.k = new ConcurrentHashMap();
      this.l = new HashMap();
      this.p = 21;
      f("create instance:" + this.d.hashCode());
      AppMethodBeat.o(211417);
      return;
    }
  }
  
  public static int a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(211505);
    b.setWatermark(paramBitmap, 0, paramFloat1, paramFloat2, paramFloat3);
    AppMethodBeat.o(211505);
    return 0;
  }
  
  public static int a(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(211547);
    b.sendCustomVideoData(com.tencent.live2.impl.b.a(paramV2TXLiveVideoFrame));
    AppMethodBeat.o(211547);
    return 0;
  }
  
  private int a(a.d paramd, String paramString, int paramInt)
  {
    AppMethodBeat.i(211573);
    int i1 = 0;
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    paramString = (b)d(paramInt).get(paramString);
    paramInt = i1;
    if (localV2TXLivePusherObserver != null)
    {
      paramInt = i1;
      if ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b)) {
        paramInt = 1;
      }
    }
    if ((paramString != null) && (paramString.f != null) && ((paramString.f instanceof com.tencent.live2.impl.a.a))) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0) {
        if (paramd == a.d.a) {
          paramInt = 3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(211573);
        return paramInt;
        paramInt = 9;
        continue;
        if (paramd == a.d.a) {
          paramInt = 10;
        } else {
          paramInt = 4;
        }
      }
    }
  }
  
  public static int a(TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams)
  {
    AppMethodBeat.i(211467);
    TXCLog.i("V2-V2TRTCCloud", "startScreenCapture");
    g = true;
    m();
    b.startScreenCapture(paramTRTCVideoEncParam, paramTRTCScreenShareParams);
    AppMethodBeat.o(211467);
    return 0;
  }
  
  public static int a(boolean paramBoolean)
  {
    AppMethodBeat.i(211531);
    b.setVideoEncoderMirror(paramBoolean);
    AppMethodBeat.o(211531);
    return 0;
  }
  
  public static f a(Context paramContext, String paramString, a.d paramd, a parama)
  {
    AppMethodBeat.i(211399);
    if (paramd == a.d.a)
    {
      Iterator localIterator = a.values().iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if ((localf != null) && (localf.j()) && (localf.m == a.d.a))
        {
          AppMethodBeat.o(211399);
          return localf;
        }
      }
    }
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("V2-V2TRTCCloud", "create instance fail. room id is empty.");
      AppMethodBeat.o(211399);
      return null;
    }
    if (a.containsKey(paramString))
    {
      TXCLog.e("V2-V2TRTCCloud", "find exist instance, maybe something error. roomId:".concat(String.valueOf(paramString)));
      n();
      paramContext = (f)a.get(paramString);
      AppMethodBeat.o(211399);
      return paramContext;
    }
    paramContext = new f(paramContext, paramd, parama);
    TXCLog.i("V2-V2TRTCCloud", "create new instance. room id: " + paramString + " instance:" + paramContext.hashCode());
    a.put(paramString, paramContext);
    AppMethodBeat.o(211399);
    return paramContext;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211705);
    TXCLog.i("V2-V2TRTCCloud", "setPushSurfaceSize [width:" + paramInt1 + "][height:" + paramInt2 + "]");
    if (z == null)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface size fail. reflect method fail.");
      AppMethodBeat.o(211705);
      return;
    }
    try
    {
      z.invoke(b, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(211705);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface size fail.", localException);
      AppMethodBeat.o(211705);
    }
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(211393);
    b = TRTCCloud.sharedInstance(paramContext);
    AppMethodBeat.o(211393);
  }
  
  public static void a(Bitmap paramBitmap, int paramInt)
  {
    AppMethodBeat.i(211497);
    TXCLog.i("V2-V2TRTCCloud", "setVideoMuteImg [bitmap:" + paramBitmap + "][fps:" + paramInt + "]");
    b.setVideoMuteImage(paramBitmap, paramInt);
    AppMethodBeat.o(211497);
  }
  
  public static void a(Surface paramSurface)
  {
    AppMethodBeat.i(211698);
    StringBuilder localStringBuilder = new StringBuilder("setPushSurface surface:");
    if (paramSurface != null) {}
    for (String str = paramSurface.hashCode();; str = "null")
    {
      TXCLog.i("V2-V2TRTCCloud", str);
      if (y != null) {
        break;
      }
      TXCLog.e("V2-V2TRTCCloud", "set local surface fail. reflect method fail.");
      AppMethodBeat.o(211698);
      return;
    }
    try
    {
      y.invoke(b, new Object[] { paramSurface });
      AppMethodBeat.o(211698);
      return;
    }
    catch (Exception paramSurface)
    {
      TXCLog.e("V2-V2TRTCCloud", "set local surface fail.", paramSurface);
      AppMethodBeat.o(211698);
    }
  }
  
  public static void a(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    int i1 = 1;
    AppMethodBeat.i(211453);
    TXCLog.i("V2-V2TRTCCloud", "startMicrophone quality: ".concat(String.valueOf(paramV2TXLiveAudioQuality)));
    h = true;
    m();
    if (paramV2TXLiveAudioQuality == V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualitySpeech) {}
    for (;;)
    {
      b.startLocalAudio(i1);
      AppMethodBeat.o(211453);
      return;
      if (paramV2TXLiveAudioQuality == V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityMusic) {
        i1 = 3;
      } else {
        i1 = 2;
      }
    }
  }
  
  public static void a(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    AppMethodBeat.i(211515);
    switch (30.a[paramV2TXLiveMirrorType.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211515);
      return;
      b.setLocalViewMirror(0);
      AppMethodBeat.o(211515);
      return;
      b.setLocalViewMirror(1);
      AppMethodBeat.o(211515);
      return;
      b.setLocalViewMirror(2);
    }
  }
  
  public static void a(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211521);
    b.setLocalViewRotation(com.tencent.live2.impl.b.b(paramV2TXLiveRotation));
    AppMethodBeat.o(211521);
  }
  
  public static void a(f paramf)
  {
    AppMethodBeat.i(211405);
    StringBuilder localStringBuilder = new StringBuilder("destroy instance:");
    if (paramf != null) {}
    for (Object localObject = paramf.hashCode();; localObject = "null")
    {
      TXCLog.i("V2-V2TRTCCloud", (String)localObject);
      if (paramf != null) {
        break;
      }
      AppMethodBeat.o(211405);
      return;
    }
    localObject = a.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((Map.Entry)((Iterator)localObject).next()).getValue() == paramf)
      {
        ((Iterator)localObject).remove();
        paramf.k();
        AppMethodBeat.o(211405);
        return;
      }
    }
    AppMethodBeat.o(211405);
  }
  
  public static void a(a.g paramg)
  {
    AppMethodBeat.i(211555);
    TXCLog.i("V2-V2TRTCCloud", "setVideoEncoderParam param:".concat(String.valueOf(paramg)));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("streamType", 0);
      localJSONObject.put("videoWidth", paramg.a);
      localJSONObject.put("videoHeight", paramg.b);
      localJSONObject.put("videoBitrate", paramg.d);
      localJSONObject.put("videoFps", paramg.c);
      paramg = new JSONObject();
      paramg.put("api", "setVideoEncodeParamEx");
      paramg.put("params", localJSONObject);
      b.callExperimentalAPI(paramg.toString());
      AppMethodBeat.o(211555);
      return;
    }
    catch (JSONException paramg)
    {
      AppMethodBeat.o(211555);
    }
  }
  
  private void a(TRTCCloudDef.TRTCParams paramTRTCParams, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211581);
    f("enterRoom");
    Context localContext;
    int i1;
    if (this.m == a.d.a)
    {
      c.a();
      this.p = paramTRTCParams.role;
      paramInt2 = a(this.m, paramTRTCParams.userId, paramInt2);
      f("enterRoom frameworkType ".concat(String.valueOf(paramInt2)));
      this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setFramework\", \"params\": {\"framework\":%d, \"scene\":%d, \"sdkappid\":%d}}", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramTRTCParams.sdkAppId) }));
      localContext = this.s;
      paramInt2 = com.tencent.liteav.basic.datareport.a.bI;
      i1 = paramTRTCParams.sdkAppId;
      if (this.m != a.d.b) {
        break label221;
      }
    }
    label221:
    for (String str = "RTC";; str = "ROOM")
    {
      TXCDRApi.txReportDAU(localContext, paramInt2, i1, str);
      this.d.enterRoom(paramTRTCParams, paramInt1);
      AppMethodBeat.o(211581);
      return;
      if (this.m != a.d.b) {
        break;
      }
      c.a(paramTRTCParams.userId, paramTRTCParams.sdkAppId, String.valueOf(paramTRTCParams.strRoomId));
      this.d.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setRoomType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
      break;
    }
  }
  
  public static void a(TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211567);
    b.setLocalVideoProcessListener(paramInt1, paramInt2, paramTRTCVideoFrameListener);
    AppMethodBeat.o(211567);
  }
  
  private void a(String paramString, int paramInt, final V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, final V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    AppMethodBeat.i(211731);
    final b localb = (b)d(paramInt).get(paramString);
    c localc = (c)this.l.get(paramString);
    if ((localb != null) && (localc != null))
    {
      if (e(paramInt)) {}
      for (boolean bool = localc.c; (paramV2TXLivePlayStatus == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) && ((!bool) || (localb.j)); bool = localc.f)
      {
        h("update status(video) fail.[userId:" + paramString + "][videoAvailable:" + bool + "][videoMuted:" + localb.j + "][fromStatus:" + b.b(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
        AppMethodBeat.o(211731);
        return;
      }
      if (!com.tencent.live2.impl.b.a(b.b(localb), paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
      {
        h("update status(video) fail.[userId:" + paramString + "][videoAvailable:" + bool + "][videoMuted:" + localb.j + "][fromStatus:" + b.b(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
        AppMethodBeat.o(211731);
        return;
      }
      f("update status(video) success.[userId:" + paramString + "][fromStatus:" + b.b(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
      b.b(localb, paramV2TXLivePlayStatus);
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211443);
          if ((localb.f != null) && (localb.g != null)) {
            localb.f.onVideoPlayStatusUpdate(localb.g, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason, new Bundle());
          }
          AppMethodBeat.o(211443);
        }
      });
      AppMethodBeat.o(211731);
      return;
    }
    paramV2TXLivePlayStatus = new StringBuilder("update status(video) fail. cant'find info. [userInfo:");
    if (localc == null)
    {
      paramString = "null";
      paramV2TXLivePlayStatus = paramV2TXLivePlayStatus.append(paramString).append("][playerInfo:");
      if (localb != null) {
        break label469;
      }
    }
    label469:
    for (paramString = "null";; paramString = Integer.valueOf(localb.hashCode()))
    {
      h(paramString + "]");
      AppMethodBeat.o(211731);
      return;
      paramString = Integer.valueOf(localc.hashCode());
      break;
    }
  }
  
  private void a(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView, TRTCCloudDef.TRTCRenderParams paramTRTCRenderParams)
  {
    AppMethodBeat.i(211615);
    this.d.startRemoteView(paramString, paramInt, paramTXCloudVideoView);
    this.d.setRemoteRenderParams(paramString, paramInt, paramTRTCRenderParams);
    AppMethodBeat.o(211615);
  }
  
  private void a(String paramString, final V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, final V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason)
  {
    AppMethodBeat.i(211716);
    final b localb = (b)this.j.get(paramString);
    c localc = (c)this.l.get(paramString);
    if ((localb != null) && (localc != null))
    {
      if ((paramV2TXLivePlayStatus == V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying) && ((!localc.b) || (localb.i)))
      {
        h("update status(audio) fail.[userId:" + paramString + "][audioAvailable:" + localc.b + "][fromStatus:" + b.a(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
        AppMethodBeat.o(211716);
        return;
      }
      if (!com.tencent.live2.impl.b.a(b.a(localb), paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason))
      {
        h("update status(audio) fail.[userId:" + paramString + "][audioAvailable:" + localc.b + "][fromStatus:" + b.a(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
        AppMethodBeat.o(211716);
        return;
      }
      f("update status(audio) success.[userId:" + paramString + "][fromStatus:" + b.a(localb) + "][toStatus:" + paramV2TXLivePlayStatus + "][reason:" + paramV2TXLiveStatusChangeReason + "]");
      b.a(localb, paramV2TXLivePlayStatus);
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211454);
          if ((localb.f != null) && (localb.g != null)) {
            localb.f.onAudioPlayStatusUpdate(localb.g, paramV2TXLivePlayStatus, paramV2TXLiveStatusChangeReason, new Bundle());
          }
          AppMethodBeat.o(211454);
        }
      });
      AppMethodBeat.o(211716);
      return;
    }
    paramV2TXLivePlayStatus = new StringBuilder("update status(audio) fail. cant'find info. [userInfo:");
    if (localc == null)
    {
      paramString = "null";
      paramV2TXLivePlayStatus = paramV2TXLivePlayStatus.append(paramString).append("][playerInfo:");
      if (localb != null) {
        break label419;
      }
    }
    label419:
    for (paramString = "null";; paramString = Integer.valueOf(localb.hashCode()))
    {
      h(paramString + "]");
      AppMethodBeat.o(211716);
      return;
      paramString = Integer.valueOf(localc.hashCode());
      break;
    }
  }
  
  private void a(final String paramString1, final String paramString2, int paramInt)
  {
    AppMethodBeat.i(211664);
    if ((this.m != a.d.b) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(211664);
      return;
    }
    b localb = (b)d(paramInt).remove(paramString1);
    if (localb == null)
    {
      h("update remote user id fail. can't find [userId:" + paramString1 + "] playerInfo.");
      AppMethodBeat.o(211664);
      return;
    }
    if (localb.a == null)
    {
      h("update remote user id fail. url param is null.");
      AppMethodBeat.o(211664);
      return;
    }
    localb.a.a(paramString2);
    d(paramInt).put(paramString2, localb);
    paramString1 = this.t;
    if (paramString1 != null) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211481);
          paramString1.a(paramString2);
          AppMethodBeat.o(211481);
        }
      });
    }
    AppMethodBeat.o(211664);
  }
  
  private void a(final String paramString, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(211675);
    c localc = (c)this.l.get(paramString);
    if (localc == null)
    {
      h("onUserVideoAvailableInner error: can't find [userId:" + paramString + "] user info.");
      AppMethodBeat.o(211675);
      return;
    }
    if (e(paramInt)) {
      localc.c = paramBoolean;
    }
    b localb;
    for (;;)
    {
      if (paramBoolean) {
        if (this.m == a.d.b)
        {
          if (!localc.b) {
            a("27eb683b73944771ce62fbddab2849a4", paramString, paramInt);
          }
          localb = (b)d(paramInt).get(paramString);
          if (localb == null)
          {
            h("onUserVideoAvailableInner error: can't find player info.");
            AppMethodBeat.o(211675);
            return;
            localc.f = paramBoolean;
            continue;
          }
          if (localb.b != null)
          {
            f("onUserVideoAvailableInner: start remote play.");
            a(paramString, paramInt, localb.b, localb.k);
          }
        }
        else
        {
          if (!e(paramInt)) {
            break label380;
          }
          if (localc.d) {
            a(paramString, 0, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211509);
            V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
            if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
              ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onUserVideoAvailable(paramString, paramInt, paramBoolean);
            }
            AppMethodBeat.o(211509);
          }
        });
        AppMethodBeat.o(211675);
        return;
        if ((localb.b != null) || (localb.c == null)) {
          break label370;
        }
        f("onUserVideoAvailableInner: start remote surface play.");
        a(paramString, paramInt, null, localb.k);
        try
        {
          A.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt), localb.c });
          B.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(localb.d), Integer.valueOf(localb.e) });
        }
        catch (Exception localException)
        {
          TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", localException);
        }
      }
      break;
      label370:
      g("onUserVideoAvailableInner: video view is null.waiting for view to start play.");
      break;
      label380:
      if (localc.g)
      {
        a(paramString, 2, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
        continue;
        a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
        if (this.m == a.d.b)
        {
          if (!localc.b) {
            a(paramString, "27eb683b73944771ce62fbddab2849a4", paramInt);
          }
          this.d.stopRemoteView(paramString, paramInt);
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211445);
    StringBuilder localStringBuilder = new StringBuilder("startCamera [front:").append(paramBoolean).append("][view: ");
    if (paramTXCloudVideoView != null) {}
    for (String str = paramTXCloudVideoView.hashCode();; str = "null")
    {
      TXCLog.i("V2-V2TRTCCloud", str + "]");
      f = true;
      m();
      b.startLocalPreview(paramBoolean, paramTXCloudVideoView);
      AppMethodBeat.o(211445);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    AppMethodBeat.i(211412);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211412);
      return false;
    }
    paramString = (f)a.get(paramString);
    if ((paramString != null) && (paramString.a()))
    {
      AppMethodBeat.o(211412);
      return true;
    }
    AppMethodBeat.o(211412);
    return false;
  }
  
  public static int b(boolean paramBoolean)
  {
    AppMethodBeat.i(211538);
    if (i != paramBoolean)
    {
      TXCLog.i("V2-V2TRTCCloud", "enableCustomVideoCapture enable: ".concat(String.valueOf(paramBoolean)));
      i = paramBoolean;
      m();
      b.enableCustomVideoCapture(paramBoolean);
    }
    AppMethodBeat.o(211538);
    return 0;
  }
  
  public static void b()
  {
    AppMethodBeat.i(211449);
    if (f)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopCamera");
      f = false;
      m();
      b.stopLocalPreview();
    }
    AppMethodBeat.o(211449);
  }
  
  public static void b(int paramInt)
  {
    AppMethodBeat.i(211690);
    try
    {
      C.invoke(null, new Object[] { Integer.valueOf(paramInt) });
      TXCLog.i("V2-V2TRTCCloud", "set env success. env:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(211690);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("V2-V2TRTCCloud", "set env fail.", localException);
      AppMethodBeat.o(211690);
    }
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(211561);
    b.callExperimentalAPI(paramString);
    AppMethodBeat.o(211561);
  }
  
  public static void c()
  {
    AppMethodBeat.i(211458);
    if (h)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopMicrophone");
      h = false;
      m();
      b.stopLocalAudio();
    }
    AppMethodBeat.o(211458);
  }
  
  private void c(int paramInt)
  {
    AppMethodBeat.i(211588);
    Object localObject2 = new StringBuilder("notify all instance switch role to:");
    if (paramInt == 20) {}
    for (Object localObject1 = "anchor";; localObject1 = "audience")
    {
      f((String)localObject1);
      localObject1 = a.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!((f)localObject2).j()) && (((f)localObject2).a()))
        {
          ((f)localObject2).p = paramInt;
          ((f)localObject2).d.switchRole(paramInt);
          ((f)localObject2).d.muteLocalVideo(true);
          ((f)localObject2).d.muteLocalAudio(true);
        }
      }
    }
    AppMethodBeat.o(211588);
  }
  
  public static int d()
  {
    AppMethodBeat.i(211473);
    if (g)
    {
      TXCLog.i("V2-V2TRTCCloud", "stopScreenCapture");
      g = false;
      m();
      b.stopScreenCapture();
    }
    AppMethodBeat.o(211473);
    return 0;
  }
  
  private Map<String, b> d(int paramInt)
  {
    AppMethodBeat.i(211602);
    if (e(paramInt)) {}
    for (Map localMap = this.j;; localMap = this.k)
    {
      AppMethodBeat.o(211602);
      return localMap;
    }
  }
  
  public static TXAudioEffectManager e()
  {
    AppMethodBeat.i(211479);
    TXAudioEffectManager localTXAudioEffectManager = b.getAudioEffectManager();
    AppMethodBeat.o(211479);
    return localTXAudioEffectManager;
  }
  
  private boolean e(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private boolean e(String paramString)
  {
    AppMethodBeat.i(211598);
    if ((TextUtils.isEmpty(paramString)) || ("27eb683b73944771ce62fbddab2849a4".equals(paramString)))
    {
      AppMethodBeat.o(211598);
      return true;
    }
    AppMethodBeat.o(211598);
    return false;
  }
  
  public static TXBeautyManager f()
  {
    AppMethodBeat.i(211483);
    TXBeautyManager localTXBeautyManager = b.getBeautyManager();
    AppMethodBeat.o(211483);
    return localTXBeautyManager;
  }
  
  private b f(String paramString, int paramInt)
  {
    AppMethodBeat.i(211606);
    Map localMap = d(paramInt);
    b localb2 = (b)localMap.get(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      localMap.put(paramString, localb1);
    }
    AppMethodBeat.o(211606);
    return localb1;
  }
  
  private void f(String paramString)
  {
    AppMethodBeat.i(211621);
    TXCLog.i("V2-V2TRTCCloud", "v2_trtccloud(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211621);
  }
  
  public static TXDeviceManager g()
  {
    AppMethodBeat.i(211492);
    TXDeviceManager localTXDeviceManager = b.getDeviceManager();
    AppMethodBeat.o(211492);
    return localTXDeviceManager;
  }
  
  private void g(String paramString)
  {
    AppMethodBeat.i(211630);
    TXCLog.w("V2-V2TRTCCloud", "v2_trtccloud(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211630);
  }
  
  private void h(String paramString)
  {
    AppMethodBeat.i(211637);
    TXCLog.e("V2-V2TRTCCloud", "v2_trtccloud(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211637);
  }
  
  private void k()
  {
    AppMethodBeat.i(211425);
    f("destroy instance:" + this.d.hashCode());
    this.t = null;
    this.j.clear();
    this.k.clear();
    if (b != this.d) {
      b.destroySubCloud(this.d);
    }
    this.l.clear();
    n();
    AppMethodBeat.o(211425);
  }
  
  private static boolean l()
  {
    return (f) || (g) || (i) || (h);
  }
  
  private static void m()
  {
    AppMethodBeat.i(211437);
    if (!e)
    {
      AppMethodBeat.o(211437);
      return;
    }
    String str = null;
    Object localObject2 = a.values().iterator();
    Object localObject1;
    do
    {
      localObject1 = str;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (f)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!((f)localObject1).j()) || (!((f)localObject1).q.i()));
    if (localObject1 == null)
    {
      AppMethodBeat.o(211437);
      return;
    }
    int i1;
    if ((((f)localObject1).i()) && (((f)localObject1).r))
    {
      if (!l()) {
        break label180;
      }
      i1 = 20;
      if (((f)localObject1).p != i1)
      {
        localObject2 = new StringBuilder("switch role to:");
        if (i1 != 20) {
          break label186;
        }
      }
    }
    label180:
    label186:
    for (str = "anchor";; str = "audience")
    {
      TXCLog.i("V2-V2TRTCCloud", str + " when room protocol.");
      ((f)localObject1).p = i1;
      ((f)localObject1).d.switchRole(i1);
      AppMethodBeat.o(211437);
      return;
      i1 = 21;
      break;
    }
  }
  
  private static void n()
  {
    AppMethodBeat.i(211647);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("All room info: [size:").append(a.size()).append("]\n");
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (f)((Map.Entry)localObject).getValue();
      if (localObject != null) {
        localStringBuilder.append("[roomId:").append(str).append(",instance:").append(localObject.hashCode()).append(",isInRoom:").append(((f)localObject).n).append(",isPusher:").append(((f)localObject).j()).append("]\n");
      } else {
        localStringBuilder.append("[roomId:").append(str).append(",instance: null]\n");
      }
    }
    TXCLog.i("V2-V2TRTCCloud", localStringBuilder.toString());
    AppMethodBeat.o(211647);
  }
  
  private static void o()
  {
    AppMethodBeat.i(211682);
    try
    {
      y = TRTCCloudImpl.class.getDeclaredMethod("setLocalSurface", new Class[] { Surface.class });
      z = TRTCCloudImpl.class.getDeclaredMethod("setLocalSurfaceSize", new Class[] { Integer.TYPE, Integer.TYPE });
      A = TRTCCloudImpl.class.getDeclaredMethod("setRemoteSurface", new Class[] { String.class, Integer.TYPE, Surface.class });
      B = TRTCCloudImpl.class.getDeclaredMethod("setRemoteSurfaceSize", new Class[] { String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE });
      TXCLog.i("V2-V2TRTCCloud", "initReflectMethod success.");
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          C = TRTCCloud.class.getDeclaredMethod("setNetEnv", new Class[] { Integer.TYPE });
          AppMethodBeat.o(211682);
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          AppMethodBeat.o(211682);
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        TXCLog.e("V2-V2TRTCCloud", "initReflectMethod init fail.", localNoSuchMethodException1);
      }
    }
  }
  
  public int a(int paramInt)
  {
    AppMethodBeat.i(211924);
    this.d.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(211924);
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211909);
    if (e(paramString))
    {
      h("muteRemoteAudio: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211909);
      return -3;
    }
    f("muteRemoteAudio [userId:" + paramString + "][streamType:" + paramInt + "][isMute:" + paramBoolean + "]");
    f(paramString, paramInt).i = paramBoolean;
    if (paramBoolean) {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    }
    while (e(paramInt))
    {
      this.d.muteRemoteAudio(paramString, paramBoolean);
      AppMethodBeat.o(211909);
      return 0;
      c localc = (c)this.l.get(paramString);
      if ((localc != null) && (localc.e))
      {
        a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
        if (this.o) {
          a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
        }
      }
    }
    AppMethodBeat.o(211909);
    return -4;
  }
  
  public void a(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    AppMethodBeat.i(211812);
    paramV2TXLiveTranscodingConfig = com.tencent.live2.impl.b.a(paramV2TXLiveTranscodingConfig);
    this.d.setMixTranscodingConfig(paramV2TXLiveTranscodingConfig);
    AppMethodBeat.o(211812);
  }
  
  public void a(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    AppMethodBeat.i(211858);
    f("registerPusherObserver observer: ".concat(String.valueOf(paramV2TXLivePusherObserver)));
    this.u = paramV2TXLivePusherObserver;
    AppMethodBeat.o(211858);
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(211880);
    if (e(paramString))
    {
      h("unregisterPlayerObserver: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211880);
      return;
    }
    paramString = (b)d(paramInt).get(paramString);
    if (paramString != null) {
      paramString.f = null;
    }
    AppMethodBeat.o(211880);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211900);
    f("setRemoteSurface [userId:" + paramString + "][streamType:" + paramInt1 + "][width:" + paramInt2 + "][height: " + paramInt3 + "]");
    if (e(paramString))
    {
      h("setPlaySurfaceSize: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211900);
      return;
    }
    b localb = f(paramString, paramInt1);
    localb.d = paramInt2;
    localb.e = paramInt3;
    try
    {
      B.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(211900);
      return;
    }
    catch (Exception paramString)
    {
      TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", paramString);
      AppMethodBeat.o(211900);
    }
  }
  
  public void a(String paramString, int paramInt, Surface paramSurface)
  {
    AppMethodBeat.i(211898);
    StringBuilder localStringBuilder = new StringBuilder("setRemoteSurface [userId:").append(paramString).append("][streamType:").append(paramInt).append("][surface: ");
    if (paramSurface != null) {}
    for (Object localObject = paramSurface.hashCode();; localObject = "null")
    {
      f((String)localObject + "]");
      if (!e(paramString)) {
        break;
      }
      h("setPlaySurface: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211898);
      return;
    }
    localObject = f(paramString, paramInt);
    ((b)localObject).c = paramSurface;
    if (((b)localObject).c != null)
    {
      f("start remote play after set surface.");
      a(paramString, paramInt, null, ((b)localObject).k);
    }
    try
    {
      A.invoke(this.d, new Object[] { paramString, Integer.valueOf(paramInt), paramSurface });
      AppMethodBeat.o(211898);
      return;
    }
    catch (Exception paramString)
    {
      TXCLog.e("V2-V2TRTCCloud", "set play surface size fail.", paramString);
      AppMethodBeat.o(211898);
    }
  }
  
  public void a(String paramString, int paramInt, V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    AppMethodBeat.i(211905);
    if (e(paramString))
    {
      h("set play view fill mode fail. invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211905);
      return;
    }
    b localb = f(paramString, paramInt);
    localb.k.fillMode = com.tencent.live2.impl.b.b(paramV2TXLiveFillMode);
    this.d.setRemoteRenderParams(paramString, paramInt, localb.k);
    AppMethodBeat.o(211905);
  }
  
  public void a(String paramString, int paramInt, V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211906);
    if (e(paramString))
    {
      h("set play view rotation fail. invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211906);
      return;
    }
    b localb = f(paramString, paramInt);
    localb.k.rotation = com.tencent.live2.impl.b.b(paramV2TXLiveRotation);
    this.d.setRemoteRenderParams(paramString, paramInt, localb.k);
    AppMethodBeat.o(211906);
  }
  
  public void a(String paramString, int paramInt, V2TXLivePlayer paramV2TXLivePlayer, V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    AppMethodBeat.i(211877);
    if (e(paramString))
    {
      h("registerPlayerObserver: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211877);
      return;
    }
    paramString = f(paramString, paramInt);
    paramString.g = paramV2TXLivePlayer;
    paramString.f = paramV2TXLivePlayerObserver;
    AppMethodBeat.o(211877);
  }
  
  public void a(String paramString, int paramInt, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211902);
    StringBuilder localStringBuilder = new StringBuilder("setPlayView: [userId:").append(paramString).append("][view:");
    if (paramTXCloudVideoView == null) {}
    for (Object localObject = "null";; localObject = paramTXCloudVideoView.hashCode())
    {
      f((String)localObject + "][streamType:" + paramInt + "]");
      if (!e(paramString)) {
        break;
      }
      h("setPlayView: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211902);
      return;
    }
    localObject = f(paramString, paramInt);
    ((b)localObject).b = paramTXCloudVideoView;
    if (((b)localObject).b != null)
    {
      f("start remote play after set view.");
      a(paramString, paramInt, paramTXCloudVideoView, ((b)localObject).k);
      AppMethodBeat.o(211902);
      return;
    }
    g("waiting for video view for play.");
    AppMethodBeat.o(211902);
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    int i1 = 1;
    AppMethodBeat.i(211885);
    if (e(paramString))
    {
      h("enableCustomRendering: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211885);
      return;
    }
    if (paramBoolean)
    {
      f(paramString, paramInt1).h = true;
      this.d.setRemoteVideoRenderListener(paramString, paramInt2, paramInt3, this);
      AppMethodBeat.o(211885);
      return;
    }
    b localb = (b)d(paramInt1).get(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(211885);
      return;
    }
    localb.h = false;
    if (e(paramInt1))
    {
      localb = (b)this.k.get(paramString);
      if ((localb == null) || (!localb.h)) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          this.d.setRemoteVideoRenderListener(paramString, 0, 0, null);
        }
        AppMethodBeat.o(211885);
        return;
      }
    }
    localb = (b)this.j.get(paramString);
    paramInt1 = i1;
    if (localb != null) {
      if (localb.h) {
        break label210;
      }
    }
    label210:
    for (paramInt1 = i1;; paramInt1 = 0) {
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211851);
    this.d.sendSEIMsg(paramArrayOfByte, 1);
    AppMethodBeat.o(211851);
  }
  
  public boolean a()
  {
    return this.n;
  }
  
  public int b(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211913);
    if (e(paramString))
    {
      h("muteRemoteVideo: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211913);
      return -3;
    }
    f("muteRemoteVideo [userId:" + paramString + "][streamType:" + paramInt + "][isMute:" + paramBoolean + "]");
    f(paramString, paramInt).j = paramBoolean;
    if (paramBoolean) {
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
    }
    label217:
    while (e(paramInt))
    {
      this.d.muteRemoteVideoStream(paramString, paramBoolean);
      AppMethodBeat.o(211913);
      return 0;
      c localc = (c)this.l.get(paramString);
      if (localc != null)
      {
        if (e(paramInt)) {}
        for (boolean bool = localc.d;; bool = localc.g)
        {
          if (!bool) {
            break label217;
          }
          a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
          if (!this.o) {
            break;
          }
          a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
          break;
        }
      }
    }
    AppMethodBeat.o(211913);
    return -4;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    AppMethodBeat.i(211889);
    if (e(paramString))
    {
      AppMethodBeat.o(211889);
      return false;
    }
    if ((b)d(paramInt).get(paramString) != null)
    {
      AppMethodBeat.o(211889);
      return true;
    }
    AppMethodBeat.o(211889);
    return false;
  }
  
  public int c(final String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(211822);
    if (TextUtils.isEmpty(paramString))
    {
      h("start push fail. url is empty.");
      AppMethodBeat.o(211822);
      return -3;
    }
    if (e)
    {
      h("start push fail. already have pusher instance. please check instance map. dumping room map info...");
      n();
      AppMethodBeat.o(211822);
      return -3;
    }
    if (i())
    {
      if ("start push fail. already in room. roomId:" + this.q != null) {}
      for (paramString = this.q.f();; paramString = "null")
      {
        h(paramString);
        AppMethodBeat.o(211822);
        return -3;
      }
    }
    b localb = b.a(paramString);
    if ((localb == null) || (!localb.a()))
    {
      h("start push fail. invalid param. [url:" + paramString + "][param:" + localb + "]");
      AppMethodBeat.o(211822);
      return -2;
    }
    f("start push success. push param: ".concat(String.valueOf(localb)));
    this.q = localb;
    this.m = this.q.j();
    e = true;
    this.n = true;
    this.l.clear();
    this.d.setDefaultStreamRecvMode(this.q.k(), this.q.l());
    boolean bool1;
    label378:
    int i1;
    if (this.q.b())
    {
      paramString = new TRTCCloudDef.TRTCVideoEncParam();
      paramString.videoResolution = 100;
      paramString.videoFps = 15;
      paramString.videoBitrate = 100;
      paramString.videoResolutionMode = 1;
      b.enableEncSmallVideoStream(true, paramString);
      b.callExperimentalAPI(String.format("{\"api\":\"enableBlackStream\", \"params\": {\"enable\":%b}}", new Object[] { Boolean.valueOf(this.q.c()) }));
      paramString = this.q.m();
      if (!this.q.i()) {
        break label518;
      }
      bool1 = bool2;
      if (this.q.e() != 1)
      {
        if (this.q.e() != 3) {
          break label498;
        }
        bool1 = bool2;
      }
      this.r = bool1;
      if (!this.r) {
        break label509;
      }
      if (!l()) {
        break label503;
      }
      i1 = 20;
      label399:
      paramString.role = i1;
    }
    for (;;)
    {
      b(this.q.d());
      a(paramString, this.q.e(), 0);
      this.d.muteLocalVideo(this.w);
      this.d.muteLocalAudio(this.v);
      n();
      paramString = this.u;
      if (paramString != null) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211484);
            paramString.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting, "connecting to the server.", new Bundle());
            AppMethodBeat.o(211484);
          }
        });
      }
      AppMethodBeat.o(211822);
      return 0;
      b.enableEncSmallVideoStream(false, null);
      break;
      label498:
      bool1 = false;
      break label378;
      label503:
      i1 = 21;
      break label399;
      label509:
      paramString.role = 20;
      continue;
      label518:
      if (this.q.h())
      {
        paramString.role = 20;
        c(20);
      }
    }
  }
  
  public int c(final String paramString, int paramInt)
  {
    AppMethodBeat.i(211896);
    f("stopPlay [userId: " + paramString + "][type:" + paramInt + "]");
    this.d.stopRemoteView(paramString, paramInt);
    if (this.m == a.d.b)
    {
      this.n = false;
      this.m = null;
      this.p = 21;
      this.d.exitRoom();
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      this.l.clear();
      this.j.clear();
      this.k.clear();
      paramString = this.t;
      if (paramString != null) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211447);
            paramString.a("27eb683b73944771ce62fbddab2849a4");
            AppMethodBeat.o(211447);
          }
        });
      }
    }
    for (;;)
    {
      AppMethodBeat.o(211896);
      return 0;
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      a(paramString, paramInt, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
      d(paramInt).remove(paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(211839);
    this.v = paramBoolean;
    this.d.muteLocalAudio(paramBoolean);
    AppMethodBeat.o(211839);
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(211892);
    f("startPlay url: ".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(211892);
      return -3;
    }
    paramString = a.b(paramString);
    b localb = f(paramString.b(), paramString.c());
    if (paramString.g() >= 0) {
      b(paramString.g());
    }
    int i1;
    if (paramString.i())
    {
      if (this.n)
      {
        h("start play fail. already in room.");
        AppMethodBeat.o(211892);
        return -3;
      }
      TRTCCloudDef.TRTCParams localTRTCParams = paramString.k();
      if (e)
      {
        i1 = 20;
        localTRTCParams.role = i1;
        this.n = true;
        a(localTRTCParams, paramString.f(), paramString.c());
      }
    }
    for (;;)
    {
      f("startPlay param:".concat(String.valueOf(paramString)));
      this.m = paramString.d();
      localb.a = paramString;
      AppMethodBeat.o(211892);
      return 0;
      i1 = 21;
      break;
      if (!paramString.j()) {
        break label256;
      }
      if (!this.n)
      {
        h("start play fail. no in room. you should enter room by using V2TXLivePusher.");
        AppMethodBeat.o(211892);
        return -3;
      }
      if (localb.b != null)
      {
        f("start remote play.");
        a(paramString.b(), paramString.c(), localb.b, localb.k);
      }
      else
      {
        g("waiting for view to start remote play.");
      }
    }
    label256:
    h("start play fail.invalid protocol. param:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(211892);
    return -2;
  }
  
  public void d(String paramString, int paramInt)
  {
    AppMethodBeat.i(211914);
    this.d.setRemoteAudioVolume(paramString, paramInt);
    AppMethodBeat.o(211914);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(211845);
    this.w = paramBoolean;
    this.d.muteLocalVideo(paramBoolean);
    AppMethodBeat.o(211845);
  }
  
  public void e(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(211921);
    if (paramString == null)
    {
      b.snapshotVideo(paramString, paramInt, new TRTCCloudListener.TRTCSnapshotListener()
      {
        public void onSnapshotComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(211389);
          V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
          if (localV2TXLivePusherObserver != null) {
            localV2TXLivePusherObserver.onSnapshotComplete(paramAnonymousBitmap);
          }
          AppMethodBeat.o(211389);
        }
      });
      AppMethodBeat.o(211921);
      return;
    }
    if (e(paramString))
    {
      h("snapshot: invalid user id:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(211921);
      return;
    }
    this.d.snapshotVideo(paramString, paramInt, new TRTCCloudListener.TRTCSnapshotListener()
    {
      public void onSnapshotComplete(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(211390);
        f.b localb = (f.b)f.a(f.this, paramInt).get(paramString);
        if ((localb != null) && (localb.f != null) && (localb.g != null)) {
          localb.f.onSnapshotComplete(localb.g, paramAnonymousBitmap);
        }
        AppMethodBeat.o(211390);
      }
    });
    AppMethodBeat.o(211921);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(211917);
    TRTCCloud localTRTCCloud = b;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      localTRTCCloud.showDebugView(i1);
      AppMethodBeat.o(211917);
      return;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    AppMethodBeat.i(211919);
    TRTCCloud localTRTCCloud = this.d;
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      localTRTCCloud.showDebugView(i1);
      AppMethodBeat.o(211919);
      return;
    }
  }
  
  public int h()
  {
    AppMethodBeat.i(211832);
    f("stop push.");
    if (!i())
    {
      g("stop push fail. no in room or no push instance.");
      AppMethodBeat.o(211832);
      return -3;
    }
    this.n = false;
    e = false;
    this.p = 21;
    if (this.q.b()) {
      b.enableEncSmallVideoStream(false, null);
    }
    if (this.q.c()) {
      b.callExperimentalAPI(String.format("{\"api\":\"enableBlackStream\", \"params\": {\"enable\":%b}}", new Object[] { Boolean.FALSE }));
    }
    this.q = null;
    b();
    c();
    d();
    b(false);
    a(null, 0, 0);
    if ((this.d instanceof TRTCSubCloud))
    {
      this.d.muteLocalVideo(true);
      this.d.muteLocalAudio(true);
    }
    this.d.exitRoom();
    if ((this.d instanceof TRTCSubCloud))
    {
      b.muteLocalVideo(false);
      b.muteLocalAudio(false);
    }
    Object localObject = this.m;
    this.m = null;
    switch (30.b[localObject.ordinal()])
    {
    default: 
      localObject = this.u;
      if (localObject != null) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211487);
            this.a.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, "disconnect server", new Bundle());
            AppMethodBeat.o(211487);
          }
        });
      }
      this.r = false;
      f("stop push success.");
      AppMethodBeat.o(211832);
      return 0;
    case 1: 
      c(21);
    }
    for (;;)
    {
      this.l.clear();
      this.j.clear();
      this.k.clear();
      break;
      localObject = new ArrayList();
      ((List)localObject).addAll(this.j.values());
      ((List)localObject).addAll(this.k.values());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if ((localb != null) && (localb.a != null))
        {
          String str = localb.a.b();
          int i1 = localb.a.c();
          a(str, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
          a(str, i1, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStopped);
        }
      }
    }
  }
  
  public boolean i()
  {
    AppMethodBeat.i(211864);
    if ((j()) && (a()))
    {
      AppMethodBeat.o(211864);
      return true;
    }
    AppMethodBeat.o(211864);
    return false;
  }
  
  public boolean j()
  {
    AppMethodBeat.i(211871);
    if ((this.q != null) && (this.q.a()))
    {
      AppMethodBeat.o(211871);
      return true;
    }
    AppMethodBeat.o(211871);
    return false;
  }
  
  public void onCameraDidReady()
  {
    AppMethodBeat.i(212000);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211461);
        f.a(f.this, "onCameraDidReady");
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if (localV2TXLivePusherObserver != null) {
          localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
        }
        AppMethodBeat.o(211461);
      }
    });
    AppMethodBeat.o(212000);
  }
  
  public void onCapturedRawAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onConnectionLost()
  {
    AppMethodBeat.i(211996);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211498);
        f.a(f.this, true);
        Object localObject = f.b(f.this);
        if (localObject != null) {
          ((V2TXLivePusherObserver)localObject).onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting, "reconnecting to the server.", new Bundle());
        }
        f.a(f.this, "onConnectionLost");
        localObject = new ArrayList();
        ((List)localObject).addAll(f.c(f.this).values());
        ((List)localObject).addAll(f.d(f.this).values());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f.b localb = (f.b)((Iterator)localObject).next();
          if ((localb != null) && (localb.a != null))
          {
            f.a(f.this, localb.a.b(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
            f.a(f.this, localb.a.b(), localb.a.c(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusLoading, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingBegin);
          }
        }
        AppMethodBeat.o(211498);
      }
    });
    AppMethodBeat.o(211996);
  }
  
  public void onConnectionRecovery()
  {
    AppMethodBeat.i(211999);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211462);
        f.a(f.this, false);
        f.a(f.this, "onConnectionRecovery");
        Object localObject = f.b(f.this);
        if (localObject != null) {
          ((V2TXLivePusherObserver)localObject).onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess, "connect server success.", new Bundle());
        }
        localObject = new ArrayList();
        ((List)localObject).addAll(f.c(f.this).values());
        ((List)localObject).addAll(f.d(f.this).values());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          f.b localb = (f.b)((Iterator)localObject).next();
          if ((localb != null) && (localb.a != null))
          {
            f.a(f.this, localb.a.b(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
            f.a(f.this, localb.a.b(), localb.a.c(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
          }
        }
        AppMethodBeat.o(211462);
      }
    });
    AppMethodBeat.o(211999);
  }
  
  public void onEnterRoom(final long paramLong)
  {
    AppMethodBeat.i(211969);
    f("onEnterRoom result: ".concat(String.valueOf(paramLong)));
    this.l.clear();
    this.o = false;
    final V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (paramLong > 0L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", (int)paramLong);
      if (localV2TXLivePusherObserver != null) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211419);
            localV2TXLivePusherObserver.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess, "connected to the server successfully.", this.b);
            if ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b)) {
              ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onEnterRoom(paramLong);
            }
            AppMethodBeat.o(211419);
          }
        });
      }
      AppMethodBeat.o(211969);
      return;
    }
    final int i1;
    if (j())
    {
      if (this.m == a.d.b) {
        c(21);
      }
      if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211409);
            ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onEnterRoom(paramLong);
            AppMethodBeat.o(211409);
          }
        });
      }
      this.m = null;
      e = false;
      this.q = null;
      this.n = false;
      this.p = 21;
      if (paramLong != -3308L) {
        break label242;
      }
      i1 = -6;
    }
    for (Object localObject = "enter room fail.request is timeout.";; localObject = "enter room fail.request is refused by server. [errorCode:" + paramLong + "]")
    {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211424);
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("code", (int)paramLong);
          if (this.b != null) {
            this.b.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, i1, (Bundle)localObject1);
          }
          Object localObject2 = new ArrayList();
          ((List)localObject2).addAll(f.c(f.this).values());
          ((List)localObject2).addAll(f.d(f.this).values());
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            f.b localb = (f.b)((Iterator)localObject2).next();
            if ((localb != null) && (localb.g != null) && (localb.f != null)) {
              localb.f.onError(localb.g, this.d, i1, (Bundle)localObject1);
            }
          }
          localObject1 = f.e(f.this);
          if (localObject1 != null) {
            ((f.a)localObject1).a(paramLong);
          }
          AppMethodBeat.o(211424);
        }
      });
      AppMethodBeat.o(211969);
      return;
      this.m = null;
      this.n = false;
      this.p = 21;
      break;
      label242:
      i1 = -7;
    }
  }
  
  public void onError(final int paramInt, final String paramString, final Bundle paramBundle)
  {
    int i1 = -1301;
    AppMethodBeat.i(211975);
    f("onError code: " + paramInt + " msg: " + paramString + " info: " + paramBundle);
    final V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(211975);
      return;
    case -1316: 
    case -1314: 
    case -1301: 
      h("onPushEvent: camera start error.");
      paramString = "";
      switch (paramInt)
      {
      default: 
        paramInt = i1;
      }
      for (;;)
      {
        b();
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211468);
            V2TXLivePusherObserver localV2TXLivePusherObserver;
            int i;
            String str;
            if (localV2TXLivePusherObserver != null)
            {
              localV2TXLivePusherObserver = localV2TXLivePusherObserver;
              i = paramInt;
              str = paramString;
              if (paramBundle != null) {
                break label57;
              }
            }
            label57:
            for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
            {
              localV2TXLivePusherObserver.onWarning(i, str, localBundle);
              AppMethodBeat.o(211468);
              return;
            }
          }
        });
        AppMethodBeat.o(211975);
        return;
        paramString = "start camera failed.";
        paramInt = i1;
        continue;
        paramInt = -1314;
        paramString = "camera not authorized.";
        continue;
        paramInt = -1316;
        paramString = "camera is occupied.";
      }
    case -1319: 
    case -1317: 
    case -1302: 
      h("opPushEvent: microphone start error.");
      paramString = "";
      switch (paramInt)
      {
      default: 
        paramInt = -1302;
      }
      for (;;)
      {
        c();
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211466);
            V2TXLivePusherObserver localV2TXLivePusherObserver;
            int i;
            String str;
            if (localV2TXLivePusherObserver != null)
            {
              localV2TXLivePusherObserver = localV2TXLivePusherObserver;
              i = paramInt;
              str = paramString;
              if (paramBundle != null) {
                break label57;
              }
            }
            label57:
            for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
            {
              localV2TXLivePusherObserver.onWarning(i, str, localBundle);
              AppMethodBeat.o(211466);
              return;
            }
          }
        });
        AppMethodBeat.o(211975);
        return;
        paramString = "start microphone failed.";
        paramInt = -1302;
        continue;
        paramInt = -1317;
        paramString = "microphone not authorized.";
        continue;
        paramInt = -1319;
        paramString = "microphone is occupied.";
      }
    }
    paramString = "";
    switch (paramInt)
    {
    default: 
      paramInt = -1308;
    }
    for (;;)
    {
      d();
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211459);
          V2TXLivePusherObserver localV2TXLivePusherObserver;
          int i;
          String str;
          if (localV2TXLivePusherObserver != null)
          {
            localV2TXLivePusherObserver = localV2TXLivePusherObserver;
            i = paramInt;
            str = paramString;
            if (paramBundle != null) {
              break label57;
            }
          }
          label57:
          for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
          {
            localV2TXLivePusherObserver.onWarning(i, str, localBundle);
            AppMethodBeat.o(211459);
            return;
          }
        }
      });
      break;
      paramString = "screen capture start failed.";
      paramInt = -1308;
      continue;
      paramInt = -1309;
      paramString = "screen capture isn't supported by system.";
      continue;
      paramInt = -7001;
      paramString = "screen capture is interrupted by system.";
    }
  }
  
  public void onExitRoom(final int paramInt)
  {
    AppMethodBeat.i(211972);
    f("onExitRoom reason: ".concat(String.valueOf(paramInt)));
    this.o = false;
    Object localObject1 = this.u;
    if ((localObject1 != null) && ((localObject1 instanceof com.tencent.live2.impl.a.b))) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211407);
          ((com.tencent.live2.impl.a.b)this.a).onExitRoom(paramInt);
          AppMethodBeat.o(211407);
        }
      });
    }
    if (paramInt == 0)
    {
      f("exit room success. do nothing.");
      AppMethodBeat.o(211972);
      return;
    }
    if (!this.n)
    {
      h("recv exit room callback, but not in room. maybe something error. dump debug info...");
      n();
      AppMethodBeat.o(211972);
      return;
    }
    if (j())
    {
      b();
      c();
      d();
      if (this.m == a.d.b) {
        c(21);
      }
      this.m = null;
      e = false;
      this.q = null;
      this.n = false;
      this.p = 21;
      switch (paramInt)
      {
      default: 
        localObject1 = "";
      }
    }
    for (;;)
    {
      final Bundle localBundle = new Bundle();
      localBundle.putInt("code", paramInt);
      Object localObject2 = this.u;
      if (localObject2 != null) {
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211480);
            this.a.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, "disconnect server reason:" + this.b, localBundle);
            AppMethodBeat.o(211480);
          }
        });
      }
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.j.values());
      ((List)localObject2).addAll(this.k.values());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        final b localb = (b)((Iterator)localObject2).next();
        if ((localb != null) && (localb.a != null))
        {
          a(localb.a.b(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
          a(localb.a.b(), localb.a.c(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
        }
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211474);
            if ((localb != null) && (localb.g != null) && (localb.f != null)) {
              localb.f.onError(localb.g, -1, this.b, localBundle);
            }
            AppMethodBeat.o(211474);
          }
        });
      }
      this.m = null;
      this.n = false;
      this.p = 21;
      localObject1 = this.t;
      if (localObject1 == null) {
        break;
      }
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211475);
          this.a.a("27eb683b73944771ce62fbddab2849a4");
          AppMethodBeat.o(211475);
        }
      });
      break;
      localObject1 = "kicked out by server.";
      continue;
      localObject1 = "room dismissed by server.";
    }
    this.j.clear();
    this.k.clear();
    this.l.clear();
    localObject1 = this.t;
    if (localObject1 != null) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211478);
          this.a.a(paramInt);
          AppMethodBeat.o(211478);
        }
      });
    }
    AppMethodBeat.o(211972);
  }
  
  public void onFirstAudioFrame(String paramString)
  {
    AppMethodBeat.i(212005);
    f("onFirstAudioFrame userId:".concat(String.valueOf(paramString)));
    c localc = (c)this.l.get(paramString);
    if (localc != null) {
      localc.e = true;
    }
    for (;;)
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      AppMethodBeat.o(212005);
      return;
      h("onFirstAudioFrame: can't find [userId:" + paramString + "]user info.");
    }
  }
  
  public void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212008);
    f("onFirstVideoFrame [userId:" + paramString + "][streamType:" + paramInt1 + "][width:" + paramInt2 + "][height:" + paramInt3 + "]");
    c localc;
    if (!TextUtils.isEmpty(paramString))
    {
      localc = (c)this.l.get(paramString);
      if (localc == null) {
        break label133;
      }
      if (!e(paramInt1)) {
        break label124;
      }
      localc.d = true;
    }
    for (;;)
    {
      a(paramString, paramInt1, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonLocalStarted);
      AppMethodBeat.o(212008);
      return;
      label124:
      localc.g = true;
      continue;
      label133:
      h("onFirstVideoFrame: can't find [userId:" + paramString + "]user info.");
    }
  }
  
  public void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onMicDidReady()
  {
    AppMethodBeat.i(212002);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211430);
        f.a(f.this, "onMicDidReady");
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if (localV2TXLivePusherObserver != null) {
          localV2TXLivePusherObserver.onCaptureFirstAudioFrame();
        }
        AppMethodBeat.o(211430);
      }
    });
    AppMethodBeat.o(212002);
  }
  
  public void onMixedAllAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame) {}
  
  public void onNetworkQuality(final TRTCCloudDef.TRTCQuality paramTRTCQuality, final ArrayList<TRTCCloudDef.TRTCQuality> paramArrayList)
  {
    AppMethodBeat.i(211993);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211513);
        Object localObject1 = f.b(f.this);
        if ((paramTRTCQuality != null) && (localObject1 != null) && ((localObject1 instanceof com.tencent.live2.impl.a.b))) {
          ((com.tencent.live2.impl.a.b)localObject1).onNetworkQuality(paramTRTCQuality.quality);
        }
        localObject1 = paramArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((TRTCCloudDef.TRTCQuality)((Iterator)localObject1).next()).userId;
          int i = paramTRTCQuality.quality;
          localObject2 = (f.b)f.a(f.this, 0).get(localObject2);
          if ((localObject2 != null) && (((f.b)localObject2).f != null) && ((((f.b)localObject2).f instanceof com.tencent.live2.impl.a.a))) {
            ((com.tencent.live2.impl.a.a)((f.b)localObject2).f).onNetworkQuality(i);
          }
        }
        AppMethodBeat.o(211513);
      }
    });
    AppMethodBeat.o(211993);
  }
  
  public void onRecvSEIMsg(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212003);
    paramString = (b)this.j.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(212003);
      return;
    }
    paramString = paramString.f;
    if ((paramString != null) && ((paramString instanceof com.tencent.live2.impl.a.a))) {
      ((com.tencent.live2.impl.a.a)paramString).onRecvSEIMessage(new String(paramArrayOfByte));
    }
    AppMethodBeat.o(212003);
  }
  
  public void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame paramTRTCAudioFrame, String paramString) {}
  
  public void onRemoteUserEnterRoom(final String paramString)
  {
    AppMethodBeat.i(211980);
    f("onRemoteUserEnterRoom: [userId:" + paramString + "]");
    c localc = new c(null);
    localc.a = paramString;
    this.l.put(paramString, localc);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211519);
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
          ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onRemoteUserEnter(paramString);
        }
        AppMethodBeat.o(211519);
      }
    });
    AppMethodBeat.o(211980);
  }
  
  public void onRemoteUserLeaveRoom(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(211983);
    f("onRemoteUserLeaveRoom: [userId:" + paramString + "][reason:" + paramInt + "]");
    final c localc = (c)this.l.get(paramString);
    if (localc == null)
    {
      h("onRemoteUserLeaveRoom error: can't find [userId:" + paramString + "] user info.");
      AppMethodBeat.o(211983);
      return;
    }
    b localb1 = (b)this.j.get(paramString);
    b localb2 = (b)this.k.get(paramString);
    if (localb1 != null)
    {
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      a(paramString, 0, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
    }
    if (localb2 != null) {
      a(paramString, 2, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
    }
    if ((localc.c) || (localc.b)) {
      a(paramString, "27eb683b73944771ce62fbddab2849a4", 0);
    }
    if (localc.f) {
      a(paramString, "27eb683b73944771ce62fbddab2849a4", 2);
    }
    this.l.remove(paramString);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211488);
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b)))
        {
          if (localc.c) {
            ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onUserVideoAvailable(paramString, 0, false);
          }
          if (localc.b) {
            ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onUserAudioAvailable(paramString, false);
          }
          if (localc.f) {
            ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onUserVideoAvailable(paramString, 2, false);
          }
          ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onRemoteUserExit(paramString, paramInt);
        }
        AppMethodBeat.o(211488);
      }
    });
    AppMethodBeat.o(211983);
  }
  
  public void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(211967);
    paramString = (b)d(paramInt).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(211967);
      return;
    }
    if ((paramString.f != null) && (paramString.g != null)) {
      paramString.f.onRenderVideoFrame(paramString.g, com.tencent.live2.impl.b.a(paramTRTCVideoFrame));
    }
    AppMethodBeat.o(211967);
  }
  
  public void onScreenCaptureStarted()
  {
    AppMethodBeat.i(212001);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211463);
        f.a(f.this, "onScreenCaptureStarted");
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if (localV2TXLivePusherObserver != null) {
          localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
        }
        AppMethodBeat.o(211463);
      }
    });
    AppMethodBeat.o(212001);
  }
  
  public void onSendFirstLocalAudioFrame()
  {
    AppMethodBeat.i(212012);
    f("onSendFirstLocalAudioFrame");
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211434);
        V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
        if (localV2TXLivePusherObserver != null) {
          localV2TXLivePusherObserver.onCaptureFirstAudioFrame();
        }
        AppMethodBeat.o(211434);
      }
    });
    AppMethodBeat.o(212012);
  }
  
  public void onSendFirstLocalVideoFrame(int paramInt)
  {
    AppMethodBeat.i(212010);
    f("onSendFirstLocalVideoFrame type: ".concat(String.valueOf(paramInt)));
    if (paramInt == 0) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211435);
          V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
          if (localV2TXLivePusherObserver != null) {
            localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
          }
          AppMethodBeat.o(211435);
        }
      });
    }
    AppMethodBeat.o(212010);
  }
  
  public void onSetMixTranscodingConfig(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(212004);
    f("onSetMixTranscodingConfig err: " + paramInt + " errMsg: " + paramString);
    final V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211427);
          int i = 0;
          switch (paramInt)
          {
          default: 
            i = -1;
          }
          for (;;)
          {
            localV2TXLivePusherObserver.onSetMixTranscodingConfig(i, paramString);
            AppMethodBeat.o(211427);
            return;
            i = -6;
            continue;
            i = -7;
          }
        }
      });
    }
    AppMethodBeat.o(212004);
  }
  
  public void onStatistics(final TRTCStatistics paramTRTCStatistics)
  {
    AppMethodBeat.i(211995);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211502);
        Object localObject1 = f.b(f.this);
        Object localObject3;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject3 = paramTRTCStatistics.localArray.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (TRTCStatistics.TRTCLocalStatistics)((Iterator)localObject3).next();
            if (((TRTCStatistics.TRTCLocalStatistics)localObject2).streamType == 0)
            {
              localObject3 = new V2TXLiveDef.V2TXLivePusherStatistics();
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).appCpu = paramTRTCStatistics.appCpu;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).systemCpu = paramTRTCStatistics.systemCpu;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).audioBitrate = ((TRTCStatistics.TRTCLocalStatistics)localObject2).audioBitrate;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).videoBitrate = ((TRTCStatistics.TRTCLocalStatistics)localObject2).videoBitrate;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).width = ((TRTCStatistics.TRTCLocalStatistics)localObject2).width;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).height = ((TRTCStatistics.TRTCLocalStatistics)localObject2).height;
              ((V2TXLiveDef.V2TXLivePusherStatistics)localObject3).fps = ((TRTCStatistics.TRTCLocalStatistics)localObject2).frameRate;
              ((V2TXLivePusherObserver)localObject1).onStatisticsUpdate((V2TXLiveDef.V2TXLivePusherStatistics)localObject3);
            }
          }
        }
        localObject1 = paramTRTCStatistics.remoteArray.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (TRTCStatistics.TRTCRemoteStatistics)((Iterator)localObject1).next();
          localObject3 = (f.b)f.a(f.this, ((TRTCStatistics.TRTCRemoteStatistics)localObject2).streamType).get(((TRTCStatistics.TRTCRemoteStatistics)localObject2).userId);
          if ((localObject3 != null) && (((f.b)localObject3).g != null) && (((f.b)localObject3).f != null))
          {
            V2TXLiveDef.V2TXLivePlayerStatistics localV2TXLivePlayerStatistics = new V2TXLiveDef.V2TXLivePlayerStatistics();
            localV2TXLivePlayerStatistics.appCpu = paramTRTCStatistics.appCpu;
            localV2TXLivePlayerStatistics.systemCpu = paramTRTCStatistics.systemCpu;
            localV2TXLivePlayerStatistics.audioBitrate = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).audioBitrate;
            localV2TXLivePlayerStatistics.videoBitrate = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).videoBitrate;
            localV2TXLivePlayerStatistics.width = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).width;
            localV2TXLivePlayerStatistics.height = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).height;
            localV2TXLivePlayerStatistics.fps = ((TRTCStatistics.TRTCRemoteStatistics)localObject2).frameRate;
            ((f.b)localObject3).f.onStatisticsUpdate(((f.b)localObject3).g, localV2TXLivePlayerStatistics);
          }
        }
        AppMethodBeat.o(211502);
      }
    });
    AppMethodBeat.o(211995);
  }
  
  public void onTryToReconnect()
  {
    AppMethodBeat.i(211998);
    f("onTryToReconnect");
    AppMethodBeat.o(211998);
  }
  
  public void onUserAudioAvailable(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(211985);
    f("onUserAudioAvailable [protocol:" + this.m + "][userId: " + paramString + "][available: " + paramBoolean + "]");
    c localc = (c)this.l.get(paramString);
    if (localc == null)
    {
      h("onUserAudioAvailable error: can't find [userId:" + paramString + "] user info.");
      AppMethodBeat.o(211985);
      return;
    }
    localc.b = paramBoolean;
    if (paramBoolean)
    {
      if ((this.m == a.d.b) && (!localc.c)) {
        a("27eb683b73944771ce62fbddab2849a4", paramString, 0);
      }
      if (localc.e) {
        a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStarted);
      }
    }
    for (;;)
    {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211489);
          V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(f.this);
          if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
            ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onUserAudioAvailable(paramString, paramBoolean);
          }
          AppMethodBeat.o(211489);
        }
      });
      AppMethodBeat.o(211985);
      return;
      a(paramString, V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonRemoteStopped);
      if ((this.m == a.d.b) && (!localc.c)) {
        a(paramString, "27eb683b73944771ce62fbddab2849a4", 0);
      }
    }
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211988);
    f("onUserSubStreamAvailable [protocol:" + this.m + "][userId: " + paramString + "][available: " + paramBoolean + "]");
    a(paramString, paramBoolean, 2);
    AppMethodBeat.o(211988);
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(211987);
    f("onUserVideoAvailable [protocol:" + this.m + "][userId: " + paramString + "][available: " + paramBoolean + "]");
    a(paramString, paramBoolean, 0);
    AppMethodBeat.o(211987);
  }
  
  public void onUserVoiceVolume(final ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(211991);
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(211530);
        if (f.f(f.this) == null) {
          f.a(f.this, new HashMap());
        }
        Object localObject2 = new ArrayList();
        Object localObject1;
        if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
          localObject1 = f.f(f.this).keySet().iterator();
        }
        Object localObject3;
        Object localObject4;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          localObject4 = new TRTCCloudDef.TRTCVolumeInfo();
          ((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId = ((String)localObject3);
          ((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume = 0;
          ((ArrayList)localObject2).add(localObject4);
          continue;
          localObject1 = new HashMap();
          if (f.g(f.this) == a.d.a)
          {
            localObject3 = paramArrayList;
            Collections.sort((List)localObject3, new Comparator()
            {
              public int a(TRTCCloudDef.TRTCVolumeInfo paramAnonymous2TRTCVolumeInfo1, TRTCCloudDef.TRTCVolumeInfo paramAnonymous2TRTCVolumeInfo2)
              {
                return paramAnonymous2TRTCVolumeInfo2.volume - paramAnonymous2TRTCVolumeInfo1.volume;
              }
            });
            localObject3 = ((ArrayList)localObject3).iterator();
            int j;
            for (int i = 0; ((Iterator)localObject3).hasNext(); i = j)
            {
              localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
              if (i >= 10) {
                break;
              }
              j = i;
              if (((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume > 10)
              {
                j = i + 1;
                ((Map)localObject1).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
                ((ArrayList)localObject2).add(localObject4);
              }
            }
          }
          ((ArrayList)localObject2).addAll(paramArrayList);
          localObject3 = paramArrayList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject3).next();
            ((Map)localObject1).put(((TRTCCloudDef.TRTCVolumeInfo)localObject4).userId, Integer.valueOf(((TRTCCloudDef.TRTCVolumeInfo)localObject4).volume));
          }
          localObject3 = f.f(f.this).keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if (!((Map)localObject1).containsKey(localObject4))
            {
              TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
              localTRTCVolumeInfo.userId = ((String)localObject4);
              localTRTCVolumeInfo.volume = 0;
              ((ArrayList)localObject2).add(localTRTCVolumeInfo);
            }
          }
          f.f(f.this).clear();
          f.f(f.this).putAll((Map)localObject1);
        }
        if (f.h(f.this) != null)
        {
          localObject1 = f.h(f.this).g();
          localObject2 = ((ArrayList)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label592;
          }
          localObject3 = (TRTCCloudDef.TRTCVolumeInfo)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(((TRTCCloudDef.TRTCVolumeInfo)localObject3).userId)))
          {
            localObject4 = f.b(f.this);
            if (localObject4 == null) {
              continue;
            }
            ((V2TXLivePusherObserver)localObject4).onMicrophoneVolumeUpdate(((TRTCCloudDef.TRTCVolumeInfo)localObject3).volume);
            continue;
            localObject1 = null;
            break;
          }
          localObject4 = (f.b)f.c(f.this).get(((TRTCCloudDef.TRTCVolumeInfo)localObject3).userId);
          if ((localObject4 != null) && (((f.b)localObject4).g != null) && (((f.b)localObject4).f != null)) {
            ((f.b)localObject4).f.onPlayoutVolumeUpdate(((f.b)localObject4).g, ((TRTCCloudDef.TRTCVolumeInfo)localObject3).volume);
          }
        }
        label592:
        AppMethodBeat.o(211530);
      }
    });
    AppMethodBeat.o(211991);
  }
  
  public void onWarning(int paramInt, final String paramString, final Bundle paramBundle)
  {
    AppMethodBeat.i(211978);
    f("onWarning code: " + paramString + " msg: " + paramString + " info: " + paramBundle);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(211978);
      return;
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211464);
          Object localObject = new ArrayList();
          ((List)localObject).addAll(f.c(f.this).values());
          ((List)localObject).addAll(f.d(f.this).values());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            f.b localb = (f.b)((Iterator)localObject).next();
            if ((localb != null) && (localb.g != null) && (localb.f != null)) {
              localb.f.onWarning(localb.g, 2105, paramString, paramBundle);
            }
          }
          AppMethodBeat.o(211464);
        }
      });
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(long paramLong);
    
    public abstract void a(String paramString);
  }
  
  static class b
  {
    public a a;
    public TXCloudVideoView b;
    public Surface c;
    public int d;
    public int e;
    public V2TXLivePlayerObserver f;
    public V2TXLivePlayer g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final TRTCCloudDef.TRTCRenderParams k;
    private V2TXLiveDef.V2TXLivePlayStatus l;
    private V2TXLiveDef.V2TXLivePlayStatus m;
    
    public b()
    {
      AppMethodBeat.i(211374);
      this.l = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
      this.m = V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusStopped;
      this.k = new TRTCCloudDef.TRTCRenderParams();
      this.k.rotation = 0;
      this.k.fillMode = 0;
      AppMethodBeat.o(211374);
    }
    
    public String toString()
    {
      AppMethodBeat.i(211404);
      String str = "[urlParam:" + this.a + "][isAudioMuted:" + this.i + "][isVideoMuted:" + this.j + "][audioPlayStatus:" + this.l + "][videoPlayStatus:" + this.m + "]";
      AppMethodBeat.o(211404);
      return str;
    }
  }
  
  static class c
  {
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    
    public String toString()
    {
      AppMethodBeat.i(211394);
      String str = "[userId:" + this.a + "][videoAvailable:" + this.c + "][isAudioAvailable:" + this.b + "][isAuxVideoAvailable:" + this.f + "]";
      AppMethodBeat.o(211394);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.f
 * JD-Core Version:    0.7.0.1
 */