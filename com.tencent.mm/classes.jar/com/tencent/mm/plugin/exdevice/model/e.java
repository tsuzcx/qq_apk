package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.f.a.dz;
import com.tencent.mm.f.a.eb;
import com.tencent.mm.f.a.ed;
import com.tencent.mm.f.a.eg;
import com.tencent.mm.f.a.ei;
import com.tencent.mm.f.a.ei.a;
import com.tencent.mm.f.a.ej;
import com.tencent.mm.f.a.ej.a;
import com.tencent.mm.f.a.ek;
import com.tencent.mm.f.a.el;
import com.tencent.mm.f.a.el.a;
import com.tencent.mm.f.a.ew;
import com.tencent.mm.f.a.ex;
import com.tencent.mm.f.a.ey;
import com.tencent.mm.f.a.ez;
import com.tencent.mm.f.a.ez.a;
import com.tencent.mm.f.a.fa;
import com.tencent.mm.f.a.fb;
import com.tencent.mm.f.a.fb.a;
import com.tencent.mm.f.a.fd;
import com.tencent.mm.f.a.fd.a;
import com.tencent.mm.f.a.ff;
import com.tencent.mm.f.a.fi;
import com.tencent.mm.f.a.fj;
import com.tencent.mm.f.a.fk;
import com.tencent.mm.f.a.fl;
import com.tencent.mm.f.a.fn;
import com.tencent.mm.f.a.fo;
import com.tencent.mm.f.a.fp;
import com.tencent.mm.f.a.fq;
import com.tencent.mm.f.a.fs;
import com.tencent.mm.f.a.ft;
import com.tencent.mm.f.a.kv;
import com.tencent.mm.f.a.kv.b;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.f.a.mu;
import com.tencent.mm.f.a.po;
import com.tencent.mm.f.a.yg;
import com.tencent.mm.f.a.yh;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.ds;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.j.j;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.pluginsdk.o.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.ILifecycleEventObserver;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Calendar;
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
  private final long deq;
  MMHandler mHandler;
  public IListener rXi;
  List<b> vdX;
  Map<String, b> vdY;
  public IListener vdZ;
  public IListener veA;
  public IListener veB;
  public IListener veC;
  public IListener veD;
  public IListener veE;
  public IListener veF;
  public IListener veG;
  public IListener veH;
  public IListener veI;
  public IListener veJ;
  public IListener veK;
  public IListener veL;
  public IListener veM;
  ExdeviceWCLanSDKUtil veN;
  g veO;
  private boolean veP;
  private c veQ;
  public IListener vea;
  public IListener veb;
  public IListener vec;
  public IListener ved;
  public IListener vee;
  public IListener vef;
  public ILifecycleEventObserver<Object> veg;
  public IListener veh;
  public IListener vei;
  public IListener vej;
  public IListener vek;
  public IListener vel;
  public IListener vem;
  public IListener ven;
  public IListener veo;
  public IListener vep;
  public IListener veq;
  public IListener ves;
  public IListener vet;
  public IListener veu;
  public IListener vev;
  public IListener vew;
  public IListener vex;
  public IListener vey;
  public IListener vez;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.vdZ = new IListener() {};
    this.vea = new IListener() {};
    this.veb = new IListener() {};
    this.vec = new e.34(this);
    this.ved = new IListener() {};
    this.vee = new IListener() {};
    this.vef = new IListener() {};
    this.veg = new ILifecycleEventObserver()
    {
      public final void onEventHappen(Object paramAnonymousObject)
      {
        AppMethodBeat.i(277024);
        paramAnonymousObject = e.this;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
        int i = bh.aGY().bih();
        if ((i != 4) && (i != 6))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(277024);
          return;
        }
        String str = com.tencent.mm.n.h.axc().getValue("DeviceAutoSyncClose");
        Log.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[] { str });
        if ((!Util.isNullOrNil(str)) && (str.equalsIgnoreCase("1"))) {
          Log.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
        }
        for (i = 0; i == 0; i = 1)
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
          AppMethodBeat.o(277024);
          return;
        }
        if (!com.tencent.mm.plugin.f.a.e.a.eP(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
          AppMethodBeat.o(277024);
          return;
        }
        if (!com.tencent.mm.plugin.f.a.e.a.cyk())
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
          AppMethodBeat.o(277024);
          return;
        }
        ae.cZF();
        if (d.cZd() == 1)
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
          AppMethodBeat.o(277024);
          return;
        }
        if (i.vfP.nb(false))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
          i.vfP.a(null, new e.38(paramAnonymousObject));
          AppMethodBeat.o(277024);
          return;
        }
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
        e.cZg();
        AppMethodBeat.o(277024);
      }
    };
    this.veh = new IListener() {};
    this.vei = new e.2(this);
    this.vej = new e.3(this);
    this.vek = new e.4(this);
    this.vel = new IListener() {};
    this.vem = new e.6(this);
    this.ven = new e.7(this);
    this.veo = new e.8(this);
    this.vep = new e.9(this);
    this.veq = new e.10(this);
    this.ves = new IListener() {};
    this.vet = new IListener() {};
    this.veu = new IListener() {};
    this.vev = new IListener() {};
    this.vew = new IListener() {};
    this.vex = new e.17(this);
    this.vey = new IListener() {};
    this.vez = new e.19(this);
    this.veA = new e.20(this);
    this.rXi = new IListener() {};
    this.veB = new e.22(this);
    this.veC = new e.24(this);
    this.veD = new IListener() {};
    this.veE = new IListener() {};
    this.veF = new IListener() {};
    this.veG = new IListener() {};
    this.veH = new IListener() {};
    this.veI = new IListener() {};
    this.veJ = new e.31(this);
    this.veK = new e.32(this);
    this.veL = new e.33(this);
    this.veM = new e.35(this);
    this.deq = 300000L;
    this.veP = false;
    this.vdX = new LinkedList();
    this.vdY = new HashMap();
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
    paramString = (b)this.vdY.put(paramString, paramb);
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
    f.a locala = u.dak().Jm(paramb.field_mac);
    if (locala == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.fAF == 2)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.dal().a((af)localObject);
    }
    Object localObject = ae.cZF();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).Kd(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ae.cZF();
      long l = paramb.field_mac;
      localObject = (MTimerHandler)((d)localObject).vdG.remove(Long.valueOf(l));
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.dak().Jq(locala.vjn)) || ((2 != locala.fAF) && (locala.fAF != 0)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.fAF), str });
        if (u.dal().vdz != null) {
          u.dal().vdz.Js(locala.vjn);
        }
      }
      if (f.b(paramb))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        avs(com.tencent.mm.plugin.exdevice.k.b.Jx(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.fAF) && (o.e.QSd != null) && (o.e.QSd.gOF()))
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ew localew = new ew();
    localew.fAO.fzB = paramString;
    localew.fAO.fzJ = paramBoolean;
    EventCenter.instance.asyncPublish(localew, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  static boolean avr(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.ao.g.gu(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.dc(false);
    if ((paramString == null) || (paramString.Zr() == null) || (!paramString.Zr().ZA()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean avs(String paramString)
  {
    AppMethodBeat.i(23301);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!cZi())
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
    ae.cZK();
    h.IW(com.tencent.mm.plugin.exdevice.k.b.avW(paramString));
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
      long l = com.tencent.mm.plugin.exdevice.k.b.avW(paramString1);
      localObject = ae.cZx().Jw(l);
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
    paramString1 = com.tencent.mm.plugin.f.a.b.a.a.bk(paramArrayOfByte);
    if (1L != paramString1.sjI)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.sjI) });
      AppMethodBeat.o(23304);
      return false;
    }
    paramString1 = (com.tencent.mm.plugin.f.a.b.a.f)paramString1;
    paramString2 = Calendar.getInstance();
    paramString2.set(11, 0);
    paramString2.set(12, 0);
    paramString2.set(13, 0);
    i = (int)(paramString2.getTimeInMillis() / 1000L);
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.sls, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    ex localex = new ex();
    localex.fAP.fzB = paramString1;
    localex.fAP.fzM = paramString2;
    localex.fAP.data = paramArrayOfByte;
    EventCenter.instance.asyncPublish(localex, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(IEvent paramIEvent)
  {
    AppMethodBeat.i(23288);
    paramIEvent = (ei)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.fzZ.fzM, paramIEvent.fzZ.context });
    LinkedList localLinkedList = ae.cZx().avK(paramIEvent.fzZ.fzM);
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
          if (!u.dak().Jk(localb.field_mac)) {
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
        paramIEvent.fAa.fAb = localJSONArray;
        paramIEvent.fAa.fzO = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  static boolean cZg()
  {
    AppMethodBeat.i(23296);
    Object localObject = ae.cZx().dap();
    if (((LinkedList)localObject).isEmpty())
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ae.cZF().Kd(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(localb.field_brandName);
      if ((localas == null) || (!com.tencent.mm.contact.d.rk(localas.field_type)))
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
        ae.cZF().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean cZh()
  {
    AppMethodBeat.i(23297);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ae.cZF();
    d.mZ(false);
    ae.cZF().cZe();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean cZi()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.f.a.e.a.eP(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.f.a.e.a.cyk())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean cZj()
  {
    AppMethodBeat.i(23300);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!cZi())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ae.cZK().cZm();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean cZk()
  {
    AppMethodBeat.i(23313);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = MMApplicationContext.getContext();
    try
    {
      ae.cZF().cZe();
      com.tencent.mm.by.c.n(new Intent(localContext, ExDeviceService.class), "exdevice");
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
    po localpo = new po();
    localpo.fOk.op = 2;
    localpo.fOk.fKT = paramString1;
    localpo.fOk.fAF = paramInt;
    localpo.fOk.url = paramString2;
    localpo.fOk.fzB = paramString3;
    EventCenter.instance.asyncPublish(localpo, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean d(IEvent paramIEvent)
  {
    AppMethodBeat.i(23289);
    paramIEvent = (fd)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramIEvent.fAY.fzM, paramIEvent.fAY.fzB });
    if (Util.isNullOrNil(paramIEvent.fAY.data))
    {
      paramIEvent.fAZ.fzO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ae.cZx().avI(paramIEvent.fAY.fzB);
    if (localObject == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramIEvent.fAZ.fzO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.dak().Jk(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramIEvent.fAZ.fzO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.dak().Jq(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramIEvent.fAZ.fzO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (ab.cZu().vfA) {
      ab.cZu().Kf(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramIEvent.fAY.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.dal().a((af)localObject);
    paramIEvent.fAZ.fzO = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static void dC(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    po localpo = new po();
    localpo.fOk.op = 1;
    localpo.fOk.fKT = paramString;
    localpo.fOk.bnA = paramInt;
    EventCenter.instance.asyncPublish(localpo, Looper.getMainLooper());
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
        paramList = ((ds)localObject).idZ;
        localObject = ((ds)localObject).iea;
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
    Object localObject = new kv();
    ((kv)localObject).fIq.fAg = paramString;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = ((kv)localObject).fIr.fIs;
    int i = ((TimeLineObject)localObject).ContentObj.Sqq;
    boolean bool;
    if (i == 1)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).idZ;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).idZ;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).idZ;
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
    if (this.vdX.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.vdX.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aQ(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    Log.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.ao.g.gu(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).dc(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).Zr();
      if ((localObject2 != null) && (((c.b.b)localObject2).ZA())) {}
    }
    else
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ae.cZx().avK(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).eZO == 1)
    {
      localObject2 = ae.cZx().dap();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((ds)localObject3).idY) });
          if (0L != (((ds)localObject3).idY & 1L)) {
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
          if (!com.tencent.mm.plugin.f.a.e.a.cyi())
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
        localObject3 = ae.cZF();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).vdH.containsKey(Long.valueOf(l)))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (MTimerHandler)((d)localObject3).vdH.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((MTimerHandler)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.dak().Jk(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.dak().Jq(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              d(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1413;
              }
              i += 1;
              if (!com.tencent.mm.plugin.f.a.e.a.eP(MMApplicationContext.getContext()))
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
        if (((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vty, 0) == 1) || (com.tencent.mm.protocal.d.RAG)) && (!com.tencent.mm.plugin.f.a.e.a.cyk()))
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close!!!");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.fh(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          avt(com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ae.cZF().Kd(1);
        ae.cZF().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ae.cZF().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          avt(com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ae.cZF().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ae.cZF().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          avs(com.tencent.mm.plugin.exdevice.k.b.Jx(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ae.cZF();
        d.IW(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.f.a.e.a.cyk())
        {
          Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          dC(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.f.a.e.a.eP(MMApplicationContext.getContext())))
        {
          dC(paramString, 1);
          continue;
          dC(paramString, -1);
        }
      }
      label1413:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean avt(String paramString)
  {
    AppMethodBeat.i(23302);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!cZi())
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
    ae.cZK().a(com.tencent.mm.plugin.exdevice.k.b.avW(paramString), new h.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23272);
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = e.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.Jx(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((e)localObject1).vdX)
        {
          localLinkedList = new LinkedList(((e)localObject1).vdX);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((e.b)((Iterator)???).next()).d(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).d(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new fl();
        ((fl)localObject1).fBs.mac = str2;
        ((fl)localObject1).fBs.fAF = paramAnonymousInt2;
        ((fl)localObject1).fBs.fBp = paramAnonymousLong2;
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
    if (this.vdX.remove(paramb))
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
    paramIEvent = (ej)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.fAc.fzM, paramIEvent.fAc.context });
    if (!avr(paramIEvent.fAc.fzM))
    {
      paramIEvent.fAd.fAb = null;
      paramIEvent.fAd.fzO = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ae.cZx().avK(paramIEvent.fAc.fzM);
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
          if (!this.veN.avv(localb.field_deviceID)) {
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
        paramIEvent.fAd.fAb = localJSONArray;
        paramIEvent.fAd.fzO = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(IEvent paramIEvent)
  {
    AppMethodBeat.i(23291);
    paramIEvent = (el)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramIEvent.fAk.fzM, paramIEvent.fAk.fzB, Integer.valueOf(paramIEvent.fAk.type) });
    Object localObject2 = new bvr();
    ((bvr)localObject2).Tfy = paramIEvent.fAk.type;
    ((bvr)localObject2).Tfz = 0;
    ((bvr)localObject2).RPX = new ciu();
    ((bvr)localObject2).RPX.rVF = paramIEvent.fAk.fzB;
    ((bvr)localObject2).RPX.RMK = paramIEvent.fAk.fzM;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramIEvent);
    localObject1 = new aa((LinkedList)localObject1, paramIEvent.fAk.fzM, paramIEvent.fAk.fAm);
    bh.aGY().a(543, (com.tencent.mm.an.i)localObject2);
    if (!bh.aGY().a((q)localObject1, 0))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      bh.aGY().b(543, (com.tencent.mm.an.i)localObject2);
      paramIEvent.fAl.fAn = true;
      paramIEvent.fAl.fAo = null;
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
    paramIEvent = (fb)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramIEvent.fAT.fzM, Boolean.valueOf(paramIEvent.fAT.fzN), Integer.valueOf(paramIEvent.fAT.fAV) });
    int j = paramIEvent.fAT.fAV;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.f.a.e.a.eP(MMApplicationContext.getContext())) {
          break label197;
        }
        Log.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    ab localab;
    Object localObject2;
    if (paramIEvent.fAT.fzN)
    {
      localab = ab.cZu();
      ??? = paramIEvent.fAT.fzM;
      localObject2 = new ab.a()
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
            ey localey = new ey();
            localey.fAQ.fAI = paramAnonymousArrayOfByte;
            localey.fAQ.fzB = paramAnonymousString;
            localey.fAQ.bby = paramAnonymousBoolean;
            EventCenter.instance.asyncPublish(localey, Looper.getMainLooper());
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
      paramIEvent.fAU.fzO = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramIEvent.fAU.fzO = false;
      AppMethodBeat.o(23292);
      return false;
      localab.veU = ((String)???);
      localab.vgm = ((ab.a)localObject2);
      localab.vgn.clear();
      ??? = localab.vgo.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (q)((Iterator)???).next();
        if (localObject2 != null) {
          bh.aGY().a((q)localObject2);
        }
      }
      localab.vgo.clear();
      synchronized (ab.fnq)
      {
        ab.vgp.clear();
        if (!localab.vfA)
        {
          localab.vfA = true;
          bh.aGY().a(542, localab);
          ae.cZF().a(i, localab);
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localab.ndv.startTimer(12000L);
        }
      }
      ab.cZu().Kf(i);
    }
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
        u.dal().a((af)localObject);
      }
      if (this.veP) {
        this.mHandler.removeCallbacks(this.veQ);
      }
      this.veQ = new c(paramList);
      this.mHandler.postDelayed(this.veQ, 300000L);
      this.veP = true;
      paramInt = 2;
      continue;
      if (this.veP)
      {
        this.mHandler.removeCallbacks(this.veQ);
        this.veP = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.vdX)
    {
      localLinkedList = new LinkedList(this.vdX);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).q(paramString1, paramString2, paramBoolean);
      }
    }
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).q(paramString1, paramString2, paramBoolean);
    }
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new fn();
    ((fn)???).fBu.fBo = paramString1;
    ((fn)???).fBu.mac = paramString2;
    ((fn)???).fBu.bby = paramBoolean;
    EventCenter.instance.asyncPublish((IEvent)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  public final boolean q(String paramString, byte[] paramArrayOfByte)
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
      l = com.tencent.mm.plugin.exdevice.k.b.avW(paramString);
      paramString = ae.cZK().vfB.Jn(l);
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
    if (paramString.fAF != 2)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ae.cZK();
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
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.Jx(paramAnonymousLong);
        boolean bool;
        if (paramAnonymousInt2 == 0) {
          bool = true;
        }
        for (;;)
        {
          Log.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (bool) {
            break;
          }
          LinkedList localLinkedList;
          synchronized (((e)localObject1).vdX)
          {
            localLinkedList = new LinkedList(((e)localObject1).vdX);
            ??? = localLinkedList.iterator();
            while (((Iterator)???).hasNext())
            {
              ((e.b)((Iterator)???).next()).b(paramAnonymousString, null, false);
              continue;
              bool = false;
            }
          }
        }
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).b(paramAnonymousString, null, false);
        }
        AppMethodBeat.o(23273);
      }
    });
    AppMethodBeat.o(23303);
    return bool;
  }
  
  public final class a
    implements e.b
  {
    private String mURL;
    private String shW;
    private String veU;
    private String veV;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.veU = paramString1;
      this.shW = paramString2;
      this.mURL = paramString3;
      this.veV = paramString4;
      Log.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.shW == null) || (!this.shW.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.shW, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ae.cZJ();
          if (!e.b(this.shW, this.veU, paramArrayOfByte))
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
    
    public final void d(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.shW == null) || (!this.shW.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.shW, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.d(this.veU, this.mURL, -1, this.veV);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.d(this.veU, this.mURL, 2, this.veV);
        paramString = new com.tencent.mm.plugin.f.a.b.a.f();
        paramString.sko = com.tencent.mm.plugin.f.a.b.a.f.slq;
        paramString.skp = 2;
        ae.cZJ().q(this.shW, com.tencent.mm.plugin.exdevice.k.b.db(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.d(this.veU, this.mURL, 1, this.veV);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.d(this.veU, this.mURL, 4, this.veV);
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.d(this.veU, this.mURL, 0, this.veV);
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void q(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.shW == null) || (!this.shW.equals(paramString2)))
      {
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.shW, paramString2, Boolean.valueOf(paramBoolean) });
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
    
    public abstract void q(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    List<com.tencent.mm.plugin.exdevice.i.b> lxi;
    
    public c()
    {
      Object localObject;
      this.lxi = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23283);
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
      if ((this.lxi != null) && (this.lxi.size() > 0))
      {
        Iterator localIterator = this.lxi.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, 1);
          u.dal().a((af)localObject);
        }
        e.this.mHandler.postDelayed(this, 300000L);
      }
      AppMethodBeat.o(23283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */