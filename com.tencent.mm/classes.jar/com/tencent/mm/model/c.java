package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.h.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, h.b> baseDBFactories;
  com.tencent.mm.storage.h gLA;
  com.tencent.mm.storage.i gLB;
  com.tencent.mm.model.b.c gLC;
  com.tencent.mm.model.b.d gLD;
  com.tencent.mm.storage.k gLE;
  com.tencent.mm.storage.o gLF;
  com.tencent.mm.storage.m gLG;
  com.tencent.mm.model.b.b gLH;
  public bu gLy;
  public bt gLz;
  
  static
  {
    AppMethodBeat.i(20305);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ax.SQL_CREATE;
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    h.a local1 = new h.a()
    {
      public final void afr()
      {
        AppMethodBeat.i(20242);
        com.tencent.mm.kernel.g.afC();
        if (com.tencent.mm.kernel.g.afw())
        {
          com.tencent.mm.modelstat.m localm = com.tencent.mm.modelstat.q.aBQ();
          if (localm != null)
          {
            ad.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
            long l = System.currentTimeMillis();
            localm.hwP.uV(true);
            ad.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
          }
        }
        AppMethodBeat.o(20242);
      }
      
      public final void afs() {}
      
      public final void aft() {}
    };
    locale.gcT.bv(local1);
    com.tencent.mm.kernel.a.c.afO().add(new com.tencent.mm.kernel.api.b()
    {
      public final List<String> afI()
      {
        AppMethodBeat.i(20243);
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "mailapp/", "favoffline/", "voice2/", "video/", "attachment/" });
        AppMethodBeat.o(20243);
        return localLinkedList;
      }
    });
    com.tencent.mm.kernel.a.c.afO().add(new f()
    {
      public final void afJ()
      {
        AppMethodBeat.i(20244);
        az.arU();
        AppMethodBeat.o(20244);
      }
      
      public final void qW(String paramAnonymousString)
      {
        AppMethodBeat.i(20245);
        if (com.tencent.mm.compatible.util.e.XG())
        {
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afB().gcV.equals(com.tencent.mm.loader.j.b.aih()))
          {
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.sdk.g.b.c(new c.b(com.tencent.mm.kernel.g.afB().cachePath, paramAnonymousString), "AccountStorage_moveDataFiles");
          }
        }
        AppMethodBeat.o(20245);
      }
    });
    AppMethodBeat.o(20248);
  }
  
  public static void a(av paramav)
  {
    AppMethodBeat.i(20255);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().a(paramav);
    AppMethodBeat.o(20255);
  }
  
  public static void aeE()
  {
    AppMethodBeat.i(20257);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeE();
    AppMethodBeat.o(20257);
  }
  
  public static boolean aeG()
  {
    AppMethodBeat.i(20258);
    com.tencent.mm.kernel.g.afC();
    boolean bool = com.tencent.mm.kernel.a.mp(com.tencent.mm.kernel.g.afz().gch);
    AppMethodBeat.o(20258);
    return bool;
  }
  
  public static String afe()
  {
    AppMethodBeat.i(20253);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().afe();
    AppMethodBeat.o(20253);
    return str;
  }
  
  public static String aff()
  {
    AppMethodBeat.i(20293);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().cachePath;
    AppMethodBeat.o(20293);
    return str;
  }
  
  public static com.tencent.mm.storagebase.h afg()
  {
    AppMethodBeat.i(20260);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.afB().gda;
    AppMethodBeat.o(20260);
    return localh;
  }
  
  public static String afh()
  {
    AppMethodBeat.i(20291);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().afh();
    AppMethodBeat.o(20291);
    return str;
  }
  
  public static String afi()
  {
    AppMethodBeat.i(20292);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().afi();
    AppMethodBeat.o(20292);
    return str;
  }
  
  public static ab afk()
  {
    AppMethodBeat.i(20263);
    com.tencent.mm.kernel.g.afC();
    ab localab = com.tencent.mm.kernel.g.afB().afk();
    AppMethodBeat.o(20263);
    return localab;
  }
  
  public static void afm()
  {
    AppMethodBeat.i(20251);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().afm();
    AppMethodBeat.o(20251);
  }
  
  public static String apI()
  {
    AppMethodBeat.i(20250);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().gcV;
    AppMethodBeat.o(20250);
    return str;
  }
  
  public static int apJ()
  {
    AppMethodBeat.i(20259);
    com.tencent.mm.kernel.g.afC();
    int i = com.tencent.mm.kernel.g.afz().gci;
    AppMethodBeat.o(20259);
    return i;
  }
  
  public static com.tencent.mm.storagebase.h apK()
  {
    AppMethodBeat.i(20261);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.g.afB().gdb;
    AppMethodBeat.o(20261);
    return localh;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i apL()
  {
    AppMethodBeat.i(20264);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL();
    AppMethodBeat.o(20264);
    return locali;
  }
  
  public static com.tencent.mm.storage.bg apM()
  {
    AppMethodBeat.i(20265);
    com.tencent.mm.storage.bg localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
    AppMethodBeat.o(20265);
    return localbg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.m apN()
  {
    AppMethodBeat.i(20266);
    com.tencent.mm.plugin.messenger.foundation.a.a.m localm = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN();
    AppMethodBeat.o(20266);
    return localm;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.h apO()
  {
    AppMethodBeat.i(20267);
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI();
    AppMethodBeat.o(20267);
    return localh;
  }
  
  public static com.tencent.mm.storage.p apP()
  {
    AppMethodBeat.i(20268);
    com.tencent.mm.storage.p localp = ((com.tencent.mm.am.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.p.class)).apP();
    AppMethodBeat.o(20268);
    return localp;
  }
  
  public static com.tencent.mm.storage.q apQ()
  {
    AppMethodBeat.i(20269);
    com.tencent.mm.storage.q localq = ((com.tencent.mm.am.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.p.class)).apQ();
    AppMethodBeat.o(20269);
    return localq;
  }
  
  public static bh apR()
  {
    AppMethodBeat.i(20270);
    bh localbh = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR();
    AppMethodBeat.o(20270);
    return localbh;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b apS()
  {
    AppMethodBeat.i(20271);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader.a.d.class)).apS();
    AppMethodBeat.o(20271);
    return localb;
  }
  
  public static bk apT()
  {
    AppMethodBeat.i(20272);
    bk localbk = ((com.tencent.mm.plugin.n.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.n.a.a.class)).apT();
    AppMethodBeat.o(20272);
    return localbk;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.k apU()
  {
    AppMethodBeat.i(20273);
    com.tencent.mm.plugin.messenger.foundation.a.a.k localk = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU();
    AppMethodBeat.o(20273);
    return localk;
  }
  
  public static aj apV()
  {
    AppMethodBeat.i(20274);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV();
    AppMethodBeat.o(20274);
    return localaj;
  }
  
  public static String apW()
  {
    AppMethodBeat.i(20275);
    String str = com.tencent.mm.plugin.image.d.apW();
    AppMethodBeat.o(20275);
    return str;
  }
  
  public static String apX()
  {
    AppMethodBeat.i(20276);
    String str = com.tencent.mm.plugin.image.d.apX();
    AppMethodBeat.o(20276);
    return str;
  }
  
  public static String apY()
  {
    AppMethodBeat.i(20277);
    String str = s.apY();
    AppMethodBeat.o(20277);
    return str;
  }
  
  public static String apZ()
  {
    AppMethodBeat.i(20278);
    String str = com.tencent.mm.plugin.record.b.apZ();
    AppMethodBeat.o(20278);
    return str;
  }
  
  public static String aqa()
  {
    AppMethodBeat.i(20279);
    String str = ac.aqa();
    AppMethodBeat.o(20279);
    return str;
  }
  
  public static String aqb()
  {
    AppMethodBeat.i(20280);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "emoji/";
    AppMethodBeat.o(20280);
    return localObject;
  }
  
  public static String aqc()
  {
    AppMethodBeat.i(20282);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "image/shakeTranImg/";
    AppMethodBeat.o(20282);
    return localObject;
  }
  
  public static String aqd()
  {
    AppMethodBeat.i(20283);
    String str = com.tencent.mm.plugin.h.a.aqd();
    AppMethodBeat.o(20283);
    return str;
  }
  
  public static String aqe()
  {
    AppMethodBeat.i(20284);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "attachment/";
    AppMethodBeat.o(20284);
    return localObject;
  }
  
  public static String aqf()
  {
    AppMethodBeat.i(20285);
    String str = ((com.tencent.mm.am.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.am.p.class)).aqf();
    AppMethodBeat.o(20285);
    return str;
  }
  
  public static String aqg()
  {
    AppMethodBeat.i(20286);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    localObject = com.tencent.mm.kernel.g.afB().gcW + "record/";
    AppMethodBeat.o(20286);
    return localObject;
  }
  
  public static String aqh()
  {
    AppMethodBeat.i(20289);
    Object localObject = new StringBuilder();
    az.arV();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(20289);
    return localObject;
  }
  
  public static String aqi()
  {
    AppMethodBeat.i(20290);
    Object localObject = new StringBuilder();
    az.arV();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(20290);
    return localObject;
  }
  
  public static com.tencent.mm.storage.g aqn()
  {
    AppMethodBeat.i(20300);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.aLf().aqn();
    AppMethodBeat.o(20300);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c aqo()
  {
    AppMethodBeat.i(20301);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).aqo();
    AppMethodBeat.o(20301);
    return localc;
  }
  
  public static void b(av paramav)
  {
    AppMethodBeat.i(20256);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().b(paramav);
    AppMethodBeat.o(20256);
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(20296);
    t.mX(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bi.a("medianote", null);
      az.arV();
      apR().aIl("medianote");
    }
    AppMethodBeat.o(20296);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(20254);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afB().oi(null);
    AppMethodBeat.o(20254);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(20294);
    com.tencent.mm.kernel.g.afC();
    String str = com.tencent.mm.kernel.g.afB().gcW;
    AppMethodBeat.o(20294);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(20287);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsPath();
    AppMethodBeat.o(20287);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(20288);
    String str = ((com.tencent.mm.plugin.sns.c.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.sns.c.c.class)).getAccSnsTmpPath();
    AppMethodBeat.o(20288);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(20281);
    com.tencent.mm.modelvideo.o.aCH();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(20281);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(20249);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(20249);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(20252);
    com.tencent.mm.kernel.g.afC();
    boolean bool = com.tencent.mm.kernel.g.afB().isSDCardAvailable();
    AppMethodBeat.o(20252);
    return bool;
  }
  
  public static SharedPreferences qR(String paramString)
  {
    AppMethodBeat.i(20262);
    com.tencent.mm.kernel.g.afC();
    paramString = com.tencent.mm.kernel.g.afB().qR(paramString);
    AppMethodBeat.o(20262);
    return paramString;
  }
  
  public final void aqj()
  {
    AppMethodBeat.i(20295);
    String str1 = com.tencent.mm.kernel.g.afB().cachePath;
    String str2 = com.tencent.mm.kernel.g.afB().gcW;
    String[] arrayOfString = new com.tencent.mm.vfs.e(str1).a(new com.tencent.mm.vfs.m()
    {
      public final boolean qT(String paramAnonymousString)
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
      com.tencent.mm.vfs.i.lC(str1 + str3, str4);
      ad.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
      i += 1;
    }
    AppMethodBeat.o(20295);
  }
  
  public final com.tencent.mm.model.b.c aqk()
  {
    AppMethodBeat.i(20297);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.model.b.c localc = this.gLC;
    AppMethodBeat.o(20297);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d aql()
  {
    AppMethodBeat.i(20298);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.model.b.d locald = this.gLD;
    AppMethodBeat.o(20298);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b aqm()
  {
    AppMethodBeat.i(20299);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.model.b.b localb = this.gLH;
    AppMethodBeat.o(20299);
    return localb;
  }
  
  public final com.tencent.mm.storage.k aqp()
  {
    AppMethodBeat.i(20302);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.storage.k localk = this.gLE;
    AppMethodBeat.o(20302);
    return localk;
  }
  
  public final com.tencent.mm.storage.o aqq()
  {
    AppMethodBeat.i(20303);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.storage.o localo = this.gLF;
    AppMethodBeat.o(20303);
    return localo;
  }
  
  public final com.tencent.mm.storage.m aqr()
  {
    AppMethodBeat.i(20304);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afz().aeD();
    com.tencent.mm.storage.m localm = this.gLG;
    AppMethodBeat.o(20304);
    return localm;
  }
  
  public static abstract interface a
  {
    public abstract void dZ(boolean paramBoolean);
  }
  
  static final class b
    implements Runnable
  {
    String dvh;
    String gLJ;
    
    public b(String paramString1, String paramString2)
    {
      this.dvh = paramString1;
      this.gLJ = paramString2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(20247);
      if ((com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.dvh)) || (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(this.gLJ)))
      {
        AppMethodBeat.o(20247);
        return;
      }
      ad.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.dvh + " to :" + this.gLJ);
      if (!com.tencent.mm.compatible.util.e.XG())
      {
        AppMethodBeat.o(20247);
        return;
      }
      if (!this.gLJ.substring(0, com.tencent.mm.loader.j.b.aih().length()).equals(com.tencent.mm.loader.j.b.aih()))
      {
        AppMethodBeat.o(20247);
        return;
      }
      com.tencent.mm.vfs.i.lF(this.dvh + "image/", this.gLJ + "image/");
      if (!com.tencent.mm.vfs.p.fil()) {
        com.tencent.mm.vfs.i.lF(this.dvh + "image2/", this.gLJ + "image2/");
      }
      com.tencent.mm.vfs.i.lF(this.dvh + "video/", this.gLJ + "video/");
      com.tencent.mm.vfs.i.lF(this.dvh + "voice/", this.gLJ + "voice/");
      com.tencent.mm.vfs.i.lF(this.dvh + "voice2/", this.gLJ + "voice2/");
      com.tencent.mm.vfs.i.lF(this.dvh + "package/", this.gLJ + "package/");
      com.tencent.mm.vfs.i.lF(this.dvh + "emoji/", this.gLJ + "emoji/");
      com.tencent.mm.vfs.i.lF(this.dvh + "mailapp/", this.gLJ + "mailapp/");
      com.tencent.mm.vfs.i.lF(this.dvh + "brandicon/", this.gLJ + "brandicon/");
      AppMethodBeat.o(20247);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */