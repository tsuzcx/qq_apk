package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MediaSdk
{
  private static final String TAG = "[hilive][java]";
  private long mContext = 0L;
  private boolean mInited = false;
  
  private boolean addAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    AppMethodBeat.i(177276);
    try
    {
      boolean bool = nativeAddAudio(this.mContext, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(177276);
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177276);
      return false;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177276);
    }
    return false;
  }
  
  private boolean addNotifyCallbacker(int paramInt, MediaCallbacker paramMediaCallbacker)
  {
    AppMethodBeat.i(199254);
    try
    {
      boolean bool = nativeAddNotifyCallbacker(this.mContext, paramInt, paramMediaCallbacker);
      AppMethodBeat.o(199254);
      return bool;
    }
    catch (Exception paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(199254);
      return false;
    }
    catch (UnsatisfiedLinkError paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(199254);
    }
    return false;
  }
  
  private boolean addVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(177275);
    try
    {
      paramBoolean1 = nativeAddVideo(this.mContext, paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(177275);
      return paramBoolean1;
    }
    catch (Exception paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177275);
      return false;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177275);
    }
    return false;
  }
  
  private boolean delNotifyCallbacker(int paramInt)
  {
    AppMethodBeat.i(199255);
    try
    {
      boolean bool = nativeDelNotifyCallbacker(this.mContext, paramInt);
      AppMethodBeat.o(199255);
      return bool;
    }
    catch (Exception localException)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(199255);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localUnsatisfiedLinkError.getMessage(), new Object[0]);
      AppMethodBeat.o(199255);
    }
    return false;
  }
  
  private boolean getFrame(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo)
  {
    AppMethodBeat.i(177277);
    try
    {
      paramBoolean = nativeGetFrame(this.mContext, paramInt, paramBoolean, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(177277);
      return paramBoolean;
    }
    catch (Exception paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177277);
      return false;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177277);
    }
    return false;
  }
  
  private native boolean nativeAddAudio(long paramLong1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  private native boolean nativeAddNotifyCallbacker(long paramLong, int paramInt, MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeAddVideo(long paramLong1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
  
  private native long nativeCreate(MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeDelNotifyCallbacker(long paramLong, int paramInt);
  
  private native boolean nativeGetFrame(long paramLong, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo);
  
  private native long nativeGetSdkVersion();
  
  private native void nativeRelease(long paramLong);
  
  private native boolean nativeRequest(long paramLong, int paramInt, byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker);
  
  private void request(int paramInt, byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    AppMethodBeat.i(177274);
    try
    {
      LogDelegate.i("[hilive][java]", "request, evtType:" + paramInt + " bytes:" + paramArrayOfByte.length, new Object[0]);
      if (!this.mInited)
      {
        LogDelegate.e("[hilive][java]", "request sdk not ready", new Object[0]);
        AppMethodBeat.o(177274);
        return;
      }
      if (!nativeRequest(this.mContext, paramInt, paramArrayOfByte, paramMediaCallbacker))
      {
        LogDelegate.e("[hilive][java]", "request invoke failed", new Object[0]);
        AppMethodBeat.o(177274);
        return;
      }
      AppMethodBeat.o(177274);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "request, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177274);
      return;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      LogDelegate.e("[hilive][java]", "request, error:" + paramArrayOfByte.getMessage(), new Object[0]);
      AppMethodBeat.o(177274);
    }
  }
  
  public void addNotify(int paramInt, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(199248);
      addNotifyCallbacker(paramInt, paramMediaCallbacker);
      AppMethodBeat.o(199248);
      return;
    }
    finally
    {
      paramMediaCallbacker = finally;
      throw paramMediaCallbacker;
    }
  }
  
  public void analysis(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177252);
      LogDelegate.i("[hilive][java]", "analysis", new Object[0]);
      request(101, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177252);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void delNotify(int paramInt)
  {
    try
    {
      AppMethodBeat.i(199249);
      delNotifyCallbacker(paramInt);
      AppMethodBeat.o(199249);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void editorCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177260);
      LogDelegate.i("[hilive][java]", "editorCreate", new Object[0]);
      request(200, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177260);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorCreateTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177262);
      LogDelegate.i("[hilive][java]", "editorCreateTrack", new Object[0]);
      request(202, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177262);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorExport(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177265);
      LogDelegate.i("[hilive][java]", "editorExport", new Object[0]);
      request(205, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177265);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorGetTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177261);
      LogDelegate.i("[hilive][java]", "editorGetTrack", new Object[0]);
      request(201, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177261);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177266);
      LogDelegate.i("[hilive][java]", "editorRemove", new Object[0]);
      request(206, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177266);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorRemoveTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177264);
      LogDelegate.i("[hilive][java]", "editorRemoveTrack", new Object[0]);
      request(204, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177264);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorUpdateTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177263);
      LogDelegate.i("[hilive][java]", "editorUpdateTrack", new Object[0]);
      request(203, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177263);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void finalize()
  {
    AppMethodBeat.i(73615);
    uint();
    AppMethodBeat.o(73615);
  }
  
  public long getSdkVersion()
  {
    boolean bool;
    label16:
    label27:
    try
    {
      AppMethodBeat.i(73617);
    }
    finally {}
    try
    {
      bool = this.mInited;
      if (bool) {
        break label27;
      }
    }
    catch (Exception localException)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + localException.getMessage(), new Object[0]);
      break label16;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + localUnsatisfiedLinkError.getMessage(), new Object[0]);
      break label16;
    }
    long l = 0L;
    AppMethodBeat.o(73617);
    for (;;)
    {
      return l;
      l = nativeGetSdkVersion();
      AppMethodBeat.o(73617);
    }
  }
  
  /* Error */
  public boolean init(MediaCallbacker paramMediaCallbacker)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 175
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 180	com/hilive/mediasdk/LoadDelegate:loadLibraries	()V
    //   12: ldc 11
    //   14: new 46	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 182
    //   20: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 170	com/hilive/mediasdk/MediaSdk:nativeGetSdkVersion	()J
    //   27: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 117	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_0
    //   41: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   44: ifne +28 -> 72
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 187	com/hilive/mediasdk/MediaSdk:nativeCreate	(Lcom/hilive/mediasdk/MediaSdk$MediaCallbacker;)J
    //   53: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   56: aload_0
    //   57: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifeq +64 -> 126
    //   65: iconst_1
    //   66: istore_2
    //   67: aload_0
    //   68: iload_2
    //   69: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   72: ldc 11
    //   74: new 46	java/lang/StringBuilder
    //   77: dup
    //   78: ldc 189
    //   80: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   87: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: ldc 191
    //   92: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 193	com/hilive/mediasdk/MediaSdk:getSdkVersion	()J
    //   99: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 117	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   116: istore_2
    //   117: ldc 175
    //   119: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: monitorexit
    //   124: iload_2
    //   125: ireturn
    //   126: iconst_0
    //   127: istore_2
    //   128: goto -61 -> 67
    //   131: astore_1
    //   132: ldc 11
    //   134: new 46	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 195
    //   140: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: ldc 175
    //   162: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: iload_3
    //   166: istore_2
    //   167: goto -45 -> 122
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: ldc 11
    //   178: new 46	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 197
    //   184: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -44 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	MediaSdk
    //   0	207	1	paramMediaCallbacker	MediaCallbacker
    //   66	101	2	bool1	boolean
    //   1	165	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   9	65	131	java/lang/Exception
    //   67	72	131	java/lang/Exception
    //   72	117	131	java/lang/Exception
    //   4	9	170	finally
    //   9	65	170	finally
    //   67	72	170	finally
    //   72	117	170	finally
    //   117	122	170	finally
    //   132	160	170	finally
    //   160	165	170	finally
    //   176	204	170	finally
    //   9	65	175	java/lang/UnsatisfiedLinkError
    //   67	72	175	java/lang/UnsatisfiedLinkError
    //   72	117	175	java/lang/UnsatisfiedLinkError
  }
  
  public boolean isInited()
  {
    try
    {
      boolean bool = this.mInited;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void loaderCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(199250);
      LogDelegate.i("[hilive][java]", "loaderCreate", new Object[0]);
      request(500, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(199250);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(199253);
      LogDelegate.i("[hilive][java]", "loaderRemove", new Object[0]);
      request(503, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(199253);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderStart(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(199251);
      LogDelegate.i("[hilive][java]", "loaderStart", new Object[0]);
      request(501, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(199251);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderStop(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(199252);
      LogDelegate.i("[hilive][java]", "loaderStop", new Object[0]);
      request(502, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(199252);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void playerCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177253);
      LogDelegate.i("[hilive][java]", "playerCreate", new Object[0]);
      request(400, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177253);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean playerGetAudio(int paramInt, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo)
  {
    try
    {
      AppMethodBeat.i(177255);
      boolean bool = getFrame(paramInt, false, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(177255);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean playerGetVideo(int paramInt, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo)
  {
    try
    {
      AppMethodBeat.i(177256);
      boolean bool = getFrame(paramInt, true, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(177256);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void playerRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177259);
      LogDelegate.i("[hilive][java]", "playerRemove", new Object[0]);
      request(404, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177259);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void playerSeek(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177257);
      LogDelegate.i("[hilive][java]", "playerSeek", new Object[0]);
      request(402, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177257);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void playerStart(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177254);
      LogDelegate.i("[hilive][java]", "playerStart", new Object[0]);
      request(401, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177254);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void playerStop(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177258);
      LogDelegate.i("[hilive][java]", "playerStop", new Object[0]);
      request(403, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177258);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean recorderAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    try
    {
      AppMethodBeat.i(177269);
      boolean bool = addAudio(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(177269);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void recorderCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177267);
      LogDelegate.i("[hilive][java]", "recorderCreate", new Object[0]);
      request(300, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177267);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void recorderRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177273);
      LogDelegate.i("[hilive][java]", "recorderRemove", new Object[0]);
      request(306, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177273);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void recorderStart(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177268);
      LogDelegate.i("[hilive][java]", "recorderStart", new Object[0]);
      request(301, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177268);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void recorderStop(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177272);
      LogDelegate.i("[hilive][java]", "recorderStop", new Object[0]);
      request(305, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177272);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void recorderUpdate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177271);
      LogDelegate.i("[hilive][java]", "recorderUpdate", new Object[0]);
      request(302, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177271);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean recorderVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    try
    {
      AppMethodBeat.i(177270);
      paramBoolean1 = addVideo(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(177270);
      return paramBoolean1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void remux(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177251);
      LogDelegate.i("[hilive][java]", "remux", new Object[0]);
      request(102, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177251);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void test(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(177250);
      LogDelegate.i("[hilive][java]", "test", new Object[0]);
      request(100, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(177250);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  /* Error */
  public void uint()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 263
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 11
    //   10: ldc_w 264
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 117	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   25: aload_0
    //   26: aload_0
    //   27: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   30: invokespecial 266	com/hilive/mediasdk/MediaSdk:nativeRelease	(J)V
    //   33: aload_0
    //   34: lconst_0
    //   35: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   38: ldc_w 263
    //   41: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: ldc 11
    //   50: new 46	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 268
    //   57: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   64: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: iconst_0
    //   71: anewarray 4	java/lang/Object
    //   74: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: ldc_w 263
    //   80: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -39 -> 44
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: ldc 11
    //   94: new 46	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 270
    //   101: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: ldc_w 263
    //   124: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: goto -83 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	MediaSdk
    //   47	14	1	localException	Exception
    //   86	4	1	localObject	Object
    //   91	14	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   20	38	47	java/lang/Exception
    //   2	20	86	finally
    //   20	38	86	finally
    //   38	44	86	finally
    //   48	83	86	finally
    //   92	127	86	finally
    //   20	38	91	java/lang/UnsatisfiedLinkError
  }
  
  public static abstract interface MediaCallbacker
  {
    public abstract void onResult(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk
 * JD-Core Version:    0.7.0.1
 */