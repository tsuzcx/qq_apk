package com.tencent.mm.plugin.freewifi.model;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public final class j
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private com.tencent.mm.sdk.b.c gSJ;
  private bz.a lGp;
  private volatile d mKD;
  private volatile com.tencent.mm.plugin.freewifi.g.d mKE;
  private volatile com.tencent.mm.plugin.freewifi.g.b mKF;
  private volatile f mKG;
  private volatile c mKH;
  private volatile c mKI;
  private volatile a mKJ;
  private volatile e mKK;
  private n mKL;
  private com.tencent.mm.sdk.b.c mKM;
  private com.tencent.mm.sdk.b.c mKN;
  private com.tencent.mm.sdk.b.c mKO;
  private com.tencent.mm.sdk.b.c mKP;
  private com.tencent.mm.sdk.b.c mKQ;
  private com.tencent.mm.sdk.b.c mKR;
  
  static
  {
    AppMethodBeat.i(20769);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new j.1());
    baseDBFactories.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new j.5());
    baseDBFactories.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new j.6());
    AppMethodBeat.o(20769);
  }
  
  public j()
  {
    AppMethodBeat.i(20757);
    this.mKL = new j.7(this);
    this.mKM = new j.8(this);
    this.mKN = new j.9(this);
    this.mKO = new j.10(this);
    this.mKP = new j.11(this);
    this.mKQ = new j.12(this);
    this.mKR = new j.2(this);
    this.gSJ = new com.tencent.mm.sdk.b.c() {};
    this.lGp = new j.4(this);
    AppMethodBeat.o(20757);
  }
  
  public static j bAI()
  {
    AppMethodBeat.i(20758);
    aw.aat();
    j localj2 = (j)bw.pF("plugin.freewifi");
    j localj1 = localj2;
    if (localj2 == null)
    {
      ab.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
      localj1 = new j();
      aw.aat().a("plugin.freewifi", localj1);
    }
    AppMethodBeat.o(20758);
    return localj1;
  }
  
  public static d bAJ()
  {
    AppMethodBeat.i(20759);
    g.RJ().QQ();
    if (bAI().mKD == null) {
      bAI().mKD = new d();
    }
    d locald = bAI().mKD;
    AppMethodBeat.o(20759);
    return locald;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.d bAK()
  {
    AppMethodBeat.i(20760);
    g.RJ().QQ();
    if (bAI().mKE == null)
    {
      localObject = bAI();
      aw.aaz();
      ((j)localObject).mKE = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bAI().mKE;
    AppMethodBeat.o(20760);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.freewifi.g.b bAL()
  {
    AppMethodBeat.i(20761);
    g.RJ().QQ();
    if (bAI().mKF == null)
    {
      localObject = bAI();
      aw.aaz();
      ((j)localObject).mKF = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bAI().mKF;
    AppMethodBeat.o(20761);
    return localObject;
  }
  
  public static f bAM()
  {
    AppMethodBeat.i(20762);
    g.RJ().QQ();
    if (bAI().mKG == null)
    {
      localObject = bAI();
      aw.aaz();
      ((j)localObject).mKG = new f(com.tencent.mm.model.c.Rq());
    }
    Object localObject = bAI().mKG;
    AppMethodBeat.o(20762);
    return localObject;
  }
  
  public static c bAN()
  {
    AppMethodBeat.i(20763);
    g.RJ().QQ();
    if (bAI().mKH == null) {
      bAI().mKH = new c();
    }
    c localc = bAI().mKH;
    AppMethodBeat.o(20763);
    return localc;
  }
  
  public static c bAO()
  {
    AppMethodBeat.i(20764);
    g.RJ().QQ();
    if (bAI().mKI == null) {
      bAI().mKI = new c();
    }
    c localc = bAI().mKI;
    AppMethodBeat.o(20764);
    return localc;
  }
  
  public static a bAP()
  {
    try
    {
      AppMethodBeat.i(20765);
      g.RJ().QQ();
      if (bAI().mKJ == null) {
        bAI().mKJ = new a();
      }
      a locala = bAI().mKJ;
      AppMethodBeat.o(20765);
      return locala;
    }
    finally {}
  }
  
  public static e bAQ()
  {
    AppMethodBeat.i(20768);
    g.RJ().QQ();
    if (bAI().mKK == null) {
      bAI().mKK = new e();
    }
    e locale = bAI().mKK;
    AppMethodBeat.o(20768);
    return locale;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20766);
    aw.getSysCmdMsgExtension().a("freewifi", this.lGp, true);
    aw.a(this.mKL);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKM);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKN);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKO);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKP);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKQ);
    com.tencent.mm.sdk.b.a.ymk.c(this.mKR);
    com.tencent.mm.sdk.b.a.ymk.c(this.gSJ);
    try
    {
      this.mKL.onNetworkChange(-9);
      b localb = b.b.bAv();
      ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
      try
      {
        localObject1 = (ConnectivityManager)ah.getContext().getSystemService("connectivity");
        localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[] { ((NetworkInfo)localObject2).toString() });
        if ((localObject2 == null) || (!((NetworkInfo)localObject2).isConnected())) {
          break label333;
        }
        localObject1 = m.Ou(m.Ow("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
        localObject2 = m.Ox("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
        b.a locala = new b.a((byte)0);
        locala.mKe = System.currentTimeMillis();
        locala.type = 1;
        locala.ssid = ((String)localObject1);
        locala.bssid = ((String)localObject2);
        locala.mKf = "";
        b.b(localb.mKb.bAu(), locala);
        localb.mKb = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2 = k.bAc();
          ((k.a)localObject2).coX = "UnExpectedException";
          ((k.a)localObject2).result = -1;
          ((k.a)localObject2).eev = m.e(localException);
          ((k.a)localObject2).bAe().bAd();
          ab.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(localException));
        }
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localb.bzQ();
      ah.getContext().registerReceiver(localb.mKc, (IntentFilter)localObject1);
      AppMethodBeat.o(20766);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + localRemoteException.getMessage());
        continue;
        label333:
        localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
        ab.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[] { ((NetworkInfo)localObject1).toString() });
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          localObject2 = new b.a((byte)0);
          ((b.a)localObject2).mKe = System.currentTimeMillis();
          ((b.a)localObject2).type = 0;
          ((b.a)localObject2).ssid = "";
          ((b.a)localObject2).bssid = "";
          ((b.a)localObject2).mKf = m.Ov(((NetworkInfo)localObject1).getExtraInfo());
          b.a(localRemoteException.mKb.bAu(), (b.a)localObject2);
          localRemoteException.mKb = ((b.a)localObject2);
        }
      }
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(20767);
    aw.getSysCmdMsgExtension().b("freewifi", this.lGp, true);
    bAJ();
    bAN().release();
    aw.b(this.mKL);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKM);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKN);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKO);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKP);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKQ);
    com.tencent.mm.sdk.b.a.ymk.d(this.mKR);
    com.tencent.mm.sdk.b.a.ymk.d(this.gSJ);
    b.b.bAv().bzQ();
    AppMethodBeat.o(20767);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.model.j
 * JD-Core Version:    0.7.0.1
 */