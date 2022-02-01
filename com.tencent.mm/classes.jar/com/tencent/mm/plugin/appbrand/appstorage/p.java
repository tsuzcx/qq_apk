package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class p
  extends j
{
  private final String nMM;
  public final String nMN;
  public final String nMO;
  public volatile long nMQ;
  private volatile boolean nNj;
  public final LuggageLocalFileObjectManager nNk;
  private t nNl;
  public String nNm;
  
  public p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134338);
    this.nNj = false;
    this.nNl = null;
    this.nNm = "tmp";
    this.nMQ = -1L;
    this.nMO = new q(paramString1).bOF();
    this.nMM = paramString2;
    this.nMN = paramString3;
    this.nNk = new LuggageLocalFileObjectManager(this.nMO, this.nMM, this.nMN);
    AppMethodBeat.o(134338);
  }
  
  public final m a(i<String> parami)
  {
    parami.value = this.nMO;
    return m.nMR;
  }
  
  public final m a(q paramq, String paramString, i<String> parami)
  {
    AppMethodBeat.i(175579);
    if ((paramq == null) || (!paramq.ifE()))
    {
      paramq = m.nMS;
      AppMethodBeat.o(175579);
      return paramq;
    }
    if ((!TextUtils.isEmpty(paramString)) || (parami == null))
    {
      paramq = m.nNh;
      AppMethodBeat.o(175579);
      return paramq;
    }
    if (this.nMQ > 0L)
    {
      if (this.nNl != null)
      {
        long l2 = this.nNl.cO(this.nMO, paramq.bOF()) + paramq.length();
        Log.i("MicroMsg.Luggage.FlattenFileSystem", "saveFile: WxaStorageSpaceStatisticsService getDirTotalSize=" + (l2 - paramq.length()));
        l1 = l2;
        if (l2 != -1L) {}
      }
      else
      {
        l1 = this.nNk.bIO() + paramq.length();
      }
      if (l1 > this.nMQ)
      {
        paramq = m.nNg;
        AppMethodBeat.o(175579);
        return paramq;
      }
    }
    paramString = this.nNk.adZ(paramq.getName());
    if (paramString != null)
    {
      if (paramString.nMi)
      {
        parami.value = paramString.fCM;
        paramq = m.nMR;
        AppMethodBeat.o(175579);
        return paramq;
      }
      l1 = paramString.mHi;
      paramq = this.nNk.a(paramString);
      parami.value = paramq.fCM;
      if (this.nNl != null)
      {
        this.nNl.d(paramString.lwh, new q(paramString.lwh).length() - l1, "FlattenFileSystem#saveFile");
        this.nNl.d(paramq.lwh, new q(paramq.lwh).length(), "FlattenFileSystem#saveFile");
      }
      paramq = m.nMR;
      AppMethodBeat.o(175579);
      return paramq;
    }
    paramq = this.nNk.j(paramq.bOF(), null, false);
    long l1 = paramq.mHi;
    paramString = this.nNk.a(paramq);
    parami.value = paramString.fCM;
    if (this.nNl != null)
    {
      this.nNl.d(paramq.lwh, new q(paramq.lwh).length() - l1, "FlattenFileSystem#saveFile");
      this.nNl.d(paramString.lwh, new q(paramString.lwh).length(), "FlattenFileSystem#saveFile");
    }
    paramq = m.nMR;
    AppMethodBeat.o(175579);
    return paramq;
  }
  
  public final m a(q paramq, String paramString, boolean paramBoolean, i<String> parami)
  {
    AppMethodBeat.i(175578);
    Log.i("MicroMsg.Luggage.FlattenFileSystem", "createTempFileFrom src[%s] suffix[%s] deleteSrc[%b] released[%b]", new Object[] { paramq, paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.nNj) });
    if (this.nNj)
    {
      paramq = m.nMT;
      AppMethodBeat.o(175578);
      return paramq;
    }
    paramq = this.nNk.j(paramq.bOF(), paramString, paramBoolean);
    if (paramq == null)
    {
      paramq = m.nMS;
      AppMethodBeat.o(175578);
      return paramq;
    }
    if (this.nNl != null) {
      this.nNl.a(this.nMO, paramq.lwh, paramq.mHi, "FlattenFileSystem#createTempFileFrom");
    }
    parami.value = paramq.fCM;
    paramq = m.nMR;
    AppMethodBeat.o(175578);
    return paramq;
  }
  
  public final m a(String paramString, long paramLong1, long paramLong2, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(175575);
    paramString = this.nNk.aea(paramString);
    if ((paramString == null) || (!u.agG(paramString.lwh)))
    {
      paramString = m.nMX;
      AppMethodBeat.o(175575);
      return paramString;
    }
    paramString = new q(paramString.lwh);
    if (paramLong2 == 9223372036854775807L) {
      paramLong2 = paramString.length() - paramLong1;
    }
    for (;;)
    {
      m localm = h(paramLong1, paramLong2, paramString.length());
      if (localm != m.nMR)
      {
        AppMethodBeat.o(175575);
        return localm;
      }
      parami.value = o.a(paramString, paramLong1, paramLong2);
      paramString = m.nMR;
      AppMethodBeat.o(175575);
      return paramString;
    }
  }
  
  public final m a(String paramString, i<List<k>> parami)
  {
    AppMethodBeat.i(134343);
    Object localObject = new LinkedList();
    b.c((List)localObject, this.nNk.bIL());
    b.c((List)localObject, this.nNk.bIN());
    paramString = new LinkedList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aa localaa = (aa)((Iterator)localObject).next();
      k localk = new k();
      localk.fileName = localaa.fCM;
      paramString.add(localk);
    }
    parami.value = paramString;
    paramString = m.nMR;
    AppMethodBeat.o(134343);
    return paramString;
  }
  
  public final m a(String paramString1, i<Map<String, ByteBuffer>> parami, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225657);
    paramString1 = this.nNk.aea(paramString1);
    if ((paramString1 == null) || (!u.agG(paramString1.lwh)))
    {
      paramString1 = m.nMX;
      AppMethodBeat.o(225657);
      return paramString1;
    }
    paramString1 = o.a(paramString1.lwh, parami, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(225657);
    return paramString1;
  }
  
  public final m a(String paramString, FileStructStat paramFileStructStat)
  {
    AppMethodBeat.i(134342);
    paramString = this.nNk.aea(paramString);
    if ((paramString == null) || (!u.agG(paramString.lwh)))
    {
      paramString = m.nMX;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (paramFileStructStat == null)
    {
      paramString = m.nMS;
      AppMethodBeat.o(134342);
      return paramString;
    }
    if (FileStat.b(paramString.lwh, paramFileStructStat) == 0)
    {
      paramString = m.nMR;
      AppMethodBeat.o(134342);
      return paramString;
    }
    paramString = m.nMS;
    AppMethodBeat.o(134342);
    return paramString;
  }
  
  public final void a(t paramt)
  {
    this.nNl = paramt;
  }
  
  public final boolean acS(String paramString)
  {
    AppMethodBeat.i(134339);
    boolean bool = Util.nullAsNil(paramString).startsWith(this.nMN);
    AppMethodBeat.o(134339);
    return bool;
  }
  
  public final m acT(String paramString)
  {
    AppMethodBeat.i(134340);
    paramString = this.nNk.aea(paramString);
    if ((paramString == null) || (!u.agG(paramString.lwh)))
    {
      paramString = m.nMX;
      AppMethodBeat.o(134340);
      return paramString;
    }
    paramString = m.nMR;
    AppMethodBeat.o(134340);
    return paramString;
  }
  
  public final m adK(String paramString)
  {
    AppMethodBeat.i(134353);
    paramString = m.nMV;
    AppMethodBeat.o(134353);
    return paramString;
  }
  
  public final q adL(String paramString)
  {
    AppMethodBeat.i(175577);
    paramString = this.nNk.aea(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(175577);
      return null;
    }
    paramString = new q(paramString.lwh);
    AppMethodBeat.o(175577);
    return paramString;
  }
  
  public final q adN(String paramString)
  {
    AppMethodBeat.i(134348);
    u.bBD(this.nMO);
    paramString = new q(this.nMO + "/" + paramString);
    AppMethodBeat.o(134348);
    return paramString;
  }
  
  public final boolean adO(String paramString)
  {
    AppMethodBeat.i(134352);
    paramString = this.nNk.aea(paramString);
    if ((paramString != null) && (paramString.nMi))
    {
      AppMethodBeat.o(134352);
      return true;
    }
    AppMethodBeat.o(134352);
    return false;
  }
  
  public final boolean adP(String paramString)
  {
    AppMethodBeat.i(225654);
    paramString = this.nNk.aea(paramString);
    if ((paramString == null) || (!paramString.nMi))
    {
      AppMethodBeat.o(225654);
      return false;
    }
    boolean bool = new q(paramString.lwh).cFq();
    if (this.nNl != null) {
      this.nNl.d(paramString.lwh, -paramString.mHi, "FlattenFileSystem#removeSavedFile");
    }
    AppMethodBeat.o(225654);
    return bool;
  }
  
  public final boolean adV(String paramString)
  {
    AppMethodBeat.i(225627);
    boolean bool = this.nNk.c(new q(paramString), false);
    AppMethodBeat.o(225627);
    return bool;
  }
  
  public final String adW(String paramString)
  {
    AppMethodBeat.i(134346);
    paramString = this.nNk.aea(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(134346);
      return null;
    }
    paramString = paramString.lwh;
    AppMethodBeat.o(134346);
    return paramString;
  }
  
  public final q ah(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(175576);
    paramString = adL(paramString);
    AppMethodBeat.o(175576);
    return paramString;
  }
  
  public final m b(String paramString, i<ByteBuffer> parami)
  {
    AppMethodBeat.i(134341);
    paramString = this.nNk.aea(paramString);
    if ((paramString == null) || (!u.agG(paramString.lwh)))
    {
      paramString = m.nMX;
      AppMethodBeat.o(134341);
      return paramString;
    }
    parami.value = o.r(new q(paramString.lwh));
    paramString = m.nMR;
    AppMethodBeat.o(134341);
    return paramString;
  }
  
  public final List<aa> bIG()
  {
    AppMethodBeat.i(134351);
    List localList = this.nNk.bIL();
    AppMethodBeat.o(134351);
    return localList;
  }
  
  public final t bIH()
  {
    return this.nNl;
  }
  
  public final String getPrefix()
  {
    return this.nMN;
  }
  
  public final String getRootPath()
  {
    return this.nMO;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(134347);
    if (!u.bBD(this.nMO)) {
      Log.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
    }
    AppMethodBeat.o(134347);
  }
  
  public final void release()
  {
    AppMethodBeat.i(225628);
    super.release();
    this.nNj = true;
    AppMethodBeat.o(225628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.p
 * JD-Core Version:    0.7.0.1
 */