package com.tencent.c.a.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class d
  extends q
{
  d(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(a parama) {}
  
  protected final String read()
  {
    AppMethodBeat.i(125719);
    for (;;)
    {
      try
      {
        s.zU();
        localObject1 = new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="));
        try
        {
          localObject1 = c.n((File)localObject1).iterator();
          boolean bool = ((Iterator)localObject1).hasNext();
          if (bool) {
            continue;
          }
          localObject1 = null;
        }
        catch (IOException localIOException)
        {
          String[] arrayOfString;
          s.zV();
          Object localObject2 = null;
          continue;
        }
        return localObject1;
      }
      finally
      {
        Object localObject1;
        AppMethodBeat.o(125719);
      }
      arrayOfString = ((String)((Iterator)localObject1).next()).split(",");
      if ((arrayOfString.length == 2) && (arrayOfString[0].equals(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))))
      {
        new StringBuilder("read mid from InternalStorage:").append(arrayOfString[1]);
        s.zU();
        localObject1 = arrayOfString[1];
      }
    }
  }
  
  /* Error */
  protected final void write(String paramString)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 28	com/tencent/c/a/a/s:zU	()V
    //   10: new 86	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   17: invokestatic 36	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   20: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc 109
    //   25: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 111
    //   30: invokestatic 42	com/tencent/c/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 118	com/tencent/c/a/a/c:cF	(Ljava/lang/String;)Ljava/io/File;
    //   42: pop
    //   43: new 30	java/io/File
    //   46: dup
    //   47: invokestatic 36	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   50: ldc 38
    //   52: invokestatic 42	com/tencent/c/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokespecial 45	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   58: astore_2
    //   59: new 120	java/io/BufferedWriter
    //   62: dup
    //   63: new 122	java/io/FileWriter
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 125	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   71: invokespecial 128	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore_2
    //   75: aload_2
    //   76: new 86	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 80
    //   82: invokestatic 42	com/tencent/c/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: ldc 74
    //   93: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 134	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: ldc 136
    //   109: invokevirtual 134	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 139	java/io/BufferedWriter:close	()V
    //   116: aload_0
    //   117: monitorexit
    //   118: ldc 102
    //   120: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_1
    //   125: invokestatic 98	com/tencent/c/a/a/s:zV	()V
    //   128: goto -12 -> 116
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: ldc 102
    //   136: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	d
    //   0	141	1	paramString	String
    //   58	55	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	116	124	java/lang/Exception
    //   7	59	131	finally
    //   59	116	131	finally
    //   116	118	131	finally
    //   125	128	131	finally
    //   132	134	131	finally
  }
  
  protected final boolean zL()
  {
    AppMethodBeat.i(125718);
    if ((s.q(this.context, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted")))
    {
      AppMethodBeat.o(125718);
      return true;
    }
    AppMethodBeat.o(125718);
    return false;
  }
  
  protected final a zM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */