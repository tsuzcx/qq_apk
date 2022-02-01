package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.a;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.a;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.ea.a;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.eq.a;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.es.a;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.jp.b;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.exdevice.j.j;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.pluginsdk.o.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private final long cIS;
  ap mHandler;
  public com.tencent.mm.sdk.b.c nET;
  List<b> qaQ;
  Map<String, b> qaR;
  public com.tencent.mm.sdk.b.c qaS;
  public com.tencent.mm.sdk.b.c qaT;
  public com.tencent.mm.sdk.b.c qaU;
  public com.tencent.mm.sdk.b.c qaV;
  public com.tencent.mm.sdk.b.c qaW;
  public com.tencent.mm.sdk.b.c qaX;
  public com.tencent.mm.sdk.b.c qaY;
  public com.tencent.mm.sdk.b.c qaZ;
  public com.tencent.mm.sdk.b.c qbA;
  public com.tencent.mm.sdk.b.c qbB;
  public com.tencent.mm.sdk.b.c qbC;
  public com.tencent.mm.sdk.b.c qbD;
  public com.tencent.mm.sdk.b.c qbE;
  ExdeviceWCLanSDKUtil qbF;
  g qbG;
  private boolean qbH;
  private c qbI;
  public com.tencent.mm.sdk.b.c qba;
  public com.tencent.mm.sdk.b.c qbb;
  public com.tencent.mm.sdk.b.c qbc;
  public com.tencent.mm.sdk.b.c qbd;
  public com.tencent.mm.sdk.b.c qbe;
  public com.tencent.mm.sdk.b.c qbf;
  public com.tencent.mm.sdk.b.c qbg;
  public com.tencent.mm.sdk.b.c qbh;
  public com.tencent.mm.sdk.b.c qbi;
  public com.tencent.mm.sdk.b.c qbj;
  public com.tencent.mm.sdk.b.c qbk;
  public com.tencent.mm.sdk.b.c qbl;
  public com.tencent.mm.sdk.b.c qbm;
  public com.tencent.mm.sdk.b.c qbn;
  public com.tencent.mm.sdk.b.c qbo;
  public com.tencent.mm.sdk.b.c qbp;
  public com.tencent.mm.sdk.b.c qbq;
  public com.tencent.mm.sdk.b.c qbr;
  public com.tencent.mm.sdk.b.c qbs;
  public com.tencent.mm.sdk.b.c qbt;
  public com.tencent.mm.sdk.b.c qbu;
  public com.tencent.mm.sdk.b.c qbv;
  public com.tencent.mm.sdk.b.c qbw;
  public com.tencent.mm.sdk.b.c qbx;
  public com.tencent.mm.sdk.b.c qby;
  public com.tencent.mm.sdk.b.c qbz;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.qaS = new e.1(this);
    this.qaT = new com.tencent.mm.sdk.b.c() {};
    this.qaU = new e.23(this);
    this.qaV = new e.34(this);
    this.qaW = new e.42(this);
    this.qaX = new com.tencent.mm.sdk.b.c() {};
    this.qaY = new com.tencent.mm.sdk.b.c() {};
    this.qaZ = new com.tencent.mm.sdk.b.c() {};
    this.qba = new com.tencent.mm.sdk.b.c() {};
    this.qbb = new e.2(this);
    this.qbc = new e.3(this);
    this.qbd = new e.4(this);
    this.qbe = new com.tencent.mm.sdk.b.c() {};
    this.qbf = new e.6(this);
    this.qbg = new e.7(this);
    this.qbh = new com.tencent.mm.sdk.b.c() {};
    this.qbi = new e.9(this);
    this.qbj = new e.10(this);
    this.qbk = new com.tencent.mm.sdk.b.c() {};
    this.qbl = new com.tencent.mm.sdk.b.c() {};
    this.qbm = new com.tencent.mm.sdk.b.c() {};
    this.qbn = new com.tencent.mm.sdk.b.c() {};
    this.qbo = new com.tencent.mm.sdk.b.c() {};
    this.qbp = new e.17(this);
    this.qbq = new e.18(this);
    this.qbr = new e.19(this);
    this.qbs = new e.20(this);
    this.nET = new com.tencent.mm.sdk.b.c() {};
    this.qbt = new e.22(this);
    this.qbu = new e.24(this);
    this.qbv = new e.25(this);
    this.qbw = new e.26(this);
    this.qbx = new e.27(this);
    this.qby = new e.28(this);
    this.qbz = new e.29(this);
    this.qbA = new e.30(this);
    this.qbB = new e.31(this);
    this.qbC = new e.32(this);
    this.qbD = new e.33(this);
    this.qbE = new e.35(this);
    this.cIS = 300000L;
    this.qbH = false;
    this.qaQ = new LinkedList();
    this.qaR = new HashMap();
    this.mHandler = new ap("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static int a(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(23290);
    int i = -1;
    if (bt.nullAsNil(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(23290);
      return i;
      if (bt.nullAsNil(paramb.field_connProto).contains("3")) {
        i = 0;
      }
    }
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (b)this.qaR.put(paramString, paramb);
    AppMethodBeat.o(23312);
    return paramString;
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.i.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23294);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      AppMethodBeat.o(23294);
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.clU().uD(paramb.field_mac);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.dpw == 2)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.clV().a((ae)localObject);
    }
    Object localObject = ad.clA();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).Cz(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.clA();
      long l = paramb.field_mac;
      localObject = (av)((d)localObject).qaz.remove(Long.valueOf(l));
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.clU().uH(locala.qgc)) || ((2 != locala.dpw) && (locala.dpw != 0)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.dpw), str });
        if (u.clV().qas != null) {
          u.clV().qas.uJ(locala.qgc);
        }
      }
      if (f.b(paramb))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        act(com.tencent.mm.plugin.exdevice.k.b.uO(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.dpw) && (o.e.EJB != null) && (o.e.EJB.eKE()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    el localel = new el();
    localel.dpF.cUi = paramString;
    localel.dpF.doA = paramBoolean;
    com.tencent.mm.sdk.b.a.IbL.a(localel, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  static boolean acs(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.am.g.eS(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.bX(false);
    if ((paramString == null) || (paramString.KH() == null) || (!paramString.KH().KQ()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean act(String paramString)
  {
    AppMethodBeat.i(23301);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!clf())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23301);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23301);
      return false;
    }
    ad.clF();
    h.ur(com.tencent.mm.plugin.exdevice.k.b.acY(paramString));
    AppMethodBeat.o(23301);
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23304);
    Object localObject;
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.cC(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bt.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (bt.cC(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(23304);
        return false;
      }
    }
    String str;
    if (bt.isNullOrNil(paramString1))
    {
      localObject = "null";
      if (!bt.isNullOrNil(paramString2)) {
        break label226;
      }
      str = "null";
      label131:
      if (!bt.cC(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.k.b.acY(paramString1);
      localObject = ad.clt().uN(l);
      if (localObject != null) {
        break label238;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23304);
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label131;
    }
    label238:
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.aG(paramArrayOfByte);
    if (1L != paramString1.nQV)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.nQV) });
      AppMethodBeat.o(23304);
      return false;
    }
    paramString1 = (com.tencent.mm.plugin.d.a.b.a.f)paramString1;
    paramString2 = Calendar.getInstance();
    paramString2.set(11, 0);
    paramString2.set(12, 0);
    paramString2.set(13, 0);
    i = (int)(paramString2.getTimeInMillis() / 1000L);
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.nSF, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    em localem = new em();
    localem.dpG.cUi = paramString1;
    localem.dpG.doD = paramString2;
    localem.dpG.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.IbL.a(localem, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23288);
    paramb = (dx)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.doQ.doD, paramb.doQ.context });
    LinkedList localLinkedList = ad.clt().acL(paramb.doQ.doD);
    JSONArray localJSONArray = new JSONArray();
    label222:
    for (;;)
    {
      try
      {
        Iterator localIterator = localLinkedList.iterator();
        JSONObject localJSONObject;
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          if (localLinkedList.isEmpty()) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!u.clU().uB(localb.field_mac)) {
            break label222;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.doR.doS = localJSONArray;
        paramb.doR.doF = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  public static void cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    ny localny = new ny();
    localny.dBN.op = 1;
    localny.dBN.dyL = paramString;
    localny.dBN.reason = paramInt;
    com.tencent.mm.sdk.b.a.IbL.a(localny, Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  static boolean cld()
  {
    AppMethodBeat.i(23296);
    Object localObject = ad.clt().clZ();
    if (((LinkedList)localObject).isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ad.clA().Cz(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(localb.field_brandName);
      if ((localam == null) || (!com.tencent.mm.o.b.lM(localam.field_type)))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.clA().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean cle()
  {
    AppMethodBeat.i(23297);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.clA();
    d.kM(false);
    ad.clA().clc();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean clf()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.d.a.e.a.ep(aj.getContext()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bMR())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean clg()
  {
    AppMethodBeat.i(23300);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!clf())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ad.clF().clj();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean clh()
  {
    AppMethodBeat.i(23313);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = aj.getContext();
    try
    {
      ad.clA().clc();
      com.tencent.mm.bs.d.n(new Intent(localContext, ExDeviceService.class), "exdevice");
      AppMethodBeat.o(23313);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23289);
    paramb = (es)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.dpP.doD, paramb.dpP.cUi });
    if (bt.cC(paramb.dpP.data))
    {
      paramb.dpQ.doF = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ad.clt().acJ(paramb.dpP.cUi);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.dpQ.doF = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.clU().uB(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.dpQ.doF = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.clU().uH(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.dpQ.doF = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (aa.clq().qcs) {
      aa.clq().CB(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramb.dpP.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.clV().a((ae)localObject);
    paramb.dpQ.doF = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    ny localny = new ny();
    localny.dBN.op = 2;
    localny.dBN.dyL = paramString1;
    localny.dBN.dpw = paramInt;
    localny.dBN.url = paramString2;
    localny.dBN.cUi = paramString3;
    com.tencent.mm.sdk.b.a.IbL.a(localny, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean n(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23286);
    String str = Uri.parse(paramString).getHost();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
    paramString = null;
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    boolean bool3;
    for (;;)
    {
      bool3 = bool1;
      if (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
        paramList = ((di)localObject).ffH;
        localObject = ((di)localObject).ffI;
        if ((localObject == null) || (((String)localObject).length() <= 0) || (paramList == null) || (!paramList.contains("wxmsg_url"))) {
          continue;
        }
        try
        {
          paramList = new JSONObject((String)localObject).getJSONArray("wxmsg_url");
          paramString = paramList;
          int j = paramString.length();
          i = 0;
          bool2 = bool1;
          if (i >= j) {}
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            try
            {
              boolean bool2 = paramString.getString(i).equals(str);
              if (!bool2) {
                continue;
              }
              bool2 = true;
              bool3 = bool2;
              if (bool2) {
                break label213;
              }
              bool1 = bool2;
            }
            catch (JSONException paramList)
            {
              int i;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
          }
        }
      }
    }
    label213:
    AppMethodBeat.o(23286);
    return bool3;
  }
  
  static boolean o(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23287);
    if (paramString == null)
    {
      AppMethodBeat.o(23287);
      return false;
    }
    Object localObject = new jp();
    ((jp)localObject).dwt.doX = paramString;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jp)localObject).dwu.dwv;
    int i = ((TimeLineObject)localObject).HAT.GaP;
    boolean bool;
    if (i == 1)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).ffH;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      AppMethodBeat.o(23287);
      return bool;
      bool = false;
      continue;
      if (i == 4)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).ffH;
            if ((localObject != null) && (((String)localObject).contains("wxmsg_music")))
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
      }
      else if (i == 15)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).ffH;
            if ((localObject != null) && (((String)localObject).contains("wxmsg_video")))
            {
              bool = true;
              break;
            }
          }
        }
        bool = false;
      }
      else if (i == 3)
      {
        bool = n(((TimeLineObject)localObject).HAT.Url, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(23310);
    if (this.qaQ.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.qaQ.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.am.g.eS(paramString);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).bX(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).KH();
      if ((localObject2 != null) && (((c.b.b)localObject2).KQ())) {}
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ad.clt().acL(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).cRe == 1)
    {
      localObject2 = ad.clt().clZ();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((di)localObject3).ffG) });
          if (0L != (((di)localObject3).ffG & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      AppMethodBeat.o(23298);
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
      AppMethodBeat.o(23298);
      return true;
    }
    int j = 0;
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    int k;
    int m;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("4"))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy) });
        }
        else if (bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.d.a.e.a.bMP())
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
            j = k;
            continue;
          }
          m = 1;
          j = i;
          i = k;
          k = m;
        }
      }
    }
    for (;;)
    {
      label495:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.clA();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).qaA.containsKey(Long.valueOf(l)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (av)((d)localObject3).qaA.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((av)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.clU().uB(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.clU().uH(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              e(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.ep(aj.getContext()))
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label495;
              label780:
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.eF(aj.getContext()))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          acu(com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ad.clA().Cz(1);
        ad.clA().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.clA().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          acu(com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.clA().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.clA().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          act(com.tencent.mm.plugin.exdevice.k.b.uO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.clA();
        d.ur(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.bMR())
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          cX(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.ep(aj.getContext())))
        {
          cX(paramString, 1);
          continue;
          cX(paramString, -1);
        }
      }
      label1357:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean acu(String paramString)
  {
    AppMethodBeat.i(23302);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!clf())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23302);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23302);
      return false;
    }
    ad.clF().a(com.tencent.mm.plugin.exdevice.k.b.acY(paramString), new h.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23272);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = e.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.uO(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((e)localObject1).qaQ)
        {
          localLinkedList = new LinkedList(((e)localObject1).qaQ);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((e.b)((Iterator)???).next()).d(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        localLinkedList.clear();
        localObject1 = ((e)localObject1).qaR.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).d(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new fa();
        ((fa)localObject1).dqk.mac = str2;
        ((fa)localObject1).dqk.dpw = paramAnonymousInt2;
        ((fa)localObject1).dqk.dqh = paramAnonymousLong2;
        com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
        AppMethodBeat.o(23272);
      }
    });
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(23311);
    if (this.qaQ.remove(paramb))
    {
      AppMethodBeat.o(23311);
      return true;
    }
    AppMethodBeat.o(23311);
    return false;
  }
  
  final boolean b(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23285);
    paramb = (dy)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.doT.doD, paramb.doT.context });
    if (!acs(paramb.doT.doD))
    {
      paramb.doU.doS = null;
      paramb.doU.doF = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ad.clt().acL(paramb.doT.doD);
    JSONArray localJSONArray = new JSONArray();
    label280:
    for (;;)
    {
      try
      {
        Iterator localIterator = localLinkedList.iterator();
        JSONObject localJSONObject;
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          if ((localLinkedList.isEmpty()) || (!bt.nullAsNil(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.qbF.acw(localb.field_deviceID)) {
            break label280;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.doU.doS = localJSONArray;
        paramb.doU.doF = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23291);
    paramb = (ea)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.dpb.doD, paramb.dpb.cUi, Integer.valueOf(paramb.dpb.type) });
    Object localObject2 = new bca();
    ((bca)localObject2).GyM = paramb.dpb.type;
    ((bca)localObject2).GyN = 0;
    ((bca)localObject2).FCT = new bnj();
    ((bca)localObject2).FCT.nDr = paramb.dpb.cUi;
    ((bca)localObject2).FCT.FzJ = paramb.dpb.doD;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramb);
    localObject1 = new z((LinkedList)localObject1, paramb.dpb.doD, paramb.dpb.dpd);
    ba.aiU().a(543, (com.tencent.mm.al.f)localObject2);
    if (!ba.aiU().a((n)localObject1, 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      ba.aiU().b(543, (com.tencent.mm.al.f)localObject2);
      paramb.dpc.dpe = true;
      paramb.dpc.dpf = null;
      if (paramb.callback != null) {
        paramb.callback.run();
      }
      AppMethodBeat.o(23291);
      return true;
    }
    AppMethodBeat.o(23291);
    return false;
  }
  
  final boolean f(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23292);
    paramb = (eq)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.dpK.doD, Boolean.valueOf(paramb.dpK.doE), Integer.valueOf(paramb.dpK.dpM) });
    int j = paramb.dpK.dpM;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.ep(aj.getContext())) {
          break label197;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.dpK.doE)
    {
      localaa = aa.clq();
      ??? = paramb.dpK.doD;
      localObject2 = new aa.a()
      {
        public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23269);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramAnonymousString });
          if (paramAnonymousArrayOfByte == null) {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          }
          for (;;)
          {
            en localen = new en();
            localen.dpH.dpz = paramAnonymousArrayOfByte;
            localen.dpH.cUi = paramAnonymousString;
            localen.dpH.bsb = paramAnonymousBoolean;
            com.tencent.mm.sdk.b.a.IbL.a(localen, Looper.getMainLooper());
            AppMethodBeat.o(23269);
            return;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramAnonymousString, Base64.encodeToString(paramAnonymousArrayOfByte, 0), Boolean.valueOf(paramAnonymousBoolean) });
          }
        }
      };
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (bt.isNullOrNil((String)???)) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramb.dpL.doF = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.dpL.doF = false;
      AppMethodBeat.o(23292);
      return false;
      localaa.qbM = ((String)???);
      localaa.qdf = ((aa.a)localObject2);
      localaa.qdg.clear();
      ??? = localaa.qdh.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (n)((Iterator)???).next();
        if (localObject2 != null) {
          ba.aiU().a((n)localObject2);
        }
      }
      localaa.qdh.clear();
      synchronized (aa.dcK)
      {
        aa.qdi.clear();
        if (!localaa.qcs)
        {
          localaa.qcs = true;
          ba.aiU().a(542, localaa);
          ad.clA().a(i, localaa);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.jkD.az(12000L, 12000L);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.clq().CB(i);
    }
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.qaQ)
    {
      localLinkedList = new LinkedList(this.qaQ);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.qaR.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new fc();
    ((fc)???).dqm.dqg = paramString1;
    ((fc)???).dqm.mac = paramString2;
    ((fc)???).dqm.bsb = paramBoolean;
    com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  final boolean n(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
  {
    AppMethodBeat.i(23295);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
      AppMethodBeat.o(23295);
      return false;
    }
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.exdevice.i.b)paramList.next();
        localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, paramInt);
        u.clV().a((ae)localObject);
      }
      if (this.qbH) {
        this.mHandler.removeCallbacks(this.qbI);
      }
      this.qbI = new c(paramList);
      this.mHandler.postDelayed(this.qbI, 300000L);
      this.qbH = true;
      paramInt = 2;
      continue;
      if (this.qbH)
      {
        this.mHandler.removeCallbacks(this.qbI);
        this.qbH = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final boolean o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23303);
    if ((bt.isNullOrNil(paramString)) || (bt.cC(paramArrayOfByte)))
    {
      if (bt.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!bt.cC(paramArrayOfByte)) {
          break label79;
        }
      }
      label79:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(23303);
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (bt.isNullOrNil(paramString))
    {
      str = "null";
      if (!bt.cC(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.k.b.acY(paramString);
      paramString = ad.clF().qct.uE(l);
      if (paramString != null) {
        break label182;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23303);
      return false;
      str = paramString;
      break;
    }
    label182:
    if (paramString.dpw != 2)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ad.clF();
    boolean bool = h.a(l, paramArrayOfByte, new t.a()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(23273);
        Object localObject1 = paramAnonymousString;
        if (paramAnonymousString == null) {
          localObject1 = "null";
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localObject1 });
        localObject1 = e.this;
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.uO(paramAnonymousLong);
        boolean bool;
        if (paramAnonymousInt2 == 0) {
          bool = true;
        }
        LinkedList localLinkedList;
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (bool) {
            break label250;
          }
          synchronized (((e)localObject1).qaQ)
          {
            localLinkedList = new LinkedList(((e)localObject1).qaQ);
            ??? = localLinkedList.iterator();
            while (((Iterator)???).hasNext())
            {
              ((e.b)((Iterator)???).next()).b(paramAnonymousString, null, false);
              continue;
              bool = false;
            }
          }
        }
        localLinkedList.clear();
        localObject1 = ((e)localObject1).qaR.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).b(paramAnonymousString, null, false);
        }
        label250:
        AppMethodBeat.o(23273);
      }
    });
    AppMethodBeat.o(23303);
    return bool;
  }
  
  public final class a
    implements e.b
  {
    private String cOA;
    private String mURL;
    private String qbM;
    private String qbN;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.qbM = paramString1;
      this.cOA = paramString2;
      this.mURL = paramString3;
      this.qbN = paramString4;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.cOA == null) || (!this.cOA.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.cOA, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.clE();
          if (!e.b(this.cOA, this.qbM, paramArrayOfByte))
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
            AppMethodBeat.o(23281);
            return;
          }
          AppMethodBeat.o(23281);
          return;
        }
        catch (Exception paramString)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
        }
      }
      AppMethodBeat.o(23281);
    }
    
    public final void d(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.cOA == null) || (!this.cOA.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.cOA, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.e(this.qbM, this.mURL, -1, this.qbN);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.e(this.qbM, this.mURL, 2, this.qbN);
        paramString = new com.tencent.mm.plugin.d.a.b.a.f();
        paramString.nRB = com.tencent.mm.plugin.d.a.b.a.f.nSD;
        paramString.nRC = 2;
        ad.clE().o(this.cOA, com.tencent.mm.plugin.exdevice.k.b.cW(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.e(this.qbM, this.mURL, 1, this.qbN);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.e(this.qbM, this.mURL, 4, this.qbN);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.e(this.qbM, this.mURL, 0, this.qbN);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void o(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.cOA == null) || (!this.cOA.equals(paramString2)))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.cOA, paramString2, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23280);
        return;
      }
      AppMethodBeat.o(23280);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void d(String paramString, int paramInt, long paramLong);
    
    public abstract void o(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    List<com.tencent.mm.plugin.exdevice.i.b> hJk;
    
    public c()
    {
      Object localObject;
      this.hJk = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23283);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
      if ((this.hJk != null) && (this.hJk.size() > 0))
      {
        Iterator localIterator = this.hJk.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, 1);
          u.clV().a((ae)localObject);
        }
        e.this.mHandler.postDelayed(this, 300000L);
      }
      AppMethodBeat.o(23283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */