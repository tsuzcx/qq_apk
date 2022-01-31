package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.b;
import com.tencent.mm.h.a.db;
import com.tencent.mm.h.a.dk;
import com.tencent.mm.h.a.dk.a;
import com.tencent.mm.h.a.dl;
import com.tencent.mm.h.a.dl.a;
import com.tencent.mm.h.a.dn;
import com.tencent.mm.h.a.dn.a;
import com.tencent.mm.h.a.dy;
import com.tencent.mm.h.a.dz;
import com.tencent.mm.h.a.ed;
import com.tencent.mm.h.a.ed.a;
import com.tencent.mm.h.a.ef;
import com.tencent.mm.h.a.ef.a;
import com.tencent.mm.h.a.ep;
import com.tencent.mm.h.a.es;
import com.tencent.mm.h.a.ev;
import com.tencent.mm.h.a.ia;
import com.tencent.mm.h.a.ia.b;
import com.tencent.mm.h.a.lg;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.i.j;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.o.d.a;
import com.tencent.mm.pluginsdk.o.f;
import com.tencent.mm.protocal.c.agj;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private final long bqk = 300000L;
  public com.tencent.mm.sdk.b.c hRD = new e.21(this);
  List<e.b> jtP = new LinkedList();
  Map<String, e.b> jtQ = new HashMap();
  public com.tencent.mm.sdk.b.c jtR = new e.1(this);
  public com.tencent.mm.sdk.b.c jtS = new e.12(this);
  public com.tencent.mm.sdk.b.c jtT = new e.23(this);
  public com.tencent.mm.sdk.b.c jtU = new e.34(this);
  public com.tencent.mm.sdk.b.c jtV = new com.tencent.mm.sdk.b.c() {};
  public com.tencent.mm.sdk.b.c jtW = new e.43(this);
  public com.tencent.mm.sdk.b.c jtX = new e.44(this);
  public com.tencent.mm.sdk.b.c jtY = new e.45(this);
  public com.tencent.mm.sdk.b.c jtZ = new e.46(this);
  public com.tencent.mm.sdk.b.c juA = new e.31(this);
  public com.tencent.mm.sdk.b.c juB = new e.32(this);
  public com.tencent.mm.sdk.b.c juC = new e.33(this);
  public com.tencent.mm.sdk.b.c juD = new e.35(this);
  ExdeviceWCLanSDKUtil juE;
  g juF;
  private boolean juG = false;
  private e.c juH;
  public com.tencent.mm.sdk.b.c jua = new e.2(this);
  public com.tencent.mm.sdk.b.c jub = new e.3(this);
  public com.tencent.mm.sdk.b.c juc = new e.4(this);
  public com.tencent.mm.sdk.b.c jud = new e.5(this);
  public com.tencent.mm.sdk.b.c jue = new e.6(this);
  public com.tencent.mm.sdk.b.c juf = new com.tencent.mm.sdk.b.c() {};
  public com.tencent.mm.sdk.b.c jug = new e.8(this);
  public com.tencent.mm.sdk.b.c juh = new e.9(this);
  public com.tencent.mm.sdk.b.c jui = new e.10(this);
  public com.tencent.mm.sdk.b.c juj = new e.11(this);
  public com.tencent.mm.sdk.b.c juk = new e.13(this);
  public com.tencent.mm.sdk.b.c jul = new e.14(this);
  public com.tencent.mm.sdk.b.c jum = new e.15(this);
  public com.tencent.mm.sdk.b.c jun = new com.tencent.mm.sdk.b.c() {};
  public com.tencent.mm.sdk.b.c juo = new e.17(this);
  public com.tencent.mm.sdk.b.c jup = new e.18(this);
  public com.tencent.mm.sdk.b.c juq = new e.19(this);
  public com.tencent.mm.sdk.b.c jur = new e.20(this);
  public com.tencent.mm.sdk.b.c jus = new e.22(this);
  public com.tencent.mm.sdk.b.c jut = new e.24(this);
  public com.tencent.mm.sdk.b.c juu = new e.25(this);
  public com.tencent.mm.sdk.b.c juv = new e.26(this);
  public com.tencent.mm.sdk.b.c juw = new e.27(this);
  public com.tencent.mm.sdk.b.c jux = new e.28(this);
  public com.tencent.mm.sdk.b.c juy = new com.tencent.mm.sdk.b.c() {};
  public com.tencent.mm.sdk.b.c juz = new e.30(this);
  ah mHandler;
  
  public e()
  {
    HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.aap("wifi_device_heart_beat");
    localHandlerThread.start();
    this.mHandler = new ah(localHandlerThread.getLooper());
  }
  
  static boolean Bp(String paramString)
  {
    paramString = com.tencent.mm.ai.f.kX(paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      return false;
    }
    paramString = paramString.bS(false);
    if ((paramString == null) || (paramString.LS() == null) || (!paramString.LS().Mc()))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      return false;
    }
    return true;
  }
  
  public static boolean Bq(String paramString)
  {
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!aLx())
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      return false;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      return false;
    }
    ad.aLX();
    h.dH(com.tencent.mm.plugin.exdevice.j.b.BU(paramString));
    return true;
  }
  
  static int a(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    int i = -1;
    if (bk.pm(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    while (!bk.pm(paramb.field_connProto).contains("3")) {
      return i;
    }
    return 0;
  }
  
  private e.b a(String paramString, e.b paramb)
  {
    return (e.b)this.jtQ.put(paramString, paramb);
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.h.b paramb, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.aMm().dT(paramb.field_mac);
    if (locala == null)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      return false;
    }
    if (locala.bKp == 2)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.aMn().a((ae)localObject);
    }
    Object localObject = ad.aLS();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).qo(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.aLS();
      long l = paramb.field_mac;
      localObject = (am)((d)localObject).jty.remove(Long.valueOf(l));
      if (localObject != null) {
        ((am)localObject).stopTimer();
      }
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.aMm().dX(locala.jzc)) || ((2 != locala.bKp) && (locala.bKp != 0)))
      {
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.bKp), str });
        if (u.aMn().jtr != null) {
          u.aMn().jtr.dZ(locala.jzc);
        }
      }
      if (f.b(paramb))
      {
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        Bq(com.tencent.mm.plugin.exdevice.j.b.ee(paramb.field_mac));
      }
      return true;
    }
    if ((2 != locala.bKp) && (o.f.rSG != null) && (o.f.rSG.bYP()))
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      return false;
    }
    return true;
  }
  
  static boolean aLv()
  {
    Object localObject = ad.aLL().aMr();
    if (((LinkedList)localObject).isEmpty())
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      return false;
    }
    ad.aLS().qo(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject).next();
      au.Hx();
      com.tencent.mm.storage.ad localad = com.tencent.mm.model.c.Fw().abl(localb.field_brandName);
      if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type)))
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.aLS().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    return true;
  }
  
  static boolean aLw()
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.aLS();
    d.fA(false);
    ad.aLS().aLu();
    return true;
  }
  
  private static boolean aLx()
  {
    if (!com.tencent.mm.plugin.f.a.e.a.cP(com.tencent.mm.sdk.platformtools.ae.getContext()))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return false;
    }
    if (!com.tencent.mm.plugin.f.a.e.a.awB())
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      return false;
    }
    return true;
  }
  
  public static boolean aLy()
  {
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!aLx())
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      return false;
    }
    ad.aLX().aLB();
    return true;
  }
  
  static boolean aLz()
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = com.tencent.mm.sdk.platformtools.ae.getContext();
    try
    {
      ad.aLS().aLu();
      localContext.stopService(new Intent(localContext, ExDeviceService.class));
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        y.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  public static void aq(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    dy localdy = new dy();
    localdy.bKy.bwK = paramString;
    localdy.bKy.bJt = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.a(localdy, Looper.getMainLooper());
  }
  
  public static void by(String paramString, int paramInt)
  {
    lg locallg = new lg();
    locallg.bUl.op = 1;
    locallg.bUl.bRF = paramString;
    locallg.bUl.aQw = paramInt;
    com.tencent.mm.sdk.b.a.udP.a(locallg, Looper.getMainLooper());
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    lg locallg = new lg();
    locallg.bUl.op = 2;
    locallg.bUl.bRF = paramString1;
    locallg.bUl.bKp = paramInt;
    locallg.bUl.url = paramString2;
    locallg.bUl.bwK = paramString3;
    com.tencent.mm.sdk.b.a.udP.a(locallg, Looper.getMainLooper());
  }
  
  public static boolean c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bE(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bk.bl(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bk.bl(paramString2)) {
        paramString1 = "null";
      }
      if (bk.bE(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        return false;
      }
    }
    String str;
    if (bk.bl(paramString1))
    {
      localObject = "null";
      if (!bk.bl(paramString2)) {
        break label208;
      }
      str = "null";
      label119:
      if (!bk.bE(paramArrayOfByte)) {
        break label214;
      }
    }
    label208:
    label214:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      y.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.j.b.BU(paramString1);
      localObject = ad.aLL().ed(l);
      if (localObject != null) {
        break label220;
      }
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label119;
    }
    label220:
    paramString1 = com.tencent.mm.plugin.f.a.b.a.a.Z(paramArrayOfByte);
    if (1L != paramString1.hUQ)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.hUQ) });
      return false;
    }
    paramString1 = (com.tencent.mm.plugin.f.a.b.a.f)paramString1;
    paramString2 = Calendar.getInstance();
    paramString2.set(11, 0);
    paramString2.set(12, 0);
    paramString2.set(13, 0);
    i = (int)(paramString2.getTimeInMillis() / 1000L);
    int j = (int)(System.currentTimeMillis() / 1000L);
    ((com.tencent.mm.plugin.sport.b.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sport.b.b.class)).b(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_deviceType, i, j, paramString1.hWB, "");
    return true;
  }
  
  public static void d(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    dz localdz = new dz();
    localdz.bKz.bwK = paramString1;
    localdz.bKz.bJw = paramString2;
    localdz.bKz.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.udP.a(localdz, Looper.getMainLooper());
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (dk)paramb;
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.bJJ.bJw, paramb.bJJ.context });
    LinkedList localLinkedList = ad.aLL().BI(paramb.bJJ.bJw);
    JSONArray localJSONArray = new JSONArray();
    label210:
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
          if (!u.aMm().dR(localb.field_mac)) {
            break label210;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.bJK.bJL = localJSONArray;
        paramb.bJK.bJy = true;
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        return true;
      }
    }
  }
  
  static boolean e(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (ef)paramb;
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.bKI.bJw, paramb.bKI.bwK });
    if (bk.bE(paramb.bKI.data))
    {
      paramb.bKJ.bJy = false;
      return false;
    }
    Object localObject = ad.aLL().BG(paramb.bKI.bwK);
    if (localObject == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.bKJ.bJy = false;
      return false;
    }
    if (!u.aMm().dR(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.bKJ.bJy = false;
      return false;
    }
    if (!u.aMm().dX(((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.bKJ.bJy = false;
      return false;
    }
    if (aa.aLI().jvr) {
      aa.aLI().qp(a((com.tencent.mm.plugin.exdevice.h.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.i.g(paramb.bKI.data, 10001, ((com.tencent.mm.plugin.exdevice.h.b)localObject).field_mac);
    u.aMn().a((ae)localObject);
    paramb.bKJ.bJy = true;
    return true;
  }
  
  static boolean i(String paramString, List<com.tencent.mm.plugin.exdevice.h.b> paramList)
  {
    String str = Uri.parse(paramString).getHost();
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
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
        paramList = ((cc)localObject).cMZ;
        localObject = ((cc)localObject).cNa;
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
                break label207;
              }
              bool1 = bool2;
            }
            catch (JSONException paramList)
            {
              int i;
              y.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            y.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
          }
        }
      }
    }
    label207:
    return bool3;
  }
  
  static boolean j(String paramString, List<com.tencent.mm.plugin.exdevice.h.b> paramList)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = new ia();
    ((ia)localObject).bQa.bJQ = paramString;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((ia)localObject).bQb.bQc;
    int i = ((bxk)localObject).tNr.sPI;
    boolean bool;
    if (i == 1)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).cMZ;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      return bool;
      bool = false;
      continue;
      if (i == 4)
      {
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).cMZ;
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
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.h.b)paramList.next()).cMZ;
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
        bool = i(((bxk)localObject).tNr.kSC, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean Br(String paramString)
  {
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!aLx())
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      return false;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      return false;
    }
    ad.aLX().a(com.tencent.mm.plugin.exdevice.j.b.BU(paramString), new e.40(this));
    return true;
  }
  
  public final boolean a(e.b paramb)
  {
    if ((paramb == null) || (this.jtP.contains(paramb))) {
      return false;
    }
    return this.jtP.add(paramb);
  }
  
  final boolean aa(int paramInt, String paramString)
  {
    y.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.ai.f.kX(paramString);
    if (localObject1 == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      return false;
    }
    localObject1 = ((com.tencent.mm.ai.d)localObject1).bS(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((d.b)localObject1).LS();
      if ((localObject2 != null) && (((d.b.b)localObject2).Mc())) {}
    }
    else
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      return false;
    }
    localObject1 = ad.aLL().BI(paramString);
    Object localObject3;
    if (((d.b.b)localObject2).efH == 1)
    {
      localObject2 = ad.aLL().aMr();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.h.b)((Iterator)localObject2).next();
          y.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.h.b)localObject3).field_deviceType, Long.valueOf(((cc)localObject3).cMY) });
          if (0L != (((cc)localObject3).cMY & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
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
          y.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (bk.pm(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("4"))
        {
          y.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          y.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy) });
        }
        else if (bk.pm(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.f.a.e.a.awz())
          {
            y.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
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
      label465:
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.aLS();
        long l = ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac;
        y.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).jtz.containsKey(Long.valueOf(l)))
        {
          y.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (am)((d)localObject3).jtz.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label750;
          }
          ((am)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.aMm().dR(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac))
          {
            y.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac) });
            if (u.aMm().dX(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac))
            {
              y.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              c(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bk.pm(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connProto).contains("3")) {
                break label1321;
              }
              i += 1;
              if (!com.tencent.mm.plugin.f.a.e.a.cP(com.tencent.mm.sdk.platformtools.ae.getContext()))
              {
                y.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label465;
              label750:
              y.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            y.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.db(com.tencent.mm.sdk.platformtools.ae.getContext()))
        {
          y.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          y.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, new e.a(this, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID));
          Br(com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName });
        ad.aLS().qo(1);
        ad.aLS().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy);
        ad.aLS().b(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, new e.a(this, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_deviceID));
          Br(com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.aLS().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_connStrategy);
        ad.aLS().b(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.h.b)localObject2))
        {
          Bq(com.tencent.mm.plugin.exdevice.j.b.ee(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.aLS();
        d.dH(((com.tencent.mm.plugin.exdevice.h.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.f.a.e.a.awB())
        {
          y.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          by(paramString, 0);
        }
      }
      for (;;)
      {
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.f.a.e.a.cP(com.tencent.mm.sdk.platformtools.ae.getContext())))
        {
          by(paramString, 1);
          continue;
          by(paramString, -1);
        }
      }
      label1321:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean b(e.b paramb)
  {
    return (paramb != null) && (this.jtP.remove(paramb));
  }
  
  final boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (dl)paramb;
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.bJM.bJw, paramb.bJM.context });
    if (!Bp(paramb.bJM.bJw))
    {
      paramb.bJN.bJL = null;
      paramb.bJN.bJy = false;
      return true;
    }
    LinkedList localLinkedList = ad.aLL().BI(paramb.bJM.bJw);
    JSONArray localJSONArray = new JSONArray();
    label262:
    for (;;)
    {
      try
      {
        Iterator localIterator = localLinkedList.iterator();
        JSONObject localJSONObject;
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.exdevice.h.b localb = (com.tencent.mm.plugin.exdevice.h.b)localIterator.next();
          if ((localLinkedList.isEmpty()) || (!bk.pm(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.juE.Bt(localb.field_deviceID)) {
            break label262;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.bJN.bJL = localJSONArray;
        paramb.bJN.bJy = true;
        y.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        return true;
      }
    }
  }
  
  final boolean f(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (dn)paramb;
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.bJU.bJw, paramb.bJU.bwK, Integer.valueOf(paramb.bJU.type) });
    Object localObject2 = new agj();
    ((agj)localObject2).tea = paramb.bJU.type;
    ((agj)localObject2).teb = 0;
    ((agj)localObject2).sAL = new aop();
    ((agj)localObject2).sAL.hQb = paramb.bJU.bwK;
    ((agj)localObject2).sAL.syI = paramb.bJU.bJw;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramb);
    localObject1 = new z((LinkedList)localObject1, paramb.bJU.bJw, paramb.bJU.bJW);
    au.Dk().a(543, (com.tencent.mm.ah.f)localObject2);
    if (!au.Dk().a((com.tencent.mm.ah.m)localObject1, 0))
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      au.Dk().b(543, (com.tencent.mm.ah.f)localObject2);
      paramb.bJV.bJX = true;
      paramb.bJV.bJY = null;
      if (paramb.bFJ != null) {
        paramb.bFJ.run();
      }
      return true;
    }
    return false;
  }
  
  final boolean f(List<com.tencent.mm.plugin.exdevice.h.b> paramList, int paramInt)
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
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
        u.aMn().a((ae)localObject);
      }
      if (this.juG) {
        this.mHandler.removeCallbacks(this.juH);
      }
      this.juH = new e.c(this, paramList);
      this.mHandler.postDelayed(this.juH, 300000L);
      this.juG = true;
      paramInt = 2;
      continue;
      if (this.juG)
      {
        this.mHandler.removeCallbacks(this.juH);
        this.juG = false;
      }
      paramInt = 0;
    }
    return true;
  }
  
  final boolean g(com.tencent.mm.sdk.b.b paramb)
  {
    paramb = (ed)paramb;
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.bKD.bJw, Boolean.valueOf(paramb.bKD.bJx), Integer.valueOf(paramb.bKD.bKF) });
    int j = paramb.bKD.bKF;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.f.a.e.a.cP(com.tencent.mm.sdk.platformtools.ae.getContext())) {
          break label185;
        }
        y.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.bKD.bJx)
    {
      localaa = aa.aLI();
      ??? = paramb.bKD.bJw;
      localObject2 = new e.37(this);
      y.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (bk.bl((String)???)) {
        y.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramb.bKE.bJy = true;
      return true;
      label185:
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.bKE.bJy = false;
      return false;
      localaa.juL = ((String)???);
      localaa.jwf = ((aa.a)localObject2);
      localaa.jwg.clear();
      ??? = localaa.jwh.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (com.tencent.mm.ah.m)((Iterator)???).next();
        if (localObject2 != null) {
          au.Dk().c((com.tencent.mm.ah.m)localObject2);
        }
      }
      localaa.jwh.clear();
      synchronized (aa.bjn)
      {
        aa.jwi.clear();
        if (!localaa.jvr)
        {
          localaa.jvr = true;
          au.Dk().a(542, localaa);
          ad.aLS().a(i, localaa);
          y.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.fqP.S(12000L, 12000L);
        }
      }
      y.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.aLI().qp(i);
    }
  }
  
  public final void m(String paramString1, String paramString2, boolean paramBoolean)
  {
    LinkedList localLinkedList;
    synchronized (this.jtP)
    {
      localLinkedList = new LinkedList(this.jtP);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).n(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.jtQ.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((e.b)((Iterator)???).next()).n(paramString1, paramString2, paramBoolean);
    }
    y.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new ep();
    ((ep)???).bLf.bKZ = paramString1;
    ((ep)???).bLf.mac = paramString2;
    ((ep)???).bLf.aES = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
  }
  
  public final boolean n(String paramString, byte[] paramArrayOfByte)
  {
    if ((bk.bl(paramString)) || (bk.bE(paramArrayOfByte)))
    {
      if (bk.bl(paramString))
      {
        paramString = "null";
        if (!bk.bE(paramArrayOfByte)) {
          break label67;
        }
      }
      label67:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (bk.bl(paramString))
    {
      str = "null";
      if (!bk.bE(paramArrayOfByte)) {
        break label158;
      }
    }
    long l;
    label158:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.j.b.BU(paramString);
      paramString = ad.aLX().jvs.dU(l);
      if (paramString != null) {
        break label164;
      }
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      return false;
      str = paramString;
      break;
    }
    label164:
    if (paramString.bKp != 2)
    {
      y.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      return false;
    }
    ad.aLX();
    return h.a(l, paramArrayOfByte, new e.41(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */