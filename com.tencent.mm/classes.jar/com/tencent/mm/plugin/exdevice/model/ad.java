package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ad
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ab qkf;
  private b qkg;
  private com.tencent.mm.plugin.exdevice.i.c qkh;
  private com.tencent.mm.plugin.exdevice.g.b.b.d qki;
  private com.tencent.mm.plugin.exdevice.g.b.b.a qkj;
  private com.tencent.mm.plugin.exdevice.g.b.b.b qkk;
  private com.tencent.mm.plugin.exdevice.g.b.b.e qkl;
  private e qkm;
  private d qkn;
  private com.tencent.mm.plugin.exdevice.g.b.c qko;
  private com.tencent.mm.plugin.exdevice.g.b.a qkp;
  private com.tencent.mm.plugin.exdevice.g.a.c qkq;
  private com.tencent.mm.av.a.a qkr;
  private com.tencent.mm.av.a.a.c qks;
  private af qkt;
  private h qku;
  private cf.a qkv;
  n.b qkw;
  
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
    this.qkf = new ab();
    this.qkr = null;
    this.qks = null;
    this.qkv = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ad.cmP() != null)
        {
          ad.cmP();
          paramAnonymousa = paramAnonymousa.gte;
          ae.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.FNI);
          if (bu.isNullOrNil((String)localObject1)) {
            ae.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
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
                paramAnonymousa = z.a(paramAnonymousa.FNI);
                if (!bu.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                ae.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(23450);
                return;
                localObject1 = bx.M((String)localObject1, "sysmsg");
              } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
              localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
            } while ((bu.isNullOrNil((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
            String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
            String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
            l = bu.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
            localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
            String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
            String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
            i = bu.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
            ae.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
            localObject1 = ad.cmJ().adA(str4);
          } while ((localObject1 == null) || (!bu.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!bu.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ad.cmU();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.cmU();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = bx.M(paramAnonymousa, "sysmsg");
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            ae.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
          if ((bu.isNullOrNil(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
          {
            ae.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = bu.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
          ae.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
          if (paramAnonymousa.equals("device_relation"))
          {
            paramAnonymousa = new dw();
            paramAnonymousa.dpQ.dpR = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
          ae.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
          if (bu.isNullOrNil((String)localObject2))
          {
            ae.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
            AppMethodBeat.o(23450);
            return;
          }
          try
          {
            paramAnonymousa = Base64.decode((String)localObject2, 0);
            if (bu.cF(paramAnonymousa))
            {
              ae.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
              AppMethodBeat.o(23450);
              return;
            }
          }
          catch (Exception paramAnonymousa)
          {
            ae.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
            ae.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(23450);
            return;
          }
          l = bu.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
          localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
          ae.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
          localObject1 = ad.cmJ().adA((String)localObject1);
          if (localObject1 == null)
          {
            ae.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.cnl().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.cmj();
          ae.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
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
    this.qkw = new ad.9(this);
    if (this.qkn == null) {
      this.qkn = new d();
    }
    if (this.qkm == null) {
      this.qkm = new e();
    }
    ae.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.IvT.c(this.qkm.qhY);
    AppMethodBeat.o(23454);
  }
  
  public static com.tencent.mm.av.a.a.c adp(String paramString)
  {
    AppMethodBeat.i(23460);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = cmI();
      if (paramString.qks == null)
      {
        c.a locala = new c.a();
        com.tencent.mm.av.q.aJc();
        locala.igB = null;
        locala.hgG = 640;
        locala.hgF = 640;
        locala.igi = false;
        locala.igk = true;
        paramString.qks = locala.aJu();
      }
      paramString = cmI().qks;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.hgG = 640;
    paramString.hgF = 640;
    paramString.igi = false;
    paramString.igj = true;
    bc.aCg();
    paramString.prefixPath = com.tencent.mm.model.c.azQ();
    paramString = paramString.aJu();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  private static ad cmI()
  {
    AppMethodBeat.i(23455);
    bc.aCa();
    ad localad2 = (ad)cc.Ca("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      ae.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      bc.aCa().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(23455);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c cmJ()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qkh == null)
    {
      localObject = cmI();
      bc.aCg();
      ((ad)localObject).qkh = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cmI().qkh;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d cmK()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qki == null)
    {
      localObject = cmI();
      bc.aCg();
      ((ad)localObject).qki = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cmI().qki;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a cmL()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qkj == null)
    {
      localObject = cmI();
      bc.aCg();
      ((ad)localObject).qkj = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cmI().qkj;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.av.a.a cmM()
  {
    AppMethodBeat.i(23459);
    if (cmI().qkr == null) {
      cmI().qkr = com.tencent.mm.av.q.aJb();
    }
    com.tencent.mm.av.a.a locala = cmI().qkr;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b cmN()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qkk == null)
    {
      localObject = cmI();
      bc.aCg();
      ((ad)localObject).qkk = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cmI().qkk;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e cmO()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qkl == null)
    {
      localObject = cmI();
      bc.aCg();
      ((ad)localObject).qkl = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = cmI().qkl;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b cmP()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (cmI().qkg == null) {
      cmI().qkg = new b();
    }
    b localb = cmI().qkg;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static d cmQ()
  {
    AppMethodBeat.i(23464);
    if (cmI().qkn == null) {
      cmI().qkn = new d();
    }
    d locald = cmI().qkn;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c cmR()
  {
    AppMethodBeat.i(23465);
    if (cmI().qko == null) {
      cmI().qko = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = cmI().qko;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a cmS()
  {
    AppMethodBeat.i(23466);
    if (cmI().qkp == null) {
      cmI().qkp = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = cmI().qkp;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c cmT()
  {
    AppMethodBeat.i(23467);
    if (cmI().qkq == null) {
      cmI().qkq = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = cmI().qkq;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e cmU()
  {
    AppMethodBeat.i(23468);
    if (cmI().qkm == null) {
      cmI().qkm = new e();
    }
    e locale = cmI().qkm;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h cmV()
  {
    AppMethodBeat.i(23471);
    if (cmI().qku == null) {
      cmI().qku = new h();
    }
    h localh = cmI().qku;
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
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.qkw);
    Object localObject = k.cmj();
    bc.ajj().a(538, (com.tencent.mm.ak.f)localObject);
    this.qkt = new af();
    com.tencent.mm.sdk.b.a.IvT.c(this.qkf);
    bc.getSysCmdMsgExtension().a("wcdevicemsg", this.qkv, true);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhz);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhA);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhB);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhU);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhy);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhx);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhC);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhD);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhE);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhV);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhF);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhG);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhH);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhJ);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhI);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhN);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhL);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhM);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhO);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhW);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().nKo);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhK);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhP);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhQ);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhR);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhS);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qif);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qig);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qih);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qij);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qii);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhZ);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qia);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qib);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qic);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qid);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qie);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhX);
    com.tencent.mm.sdk.b.a.IvT.c(cmU().qhY);
    localObject = i.qjm;
    ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    bc.ajj().a(539, (com.tencent.mm.ak.f)localObject);
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
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.qkw);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhz);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhA);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhB);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhU);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhW);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhy);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhx);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhC);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhD);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhE);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhV);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qif);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qig);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qih);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qij);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qii);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhZ);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qia);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qib);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qic);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qid);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qie);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhG);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhX);
    com.tencent.mm.sdk.b.a.IvT.d(cmU().qhY);
    ae.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = ak.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.cnk();
      ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).qmG != null) {
        break label630;
      }
      ae.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.cmj();
      bc.ajj().b(538, (com.tencent.mm.ak.f)localObject1);
      k.qgI = null;
      com.tencent.mm.sdk.b.a.IvT.d(this.qkf);
      bc.getSysCmdMsgExtension().b("wcdevicemsg", this.qkv, true);
      com.tencent.mm.sdk.b.a.IvT.d(cmU().qhF);
      if (cmI().qkg != null) {
        cmI();
      }
      localObject1 = i.qjm;
      ae.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      bc.ajj().b(539, (com.tencent.mm.ak.f)localObject1);
      if ((((i)localObject1).fOC != null) && (((i)localObject1).fOC.isShowing()))
      {
        ((i)localObject1).fOC.dismiss();
        ((i)localObject1).fOC = null;
      }
      localObject1 = cmI().qkn;
      if ((((d)localObject1).qhe == null) || (((d)localObject1).qhe.isEmpty())) {
        break label695;
      }
      Object localObject2 = ((d)localObject1).qhe.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((aw)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      ae.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label630:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).qmG.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.qmK = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).qhe.clear();
    label695:
    if (cmI().qko != null)
    {
      localObject1 = cmI().qko;
      bc.ajj().b(1042, (com.tencent.mm.ak.f)localObject1);
      bc.ajj().b(1041, (com.tencent.mm.ak.f)localObject1);
      bc.ajj().b(1043, (com.tencent.mm.ak.f)localObject1);
      bc.ajj().b(1040, (com.tencent.mm.ak.f)localObject1);
    }
    if (cmI().qkr != null) {
      cmI().qkr.detach();
    }
    localObject1 = this.qkt;
    com.tencent.mm.sdk.b.a.IvT.d(((af)localObject1).fHr);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.exdevice.a.b.class);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */