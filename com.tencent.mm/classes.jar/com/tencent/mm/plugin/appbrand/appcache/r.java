package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"dirAccessTimeRecord", "", "", "", "TAG", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getTAG", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Ljava/lang/String;", "key", "getKey", "access", "Lcom/tencent/mm/plugin/appbrand/appstorage/FileOpResult;", "path", "checkReadFileArgsBoundary", "position", "length", "fileLength", "readFile", "readFileBuffer", "pByteBuffer", "Lcom/tencent/mm/plugin/appbrand/util/Pointer;", "Ljava/nio/ByteBuffer;", "safeReadFile", "updateDirAccessTimeRecord", "", "luggage-file-storage_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final Map<String, Long> qEq;
  
  static
  {
    AppMethodBeat.i(320355);
    qEq = (Map)new HashMap();
    AppMethodBeat.o(320355);
  }
  
  public static final com.tencent.mm.plugin.appbrand.appstorage.r a(q paramq, String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(320347);
    s.u(paramq, "<this>");
    s.u(paramString, "path");
    s.u(paramk, "pByteBuffer");
    InputStream localInputStream = paramq.Va(paramString);
    if (localInputStream == null)
    {
      paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMR;
      AppMethodBeat.o(320347);
      return paramq;
    }
    int i;
    label237:
    int j;
    int k;
    int m;
    for (;;)
    {
      try
      {
        l = localInputStream.available();
        paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qML;
        if ((paramLong1 < 0L) || (paramLong1 > l - 1L))
        {
          paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMW;
          com.tencent.mm.plugin.appbrand.appstorage.r localr = com.tencent.mm.plugin.appbrand.appstorage.r.qML;
          if (paramq != localr) {
            return paramq;
          }
        }
        else
        {
          if ((paramLong2 >= 1L) && (paramLong2 <= l - paramLong1)) {
            continue;
          }
          paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMX;
          continue;
        }
        l = paramLong2;
        if (paramLong2 == 9223372036854775807L) {
          l = localInputStream.available() - paramLong1;
        }
        paramq = ByteBuffer.allocateDirect(localInputStream.available());
        if ((paramLong1 != 0L) || (l != localInputStream.available())) {
          break label693;
        }
        i = 1;
        if ((i == 0) || (!(localInputStream instanceof com.tencent.luggage.l.a))) {
          continue;
        }
        paramq.put(((com.tencent.luggage.l.a)localInputStream).ewT);
        paramq.rewind();
        paramk.value = paramq;
        if (n.U(paramString, "/", false)) {
          break label653;
        }
        paramq = s.X("/", paramString);
        if (n.a((CharSequence)paramq, (CharSequence)"\\", false)) {
          continue;
        }
        paramString = (CharSequence)paramq;
        i = 0;
        j = paramString.length() - 1;
        k = 0;
      }
      catch (Exception paramq)
      {
        long l;
        Log.printErrStackTrace("MicroMsg.IWxaPkg.Extend", (Throwable)paramq, "readFile", new Object[0]);
        Util.qualityClose((Closeable)localInputStream);
        paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMM;
        AppMethodBeat.o(320347);
        return paramq;
        m = j;
        continue;
        m = 0;
        break label677;
        i += 1;
        break label658;
        if (m == 0) {
          continue;
        }
        j -= 1;
        break label658;
        if (((CharSequence)paramString.subSequence(i, j + 1).toString()).length() != 0) {
          continue;
        }
        i = 1;
        break label699;
        Log.e("MicroMsg.IWxaPkg.Extend", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramq });
        paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qML;
        return paramq;
        i = 0;
        break label699;
        paramString = (List)new ArrayList();
        if (s.p(paramq, "")) {
          break label604;
        }
        if (n.rs(paramq, "/")) {
          break label589;
        }
        i = n.g((CharSequence)paramq, "/");
        if (paramq != null) {
          break label538;
        }
        paramq = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(320347);
        throw paramq;
      }
      finally
      {
        Util.qualityClose((Closeable)localInputStream);
        AppMethodBeat.o(320347);
      }
      if (s.compare(paramString.charAt(m), 32) > 0) {
        continue;
      }
      m = 1;
      break label677;
      paramq.put(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.af.d.a(localInputStream, paramLong1, l)));
    }
    for (;;)
    {
      label353:
      label366:
      label375:
      paramq = paramq.substring(0, i);
      label538:
      s.s(paramq, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (s.p(paramq, ""))
      {
        paramString.add("/");
      }
      else
      {
        paramString.add(s.X(paramq, "/"));
        continue;
        label589:
        Log.e("MicroMsg.IWxaPkg.Extend", "updateDirAccessTimeRecord: file = [%s] is illegal", new Object[] { paramq });
        label604:
        paramq = paramString.iterator();
        while (paramq.hasNext())
        {
          paramString = (String)paramq.next();
          qEq.put(paramString, Long.valueOf(MMSlotKt.now() / 1000L));
        }
        continue;
        label653:
        paramq = paramString;
        break label237;
        for (;;)
        {
          label658:
          if (i > j) {
            break label691;
          }
          if (k != 0) {
            break label353;
          }
          m = i;
          break;
          label677:
          if (k != 0) {
            break label375;
          }
          if (m != 0) {
            break label366;
          }
          k = 1;
        }
        label691:
        continue;
        label693:
        i = 0;
        break;
        label699:
        if (i == 0) {}
      }
    }
  }
  
  public static final com.tencent.mm.plugin.appbrand.appstorage.r a(q paramq, String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(320338);
    s.u(paramq, "<this>");
    s.u(paramString, "path");
    s.u(paramk, "pByteBuffer");
    InputStream localInputStream = paramq.Va(paramString);
    if (localInputStream == null)
    {
      paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMR;
      AppMethodBeat.o(320338);
      return paramq;
    }
    try
    {
      int i = localInputStream.available();
      Util.qualityClose((Closeable)localInputStream);
      paramq = a(paramq, paramString, 0L, i, paramk);
      AppMethodBeat.o(320338);
      return paramq;
    }
    catch (IOException paramq)
    {
      Log.printErrStackTrace("MicroMsg.IWxaPkg.Extend", (Throwable)paramq, "readFile", new Object[0]);
      paramq = com.tencent.mm.plugin.appbrand.appstorage.r.qMM;
      return paramq;
    }
    finally
    {
      Util.qualityClose((Closeable)localInputStream);
      AppMethodBeat.o(320338);
    }
  }
  
  public static final String a(q paramq)
  {
    AppMethodBeat.i(320316);
    s.u(paramq, "<this>");
    String str = y.bub(paramq.cfJ());
    if (str == null) {}
    for (str = null; str == null; str = s.X("MD5_", str))
    {
      paramq = "REV_" + BuildInfo.REV + ':' + paramq.cfJ();
      AppMethodBeat.o(320316);
      return paramq;
    }
    AppMethodBeat.o(320316);
    return str;
  }
  
  public static final String a(q paramq, String paramString)
  {
    AppMethodBeat.i(320322);
    s.u(paramq, "<this>");
    s.u(paramString, "path");
    paramq = (Closeable)paramq.Va(paramString);
    try
    {
      paramString = (InputStream)paramq;
      s.s(paramString, "it");
      paramString = new String(kotlin.f.a.ag(paramString), kotlin.n.d.UTF_8);
      b.a(paramq, null);
      AppMethodBeat.o(320322);
      return paramString;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(320322);
        throw paramString;
      }
      finally
      {
        b.a(paramq, paramString);
        AppMethodBeat.o(320322);
      }
    }
  }
  
  /* Error */
  public static final String b(q paramq, String paramString)
  {
    // Byte code:
    //   0: ldc_w 346
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 70
    //   9: invokestatic 76	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc 77
    //   15: invokestatic 76	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: aload_1
    //   20: invokeinterface 84 2 0
    //   25: checkcast 104	java/io/Closeable
    //   28: astore_1
    //   29: aload_1
    //   30: checkcast 92	java/io/InputStream
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +31 -> 66
    //   38: new 233	java/lang/String
    //   41: dup
    //   42: aload_0
    //   43: invokestatic 330	kotlin/f/a:ag	(Ljava/io/InputStream;)[B
    //   46: getstatic 336	kotlin/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   49: invokespecial 339	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   52: astore_0
    //   53: aload_1
    //   54: aconst_null
    //   55: invokestatic 344	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   58: ldc_w 346
    //   61: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: ldc 212
    //   68: astore_0
    //   69: goto -16 -> 53
    //   72: astore_0
    //   73: ldc_w 346
    //   76: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_0
    //   80: athrow
    //   81: astore_2
    //   82: aload_1
    //   83: aload_0
    //   84: invokestatic 344	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   87: ldc_w 346
    //   90: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramq	q
    //   0	95	1	paramString	String
    //   81	13	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	72	finally
    //   38	53	72	finally
    //   73	81	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.r
 * JD-Core Version:    0.7.0.1
 */