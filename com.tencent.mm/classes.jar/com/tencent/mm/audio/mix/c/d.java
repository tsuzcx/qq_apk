package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class d
  extends c
{
  private com.tencent.mm.audio.mix.a.c cfb;
  private FileInputStream cfc;
  private FileOutputStream outputStream;
  
  /* Error */
  public d(com.tencent.mm.audio.mix.a.c paramc, int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	com/tencent/mm/audio/mix/c/c:<init>	()V
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
    //   47: invokestatic 48	com/tencent/mm/audio/mix/c/b:Di	()V
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 50	com/tencent/mm/audio/mix/c/d:cfb	Lcom/tencent/mm/audio/mix/a/c;
    //   55: aload_0
    //   56: aload 5
    //   58: invokestatic 56	com/tencent/mm/audio/mix/h/a:eD	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 60	com/tencent/mm/audio/mix/c/d:ceV	Ljava/lang/String;
    //   64: ldc 28
    //   66: ldc 62
    //   68: iconst_1
    //   69: anewarray 32	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 60	com/tencent/mm/audio/mix/c/d:ceV	Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 43	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: new 64	java/io/File
    //   85: dup
    //   86: aload_0
    //   87: getfield 60	com/tencent/mm/audio/mix/c/d:ceV	Ljava/lang/String;
    //   90: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 71	java/io/File:delete	()Z
    //   96: pop
    //   97: aload_0
    //   98: new 73	java/io/FileOutputStream
    //   101: dup
    //   102: aload_0
    //   103: getfield 60	com/tencent/mm/audio/mix/c/d:ceV	Ljava/lang/String;
    //   106: invokestatic 77	com/tencent/mm/audio/mix/h/a:eE	(Ljava/lang/String;)Ljava/io/File;
    //   109: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: putfield 82	com/tencent/mm/audio/mix/c/d:outputStream	Ljava/io/FileOutputStream;
    //   115: aload_0
    //   116: new 84	java/io/FileInputStream
    //   119: dup
    //   120: aload_0
    //   121: getfield 60	com/tencent/mm/audio/mix/c/d:ceV	Ljava/lang/String;
    //   124: invokestatic 77	com/tencent/mm/audio/mix/h/a:eE	(Ljava/lang/String;)Ljava/io/File;
    //   127: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: putfield 87	com/tencent/mm/audio/mix/c/d:cfc	Ljava/io/FileInputStream;
    //   133: aload_0
    //   134: aload 5
    //   136: putfield 90	com/tencent/mm/audio/mix/c/d:ceU	Ljava/lang/String;
    //   139: aload_0
    //   140: ldc 91
    //   142: putfield 95	com/tencent/mm/audio/mix/c/d:ceO	I
    //   145: aload_0
    //   146: iconst_2
    //   147: putfield 98	com/tencent/mm/audio/mix/c/d:ceP	I
    //   150: aload_0
    //   151: iconst_2
    //   152: putfield 101	com/tencent/mm/audio/mix/c/d:ceQ	I
    //   155: aload_0
    //   156: iload_2
    //   157: iload_3
    //   158: iload 4
    //   160: invokevirtual 105	com/tencent/mm/audio/mix/c/d:C	(III)V
    //   163: ldc 20
    //   165: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: return
    //   169: astore_1
    //   170: ldc 28
    //   172: aload_1
    //   173: ldc 110
    //   175: iconst_0
    //   176: anewarray 32	java/lang/Object
    //   179: invokestatic 114	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -67 -> 115
    //   185: astore_1
    //   186: ldc 28
    //   188: aload_1
    //   189: ldc 110
    //   191: iconst_0
    //   192: anewarray 32	java/lang/Object
    //   195: invokestatic 114	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -83 -> 115
    //   201: astore_1
    //   202: ldc 28
    //   204: aload_1
    //   205: ldc 116
    //   207: iconst_0
    //   208: anewarray 32	java/lang/Object
    //   211: invokestatic 114	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -81 -> 133
    //   217: astore_1
    //   218: ldc 28
    //   220: aload_1
    //   221: ldc 116
    //   223: iconst_0
    //   224: anewarray 32	java/lang/Object
    //   227: invokestatic 114	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: goto -97 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	d
    //   0	233	1	paramc	com.tencent.mm.audio.mix.a.c
    //   0	233	2	paramInt1	int
    //   0	233	3	paramInt2	int
    //   0	233	4	paramInt3	int
    //   0	233	5	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   97	115	169	java/io/FileNotFoundException
    //   97	115	185	java/lang/Exception
    //   115	133	201	java/io/FileNotFoundException
    //   115	133	217	java/lang/Exception
  }
  
  public final h Dj()
  {
    AppMethodBeat.i(137025);
    i locali = new i();
    AppMethodBeat.o(137025);
    return locali;
  }
  
  public final void Dk()
  {
    AppMethodBeat.i(137021);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "finishProcess");
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
        this.outputStream = null;
      }
      Runtime.getRuntime().gc();
      AppMethodBeat.o(137021);
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
  
  public final com.tencent.mm.audio.mix.a.d Dl()
  {
    AppMethodBeat.i(137022);
    if (this.cfc == null)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack, inputStream is null");
      AppMethodBeat.o(137022);
      return null;
    }
    byte[] arrayOfByte = new byte[3536];
    try
    {
      int i = this.cfc.read(arrayOfByte, 0, 3536);
      if (i > 0)
      {
        com.tencent.mm.audio.mix.a.d locald = com.tencent.mm.audio.mix.b.c.Dc().Db();
        locald.cem = arrayOfByte;
        AppMethodBeat.o(137022);
        return locald;
      }
    }
    catch (Exception localException)
    {
      b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
      AppMethodBeat.o(137022);
      return null;
    }
    b.e("MicroMsg.Mix.AudioFixedConvertProcess", "readPcmDataTrack readSize is 0");
    AppMethodBeat.o(137022);
    return null;
  }
  
  public final byte[] E(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137020);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(137020);
      return paramArrayOfByte;
    }
    paramArrayOfByte = super.E(paramArrayOfByte);
    if (this.outputStream == null)
    {
      AppMethodBeat.o(137020);
      return paramArrayOfByte;
    }
    if (paramArrayOfByte != null) {
      try
      {
        this.outputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        AppMethodBeat.o(137020);
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
    AppMethodBeat.o(137020);
    return null;
  }
  
  public final void flushCache()
  {
    AppMethodBeat.i(137023);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
    if (this.cfc == null)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
      AppMethodBeat.o(137023);
      return;
    }
    if (this.cfb.cep)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, cache is complete");
      AppMethodBeat.o(137023);
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
        int j = this.cfc.read(arrayOfByte, 0, 3536);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.audio.mix.a.d locald;
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
        }
      }
      if (i > 0)
      {
        locald = com.tencent.mm.audio.mix.b.c.Dc().Db();
        locald.cem = arrayOfByte;
        this.cfb.a(locald);
      }
    }
    label131:
    this.cfb.complete();
    AppMethodBeat.o(137023);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137024);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "release");
    super.release();
    try
    {
      if (this.outputStream != null)
      {
        this.outputStream.flush();
        this.outputStream.close();
        this.outputStream = null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.cfc != null)
          {
            this.cfc.close();
            this.cfc = null;
          }
          AppMethodBeat.o(137024);
          return;
        }
        catch (Exception localException2)
        {
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException2, "inputStream close", new Object[0]);
          AppMethodBeat.o(137024);
        }
        localException1 = localException1;
        b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException1, "outputStream close", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.d
 * JD-Core Version:    0.7.0.1
 */