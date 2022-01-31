package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.RemoteException;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.ad;
import com.tencent.mm.h.a.gk;
import com.tencent.mm.h.a.gk.a;
import com.tencent.mm.h.a.os;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class j
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private com.tencent.mm.sdk.b.c fAU = new com.tencent.mm.sdk.b.c() {};
  private bx.a jwQ = new j.4(this);
  private volatile d koQ;
  private volatile com.tencent.mm.plugin.freewifi.g.d koR;
  private volatile com.tencent.mm.plugin.freewifi.g.b koS;
  private volatile com.tencent.mm.plugin.freewifi.g.f koT;
  private volatile c koU;
  private volatile c koV;
  private volatile a koW;
  private volatile e koX;
  private n koY = new j.7(this);
  private com.tencent.mm.sdk.b.c koZ = new j.8(this);
  private com.tencent.mm.sdk.b.c kpa = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c kpb = new com.tencent.mm.sdk.b.c()
  {
    private static boolean a(gk paramAnonymousgk)
    {
      String str1;
      f.b localb;
      if ((paramAnonymousgk.bOj.data == "MAIN_UI_EVENT_UPDATE_VIEW") && (m.aTA()))
      {
        str1 = "InterruptedProtocol31-" + System.currentTimeMillis();
        localb = f.a.aUe().aUc();
        if ((localb != null) && (!localb.koE) && (System.currentTimeMillis() - localb.kor <= 180000L) && (!m.isEmpty(localb.koC)) && (!m.isEmpty(localb.koB)) && (!m.isEmpty(localb.koD))) {
          break label102;
        }
      }
      label102:
      String str2;
      do
      {
        do
        {
          return false;
          y.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[] { str1, Integer.valueOf(1), localb.koB, localb.koC, localb.koD, Long.valueOf(localb.kor) });
          paramAnonymousgk = d.aTY();
          y.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", new Object[] { str1, Integer.valueOf(2), paramAnonymousgk });
        } while (paramAnonymousgk == null);
        str2 = m.Dm(paramAnonymousgk.getSSID());
      } while (!m.Dm(localb.koB).equals(str2));
      String str3 = paramAnonymousgk.getBSSID();
      ??? = paramAnonymousgk.getMacAddress();
      paramAnonymousgk = (gk)???;
      if (Build.VERSION.SDK_INT > 22) {
        if (??? != null)
        {
          paramAnonymousgk = (gk)???;
          if (!((String)???).equals("02:00:00:00:00:00")) {}
        }
        else
        {
          paramAnonymousgk = m.aTC();
        }
      }
      synchronized (f.a.aUe())
      {
        if (localb != f.a.aUe().aUc()) {
          return false;
        }
      }
      y.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[] { str1, Integer.valueOf(3), str2, str3, paramAnonymousgk });
      new com.tencent.mm.plugin.freewifi.d.g(str2, str3, paramAnonymousgk).b(new c.1(str1, localb));
      return false;
    }
  };
  private com.tencent.mm.sdk.b.c kpc = new j.11(this);
  private com.tencent.mm.sdk.b.c kpd = new j.12(this);
  private com.tencent.mm.sdk.b.c kpe = new j.2(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new j.1());
    dgp.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new j.5());
    dgp.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new j.6());
  }
  
  public static j aUg()
  {
    au.Hq();
    j localj2 = (j)bu.iR("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      y.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      au.Hq().a("plugin.freewifi", localj1);
    }
    return localj1;
  }
  
  public static d aUh()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koQ == null) {
      aUg().koQ = new d();
    }
    return aUg().koQ;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d aUi()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koR == null)
    {
      j localj = aUg();
      au.Hx();
      localj.koR = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.Dv());
    }
    return aUg().koR;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b aUj()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koS == null)
    {
      j localj = aUg();
      au.Hx();
      localj.koS = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.Dv());
    }
    return aUg().koS;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.f aUk()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koT == null)
    {
      j localj = aUg();
      au.Hx();
      localj.koT = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.Dv());
    }
    return aUg().koT;
  }
  
  public static c aUl()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koU == null) {
      aUg().koU = new c();
    }
    return aUg().koU;
  }
  
  public static c aUm()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koV == null) {
      aUg().koV = new c();
    }
    return aUg().koV;
  }
  
  public static a aUn()
  {
    try
    {
      com.tencent.mm.kernel.g.DN().CX();
      if (aUg().koW == null) {
        aUg().koW = new a();
      }
      a locala = aUg().koW;
      return locala;
    }
    finally {}
  }
  
  public static e aUo()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aUg().koX == null) {
      aUg().koX = new e();
    }
    return aUg().koX;
  }
  
  public final void bh(boolean paramBoolean)
  {
    au.getSysCmdMsgExtension().a("freewifi", this.jwQ, true);
    au.a(this.koY);
    com.tencent.mm.sdk.b.a.udP.c(this.koZ);
    com.tencent.mm.sdk.b.a.udP.c(this.kpa);
    com.tencent.mm.sdk.b.a.udP.c(this.kpb);
    com.tencent.mm.sdk.b.a.udP.c(this.kpc);
    com.tencent.mm.sdk.b.a.udP.c(this.kpd);
    com.tencent.mm.sdk.b.a.udP.c(this.kpe);
    com.tencent.mm.sdk.b.a.udP.c(this.fAU);
    try
    {
      this.koY.et(-9);
      b localb = b.b.aTS();
      y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)ae.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label338;
        }
        localObject2 = ((WifiManager)ae.getContext().getSystemService("wifi")).getConnectionInfo();
        localObject1 = m.Dm(((WifiInfo)localObject2).getSSID());
        localObject2 = m.Dn(((WifiInfo)localObject2).getBSSID()).toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.kor = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.kos = "";
        b.b(localb.koo.aTR(), locala);
        localb.koo = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = k.aTx();
          ((k.a)localObject2).bHI = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).dmU = m.f(localException);
          ((k.a)localObject2).aTz().aTy();
          y.e("MicroMsg.FreeWifi.UnExcepctedException", m.g(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.aTl();
      ae.getContext().registerReceiver(localb.kop, (IntentFilter)localObject1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label338:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        y.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).kor = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).kos = m.Dn(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.koo.aTR(), (b.a)localObject2);
          localRemoteException.koo = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    au.getSysCmdMsgExtension().b("freewifi", this.jwQ, true);
    aUh();
    d.release();
    aUl().release();
    au.b(this.koY);
    com.tencent.mm.sdk.b.a.udP.d(this.koZ);
    com.tencent.mm.sdk.b.a.udP.d(this.kpa);
    com.tencent.mm.sdk.b.a.udP.d(this.kpb);
    com.tencent.mm.sdk.b.a.udP.d(this.kpc);
    com.tencent.mm.sdk.b.a.udP.d(this.kpd);
    com.tencent.mm.sdk.b.a.udP.d(this.kpe);
    com.tencent.mm.sdk.b.a.udP.d(this.fAU);
    b.b.aTS().aTl();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */