package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.a;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.a;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ee.a;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.eu.a;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ew.a;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.kf.b;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.do;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  private final long cZY;
  MMHandler mHandler;
  public IListener oVj;
  public IListener ryA;
  public IListener ryB;
  public IListener ryC;
  public IListener ryD;
  public IListener ryE;
  public IListener ryF;
  public IListener ryG;
  public IListener ryH;
  public IListener ryI;
  public IListener ryJ;
  public IListener ryK;
  public IListener ryL;
  public IListener ryM;
  public IListener ryN;
  public IListener ryO;
  public IListener ryP;
  public IListener ryQ;
  public IListener ryR;
  public IListener ryS;
  public IListener ryT;
  public IListener ryU;
  public IListener ryV;
  public IListener ryW;
  public IListener ryX;
  public IListener ryY;
  public IListener ryZ;
  List<b> ryr;
  Map<String, b> rys;
  public IListener ryt;
  public IListener ryu;
  public IListener ryv;
  public IListener ryw;
  public IListener ryx;
  public IListener ryy;
  public IListener ryz;
  public IListener rza;
  public IListener rzb;
  public IListener rzc;
  public IListener rzd;
  public IListener rze;
  public IListener rzf;
  ExdeviceWCLanSDKUtil rzg;
  g rzh;
  private boolean rzi;
  private c rzj;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.ryt = new IListener() {};
    this.ryu = new IListener() {};
    this.ryv = new e.23(this);
    this.ryw = new e.34(this);
    this.ryx = new IListener() {};
    this.ryy = new e.43(this);
    this.ryz = new IListener() {};
    this.ryA = new IListener() {};
    this.ryB = new e.46(this);
    this.ryC = new e.2(this);
    this.ryD = new e.3(this);
    this.ryE = new e.4(this);
    this.ryF = new IListener() {};
    this.ryG = new e.6(this);
    this.ryH = new e.7(this);
    this.ryI = new IListener() {};
    this.ryJ = new e.9(this);
    this.ryK = new e.10(this);
    this.ryL = new IListener() {};
    this.ryM = new IListener() {};
    this.ryN = new IListener() {};
    this.ryO = new IListener() {};
    this.ryP = new IListener() {};
    this.ryQ = new e.17(this);
    this.ryR = new IListener() {};
    this.ryS = new e.19(this);
    this.ryT = new e.20(this);
    this.oVj = new e.21(this);
    this.ryU = new e.22(this);
    this.ryV = new IListener() {};
    this.ryW = new IListener() {};
    this.ryX = new IListener() {};
    this.ryY = new IListener() {};
    this.ryZ = new IListener() {};
    this.rza = new IListener() {};
    this.rzb = new IListener() {};
    this.rzc = new e.31(this);
    this.rzd = new e.32(this);
    this.rze = new e.33(this);
    this.rzf = new e.35(this);
    this.cZY = 300000L;
    this.rzi = false;
    this.ryr = new LinkedList();
    this.rys = new HashMap();
    this.mHandler = new MMHandler("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static int a(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(23290);
    int i = -1;
    if (Util.nullAsNil(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(23290);
      return i;
      if (Util.nullAsNil(paramb.field_connProto).contains("3")) {
        i = 0;
      }
    }
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (b)this.rys.put(paramString, paramb);
    AppMethodBeat.o(23312);
    return paramString;
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.i.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23294);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      AppMethodBeat.o(23294);
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.cLx().CY(paramb.field_mac);
    if (locala == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.dHO == 2)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.cLy().a((ae)localObject);
    }
    Object localObject = ad.cKS();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).Gw(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.cKS();
      long l = paramb.field_mac;
      localObject = (MTimerHandler)((d)localObject).rya.remove(Long.valueOf(l));
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.cLx().Dc(locala.rDD)) || ((2 != locala.dHO) && (locala.dHO != 0)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.dHO), str });
        if (u.cLy().rxT != null) {
          u.cLy().rxT.De(locala.rDD);
        }
      }
      if (f.b(paramb))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        ant(com.tencent.mm.plugin.exdevice.k.b.Dj(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.dHO) && (o.e.JSY != null) && (o.e.JSY.fVV()))
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ep localep = new ep();
    localep.dHX.dGL = paramString;
    localep.dHX.dGT = paramBoolean;
    EventCenter.instance.asyncPublish(localep, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  static boolean ans(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.al.g.fJ(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.cG(false);
    if ((paramString == null) || (paramString.UZ() == null) || (!paramString.UZ().Vi()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean ant(String paramString)
  {
    AppMethodBeat.i(23301);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!cKx())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23301);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23301);
      return false;
    }
    ad.cKX();
    h.CM(com.tencent.mm.plugin.exdevice.k.b.anY(paramString));
    AppMethodBeat.o(23301);
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23304);
    Object localObject;
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (Util.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (Util.isNullOrNil(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(23304);
        return false;
      }
    }
    String str;
    if (Util.isNullOrNil(paramString1))
    {
      localObject = "null";
      if (!Util.isNullOrNil(paramString2)) {
        break label226;
      }
      str = "null";
      label131:
      if (!Util.isNullOrNil(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.k.b.anY(paramString1);
      localObject = ad.cKL().Di(l);
      if (localObject != null) {
        break label238;
      }
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23304);
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label131;
    }
    label238:
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.aX(paramArrayOfByte);
    if (1L != paramString1.phx)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.phx) });
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
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.pjj, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    eq localeq = new eq();
    localeq.dHY.dGL = paramString1;
    localeq.dHY.brandName = paramString2;
    localeq.dHY.data = paramArrayOfByte;
    EventCenter.instance.asyncPublish(localeq, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(IEvent paramIEvent)
  {
    AppMethodBeat.i(23288);
    paramIEvent = (eb)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.dHi.brandName, paramIEvent.dHi.context });
    LinkedList localLinkedList = ad.cKL().anL(paramIEvent.dHi.brandName);
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
          if (!u.cLx().CW(localb.field_mac)) {
            break label222;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramIEvent.dHj.dHk = localJSONArray;
        paramIEvent.dHj.dGX = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  static boolean cKv()
  {
    AppMethodBeat.i(23296);
    Object localObject = ad.cKL().cLC();
    if (((LinkedList)localObject).isEmpty())
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ad.cKS().Gw(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(localb.field_brandName);
      if ((localas == null) || (!com.tencent.mm.contact.c.oR(localas.field_type)))
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.cKS().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean cKw()
  {
    AppMethodBeat.i(23297);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.cKS();
    d.lO(false);
    ad.cKS().cKu();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean cKx()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.ckP())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean cKy()
  {
    AppMethodBeat.i(23300);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!cKx())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ad.cKX().cKB();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean cKz()
  {
    AppMethodBeat.i(23313);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = MMApplicationContext.getContext();
    try
    {
      ad.cKS().cKu();
      com.tencent.mm.br.c.o(new Intent(localContext, ExDeviceService.class), "exdevice");
      AppMethodBeat.o(23313);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    or localor = new or();
    localor.dUI.op = 2;
    localor.dUI.dRD = paramString1;
    localor.dUI.dHO = paramInt;
    localor.dUI.url = paramString2;
    localor.dUI.dGL = paramString3;
    EventCenter.instance.asyncPublish(localor, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean d(IEvent paramIEvent)
  {
    AppMethodBeat.i(23289);
    paramIEvent = (ew)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramIEvent.dIh.brandName, paramIEvent.dIh.dGL });
    if (Util.isNullOrNil(paramIEvent.dIh.data))
    {
      paramIEvent.dIi.dGX = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ad.cKL().anJ(paramIEvent.dIh.dGL);
    if (localObject == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramIEvent.dIi.dGX = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cLx().CW(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramIEvent.dIi.dGX = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cLx().Dc(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramIEvent.dIi.dGX = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (aa.cKI().rzT) {
      aa.cKI().Gy(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramIEvent.dIh.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.cLy().a((ae)localObject);
    paramIEvent.dIi.dGX = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static void dh(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    or localor = new or();
    localor.dUI.op = 1;
    localor.dUI.dRD = paramString;
    localor.dUI.bDZ = paramInt;
    EventCenter.instance.asyncPublish(localor, Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  static boolean o(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23286);
    String str = Uri.parse(paramString).getHost();
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
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
        paramList = ((do)localObject).fMh;
        localObject = ((do)localObject).fMi;
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
              Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
          }
        }
      }
    }
    label213:
    AppMethodBeat.o(23286);
    return bool3;
  }
  
  static boolean p(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23287);
    if (paramString == null)
    {
      AppMethodBeat.o(23287);
      return false;
    }
    Object localObject = new kf();
    ((kf)localObject).dPf.dHp = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((kf)localObject).dPg.dPh;
    int i = ((TimeLineObject)localObject).ContentObj.LoU;
    boolean bool;
    if (i == 1)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fMh;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      AppMethodBeat.o(23287);
      return bool;
      bool = false;
      continue;
      if ((i == 4) || (i == 42))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fMh;
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
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fMh;
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
        bool = o(((TimeLineObject)localObject).ContentObj.Url, paramList);
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
    if (this.ryr.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.ryr.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aR(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    Log.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.al.g.fJ(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).cG(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).UZ();
      if ((localObject2 != null) && (((c.b.b)localObject2).Vi())) {}
    }
    else
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ad.cKL().anL(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).dih == 1)
    {
      localObject2 = ad.cKL().cLC();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((do)localObject3).fMg) });
          if (0L != (((do)localObject3).fMg & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      AppMethodBeat.o(23298);
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
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
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("4"))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy) });
        }
        else if (Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.d.a.e.a.ckN())
          {
            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
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
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.cKS();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).ryb.containsKey(Long.valueOf(l)))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (MTimerHandler)((d)localObject3).ryb.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((MTimerHandler)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.cLx().CW(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.cLx().Dc(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              d(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext()))
              {
                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label495;
              label780:
              Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.fd(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          anu(com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ad.cKS().Gw(1);
        ad.cKS().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cKS().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          anu(com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cKS().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cKS().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          ant(com.tencent.mm.plugin.exdevice.k.b.Dj(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cKS();
        d.CM(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.ckP())
        {
          Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          dh(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())))
        {
          dh(paramString, 1);
          continue;
          dh(paramString, -1);
        }
      }
      label1357:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean anu(String paramString)
  {
    AppMethodBeat.i(23302);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!cKx())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23302);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23302);
      return false;
    }
    ad.cKX().a(com.tencent.mm.plugin.exdevice.k.b.anY(paramString), new h.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23272);
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = e.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.Dj(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((e)localObject1).ryr)
        {
          localLinkedList = new LinkedList(((e)localObject1).ryr);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((e.b)((Iterator)???).next()).c(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        localLinkedList.clear();
        localObject1 = ((e)localObject1).rys.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).c(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new fe();
        ((fe)localObject1).dIB.mac = str2;
        ((fe)localObject1).dIB.dHO = paramAnonymousInt2;
        ((fe)localObject1).dIB.dIy = paramAnonymousLong2;
        EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.getMainLooper());
        AppMethodBeat.o(23272);
      }
    });
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(23311);
    if (this.ryr.remove(paramb))
    {
      AppMethodBeat.o(23311);
      return true;
    }
    AppMethodBeat.o(23311);
    return false;
  }
  
  final boolean b(IEvent paramIEvent)
  {
    AppMethodBeat.i(23285);
    paramIEvent = (ec)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.dHl.brandName, paramIEvent.dHl.context });
    if (!ans(paramIEvent.dHl.brandName))
    {
      paramIEvent.dHm.dHk = null;
      paramIEvent.dHm.dGX = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ad.cKL().anL(paramIEvent.dHl.brandName);
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
          if ((localLinkedList.isEmpty()) || (!Util.nullAsNil(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.rzg.anw(localb.field_deviceID)) {
            break label280;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramIEvent.dHm.dHk = localJSONArray;
        paramIEvent.dHm.dGX = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(IEvent paramIEvent)
  {
    AppMethodBeat.i(23291);
    paramIEvent = (ee)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramIEvent.dHt.brandName, paramIEvent.dHt.dGL, Integer.valueOf(paramIEvent.dHt.type) });
    Object localObject2 = new boc();
    ((boc)localObject2).LWr = paramIEvent.dHt.type;
    ((boc)localObject2).LWs = 0;
    ((boc)localObject2).KOZ = new cat();
    ((boc)localObject2).KOZ.oTH = paramIEvent.dHt.dGL;
    ((boc)localObject2).KOZ.KLO = paramIEvent.dHt.brandName;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramIEvent);
    localObject1 = new z((LinkedList)localObject1, paramIEvent.dHt.brandName, paramIEvent.dHt.dHv);
    bg.azz().a(543, (i)localObject2);
    if (!bg.azz().a((q)localObject1, 0))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      bg.azz().b(543, (i)localObject2);
      paramIEvent.dHu.dHw = true;
      paramIEvent.dHu.dHx = null;
      if (paramIEvent.callback != null) {
        paramIEvent.callback.run();
      }
      AppMethodBeat.o(23291);
      return true;
    }
    AppMethodBeat.o(23291);
    return false;
  }
  
  final boolean f(IEvent paramIEvent)
  {
    AppMethodBeat.i(23292);
    paramIEvent = (eu)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramIEvent.dIc.brandName, Boolean.valueOf(paramIEvent.dIc.dGW), Integer.valueOf(paramIEvent.dIc.dIe) });
    int j = paramIEvent.dIc.dIe;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
          break label197;
        }
        Log.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramIEvent.dIc.dGW)
    {
      localaa = aa.cKI();
      ??? = paramIEvent.dIc.brandName;
      localObject2 = new aa.a()
      {
        public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23269);
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramAnonymousString });
          if (paramAnonymousArrayOfByte == null) {
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          }
          for (;;)
          {
            er localer = new er();
            localer.dHZ.dHR = paramAnonymousArrayOfByte;
            localer.dHZ.dGL = paramAnonymousString;
            localer.dHZ.brW = paramAnonymousBoolean;
            EventCenter.instance.asyncPublish(localer, Looper.getMainLooper());
            AppMethodBeat.o(23269);
            return;
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramAnonymousString, Base64.encodeToString(paramAnonymousArrayOfByte, 0), Boolean.valueOf(paramAnonymousBoolean) });
          }
        }
      };
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (Util.isNullOrNil((String)???)) {
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramIEvent.dId.dGX = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramIEvent.dId.dGX = false;
      AppMethodBeat.o(23292);
      return false;
      localaa.rzn = ((String)???);
      localaa.rAF = ((aa.a)localObject2);
      localaa.rAG.clear();
      ??? = localaa.rAH.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (q)((Iterator)???).next();
        if (localObject2 != null) {
          bg.azz().a((q)localObject2);
        }
      }
      localaa.rAH.clear();
      synchronized (aa.duI)
      {
        aa.rAI.clear();
        if (!localaa.rzT)
        {
          localaa.rzT = true;
          bg.azz().a(542, localaa);
          ad.cKS().a(i, localaa);
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.klF.startTimer(12000L);
        }
      }
      Log.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.cKI().Gy(i);
    }
  }
  
  public final boolean n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23303);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramArrayOfByte)))
    {
      if (Util.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!Util.isNullOrNil(paramArrayOfByte)) {
          break label79;
        }
      }
      label79:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(23303);
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (Util.isNullOrNil(paramString))
    {
      str = "null";
      if (!Util.isNullOrNil(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.k.b.anY(paramString);
      paramString = ad.cKX().rzU.CZ(l);
      if (paramString != null) {
        break label182;
      }
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23303);
      return false;
      str = paramString;
      break;
    }
    label182:
    if (paramString.dHO != 2)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ad.cKX();
    boolean bool = h.a(l, paramArrayOfByte, new t.a()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(23273);
        Object localObject1 = paramAnonymousString;
        if (paramAnonymousString == null) {
          localObject1 = "null";
        }
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localObject1 });
        localObject1 = e.this;
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.Dj(paramAnonymousLong);
        boolean bool;
        if (paramAnonymousInt2 == 0) {
          bool = true;
        }
        LinkedList localLinkedList;
        for (;;)
        {
          Log.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (bool) {
            break label250;
          }
          synchronized (((e)localObject1).ryr)
          {
            localLinkedList = new LinkedList(((e)localObject1).ryr);
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
        localObject1 = ((e)localObject1).rys.values().iterator();
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
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.ryr)
    {
      localLinkedList = new LinkedList(this.ryr);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).p(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.rys.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).p(paramString1, paramString2, paramBoolean);
    }
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new fg();
    ((fg)???).dID.dIx = paramString1;
    ((fg)???).dID.mac = paramString2;
    ((fg)???).dID.brW = paramBoolean;
    EventCenter.instance.asyncPublish((IEvent)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  final boolean o(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
  {
    AppMethodBeat.i(23295);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
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
        u.cLy().a((ae)localObject);
      }
      if (this.rzi) {
        this.mHandler.removeCallbacks(this.rzj);
      }
      this.rzj = new c(paramList);
      this.mHandler.postDelayed(this.rzj, 300000L);
      this.rzi = true;
      paramInt = 2;
      continue;
      if (this.rzi)
      {
        this.mHandler.removeCallbacks(this.rzj);
        this.rzi = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final class a
    implements e.b
  {
    private String dfJ;
    private String mURL;
    private String rzn;
    private String rzo;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.rzn = paramString1;
      this.dfJ = paramString2;
      this.mURL = paramString3;
      this.rzo = paramString4;
      Log.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.dfJ == null) || (!this.dfJ.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.dfJ, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.cKW();
          if (!e.b(this.dfJ, this.rzn, paramArrayOfByte))
          {
            Log.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
            AppMethodBeat.o(23281);
            return;
          }
          AppMethodBeat.o(23281);
          return;
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
        }
      }
      AppMethodBeat.o(23281);
    }
    
    public final void c(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.dfJ == null) || (!this.dfJ.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.dfJ, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.d(this.rzn, this.mURL, -1, this.rzo);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.d(this.rzn, this.mURL, 2, this.rzo);
        paramString = new com.tencent.mm.plugin.d.a.b.a.f();
        paramString.pie = com.tencent.mm.plugin.d.a.b.a.f.pjh;
        paramString.pif = 2;
        ad.cKW().n(this.dfJ, com.tencent.mm.plugin.exdevice.k.b.de(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.d(this.rzn, this.mURL, 1, this.rzo);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.d(this.rzn, this.mURL, 4, this.rzo);
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.d(this.rzn, this.mURL, 0, this.rzo);
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void p(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.dfJ == null) || (!this.dfJ.equals(paramString2)))
      {
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.dfJ, paramString2, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23280);
        return;
      }
      AppMethodBeat.o(23280);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void c(String paramString, int paramInt, long paramLong);
    
    public abstract void p(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    List<com.tencent.mm.plugin.exdevice.i.b> iHg;
    
    public c()
    {
      Object localObject;
      this.iHg = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23283);
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
      if ((this.iHg != null) && (this.iHg.size() > 0))
      {
        Iterator localIterator = this.iHg.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, 1);
          u.cLy().a((ae)localObject);
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