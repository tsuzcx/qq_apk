package com.tencent.mm.plugin.exdevice.model;

import android.os.Message;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.b.k.c;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;
import junit.framework.Assert;

final class ad$8
  implements bz.a
{
  ad$8(ad paramad) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(19382);
    Object localObject1;
    Object localObject2;
    long l;
    if (ad.bqe() != null)
    {
      ad.bqe();
      parama = parama.eyJ;
      ab.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
      localObject1 = aa.a(parama.woR);
      if (bo.isNullOrNil((String)localObject1)) {
        ab.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
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
            parama = aa.a(parama.woR);
            if (!bo.isNullOrNil(parama)) {
              break;
            }
            ab.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
            AppMethodBeat.o(19382);
            return;
            localObject1 = br.F((String)localObject1, "sysmsg");
          } while ((localObject1 == null) || (((Map)localObject1).size() <= 0));
          localObject2 = (String)((Map)localObject1).get(".sysmsg.$type");
        } while ((bo.isNullOrNil((String)localObject2)) || (!((String)localObject2).equalsIgnoreCase("wcdevicemsg")));
        String str1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.ToUserName");
        String str2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.FromUserName");
        l = bo.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1L);
        localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType");
        String str3 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceType");
        String str4 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
        i = bo.getInt((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
        ab.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + str1 + ",fromuser=" + str2 + ",createtime=" + l + ",msgtype=" + (String)localObject2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
        localObject1 = ad.bpY().LI(str4);
      } while ((localObject1 == null) || (!bo.nullAsNil(((b)localObject1).field_connProto).contains("4")) || (!bo.nullAsNil((String)localObject2).contains("device_status")));
      if (i != 0)
      {
        ad.bqj();
        e.c(((b)localObject1).field_brandName, ((b)localObject1).field_url, 2, ((b)localObject1).field_deviceID);
      }
      for (;;)
      {
        i = 1;
        break;
        ad.bqj();
        e.c(((b)localObject1).field_brandName, ((b)localObject1).field_url, 4, ((b)localObject1).field_deviceID);
      }
      localObject1 = br.F(parama, "sysmsg");
      if ((localObject1 == null) || (((Map)localObject1).size() <= 0))
      {
        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
        AppMethodBeat.o(19382);
        return;
      }
      parama = (String)((Map)localObject1).get(".sysmsg.$type");
      if ((bo.isNullOrNil(parama)) || (!parama.equalsIgnoreCase("wcdevicemsg")))
      {
        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
        AppMethodBeat.o(19382);
        return;
      }
      parama = bo.nullAsNil((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.MsgType"));
      ab.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[] { parama });
      if (parama.equals("device_relation"))
      {
        parama = new dl();
        parama.cqY.cqZ = true;
        a.ymk.l(parama);
        AppMethodBeat.o(19382);
        return;
      }
      localObject2 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.Content");
      ab.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[] { localObject2 });
      if (bo.isNullOrNil((String)localObject2))
      {
        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
        AppMethodBeat.o(19382);
        return;
      }
      try
      {
        parama = Base64.decode((String)localObject2, 0);
        if (bo.ce(parama))
        {
          ab.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
          AppMethodBeat.o(19382);
          return;
        }
      }
      catch (Exception parama)
      {
        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[] { parama.getMessage() });
        ab.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", parama, "", new Object[0]);
        AppMethodBeat.o(19382);
        return;
      }
      l = bo.getLong((String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.SessionID"), -1L);
      localObject1 = (String)((Map)localObject1).get(".sysmsg.wcdevicemsg.xml.DeviceID");
      ab.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[] { Long.valueOf(l), localObject1, localObject2, Integer.valueOf(parama.length) });
      localObject1 = ad.bpY().LI((String)localObject1);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
        AppMethodBeat.o(19382);
        return;
      }
      if (0L == l)
      {
        parama = new g(parama, 0, ((b)localObject1).field_mac);
        u.bqA().a(parama);
        AppMethodBeat.o(19382);
        return;
      }
      localObject1 = k.bpz();
      ab.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[] { Long.valueOf(l) });
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
      ((k.c)localObject2).mData = parama;
      ((k)localObject1).mHandler.obtainMessage(3, localObject2).sendToTarget();
      AppMethodBeat.o(19382);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.8
 * JD-Core Version:    0.7.0.1
 */