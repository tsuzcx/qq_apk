package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bh;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class i
  implements aw
{
  private static HashMap<Integer, h.b> sAK;
  private static i sAr;
  private j sAA;
  private com.tencent.mm.plugin.ipcall.model.h.h sAB;
  private com.tencent.mm.plugin.voip.video.i sAC;
  private com.tencent.mm.plugin.voip.video.d sAD;
  private Context sAE;
  private long sAF;
  private com.tencent.mm.sdk.b.c sAG;
  private com.tencent.mm.sdk.b.c sAH;
  private com.tencent.mm.sdk.b.c sAI;
  private com.tencent.mm.sdk.b.c sAJ;
  private cc.a sAL;
  private cc.a sAM;
  private cc.a sAN;
  private g sAs;
  private com.tencent.mm.plugin.ipcall.model.d.a sAt;
  private com.tencent.mm.plugin.ipcall.model.d.b sAu;
  public com.tencent.mm.plugin.ipcall.model.c.b sAv;
  private f sAw;
  private com.tencent.mm.plugin.ipcall.c sAx;
  private com.tencent.mm.plugin.ipcall.model.h.d sAy;
  private l sAz;
  
  static
  {
    AppMethodBeat.i(25405);
    sAr = null;
    HashMap localHashMap = new HashMap();
    sAK = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.model.h.d.SQL_CREATE;
      }
    });
    sAK.put(Integer.valueOf("IPCallRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    sAK.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    sAK.put(Integer.valueOf("IPCallMsg".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.model.h.h.SQL_CREATE;
      }
    });
    AppMethodBeat.o(25405);
  }
  
  public i()
  {
    AppMethodBeat.i(25389);
    this.sAs = new g();
    this.sAt = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.sAu = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.sAw = new f();
    this.sAx = new com.tencent.mm.plugin.ipcall.c();
    this.sAG = new com.tencent.mm.sdk.b.c() {};
    this.sAH = new com.tencent.mm.sdk.b.c() {};
    this.sAI = new com.tencent.mm.sdk.b.c() {};
    this.sAJ = new com.tencent.mm.sdk.b.c() {};
    this.sAL = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(25388);
        ad.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25388);
          return;
        }
        Object localObject = bw.K(paramAnonymousa, "sysmsg");
        if (localObject == null)
        {
          ad.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
          AppMethodBeat.o(25388);
          return;
        }
        int i;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
        {
          i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
          ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FiC, Integer.valueOf(i));
        }
        for (;;)
        {
          int j;
          if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
          {
            j = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
            ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
            if (j != 0)
            {
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiB, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.vKh.f(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
          }
          else
          {
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1285;
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiO, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.vKh.f(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label386:
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1304;
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiI, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.vKh.f(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label509:
            String str;
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiH, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiJ, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiD, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiS, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiN, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiE, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiF, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiG, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
            {
              i = bt.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.report.service.h.vKh.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.FiP, Integer.valueOf(i));
            }
            i = paramAnonymousa.indexOf("<ActivityInfo>");
            j = paramAnonymousa.indexOf("</ActivityInfo>");
            if ((i > 0) && (j > 0) && (j > i))
            {
              paramAnonymousa = paramAnonymousa.substring(i, j + 15);
              ad.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { paramAnonymousa });
              localObject = com.tencent.mm.plugin.ipcall.model.h.a.adS(paramAnonymousa);
              if ((localObject == null) || (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Title)) || (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Desc))) {
                break label1323;
              }
              ad.i("MicroMsg.SubCoreIPCall", "clear activity");
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fjb, Boolean.FALSE);
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fjc, "");
            }
          }
          for (;;)
          {
            com.tencent.mm.sdk.b.a.ESL.l(new jq());
            com.tencent.mm.sdk.b.a.ESL.l(new vz());
            AppMethodBeat.o(25388);
            return;
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.FiB, Boolean.FALSE);
            break;
            label1285:
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.FiO, Boolean.FALSE);
            break label386;
            label1304:
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.FiI, Boolean.FALSE);
            break label509;
            label1323:
            if (localObject != null)
            {
              if (!bt.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl)) {
                o.ayE().a(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl, null);
              }
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fjb, Boolean.TRUE);
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fjc, paramAnonymousa);
            }
          }
          i = -1;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.sAM = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(25383);
        ad.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
        Object localObject = paramAnonymousa.fTo;
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25383);
          return;
        }
        paramAnonymousa = bw.K(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
          AppMethodBeat.o(25383);
          return;
        }
        com.tencent.mm.plugin.ipcall.model.h.h localh = i.cHt();
        long l = ((cs)localObject).uKX;
        int i;
        if (paramAnonymousa != null)
        {
          localObject = new com.tencent.mm.plugin.ipcall.model.h.g();
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId = l;
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.Title"));
          if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title == null) {
            ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title = "";
          }
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.Content"));
          if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content == null) {
            ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content = "";
          }
          i = bt.getInt((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType = i;
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime = bt.getLong((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.DescUrl"));
          if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl == null) {
            ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = "";
          }
          ad.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl });
          localh.insert((com.tencent.mm.sdk.e.c)localObject);
        }
        for (;;)
        {
          if (i != -1)
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.FiR, Integer.valueOf(i));
          }
          az.arV();
          com.tencent.mm.model.c.afk().set(ae.a.FiQ, Boolean.TRUE);
          com.tencent.mm.plugin.report.service.h.vKh.f(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
          AppMethodBeat.o(25383);
          return;
          i = -1;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.sAN = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(25384);
        ad.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
        paramAnonymousa = z.a(paramAnonymousa.fTo.Cxz);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ad.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25384);
          return;
        }
        paramAnonymousa = bw.K(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ad.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
          AppMethodBeat.o(25384);
          return;
        }
        if (paramAnonymousa.containsKey(".sysmsg.WCONotify.NotifyGetBalance"))
        {
          int i = bt.getInt((String)paramAnonymousa.get(".sysmsg.WCONotify.NotifyGetBalance"), 0);
          ad.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", new Object[] { Integer.valueOf(i) });
          if (i > 0)
          {
            paramAnonymousa = new com.tencent.mm.plugin.ipcall.model.e.g(2);
            az.aeS().a(paramAnonymousa, 0);
          }
        }
        AppMethodBeat.o(25384);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(25389);
  }
  
  public static i cHi()
  {
    AppMethodBeat.i(25390);
    if (sAr == null)
    {
      sAr = new i();
      az.arP().a("plugin.ipcall", sAr);
    }
    i locali = sAr;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g cHk()
  {
    AppMethodBeat.i(25391);
    g localg = cHi().sAs;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a cHl()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = cHi().sAt;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b cHm()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = cHi().sAu;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b cHn()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = cHi().sAv;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f cHo()
  {
    AppMethodBeat.i(25395);
    f localf = cHi().sAw;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c cHp()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = cHi().sAx;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d cHq()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cHi().sAy == null)
    {
      localObject = cHi();
      az.arV();
      ((i)localObject).sAy = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.afg());
    }
    Object localObject = cHi().sAy;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l cHr()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cHi().sAz == null)
    {
      localObject = cHi();
      az.arV();
      ((i)localObject).sAz = new l(com.tencent.mm.model.c.afg());
    }
    Object localObject = cHi().sAz;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j cHs()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cHi().sAA == null)
    {
      localObject = cHi();
      az.arV();
      ((i)localObject).sAA = new j(com.tencent.mm.model.c.afg());
    }
    Object localObject = cHi().sAA;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h cHt()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cHi().sAB == null)
    {
      localObject = cHi();
      az.arV();
      ((i)localObject).sAB = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.afg());
    }
    Object localObject = cHi().sAB;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.i cHu()
  {
    AppMethodBeat.i(25401);
    if (cHi().sAC == null) {
      cHi().sAC = new com.tencent.mm.plugin.voip.video.i(aj.getContext());
    }
    com.tencent.mm.plugin.voip.video.i locali = cHi().sAC;
    AppMethodBeat.o(25401);
    return locali;
  }
  
  public static com.tencent.mm.plugin.voip.video.d cHv()
  {
    AppMethodBeat.i(25402);
    if (cHi().sAD == null) {
      cHi().sAD = new com.tencent.mm.plugin.voip.video.d(aj.getContext());
    }
    com.tencent.mm.plugin.voip.video.d locald = cHi().sAD;
    AppMethodBeat.o(25402);
    return locald;
  }
  
  public final void cHj()
  {
    AppMethodBeat.i(191184);
    this.sAv = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(191184);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return sAK;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.sAs;
    ((g)localObject).sAd.init();
    ((g)localObject).sAe.init();
    ((g)localObject).sAf.init();
    ((g)localObject).sAg.init();
    ((g)localObject).sAh.init();
    ((g)localObject).sAi.init();
    ((g)localObject).sAj.init();
    ((g)localObject).sAk.init();
    ((g)localObject).sAd.a((a.a)localObject);
    ((g)localObject).sAf.a((a.a)localObject);
    ((g)localObject).sAg.a((a.a)localObject);
    ((g)localObject).sAi.a((a.a)localObject);
    ((g)localObject).sAk.a((a.a)localObject);
    ((g)localObject).sAe.sAV = ((b.a)localObject);
    ((g)localObject).sAh.sAV = ((b.a)localObject);
    az.a(((g)localObject).sAo);
    b.init();
    localObject = d.cGZ();
    com.tencent.mm.sdk.b.a.ESL.c(((d)localObject).szQ);
    localObject = e.cHc();
    com.tencent.mm.sdk.b.a.ESL.c(((e)localObject).iop);
    az.getSysCmdMsgExtension().a("WeChatOut", this.sAL, true);
    az.getSysCmdMsgExtension().a("WeChatOutMsg", this.sAM, true);
    az.getSysCmdMsgExtension().a("WCONotify", this.sAN, true);
    com.tencent.mm.sdk.b.a.ESL.c(this.sAG);
    com.tencent.mm.sdk.b.a.ESL.c(this.sAH);
    com.tencent.mm.sdk.b.a.ESL.c(this.sAI);
    com.tencent.mm.sdk.b.a.ESL.c(this.sAJ);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.sAw.cHd()) {
      this.sAx.fT(0, 0);
    }
    Object localObject = this.sAs;
    ((g)localObject).sAd.destroy();
    ((g)localObject).sAe.destroy();
    ((g)localObject).sAf.destroy();
    ((g)localObject).sAg.destroy();
    ((g)localObject).sAh.destroy();
    ((g)localObject).sAj.destroy();
    az.b(((g)localObject).sAo);
    b.release();
    localObject = d.cGZ();
    az.aeS().b(159, (com.tencent.mm.al.g)localObject);
    az.aeS().b(160, (com.tencent.mm.al.g)localObject);
    com.tencent.mm.sdk.b.a.ESL.d(((d)localObject).szQ);
    localObject = e.cHc();
    com.tencent.mm.sdk.b.a.ESL.d(((e)localObject).iop);
    az.getSysCmdMsgExtension().b("WeChatOut", this.sAL, true);
    az.getSysCmdMsgExtension().b("WeChatOutMsg", this.sAM, true);
    az.getSysCmdMsgExtension().b("WCONotify", this.sAN, true);
    com.tencent.mm.sdk.b.a.ESL.d(this.sAG);
    com.tencent.mm.sdk.b.a.ESL.d(this.sAH);
    com.tencent.mm.sdk.b.a.ESL.d(this.sAI);
    com.tencent.mm.sdk.b.a.ESL.d(this.sAJ);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */