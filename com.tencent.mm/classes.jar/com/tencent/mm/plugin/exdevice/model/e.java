package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.b;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dn.a;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.do.a;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dq.a;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.eg.a;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ei.a;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ie.b;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.i.j;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.p.c.a;
import com.tencent.mm.pluginsdk.p.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.alf;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
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
  private final long bQo;
  public com.tencent.mm.sdk.b.c jLe;
  public com.tencent.mm.sdk.b.c lDA;
  public com.tencent.mm.sdk.b.c lDB;
  public com.tencent.mm.sdk.b.c lDC;
  public com.tencent.mm.sdk.b.c lDD;
  public com.tencent.mm.sdk.b.c lDE;
  public com.tencent.mm.sdk.b.c lDF;
  public com.tencent.mm.sdk.b.c lDG;
  public com.tencent.mm.sdk.b.c lDH;
  public com.tencent.mm.sdk.b.c lDI;
  public com.tencent.mm.sdk.b.c lDJ;
  public com.tencent.mm.sdk.b.c lDK;
  public com.tencent.mm.sdk.b.c lDL;
  public com.tencent.mm.sdk.b.c lDM;
  public com.tencent.mm.sdk.b.c lDN;
  public com.tencent.mm.sdk.b.c lDO;
  public com.tencent.mm.sdk.b.c lDP;
  public com.tencent.mm.sdk.b.c lDQ;
  public com.tencent.mm.sdk.b.c lDR;
  public com.tencent.mm.sdk.b.c lDS;
  public com.tencent.mm.sdk.b.c lDT;
  public com.tencent.mm.sdk.b.c lDU;
  public com.tencent.mm.sdk.b.c lDV;
  public com.tencent.mm.sdk.b.c lDW;
  public com.tencent.mm.sdk.b.c lDX;
  public com.tencent.mm.sdk.b.c lDY;
  public com.tencent.mm.sdk.b.c lDZ;
  List<b> lDo;
  Map<String, b> lDp;
  public com.tencent.mm.sdk.b.c lDq;
  public com.tencent.mm.sdk.b.c lDr;
  public com.tencent.mm.sdk.b.c lDs;
  public com.tencent.mm.sdk.b.c lDt;
  public com.tencent.mm.sdk.b.c lDu;
  public com.tencent.mm.sdk.b.c lDv;
  public com.tencent.mm.sdk.b.c lDw;
  public com.tencent.mm.sdk.b.c lDx;
  public com.tencent.mm.sdk.b.c lDy;
  public com.tencent.mm.sdk.b.c lDz;
  public com.tencent.mm.sdk.b.c lEa;
  public com.tencent.mm.sdk.b.c lEb;
  public com.tencent.mm.sdk.b.c lEc;
  ExdeviceWCLanSDKUtil lEd;
  g lEe;
  private boolean lEf;
  private e.c lEg;
  ak mHandler;
  
  public e()
  {
    AppMethodBeat.i(19216);
    this.lDq = new e.1(this);
    this.lDr = new e.12(this);
    this.lDs = new e.23(this);
    this.lDt = new e.34(this);
    this.lDu = new com.tencent.mm.sdk.b.c() {};
    this.lDv = new e.43(this);
    this.lDw = new e.44(this);
    this.lDx = new e.45(this);
    this.lDy = new e.46(this);
    this.lDz = new e.2(this);
    this.lDA = new e.3(this);
    this.lDB = new e.4(this);
    this.lDC = new e.5(this);
    this.lDD = new e.6(this);
    this.lDE = new com.tencent.mm.sdk.b.c() {};
    this.lDF = new e.8(this);
    this.lDG = new e.9(this);
    this.lDH = new e.10(this);
    this.lDI = new e.11(this);
    this.lDJ = new e.13(this);
    this.lDK = new e.14(this);
    this.lDL = new e.15(this);
    this.lDM = new com.tencent.mm.sdk.b.c() {};
    this.lDN = new e.17(this);
    this.lDO = new e.18(this);
    this.lDP = new e.19(this);
    this.lDQ = new e.20(this);
    this.jLe = new com.tencent.mm.sdk.b.c() {};
    this.lDR = new com.tencent.mm.sdk.b.c() {};
    this.lDS = new e.24(this);
    this.lDT = new e.25(this);
    this.lDU = new e.26(this);
    this.lDV = new e.27(this);
    this.lDW = new e.28(this);
    this.lDX = new e.29(this);
    this.lDY = new e.30(this);
    this.lDZ = new e.31(this);
    this.lEa = new e.32(this);
    this.lEb = new e.33(this);
    this.lEc = new e.35(this);
    this.bQo = 300000L;
    this.lEf = false;
    this.lDo = new LinkedList();
    this.lDp = new HashMap();
    HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.aqu("wifi_device_heart_beat");
    localHandlerThread.start();
    this.mHandler = new ak(localHandlerThread.getLooper());
    AppMethodBeat.o(19216);
  }
  
  static boolean Lr(String paramString)
  {
    AppMethodBeat.i(19225);
    paramString = com.tencent.mm.aj.f.rS(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(19225);
      return false;
    }
    paramString = paramString.cU(false);
    if ((paramString == null) || (paramString.aeA() == null) || (!paramString.aeA().aeJ()))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(19225);
      return false;
    }
    AppMethodBeat.o(19225);
    return true;
  }
  
  public static boolean Ls(String paramString)
  {
    AppMethodBeat.i(19233);
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!bpL())
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(19233);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(19233);
      return false;
    }
    ad.bqk();
    h.iZ(com.tencent.mm.plugin.exdevice.j.b.LX(paramString));
    AppMethodBeat.o(19233);
    return true;
  }
  
  static int a(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    AppMethodBeat.i(19222);
    int i = -1;
    if (bo.nullAsNil(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(19222);
      return i;
      if (bo.nullAsNil(paramb.field_connProto).contains("3")) {
        i = 0;
      }
    }
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(19244);
    paramString = (b)this.lDp.put(paramString, paramb);
    AppMethodBeat.o(19244);
    return paramString;
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.h.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(19226);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      AppMethodBeat.o(19226);
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.bqz().jl(paramb.field_mac);
    if (locala == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(19226);
      return false;
    }
    if (locala.crJ == 2)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.bqA().a((ae)localObject);
    }
    Object localObject = ad.bqf();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).uU(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.bqf();
      long l = paramb.field_mac;
      localObject = (ap)((d)localObject).lCX.remove(Long.valueOf(l));
      if (localObject != null) {
        ((ap)localObject).stopTimer();
      }
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.bqz().jp(locala.lIB)) || ((2 != locala.crJ) && (locala.crJ != 0)))
      {
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.crJ), str });
        if (u.bqA().lCQ != null) {
          u.bqA().lCQ.jr(locala.lIB);
        }
      }
      if (f.b(paramb))
      {
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        Ls(com.tencent.mm.plugin.exdevice.j.b.jw(paramb.field_mac));
      }
      AppMethodBeat.o(19226);
      return true;
    }
    if ((2 != locala.crJ) && (p.e.vJC != null) && (p.e.vJC.cYC()))
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(19226);
      return false;
    }
    AppMethodBeat.o(19226);
    return true;
  }
  
  public static void aB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19241);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    eb localeb = new eb();
    localeb.crS.bYu = paramString;
    localeb.crS.cqN = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.a(localeb, Looper.getMainLooper());
    AppMethodBeat.o(19241);
  }
  
  static boolean bpJ()
  {
    AppMethodBeat.i(19228);
    Object localObject = ad.bpY().bqE();
    if (((LinkedList)localObject).isEmpty())
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(19228);
      return false;
    }
    ad.bqf().uU(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject).next();
      aw.aaz();
      com.tencent.mm.storage.ad localad = com.tencent.mm.model.c.YA().arw(localb.field_brandName);
      if ((localad == null) || (!com.tencent.mm.n.a.je(localad.field_type)))
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.bqf().b(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(19228);
    return true;
  }
  
  static boolean bpK()
  {
    AppMethodBeat.i(19229);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.bqf();
    d.hc(false);
    ad.bqf().bpI();
    AppMethodBeat.o(19229);
    return true;
  }
  
  private static boolean bpL()
  {
    AppMethodBeat.i(19231);
    if (!com.tencent.mm.plugin.d.a.e.a.dA(ah.getContext()))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(19231);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.aWe())
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(19231);
      return false;
    }
    AppMethodBeat.o(19231);
    return true;
  }
  
  public static boolean bpM()
  {
    AppMethodBeat.i(19232);
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!bpL())
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(19232);
      return false;
    }
    ad.bqk().scan();
    AppMethodBeat.o(19232);
    return true;
  }
  
  static boolean bpN()
  {
    AppMethodBeat.i(19245);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = ah.getContext();
    try
    {
      ad.bqf().bpI();
      com.tencent.mm.bq.d.l(new Intent(localContext, ExDeviceService.class), "exdevice");
      AppMethodBeat.o(19245);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(19238);
    lv locallv = new lv();
    locallv.cBR.op = 2;
    locallv.cBR.czh = paramString1;
    locallv.cBR.crJ = paramInt;
    locallv.cBR.url = paramString2;
    locallv.cBR.bYu = paramString3;
    com.tencent.mm.sdk.b.a.ymk.a(locallv, Looper.getMainLooper());
    AppMethodBeat.o(19238);
  }
  
  static boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(19220);
    paramb = (dn)paramb;
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.crd.cqQ, paramb.crd.context });
    LinkedList localLinkedList = ad.bpY().LK(paramb.crd.cqQ);
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
          com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)localIterator.next();
          if (localLinkedList.isEmpty()) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!u.bqz().jj(localb.field_mac)) {
            break label222;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.cre.crf = localJSONArray;
        paramb.cre.cqS = true;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(19220);
        return true;
      }
    }
  }
  
  public static boolean c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19236);
    Object localObject;
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.ce(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bo.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bo.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (bo.ce(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(19236);
        return false;
      }
    }
    String str;
    if (bo.isNullOrNil(paramString1))
    {
      localObject = "null";
      if (!bo.isNullOrNil(paramString2)) {
        break label226;
      }
      str = "null";
      label131:
      if (!bo.ce(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.j.b.LX(paramString1);
      localObject = ad.bpY().jv(l);
      if (localObject != null) {
        break label238;
      }
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(19236);
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label131;
    }
    label238:
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.as(paramArrayOfByte);
    if (1L != paramString1.jOK)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.jOK) });
      AppMethodBeat.o(19236);
      return false;
    }
    paramString1 = (com.tencent.mm.plugin.d.a.b.a.f)paramString1;
    paramString2 = Calendar.getInstance();
    paramString2.set(11, 0);
    paramString2.set(12, 0);
    paramString2.set(13, 0);
    i = (int)(paramString2.getTimeInMillis() / 1000L);
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceType, i, j, paramString1.jQu, "");
    AppMethodBeat.o(19236);
    return true;
  }
  
  public static void cd(String paramString, int paramInt)
  {
    AppMethodBeat.i(19239);
    lv locallv = new lv();
    locallv.cBR.op = 1;
    locallv.cBR.czh = paramString;
    locallv.cBR.aXG = paramInt;
    com.tencent.mm.sdk.b.a.ymk.a(locallv, Looper.getMainLooper());
    AppMethodBeat.o(19239);
  }
  
  public static void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19240);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    ec localec = new ec();
    localec.crT.bYu = paramString1;
    localec.crT.cqQ = paramString2;
    localec.crT.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.ymk.a(localec, Looper.getMainLooper());
    AppMethodBeat.o(19240);
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(19221);
    paramb = (ei)paramb;
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.csc.cqQ, paramb.csc.bYu });
    if (bo.ce(paramb.csc.data))
    {
      paramb.csd.cqS = false;
      AppMethodBeat.o(19221);
      return false;
    }
    Object localObject = ad.bpY().LI(paramb.csc.bYu);
    if (localObject == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.csd.cqS = false;
      AppMethodBeat.o(19221);
      return false;
    }
    if (!u.bqz().jj(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.csd.cqS = false;
      AppMethodBeat.o(19221);
      return false;
    }
    if (!u.bqz().jp(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.csd.cqS = false;
      AppMethodBeat.o(19221);
      return false;
    }
    if (aa.bpV().lEQ) {
      aa.bpV().uW(a((com.tencent.mm.plugin.exdevice.h.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.i.g(paramb.csc.data, 10001, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac);
    u.bqA().a((ae)localObject);
    paramb.csd.cqS = true;
    AppMethodBeat.o(19221);
    return true;
  }
  
  static boolean j(String paramString, List<com.tencent.mm.plugin.exdevice.h.b> paramList)
  {
    AppMethodBeat.i(19218);
    String str = Uri.parse(paramString).getHost();
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
    paramString = null;
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    boolean bool3;
    for (;;)
    {
      bool3 = bool1;
      if (localIterator.hasNext())
      {
        Object localObject = (com.tencent.mm.plugin.exdevice.h.b)localIterator.next();
        paramList = ((ch)localObject).dCP;
        localObject = ((ch)localObject).dCQ;
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
              ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
          }
        }
      }
    }
    label213:
    AppMethodBeat.o(19218);
    return bool3;
  }
  
  static boolean k(String paramString, List<com.tencent.mm.plugin.exdevice.h.b> paramList)
  {
    AppMethodBeat.i(19219);
    if (paramString == null)
    {
      AppMethodBeat.o(19219);
      return false;
    }
    Object localObject = new ie();
    ((ie)localObject).cxt.crk = paramString;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((ie)localObject).cxu.cxv;
    int i = ((TimeLineObject)localObject).xTS.wNZ;
    boolean bool;
    if (i == 1)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).dCP;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      AppMethodBeat.o(19219);
      return bool;
      bool = false;
      continue;
      if (i == 4)
      {
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).dCP;
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
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).dCP;
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
        bool = j(((TimeLineObject)localObject).xTS.Url, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean Lt(String paramString)
  {
    AppMethodBeat.i(19234);
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!bpL())
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(19234);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(19234);
      return false;
    }
    ad.bqk().a(com.tencent.mm.plugin.exdevice.j.b.LX(paramString), new e.40(this));
    AppMethodBeat.o(19234);
    return true;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(19242);
    if (this.lDo.contains(paramb))
    {
      AppMethodBeat.o(19242);
      return false;
    }
    boolean bool = this.lDo.add(paramb);
    AppMethodBeat.o(19242);
    return bool;
  }
  
  final boolean at(int paramInt, String paramString)
  {
    AppMethodBeat.i(19230);
    ab.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.aj.f.rS(paramString);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(19230);
      return false;
    }
    localObject1 = ((com.tencent.mm.aj.d)localObject1).cU(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((d.b)localObject1).aeA();
      if ((localObject2 != null) && (((d.b.b)localObject2).aeJ())) {}
    }
    else
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(19230);
      return false;
    }
    localObject1 = ad.bpY().LK(paramString);
    Object localObject3;
    if (((d.b.b)localObject2).fvJ == 1)
    {
      localObject2 = ad.bpY().bqE();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject2).next();
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_deviceType, Long.valueOf(((ch)localObject3).dCO) });
          if (0L != (((ch)localObject3).dCO & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      AppMethodBeat.o(19230);
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
      AppMethodBeat.o(19230);
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
        localObject2 = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject1).next();
        if (localObject2 == null)
        {
          ab.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (bo.nullAsNil(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("4"))
        {
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy) });
        }
        else if (bo.nullAsNil(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.d.a.e.a.aWc())
          {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
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
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.bqf();
        long l = ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac;
        ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).lCY.containsKey(Long.valueOf(l)))
        {
          ab.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (ap)((d)localObject3).lCY.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((ap)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.bqz().jj(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac))
          {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac) });
            if (u.bqz().jp(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac))
            {
              ab.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              c(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bo.nullAsNil(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.dA(ah.getContext()))
              {
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label495;
              label780:
              ab.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.dN(ah.getContext()))
        {
          ab.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, new e.a(this, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID));
          Lt(com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
        ad.bqf().uU(1);
        ad.bqf().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy);
        ad.bqf().c(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, new e.a(this, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID));
          Lt(com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.bqf().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy);
        ad.bqf().c(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          Ls(com.tencent.mm.plugin.exdevice.j.b.jw(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.bqf();
        d.iZ(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.aWe())
        {
          ab.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          cd(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(19230);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.dA(ah.getContext())))
        {
          cd(paramString, 1);
          continue;
          cd(paramString, -1);
        }
      }
      label1357:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(19243);
    if (this.lDo.remove(paramb))
    {
      AppMethodBeat.o(19243);
      return true;
    }
    AppMethodBeat.o(19243);
    return false;
  }
  
  final boolean b(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(19217);
    paramb = (do)paramb;
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.crg.cqQ, paramb.crg.context });
    if (!Lr(paramb.crg.cqQ))
    {
      paramb.crh.crf = null;
      paramb.crh.cqS = false;
      AppMethodBeat.o(19217);
      return true;
    }
    LinkedList localLinkedList = ad.bpY().LK(paramb.crg.cqQ);
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
          com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)localIterator.next();
          if ((localLinkedList.isEmpty()) || (!bo.nullAsNil(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.lEd.Lv(localb.field_deviceID)) {
            break label280;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.crh.crf = localJSONArray;
        paramb.crh.cqS = true;
        ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(19217);
        return true;
      }
    }
  }
  
  final boolean e(final com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(19223);
    paramb = (dq)paramb;
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.cro.cqQ, paramb.cro.bYu, Integer.valueOf(paramb.cro.type) });
    Object localObject2 = new alc();
    ((alc)localObject2).xbZ = paramb.cro.type;
    ((alc)localObject2).xca = 0;
    ((alc)localObject2).wva = new auh();
    ((alc)localObject2).wva.jJD = paramb.cro.bYu;
    ((alc)localObject2).wva.wsq = paramb.cro.cqQ;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new com.tencent.mm.ai.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
      {
        AppMethodBeat.i(19195);
        if ((paramAnonymousm != null) && (paramAnonymousm.getType() == 543))
        {
          aw.Rc().b(543, this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ab.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramb.crp.crr = true;
            paramb.crp.crs = null;
            if (paramb.callback != null) {
              paramb.callback.run();
            }
            AppMethodBeat.o(19195);
            return;
          }
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (z)paramAnonymousm;
          if ((paramAnonymousString.lFp == null) || (paramAnonymousString.lFp.fsW.fta == null)) {}
          alf localalf;
          for (paramAnonymousString = null;; paramAnonymousString = (ale)paramAnonymousString.lFp.fsW.fta)
          {
            Iterator localIterator = paramAnonymousString.xcd.iterator();
            paramAnonymousInt1 = 0;
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label413;
              }
              localalf = (alf)localIterator.next();
              if (localalf != null)
              {
                paramAnonymousm = null;
                paramAnonymousString = null;
                if (localalf.wva != null)
                {
                  paramAnonymousm = localalf.wva.jJD;
                  paramAnonymousString = localalf.wva.wsq;
                }
                if ((localalf.Ret == 0) && (!bo.isNullOrNil(localalf.wQf))) {
                  break;
                }
                ab.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramAnonymousm, Integer.valueOf(localalf.Ret), localalf.wQf });
              }
            }
          }
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramAnonymousm, paramAnonymousString, localalf.wQf, Integer.valueOf(localalf.xbZ) });
          paramb.crp.crr = true;
          paramb.crp.crs = localalf.wQf;
          if (paramb.callback == null) {
            break label519;
          }
          paramb.callback.run();
          paramAnonymousInt1 = 1;
        }
        label519:
        for (;;)
        {
          break;
          label413:
          if (paramAnonymousInt1 == 0)
          {
            paramb.crp.crr = true;
            paramb.crp.crs = null;
            if (paramb.callback != null) {
              paramb.callback.run();
            }
          }
          AppMethodBeat.o(19195);
          return;
          paramb.crp.crr = true;
          paramb.crp.crs = null;
          if (paramb.callback != null) {
            paramb.callback.run();
          }
          AppMethodBeat.o(19195);
          return;
        }
      }
    };
    localObject1 = new z((LinkedList)localObject1, paramb.cro.cqQ, paramb.cro.crq);
    aw.Rc().a(543, (com.tencent.mm.ai.f)localObject2);
    if (!aw.Rc().a((com.tencent.mm.ai.m)localObject1, 0))
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      aw.Rc().b(543, (com.tencent.mm.ai.f)localObject2);
      paramb.crp.crr = true;
      paramb.crp.crs = null;
      if (paramb.callback != null) {
        paramb.callback.run();
      }
      AppMethodBeat.o(19223);
      return true;
    }
    AppMethodBeat.o(19223);
    return false;
  }
  
  final boolean f(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(19224);
    paramb = (eg)paramb;
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.crX.cqQ, Boolean.valueOf(paramb.crX.cqR), Integer.valueOf(paramb.crX.crZ) });
    int j = paramb.crX.crZ;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.dA(ah.getContext())) {
          break label197;
        }
        ab.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.crX.cqR)
    {
      localaa = aa.bpV();
      ??? = paramb.crX.cqQ;
      localObject2 = new aa.a()
      {
        public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(19196);
          ab.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramAnonymousString });
          if (paramAnonymousArrayOfByte == null) {
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          }
          for (;;)
          {
            ed localed = new ed();
            localed.crU.crM = paramAnonymousArrayOfByte;
            localed.crU.bYu = paramAnonymousString;
            localed.crU.aLC = paramAnonymousBoolean;
            com.tencent.mm.sdk.b.a.ymk.a(localed, Looper.getMainLooper());
            AppMethodBeat.o(19196);
            return;
            ab.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramAnonymousString, Base64.encodeToString(paramAnonymousArrayOfByte, 0), Boolean.valueOf(paramAnonymousBoolean) });
          }
        }
      };
      ab.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (bo.isNullOrNil((String)???)) {
        ab.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramb.crY.cqS = true;
      AppMethodBeat.o(19224);
      return true;
      label197:
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.crY.cqS = false;
      AppMethodBeat.o(19224);
      return false;
      localaa.lEk = ((String)???);
      localaa.lFE = ((aa.a)localObject2);
      localaa.lFF.clear();
      ??? = localaa.lFG.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (com.tencent.mm.ai.m)((Iterator)???).next();
        if (localObject2 != null) {
          aw.Rc().a((com.tencent.mm.ai.m)localObject2);
        }
      }
      localaa.lFG.clear();
      synchronized (aa.ceY)
      {
        aa.lFH.clear();
        if (!localaa.lEQ)
        {
          localaa.lEQ = true;
          aw.Rc().a(542, localaa);
          ad.bqf().a(i, localaa);
          ab.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.gIs.ag(12000L, 12000L);
        }
      }
      ab.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.bpV().uW(i);
    }
  }
  
  final boolean k(List<com.tencent.mm.plugin.exdevice.h.b> paramList, int paramInt)
  {
    AppMethodBeat.i(19227);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      ab.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
      AppMethodBeat.o(19227);
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
        Object localObject = (com.tencent.mm.plugin.exdevice.h.b)paramList.next();
        localObject = new k(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceID, paramInt);
        u.bqA().a((ae)localObject);
      }
      if (this.lEf) {
        this.mHandler.removeCallbacks(this.lEg);
      }
      this.lEg = new e.c(this, paramList);
      this.mHandler.postDelayed(this.lEg, 300000L);
      this.lEf = true;
      paramInt = 2;
      continue;
      if (this.lEf)
      {
        this.mHandler.removeCallbacks(this.lEg);
        this.lEf = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(19227);
    return true;
  }
  
  public final void o(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(19237);
    LinkedList localLinkedList;
    synchronized (this.lDo)
    {
      localLinkedList = new LinkedList(this.lDo);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).p(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.lDp.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).p(paramString1, paramString2, paramBoolean);
    }
    ab.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new es();
    ((es)???).csz.cst = paramString1;
    ((es)???).csz.mac = paramString2;
    ((es)???).csz.aLC = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
    AppMethodBeat.o(19237);
  }
  
  public final boolean u(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19235);
    if ((bo.isNullOrNil(paramString)) || (bo.ce(paramArrayOfByte)))
    {
      if (bo.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!bo.ce(paramArrayOfByte)) {
          break label79;
        }
      }
      label79:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        ab.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(19235);
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (bo.isNullOrNil(paramString))
    {
      str = "null";
      if (!bo.ce(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.j.b.LX(paramString);
      paramString = ad.bqk().lER.jm(l);
      if (paramString != null) {
        break label182;
      }
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(19235);
      return false;
      str = paramString;
      break;
    }
    label182:
    if (paramString.crJ != 2)
    {
      ab.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(19235);
      return false;
    }
    ad.bqk();
    boolean bool = h.a(l, paramArrayOfByte, new e.41(this));
    AppMethodBeat.o(19235);
    return bool;
  }
  
  public static abstract interface b
  {
    public abstract void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean);
    
    public abstract void c(String paramString, int paramInt, long paramLong);
    
    public abstract void p(String paramString1, String paramString2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */