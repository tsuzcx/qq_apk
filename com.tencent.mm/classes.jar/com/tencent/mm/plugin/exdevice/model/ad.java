package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ad
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ab oWK;
  private b oWL;
  private com.tencent.mm.plugin.exdevice.i.c oWM;
  private com.tencent.mm.plugin.exdevice.g.b.b.d oWN;
  private com.tencent.mm.plugin.exdevice.g.b.b.a oWO;
  private com.tencent.mm.plugin.exdevice.g.b.b.b oWP;
  private com.tencent.mm.plugin.exdevice.g.b.b.e oWQ;
  private e oWR;
  private d oWS;
  private com.tencent.mm.plugin.exdevice.g.b.c oWT;
  private com.tencent.mm.plugin.exdevice.g.b.a oWU;
  private com.tencent.mm.plugin.exdevice.g.a.c oWV;
  private com.tencent.mm.aw.a.a oWW;
  private com.tencent.mm.aw.a.a.c oWX;
  private af oWY;
  private h oWZ;
  private cc.a oXa;
  n.b oXb;
  
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
    this.oWK = new ab();
    this.oWW = null;
    this.oWX = null;
    this.oXa = new cc.a()
    {
      public final void a(com.tencent.mm.al.f.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ad.bZM() != null)
        {
          ad.bZM();
          paramAnonymousa = paramAnonymousa.fTo;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.Cxz);
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
                paramAnonymousa = z.a(paramAnonymousa.Cxz);
                if (!bt.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(23450);
                return;
                localObject1 = bw.K((String)localObject1, "sysmsg");
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
            localObject1 = ad.bZG().UR(str4);
          } while ((localObject1 == null) || (!bt.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!bt.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ad.bZR();
            e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.bZR();
            e.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = bw.K(paramAnonymousa, "sysmsg");
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
            paramAnonymousa = new dr();
            paramAnonymousa.dfU.dfV = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousa);
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
            if (bt.cw(paramAnonymousa))
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
          localObject1 = ad.bZG().UR((String)localObject1);
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.cai().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.bZg();
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
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.oXb = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, final Object paramAnonymousObject)
      {
        AppMethodBeat.i(23452);
        try
        {
          if (!az.afw())
          {
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
            AppMethodBeat.o(23452);
            return;
          }
          if ((paramAnonymousObject instanceof String)) {
            az.afE().m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23451);
                String str = (String)paramAnonymousObject;
                if (ad.bZI().UL(str))
                {
                  az.arV();
                  if (!com.tencent.mm.model.c.apM().aHT(str)) {
                    az.aeS().a(new com.tencent.mm.plugin.exdevice.g.a.h(str, null), 0);
                  }
                }
                AppMethodBeat.o(23451);
              }
            }, 2000L);
          }
          AppMethodBeat.o(23452);
          return;
        }
        catch (Exception paramAnonymousn)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramAnonymousn.getMessage() });
          AppMethodBeat.o(23452);
        }
      }
    };
    if (this.oWS == null) {
      this.oWS = new d();
    }
    if (this.oWR == null) {
      this.oWR = new e();
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.ESL.c(this.oWR.oUD);
    AppMethodBeat.o(23454);
  }
  
  public static com.tencent.mm.aw.a.a.c UG(String paramString)
  {
    AppMethodBeat.i(23460);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = bZF();
      if (paramString.oWX == null)
      {
        c.a locala = new c.a();
        o.ayK();
        locala.hkl = null;
        locala.gjw = 640;
        locala.gjv = 640;
        locala.hjS = false;
        locala.hjU = true;
        paramString.oWX = locala.azc();
      }
      paramString = bZF().oWX;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.gjw = 640;
    paramString.gjv = 640;
    paramString.hjS = false;
    paramString.hjT = true;
    az.arV();
    paramString.prefixPath = com.tencent.mm.model.c.apW();
    paramString = paramString.azc();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  private static ad bZF()
  {
    AppMethodBeat.i(23455);
    az.arP();
    ad localad2 = (ad)bz.ut("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      az.arP().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(23455);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c bZG()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWM == null)
    {
      localObject = bZF();
      az.arV();
      ((ad)localObject).oWM = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.afg());
    }
    Object localObject = bZF().oWM;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d bZH()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWN == null)
    {
      localObject = bZF();
      az.arV();
      ((ad)localObject).oWN = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.afg());
    }
    Object localObject = bZF().oWN;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a bZI()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWO == null)
    {
      localObject = bZF();
      az.arV();
      ((ad)localObject).oWO = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.afg());
    }
    Object localObject = bZF().oWO;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.aw.a.a bZJ()
  {
    AppMethodBeat.i(23459);
    if (bZF().oWW == null) {
      bZF().oWW = o.ayJ();
    }
    com.tencent.mm.aw.a.a locala = bZF().oWW;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b bZK()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWP == null)
    {
      localObject = bZF();
      az.arV();
      ((ad)localObject).oWP = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.afg());
    }
    Object localObject = bZF().oWP;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e bZL()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWQ == null)
    {
      localObject = bZF();
      az.arV();
      ((ad)localObject).oWQ = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.afg());
    }
    Object localObject = bZF().oWQ;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b bZM()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.g.afz().aeD();
    if (bZF().oWL == null) {
      bZF().oWL = new b();
    }
    b localb = bZF().oWL;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static d bZN()
  {
    AppMethodBeat.i(23464);
    if (bZF().oWS == null) {
      bZF().oWS = new d();
    }
    d locald = bZF().oWS;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c bZO()
  {
    AppMethodBeat.i(23465);
    if (bZF().oWT == null) {
      bZF().oWT = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = bZF().oWT;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a bZP()
  {
    AppMethodBeat.i(23466);
    if (bZF().oWU == null) {
      bZF().oWU = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = bZF().oWU;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c bZQ()
  {
    AppMethodBeat.i(23467);
    if (bZF().oWV == null) {
      bZF().oWV = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = bZF().oWV;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e bZR()
  {
    AppMethodBeat.i(23468);
    if (bZF().oWR == null) {
      bZF().oWR = new e();
    }
    e locale = bZF().oWR;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h bZS()
  {
    AppMethodBeat.i(23471);
    if (bZF().oWZ == null) {
      bZF().oWZ = new h();
    }
    h localh = bZF().oWZ;
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
    az.arV();
    com.tencent.mm.model.c.apM().a(this.oXb);
    Object localObject = k.bZg();
    az.aeS().a(538, (com.tencent.mm.al.g)localObject);
    this.oWY = new af();
    com.tencent.mm.sdk.b.a.ESL.c(this.oWK);
    az.getSysCmdMsgExtension().a("wcdevicemsg", this.oXa, true);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUe);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUf);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUg);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUz);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUd);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUc);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUh);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUi);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUj);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUA);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUk);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUl);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUm);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUo);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUn);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUs);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUq);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUr);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUt);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUB);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().mCv);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUp);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUu);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUv);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUw);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUx);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUK);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUL);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUM);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUO);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUN);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUE);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUF);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUG);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUH);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUI);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUJ);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUC);
    com.tencent.mm.sdk.b.a.ESL.c(bZR().oUD);
    localObject = i.oVR;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    az.aeS().a(539, (com.tencent.mm.al.g)localObject);
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
    az.arV();
    com.tencent.mm.model.c.apM().b(this.oXb);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUe);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUf);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUg);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUz);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUB);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUd);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUc);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUh);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUi);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUj);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUA);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUK);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUL);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUM);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUO);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUN);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUE);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUF);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUG);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUH);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUI);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUJ);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUl);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUC);
    com.tencent.mm.sdk.b.a.ESL.d(bZR().oUD);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.cah();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((f)localObject1).oZl != null) {
        break label630;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.bZg();
      az.aeS().b(538, (com.tencent.mm.al.g)localObject1);
      k.oTn = null;
      com.tencent.mm.sdk.b.a.ESL.d(this.oWK);
      az.getSysCmdMsgExtension().b("wcdevicemsg", this.oXa, true);
      com.tencent.mm.sdk.b.a.ESL.d(bZR().oUk);
      if (bZF().oWL != null) {
        bZF();
      }
      localObject1 = i.oVR;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      az.aeS().b(539, (com.tencent.mm.al.g)localObject1);
      if ((((i)localObject1).fpP != null) && (((i)localObject1).fpP.isShowing()))
      {
        ((i)localObject1).fpP.dismiss();
        ((i)localObject1).fpP = null;
      }
      localObject1 = bZF().oWS;
      if ((((d)localObject1).oTJ == null) || (((d)localObject1).oTJ.isEmpty())) {
        break label695;
      }
      Object localObject2 = ((d)localObject1).oTJ.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((av)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label630:
      localObject1 = ((f)localObject1).oZl.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        com.tencent.mm.plugin.exdevice.service.f.a locala = (com.tencent.mm.plugin.exdevice.service.f.a)((Map.Entry)localObject2).getValue();
        locala.oZp = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).oTJ.clear();
    label695:
    if (bZF().oWT != null)
    {
      localObject1 = bZF().oWT;
      az.aeS().b(1042, (com.tencent.mm.al.g)localObject1);
      az.aeS().b(1041, (com.tencent.mm.al.g)localObject1);
      az.aeS().b(1043, (com.tencent.mm.al.g)localObject1);
      az.aeS().b(1040, (com.tencent.mm.al.g)localObject1);
    }
    if (bZF().oWW != null) {
      bZF().oWW.detach();
    }
    localObject1 = this.oWY;
    com.tencent.mm.sdk.b.a.ESL.d(((af)localObject1).fjL);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.exdevice.a.b.class);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */