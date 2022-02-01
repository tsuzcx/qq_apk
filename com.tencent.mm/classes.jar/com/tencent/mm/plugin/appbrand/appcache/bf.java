package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class bf
  extends o
  implements IWxaFileSystemWithModularizing
{
  private Map<String, Long> qEq;
  private final t qGP;
  
  public bf(s params)
  {
    AppMethodBeat.i(178529);
    this.qEq = new HashMap();
    Assert.assertTrue(params instanceof t);
    this.qGP = ((t)params);
    AppMethodBeat.o(178529);
  }
  
  private r Vs(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.qGP.Vf(paramString))
    {
      paramString = r.qMR;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = r.qML;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.qGP.Vg(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(178532);
    r localr = Vs(paramString);
    if (localr == r.qMR)
    {
      if (paramString.length() == 0)
      {
        paramString = r.qMR;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = com.tencent.mm.plugin.appbrand.appstorage.t.as(paramString, true);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label154;
      }
      paramString = paramString + "/";
    }
    label154:
    for (;;)
    {
      List localList = this.qGP.cgg();
      Object localObject = localList;
      if (localList == null) {
        localObject = Collections.emptyList();
      }
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!Util.nullAsNil((String)((Iterator)localObject).next()).startsWith(paramString));
      for (paramString = r.qML;; paramString = localr)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final r Vt(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new k());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.qGP.Vd(paramString);
    if (localInputStream == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(178536);
      return paramString;
    }
    if (paramLong2 == 9223372036854775807L) {}
    label384:
    label427:
    label446:
    for (;;)
    {
      try
      {
        paramLong2 = localInputStream.available() - paramLong1;
        localObject1 = h(paramLong1, paramLong2, localInputStream.available());
        localObject2 = r.qML;
        if (localObject1 != localObject2) {
          return localObject1;
        }
        if ((paramLong1 != 0L) || (paramLong2 != localInputStream.available())) {
          continue;
        }
        i = 1;
        if ((i == 0) || (!(localInputStream instanceof a))) {
          continue;
        }
        localObject1 = ByteBuffer.allocateDirect(localInputStream.available());
        ((ByteBuffer)localObject1).put(((a)localInputStream).ewT);
        ((ByteBuffer)localObject1).rewind();
        paramk.value = localObject1;
        if (paramString.startsWith("/")) {
          break label446;
        }
        paramString = "/".concat(String.valueOf(paramString));
        if (!paramString.contains("\\"))
        {
          paramk = paramString;
          if (!paramString.trim().isEmpty()) {
            continue;
          }
        }
        Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject1;
        Object localObject2;
        int i;
        Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = r.qMM;
        AppMethodBeat.o(178536);
        return paramString;
        if (paramk.equals("")) {
          continue;
        }
        if (paramk.endsWith("/")) {
          break label427;
        }
        paramk = paramk.substring(0, paramk.lastIndexOf("/"));
        if (!paramk.equals("")) {
          break label384;
        }
        this.qEq.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        Util.qualityClose(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = r.qML;
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      localObject2 = d.a(localInputStream, paramLong1, paramLong2);
      localObject1 = ByteBuffer.allocateDirect(localObject2.length);
      ((ByteBuffer)localObject1).put(ByteBuffer.wrap((byte[])localObject2));
      continue;
      this.qEq.put(paramk + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramk });
      continue;
    }
  }
  
  public final r a(String paramString, k<List<p>> paramk)
  {
    AppMethodBeat.i(178534);
    if (Vs(paramString) == r.qML)
    {
      paramString = r.qMT;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = com.tencent.mm.plugin.appbrand.appstorage.t.as(paramString, true);
    paramString = this.qGP.cgg();
    if (paramString == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      if (Util.nullAsNil(paramString).startsWith(str1))
      {
        paramString = paramString.replaceFirst(str2, "");
        if (paramString.split("/").length <= 1)
        {
          p localp = new p();
          localp.fileName = paramString;
          if (paramk.value == null) {}
          for (paramString = new LinkedList();; paramString = (List)paramk.value)
          {
            paramk.value = paramString;
            ((List)paramk.value).add(localp);
            break;
          }
        }
      }
    }
    if (paramk.value == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = r.qML;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(320271);
    paramString1 = com.tencent.mm.plugin.appbrand.appstorage.t.a(ah.v(ao(paramString1, false).jKT()), paramk, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(320271);
    return paramString1;
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.qGP.Ve(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (Vs(paramString) != r.qMR) {
          break label156;
        }
        localObject = this.qGP.Vc(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).cgK().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.qEq.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = r.qML;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = r.qMR;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((s.a)localObject).qEt.cgK().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((s.a)localObject).qEw;
    paramString = r.qML;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final u ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (Vt(paramString) == r.qML) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.qGP.Ve(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = ad.a(paramString.qEt, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new u(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.qGP.Vd(paramString);
    if (localInputStream == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(178537);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = a(paramString, 0L, i, paramk);
      AppMethodBeat.o(178537);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
      paramString = r.qMM;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final void initialize() {}
  
  public final r j(String paramString, List<com.tencent.mm.plugin.appbrand.appstorage.ad> paramList)
  {
    AppMethodBeat.i(320262);
    if (paramString.endsWith("/")) {
      if (!paramString.startsWith("/")) {
        break label97;
      }
    }
    for (;;)
    {
      if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty())) {
        break label110;
      }
      Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: path = [%s] is illegal", new Object[] { paramString });
      paramString = super.j(paramString, paramList);
      AppMethodBeat.o(320262);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.qGP.cgg().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1 != null) && (str1.startsWith(paramString)))
      {
        com.tencent.mm.plugin.appbrand.appstorage.ad localad = new com.tencent.mm.plugin.appbrand.appstorage.ad(str1);
        String str2 = a(str1, localad).name();
        if (str2.equals(r.qML.name())) {
          paramList.add(localad);
        } else {
          Log.w("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = r.qML;
    AppMethodBeat.o(320262);
    return paramString;
  }
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.qGP.Ve(paramString);
    if (paramString != null)
    {
      paramString = new WxaPkg.Info(paramString.qEu, paramString.fileName, paramString.qEv, paramString.qEw);
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.qGP.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bf
 * JD-Core Version:    0.7.0.1
 */