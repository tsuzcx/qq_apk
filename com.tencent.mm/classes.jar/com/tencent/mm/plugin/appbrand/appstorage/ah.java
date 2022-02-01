package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
public final class ah
  extends o
{
  private Map<String, Long> qEq;
  private final WxaPkg qOe;
  
  static
  {
    AppMethodBeat.i(178575);
    if (!ah.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(178575);
      return;
    }
  }
  
  public ah(WxaPkg paramWxaPkg)
  {
    AppMethodBeat.i(178574);
    this.qEq = new HashMap();
    this.qOe = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private r Vs(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.qOe.Va(paramString);
    if (paramString == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(134748);
      return paramString;
    }
    Util.qualityClose(paramString);
    paramString = r.qML;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final boolean Vq(String paramString)
  {
    return true;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(134747);
    r localr = Vs(paramString);
    if (localr == r.qMR)
    {
      if (paramString.length() == 0)
      {
        paramString = r.qMR;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = t.as(paramString, true);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label137;
      }
      paramString = paramString + "/";
    }
    label137:
    for (;;)
    {
      Iterator localIterator = this.qOe.cgL().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = r.qML;; paramString = localr)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final r Vt(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new k());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.qOe.Va(paramString);
    if (localInputStream == null)
    {
      paramString = r.qMR;
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
        Object localObject2 = r.qML;
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
            ((ByteBuffer)localObject1).put(((a)localInputStream).ewT);
            ((ByteBuffer)localObject1).rewind();
            paramk.value = localObject1;
            if (paramString.startsWith("/")) {
              break label468;
            }
            paramString = "/".concat(String.valueOf(paramString));
            if ((!paramString.contains("\\")) && (!paramString.trim().isEmpty())) {
              continue;
            }
            Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
            paramString = r.qML;
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
        paramk.add(paramString + "/");
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        Util.qualityClose(localInputStream);
        paramString = r.qMM;
        AppMethodBeat.o(134751);
        return paramString;
        paramk = new ArrayList();
        if (paramString.equals("")) {
          break label415;
        }
        if (paramString.endsWith("/")) {
          break label400;
        }
        paramString = paramString.substring(0, paramString.lastIndexOf("/"));
        if (paramString.equals(""))
        {
          paramk.add("/");
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
      paramString = paramk.iterator();
      while (paramString.hasNext())
      {
        paramk = (String)paramString.next();
        this.qEq.put(paramk, Long.valueOf(System.currentTimeMillis() / 1000L));
      }
      continue;
    }
  }
  
  public final r a(String paramString, k<List<p>> paramk)
  {
    AppMethodBeat.i(134749);
    if (Vs(paramString) == r.qML)
    {
      paramString = r.qMT;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = t.as(paramString, true);
    paramString = this.qOe.cgL();
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
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = r.qML;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.qOe.Va(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((Vs(paramString) != r.qMR) || (Vr(paramString) != r.qML)) {
          break label153;
        }
        this.qOe.cgK().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.qEq.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = r.qML;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = r.qMR;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.qOe.cgK().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = r.qML;
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
  
  public final u ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (Vt(paramString) == r.qML) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.ad.a(this.qOe, paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new u(paramString);
      AppMethodBeat.o(176548);
      return paramString;
    }
    AppMethodBeat.o(176548);
    return null;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134752);
    InputStream localInputStream = this.qOe.Va(paramString);
    if (localInputStream == null)
    {
      paramString = r.qMR;
      AppMethodBeat.o(134752);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      Util.qualityClose(localInputStream);
      paramString = a(paramString, 0L, i, paramk);
      AppMethodBeat.o(134752);
      return paramString;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
      paramString = r.qMM;
      return paramString;
    }
    finally
    {
      Util.qualityClose(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.qOe.cfK();
    AppMethodBeat.o(134755);
  }
  
  public final r j(String paramString, List<ad> paramList)
  {
    AppMethodBeat.i(323185);
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
      paramString = super.j(paramString, paramList);
      AppMethodBeat.o(323185);
      return paramString;
      paramString = paramString + "/";
      break;
      label97:
      paramString = "/".concat(String.valueOf(paramString));
    }
    label110:
    Iterator localIterator = this.qOe.cgM().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (str1.startsWith(paramString))
      {
        ad localad = new ad(str1);
        String str2 = a(str1, localad).name();
        if (str2.equals(r.qML.name())) {
          paramList.add(localad);
        } else {
          Log.w("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", new Object[] { str1, str2 });
        }
      }
    }
    paramString = r.qML;
    AppMethodBeat.o(323185);
    return paramString;
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.qOe.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.ah
 * JD-Core Version:    0.7.0.1
 */