package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  public bu hlY;
  public bt hlZ;
  com.tencent.mm.storage.h hma;
  com.tencent.mm.storage.i hmb;
  com.tencent.mm.model.b.c hmc;
  com.tencent.mm.model.b.d hmd;
  com.tencent.mm.storage.k hme;
  com.tencent.mm.storage.o hmf;
  com.tencent.mm.storage.m hmg;
  com.tencent.mm.model.b.b hmh;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ba.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.h.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("APPBRAND_NOTIFY_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.i.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BackupMoveTime".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.storage.k.SQL_CREATE;
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
    h.a local1 = new h.a()
    {
      public final void agH()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.g.agS();
        if (com.tencent.mm.kernel.g.agM())
        {
          com.tencent.mm.modelstat.m localm = com.tencent.mm.modelstat.q.aIG();
          if (localm != null)
          {
            ac.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
            long l = System.currentTimeMillis();
            localm.hXq.vX(true);
            ac.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void agI() {}
      
      public final void agJ() {}
    };
    locale.ghz.bs(local1);
    com.tencent.mm.kernel.a.c.ahe().add(new c.3(this));
    com.tencent.mm.kernel.a.c.ahe().add(new c.4(this));
    AppMethodBeat.o(20248);
  }
  
  public static void a(av paramav)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().a(paramav);
    AppMethodBeat.o(20255);
  }
  
  public static void afU()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afU();
    AppMethodBeat.o(20257);
  }
  
  public static boolean afW()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.g.agS();
    boolean bool = com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static ae agA()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.g.agS();
    ae localae = com.tencent.mm.kernel.g.agR().agA();
    AppMethodBeat.o(20263);
    return localae;
  }
  
  public static void agC()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().agC();
    AppMethodBeat.o(20251);
  }
  
  public static String agu()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().agu();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String agv()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h agw()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.agR().ghG;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static String agx()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().agx();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String agy()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().agy();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i awA()
  {
    AppMethodBeat.i(20264);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA();
    AppMethodBeat.o(20264);
    return locali;
  }
  
  public static bj awB()
  {
    AppMethodBeat.i(20265);
    bj localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
    AppMethodBeat.o(20265);
    return localbj;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.m awC()
  {
    AppMethodBeat.i(20266);
    com.tencent.mm.plugin.messenger.foundation.a.a.m localm = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC();
    AppMethodBeat.o(20266);
    return localm;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.h awD()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr();
    AppMethodBeat.o(20267);
    return localh;
  }
  
  public static com.tencent.mm.storage.p awE()
  {
    AppMethodBeat.i(20268);
    com.tencent.mm.storage.p localp = ((com.tencent.mm.al.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.p.class)).awE();
    AppMethodBeat.o(20268);
    return localp;
  }
  
  public static com.tencent.mm.storage.q awF()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.q localq = ((com.tencent.mm.al.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.p.class)).awF();
    AppMethodBeat.o(20269);
    return localq;
  }
  
  public static bk awG()
  {
    AppMethodBeat.i(20270);
    bk localbk = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG();
    AppMethodBeat.o(20270);
    return localbk;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b awH()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).awH();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bn awI()
  {
    AppMethodBeat.i(20272);
    bn localbn = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).awI();
    AppMethodBeat.o(20272);
    return localbn;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.k awJ()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.k localk = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ();
    AppMethodBeat.o(20273);
    return localk;
  }
  
  public static aj awK()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK();
    AppMethodBeat.o(20274);
    return localaj;
  }
  
  public static String awL()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.awL();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String awM()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.awM();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String awN()
  {
    AppMethodBeat.i(20277);
    String str = s.awN();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String awO()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.b.awO();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String awP()
  {
    AppMethodBeat.i(20279);
    String str = af.awP();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String awQ()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String awR()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String awS()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.h.a.awS();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String awT()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String awU()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.al.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.p.class)).awU();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String awV()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    localObject = com.tencent.mm.kernel.g.agR().ghC + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String awW()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String awX()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static String awx()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().ghB;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int awy()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.g.agS();
    int i = com.tencent.mm.kernel.g.agP().ggO;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h awz()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.agR().ghH;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static com.tencent.mm.storage.g axc()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.aRW().axc();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c axd()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).axd();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static void b(av paramav)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().b(paramav);
    AppMethodBeat.o(20256);
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    t.nL(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bi.a("medianote", null);
      az.ayM();
      awG().aNG("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agR().ro(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.g.agS();
    String str = com.tencent.mm.kernel.g.agR().ghC;
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
    com.tencent.mm.modelvideo.o.aJx();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.g.agS();
    boolean bool = com.tencent.mm.kernel.g.agR().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public static SharedPreferences ug(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.g.agS();
    paramString = com.tencent.mm.kernel.g.agR().ug(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public final void awY()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.g.agR().cachePath;
    String str2 = com.tencent.mm.kernel.g.agR().ghC;
    String[] arrayOfString = new com.tencent.mm.vfs.e(str1).a(new com.tencent.mm.vfs.m()
    {
      public final boolean ui(String paramAnonymousString)
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
      com.tencent.mm.vfs.i.lZ(str1 + str3, str4);
      ac.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c awZ()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.model.b.c localc = this.hmc;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d axa()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.model.b.d locald = this.hmd;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b axb()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.model.b.b localb = this.hmh;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final com.tencent.mm.storage.k axe()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.storage.k localk = this.hme;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final com.tencent.mm.storage.o axf()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.storage.o localo = this.hmf;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final com.tencent.mm.storage.m axg()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agP().afT();
    com.tencent.mm.storage.m localm = this.hmg;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void eu(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */