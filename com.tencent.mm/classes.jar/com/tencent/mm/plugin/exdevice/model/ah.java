package com.tencent.mm.plugin.exdevice.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.eq;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.exdevice.c.k.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dlf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ah
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private SearchDeviceGetA8KeyRedirectListener ysH;
  private b ysI;
  private com.tencent.mm.plugin.exdevice.i.c ysJ;
  private com.tencent.mm.plugin.exdevice.i.g ysK;
  private com.tencent.mm.plugin.exdevice.i.e ysL;
  private com.tencent.mm.plugin.exdevice.g.b.b.d ysM;
  private com.tencent.mm.plugin.exdevice.g.b.b.a ysN;
  private com.tencent.mm.plugin.exdevice.g.b.b.b ysO;
  private com.tencent.mm.plugin.exdevice.g.b.b.e ysP;
  private g ysQ;
  private f ysR;
  private com.tencent.mm.plugin.exdevice.g.b.c ysS;
  private com.tencent.mm.plugin.exdevice.g.b.a ysT;
  private com.tencent.mm.plugin.exdevice.g.a.c ysU;
  private com.tencent.mm.modelimage.loader.a ysV;
  private com.tencent.mm.modelimage.loader.a.c ysW;
  private aj ysX;
  private j ysY;
  private cl.a ysZ;
  MStorageEx.IOnStorageChange yta;
  private t ytb;
  
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
    baseDBFactories.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new ah.10());
    baseDBFactories.put(Integer.valueOf("HARDIOTDEVICERANKDETAILINFO_TABLE".hashCode()), new ah.11());
    baseDBFactories.put(Integer.valueOf("HARDIOTCDNINFO_TABLE".hashCode()), new ah.12());
    AppMethodBeat.o(23473);
  }
  
  public ah()
  {
    AppMethodBeat.i(23454);
    this.ysH = new SearchDeviceGetA8KeyRedirectListener();
    this.ysV = null;
    this.ysW = null;
    this.ysZ = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(274625);
        Object localObject1;
        Object localObject2;
        long l;
        if (ah.dFX() != null)
        {
          ah.dFX();
          paramAnonymousa = paramAnonymousa.mpN;
          Log.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
          localObject1 = w.a(paramAnonymousa.YFG);
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
                  break label903;
                }
                paramAnonymousa = w.a(paramAnonymousa.YFG);
                if (!Util.isNullOrNil(paramAnonymousa)) {
                  break;
                }
                Log.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                AppMethodBeat.o(274625);
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
            localObject1 = ah.dFO().apI(str4);
          } while ((localObject1 == null) || (!Util.nullAsNil(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_connProto).contains("4")) || (!Util.nullAsNil((String)localObject2).contains("device_status")));
          if (i != 0)
          {
            ah.dGc();
            g.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 2, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          for (;;)
          {
            i = 1;
            break;
            ah.dGc();
            g.d(((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_brandName, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_url, 4, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_deviceID);
          }
          localObject1 = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
            AppMethodBeat.o(274625);
            return;
          }
          paramAnonymousa = (String)((Map)localObject1).get(".sysmsg.$type");
          if ((Util.isNullOrNil(paramAnonymousa)) || (!paramAnonymousa.equalsIgnoreCase("wcdevicemsg")))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
            AppMethodBeat.o(274625);
            return;
          }
          paramAnonymousa = Util.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { paramAnonymousa });
          if (paramAnonymousa.equals("device_relation"))
          {
            paramAnonymousa = new eq();
            paramAnonymousa.hEF.hEG = true;
            paramAnonymousa.publish();
            AppMethodBeat.o(274625);
            return;
          }
          localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
          if (Util.isNullOrNil((String)localObject2))
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
            AppMethodBeat.o(274625);
            return;
          }
          try
          {
            paramAnonymousa = Base64.decode((String)localObject2, 0);
            if (Util.isNullOrNil(paramAnonymousa))
            {
              Log.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
              AppMethodBeat.o(274625);
              return;
            }
          }
          catch (Exception paramAnonymousa)
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { paramAnonymousa.getMessage() });
            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", paramAnonymousa, "", new Object[0]);
            AppMethodBeat.o(274625);
            return;
          }
          l = Util.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
          localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
          Log.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(paramAnonymousa.length) });
          localObject1 = ah.dFO().apI((String)localObject1);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            AppMethodBeat.o(274625);
            return;
          }
          if (0L == l)
          {
            paramAnonymousa = new com.tencent.mm.plugin.exdevice.j.g(paramAnonymousa, 0, ((com.tencent.mm.plugin.exdevice.i.b)localObject1).field_mac);
            u.dGE().a(paramAnonymousa);
            AppMethodBeat.o(274625);
            return;
          }
          localObject1 = com.tencent.mm.plugin.exdevice.c.k.dFm();
          Log.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
          if (l < 0L) {
            break label909;
          }
        }
        label903:
        label909:
        for (boolean bool = true;; bool = false)
        {
          Assert.assertTrue(bool);
          localObject2 = new k.c((byte)0);
          ((k.c)localObject2).mSessionId = l;
          ((k.c)localObject2).mData = paramAnonymousa;
          ((com.tencent.mm.plugin.exdevice.c.k)localObject1).mHandler.obtainMessage(3, localObject2).sendToTarget();
          AppMethodBeat.o(274625);
          return;
        }
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.yta = new ah.2(this);
    this.ytb = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(274589);
        Log.i("MicroMsg.exdevice.SubCoreExDevice", "iLinkDeviceUpdateListener onNewXmlReceived");
        k.yrL.dFE();
        AppMethodBeat.o(274589);
      }
    };
    if (this.ysR == null) {
      this.ysR = new f();
    }
    if (this.ysQ == null) {
      this.ysQ = new g();
    }
    Log.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
    this.ysQ.yqy.alive();
    AppMethodBeat.o(23454);
  }
  
  public static void Lf(int paramInt)
  {
    AppMethodBeat.i(274600);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acKu, Integer.valueOf(paramInt));
    AppMethodBeat.o(274600);
  }
  
  public static void a(com.tencent.mm.plugin.exdevice.i.d paramd)
  {
    AppMethodBeat.i(274610);
    dFQ().replace(paramd);
    AppMethodBeat.o(274610);
  }
  
  public static void ac(LinkedList<dlf> paramLinkedList)
  {
    AppMethodBeat.i(274607);
    Object localObject1 = dFP().dGJ();
    Log.i("MicroMsg.exdevice.HardIotDeviceInfoStorage", "iotDevice old size = %d new size = %d", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(paramLinkedList.size()) });
    localObject1 = ((List)localObject1).iterator();
    label561:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.exdevice.i.f)((Iterator)localObject1).next();
        localObject3 = paramLinkedList.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!((dlf)((Iterator)localObject3).next()).ZQS.equals(((com.tencent.mm.plugin.exdevice.i.f)localObject2).field_deviceId));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label561;
        }
        Log.i("MicroMsg.exdevice.HardIotDeviceInfoStorage", "delete iot deviceId %s, deviceType %s ", new Object[] { ((com.tencent.mm.plugin.exdevice.i.f)localObject2).field_deviceId, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.f)localObject2).field_deviceType) });
        dFP().delete((IAutoDBItem)localObject2, new String[0]);
        break;
        localObject1 = paramLinkedList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dlf)((Iterator)localObject1).next();
          localObject3 = dFP();
          paramLinkedList = ((dlf)localObject2).ZQS;
          if (Util.isNullOrNil(paramLinkedList)) {
            paramLinkedList = null;
          }
          for (;;)
          {
            localObject3 = new com.tencent.mm.plugin.exdevice.i.f();
            ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_deviceId = ((dlf)localObject2).ZQS;
            ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_deviceType = ((dlf)localObject2).aaRi;
            ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_iconUrl = ((dlf)localObject2).icon_url;
            ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_nickName = ((dlf)localObject2).nickname;
            Object localObject4 = ((dlf)localObject2).aaRj;
            localObject2 = new StringBuffer();
            if ((localObject4 == null) || (((LinkedList)localObject4).size() <= 0)) {
              break label445;
            }
            localObject4 = ((LinkedList)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              ((StringBuffer)localObject2).append((Integer)((Iterator)localObject4).next());
              ((StringBuffer)localObject2).append(" ");
            }
            localObject3 = ((com.tencent.mm.plugin.exdevice.i.g)localObject3).db.query("HardIotDeviceInfo", null, "deviceId=?", new String[] { paramLinkedList }, null, null, null, 2);
            if (localObject3 == null)
            {
              paramLinkedList = null;
            }
            else if (!((Cursor)localObject3).moveToFirst())
            {
              Log.w("MicroMsg.exdevice.HardIotDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(paramLinkedList)));
              ((Cursor)localObject3).close();
              paramLinkedList = null;
            }
            else
            {
              paramLinkedList = new com.tencent.mm.plugin.exdevice.i.f();
              paramLinkedList.convertFrom((Cursor)localObject3);
              ((Cursor)localObject3).close();
            }
          }
          ((StringBuffer)localObject2).trimToSize();
          label445:
          ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_supportMsgTypeList = ((StringBuffer)localObject2).toString().replace(" ", ",");
          if (paramLinkedList == null) {}
          for (boolean bool = dFP().insert((IAutoDBItem)localObject3);; bool = dFP().update((IAutoDBItem)localObject3, new String[0]))
          {
            Log.i("MicroMsg.exdevice.HardIotDeviceInfoStorage", "update deviceId %s, deviceType = %d, nickName = %s, supportMsgTypeList = %s ret = %b", new Object[] { ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_deviceId, Integer.valueOf(((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_deviceType), ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_nickName, ((com.tencent.mm.plugin.exdevice.i.f)localObject3).field_supportMsgTypeList, Boolean.valueOf(bool) });
            break;
          }
        }
        AppMethodBeat.o(274607);
        return;
      }
    }
  }
  
  public static com.tencent.mm.modelimage.loader.a.c apx(String paramString)
  {
    AppMethodBeat.i(23460);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
      paramString = dFN();
      if (paramString.ysW == null)
      {
        c.a locala = new c.a();
        locala.oKH = r.bKf();
        locala.npV = 640;
        locala.npU = 640;
        locala.oKn = false;
        locala.oKp = true;
        paramString.ysW = locala.bKx();
      }
      paramString = dFN().ysW;
      AppMethodBeat.o(23460);
      return paramString;
    }
    paramString = new c.a();
    paramString.npV = 640;
    paramString.npU = 640;
    paramString.oKn = false;
    paramString.oKo = true;
    bh.bCz();
    paramString.prefixPath = com.tencent.mm.model.c.bzL();
    paramString = paramString.bKx();
    AppMethodBeat.o(23460);
    return paramString;
  }
  
  private static ah dFN()
  {
    AppMethodBeat.i(23455);
    bh.bCt();
    ah localah2 = (ah)ci.Ka("plugin.exdevice");
    ah localah1 = localah2;
    if (localah2 == null)
    {
      Log.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
      localah1 = new ah();
      bh.bCt().a("plugin.exdevice", localah1);
    }
    AppMethodBeat.o(23455);
    return localah1;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.c dFO()
  {
    AppMethodBeat.i(23456);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysJ == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysJ = new com.tencent.mm.plugin.exdevice.i.c(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysJ;
    AppMethodBeat.o(23456);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.g dFP()
  {
    AppMethodBeat.i(274595);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysK == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysK = new com.tencent.mm.plugin.exdevice.i.g(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysK;
    AppMethodBeat.o(274595);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.e dFQ()
  {
    AppMethodBeat.i(274597);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysL == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysL = new com.tencent.mm.plugin.exdevice.i.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysL;
    AppMethodBeat.o(274597);
    return localObject;
  }
  
  public static int dFR()
  {
    AppMethodBeat.i(274608);
    com.tencent.mm.kernel.h.baF();
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acKu, 0);
    AppMethodBeat.o(274608);
    return i;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.d dFS()
  {
    AppMethodBeat.i(23457);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysM == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysM = new com.tencent.mm.plugin.exdevice.g.b.b.d(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysM;
    AppMethodBeat.o(23457);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.a dFT()
  {
    AppMethodBeat.i(23458);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysN == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysN = new com.tencent.mm.plugin.exdevice.g.b.b.a(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysN;
    AppMethodBeat.o(23458);
    return localObject;
  }
  
  public static com.tencent.mm.modelimage.loader.a dFU()
  {
    AppMethodBeat.i(23459);
    if (dFN().ysV == null) {
      dFN().ysV = r.bKe();
    }
    com.tencent.mm.modelimage.loader.a locala = dFN().ysV;
    AppMethodBeat.o(23459);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.b dFV()
  {
    AppMethodBeat.i(23461);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysO == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysO = new com.tencent.mm.plugin.exdevice.g.b.b.b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysO;
    AppMethodBeat.o(23461);
    return localObject;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.b.e dFW()
  {
    AppMethodBeat.i(23462);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysP == null)
    {
      localObject = dFN();
      bh.bCz();
      ((ah)localObject).ysP = new com.tencent.mm.plugin.exdevice.g.b.b.e(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = dFN().ysP;
    AppMethodBeat.o(23462);
    return localObject;
  }
  
  public static b dFX()
  {
    AppMethodBeat.i(23463);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (dFN().ysI == null) {
      dFN().ysI = new b();
    }
    b localb = dFN().ysI;
    AppMethodBeat.o(23463);
    return localb;
  }
  
  public static f dFY()
  {
    AppMethodBeat.i(23464);
    if (dFN().ysR == null) {
      dFN().ysR = new f();
    }
    f localf = dFN().ysR;
    AppMethodBeat.o(23464);
    return localf;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.c dFZ()
  {
    AppMethodBeat.i(23465);
    if (dFN().ysS == null) {
      dFN().ysS = new com.tencent.mm.plugin.exdevice.g.b.c();
    }
    com.tencent.mm.plugin.exdevice.g.b.c localc = dFN().ysS;
    AppMethodBeat.o(23465);
    return localc;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a dGa()
  {
    AppMethodBeat.i(23466);
    if (dFN().ysT == null) {
      dFN().ysT = new com.tencent.mm.plugin.exdevice.g.b.a();
    }
    com.tencent.mm.plugin.exdevice.g.b.a locala = dFN().ysT;
    AppMethodBeat.o(23466);
    return locala;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.a.c dGb()
  {
    AppMethodBeat.i(23467);
    if (dFN().ysU == null) {
      dFN().ysU = new com.tencent.mm.plugin.exdevice.g.a.c();
    }
    com.tencent.mm.plugin.exdevice.g.a.c localc = dFN().ysU;
    AppMethodBeat.o(23467);
    return localc;
  }
  
  public static g dGc()
  {
    AppMethodBeat.i(23468);
    if (dFN().ysQ == null) {
      dFN().ysQ = new g();
    }
    g localg = dFN().ysQ;
    AppMethodBeat.o(23468);
    return localg;
  }
  
  public static j dGd()
  {
    AppMethodBeat.i(23471);
    if (dFN().ysY == null) {
      dFN().ysY = new j();
    }
    j localj = dFN().ysY;
    AppMethodBeat.o(23471);
    return localj;
  }
  
  public static com.tencent.mm.plugin.exdevice.i.d lw(long paramLong)
  {
    AppMethodBeat.i(274612);
    Cursor localCursor = dFQ().db.query("HardIotCdnInfo", null, "msgid=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(274612);
      return null;
    }
    if (!localCursor.moveToFirst())
    {
      Log.w("MicroMsg.exdevice.HardIotCdnInfoStorage", "get null with msgId:".concat(String.valueOf(paramLong)));
      localCursor.close();
      AppMethodBeat.o(274612);
      return null;
    }
    com.tencent.mm.plugin.exdevice.i.d locald = new com.tencent.mm.plugin.exdevice.i.d();
    locald.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(274612);
    return locald;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23469);
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.yta);
    Object localObject = com.tencent.mm.plugin.exdevice.c.k.dFm();
    bh.aZW().a(538, (com.tencent.mm.am.h)localObject);
    this.ysX = new aj();
    this.ysH.alive();
    bh.getSysCmdMsgExtension().a("wcdevicemsg", this.ysZ, true);
    dGc().ypY.alive();
    dGc().ypZ.alive();
    dGc().yqa.alive();
    dGc().yqu.alive();
    dGc().ypX.alive();
    dGc().ypW.alive();
    dGc().yqb.alive();
    dGc().yqc.alive();
    ((com.tencent.mm.u.c)MvvmEventCenter.getEvent(com.tencent.mm.u.c.class)).observe(com.tencent.mm.kernel.h.baC().mBP, "MicroMsg.exdevice.SubCoreExDevice", dGc().yqd);
    dGc().yqv.alive();
    dGc().yqe.alive();
    dGc().yqf.alive();
    dGc().yqg.alive();
    dGc().yqh.alive();
    dGc().yqj.alive();
    dGc().yqi.alive();
    dGc().yqn.alive();
    dGc().yql.alive();
    dGc().yqm.alive();
    dGc().yqo.alive();
    dGc().yqw.alive();
    dGc().viz.alive();
    dGc().yqk.alive();
    dGc().yqp.alive();
    dGc().yqq.alive();
    dGc().yqr.alive();
    dGc().yqs.alive();
    dGc().yqF.alive();
    dGc().yqG.alive();
    dGc().yqH.alive();
    dGc().yqJ.alive();
    dGc().yqI.alive();
    dGc().yqz.alive();
    dGc().yqA.alive();
    dGc().yqB.alive();
    dGc().yqC.alive();
    dGc().yqD.alive();
    dGc().yqE.alive();
    dGc().yqx.alive();
    dGc().yqy.alive();
    localObject = k.yrL;
    Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
    bh.aZW().a(539, (com.tencent.mm.am.h)localObject);
    bh.aZW().a(6693, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.compatible.a.a.a(19, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(274590);
        ah.a(ah.this);
        AppMethodBeat.o(274590);
      }
    });
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.exdevice.a.b.class, new com.tencent.mm.plugin.exdevice.a.a());
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("ilink_device_update", this.ytb);
    AppMethodBeat.o(23469);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23470);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.yta);
    dGc().ypY.dead();
    dGc().ypZ.dead();
    dGc().yqa.dead();
    dGc().yqu.dead();
    dGc().yqw.dead();
    dGc().ypX.dead();
    dGc().ypW.dead();
    dGc().yqb.dead();
    dGc().yqc.dead();
    dGc().yqv.dead();
    dGc().yqF.dead();
    dGc().yqG.dead();
    dGc().yqH.dead();
    dGc().yqJ.dead();
    dGc().yqI.dead();
    dGc().yqz.dead();
    dGc().yqA.dead();
    dGc().yqB.dead();
    dGc().yqC.dead();
    dGc().yqD.dead();
    dGc().yqE.dead();
    dGc().yqg.dead();
    dGc().yqx.dead();
    dGc().yqy.dead();
    Log.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
    Object localObject1 = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
      localObject1 = MultiProcessMMKV.getMMKV("exdevice_kv");
      if (localObject1 != null) {
        ((MultiProcessMMKV)localObject1).clear().commit();
      }
      localObject1 = u.dGD();
      Log.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
      if (((com.tencent.mm.plugin.exdevice.service.f)localObject1).yvk != null) {
        break label558;
      }
      Log.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.exdevice.c.k.dFm();
      bh.aZW().b(538, (com.tencent.mm.am.h)localObject1);
      com.tencent.mm.plugin.exdevice.c.k.yoX = null;
      this.ysH.dead();
      bh.getSysCmdMsgExtension().b("wcdevicemsg", this.ysZ, true);
      dGc().yqe.dead();
      dGc().yqf.dead();
      if (dFN().ysI != null) {
        dFN();
      }
      localObject1 = k.yrL;
      Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
      bh.aZW().b(539, (com.tencent.mm.am.h)localObject1);
      bh.aZW().b(6693, (com.tencent.mm.am.h)localObject1);
      ((k)localObject1).yrN = false;
      if ((((k)localObject1).lzP != null) && (((k)localObject1).lzP.isShowing()))
      {
        ((k)localObject1).lzP.dismiss();
        ((k)localObject1).lzP = null;
      }
      localObject1 = dFN().ysR;
      if ((((f)localObject1).ypD == null) || (((f)localObject1).ypD.isEmpty())) {
        break label623;
      }
      Object localObject2 = ((f)localObject1).ypD.entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((MTimerHandler)((Map.Entry)((Iterator)localObject2).next()).getValue()).stopTimer();
      }
      if (((SharedPreferences)localObject1).edit().clear().commit()) {
        break;
      }
      Log.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
      break;
      label558:
      localObject1 = ((com.tencent.mm.plugin.exdevice.service.f)localObject1).yvk.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        f.a locala = (f.a)((Map.Entry)localObject2).getValue();
        locala.yvo = false;
        ((Map.Entry)localObject2).setValue(locala);
      }
    }
    ((f)localObject1).ypD.clear();
    label623:
    if (dFN().ysS != null)
    {
      localObject1 = dFN().ysS;
      bh.aZW().b(1042, (com.tencent.mm.am.h)localObject1);
      bh.aZW().b(1041, (com.tencent.mm.am.h)localObject1);
      bh.aZW().b(1043, (com.tencent.mm.am.h)localObject1);
      bh.aZW().b(1040, (com.tencent.mm.am.h)localObject1);
    }
    if (dFN().ysV != null) {
      dFN().ysV.detach();
    }
    this.ysX.lsH.dead();
    com.tencent.mm.kernel.h.ay(com.tencent.mm.plugin.exdevice.a.b.class);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("ilink_device_update", this.ytb);
    AppMethodBeat.o(23470);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ah
 * JD-Core Version:    0.7.0.1
 */