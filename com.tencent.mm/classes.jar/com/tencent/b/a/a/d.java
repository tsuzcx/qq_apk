package com.tencent.b.a.a;

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
  
  protected final boolean TW()
  {
    AppMethodBeat.i(87600);
    if ((s.checkPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted")))
    {
      AppMethodBeat.o(87600);
      return true;
    }
    AppMethodBeat.o(87600);
    return false;
  }
  
  protected final a TX()
  {
    return null;
  }
  
  protected final void a(a parama) {}
  
  protected final String read()
  {
    AppMethodBeat.i(87601);
    for (;;)
    {
      try
      {
        s.Uf();
        localObject1 = new File(Environment.getExternalStorageDirectory(), s.decode("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="));
        try
        {
          localObject1 = c.z((File)localObject1).iterator();
          boolean bool = ((Iterator)localObject1).hasNext();
          if (bool) {
            continue;
          }
          localObject1 = null;
        }
        catch (IOException localIOException)
        {
          String[] arrayOfString;
          s.Ug();
          Object localObject2 = null;
          continue;
        }
        return localObject1;
      }
      finally
      {
        Object localObject1;
        AppMethodBeat.o(87601);
      }
      arrayOfString = ((String)((Iterator)localObject1).next()).split(",");
      if ((arrayOfString.length == 2) && (arrayOfString[0].equals(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="))))
      {
        new StringBuilder("read mid from InternalStorage:").append(arrayOfString[1]);
        s.Uf();
        localObject1 = arrayOfString[1];
      }
    }
  }
  
  /* Error */
  protected final void write(String paramString)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 59	com/tencent/b/a/a/s:Uf	()V
    //   10: new 105	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   17: invokestatic 65	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   20: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc 128
    //   25: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 130
    //   30: invokestatic 71	com/tencent/b/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 137	com/tencent/b/a/a/c:eV	(Ljava/lang/String;)Ljava/io/File;
    //   42: pop
    //   43: new 61	java/io/File
    //   46: dup
    //   47: invokestatic 65	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   50: ldc 67
    //   52: invokestatic 71	com/tencent/b/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   58: astore_2
    //   59: new 139	java/io/BufferedWriter
    //   62: dup
    //   63: new 141	java/io/FileWriter
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 144	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   71: invokespecial 147	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   74: astore_2
    //   75: aload_2
    //   76: new 105	java/lang/StringBuilder
    //   79: dup
    //   80: ldc 103
    //   82: invokestatic 71	com/tencent/b/a/a/s:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 151	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: ldc 97
    //   93: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 153	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: ldc 155
    //   109: invokevirtual 153	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: invokevirtual 158	java/io/BufferedWriter:close	()V
    //   116: aload_0
    //   117: monitorexit
    //   118: ldc 121
    //   120: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    //   124: astore_1
    //   125: invokestatic 117	com/tencent/b/a/a/s:Ug	()V
    //   128: goto -12 -> 116
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: ldc 121
    //   136: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */