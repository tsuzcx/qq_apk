package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.g;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.z;
import java.util.HashMap;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  public cc lqS;
  public cb lqT;
  com.tencent.mm.storage.h lqU;
  com.tencent.mm.storage.i lqV;
  com.tencent.mm.model.b.c lqW;
  com.tencent.mm.model.b.d lqX;
  k lqY;
  o lqZ;
  m lra;
  com.tencent.mm.model.b.b lrb;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bk.SQL_CREATE;
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
    baseDBFactories.put(Integer.valueOf("BackupMoveTime".hashCode()), new c.9());
    baseDBFactories.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new c.10());
    baseDBFactories.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return m.SQL_CREATE;
      }
    });
    AppMethodBeat.o(20305);
  }
  
  public c()
  {
    AppMethodBeat.i(20248);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().a(new h.a()
    {
      public final void aHw()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.h.aHH();
        if (com.tencent.mm.kernel.h.aHB())
        {
          com.tencent.mm.modelstat.l locall = p.bpD();
          if (locall != null)
          {
            Log.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(locall)));
            long l = System.currentTimeMillis();
            locall.mei.appendAll(true);
            Log.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void aHx() {}
      
      public final void aHy() {}
    });
    com.tencent.mm.kernel.a.c.aHV().add(new c.3(this));
    com.tencent.mm.kernel.a.c.aHV().add(new c.4(this));
    AppMethodBeat.o(20248);
  }
  
  public static SharedPreferences MQ(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.h.aHH();
    paramString = com.tencent.mm.kernel.h.aHG().MQ(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public static void a(bd parambd)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().a(parambd);
    AppMethodBeat.o(20255);
  }
  
  public static void aGI()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGI();
    AppMethodBeat.o(20257);
  }
  
  public static boolean aGK()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.h.aHH();
    boolean bool = com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static String aHk()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().aHk();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String aHl()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static String aHm()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().aHm();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String aHn()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().aHn();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static ao aHp()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.h.aHH();
    ao localao = com.tencent.mm.kernel.h.aHG().aHp();
    AppMethodBeat.o(20263);
    return localao;
  }
  
  public static void aHr()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHr();
    AppMethodBeat.o(20251);
  }
  
  public static void b(bd parambd)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().b(parambd);
    AppMethodBeat.o(20256);
  }
  
  public static String bbH()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().kcA;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int bbI()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.h.aHH();
    int i = com.tencent.mm.kernel.h.aHE().kbO;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h bbJ()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.aHG().kcG;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static j bbK()
  {
    AppMethodBeat.i(20264);
    j localj = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbK();
    AppMethodBeat.o(20264);
    return localj;
  }
  
  public static bv bbL()
  {
    AppMethodBeat.i(20265);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL();
    AppMethodBeat.o(20265);
    return localbv;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.n bbM()
  {
    AppMethodBeat.i(20266);
    com.tencent.mm.plugin.messenger.foundation.a.a.n localn = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM();
    AppMethodBeat.o(20266);
    return localn;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.f bbN()
  {
    AppMethodBeat.i(289868);
    com.tencent.mm.plugin.messenger.foundation.a.a.f localf = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbN();
    AppMethodBeat.o(289868);
    return localf;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i bbO()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe();
    AppMethodBeat.o(20267);
    return locali;
  }
  
  public static t bbP()
  {
    AppMethodBeat.i(20268);
    t localt = ((com.tencent.mm.ao.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.ao.q.class)).bbP();
    AppMethodBeat.o(20268);
    return localt;
  }
  
  public static com.tencent.mm.storage.u bbQ()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.u localu = ((com.tencent.mm.ao.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.ao.q.class)).bbQ();
    AppMethodBeat.o(20269);
    return localu;
  }
  
  public static bw bbR()
  {
    AppMethodBeat.i(20270);
    bw localbw = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR();
    AppMethodBeat.o(20270);
    return localbw;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b bbS()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.downloader.a.d.class)).bbS();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bz bbT()
  {
    AppMethodBeat.i(20272);
    bz localbz = ((com.tencent.mm.plugin.s.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.s.a.a.class)).bbT();
    AppMethodBeat.o(20272);
    return localbz;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l bbU()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.l locall = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbU();
    AppMethodBeat.o(20273);
    return locall;
  }
  
  public static aq bbV()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    AppMethodBeat.o(20274);
    return localaq;
  }
  
  public static String bbW()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.bbW();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String bbX()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.bbX();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String bbY()
  {
    AppMethodBeat.i(20277);
    String str = com.tencent.mm.modelvoice.s.bbY();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String bbZ()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.c.bbZ();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String bca()
  {
    AppMethodBeat.i(20279);
    String str = ap.bca();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String bcb()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String bcc()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String bcd()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.l.a.bcd();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String bce()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String bcf()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.ao.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.ao.q.class)).bcf();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String bcg()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    localObject = com.tencent.mm.kernel.h.aHG().kcB + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String bch()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String bci()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static g bcn()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    g localg = com.tencent.mm.plugin.c.a.bBt().bcn();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c bco()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bco();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    y.uH(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bq.a("medianote", null);
      bh.beI();
      bbR().bwv("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().JA(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.h.aHH();
    String str = com.tencent.mm.kernel.h.aHG().kcB;
    AppMethodBeat.o(20294);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(20287);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(20287);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(20288);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(20288);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(20281);
    com.tencent.mm.modelvideo.s.bqA();
    String str = com.tencent.mm.modelvideo.s.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.aHG().kcF;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static cf getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(289878);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    cf localcf = ((com.tencent.mm.plugin.notifymessage.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notifymessage.a.class)).getNotifyMessageRecordStorage();
    AppMethodBeat.o(289878);
    return localcf;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE();
    int i = com.tencent.mm.kernel.b.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.h.aHH();
    boolean bool = com.tencent.mm.kernel.h.aHG().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public final void bcj()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.h.aHG().cachePath;
    String str2 = com.tencent.mm.kernel.h.aHG().kcB;
    String[] arrayOfString = new com.tencent.mm.vfs.q(str1).a(new z()
    {
      public final boolean accept(com.tencent.mm.vfs.q paramAnonymousq, String paramAnonymousString)
      {
        AppMethodBeat.i(289750);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg_encrypt.db")))
        {
          AppMethodBeat.o(289750);
          return true;
        }
        AppMethodBeat.o(289750);
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
      com.tencent.mm.vfs.u.deleteFile(str4);
      com.tencent.mm.vfs.u.on(str1 + str3, str4);
      Log.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c bck()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.model.b.c localc = this.lqW;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d bcl()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.model.b.d locald = this.lqX;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b bcm()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    com.tencent.mm.model.b.b localb = this.lrb;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final k bcp()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    k localk = this.lqY;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final o bcq()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    o localo = this.lqZ;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final m bcr()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHE().aGH();
    m localm = this.lra;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void fY(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */