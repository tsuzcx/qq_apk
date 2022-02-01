package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.wk;
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
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class i
  implements aw
{
  private static i tIb;
  private static HashMap<Integer, h.b> tIt;
  private com.tencent.mm.plugin.voip.video.i gDU;
  private g tIc;
  private com.tencent.mm.plugin.ipcall.model.d.a tId;
  private com.tencent.mm.plugin.ipcall.model.d.b tIe;
  public com.tencent.mm.plugin.ipcall.model.c.b tIf;
  private f tIg;
  private com.tencent.mm.plugin.ipcall.c tIh;
  private com.tencent.mm.plugin.ipcall.model.h.d tIi;
  private l tIj;
  private j tIk;
  private com.tencent.mm.plugin.ipcall.model.h.h tIl;
  private com.tencent.mm.plugin.voip.video.d tIm;
  private Context tIn;
  private long tIo;
  private com.tencent.mm.sdk.b.c tIp;
  private com.tencent.mm.sdk.b.c tIq;
  private com.tencent.mm.sdk.b.c tIr;
  private com.tencent.mm.sdk.b.c tIs;
  private cc.a tIu;
  private cc.a tIv;
  private cc.a tIw;
  
  static
  {
    AppMethodBeat.i(25405);
    tIb = null;
    HashMap localHashMap = new HashMap();
    tIt = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.model.h.d.SQL_CREATE;
      }
    });
    tIt.put(Integer.valueOf("IPCallRecord".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return l.SQL_CREATE;
      }
    });
    tIt.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    tIt.put(Integer.valueOf("IPCallMsg".hashCode()), new h.b()
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
    this.tIc = new g();
    this.tId = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.tIe = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.tIg = new f();
    this.tIh = new com.tencent.mm.plugin.ipcall.c();
    this.tIp = new com.tencent.mm.sdk.b.c() {};
    this.tIq = new com.tencent.mm.sdk.b.c() {};
    this.tIr = new com.tencent.mm.sdk.b.c() {};
    this.tIs = new com.tencent.mm.sdk.b.c() {};
    this.tIu = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(25388);
        ac.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ac.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25388);
          return;
        }
        Object localObject = bv.L(paramAnonymousa, "sysmsg");
        if (localObject == null)
        {
          ac.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
          AppMethodBeat.o(25388);
          return;
        }
        int i;
        if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountRedDotType"))
        {
          i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
          ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", new Object[] { Integer.valueOf(i) });
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GGr, Integer.valueOf(i));
        }
        for (;;)
        {
          int j;
          if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AcctRD"))
          {
            j = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AcctRD"), 0);
            ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", new Object[] { Integer.valueOf(j) });
            if (j != 0)
            {
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGq, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.wUl.f(13254, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
          }
          else
          {
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRD"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRD"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1285;
              }
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGD, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.wUl.f(13254, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label386:
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeRD"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeRD"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                break label1304;
              }
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGx, Boolean.TRUE);
              com.tencent.mm.plugin.report.service.h.wUl.f(13254, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            }
            label509:
            String str;
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWording");
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", new Object[] { str });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGw, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.PackagePurchaseWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.PackagePurchaseWording");
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", new Object[] { str });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGy, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountWording");
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", new Object[] { str });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGs, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.RechargeWordingVersion"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGH, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.TabWording");
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", new Object[] { str });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGC, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWording"))
            {
              str = (String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWording");
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", new Object[] { str });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGt, str);
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", new Object[] { Integer.valueOf(i) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGu, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", new Object[] { Integer.valueOf(i) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGv, Integer.valueOf(i));
            }
            if (((Map)localObject).containsKey(".sysmsg.WeChatOut.TabRedDotType"))
            {
              i = bs.getInt((String)((Map)localObject).get(".sysmsg.WeChatOut.TabRedDotType"), 0);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", new Object[] { Integer.valueOf(i) });
              com.tencent.mm.plugin.report.service.h.wUl.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGE, Integer.valueOf(i));
            }
            i = paramAnonymousa.indexOf("<ActivityInfo>");
            j = paramAnonymousa.indexOf("</ActivityInfo>");
            if ((i > 0) && (j > 0) && (j > i))
            {
              paramAnonymousa = paramAnonymousa.substring(i, j + 15);
              ac.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", new Object[] { paramAnonymousa });
              localObject = com.tencent.mm.plugin.ipcall.model.h.a.aiK(paramAnonymousa);
              if ((localObject == null) || (!bs.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Title)) || (!bs.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).Desc))) {
                break label1323;
              }
              ac.i("MicroMsg.SubCoreIPCall", "clear activity");
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGQ, Boolean.FALSE);
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGR, "");
            }
          }
          for (;;)
          {
            com.tencent.mm.sdk.b.a.GpY.l(new jy());
            com.tencent.mm.sdk.b.a.GpY.l(new wk());
            AppMethodBeat.o(25388);
            return;
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GGq, Boolean.FALSE);
            break;
            label1285:
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GGD, Boolean.FALSE);
            break label386;
            label1304:
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GGx, Boolean.FALSE);
            break label509;
            label1323:
            if (localObject != null)
            {
              if (!bs.isNullOrNil(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl)) {
                o.aFw().a(((com.tencent.mm.plugin.ipcall.model.h.a)localObject).ImgUrl, null);
              }
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGQ, Boolean.TRUE);
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GGR, paramAnonymousa);
            }
          }
          i = -1;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tIv = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(25383);
        ac.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
        Object localObject = paramAnonymousa.fXi;
        paramAnonymousa = z.a(paramAnonymousa.fXi.DPV);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ac.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25383);
          return;
        }
        paramAnonymousa = bv.L(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ac.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
          AppMethodBeat.o(25383);
          return;
        }
        com.tencent.mm.plugin.ipcall.model.h.h localh = i.cUE();
        long l = ((cu)localObject).vTO;
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
          i = bs.getInt((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType = i;
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime = bs.getLong((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.DescUrl"));
          if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl == null) {
            ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = "";
          }
          ac.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl });
          localh.insert((com.tencent.mm.sdk.e.c)localObject);
        }
        for (;;)
        {
          if (i != -1)
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GGG, Integer.valueOf(i));
          }
          az.ayM();
          com.tencent.mm.model.c.agA().set(ah.a.GGF, Boolean.TRUE);
          com.tencent.mm.plugin.report.service.h.wUl.f(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
          AppMethodBeat.o(25383);
          return;
          i = -1;
        }
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tIw = new i.3(this);
    AppMethodBeat.o(25389);
  }
  
  public static com.tencent.mm.plugin.ipcall.c cUA()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = cUt().tIh;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d cUB()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.g.agP().afT();
    if (cUt().tIi == null)
    {
      localObject = cUt();
      az.ayM();
      ((i)localObject).tIi = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.agw());
    }
    Object localObject = cUt().tIi;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l cUC()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.g.agP().afT();
    if (cUt().tIj == null)
    {
      localObject = cUt();
      az.ayM();
      ((i)localObject).tIj = new l(com.tencent.mm.model.c.agw());
    }
    Object localObject = cUt().tIj;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public static j cUD()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.g.agP().afT();
    if (cUt().tIk == null)
    {
      localObject = cUt();
      az.ayM();
      ((i)localObject).tIk = new j(com.tencent.mm.model.c.agw());
    }
    Object localObject = cUt().tIk;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h cUE()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.g.agP().afT();
    if (cUt().tIl == null)
    {
      localObject = cUt();
      az.ayM();
      ((i)localObject).tIl = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.agw());
    }
    Object localObject = cUt().tIl;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.i cUF()
  {
    AppMethodBeat.i(25401);
    if (cUt().gDU == null) {
      cUt().gDU = new com.tencent.mm.plugin.voip.video.i(ai.getContext());
    }
    com.tencent.mm.plugin.voip.video.i locali = cUt().gDU;
    AppMethodBeat.o(25401);
    return locali;
  }
  
  public static com.tencent.mm.plugin.voip.video.d cUG()
  {
    AppMethodBeat.i(25402);
    if (cUt().tIm == null) {
      cUt().tIm = new com.tencent.mm.plugin.voip.video.d(ai.getContext());
    }
    com.tencent.mm.plugin.voip.video.d locald = cUt().tIm;
    AppMethodBeat.o(25402);
    return locald;
  }
  
  public static i cUt()
  {
    AppMethodBeat.i(25390);
    if (tIb == null)
    {
      tIb = new i();
      az.ayG().a("plugin.ipcall", tIb);
    }
    i locali = tIb;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g cUv()
  {
    AppMethodBeat.i(25391);
    g localg = cUt().tIc;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a cUw()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = cUt().tId;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b cUx()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = cUt().tIe;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b cUy()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = cUt().tIf;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f cUz()
  {
    AppMethodBeat.i(25395);
    f localf = cUt().tIg;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public final void cUu()
  {
    AppMethodBeat.i(196000);
    this.tIf = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(196000);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return tIt;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.tIc;
    ((g)localObject).tHN.init();
    ((g)localObject).tHO.init();
    ((g)localObject).tHP.init();
    ((g)localObject).tHQ.init();
    ((g)localObject).tHR.init();
    ((g)localObject).tHS.init();
    ((g)localObject).tHT.init();
    ((g)localObject).tHU.init();
    ((g)localObject).tHN.a((a.a)localObject);
    ((g)localObject).tHP.a((a.a)localObject);
    ((g)localObject).tHQ.a((a.a)localObject);
    ((g)localObject).tHS.a((a.a)localObject);
    ((g)localObject).tHU.a((a.a)localObject);
    ((g)localObject).tHO.tIE = ((b.a)localObject);
    ((g)localObject).tHR.tIE = ((b.a)localObject);
    az.a(((g)localObject).tHY);
    b.init();
    localObject = d.cUk();
    com.tencent.mm.sdk.b.a.GpY.c(((d)localObject).tHA);
    localObject = e.cUn();
    com.tencent.mm.sdk.b.a.GpY.c(((e)localObject).iOv);
    az.getSysCmdMsgExtension().a("WeChatOut", this.tIu, true);
    az.getSysCmdMsgExtension().a("WeChatOutMsg", this.tIv, true);
    az.getSysCmdMsgExtension().a("WCONotify", this.tIw, true);
    com.tencent.mm.sdk.b.a.GpY.c(this.tIp);
    com.tencent.mm.sdk.b.a.GpY.c(this.tIq);
    com.tencent.mm.sdk.b.a.GpY.c(this.tIr);
    com.tencent.mm.sdk.b.a.GpY.c(this.tIs);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.tIg.cUo()) {
      this.tIh.ga(0, 0);
    }
    Object localObject = this.tIc;
    ((g)localObject).tHN.destroy();
    ((g)localObject).tHO.destroy();
    ((g)localObject).tHP.destroy();
    ((g)localObject).tHQ.destroy();
    ((g)localObject).tHR.destroy();
    ((g)localObject).tHT.destroy();
    az.b(((g)localObject).tHY);
    b.release();
    localObject = d.cUk();
    az.agi().b(159, (com.tencent.mm.ak.g)localObject);
    az.agi().b(160, (com.tencent.mm.ak.g)localObject);
    com.tencent.mm.sdk.b.a.GpY.d(((d)localObject).tHA);
    localObject = e.cUn();
    com.tencent.mm.sdk.b.a.GpY.d(((e)localObject).iOv);
    az.getSysCmdMsgExtension().b("WeChatOut", this.tIu, true);
    az.getSysCmdMsgExtension().b("WeChatOutMsg", this.tIv, true);
    az.getSysCmdMsgExtension().b("WCONotify", this.tIw, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.tIp);
    com.tencent.mm.sdk.b.a.GpY.d(this.tIq);
    com.tencent.mm.sdk.b.a.GpY.d(this.tIr);
    com.tencent.mm.sdk.b.a.GpY.d(this.tIs);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */