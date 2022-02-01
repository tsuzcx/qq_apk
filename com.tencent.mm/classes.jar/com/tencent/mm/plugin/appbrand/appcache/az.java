package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.m;
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
import junit.framework.Assert;

public final class az
  extends com.tencent.mm.plugin.appbrand.appstorage.i
  implements IWxaFileSystemWithModularizing
{
  private final r joh;
  private Map<String, Long> joi;
  
  public az(q paramq)
  {
    AppMethodBeat.i(178529);
    this.joi = new HashMap();
    Assert.assertTrue(paramq instanceof r);
    this.joh = ((r)paramq);
    AppMethodBeat.o(178529);
  }
  
  private l Ig(String paramString)
  {
    AppMethodBeat.i(178533);
    if (!this.joh.HU(paramString))
    {
      paramString = l.jsH;
      AppMethodBeat.o(178533);
      return paramString;
    }
    paramString = l.jsB;
    AppMethodBeat.o(178533);
    return paramString;
  }
  
  public final boolean Ie(String paramString)
  {
    AppMethodBeat.i(178531);
    try
    {
      this.joh.HV(paramString);
      AppMethodBeat.o(178531);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(178531);
    }
    return false;
  }
  
  public final l If(String paramString)
  {
    AppMethodBeat.i(178532);
    l locall = Ig(paramString);
    if (locall == l.jsH)
    {
      if (paramString.length() == 0)
      {
        paramString = l.jsH;
        AppMethodBeat.o(178532);
        return paramString;
      }
      paramString = m.IY(paramString);
      if (paramString.substring(paramString.length() - 1).equals("/")) {
        break label138;
      }
      paramString = paramString + "/";
    }
    label138:
    for (;;)
    {
      Iterator localIterator = this.joh.aWs().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!bs.nullAsNil((String)localIterator.next()).startsWith(paramString));
      for (paramString = l.jsB;; paramString = locall)
      {
        AppMethodBeat.o(178532);
        return paramString;
      }
    }
  }
  
  public final l Ih(String paramString)
  {
    AppMethodBeat.i(178535);
    paramString = a(paramString, new com.tencent.mm.plugin.appbrand.z.i());
    AppMethodBeat.o(178535);
    return paramString;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178536);
    InputStream localInputStream = this.joh.HS(paramString);
    if (localInputStream == null)
    {
      paramString = l.jsH;
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
        ac.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { paramString });
      }
      catch (Exception paramString)
      {
        Object localObject;
        long l;
        int i;
        ac.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
        bs.d(localInputStream);
        paramString = l.jsC;
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
        this.joi.put("/", Long.valueOf(System.currentTimeMillis() / 1000L));
        continue;
      }
      finally
      {
        bs.d(localInputStream);
        AppMethodBeat.o(178536);
      }
      paramString = l.jsB;
      bs.d(localInputStream);
      AppMethodBeat.o(178536);
      return paramString;
      i = 0;
      continue;
      ((ByteBuffer)localObject).put(ByteBuffer.wrap(d.a(localInputStream, paramLong1, l)));
      continue;
      label376:
      this.joi.put(parami + "/", Long.valueOf(System.currentTimeMillis() / 1000L));
      continue;
      ac.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", new Object[] { parami });
    }
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(178538);
    Object localObject = this.joh.HT(paramString);
    if (localObject == null)
    {
      if (paramString.endsWith("/")) {
        if (!paramString.startsWith("/")) {
          break label143;
        }
      }
      for (;;)
      {
        if (Ig(paramString) != l.jsH) {
          break label156;
        }
        localObject = this.joh.HR(paramString);
        if (localObject == null) {
          break label156;
        }
        ((WxaPkg)localObject).aWW().fillAnother(paramFileStructStat);
        paramFileStructStat.makeItIsDir();
        paramFileStructStat.st_size = 0L;
        paramString = (Long)this.joi.get(paramString);
        if (paramString != null) {
          paramFileStructStat.st_atime = paramString.longValue();
        }
        paramString = l.jsB;
        AppMethodBeat.o(178538);
        return paramString;
        paramString = paramString + "/";
        break;
        label143:
        paramString = "/".concat(String.valueOf(paramString));
      }
      label156:
      paramString = l.jsH;
      AppMethodBeat.o(178538);
      return paramString;
    }
    ((q.a)localObject).jlW.aWW().fillAnother(paramFileStructStat);
    paramFileStructStat.st_size = ((q.a)localObject).jlZ;
    paramString = l.jsB;
    AppMethodBeat.o(178538);
    return paramString;
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(178534);
    if (Ig(paramString) == l.jsB)
    {
      paramString = l.jsJ;
      AppMethodBeat.o(178534);
      return paramString;
    }
    String str1 = m.IY(paramString);
    paramString = this.joh.aWs();
    String str2 = Pattern.quote(str1);
    Iterator localIterator = paramString.iterator();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      if (bs.nullAsNil(paramString).startsWith(str1))
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
      paramString = l.jsH;
      AppMethodBeat.o(178534);
      return paramString;
    }
    paramString = l.jsB;
    AppMethodBeat.o(178534);
    return paramString;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(178539);
    if (!paramBoolean)
    {
      if (Ih(paramString) == l.jsB) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(178539);
        return null;
      }
    }
    paramString = this.joh.HT(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(178539);
      return null;
    }
    paramString = z.a(paramString.jlW, paramString.fileName);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new e(paramString);
      AppMethodBeat.o(178539);
      return paramString;
    }
    AppMethodBeat.o(178539);
    return null;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(178537);
    InputStream localInputStream = this.joh.HS(paramString);
    if (localInputStream == null)
    {
      paramString = l.jsH;
      AppMethodBeat.o(178537);
      return paramString;
    }
    try
    {
      int i = localInputStream.available();
      bs.d(localInputStream);
      paramString = a(paramString, 0L, i, parami);
      AppMethodBeat.o(178537);
      return paramString;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", paramString, "readFile", new Object[0]);
      paramString = l.jsC;
      return paramString;
    }
    finally
    {
      bs.d(localInputStream);
      AppMethodBeat.o(178537);
    }
  }
  
  public final void initialize() {}
  
  public final WxaPkg.Info openReadPartialInfo(String paramString)
  {
    AppMethodBeat.i(178530);
    paramString = this.joh.HT(paramString);
    if (paramString != null)
    {
      paramString = paramString.aWt();
      AppMethodBeat.o(178530);
      return paramString;
    }
    AppMethodBeat.o(178530);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(178540);
    this.joh.close();
    AppMethodBeat.o(178540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.az
 * JD-Core Version:    0.7.0.1
 */