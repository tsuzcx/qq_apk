package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class k
{
  SimpleDateFormat a;
  a b;
  public File c;
  private String d;
  private ModuleEncryptListener e;
  private Context f;
  private v g;
  private SimpleDateFormat h;
  private StringBuilder i;
  private String j;
  private String k;
  
  public k(Context paramContext, Looper paramLooper, File paramFile, ModuleEncryptListener paramModuleEncryptListener)
  {
    AppMethodBeat.i(180814);
    this.d = k.class.getSimpleName();
    this.a = new SimpleDateFormat("HHmmss");
    this.h = new SimpleDateFormat("yyyyMMdd-HHmmss");
    this.j = "/d_l";
    this.c = null;
    this.f = paramContext;
    this.b = new a(paramLooper);
    this.e = paramModuleEncryptListener;
    paramLooper = paramFile;
    if (paramFile == null) {}
    try
    {
      paramLooper = new File(paramContext.getExternalFilesDir("data").getAbsolutePath() + File.separator + a.a + "_" + this.j);
      this.c = paramLooper;
      this.k = "d_";
      this.g = new v(this.f, paramLooper, "d");
      a();
      r.a(this.b, 10003, 15000L);
      r.a(this.b, 10004, 60000L);
      AppMethodBeat.o(180814);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramLooper = null;
      }
    }
  }
  
  private String b()
  {
    AppMethodBeat.i(180816);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LOC_CORE,").append(this.h.format(new Date())).append(',').append(y.c(this.f)).append(',').append(',').append(',').append("MapSDK_COMP,").append(a.b).append(".").append(a.c).append(',').append(a.d).append(',').append(a.e).append("$");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(180816);
    return localObject;
  }
  
  public final void a()
  {
    AppMethodBeat.i(180815);
    String str = b();
    r.a(this.b, 10001, str);
    AppMethodBeat.o(180815);
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(180809);
      k.a(k.this, new StringBuilder(1024));
      AppMethodBeat.o(180809);
    }
    
    private static void a(Closeable paramCloseable)
    {
      AppMethodBeat.i(180813);
      if (paramCloseable != null) {
        try
        {
          paramCloseable.close();
          AppMethodBeat.o(180813);
          return;
        }
        catch (Throwable paramCloseable) {}
      }
      AppMethodBeat.o(180813);
    }
    
    /* Error */
    private static byte[] a(File paramFile)
    {
      // Byte code:
      //   0: ldc 45
      //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokevirtual 51	java/io/File:exists	()Z
      //   9: ifeq +12 -> 21
      //   12: aload_0
      //   13: invokevirtual 55	java/io/File:length	()J
      //   16: lconst_0
      //   17: lcmp
      //   18: ifne +12 -> 30
      //   21: ldc 45
      //   23: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: iconst_0
      //   27: newarray byte
      //   29: areturn
      //   30: new 57	java/io/ByteArrayOutputStream
      //   33: dup
      //   34: invokespecial 59	java/io/ByteArrayOutputStream:<init>	()V
      //   37: astore 4
      //   39: sipush 4096
      //   42: newarray byte
      //   44: astore_3
      //   45: new 61	java/io/BufferedInputStream
      //   48: dup
      //   49: new 63	java/io/FileInputStream
      //   52: dup
      //   53: aload_0
      //   54: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   57: invokespecial 69	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   60: astore_2
      //   61: aload_2
      //   62: astore_0
      //   63: aload_2
      //   64: aload_3
      //   65: invokevirtual 73	java/io/BufferedInputStream:read	([B)I
      //   68: istore_1
      //   69: iload_1
      //   70: iconst_m1
      //   71: if_icmpeq +35 -> 106
      //   74: aload_2
      //   75: astore_0
      //   76: aload 4
      //   78: aload_3
      //   79: iconst_0
      //   80: iload_1
      //   81: invokevirtual 77	java/io/ByteArrayOutputStream:write	([BII)V
      //   84: goto -23 -> 61
      //   87: astore_0
      //   88: aload_2
      //   89: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   92: aload 4
      //   94: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   97: ldc 45
      //   99: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   102: iconst_0
      //   103: newarray byte
      //   105: areturn
      //   106: aload_2
      //   107: astore_0
      //   108: aload 4
      //   110: invokevirtual 83	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   113: astore_3
      //   114: aload_2
      //   115: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   118: aload 4
      //   120: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   123: ldc 45
      //   125: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   128: aload_3
      //   129: areturn
      //   130: astore_0
      //   131: aconst_null
      //   132: astore_2
      //   133: aload_2
      //   134: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   137: aload 4
      //   139: invokestatic 79	com/tencent/map/tools/internal/k$a:a	(Ljava/io/Closeable;)V
      //   142: ldc 45
      //   144: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_0
      //   148: athrow
      //   149: astore_2
      //   150: aload_0
      //   151: astore_3
      //   152: aload_2
      //   153: astore_0
      //   154: aload_3
      //   155: astore_2
      //   156: goto -23 -> 133
      //   159: astore_0
      //   160: aconst_null
      //   161: astore_2
      //   162: goto -74 -> 88
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	165	0	paramFile	File
      //   68	13	1	i	int
      //   60	74	2	localBufferedInputStream	java.io.BufferedInputStream
      //   149	4	2	localObject1	Object
      //   155	7	2	localObject2	Object
      //   44	111	3	localObject3	Object
      //   37	101	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      // Exception table:
      //   from	to	target	type
      //   63	69	87	java/lang/Throwable
      //   76	84	87	java/lang/Throwable
      //   108	114	87	java/lang/Throwable
      //   45	61	130	finally
      //   63	69	149	finally
      //   76	84	149	finally
      //   108	114	149	finally
      //   45	61	159	java/lang/Throwable
    }
    
    public final boolean a(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(180811);
      if (paramArrayOfByte != null) {}
      try
      {
        int i = paramArrayOfByte.length;
        if (i == 0)
        {
          AppMethodBeat.o(180811);
          return true;
        }
        byte[] arrayOfByte = paramArrayOfByte;
        if (k.d(k.this) != null) {
          arrayOfByte = k.d(k.this).enCryptModleData(paramArrayOfByte);
        }
        if (arrayOfByte != null)
        {
          i = arrayOfByte.length;
          if (i != 0) {}
        }
        else
        {
          AppMethodBeat.o(180811);
          return true;
        }
        if (s.a(a.j, arrayOfByte) == null) {
          k.c(k.this).a(arrayOfByte);
        }
        AppMethodBeat.o(180811);
        return false;
      }
      catch (Throwable paramArrayOfByte)
      {
        AppMethodBeat.o(180811);
      }
      return false;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = 0;
      AppMethodBeat.i(180810);
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(180810);
        return;
        paramMessage = (String)paramMessage.obj;
        k.a(k.this).append(paramMessage).append("$");
        if (k.a(k.this).length() > 20480L)
        {
          r.a(k.b(k.this), 10003, 0L);
          AppMethodBeat.o(180810);
          return;
        }
        k.c(k.this).a(k.a(k.this).toString().getBytes());
        AppMethodBeat.o(180810);
        return;
        if (k.a(k.this) != null)
        {
          a(k.a(k.this).toString().getBytes());
          k.a(k.this).setLength(0);
          k.this.a();
          AppMethodBeat.o(180810);
          return;
          paramMessage = k.e(k.this);
          if ((paramMessage != null) && (paramMessage.exists()) && (paramMessage.isDirectory()))
          {
            paramMessage = paramMessage.listFiles();
            if ((paramMessage != null) && (paramMessage.length > 0)) {
              if (i < paramMessage.length)
              {
                File localFile = paramMessage[i];
                byte[] arrayOfByte;
                if ((localFile.exists()) && (localFile.getName().startsWith(k.f(k.this))))
                {
                  arrayOfByte = a(localFile);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    break label313;
                  }
                  if (s.a(a.j, arrayOfByte) != null) {
                    localFile.delete();
                  }
                }
                for (;;)
                {
                  i += 1;
                  break;
                  label313:
                  if ((arrayOfByte != null) && (arrayOfByte.length == 0)) {
                    localFile.delete();
                  }
                }
              }
            }
          }
          r.a(k.b(k.this), 10004, 60000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.k
 * JD-Core Version:    0.7.0.1
 */