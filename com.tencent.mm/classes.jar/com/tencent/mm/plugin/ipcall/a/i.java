package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.b.a;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public final class i
  implements at
{
  private static HashMap<Integer, h.d> nMR;
  private static i nMy;
  private com.tencent.mm.plugin.ipcall.a.c.a nMA;
  private com.tencent.mm.plugin.ipcall.a.c.b nMB;
  private com.tencent.mm.plugin.ipcall.a.b.b nMC;
  private f nMD;
  private com.tencent.mm.plugin.ipcall.c nME;
  private com.tencent.mm.plugin.ipcall.a.g.d nMF;
  private l nMG;
  private j nMH;
  private com.tencent.mm.plugin.ipcall.a.g.h nMI;
  private com.tencent.mm.plugin.voip.video.h nMJ;
  private com.tencent.mm.plugin.voip.video.d nMK;
  private Context nML;
  private long nMM;
  private com.tencent.mm.sdk.b.c nMN;
  private com.tencent.mm.sdk.b.c nMO;
  private com.tencent.mm.sdk.b.c nMP;
  private com.tencent.mm.sdk.b.c nMQ;
  private bz.a nMS;
  private bz.a nMT;
  private bz.a nMU;
  private g nMz;
  
  static
  {
    AppMethodBeat.i(21790);
    nMy = null;
    HashMap localHashMap = new HashMap();
    nMR = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.ipcall.a.g.d.SQL_CREATE;
      }
    });
    nMR.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    nMR.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return j.SQL_CREATE;
      }
    });
    nMR.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
    AppMethodBeat.o(21790);
  }
  
  public i()
  {
    AppMethodBeat.i(21774);
    this.nMz = new g();
    this.nMA = new com.tencent.mm.plugin.ipcall.a.c.a();
    this.nMB = new com.tencent.mm.plugin.ipcall.a.c.b();
    this.nMC = new com.tencent.mm.plugin.ipcall.a.b.b();
    this.nMD = new f();
    this.nME = new com.tencent.mm.plugin.ipcall.c();
    this.nMN = new i.1(this);
    this.nMO = new i.4(this);
    this.nMP = new i.5(this);
    this.nMQ = new i.6(this);
    this.nMS = new i.11(this);
    this.nMT = new bz.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(21765);
        ab.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
        Object localObject = paramAnonymousa.eyJ;
        paramAnonymousa = aa.a(paramAnonymousa.eyJ.woR);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          ab.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
          AppMethodBeat.o(21765);
          return;
        }
        paramAnonymousa = br.F(paramAnonymousa, "sysmsg");
        if (paramAnonymousa == null)
        {
          ab.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
          AppMethodBeat.o(21765);
          return;
        }
        com.tencent.mm.plugin.ipcall.a.g.h localh = i.bJw();
        long l = ((cm)localObject).pIE;
        int i;
        if (paramAnonymousa != null)
        {
          localObject = new com.tencent.mm.plugin.ipcall.a.g.g();
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_svrId = l;
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_title = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.Title"));
          if (((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_title == null) {
            ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_title = "";
          }
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_content = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.Content"));
          if (((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_content == null) {
            ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_content = "";
          }
          i = bo.getInt((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_msgType = i;
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_pushTime = bo.getLong((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
          ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_descUrl = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.DescUrl"));
          if (((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_descUrl == null) {
            ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_descUrl = "";
          }
          ab.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_svrId, ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_title, ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_content, ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_msgType, ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_pushTime, ((com.tencent.mm.plugin.ipcall.a.g.g)localObject).field_descUrl });
          localh.insert((com.tencent.mm.sdk.e.c)localObject);
        }
        for (;;)
        {
          if (i != -1)
          {
            aw.aaz();
            com.tencent.mm.model.c.Ru().set(ac.a.yAv, Integer.valueOf(i));
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAu, Boolean.TRUE);
          com.tencent.mm.plugin.report.service.h.qsU.e(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
          AppMethodBeat.o(21765);
          return;
          i = -1;
        }
      }
    };
    this.nMU = new i.3(this);
    AppMethodBeat.o(21774);
  }
  
  public static i bJm()
  {
    AppMethodBeat.i(21775);
    if (nMy == null)
    {
      nMy = new i();
      aw.aat().a("plugin.ipcall", nMy);
    }
    i locali = nMy;
    AppMethodBeat.o(21775);
    return locali;
  }
  
  public static g bJn()
  {
    AppMethodBeat.i(21776);
    g localg = bJm().nMz;
    AppMethodBeat.o(21776);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.c.a bJo()
  {
    AppMethodBeat.i(21777);
    com.tencent.mm.plugin.ipcall.a.c.a locala = bJm().nMA;
    AppMethodBeat.o(21777);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.c.b bJp()
  {
    AppMethodBeat.i(21778);
    com.tencent.mm.plugin.ipcall.a.c.b localb = bJm().nMB;
    AppMethodBeat.o(21778);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.b.b bJq()
  {
    AppMethodBeat.i(21779);
    com.tencent.mm.plugin.ipcall.a.b.b localb = bJm().nMC;
    AppMethodBeat.o(21779);
    return localb;
  }
  
  public static f bJr()
  {
    AppMethodBeat.i(21780);
    f localf = bJm().nMD;
    AppMethodBeat.o(21780);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c bJs()
  {
    AppMethodBeat.i(21781);
    com.tencent.mm.plugin.ipcall.c localc = bJm().nME;
    AppMethodBeat.o(21781);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.g.d bJt()
  {
    AppMethodBeat.i(21782);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bJm().nMF == null)
    {
      localObject = bJm();
      aw.aaz();
      ((i)localObject).nMF = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bJm().nMF;
    AppMethodBeat.o(21782);
    return localObject;
  }
  
  public static l bJu()
  {
    AppMethodBeat.i(21783);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bJm().nMG == null)
    {
      localObject = bJm();
      aw.aaz();
      ((i)localObject).nMG = new l(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bJm().nMG;
    AppMethodBeat.o(21783);
    return localObject;
  }
  
  public static j bJv()
  {
    AppMethodBeat.i(21784);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bJm().nMH == null)
    {
      localObject = bJm();
      aw.aaz();
      ((i)localObject).nMH = new j(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bJm().nMH;
    AppMethodBeat.o(21784);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.a.g.h bJw()
  {
    AppMethodBeat.i(21785);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (bJm().nMI == null)
    {
      localObject = bJm();
      aw.aaz();
      ((i)localObject).nMI = new com.tencent.mm.plugin.ipcall.a.g.h(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bJm().nMI;
    AppMethodBeat.o(21785);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.h bJx()
  {
    AppMethodBeat.i(21786);
    if (bJm().nMJ == null) {
      bJm().nMJ = new com.tencent.mm.plugin.voip.video.h(ah.getContext());
    }
    com.tencent.mm.plugin.voip.video.h localh = bJm().nMJ;
    AppMethodBeat.o(21786);
    return localh;
  }
  
  public static com.tencent.mm.plugin.voip.video.d bJy()
  {
    AppMethodBeat.i(21787);
    if (bJm().nMK == null) {
      bJm().nMK = new com.tencent.mm.plugin.voip.video.d(ah.getContext());
    }
    com.tencent.mm.plugin.voip.video.d locald = bJm().nMK;
    AppMethodBeat.o(21787);
    return locald;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return nMR;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(21788);
    Object localObject = this.nMz;
    ((g)localObject).nMk.init();
    ((g)localObject).nMl.init();
    ((g)localObject).nMm.init();
    ((g)localObject).nMn.init();
    ((g)localObject).nMo.init();
    ((g)localObject).nMp.init();
    ((g)localObject).nMq.init();
    ((g)localObject).nMr.init();
    ((g)localObject).nMk.a((a.a)localObject);
    ((g)localObject).nMm.a((a.a)localObject);
    ((g)localObject).nMn.a((a.a)localObject);
    ((g)localObject).nMp.a((a.a)localObject);
    ((g)localObject).nMr.a((a.a)localObject);
    ((g)localObject).nMl.nMX = ((b.a)localObject);
    ((g)localObject).nMo.nMX = ((b.a)localObject);
    aw.a(((g)localObject).nMv);
    b.init();
    localObject = d.bJd();
    com.tencent.mm.sdk.b.a.ymk.c(((d)localObject).nLY);
    localObject = e.bJg();
    com.tencent.mm.sdk.b.a.ymk.c(((e)localObject).gAV);
    aw.getSysCmdMsgExtension().a("WeChatOut", this.nMS, true);
    aw.getSysCmdMsgExtension().a("WeChatOutMsg", this.nMT, true);
    aw.getSysCmdMsgExtension().a("WCONotify", this.nMU, true);
    com.tencent.mm.sdk.b.a.ymk.c(this.nMN);
    com.tencent.mm.sdk.b.a.ymk.c(this.nMO);
    com.tencent.mm.sdk.b.a.ymk.c(this.nMP);
    com.tencent.mm.sdk.b.a.ymk.c(this.nMQ);
    AppMethodBeat.o(21788);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(21789);
    if (this.nMD.bJh()) {
      this.nME.ex(0, 0);
    }
    Object localObject = this.nMz;
    ((g)localObject).nMk.destroy();
    ((g)localObject).nMl.destroy();
    ((g)localObject).nMm.destroy();
    ((g)localObject).nMn.destroy();
    ((g)localObject).nMo.destroy();
    ((g)localObject).nMq.destroy();
    aw.b(((g)localObject).nMv);
    b.release();
    localObject = d.bJd();
    aw.Rc().b(159, (com.tencent.mm.ai.f)localObject);
    aw.Rc().b(160, (com.tencent.mm.ai.f)localObject);
    com.tencent.mm.sdk.b.a.ymk.d(((d)localObject).nLY);
    localObject = e.bJg();
    com.tencent.mm.sdk.b.a.ymk.d(((e)localObject).gAV);
    aw.getSysCmdMsgExtension().b("WeChatOut", this.nMS, true);
    aw.getSysCmdMsgExtension().b("WeChatOutMsg", this.nMT, true);
    aw.getSysCmdMsgExtension().b("WCONotify", this.nMU, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.nMN);
    com.tencent.mm.sdk.b.a.ymk.d(this.nMO);
    com.tencent.mm.sdk.b.a.ymk.d(this.nMP);
    com.tencent.mm.sdk.b.a.ymk.d(this.nMQ);
    AppMethodBeat.o(21789);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.i
 * JD-Core Version:    0.7.0.1
 */