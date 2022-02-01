package com.tencent.magicbrush.handler.glfont;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/handler/glfont/TTFParserKt;", "", "()V", "FAMILY_NAME", "", "POSTSCRIPT_NAME", "parseDetail", "", "f", "Ljava/io/RandomAccessFile;", "parseFontName", "fileName", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 16})
public final class m
{
  public static final m eKa;
  
  static
  {
    AppMethodBeat.i(229002);
    eKa = new m();
    AppMethodBeat.o(229002);
  }
  
  private static String c(RandomAccessFile paramRandomAccessFile)
  {
    int m = 0;
    AppMethodBeat.i(228998);
    int i = paramRandomAccessFile.readShort();
    int j = paramRandomAccessFile.readShort();
    int n = paramRandomAccessFile.readShort();
    if ((i != 1) || (j != 0))
    {
      AppMethodBeat.o(228998);
      return null;
    }
    paramRandomAccessFile.seek(12L);
    Object localObject1 = new byte[4];
    j = 0;
    i = 0;
    Object localObject2;
    if (j < n)
    {
      paramRandomAccessFile.read((byte[])localObject1);
      localObject2 = new String((byte[])localObject1, d.UTF_8);
      paramRandomAccessFile.readInt();
      i = paramRandomAccessFile.readInt();
      paramRandomAccessFile.readInt();
      if (n.T("name", (String)localObject2, true)) {
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        AppMethodBeat.o(228998);
        return null;
        if (((CharSequence)localObject2).length() == 0) {}
        for (k = 1;; k = 0)
        {
          if (k != 0) {
            break label452;
          }
          j += 1;
          break;
        }
      }
      paramRandomAccessFile.seek(i);
      paramRandomAccessFile.readShort();
      int k = paramRandomAccessFile.readShort();
      n = paramRandomAccessFile.readShort();
      localObject2 = null;
      localObject1 = null;
      j = m;
      if (j < k)
      {
        paramRandomAccessFile.readShort();
        paramRandomAccessFile.readShort();
        paramRandomAccessFile.readShort();
        m = paramRandomAccessFile.readShort();
        int i1 = paramRandomAccessFile.readShort();
        int i2 = paramRandomAccessFile.readShort();
        long l = paramRandomAccessFile.getFilePointer();
        if ((i1 <= 0) || (i1 >= 32767))
        {
          AppMethodBeat.o(228998);
          return null;
        }
        Object localObject3;
        Object localObject4;
        if (m != 1)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (m != 6) {}
        }
        else
        {
          paramRandomAccessFile.seek(i2 + i + n);
          localObject3 = new byte[i1];
          paramRandomAccessFile.read((byte[])localObject3);
          paramRandomAccessFile.seek(l);
          switch (m)
          {
          default: 
            localObject4 = localObject1;
            localObject3 = localObject2;
          }
        }
        for (;;)
        {
          j += 1;
          localObject2 = localObject3;
          localObject1 = localObject4;
          break;
          localObject1 = Charset.forName("utf-16");
          s.r(localObject1, "Charset.forName(\"utf-16\")");
          localObject4 = new String((byte[])localObject3, (Charset)localObject1);
          localObject3 = localObject2;
          continue;
          localObject2 = Charset.forName("utf-16");
          s.r(localObject2, "Charset.forName(\"utf-16\")");
          localObject3 = new String((byte[])localObject3, (Charset)localObject2);
          localObject4 = localObject1;
        }
      }
      if (localObject1 != null)
      {
        AppMethodBeat.o(228998);
        return localObject1;
      }
      if (localObject2 != null)
      {
        AppMethodBeat.o(228998);
        return localObject2;
      }
      AppMethodBeat.o(228998);
      return null;
      label452:
      j = 0;
      continue;
      j = 0;
    }
  }
  
  /* Error */
  public static String gc(String paramString)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 119
    //   8: invokestatic 122	kotlin/g/b/s:t	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 51	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_0
    //   16: ldc 123
    //   18: invokespecial 126	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 128	com/tencent/magicbrush/handler/glfont/m:c	(Ljava/io/RandomAccessFile;)Ljava/lang/String;
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   31: ldc 118
    //   33: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: areturn
    //   38: astore_1
    //   39: ldc 133
    //   41: aload_1
    //   42: checkcast 135	java/lang/Throwable
    //   45: ldc 137
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 143	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: goto -23 -> 31
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +7 -> 68
    //   64: aload_1
    //   65: invokevirtual 131	java/io/RandomAccessFile:close	()V
    //   68: ldc 118
    //   70: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_0
    //   74: athrow
    //   75: astore_1
    //   76: ldc 133
    //   78: aload_1
    //   79: checkcast 135	java/lang/Throwable
    //   82: ldc 137
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 143	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: goto -23 -> 68
    //   94: astore_0
    //   95: goto -35 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   21	7	1	localRandomAccessFile	RandomAccessFile
    //   38	4	1	localException1	java.lang.Exception
    //   59	6	1	localObject	Object
    //   75	4	1	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   27	31	38	java/lang/Exception
    //   11	22	57	finally
    //   64	68	75	java/lang/Exception
    //   22	27	94	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.m
 * JD-Core Version:    0.7.0.1
 */