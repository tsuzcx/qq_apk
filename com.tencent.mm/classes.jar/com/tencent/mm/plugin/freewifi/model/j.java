package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.hx.a;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c nEU;
  private cd.a qdQ;
  private volatile d tnc;
  private volatile com.tencent.mm.plugin.freewifi.g.d tnd;
  private volatile com.tencent.mm.plugin.freewifi.g.b tne;
  private volatile com.tencent.mm.plugin.freewifi.g.f tnf;
  private volatile c tng;
  private volatile c tnh;
  private volatile a tni;
  private volatile e tnj;
  private n tnk;
  private com.tencent.mm.sdk.b.c tnl;
  private com.tencent.mm.sdk.b.c tnm;
  private com.tencent.mm.sdk.b.c tnn;
  private com.tencent.mm.sdk.b.c tno;
  private com.tencent.mm.sdk.b.c tnp;
  private com.tencent.mm.sdk.b.c tnq;
  
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
    this.tnk = new n.a()
    {
      private byte[] fEu;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(24818);
        for (;;)
        {
          synchronized (this.fEu)
          {
            if (!ba.ajx())
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
                f.a.cRv().cRs();
                AppMethodBeat.o(24818);
                return;
              }
              boolean bool = f.a.cRv().af(m.ajK("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.ajL("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.ajM("MicroMsg.FreeWifi.SubCoreFreeWifi"));
              ad.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                j.cRE().cRi();
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
    this.tnl = new com.tencent.mm.sdk.b.c() {};
    this.tnm = new com.tencent.mm.sdk.b.c() {};
    this.tnn = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(hx arg0)
      {
        AppMethodBeat.i(24822);
        String str1;
        f.b localb;
        if ((???.duu.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.cQU()))
        {
          str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
          localb = f.a.cRv().cRt();
          if ((localb != null) && (!localb.tmR) && (System.currentTimeMillis() - localb.tmF <= 180000L) && (!m.ea(localb.tmP)) && (!m.ea(localb.tmO)) && (!m.ea(localb.tmQ))) {
            break label114;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(24822);
          return false;
          label114:
          ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.tmO, localb.tmP, localb.tmQ, Long.valueOf(localb.tmF) });
          ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
          String str3 = m.ajK("MicroMsg.FreeWifi.Protocol31Handler");
          if (m.ajI(localb.tmO).equals(str3))
          {
            String str4 = m.ajL("MicroMsg.FreeWifi.Protocol31Handler");
            String str5 = m.ajM("MicroMsg.FreeWifi.Protocol31Handler");
            synchronized (f.a.cRv())
            {
              if (localb == f.a.cRv().cRt()) {}
            }
            ad.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
            new com.tencent.mm.plugin.freewifi.d.g(str3, str4, str5).c(new c.1(str2, localb));
          }
        }
      }
    };
    this.tno = new com.tencent.mm.sdk.b.c() {};
    this.tnp = new com.tencent.mm.sdk.b.c() {};
    this.tnq = new j.2(this);
    this.nEU = new j.3(this);
    this.qdQ = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(24816);
        e locale = j.cRF();
        paramAnonymousa = paramAnonymousa.gqE;
        if (1 != i.a.cQQ().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
          i.a.cQQ().dB("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if ((paramAnonymousa == null) || (paramAnonymousa.Fvk == null))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          AppMethodBeat.o(24816);
          return;
        }
        Object localObject = z.a(paramAnonymousa.Fvk);
        ad.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(paramAnonymousa.xbt), localObject });
        if (m.ea((String)localObject))
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          AppMethodBeat.o(24816);
          return;
        }
        localObject = com.tencent.mm.plugin.freewifi.c.a.ajO((String)localObject);
        if (localObject == null)
        {
          ad.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          AppMethodBeat.o(24816);
          return;
        }
        String str = m.ajM("MicroMsg.FreeWifi.FreeWifiMessageService");
        new com.tencent.mm.plugin.freewifi.d.d(m.ajK("MicroMsg.FreeWifi.FreeWifiMessageService"), m.ajL("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((com.tencent.mm.plugin.freewifi.c.a)localObject).tmx, ((com.tencent.mm.plugin.freewifi.c.a)localObject).tmu, ((com.tencent.mm.plugin.freewifi.c.a)localObject).tmy, ((com.tencent.mm.plugin.freewifi.c.a)localObject).ssid, ((com.tencent.mm.plugin.freewifi.c.a)localObject).bssid).c(new e.1(locale, paramAnonymousa));
        AppMethodBeat.o(24816);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(24826);
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b cRA()
  {
    AppMethodBeat.i(24830);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tne == null)
    {
      localObject = cRx();
      ba.aBQ();
      ((j)localObject).tne = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cRx().tne;
    AppMethodBeat.o(24830);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.f cRB()
  {
    AppMethodBeat.i(24831);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tnf == null)
    {
      localObject = cRx();
      ba.aBQ();
      ((j)localObject).tnf = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cRx().tnf;
    AppMethodBeat.o(24831);
    return localObject;
  }
  
  public static c cRC()
  {
    AppMethodBeat.i(24832);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tng == null) {
      cRx().tng = new c();
    }
    c localc = cRx().tng;
    AppMethodBeat.o(24832);
    return localc;
  }
  
  public static c cRD()
  {
    AppMethodBeat.i(24833);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tnh == null) {
      cRx().tnh = new c();
    }
    c localc = cRx().tnh;
    AppMethodBeat.o(24833);
    return localc;
  }
  
  public static a cRE()
  {
    try
    {
      AppMethodBeat.i(24834);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (cRx().tni == null) {
        cRx().tni = new a();
      }
      a locala = cRx().tni;
      AppMethodBeat.o(24834);
      return locala;
    }
    finally {}
  }
  
  public static e cRF()
  {
    AppMethodBeat.i(24837);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tnj == null) {
      cRx().tnj = new e();
    }
    e locale = cRx().tnj;
    AppMethodBeat.o(24837);
    return locale;
  }
  
  public static j cRx()
  {
    AppMethodBeat.i(24827);
    ba.aBK();
    j localj2 = (j)ca.By("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      ad.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      ba.aBK().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(24827);
    return localj1;
  }
  
  public static d cRy()
  {
    AppMethodBeat.i(24828);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tnc == null) {
      cRx().tnc = new d();
    }
    d locald = cRx().tnc;
    AppMethodBeat.o(24828);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d cRz()
  {
    AppMethodBeat.i(24829);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cRx().tnd == null)
    {
      localObject = cRx();
      ba.aBQ();
      ((j)localObject).tnd = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cRx().tnd;
    AppMethodBeat.o(24829);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24835);
    ba.getSysCmdMsgExtension().a("freewifi", this.qdQ, true);
    ba.a(this.tnk);
    com.tencent.mm.sdk.b.a.IbL.c(this.tnl);
    com.tencent.mm.sdk.b.a.IbL.c(this.tnm);
    com.tencent.mm.sdk.b.a.IbL.c(this.tnn);
    com.tencent.mm.sdk.b.a.IbL.c(this.tno);
    com.tencent.mm.sdk.b.a.IbL.c(this.tnp);
    com.tencent.mm.sdk.b.a.IbL.c(this.tnq);
    com.tencent.mm.sdk.b.a.IbL.c(this.nEU);
    try
    {
      this.tnk.onNetworkChange(-9);
      b localb = b.b.cRk();
      ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)aj.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        ad.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.ajI(m.ajK("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.ajL("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.tmF = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.tmG = "";
        b.b(localb.tmC.cRj(), locala);
        localb.tmC = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = com.tencent.mm.plugin.freewifi.k.cQR();
          ((k.a)localObject2).dmM = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).fKQ = m.l(localException);
          ((k.a)localObject2).cQT().cQS();
          ad.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.cQG();
      aj.getContext().registerReceiver(localb.tmD, (IntentFilter)localObject1);
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
          ((b.a)localObject2).tmF = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).tmG = m.ajJ(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.tmC.cRj(), (b.a)localObject2);
          localRemoteException.tmC = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24836);
    ba.getSysCmdMsgExtension().b("freewifi", this.qdQ, true);
    cRy();
    cRC().release();
    ba.b(this.tnk);
    com.tencent.mm.sdk.b.a.IbL.d(this.tnl);
    com.tencent.mm.sdk.b.a.IbL.d(this.tnm);
    com.tencent.mm.sdk.b.a.IbL.d(this.tnn);
    com.tencent.mm.sdk.b.a.IbL.d(this.tno);
    com.tencent.mm.sdk.b.a.IbL.d(this.tnp);
    com.tencent.mm.sdk.b.a.IbL.d(this.tnq);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEU);
    b.b.cRk().cQG();
    AppMethodBeat.o(24836);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */