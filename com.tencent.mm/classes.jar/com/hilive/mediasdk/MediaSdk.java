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
    AppMethodBeat.i(221079);
    try
    {
      boolean bool = nativeAddNotifyCallbacker(this.mContext, paramInt, paramMediaCallbacker);
      AppMethodBeat.o(221079);
      return bool;
    }
    catch (Exception paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(221079);
      return false;
    }
    catch (UnsatisfiedLinkError paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(221079);
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
    AppMethodBeat.i(221080);
    try
    {
      boolean bool = nativeDelNotifyCallbacker(this.mContext, paramInt);
      AppMethodBeat.o(221080);
      return bool;
    }
    catch (Exception localException)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(221080);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localUnsatisfiedLinkError.getMessage(), new Object[0]);
      AppMethodBeat.o(221080);
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
  
  private native boolean nativeSetConfig(long paramLong, int paramInt1, int paramInt2);
  
  private native boolean nativeSetObject(long paramLong, int paramInt, Object paramObject);
  
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
      AppMethodBeat.i(221057);
      addNotifyCallbacker(paramInt, paramMediaCallbacker);
      AppMethodBeat.o(221057);
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
      AppMethodBeat.i(221058);
      delNotifyCallbacker(paramInt);
      AppMethodBeat.o(221058);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void editorAddTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221059);
      LogDelegate.i("[hilive][java]", "editorAddTrack", new Object[0]);
      request(202, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221059);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
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
  
  public void editorDelTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221060);
      LogDelegate.i("[hilive][java]", "editorDelTrack", new Object[0]);
      request(204, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221060);
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
    //   4: ldc 179
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 184	com/hilive/mediasdk/LoadDelegate:loadLibraries	()V
    //   12: ldc 11
    //   14: new 46	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 186
    //   20: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 174	com/hilive/mediasdk/MediaSdk:nativeGetSdkVersion	()J
    //   27: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 121	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: aload_0
    //   41: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   44: ifne +28 -> 72
    //   47: aload_0
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 191	com/hilive/mediasdk/MediaSdk:nativeCreate	(Lcom/hilive/mediasdk/MediaSdk$MediaCallbacker;)J
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
    //   78: ldc 193
    //   80: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   87: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: ldc 195
    //   92: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 197	com/hilive/mediasdk/MediaSdk:getSdkVersion	()J
    //   99: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 4	java/lang/Object
    //   109: invokestatic 121	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_0
    //   113: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   116: istore_2
    //   117: ldc 179
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
    //   138: ldc 199
    //   140: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: ldc 179
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
    //   182: ldc 201
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
      AppMethodBeat.i(221075);
      LogDelegate.i("[hilive][java]", "loaderCreate", new Object[0]);
      request(500, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221075);
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
      AppMethodBeat.i(221078);
      LogDelegate.i("[hilive][java]", "loaderRemove", new Object[0]);
      request(503, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221078);
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
      AppMethodBeat.i(221076);
      LogDelegate.i("[hilive][java]", "loaderStart", new Object[0]);
      request(501, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221076);
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
      AppMethodBeat.i(221077);
      LogDelegate.i("[hilive][java]", "loaderStop", new Object[0]);
      request(502, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221077);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221061);
      LogDelegate.i("[hilive][java]", "readerCreate", new Object[0]);
      request(400, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221061);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean readerGetAudio(int paramInt, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo)
  {
    try
    {
      AppMethodBeat.i(221063);
      boolean bool = getFrame(paramInt, false, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(221063);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean readerGetVideo(int paramInt, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo)
  {
    try
    {
      AppMethodBeat.i(221064);
      boolean bool = getFrame(paramInt, true, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(221064);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221067);
      LogDelegate.i("[hilive][java]", "readerRemove", new Object[0]);
      request(405, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221067);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerSeek(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221065);
      LogDelegate.i("[hilive][java]", "readerSeek", new Object[0]);
      request(402, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221065);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerStart(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221062);
      LogDelegate.i("[hilive][java]", "readerStart", new Object[0]);
      request(401, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221062);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerStop(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221066);
      LogDelegate.i("[hilive][java]", "readerStop", new Object[0]);
      request(404, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221066);
      return;
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
  
  public boolean setConfig(int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    boolean bool2;
    label20:
    label29:
    try
    {
      AppMethodBeat.i(221056);
    }
    finally {}
    try
    {
      bool2 = this.mInited;
      if (bool2) {
        break label29;
      }
    }
    catch (Exception localException)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + localException.getMessage(), new Object[0]);
      break label20;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + localUnsatisfiedLinkError.getMessage(), new Object[0]);
      break label20;
    }
    AppMethodBeat.o(221056);
    for (;;)
    {
      return bool1;
      bool2 = nativeSetConfig(this.mContext, paramInt1, paramInt2);
      bool1 = bool2;
      AppMethodBeat.o(221056);
    }
  }
  
  public boolean setObject(int paramInt, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2;
    label20:
    label29:
    try
    {
      AppMethodBeat.i(221055);
    }
    finally {}
    try
    {
      bool2 = this.mInited;
      if (bool2) {
        break label29;
      }
    }
    catch (Exception paramObject)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + paramObject.getMessage(), new Object[0]);
      break label20;
    }
    catch (UnsatisfiedLinkError paramObject)
    {
      LogDelegate.e("[hilive][java]", "getSdkVersion failed, error:" + paramObject.getMessage(), new Object[0]);
      break label20;
    }
    AppMethodBeat.o(221055);
    for (;;)
    {
      return bool1;
      bool2 = nativeSetObject(this.mContext, paramInt, paramObject);
      bool1 = bool2;
      AppMethodBeat.o(221055);
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
    //   2: ldc 254
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 11
    //   9: ldc 255
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 121	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   28: invokespecial 257	com/hilive/mediasdk/MediaSdk:nativeRelease	(J)V
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   36: ldc 254
    //   38: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: ldc 11
    //   47: new 46	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 259
    //   54: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: ldc 254
    //   76: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -38 -> 41
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: ldc 11
    //   90: new 46	java/lang/StringBuilder
    //   93: dup
    //   94: ldc_w 261
    //   97: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: iconst_0
    //   111: anewarray 4	java/lang/Object
    //   114: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: ldc 254
    //   119: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: goto -81 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	MediaSdk
    //   44	14	1	localException	Exception
    //   82	4	1	localObject	Object
    //   87	14	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   18	36	44	java/lang/Exception
    //   2	18	82	finally
    //   18	36	82	finally
    //   36	41	82	finally
    //   45	79	82	finally
    //   88	122	82	finally
    //   18	36	87	java/lang/UnsatisfiedLinkError
  }
  
  public boolean writerAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    try
    {
      AppMethodBeat.i(221070);
      boolean bool = addAudio(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(221070);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerCreate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221068);
      LogDelegate.i("[hilive][java]", "writerCreate", new Object[0]);
      request(300, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221068);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerRemove(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221074);
      LogDelegate.i("[hilive][java]", "writerRemove", new Object[0]);
      request(304, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221074);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerStart(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221069);
      LogDelegate.i("[hilive][java]", "writerStart", new Object[0]);
      request(301, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221069);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerStop(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221073);
      LogDelegate.i("[hilive][java]", "writerStop", new Object[0]);
      request(303, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221073);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerUpdate(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(221072);
      LogDelegate.i("[hilive][java]", "writerUpdate", new Object[0]);
      request(302, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(221072);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public boolean writerVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    try
    {
      AppMethodBeat.i(221071);
      paramBoolean1 = addVideo(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(221071);
      return paramBoolean1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
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