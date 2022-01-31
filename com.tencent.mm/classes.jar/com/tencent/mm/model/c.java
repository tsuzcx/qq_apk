package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e.b;
import com.tencent.mm.model.b.d;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static HashMap<Integer, h.d> dgp;
  public bp dUh;
  public bo dUi;
  com.tencent.mm.storage.h dUj;
  com.tencent.mm.model.b.c dUk;
  d dUl;
  com.tencent.mm.storage.j dUm;
  n dUn;
  com.tencent.mm.storage.l dUo;
  com.tencent.mm.model.b.b dUp;
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new c.5());
    dgp.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new c.6());
    dgp.put(Integer.valueOf("BackupMoveTime".hashCode()), new c.7());
    dgp.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new c.8());
    dgp.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new c.9());
  }
  
  public c()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.DP();
    c.1 local1 = new c.1(this);
    locale.dKq.aj(local1);
    com.tencent.mm.kernel.a.c.DY().add(new com.tencent.mm.kernel.api.b()
    {
      public final List<String> collectStoragePaths()
      {
        LinkedList localLinkedList = new LinkedList();
        Collections.addAll(localLinkedList, new String[] { "image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/" });
        return localLinkedList;
      }
    });
    com.tencent.mm.kernel.a.c.DY().add(new c.3(this));
  }
  
  public static int CK()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    return com.tencent.mm.kernel.a.CK();
  }
  
  public static void CY()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CY();
  }
  
  public static bs DA()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().DA();
  }
  
  public static void DB()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().DB();
  }
  
  public static String Du()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Du();
  }
  
  public static com.tencent.mm.cf.h Dv()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKu;
  }
  
  public static String Dw()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Dw();
  }
  
  public static String Dx()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Dx();
  }
  
  public static z Dz()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().Dz();
  }
  
  public static com.tencent.mm.storage.p FA()
  {
    return ((com.tencent.mm.ai.o)com.tencent.mm.kernel.g.r(com.tencent.mm.ai.o.class)).FA();
  }
  
  public static be FB()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB();
  }
  
  public static com.tencent.mm.plugin.downloader.f.b FC()
  {
    return ((com.tencent.mm.plugin.downloader.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.downloader.a.c.class)).FC();
  }
  
  public static bh FD()
  {
    return ((com.tencent.mm.plugin.r.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.r.a.a.class)).FD();
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.j FE()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE();
  }
  
  public static af FF()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF();
  }
  
  public static String FG()
  {
    return com.tencent.mm.plugin.n.c.FG();
  }
  
  public static String FH()
  {
    return com.tencent.mm.plugin.n.c.FH();
  }
  
  public static String FI()
  {
    return q.FI();
  }
  
  public static String FJ()
  {
    return com.tencent.mm.plugin.record.b.FJ();
  }
  
  public static String FK()
  {
    return aa.FK();
  }
  
  public static String FL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "emoji/";
  }
  
  public static String FM()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "image/shakeTranImg/";
  }
  
  public static String FN()
  {
    return com.tencent.mm.plugin.k.a.FN();
  }
  
  public static String FO()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "attachment/";
  }
  
  public static String FP()
  {
    return ((com.tencent.mm.ai.o)com.tencent.mm.kernel.g.r(com.tencent.mm.ai.o.class)).FP();
  }
  
  public static String FQ()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt + "record/";
  }
  
  public static String FR()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return FU() + "voiceremind/";
  }
  
  public static String FS()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return FU() + "wenote/";
  }
  
  public static String FT()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().cachePath;
  }
  
  public static String FU()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKt;
  }
  
  public static void FW() {}
  
  public static String Fr()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKs;
  }
  
  public static boolean Fs()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.a.hw(com.tencent.mm.kernel.g.DN().dJB);
  }
  
  public static int Ft()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DN().dJC;
  }
  
  public static com.tencent.mm.cf.h Fu()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().dKv;
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.h Fv()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv();
  }
  
  public static com.tencent.mm.storage.bd Fw()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw();
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.l Fx()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fx();
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.g Fy()
  {
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO();
  }
  
  public static com.tencent.mm.storage.o Fz()
  {
    return ((com.tencent.mm.ai.o)com.tencent.mm.kernel.g.r(com.tencent.mm.ai.o.class)).Fz();
  }
  
  public static com.tencent.mm.storage.g Ga()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return com.tencent.mm.plugin.c.a.YT().Ga();
  }
  
  public static com.tencent.mm.plugin.messenger.foundation.a.a.c Gb()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Gb();
  }
  
  public static void a(aq paramaq)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.DN();
    y.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramaq });
    synchronized (locala.dJD)
    {
      if (!locala.dJD.contains(paramaq)) {
        locala.dJD.add(paramaq);
      }
      return;
    }
  }
  
  public static void b(aq paramaq)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.DN();
    y.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramaq });
    synchronized (locala.dJD)
    {
      locala.dJD.remove(paramaq);
      return;
    }
  }
  
  public static void closeDB()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().ek(null);
  }
  
  public static String getAccSnsPath()
  {
    return ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
  }
  
  public static String getAccSnsTmpPath()
  {
    return ((com.tencent.mm.plugin.sns.b.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
  }
  
  public static String getAccVideoPath()
  {
    com.tencent.mm.modelvideo.o.Sq();
    return com.tencent.mm.modelvideo.o.getAccVideoPath();
  }
  
  public static void gf(int paramInt)
  {
    p.hG(paramInt);
    if ((paramInt & 0x10) != 0)
    {
      bd.a("medianote", null);
      au.Hx();
      FB().abu("medianote");
    }
  }
  
  public static SharedPreferences gh(String paramString)
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().gh(paramString);
  }
  
  public static boolean isSDCardAvailable()
  {
    com.tencent.mm.kernel.g.DQ();
    return com.tencent.mm.kernel.g.DP().isSDCardAvailable();
  }
  
  public final void FV()
  {
    Object localObject = new StringBuilder("mm");
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN();
    String str1 = com.tencent.mm.a.g.o(com.tencent.mm.kernel.a.CK().getBytes());
    localObject = ac.dOP + str1 + "/";
    str1 = com.tencent.mm.compatible.util.e.bkH + str1 + "/";
    String[] arrayOfString = new com.tencent.mm.vfs.b((String)localObject).a(new i()
    {
      public final boolean gx(String paramAnonymousString)
      {
        return (paramAnonymousString.equals("EnMicroMsg.db")) || (paramAnonymousString.startsWith("EnMicroMsg.dberr")) || (paramAnonymousString.equals("FTS5IndexMicroMsg.db"));
      }
    });
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        String str3 = str1 + str2 + ".dump";
        com.tencent.mm.vfs.e.deleteFile(str3);
        com.tencent.mm.vfs.e.r((String)localObject + str2, str3);
        y.i("MicroMsg.AccountStorage", "Exported: " + str3);
        i += 1;
      }
    }
  }
  
  public final com.tencent.mm.model.b.c FX()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUk;
  }
  
  public final d FY()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUl;
  }
  
  public final com.tencent.mm.model.b.b FZ()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUp;
  }
  
  public final com.tencent.mm.storage.j Gc()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUm;
  }
  
  public final n Gd()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUn;
  }
  
  public final com.tencent.mm.storage.l Ge()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DN().CX();
    return this.dUo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c
 * JD-Core Version:    0.7.0.1
 */