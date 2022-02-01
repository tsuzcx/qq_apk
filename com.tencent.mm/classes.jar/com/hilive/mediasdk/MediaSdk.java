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
  
  private native boolean nativeAddVideo(long paramLong1, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
  
  private native long nativeCreate();
  
  private native boolean nativeGetFrame(long paramLong, int paramInt, boolean paramBoolean, byte[] paramArrayOfByte, SdkInfo.FrameInfo paramFrameInfo);
  
  private native void nativeRelease(long paramLong);
  
  private native boolean nativeRequest(long paramLong, int paramInt, byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker);
  
  private native boolean nativeSetConfig(long paramLong, int paramInt1, int paramInt2);
  
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
  
  public void Loging(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238028);
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(238028);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(238028);
        return;
      }
      LogDelegate.e("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(238028);
      return;
      LogDelegate.w("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(238028);
      return;
      LogDelegate.i("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(238028);
      return;
      LogDelegate.d("[hilive][java]", paramArrayOfByte, new Object[0]);
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
  
  public void editorAddTrack(byte[] paramArrayOfByte, MediaCallbacker paramMediaCallbacker)
  {
    try
    {
      AppMethodBeat.i(238008);
      LogDelegate.i("[hilive][java]", "editorAddTrack", new Object[0]);
      request(202, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238008);
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
      AppMethodBeat.i(238009);
      LogDelegate.i("[hilive][java]", "editorDelTrack", new Object[0]);
      request(204, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238009);
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
  
  /* Error */
  public boolean init()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 160
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 11
    //   11: ldc 162
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: invokestatic 167	com/hilive/mediasdk/LoadDelegate:loadLibraries	()V
    //   23: aload_0
    //   24: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   27: ifne +27 -> 54
    //   30: aload_0
    //   31: aload_0
    //   32: invokespecial 169	com/hilive/mediasdk/MediaSdk:nativeCreate	()J
    //   35: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   38: aload_0
    //   39: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifeq +52 -> 96
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_0
    //   50: iload_1
    //   51: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   54: ldc 11
    //   56: new 46	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 171
    //   62: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   69: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: iconst_0
    //   76: anewarray 4	java/lang/Object
    //   79: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   86: istore_1
    //   87: ldc 160
    //   89: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_0
    //   93: monitorexit
    //   94: iload_1
    //   95: ireturn
    //   96: iconst_0
    //   97: istore_1
    //   98: goto -49 -> 49
    //   101: astore_3
    //   102: ldc 11
    //   104: new 46	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 176
    //   110: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_3
    //   114: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   117: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: ldc 160
    //   132: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: istore_1
    //   137: goto -45 -> 92
    //   140: astore_3
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_3
    //   144: athrow
    //   145: astore_3
    //   146: ldc 11
    //   148: new 46	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 178
    //   154: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload_3
    //   158: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -44 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	MediaSdk
    //   48	89	1	bool1	boolean
    //   1	135	2	bool2	boolean
    //   101	13	3	localException	Exception
    //   140	4	3	localObject	Object
    //   145	13	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   9	47	101	java/lang/Exception
    //   49	54	101	java/lang/Exception
    //   54	87	101	java/lang/Exception
    //   4	9	140	finally
    //   9	47	140	finally
    //   49	54	140	finally
    //   54	87	140	finally
    //   87	92	140	finally
    //   102	130	140	finally
    //   130	135	140	finally
    //   146	174	140	finally
    //   9	47	145	java/lang/UnsatisfiedLinkError
    //   49	54	145	java/lang/UnsatisfiedLinkError
    //   54	87	145	java/lang/UnsatisfiedLinkError
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
      AppMethodBeat.i(238024);
      LogDelegate.i("[hilive][java]", "loaderCreate", new Object[0]);
      request(500, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238024);
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
      AppMethodBeat.i(238027);
      LogDelegate.i("[hilive][java]", "loaderRemove", new Object[0]);
      request(503, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238027);
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
      AppMethodBeat.i(238025);
      LogDelegate.i("[hilive][java]", "loaderStart", new Object[0]);
      request(501, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238025);
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
      AppMethodBeat.i(238026);
      LogDelegate.i("[hilive][java]", "loaderStop", new Object[0]);
      request(502, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238026);
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
      AppMethodBeat.i(238010);
      LogDelegate.i("[hilive][java]", "readerCreate", new Object[0]);
      request(400, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238010);
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
      AppMethodBeat.i(238012);
      boolean bool = getFrame(paramInt, false, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(238012);
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
      AppMethodBeat.i(238013);
      boolean bool = getFrame(paramInt, true, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(238013);
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
      AppMethodBeat.i(238016);
      LogDelegate.i("[hilive][java]", "readerRemove", new Object[0]);
      request(405, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238016);
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
      AppMethodBeat.i(238014);
      LogDelegate.i("[hilive][java]", "readerSeek", new Object[0]);
      request(402, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238014);
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
      AppMethodBeat.i(238011);
      LogDelegate.i("[hilive][java]", "readerStart", new Object[0]);
      request(401, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238011);
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
      AppMethodBeat.i(238015);
      LogDelegate.i("[hilive][java]", "readerStop", new Object[0]);
      request(404, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238015);
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
      AppMethodBeat.i(238007);
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
    AppMethodBeat.o(238007);
    for (;;)
    {
      return bool1;
      bool2 = nativeSetConfig(this.mContext, paramInt1, paramInt2);
      bool1 = bool2;
      AppMethodBeat.o(238007);
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
    //   2: ldc 227
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 11
    //   9: ldc 229
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   28: invokespecial 231	com/hilive/mediasdk/MediaSdk:nativeRelease	(J)V
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   36: ldc 11
    //   38: ldc 233
    //   40: iconst_0
    //   41: anewarray 4	java/lang/Object
    //   44: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: ldc 227
    //   49: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: ldc 11
    //   58: new 46	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 235
    //   64: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: iconst_0
    //   78: anewarray 4	java/lang/Object
    //   81: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: goto -48 -> 36
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    //   92: astore_1
    //   93: ldc 11
    //   95: new 46	java/lang/StringBuilder
    //   98: dup
    //   99: ldc 237
    //   101: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: goto -85 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	MediaSdk
    //   55	13	1	localException	Exception
    //   87	4	1	localObject	Object
    //   92	13	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   18	36	55	java/lang/Exception
    //   2	18	87	finally
    //   18	36	87	finally
    //   36	52	87	finally
    //   56	84	87	finally
    //   93	121	87	finally
    //   18	36	92	java/lang/UnsatisfiedLinkError
  }
  
  public boolean writerAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    try
    {
      AppMethodBeat.i(238019);
      boolean bool = addAudio(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(238019);
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
      AppMethodBeat.i(238017);
      LogDelegate.i("[hilive][java]", "writerCreate", new Object[0]);
      request(300, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238017);
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
      AppMethodBeat.i(238023);
      LogDelegate.i("[hilive][java]", "writerRemove", new Object[0]);
      request(304, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238023);
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
      AppMethodBeat.i(238018);
      LogDelegate.i("[hilive][java]", "writerStart", new Object[0]);
      request(301, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238018);
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
      AppMethodBeat.i(238022);
      LogDelegate.i("[hilive][java]", "writerStop", new Object[0]);
      request(303, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238022);
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
      AppMethodBeat.i(238021);
      LogDelegate.i("[hilive][java]", "writerUpdate", new Object[0]);
      request(302, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(238021);
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
      AppMethodBeat.i(238020);
      paramBoolean1 = addVideo(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(238020);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk
 * JD-Core Version:    0.7.0.1
 */