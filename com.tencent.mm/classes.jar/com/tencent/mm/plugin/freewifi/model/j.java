package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.c;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.hj.a;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c mCw;
  private cc.a oXa;
  private volatile d rhH;
  private volatile com.tencent.mm.plugin.freewifi.g.d rhI;
  private volatile com.tencent.mm.plugin.freewifi.g.b rhJ;
  private volatile com.tencent.mm.plugin.freewifi.g.f rhK;
  private volatile c rhL;
  private volatile c rhM;
  private volatile a rhN;
  private volatile e rhO;
  private n rhP;
  private com.tencent.mm.sdk.b.c rhQ;
  private com.tencent.mm.sdk.b.c rhR;
  private com.tencent.mm.sdk.b.c rhS;
  private com.tencent.mm.sdk.b.c rhT;
  private com.tencent.mm.sdk.b.c rhU;
  private com.tencent.mm.sdk.b.c rhV;
  
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
    baseDBFactories.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.freewifi.g.f.SQL_CREATE;
      }
    });
    AppMethodBeat.o(24838);
  }
  
  public j()
  {
    AppMethodBeat.i(24826);
    this.rhP = new n.a()
    {
      private byte[] fiT;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(24818);
        for (;;)
        {
          synchronized (this.fiT)
          {
            if (!az.afw())
            {
              ad.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
              AppMethodBeat.o(24818);
              return;
            }
            ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramAnonymousInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
            Object localObject2 = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
            if (localObject2 == null)
            {
              AppMethodBeat.o(24818);
              return;
            }
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
            if (localNetworkInfo != null)
            {
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(localNetworkInfo)));
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
            }
            localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
            if (localObject2 != null)
            {
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
              break label331;
              if (!localNetworkInfo.isConnected())
              {
                f.a.cvU().cvR();
                AppMethodBeat.o(24818);
                return;
              }
              boolean bool = f.a.cvU().ab(m.aau("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.aav("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.aaw("MicroMsg.FreeWifi.SubCoreFreeWifi"));
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                j.cwd().cvH();
              }
              AppMethodBeat.o(24818);
              return;
            }
          }
          label331:
          if ((6 != paramAnonymousInt) && (4 != paramAnonymousInt) && (paramAnonymousInt != 0) && (-1 != paramAnonymousInt)) {
            if (-9 != paramAnonymousInt) {}
          }
        }
      }
    };
    this.rhQ = new com.tencent.mm.sdk.b.c() {};
    this.rhR = new com.tencent.mm.sdk.b.c() {};
    this.rhS = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(hj arg0)
      {
        AppMethodBeat.i(24822);
        String str1;
        f.b localb;
        if ((???.dkZ.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.cvt()))
        {
          str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
          localb = f.a.cvU().cvS();
          if ((localb != null) && (!localb.rhw) && (System.currentTimeMillis() - localb.rhk <= 180000L) && (!m.dq(localb.rhu)) && (!m.dq(localb.rht)) && (!m.dq(localb.rhv))) {
            break label114;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(24822);
          return false;
          label114:
          ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.rht, localb.rhu, localb.rhv, Long.valueOf(localb.rhk) });
          ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
          String str3 = m.aau("MicroMsg.FreeWifi.Protocol31Handler");
          if (m.aas(localb.rht).equals(str3))
          {
            String str4 = m.aav("MicroMsg.FreeWifi.Protocol31Handler");
            String str5 = m.aaw("MicroMsg.FreeWifi.Protocol31Handler");
            synchronized (f.a.cvU())
            {
              if (localb == f.a.cvU().cvS()) {}
            }
            ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
            new com.tencent.mm.plugin.freewifi.d.g(str3, str4, str5).c(new c.1(str2, localb));
          }
        }
      }
    };
    this.rhT = new j.11(this);
    this.rhU = new j.12(this);
    this.rhV = new com.tencent.mm.sdk.b.c() {};
    this.mCw = new j.3(this);
    this.oXa = new cc.a()
    {
      public final void a(com.tencent.mm.al.f.a paramAnonymousa)
      {
        AppMethodBeat.i(24816);
        e locale = j.cwe();
        paramAnonymousa = paramAnonymousa.fTo;
        if (1 != i.a.cvp().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
          i.a.cvp().df("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if ((paramAnonymousa == null) || (paramAnonymousa.Cxz == null))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          AppMethodBeat.o(24816);
          return;
        }
        Object localObject = z.a(paramAnonymousa.Cxz);
        ad.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(paramAnonymousa.uKZ), localObject });
        if (m.dq((String)localObject))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          AppMethodBeat.o(24816);
          return;
        }
        localObject = com.tencent.mm.plugin.freewifi.c.a.aay((String)localObject);
        if (localObject == null)
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          AppMethodBeat.o(24816);
          return;
        }
        String str = m.aaw("MicroMsg.FreeWifi.FreeWifiMessageService");
        new com.tencent.mm.plugin.freewifi.d.d(m.aau("MicroMsg.FreeWifi.FreeWifiMessageService"), m.aav("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((com.tencent.mm.plugin.freewifi.c.a)localObject).rhc, ((com.tencent.mm.plugin.freewifi.c.a)localObject).rgZ, ((com.tencent.mm.plugin.freewifi.c.a)localObject).rhd, ((com.tencent.mm.plugin.freewifi.c.a)localObject).ssid, ((com.tencent.mm.plugin.freewifi.c.a)localObject).bssid).c(new e.1(locale, paramAnonymousa));
        AppMethodBeat.o(24816);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    AppMethodBeat.o(24826);
  }
  
  public static j cvW()
  {
    AppMethodBeat.i(24827);
    az.arP();
    j localj2 = (j)bz.ut("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      ad.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      az.arP().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(24827);
    return localj1;
  }
  
  public static d cvX()
  {
    AppMethodBeat.i(24828);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhH == null) {
      cvW().rhH = new d();
    }
    d locald = cvW().rhH;
    AppMethodBeat.o(24828);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d cvY()
  {
    AppMethodBeat.i(24829);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhI == null)
    {
      localObject = cvW();
      az.arV();
      ((j)localObject).rhI = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.afg());
    }
    Object localObject = cvW().rhI;
    AppMethodBeat.o(24829);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b cvZ()
  {
    AppMethodBeat.i(24830);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhJ == null)
    {
      localObject = cvW();
      az.arV();
      ((j)localObject).rhJ = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.afg());
    }
    Object localObject = cvW().rhJ;
    AppMethodBeat.o(24830);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.f cwa()
  {
    AppMethodBeat.i(24831);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhK == null)
    {
      localObject = cvW();
      az.arV();
      ((j)localObject).rhK = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.afg());
    }
    Object localObject = cvW().rhK;
    AppMethodBeat.o(24831);
    return localObject;
  }
  
  public static c cwb()
  {
    AppMethodBeat.i(24832);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhL == null) {
      cvW().rhL = new c();
    }
    c localc = cvW().rhL;
    AppMethodBeat.o(24832);
    return localc;
  }
  
  public static c cwc()
  {
    AppMethodBeat.i(24833);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhM == null) {
      cvW().rhM = new c();
    }
    c localc = cvW().rhM;
    AppMethodBeat.o(24833);
    return localc;
  }
  
  public static a cwd()
  {
    try
    {
      AppMethodBeat.i(24834);
      com.tencent.mm.kernel.g.afz().aeD();
      if (cvW().rhN == null) {
        cvW().rhN = new a();
      }
      a locala = cvW().rhN;
      AppMethodBeat.o(24834);
      return locala;
    }
    finally {}
  }
  
  public static e cwe()
  {
    AppMethodBeat.i(24837);
    com.tencent.mm.kernel.g.afz().aeD();
    if (cvW().rhO == null) {
      cvW().rhO = new e();
    }
    e locale = cvW().rhO;
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
    az.getSysCmdMsgExtension().a("freewifi", this.oXa, true);
    az.a(this.rhP);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhQ);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhR);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhS);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhT);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhU);
    com.tencent.mm.sdk.b.a.ESL.c(this.rhV);
    com.tencent.mm.sdk.b.a.ESL.c(this.mCw);
    try
    {
      this.rhP.onNetworkChange(-9);
      b localb = b.b.cvJ();
      ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.aas(m.aau("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.aav("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.rhk = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.rhl = "";
        b.b(localb.rhh.cvI(), locala);
        localb.rhh = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = com.tencent.mm.plugin.freewifi.k.cvq();
          ((k.a)localObject2).ddU = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).foR = m.l(localException);
          ((k.a)localObject2).cvs().cvr();
          ad.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.cvf();
      aj.getContext().registerReceiver(localb.rhi, (IntentFilter)localObject1);
      AppMethodBeat.o(24835);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ad.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label333:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).rhk = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).rhl = m.aat(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.rhh.cvI(), (b.a)localObject2);
          localRemoteException.rhh = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24836);
    az.getSysCmdMsgExtension().b("freewifi", this.oXa, true);
    cvX();
    cwb().release();
    az.b(this.rhP);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhQ);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhR);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhS);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhT);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhU);
    com.tencent.mm.sdk.b.a.ESL.d(this.rhV);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCw);
    b.b.cvJ().cvf();
    AppMethodBeat.o(24836);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */