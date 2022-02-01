package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
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

public final class bb
  extends j
  implements IWxaFileSystemWithModularizing
{
  private final r kNd;
  private Map<String, Long> kNe;
  
  public bb(q paramq)
  {
    AppMethodBeat.i(178529);
    this.kNe = new HashMap();
    Assert.assertTrue(paramq instanceof r);
    this.kNd = ((r)paramq);
    AppMethodBeat.o(178529);
  }
  
  private m Vk(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.kNd.UW(paramString))
    {
      paramString = m.kSA;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = m.kSu;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final boolean Vi(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.kNd.UX(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final m Vj(String paramString)
  {
    AppMethodBeat.i(178532);
    m localm = Vk(paramString);
    if (localm == m.kSA)
    {
      if (paramString.length() == 0)
      {
        paramString = m.kSA;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = n.We(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label153;
      }
      paramString = paramString + "/";
    }
    label153:
    for (;;)
    {
      List localList = this.kNd.bvA();
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
      for (paramString = m.kSu;; paramString = localm)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final m Vl(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new i());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.kNd.UU(paramString);
    if (localInputStream == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(178536);
      return paramString;
    }
    label419:
    label438:
    for (;;)
    {
      try
      {
        localObject = g(paramLong1, paramLong2, localInputStream.available());
        m localm = m.kSu;
        if (localObject != localm) {
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
        ((ByteBuffer)localObject).put(((a)localInputStream).cDi);
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
        Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = m.kSv;
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
        this.kNe.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        Util.qualityClose(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = m.kSu;
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label376:
      this.kNe.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(178534);
    if (Vk(paramString) == m.kSu)
    {
      paramString = m.kSC;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = n.We(paramString);
    paramString = this.kNd.bvA();
    if (paramString == null)
    {
      paramString = m.kSA;
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
          k localk = new k();
          localk.fileName = paramString;
          if (parami.value == null) {}
          for (paramString = new LinkedList();; paramString = (List)parami.value)
          {
            parami.value = paramString;
            ((List)parami.value).add(localk);
            break;
          }
        }
      }
    }
    if (parami.value == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = m.kSu;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.kNd.UV(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (Vk(paramString) != m.kSA) {
          break label156;
        }
        localObject = this.kNd.UT(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).bwg().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.kNe.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = m.kSu;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = m.kSA;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((q.a)localObject).kKH.bwg().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((q.a)localObject).kKK;
    paramString = m.kSu;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final o ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (Vl(paramString) == m.kSu) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.kNd.UV(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = ab.a(paramString.kKH, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new o(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.kNd.UU(paramString);
    if (localInputStream == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(178537);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(178537);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
      paramString = m.kSv;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final m h(String paramString, List<x> paramList)
  {
    AppMethodBeat.i(219301);
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
      paramString = super.h(paramString, paramList);
      AppMethodBeat.o(219301);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.kNd.bvA().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1 != null) && (str1.startsWith(paramString)))
      {
        x localx = new x(str1);
        String str2 = a(str1, localx).name();
        if (str2.equals(m.kSu.name())) {
          paramList.add(localx);
        } else {
          Log.w("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = m.kSu;
    AppMethodBeat.o(219301);
    return paramString;
  }
  
  public final void initialize() {}
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.kNd.UV(paramString);
    if (paramString != null)
    {
      paramString = paramString.bvB();
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.kNd.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */