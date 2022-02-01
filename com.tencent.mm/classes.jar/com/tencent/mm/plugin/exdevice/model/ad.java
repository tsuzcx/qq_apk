package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ad
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ab qdA;
  private b qdB;
  private com.tencent.mm.plugin.exdevice.i.c qdC;
  private com.tencent.mm.plugin.exdevice.g.b.b.d qdD;
  private com.tencent.mm.plugin.exdevice.g.b.b.a qdE;
  private com.tencent.mm.plugin.exdevice.g.b.b.b qdF;
  private com.tencent.mm.plugin.exdevice.g.b.b.e qdG;
  private e qdH;
  private d qdI;
  private com.tencent.mm.plugin.exdevice.g.b.c qdJ;
  private com.tencent.mm.plugin.exdevice.g.b.a qdK;
  private com.tencent.mm.plugin.exdevice.g.a.c qdL;
  private com.tencent.mm.aw.a.a qdM;
  private com.tencent.mm.aw.a.a.c qdN;
  private af qdO;
  private h qdP;
  private cd.a qdQ;
  n.b qdR;
  
  static
  {
    AppMethodBeat.i(23473);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new ad.1());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new ad.3());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new ad.4());
    baseDBFactories.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new ad.5());
    baseDBFactories.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new ad.6());
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ad.7());
    AppMethodBeat.o(23473);
  }
  
  public ad()
  {
    AppMethodBeat.i(23454);
    this.qdA = new ab();
    this.qdM = null;
    this.qdN = null;
    this.qdQ = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ad.clz() != null)
        {
          ad.clz();
          paramAnonymousa = paramAnonymousa.gqE;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.Fvk);
          if (bt.isNullOrNil((String)localObject1)) {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
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
                  break label915;
                }
                paramAnonymousa = z.a(paramAnonymousa.Fvk);
                if (!bt.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(23450);
                return;
                localObject1 = bw.M((String)localObject1, "sysmsg");
              } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
              localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
            } while ((bt.isNullOrNil((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
            String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
            String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
            l = bt.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
            localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
            String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
            String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
            i = bt.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
            localObject1 = ad.clt().acJ(str4);
          } while ((localObject1 == null) || (!bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!bt.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ad.clE();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.clE();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = bw.M(paramAnonymousa, "sysmsg");
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
          if ((bt.isNullOrNil(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = bt.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
          if (paramAnonymousa.equals("device_relation"))
          {
            paramAnonymousa = new dv();
            paramAnonymousa.doL.doM = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
          if (bt.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
            AppMethodBeat.o(23450);
            return;
          }
          try
          {
            paramAnonymousa = Base64.decode((String)localObject2, 0);
            if (bt.cC(paramAnonymousa))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
              AppMethodBeat.o(23450);
              return;
            }
          }
          catch (Exception paramAnonymousa)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(23450);
            return;
          }
          l = bt.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
          localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
          localObject1 = ad.clt().acJ((String)localObject1);
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.clV().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.ckT();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
          if (l < 0L) {
            break label922;
          }
        }
        label915:
        label922:
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
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.qdR = new ad.9(this);
    if (this.qdI == null) {
      this.qdI = new d();
    }
    if (this.qdH == null) {
      this.qdH = new e();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.IbL.c(this.qdH.qbt);
    AppMethodBeat.o(23454);
  }
  
  public static com.tencent.mm.aw.a.a.c acy(String paramString)
  {
    AppMethodBeat.i(23460);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = cls();
      if (paramString.qdN == null)
      {
        c.a locala = new c.a();
        com.tencent.mm.aw.q.aIK();
        locala.idJ = null;
        locala.hdS = 640;
        locala.hdR = 640;
        locala.idp = false;
        locala.idr = true;
        paramString.qdN = locala.aJc();
      }
      paramString = cls().qdN;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.hdS = 640;
    paramString.hdR = 640;
    paramString.idp = false;
    paramString.idq = true;
    ba.aBQ();
    paramString.prefixPath = com.tencent.mm.model.c.azA();
    paramString = paramString.aJc();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  public static d clA()
  {
    AppMethodBeat.i(23464);
    if (cls().qdI == null) {
      cls().qdI = new d();
    }
    d locald = cls().qdI;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c clB()
  {
    AppMethodBeat.i(23465);
    if (cls().qdJ == null) {
      cls().qdJ = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = cls().qdJ;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a clC()
  {
    AppMethodBeat.i(23466);
    if (cls().qdK == null) {
      cls().qdK = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = cls().qdK;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c clD()
  {
    AppMethodBeat.i(23467);
    if (cls().qdL == null) {
      cls().qdL = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = cls().qdL;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e clE()
  {
    AppMethodBeat.i(23468);
    if (cls().qdH == null) {
      cls().qdH = new e();
    }
    e locale = cls().qdH;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h clF()
  {
    AppMethodBeat.i(23471);
    if (cls().qdP == null) {
      cls().qdP = new h();
    }
    h localh = cls().qdP;
    AppMethodBeat.o(23471);
    return localh;
  }
  
  private static ad cls()
  {
    AppMethodBeat.i(23455);
    ba.aBK();
    ad localad2 = (ad)ca.By("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      ba.aBK().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(23455);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c clt()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdC == null)
    {
      localObject = cls();
      ba.aBQ();
      ((ad)localObject).qdC = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cls().qdC;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d clu()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdD == null)
    {
      localObject = cls();
      ba.aBQ();
      ((ad)localObject).qdD = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cls().qdD;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a clv()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdE == null)
    {
      localObject = cls();
      ba.aBQ();
      ((ad)localObject).qdE = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cls().qdE;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.aw.a.a clw()
  {
    AppMethodBeat.i(23459);
    if (cls().qdM == null) {
      cls().qdM = com.tencent.mm.aw.q.aIJ();
    }
    com.tencent.mm.aw.a.a locala = cls().qdM;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b clx()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdF == null)
    {
      localObject = cls();
      ba.aBQ();
      ((ad)localObject).qdF = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cls().qdF;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e cly()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdG == null)
    {
      localObject = cls();
      ba.aBQ();
      ((ad)localObject).qdG = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cls().qdG;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b clz()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (cls().qdB == null) {
      cls().qdB = new b();
    }
    b localb = cls().qdB;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23469);
    ba.aBQ();
    com.tencent.mm.model.c.azp().a(this.qdR);
    Object localObject = k.ckT();
    ba.aiU().a(538, (com.tencent.mm.al.f)localObject);
    this.qdO = new af();
    com.tencent.mm.sdk.b.a.IbL.c(this.qdA);
    ba.getSysCmdMsgExtension().a("wcdevicemsg", this.qdQ, true);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaU);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaV);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaW);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbp);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaT);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaS);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaX);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaY);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qaZ);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbq);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qba);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbb);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbc);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbe);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbd);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbi);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbg);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbh);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbj);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbr);
    com.tencent.mm.sdk.b.a.IbL.c(clE().nET);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbf);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbk);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbl);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbm);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbn);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbA);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbB);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbC);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbE);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbD);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbu);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbv);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbw);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbx);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qby);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbz);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbs);
    com.tencent.mm.sdk.b.a.IbL.c(clE().qbt);
    localObject = i.qcH;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    ba.aiU().a(539, (com.tencent.mm.al.f)localObject);
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
    ba.aBQ();
    com.tencent.mm.model.c.azp().b(this.qdR);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaU);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaV);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaW);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbp);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbr);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaT);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaS);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaX);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaY);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qaZ);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbq);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbA);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbB);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbC);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbE);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbD);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbu);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbv);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbw);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbx);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qby);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbz);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbb);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbs);
    com.tencent.mm.sdk.b.a.IbL.d(clE().qbt);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.clU();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).qgb != null) {
        break label630;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.ckT();
      ba.aiU().b(538, (com.tencent.mm.al.f)localObject1);
      k.qad = null;
      com.tencent.mm.sdk.b.a.IbL.d(this.qdA);
      ba.getSysCmdMsgExtension().b("wcdevicemsg", this.qdQ, true);
      com.tencent.mm.sdk.b.a.IbL.d(clE().qba);
      if (cls().qdB != null) {
        cls();
      }
      localObject1 = i.qcH;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      ba.aiU().b(539, (com.tencent.mm.al.f)localObject1);
      if ((((i)localObject1).fMu != null) && (((i)localObject1).fMu.isShowing()))
      {
        ((i)localObject1).fMu.dismiss();
        ((i)localObject1).fMu = null;
      }
      localObject1 = cls().qdI;
      if ((((d)localObject1).qaz == null) || (((d)localObject1).qaz.isEmpty())) {
        break label695;
      }
      Object localObject2 = ((d)localObject1).qaz.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((av)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label630:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).qgb.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.qgf = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).qaz.clear();
    label695:
    if (cls().qdJ != null)
    {
      localObject1 = cls().qdJ;
      ba.aiU().b(1042, (com.tencent.mm.al.f)localObject1);
      ba.aiU().b(1041, (com.tencent.mm.al.f)localObject1);
      ba.aiU().b(1043, (com.tencent.mm.al.f)localObject1);
      ba.aiU().b(1040, (com.tencent.mm.al.f)localObject1);
    }
    if (cls().qdM != null) {
      cls().qdM.detach();
    }
    localObject1 = this.qdO;
    com.tencent.mm.sdk.b.a.IbL.d(((af)localObject1).fFn);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.exdevice.a.b.class);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */