package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class n
  extends i
{
  public final String jsT;
  private final String jsU;
  public final String jsV;
  public final LuggageLocalFileObjectManager jsW;
  public String jsX;
  public volatile long jsY;
  
  public n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.jsX = "tmp";
    this.jsY = -1L;
    this.jsT = q.B(new e(paramString1).fxV());
    this.jsU = paramString2;
    this.jsV = paramString3;
    this.jsW = new LuggageLocalFileObjectManager(this.jsT, this.jsU, this.jsV);
    AppMethodBeat.o(134338);
  }
  
  public final l IR(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = l.jsF;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final e IS(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.jsW.Je(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new e(paramString.hqg);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final e IU(String paramString)
  {
    AppMethodBeat.i(134348);
    com.tencent.mm.vfs.i.aSh(this.jsT);
    paramString = new e(this.jsT + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean IV(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.jsW.Je(paramString);
    if ((paramString != null) && (paramString.jsm))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final boolean Ie(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = bs.nullAsNil(paramString).startsWith(this.jsV);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final l If(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.jsW.Je(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eA(paramString.hqg)))
    {
      paramString = l.jsH;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = l.jsB;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final String Jb(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.jsW.Je(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.hqg;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final l a(com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    parami.value = this.jsT;
    return l.jsB;
  }
  
  public final l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    long l1 = 0L;
    AppMethodBeat.i(175579);
    if ((parame == null) || (!parame.exists()))
    {
      parame = l.jsC;
      AppMethodBeat.o(175579);
      return parame;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      parame = l.jsR;
      AppMethodBeat.o(175579);
      return parame;
    }
    if (this.jsY > 0L)
    {
      paramString = this.jsW.aYf();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + parame.length() <= this.jsY) {
          break label151;
        }
        parame = l.jsQ;
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
    paramString = this.jsW.Jd(parame.getName());
    if (paramString != null)
    {
      if (paramString.jsm)
      {
        parami.value = paramString.dgl;
        parame = l.jsB;
        AppMethodBeat.o(175579);
        return parame;
      }
      parami.value = this.jsW.a(paramString).dgl;
      parame = l.jsB;
      AppMethodBeat.o(175579);
      return parame;
    }
    parame = this.jsW.j(q.B(parame.fxV()), null, false);
    parami.value = this.jsW.a(parame).dgl;
    parame = l.jsB;
    AppMethodBeat.o(175579);
    return parame;
  }
  
  public final l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    AppMethodBeat.i(175578);
    ac.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b]", new Object[] { parame, paramString, Boolean.valueOf(paramBoolean) });
    parame = this.jsW.j(q.B(parame.fxV()), paramString, paramBoolean);
    if (parame == null)
    {
      parame = l.jsC;
      AppMethodBeat.o(175578);
      return parame;
    }
    parami.value = parame.dgl;
    parame = l.jsB;
    AppMethodBeat.o(175578);
    return parame;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.jsW.Je(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eA(paramString.hqg)))
    {
      paramString = l.jsH;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new e(paramString.hqg);
    l locall = g(paramLong1, paramLong2, paramString.length());
    if (locall != l.jsB)
    {
      AppMethodBeat.o(175575);
      return locall;
    }
    long l = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      l = paramString.length() - paramLong1;
    }
    parami.value = m.a(paramString, paramLong1, l);
    paramString = l.jsB;
    AppMethodBeat.o(175575);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.jsW.Je(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eA(paramString.hqg)))
    {
      paramString = l.jsH;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = l.jsC;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.hqg, paramFileStructStat) == 0)
    {
      paramString = l.jsB;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = l.jsC;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.jsW.aYe());
    b.c((List)localObject, this.jsW.aYg());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      j localj = new j();
      localj.fileName = localw.dgl;
      paramString.add(localj);
    }
    parami.value = paramString;
    paramString = l.jsB;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final List<w> aYc()
  {
    AppMethodBeat.i(134351);
    List localList = this.jsW.aYe();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = IS(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.jsW.Je(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.eA(paramString.hqg)))
    {
      paramString = l.jsH;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = m.t(new e(paramString.hqg));
    paramString = l.jsB;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final String getRootPath()
  {
    return this.jsT;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!com.tencent.mm.vfs.i.aSh(this.jsT)) {
      ac.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */