package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.f.a.eg;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.j.g;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.LifecycleEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ae
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ac vgH;
  private b vgI;
  private com.tencent.mm.plugin.exdevice.i.c vgJ;
  private com.tencent.mm.plugin.exdevice.g.b.b.d vgK;
  private com.tencent.mm.plugin.exdevice.g.b.b.a vgL;
  private com.tencent.mm.plugin.exdevice.g.b.b.b vgM;
  private com.tencent.mm.plugin.exdevice.g.b.b.e vgN;
  private e vgO;
  private d vgP;
  private com.tencent.mm.plugin.exdevice.g.b.c vgQ;
  private com.tencent.mm.plugin.exdevice.g.b.a vgR;
  private com.tencent.mm.plugin.exdevice.g.a.c vgS;
  private com.tencent.mm.ay.a.a vgT;
  private com.tencent.mm.ay.a.a.c vgU;
  private ag vgV;
  private h vgW;
  private ck.a vgX;
  MStorageEx.IOnStorageChange vgY;
  private com.tencent.mm.plugin.messenger.foundation.a.t vgZ;
  
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
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new ae.4());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new ae.5());
    baseDBFactories.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new ae.6());
    baseDBFactories.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new ae.7());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ae.8());
    AppMethodBeat.o(23473);
  }
  
  public ae()
  {
    AppMethodBeat.i(23454);
    this.vgH = new ac();
    this.vgT = null;
    this.vgU = null;
    this.vgX = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ae.cZE() != null)
        {
          ae.cZE();
          paramAnonymousa = paramAnonymousa.jQG;
          Log.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.RIF);
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
                paramAnonymousa = z.a(paramAnonymousa.RIF);
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
            localObject1 = ae.cZx().avI(str4);
          } while ((localObject1 == null) || (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!Util.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ae.cZJ();
            e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ae.cZJ();
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
            paramAnonymousa = new eg();
            paramAnonymousa.fzU.fzV = true;
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
          localObject1 = ae.cZx().avI((String)localObject1);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.dal().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.cYV();
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
    this.vgY = new ae.10(this);
    this.vgZ = new ae.2(this);
    if (this.vgP == null) {
      this.vgP = new d();
    }
    if (this.vgO == null) {
      this.vgO = new e();
    }
    Log.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    EventCenter.instance.addListener(this.vgO.veB);
    AppMethodBeat.o(23454);
  }
  
  public static void Kg(int paramInt)
  {
    AppMethodBeat.i(288998);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vja, Integer.valueOf(paramInt));
    AppMethodBeat.o(288998);
  }
  
  public static com.tencent.mm.ay.a.a.c avx(String paramString)
  {
    AppMethodBeat.i(23460);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = cZw();
      if (paramString.vgU == null)
      {
        c.a locala = new c.a();
        q.bmm();
        locala.lRV = null;
        locala.kOg = 640;
        locala.kOf = 640;
        locala.lRB = false;
        locala.lRD = true;
        paramString.vgU = locala.bmL();
      }
      paramString = cZw().vgU;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.kOg = 640;
    paramString.kOf = 640;
    paramString.lRB = false;
    paramString.lRC = true;
    bh.beI();
    paramString.prefixPath = com.tencent.mm.model.c.bbW();
    paramString = paramString.bmL();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a cZA()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgL == null)
    {
      localObject = cZw();
      bh.beI();
      ((ae)localObject).vgL = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cZw().vgL;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.ay.a.a cZB()
  {
    AppMethodBeat.i(23459);
    if (cZw().vgT == null) {
      cZw().vgT = q.bml();
    }
    com.tencent.mm.ay.a.a locala = cZw().vgT;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b cZC()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgM == null)
    {
      localObject = cZw();
      bh.beI();
      ((ae)localObject).vgM = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cZw().vgM;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e cZD()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgN == null)
    {
      localObject = cZw();
      bh.beI();
      ((ae)localObject).vgN = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cZw().vgN;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b cZE()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgI == null) {
      cZw().vgI = new b();
    }
    b localb = cZw().vgI;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static d cZF()
  {
    AppMethodBeat.i(23464);
    if (cZw().vgP == null) {
      cZw().vgP = new d();
    }
    d locald = cZw().vgP;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c cZG()
  {
    AppMethodBeat.i(23465);
    if (cZw().vgQ == null) {
      cZw().vgQ = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = cZw().vgQ;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a cZH()
  {
    AppMethodBeat.i(23466);
    if (cZw().vgR == null) {
      cZw().vgR = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = cZw().vgR;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c cZI()
  {
    AppMethodBeat.i(23467);
    if (cZw().vgS == null) {
      cZw().vgS = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = cZw().vgS;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e cZJ()
  {
    AppMethodBeat.i(23468);
    if (cZw().vgO == null) {
      cZw().vgO = new e();
    }
    e locale = cZw().vgO;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h cZK()
  {
    AppMethodBeat.i(23471);
    if (cZw().vgW == null) {
      cZw().vgW = new h();
    }
    h localh = cZw().vgW;
    AppMethodBeat.o(23471);
    return localh;
  }
  
  private static ae cZw()
  {
    AppMethodBeat.i(23455);
    bh.beC();
    ae localae2 = (ae)ch.RZ("plugin.exdevice");
    ae localae1 = localae2;
    if (localae2 == null)
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localae1 = new ae();
      bh.beC().a("plugin.exdevice", localae1);
    }
    AppMethodBeat.o(23455);
    return localae1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c cZx()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgJ == null)
    {
      localObject = cZw();
      bh.beI();
      ((ae)localObject).vgJ = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cZw().vgJ;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static int cZy()
  {
    AppMethodBeat.i(288999);
    com.tencent.mm.kernel.h.aHH();
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vja, 0);
    AppMethodBeat.o(288999);
    return i;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d cZz()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.h.aHE().aGH();
    if (cZw().vgK == null)
    {
      localObject = cZw();
      bh.beI();
      ((ae)localObject).vgK = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cZw().vgK;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23469);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.vgY);
    Object localObject = k.cYV();
    bh.aGY().a(538, (com.tencent.mm.an.i)localObject);
    this.vgV = new ag();
    EventCenter.instance.addListener(this.vgH);
    bh.getSysCmdMsgExtension().a("wcdevicemsg", this.vgX, true);
    EventCenter.instance.addListener(cZJ().veb);
    EventCenter.instance.addListener(cZJ().vec);
    EventCenter.instance.addListener(cZJ().ved);
    EventCenter.instance.addListener(cZJ().vex);
    EventCenter.instance.addListener(cZJ().vea);
    EventCenter.instance.addListener(cZJ().vdZ);
    EventCenter.instance.addListener(cZJ().vee);
    EventCenter.instance.addListener(cZJ().vef);
    ((com.tencent.mm.v.c)LifecycleEventCenter.getEvent(com.tencent.mm.v.c.class)).observeInUIThread(com.tencent.mm.kernel.h.aHE().kbJ, cZJ().veg);
    EventCenter.instance.addListener(cZJ().vey);
    EventCenter.instance.addListener(cZJ().veh);
    EventCenter.instance.addListener(cZJ().vei);
    EventCenter.instance.addListener(cZJ().vej);
    EventCenter.instance.addListener(cZJ().vel);
    EventCenter.instance.addListener(cZJ().vek);
    EventCenter.instance.addListener(cZJ().vep);
    EventCenter.instance.addListener(cZJ().ven);
    EventCenter.instance.addListener(cZJ().veo);
    EventCenter.instance.addListener(cZJ().veq);
    EventCenter.instance.addListener(cZJ().vez);
    EventCenter.instance.addListener(cZJ().rXi);
    EventCenter.instance.addListener(cZJ().vem);
    EventCenter.instance.addListener(cZJ().ves);
    EventCenter.instance.addListener(cZJ().vet);
    EventCenter.instance.addListener(cZJ().veu);
    EventCenter.instance.addListener(cZJ().vev);
    EventCenter.instance.addListener(cZJ().veI);
    EventCenter.instance.addListener(cZJ().veJ);
    EventCenter.instance.addListener(cZJ().veK);
    EventCenter.instance.addListener(cZJ().veM);
    EventCenter.instance.addListener(cZJ().veL);
    EventCenter.instance.addListener(cZJ().veC);
    EventCenter.instance.addListener(cZJ().veD);
    EventCenter.instance.addListener(cZJ().veE);
    EventCenter.instance.addListener(cZJ().veF);
    EventCenter.instance.addListener(cZJ().veG);
    EventCenter.instance.addListener(cZJ().veH);
    EventCenter.instance.addListener(cZJ().veA);
    EventCenter.instance.addListener(cZJ().veB);
    localObject = i.vfP;
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    bh.aGY().a(539, (com.tencent.mm.an.i)localObject);
    bh.aGY().a(6693, (com.tencent.mm.an.i)localObject);
    com.tencent.mm.compatible.a.a.a(19, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(23453);
        ae.a(ae.this);
        AppMethodBeat.o(23453);
      }
    });
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.exdevice.a.b.class, new com.tencent.mm.plugin.exdevice.a.a());
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("ilink_device_update", this.vgZ);
    AppMethodBeat.o(23469);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23470);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.vgY);
    EventCenter.instance.removeListener(cZJ().veb);
    EventCenter.instance.removeListener(cZJ().vec);
    EventCenter.instance.removeListener(cZJ().ved);
    EventCenter.instance.removeListener(cZJ().vex);
    EventCenter.instance.removeListener(cZJ().vez);
    EventCenter.instance.removeListener(cZJ().vea);
    EventCenter.instance.removeListener(cZJ().vdZ);
    EventCenter.instance.removeListener(cZJ().vee);
    EventCenter.instance.removeListener(cZJ().vef);
    EventCenter.instance.removeListener(cZJ().vey);
    EventCenter.instance.removeListener(cZJ().veI);
    EventCenter.instance.removeListener(cZJ().veJ);
    EventCenter.instance.removeListener(cZJ().veK);
    EventCenter.instance.removeListener(cZJ().veM);
    EventCenter.instance.removeListener(cZJ().veL);
    EventCenter.instance.removeListener(cZJ().veC);
    EventCenter.instance.removeListener(cZJ().veD);
    EventCenter.instance.removeListener(cZJ().veE);
    EventCenter.instance.removeListener(cZJ().veF);
    EventCenter.instance.removeListener(cZJ().veG);
    EventCenter.instance.removeListener(cZJ().veH);
    EventCenter.instance.removeListener(cZJ().vei);
    EventCenter.instance.removeListener(cZJ().veA);
    EventCenter.instance.removeListener(cZJ().veB);
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.dak();
      Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).vjm != null) {
        break label627;
      }
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.cYV();
      bh.aGY().b(538, (com.tencent.mm.an.i)localObject1);
      k.vdk = null;
      EventCenter.instance.removeListener(this.vgH);
      bh.getSysCmdMsgExtension().b("wcdevicemsg", this.vgX, true);
      EventCenter.instance.removeListener(cZJ().veh);
      if (cZw().vgI != null) {
        cZw();
      }
      localObject1 = i.vfP;
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      bh.aGY().b(539, (com.tencent.mm.an.i)localObject1);
      bh.aGY().b(6693, (com.tencent.mm.an.i)localObject1);
      if ((((i)localObject1).iXX != null) && (((i)localObject1).iXX.isShowing()))
      {
        ((i)localObject1).iXX.dismiss();
        ((i)localObject1).iXX = null;
      }
      localObject1 = cZw().vgP;
      if ((((d)localObject1).vdG == null) || (((d)localObject1).vdG.isEmpty())) {
        break label692;
      }
      Object localObject2 = ((d)localObject1).vdG.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((MTimerHandler)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label627:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).vjm.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.vjq = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).vdG.clear();
    label692:
    if (cZw().vgQ != null)
    {
      localObject1 = cZw().vgQ;
      bh.aGY().b(1042, (com.tencent.mm.an.i)localObject1);
      bh.aGY().b(1041, (com.tencent.mm.an.i)localObject1);
      bh.aGY().b(1043, (com.tencent.mm.an.i)localObject1);
      bh.aGY().b(1040, (com.tencent.mm.an.i)localObject1);
    }
    if (cZw().vgT != null) {
      cZw().vgT.detach();
    }
    localObject1 = this.vgV;
    EventCenter.instance.removeListener(((ag)localObject1).iQL);
    com.tencent.mm.kernel.h.af(com.tencent.mm.plugin.exdevice.a.b.class);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("ilink_device_update", this.vgZ);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ae
 * JD-Core Version:    0.7.0.1
 */