package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
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

@Deprecated
public final class z
  extends i
{
  public final WxaPkg iNh;
  private Map<String, Long> iOa;
  
  static
  {
    AppMethodBeat.i(178575);
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(178575);
      return;
    }
  }
  
  public z(WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(178574);
    this.iOa = new HashMap();
    if ((!$assertionsDisabled) && (paramWxaPkg == null))
    {
      paramWxaPkg = new AssertionError();
      AppMethodBeat.o(178574);
      throw paramWxaPkg;
    }
    this.iNh = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private l Ed(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.iNh.DM(paramString);
    if (paramString == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(134748);
      return paramString;
    }
    bt.d(paramString);
    paramString = l.iSq;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final boolean Eb(String paramString)
  {
    return true;
  }
  
  public final l Ec(String paramString)
  {
    AppMethodBeat.i(134747);
    l locall = Ed(paramString);
    if (locall == l.iSw)
    {
      if (paramString.length() == 0)
      {
        paramString = l.iSw;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = m.EV(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label136;
      }
      paramString = paramString + "/";
    }
    label136:
    for (;;)
    {
      Iterator localIterator = this.iNh.aQg().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = l.iSq;; paramString = locall)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final l Ee(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.aa.i());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.iNh.DM(paramString);
    if (localInputStream == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(134751);
      return paramString;
    }
    label417:
    label436:
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
          break label436;
        }
        paramString = "/".concat(String.valueOf(paramString));
        if (!paramString.contains("\\"))
        {
          parami = paramString;
          if (!paramString.trim().isEmpty()) {
            continue;
          }
        }
        ad.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        ad.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        bt.d(localInputStream);
        paramString = l.iSr;
        AppMethodBeat.o(134751);
        return paramString;
        if (parami.equals("")) {
          continue;
        }
        if (parami.endsWith("/")) {
          break label417;
        }
        parami = parami.substring(0, parami.lastIndexOf("/"));
        if (!parami.equals("")) {
          break label374;
        }
        this.iOa.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        bt.d(localInputStream);
        AppMethodBeat.o(134751);
      }
      paramString = l.iSq;
      bt.d(localInputStream);
      AppMethodBeat.o(134751);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label374:
      this.iOa.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      ad.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.aa.i<List<j>> parami)
  {
    AppMethodBeat.i(134749);
    if (Ed(paramString) == l.iSq)
    {
      paramString = l.iSy;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = m.EV(paramString);
    paramString = this.iNh.aQg();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (WxaPkg.Info)localIterator.next();
      if (paramString.fileName.startsWith(str1))
      {
        paramString = paramString.fileName.replaceFirst(str2, "");
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
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = l.iSq;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.iNh.DM(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((Ed(paramString) != l.iSw) || (Ec(paramString) != l.iSq)) {
          break label153;
        }
        this.iNh.aQe().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.iOa.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = l.iSq;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = l.iSw;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.iNh.aQe().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      bt.d(localInputStream);
      paramString = l.iSq;
      AppMethodBeat.o(134753);
      return paramString;
    }
    catch (Exception paramFileStructStat)
    {
      for (;;)
      {
        ad.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
      }
    }
  }
  
  public final e ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (Ee(paramString) == l.iSq) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.z.a(this.iNh, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new e(paramString);
      AppMethodBeat.o(176548);
      return paramString;
    }
    AppMethodBeat.o(176548);
    return null;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134752);
    InputStream localInputStream = this.iNh.DM(paramString);
    if (localInputStream == null)
    {
      paramString = l.iSw;
      AppMethodBeat.o(134752);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      bt.d(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(134752);
      return paramString;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
      paramString = l.iSr;
      return paramString;
    }
    finally
    {
      bt.d(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.iNh.aPe();
    AppMethodBeat.o(134755);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.iNh.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.z
 * JD-Core Version:    0.7.0.1
 */