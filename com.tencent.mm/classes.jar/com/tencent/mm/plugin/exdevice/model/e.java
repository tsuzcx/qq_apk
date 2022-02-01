package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.do;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.a;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.dz.a;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.a;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.eo;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ep.a;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.er.a;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.et.a;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.jq.b;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.c.di;
import com.tencent.mm.model.bc;
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
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private final long cJB;
  aq mHandler;
  public com.tencent.mm.sdk.b.c nKo;
  public com.tencent.mm.sdk.b.c qhA;
  public com.tencent.mm.sdk.b.c qhB;
  public com.tencent.mm.sdk.b.c qhC;
  public com.tencent.mm.sdk.b.c qhD;
  public com.tencent.mm.sdk.b.c qhE;
  public com.tencent.mm.sdk.b.c qhF;
  public com.tencent.mm.sdk.b.c qhG;
  public com.tencent.mm.sdk.b.c qhH;
  public com.tencent.mm.sdk.b.c qhI;
  public com.tencent.mm.sdk.b.c qhJ;
  public com.tencent.mm.sdk.b.c qhK;
  public com.tencent.mm.sdk.b.c qhL;
  public com.tencent.mm.sdk.b.c qhM;
  public com.tencent.mm.sdk.b.c qhN;
  public com.tencent.mm.sdk.b.c qhO;
  public com.tencent.mm.sdk.b.c qhP;
  public com.tencent.mm.sdk.b.c qhQ;
  public com.tencent.mm.sdk.b.c qhR;
  public com.tencent.mm.sdk.b.c qhS;
  public com.tencent.mm.sdk.b.c qhT;
  public com.tencent.mm.sdk.b.c qhU;
  public com.tencent.mm.sdk.b.c qhV;
  public com.tencent.mm.sdk.b.c qhW;
  public com.tencent.mm.sdk.b.c qhX;
  public com.tencent.mm.sdk.b.c qhY;
  public com.tencent.mm.sdk.b.c qhZ;
  List<b> qhv;
  Map<String, b> qhw;
  public com.tencent.mm.sdk.b.c qhx;
  public com.tencent.mm.sdk.b.c qhy;
  public com.tencent.mm.sdk.b.c qhz;
  public com.tencent.mm.sdk.b.c qia;
  public com.tencent.mm.sdk.b.c qib;
  public com.tencent.mm.sdk.b.c qic;
  public com.tencent.mm.sdk.b.c qid;
  public com.tencent.mm.sdk.b.c qie;
  public com.tencent.mm.sdk.b.c qif;
  public com.tencent.mm.sdk.b.c qig;
  public com.tencent.mm.sdk.b.c qih;
  public com.tencent.mm.sdk.b.c qii;
  public com.tencent.mm.sdk.b.c qij;
  ExdeviceWCLanSDKUtil qik;
  g qil;
  private boolean qim;
  private c qin;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.qhx = new com.tencent.mm.sdk.b.c() {};
    this.qhy = new com.tencent.mm.sdk.b.c() {};
    this.qhz = new com.tencent.mm.sdk.b.c() {};
    this.qhA = new com.tencent.mm.sdk.b.c() {};
    this.qhB = new com.tencent.mm.sdk.b.c() {};
    this.qhC = new com.tencent.mm.sdk.b.c() {};
    this.qhD = new com.tencent.mm.sdk.b.c() {};
    this.qhE = new com.tencent.mm.sdk.b.c() {};
    this.qhF = new com.tencent.mm.sdk.b.c() {};
    this.qhG = new com.tencent.mm.sdk.b.c() {};
    this.qhH = new e.3(this);
    this.qhI = new e.4(this);
    this.qhJ = new com.tencent.mm.sdk.b.c() {};
    this.qhK = new e.6(this);
    this.qhL = new e.7(this);
    this.qhM = new com.tencent.mm.sdk.b.c() {};
    this.qhN = new e.9(this);
    this.qhO = new e.10(this);
    this.qhP = new com.tencent.mm.sdk.b.c() {};
    this.qhQ = new com.tencent.mm.sdk.b.c() {};
    this.qhR = new com.tencent.mm.sdk.b.c() {};
    this.qhS = new com.tencent.mm.sdk.b.c() {};
    this.qhT = new com.tencent.mm.sdk.b.c() {};
    this.qhU = new com.tencent.mm.sdk.b.c() {};
    this.qhV = new com.tencent.mm.sdk.b.c() {};
    this.qhW = new e.19(this);
    this.qhX = new e.20(this);
    this.nKo = new com.tencent.mm.sdk.b.c() {};
    this.qhY = new e.22(this);
    this.qhZ = new com.tencent.mm.sdk.b.c() {};
    this.qia = new e.25(this);
    this.qib = new e.26(this);
    this.qic = new e.27(this);
    this.qid = new com.tencent.mm.sdk.b.c() {};
    this.qie = new e.29(this);
    this.qif = new e.30(this);
    this.qig = new e.31(this);
    this.qih = new e.32(this);
    this.qii = new e.33(this);
    this.qij = new e.35(this);
    this.cJB = 300000L;
    this.qim = false;
    this.qhv = new LinkedList();
    this.qhw = new HashMap();
    this.mHandler = new aq("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static int a(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(23290);
    int i = -1;
    if (bu.nullAsNil(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(23290);
      return i;
      if (bu.nullAsNil(paramb.field_connProto).contains("3")) {
        i = 0;
      }
    }
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (b)this.qhw.put(paramString, paramb);
    AppMethodBeat.o(23312);
    return paramString;
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.i.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23294);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      AppMethodBeat.o(23294);
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.cnk().uU(paramb.field_mac);
    if (locala == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.dqB == 2)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.cnl().a((ae)localObject);
    }
    Object localObject = ad.cmQ();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).CL(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.cmQ();
      long l = paramb.field_mac;
      localObject = (com.tencent.mm.sdk.platformtools.aw)((d)localObject).qhe.remove(Long.valueOf(l));
      if (localObject != null) {
        ((com.tencent.mm.sdk.platformtools.aw)localObject).stopTimer();
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.cnk().uY(locala.qmH)) || ((2 != locala.dqB) && (locala.dqB != 0)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.dqB), str });
        if (u.cnl().qgX != null) {
          u.cnl().qgX.va(locala.qmH);
        }
      }
      if (f.b(paramb))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        adk(com.tencent.mm.plugin.exdevice.k.b.vf(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.dqB) && (o.e.FbZ != null) && (o.e.FbZ.eOm()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    em localem = new em();
    localem.dqK.cVh = paramString;
    localem.dqK.dpF = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.a(localem, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  static boolean adj(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.al.g.eX(paramString);
    if (paramString == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.bX(false);
    if ((paramString == null) || (paramString.KP() == null) || (!paramString.KP().KY()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean adk(String paramString)
  {
    AppMethodBeat.i(23301);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!cmv())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23301);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23301);
      return false;
    }
    ad.cmV();
    h.uI(com.tencent.mm.plugin.exdevice.k.b.adP(paramString));
    AppMethodBeat.o(23301);
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23304);
    Object localObject;
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)) || (bu.cF(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bu.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bu.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (bu.cF(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(23304);
        return false;
      }
    }
    String str;
    if (bu.isNullOrNil(paramString1))
    {
      localObject = "null";
      if (!bu.isNullOrNil(paramString2)) {
        break label226;
      }
      str = "null";
      label131:
      if (!bu.cF(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.k.b.adP(paramString1);
      localObject = ad.cmJ().ve(l);
      if (localObject != null) {
        break label238;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23304);
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label131;
    }
    label238:
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.aG(paramArrayOfByte);
    if (1L != paramString1.nWB)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.nWB) });
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
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.nYl, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    en localen = new en();
    localen.dqL.cVh = paramString1;
    localen.dqL.dpI = paramString2;
    localen.dqL.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.IvT.a(localen, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23288);
    paramb = (dy)paramb;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.dpV.dpI, paramb.dpV.context });
    LinkedList localLinkedList = ad.cmJ().adC(paramb.dpV.dpI);
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
          if (!u.cnk().uS(localb.field_mac)) {
            break label222;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.dpW.dpX = localJSONArray;
        paramb.dpW.dpK = true;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  static boolean cmt()
  {
    AppMethodBeat.i(23296);
    Object localObject = ad.cmJ().cnp();
    if (((LinkedList)localObject).isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ad.cmQ().CL(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(localb.field_brandName);
      if ((localan == null) || (!com.tencent.mm.contact.c.lO(localan.field_type)))
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.cmQ().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean cmu()
  {
    AppMethodBeat.i(23297);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.cmQ();
    d.kM(false);
    ad.cmQ().cms();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean cmv()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.d.a.e.a.et(ak.getContext()))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bNP())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean cmw()
  {
    AppMethodBeat.i(23300);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!cmv())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ad.cmV().cmz();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean cmx()
  {
    AppMethodBeat.i(23313);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = ak.getContext();
    try
    {
      ad.cmQ().cms();
      com.tencent.mm.br.d.n(new Intent(localContext, ExDeviceService.class), "exdevice");
      AppMethodBeat.o(23313);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23289);
    paramb = (et)paramb;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.dqU.dpI, paramb.dqU.cVh });
    if (bu.cF(paramb.dqU.data))
    {
      paramb.dqV.dpK = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ad.cmJ().adA(paramb.dqU.cVh);
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.dqV.dpK = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cnk().uS(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.dqV.dpK = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.cnk().uY(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.dqV.dpK = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (aa.cmG().qiX) {
      aa.cmG().CN(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramb.dqU.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.cnl().a((ae)localObject);
    paramb.dqV.dpK = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static void db(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    nz localnz = new nz();
    localnz.dCS.op = 1;
    localnz.dCS.dzQ = paramString;
    localnz.dCS.reason = paramInt;
    com.tencent.mm.sdk.b.a.IvT.a(localnz, Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    nz localnz = new nz();
    localnz.dCS.op = 2;
    localnz.dCS.dzQ = paramString1;
    localnz.dCS.dqB = paramInt;
    localnz.dCS.url = paramString2;
    localnz.dCS.cVh = paramString3;
    com.tencent.mm.sdk.b.a.IvT.a(localnz, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean n(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23286);
    String str = Uri.parse(paramString).getHost();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
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
        paramList = ((di)localObject).fhE;
        localObject = ((di)localObject).fhF;
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
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
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
    Object localObject = new jq();
    ((jq)localObject).dxy.dqc = paramString;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jq)localObject).dxz.dxA;
    int i = ((TimeLineObject)localObject).HUG.Gtw;
    boolean bool;
    if (i == 1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fhE;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      AppMethodBeat.o(23287);
      return bool;
      bool = false;
      continue;
      if (i == 4)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fhE;
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).fhE;
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
        bool = n(((TimeLineObject)localObject).HUG.Url, paramList);
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
    if (this.qhv.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.qhv.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aM(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.al.g.eX(paramString);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).bX(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).KP();
      if ((localObject2 != null) && (((c.b.b)localObject2).KY())) {}
    }
    else
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ad.cmJ().adC(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).cRO == 1)
    {
      localObject2 = ad.cmJ().cnp();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((di)localObject3).fhD) });
          if (0L != (((di)localObject3).fhD & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      AppMethodBeat.o(23298);
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (bu.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("4"))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy) });
        }
        else if (bu.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.d.a.e.a.bNN())
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
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
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.cmQ();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).qhf.containsKey(Long.valueOf(l)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (com.tencent.mm.sdk.platformtools.aw)((d)localObject3).qhf.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((com.tencent.mm.sdk.platformtools.aw)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.cnk().uS(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.cnk().uY(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              e(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bu.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.et(ak.getContext()))
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label495;
              label780:
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.eJ(ak.getContext()))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          adl(com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ad.cmQ().CL(1);
        ad.cmQ().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cmQ().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          adl(com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cmQ().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cmQ().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          adk(com.tencent.mm.plugin.exdevice.k.b.vf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cmQ();
        d.uI(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.bNP())
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          db(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.et(ak.getContext())))
        {
          db(paramString, 1);
          continue;
          db(paramString, -1);
        }
      }
      label1357:
      k = -1;
      m = j;
      j = i;
      i = m;
    }
  }
  
  public final boolean adl(String paramString)
  {
    AppMethodBeat.i(23302);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!cmv())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23302);
      return false;
    }
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23302);
      return false;
    }
    ad.cmV().a(com.tencent.mm.plugin.exdevice.k.b.adP(paramString), new h.a()
    {
      public final void a(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23272);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = e.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.vf(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((e)localObject1).qhv)
        {
          localLinkedList = new LinkedList(((e)localObject1).qhv);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((e.b)((Iterator)???).next()).d(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        localLinkedList.clear();
        localObject1 = ((e)localObject1).qhw.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).d(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new fb();
        ((fb)localObject1).drp.mac = str2;
        ((fb)localObject1).drp.dqB = paramAnonymousInt2;
        ((fb)localObject1).drp.drm = paramAnonymousLong2;
        com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
        AppMethodBeat.o(23272);
      }
    });
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean b(b paramb)
  {
    AppMethodBeat.i(23311);
    if (this.qhv.remove(paramb))
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
    paramb = (dz)paramb;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.dpY.dpI, paramb.dpY.context });
    if (!adj(paramb.dpY.dpI))
    {
      paramb.dpZ.dpX = null;
      paramb.dpZ.dpK = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ad.cmJ().adC(paramb.dpY.dpI);
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
          if ((localLinkedList.isEmpty()) || (!bu.nullAsNil(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.qik.adn(localb.field_deviceID)) {
            break label280;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.dpZ.dpX = localJSONArray;
        paramb.dpZ.dpK = true;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23291);
    paramb = (eb)paramb;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.dqg.dpI, paramb.dqg.cVh, Integer.valueOf(paramb.dqg.type) });
    Object localObject2 = new bcq();
    ((bcq)localObject2).GSm = paramb.dqg.type;
    ((bcq)localObject2).GSn = 0;
    ((bcq)localObject2).FVo = new bob();
    ((bcq)localObject2).FVo.nIM = paramb.dqg.cVh;
    ((bcq)localObject2).FVo.FSh = paramb.dqg.dpI;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new e.36(this, paramb);
    localObject1 = new z((LinkedList)localObject1, paramb.dqg.dpI, paramb.dqg.dqi);
    bc.ajj().a(543, (com.tencent.mm.ak.f)localObject2);
    if (!bc.ajj().a((n)localObject1, 0))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      bc.ajj().b(543, (com.tencent.mm.ak.f)localObject2);
      paramb.dqh.dqj = true;
      paramb.dqh.dqk = null;
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
    paramb = (er)paramb;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.dqP.dpI, Boolean.valueOf(paramb.dqP.dpJ), Integer.valueOf(paramb.dqP.dqR) });
    int j = paramb.dqP.dqR;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.et(ak.getContext())) {
          break label197;
        }
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.dqP.dpJ)
    {
      localaa = aa.cmG();
      ??? = paramb.dqP.dpI;
      localObject2 = new aa.a()
      {
        public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23269);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramAnonymousString });
          if (paramAnonymousArrayOfByte == null) {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          }
          for (;;)
          {
            eo localeo = new eo();
            localeo.dqM.dqE = paramAnonymousArrayOfByte;
            localeo.dqM.cVh = paramAnonymousString;
            localeo.dqM.bsb = paramAnonymousBoolean;
            com.tencent.mm.sdk.b.a.IvT.a(localeo, Looper.getMainLooper());
            AppMethodBeat.o(23269);
            return;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramAnonymousString, Base64.encodeToString(paramAnonymousArrayOfByte, 0), Boolean.valueOf(paramAnonymousBoolean) });
          }
        }
      };
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (bu.isNullOrNil((String)???)) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramb.dqQ.dpK = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.dqQ.dpK = false;
      AppMethodBeat.o(23292);
      return false;
      localaa.qir = ((String)???);
      localaa.qjK = ((aa.a)localObject2);
      localaa.qjL.clear();
      ??? = localaa.qjM.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (n)((Iterator)???).next();
        if (localObject2 != null) {
          bc.ajj().a((n)localObject2);
        }
      }
      localaa.qjM.clear();
      synchronized (aa.ddM)
      {
        aa.qjN.clear();
        if (!localaa.qiX)
        {
          localaa.qiX = true;
          bc.ajj().a(542, localaa);
          ad.cmQ().a(i, localaa);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.jnx.ay(12000L, 12000L);
        }
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.cmG().CN(i);
    }
  }
  
  public final void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23305);
    LinkedList localLinkedList;
    synchronized (this.qhv)
    {
      localLinkedList = new LinkedList(this.qhv);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.qhw.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new fd();
    ((fd)???).drr.drl = paramString1;
    ((fd)???).drr.mac = paramString2;
    ((fd)???).drr.bsb = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  final boolean n(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
  {
    AppMethodBeat.i(23295);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
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
        u.cnl().a((ae)localObject);
      }
      if (this.qim) {
        this.mHandler.removeCallbacks(this.qin);
      }
      this.qin = new c(paramList);
      this.mHandler.postDelayed(this.qin, 300000L);
      this.qim = true;
      paramInt = 2;
      continue;
      if (this.qim)
      {
        this.mHandler.removeCallbacks(this.qin);
        this.qim = false;
      }
      paramInt = 0;
    }
    AppMethodBeat.o(23295);
    return true;
  }
  
  public final boolean o(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23303);
    if ((bu.isNullOrNil(paramString)) || (bu.cF(paramArrayOfByte)))
    {
      if (bu.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!bu.cF(paramArrayOfByte)) {
          break label79;
        }
      }
      label79:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(23303);
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (bu.isNullOrNil(paramString))
    {
      str = "null";
      if (!bu.cF(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.k.b.adP(paramString);
      paramString = ad.cmV().qiY.uV(l);
      if (paramString != null) {
        break label182;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23303);
      return false;
      str = paramString;
      break;
    }
    label182:
    if (paramString.dqB != 2)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ad.cmV();
    boolean bool = h.a(l, paramArrayOfByte, new t.a()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(23273);
        Object localObject1 = paramAnonymousString;
        if (paramAnonymousString == null) {
          localObject1 = "null";
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localObject1 });
        localObject1 = e.this;
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.vf(paramAnonymousLong);
        boolean bool;
        if (paramAnonymousInt2 == 0) {
          bool = true;
        }
        LinkedList localLinkedList;
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (bool) {
            break label250;
          }
          synchronized (((e)localObject1).qhv)
          {
            localLinkedList = new LinkedList(((e)localObject1).qhv);
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
        localObject1 = ((e)localObject1).qhw.values().iterator();
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
    private String cPk;
    private String mURL;
    private String qir;
    private String qis;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.qir = paramString1;
      this.cPk = paramString2;
      this.mURL = paramString3;
      this.qis = paramString4;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.cPk == null) || (!this.cPk.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.cPk, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.cmU();
          if (!e.b(this.cPk, this.qir, paramArrayOfByte))
          {
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
            AppMethodBeat.o(23281);
            return;
          }
          AppMethodBeat.o(23281);
          return;
        }
        catch (Exception paramString)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
        }
      }
      AppMethodBeat.o(23281);
    }
    
    public final void d(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.cPk == null) || (!this.cPk.equals(paramString)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.cPk, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.e(this.qir, this.mURL, -1, this.qis);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.e(this.qir, this.mURL, 2, this.qis);
        paramString = new com.tencent.mm.plugin.d.a.b.a.f();
        paramString.nXh = com.tencent.mm.plugin.d.a.b.a.f.nYj;
        paramString.nXi = 2;
        ad.cmU().o(this.cPk, com.tencent.mm.plugin.exdevice.k.b.cX(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.e(this.qir, this.mURL, 1, this.qis);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.e(this.qir, this.mURL, 4, this.qis);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.e(this.qir, this.mURL, 0, this.qis);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void o(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.cPk == null) || (!this.cPk.equals(paramString2)))
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.cPk, paramString2, Boolean.valueOf(paramBoolean) });
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
    List<com.tencent.mm.plugin.exdevice.i.b> hMd;
    
    public c()
    {
      Object localObject;
      this.hMd = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23283);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
      if ((this.hMd != null) && (this.hMd.size() > 0))
      {
        Iterator localIterator = this.hMd.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, 1);
          u.cnl().a((ae)localObject);
        }
        e.this.mHandler.postDelayed(this, 300000L);
      }
      AppMethodBeat.o(23283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */