package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.h.b;
import java.io.InputStream;
import java.io.OutputStream;

public final class d
  extends c
{
  private com.tencent.mm.audio.mix.a.d dcN;
  private InputStream inputStream;
  private OutputStream outputStream;
  
  /* Error */
  public d(com.tencent.mm.audio.mix.a.d paramd, int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString)
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
    //   47: invokestatic 48	com/tencent/mm/audio/mix/c/b:Oy	()V
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 50	com/tencent/mm/audio/mix/c/d:dcN	Lcom/tencent/mm/audio/mix/a/d;
    //   55: aload_0
    //   56: aload 5
    //   58: invokestatic 56	com/tencent/mm/audio/mix/h/a:gv	(Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield 60	com/tencent/mm/audio/mix/c/d:dcH	Ljava/lang/String;
    //   64: ldc 28
    //   66: ldc 62
    //   68: iconst_1
    //   69: anewarray 32	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: getfield 60	com/tencent/mm/audio/mix/c/d:dcH	Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 43	com/tencent/mm/audio/mix/h/b:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: getfield 60	com/tencent/mm/audio/mix/c/d:dcH	Ljava/lang/String;
    //   86: invokestatic 68	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 60	com/tencent/mm/audio/mix/c/d:dcH	Ljava/lang/String;
    //   95: invokestatic 72	com/tencent/mm/audio/mix/h/a:gw	(Ljava/lang/String;)Lcom/tencent/mm/vfs/e;
    //   98: invokestatic 76	com/tencent/mm/vfs/i:aj	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   101: putfield 78	com/tencent/mm/audio/mix/c/d:outputStream	Ljava/io/OutputStream;
    //   104: aload_0
    //   105: aload_0
    //   106: getfield 60	com/tencent/mm/audio/mix/c/d:dcH	Ljava/lang/String;
    //   109: invokestatic 72	com/tencent/mm/audio/mix/h/a:gw	(Ljava/lang/String;)Lcom/tencent/mm/vfs/e;
    //   112: invokestatic 82	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   115: putfield 84	com/tencent/mm/audio/mix/c/d:inputStream	Ljava/io/InputStream;
    //   118: aload_0
    //   119: aload 5
    //   121: putfield 87	com/tencent/mm/audio/mix/c/d:dcG	Ljava/lang/String;
    //   124: aload_0
    //   125: ldc 88
    //   127: putfield 92	com/tencent/mm/audio/mix/c/d:dcA	I
    //   130: aload_0
    //   131: iconst_2
    //   132: putfield 95	com/tencent/mm/audio/mix/c/d:dcB	I
    //   135: aload_0
    //   136: iconst_2
    //   137: putfield 98	com/tencent/mm/audio/mix/c/d:dcC	I
    //   140: aload_0
    //   141: iload_2
    //   142: iload_3
    //   143: iload 4
    //   145: invokevirtual 102	com/tencent/mm/audio/mix/c/d:G	(III)V
    //   148: ldc 20
    //   150: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: astore_1
    //   155: ldc 28
    //   157: aload_1
    //   158: ldc 107
    //   160: iconst_0
    //   161: anewarray 32	java/lang/Object
    //   164: invokestatic 111	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: goto -63 -> 104
    //   170: astore_1
    //   171: ldc 28
    //   173: aload_1
    //   174: ldc 107
    //   176: iconst_0
    //   177: anewarray 32	java/lang/Object
    //   180: invokestatic 111	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: goto -79 -> 104
    //   186: astore_1
    //   187: ldc 28
    //   189: aload_1
    //   190: ldc 113
    //   192: iconst_0
    //   193: anewarray 32	java/lang/Object
    //   196: invokestatic 111	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -81 -> 118
    //   202: astore_1
    //   203: ldc 28
    //   205: aload_1
    //   206: ldc 113
    //   208: iconst_0
    //   209: anewarray 32	java/lang/Object
    //   212: invokestatic 111	com/tencent/mm/audio/mix/h/b:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: goto -97 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	d
    //   0	218	1	paramd	com.tencent.mm.audio.mix.a.d
    //   0	218	2	paramInt1	int
    //   0	218	3	paramInt2	int
    //   0	218	4	paramInt3	int
    //   0	218	5	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   90	104	154	java/io/FileNotFoundException
    //   90	104	170	java/lang/Exception
    //   104	118	186	java/io/FileNotFoundException
    //   104	118	202	java/lang/Exception
  }
  
  public final byte[] J(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136768);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136768);
      return paramArrayOfByte;
    }
    paramArrayOfByte = super.J(paramArrayOfByte);
    if (this.outputStream == null)
    {
      AppMethodBeat.o(136768);
      return paramArrayOfByte;
    }
    if (paramArrayOfByte != null) {
      try
      {
        this.outputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
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
  
  public final void OA()
  {
    AppMethodBeat.i(136769);
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
  
  public final e OB()
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
        e locale = com.tencent.mm.audio.mix.b.d.Os().Or();
        locale.dbX = arrayOfByte;
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
  
  public final h Oz()
  {
    AppMethodBeat.i(136773);
    i locali = new i();
    AppMethodBeat.o(136773);
    return locali;
  }
  
  public final void flushCache()
  {
    AppMethodBeat.i(136771);
    b.i("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache");
    if (this.inputStream == null)
    {
      b.e("MicroMsg.Mix.AudioFixedConvertProcess", "flushCache, inputStream is null");
      AppMethodBeat.o(136771);
      return;
    }
    if (this.dcN.aBS)
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
          e locale;
          b.printErrStackTrace("MicroMsg.Mix.AudioFixedConvertProcess", localException, "readPcmDataTrack", new Object[0]);
        }
      }
      if (i > 0)
      {
        locale = com.tencent.mm.audio.mix.b.d.Os().Or();
        locale.dbX = arrayOfByte;
        this.dcN.a(locale);
      }
    }
    label131:
    this.dcN.complete();
    AppMethodBeat.o(136771);
  }
  
  public final void release()
  {
    AppMethodBeat.i(136772);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.d
 * JD-Core Version:    0.7.0.1
 */