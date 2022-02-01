package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.g.a.ds;
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
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bj;
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
  private com.tencent.mm.plugin.exdevice.g.b.b.b pAa;
  private com.tencent.mm.plugin.exdevice.g.b.b.e pAb;
  private e pAc;
  private d pAd;
  private com.tencent.mm.plugin.exdevice.g.b.c pAe;
  private com.tencent.mm.plugin.exdevice.g.b.a pAf;
  private com.tencent.mm.plugin.exdevice.g.a.c pAg;
  private com.tencent.mm.av.a.a pAh;
  private com.tencent.mm.av.a.a.c pAi;
  private af pAj;
  private h pAk;
  private cc.a pAl;
  n.b pAm;
  private ab pzV;
  private b pzW;
  private com.tencent.mm.plugin.exdevice.i.c pzX;
  private com.tencent.mm.plugin.exdevice.g.b.b.d pzY;
  private com.tencent.mm.plugin.exdevice.g.b.b.a pzZ;
  
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
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.exdevice.g.b.b.c.SQL_CREATE;
      }
    });
    AppMethodBeat.o(23473);
  }
  
  public ad()
  {
    AppMethodBeat.i(23454);
    this.pzV = new ab();
    this.pAh = null;
    this.pAi = null;
    this.pAl = new cc.a()
    {
      public final void a(com.tencent.mm.ak.f.a paramAnonymousa)
      {
        AppMethodBeat.i(23450);
        Object localObject1;
        Object localObject2;
        long l;
        if (ad.cgV() != null)
        {
          ad.cgV();
          paramAnonymousa = paramAnonymousa.fXi;
          ac.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = z.a(paramAnonymousa.DPV);
          if (bs.isNullOrNil((String)localObject1)) {
            ac.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
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
                paramAnonymousa = z.a(paramAnonymousa.DPV);
                if (!bs.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                ac.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(23450);
                return;
                localObject1 = bv.L((String)localObject1, "sysmsg");
              } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
              localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
            } while ((bs.isNullOrNil((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
            String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
            String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
            l = bs.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
            localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
            String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
            String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
            i = bs.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
            ac.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
            localObject1 = ad.cgP().Zd(str4);
          } while ((localObject1 == null) || (!bs.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!bs.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ad.cha();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ad.cha();
            e.e(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = bv.L(paramAnonymousa, "sysmsg");
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            ac.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
          if ((bs.isNullOrNil(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
          {
            ac.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
            AppMethodBeat.o(23450);
            return;
          }
          paramAnonymousa = bs.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
          ac.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
          if (paramAnonymousa.equals("device_relation"))
          {
            paramAnonymousa = new ds();
            paramAnonymousa.ddp.ddq = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
          ac.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
          if (bs.isNullOrNil((String)localObject2))
          {
            ac.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
            AppMethodBeat.o(23450);
            return;
          }
          try
          {
            paramAnonymousa = Base64.decode((String)localObject2, 0);
            if (bs.cv(paramAnonymousa))
            {
              ac.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
              AppMethodBeat.o(23450);
              return;
            }
          }
          catch (Exception paramAnonymousa)
          {
            ac.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
            ac.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(23450);
            return;
          }
          l = bs.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
          localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
          ac.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
          localObject1 = ad.cgP().Zd((String)localObject1);
          if (localObject1 == null)
          {
            ac.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(23450);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.chr().a(paramAnonymousa);
            AppMethodBeat.o(23450);
            return;
          }
          localObject1 = k.cgp();
          ac.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
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
    this.pAm = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, final Object paramAnonymousObject)
      {
        AppMethodBeat.i(23452);
        try
        {
          if (!az.agM())
          {
            ac.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
            AppMethodBeat.o(23452);
            return;
          }
          if ((paramAnonymousObject instanceof String)) {
            az.agU().m(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23451);
                String str = (String)paramAnonymousObject;
                if (ad.cgR().YX(str))
                {
                  az.ayM();
                  if (!com.tencent.mm.model.c.awB().aNo(str)) {
                    az.agi().a(new com.tencent.mm.plugin.exdevice.g.a.h(str, null), 0);
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
          ac.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramAnonymousn.getMessage() });
          AppMethodBeat.o(23452);
        }
      }
    };
    if (this.pAd == null) {
      this.pAd = new d();
    }
    if (this.pAc == null) {
      this.pAc = new e();
    }
    ac.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    com.tencent.mm.sdk.b.a.GpY.c(this.pAc.pxO);
    AppMethodBeat.o(23454);
  }
  
  public static com.tencent.mm.av.a.a.c YS(String paramString)
  {
    AppMethodBeat.i(23460);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = cgO();
      if (paramString.pAi == null)
      {
        c.a locala = new c.a();
        o.aFC();
        locala.hKO = null;
        locala.gKh = 640;
        locala.gKg = 640;
        locala.hKv = false;
        locala.hKx = true;
        paramString.pAi = locala.aFT();
      }
      paramString = cgO().pAi;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.gKh = 640;
    paramString.gKg = 640;
    paramString.hKv = false;
    paramString.hKw = true;
    az.ayM();
    paramString.prefixPath = com.tencent.mm.model.c.awL();
    paramString = paramString.aFT();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  private static ad cgO()
  {
    AppMethodBeat.i(23455);
    az.ayG();
    ad localad2 = (ad)bz.yz("plugin.exdevice");
    ad localad1 = localad2;
    if (localad2 == null)
    {
      ac.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localad1 = new ad();
      az.ayG().a("plugin.exdevice", localad1);
    }
    AppMethodBeat.o(23455);
    return localad1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c cgP()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pzX == null)
    {
      localObject = cgO();
      az.ayM();
      ((ad)localObject).pzX = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.agw());
    }
    Object localObject = cgO().pzX;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d cgQ()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pzY == null)
    {
      localObject = cgO();
      az.ayM();
      ((ad)localObject).pzY = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.agw());
    }
    Object localObject = cgO().pzY;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a cgR()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pzZ == null)
    {
      localObject = cgO();
      az.ayM();
      ((ad)localObject).pzZ = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.agw());
    }
    Object localObject = cgO().pzZ;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.av.a.a cgS()
  {
    AppMethodBeat.i(23459);
    if (cgO().pAh == null) {
      cgO().pAh = o.aFB();
    }
    com.tencent.mm.av.a.a locala = cgO().pAh;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b cgT()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pAa == null)
    {
      localObject = cgO();
      az.ayM();
      ((ad)localObject).pAa = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.agw());
    }
    Object localObject = cgO().pAa;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e cgU()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pAb == null)
    {
      localObject = cgO();
      az.ayM();
      ((ad)localObject).pAb = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.agw());
    }
    Object localObject = cgO().pAb;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b cgV()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.g.agP().afT();
    if (cgO().pzW == null) {
      cgO().pzW = new b();
    }
    b localb = cgO().pzW;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static d cgW()
  {
    AppMethodBeat.i(23464);
    if (cgO().pAd == null) {
      cgO().pAd = new d();
    }
    d locald = cgO().pAd;
    AppMethodBeat.o(23464);
    return locald;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c cgX()
  {
    AppMethodBeat.i(23465);
    if (cgO().pAe == null) {
      cgO().pAe = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = cgO().pAe;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a cgY()
  {
    AppMethodBeat.i(23466);
    if (cgO().pAf == null) {
      cgO().pAf = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = cgO().pAf;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c cgZ()
  {
    AppMethodBeat.i(23467);
    if (cgO().pAg == null) {
      cgO().pAg = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = cgO().pAg;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static e cha()
  {
    AppMethodBeat.i(23468);
    if (cgO().pAc == null) {
      cgO().pAc = new e();
    }
    e locale = cgO().pAc;
    AppMethodBeat.o(23468);
    return locale;
  }
  
  public static h chb()
  {
    AppMethodBeat.i(23471);
    if (cgO().pAk == null) {
      cgO().pAk = new h();
    }
    h localh = cgO().pAk;
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
    az.ayM();
    com.tencent.mm.model.c.awB().a(this.pAm);
    Object localObject = k.cgp();
    az.agi().a(538, (com.tencent.mm.ak.g)localObject);
    this.pAj = new af();
    com.tencent.mm.sdk.b.a.GpY.c(this.pzV);
    az.getSysCmdMsgExtension().a("wcdevicemsg", this.pAl, true);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxp);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxq);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxr);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxK);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxo);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxn);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxs);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxt);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxu);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxL);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxv);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxw);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxx);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxz);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxy);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxD);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxB);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxC);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxE);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxM);
    com.tencent.mm.sdk.b.a.GpY.c(cha().nex);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxA);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxF);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxG);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxH);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxI);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxV);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxW);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxX);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxZ);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxY);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxP);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxQ);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxR);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxS);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxT);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxU);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxN);
    com.tencent.mm.sdk.b.a.GpY.c(cha().pxO);
    localObject = i.pzc;
    ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    az.agi().a(539, (com.tencent.mm.ak.g)localObject);
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
    az.ayM();
    com.tencent.mm.model.c.awB().b(this.pAm);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxp);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxq);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxr);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxK);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxM);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxo);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxn);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxs);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxt);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxu);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxL);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxV);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxW);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxX);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxZ);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxY);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxP);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxQ);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxR);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxS);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxT);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxU);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxw);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxN);
    com.tencent.mm.sdk.b.a.GpY.d(cha().pxO);
    ac.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = ai.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      ac.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = u.chq();
      ac.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((f)localObject1).pCw != null) {
        break label630;
      }
      ac.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = k.cgp();
      az.agi().b(538, (com.tencent.mm.ak.g)localObject1);
      k.pwy = null;
      com.tencent.mm.sdk.b.a.GpY.d(this.pzV);
      az.getSysCmdMsgExtension().b("wcdevicemsg", this.pAl, true);
      com.tencent.mm.sdk.b.a.GpY.d(cha().pxv);
      if (cgO().pzW != null) {
        cgO();
      }
      localObject1 = i.pzc;
      ac.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      az.agi().b(539, (com.tencent.mm.ak.g)localObject1);
      if ((((i)localObject1).fts != null) && (((i)localObject1).fts.isShowing()))
      {
        ((i)localObject1).fts.dismiss();
        ((i)localObject1).fts = null;
      }
      localObject1 = cgO().pAd;
      if ((((d)localObject1).pwU == null) || (((d)localObject1).pwU.isEmpty())) {
        break label695;
      }
      Object localObject2 = ((d)localObject1).pwU.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((au)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      ac.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label630:
      localObject1 = ((f)localObject1).pCw.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        com.tencent.mm.plugin.exdevice.service.f.a locala = (com.tencent.mm.plugin.exdevice.service.f.a)((Map.Entry)localObject2).getValue();
        locala.pCA = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((d)localObject1).pwU.clear();
    label695:
    if (cgO().pAe != null)
    {
      localObject1 = cgO().pAe;
      az.agi().b(1042, (com.tencent.mm.ak.g)localObject1);
      az.agi().b(1041, (com.tencent.mm.ak.g)localObject1);
      az.agi().b(1043, (com.tencent.mm.ak.g)localObject1);
      az.agi().b(1040, (com.tencent.mm.ak.g)localObject1);
    }
    if (cgO().pAh != null) {
      cgO().pAh.detach();
    }
    localObject1 = this.pAj;
    com.tencent.mm.sdk.b.a.GpY.d(((af)localObject1).fnf);
    com.tencent.mm.kernel.g.ac(com.tencent.mm.plugin.exdevice.a.b.class);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad
 * JD-Core Version:    0.7.0.1
 */