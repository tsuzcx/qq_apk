package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ao.a;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class y
  extends g
{
  public final ao gVr;
  
  public y(ao paramao)
  {
    this.gVr = paramao;
  }
  
  public final j a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(86872);
    InputStream localInputStream = this.gVr.yw(paramString);
    if (localInputStream == null)
    {
      paramString = j.gZG;
      AppMethodBeat.o(86872);
      return paramString;
    }
    ao localao = this.gVr;
    FileStructStat localFileStructStat2 = localao.gVT;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.stat(localao.gVL.getAbsolutePath(), localFileStructStat1);
      localao.gVT = localFileStructStat1;
    }
    localFileStructStat1.fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      bo.b(localInputStream);
      paramString = j.gZA;
      AppMethodBeat.o(86872);
      return paramString;
    }
    catch (Exception paramFileStructStat)
    {
      for (;;)
      {
        ab.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
      }
    }
  }
  
  public final j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    AppMethodBeat.i(86869);
    if (zd(paramString) == j.gZA)
    {
      paramString = j.gZI;
      AppMethodBeat.o(86869);
      return paramString;
    }
    String str = k.zl(paramString);
    Object localObject = this.gVr;
    paramString = new LinkedList();
    localObject = ((ao)localObject).gVS.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add((ao.a)((Iterator)localObject).next());
    }
    localObject = Pattern.quote(str);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (ao.a)localIterator.next();
      if (paramString.fileName.startsWith(str))
      {
        paramString = paramString.fileName.replaceFirst((String)localObject, "");
        if (paramString.split("/").length <= 1)
        {
          h localh = new h();
          localh.fileName = paramString;
          if (paramj.value == null) {}
          for (paramString = new LinkedList();; paramString = (List)paramj.value)
          {
            paramj.value = paramString;
            ((List)paramj.value).add(localh);
            break;
          }
        }
      }
    }
    if (paramj.value == null)
    {
      paramString = j.gZG;
      AppMethodBeat.o(86869);
      return paramString;
    }
    paramString = j.gZA;
    AppMethodBeat.o(86869);
    return paramString;
  }
  
  public final File aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(86873);
    if (!paramBoolean)
    {
      if (ze(paramString) == j.gZA) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(86873);
        return null;
      }
    }
    paramString = w.a(this.gVr, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      AppMethodBeat.o(86873);
      return paramString;
    }
    AppMethodBeat.o(86873);
    return null;
  }
  
  /* Error */
  public final j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<java.nio.ByteBuffer> paramj)
  {
    // Byte code:
    //   0: ldc 211
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 13	com/tencent/mm/plugin/appbrand/appstorage/y:gVr	Lcom/tencent/mm/plugin/appbrand/appcache/ao;
    //   9: aload_1
    //   10: invokevirtual 31	com/tencent/mm/plugin/appbrand/appcache/ao:yw	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +14 -> 29
    //   18: getstatic 37	com/tencent/mm/plugin/appbrand/appstorage/j:gZG	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   21: astore_1
    //   22: ldc 211
    //   24: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_1
    //   28: areturn
    //   29: aload_1
    //   30: invokevirtual 73	java/io/InputStream:available	()I
    //   33: invokestatic 217	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   36: astore_3
    //   37: aload_1
    //   38: instanceof 219
    //   41: ifeq +40 -> 81
    //   44: aload_3
    //   45: aload_1
    //   46: checkcast 219	com/tencent/luggage/g/a
    //   49: getfield 223	com/tencent/luggage/g/a:bFu	Ljava/nio/ByteBuffer;
    //   52: invokevirtual 227	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   55: pop
    //   56: aload_3
    //   57: invokevirtual 231	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   60: pop
    //   61: aload_2
    //   62: aload_3
    //   63: putfield 188	com/tencent/mm/plugin/appbrand/s/j:value	Ljava/lang/Object;
    //   66: getstatic 86	com/tencent/mm/plugin/appbrand/appstorage/j:gZA	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   69: astore_2
    //   70: aload_1
    //   71: invokestatic 83	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   74: ldc 211
    //   76: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_2
    //   80: areturn
    //   81: aload_3
    //   82: aload_1
    //   83: invokestatic 237	com/tencent/mm/plugin/appbrand/s/d:g	(Ljava/io/InputStream;)[B
    //   86: invokestatic 241	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   89: invokevirtual 227	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   92: pop
    //   93: goto -37 -> 56
    //   96: astore_2
    //   97: ldc 88
    //   99: aload_2
    //   100: ldc 243
    //   102: iconst_0
    //   103: anewarray 92	java/lang/Object
    //   106: invokestatic 247	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_1
    //   110: invokestatic 83	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   113: getstatic 250	com/tencent/mm/plugin/appbrand/appstorage/j:gZB	Lcom/tencent/mm/plugin/appbrand/appstorage/j;
    //   116: astore_1
    //   117: ldc 211
    //   119: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: areturn
    //   124: astore_2
    //   125: aload_1
    //   126: invokestatic 83	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   129: ldc 211
    //   131: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	y
    //   0	136	1	paramString	String
    //   0	136	2	paramj	com.tencent.mm.plugin.appbrand.s.j<java.nio.ByteBuffer>
    //   36	46	3	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   29	56	96	java/lang/Exception
    //   56	70	96	java/lang/Exception
    //   81	93	96	java/lang/Exception
    //   29	56	124	finally
    //   56	70	124	finally
    //   81	93	124	finally
    //   97	109	124	finally
  }
  
  public final boolean bL(String paramString)
  {
    return true;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(86874);
    this.gVr.avO();
    AppMethodBeat.o(86874);
  }
  
  public final void release()
  {
    AppMethodBeat.i(86875);
    this.gVr.close();
    AppMethodBeat.o(86875);
  }
  
  public final j zd(String paramString)
  {
    AppMethodBeat.i(86868);
    paramString = this.gVr.yw(paramString);
    if (paramString == null)
    {
      paramString = j.gZG;
      AppMethodBeat.o(86868);
      return paramString;
    }
    bo.b(paramString);
    paramString = j.gZA;
    AppMethodBeat.o(86868);
    return paramString;
  }
  
  public final j ze(String paramString)
  {
    AppMethodBeat.i(86870);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.s.j());
    AppMethodBeat.o(86870);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.y
 * JD-Core Version:    0.7.0.1
 */