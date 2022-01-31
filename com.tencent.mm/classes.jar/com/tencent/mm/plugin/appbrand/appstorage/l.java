package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.g.c;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class l
  extends g
{
  public final String gZQ;
  private final String gZR;
  private final String gZS;
  public final LuggageLocalFileObjectManager gZT;
  public volatile long gZU;
  
  public l(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(105374);
    this.gZU = -1L;
    this.gZQ = new File(paramString1).getAbsolutePath();
    this.gZR = paramString2;
    this.gZS = paramString3;
    this.gZT = new LuggageLocalFileObjectManager(this.gZQ, this.gZR, this.gZS);
    AppMethodBeat.o(105374);
  }
  
  public final j a(com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    paramj.value = this.gZQ;
    return j.gZA;
  }
  
  public final j a(File paramFile, String paramString, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    long l1 = 0L;
    AppMethodBeat.i(105386);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      paramFile = j.gZB;
      AppMethodBeat.o(105386);
      return paramFile;
    }
    if ((!TextUtils.isEmpty(paramString)) || (paramj == null))
    {
      paramFile = j.gZO;
      AppMethodBeat.o(105386);
      return paramFile;
    }
    if (this.gZU > 0L)
    {
      paramString = this.gZT.awL();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + paramFile.length() <= this.gZU) {
          break label151;
        }
        paramFile = j.gZN;
        AppMethodBeat.o(105386);
        return paramFile;
      }
      int j = paramString.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 += paramString[i].length();
        i += 1;
      }
    }
    label151:
    paramString = this.gZT.zo(paramFile.getName());
    if (paramString != null)
    {
      if (paramString.gZm)
      {
        paramj.value = paramString.ctV;
        paramFile = j.gZA;
        AppMethodBeat.o(105386);
        return paramFile;
      }
      paramj.value = this.gZT.a(paramString).ctV;
      paramFile = j.gZA;
      AppMethodBeat.o(105386);
      return paramFile;
    }
    paramFile = this.gZT.k(paramFile.getAbsolutePath(), null, false);
    paramj.value = this.gZT.a(paramFile).ctV;
    paramFile = j.gZA;
    AppMethodBeat.o(105386);
    return paramFile;
  }
  
  public final j a(File paramFile, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.s.j<String> paramj)
  {
    AppMethodBeat.i(105385);
    paramFile = this.gZT.k(paramFile.getAbsolutePath(), paramString, paramBoolean);
    if (paramFile == null)
    {
      paramFile = j.gZB;
      AppMethodBeat.o(105385);
      return paramFile;
    }
    paramj.value = paramFile.ctV;
    paramFile = j.gZA;
    AppMethodBeat.o(105385);
    return paramFile;
  }
  
  public final j a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(105378);
    paramString = this.gZT.zp(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.cN(paramString.fod)))
    {
      paramString = j.gZG;
      AppMethodBeat.o(105378);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = j.gZB;
      AppMethodBeat.o(105378);
      return paramString;
    }
    if (FileStat.stat(paramString.fod, paramFileStructStat) == 0)
    {
      paramString = j.gZA;
      AppMethodBeat.o(105378);
      return paramString;
    }
    paramString = j.gZB;
    AppMethodBeat.o(105378);
    return paramString;
  }
  
  public final j a(String paramString, com.tencent.mm.plugin.appbrand.s.j<List<h>> paramj)
  {
    AppMethodBeat.i(105379);
    Object localObject = new LinkedList();
    c.c((List)localObject, this.gZT.awK());
    c.c((List)localObject, this.gZT.awM());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      v localv = (v)((Iterator)localObject).next();
      h localh = new h();
      localh.fileName = localv.ctV;
      paramString.add(localh);
    }
    paramj.value = paramString;
    paramString = j.gZA;
    AppMethodBeat.o(105379);
    return paramString;
  }
  
  public final File aa(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(105380);
    paramString = zg(paramString);
    AppMethodBeat.o(105380);
    return paramString;
  }
  
  public final List<v> awJ()
  {
    AppMethodBeat.i(105387);
    List localList = this.gZT.awK();
    AppMethodBeat.o(105387);
    return localList;
  }
  
  public final j b(String paramString, com.tencent.mm.plugin.appbrand.s.j<ByteBuffer> paramj)
  {
    AppMethodBeat.i(105377);
    paramString = this.gZT.zp(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.cN(paramString.fod)))
    {
      paramString = j.gZG;
      AppMethodBeat.o(105377);
      return paramString;
    }
    paramj.value = k.A(new File(paramString.fod));
    paramString = j.gZA;
    AppMethodBeat.o(105377);
    return paramString;
  }
  
  public final boolean bL(String paramString)
  {
    AppMethodBeat.i(105375);
    boolean bool = bo.nullAsNil(paramString).startsWith(this.gZS);
    AppMethodBeat.o(105375);
    return bool;
  }
  
  public final String getRootPath()
  {
    return this.gZQ;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(105383);
    if (!com.tencent.mm.vfs.e.um(this.gZQ)) {
      d.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(105383);
  }
  
  public final j zd(String paramString)
  {
    AppMethodBeat.i(105376);
    paramString = this.gZT.zp(paramString);
    if ((paramString == null) || (!com.tencent.mm.a.e.cN(paramString.fod)))
    {
      paramString = j.gZG;
      AppMethodBeat.o(105376);
      return paramString;
    }
    paramString = j.gZA;
    AppMethodBeat.o(105376);
    return paramString;
  }
  
  public final j zf(String paramString)
  {
    AppMethodBeat.i(105389);
    v localv = this.gZT.zp(paramString);
    if (localv != null)
    {
      com.tencent.mm.vfs.e.deleteFile(localv.fod);
      if (com.tencent.mm.vfs.e.cN(localv.fod))
      {
        d.e("MicroMsg.Luggage.FlattenFileSystem", "delete file failed, id %s, path %s", new Object[] { paramString, localv.fod });
        paramString = j.gZB;
        AppMethodBeat.o(105389);
        return paramString;
      }
    }
    paramString = j.gZA;
    AppMethodBeat.o(105389);
    return paramString;
  }
  
  public final File zg(String paramString)
  {
    AppMethodBeat.i(105381);
    paramString = this.gZT.zp(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105381);
      return null;
    }
    paramString = new File(paramString.fod);
    AppMethodBeat.o(105381);
    return paramString;
  }
  
  public final b zh(String paramString)
  {
    AppMethodBeat.i(105384);
    com.tencent.mm.vfs.e.um(this.gZQ);
    paramString = new b(this.gZQ + "/" + paramString);
    AppMethodBeat.o(105384);
    return paramString;
  }
  
  public final boolean zi(String paramString)
  {
    AppMethodBeat.i(105388);
    paramString = this.gZT.zp(paramString);
    if ((paramString != null) && (paramString.gZm))
    {
      AppMethodBeat.o(105388);
      return true;
    }
    AppMethodBeat.o(105388);
    return false;
  }
  
  public final String zm(String paramString)
  {
    AppMethodBeat.i(105382);
    paramString = this.gZT.zp(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(105382);
      return null;
    }
    paramString = paramString.fod;
    AppMethodBeat.o(105382);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */