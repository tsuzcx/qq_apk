package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.f.a;
import com.tencent.liteav.renderer.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class TRTCRoomInfo
{
  public static final int NETWORK_STATUS_OFFLINE = 1;
  public static final int NETWORK_STATUS_ONLINE = 3;
  public static final int NETWORK_STATUS_RECONNECTING = 2;
  public static final int STATE_AUDIO = 8;
  public static final int STATE_BIG_VIDEO = 1;
  public static final int STATE_MUTE_AUDIO = 64;
  public static final int STATE_MUTE_MAIN_VIDEO = 16;
  public static final int STATE_MUTE_SUB_VIDEO = 32;
  public static final int STATE_SMALL_VIDEO = 2;
  public static final int STATE_SUB_VIDEO = 4;
  private static final String TOKEN = "TRTC.0x0.Token";
  private static final String TRTC_INFO = "TRTC.Info";
  public f.a bigEncSize;
  public TRTCCloud.TRTCViewMargin debugMargin;
  public JSONArray decProperties;
  public boolean enableCustomPreprocessor;
  public boolean enableRestartDecoder;
  public long enterTime;
  private int exitRoomCode;
  private boolean hasExitedRoom;
  public int localBufferType;
  public TRTCCloudListener.TRTCVideoRenderListener localListener;
  public int localPixelFormat;
  public int localRenderRotation;
  public TXCloudVideoView localView;
  private boolean micHasStartd;
  public boolean muteLocalAudio;
  public boolean muteLocalVideo;
  public boolean muteRemoteAudio;
  public boolean muteRemoteVideo;
  public int networkStatus;
  public String privateMapKey;
  private HashMap<Long, Integer> recvFirstIFrameCntList;
  public long roomId;
  public int sdkAppId;
  public f.a smallEncSize;
  public String strRoomId;
  public String tinyId;
  public byte[] token;
  public String userId;
  private HashMap<String, UserInfo> userList;
  public String userSig;
  
  public TRTCRoomInfo()
  {
    AppMethodBeat.i(15731);
    this.token = null;
    this.networkStatus = 1;
    this.debugMargin = new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F);
    this.enableCustomPreprocessor = false;
    this.localView = null;
    this.userList = new HashMap();
    this.recvFirstIFrameCntList = new HashMap();
    this.muteLocalVideo = false;
    this.muteRemoteVideo = false;
    this.muteLocalAudio = false;
    this.muteRemoteAudio = false;
    this.localRenderRotation = 0;
    this.micHasStartd = false;
    this.hasExitedRoom = false;
    this.exitRoomCode = 0;
    this.decProperties = null;
    this.enableRestartDecoder = false;
    this.bigEncSize = new f.a();
    this.smallEncSize = new f.a();
    AppMethodBeat.o(15731);
  }
  
  private String byteArrayToHexStr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15734);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(15734);
      return null;
    }
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar2[(i * 2)] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    paramArrayOfByte = new String(arrayOfChar2);
    AppMethodBeat.o(15734);
    return paramArrayOfByte;
  }
  
  public static boolean hasAudio(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean hasMainVideo(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean hasSmallVideo(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean hasSubVideo(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  private byte[] hexStrToByteArray(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(15735);
    if (paramString == null)
    {
      AppMethodBeat.o(15735);
      return null;
    }
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(15735);
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
    AppMethodBeat.o(15735);
    return arrayOfByte;
  }
  
  public static boolean isMuteAudio(int paramInt)
  {
    return (paramInt & 0x40) != 0;
  }
  
  public static boolean isMuteMainVideo(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  public static boolean isMuteSubVideo(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  public void addUserInfo(String paramString, UserInfo paramUserInfo)
  {
    try
    {
      AppMethodBeat.i(15739);
      this.userList.put(paramString, paramUserInfo);
      AppMethodBeat.o(15739);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void clear()
  {
    try
    {
      AppMethodBeat.i(15732);
      this.roomId = 0L;
      this.userId = "";
      this.enterTime = 0L;
      this.tinyId = "";
      this.muteLocalVideo = false;
      this.muteLocalAudio = false;
      this.muteRemoteVideo = false;
      this.muteRemoteAudio = false;
      this.userList.clear();
      this.recvFirstIFrameCntList.clear();
      this.networkStatus = 1;
      this.decProperties = null;
      this.enableRestartDecoder = false;
      this.enableCustomPreprocessor = false;
      this.localListener = null;
      AppMethodBeat.o(15732);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearUserList()
  {
    try
    {
      AppMethodBeat.i(15744);
      this.userList.clear();
      this.recvFirstIFrameCntList.clear();
      AppMethodBeat.o(15744);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void forEachUser(UserAction paramUserAction)
  {
    AppMethodBeat.i(15743);
    Object localObject = new HashMap(this.userList.size());
    try
    {
      ((HashMap)localObject).putAll(this.userList);
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if ((paramUserAction != null) && (localEntry.getValue() != null)) {
          paramUserAction.accept((String)localEntry.getKey(), (UserInfo)localEntry.getValue());
        }
      }
      AppMethodBeat.o(15743);
    }
    finally
    {
      AppMethodBeat.o(15743);
    }
  }
  
  public long getRoomElapsed()
  {
    AppMethodBeat.i(15738);
    long l1 = System.currentTimeMillis();
    long l2 = this.enterTime;
    AppMethodBeat.o(15738);
    return l1 - l2;
  }
  
  public int getRoomExitCode()
  {
    try
    {
      int i = this.exitRoomCode;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getRoomId()
  {
    return this.roomId;
  }
  
  public String getStrRoomId()
  {
    AppMethodBeat.i(15733);
    if (TextUtils.isEmpty(this.strRoomId))
    {
      long l = this.roomId;
      AppMethodBeat.o(15733);
      return String.valueOf(l);
    }
    String str = this.strRoomId;
    AppMethodBeat.o(15733);
    return str;
  }
  
  public String getTinyId()
  {
    return this.tinyId;
  }
  
  public byte[] getToken(Context paramContext)
  {
    AppMethodBeat.i(15737);
    try
    {
      if (this.token == null) {
        this.token = hexStrToByteArray(paramContext.getSharedPreferences("TRTC.Info", 0).getString("TRTC.0x0.Token", ""));
      }
      label37:
      paramContext = this.token;
      AppMethodBeat.o(15737);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      break label37;
    }
  }
  
  public UserInfo getUser(String paramString)
  {
    try
    {
      AppMethodBeat.i(15741);
      paramString = (UserInfo)this.userList.get(paramString);
      AppMethodBeat.o(15741);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  /* Error */
  public String getUserIdByTinyId(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15742
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 111	com/tencent/liteav/trtc/impl/TRTCRoomInfo:userList	Ljava/util/HashMap;
    //   12: invokevirtual 218	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   15: invokeinterface 224 1 0
    //   20: astore_3
    //   21: aload_3
    //   22: invokeinterface 230 1 0
    //   27: ifeq +53 -> 80
    //   30: aload_3
    //   31: invokeinterface 234 1 0
    //   36: checkcast 236	java/util/Map$Entry
    //   39: invokeinterface 239 1 0
    //   44: checkcast 12	com/tencent/liteav/trtc/impl/TRTCRoomInfo$UserInfo
    //   47: astore 4
    //   49: aload 4
    //   51: ifnull -30 -> 21
    //   54: aload 4
    //   56: getfield 298	com/tencent/liteav/trtc/impl/TRTCRoomInfo$UserInfo:tinyID	J
    //   59: lload_1
    //   60: lcmp
    //   61: ifne -40 -> 21
    //   64: aload 4
    //   66: getfield 301	com/tencent/liteav/trtc/impl/TRTCRoomInfo$UserInfo:userID	Ljava/lang/String;
    //   69: astore_3
    //   70: sipush 15742
    //   73: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: areturn
    //   80: aconst_null
    //   81: astore_3
    //   82: sipush 15742
    //   85: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: goto -12 -> 76
    //   91: astore_3
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_3
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	TRTCRoomInfo
    //   0	96	1	paramLong	long
    //   20	62	3	localObject1	Object
    //   91	4	3	localObject2	Object
    //   47	18	4	localUserInfo	UserInfo
    // Exception table:
    //   from	to	target	type
    //   2	21	91	finally
    //   21	49	91	finally
    //   54	76	91	finally
    //   82	88	91	finally
  }
  
  /* Error */
  public boolean hasRecvFirstIFrame(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15746
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 113	com/tencent/liteav/trtc/impl/TRTCRoomInfo:recvFirstIFrameCntList	Ljava/util/HashMap;
    //   12: lload_1
    //   13: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   16: invokevirtual 293	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 174	java/lang/Integer
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +23 -> 49
    //   29: aload 4
    //   31: invokevirtual 311	java/lang/Integer:intValue	()I
    //   34: ifle +15 -> 49
    //   37: iconst_1
    //   38: istore_3
    //   39: sipush 15746
    //   42: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: iload_3
    //   48: ireturn
    //   49: iconst_0
    //   50: istore_3
    //   51: sipush 15746
    //   54: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: goto -12 -> 45
    //   60: astore 4
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 4
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	TRTCRoomInfo
    //   0	67	1	paramLong	long
    //   38	13	3	bool	boolean
    //   22	8	4	localInteger	Integer
    //   60	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	60	finally
    //   29	37	60	finally
    //   39	45	60	finally
    //   51	57	60	finally
  }
  
  public void init(long paramLong, String paramString)
  {
    this.roomId = paramLong;
    this.userId = paramString;
  }
  
  public boolean isMicStard()
  {
    try
    {
      boolean bool = this.micHasStartd;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isRoomExit()
  {
    try
    {
      boolean bool = this.hasExitedRoom;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void micStart(boolean paramBoolean)
  {
    this.micHasStartd = paramBoolean;
  }
  
  /* Error */
  public int recvFirstIFrame(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15745
    //   5: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 113	com/tencent/liteav/trtc/impl/TRTCRoomInfo:recvFirstIFrameCntList	Ljava/util/HashMap;
    //   12: lload_1
    //   13: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   16: invokevirtual 293	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 174	java/lang/Integer
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 113	com/tencent/liteav/trtc/impl/TRTCRoomInfo:recvFirstIFrameCntList	Ljava/util/HashMap;
    //   28: astore 5
    //   30: aload 4
    //   32: ifnonnull +36 -> 68
    //   35: iconst_1
    //   36: istore_3
    //   37: aload 5
    //   39: lload_1
    //   40: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: iload_3
    //   44: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 187	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: aload 4
    //   53: ifnonnull +26 -> 79
    //   56: sipush 15745
    //   59: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: iconst_1
    //   63: istore_3
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_3
    //   67: ireturn
    //   68: aload 4
    //   70: invokevirtual 311	java/lang/Integer:intValue	()I
    //   73: iconst_1
    //   74: iadd
    //   75: istore_3
    //   76: goto -39 -> 37
    //   79: aload 4
    //   81: invokevirtual 311	java/lang/Integer:intValue	()I
    //   84: iconst_1
    //   85: iadd
    //   86: istore_3
    //   87: sipush 15745
    //   90: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -29 -> 64
    //   96: astore 4
    //   98: aload_0
    //   99: monitorexit
    //   100: aload 4
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	TRTCRoomInfo
    //   0	103	1	paramLong	long
    //   36	51	3	i	int
    //   22	58	4	localInteger	Integer
    //   96	5	4	localObject	Object
    //   28	10	5	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	30	96	finally
    //   37	51	96	finally
    //   56	62	96	finally
    //   68	76	96	finally
    //   79	93	96	finally
  }
  
  public void removeRenderInfo(String paramString)
  {
    try
    {
      AppMethodBeat.i(15740);
      UserInfo localUserInfo = (UserInfo)this.userList.get(paramString);
      this.recvFirstIFrameCntList.remove(Long.valueOf(localUserInfo.tinyID));
      this.userList.remove(paramString);
      AppMethodBeat.o(15740);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void setRoomExit(boolean paramBoolean, int paramInt)
  {
    try
    {
      this.hasExitedRoom = paramBoolean;
      this.exitRoomCode = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setRoomId(int paramInt)
  {
    this.roomId = paramInt;
  }
  
  public void setTinyId(String paramString)
  {
    this.tinyId = paramString;
  }
  
  public void setToken(Context paramContext, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(15736);
    this.token = paramArrayOfByte;
    try
    {
      paramContext = paramContext.getSharedPreferences("TRTC.Info", 0).edit();
      if (this.token != null) {
        paramContext.putString("TRTC.0x0.Token", byteArrayToHexStr(this.token));
      }
      for (;;)
      {
        paramContext.commit();
        AppMethodBeat.o(15736);
        return;
        paramContext.clear();
      }
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(15736);
    }
  }
  
  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
  
  public static class RenderInfo
    implements SurfaceHolder.Callback
  {
    public boolean muteAudio = false;
    public boolean muteVideo = false;
    public TXCRenderAndDec render = null;
    public long tinyID;
    public TXCloudVideoView view = null;
    
    public void stop()
    {
      AppMethodBeat.i(15667);
      try
      {
        if ((this.view != null) && (this.view.getSurfaceView() != null) && (this.view.getSurfaceView().getHolder() != null)) {
          this.view.getSurfaceView().getHolder().removeCallback(this);
        }
        AppMethodBeat.o(15667);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(15667);
      }
    }
    
    public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(15665);
      TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceChanged " + paramSurfaceHolder.getSurface() + " width " + paramInt2 + ", height " + paramInt3 + ", " + this.tinyID + ", " + this.render);
      if (this.render != null) {}
      for (paramSurfaceHolder = this.render.getVideoRender();; paramSurfaceHolder = null)
      {
        if (paramSurfaceHolder != null) {
          paramSurfaceHolder.c(paramInt2, paramInt3);
        }
        AppMethodBeat.o(15665);
        return;
      }
    }
    
    public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(15664);
      TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceCreated " + paramSurfaceHolder.getSurface() + ", " + this.tinyID + ", " + this.render);
      if (paramSurfaceHolder.getSurface().isValid()) {
        if (this.render == null) {
          break label104;
        }
      }
      label104:
      for (e locale = this.render.getVideoRender();; locale = null)
      {
        if (locale != null) {
          locale.a(paramSurfaceHolder.getSurface());
        }
        AppMethodBeat.o(15664);
        return;
      }
    }
    
    public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(15666);
      TXCLog.i("RenderInfo", "trtc_api startRemoteView surfaceDestroyed " + paramSurfaceHolder.getSurface() + ", " + this.tinyID + ", " + this.render);
      if (this.render != null) {}
      for (paramSurfaceHolder = this.render.getVideoRender();; paramSurfaceHolder = null)
      {
        if (paramSurfaceHolder != null) {
          paramSurfaceHolder.a(null);
        }
        AppMethodBeat.o(15666);
        return;
      }
    }
  }
  
  public static abstract interface UserAction
  {
    public abstract void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo);
  }
  
  public static class UserInfo
  {
    public TRTCCloud.TRTCViewMargin debugMargin;
    public TRTCRoomInfo.RenderInfo mainRender;
    public int streamState;
    public int streamType;
    public TRTCRoomInfo.RenderInfo subRender;
    public int terminalType;
    public long tinyID;
    public String userID;
    
    public UserInfo(long paramLong, String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(15718);
      this.mainRender = new TRTCRoomInfo.RenderInfo();
      this.subRender = new TRTCRoomInfo.RenderInfo();
      this.streamType = 2;
      this.debugMargin = new TRTCCloud.TRTCViewMargin(0.0F, 0.0F, 0.1F, 0.0F);
      this.tinyID = paramLong;
      this.userID = paramString;
      this.terminalType = paramInt1;
      this.streamState = paramInt2;
      this.mainRender.tinyID = paramLong;
      this.subRender.tinyID = paramLong;
      AppMethodBeat.o(15718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCRoomInfo
 * JD-Core Version:    0.7.0.1
 */