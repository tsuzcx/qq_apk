package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class j
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c ney;
  private cc.a pAl;
  private volatile d sqA;
  private volatile com.tencent.mm.plugin.freewifi.g.d sqB;
  private volatile com.tencent.mm.plugin.freewifi.g.b sqC;
  private volatile f sqD;
  private volatile c sqE;
  private volatile c sqF;
  private volatile a sqG;
  private volatile e sqH;
  private n sqI;
  private com.tencent.mm.sdk.b.c sqJ;
  private com.tencent.mm.sdk.b.c sqK;
  private com.tencent.mm.sdk.b.c sqL;
  private com.tencent.mm.sdk.b.c sqM;
  private com.tencent.mm.sdk.b.c sqN;
  private com.tencent.mm.sdk.b.c sqO;
  
  static
  {
    AppMethodBeat.i(24838);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.freewifi.g.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new j.5());
    baseDBFactories.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new j.6());
    AppMethodBeat.o(24838);
  }
  
  public j()
  {
    AppMethodBeat.i(24826);
    this.sqI = new j.7(this);
    this.sqJ = new com.tencent.mm.sdk.b.c() {};
    this.sqK = new j.9(this);
    this.sqL = new j.10(this);
    this.sqM = new j.11(this);
    this.sqN = new j.12(this);
    this.sqO = new j.2(this);
    this.ney = new j.3(this);
    this.pAl = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(24816);
        e locale = j.cJq();
        paramAnonymousa = paramAnonymousa.fXi;
        if (1 != i.a.cIB().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
          i.a.cIB().dl("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if ((paramAnonymousa == null) || (paramAnonymousa.DPV == null))
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          AppMethodBeat.o(24816);
          return;
        }
        Object localObject = z.a(paramAnonymousa.DPV);
        ac.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(paramAnonymousa.vTQ), localObject });
        if (m.cX((String)localObject))
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          AppMethodBeat.o(24816);
          return;
        }
        localObject = com.tencent.mm.plugin.freewifi.c.a.afq((String)localObject);
        if (localObject == null)
        {
          ac.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          AppMethodBeat.o(24816);
          return;
        }
        String str = m.afo("MicroMsg.FreeWifi.FreeWifiMessageService");
        new com.tencent.mm.plugin.freewifi.d.d(m.afm("MicroMsg.FreeWifi.FreeWifiMessageService"), m.afn("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((com.tencent.mm.plugin.freewifi.c.a)localObject).spU, ((com.tencent.mm.plugin.freewifi.c.a)localObject).spR, ((com.tencent.mm.plugin.freewifi.c.a)localObject).spV, ((com.tencent.mm.plugin.freewifi.c.a)localObject).ssid, ((com.tencent.mm.plugin.freewifi.c.a)localObject).bssid).c(new e.1(locale, paramAnonymousa));
        AppMethodBeat.o(24816);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(24826);
  }
  
  public static j cJi()
  {
    AppMethodBeat.i(24827);
    az.ayG();
    j localj2 = (j)bz.yz("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      ac.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      az.ayG().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(24827);
    return localj1;
  }
  
  public static d cJj()
  {
    AppMethodBeat.i(24828);
    g.agP().afT();
    if (cJi().sqA == null) {
      cJi().sqA = new d();
    }
    d locald = cJi().sqA;
    AppMethodBeat.o(24828);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d cJk()
  {
    AppMethodBeat.i(24829);
    g.agP().afT();
    if (cJi().sqB == null)
    {
      localObject = cJi();
      az.ayM();
      ((j)localObject).sqB = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.agw());
    }
    Object localObject = cJi().sqB;
    AppMethodBeat.o(24829);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b cJl()
  {
    AppMethodBeat.i(24830);
    g.agP().afT();
    if (cJi().sqC == null)
    {
      localObject = cJi();
      az.ayM();
      ((j)localObject).sqC = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.agw());
    }
    Object localObject = cJi().sqC;
    AppMethodBeat.o(24830);
    return localObject;
  }
  
  public static f cJm()
  {
    AppMethodBeat.i(24831);
    g.agP().afT();
    if (cJi().sqD == null)
    {
      localObject = cJi();
      az.ayM();
      ((j)localObject).sqD = new f(com.tencent.mm.model.c.agw());
    }
    Object localObject = cJi().sqD;
    AppMethodBeat.o(24831);
    return localObject;
  }
  
  public static c cJn()
  {
    AppMethodBeat.i(24832);
    g.agP().afT();
    if (cJi().sqE == null) {
      cJi().sqE = new c();
    }
    c localc = cJi().sqE;
    AppMethodBeat.o(24832);
    return localc;
  }
  
  public static c cJo()
  {
    AppMethodBeat.i(24833);
    g.agP().afT();
    if (cJi().sqF == null) {
      cJi().sqF = new c();
    }
    c localc = cJi().sqF;
    AppMethodBeat.o(24833);
    return localc;
  }
  
  public static a cJp()
  {
    try
    {
      AppMethodBeat.i(24834);
      g.agP().afT();
      if (cJi().sqG == null) {
        cJi().sqG = new a();
      }
      a locala = cJi().sqG;
      AppMethodBeat.o(24834);
      return locala;
    }
    finally {}
  }
  
  public static e cJq()
  {
    AppMethodBeat.i(24837);
    g.agP().afT();
    if (cJi().sqH == null) {
      cJi().sqH = new e();
    }
    e locale = cJi().sqH;
    AppMethodBeat.o(24837);
    return locale;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24835);
    az.getSysCmdMsgExtension().a("freewifi", this.pAl, true);
    az.a(this.sqI);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqJ);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqK);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqL);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqM);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqN);
    com.tencent.mm.sdk.b.a.GpY.c(this.sqO);
    com.tencent.mm.sdk.b.a.GpY.c(this.ney);
    try
    {
      this.sqI.onNetworkChange(-9);
      b localb = b.b.cIV();
      ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.afk(m.afm("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.afn("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.sqc = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.sqd = "";
        b.b(localb.spZ.cIU(), locala);
        localb.spZ = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = k.cIC();
          ((k.a)localObject2).dbq = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).fsq = m.l(localException);
          ((k.a)localObject2).cIE().cID();
          ac.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.cIr();
      ai.getContext().registerReceiver(localb.sqa, (IntentFilter)localObject1);
      AppMethodBeat.o(24835);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ac.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label333:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        ac.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).sqc = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).sqd = m.afl(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.spZ.cIU(), (b.a)localObject2);
          localRemoteException.spZ = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24836);
    az.getSysCmdMsgExtension().b("freewifi", this.pAl, true);
    cJj();
    cJn().release();
    az.b(this.sqI);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqJ);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqK);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqL);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqM);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqN);
    com.tencent.mm.sdk.b.a.GpY.d(this.sqO);
    com.tencent.mm.sdk.b.a.GpY.d(this.ney);
    b.b.cIV().cIr();
    AppMethodBeat.o(24836);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */