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
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dt.a;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.du.a;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dw.a;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.ek.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.em.a;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.eo.a;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.ja.b;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.us;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.j.j;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.n.c.a;
import com.tencent.mm.pluginsdk.n.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private final long cAO;
  public com.tencent.mm.sdk.b.c mCv;
  ap mHandler;
  public com.tencent.mm.sdk.b.c oUA;
  public com.tencent.mm.sdk.b.c oUB;
  public com.tencent.mm.sdk.b.c oUC;
  public com.tencent.mm.sdk.b.c oUD;
  public com.tencent.mm.sdk.b.c oUE;
  public com.tencent.mm.sdk.b.c oUF;
  public com.tencent.mm.sdk.b.c oUG;
  public com.tencent.mm.sdk.b.c oUH;
  public com.tencent.mm.sdk.b.c oUI;
  public com.tencent.mm.sdk.b.c oUJ;
  public com.tencent.mm.sdk.b.c oUK;
  public com.tencent.mm.sdk.b.c oUL;
  public com.tencent.mm.sdk.b.c oUM;
  public com.tencent.mm.sdk.b.c oUN;
  public com.tencent.mm.sdk.b.c oUO;
  ExdeviceWCLanSDKUtil oUP;
  g oUQ;
  private boolean oUR;
  private e.c oUS;
  List<e.b> oUa;
  Map<String, e.b> oUb;
  public com.tencent.mm.sdk.b.c oUc;
  public com.tencent.mm.sdk.b.c oUd;
  public com.tencent.mm.sdk.b.c oUe;
  public com.tencent.mm.sdk.b.c oUf;
  public com.tencent.mm.sdk.b.c oUg;
  public com.tencent.mm.sdk.b.c oUh;
  public com.tencent.mm.sdk.b.c oUi;
  public com.tencent.mm.sdk.b.c oUj;
  public com.tencent.mm.sdk.b.c oUk;
  public com.tencent.mm.sdk.b.c oUl;
  public com.tencent.mm.sdk.b.c oUm;
  public com.tencent.mm.sdk.b.c oUn;
  public com.tencent.mm.sdk.b.c oUo;
  public com.tencent.mm.sdk.b.c oUp;
  public com.tencent.mm.sdk.b.c oUq;
  public com.tencent.mm.sdk.b.c oUr;
  public com.tencent.mm.sdk.b.c oUs;
  public com.tencent.mm.sdk.b.c oUt;
  public com.tencent.mm.sdk.b.c oUu;
  public com.tencent.mm.sdk.b.c oUv;
  public com.tencent.mm.sdk.b.c oUw;
  public com.tencent.mm.sdk.b.c oUx;
  public com.tencent.mm.sdk.b.c oUy;
  public com.tencent.mm.sdk.b.c oUz;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.oUc = new com.tencent.mm.sdk.b.c() {};
    this.oUd = new com.tencent.mm.sdk.b.c() {};
    this.oUe = new com.tencent.mm.sdk.b.c() {};
    this.oUf = new com.tencent.mm.sdk.b.c() {};
    this.oUg = new com.tencent.mm.sdk.b.c() {};
    this.oUh = new com.tencent.mm.sdk.b.c() {};
    this.oUi = new com.tencent.mm.sdk.b.c() {};
    this.oUj = new com.tencent.mm.sdk.b.c() {};
    this.oUk = new com.tencent.mm.sdk.b.c() {};
    this.oUl = new e.2(this);
    this.oUm = new e.3(this);
    this.oUn = new e.4(this);
    this.oUo = new com.tencent.mm.sdk.b.c() {};
    this.oUp = new e.6(this);
    this.oUq = new e.7(this);
    this.oUr = new com.tencent.mm.sdk.b.c() {};
    this.oUs = new e.9(this);
    this.oUt = new e.10(this);
    this.oUu = new com.tencent.mm.sdk.b.c() {};
    this.oUv = new com.tencent.mm.sdk.b.c() {};
    this.oUw = new com.tencent.mm.sdk.b.c() {};
    this.oUx = new com.tencent.mm.sdk.b.c() {};
    this.oUy = new com.tencent.mm.sdk.b.c() {};
    this.oUz = new com.tencent.mm.sdk.b.c() {};
    this.oUA = new com.tencent.mm.sdk.b.c() {};
    this.oUB = new e.19(this);
    this.oUC = new e.20(this);
    this.mCv = new com.tencent.mm.sdk.b.c() {};
    this.oUD = new e.22(this);
    this.oUE = new com.tencent.mm.sdk.b.c() {};
    this.oUF = new e.25(this);
    this.oUG = new e.26(this);
    this.oUH = new e.27(this);
    this.oUI = new com.tencent.mm.sdk.b.c() {};
    this.oUJ = new com.tencent.mm.sdk.b.c() {};
    this.oUK = new e.30(this);
    this.oUL = new e.31(this);
    this.oUM = new e.32(this);
    this.oUN = new e.33(this);
    this.oUO = new e.35(this);
    this.cAO = 300000L;
    this.oUR = false;
    this.oUa = new LinkedList();
    this.oUb = new HashMap();
    this.mHandler = new ap("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static boolean UA(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.am.f.ei(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.bU(false);
    if ((paramString == null) || (paramString.Jy() == null) || (!paramString.Jy().JI()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean UB(String paramString)
  {
    AppMethodBeat.i(23301);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!bZs())
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
    ad.bZS();
    h.oH(com.tencent.mm.plugin.exdevice.k.b.Vg(paramString));
    AppMethodBeat.o(23301);
    return true;
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
  
  private e.b a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (e.b)this.oUb.put(paramString, paramb);
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
    f.a locala = u.cah().oT(paramb.field_mac);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.dgF == 2)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.cai().a((ae)localObject);
    }
    Object localObject = ad.bZN();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).AY(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.bZN();
      long l = paramb.field_mac;
      localObject = (av)((d)localObject).oTJ.remove(Long.valueOf(l));
      if (localObject != null) {
        ((av)localObject).stopTimer();
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.cah().oX(locala.oZm)) || ((2 != locala.dgF) && (locala.dgF != 0)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.dgF), str });
        if (u.cai().oTC != null) {
          u.cai().oTC.oZ(locala.oZm);
        }
      }
      if (f.b(paramb))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        UB(com.tencent.mm.plugin.exdevice.k.b.pe(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.dgF) && (n.e.BNv != null) && (n.e.BNv.ehe()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    eh localeh = new eh();
    localeh.dgO.cLR = paramString;
    localeh.dgO.dfJ = paramBoolean;
    com.tencent.mm.sdk.b.a.ESL.a(localeh, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  public static boolean b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23304);
    Object localObject;
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.cw(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bt.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (bt.cw(paramArrayOfByte)) {}
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
      if (!bt.cw(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.k.b.Vg(paramString1);
      localObject = ad.bZG().pd(l);
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
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.aH(paramArrayOfByte);
    if (1L != paramString1.mNN)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.mNN) });
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
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.mPx, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  static boolean bZq()
  {
    AppMethodBeat.i(23296);
    Object localObject = ad.bZG().cam();
    if (((LinkedList)localObject).isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ad.bZN().AY(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      az.arV();
      af localaf = com.tencent.mm.model.c.apM().aHY(localb.field_brandName);
      if ((localaf == null) || (!com.tencent.mm.n.b.ls(localaf.field_type)))
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
        ad.bZN().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean bZr()
  {
    AppMethodBeat.i(23297);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.bZN();
    d.jX(false);
    ad.bZN().bZp();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean bZs()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.d.a.e.a.eh(aj.getContext()))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bBG())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean bZt()
  {
    AppMethodBeat.i(23300);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!bZs())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ad.bZS().bZw();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean bZu()
  {
    AppMethodBeat.i(23313);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = aj.getContext();
    try
    {
      ad.bZN().bZp();
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
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    ei localei = new ei();
    localei.dgP.cLR = paramString1;
    localei.dgP.dfM = paramString2;
    localei.dgP.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.ESL.a(localei, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23288);
    paramb = (dt)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.dfZ.dfM, paramb.dfZ.context });
    LinkedList localLinkedList = ad.bZG().UT(paramb.dfZ.dfM);
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
          if (!u.cah().oR(localb.field_mac)) {
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
        paramb.dga.dgb = localJSONArray;
        paramb.dga.dfO = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  public static void cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    nh localnh = new nh();
    localnh.dsp.op = 1;
    localnh.dsp.dpn = paramString;
    localnh.dsp.bvJ = paramInt;
    com.tencent.mm.sdk.b.a.ESL.a(localnh, Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    nh localnh = new nh();
    localnh.dsp.op = 2;
    localnh.dsp.dpn = paramString1;
    localnh.dsp.dgF = paramInt;
    localnh.dsp.url = paramString2;
    localnh.dsp.cLR = paramString3;
    com.tencent.mm.sdk.b.a.ESL.a(localnh, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23289);
    paramb = (eo)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.dgY.dfM, paramb.dgY.cLR });
    if (bt.cw(paramb.dgY.data))
    {
      paramb.dgZ.dfO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ad.bZG().UR(paramb.dgY.cLR);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.dgZ.dfO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cah().oR(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.dgZ.dfO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cah().oX(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.dgZ.dfO = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (aa.bZD().oVC) {
      aa.bZD().Ba(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramb.dgY.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.cai().a((ae)localObject);
    paramb.dgZ.dfO = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  static boolean o(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
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
        paramList = ((cw)localObject).eKt;
        localObject = ((cw)localObject).eKu;
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
  
  static boolean p(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23287);
    if (paramString == null)
    {
      AppMethodBeat.o(23287);
      return false;
    }
    Object localObject = new ja();
    ((ja)localObject).dmY.dgg = paramString;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((ja)localObject).dmZ.dna;
    int i = ((TimeLineObject)localObject).Etm.DaB;
    boolean bool;
    if (i == 1)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eKt;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eKt;
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
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eKt;
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
        bool = o(((TimeLineObject)localObject).Etm.Url, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean UC(String paramString)
  {
    AppMethodBeat.i(23302);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!bZs())
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
    ad.bZS().a(com.tencent.mm.plugin.exdevice.k.b.Vg(paramString), new e.40(this));
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean a(e.b paramb)
  {
    AppMethodBeat.i(23310);
    if (this.oUa.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.oUa.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.am.f.ei(paramString);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).bU(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).Jy();
      if ((localObject2 != null) && (((c.b.b)localObject2).JI())) {}
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ad.bZG().UT(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).cIS == 1)
    {
      localObject2 = ad.bZG().cam();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((cw)localObject3).eKs) });
          if (0L != (((cw)localObject3).eKs & 1L)) {
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
          if (!com.tencent.mm.plugin.d.a.e.a.bBE())
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
        localObject3 = ad.bZN();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).oTK.containsKey(Long.valueOf(l)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (av)((d)localObject3).oTK.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((av)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.cah().oR(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.cah().oX(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              d(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.eh(aj.getContext()))
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
        if (!com.tencent.mm.plugin.exdevice.service.d.ex(aj.getContext()))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          UC(com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ad.bZN().AY(1);
        ad.bZN().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.bZN().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          UC(com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.bZN().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.bZN().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          UB(com.tencent.mm.plugin.exdevice.k.b.pe(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.bZN();
        d.oH(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.bBG())
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          cP(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.eh(aj.getContext())))
        {
          cP(paramString, 1);
          continue;
          cP(paramString, -1);
        }
      }
      label1357:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean b(e.b paramb)
  {
    AppMethodBeat.i(23311);
    if (this.oUa.remove(paramb))
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
    paramb = (du)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.dgc.dfM, paramb.dgc.context });
    if (!UA(paramb.dgc.dfM))
    {
      paramb.dgd.dgb = null;
      paramb.dgd.dfO = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ad.bZG().UT(paramb.dgc.dfM);
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
          if (!this.oUP.UE(localb.field_deviceID)) {
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
        paramb.dgd.dgb = localJSONArray;
        paramb.dgd.dfO = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23291);
    paramb = (dw)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.dgk.dfM, paramb.dgk.cLR, Integer.valueOf(paramb.dgk.type) });
    Object localObject2 = new aus();
    ((aus)localObject2).Dus = paramb.dgk.type;
    ((aus)localObject2).Dut = 0;
    ((aus)localObject2).CEX = new bfj();
    ((aus)localObject2).CEX.mAT = paramb.dgk.cLR;
    ((aus)localObject2).CEX.CBS = paramb.dgk.dfM;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramb);
    localObject1 = new z((LinkedList)localObject1, paramb.dgk.dfM, paramb.dgk.dgm);
    az.aeS().a(543, (com.tencent.mm.al.g)localObject2);
    if (!az.aeS().a((n)localObject1, 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      az.aeS().b(543, (com.tencent.mm.al.g)localObject2);
      paramb.dgl.dgn = true;
      paramb.dgl.dgo = null;
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
    paramb = (em)paramb;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.dgT.dfM, Boolean.valueOf(paramb.dgT.dfN), Integer.valueOf(paramb.dgT.dgV) });
    int j = paramb.dgT.dgV;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.eh(aj.getContext())) {
          break label197;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.dgT.dfN)
    {
      localaa = aa.bZD();
      ??? = paramb.dgT.dfM;
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
            ej localej = new ej();
            localej.dgQ.dgI = paramAnonymousArrayOfByte;
            localej.dgQ.cLR = paramAnonymousString;
            localej.dgQ.bhb = paramAnonymousBoolean;
            com.tencent.mm.sdk.b.a.ESL.a(localej, Looper.getMainLooper());
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
      paramb.dgU.dfO = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.dgU.dfO = false;
      AppMethodBeat.o(23292);
      return false;
      localaa.oUW = ((String)???);
      localaa.oWp = ((aa.a)localObject2);
      localaa.oWq.clear();
      ??? = localaa.oWr.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (n)((Iterator)???).next();
        if (localObject2 != null) {
          az.aeS().a((n)localObject2);
        }
      }
      localaa.oWr.clear();
      synchronized (aa.cTX)
      {
        aa.oWs.clear();
        if (!localaa.oVC)
        {
          localaa.oVC = true;
          az.aeS().a(542, localaa);
          ad.bZN().a(i, localaa);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.irp.av(12000L, 12000L);
        }
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.bZD().Ba(i);
    }
  }
  
  final boolean m(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
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
        u.cai().a((ae)localObject);
      }
      if (this.oUR) {
        this.mHandler.removeCallbacks(this.oUS);
      }
      this.oUS = new e.c(this, paramList);
      this.mHandler.postDelayed(this.oUS, 300000L);
      this.oUR = true;
      paramInt = 2;
      continue;
      if (this.oUR)
      {
        this.mHandler.removeCallbacks(this.oUS);
        this.oUR = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.oUa)
    {
      localLinkedList = new LinkedList(this.oUa);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((e.b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.oUb.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((e.b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new ey();
    ((ey)???).dhv.dhp = paramString1;
    ((ey)???).dhv.mac = paramString2;
    ((ey)???).dhv.bhb = paramBoolean;
    com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  public final boolean n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23303);
    if ((bt.isNullOrNil(paramString)) || (bt.cw(paramArrayOfByte)))
    {
      if (bt.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!bt.cw(paramArrayOfByte)) {
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
      if (!bt.cw(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.k.b.Vg(paramString);
      paramString = ad.bZS().oVD.oU(l);
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
    if (paramString.dgF != 2)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ad.bZS();
    boolean bool = h.a(l, paramArrayOfByte, new e.41(this));
    AppMethodBeat.o(23303);
    return bool;
  }
  
  public final class a
    implements e.b
  {
    private String cGn;
    private String mURL;
    private String oUW;
    private String oUX;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.oUW = paramString1;
      this.cGn = paramString2;
      this.mURL = paramString3;
      this.oUX = paramString4;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.cGn == null) || (!this.cGn.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.cGn, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.bZR();
          if (!e.b(this.cGn, this.oUW, paramArrayOfByte))
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
    
    public final void c(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.cGn == null) || (!this.cGn.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.cGn, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.d(this.oUW, this.mURL, -1, this.oUX);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.d(this.oUW, this.mURL, 2, this.oUX);
        paramString = new com.tencent.mm.plugin.d.a.b.a.f();
        paramString.mOt = com.tencent.mm.plugin.d.a.b.a.f.mPv;
        paramString.mOu = 2;
        ad.bZR().n(this.cGn, com.tencent.mm.plugin.exdevice.k.b.cU(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.d(this.oUW, this.mURL, 1, this.oUX);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.d(this.oUW, this.mURL, 4, this.oUX);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.d(this.oUW, this.mURL, 0, this.oUX);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void o(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.cGn == null) || (!this.cGn.equals(paramString2)))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.cGn, paramString2, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23280);
        return;
      }
      AppMethodBeat.o(23280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */