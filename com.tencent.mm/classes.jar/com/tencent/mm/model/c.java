package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.g;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ad;
import java.util.HashMap;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  o oiA;
  m oiB;
  com.tencent.mm.model.b.b oiC;
  public cd oit;
  public cc oiu;
  com.tencent.mm.storage.h oiv;
  com.tencent.mm.storage.i oiw;
  com.tencent.mm.model.b.c oix;
  com.tencent.mm.model.b.d oiy;
  k oiz;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bm.SQL_CREATE;
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
        return k.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return o.SQL_CREATE;
      }
    });
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().a(new h.a()
    {
      public final void bau()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.h.baF();
        if (com.tencent.mm.kernel.h.baz())
        {
          com.tencent.mm.modelstat.l locall = p.bNk();
          if (locall != null)
          {
            Log.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(locall)));
            long l = System.currentTimeMillis();
            locall.oXb.appendAll(true);
            Log.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void bav() {}
      
      public final void baw() {}
    });
    com.tencent.mm.kernel.a.c.baR().add(new c.3(this));
    com.tencent.mm.kernel.a.c.baR().add(new c.4(this));
    AppMethodBeat.o(20248);
  }
  
  public static SharedPreferences Fz(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.h.baF();
    paramString = com.tencent.mm.kernel.h.baE().Fz(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public static void a(bd parambd)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().a(parambd);
    AppMethodBeat.o(20255);
  }
  
  public static void aZK()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZK();
    AppMethodBeat.o(20257);
  }
  
  public static void b(bd parambd)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().b(parambd);
    AppMethodBeat.o(20256);
  }
  
  public static g bAc()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    g localg = com.tencent.mm.plugin.c.a.caJ().bAc();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c bAd()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bAd();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static String bai()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().bai();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String baj()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static String bak()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().bak();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String bal()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().bal();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static aq ban()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.h.baF();
    aq localaq = com.tencent.mm.kernel.h.baE().ban();
    AppMethodBeat.o(20263);
    return localaq;
  }
  
  public static void bap()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().bap();
    AppMethodBeat.o(20251);
  }
  
  public static bx bzA()
  {
    AppMethodBeat.i(20265);
    bx localbx = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    AppMethodBeat.o(20265);
    return localbx;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.n bzB()
  {
    AppMethodBeat.i(20266);
    com.tencent.mm.plugin.messenger.foundation.a.a.n localn = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB();
    AppMethodBeat.o(20266);
    return localn;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.f bzC()
  {
    AppMethodBeat.i(241943);
    com.tencent.mm.plugin.messenger.foundation.a.a.f localf = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzC();
    AppMethodBeat.o(241943);
    return localf;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i bzD()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
    AppMethodBeat.o(20267);
    return locali;
  }
  
  public static t bzE()
  {
    AppMethodBeat.i(20268);
    t localt = ((q)com.tencent.mm.kernel.h.ax(q.class)).bzE();
    AppMethodBeat.o(20268);
    return localt;
  }
  
  public static com.tencent.mm.storage.u bzF()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.u localu = ((q)com.tencent.mm.kernel.h.ax(q.class)).bzF();
    AppMethodBeat.o(20269);
    return localu;
  }
  
  public static by bzG()
  {
    AppMethodBeat.i(20270);
    by localby = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG();
    AppMethodBeat.o(20270);
    return localby;
  }
  
  public static com.tencent.mm.plugin.downloader.f.b bzH()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.f.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader.a.d.class)).bzH();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static cb bzI()
  {
    AppMethodBeat.i(20272);
    cb localcb = ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.r.a.a.class)).bzI();
    AppMethodBeat.o(20272);
    return localcb;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l bzJ()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.l locall = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzJ();
    AppMethodBeat.o(20273);
    return locall;
  }
  
  public static ar bzK()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    AppMethodBeat.o(20274);
    return localar;
  }
  
  public static String bzL()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.bzL();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String bzM()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.bzM();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String bzN()
  {
    AppMethodBeat.i(20277);
    String str = s.bzN();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String bzO()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.c.bzO();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String bzP()
  {
    AppMethodBeat.i(20279);
    String str = com.tencent.mm.storage.ar.bzP();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String bzQ()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String bzR()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String bzS()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.l.a.bzS();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String bzT()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String bzU()
  {
    AppMethodBeat.i(20285);
    String str = ((q)com.tencent.mm.kernel.h.ax(q.class)).bzU();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String bzV()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    localObject = com.tencent.mm.kernel.h.baE().mCJ + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String bzW()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String bzX()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static String bzv()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().mCI;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static boolean bzw()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.h.baF();
    boolean bool = com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.h.baC().mBT);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static int bzx()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.h.baF();
    int i = com.tencent.mm.kernel.h.baC().mBU;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h bzy()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCO;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static j bzz()
  {
    AppMethodBeat.i(20264);
    j localj = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzz();
    AppMethodBeat.o(20264);
    return localj;
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    y.uT(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      br.a("medianote", null);
      bh.bCz();
      bzG().bxK("medianote");
      ac.aY("medianote", 15);
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().Cg(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.h.baF();
    String str = com.tencent.mm.kernel.h.baE().mCJ;
    AppMethodBeat.o(20294);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(20287);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath();
    AppMethodBeat.o(20287);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(20288);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(20288);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(20281);
    v.bOg();
    String str = v.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCN;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static com.tencent.mm.message.b.a getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(241975);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.message.b.a locala = ((com.tencent.mm.message.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.message.b.b.class)).getNotifyMessageRecordStorage();
    AppMethodBeat.o(241975);
    return locala;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC();
    int i = com.tencent.mm.kernel.b.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.h.baF();
    boolean bool = com.tencent.mm.kernel.h.baE().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public final com.tencent.mm.model.b.d bAa()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.model.b.d locald = this.oiy;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b bAb()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.model.b.b localb = this.oiC;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final k bAe()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    k localk = this.oiz;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final o bAf()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    o localo = this.oiA;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final m bAg()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    m localm = this.oiB;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public final void bzY()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.h.baE().cachePath;
    String str2 = com.tencent.mm.kernel.h.baE().mCJ;
    String[] arrayOfString = new com.tencent.mm.vfs.u(str1).a(new ad()
    {
      public final boolean accept(com.tencent.mm.vfs.u paramAnonymousu, String paramAnonymousString)
      {
        AppMethodBeat.i(242040);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg_encrypt.db")))
        {
          AppMethodBeat.o(242040);
          return true;
        }
        AppMethodBeat.o(242040);
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
      com.tencent.mm.vfs.y.deleteFile(str4);
      com.tencent.mm.vfs.y.O(str1 + str3, str4, false);
      Log.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c bzZ()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baC().aZJ();
    com.tencent.mm.model.b.c localc = this.oix;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public static abstract interface a
  {
    public abstract void gQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */