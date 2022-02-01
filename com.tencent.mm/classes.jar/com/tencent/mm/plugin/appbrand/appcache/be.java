package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

public final class be
  extends j
  implements IWxaFileSystemWithModularizing
{
  private final r nGX;
  private Map<String, Long> nGY;
  
  public be(q paramq)
  {
    AppMethodBeat.i(178529);
    this.nGY = new HashMap();
    Assert.assertTrue(paramq instanceof r);
    this.nGX = ((r)paramq);
    AppMethodBeat.o(178529);
  }
  
  private m acU(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.nGX.acG(paramString))
    {
      paramString = m.nMX;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = m.nMR;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.nGX.acE(paramString);
    if (localInputStream == null)
    {
      paramString = m.nMX;
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
        localObject2 = m.nMR;
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
        ((ByteBuffer)localObject1).put(((a)localInputStream).cDP);
        ((ByteBuffer)localObject1).rewind();
        parami.value = localObject1;
        if (paramString.startsWith("/")) {
          break label446;
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
        Object localObject1;
        Object localObject2;
        int i;
        Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = m.nMS;
        AppMethodBeat.o(178536);
        return paramString;
        if (parami.equals("")) {
          continue;
        }
        if (parami.endsWith("/")) {
          break label427;
        }
        parami = parami.substring(0, parami.lastIndexOf("/"));
        if (!parami.equals("")) {
          break label384;
        }
        this.nGY.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        Util.qualityClose(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = m.nMR;
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      localObject2 = d.a(localInputStream, paramLong1, paramLong2);
      localObject1 = ByteBuffer.allocateDirect(localObject2.length);
      ((ByteBuffer)localObject1).put(ByteBuffer.wrap((byte[])localObject2));
      continue;
      this.nGY.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
      continue;
    }
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(178534);
    if (acU(paramString) == m.nMR)
    {
      paramString = m.nMZ;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = o.adS(paramString);
    paramString = this.nGX.bGH();
    if (paramString == null)
    {
      paramString = m.nMX;
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
      paramString = m.nMX;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = m.nMR;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final m a(String paramString1, i<Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(243403);
    paramString1 = o.a(ah(paramString1, false).bOF(), parami, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(243403);
    return paramString1;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.nGX.acF(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (acU(paramString) != m.nMX) {
          break label156;
        }
        localObject = this.nGX.acD(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).bHn().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.nGY.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = m.nMR;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = m.nMX;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((q.a)localObject).nEw.bHn().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((q.a)localObject).nEz;
    paramString = m.nMR;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final boolean acS(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.nGX.acH(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final m acT(String paramString)
  {
    AppMethodBeat.i(178532);
    m localm = acU(paramString);
    if (localm == m.nMX)
    {
      if (paramString.length() == 0)
      {
        paramString = m.nMX;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = o.adS(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label156;
      }
      paramString = paramString + "/";
    }
    label156:
    for (;;)
    {
      List localList = this.nGX.bGH();
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
      for (paramString = m.nMR;; paramString = localm)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final m acV(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new i());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.q ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (acV(paramString) == m.nMR) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.nGX.acF(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = ac.a(paramString.nEw, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new com.tencent.mm.vfs.q(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.nGX.acE(paramString);
    if (localInputStream == null)
    {
      paramString = m.nMX;
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
      paramString = m.nMS;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final m h(String paramString, List<z> paramList)
  {
    AppMethodBeat.i(243402);
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
      AppMethodBeat.o(243402);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.nGX.bGH().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1 != null) && (str1.startsWith(paramString)))
      {
        z localz = new z(str1);
        String str2 = a(str1, localz).name();
        if (str2.equals(m.nMR.name())) {
          paramList.add(localz);
        } else {
          Log.w("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = m.nMR;
    AppMethodBeat.o(243402);
    return paramString;
  }
  
  public final void initialize() {}
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.nGX.acF(paramString);
    if (paramString != null)
    {
      paramString = paramString.bGI();
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.nGX.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.be
 * JD-Core Version:    0.7.0.1
 */