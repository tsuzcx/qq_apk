package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.autogen.a.et;
import com.tencent.mm.autogen.a.et.a;
import com.tencent.mm.autogen.a.eu;
import com.tencent.mm.autogen.a.eu.a;
import com.tencent.mm.autogen.a.ew;
import com.tencent.mm.autogen.a.ew.a;
import com.tencent.mm.autogen.a.fh;
import com.tencent.mm.autogen.a.fi;
import com.tencent.mm.autogen.a.fm;
import com.tencent.mm.autogen.a.fm.a;
import com.tencent.mm.autogen.a.fo;
import com.tencent.mm.autogen.a.fo.a;
import com.tencent.mm.autogen.a.fw;
import com.tencent.mm.autogen.a.fy;
import com.tencent.mm.autogen.a.lz;
import com.tencent.mm.autogen.a.lz.b;
import com.tencent.mm.autogen.a.rb;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.ee;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.o.c.a;
import com.tencent.mm.pluginsdk.o.d;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private final long fdb;
  MMHandler mHandler;
  public IListener viz;
  List<b> ypU;
  Map<String, b> ypV;
  public IListener ypW;
  public IListener ypX;
  public IListener ypY;
  public IListener ypZ;
  public IListener yqA;
  public IListener yqB;
  public IListener yqC;
  public IListener yqD;
  public IListener yqE;
  public IListener yqF;
  public IListener yqG;
  public IListener yqH;
  public IListener yqI;
  public IListener yqJ;
  ExdeviceWCLanSDKUtil yqK;
  i yqL;
  private boolean yqM;
  private g.c yqN;
  public IListener yqa;
  public IListener yqb;
  public IListener yqc;
  public IMvvmObserver<Object> yqd;
  public IListener yqe;
  public IListener yqf;
  public IListener yqg;
  public IListener yqh;
  public IListener yqi;
  public IListener yqj;
  public IListener yqk;
  public IListener yql;
  public IListener yqm;
  public IListener yqn;
  public IListener yqo;
  public IListener yqp;
  public IListener yqq;
  public IListener yqr;
  public IListener yqs;
  public IListener yqt;
  public IListener yqu;
  public IListener yqv;
  public IListener yqw;
  public IListener yqx;
  public IListener yqy;
  public IListener yqz;
  
  public g()
  {
    AppMethodBeat.i(23284);
    this.ypW = new ExdeviceEventManager.1(this, com.tencent.mm.app.f.hfK);
    this.ypX = new ExdeviceEventManager.2(this, com.tencent.mm.app.f.hfK);
    this.ypY = new ExdeviceEventManager.3(this, com.tencent.mm.app.f.hfK);
    this.ypZ = new ExdeviceEventManager.4(this, com.tencent.mm.app.f.hfK);
    this.yqa = new ExdeviceEventManager.5(this, com.tencent.mm.app.f.hfK);
    this.yqb = new ExdeviceEventManager.6(this, com.tencent.mm.app.f.hfK);
    this.yqc = new ExdeviceEventManager.7(this, com.tencent.mm.app.f.hfK);
    this.yqd = new IMvvmObserver()
    {
      public final void onChanged(Object paramAnonymousObject)
      {
        AppMethodBeat.i(274668);
        paramAnonymousObject = g.this;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
        int i = bh.aZW().bFQ();
        if ((i != 4) && (i != 6))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(274668);
          return;
        }
        String str = com.tencent.mm.k.i.aRC().getValue("DeviceAutoSyncClose");
        Log.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", new Object[] { str });
        if ((!Util.isNullOrNil(str)) && (str.equalsIgnoreCase("1"))) {
          Log.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
        }
        for (i = 0; i == 0; i = 1)
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
          AppMethodBeat.o(274668);
          return;
        }
        if (k.yrL.oB(false))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound iot harddevices");
          k.yrL.dFE();
        }
        if (!com.tencent.mm.plugin.g.a.e.a.fL(MMApplicationContext.getContext()))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
          AppMethodBeat.o(274668);
          return;
        }
        if (!com.tencent.mm.plugin.g.a.e.a.dbb())
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
          AppMethodBeat.o(274668);
          return;
        }
        ah.dFY();
        if (f.dFu() == 1)
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
          AppMethodBeat.o(274668);
          return;
        }
        if (k.yrL.oA(false))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
          k.yrL.a(null, new g.3(paramAnonymousObject));
          AppMethodBeat.o(274668);
          return;
        }
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
        g.dFx();
        AppMethodBeat.o(274668);
      }
    };
    this.yqe = new ExdeviceEventManager.9(this, com.tencent.mm.app.f.hfK);
    this.yqf = new ExdeviceEventManager.10(this, com.tencent.mm.app.f.hfK);
    this.yqg = new ExdeviceEventManager.11(this, com.tencent.mm.app.f.hfK);
    this.yqh = new ExdeviceEventManager.12(this, com.tencent.mm.app.f.hfK);
    this.yqi = new ExdeviceEventManager.13(this, com.tencent.mm.app.f.hfK);
    this.yqj = new ExdeviceEventManager.14(this, com.tencent.mm.app.f.hfK);
    this.yqk = new ExdeviceEventManager.15(this, com.tencent.mm.app.f.hfK);
    this.yql = new ExdeviceEventManager.16(this, com.tencent.mm.app.f.hfK);
    this.yqm = new ExdeviceEventManager.17(this, com.tencent.mm.app.f.hfK);
    this.yqn = new ExdeviceEventManager.18(this, com.tencent.mm.app.f.hfK);
    this.yqo = new ExdeviceEventManager.19(this, com.tencent.mm.app.f.hfK);
    this.yqp = new ExdeviceEventManager.20(this, com.tencent.mm.app.f.hfK);
    this.yqq = new ExdeviceEventManager.21(this, com.tencent.mm.app.f.hfK);
    this.yqr = new ExdeviceEventManager.22(this, com.tencent.mm.app.f.hfK);
    this.yqs = new ExdeviceEventManager.23(this, com.tencent.mm.app.f.hfK);
    this.yqt = new ExdeviceEventManager.24(this, com.tencent.mm.app.f.hfK);
    this.yqu = new ExdeviceEventManager.25(this, com.tencent.mm.app.f.hfK);
    this.yqv = new ExdeviceEventManager.26(this, com.tencent.mm.app.f.hfK);
    this.yqw = new ExdeviceEventManager.27(this, com.tencent.mm.app.f.hfK);
    this.yqx = new ExdeviceEventManager.28(this, com.tencent.mm.app.f.hfK);
    this.viz = new ExdeviceEventManager.29(this, com.tencent.mm.app.f.hfK);
    this.yqy = new ExdeviceEventManager.30(this, com.tencent.mm.app.f.hfK);
    this.yqz = new ExdeviceEventManager.31(this, com.tencent.mm.app.f.hfK);
    this.yqA = new ExdeviceEventManager.32(this, com.tencent.mm.app.f.hfK);
    this.yqB = new ExdeviceEventManager.33(this, com.tencent.mm.app.f.hfK);
    this.yqC = new ExdeviceEventManager.34(this, com.tencent.mm.app.f.hfK);
    this.yqD = new ExdeviceEventManager.35(this, com.tencent.mm.app.f.hfK);
    this.yqE = new ExdeviceEventManager.36(this, com.tencent.mm.app.f.hfK);
    this.yqF = new ExdeviceEventManager.37(this, com.tencent.mm.app.f.hfK);
    this.yqG = new ExdeviceEventManager.38(this, com.tencent.mm.app.f.hfK);
    this.yqH = new ExdeviceEventManager.39(this, com.tencent.mm.app.f.hfK);
    this.yqI = new ExdeviceEventManager.40(this, com.tencent.mm.app.f.hfK);
    this.yqJ = new ExdeviceEventManager.41(this, com.tencent.mm.app.f.hfK);
    this.fdb = 300000L;
    this.yqM = false;
    this.ypU = new LinkedList();
    this.ypV = new HashMap();
    this.mHandler = new MMHandler("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static boolean B(List<com.tencent.mm.plugin.exdevice.i.f> paramList, int paramInt)
  {
    AppMethodBeat.i(274619);
    Object localObject;
    do
    {
      paramList = paramList.iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          localObject = com.tencent.mm.plugin.exdevice.k.b.apX(((com.tencent.mm.plugin.exdevice.i.f)paramList.next()).field_supportMsgTypeList);
        } while (localObject == null);
        localObject = ((LinkedList)localObject).iterator();
      }
    } while (((Integer)((Iterator)localObject).next()).intValue() != paramInt);
    AppMethodBeat.o(274619);
    return true;
    AppMethodBeat.o(274619);
    return false;
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (b)this.ypV.put(paramString, paramb);
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
    f.a locala = u.dGD().lC(paramb.field_mac);
    if (locala == null)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.hFs == 2)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new com.tencent.mm.plugin.exdevice.j.j(paramInt1, paramInt2, paramb.field_mac);
      u.dGE().a((ai)localObject);
    }
    Object localObject = ah.dFY();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((f)localObject).Lb(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ah.dFY();
      long l = paramb.field_mac;
      localObject = (MTimerHandler)((f)localObject).ypD.remove(Long.valueOf(l));
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.dGD().lG(locala.yvl)) || ((2 != locala.hFs) && (locala.hFs != 0)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.hFs), str });
        if (u.dGE().yps != null) {
          u.dGE().yps.lI(locala.yvl);
        }
      }
      if (h.c(paramb))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        apt(com.tencent.mm.plugin.exdevice.k.b.lO(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.hFs) && (o.d.XNU != null) && (o.d.XNU.inT()))
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  static boolean aps(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.an.g.hU(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.dO(false);
    if ((paramString == null) || (paramString.aBj() == null) || (!paramString.aBj().aBs()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean apt(String paramString)
  {
    AppMethodBeat.i(23301);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!dFz())
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
    ah.dGd();
    j.lt(com.tencent.mm.plugin.exdevice.k.b.apW(paramString));
    AppMethodBeat.o(23301);
    return true;
  }
  
  static int b(com.tencent.mm.plugin.exdevice.i.b paramb)
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
  
  public static void bf(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    fh localfh = new fh();
    localfh.hFB.hEl = paramString;
    localfh.hFB.hEv = paramBoolean;
    localfh.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  static boolean c(IEvent paramIEvent)
  {
    AppMethodBeat.i(23288);
    paramIEvent = (et)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.hEL.hEy, paramIEvent.hEL.context });
    LinkedList localLinkedList = ah.dFO().apK(paramIEvent.hEL.hEy);
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
          if (!u.dGD().lA(localb.field_mac)) {
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
        paramIEvent.hEM.hEN = localJSONArray;
        paramIEvent.hEM.hEn = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  public static boolean c(String paramString1, String paramString2, byte[] paramArrayOfByte)
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
      long l = com.tencent.mm.plugin.exdevice.k.b.apW(paramString1);
      localObject = ah.dFO().lM(l);
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
    paramString1 = com.tencent.mm.plugin.g.a.b.a.a.bk(paramArrayOfByte);
    if (1L != paramString1.vvH)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.vvH) });
      AppMethodBeat.o(23304);
      return false;
    }
    paramString1 = (com.tencent.mm.plugin.g.a.b.a.f)paramString1;
    paramString2 = Calendar.getInstance();
    paramString2.set(11, 0);
    paramString2.set(12, 0);
    paramString2.set(13, 0);
    i = (int)(paramString2.getTimeInMillis() / 1000L);
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.vxr, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    rb localrb = new rb();
    localrb.hUc.op = 2;
    localrb.hUc.hQA = paramString1;
    localrb.hUc.hFs = paramInt;
    localrb.hUc.url = paramString2;
    localrb.hUc.hEl = paramString3;
    localrb.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  public static void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    fi localfi = new fi();
    localfi.hFC.hEl = paramString1;
    localfi.hFC.hEy = paramString2;
    localfi.hFC.data = paramArrayOfByte;
    localfi.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean d(IEvent paramIEvent)
  {
    AppMethodBeat.i(23289);
    paramIEvent = (fo)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramIEvent.hFL.hEy, paramIEvent.hFL.hEl });
    if (Util.isNullOrNil(paramIEvent.hFL.data))
    {
      paramIEvent.hFM.hEn = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ah.dFO().apI(paramIEvent.hFL.hEl);
    if (localObject == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramIEvent.hFM.hEn = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.dGD().lA(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramIEvent.hFM.hEn = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.dGD().lG(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramIEvent.hFM.hEn = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (af.dFL().yrw) {
      af.dFL().Le(b((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramIEvent.hFL.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.dGE().a((ai)localObject);
    paramIEvent.hFM.hEn = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static boolean dFA()
  {
    AppMethodBeat.i(23300);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!dFz())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ah.dGd().dFD();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean dFB()
  {
    AppMethodBeat.i(23313);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = MMApplicationContext.getContext();
    try
    {
      ah.dFY().dFv();
      com.tencent.mm.br.c.p(new Intent(localContext, ExDeviceService.class), "exdevice");
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
  
  static boolean dFx()
  {
    AppMethodBeat.i(23296);
    Object localObject = ah.dFO().dGI();
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ah.dFY().Lb(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(localb.field_brandName);
      if ((localau == null) || (!com.tencent.mm.contact.d.rs(localau.field_type)))
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
        ah.dFY().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean dFy()
  {
    AppMethodBeat.i(23297);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ah.dFY();
    f.oy(false);
    ah.dFY().dFv();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean dFz()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.g.a.e.a.fL(MMApplicationContext.getContext()))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.g.a.e.a.dbb())
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static void ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    rb localrb = new rb();
    localrb.hUc.op = 1;
    localrb.hUc.hQA = paramString;
    localrb.hUc.reason = paramInt;
    localrb.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  static boolean u(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
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
        paramList = ((ee)localObject).kDj;
        localObject = ((ee)localObject).kDk;
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
  
  static boolean v(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23287);
    if ((paramString == null) || (paramList == null))
    {
      AppMethodBeat.o(23287);
      return false;
    }
    Object localObject = new lz();
    ((lz)localObject).hNQ.hES = paramString;
    ((lz)localObject).publish();
    localObject = ((lz)localObject).hNR.hNS;
    int i = ((TimeLineObject)localObject).ContentObj.Zpq;
    boolean bool;
    if (i == 1)
    {
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).kDj;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).kDj;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).kDj;
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
        bool = u(((TimeLineObject)localObject).ContentObj.Url, paramList);
      }
      else if (i == 5)
      {
        bool = u(((TimeLineObject)localObject).ContentObj.Url, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  final boolean C(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
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
        localObject = new com.tencent.mm.plugin.exdevice.j.k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, paramInt);
        u.dGE().a((ai)localObject);
      }
      if (this.yqM) {
        this.mHandler.removeCallbacks(this.yqN);
      }
      this.yqN = new g.c(this, paramList);
      this.mHandler.postDelayed(this.yqN, 300000L);
      this.yqM = true;
      paramInt = 2;
      continue;
      if (this.yqM)
      {
        this.mHandler.removeCallbacks(this.yqN);
        this.yqM = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(23310);
    if (this.ypU.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.ypU.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  public final boolean apu(String paramString)
  {
    AppMethodBeat.i(23302);
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!dFz())
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
    ah.dGd().a(com.tencent.mm.plugin.exdevice.k.b.apW(paramString), new j.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(274672);
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = g.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.lO(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((g)localObject1).ypU)
        {
          localLinkedList = new LinkedList(((g)localObject1).ypU);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((g.b)((Iterator)???).next()).d(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        while (((Iterator)localObject1).hasNext()) {
          ((g.b)((Iterator)localObject1).next()).d(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new fw();
        ((fw)localObject1).hGh.mac = str2;
        ((fw)localObject1).hGh.hFs = paramAnonymousInt2;
        ((fw)localObject1).hGh.hGe = paramAnonymousLong2;
        ((fw)localObject1).asyncPublish(Looper.getMainLooper());
        AppMethodBeat.o(274672);
      }
    });
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(23311);
    if (this.ypU.remove(paramb))
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
    paramIEvent = (eu)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramIEvent.hEO.hEy, paramIEvent.hEO.context });
    if (!aps(paramIEvent.hEO.hEy))
    {
      paramIEvent.hEP.hEN = null;
      paramIEvent.hEP.hEn = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ah.dFO().apK(paramIEvent.hEO.hEy);
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
          if (!this.yqK.apv(localb.field_deviceID)) {
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
        paramIEvent.hEP.hEN = localJSONArray;
        paramIEvent.hEP.hEn = true;
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean bj(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    Log.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.an.g.hU(paramString);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).dO(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).aBj();
      if ((localObject2 != null) && (((c.b.b)localObject2).aBs())) {}
    }
    else
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ah.dFO().apK(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).hdo == 1)
    {
      localObject2 = ah.dFO().dGI();
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((ee)localObject3).kDi) });
          if (0L != (((ee)localObject3).kDi & 1L)) {
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
          if (!com.tencent.mm.plugin.g.a.e.a.daZ())
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
      label500:
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ah.dFY();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((f)localObject3).ypE.containsKey(Long.valueOf(l)))
        {
          Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (MTimerHandler)((f)localObject3).ypE.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label785;
          }
          ((MTimerHandler)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.dGD().lA(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.dGD().lG(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              d(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1418;
              }
              i += 1;
              if (!com.tencent.mm.plugin.g.a.e.a.fL(MMApplicationContext.getContext()))
              {
                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label500;
              label785:
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
        if (((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yFW, 0) == 1) || (com.tencent.mm.protocal.d.Yxk)) && (!com.tencent.mm.plugin.g.a.e.a.dbb()))
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close!!!");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.ge(MMApplicationContext.getContext()))
        {
          Log.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (h.c((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          apu(com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ah.dFY().Lb(1);
        ah.dFY().b(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ah.dFY().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (h.c((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          apu(com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ah.dFY().b(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ah.dFY().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (h.c((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          apt(com.tencent.mm.plugin.exdevice.k.b.lO(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ah.dFY();
        f.lt(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.g.a.e.a.dbb())
        {
          Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          ef(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.g.a.e.a.fL(MMApplicationContext.getContext())))
        {
          ef(paramString, 1);
          continue;
          ef(paramString, -1);
        }
      }
      label1418:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  final boolean e(IEvent paramIEvent)
  {
    AppMethodBeat.i(23291);
    paramIEvent = (ew)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramIEvent.hEX.hEy, paramIEvent.hEX.hEl, Integer.valueOf(paramIEvent.hEX.type) });
    Object localObject2 = new ckt();
    ((ckt)localObject2).aasS = paramIEvent.hEX.type;
    ((ckt)localObject2).aasT = 0;
    ((ckt)localObject2).YNl = new cyx();
    ((ckt)localObject2).YNl.vgV = paramIEvent.hEX.hEl;
    ((ckt)localObject2).YNl.YJY = paramIEvent.hEX.hEy;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new g.1(this, paramIEvent);
    localObject1 = new ad((LinkedList)localObject1, paramIEvent.hEX.hEy, paramIEvent.hEX.hEZ);
    bh.aZW().a(543, (com.tencent.mm.am.h)localObject2);
    if (!bh.aZW().a((p)localObject1, 0))
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      bh.aZW().b(543, (com.tencent.mm.am.h)localObject2);
      paramIEvent.hEY.hFa = true;
      paramIEvent.hEY.hFb = null;
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
    paramIEvent = (fm)paramIEvent;
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramIEvent.hFG.hEy, Boolean.valueOf(paramIEvent.hFG.hEz), Integer.valueOf(paramIEvent.hFG.hFI) });
    int j = paramIEvent.hFG.hFI;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.g.a.e.a.fL(MMApplicationContext.getContext())) {
          break label197;
        }
        Log.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    af localaf;
    Object localObject2;
    if (paramIEvent.hFG.hEz)
    {
      localaf = af.dFL();
      ??? = paramIEvent.hFG.hEy;
      localObject2 = new g.2(this);
      Log.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (Util.isNullOrNil((String)???)) {
        Log.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramIEvent.hFH.hEn = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramIEvent.hFH.hEn = false;
      AppMethodBeat.o(23292);
      return false;
      localaf.yqR = ((String)???);
      localaf.ysm = ((af.a)localObject2);
      localaf.ysn.clear();
      ??? = localaf.yso.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (p)((Iterator)???).next();
        if (localObject2 != null) {
          bh.aZW().a((p)localObject2);
        }
      }
      localaf.yso.clear();
      synchronized (af.hrB)
      {
        af.ysp.clear();
        if (!localaf.yrw)
        {
          localaf.yrw = true;
          bh.aZW().a(542, localaf);
          ah.dFY().a(i, localaf);
          Log.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaf.qaM.startTimer(12000L);
        }
      }
      af.dFL().Le(i);
    }
  }
  
  public final void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.ypU)
    {
      localLinkedList = new LinkedList(this.ypU);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).t(paramString1, paramString2, paramBoolean);
      }
    }
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).t(paramString1, paramString2, paramBoolean);
    }
    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new fy();
    ((fy)???).hGj.hGd = paramString1;
    ((fy)???).hGj.mac = paramString2;
    ((fy)???).hGj.cVt = paramBoolean;
    ((fy)???).asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  public final boolean t(String paramString, byte[] paramArrayOfByte)
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
      l = com.tencent.mm.plugin.exdevice.k.b.apW(paramString);
      paramString = ah.dGd().yrx.lD(l);
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
    if (paramString.hFs != 2)
    {
      Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ah.dGd();
    boolean bool = j.a(l, paramArrayOfByte, new t.a()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(274674);
        Object localObject1 = paramAnonymousString;
        if (paramAnonymousString == null) {
          localObject1 = "null";
        }
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localObject1 });
        localObject1 = g.this;
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.lO(paramAnonymousLong);
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
          synchronized (((g)localObject1).ypU)
          {
            localLinkedList = new LinkedList(((g)localObject1).ypU);
            ??? = localLinkedList.iterator();
            while (((Iterator)???).hasNext())
            {
              ((g.b)((Iterator)???).next()).b(paramAnonymousString, null, false);
              continue;
              bool = false;
            }
          }
        }
        while (((Iterator)localObject1).hasNext()) {
          ((g.b)((Iterator)localObject1).next()).b(paramAnonymousString, null, false);
        }
        AppMethodBeat.o(274674);
      }
    });
    AppMethodBeat.o(23303);
    return bool;
  }
  
  public final class a
    implements g.b
  {
    private String mURL;
    private String vtX;
    private String yqR;
    private String yqS;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.yqR = paramString1;
      this.vtX = paramString2;
      this.mURL = paramString3;
      this.yqS = paramString4;
      Log.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.vtX == null) || (!this.vtX.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.vtX, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ah.dGc();
          if (!g.c(this.vtX, this.yqR, paramArrayOfByte))
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
      if ((this.vtX == null) || (!this.vtX.equals(paramString)))
      {
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.vtX, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        g.d(this.yqR, this.mURL, -1, this.yqS);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        g.d(this.yqR, this.mURL, 2, this.yqS);
        paramString = new com.tencent.mm.plugin.g.a.b.a.f();
        paramString.vwn = com.tencent.mm.plugin.g.a.b.a.f.vxp;
        paramString.vwo = 2;
        ah.dGc().t(this.vtX, com.tencent.mm.plugin.exdevice.k.b.eZ(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        g.d(this.yqR, this.mURL, 1, this.yqS);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        g.d(this.yqR, this.mURL, 4, this.yqS);
        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      g.d(this.yqR, this.mURL, 0, this.yqS);
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void t(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.vtX == null) || (!this.vtX.equals(paramString2)))
      {
        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.vtX, paramString2, Boolean.valueOf(paramBoolean) });
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
    
    public abstract void t(String paramString1, String paramString2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g
 * JD-Core Version:    0.7.0.1
 */