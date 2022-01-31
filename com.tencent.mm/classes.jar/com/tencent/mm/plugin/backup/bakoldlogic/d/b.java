package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.o;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import junit.framework.Assert;

public final class b
  extends com.tencent.mm.plugin.backup.b.a
{
  private static b jIN;
  private static int jIQ = 0;
  private c jIO;
  private a jIP;
  private c jIR;
  
  private boolean a(PLong paramPLong1, PLong paramPLong2, PLong paramPLong3, b.a parama, int paramInt)
  {
    AppMethodBeat.i(18017);
    aw.aaz();
    com.tencent.mm.model.c.closeDB();
    ab.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
    aw.aaz();
    long l = e.avI(com.tencent.mm.model.c.Rr());
    aw.aaz();
    paramPLong3.value = (l + e.avI(com.tencent.mm.model.c.Rs()));
    l = paramPLong3.value;
    aw.aaz();
    if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(l, paramPLong1, paramPLong2, com.tencent.mm.model.c.getAccPath()))
    {
      ab.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", new Object[] { Long.valueOf(paramPLong3.value) });
      parama.jIZ = false;
      parama.jJa = paramPLong1.value;
      parama.jJb = paramPLong2.value;
      parama.dbSize = paramPLong3.value;
      AppMethodBeat.o(18017);
      return false;
    }
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.Rr();
    Object localObject2 = new StringBuilder();
    aw.aaz();
    e.C((String)localObject1, com.tencent.mm.model.c.Rr() + ".tem");
    aw.aaz();
    localObject1 = com.tencent.mm.model.c.Rs();
    localObject2 = new StringBuilder();
    aw.aaz();
    e.C((String)localObject1, com.tencent.mm.model.c.Rs() + ".tem");
    localObject1 = new StringBuilder();
    aw.aaz();
    localObject1 = com.tencent.mm.model.c.Rs() + "-journal";
    localObject2 = new StringBuilder();
    aw.aaz();
    e.C((String)localObject1, com.tencent.mm.model.c.Rs() + ".tem-journal");
    localObject1 = new StringBuilder();
    aw.aaz();
    localObject1 = com.tencent.mm.model.c.Rs() + "-wal";
    localObject2 = new StringBuilder();
    aw.aaz();
    e.C((String)localObject1, com.tencent.mm.model.c.Rs() + ".tem-wal");
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
    com.tencent.mm.kernel.g.RJ().release();
    com.tencent.mm.kernel.g.RJ().initialize();
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
    localObject1 = aVv();
    aw.aaz();
    localObject2 = com.tencent.mm.model.c.getAccPath();
    aw.aaz();
    int i = com.tencent.mm.model.c.getUin();
    ab.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", new Object[] { localObject2, Integer.valueOf(i) });
    ((c)localObject1).uin = i;
    ((c)localObject1).eHR = ((String)localObject2);
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
    localObject1 = aVv();
    localObject2 = new StringBuilder();
    aw.aaz();
    localObject2 = com.tencent.mm.model.c.Rr() + ".tem";
    aw.aaz();
    i = com.tencent.mm.model.c.getUin();
    Object localObject3 = new StringBuilder();
    aw.aaz();
    localObject3 = com.tencent.mm.model.c.Rs() + ".tem";
    ab.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", new Object[] { ((c)localObject1).jJe, localObject2, Integer.valueOf(i), localObject3, bo.dtY() });
    if (((c)localObject1).eHS != null) {
      ab.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
    }
    Object localObject4;
    if (paramInt > 0)
    {
      if ((((c)localObject1).jJe != null) && (!((c)localObject1).jJe.booleanValue()))
      {
        ab.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
        ((c)localObject1).aVy();
      }
      localObject4 = "bakoldInitDB here  isTempDb should null :" + ((c)localObject1).jJe;
      if (((c)localObject1).jJe != null) {
        break label747;
      }
    }
    label747:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject4, bool);
      ((c)localObject1).jJe = Boolean.TRUE;
      ((c)localObject1).eHS = new com.tencent.mm.cg.h(new c.2((c)localObject1));
      localObject4 = ((c)localObject1).eHS;
      l = i;
      q.bP(true);
      if (((com.tencent.mm.cg.h)localObject4).b((String)localObject2, (String)localObject3, "", l, new HashMap(), false)) {
        break;
      }
      paramPLong1 = new com.tencent.mm.model.b((byte)0);
      AppMethodBeat.o(18017);
      throw paramPLong1;
    }
    ((c)localObject1).jGm = new com.tencent.mm.storage.z(((c)localObject1).eHS);
    localObject2 = (com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    ((c)localObject1).jGn = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).d(((c)localObject1).eHS);
    ((c)localObject1).jGp = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).e(((c)localObject1).eHS);
    ((c)localObject1).jGo = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).a(((c)localObject1).eHS, ((c)localObject1).jGn, ((c)localObject1).jGp);
    ((c)localObject1).jGo.a(new au(((c)localObject1).jGo));
    ((c)localObject1).jGo.a(new o(((c)localObject1).jGo));
    ((c)localObject1).jGs = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).f(((c)localObject1).eHS);
    ((c)localObject1).jGq = new com.tencent.mm.at.g(((c)localObject1).eHS);
    if (com.tencent.mm.bq.d.ahR("emoji")) {
      ((c)localObject1).jGr = new com.tencent.mm.storage.emotion.d(((c)localObject1).eHS);
    }
    ((c)localObject1).jGu = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).c(((c)localObject1).eHS);
    ((c)localObject1).jGt = new t(((c)localObject1).eHS);
    ((c)localObject1).jGv = new com.tencent.mm.pluginsdk.model.app.k(((c)localObject1).eHS);
    ((c)localObject1).jGw = new i(((c)localObject1).eHS);
    ((c)localObject1).jGx = new com.tencent.mm.pluginsdk.model.app.c(((c)localObject1).eHS);
    ((c)localObject1).jJc = new bs(((c)localObject1).jGm);
    ((c)localObject1).jJc.add(new c.1((c)localObject1));
    ((c)localObject1).jJc.dyJ();
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
    aVu();
    parama.jIZ = true;
    parama.jJa = paramPLong1.value;
    parama.jJb = paramPLong2.value;
    parama.dbSize = paramPLong3.value;
    com.tencent.mm.plugin.backup.bakoldlogic.a.a.Gv(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aUR());
    AppMethodBeat.o(18017);
    return true;
  }
  
  public static b aVr()
  {
    AppMethodBeat.i(18011);
    if (jIN == null)
    {
      localb = new b();
      jIN = localb;
      a(localb);
    }
    b localb = jIN;
    AppMethodBeat.o(18011);
    return localb;
  }
  
  private static void aVu()
  {
    AppMethodBeat.i(18014);
    com.tencent.mm.g.a.z localz = new com.tencent.mm.g.a.z();
    com.tencent.mm.sdk.b.a.ymk.l(localz);
    AppMethodBeat.o(18014);
  }
  
  private c aVv()
  {
    AppMethodBeat.i(18015);
    if (this.jIR == null) {
      this.jIR = new c();
    }
    c localc = this.jIR;
    AppMethodBeat.o(18015);
    return localc;
  }
  
  public static void aVw()
  {
    AppMethodBeat.i(18018);
    StringBuilder localStringBuilder = new StringBuilder();
    aw.aaz();
    e.deleteFile(com.tencent.mm.model.c.Rr() + ".tem");
    localStringBuilder = new StringBuilder();
    aw.aaz();
    e.deleteFile(com.tencent.mm.model.c.Rr() + ".ini.tem");
    localStringBuilder = new StringBuilder();
    aw.aaz();
    e.deleteFile(com.tencent.mm.model.c.Rs() + ".tem");
    localStringBuilder = new StringBuilder();
    aw.aaz();
    e.deleteFile(com.tencent.mm.model.c.Rs() + ".ini.tem");
    AppMethodBeat.o(18018);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(18016);
    long l = bo.aoy();
    ab.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", new Object[] { Boolean.FALSE, bo.dtY() });
    al.p(new b.1(this, l, parama), 1000L);
    AppMethodBeat.o(18016);
  }
  
  public final void aSG()
  {
    jIN = null;
  }
  
  public final c aVs()
  {
    AppMethodBeat.i(18012);
    if (this.jIO == null) {
      this.jIO = new c();
    }
    c localc = this.jIO;
    AppMethodBeat.o(18012);
    return localc;
  }
  
  public final a aVt()
  {
    AppMethodBeat.i(18013);
    if (this.jIP == null) {
      this.jIP = new a();
    }
    a locala = this.jIP;
    AppMethodBeat.o(18013);
    return locala;
  }
  
  public final void c(Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(18019);
    if ((paramInt < 0) || (jIQ == 0))
    {
      if (paramInt < 0) {
        ab.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
      }
      ab.i("MicroMsg.BakOldTempDbModel", "closeDB before");
      aVv().aVy();
      ab.i("MicroMsg.BakOldTempDbModel", "closeDB after");
      if (paramRunnable != null)
      {
        paramRunnable.run();
        AppMethodBeat.o(18019);
      }
    }
    else
    {
      new ak(Looper.getMainLooper()).postDelayed(new b.3(this, paramRunnable, paramInt), 500L);
    }
    AppMethodBeat.o(18019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b
 * JD-Core Version:    0.7.0.1
 */