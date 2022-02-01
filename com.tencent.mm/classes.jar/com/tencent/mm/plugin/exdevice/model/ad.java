package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ad
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ab rBa;
  private b rBb;
  private com.tencent.mm.plugin.exdevice.i.c rBc;
  private com.tencent.mm.plugin.exdevice.g.b.b.d rBd;
  private com.tencent.mm.plugin.exdevice.g.b.b.a rBe;
  private com.tencent.mm.plugin.exdevice.g.b.b.b rBf;
  private com.tencent.mm.plugin.exdevice.g.b.b.e rBg;
  private e rBh;
  private d rBi;
  private com.tencent.mm.plugin.exdevice.g.b.c rBj;
  private com.tencent.mm.plugin.exdevice.g.b.a rBk;
  private com.tencent.mm.plugin.exdevice.g.a.c rBl;
  private com.tencent.mm.av.a.a rBm;
  private com.tencent.mm.av.a.a.c rBn;
  private af rBo;
  private h rBp;
  private cj.a rBq;
  MStorageEx.IOnStorageChange rBr;
  
  static
  {
    AppMethodBeat.i(23473);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.i.c.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.g.b.b.d.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.g.b.b.a.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.g.b.b.e.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.g.b.b.b.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ad.7());
    AppMethodBeat.o(23473);
  }
  
  public ad()
  {
    AppMethodBeat.i(23454);
    this.rBa = new ab();
    this.rBm = null;
    this.rBn = null;
    this.rBq = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ad.cKR() != null)
        {
          ad.cKR();
          paramAnonymousa = paramAnonymousa.heO;
          Log.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.KHn);
          if (Util.isNullOrNil((String)localObject1)) {
            Log.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
          }
          int i;
          do
          {
            do
            {
              do
              {
                i = 0;
                if (i != 0) {
                  break label917;
                }
                paramAnonymousa = z.a(paramAnonymousa.KHn);
                if (!Util.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                Log.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(23450);
                return;
                localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
              } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
              localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
            } while ((Util.isNullOrNil((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
            String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
            String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
            l = Util.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
            localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
            String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
            String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
            i = Util.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
            Log.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
            localObject1 = ad.cKL().anJ(str4);
          } while ((localObject1 == null) || (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!Util.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ad.cKW();
            e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.cKW();
            e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
          if ((Util.isNullOrNil(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = Util.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
          if (paramAnonymousa.equals("device_relation"))
          {
            paramAnonymousa = new dz();
            paramAnonymousa.dHd.dHe = true;
            EventCenter.instance.publish(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
          if (Util.isNullOrNil((String)localObject2))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
            AppMethodBeat.o(23450);
            return;
          }
          try
          {
            paramAnonymousa = Base64.decode((String)localObject2, 0);
            if (Util.isNullOrNil(paramAnonymousa))
            {
              Log.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
              AppMethodBeat.o(23450);
              return;
            }
          }
          catch (Exception paramAnonymousa)
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(23450);
            return;
          }
          l = Util.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
          localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
          localObject1 = ad.cKL().anJ((String)localObject1);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.cLy().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.cKl();
          Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
          if (l < 0L) {
            break label924;
          }
        }
        label917:
        label924:
        for (boolean bool = true;; bool = false)
        {
          Assert.assertTrue(bool);
          localObject2 = new k.c((byte)0);
          ((k.c)localObject2).mSessionId = l;
          ((k.c)localObject2).mData = paramAnonymousa;
          ((k)localObject1).mHandler.obtainMessage(3, localObject2).sendToTarget();
          AppMethodBeat.o(23450);
          return;
        }
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.rBr = new ad.9(this);
    if (this.rBi == null) {
      this.rBi = new d();
    }
    if (this.rBh == null) {
      this.rBh = new e();
    }
    Log.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    EventCenter.instance.addListener(this.rBh.ryU);
    AppMethodBeat.o(23454);
  }
  
  public static com.tencent.mm.av.a.a.c any(String paramString)
  {
    AppMethodBeat.i(23460);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = cKK();
      if (paramString.rBn == null)
      {
        c.a locala = new c.a();
        q.bcW();
        locala.jbw = null;
        locala.hZA = 640;
        locala.hZz = 640;
        locala.jbd = false;
        locala.jbf = true;
        paramString.rBn = locala.bdv();
      }
      paramString = cKK().rBn;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.hZA = 640;
    paramString.hZz = 640;
    paramString.jbd = false;
    paramString.jbe = true;
    bg.aVF();
    paramString.prefixPath = com.tencent.mm.model.c.aSY();
    paramString = paramString.bdv();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  private static ad cKK()
  {
    AppMethodBeat.i(23455);
    bg.aVz();
    ad localad2 = (ad)cg.KG("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      bg.aVz().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(23455);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c cKL()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBc == null)
    {
      localObject = cKK();
      bg.aVF();
      ((ad)localObject).rBc = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cKK().rBc;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d cKM()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBd == null)
    {
      localObject = cKK();
      bg.aVF();
      ((ad)localObject).rBd = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cKK().rBd;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a cKN()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBe == null)
    {
      localObject = cKK();
      bg.aVF();
      ((ad)localObject).rBe = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cKK().rBe;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.av.a.a cKO()
  {
    AppMethodBeat.i(23459);
    if (cKK().rBm == null) {
      cKK().rBm = q.bcV();
    }
    com.tencent.mm.av.a.a locala = cKK().rBm;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b cKP()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBf == null)
    {
      localObject = cKK();
      bg.aVF();
      ((ad)localObject).rBf = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cKK().rBf;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e cKQ()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBg == null)
    {
      localObject = cKK();
      bg.aVF();
      ((ad)localObject).rBg = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cKK().rBg;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b cKR()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.g.aAf().azk();
    if (cKK().rBb == null) {
      cKK().rBb = new b();
    }
    b localb = cKK().rBb;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static d cKS()
  {
    AppMethodBeat.i(23464);
    if (cKK().rBi == null) {
      cKK().rBi = new d();
    }
    d locald = cKK().rBi;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c cKT()
  {
    AppMethodBeat.i(23465);
    if (cKK().rBj == null) {
      cKK().rBj = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = cKK().rBj;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a cKU()
  {
    AppMethodBeat.i(23466);
    if (cKK().rBk == null) {
      cKK().rBk = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = cKK().rBk;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c cKV()
  {
    AppMethodBeat.i(23467);
    if (cKK().rBl == null) {
      cKK().rBl = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = cKK().rBl;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e cKW()
  {
    AppMethodBeat.i(23468);
    if (cKK().rBh == null) {
      cKK().rBh = new e();
    }
    e locale = cKK().rBh;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h cKX()
  {
    AppMethodBeat.i(23471);
    if (cKK().rBp == null) {
      cKK().rBp = new h();
    }
    h localh = cKK().rBp;
    AppMethodBeat.o(23471);
    return localh;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23469);
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.rBr);
    Object localObject = k.cKl();
    bg.azz().a(538, (com.tencent.mm.ak.i)localObject);
    this.rBo = new af();
    EventCenter.instance.addListener(this.rBa);
    bg.getSysCmdMsgExtension().a("wcdevicemsg", this.rBq, true);
    EventCenter.instance.addListener(cKW().ryv);
    EventCenter.instance.addListener(cKW().ryw);
    EventCenter.instance.addListener(cKW().ryx);
    EventCenter.instance.addListener(cKW().ryQ);
    EventCenter.instance.addListener(cKW().ryu);
    EventCenter.instance.addListener(cKW().ryt);
    EventCenter.instance.addListener(cKW().ryy);
    EventCenter.instance.addListener(cKW().ryz);
    EventCenter.instance.addListener(cKW().ryA);
    EventCenter.instance.addListener(cKW().ryR);
    EventCenter.instance.addListener(cKW().ryB);
    EventCenter.instance.addListener(cKW().ryC);
    EventCenter.instance.addListener(cKW().ryD);
    EventCenter.instance.addListener(cKW().ryF);
    EventCenter.instance.addListener(cKW().ryE);
    EventCenter.instance.addListener(cKW().ryJ);
    EventCenter.instance.addListener(cKW().ryH);
    EventCenter.instance.addListener(cKW().ryI);
    EventCenter.instance.addListener(cKW().ryK);
    EventCenter.instance.addListener(cKW().ryS);
    EventCenter.instance.addListener(cKW().oVj);
    EventCenter.instance.addListener(cKW().ryG);
    EventCenter.instance.addListener(cKW().ryL);
    EventCenter.instance.addListener(cKW().ryM);
    EventCenter.instance.addListener(cKW().ryN);
    EventCenter.instance.addListener(cKW().ryO);
    EventCenter.instance.addListener(cKW().rzb);
    EventCenter.instance.addListener(cKW().rzc);
    EventCenter.instance.addListener(cKW().rzd);
    EventCenter.instance.addListener(cKW().rzf);
    EventCenter.instance.addListener(cKW().rze);
    EventCenter.instance.addListener(cKW().ryV);
    EventCenter.instance.addListener(cKW().ryW);
    EventCenter.instance.addListener(cKW().ryX);
    EventCenter.instance.addListener(cKW().ryY);
    EventCenter.instance.addListener(cKW().ryZ);
    EventCenter.instance.addListener(cKW().rza);
    EventCenter.instance.addListener(cKW().ryT);
    EventCenter.instance.addListener(cKW().ryU);
    localObject = i.rAi;
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    bg.azz().a(539, (com.tencent.mm.ak.i)localObject);
    com.tencent.mm.compatible.a.a.a(19, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(23453);
        ad.a(ad.this);
        AppMethodBeat.o(23453);
      }
    });
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.exdevice.a.b.class, new com.tencent.mm.plugin.exdevice.a.a());
    AppMethodBeat.o(23469);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23470);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.rBr);
    EventCenter.instance.removeListener(cKW().ryv);
    EventCenter.instance.removeListener(cKW().ryw);
    EventCenter.instance.removeListener(cKW().ryx);
    EventCenter.instance.removeListener(cKW().ryQ);
    EventCenter.instance.removeListener(cKW().ryS);
    EventCenter.instance.removeListener(cKW().ryu);
    EventCenter.instance.removeListener(cKW().ryt);
    EventCenter.instance.removeListener(cKW().ryy);
    EventCenter.instance.removeListener(cKW().ryz);
    EventCenter.instance.removeListener(cKW().ryA);
    EventCenter.instance.removeListener(cKW().ryR);
    EventCenter.instance.removeListener(cKW().rzb);
    EventCenter.instance.removeListener(cKW().rzc);
    EventCenter.instance.removeListener(cKW().rzd);
    EventCenter.instance.removeListener(cKW().rzf);
    EventCenter.instance.removeListener(cKW().rze);
    EventCenter.instance.removeListener(cKW().ryV);
    EventCenter.instance.removeListener(cKW().ryW);
    EventCenter.instance.removeListener(cKW().ryX);
    EventCenter.instance.removeListener(cKW().ryY);
    EventCenter.instance.removeListener(cKW().ryZ);
    EventCenter.instance.removeListener(cKW().rza);
    EventCenter.instance.removeListener(cKW().ryC);
    EventCenter.instance.removeListener(cKW().ryT);
    EventCenter.instance.removeListener(cKW().ryU);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.cLx();
      Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((f)localObject1).rDC != null) {
        break label630;
      }
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.cKl();
      bg.azz().b(538, (com.tencent.mm.ak.i)localObject1);
      k.rxE = null;
      EventCenter.instance.removeListener(this.rBa);
      bg.getSysCmdMsgExtension().b("wcdevicemsg", this.rBq, true);
      EventCenter.instance.removeListener(cKW().ryB);
      if (cKK().rBb != null) {
        cKK();
      }
      localObject1 = i.rAi;
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      bg.azz().b(539, (com.tencent.mm.ak.i)localObject1);
      if ((((i)localObject1).gtM != null) && (((i)localObject1).gtM.isShowing()))
      {
        ((i)localObject1).gtM.dismiss();
        ((i)localObject1).gtM = null;
      }
      localObject1 = cKK().rBi;
      if ((((d)localObject1).rya == null) || (((d)localObject1).rya.isEmpty())) {
        break label695;
      }
      Object localObject2 = ((d)localObject1).rya.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((MTimerHandler)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label630:
      localObject1 = ((f)localObject1).rDC.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.rDG = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).rya.clear();
    label695:
    if (cKK().rBj != null)
    {
      localObject1 = cKK().rBj;
      bg.azz().b(1042, (com.tencent.mm.ak.i)localObject1);
      bg.azz().b(1041, (com.tencent.mm.ak.i)localObject1);
      bg.azz().b(1043, (com.tencent.mm.ak.i)localObject1);
      bg.azz().b(1040, (com.tencent.mm.ak.i)localObject1);
    }
    if (cKK().rBm != null) {
      cKK().rBm.detach();
    }
    localObject1 = this.rBo;
    EventCenter.instance.removeListener(((af)localObject1).gmC);
    com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.exdevice.a.b.class);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */