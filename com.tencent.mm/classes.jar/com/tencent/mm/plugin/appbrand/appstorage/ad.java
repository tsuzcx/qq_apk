package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
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
public final class ad
  extends j
{
  private Map<String, Long> nGY;
  public final WxaPkg nGd;
  
  static
  {
    AppMethodBeat.i(178575);
    if (!ad.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(178575);
      return;
    }
  }
  
  public ad(WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(178574);
    this.nGY = new HashMap();
    if ((!$assertionsDisabled) && (paramWxaPkg == null))
    {
      paramWxaPkg = new AssertionError();
      AppMethodBeat.o(178574);
      throw paramWxaPkg;
    }
    this.nGd = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private m acU(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.nGd.acB(paramString);
    if (paramString == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(134748);
      return paramString;
    }
    Util.qualityClose(paramString);
    paramString = m.nMR;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.nGd.acB(paramString);
    if (localInputStream == null)
    {
      paramString = m.nMX;
      AppMethodBeat.o(134751);
      return paramString;
    }
    if (paramLong2 == 9223372036854775807L) {}
    label400:
    label415:
    label468:
    for (;;)
    {
      try
      {
        paramLong2 = localInputStream.available() - paramLong1;
        Object localObject1 = h(paramLong1, paramLong2, localInputStream.available());
        Object localObject2 = m.nMR;
        if (localObject1 != localObject2) {
          return localObject1;
        }
        int i;
        if ((paramLong1 == 0L) && (paramLong2 == localInputStream.available()))
        {
          i = 1;
          if ((i != 0) && ((localInputStream instanceof a)))
          {
            localObject1 = ByteBuffer.allocateDirect(localInputStream.available());
            ((ByteBuffer)localObject1).put(((a)localInputStream).cDP);
            ((ByteBuffer)localObject1).rewind();
            parami.value = localObject1;
            if (paramString.startsWith("/")) {
              break label468;
            }
            paramString = "/".concat(String.valueOf(paramString));
            if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty())) {
              continue;
            }
            Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
            paramString = m.nMR;
            return paramString;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        localObject2 = d.a(localInputStream, paramLong1, paramLong2);
        localObject1 = ByteBuffer.allocateDirect(localObject2.length);
        ((ByteBuffer)localObject1).put(ByteBuffer.wrap((byte[])localObject2));
        continue;
        parami.add(paramString + "/");
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = m.nMS;
        AppMethodBeat.o(134751);
        return paramString;
        parami = new ArrayList();
        if (paramString.equals("")) {
          break label415;
        }
        if (paramString.endsWith("/")) {
          break label400;
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
        this.nGY.put(parami, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
      continue;
    }
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134749);
    if (acU(paramString) == m.nMR)
    {
      paramString = m.nMZ;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = o.adS(paramString);
    paramString = this.nGd.bHp();
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
      paramString = m.nMX;
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = m.nMR;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.nGd.acB(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((acU(paramString) != m.nMX) || (acT(paramString) != m.nMR)) {
          break label153;
        }
        this.nGd.bHn().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.nGY.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = m.nMR;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = m.nMX;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.nGd.bHn().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = m.nMR;
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
  
  public final boolean acS(String paramString)
  {
    return true;
  }
  
  public final m acT(String paramString)
  {
    AppMethodBeat.i(134747);
    m localm = acU(paramString);
    if (localm == m.nMX)
    {
      if (paramString.length() == 0)
      {
        paramString = m.nMX;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = o.adS(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label139;
      }
      paramString = paramString + "/";
    }
    label139:
    for (;;)
    {
      Iterator localIterator = this.nGd.bHp().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = m.nMR;; paramString = localm)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final m acV(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new i());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final q ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (acV(paramString) == m.nMR) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = ac.a(this.nGd, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new q(paramString);
      AppMethodBeat.o(176548);
      return paramString;
    }
    AppMethodBeat.o(176548);
    return null;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134752);
    InputStream localInputStream = this.nGd.acB(paramString);
    if (localInputStream == null)
    {
      paramString = m.nMX;
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
      paramString = m.nMS;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final m h(String paramString, List<z> paramList)
  {
    AppMethodBeat.i(243350);
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
      AppMethodBeat.o(243350);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.nGd.bHq().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.startsWith(paramString))
      {
        z localz = new z(str1);
        String str2 = a(str1, localz).name();
        if (str2.equals(m.nMR.name())) {
          paramList.add(localz);
        } else {
          Log.w("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = m.nMR;
    AppMethodBeat.o(243350);
    return paramString;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.nGd.bGl();
    AppMethodBeat.o(134755);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.nGd.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ad
 * JD-Core Version:    0.7.0.1
 */