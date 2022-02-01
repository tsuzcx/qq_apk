package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WCFirebaseMessagingService
  extends FirebaseMessagingService
{
  static List<Pair<Long, Long>> qmT;
  private WakerLock wakerlock;
  
  static
  {
    AppMethodBeat.i(127596);
    qmT = new LinkedList();
    AppMethodBeat.o(127596);
  }
  
  public static void ckn()
  {
    AppMethodBeat.i(127595);
    qmT.clear();
    AppMethodBeat.o(127595);
  }
  
  public final void a(RemoteMessage paramRemoteMessage)
  {
    AppMethodBeat.i(127594);
    ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
    Object localObject1 = a.ckh();
    if (localObject1 == null)
    {
      ad.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
      e.vIY.idkeyStat(901L, 26L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    if (!((a)localObject1).ckl())
    {
      ad.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
      e.vIY.idkeyStat(901L, 25L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    try
    {
      localObject1 = aj.getContext();
      if (l.cj((Context)localObject1))
      {
        ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
        h.vKh.kvStat(11250, "1,2");
        e.vIY.idkeyStat(901L, 28L, 1L, false);
        AppMethodBeat.o(127594);
        return;
      }
      if (paramRemoteMessage.bEI == null)
      {
        paramRemoteMessage.bEI = new android.support.v4.e.a();
        localObject2 = paramRemoteMessage.bEH.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          localObject3 = paramRemoteMessage.bEH.get(str1);
          if ((localObject3 instanceof String))
          {
            localObject3 = (String)localObject3;
            if ((!str1.startsWith("google.")) && (!str1.startsWith("gcm.")) && (!str1.equals("from")) && (!str1.equals("message_type")) && (!str1.equals("collapse_key"))) {
              paramRemoteMessage.bEI.put(str1, localObject3);
            }
          }
        }
      }
      localObject4 = paramRemoteMessage.bEI;
    }
    catch (Exception paramRemoteMessage)
    {
      ad.e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(paramRemoteMessage.toString())));
      ad.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", paramRemoteMessage, "", new Object[0]);
      e.vIY.idkeyStat(901L, 36L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    if (((Map)localObject4).isEmpty())
    {
      ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
      h.vKh.kvStat(11250, "1,0");
      e.vIY.idkeyStat(901L, 29L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    paramRemoteMessage = (String)((Map)localObject4).get("seq");
    Object localObject2 = (String)((Map)localObject4).get("uin");
    String str1 = (String)((Map)localObject4).get("cmd");
    String str7 = (String)((Map)localObject4).get("username");
    Object localObject3 = (String)((Map)localObject4).get("time");
    String str2 = (String)((Map)localObject4).get("collapse_key");
    String str3 = (String)((Map)localObject4).get("sound");
    String str4 = (String)((Map)localObject4).get("alert");
    String str5 = (String)((Map)localObject4).get("msgType");
    String str6 = (String)((Map)localObject4).get("badge");
    Object localObject4 = (String)((Map)localObject4).get("from");
    e.vIY.idkeyStat(901L, 32L, 1L, false);
    str7 = bt.aGs(str7);
    int i;
    label650:
    long l2;
    label660:
    long l3;
    if (str4 == null)
    {
      i = -1;
      ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", new Object[] { paramRemoteMessage, localObject2, str1, str7, localObject3, str2, str3, Integer.valueOf(i), str5, str6, localObject4 });
      if (!bt.isNullOrNil((String)localObject2)) {
        break label778;
      }
      l1 = 0L;
      if (!bt.isNullOrNil(paramRemoteMessage)) {
        break label788;
      }
      l2 = 0L;
      if (!bt.isNullOrNil(str1)) {
        break label798;
      }
      l3 = 0L;
      label671:
      i = com.tencent.mm.kernel.a.aeL();
      if ((l1 != 0L) && (Integer.toHexString(i).equals(Long.toHexString(l1)))) {
        break label809;
      }
      ad.e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + l1 + ", oldUin:" + i);
      h.vKh.kvStat(11250, "1,3");
      paramRemoteMessage = e.vIY;
      if (l1 != 0L) {
        break label1119;
      }
    }
    label778:
    label788:
    label798:
    label809:
    label1119:
    for (long l1 = 33L;; l1 = 34L)
    {
      paramRemoteMessage.idkeyStat(901L, l1, 1L, false);
      AppMethodBeat.o(127594);
      return;
      i = str4.length();
      break;
      l1 = bt.getLong((String)localObject2, 0L);
      break label650;
      l2 = bt.getLong(paramRemoteMessage, 0L);
      break label660;
      l3 = bt.getLong(str1, 0L);
      break label671;
      paramRemoteMessage = qmT.iterator();
      do
      {
        if (!paramRemoteMessage.hasNext()) {
          break;
        }
        localObject2 = (Pair)paramRemoteMessage.next();
      } while ((((Long)((Pair)localObject2).first).longValue() != l3) || (((Long)((Pair)localObject2).second).longValue() != l2));
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          ad.w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(l2)));
          e.vIY.idkeyStat(901L, 35L, 1L, false);
          AppMethodBeat.o(127594);
          return;
        }
        qmT.add(Pair.create(Long.valueOf(l3), Long.valueOf(l2)));
        if (qmT.size() > 60) {
          qmT.remove(0);
        }
        if (this.wakerlock == null)
        {
          this.wakerlock = new WakerLock((Context)localObject1, "MicroMsg.FCM.WCFirebaseMessagingService");
          ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
        }
        this.wakerlock.lock(200L, "FcmBroadcastReceiver.onReceive");
        ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
        paramRemoteMessage = new Intent(aj.getContext(), NotifyReceiver.NotifyService.class);
        paramRemoteMessage.putExtra("notify_option_type", 2);
        paramRemoteMessage.putExtra("notify_uin", com.tencent.mm.kernel.a.aeL());
        paramRemoteMessage.putExtra("notify_respType", 2147480001);
        paramRemoteMessage.putExtra("notify_respBuf", new byte[0]);
        paramRemoteMessage.putExtra("notfiy_recv_time", bt.eGO());
        g.afC();
        paramRemoteMessage.putExtra("notify_skey", g.afA().mq(1));
        d.aY(paramRemoteMessage);
        ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
        AppMethodBeat.o(127594);
        return;
      }
    }
  }
  
  public final void a(String paramString, Exception paramException)
  {
    AppMethodBeat.i(127593);
    super.a(paramString, paramException);
    h.vKh.kvStat(11250, "1,1");
    e.vIY.idkeyStat(901L, 30L, 1L, false);
    AppMethodBeat.o(127593);
  }
  
  public final void onDeletedMessages()
  {
    AppMethodBeat.i(127592);
    super.onDeletedMessages();
    ad.i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
    h.vKh.kvStat(11250, "1,1");
    e.vIY.idkeyStat(901L, 31L, 1L, false);
    AppMethodBeat.o(127592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.WCFirebaseMessagingService
 * JD-Core Version:    0.7.0.1
 */