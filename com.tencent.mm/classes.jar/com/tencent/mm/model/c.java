package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.r;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  public bv hEl;
  public bu hEm;
  com.tencent.mm.storage.h hEn;
  com.tencent.mm.storage.i hEo;
  com.tencent.mm.model.b.c hEp;
  com.tencent.mm.model.b.d hEq;
  k hEr;
  com.tencent.mm.storage.o hEs;
  com.tencent.mm.storage.m hEt;
  com.tencent.mm.model.b.b hEu;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return be.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new c.7());
    baseDBFactories.put(Integer.valueOf("APPBRAND_NOTIFY_MESSAGE_TABLE".hashCode()), new c.8());
    baseDBFactories.put(Integer.valueOf("BackupMoveTime".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.o.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.m.SQL_CREATE;
      }
    });
    AppMethodBeat.o(20305);
  }
  
  public c()
  {
    AppMethodBeat.i(20248);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    h.a local1 = new h.a()
    {
      public final void ajs()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.g.ajD();
        if (com.tencent.mm.kernel.g.ajx())
        {
          com.tencent.mm.modelstat.m localm = com.tencent.mm.modelstat.q.aLQ();
          if (localm != null)
          {
            ad.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
            long l = System.currentTimeMillis();
            localm.iqL.wJ(true);
            ad.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void ajt() {}
      
      public final void aju() {}
    };
    locale.gBj.bu(local1);
    com.tencent.mm.kernel.a.c.ajP().add(new com.tencent.mm.kernel.api.b()
    {
      public final List<String> ajJ()
      {
        AppMethodBeat.i(20243);
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "mailapp/", "favoffline/", "voice2/", "video/", "attachment/" });
        AppMethodBeat.o(20243);
        return localLinkedList;
      }
    });
    com.tencent.mm.kernel.a.c.ajP().add(new com.tencent.mm.kernel.api.f()
    {
      public final void ajK()
      {
        AppMethodBeat.i(20244);
        ba.aBP();
        AppMethodBeat.o(20244);
      }
      
      public final void xb(String paramAnonymousString)
      {
        AppMethodBeat.i(20245);
        if (com.tencent.mm.compatible.util.e.abf())
        {
          com.tencent.mm.kernel.g.ajD();
          if (com.tencent.mm.kernel.g.ajC().gBl.equals(com.tencent.mm.loader.j.b.arU()))
          {
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.sdk.g.b.c(new c.b(com.tencent.mm.kernel.g.ajC().cachePath, paramAnonymousString), "AccountStorage_moveDataFiles");
          }
        }
        AppMethodBeat.o(20245);
      }
    });
    AppMethodBeat.o(20248);
  }
  
  public static void a(aw paramaw)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().a(paramaw);
    AppMethodBeat.o(20255);
  }
  
  public static void aiG()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiG();
    AppMethodBeat.o(20257);
  }
  
  public static boolean aiI()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.g.ajD();
    boolean bool = com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static String ajg()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().ajg();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String ajh()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static String aji()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().aji();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String ajj()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().ajj();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static ai ajl()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.g.ajD();
    ai localai = com.tencent.mm.kernel.g.ajC().ajl();
    AppMethodBeat.o(20263);
    return localai;
  }
  
  public static void ajn()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ajn();
    AppMethodBeat.o(20251);
  }
  
  public static String azA()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.azA();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String azB()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.azB();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String azC()
  {
    AppMethodBeat.i(20277);
    String str = com.tencent.mm.modelvoice.s.azC();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String azD()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.b.azD();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String azE()
  {
    AppMethodBeat.i(20279);
    String str = aj.azE();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String azF()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String azG()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String azH()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.h.a.azH();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String azI()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String azJ()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.am.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.q.class)).azJ();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String azK()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    localObject = com.tencent.mm.kernel.g.ajC().gBm + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String azL()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String azM()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static com.tencent.mm.storage.g azR()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.aVi().azR();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c azS()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azS();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static String azl()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().gBl;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int azm()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.g.ajD();
    int i = com.tencent.mm.kernel.g.ajA().gAy;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h azn()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajC().gBr;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static j azo()
  {
    AppMethodBeat.i(20264);
    j localj = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo();
    AppMethodBeat.o(20264);
    return localj;
  }
  
  public static bp azp()
  {
    AppMethodBeat.i(20265);
    bp localbp = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp();
    AppMethodBeat.o(20265);
    return localbp;
  }
  
  public static n azq()
  {
    AppMethodBeat.i(20266);
    n localn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azq();
    AppMethodBeat.o(20266);
    return localn;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.f azr()
  {
    AppMethodBeat.i(193113);
    com.tencent.mm.plugin.messenger.foundation.a.a.f localf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azr();
    AppMethodBeat.o(193113);
    return localf;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i azs()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK();
    AppMethodBeat.o(20267);
    return locali;
  }
  
  public static r azt()
  {
    AppMethodBeat.i(20268);
    r localr = ((com.tencent.mm.am.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.q.class)).azt();
    AppMethodBeat.o(20268);
    return localr;
  }
  
  public static com.tencent.mm.storage.s azu()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.s locals = ((com.tencent.mm.am.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.q.class)).azu();
    AppMethodBeat.o(20269);
    return locals;
  }
  
  public static bq azv()
  {
    AppMethodBeat.i(20270);
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv();
    AppMethodBeat.o(20270);
    return localbq;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b azw()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).azw();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bt azx()
  {
    AppMethodBeat.i(20272);
    bt localbt = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azx();
    AppMethodBeat.o(20272);
    return localbt;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l azy()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.l locall = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy();
    AppMethodBeat.o(20273);
    return locall;
  }
  
  public static ak azz()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    ak localak = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz();
    AppMethodBeat.o(20274);
    return localak;
  }
  
  public static void b(aw paramaw)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().b(paramaw);
    AppMethodBeat.o(20256);
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    t.ol(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bj.a("medianote", null);
      ba.aBQ();
      azv().aTx("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajC().ua(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.g.ajD();
    String str = com.tencent.mm.kernel.g.ajC().gBm;
    AppMethodBeat.o(20294);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(20287);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(20287);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(20288);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(20288);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(20281);
    com.tencent.mm.modelvideo.o.aMI();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajC().gBq;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.g.ajD();
    boolean bool = com.tencent.mm.kernel.g.ajC().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public static SharedPreferences wW(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.g.ajD();
    paramString = com.tencent.mm.kernel.g.ajC().wW(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public final void azN()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.g.ajC().cachePath;
    String str2 = com.tencent.mm.kernel.g.ajC().gBm;
    String[] arrayOfString = new com.tencent.mm.vfs.e(str1).a(new com.tencent.mm.vfs.m()
    {
      public final boolean wY(String paramAnonymousString)
      {
        AppMethodBeat.i(20246);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg_encrypt.db")))
        {
          AppMethodBeat.o(20246);
          return true;
        }
        AppMethodBeat.o(20246);
        return false;
      }
    });
    if (arrayOfString == null)
    {
      AppMethodBeat.o(20295);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str3 = arrayOfString[i];
      String str4 = str2 + str3 + ".dump";
      com.tencent.mm.vfs.i.deleteFile(str4);
      com.tencent.mm.vfs.i.mz(str1 + str3, str4);
      ad.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c azO()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.model.b.c localc = this.hEp;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d azP()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.model.b.d locald = this.hEq;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b azQ()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.model.b.b localb = this.hEu;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final k azT()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    k localk = this.hEr;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final com.tencent.mm.storage.o azU()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.storage.o localo = this.hEs;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final com.tencent.mm.storage.m azV()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajA().aiF();
    com.tencent.mm.storage.m localm = this.hEt;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void ew(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */