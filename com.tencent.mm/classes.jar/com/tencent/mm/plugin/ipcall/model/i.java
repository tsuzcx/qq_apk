package com.tencent.mm.plugin.ipcall.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.b.a.a;
import com.tencent.mm.plugin.ipcall.model.b.b.a;
import com.tencent.mm.plugin.ipcall.model.h.j;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class i
  implements bd
{
  private static i ypc;
  private static HashMap<Integer, h.b> ypu;
  private com.tencent.mm.plugin.voip.video.e hTl;
  private g ypd;
  private com.tencent.mm.plugin.ipcall.model.d.a ype;
  private com.tencent.mm.plugin.ipcall.model.d.b ypf;
  public com.tencent.mm.plugin.ipcall.model.c.b ypg;
  private f yph;
  private com.tencent.mm.plugin.ipcall.c ypi;
  private com.tencent.mm.plugin.ipcall.model.h.d ypj;
  private l ypk;
  private j ypl;
  private com.tencent.mm.plugin.ipcall.model.h.h ypm;
  private com.tencent.mm.plugin.voip.video.c ypn;
  private Context ypo;
  private long ypp;
  private IListener ypq;
  private IListener ypr;
  private IListener yps;
  private IListener ypt;
  private cj.a ypv;
  private cj.a ypw;
  private cj.a ypx;
  
  static
  {
    AppMethodBeat.i(25405);
    ypc = null;
    HashMap localHashMap = new HashMap();
    ypu = localHashMap;
    localHashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new i.7());
    ypu.put(Integer.valueOf("IPCallRecord".hashCode()), new i.8());
    ypu.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new i.9());
    ypu.put(Integer.valueOf("IPCallMsg".hashCode()), new i.10());
    AppMethodBeat.o(25405);
  }
  
  public i()
  {
    AppMethodBeat.i(25389);
    this.ypd = new g();
    this.ype = new com.tencent.mm.plugin.ipcall.model.d.a();
    this.ypf = new com.tencent.mm.plugin.ipcall.model.d.b();
    this.yph = new f();
    this.ypi = new com.tencent.mm.plugin.ipcall.c();
    this.ypq = new i.1(this);
    this.ypr = new i.4(this);
    this.yps = new i.5(this);
    this.ypt = new IListener() {};
    this.ypv = new i.11(this);
    this.ypw = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(25383);
        Log.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
        Object localObject = paramAnonymousa.heO;
        paramAnonymousa = z.a(paramAnonymousa.heO.KHn);
        if ((paramAnonymousa == null) || (paramAnonymousa.length() == 0))
        {
          Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
          AppMethodBeat.o(25383);
          return;
        }
        paramAnonymousa = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
          AppMethodBeat.o(25383);
          return;
        }
        com.tencent.mm.plugin.ipcall.model.h.h localh = i.eaB();
        long l = ((de)localObject).Brl;
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
          i = Util.getInt((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType = i;
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime = Util.getLong((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
          ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = ((String)paramAnonymousa.get(".sysmsg.WeChatOutMsg.DescUrl"));
          if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl == null) {
            ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = "";
          }
          Log.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl });
          localh.insert((IAutoDBItem)localObject);
        }
        for (;;)
        {
          if (i != -1)
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NVx, Integer.valueOf(i));
          }
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(ar.a.NVw, Boolean.TRUE);
          com.tencent.mm.plugin.report.service.h.CyF.a(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
          AppMethodBeat.o(25383);
          return;
          i = -1;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.ypx = new i.3(this);
    AppMethodBeat.o(25389);
  }
  
  public static j eaA()
  {
    AppMethodBeat.i(25399);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eaq().ypl == null)
    {
      localObject = eaq();
      bg.aVF();
      ((i)localObject).ypl = new j(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eaq().ypl;
    AppMethodBeat.o(25399);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.h eaB()
  {
    AppMethodBeat.i(25400);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eaq().ypm == null)
    {
      localObject = eaq();
      bg.aVF();
      ((i)localObject).ypm = new com.tencent.mm.plugin.ipcall.model.h.h(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eaq().ypm;
    AppMethodBeat.o(25400);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.voip.video.e eaC()
  {
    AppMethodBeat.i(25401);
    if (eaq().hTl == null) {
      eaq().hTl = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.e locale = eaq().hTl;
    AppMethodBeat.o(25401);
    return locale;
  }
  
  public static com.tencent.mm.plugin.voip.video.c eaD()
  {
    AppMethodBeat.i(25402);
    if (eaq().ypn == null) {
      eaq().ypn = new com.tencent.mm.plugin.voip.video.c(MMApplicationContext.getContext());
    }
    com.tencent.mm.plugin.voip.video.c localc = eaq().ypn;
    AppMethodBeat.o(25402);
    return localc;
  }
  
  public static i eaq()
  {
    AppMethodBeat.i(25390);
    if (ypc == null)
    {
      ypc = new i();
      bg.aVz().a("plugin.ipcall", ypc);
    }
    i locali = ypc;
    AppMethodBeat.o(25390);
    return locali;
  }
  
  public static g eas()
  {
    AppMethodBeat.i(25391);
    g localg = eaq().ypd;
    AppMethodBeat.o(25391);
    return localg;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.a eat()
  {
    AppMethodBeat.i(25392);
    com.tencent.mm.plugin.ipcall.model.d.a locala = eaq().ype;
    AppMethodBeat.o(25392);
    return locala;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.d.b eau()
  {
    AppMethodBeat.i(25393);
    com.tencent.mm.plugin.ipcall.model.d.b localb = eaq().ypf;
    AppMethodBeat.o(25393);
    return localb;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.c.b eav()
  {
    AppMethodBeat.i(25394);
    com.tencent.mm.plugin.ipcall.model.c.b localb = eaq().ypg;
    AppMethodBeat.o(25394);
    return localb;
  }
  
  public static f eaw()
  {
    AppMethodBeat.i(25395);
    f localf = eaq().yph;
    AppMethodBeat.o(25395);
    return localf;
  }
  
  public static com.tencent.mm.plugin.ipcall.c eax()
  {
    AppMethodBeat.i(25396);
    com.tencent.mm.plugin.ipcall.c localc = eaq().ypi;
    AppMethodBeat.o(25396);
    return localc;
  }
  
  public static com.tencent.mm.plugin.ipcall.model.h.d eay()
  {
    AppMethodBeat.i(25397);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eaq().ypj == null)
    {
      localObject = eaq();
      bg.aVF();
      ((i)localObject).ypj = new com.tencent.mm.plugin.ipcall.model.h.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eaq().ypj;
    AppMethodBeat.o(25397);
    return localObject;
  }
  
  public static l eaz()
  {
    AppMethodBeat.i(25398);
    com.tencent.mm.kernel.g.aAf().azk();
    if (eaq().ypk == null)
    {
      localObject = eaq();
      bg.aVF();
      ((i)localObject).ypk = new l(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = eaq().ypk;
    AppMethodBeat.o(25398);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final void ear()
  {
    AppMethodBeat.i(231721);
    this.ypg = new com.tencent.mm.plugin.ipcall.model.c.b();
    AppMethodBeat.o(231721);
  }
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return ypu;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25403);
    Object localObject = this.ypd;
    ((g)localObject).yoO.init();
    ((g)localObject).yoP.init();
    ((g)localObject).yoQ.init();
    ((g)localObject).yoR.init();
    ((g)localObject).yoS.init();
    ((g)localObject).yoT.init();
    ((g)localObject).yoU.init();
    ((g)localObject).yoV.init();
    ((g)localObject).yoO.a((a.a)localObject);
    ((g)localObject).yoQ.a((a.a)localObject);
    ((g)localObject).yoR.a((a.a)localObject);
    ((g)localObject).yoT.a((a.a)localObject);
    ((g)localObject).yoV.a((a.a)localObject);
    ((g)localObject).yoP.ypF = ((b.a)localObject);
    ((g)localObject).yoS.ypF = ((b.a)localObject);
    bg.a(((g)localObject).yoZ);
    b.init();
    localObject = d.eah();
    EventCenter.instance.addListener(((d)localObject).yoB);
    localObject = e.eak();
    EventCenter.instance.addListener(((e)localObject).kiA);
    bg.getSysCmdMsgExtension().a("WeChatOut", this.ypv, true);
    bg.getSysCmdMsgExtension().a("WeChatOutMsg", this.ypw, true);
    bg.getSysCmdMsgExtension().a("WCONotify", this.ypx, true);
    EventCenter.instance.addListener(this.ypq);
    EventCenter.instance.addListener(this.ypr);
    EventCenter.instance.addListener(this.yps);
    EventCenter.instance.addListener(this.ypt);
    AppMethodBeat.o(25403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25404);
    if (this.yph.eal()) {
      this.ypi.gP(0, 0);
    }
    Object localObject = this.ypd;
    ((g)localObject).yoO.destroy();
    ((g)localObject).yoP.destroy();
    ((g)localObject).yoQ.destroy();
    ((g)localObject).yoR.destroy();
    ((g)localObject).yoS.destroy();
    ((g)localObject).yoU.destroy();
    bg.b(((g)localObject).yoZ);
    b.release();
    localObject = d.eah();
    bg.azz().b(159, (com.tencent.mm.ak.i)localObject);
    bg.azz().b(160, (com.tencent.mm.ak.i)localObject);
    EventCenter.instance.removeListener(((d)localObject).yoB);
    localObject = e.eak();
    EventCenter.instance.removeListener(((e)localObject).kiA);
    bg.getSysCmdMsgExtension().b("WeChatOut", this.ypv, true);
    bg.getSysCmdMsgExtension().b("WeChatOutMsg", this.ypw, true);
    bg.getSysCmdMsgExtension().b("WCONotify", this.ypx, true);
    EventCenter.instance.removeListener(this.ypq);
    EventCenter.instance.removeListener(this.ypr);
    EventCenter.instance.removeListener(this.yps);
    EventCenter.instance.removeListener(this.ypt);
    AppMethodBeat.o(25404);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i
 * JD-Core Version:    0.7.0.1
 */