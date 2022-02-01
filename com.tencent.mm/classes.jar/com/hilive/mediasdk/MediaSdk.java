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
  
  private native long nativeCreate(String paramString);
  
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
    AppMethodBeat.i(207803);
    for (;;)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207803);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        AppMethodBeat.o(207803);
        return;
      }
      LogDelegate.e("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(207803);
      return;
      LogDelegate.w("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(207803);
      return;
      LogDelegate.i("[hilive][java]", paramArrayOfByte, new Object[0]);
      AppMethodBeat.o(207803);
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
      AppMethodBeat.i(207687);
      LogDelegate.i("[hilive][java]", "editorAddTrack", new Object[0]);
      request(202, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207687);
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
      AppMethodBeat.i(207693);
      LogDelegate.i("[hilive][java]", "editorDelTrack", new Object[0]);
      request(204, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207693);
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
  public boolean init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 160
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 11
    //   11: new 46	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 162
    //   17: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokevirtual 168	android/content/Context:getCacheDir	()Ljava/io/File;
    //   24: invokevirtual 173	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   27: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: iconst_0
    //   34: anewarray 4	java/lang/Object
    //   37: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: invokestatic 178	com/hilive/mediasdk/LoadDelegate:loadLibraries	()V
    //   43: aload_0
    //   44: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   47: ifne +34 -> 81
    //   50: aload_0
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 168	android/content/Context:getCacheDir	()Ljava/io/File;
    //   56: invokevirtual 173	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: invokespecial 180	com/hilive/mediasdk/MediaSdk:nativeCreate	(Ljava/lang/String;)J
    //   62: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   65: aload_0
    //   66: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +52 -> 123
    //   74: iconst_1
    //   75: istore_2
    //   76: aload_0
    //   77: iload_2
    //   78: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   81: ldc 11
    //   83: new 46	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 182
    //   89: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   96: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: getfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   113: istore_2
    //   114: ldc 160
    //   116: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: monitorexit
    //   121: iload_2
    //   122: ireturn
    //   123: iconst_0
    //   124: istore_2
    //   125: goto -49 -> 76
    //   128: astore_1
    //   129: ldc 11
    //   131: new 46	java/lang/StringBuilder
    //   134: dup
    //   135: ldc 187
    //   137: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload_1
    //   141: invokevirtual 55	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 160
    //   159: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: iload_3
    //   163: istore_2
    //   164: goto -45 -> 119
    //   167: astore_1
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: ldc 11
    //   175: new 46	java/lang/StringBuilder
    //   178: dup
    //   179: ldc 189
    //   181: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: invokevirtual 69	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 68	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: goto -44 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	MediaSdk
    //   0	204	1	paramContext	android.content.Context
    //   75	89	2	bool1	boolean
    //   1	162	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   9	74	128	java/lang/Exception
    //   76	81	128	java/lang/Exception
    //   81	114	128	java/lang/Exception
    //   4	9	167	finally
    //   9	74	167	finally
    //   76	81	167	finally
    //   81	114	167	finally
    //   114	119	167	finally
    //   129	157	167	finally
    //   157	162	167	finally
    //   173	201	167	finally
    //   9	74	172	java/lang/UnsatisfiedLinkError
    //   76	81	172	java/lang/UnsatisfiedLinkError
    //   81	114	172	java/lang/UnsatisfiedLinkError
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
      AppMethodBeat.i(207770);
      LogDelegate.i("[hilive][java]", "loaderCreate", new Object[0]);
      request(500, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207770);
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
      AppMethodBeat.i(207790);
      LogDelegate.i("[hilive][java]", "loaderRemove", new Object[0]);
      request(503, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207790);
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
      AppMethodBeat.i(207776);
      LogDelegate.i("[hilive][java]", "loaderStart", new Object[0]);
      request(501, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207776);
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
      AppMethodBeat.i(207785);
      LogDelegate.i("[hilive][java]", "loaderStop", new Object[0]);
      request(502, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207785);
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
      AppMethodBeat.i(207702);
      LogDelegate.i("[hilive][java]", "readerCreate", new Object[0]);
      request(400, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207702);
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
      AppMethodBeat.i(207715);
      boolean bool = getFrame(paramInt, false, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(207715);
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
      AppMethodBeat.i(207719);
      boolean bool = getFrame(paramInt, true, paramArrayOfByte, paramFrameInfo);
      AppMethodBeat.o(207719);
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
      AppMethodBeat.i(207737);
      LogDelegate.i("[hilive][java]", "readerRemove", new Object[0]);
      request(405, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207737);
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
      AppMethodBeat.i(207724);
      LogDelegate.i("[hilive][java]", "readerSeek", new Object[0]);
      request(402, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207724);
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
      AppMethodBeat.i(207709);
      LogDelegate.i("[hilive][java]", "readerStart", new Object[0]);
      request(401, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207709);
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
      AppMethodBeat.i(207732);
      LogDelegate.i("[hilive][java]", "readerStop", new Object[0]);
      request(404, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207732);
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
      AppMethodBeat.i(207672);
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
    AppMethodBeat.o(207672);
    for (;;)
    {
      return bool1;
      bool2 = nativeSetConfig(this.mContext, paramInt1, paramInt2);
      bool1 = bool2;
      AppMethodBeat.o(207672);
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
    //   2: ldc 239
    //   4: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 11
    //   9: ldc 241
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 21	com/hilive/mediasdk/MediaSdk:mInited	Z
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   28: invokespecial 243	com/hilive/mediasdk/MediaSdk:nativeRelease	(J)V
    //   31: aload_0
    //   32: lconst_0
    //   33: putfield 23	com/hilive/mediasdk/MediaSdk:mContext	J
    //   36: ldc 11
    //   38: ldc 245
    //   40: iconst_0
    //   41: anewarray 4	java/lang/Object
    //   44: invokestatic 103	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: ldc 239
    //   49: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: ldc 11
    //   58: new 46	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 247
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
    //   99: ldc 249
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
      AppMethodBeat.i(207749);
      boolean bool = addAudio(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramLong);
      AppMethodBeat.o(207749);
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
      AppMethodBeat.i(207740);
      LogDelegate.i("[hilive][java]", "writerCreate", new Object[0]);
      request(300, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207740);
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
      AppMethodBeat.i(207765);
      LogDelegate.i("[hilive][java]", "writerRemove", new Object[0]);
      request(304, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207765);
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
      AppMethodBeat.i(207745);
      LogDelegate.i("[hilive][java]", "writerStart", new Object[0]);
      request(301, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207745);
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
      AppMethodBeat.i(207761);
      LogDelegate.i("[hilive][java]", "writerStop", new Object[0]);
      request(303, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207761);
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
      AppMethodBeat.i(207755);
      LogDelegate.i("[hilive][java]", "writerUpdate", new Object[0]);
      request(302, paramArrayOfByte, paramMediaCallbacker);
      AppMethodBeat.o(207755);
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
      AppMethodBeat.i(207752);
      paramBoolean1 = addVideo(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramLong);
      AppMethodBeat.o(207752);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.hilive.mediasdk.MediaSdk
 * JD-Core Version:    0.7.0.1
 */