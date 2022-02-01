package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  public bx hHd;
  public bw hHe;
  com.tencent.mm.storage.h hHf;
  com.tencent.mm.storage.i hHg;
  com.tencent.mm.model.b.c hHh;
  com.tencent.mm.model.b.d hHi;
  com.tencent.mm.storage.k hHj;
  com.tencent.mm.storage.o hHk;
  com.tencent.mm.storage.m hHl;
  com.tencent.mm.model.b.b hHm;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bf.SQL_CREATE;
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
    com.tencent.mm.kernel.g.ajS();
    e locale = com.tencent.mm.kernel.g.ajR();
    h.a local1 = new h.a()
    {
      public final void ajH()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.g.ajS();
        if (com.tencent.mm.kernel.g.ajM())
        {
          com.tencent.mm.modelstat.m localm = com.tencent.mm.modelstat.q.aMn();
          if (localm != null)
          {
            ae.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
            long l = System.currentTimeMillis();
            localm.itG.wR(true);
            ae.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void ajI() {}
      
      public final void ajJ() {}
    };
    locale.gDQ.bu(local1);
    com.tencent.mm.kernel.a.c.ake().add(new c.3(this));
    com.tencent.mm.kernel.a.c.ake().add(new c.4(this));
    AppMethodBeat.o(20248);
  }
  
  public static void a(ay paramay)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().a(paramay);
    AppMethodBeat.o(20255);
  }
  
  public static String aAa()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String aAb()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String aAc()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static com.tencent.mm.storage.g aAh()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.aVH().aAh();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c aAi()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aAi();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static void aiV()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiV();
    AppMethodBeat.o(20257);
  }
  
  public static boolean aiX()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.g.ajS();
    boolean bool = com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static aj ajA()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.g.ajS();
    aj localaj = com.tencent.mm.kernel.g.ajR().ajA();
    AppMethodBeat.o(20263);
    return localaj;
  }
  
  public static void ajC()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().ajC();
    AppMethodBeat.o(20251);
  }
  
  public static String ajv()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().ajv();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String ajw()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static String ajx()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().ajx();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String ajy()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().ajy();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static String azB()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().gDS;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int azC()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.g.ajS();
    int i = com.tencent.mm.kernel.g.ajP().gDf;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h azD()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajR().gDY;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static j azE()
  {
    AppMethodBeat.i(20264);
    j localj = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE();
    AppMethodBeat.o(20264);
    return localj;
  }
  
  public static bq azF()
  {
    AppMethodBeat.i(20265);
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF();
    AppMethodBeat.o(20265);
    return localbq;
  }
  
  public static n azG()
  {
    AppMethodBeat.i(20266);
    n localn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azG();
    AppMethodBeat.o(20266);
    return localn;
  }
  
  public static f azH()
  {
    AppMethodBeat.i(186354);
    f localf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azH();
    AppMethodBeat.o(186354);
    return localf;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i azI()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ();
    AppMethodBeat.o(20267);
    return locali;
  }
  
  public static r azJ()
  {
    AppMethodBeat.i(20268);
    r localr = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.q.class)).azJ();
    AppMethodBeat.o(20268);
    return localr;
  }
  
  public static com.tencent.mm.storage.s azK()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.s locals = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.q.class)).azK();
    AppMethodBeat.o(20269);
    return locals;
  }
  
  public static br azL()
  {
    AppMethodBeat.i(20270);
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL();
    AppMethodBeat.o(20270);
    return localbr;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b azM()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).azM();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bu azN()
  {
    AppMethodBeat.i(20272);
    bu localbu = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).azN();
    AppMethodBeat.o(20272);
    return localbu;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l azO()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.l locall = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO();
    AppMethodBeat.o(20273);
    return locall;
  }
  
  public static al azP()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    AppMethodBeat.o(20274);
    return localal;
  }
  
  public static String azQ()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.azQ();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String azR()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.azR();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String azS()
  {
    AppMethodBeat.i(20277);
    String str = com.tencent.mm.modelvoice.s.azS();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String azT()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.b.azT();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String azU()
  {
    AppMethodBeat.i(20279);
    String str = ak.azU();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String azV()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String azW()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String azX()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.h.a.azX();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String azY()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    localObject = com.tencent.mm.kernel.g.ajR().gDT + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String azZ()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.al.q.class)).azZ();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static void b(ay paramay)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().b(paramay);
    AppMethodBeat.o(20256);
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    u.oo(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bl.a("medianote", null);
      bc.aCg();
      azL().aUY("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajR().uv(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.g.ajS();
    String str = com.tencent.mm.kernel.g.ajR().gDT;
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
    com.tencent.mm.modelvideo.o.aNg();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.ajR().gDX;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.g.ajS();
    boolean bool = com.tencent.mm.kernel.g.ajR().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public static SharedPreferences xF(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.g.ajS();
    paramString = com.tencent.mm.kernel.g.ajR().xF(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public final void aAd()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.g.ajR().cachePath;
    String str2 = com.tencent.mm.kernel.g.ajR().gDT;
    String[] arrayOfString = new com.tencent.mm.vfs.k(str1).a(new com.tencent.mm.vfs.s()
    {
      public final boolean xH(String paramAnonymousString)
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
      com.tencent.mm.vfs.o.deleteFile(str4);
      com.tencent.mm.vfs.o.mF(str1 + str3, str4);
      ae.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c aAe()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.model.b.c localc = this.hHh;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d aAf()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.model.b.d locald = this.hHi;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b aAg()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.model.b.b localb = this.hHm;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final com.tencent.mm.storage.k aAj()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.storage.k localk = this.hHj;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final com.tencent.mm.storage.o aAk()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.storage.o localo = this.hHk;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final com.tencent.mm.storage.m aAl()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajP().aiU();
    com.tencent.mm.storage.m localm = this.hHl;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void ey(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */