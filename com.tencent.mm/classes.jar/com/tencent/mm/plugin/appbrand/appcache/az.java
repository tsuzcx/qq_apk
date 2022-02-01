package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class az
  extends com.tencent.mm.plugin.appbrand.appstorage.i
  implements IWxaFileSystemWithModularizing
{
  private final r iNZ;
  private Map<String, Long> iOa;
  
  public az(q paramq)
  {
    AppMethodBeat.i(178529);
    this.iOa = new HashMap();
    Assert.assertTrue(paramq instanceof r);
    this.iNZ = ((r)paramq);
    AppMethodBeat.o(178529);
  }
  
  private l Ed(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.iNZ.DR(paramString))
    {
      paramString = l.iSw;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = l.iSq;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final boolean Eb(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.iNZ.DS(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final l Ec(String paramString)
  {
    AppMethodBeat.i(178532);
    l locall = Ed(paramString);
    if (locall == l.iSw)
    {
      if (paramString.length() == 0)
      {
        paramString = l.iSw;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = m.EV(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label138;
      }
      paramString = paramString + "/";
    }
    label138:
    for (;;)
    {
      Iterator localIterator = this.iNZ.aPA().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!bt.nullAsNil((String)localIterator.next()).startsWith(paramString));
      for (paramString = l.iSq;; paramString = locall)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final l Ee(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.aa.i());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.iNZ.DP(paramString);
    if (localInputStream == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(178536);
      return paramString;
    }
    label419:
    label438:
    for (;;)
    {
      try
      {
        localObject = f(paramLong1, paramLong2, localInputStream.available());
        l locall = l.iSq;
        if (localObject != locall) {
          return localObject;
        }
        l = paramLong2;
        if (paramLong2 == 9223372036854775807L) {
          l = localInputStream.available() - paramLong1;
        }
        localObject = ByteBuffer.allocateDirect(localInputStream.available());
        if ((paramLong1 != 0L) || (l != localInputStream.available())) {
          continue;
        }
        i = 1;
        if ((i == 0) || (!(localInputStream instanceof a))) {
          continue;
        }
        ((ByteBuffer)localObject).put(((a)localInputStream).cjb);
        ((ByteBuffer)localObject).rewind();
        parami.value = localObject;
        if (paramString.startsWith("/")) {
          break label438;
        }
        paramString = "/".concat(String.valueOf(paramString));
        if (!paramString.contains("\\"))
        {
          parami = paramString;
          if (!paramString.trim().isEmpty()) {
            continue;
          }
        }
        ad.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        ad.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        bt.d(localInputStream);
        paramString = l.iSr;
        AppMethodBeat.o(178536);
        return paramString;
        if (parami.equals("")) {
          continue;
        }
        if (parami.endsWith("/")) {
          break label419;
        }
        parami = parami.substring(0, parami.lastIndexOf("/"));
        if (!parami.equals("")) {
          break label376;
        }
        this.iOa.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        bt.d(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = l.iSq;
      bt.d(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label376:
      this.iOa.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      ad.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.aa.i<List<j>> parami)
  {
    AppMethodBeat.i(178534);
    if (Ed(paramString) == l.iSq)
    {
      paramString = l.iSy;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = m.EV(paramString);
    paramString = this.iNZ.aPA();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      if (bt.nullAsNil(paramString).startsWith(str1))
      {
        paramString = paramString.replaceFirst(str2, "");
        if (paramString.split("/").length <= 1)
        {
          j localj = new j();
          localj.fileName = paramString;
          if (parami.value == null) {}
          for (paramString = new LinkedList();; paramString = (List)parami.value)
          {
            parami.value = paramString;
            ((List)parami.value).add(localj);
            break;
          }
        }
      }
    }
    if (parami.value == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = l.iSq;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.iNZ.DQ(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (Ed(paramString) != l.iSw) {
          break label156;
        }
        localObject = this.iNZ.DO(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).aQe().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.iOa.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = l.iSq;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = l.iSw;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((q.a)localObject).iLP.aQe().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((q.a)localObject).iLS;
    paramString = l.iSq;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final e ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (Ee(paramString) == l.iSq) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.iNZ.DQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = z.a(paramString.iLP, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new e(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.iNZ.DP(paramString);
    if (localInputStream == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(178537);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      bt.d(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(178537);
      return paramString;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
      paramString = l.iSr;
      return paramString;
    }
    finally
    {
      bt.d(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final void initialize() {}
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.iNZ.DQ(paramString);
    if (paramString != null)
    {
      paramString = paramString.aPB();
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.iNZ.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */