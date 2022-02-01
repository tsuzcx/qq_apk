package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hy.a;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
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
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private com.tencent.mm.sdk.b.c nKp;
  private cf.a qkv;
  private volatile d txU;
  private volatile com.tencent.mm.plugin.freewifi.g.d txV;
  private volatile com.tencent.mm.plugin.freewifi.g.b txW;
  private volatile com.tencent.mm.plugin.freewifi.g.f txX;
  private volatile c txY;
  private volatile c txZ;
  private volatile a tya;
  private volatile e tyb;
  private n tyc;
  private com.tencent.mm.sdk.b.c tyd;
  private com.tencent.mm.sdk.b.c tye;
  private com.tencent.mm.sdk.b.c tyf;
  private com.tencent.mm.sdk.b.c tyg;
  private com.tencent.mm.sdk.b.c tyh;
  private com.tencent.mm.sdk.b.c tyi;
  
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
    this.tyc = new n.a()
    {
      private byte[] fGy;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(24818);
        for (;;)
        {
          synchronized (this.fGy)
          {
            if (!bc.ajM())
            {
              ae.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
              AppMethodBeat.o(24818);
              return;
            }
            ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramAnonymousInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
            Object localObject2 = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
            if (localObject2 == null)
            {
              AppMethodBeat.o(24818);
              return;
            }
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
            if (localNetworkInfo != null)
            {
              ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(localNetworkInfo)));
              ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
            }
            localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
            if (localObject2 != null)
            {
              ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
              ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
              break label331;
              if (!localNetworkInfo.isConnected())
              {
                f.a.cUa().cTX();
                AppMethodBeat.o(24818);
                return;
              }
              boolean bool = f.a.cUa().ag(m.akI("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.akJ("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.akK("MicroMsg.FreeWifi.SubCoreFreeWifi"));
              ae.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                j.cUj().cTN();
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
    this.tyd = new com.tencent.mm.sdk.b.c() {};
    this.tye = new com.tencent.mm.sdk.b.c() {};
    this.tyf = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(hy arg0)
      {
        AppMethodBeat.i(24822);
        String str1;
        f.b localb;
        if ((???.dvz.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.cTz()))
        {
          str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
          localb = f.a.cUa().cTY();
          if ((localb != null) && (!localb.txJ) && (System.currentTimeMillis() - localb.txx <= 180000L) && (!m.ef(localb.txH)) && (!m.ef(localb.txG)) && (!m.ef(localb.txI))) {
            break label114;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(24822);
          return false;
          label114:
          ae.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.txG, localb.txH, localb.txI, Long.valueOf(localb.txx) });
          ae.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
          String str3 = m.akI("MicroMsg.FreeWifi.Protocol31Handler");
          if (m.akG(localb.txG).equals(str3))
          {
            String str4 = m.akJ("MicroMsg.FreeWifi.Protocol31Handler");
            String str5 = m.akK("MicroMsg.FreeWifi.Protocol31Handler");
            synchronized (f.a.cUa())
            {
              if (localb == f.a.cUa().cTY()) {}
            }
            ae.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
            new com.tencent.mm.plugin.freewifi.d.g(str3, str4, str5).c(new c.1(str2, localb));
          }
        }
      }
    };
    this.tyg = new j.11(this);
    this.tyh = new j.12(this);
    this.tyi = new j.2(this);
    this.nKp = new j.3(this);
    this.qkv = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(24816);
        e locale = j.cUk();
        paramAnonymousa = paramAnonymousa.gte;
        if (1 != i.a.cTv().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
          i.a.cTv().dF("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if ((paramAnonymousa == null) || (paramAnonymousa.FNI == null))
        {
          ae.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          AppMethodBeat.o(24816);
          return;
        }
        Object localObject = z.a(paramAnonymousa.FNI);
        ae.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(paramAnonymousa.xrk), localObject });
        if (m.ef((String)localObject))
        {
          ae.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          AppMethodBeat.o(24816);
          return;
        }
        localObject = com.tencent.mm.plugin.freewifi.c.a.akM((String)localObject);
        if (localObject == null)
        {
          ae.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          AppMethodBeat.o(24816);
          return;
        }
        String str = m.akK("MicroMsg.FreeWifi.FreeWifiMessageService");
        new com.tencent.mm.plugin.freewifi.d.d(m.akI("MicroMsg.FreeWifi.FreeWifiMessageService"), m.akJ("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((com.tencent.mm.plugin.freewifi.c.a)localObject).txp, ((com.tencent.mm.plugin.freewifi.c.a)localObject).txm, ((com.tencent.mm.plugin.freewifi.c.a)localObject).txq, ((com.tencent.mm.plugin.freewifi.c.a)localObject).ssid, ((com.tencent.mm.plugin.freewifi.c.a)localObject).bssid).c(new e.1(locale, paramAnonymousa));
        AppMethodBeat.o(24816);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(24826);
  }
  
  public static j cUc()
  {
    AppMethodBeat.i(24827);
    bc.aCa();
    j localj2 = (j)cc.Ca("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      ae.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      bc.aCa().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(24827);
    return localj1;
  }
  
  public static d cUd()
  {
    AppMethodBeat.i(24828);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txU == null) {
      cUc().txU = new d();
    }
    d locald = cUc().txU;
    AppMethodBeat.o(24828);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d cUe()
  {
    AppMethodBeat.i(24829);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txV == null)
    {
      localObject = cUc();
      bc.aCg();
      ((j)localObject).txV = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cUc().txV;
    AppMethodBeat.o(24829);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b cUf()
  {
    AppMethodBeat.i(24830);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txW == null)
    {
      localObject = cUc();
      bc.aCg();
      ((j)localObject).txW = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cUc().txW;
    AppMethodBeat.o(24830);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.f cUg()
  {
    AppMethodBeat.i(24831);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txX == null)
    {
      localObject = cUc();
      bc.aCg();
      ((j)localObject).txX = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cUc().txX;
    AppMethodBeat.o(24831);
    return localObject;
  }
  
  public static c cUh()
  {
    AppMethodBeat.i(24832);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txY == null) {
      cUc().txY = new c();
    }
    c localc = cUc().txY;
    AppMethodBeat.o(24832);
    return localc;
  }
  
  public static c cUi()
  {
    AppMethodBeat.i(24833);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().txZ == null) {
      cUc().txZ = new c();
    }
    c localc = cUc().txZ;
    AppMethodBeat.o(24833);
    return localc;
  }
  
  public static a cUj()
  {
    try
    {
      AppMethodBeat.i(24834);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (cUc().tya == null) {
        cUc().tya = new a();
      }
      a locala = cUc().tya;
      AppMethodBeat.o(24834);
      return locala;
    }
    finally {}
  }
  
  public static e cUk()
  {
    AppMethodBeat.i(24837);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cUc().tyb == null) {
      cUc().tyb = new e();
    }
    e locale = cUc().tyb;
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
    bc.getSysCmdMsgExtension().a("freewifi", this.qkv, true);
    bc.a(this.tyc);
    com.tencent.mm.sdk.b.a.IvT.c(this.tyd);
    com.tencent.mm.sdk.b.a.IvT.c(this.tye);
    com.tencent.mm.sdk.b.a.IvT.c(this.tyf);
    com.tencent.mm.sdk.b.a.IvT.c(this.tyg);
    com.tencent.mm.sdk.b.a.IvT.c(this.tyh);
    com.tencent.mm.sdk.b.a.IvT.c(this.tyi);
    com.tencent.mm.sdk.b.a.IvT.c(this.nKp);
    try
    {
      this.tyc.onNetworkChange(-9);
      b localb = b.b.cTP();
      ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)ak.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.akG(m.akI("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.akJ("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.txx = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.txy = "";
        b.b(localb.txu.cTO(), locala);
        localb.txu = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = com.tencent.mm.plugin.freewifi.k.cTw();
          ((k.a)localObject2).dnO = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).fMT = m.l(localException);
          ((k.a)localObject2).cTy().cTx();
          ae.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.cTl();
      ak.getContext().registerReceiver(localb.txv, (IntentFilter)localObject1);
      AppMethodBeat.o(24835);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ae.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label333:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        ae.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).txx = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).txy = m.akH(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.txu.cTO(), (b.a)localObject2);
          localRemoteException.txu = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24836);
    bc.getSysCmdMsgExtension().b("freewifi", this.qkv, true);
    cUd();
    cUh().release();
    bc.b(this.tyc);
    com.tencent.mm.sdk.b.a.IvT.d(this.tyd);
    com.tencent.mm.sdk.b.a.IvT.d(this.tye);
    com.tencent.mm.sdk.b.a.IvT.d(this.tyf);
    com.tencent.mm.sdk.b.a.IvT.d(this.tyg);
    com.tencent.mm.sdk.b.a.IvT.d(this.tyh);
    com.tencent.mm.sdk.b.a.IvT.d(this.tyi);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKp);
    b.b.cTP().cTl();
    AppMethodBeat.o(24836);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */