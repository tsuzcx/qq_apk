package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ai.a;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class s
  extends e
{
  public final ai fDd;
  
  public s(ai paramai)
  {
    this.fDd = paramai;
  }
  
  public final h a(String paramString, FileStructStat paramFileStructStat)
  {
    InputStream localInputStream = this.fDd.rb(paramString);
    if (localInputStream == null) {
      return h.fHa;
    }
    ai localai = this.fDd;
    FileStructStat localFileStructStat2 = localai.fDD;
    FileStructStat localFileStructStat1 = localFileStructStat2;
    if (localFileStructStat2 == null)
    {
      localFileStructStat1 = new FileStructStat();
      FileStat.stat(localai.fDw.getAbsolutePath(), localFileStructStat1);
      localai.fDD = localFileStructStat1;
    }
    localFileStructStat1.fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      bk.b(localInputStream);
      return h.fGU;
    }
    catch (Exception paramFileStructStat)
    {
      for (;;)
      {
        y.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
      }
    }
  }
  
  public final h a(String paramString, k<List<f>> paramk)
  {
    if (ru(paramString) == h.fGU) {
      return h.fHc;
    }
    String str = i.rA(paramString);
    Object localObject = this.fDd;
    paramString = new LinkedList();
    localObject = ((ai)localObject).fDC.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.add((ai.a)((Iterator)localObject).next());
    }
    localObject = Pattern.quote(str);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (ai.a)localIterator.next();
      if (paramString.fileName.startsWith(str))
      {
        paramString = paramString.fileName.replaceFirst((String)localObject, "");
        if (paramString.split("/").length <= 1)
        {
          f localf = new f();
          localf.fileName = paramString;
          if (paramk.value == null) {}
          for (paramString = new LinkedList();; paramString = (List)paramk.value)
          {
            paramk.value = paramString;
            ((List)paramk.value).add(localf);
            break;
          }
        }
      }
    }
    if (paramk.value == null) {
      return h.fHa;
    }
    return h.fGU;
  }
  
  /* Error */
  public final h b(String paramString, k<java.nio.ByteBuffer> paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/tencent/mm/plugin/appbrand/appstorage/s:fDd	Lcom/tencent/mm/plugin/appbrand/appcache/ai;
    //   4: aload_1
    //   5: invokevirtual 24	com/tencent/mm/plugin/appbrand/appcache/ai:rb	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +7 -> 17
    //   13: getstatic 30	com/tencent/mm/plugin/appbrand/appstorage/h:fHa	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   16: areturn
    //   17: aload_1
    //   18: invokevirtual 63	java/io/InputStream:available	()I
    //   21: invokestatic 185	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   24: astore_3
    //   25: aload_1
    //   26: instanceof 187
    //   29: ifeq +35 -> 64
    //   32: aload_3
    //   33: aload_1
    //   34: checkcast 187	com/tencent/luggage/j/a
    //   37: getfield 191	com/tencent/luggage/j/a:bjB	Ljava/nio/ByteBuffer;
    //   40: invokevirtual 195	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 199	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   48: pop
    //   49: aload_2
    //   50: aload_3
    //   51: putfield 177	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   54: getstatic 76	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 73	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   62: aload_2
    //   63: areturn
    //   64: aload_3
    //   65: aload_1
    //   66: invokestatic 205	com/tencent/mm/plugin/appbrand/u/d:w	(Ljava/io/InputStream;)[B
    //   69: invokestatic 209	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   72: invokevirtual 195	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   75: pop
    //   76: goto -32 -> 44
    //   79: astore_2
    //   80: ldc 78
    //   82: aload_2
    //   83: ldc 211
    //   85: iconst_0
    //   86: anewarray 82	java/lang/Object
    //   89: invokestatic 215	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: aload_1
    //   93: invokestatic 73	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   96: getstatic 218	com/tencent/mm/plugin/appbrand/appstorage/h:fGV	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   99: areturn
    //   100: astore_2
    //   101: aload_1
    //   102: invokestatic 73	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	s
    //   0	107	1	paramString	String
    //   0	107	2	paramk	k<java.nio.ByteBuffer>
    //   24	41	3	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   17	44	79	java/lang/Exception
    //   44	58	79	java/lang/Exception
    //   64	76	79	java/lang/Exception
    //   17	44	100	finally
    //   44	58	100	finally
    //   64	76	100	finally
    //   80	92	100	finally
  }
  
  public final boolean bs(String paramString)
  {
    return true;
  }
  
  public final void initialize()
  {
    this.fDd.abX();
  }
  
  public final void release()
  {
    this.fDd.close();
  }
  
  public final h ru(String paramString)
  {
    paramString = this.fDd.rb(paramString);
    if (paramString == null) {
      return h.fHa;
    }
    bk.b(paramString);
    return h.fGU;
  }
  
  public final h rv(String paramString)
  {
    return a(paramString, new k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.s
 * JD-Core Version:    0.7.0.1
 */