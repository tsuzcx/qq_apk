package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class e
  extends d
{
  private OutputStream djc;
  private com.tencent.mm.audio.mix.a.d hrE;
  private InputStream inputStream;
  
  /* Error */
  public e(com.tencent.mm.audio.mix.a.d paramd, int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	com/tencent/mm/audio/mix/c/d:<init>	()V
    //   4: ldc 20
    //   6: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 28
    //   11: ldc 30
    //   13: iconst_4
    //   14: anewarray 32	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload 5
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: iload_3
    //   32: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: iload 4
    //   40: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: invokestatic 43	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 48	com/tencent/mm/audio/mix/c/c:aFv	()V
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 50	com/tencent/mm/audio/mix/c/e:hrE	Lcom/tencent/mm/audio/mix/a/d;
    //   55: aload_0
    //   56: aload 5
    //   58: invokestatic 56	com/tencent/mm/audio/mix/h/a:jG	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 60	com/tencent/mm/audio/mix/c/e:hry	Ljava/lang/String;
    //   64: ldc 28
    //   66: ldc 62
    //   68: iconst_1
    //   69: anewarray 32	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 60	com/tencent/mm/audio/mix/c/e:hry	Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 43	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 60	com/tencent/mm/audio/mix/c/e:hry	Ljava/lang/String;
    //   86: invokestatic 68	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: invokestatic 74	com/tencent/mm/audio/mix/b/a:aFc	()Lcom/tencent/mm/audio/mix/b/a;
    //   93: aload_1
    //   94: getfield 79	com/tencent/mm/audio/mix/a/d:hqM	Ljava/lang/String;
    //   97: invokevirtual 82	com/tencent/mm/audio/mix/b/a:iP	(Ljava/lang/String;)Z
    //   100: pop
    //   101: aload_0
    //   102: aload_0
    //   103: getfield 60	com/tencent/mm/audio/mix/c/e:hry	Ljava/lang/String;
    //   106: invokestatic 86	com/tencent/mm/audio/mix/h/a:jH	(Ljava/lang/String;)Lcom/tencent/mm/vfs/u;
    //   109: invokestatic 90	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   112: putfield 92	com/tencent/mm/audio/mix/c/e:djc	Ljava/io/OutputStream;
    //   115: aload_0
    //   116: aload_0
    //   117: getfield 60	com/tencent/mm/audio/mix/c/e:hry	Ljava/lang/String;
    //   120: invokestatic 86	com/tencent/mm/audio/mix/h/a:jH	(Ljava/lang/String;)Lcom/tencent/mm/vfs/u;
    //   123: invokestatic 96	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   126: putfield 98	com/tencent/mm/audio/mix/c/e:inputStream	Ljava/io/InputStream;
    //   129: aload_0
    //   130: aload 5
    //   132: putfield 101	com/tencent/mm/audio/mix/c/e:hrl	Ljava/lang/String;
    //   135: aload_0
    //   136: ldc 102
    //   138: putfield 106	com/tencent/mm/audio/mix/c/e:hrs	I
    //   141: aload_0
    //   142: iconst_2
    //   143: putfield 109	com/tencent/mm/audio/mix/c/e:hrt	I
    //   146: aload_0
    //   147: iconst_2
    //   148: putfield 112	com/tencent/mm/audio/mix/c/e:hru	I
    //   151: aload_0
    //   152: iload_2
    //   153: iload_3
    //   154: iload 4
    //   156: invokevirtual 116	com/tencent/mm/audio/mix/c/e:Z	(III)V
    //   159: ldc 20
    //   161: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: astore_1
    //   166: ldc 28
    //   168: aload_1
    //   169: ldc 121
    //   171: iconst_0
    //   172: anewarray 32	java/lang/Object
    //   175: invokestatic 125	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -63 -> 115
    //   181: astore_1
    //   182: ldc 28
    //   184: aload_1
    //   185: ldc 121
    //   187: iconst_0
    //   188: anewarray 32	java/lang/Object
    //   191: invokestatic 125	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: goto -79 -> 115
    //   197: astore_1
    //   198: ldc 28
    //   200: aload_1
    //   201: ldc 127
    //   203: iconst_0
    //   204: anewarray 32	java/lang/Object
    //   207: invokestatic 125	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: goto -81 -> 129
    //   213: astore_1
    //   214: ldc 28
    //   216: aload_1
    //   217: ldc 127
    //   219: iconst_0
    //   220: anewarray 32	java/lang/Object
    //   223: invokestatic 125	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: goto -97 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	e
    //   0	229	1	paramd	com.tencent.mm.audio.mix.a.d
    //   0	229	2	paramInt1	int
    //   0	229	3	paramInt2	int
    //   0	229	4	paramInt3	int
    //   0	229	5	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   101	115	165	java/io/FileNotFoundException
    //   101	115	181	java/lang/Exception
    //   115	129	197	java/io/FileNotFoundException
    //   115	129	213	java/lang/Exception
  }
  
  public final i aFw()
  {
    AppMethodBeat.i(136773);
    j localj = new j();
    AppMethodBeat.o(136773);
    return localj;
  }
  
  public final void aFx()
  {
    AppMethodBeat.i(136769);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
    try
    {
      if (this.djc != null)
      {
        this.djc.flush();
        this.djc.close();
        this.djc = null;
      }
      Runtime.getRuntime().gc();
      AppMethodBeat.o(136769);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "finishProcess", new Object[0]);
      }
    }
  }
  
  public final com.tencent.mm.audio.mix.a.e aFy()
  {
    AppMethodBeat.i(136770);
    if (this.inputStream == null)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
      AppMethodBeat.o(136770);
      return null;
    }
    byte[] arrayOfByte = new byte[3536];
    try
    {
      int i = this.inputStream.read(arrayOfByte, 0, 3536);
      if (i > 0)
      {
        com.tencent.mm.audio.mix.a.e locale = com.tencent.mm.audio.mix.b.e.aFp().aFo();
        locale.hqJ = arrayOfByte;
        AppMethodBeat.o(136770);
        return locale;
      }
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
      AppMethodBeat.o(136770);
      return null;
    }
    b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
    AppMethodBeat.o(136770);
    return null;
  }
  
  public final void aFz()
  {
    AppMethodBeat.i(136771);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
    if (this.inputStream == null)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
      AppMethodBeat.o(136771);
      return;
    }
    if (this.hrE.ckB)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
      AppMethodBeat.o(136771);
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i == -1) {
        break label131;
      }
      byte[] arrayOfByte = new byte[3536];
      try
      {
        int j = this.inputStream.read(arrayOfByte, 0, 3536);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.a.e locale;
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
        }
      }
      if (i > 0)
      {
        locale = com.tencent.mm.audio.mix.b.e.aFp().aFo();
        locale.hqJ = arrayOfByte;
        this.hrE.a(locale);
      }
    }
    label131:
    this.hrE.GK();
    AppMethodBeat.o(136771);
  }
  
  public final byte[] ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136768);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136768);
      return paramArrayOfByte;
    }
    paramArrayOfByte = super.ae(paramArrayOfByte);
    if (this.djc == null)
    {
      AppMethodBeat.o(136768);
      return paramArrayOfByte;
    }
    if (paramArrayOfByte != null) {
      try
      {
        this.djc.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        AppMethodBeat.o(136768);
        return paramArrayOfByte;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "write", new Object[0]);
        }
      }
    }
    b.e("MicroMsg.Mix.AudioFixedConvertProcess", "desdata is null");
    AppMethodBeat.o(136768);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(136772);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "release");
    super.release();
    try
    {
      if (this.djc != null)
      {
        this.djc.flush();
        this.djc.close();
        this.djc = null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.inputStream != null)
          {
            this.inputStream.close();
            this.inputStream = null;
          }
          AppMethodBeat.o(136772);
          return;
        }
        catch (Exception localException2)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException2, "inputStream close", new Object[0]);
          AppMethodBeat.o(136772);
        }
        localException1 = localException1;
        b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException1, "outputStream close", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.e
 * JD-Core Version:    0.7.0.1
 */