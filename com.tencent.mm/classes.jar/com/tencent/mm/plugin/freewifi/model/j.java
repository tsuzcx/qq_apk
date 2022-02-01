package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.in.a;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.te;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p netChanged;
  private IListener oVk;
  private cj.a rBq;
  private volatile d wOY;
  private volatile com.tencent.mm.plugin.freewifi.g.d wOZ;
  private volatile com.tencent.mm.plugin.freewifi.g.b wPa;
  private volatile com.tencent.mm.plugin.freewifi.g.f wPb;
  private volatile c wPc;
  private volatile c wPd;
  private volatile a wPe;
  private volatile e wPf;
  private IListener wPg;
  private IListener wPh;
  private IListener wPi;
  private IListener wPj;
  private IListener wPk;
  private IListener wPl;
  
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
    this.netChanged = new p.a()
    {
      private byte[] glH;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(24818);
        for (;;)
        {
          synchronized (this.glH)
          {
            if (!bg.aAc())
            {
              Log.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
              AppMethodBeat.o(24818);
              return;
            }
            Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + paramAnonymousInt + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
            Object localObject2 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
            if (localObject2 == null)
            {
              AppMethodBeat.o(24818);
              return;
            }
            NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject2).getNetworkInfo(1);
            if (localNetworkInfo != null)
            {
              Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(localNetworkInfo)));
              Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(localNetworkInfo.isAvailable()), Boolean.valueOf(localNetworkInfo.isConnected()), Boolean.valueOf(localNetworkInfo.isConnectedOrConnecting()) });
            }
            localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
            if (localObject2 != null)
            {
              Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", new Object[] { localObject2 });
              Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", new Object[] { Boolean.valueOf(((NetworkInfo)localObject2).isAvailable()), Boolean.valueOf(((NetworkInfo)localObject2).isConnected()), Boolean.valueOf(((NetworkInfo)localObject2).isConnectedOrConnecting()) });
              break label331;
              if (!localNetworkInfo.isConnected())
              {
                f.a.dNj().dNg();
                AppMethodBeat.o(24818);
                return;
              }
              boolean bool = f.a.dNj().ao(m.axM("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.axN("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.axO("MicroMsg.FreeWifi.SubCoreFreeWifi"));
              Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                j.dNs().dMW();
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
    this.wPg = new IListener() {};
    this.wPh = new IListener() {};
    this.wPi = new IListener()
    {
      private static boolean a(in arg0)
      {
        AppMethodBeat.i(24822);
        String str1;
        f.b localb;
        if ((???.dNg.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.dMI()))
        {
          str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
          localb = f.a.dNj().dNh();
          if ((localb != null) && (!localb.wON) && (System.currentTimeMillis() - localb.wOB <= 180000L) && (!m.eP(localb.wOL)) && (!m.eP(localb.wOK)) && (!m.eP(localb.wOM))) {
            break label114;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(24822);
          return false;
          label114:
          Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.wOK, localb.wOL, localb.wOM, Long.valueOf(localb.wOB) });
          Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", new Object[] { str1, Integer.valueOf(2) });
          String str3 = m.axM("MicroMsg.FreeWifi.Protocol31Handler");
          if (m.removeSsidQuote(localb.wOK).equals(str3))
          {
            String str4 = m.axN("MicroMsg.FreeWifi.Protocol31Handler");
            String str5 = m.axO("MicroMsg.FreeWifi.Protocol31Handler");
            synchronized (f.a.dNj())
            {
              if (localb == f.a.dNj().dNh()) {}
            }
            Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str2, Integer.valueOf(3), str3, str4, str5 });
            new com.tencent.mm.plugin.freewifi.d.g(str3, str4, str5).c(new c.1(str2, localb));
          }
        }
      }
    };
    this.wPj = new j.11(this);
    this.wPk = new j.12(this);
    this.wPl = new IListener() {};
    this.oVk = new j.3(this);
    this.rBq = new cj.a()
    {
      public final void a(com.tencent.mm.ak.h.a paramAnonymousa)
      {
        AppMethodBeat.i(24816);
        e locale = j.dNt();
        paramAnonymousa = paramAnonymousa.heO;
        if (1 != i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
          i.a.dME().dU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
        }
        if ((paramAnonymousa == null) || (paramAnonymousa.KHn == null))
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
          AppMethodBeat.o(24816);
          return;
        }
        Object localObject = z.a(paramAnonymousa.KHn);
        Log.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[] { Long.valueOf(paramAnonymousa.Brn), localObject });
        if (m.eP((String)localObject))
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
          AppMethodBeat.o(24816);
          return;
        }
        localObject = com.tencent.mm.plugin.freewifi.c.a.axQ((String)localObject);
        if (localObject == null)
        {
          Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
          AppMethodBeat.o(24816);
          return;
        }
        String str = m.axO("MicroMsg.FreeWifi.FreeWifiMessageService");
        new com.tencent.mm.plugin.freewifi.d.d(m.axM("MicroMsg.FreeWifi.FreeWifiMessageService"), m.axN("MicroMsg.FreeWifi.FreeWifiMessageService"), str, ((com.tencent.mm.plugin.freewifi.c.a)localObject).wOt, ((com.tencent.mm.plugin.freewifi.c.a)localObject).wOq, ((com.tencent.mm.plugin.freewifi.c.a)localObject).wOu, ((com.tencent.mm.plugin.freewifi.c.a)localObject).ssid, ((com.tencent.mm.plugin.freewifi.c.a)localObject).bssid).c(new e.1(locale, paramAnonymousa));
        AppMethodBeat.o(24816);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    AppMethodBeat.o(24826);
  }
  
  public static j dNl()
  {
    AppMethodBeat.i(24827);
    bg.aVz();
    j localj2 = (j)cg.KG("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      Log.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      bg.aVz().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(24827);
    return localj1;
  }
  
  public static d dNm()
  {
    AppMethodBeat.i(24828);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wOY == null) {
      dNl().wOY = new d();
    }
    d locald = dNl().wOY;
    AppMethodBeat.o(24828);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d dNn()
  {
    AppMethodBeat.i(24829);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wOZ == null)
    {
      localObject = dNl();
      bg.aVF();
      ((j)localObject).wOZ = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNl().wOZ;
    AppMethodBeat.o(24829);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b dNo()
  {
    AppMethodBeat.i(24830);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wPa == null)
    {
      localObject = dNl();
      bg.aVF();
      ((j)localObject).wPa = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNl().wPa;
    AppMethodBeat.o(24830);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.f dNp()
  {
    AppMethodBeat.i(24831);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wPb == null)
    {
      localObject = dNl();
      bg.aVF();
      ((j)localObject).wPb = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dNl().wPb;
    AppMethodBeat.o(24831);
    return localObject;
  }
  
  public static c dNq()
  {
    AppMethodBeat.i(24832);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wPc == null) {
      dNl().wPc = new c();
    }
    c localc = dNl().wPc;
    AppMethodBeat.o(24832);
    return localc;
  }
  
  public static c dNr()
  {
    AppMethodBeat.i(24833);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wPd == null) {
      dNl().wPd = new c();
    }
    c localc = dNl().wPd;
    AppMethodBeat.o(24833);
    return localc;
  }
  
  public static a dNs()
  {
    try
    {
      AppMethodBeat.i(24834);
      com.tencent.mm.kernel.g.aAf().azk();
      if (dNl().wPe == null) {
        dNl().wPe = new a();
      }
      a locala = dNl().wPe;
      AppMethodBeat.o(24834);
      return locala;
    }
    finally {}
  }
  
  public static e dNt()
  {
    AppMethodBeat.i(24837);
    com.tencent.mm.kernel.g.aAf().azk();
    if (dNl().wPf == null) {
      dNl().wPf = new e();
    }
    e locale = dNl().wPf;
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
    bg.getSysCmdMsgExtension().a("freewifi", this.rBq, true);
    bg.a(this.netChanged);
    EventCenter.instance.addListener(this.wPg);
    EventCenter.instance.addListener(this.wPh);
    EventCenter.instance.addListener(this.wPi);
    EventCenter.instance.addListener(this.wPj);
    EventCenter.instance.addListener(this.wPk);
    EventCenter.instance.addListener(this.wPl);
    EventCenter.instance.addListener(this.oVk);
    try
    {
      this.netChanged.onNetworkChange(-9);
      b localb = b.b.dMY();
      Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.removeSsidQuote(m.axM("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.axN("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.wOB = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.wOC = "";
        b.b(localb.wOy.dMX(), locala);
        localb.wOy = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = com.tencent.mm.plugin.freewifi.k.dMF();
          ((k.a)localObject2).dFd = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).resultMsg = m.l(localException);
          ((k.a)localObject2).dMH().dMG();
          Log.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.dMu();
      MMApplicationContext.getContext().registerReceiver(localb.wOz, (IntentFilter)localObject1);
      AppMethodBeat.o(24835);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label333:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).wOB = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).wOC = m.axL(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.wOy.dMX(), (b.a)localObject2);
          localRemoteException.wOy = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24836);
    bg.getSysCmdMsgExtension().b("freewifi", this.rBq, true);
    dNm();
    dNq().release();
    bg.b(this.netChanged);
    EventCenter.instance.removeListener(this.wPg);
    EventCenter.instance.removeListener(this.wPh);
    EventCenter.instance.removeListener(this.wPi);
    EventCenter.instance.removeListener(this.wPj);
    EventCenter.instance.removeListener(this.wPk);
    EventCenter.instance.removeListener(this.wPl);
    EventCenter.instance.removeListener(this.oVk);
    b.b.dMY().dMu();
    AppMethodBeat.o(24836);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */