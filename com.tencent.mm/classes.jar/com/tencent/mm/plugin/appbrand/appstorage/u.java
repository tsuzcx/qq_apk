package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.l.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class u
  extends o
{
  private volatile boolean IY;
  private final String qMG;
  public final String qMH;
  public final String qMI;
  public volatile long qMK;
  public final LuggageLocalFileObjectManager qNd;
  public y qNe;
  public String qNf;
  
  public u(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.IY = false;
    this.qNe = null;
    this.qNf = "tmp";
    this.qMK = -1L;
    this.qMI = ah.v(new com.tencent.mm.vfs.u(paramString1).jKT());
    this.qMG = paramString2;
    this.qMH = paramString3;
    this.qNd = new LuggageLocalFileObjectManager(this.qMI, this.qMG, this.qMH);
    AppMethodBeat.o(134338);
  }
  
  public final boolean Vq(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.qMH);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final r Vr(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.y.ZC(paramString.onG)))
    {
      paramString = r.qMR;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = r.qML;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final r Wl(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = r.qMP;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.u Wm(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.qNd.WA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new com.tencent.mm.vfs.u(paramString.onG);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.u Wo(String paramString)
  {
    AppMethodBeat.i(134348);
    com.tencent.mm.vfs.y.bDX(this.qMI);
    paramString = new com.tencent.mm.vfs.u(this.qMI + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean Wp(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.qNd.WA(paramString);
    if ((paramString != null) && (paramString.qMj))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final boolean Wq(String paramString)
  {
    AppMethodBeat.i(323293);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!paramString.qMj))
    {
      AppMethodBeat.o(323293);
      return false;
    }
    boolean bool = new com.tencent.mm.vfs.u(paramString.onG).diJ();
    if (this.qNe != null) {
      this.qNe.c(paramString.onG, -paramString.fileLength, "FlattenFileSystem#removeSavedFile");
    }
    AppMethodBeat.o(323293);
    return bool;
  }
  
  public final InputStream Wr(String paramString)
  {
    AppMethodBeat.i(323295);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.y.ZC(paramString.onG)))
    {
      AppMethodBeat.o(323295);
      return null;
    }
    try
    {
      paramString = com.tencent.mm.vfs.y.Lh(paramString.onG);
      AppMethodBeat.o(323295);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      AppMethodBeat.o(323295);
    }
    return null;
  }
  
  public final String Ww(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.qNd.WA(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.onG;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final r a(k<String> paramk)
  {
    paramk.value = this.qMI;
    return r.qML;
  }
  
  public final r a(com.tencent.mm.vfs.u paramu, String paramString, k<String> paramk)
  {
    AppMethodBeat.i(175579);
    if ((paramu == null) || (!paramu.jKS()))
    {
      paramu = r.qMM;
      AppMethodBeat.o(175579);
      return paramu;
    }
    if ((!TextUtils.isEmpty(paramString)) || (paramk == null))
    {
      paramu = r.qNb;
      AppMethodBeat.o(175579);
      return paramu;
    }
    if (this.qMK > 0L)
    {
      if (this.qNe != null)
      {
        long l2 = this.qNe.df(this.qMI, ah.v(paramu.jKT())) + paramu.length();
        Log.i("MicroMsg.Luggage.FlattenFileSystem", "saveFile: WxaStorageSpaceStatisticsService getDirTotalSize=" + (l2 - paramu.length()));
        l1 = l2;
        if (l2 != -1L) {}
      }
      else
      {
        l1 = this.qNd.cis() + paramu.length();
      }
      if (l1 > this.qMK)
      {
        paramu = r.qNa;
        AppMethodBeat.o(175579);
        return paramu;
      }
    }
    paramString = this.qNd.Wz(paramu.getName());
    if (paramString != null)
    {
      if (paramString.qMj)
      {
        paramk.value = paramString.hHB;
        paramu = r.qML;
        AppMethodBeat.o(175579);
        return paramu;
      }
      l1 = paramString.fileLength;
      paramu = this.qNd.a(paramString);
      paramk.value = paramu.hHB;
      if (this.qNe != null)
      {
        this.qNe.c(paramString.onG, new com.tencent.mm.vfs.u(paramString.onG).length() - l1, "FlattenFileSystem#saveFile");
        this.qNe.c(paramu.onG, new com.tencent.mm.vfs.u(paramu.onG).length(), "FlattenFileSystem#saveFile");
      }
      paramu = r.qML;
      AppMethodBeat.o(175579);
      return paramu;
    }
    paramu = this.qNd.n(ah.v(paramu.jKT()), null, false);
    long l1 = paramu.fileLength;
    paramString = this.qNd.a(paramu);
    paramk.value = paramString.hHB;
    if (this.qNe != null)
    {
      this.qNe.c(paramu.onG, new com.tencent.mm.vfs.u(paramu.onG).length() - l1, "FlattenFileSystem#saveFile");
      this.qNe.c(paramString.onG, new com.tencent.mm.vfs.u(paramString.onG).length(), "FlattenFileSystem#saveFile");
    }
    paramu = r.qML;
    AppMethodBeat.o(175579);
    return paramu;
  }
  
  public final r a(com.tencent.mm.vfs.u paramu, String paramString, boolean paramBoolean, k<String> paramk)
  {
    AppMethodBeat.i(175578);
    Log.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b] released[%b]", new Object[] { paramu, paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.IY) });
    if (this.IY)
    {
      paramu = r.qMN;
      AppMethodBeat.o(175578);
      return paramu;
    }
    paramu = this.qNd.n(ah.v(paramu.jKT()), paramString, paramBoolean);
    if (paramu == null)
    {
      paramu = r.qMM;
      AppMethodBeat.o(175578);
      return paramu;
    }
    if (this.qNe != null) {
      this.qNe.a(this.qMI, paramu.onG, paramu.fileLength, "FlattenFileSystem#createTempFileFrom");
    }
    paramk.value = paramu.hHB;
    paramu = r.qML;
    AppMethodBeat.o(175578);
    return paramu;
  }
  
  public final r a(String paramString, long paramLong1, long paramLong2, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(175575);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.y.ZC(paramString.onG)))
    {
      paramString = r.qMR;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new com.tencent.mm.vfs.u(paramString.onG);
    if (paramLong2 == 9223372036854775807L) {
      paramLong2 = paramString.length() - paramLong1;
    }
    for (;;)
    {
      r localr = h(paramLong1, paramLong2, paramString.length());
      if (localr != r.qML)
      {
        AppMethodBeat.o(175575);
        return localr;
      }
      paramk.value = t.a(paramString, paramLong1, paramLong2);
      paramString = r.qML;
      AppMethodBeat.o(175575);
      return paramString;
    }
  }
  
  public final r a(String paramString, k<List<p>> paramk)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.h((List)localObject, this.qNd.cip());
    b.h((List)localObject, this.qNd.cir());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ae localae = (ae)((Iterator)localObject).next();
      p localp = new p();
      localp.fileName = localae.hHB;
      paramString.add(localp);
    }
    paramk.value = paramString;
    paramString = r.qML;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final r a(String paramString1, k<Map<String, ByteBuffer>> paramk, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(323294);
    paramString1 = this.qNd.WA(paramString1);
    if ((paramString1 == null) || (!com.tencent.mm.vfs.y.ZC(paramString1.onG)))
    {
      paramString1 = r.qMR;
      AppMethodBeat.o(323294);
      return paramString1;
    }
    paramString1 = t.a(paramString1.onG, paramk, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(323294);
    return paramString1;
  }
  
  public final r a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.y.ZC(paramString.onG)))
    {
      paramString = r.qMR;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = r.qMM;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.onG, paramFileStructStat) == 0)
    {
      paramString = r.qML;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = r.qMM;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.u ao(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = Wm(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final r b(String paramString, k<ByteBuffer> paramk)
  {
    AppMethodBeat.i(134341);
    paramString = this.qNd.WA(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.y.ZC(paramString.onG)))
    {
      paramString = r.qMR;
      AppMethodBeat.o(134341);
      return paramString;
    }
    paramk.value = t.s(new com.tencent.mm.vfs.u(paramString.onG));
    paramString = r.qML;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final List<ae> cil()
  {
    AppMethodBeat.i(134351);
    List localList = this.qNd.cip();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final y cim()
  {
    return this.qNe;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!com.tencent.mm.vfs.y.bDX(this.qMI)) {
      Log.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
  
  public final void release()
  {
    AppMethodBeat.i(323274);
    super.release();
    this.IY = true;
    AppMethodBeat.o(323274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.u
 * JD-Core Version:    0.7.0.1
 */