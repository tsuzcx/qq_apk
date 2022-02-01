package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
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
  public final WxaPkg jHm;
  private Map<String, Long> jIe;
  
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
    this.jIe = new HashMap();
    if ((!$assertionsDisabled) && (paramWxaPkg == null))
    {
      paramWxaPkg = new AssertionError();
      AppMethodBeat.o(178574);
      throw paramWxaPkg;
    }
    this.jHm = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private l Ly(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.jHm.Lh(paramString);
    if (paramString == null)
    {
      paramString = l.jMB;
      AppMethodBeat.o(134748);
      return paramString;
    }
    bt.d(paramString);
    paramString = l.jMv;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final boolean Lw(String paramString)
  {
    return true;
  }
  
  public final l Lx(String paramString)
  {
    AppMethodBeat.i(134747);
    l locall = Ly(paramString);
    if (locall == l.jMB)
    {
      if (paramString.length() == 0)
      {
        paramString = l.jMB;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = m.Mp(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label136;
      }
      paramString = paramString + "/";
    }
    label136:
    for (;;)
    {
      Iterator localIterator = this.jHm.bav().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = l.jMv;; paramString = locall)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final l Lz(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.z.i());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.jHm.Lh(paramString);
    if (localInputStream == null)
    {
      paramString = l.jMB;
      AppMethodBeat.o(134751);
      return paramString;
    }
    label392:
    label408:
    label461:
    for (;;)
    {
      try
      {
        Object localObject = g(paramLong1, paramLong2, localInputStream.available());
        l locall = l.jMv;
        if (localObject != locall) {
          return localObject;
        }
        long l = paramLong2;
        if (paramLong2 == 9223372036854775807L) {
          l = localInputStream.available() - paramLong1;
        }
        localObject = ByteBuffer.allocateDirect(localInputStream.available());
        int i;
        if ((paramLong1 == 0L) && (l == localInputStream.available()))
        {
          i = 1;
          if ((i != 0) && ((localInputStream instanceof a)))
          {
            ((ByteBuffer)localObject).put(((a)localInputStream).cqn);
            ((ByteBuffer)localObject).rewind();
            parami.value = localObject;
            if (paramString.startsWith("/")) {
              break label461;
            }
            paramString = "/".concat(String.valueOf(paramString));
            if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty())) {
              continue;
            }
            ad.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
            paramString = l.jMv;
            return paramString;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
        continue;
        parami.add(paramString + "/");
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        bt.d(localInputStream);
        paramString = l.jMw;
        AppMethodBeat.o(134751);
        return paramString;
        parami = new ArrayList();
        if (paramString.equals("")) {
          break label408;
        }
        if (paramString.endsWith("/")) {
          break label392;
        }
        paramString = paramString.substring(0, paramString.lastIndexOf("/"));
        if (paramString.equals(""))
        {
          parami.add("/");
          continue;
        }
      }
      finally
      {
        bt.d(localInputStream);
        AppMethodBeat.o(134751);
      }
      continue;
      ad.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: file = [%s] is illegal", new Object[] { paramString });
      paramString = parami.iterator();
      while (paramString.hasNext())
      {
        parami = (String)paramString.next();
        this.jIe.put(parami, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.jHm.Lh(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((Ly(paramString) != l.jMB) || (Lx(paramString) != l.jMv)) {
          break label153;
        }
        this.jHm.bat().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.jIe.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = l.jMv;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = l.jMB;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.jHm.bat().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      bt.d(localInputStream);
      paramString = l.jMv;
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
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(134749);
    if (Ly(paramString) == l.jMv)
    {
      paramString = l.jMD;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = m.Mp(paramString);
    paramString = this.jHm.bav();
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
      paramString = l.jMB;
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = l.jMv;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (Lz(paramString) == l.jMv) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = aa.a(this.jHm, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new e(paramString);
      AppMethodBeat.o(176548);
      return paramString;
    }
    AppMethodBeat.o(176548);
    return null;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134752);
    InputStream localInputStream = this.jHm.Lh(paramString);
    if (localInputStream == null)
    {
      paramString = l.jMB;
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
      paramString = l.jMw;
      return paramString;
    }
    finally
    {
      bt.d(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final l g(String paramString, List<v> paramList)
  {
    AppMethodBeat.i(197272);
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
      ad.e("MicroMsg.WxaPkgFileSystem", "statDir: path = [%s] is illegal", new Object[] { paramString });
      paramString = super.g(paramString, paramList);
      AppMethodBeat.o(197272);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.jHm.baw().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.startsWith(paramString))
      {
        v localv = new v(str1);
        String str2 = a(str1, localv).name();
        if (str2.equals(l.jMv.name())) {
          paramList.add(localv);
        } else {
          ad.w("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = l.jMv;
    AppMethodBeat.o(197272);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.jHm.aZr();
    AppMethodBeat.o(134755);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.jHm.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.z
 * JD-Core Version:    0.7.0.1
 */