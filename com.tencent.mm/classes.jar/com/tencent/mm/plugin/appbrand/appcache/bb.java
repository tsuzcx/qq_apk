package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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

public final class bb
  extends j
  implements IWxaFileSystemWithModularizing
{
  private final r jLe;
  private Map<String, Long> jLf;
  
  public bb(q paramq)
  {
    AppMethodBeat.i(178529);
    this.jLf = new HashMap();
    Assert.assertTrue(paramq instanceof r);
    this.jLe = ((r)paramq);
    AppMethodBeat.o(178529);
  }
  
  private m Mb(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.jLe.LN(paramString))
    {
      paramString = m.jPS;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = m.jPM;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final boolean LZ(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.jLe.LO(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final m Ma(String paramString)
  {
    AppMethodBeat.i(178532);
    m localm = Mb(paramString);
    if (localm == m.jPS)
    {
      if (paramString.length() == 0)
      {
        paramString = m.jPS;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = n.MV(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label138;
      }
      paramString = paramString + "/";
    }
    label138:
    for (;;)
    {
      Iterator localIterator = this.jLe.bak().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!bu.nullAsNil((String)localIterator.next()).startsWith(paramString));
      for (paramString = m.jPM;; paramString = localm)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final m Mc(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new i());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.jLe.LL(paramString);
    if (localInputStream == null)
    {
      paramString = m.jPS;
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
        m localm = m.jPM;
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
        ((ByteBuffer)localObject).put(((a)localInputStream).cqQ);
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
        ae.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        ae.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        bu.d(localInputStream);
        paramString = m.jPN;
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
        this.jLf.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        bu.d(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = m.jPM;
      bu.d(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label376:
      this.jLf.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      ae.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.jLe.LM(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (Mb(paramString) != m.jPS) {
          break label156;
        }
        localObject = this.jLe.LK(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).baS().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.jLf.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = m.jPM;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = m.jPS;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((q.a)localObject).jIL.baS().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((q.a)localObject).jIO;
    paramString = m.jPM;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final m a(String paramString, i<List<com.tencent.mm.plugin.appbrand.appstorage.k>> parami)
  {
    AppMethodBeat.i(178534);
    if (Mb(paramString) == m.jPM)
    {
      paramString = m.jPU;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = n.MV(paramString);
    paramString = this.jLe.bak();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      if (bu.nullAsNil(paramString).startsWith(str1))
      {
        paramString = paramString.replaceFirst(str2, "");
        if (paramString.split("/").length <= 1)
        {
          com.tencent.mm.plugin.appbrand.appstorage.k localk = new com.tencent.mm.plugin.appbrand.appstorage.k();
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
      paramString = m.jPS;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = m.jPM;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (Mc(paramString) == m.jPM) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.jLe.LM(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = ab.a(paramString.jIL, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new com.tencent.mm.vfs.k(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.jLe.LL(paramString);
    if (localInputStream == null)
    {
      paramString = m.jPS;
      AppMethodBeat.o(178537);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      bu.d(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(178537);
      return paramString;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
      paramString = m.jPN;
      return paramString;
    }
    finally
    {
      bu.d(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final m g(String paramString, List<x> paramList)
  {
    AppMethodBeat.i(207750);
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
      ae.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: path = [%s] is illegal", new Object[] { paramString });
      paramString = super.g(paramString, paramList);
      AppMethodBeat.o(207750);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.jLe.bak().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1 != null) && (str1.startsWith(paramString)))
      {
        x localx = new x(str1);
        String str2 = a(str1, localx).name();
        if (str2.equals(m.jPM.name())) {
          paramList.add(localx);
        } else {
          ae.w("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = m.jPM;
    AppMethodBeat.o(207750);
    return paramString;
  }
  
  public final void initialize() {}
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.jLe.LM(paramString);
    if (paramString != null)
    {
      paramString = paramString.bal();
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.jLe.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */