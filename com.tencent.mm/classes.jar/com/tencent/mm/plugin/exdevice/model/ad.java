package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.util.Base64;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.h.a.di;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.b.k.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ad
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private ab jwA = new ab();
  private b jwB;
  private com.tencent.mm.plugin.exdevice.h.c jwC;
  private com.tencent.mm.plugin.exdevice.f.b.b.d jwD;
  private com.tencent.mm.plugin.exdevice.f.b.b.a jwE;
  private com.tencent.mm.plugin.exdevice.f.b.b.b jwF;
  private com.tencent.mm.plugin.exdevice.f.b.b.e jwG;
  private e jwH;
  private d jwI;
  private com.tencent.mm.plugin.exdevice.f.b.c jwJ;
  private com.tencent.mm.plugin.exdevice.f.b.a jwK;
  private com.tencent.mm.plugin.exdevice.f.a.c jwL;
  private com.tencent.mm.as.a.a jwM = null;
  private com.tencent.mm.as.a.a.c jwN = null;
  private af jwO;
  private h jwP;
  private bx.a jwQ = new bx.a()
  {
    public final void a(e.a paramAnonymousa)
    {
      if (ad.aLR() != null)
      {
        ad.aLR();
        paramAnonymousa = paramAnonymousa.dBs;
        y.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
        localObject1 = aa.a(paramAnonymousa.svH);
        if (!bk.bl((String)localObject1)) {
          break label75;
        }
        y.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
      }
      int i;
      label75:
      do
      {
        do
        {
          do
          {
            i = 0;
            if (i == 0)
            {
              paramAnonymousa = aa.a(paramAnonymousa.svH);
              if (!bk.bl(paramAnonymousa)) {
                break;
              }
              y.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
            }
            return;
            localObject1 = bn.s((String)localObject1, "sysmsg");
          } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
          localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
        } while ((bk.bl((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
        String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
        String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
        l = bk.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
        localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
        String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
        String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
        i = bk.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
        y.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
        localObject1 = ad.aLL().BG(str4);
      } while ((localObject1 == null) || (!bk.pm(((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_connProto).contains("4")) || (!bk.pm((String)localObject2).contains("device_status")));
      if (i != 0)
      {
        ad.aLW();
        e.c(((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_deviceID);
      }
      for (;;)
      {
        i = 1;
        break;
        ad.aLW();
        e.c(((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_deviceID);
      }
      Object localObject1 = bn.s(paramAnonymousa, "sysmsg");
      if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
      {
        y.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
        return;
      }
      paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
      if ((bk.bl(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
      {
        y.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
        return;
      }
      paramAnonymousa = bk.pm((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
      y.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
      if (paramAnonymousa.equals("device_relation"))
      {
        paramAnonymousa = new di();
        paramAnonymousa.bJE.bJF = true;
        com.tencent.mm.sdk.b.a.udP.m(paramAnonymousa);
        return;
      }
      Object localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
      y.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
      if (bk.bl((String)localObject2))
      {
        y.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
        return;
      }
      try
      {
        paramAnonymousa = Base64.decode((String)localObject2, 0);
        if (bk.bE(paramAnonymousa))
        {
          y.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
          return;
        }
      }
      catch (Exception paramAnonymousa)
      {
        y.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
        y.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
        return;
      }
      long l = bk.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
      localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
      y.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
      localObject1 = ad.aLL().BG((String)localObject1);
      if (localObject1 == null)
      {
        y.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
        return;
      }
      if (0L == l)
      {
        paramAnonymousa = new com.tencent.mm.plugin.exdevice.i.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.h.b)localObject1).field_mac);
        u.aMn().a(paramAnonymousa);
        return;
      }
      localObject1 = k.aLm();
      y.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
      if (l >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        localObject2 = new k.c((byte)0);
        ((k.c)localObject2).mSessionId = l;
        ((k.c)localObject2).mData = paramAnonymousa;
        ((k)localObject1).mHandler.obtainMessage(3, localObject2).sendToTarget();
        return;
      }
    }
  };
  m.b jwR = new ad.9(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.plugin.exdevice.h.c.dXp;
      }
    });
    dgp.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new ad.3());
    dgp.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new ad.4());
    dgp.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new ad.5());
    dgp.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new ad.6());
    dgp.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ad.7());
  }
  
  public ad()
  {
    if (this.jwI == null) {
      this.jwI = new d();
    }
    if (this.jwH == null) {
      this.jwH = new e();
    }
    y.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.udP.c(this.jwH.jus);
  }
  
  public static com.tencent.mm.as.a.a.c Bv(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = aLK();
      if (paramString.jwN == null)
      {
        c.a locala = new c.a();
        o.OO();
        locala.erB = null;
        locala.erm = 640;
        locala.erl = 640;
        locala.erd = false;
        locala.erf = true;
        paramString.jwN = locala.OV();
      }
      return aLK().jwN;
    }
    paramString = new c.a();
    paramString.erm = 640;
    paramString.erl = 640;
    paramString.erd = false;
    paramString.ere = true;
    au.Hx();
    paramString.eri = com.tencent.mm.model.c.FG();
    return paramString.OV();
  }
  
  private static ad aLK()
  {
    au.Hq();
    ad localad2 = (ad)bu.iR("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      y.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      au.Hq().a("plugin.exdevice", localad1);
    }
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.h.c aLL()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwC == null)
    {
      ad localad = aLK();
      au.Hx();
      localad.jwC = new com.tencent.mm.plugin.exdevice.h.c(com.tencent.mm.model.c.Dv());
    }
    return aLK().jwC;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.d aLM()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwD == null)
    {
      ad localad = aLK();
      au.Hx();
      localad.jwD = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.model.c.Dv());
    }
    return aLK().jwD;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.a aLN()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwE == null)
    {
      ad localad = aLK();
      au.Hx();
      localad.jwE = new com.tencent.mm.plugin.exdevice.f.b.b.a(com.tencent.mm.model.c.Dv());
    }
    return aLK().jwE;
  }
  
  public static com.tencent.mm.as.a.a aLO()
  {
    if (aLK().jwM == null) {
      aLK().jwM = o.ON();
    }
    return aLK().jwM;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.b aLP()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwF == null)
    {
      ad localad = aLK();
      au.Hx();
      localad.jwF = new com.tencent.mm.plugin.exdevice.f.b.b.b(com.tencent.mm.model.c.Dv());
    }
    return aLK().jwF;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.b.e aLQ()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwG == null)
    {
      ad localad = aLK();
      au.Hx();
      localad.jwG = new com.tencent.mm.plugin.exdevice.f.b.b.e(com.tencent.mm.model.c.Dv());
    }
    return aLK().jwG;
  }
  
  public static b aLR()
  {
    com.tencent.mm.kernel.g.DN().CX();
    if (aLK().jwB == null) {
      aLK().jwB = new b();
    }
    return aLK().jwB;
  }
  
  public static d aLS()
  {
    if (aLK().jwI == null) {
      aLK().jwI = new d();
    }
    return aLK().jwI;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.c aLT()
  {
    if (aLK().jwJ == null) {
      aLK().jwJ = new com.tencent.mm.plugin.exdevice.f.b.c();
    }
    return aLK().jwJ;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.b.a aLU()
  {
    if (aLK().jwK == null) {
      aLK().jwK = new com.tencent.mm.plugin.exdevice.f.b.a();
    }
    return aLK().jwK;
  }
  
  public static com.tencent.mm.plugin.exdevice.f.a.c aLV()
  {
    if (aLK().jwL == null) {
      aLK().jwL = new com.tencent.mm.plugin.exdevice.f.a.c();
    }
    return aLK().jwL;
  }
  
  public static e aLW()
  {
    if (aLK().jwH == null) {
      aLK().jwH = new e();
    }
    return aLK().jwH;
  }
  
  public static h aLX()
  {
    if (aLK().jwP == null) {
      aLK().jwP = new h();
    }
    return aLK().jwP;
  }
  
  public final void bh(boolean paramBoolean)
  {
    au.Hx();
    com.tencent.mm.model.c.Fw().a(this.jwR);
    Object localObject = k.aLm();
    au.Dk().a(538, (com.tencent.mm.ah.f)localObject);
    this.jwO = new af();
    com.tencent.mm.sdk.b.a.udP.c(this.jwA);
    au.getSysCmdMsgExtension().a("wcdevicemsg", this.jwQ, true);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtT);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtU);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtV);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juo);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtS);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtR);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtW);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtX);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtY);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jup);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jtZ);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jua);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jub);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jud);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juc);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juh);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juf);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jug);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jui);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juq);
    com.tencent.mm.sdk.b.a.udP.c(aLW().hRD);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jue);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juj);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juk);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jul);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jum);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juz);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juA);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juB);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juD);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juC);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jut);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juu);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juv);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juw);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jux);
    com.tencent.mm.sdk.b.a.udP.c(aLW().juy);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jur);
    com.tencent.mm.sdk.b.a.udP.c(aLW().jus);
    localObject = i.jvG;
    y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    au.Dk().a(539, (com.tencent.mm.ah.f)localObject);
    com.tencent.mm.compatible.a.a.a(19, new a.a()
    {
      public final void run()
      {
        ad.a(ad.this);
      }
    });
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    au.Hx();
    com.tencent.mm.model.c.Fw().b(this.jwR);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtT);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtU);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtV);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juo);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juq);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtS);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtR);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtW);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtX);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jtY);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jup);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juz);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juA);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juB);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juD);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juC);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jut);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juu);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juv);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juw);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jux);
    com.tencent.mm.sdk.b.a.udP.d(aLW().juy);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jua);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jur);
    com.tencent.mm.sdk.b.a.udP.d(aLW().jus);
    y.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.aMm();
      y.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).jzb != null) {
        break label595;
      }
      y.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.aLm();
      au.Dk().b(538, (com.tencent.mm.ah.f)localObject1);
      k.jtc = null;
      com.tencent.mm.sdk.b.a.udP.d(this.jwA);
      au.getSysCmdMsgExtension().b("wcdevicemsg", this.jwQ, true);
      com.tencent.mm.sdk.b.a.udP.d(aLW().jtZ);
      if (aLK().jwB != null) {
        aLK();
      }
      localObject1 = i.jvG;
      y.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      au.Dk().b(539, (com.tencent.mm.ah.f)localObject1);
      localObject1 = aLK().jwI;
      if ((((d)localObject1).jty == null) || (((d)localObject1).jty.isEmpty())) {
        break label660;
      }
      Object localObject2 = ((d)localObject1).jty.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((am)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      y.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label595:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).jzb.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.jzf = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).jty.clear();
    label660:
    if (aLK().jwJ != null)
    {
      localObject1 = aLK().jwJ;
      au.Dk().b(1042, (com.tencent.mm.ah.f)localObject1);
      au.Dk().b(1041, (com.tencent.mm.ah.f)localObject1);
      au.Dk().b(1043, (com.tencent.mm.ah.f)localObject1);
      au.Dk().b(1040, (com.tencent.mm.ah.f)localObject1);
    }
    if (aLK().jwM != null) {
      aLK().jwM.detach();
    }
    localObject1 = this.jwO;
    com.tencent.mm.sdk.b.a.udP.d(((af)localObject1).dii);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */