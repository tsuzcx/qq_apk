package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.dp;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.du.a;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.a;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.a;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.g.a.ei;
import com.tencent.mm.g.a.ej;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.el.a;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.en.a;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.ep.a;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.jh.b;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.ld;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.vc;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.exdevice.j.j;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.t.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.n.c.a;
import com.tencent.mm.pluginsdk.n.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.aya;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
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
  private final long cxX;
  ao mHandler;
  public com.tencent.mm.sdk.b.c nex;
  public com.tencent.mm.sdk.b.c pxA;
  public com.tencent.mm.sdk.b.c pxB;
  public com.tencent.mm.sdk.b.c pxC;
  public com.tencent.mm.sdk.b.c pxD;
  public com.tencent.mm.sdk.b.c pxE;
  public com.tencent.mm.sdk.b.c pxF;
  public com.tencent.mm.sdk.b.c pxG;
  public com.tencent.mm.sdk.b.c pxH;
  public com.tencent.mm.sdk.b.c pxI;
  public com.tencent.mm.sdk.b.c pxJ;
  public com.tencent.mm.sdk.b.c pxK;
  public com.tencent.mm.sdk.b.c pxL;
  public com.tencent.mm.sdk.b.c pxM;
  public com.tencent.mm.sdk.b.c pxN;
  public com.tencent.mm.sdk.b.c pxO;
  public com.tencent.mm.sdk.b.c pxP;
  public com.tencent.mm.sdk.b.c pxQ;
  public com.tencent.mm.sdk.b.c pxR;
  public com.tencent.mm.sdk.b.c pxS;
  public com.tencent.mm.sdk.b.c pxT;
  public com.tencent.mm.sdk.b.c pxU;
  public com.tencent.mm.sdk.b.c pxV;
  public com.tencent.mm.sdk.b.c pxW;
  public com.tencent.mm.sdk.b.c pxX;
  public com.tencent.mm.sdk.b.c pxY;
  public com.tencent.mm.sdk.b.c pxZ;
  List<b> pxl;
  Map<String, b> pxm;
  public com.tencent.mm.sdk.b.c pxn;
  public com.tencent.mm.sdk.b.c pxo;
  public com.tencent.mm.sdk.b.c pxp;
  public com.tencent.mm.sdk.b.c pxq;
  public com.tencent.mm.sdk.b.c pxr;
  public com.tencent.mm.sdk.b.c pxs;
  public com.tencent.mm.sdk.b.c pxt;
  public com.tencent.mm.sdk.b.c pxu;
  public com.tencent.mm.sdk.b.c pxv;
  public com.tencent.mm.sdk.b.c pxw;
  public com.tencent.mm.sdk.b.c pxx;
  public com.tencent.mm.sdk.b.c pxy;
  public com.tencent.mm.sdk.b.c pxz;
  ExdeviceWCLanSDKUtil pya;
  g pyb;
  private boolean pyc;
  private c pyd;
  
  public e()
  {
    AppMethodBeat.i(23284);
    this.pxn = new com.tencent.mm.sdk.b.c() {};
    this.pxo = new com.tencent.mm.sdk.b.c() {};
    this.pxp = new com.tencent.mm.sdk.b.c() {};
    this.pxq = new e.34(this);
    this.pxr = new com.tencent.mm.sdk.b.c() {};
    this.pxs = new com.tencent.mm.sdk.b.c() {};
    this.pxt = new com.tencent.mm.sdk.b.c() {};
    this.pxu = new com.tencent.mm.sdk.b.c() {};
    this.pxv = new com.tencent.mm.sdk.b.c() {};
    this.pxw = new com.tencent.mm.sdk.b.c() {};
    this.pxx = new com.tencent.mm.sdk.b.c() {};
    this.pxy = new com.tencent.mm.sdk.b.c() {};
    this.pxz = new com.tencent.mm.sdk.b.c() {};
    this.pxA = new com.tencent.mm.sdk.b.c() {};
    this.pxB = new com.tencent.mm.sdk.b.c() {};
    this.pxC = new com.tencent.mm.sdk.b.c() {};
    this.pxD = new com.tencent.mm.sdk.b.c() {};
    this.pxE = new com.tencent.mm.sdk.b.c() {};
    this.pxF = new com.tencent.mm.sdk.b.c() {};
    this.pxG = new com.tencent.mm.sdk.b.c() {};
    this.pxH = new com.tencent.mm.sdk.b.c() {};
    this.pxI = new com.tencent.mm.sdk.b.c() {};
    this.pxJ = new com.tencent.mm.sdk.b.c() {};
    this.pxK = new e.17(this);
    this.pxL = new com.tencent.mm.sdk.b.c() {};
    this.pxM = new com.tencent.mm.sdk.b.c() {};
    this.pxN = new com.tencent.mm.sdk.b.c() {};
    this.nex = new com.tencent.mm.sdk.b.c() {};
    this.pxO = new com.tencent.mm.sdk.b.c() {};
    this.pxP = new com.tencent.mm.sdk.b.c() {};
    this.pxQ = new com.tencent.mm.sdk.b.c() {};
    this.pxR = new e.26(this);
    this.pxS = new com.tencent.mm.sdk.b.c() {};
    this.pxT = new com.tencent.mm.sdk.b.c() {};
    this.pxU = new com.tencent.mm.sdk.b.c() {};
    this.pxV = new com.tencent.mm.sdk.b.c() {};
    this.pxW = new com.tencent.mm.sdk.b.c() {};
    this.pxX = new com.tencent.mm.sdk.b.c() {};
    this.pxY = new com.tencent.mm.sdk.b.c() {};
    this.pxZ = new com.tencent.mm.sdk.b.c() {};
    this.cxX = 300000L;
    this.pyc = false;
    this.pxl = new LinkedList();
    this.pxm = new HashMap();
    this.mHandler = new ao("wifi_device_heart_beat");
    AppMethodBeat.o(23284);
  }
  
  static boolean YM(String paramString)
  {
    AppMethodBeat.i(23293);
    paramString = com.tencent.mm.al.f.dX(paramString);
    if (paramString == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23293);
      return false;
    }
    paramString = paramString.bV(false);
    if ((paramString == null) || (paramString.Jh() == null) || (!paramString.Jh().Jr()))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23293);
      return false;
    }
    AppMethodBeat.o(23293);
    return true;
  }
  
  public static boolean YN(String paramString)
  {
    AppMethodBeat.i(23301);
    ac.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[] { paramString });
    if (!cgB())
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23301);
      return false;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23301);
      return false;
    }
    ad.chb();
    h.st(com.tencent.mm.plugin.exdevice.k.b.Zs(paramString));
    AppMethodBeat.o(23301);
    return true;
  }
  
  static int a(com.tencent.mm.plugin.exdevice.i.b paramb)
  {
    AppMethodBeat.i(23290);
    int i = -1;
    if (bs.nullAsNil(paramb.field_connProto).contains("1")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(23290);
      return i;
      if (bs.nullAsNil(paramb.field_connProto).contains("3")) {
        i = 0;
      }
    }
  }
  
  private b a(String paramString, b paramb)
  {
    AppMethodBeat.i(23312);
    paramString = (b)this.pxm.put(paramString, paramb);
    AppMethodBeat.o(23312);
    return paramString;
  }
  
  static boolean a(com.tencent.mm.plugin.exdevice.i.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23294);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
    if (paramb == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
      AppMethodBeat.o(23294);
      return false;
    }
    String str = paramb.field_brandName;
    f.a locala = u.chq().sF(paramb.field_mac);
    if (locala == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23294);
      return false;
    }
    if (locala.dea == 2)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[] { str });
      localObject = new j(paramInt1, paramInt2, paramb.field_mac);
      u.chr().a((ae)localObject);
    }
    Object localObject = ad.cgW();
    if (paramInt1 == 1) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      ((d)localObject).BQ(paramInt2);
      if (paramInt1 != 2) {
        break;
      }
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
      localObject = ad.cgW();
      long l = paramb.field_mac;
      localObject = (au)((d)localObject).pwU.remove(Long.valueOf(l));
      if (localObject != null) {
        ((au)localObject).stopTimer();
      }
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[] { Integer.valueOf(paramb.field_closeStrategy) });
      if (((paramb.field_closeStrategy & 0x1) != 0) || (!u.chq().sJ(locala.pCx)) || ((2 != locala.dea) && (locala.dea != 0)))
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[] { Integer.valueOf(locala.dea), str });
        if (u.chr().pwN != null) {
          u.chr().pwN.sL(locala.pCx);
        }
      }
      if (f.b(paramb))
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[] { Long.valueOf(paramb.field_mac) });
        YN(com.tencent.mm.plugin.exdevice.k.b.sQ(paramb.field_mac));
      }
      AppMethodBeat.o(23294);
      return true;
    }
    if ((2 != locala.dea) && (n.e.DfF != null) && (n.e.DfF.ewy()))
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
      AppMethodBeat.o(23294);
      return false;
    }
    AppMethodBeat.o(23294);
    return true;
  }
  
  public static void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23309);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    ei localei = new ei();
    localei.dej.cIZ = paramString;
    localei.dej.dde = paramBoolean;
    com.tencent.mm.sdk.b.a.GpY.a(localei, Looper.getMainLooper());
    AppMethodBeat.o(23309);
  }
  
  public static boolean b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23304);
    Object localObject;
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)) || (bs.cv(paramArrayOfByte)))
    {
      localObject = paramString1;
      if (bs.isNullOrNil(paramString1)) {
        localObject = "null";
      }
      paramString1 = paramString2;
      if (bs.isNullOrNil(paramString2)) {
        paramString1 = "null";
      }
      if (bs.cv(paramArrayOfByte)) {}
      for (i = 0;; i = paramArrayOfByte.length)
      {
        ac.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, paramString1, Integer.valueOf(i) });
        AppMethodBeat.o(23304);
        return false;
      }
    }
    String str;
    if (bs.isNullOrNil(paramString1))
    {
      localObject = "null";
      if (!bs.isNullOrNil(paramString2)) {
        break label226;
      }
      str = "null";
      label131:
      if (!bs.cv(paramArrayOfByte)) {
        break label232;
      }
    }
    label226:
    label232:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", new Object[] { localObject, str, Integer.valueOf(i) });
      long l = com.tencent.mm.plugin.exdevice.k.b.Zs(paramString1);
      localObject = ad.cgP().sP(l);
      if (localObject != null) {
        break label238;
      }
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23304);
      return false;
      localObject = paramString1;
      break;
      str = paramString2;
      break label131;
    }
    label238:
    paramString1 = com.tencent.mm.plugin.d.a.b.a.a.aG(paramArrayOfByte);
    if (1L != paramString1.npZ)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[] { Long.valueOf(1L), Long.valueOf(paramString1.npZ) });
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
    ((com.tencent.mm.plugin.sport.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sport.a.b.class)).b(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, i, j, paramString1.nrJ, "");
    AppMethodBeat.o(23304);
    return true;
  }
  
  public static void c(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23308);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[] { paramString1, paramString2 });
    ej localej = new ej();
    localej.dek.cIZ = paramString1;
    localej.dek.ddh = paramString2;
    localej.dek.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.GpY.a(localej, Looper.getMainLooper());
    AppMethodBeat.o(23308);
  }
  
  static boolean c(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23288);
    paramb = (du)paramb;
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.ddu.ddh, paramb.ddu.context });
    LinkedList localLinkedList = ad.cgP().Zf(paramb.ddu.ddh);
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
          if (!u.chq().sD(localb.field_mac)) {
            break label222;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.ddv.ddw = localJSONArray;
        paramb.ddv.ddj = true;
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23288);
        return true;
      }
    }
  }
  
  public static void cU(String paramString, int paramInt)
  {
    AppMethodBeat.i(23307);
    nq localnq = new nq();
    localnq.dqa.op = 1;
    localnq.dqa.dmX = paramString;
    localnq.dqa.reason = paramInt;
    com.tencent.mm.sdk.b.a.GpY.a(localnq, Looper.getMainLooper());
    AppMethodBeat.o(23307);
  }
  
  static boolean cgA()
  {
    AppMethodBeat.i(23297);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
    ad.cgW();
    d.kB(false);
    ad.cgW().cgy();
    AppMethodBeat.o(23297);
    return true;
  }
  
  private static boolean cgB()
  {
    AppMethodBeat.i(23299);
    if (!com.tencent.mm.plugin.d.a.e.a.ep(com.tencent.mm.sdk.platformtools.ai.getContext()))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(23299);
      return false;
    }
    if (!com.tencent.mm.plugin.d.a.e.a.bIE())
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
      AppMethodBeat.o(23299);
      return false;
    }
    AppMethodBeat.o(23299);
    return true;
  }
  
  public static boolean cgC()
  {
    AppMethodBeat.i(23300);
    ac.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
    if (!cgB())
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23300);
      return false;
    }
    ad.chb().cgF();
    AppMethodBeat.o(23300);
    return true;
  }
  
  static boolean cgD()
  {
    AppMethodBeat.i(23313);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
    Context localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    try
    {
      ad.cgW().cgy();
      com.tencent.mm.br.d.n(new Intent(localContext, ExDeviceService.class), "exdevice");
      AppMethodBeat.o(23313);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[] { localException.getMessage() });
        ac.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", localException, "", new Object[0]);
      }
    }
  }
  
  static boolean cgz()
  {
    AppMethodBeat.i(23296);
    Object localObject = ad.cgP().chv();
    if (((LinkedList)localObject).isEmpty())
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
      AppMethodBeat.o(23296);
      return false;
    }
    ad.cgW().BQ(2);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.exdevice.i.b localb = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject).next();
      az.ayM();
      com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(localb.field_brandName);
      if ((localai == null) || (!com.tencent.mm.n.b.ln(localai.field_type)))
      {
        ac.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[] { localb.field_brandName });
      }
      else if ((localb.field_connStrategy & 0x4) == 0)
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[] { Integer.valueOf(localb.field_connStrategy) });
      }
      else
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[] { localb.field_brandName });
        ad.cgW().a(localb.field_brandName, localb.field_mac, 0, true);
      }
    }
    AppMethodBeat.o(23296);
    return true;
  }
  
  static boolean d(com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23289);
    paramb = (ep)paramb;
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[] { paramb.det.ddh, paramb.det.cIZ });
    if (bs.cv(paramb.det.data))
    {
      paramb.deu.ddj = false;
      AppMethodBeat.o(23289);
      return false;
    }
    Object localObject = ad.cgP().Zd(paramb.det.cIZ);
    if (localObject == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
      paramb.deu.ddj = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.chq().sD(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
      paramb.deu.ddj = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (!u.chq().sJ(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
      paramb.deu.ddj = false;
      AppMethodBeat.o(23289);
      return false;
    }
    if (aa.cgM().pyN) {
      aa.cgM().BS(a((com.tencent.mm.plugin.exdevice.i.b)localObject));
    }
    localObject = new com.tencent.mm.plugin.exdevice.j.g(paramb.det.data, 10001, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_mac);
    u.chr().a((ae)localObject);
    paramb.deu.ddj = true;
    AppMethodBeat.o(23289);
    return true;
  }
  
  public static void e(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(23306);
    nq localnq = new nq();
    localnq.dqa.op = 2;
    localnq.dqa.dmX = paramString1;
    localnq.dqa.dea = paramInt;
    localnq.dqa.url = paramString2;
    localnq.dqa.cIZ = paramString3;
    com.tencent.mm.sdk.b.a.GpY.a(localnq, Looper.getMainLooper());
    AppMethodBeat.o(23306);
  }
  
  static boolean m(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23286);
    String str = Uri.parse(paramString).getHost();
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
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
        paramList = ((cy)localObject).eNl;
        localObject = ((cy)localObject).eNm;
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
              ac.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
              i += 1;
            }
            paramList = paramList;
            ac.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", paramList, "", new Object[0]);
          }
        }
      }
    }
    label213:
    AppMethodBeat.o(23286);
    return bool3;
  }
  
  static boolean n(String paramString, List<com.tencent.mm.plugin.exdevice.i.b> paramList)
  {
    AppMethodBeat.i(23287);
    if (paramString == null)
    {
      AppMethodBeat.o(23287);
      return false;
    }
    Object localObject = new jh();
    ((jh)localObject).dkG.ddB = paramString;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((jh)localObject).dkH.dkI;
    int i = ((TimeLineObject)localObject).FQo.Ety;
    boolean bool;
    if (i == 1)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eNl;
        if ((localObject != null) && (((String)localObject).contains("wxmsg_image"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + bool + ", snsLocalId = " + paramString);
      AppMethodBeat.o(23287);
      return bool;
      bool = false;
      continue;
      if (i == 4)
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eNl;
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
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
        paramList = paramList.iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localObject = ((com.tencent.mm.plugin.exdevice.i.b)paramList.next()).eNl;
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
        bool = m(((TimeLineObject)localObject).FQo.Url, paramList);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final boolean YO(String paramString)
  {
    AppMethodBeat.i(23302);
    ac.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
    if (!cgB())
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
      AppMethodBeat.o(23302);
      return false;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
      AppMethodBeat.o(23302);
      return false;
    }
    ad.chb().a(com.tencent.mm.plugin.exdevice.k.b.Zs(paramString), new h.a()
    {
      public final void b(long paramAnonymousLong1, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, long paramAnonymousLong2)
      {
        AppMethodBeat.i(23272);
        ac.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", new Object[] { Long.valueOf(paramAnonymousLong1), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3), Long.valueOf(paramAnonymousLong2) });
        Object localObject1 = e.this;
        String str1 = com.tencent.mm.plugin.exdevice.k.b.sQ(paramAnonymousLong1);
        LinkedList localLinkedList;
        synchronized (((e)localObject1).pxl)
        {
          localLinkedList = new LinkedList(((e)localObject1).pxl);
          ??? = localLinkedList.iterator();
          if (((Iterator)???).hasNext()) {
            ((e.b)((Iterator)???).next()).c(str1, paramAnonymousInt2, paramAnonymousLong2);
          }
        }
        localLinkedList.clear();
        localObject1 = ((e)localObject1).pxm.values().iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((e.b)((Iterator)localObject1).next()).c(str2, paramAnonymousInt2, paramAnonymousLong2);
        }
        localObject1 = new ex();
        ((ex)localObject1).deO.mac = str2;
        ((ex)localObject1).deO.dea = paramAnonymousInt2;
        ((ex)localObject1).deO.deL = paramAnonymousLong2;
        com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject1, Looper.getMainLooper());
        AppMethodBeat.o(23272);
      }
    });
    AppMethodBeat.o(23302);
    return true;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(23310);
    if (this.pxl.contains(paramb))
    {
      AppMethodBeat.o(23310);
      return false;
    }
    boolean bool = this.pxl.add(paramb);
    AppMethodBeat.o(23310);
    return bool;
  }
  
  final boolean aK(int paramInt, String paramString)
  {
    AppMethodBeat.i(23298);
    ac.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
    Object localObject1 = com.tencent.mm.al.f.dX(paramString);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ((com.tencent.mm.api.c)localObject1).bV(false);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((c.b)localObject1).Jh();
      if ((localObject2 != null) && (((c.b.b)localObject2).Jr())) {}
    }
    else
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
      AppMethodBeat.o(23298);
      return false;
    }
    localObject1 = ad.cgP().Zf(paramString);
    Object localObject3;
    if (((c.b.b)localObject2).cFZ == 1)
    {
      localObject2 = ad.cgP().chv();
      if (((List)localObject2).size() != 0)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (com.tencent.mm.plugin.exdevice.i.b)((Iterator)localObject2).next();
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[] { Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceID, ((com.tencent.mm.plugin.exdevice.i.b)localObject3).field_deviceType, Long.valueOf(((cy)localObject3).eNk) });
          if (0L != (((cy)localObject3).eNk & 1L)) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
    }
    if (localObject1 == null)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
      AppMethodBeat.o(23298);
      return false;
    }
    if (((List)localObject1).size() == 0)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
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
          ac.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
        }
        else if (bs.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("4"))
        {
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        }
        else if ((((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy & 0x10) != 0)
        {
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy) });
        }
        else if (bs.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("1"))
        {
          k = j + 1;
          if (!com.tencent.mm.plugin.d.a.e.a.bIC())
          {
            ac.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
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
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[] { Integer.valueOf(paramInt), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto });
      if (paramInt == 0)
      {
        localObject3 = ad.cgW();
        long l = ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac;
        ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[] { Long.valueOf(l) });
        if (((d)localObject3).pwV.containsKey(Long.valueOf(l)))
        {
          ac.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
          localObject3 = (au)((d)localObject3).pwV.remove(Long.valueOf(l));
          if (localObject3 == null) {
            break label780;
          }
          ((au)localObject3).stopTimer();
        }
        for (;;)
        {
          if (u.chq().sD(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
          {
            ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[] { ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac) });
            if (u.chq().sJ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac))
            {
              ac.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
              e(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID);
              k = i;
              i = j;
              j = k;
              break;
              if (!bs.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connProto).contains("3")) {
                break label1357;
              }
              i += 1;
              if (!com.tencent.mm.plugin.d.a.e.a.ep(com.tencent.mm.sdk.platformtools.ai.getContext()))
              {
                ac.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                break;
              }
              k = 0;
              m = j;
              j = i;
              i = m;
              break label495;
              label780:
              ac.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[] { Long.valueOf(l) });
              continue;
            }
            ac.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
            k = i;
            i = j;
            j = k;
            break;
          }
        }
        if (!com.tencent.mm.plugin.exdevice.service.d.eF(com.tencent.mm.sdk.platformtools.ai.getContext()))
        {
          ac.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
          k = i;
          i = j;
          j = k;
          break;
        }
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          YO(com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[] { com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName });
        ad.cgW().BQ(1);
        ad.cgW().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cgW().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 1)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName + ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, new a(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_url, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_deviceID));
          YO(com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cgW().a(Long.valueOf(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac), ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_connStrategy);
        ad.cgW().b(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac, k);
        k = i;
        i = j;
        j = k;
        break;
      }
      if (paramInt == 2)
      {
        if (f.b((com.tencent.mm.plugin.exdevice.i.b)localObject2))
        {
          YN(com.tencent.mm.plugin.exdevice.k.b.sQ(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac));
          k = i;
          i = j;
          j = k;
          break;
        }
        ad.cgW();
        d.st(((com.tencent.mm.plugin.exdevice.i.b)localObject2).field_mac);
      }
      k = i;
      i = j;
      j = k;
      break;
      if (j + i > 0) {
        if (!com.tencent.mm.plugin.d.a.e.a.bIE())
        {
          ac.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
          cU(paramString, 0);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(23298);
        return true;
        if ((i > 0) && (j == 0) && (!com.tencent.mm.plugin.d.a.e.a.ep(com.tencent.mm.sdk.platformtools.ai.getContext())))
        {
          cU(paramString, 1);
          continue;
          cU(paramString, -1);
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
    AppMethodBeat.i(23311);
    if (this.pxl.remove(paramb))
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
    paramb = (dv)paramb;
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[] { paramb.ddx.ddh, paramb.ddx.context });
    if (!YM(paramb.ddx.ddh))
    {
      paramb.ddy.ddw = null;
      paramb.ddy.ddj = false;
      AppMethodBeat.o(23285);
      return true;
    }
    LinkedList localLinkedList = ad.cgP().Zf(paramb.ddx.ddh);
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
          if ((localLinkedList.isEmpty()) || (!bs.nullAsNil(localb.field_connProto).contains("4"))) {
            continue;
          }
          localJSONObject = new JSONObject();
          localJSONObject.put("deviceId", localb.field_deviceID);
          if (!this.pya.YQ(localb.field_deviceID)) {
            break label280;
          }
          localJSONObject.put("state", "connected");
          localJSONArray.put(localJSONObject);
        }
        localJSONObject.put("state", "disconnected");
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[] { localException.getMessage() });
        paramb.ddy.ddw = localJSONArray;
        paramb.ddy.ddj = true;
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[] { localJSONArray.toString() });
        AppMethodBeat.o(23285);
        return true;
      }
    }
  }
  
  final boolean e(final com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(23291);
    paramb = (dx)paramb;
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[] { paramb.ddF.ddh, paramb.ddF.cIZ, Integer.valueOf(paramb.ddF.type) });
    Object localObject2 = new axy();
    ((axy)localObject2).EPB = paramb.ddF.type;
    ((axy)localObject2).EPC = 0;
    ((axy)localObject2).DXx = new bjb();
    ((axy)localObject2).DXx.ncU = paramb.ddF.cIZ;
    ((axy)localObject2).DXx.DUp = paramb.ddF.ddh;
    Object localObject1 = new LinkedList();
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(23268);
        if ((paramAnonymousn != null) && (paramAnonymousn.getType() == 543))
        {
          az.agi().b(543, this);
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            paramb.ddG.ddI = true;
            paramb.ddG.ddJ = null;
            if (paramb.callback != null) {
              paramb.callback.run();
            }
            AppMethodBeat.o(23268);
            return;
          }
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (z)paramAnonymousn;
          if ((paramAnonymousString.fYA == null) || (paramAnonymousString.fYA.hvs.hvw == null)) {}
          ayb localayb;
          for (paramAnonymousString = null;; paramAnonymousString = (aya)paramAnonymousString.fYA.hvs.hvw)
          {
            Iterator localIterator = paramAnonymousString.EPF.iterator();
            paramAnonymousInt1 = 0;
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label413;
              }
              localayb = (ayb)localIterator.next();
              if (localayb != null)
              {
                paramAnonymousn = null;
                paramAnonymousString = null;
                if (localayb.DXx != null)
                {
                  paramAnonymousn = localayb.DXx.ncU;
                  paramAnonymousString = localayb.DXx.DUp;
                }
                if ((localayb.Ret == 0) && (!bs.isNullOrNil(localayb.Ewu))) {
                  break;
                }
                ac.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramAnonymousn, Integer.valueOf(localayb.Ret), localayb.Ewu });
              }
            }
          }
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramAnonymousn, paramAnonymousString, localayb.Ewu, Integer.valueOf(localayb.EPB) });
          paramb.ddG.ddI = true;
          paramb.ddG.ddJ = localayb.Ewu;
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
            paramb.ddG.ddI = true;
            paramb.ddG.ddJ = null;
            if (paramb.callback != null) {
              paramb.callback.run();
            }
          }
          AppMethodBeat.o(23268);
          return;
          paramb.ddG.ddI = true;
          paramb.ddG.ddJ = null;
          if (paramb.callback != null) {
            paramb.callback.run();
          }
          AppMethodBeat.o(23268);
          return;
        }
      }
    };
    localObject1 = new z((LinkedList)localObject1, paramb.ddF.ddh, paramb.ddF.ddH);
    az.agi().a(543, (com.tencent.mm.ak.g)localObject2);
    if (!az.agi().a((n)localObject1, 0))
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
      az.agi().b(543, (com.tencent.mm.ak.g)localObject2);
      paramb.ddG.ddI = true;
      paramb.ddG.ddJ = null;
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
    paramb = (en)paramb;
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[] { paramb.deo.ddh, Boolean.valueOf(paramb.deo.ddi), Integer.valueOf(paramb.deo.deq) });
    int j = paramb.deo.deq;
    int i = j;
    if (j != 0)
    {
      i = j;
      if (j != 1)
      {
        if (!com.tencent.mm.plugin.d.a.e.a.ep(com.tencent.mm.sdk.platformtools.ai.getContext())) {
          break label197;
        }
        ac.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[] { Integer.valueOf(j) });
        i = 0;
      }
    }
    aa localaa;
    Object localObject2;
    if (paramb.deo.ddi)
    {
      localaa = aa.cgM();
      ??? = paramb.deo.ddh;
      localObject2 = new aa.a()
      {
        public final void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(23269);
          ac.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[] { paramAnonymousString });
          if (paramAnonymousArrayOfByte == null) {
            ac.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
          }
          for (;;)
          {
            ek localek = new ek();
            localek.del.ded = paramAnonymousArrayOfByte;
            localek.del.cIZ = paramAnonymousString;
            localek.del.bhH = paramAnonymousBoolean;
            com.tencent.mm.sdk.b.a.GpY.a(localek, Looper.getMainLooper());
            AppMethodBeat.o(23269);
            return;
            ac.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[] { paramAnonymousString, Base64.encodeToString(paramAnonymousArrayOfByte, 0), Boolean.valueOf(paramAnonymousBoolean) });
          }
        }
      };
      ac.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[] { ??? });
      if (bs.isNullOrNil((String)???)) {
        ac.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
      }
    }
    for (;;)
    {
      paramb.dep.ddj = true;
      AppMethodBeat.o(23292);
      return true;
      label197:
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[] { Integer.valueOf(j) });
      paramb.dep.ddj = false;
      AppMethodBeat.o(23292);
      return false;
      localaa.pyh = ((String)???);
      localaa.pzA = ((aa.a)localObject2);
      localaa.pzB.clear();
      ??? = localaa.pzC.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (n)((Iterator)???).next();
        if (localObject2 != null) {
          az.agi().a((n)localObject2);
        }
      }
      localaa.pzC.clear();
      synchronized (aa.cRu)
      {
        aa.pzD.clear();
        if (!localaa.pyN)
        {
          localaa.pyN = true;
          az.agi().a(542, localaa);
          ad.cgW().a(i, localaa);
          ac.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
          localaa.iRv.au(12000L, 12000L);
        }
      }
      ac.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
      continue;
      aa.cgM().BS(i);
    }
  }
  
  final boolean m(List<com.tencent.mm.plugin.exdevice.i.b> paramList, int paramInt)
  {
    AppMethodBeat.i(23295);
    ac.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
    if (paramList.size() == 0)
    {
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
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
        u.chr().a((ae)localObject);
      }
      if (this.pyc) {
        this.mHandler.removeCallbacks(this.pyd);
      }
      this.pyd = new c(paramList);
      this.mHandler.postDelayed(this.pyd, 300000L);
      this.pyc = true;
      paramInt = 2;
      continue;
      if (this.pyc)
      {
        this.mHandler.removeCallbacks(this.pyd);
        this.pyc = false;
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
    synchronized (this.pxl)
    {
      localLinkedList = new LinkedList(this.pxl);
      ??? = localLinkedList.iterator();
      if (((Iterator)???).hasNext()) {
        ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
      }
    }
    localLinkedList.clear();
    ??? = this.pxm.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((b)((Iterator)???).next()).o(paramString1, paramString2, paramBoolean);
    }
    ac.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + paramString1 + ", mac=" + paramString2 + ", isCompleted=" + paramBoolean);
    ??? = new ez();
    ((ez)???).deQ.deK = paramString1;
    ((ez)???).deQ.mac = paramString2;
    ((ez)???).deQ.bhH = paramBoolean;
    com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)???, Looper.getMainLooper());
    AppMethodBeat.o(23305);
  }
  
  public final boolean n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23303);
    if ((bs.isNullOrNil(paramString)) || (bs.cv(paramArrayOfByte)))
    {
      if (bs.isNullOrNil(paramString))
      {
        paramString = "null";
        if (!bs.cv(paramArrayOfByte)) {
          break label79;
        }
      }
      label79:
      for (i = 0;; i = paramArrayOfByte.length)
      {
        ac.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", new Object[] { paramString, Integer.valueOf(i) });
        AppMethodBeat.o(23303);
        return false;
        paramString = "mac";
        break;
      }
    }
    String str;
    if (bs.isNullOrNil(paramString))
    {
      str = "null";
      if (!bs.cv(paramArrayOfByte)) {
        break label176;
      }
    }
    long l;
    label176:
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", new Object[] { str, Integer.valueOf(i) });
      l = com.tencent.mm.plugin.exdevice.k.b.Zs(paramString);
      paramString = ad.chb().pyO.sG(l);
      if (paramString != null) {
        break label182;
      }
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
      AppMethodBeat.o(23303);
      return false;
      str = paramString;
      break;
    }
    label182:
    if (paramString.dea != 2)
    {
      ac.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
      AppMethodBeat.o(23303);
      return false;
    }
    ad.chb();
    boolean bool = h.a(l, paramArrayOfByte, new t.a()
    {
      public final void b(long paramAnonymousLong, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(23273);
        Object localObject1 = paramAnonymousString;
        if (paramAnonymousString == null) {
          localObject1 = "null";
        }
        ac.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), localObject1 });
        localObject1 = e.this;
        paramAnonymousString = com.tencent.mm.plugin.exdevice.k.b.sQ(paramAnonymousLong);
        boolean bool;
        if (paramAnonymousInt2 == 0) {
          bool = true;
        }
        LinkedList localLinkedList;
        for (;;)
        {
          ac.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", new Object[] { paramAnonymousString, Boolean.valueOf(bool) });
          if (bool) {
            break label250;
          }
          synchronized (((e)localObject1).pxl)
          {
            localLinkedList = new LinkedList(((e)localObject1).pxl);
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
        localObject1 = ((e)localObject1).pxm.values().iterator();
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
    private String cDv;
    private String mURL;
    private String pyh;
    private String pyi;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(23279);
      this.pyh = paramString1;
      this.cDv = paramString2;
      this.mURL = paramString3;
      this.pyi = paramString4;
      ac.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(23279);
    }
    
    public final void b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(23281);
      if ((this.cDv == null) || (!this.cDv.equals(paramString)))
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[] { this.cDv, paramString, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(23281);
        return;
      }
      if ((paramBoolean) && (paramArrayOfByte != null)) {
        try
        {
          ad.cha();
          if (!e.b(this.cDv, this.pyh, paramArrayOfByte))
          {
            ac.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
            AppMethodBeat.o(23281);
            return;
          }
          AppMethodBeat.o(23281);
          return;
        }
        catch (Exception paramString)
        {
          ac.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
        }
      }
      AppMethodBeat.o(23281);
    }
    
    public final void c(String paramString, int paramInt, long paramLong)
    {
      AppMethodBeat.i(23282);
      if ((this.cDv == null) || (!this.cDv.equals(paramString)))
      {
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[] { this.cDv, paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        AppMethodBeat.o(23282);
        return;
      }
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
      switch (paramInt)
      {
      case 3: 
      default: 
        ac.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        e.e(this.pyh, this.mURL, -1, this.pyi);
        AppMethodBeat.o(23282);
        return;
      case 2: 
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[] { paramString });
        e.e(this.pyh, this.mURL, 2, this.pyi);
        paramString = new com.tencent.mm.plugin.d.a.b.a.f();
        paramString.nqF = com.tencent.mm.plugin.d.a.b.a.f.nrH;
        paramString.nqG = 2;
        ad.cha().n(this.cDv, com.tencent.mm.plugin.exdevice.k.b.cT(paramString));
        AppMethodBeat.o(23282);
        return;
      case 1: 
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[] { paramString });
        e.e(this.pyh, this.mURL, 1, this.pyi);
        AppMethodBeat.o(23282);
        return;
      case 4: 
        e.e(this.pyh, this.mURL, 4, this.pyi);
        ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[] { paramString });
        AppMethodBeat.o(23282);
        return;
      }
      e.e(this.pyh, this.mURL, 0, this.pyi);
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[] { paramString });
      AppMethodBeat.o(23282);
    }
    
    public final void o(String paramString1, String paramString2, boolean paramBoolean)
    {
      AppMethodBeat.i(23280);
      if ((this.cDv == null) || (!this.cDv.equals(paramString2)))
      {
        ac.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[] { this.cDv, paramString2, Boolean.valueOf(paramBoolean) });
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
    
    public abstract void o(String paramString1, String paramString2, boolean paramBoolean);
  }
  
  final class c
    implements Runnable
  {
    List<com.tencent.mm.plugin.exdevice.i.b> hqS;
    
    public c()
    {
      Object localObject;
      this.hqS = localObject;
    }
    
    public final void run()
    {
      AppMethodBeat.i(23283);
      ac.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
      if ((this.hqS != null) && (this.hqS.size() > 0))
      {
        Iterator localIterator = this.hqS.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (com.tencent.mm.plugin.exdevice.i.b)localIterator.next();
          localObject = new k(((com.tencent.mm.plugin.exdevice.i.b)localObject).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceType, ((com.tencent.mm.plugin.exdevice.i.b)localObject).field_deviceID, 1);
          u.chr().a((ae)localObject);
        }
        e.this.mHandler.postDelayed(this, 300000L);
      }
      AppMethodBeat.o(23283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e
 * JD-Core Version:    0.7.0.1
 */