package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
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
public final class ab
  extends j
{
  public final WxaPkg kMl;
  private Map<String, Long> kNe;
  
  static
  {
    AppMethodBeat.i(178575);
    if (!ab.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(178575);
      return;
    }
  }
  
  public ab(WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(178574);
    this.kNe = new HashMap();
    if ((!$assertionsDisabled) && (paramWxaPkg == null))
    {
      paramWxaPkg = new AssertionError();
      AppMethodBeat.o(178574);
      throw paramWxaPkg;
    }
    this.kMl = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private m Vk(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.kMl.UR(paramString);
    if (paramString == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(134748);
      return paramString;
    }
    Util.qualityClose(paramString);
    paramString = m.kSu;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final boolean Vi(String paramString)
  {
    return true;
  }
  
  public final m Vj(String paramString)
  {
    AppMethodBeat.i(134747);
    m localm = Vk(paramString);
    if (localm == m.kSA)
    {
      if (paramString.length() == 0)
      {
        paramString = m.kSA;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = n.We(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label136;
      }
      paramString = paramString + "/";
    }
    label136:
    for (;;)
    {
      Iterator localIterator = this.kMl.bwi().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = m.kSu;; paramString = localm)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final m Vl(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new i());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.kMl.UR(paramString);
    if (localInputStream == null)
    {
      paramString = m.kSA;
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
        m localm = m.kSu;
        if (localObject != localm) {
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
            ((ByteBuffer)localObject).put(((a)localInputStream).cDi);
            ((ByteBuffer)localObject).rewind();
            parami.value = localObject;
            if (paramString.startsWith("/")) {
              break label461;
            }
            paramString = "/".concat(String.valueOf(paramString));
            if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty())) {
              continue;
            }
            Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
            paramString = m.kSu;
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
        Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = m.kSv;
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
        Util.qualityClose(localInputStream);
        AppMethodBeat.o(134751);
      }
      continue;
      Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: file = [%s] is illegal", new Object[] { paramString });
      paramString = parami.iterator();
      while (paramString.hasNext())
      {
        parami = (String)paramString.next();
        this.kNe.put(parami, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
    }
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134749);
    if (Vk(paramString) == m.kSu)
    {
      paramString = m.kSC;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = n.We(paramString);
    paramString = this.kMl.bwi();
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
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = m.kSu;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.kMl.UR(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((Vk(paramString) != m.kSA) || (Vj(paramString) != m.kSu)) {
          break label153;
        }
        this.kMl.bwg().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.kNe.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = m.kSu;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = m.kSA;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.kMl.bwg().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = m.kSu;
      AppMethodBeat.o(134753);
      return paramString;
    }
    catch (Exception paramFileStructStat)
    {
      for (;;)
      {
        Log.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
      }
    }
  }
  
  public final o ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (Vl(paramString) == m.kSu) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.ab.a(this.kMl, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new o(paramString);
      AppMethodBeat.o(176548);
      return paramString;
    }
    AppMethodBeat.o(176548);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134752);
    InputStream localInputStream = this.kMl.UR(paramString);
    if (localInputStream == null)
    {
      paramString = m.kSA;
      AppMethodBeat.o(134752);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(134752);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
      paramString = m.kSv;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final m h(String paramString, List<x> paramList)
  {
    AppMethodBeat.i(219306);
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
      Log.e("MicroMsg.WxaPkgFileSystem", "statDir: path = [%s] is illegal", new Object[] { paramString });
      paramString = super.h(paramString, paramList);
      AppMethodBeat.o(219306);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.kMl.bwj().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.startsWith(paramString))
      {
        x localx = new x(str1);
        String str2 = a(str1, localx).name();
        if (str2.equals(m.kSu.name())) {
          paramList.add(localx);
        } else {
          Log.w("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = m.kSu;
    AppMethodBeat.o(219306);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.kMl.bvf();
    AppMethodBeat.o(134755);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.kMl.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ab
 * JD-Core Version:    0.7.0.1
 */