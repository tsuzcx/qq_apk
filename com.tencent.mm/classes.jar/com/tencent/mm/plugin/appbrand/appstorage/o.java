package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class o
  extends j
{
  private volatile boolean kSM;
  public final LuggageLocalFileObjectManager kSN;
  public String kSO;
  private final String kSp;
  public final String kSq;
  public final String kSr;
  public volatile long kSt;
  
  public o(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.kSM = false;
    this.kSO = "tmp";
    this.kSt = -1L;
    this.kSr = aa.z(new com.tencent.mm.vfs.o(paramString1).her());
    this.kSp = paramString2;
    this.kSq = paramString3;
    this.kSN = new LuggageLocalFileObjectManager(this.kSr, this.kSp, this.kSq);
    AppMethodBeat.o(134338);
  }
  
  public final m VX(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = m.kSy;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.o VY(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.kSN.Wl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new com.tencent.mm.vfs.o(paramString.iGf);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final boolean Vi(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.kSq);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final m Vj(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.kSN.Wl(paramString);
    if ((paramString == null) || (!s.YS(paramString.iGf)))
    {
      paramString = m.kSA;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = m.kSu;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.o Wa(String paramString)
  {
    AppMethodBeat.i(134348);
    s.boN(this.kSr);
    paramString = new com.tencent.mm.vfs.o(this.kSr + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean Wb(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.kSN.Wl(paramString);
    if ((paramString != null) && (paramString.kSa))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final String Wh(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.kSN.Wl(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.iGf;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final m a(i<String> parami)
  {
    parami.value = this.kSr;
    return m.kSu;
  }
  
  public final m a(com.tencent.mm.vfs.o paramo, String paramString, i<String> parami)
  {
    long l1 = 0L;
    AppMethodBeat.i(175579);
    if ((paramo == null) || (!paramo.exists()))
    {
      paramo = m.kSv;
      AppMethodBeat.o(175579);
      return paramo;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      paramo = m.kSK;
      AppMethodBeat.o(175579);
      return paramo;
    }
    if (this.kSt > 0L)
    {
      paramString = this.kSN.bxx();
      long l2 = l1;
      if (paramString != null)
      {
        if (paramString.length <= 0) {
          l2 = l1;
        }
      }
      else
      {
        if (l2 + paramo.length() <= this.kSt) {
          break label151;
        }
        paramo = m.kSJ;
        AppMethodBeat.o(175579);
        return paramo;
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
    paramString = this.kSN.Wk(paramo.getName());
    if (paramString != null)
    {
      if (paramString.kSa)
      {
        parami.value = paramString.dJX;
        paramo = m.kSu;
        AppMethodBeat.o(175579);
        return paramo;
      }
      parami.value = this.kSN.a(paramString).dJX;
      paramo = m.kSu;
      AppMethodBeat.o(175579);
      return paramo;
    }
    paramo = this.kSN.j(aa.z(paramo.her()), null, false);
    parami.value = this.kSN.a(paramo).dJX;
    paramo = m.kSu;
    AppMethodBeat.o(175579);
    return paramo;
  }
  
  public final m a(com.tencent.mm.vfs.o paramo, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175578);
    Log.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b] released[%b]", new Object[] { paramo, paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.kSM) });
    if (this.kSM)
    {
      paramo = m.kSw;
      AppMethodBeat.o(175578);
      return paramo;
    }
    paramo = this.kSN.j(aa.z(paramo.her()), paramString, paramBoolean);
    if (paramo == null)
    {
      paramo = m.kSv;
      AppMethodBeat.o(175578);
      return paramo;
    }
    parami.value = paramo.dJX;
    paramo = m.kSu;
    AppMethodBeat.o(175578);
    return paramo;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.kSN.Wl(paramString);
    if ((paramString == null) || (!s.YS(paramString.iGf)))
    {
      paramString = m.kSA;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new com.tencent.mm.vfs.o(paramString.iGf);
    m localm = g(paramLong1, paramLong2, paramString.length());
    if (localm != m.kSu)
    {
      AppMethodBeat.o(175575);
      return localm;
    }
    long l = paramLong2;
    if (paramLong2 == 9223372036854775807L) {
      l = paramString.length() - paramLong1;
    }
    parami.value = n.a(paramString, paramLong1, l);
    paramString = m.kSu;
    AppMethodBeat.o(175575);
    return paramString;
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.kSN.bxw());
    b.c((List)localObject, this.kSN.bxy());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      y localy = (y)((Iterator)localObject).next();
      k localk = new k();
      localk.fileName = localy.dJX;
      paramString.add(localk);
    }
    parami.value = paramString;
    paramString = m.kSu;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.kSN.Wl(paramString);
    if ((paramString == null) || (!s.YS(paramString.iGf)))
    {
      paramString = m.kSA;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.kSv;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.iGf, paramFileStructStat) == 0)
    {
      paramString = m.kSu;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = m.kSv;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final com.tencent.mm.vfs.o ag(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = VY(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.kSN.Wl(paramString);
    if ((paramString == null) || (!s.YS(paramString.iGf)))
    {
      paramString = m.kSA;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = n.s(new com.tencent.mm.vfs.o(paramString.iGf));
    paramString = m.kSu;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final List<y> bxs()
  {
    AppMethodBeat.i(134351);
    List localList = this.kSN.bxw();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final String getRootPath()
  {
    return this.kSr;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!s.boN(this.kSr)) {
      Log.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196167);
    super.release();
    this.kSM = true;
    AppMethodBeat.o(196167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.o
 * JD-Core Version:    0.7.0.1
 */