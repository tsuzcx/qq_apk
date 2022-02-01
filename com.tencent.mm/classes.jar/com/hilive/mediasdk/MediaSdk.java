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
  
  private boolean addNotifyCallbacker(int paramInt, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    AppMethodBeat.i(215399);
    try
    {
      boolean bool = nativeAddNotifyCallbacker(this.mContext, paramInt, paramMediaCallbacker);
      AppMethodBeat.o(215399);
      return bool;
    }
    catch (Exception paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(215399);
      return false;
    }
    catch (UnsatisfiedLinkError paramMediaCallbacker)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + paramMediaCallbacker.getMessage(), new Object[0]);
      AppMethodBeat.o(215399);
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
    AppMethodBeat.i(215400);
    try
    {
      boolean bool = nativeDelNotifyCallbacker(this.mContext, paramInt);
      AppMethodBeat.o(215400);
      return bool;
    }
    catch (Exception localException)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(215400);
      return false;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogDelegate.e("[hilive][java]", "getFrame, error:" + localUnsatisfiedLinkError.getMessage(), new Object[0]);
      AppMethodBeat.o(215400);
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
  
  private native boolean nativeAddNotifyCallbacker(long paramLong, int paramInt, MediaSdk.MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeAddVideo(long paramLong1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
  
  private native long nativeCreate(MediaSdk.MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeDelNotifyCallbacker(long paramLong, int paramInt);
  
  private native boolean nativeGetFrame(long paramLong, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo);
  
  private native void nativeRelease(long paramLong);
  
  private native boolean nativeRequest(long paramLong, int paramInt, byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeSetConfig(long paramLong, int paramInt1, int paramInt2);
  
  private void request(int paramInt, byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  public void addNotify(int paramInt, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215377);
      addNotifyCallbacker(paramInt, paramMediaCallbacker);
      AppMethodBeat.o(215377);
      return;
    }
    finally
    {
      paramMediaCallbacker = finally;
      throw paramMediaCallbacker;
    }
  }
  
  public void analysis(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
      AppMethodBeat.i(215378);
      delNotifyCallbacker(paramInt);
      AppMethodBeat.o(215378);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void editorAddTrack(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215379);
      LogDelegate.i("[hilive][java]", "editorAddTrack", new Object[0]);
      request(202, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215379);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorCreate(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  public void editorDelTrack(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215380);
      LogDelegate.i("[hilive][java]", "editorDelTrack", new Object[0]);
      request(204, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215380);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void editorExport(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  public void editorGetTrack(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  public void editorRemove(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  public void editorUpdateTrack(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
  
  /* Error */
  public boolean init(MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 168
    //   6: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 173	com/hilive/mediasdk/LoadDelegate:loadLibraries	()V
    //   12: aload_0
    //   13: getfield 20	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   16: ifne +28 -> 44
    //   19: aload_0
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 175	com/hilive/mediasdk/MediaSdk:nativeCreate	(Lcom/hilive/mediasdk/MediaSdk$MediaCallbacker;)J
    //   25: putfield 22	com/hilive/mediasdk/MediaSdk:mContext	J
    //   28: aload_0
    //   29: getfield 22	com/hilive/mediasdk/MediaSdk:mContext	J
    //   32: lconst_0
    //   33: lcmp
    //   34: ifeq +52 -> 86
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: iload_2
    //   41: putfield 20	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   44: ldc 10
    //   46: new 45	java/lang/StringBuilder
    //   49: dup
    //   50: ldc 177
    //   52: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: getfield 22	com/hilive/mediasdk/MediaSdk:mContext	J
    //   59: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokestatic 116	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 20	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   76: istore_2
    //   77: ldc 168
    //   79: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: monitorexit
    //   84: iload_2
    //   85: ireturn
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -49 -> 39
    //   91: astore_1
    //   92: ldc 10
    //   94: new 45	java/lang/StringBuilder
    //   97: dup
    //   98: ldc 182
    //   100: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 54	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 67	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: ldc 168
    //   122: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iload_3
    //   126: istore_2
    //   127: goto -45 -> 82
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: ldc 10
    //   138: new 45	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 184
    //   144: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_1
    //   148: invokevirtual 68	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 67	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -44 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	MediaSdk
    //   0	167	1	paramMediaCallbacker	MediaSdk.MediaCallbacker
    //   38	89	2	bool1	boolean
    //   1	125	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   9	37	91	java/lang/Exception
    //   39	44	91	java/lang/Exception
    //   44	77	91	java/lang/Exception
    //   4	9	130	finally
    //   9	37	130	finally
    //   39	44	130	finally
    //   44	77	130	finally
    //   77	82	130	finally
    //   92	120	130	finally
    //   120	125	130	finally
    //   136	164	130	finally
    //   9	37	135	java/lang/UnsatisfiedLinkError
    //   39	44	135	java/lang/UnsatisfiedLinkError
    //   44	77	135	java/lang/UnsatisfiedLinkError
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
  
  public void loaderCreate(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215395);
      LogDelegate.i("[hilive][java]", "loaderCreate", new Object[0]);
      request(500, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215395);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderRemove(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215398);
      LogDelegate.i("[hilive][java]", "loaderRemove", new Object[0]);
      request(503, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215398);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderStart(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215396);
      LogDelegate.i("[hilive][java]", "loaderStart", new Object[0]);
      request(501, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215396);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void loaderStop(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215397);
      LogDelegate.i("[hilive][java]", "loaderStop", new Object[0]);
      request(502, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215397);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerCreate(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215381);
      LogDelegate.i("[hilive][java]", "readerCreate", new Object[0]);
      request(400, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215381);
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
      AppMethodBeat.i(215383);
      boolean bool = getFrame(paramInt, false, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(215383);
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
      AppMethodBeat.i(215384);
      boolean bool = getFrame(paramInt, true, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(215384);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerRemove(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215387);
      LogDelegate.i("[hilive][java]", "readerRemove", new Object[0]);
      request(405, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215387);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerSeek(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215385);
      LogDelegate.i("[hilive][java]", "readerSeek", new Object[0]);
      request(402, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215385);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerStart(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215382);
      LogDelegate.i("[hilive][java]", "readerStart", new Object[0]);
      request(401, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215382);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void readerStop(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215386);
      LogDelegate.i("[hilive][java]", "readerStop", new Object[0]);
      request(404, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215386);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void remux(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
      AppMethodBeat.i(215376);
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
    AppMethodBeat.o(215376);
    for (;;)
    {
      return bool1;
      bool2 = nativeSetConfig(this.mContext, paramInt1, paramInt2);
      bool1 = bool2;
      AppMethodBeat.o(215376);
    }
  }
  
  public void test(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
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
    //   2: ldc 234
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 10
    //   9: ldc 235
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 116	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 20	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 22	com/hilive/mediasdk/MediaSdk:mContext	J
    //   28: invokespecial 237	com/hilive/mediasdk/MediaSdk:nativeRelease	(J)V
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 22	com/hilive/mediasdk/MediaSdk:mContext	J
    //   36: ldc 234
    //   38: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: ldc 10
    //   47: new 45	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 239
    //   53: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: invokevirtual 54	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   60: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: iconst_0
    //   67: anewarray 4	java/lang/Object
    //   70: invokestatic 67	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: ldc 234
    //   75: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: goto -37 -> 41
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: ldc 10
    //   89: new 45	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 241
    //   95: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_1
    //   99: invokevirtual 68	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: iconst_0
    //   109: anewarray 4	java/lang/Object
    //   112: invokestatic 67	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: ldc 234
    //   117: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -79 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	MediaSdk
    //   44	13	1	localException	Exception
    //   81	4	1	localObject	Object
    //   86	13	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   18	36	44	java/lang/Exception
    //   2	18	81	finally
    //   18	36	81	finally
    //   36	41	81	finally
    //   45	78	81	finally
    //   87	120	81	finally
    //   18	36	86	java/lang/UnsatisfiedLinkError
  }
  
  public boolean writerAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    try
    {
      AppMethodBeat.i(215390);
      boolean bool = addAudio(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(215390);
      return bool;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerCreate(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215388);
      LogDelegate.i("[hilive][java]", "writerCreate", new Object[0]);
      request(300, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215388);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerRemove(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215394);
      LogDelegate.i("[hilive][java]", "writerRemove", new Object[0]);
      request(304, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215394);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerStart(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215389);
      LogDelegate.i("[hilive][java]", "writerStart", new Object[0]);
      request(301, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215389);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerStop(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215393);
      LogDelegate.i("[hilive][java]", "writerStop", new Object[0]);
      request(303, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215393);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void writerUpdate(byte[] paramArrayOfByte, MediaSdk.MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(215392);
      LogDelegate.i("[hilive][java]", "writerUpdate", new Object[0]);
      request(302, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(215392);
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
      AppMethodBeat.i(215391);
      paramBoolean1 = addVideo(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(215391);
      return paramBoolean1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk
 * JD-Core Version:    0.7.0.1
 */