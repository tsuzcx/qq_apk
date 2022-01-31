package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, h.d> baseDBFactories;
  public br fkq;
  public bq fkr;
  com.tencent.mm.storage.h fks;
  com.tencent.mm.model.b.c fkt;
  com.tencent.mm.model.b.d fku;
  com.tencent.mm.storage.j fkv;
  n fkw;
  l fkx;
  com.tencent.mm.model.b.b fky;
  
  static
  {
    AppMethodBeat.i(16262);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new c.5());
    baseDBFactories.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new c.6());
    baseDBFactories.put(Integer.valueOf("BackupMoveTime".hashCode()), new c.7());
    baseDBFactories.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new c.8());
    baseDBFactories.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new c.9());
    AppMethodBeat.o(16262);
  }
  
  public c()
  {
    AppMethodBeat.i(16205);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    c.1 local1 = new c.1(this);
    locale.eHO.at(local1);
    com.tencent.mm.kernel.a.c.RX().add(new com.tencent.mm.kernel.api.b()
    {
      public final List<String> RR()
      {
        AppMethodBeat.i(16200);
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/" });
        AppMethodBeat.o(16200);
        return localLinkedList;
      }
    });
    com.tencent.mm.kernel.a.c.RX().add(new c.3(this));
    AppMethodBeat.o(16205);
  }
  
  public static void QR()
  {
    AppMethodBeat.i(16214);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QR();
    AppMethodBeat.o(16214);
  }
  
  public static String Ro()
  {
    AppMethodBeat.i(16210);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().Ro();
    AppMethodBeat.o(16210);
    return str;
  }
  
  public static String Rp()
  {
    AppMethodBeat.i(16250);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().cachePath;
    AppMethodBeat.o(16250);
    return str;
  }
  
  public static com.tencent.mm.cg.h Rq()
  {
    AppMethodBeat.i(16217);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.cg.h localh = com.tencent.mm.kernel.g.RL().eHS;
    AppMethodBeat.o(16217);
    return localh;
  }
  
  public static String Rr()
  {
    AppMethodBeat.i(16248);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().Rr();
    AppMethodBeat.o(16248);
    return str;
  }
  
  public static String Rs()
  {
    AppMethodBeat.i(16249);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().Rs();
    AppMethodBeat.o(16249);
    return str;
  }
  
  public static z Ru()
  {
    AppMethodBeat.i(16220);
    com.tencent.mm.kernel.g.RM();
    z localz = com.tencent.mm.kernel.g.RL().Ru();
    AppMethodBeat.o(16220);
    return localz;
  }
  
  public static void Rw()
  {
    AppMethodBeat.i(16208);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().Rw();
    AppMethodBeat.o(16208);
  }
  
  public static bd YA()
  {
    AppMethodBeat.i(16222);
    bd localbd = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA();
    AppMethodBeat.o(16222);
    return localbd;
  }
  
  public static m YB()
  {
    AppMethodBeat.i(16223);
    m localm = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YB();
    AppMethodBeat.o(16223);
    return localm;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.h YC()
  {
    AppMethodBeat.i(16224);
    com.tencent.mm.plugin.messenger.foundation.a.a.h localh = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ();
    AppMethodBeat.o(16224);
    return localh;
  }
  
  public static com.tencent.mm.storage.o YD()
  {
    AppMethodBeat.i(16225);
    com.tencent.mm.storage.o localo = ((com.tencent.mm.aj.o)com.tencent.mm.kernel.g.E(com.tencent.mm.aj.o.class)).YD();
    AppMethodBeat.o(16225);
    return localo;
  }
  
  public static p YE()
  {
    AppMethodBeat.i(16226);
    p localp = ((com.tencent.mm.aj.o)com.tencent.mm.kernel.g.E(com.tencent.mm.aj.o.class)).YE();
    AppMethodBeat.o(16226);
    return localp;
  }
  
  public static be YF()
  {
    AppMethodBeat.i(16227);
    be localbe = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF();
    AppMethodBeat.o(16227);
    return localbe;
  }
  
  public static com.tencent.mm.plugin.downloader.g.b YG()
  {
    AppMethodBeat.i(16228);
    com.tencent.mm.plugin.downloader.g.b localb = ((com.tencent.mm.plugin.downloader.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader.a.d.class)).YG();
    AppMethodBeat.o(16228);
    return localb;
  }
  
  public static bh YH()
  {
    AppMethodBeat.i(16229);
    bh localbh = ((com.tencent.mm.plugin.m.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.m.a.a.class)).YH();
    AppMethodBeat.o(16229);
    return localbh;
  }
  
  public static k YI()
  {
    AppMethodBeat.i(16230);
    k localk = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YI();
    AppMethodBeat.o(16230);
    return localk;
  }
  
  public static ag YJ()
  {
    AppMethodBeat.i(16231);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    ag localag = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ();
    AppMethodBeat.o(16231);
    return localag;
  }
  
  public static String YK()
  {
    AppMethodBeat.i(16232);
    String str = com.tencent.mm.plugin.i.c.YK();
    AppMethodBeat.o(16232);
    return str;
  }
  
  public static String YL()
  {
    AppMethodBeat.i(16233);
    String str = com.tencent.mm.plugin.i.c.YL();
    AppMethodBeat.o(16233);
    return str;
  }
  
  public static String YM()
  {
    AppMethodBeat.i(16234);
    String str = s.YM();
    AppMethodBeat.o(16234);
    return str;
  }
  
  public static String YN()
  {
    AppMethodBeat.i(16235);
    String str = com.tencent.mm.plugin.record.b.YN();
    AppMethodBeat.o(16235);
    return str;
  }
  
  public static String YO()
  {
    AppMethodBeat.i(16236);
    String str = aa.YO();
    AppMethodBeat.o(16236);
    return str;
  }
  
  public static String YP()
  {
    AppMethodBeat.i(16237);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "emoji/";
    AppMethodBeat.o(16237);
    return localObject;
  }
  
  public static String YQ()
  {
    AppMethodBeat.i(16239);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "image/shakeTranImg/";
    AppMethodBeat.o(16239);
    return localObject;
  }
  
  public static String YR()
  {
    AppMethodBeat.i(16240);
    String str = com.tencent.mm.plugin.h.a.YR();
    AppMethodBeat.o(16240);
    return str;
  }
  
  public static String YS()
  {
    AppMethodBeat.i(16241);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "attachment/";
    AppMethodBeat.o(16241);
    return localObject;
  }
  
  public static String YT()
  {
    AppMethodBeat.i(16242);
    String str = ((com.tencent.mm.aj.o)com.tencent.mm.kernel.g.E(com.tencent.mm.aj.o.class)).YT();
    AppMethodBeat.o(16242);
    return str;
  }
  
  public static String YU()
  {
    AppMethodBeat.i(16243);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RM();
    localObject = com.tencent.mm.kernel.g.RL().eHR + "record/";
    AppMethodBeat.o(16243);
    return localObject;
  }
  
  public static String YV()
  {
    AppMethodBeat.i(16246);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = getAccPath() + "voiceremind/";
    AppMethodBeat.o(16246);
    return localObject;
  }
  
  public static String YW()
  {
    AppMethodBeat.i(16247);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = getAccPath() + "wenote/";
    AppMethodBeat.o(16247);
    return localObject;
  }
  
  public static String Yv()
  {
    AppMethodBeat.i(16207);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().eHQ;
    AppMethodBeat.o(16207);
    return str;
  }
  
  public static boolean Yw()
  {
    AppMethodBeat.i(16215);
    com.tencent.mm.kernel.g.RM();
    boolean bool = com.tencent.mm.kernel.a.jM(com.tencent.mm.kernel.g.RJ().eHa);
    AppMethodBeat.o(16215);
    return bool;
  }
  
  public static int Yx()
  {
    AppMethodBeat.i(16216);
    com.tencent.mm.kernel.g.RM();
    int i = com.tencent.mm.kernel.g.RJ().eHb;
    AppMethodBeat.o(16216);
    return i;
  }
  
  public static com.tencent.mm.cg.h Yy()
  {
    AppMethodBeat.i(16218);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.cg.h localh = com.tencent.mm.kernel.g.RL().eHT;
    AppMethodBeat.o(16218);
    return localh;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.i Yz()
  {
    AppMethodBeat.i(16221);
    com.tencent.mm.plugin.messenger.foundation.a.a.i locali = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz();
    AppMethodBeat.o(16221);
    return locali;
  }
  
  public static com.tencent.mm.storage.g Zb()
  {
    AppMethodBeat.i(16257);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.storage.g localg = com.tencent.mm.plugin.c.a.asD().Zb();
    AppMethodBeat.o(16257);
    return localg;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c Zc()
  {
    AppMethodBeat.i(16258);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.plugin.messenger.foundation.a.a.c localc = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Zc();
    AppMethodBeat.o(16258);
    return localc;
  }
  
  public static void a(as paramas)
  {
    AppMethodBeat.i(16212);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.RJ();
    ab.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramas });
    synchronized (locala.eHc)
    {
      if (!locala.eHc.contains(paramas)) {
        locala.eHc.add(paramas);
      }
      AppMethodBeat.o(16212);
      return;
    }
  }
  
  public static void b(as paramas)
  {
    AppMethodBeat.i(16213);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.RJ();
    ab.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramas });
    synchronized (locala.eHc)
    {
      locala.eHc.remove(paramas);
      AppMethodBeat.o(16213);
      return;
    }
  }
  
  public static void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(16253);
    q.ks(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bf.a("medianote", null);
      aw.aaz();
      YF().arF("medianote");
    }
    AppMethodBeat.o(16253);
  }
  
  public static void closeDB()
  {
    AppMethodBeat.i(16211);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RL().kr(null);
    AppMethodBeat.o(16211);
  }
  
  public static String getAccPath()
  {
    AppMethodBeat.i(16251);
    com.tencent.mm.kernel.g.RM();
    String str = com.tencent.mm.kernel.g.RL().eHR;
    AppMethodBeat.o(16251);
    return str;
  }
  
  public static String getAccSnsPath()
  {
    AppMethodBeat.i(16244);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    AppMethodBeat.o(16244);
    return str;
  }
  
  public static String getAccSnsTmpPath()
  {
    AppMethodBeat.i(16245);
    String str = ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    AppMethodBeat.o(16245);
    return str;
  }
  
  public static String getAccVideoPath()
  {
    AppMethodBeat.i(16238);
    com.tencent.mm.modelvideo.o.alD();
    String str = com.tencent.mm.modelvideo.o.getAccVideoPath();
    AppMethodBeat.o(16238);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(16206);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    int i = com.tencent.mm.kernel.a.getUin();
    AppMethodBeat.o(16206);
    return i;
  }
  
  public static boolean isSDCardAvailable()
  {
    AppMethodBeat.i(16209);
    com.tencent.mm.kernel.g.RM();
    boolean bool = com.tencent.mm.kernel.g.RL().isSDCardAvailable();
    AppMethodBeat.o(16209);
    return bool;
  }
  
  public static SharedPreferences mC(String paramString)
  {
    AppMethodBeat.i(16219);
    com.tencent.mm.kernel.g.RM();
    paramString = com.tencent.mm.kernel.g.RL().mC(paramString);
    AppMethodBeat.o(16219);
    return paramString;
  }
  
  public final void YX()
  {
    AppMethodBeat.i(16252);
    Object localObject = new StringBuilder("mm");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    String str1 = com.tencent.mm.a.g.w(com.tencent.mm.kernel.a.getUin().getBytes());
    localObject = ac.eQv + str1 + "/";
    str1 = com.tencent.mm.compatible.util.e.eQz + str1 + "/";
    String[] arrayOfString = new com.tencent.mm.vfs.b((String)localObject).a(new com.tencent.mm.vfs.i()
    {
      public final boolean nf(String paramAnonymousString)
      {
        AppMethodBeat.i(16203);
        if ((paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg_encrypt.db")))
        {
          AppMethodBeat.o(16203);
          return true;
        }
        AppMethodBeat.o(16203);
        return false;
      }
    });
    if (arrayOfString == null)
    {
      AppMethodBeat.o(16252);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      String str3 = str1 + str2 + ".dump";
      com.tencent.mm.vfs.e.deleteFile(str3);
      com.tencent.mm.vfs.e.C((String)localObject + str2, str3);
      ab.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str3)));
      i += 1;
    }
    AppMethodBeat.o(16252);
  }
  
  public final com.tencent.mm.model.b.c YY()
  {
    AppMethodBeat.i(16254);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.model.b.c localc = this.fkt;
    AppMethodBeat.o(16254);
    return localc;
  }
  
  public final com.tencent.mm.model.b.d YZ()
  {
    AppMethodBeat.i(16255);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.model.b.d locald = this.fku;
    AppMethodBeat.o(16255);
    return locald;
  }
  
  public final com.tencent.mm.model.b.b Za()
  {
    AppMethodBeat.i(16256);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.model.b.b localb = this.fky;
    AppMethodBeat.o(16256);
    return localb;
  }
  
  public final com.tencent.mm.storage.j Zd()
  {
    AppMethodBeat.i(16259);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    com.tencent.mm.storage.j localj = this.fkv;
    AppMethodBeat.o(16259);
    return localj;
  }
  
  public final n Ze()
  {
    AppMethodBeat.i(16260);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    n localn = this.fkw;
    AppMethodBeat.o(16260);
    return localn;
  }
  
  public final l Zf()
  {
    AppMethodBeat.i(16261);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ().QQ();
    l locall = this.fkx;
    AppMethodBeat.o(16261);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */