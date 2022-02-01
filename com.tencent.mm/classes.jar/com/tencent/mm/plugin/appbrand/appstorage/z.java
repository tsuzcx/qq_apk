package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  public final WxaPkg jnp;
  private Map<String, Long> joi;
  
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
    this.joi = new HashMap();
    if ((!$assertionsDisabled) && (paramWxaPkg == null))
    {
      paramWxaPkg = new AssertionError();
      AppMethodBeat.o(178574);
      throw paramWxaPkg;
    }
    this.jnp = paramWxaPkg;
    AppMethodBeat.o(178574);
  }
  
  private l Ig(String paramString)
  {
    AppMethodBeat.i(134748);
    paramString = this.jnp.HP(paramString);
    if (paramString == null)
    {
      paramString = l.jsH;
      AppMethodBeat.o(134748);
      return paramString;
    }
    bs.d(paramString);
    paramString = l.jsB;
    AppMethodBeat.o(134748);
    return paramString;
  }
  
  public final boolean Ie(String paramString)
  {
    return true;
  }
  
  public final l If(String paramString)
  {
    AppMethodBeat.i(134747);
    l locall = Ig(paramString);
    if (locall == l.jsH)
    {
      if (paramString.length() == 0)
      {
        paramString = l.jsH;
        AppMethodBeat.o(134747);
        return paramString;
      }
      paramString = m.IY(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label136;
      }
      paramString = paramString + "/";
    }
    label136:
    for (;;)
    {
      Iterator localIterator = this.jnp.aWY().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((WxaPkg.Info)localIterator.next()).fileName.startsWith(paramString));
      for (paramString = l.jsB;; paramString = locall)
      {
        AppMethodBeat.o(134747);
        return paramString;
      }
    }
  }
  
  public final l Ih(String paramString)
  {
    AppMethodBeat.i(134750);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.z.i());
    AppMethodBeat.o(134750);
    return paramString;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134751);
    InputStream localInputStream = this.jnp.HP(paramString);
    if (localInputStream == null)
    {
      paramString = l.jsH;
      AppMethodBeat.o(134751);
      return paramString;
    }
    label417:
    label436:
    for (;;)
    {
      try
      {
        localObject = g(paramLong1, paramLong2, localInputStream.available());
        l locall = l.jsB;
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
        ((ByteBuffer)localObject).put(((a)localInputStream).cfX);
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
        ac.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        ac.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
        bs.d(localInputStream);
        paramString = l.jsC;
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
        this.joi.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        bs.d(localInputStream);
        AppMethodBeat.o(134751);
      }
      paramString = l.jsB;
      bs.d(localInputStream);
      AppMethodBeat.o(134751);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label374:
      this.joi.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      ac.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134753);
    InputStream localInputStream = this.jnp.HP(paramString);
    if (localInputStream == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label140;
        }
      }
      for (;;)
      {
        if ((Ig(paramString) != l.jsH) || (If(paramString) != l.jsB)) {
          break label153;
        }
        this.jnp.aWW().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.joi.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = l.jsB;
        AppMethodBeat.o(134753);
        return paramString;
        paramString = paramString + "/";
        break;
        label140:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label153:
      paramString = l.jsH;
      AppMethodBeat.o(134753);
      return paramString;
    }
    this.jnp.aWW().fillAnother(paramFileStructStat);
    try
    {
      paramFileStructStat.st_size = localInputStream.available();
      bs.d(localInputStream);
      paramString = l.jsB;
      AppMethodBeat.o(134753);
      return paramString;
    }
    catch (Exception paramFileStructStat)
    {
      for (;;)
      {
        ac.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", new Object[] { paramString });
      }
    }
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(134749);
    if (Ig(paramString) == l.jsB)
    {
      paramString = l.jsJ;
      AppMethodBeat.o(134749);
      return paramString;
    }
    String str1 = m.IY(paramString);
    paramString = this.jnp.aWY();
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
      paramString = l.jsH;
      AppMethodBeat.o(134749);
      return paramString;
    }
    paramString = l.jsB;
    AppMethodBeat.o(134749);
    return paramString;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(176548);
    if (!paramBoolean)
    {
      if (Ih(paramString) == l.jsB) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(176548);
        return null;
      }
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.z.a(this.jnp, paramString);
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
    InputStream localInputStream = this.jnp.HP(paramString);
    if (localInputStream == null)
    {
      paramString = l.jsH;
      AppMethodBeat.o(134752);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      bs.d(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(134752);
      return paramString;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("MicroMsg.WxaPkgFileSystem", paramString, "readFile", new Object[0]);
      paramString = l.jsC;
      return paramString;
    }
    finally
    {
      bs.d(localInputStream);
      AppMethodBeat.o(134752);
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134755);
    this.jnp.aVW();
    AppMethodBeat.o(134755);
  }
  
  public final void release()
  {
    AppMethodBeat.i(134756);
    this.jnp.close();
    AppMethodBeat.o(134756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.z
 * JD-Core Version:    0.7.0.1
 */