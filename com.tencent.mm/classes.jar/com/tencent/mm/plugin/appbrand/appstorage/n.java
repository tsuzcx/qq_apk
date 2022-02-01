package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class n
  extends i
{
  public final String iSI;
  private final String iSJ;
  public final String iSK;
  public final LuggageLocalFileObjectManager iSL;
  public String iSM;
  public volatile long iSN;
  
  public n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.iSM = "tmp";
    this.iSN = -1L;
    this.iSI = q.B(new e(paramString1).fhU());
    this.iSJ = paramString2;
    this.iSK = paramString3;
    this.iSL = new LuggageLocalFileObjectManager(this.iSI, this.iSJ, this.iSK);
    AppMethodBeat.o(134338);
  }
  
  public final l EO(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = l.iSu;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final e EP(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.iSL.Fb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new e(paramString.gPG);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final e ER(String paramString)
  {
    AppMethodBeat.i(134348);
    com.tencent.mm.vfs.i.aMF(this.iSI);
    paramString = new e(this.iSI + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean ES(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.iSL.Fb(paramString);
    if ((paramString != null) && (paramString.iSb))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final String EY(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.iSL.Fb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.gPG;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final boolean Eb(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = bt.nullAsNil(paramString).startsWith(this.iSK);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final l Ec(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.iSL.Fb(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eK(paramString.gPG)))
    {
      paramString = l.iSw;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = l.iSq;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final l a(com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    parami.value = this.iSI;
    return l.iSq;
  }
  
  public final l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    long l1 = 0L;
    AppMethodBeat.i(175579);
    if ((parame == null) || (!parame.exists()))
    {
      parame = l.iSr;
      AppMethodBeat.o(175579);
      return parame;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      parame = l.iSG;
      AppMethodBeat.o(175579);
      return parame;
    }
    if (this.iSN > 0L)
    {
      paramString = this.iSL.aRk();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + parame.length() <= this.iSN) {
          break label151;
        }
        parame = l.iSF;
        AppMethodBeat.o(175579);
        return parame;
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
    paramString = this.iSL.Fa(parame.getName());
    if (paramString != null)
    {
      if (paramString.iSb)
      {
        parami.value = paramString.diQ;
        parame = l.iSq;
        AppMethodBeat.o(175579);
        return parame;
      }
      parami.value = this.iSL.a(paramString).diQ;
      parame = l.iSq;
      AppMethodBeat.o(175579);
      return parame;
    }
    parame = this.iSL.j(q.B(parame.fhU()), null, false);
    parami.value = this.iSL.a(parame).diQ;
    parame = l.iSq;
    AppMethodBeat.o(175579);
    return parame;
  }
  
  public final l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.aa.i<String> parami)
  {
    AppMethodBeat.i(175578);
    ad.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b]", new Object[] { parame, paramString, Boolean.valueOf(paramBoolean) });
    parame = this.iSL.j(q.B(parame.fhU()), paramString, paramBoolean);
    if (parame == null)
    {
      parame = l.iSr;
      AppMethodBeat.o(175578);
      return parame;
    }
    parami.value = parame.diQ;
    parame = l.iSq;
    AppMethodBeat.o(175578);
    return parame;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.iSL.Fb(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eK(paramString.gPG)))
    {
      paramString = l.iSw;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new e(paramString.gPG);
    l locall = f(paramLong1, paramLong2, paramString.length());
    if (locall != l.iSq)
    {
      AppMethodBeat.o(175575);
      return locall;
    }
    long l = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      l = paramString.length() - paramLong1;
    }
    parami.value = m.a(paramString, paramLong1, l);
    paramString = l.iSq;
    AppMethodBeat.o(175575);
    return paramString;
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.aa.i<List<j>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.iSL.aRj());
    b.c((List)localObject, this.iSL.aRl());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      j localj = new j();
      localj.fileName = localw.diQ;
      paramString.add(localj);
    }
    parami.value = paramString;
    paramString = l.iSq;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.iSL.Fb(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eK(paramString.gPG)))
    {
      paramString = l.iSw;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = l.iSr;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.gPG, paramFileStructStat) == 0)
    {
      paramString = l.iSq;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = l.iSr;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final List<w> aRh()
  {
    AppMethodBeat.i(134351);
    List localList = this.iSL.aRj();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final e ad(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = EP(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.aa.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.iSL.Fb(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eK(paramString.gPG)))
    {
      paramString = l.iSw;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = m.t(new e(paramString.gPG));
    paramString = l.iSq;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final String getRootPath()
  {
    return this.iSI;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!com.tencent.mm.vfs.i.aMF(this.iSI)) {
      ad.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */