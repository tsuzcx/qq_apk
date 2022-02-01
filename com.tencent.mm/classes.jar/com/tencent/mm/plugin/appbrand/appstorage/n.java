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
  public final String jMN;
  private final String jMO;
  public final String jMP;
  public final LuggageLocalFileObjectManager jMQ;
  public String jMR;
  public volatile long jMS;
  
  public n(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.jMR = "tmp";
    this.jMS = -1L;
    this.jMN = q.B(new e(paramString1).fOK());
    this.jMO = paramString2;
    this.jMP = paramString3;
    this.jMQ = new LuggageLocalFileObjectManager(this.jMN, this.jMO, this.jMP);
    AppMethodBeat.o(134338);
  }
  
  public final boolean Lw(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = bt.nullAsNil(paramString).startsWith(this.jMP);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final l Lx(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.jMQ.Mv(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.fv(paramString.hIy)))
    {
      paramString = l.jMB;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = l.jMv;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final l Mi(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = l.jMz;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final e Mj(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.jMQ.Mv(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new e(paramString.hIy);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final e Ml(String paramString)
  {
    AppMethodBeat.i(134348);
    com.tencent.mm.vfs.i.aYg(this.jMN);
    paramString = new e(this.jMN + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean Mm(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.jMQ.Mv(paramString);
    if ((paramString != null) && (paramString.jMg))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final String Ms(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.jMQ.Mv(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.hIy;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final l a(com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    parami.value = this.jMN;
    return l.jMv;
  }
  
  public final l a(e parame, String paramString, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    long l1 = 0L;
    AppMethodBeat.i(175579);
    if ((parame == null) || (!parame.exists()))
    {
      parame = l.jMw;
      AppMethodBeat.o(175579);
      return parame;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      parame = l.jML;
      AppMethodBeat.o(175579);
      return parame;
    }
    if (this.jMS > 0L)
    {
      paramString = this.jMQ.bbD();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + parame.length() <= this.jMS) {
          break label151;
        }
        parame = l.jMK;
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
    paramString = this.jMQ.Mu(parame.getName());
    if (paramString != null)
    {
      if (paramString.jMg)
      {
        parami.value = paramString.drH;
        parame = l.jMv;
        AppMethodBeat.o(175579);
        return parame;
      }
      parami.value = this.jMQ.a(paramString).drH;
      parame = l.jMv;
      AppMethodBeat.o(175579);
      return parame;
    }
    parame = this.jMQ.j(q.B(parame.fOK()), null, false);
    parami.value = this.jMQ.a(parame).drH;
    parame = l.jMv;
    AppMethodBeat.o(175579);
    return parame;
  }
  
  public final l a(e parame, String paramString, boolean paramBoolean, com.tencent.mm.plugin.appbrand.z.i<String> parami)
  {
    AppMethodBeat.i(175578);
    ad.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b]", new Object[] { parame, paramString, Boolean.valueOf(paramBoolean) });
    parame = this.jMQ.j(q.B(parame.fOK()), paramString, paramBoolean);
    if (parame == null)
    {
      parame = l.jMw;
      AppMethodBeat.o(175578);
      return parame;
    }
    parami.value = parame.drH;
    parame = l.jMv;
    AppMethodBeat.o(175578);
    return parame;
  }
  
  public final l a(String paramString, long paramLong1, long paramLong2, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.jMQ.Mv(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.fv(paramString.hIy)))
    {
      paramString = l.jMB;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new e(paramString.hIy);
    l locall = g(paramLong1, paramLong2, paramString.length());
    if (locall != l.jMv)
    {
      AppMethodBeat.o(175575);
      return locall;
    }
    long l = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      l = paramString.length() - paramLong1;
    }
    parami.value = m.a(paramString, paramLong1, l);
    paramString = l.jMv;
    AppMethodBeat.o(175575);
    return paramString;
  }
  
  public final l a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.jMQ.Mv(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.fv(paramString.hIy)))
    {
      paramString = l.jMB;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = l.jMw;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.hIy, paramFileStructStat) == 0)
    {
      paramString = l.jMv;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = l.jMw;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final l a(String paramString, com.tencent.mm.plugin.appbrand.z.i<List<j>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.jMQ.bbC());
    b.c((List)localObject, this.jMQ.bbE());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      j localj = new j();
      localj.fileName = localw.drH;
      paramString.add(localj);
    }
    parami.value = paramString;
    paramString = l.jMv;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final e ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = Mj(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final l b(String paramString, com.tencent.mm.plugin.appbrand.z.i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.jMQ.Mv(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.i.fv(paramString.hIy)))
    {
      paramString = l.jMB;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = m.t(new e(paramString.hIy));
    paramString = l.jMv;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final List<w> bbA()
  {
    AppMethodBeat.i(134351);
    List localList = this.jMQ.bbC();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final String getRootPath()
  {
    return this.jMN;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!com.tencent.mm.vfs.i.aYg(this.jMN)) {
      ad.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.n
 * JD-Core Version:    0.7.0.1
 */