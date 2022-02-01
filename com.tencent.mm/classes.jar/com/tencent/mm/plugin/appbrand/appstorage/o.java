package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.w;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  extends j
{
  private final String jPH;
  public final String jPI;
  public final String jPJ;
  public volatile long jPL;
  public final LuggageLocalFileObjectManager jQe;
  public String jQf;
  
  public o(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.jQf = "tmp";
    this.jPL = -1L;
    this.jPJ = w.B(new com.tencent.mm.vfs.k(paramString1).fTh());
    this.jPH = paramString2;
    this.jPI = paramString3;
    this.jQe = new LuggageLocalFileObjectManager(this.jPJ, this.jPH, this.jPI);
    AppMethodBeat.o(134338);
  }
  
  public final boolean LZ(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = bu.nullAsNil(paramString).startsWith(this.jPI);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final m MO(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = m.jPQ;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k MP(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.jQe.Nc(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new com.tencent.mm.vfs.k(paramString.hLr);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k MR(String paramString)
  {
    AppMethodBeat.i(134348);
    com.tencent.mm.vfs.o.aZI(this.jPJ);
    paramString = new com.tencent.mm.vfs.k(this.jPJ + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean MS(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.jQe.Nc(paramString);
    if ((paramString != null) && (paramString.jPs))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final String MY(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.jQe.Nc(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.hLr;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final m Ma(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.jQe.Nc(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.o.fB(paramString.hLr)))
    {
      paramString = m.jPS;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = m.jPM;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final m a(i<String> parami)
  {
    parami.value = this.jPJ;
    return m.jPM;
  }
  
  public final m a(com.tencent.mm.vfs.k paramk, String paramString, i<String> parami)
  {
    long l1 = 0L;
    AppMethodBeat.i(175579);
    if ((paramk == null) || (!paramk.exists()))
    {
      paramk = m.jPN;
      AppMethodBeat.o(175579);
      return paramk;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      paramk = m.jQc;
      AppMethodBeat.o(175579);
      return paramk;
    }
    if (this.jPL > 0L)
    {
      paramString = this.jQe.bci();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + paramk.length() <= this.jPL) {
          break label151;
        }
        paramk = m.jQb;
        AppMethodBeat.o(175579);
        return paramk;
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
    paramString = this.jQe.Nb(paramk.getName());
    if (paramString != null)
    {
      if (paramString.jPs)
      {
        parami.value = paramString.dsN;
        paramk = m.jPM;
        AppMethodBeat.o(175579);
        return paramk;
      }
      parami.value = this.jQe.a(paramString).dsN;
      paramk = m.jPM;
      AppMethodBeat.o(175579);
      return paramk;
    }
    paramk = this.jQe.j(w.B(paramk.fTh()), null, false);
    parami.value = this.jQe.a(paramk).dsN;
    paramk = m.jPM;
    AppMethodBeat.o(175579);
    return paramk;
  }
  
  public final m a(com.tencent.mm.vfs.k paramk, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175578);
    ae.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b]", new Object[] { paramk, paramString, Boolean.valueOf(paramBoolean) });
    paramk = this.jQe.j(w.B(paramk.fTh()), paramString, paramBoolean);
    if (paramk == null)
    {
      paramk = m.jPN;
      AppMethodBeat.o(175578);
      return paramk;
    }
    parami.value = paramk.dsN;
    paramk = m.jPM;
    AppMethodBeat.o(175578);
    return paramk;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.jQe.Nc(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.o.fB(paramString.hLr)))
    {
      paramString = m.jPS;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new com.tencent.mm.vfs.k(paramString.hLr);
    m localm = g(paramLong1, paramLong2, paramString.length());
    if (localm != m.jPM)
    {
      AppMethodBeat.o(175575);
      return localm;
    }
    long l = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      l = paramString.length() - paramLong1;
    }
    parami.value = n.a(paramString, paramLong1, l);
    paramString = m.jPM;
    AppMethodBeat.o(175575);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.jQe.Nc(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.o.fB(paramString.hLr)))
    {
      paramString = m.jPS;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.jPN;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.hLr, paramFileStructStat) == 0)
    {
      paramString = m.jPM;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = m.jPN;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.jQe.bch());
    b.c((List)localObject, this.jQe.bcj());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      y localy = (y)((Iterator)localObject).next();
      k localk = new k();
      localk.fileName = localy.dsN;
      paramString.add(localk);
    }
    parami.value = paramString;
    paramString = m.jPM;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.k ae(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = MP(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.jQe.Nc(paramString);
    if ((paramString == null) || (!com.tencent.mm.vfs.o.fB(paramString.hLr)))
    {
      paramString = m.jPS;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = n.t(new com.tencent.mm.vfs.k(paramString.hLr));
    paramString = m.jPM;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final List<y> bcd()
  {
    AppMethodBeat.i(134351);
    List localList = this.jQe.bch();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final String getRootPath()
  {
    return this.jPJ;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!com.tencent.mm.vfs.o.aZI(this.jPJ)) {
      ae.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */