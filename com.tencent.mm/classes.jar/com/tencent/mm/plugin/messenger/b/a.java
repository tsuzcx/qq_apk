package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.cp.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dwj;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.tmassistantsdk.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a
  extends p
  implements m
{
  public static String KPK;
  public static String KPL;
  private static ArrayList<a> KPM = null;
  private static int KPN;
  private static int KPO = 0;
  private static boolean KPP = false;
  private static int KPQ = 0;
  private static int qvo = -1;
  private static int qvp = 0;
  private com.tencent.mm.am.h callback;
  
  public a(int paramInt)
  {
    KPN = paramInt;
  }
  
  public static void a(final a parama, com.tencent.mm.modelsimple.ak paramak)
  {
    AppMethodBeat.i(288651);
    if ((parama == null) || (paramak == null))
    {
      AppMethodBeat.o(288651);
      return;
    }
    Log.i("MicroMsg.NetSceneGetOnlineInfo", "changeDeviceAutoLogin iconType:%s, setting:%s", new Object[] { Integer.valueOf(parama.qvo), Integer.valueOf(paramak.value) });
    new com.tencent.mm.modelsimple.b(parama.YMq, parama.YMr, paramak).bFJ().h(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(288651);
  }
  
  public static void a(a parama, boolean paramBoolean)
  {
    parama.KQf = paramBoolean;
    if (paramBoolean)
    {
      parama.abcp |= 0x4;
      return;
    }
    parama.abcp &= 0xFFFFFFFB;
  }
  
  public static boolean aau(int paramInt)
  {
    return KPN != paramInt;
  }
  
  private static boolean aav(int paramInt)
  {
    return (paramInt & 0x200) != 0;
  }
  
  private static boolean aaw(int paramInt)
  {
    return (paramInt & 0x400) != 0;
  }
  
  private static boolean aax(int paramInt)
  {
    return (paramInt & 0x20) != 0;
  }
  
  private static boolean aay(int paramInt)
  {
    return (paramInt & 0x800) != 0;
  }
  
  private static boolean aaz(int paramInt)
  {
    return (paramInt & 0x1000) != 0;
  }
  
  public static int bLP()
  {
    return qvp;
  }
  
  public static void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(288645);
    try
    {
      Iterator localIterator = gaL().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (Util.isEqual(Base64.encodeToString(locala.YMq.Op, 2), paramString))
        {
          locala.KQh = paramBoolean;
          new abn().publish();
          AppMethodBeat.o(288645);
          return;
        }
      }
      AppMethodBeat.o(288645);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NetSceneGetOnlineInfo", "updateAutoLoginStatus %s, %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      AppMethodBeat.o(288645);
    }
  }
  
  public static boolean gaJ()
  {
    AppMethodBeat.i(288556);
    if ((KPM != null) && (KPM.size() > 1))
    {
      AppMethodBeat.o(288556);
      return true;
    }
    AppMethodBeat.o(288556);
    return false;
  }
  
  public static a gaK()
  {
    AppMethodBeat.i(288561);
    if ((KPM != null) && (KPM.size() > 0))
    {
      a locala = (a)KPM.get(0);
      AppMethodBeat.o(288561);
      return locala;
    }
    AppMethodBeat.o(288561);
    return null;
  }
  
  public static ArrayList<a> gaL()
  {
    AppMethodBeat.i(288569);
    if (KPM != null)
    {
      localArrayList = KPM;
      AppMethodBeat.o(288569);
      return localArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(288569);
    return localArrayList;
  }
  
  public static int gaM()
  {
    return qvo;
  }
  
  public static boolean gaN()
  {
    return (KPO & 0x2) != 0;
  }
  
  public static boolean gaO()
  {
    AppMethodBeat.i(288601);
    Iterator localIterator = gaL().iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while ((locala.KQc) || (!locala.KQf));
    for (;;)
    {
      if (locala != null)
      {
        AppMethodBeat.o(288601);
        return true;
      }
      AppMethodBeat.o(288601);
      return false;
      locala = null;
    }
  }
  
  public static int gaP()
  {
    return KPN;
  }
  
  public static int gaQ()
  {
    return KPQ;
  }
  
  private static void gaR()
  {
    AppMethodBeat.i(288639);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = KPM.iterator();
    a locala;
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.qvo == 1) || (locala.qvo == 2)) {
        localArrayList.add(locala);
      }
    }
    localIterator = KPM.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.qvo == 3) || (locala.qvo == 8)) {
        localArrayList.add(locala);
      }
    }
    localIterator = KPM.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.qvo != 1) && (locala.qvo != 2) && (locala.qvo != 3) && (locala.qvo != 8) && (locala.qvo != 10)) {
        localArrayList.add(locala);
      }
    }
    localIterator = KPM.iterator();
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if (locala.qvo == 10) {
        localArrayList.add(locala);
      }
    }
    KPM = localArrayList;
    AppMethodBeat.o(288639);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(288662);
    c.a locala = new c.a();
    cof localcof = new cof();
    localcof.yts = LocaleUtil.getApplicationLanguage();
    Log.d("MicroMsg.NetSceneGetOnlineInfo", "language %s", new Object[] { localcof.yts });
    locala.otE = localcof;
    locala.otF = new cog();
    locala.uri = "/cgi-bin/micromsg-bin/getonlineinfo";
    locala.funcId = 526;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.callback = paramh;
    int i = dispatch(paramg, locala.bEF(), this);
    AppMethodBeat.o(288662);
    return i;
  }
  
  public final int getType()
  {
    return 526;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(288672);
    Log.i("MicroMsg.NetSceneGetOnlineInfo", "ongynetend %d, %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    Object localObject;
    boolean bool2;
    dwj localdwj;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cog)c.c.b(((c)params).otC);
      qvo = paramArrayOfByte.aavw;
      Log.d("MicroMsg.NetSceneGetOnlineInfo", "iconType:%d onlineInfoFlag:%d", new Object[] { Integer.valueOf(qvo), Integer.valueOf(paramArrayOfByte.YFu) });
      localObject = XmlParser.parseXml(paramArrayOfByte.aavv, "summary", null);
      bool2 = gaO();
      KPM = null;
      if (localObject != null)
      {
        KPK = (String)((Map)localObject).get(".summary.banner");
        KPL = Util.nullAsNil((String)((Map)localObject).get(".summary.device_name"));
        KPO = paramArrayOfByte.YFu;
        Log.d("MicroMsg.NetSceneGetOnlineInfo", "onlineinfo, count:%d, summary:%s, infoFlag:%s", new Object[] { Integer.valueOf(paramArrayOfByte.aavt), paramArrayOfByte.aavv, Integer.valueOf(KPO) });
        localObject = (cof)c.b.b(((c)params).otB);
        KPM = new ArrayList();
        Iterator localIterator = paramArrayOfByte.aavu.iterator();
        paramInt1 = 1;
        if (localIterator.hasNext())
        {
          localdwj = (dwj)localIterator.next();
          if (localdwj.YMq.ZV().hashCode() == ((cof)localObject).BaseRequest.YMq.ZV().hashCode()) {
            break label1219;
          }
          if (localdwj == null)
          {
            params = null;
            if (params.qvo == 0) {
              params.qvo = qvo;
            }
            KPM.add(params);
            if (paramInt1 == 0) {
              break label1219;
            }
            KPQ = localdwj.abcm;
            Log.i("MicroMsg.NetSceneGetOnlineInfo", "device type %d", new Object[] { Integer.valueOf(KPQ) });
            Log.d("MicroMsg.NetSceneGetOnlineInfo", localdwj.abcn);
            qvp = localdwj.YMr;
            paramInt1 = 0;
          }
        }
      }
    }
    label1216:
    label1219:
    for (;;)
    {
      break;
      params = new a();
      params.abcm = localdwj.abcm;
      params.YMq = localdwj.YMq;
      params.abcn = localdwj.abcn;
      params.abco = localdwj.abco;
      params.abcp = localdwj.abcp;
      params.abcq = localdwj.abcq;
      params.YMr = localdwj.YMr;
      params.qvo = localdwj.qvo;
      params.YFu = localdwj.YFu;
      params.KQc = aav(KPO);
      params.KQd = aax(KPO);
      params.KQe = aaw(KPO);
      if ((localdwj.abcp & 0x4) != 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        params.KQf = bool1;
        params.KQg = aay(KPO);
        params.KQh = aaz(KPO);
        Map localMap = XmlParser.parseXml(localdwj.abcn, "wording", null);
        if (localMap != null)
        {
          params.desc = ((String)localMap.get(".wording.title"));
          params.KPT = ((String)localMap.get(".wording.notify"));
          params.KPU = ((String)localMap.get(".wording.mute_title"));
          params.KPV = ((String)localMap.get(".wording.mute_tips"));
          params.KPW = ((String)localMap.get(".wording.exit_confirm"));
          params.KPX = ((String)localMap.get(".wording.lock_title"));
          params.KPY = ((String)localMap.get(".wording.mute_lock_title"));
          params.KPZ = ((String)localMap.get(".wording.exit"));
          params.KQa = ((String)localMap.get(".wording.usage_link"));
          params.KQb = ((String)localMap.get(".wording.autologin_switch_tip"));
        }
        Log.i("MicroMsg.NetSceneGetOnlineInfo", "fromOnlineInfoToLocalOnlineInfo %s", new Object[] { Integer.valueOf(params.qvo) });
        break;
      }
      gaR();
      if (KPM.size() > 1)
      {
        params = KPM.iterator();
        while (params.hasNext())
        {
          localObject = (a)params.next();
          ((a)localObject).KQc = aav(((a)localObject).YFu);
          ((a)localObject).KQd = aax(((a)localObject).YFu);
          ((a)localObject).KQe = aaw(((a)localObject).YFu);
          ((a)localObject).KQg = aay(((a)localObject).YFu);
          ((a)localObject).KQh = aaz(((a)localObject).YFu);
        }
      }
      if ((KPO & 0x2) == 0)
      {
        KPP = true;
        if (bool2 != gaO())
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baC().aZK();
        }
        paramInt1 = paramArrayOfByte.YFu;
        int i = paramArrayOfByte.aavw;
        if (((paramInt1 & 0x40) != 0) || (7 == i) || (8 == i))
        {
          params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("filehelper");
          if ((params != null) && (!Util.isNullOrNil(params.field_username))) {
            break label1216;
          }
          com.tencent.mm.model.ak.T(params);
          params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE("filehelper");
        }
      }
      for (;;)
      {
        if ((params != null) && (!d.rs(params.field_type)))
        {
          params.aRK();
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(params.field_username, params);
        }
        params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("filehelper");
        if (params == null)
        {
          params = new bb("filehelper");
          params.gR(Util.nowMilliSecond());
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().h(params);
        }
        for (;;)
        {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(288672);
          return;
          KPP = false;
          break;
          params.gR(Util.nowMilliSecond());
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(params, "filehelper");
        }
      }
    }
  }
  
  public static final class a
    extends dwj
  {
    public String KPT;
    public String KPU;
    public String KPV;
    public String KPW;
    public String KPX;
    public String KPY;
    public String KPZ;
    public String KQa;
    public String KQb;
    public boolean KQc;
    public boolean KQd;
    public boolean KQe;
    public boolean KQf;
    public boolean KQg;
    public boolean KQh;
    public String desc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */