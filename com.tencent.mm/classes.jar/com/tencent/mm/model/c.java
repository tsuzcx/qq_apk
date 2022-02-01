package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  public cb iBo;
  public ca iBp;
  com.tencent.mm.storage.h iBq;
  com.tencent.mm.storage.i iBr;
  com.tencent.mm.model.b.c iBs;
  com.tencent.mm.model.b.d iBt;
  k iBu;
  com.tencent.mm.storage.o iBv;
  com.tencent.mm.storage.m iBw;
  com.tencent.mm.model.b.b iBx;
  
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
        return com.tencent.mm.storage.m.SQL_CREATE;
      }
    });
    AppMethodBeat.o(20305);
  }
  
  public c()
  {
    AppMethodBeat.i(20248);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
    h.a local1 = new h.a()
    {
      public final void azX()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.g.aAi();
        if (com.tencent.mm.kernel.g.aAc())
        {
          com.tencent.mm.modelstat.m localm = com.tencent.mm.modelstat.q.bgo();
          if (localm != null)
          {
            Log.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
            long l = System.currentTimeMillis();
            localm.joS.appendAll(true);
            Log.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void azY() {}
      
      public final void azZ() {}
    };
    locale.hqD.add(local1);
    com.tencent.mm.kernel.a.c.aAu().add(new com.tencent.mm.kernel.api.b()
    {
      public final List<String> aAo()
      {
        AppMethodBeat.i(20243);
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "mailapp/", "favoffline/", "voice2/", "video/", "attachment/" });
        AppMethodBeat.o(20243);
        return localLinkedList;
      }
    });
    com.tencent.mm.kernel.a.c.aAu().add(new com.tencent.mm.kernel.api.f()
    {
      public final void FU(String paramAnonymousString)
      {
        AppMethodBeat.i(20245);
        if (com.tencent.mm.compatible.util.e.apn())
        {
          com.tencent.mm.kernel.g.aAi();
          if (com.tencent.mm.kernel.g.aAh().hqF.equals(com.tencent.mm.loader.j.b.aKJ()))
          {
            com.tencent.mm.kernel.g.aAi();
            ThreadPool.post(new c.b(com.tencent.mm.kernel.g.aAh().cachePath, paramAnonymousString), "AccountStorage_moveDataFiles");
          }
        }
        AppMethodBeat.o(20245);
      }
      
      public final void aAp()
      {
        AppMethodBeat.i(20244);
        bg.aVE();
        AppMethodBeat.o(20244);
      }
    });
    AppMethodBeat.o(20248);
  }
  
  public static SharedPreferences FQ(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.g.aAi();
    paramString = com.tencent.mm.kernel.g.aAh().FQ(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public static void a(bc parambc)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().a(parambc);
    AppMethodBeat.o(20255);
  }
  
  public static String aSJ()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().hqF;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int aSK()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.g.aAi();
    int i = com.tencent.mm.kernel.g.aAf().hpT;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h aSL()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.aAh().hqL;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static j aSM()
  {
    AppMethodBeat.i(20264);
    j localj = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM();
    AppMethodBeat.o(20264);
    return localj;
  }
  
  public static bv aSN()
  {
    AppMethodBeat.i(20265);
    bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
    AppMethodBeat.o(20265);
    return localbv;
  }
  
  public static n aSO()
  {
    AppMethodBeat.i(20266);
    n localn = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO();
    AppMethodBeat.o(20266);
    return localn;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.f aSP()
  {
    AppMethodBeat.i(231535);
    com.tencent.mm.plugin.messenger.foundation.a.a.f localf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSP();
    AppMethodBeat.o(231535);
    return localf;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy();
    AppMethodBeat.o(20267);
    return locali;
  }
  
  public static t aSR()
  {
    AppMethodBeat.i(20268);
    t localt = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class)).aSR();
    AppMethodBeat.o(20268);
    return localt;
  }
  
  public static u aSS()
  {
    AppMethodBeat.i(20269);
    u localu = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class)).aSS();
    AppMethodBeat.o(20269);
    return localu;
  }
  
  public static bw aST()
  {
    AppMethodBeat.i(20270);
    bw localbw = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST();
    AppMethodBeat.o(20270);
    return localbw;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b aSU()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bz aSV()
  {
    AppMethodBeat.i(20272);
    bz localbz = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
    AppMethodBeat.o(20272);
    return localbz;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l aSW()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.l locall = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW();
    AppMethodBeat.o(20273);
    return locall;
  }
  
  public static ap aSX()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    AppMethodBeat.o(20274);
    return localap;
  }
  
  public static String aSY()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.aSY();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String aSZ()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.aSZ();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String aTa()
  {
    AppMethodBeat.i(20277);
    String str = com.tencent.mm.modelvoice.s.aTa();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String aTb()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.b.aTb();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String aTc()
  {
    AppMethodBeat.i(20279);
    String str = com.tencent.mm.storage.ap.aTc();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String aTd()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String aTe()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String aTf()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.h.a.aTf();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String aTg()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String aTh()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.al.q)com.tencent.mm.kernel.g.af(com.tencent.mm.al.q.class)).aTh();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String aTi()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAi();
    localObject = com.tencent.mm.kernel.g.aAh().hqG + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String aTj()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String aTk()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static com.tencent.mm.storage.g aTp()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.bqE().aTp();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c aTq()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aTq();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static String azL()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().azL();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String azM()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static String azN()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().azN();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String azO()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().azO();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static ao azQ()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.g.aAi();
    ao localao = com.tencent.mm.kernel.g.aAh().azQ();
    AppMethodBeat.o(20263);
    return localao;
  }
  
  public static void azS()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().azS();
    AppMethodBeat.o(20251);
  }
  
  public static void azl()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azl();
    AppMethodBeat.o(20257);
  }
  
  public static boolean azn()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.g.aAi();
    boolean bool = com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static void b(bc parambc)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().b(parambc);
    AppMethodBeat.o(20256);
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    y.rN(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bp.a("medianote", null);
      bg.aVF();
      aST().bjW("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().CL(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.g.aAi();
    String str = com.tencent.mm.kernel.g.aAh().hqG;
    AppMethodBeat.o(20294);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(20287);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
    AppMethodBeat.o(20287);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(20288);
    String str = ((com.tencent.mm.plugin.sns.b.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(20288);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(20281);
    com.tencent.mm.modelvideo.o.bhi();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h getDataDB()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.aAh().hqK;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static cf getNotifyMessageRecordStorage()
  {
    AppMethodBeat.i(231536);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    cf localcf = ((com.tencent.mm.plugin.notifymessage.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notifymessage.a.class)).getNotifyMessageRecordStorage();
    AppMethodBeat.o(231536);
    return localcf;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.g.aAi();
    boolean bool = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public final void aTl()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.g.aAh().cachePath;
    String str2 = com.tencent.mm.kernel.g.aAh().hqG;
    String[] arrayOfString = new com.tencent.mm.vfs.o(str1).a(new w()
    {
      public final boolean accept(com.tencent.mm.vfs.o paramAnonymouso, String paramAnonymousString)
      {
        AppMethodBeat.i(231534);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg_encrypt.db")))
        {
          AppMethodBeat.o(231534);
          return true;
        }
        AppMethodBeat.o(231534);
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
      com.tencent.mm.vfs.s.deleteFile(str4);
      com.tencent.mm.vfs.s.nw(str1 + str3, str4);
      Log.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c aTm()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.model.b.c localc = this.iBs;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d aTn()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.model.b.d locald = this.iBt;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b aTo()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.model.b.b localb = this.iBx;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final k aTr()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    k localk = this.iBu;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final com.tencent.mm.storage.o aTs()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.storage.o localo = this.iBv;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final com.tencent.mm.storage.m aTt()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAf().azk();
    com.tencent.mm.storage.m localm = this.iBw;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void fo(boolean paramBoolean);
  }
  
  static final class b
    implements Runnable
  {
    String from;
    String to;
    
    public b(String paramString1, String paramString2)
    {
      this.from = paramString1;
      this.to = paramString2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20247);
      if ((Util.isNullOrNil(this.from)) || (Util.isNullOrNil(this.to)))
      {
        AppMethodBeat.o(20247);
        return;
      }
      Log.i("MicroMsg.AccountStorage", "MoveDataFiles :" + this.from + " to :" + this.to);
      if (!com.tencent.mm.compatible.util.e.apn())
      {
        AppMethodBeat.o(20247);
        return;
      }
      if (!this.to.substring(0, com.tencent.mm.loader.j.b.aKJ().length()).equals(com.tencent.mm.loader.j.b.aKJ()))
      {
        AppMethodBeat.o(20247);
        return;
      }
      com.tencent.mm.vfs.s.cL(this.from + "image/", this.to + "image/");
      com.tencent.mm.vfs.s.cL(this.from + "video/", this.to + "video/");
      com.tencent.mm.vfs.s.cL(this.from + "voice/", this.to + "voice/");
      com.tencent.mm.vfs.s.cL(this.from + "voice2/", this.to + "voice2/");
      com.tencent.mm.vfs.s.cL(this.from + "package/", this.to + "package/");
      com.tencent.mm.vfs.s.cL(this.from + "emoji/", this.to + "emoji/");
      com.tencent.mm.vfs.s.cL(this.from + "mailapp/", this.to + "mailapp/");
      com.tencent.mm.vfs.s.cL(this.from + "brandicon/", this.to + "brandicon/");
      AppMethodBeat.o(20247);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */