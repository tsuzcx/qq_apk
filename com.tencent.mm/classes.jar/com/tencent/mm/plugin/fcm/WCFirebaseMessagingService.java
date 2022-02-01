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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WCFirebaseMessagingService
  extends FirebaseMessagingService
{
  static List<Pair<Long, Long>> qVv;
  private WakerLock wakerlock;
  
  static
  {
    AppMethodBeat.i(127596);
    qVv = new LinkedList();
    AppMethodBeat.o(127596);
  }
  
  public static void crU()
  {
    AppMethodBeat.i(127595);
    qVv.clear();
    AppMethodBeat.o(127595);
  }
  
  public final void a(RemoteMessage paramRemoteMessage)
  {
    AppMethodBeat.i(127594);
    ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
    Object localObject1 = a.crO();
    if (localObject1 == null)
    {
      ac.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
      e.wTc.idkeyStat(901L, 26L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    if (!((a)localObject1).crS())
    {
      ac.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
      e.wTc.idkeyStat(901L, 25L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    try
    {
      localObject1 = ai.getContext();
      if (l.cp((Context)localObject1))
      {
        ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
        h.wUl.kvStat(11250, "1,2");
        e.wTc.idkeyStat(901L, 28L, 1L, false);
        AppMethodBeat.o(127594);
        return;
      }
      if (paramRemoteMessage.bCq == null)
      {
        paramRemoteMessage.bCq = new android.support.v4.e.a();
        localObject2 = paramRemoteMessage.bCp.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str1 = (String)((Iterator)localObject2).next();
          localObject3 = paramRemoteMessage.bCp.get(str1);
          if ((localObject3 instanceof String))
          {
            localObject3 = (String)localObject3;
            if ((!str1.startsWith("google.")) && (!str1.startsWith("gcm.")) && (!str1.equals("from")) && (!str1.equals("message_type")) && (!str1.equals("collapse_key"))) {
              paramRemoteMessage.bCq.put(str1, localObject3);
            }
          }
        }
      }
      localObject4 = paramRemoteMessage.bCq;
    }
    catch (Exception paramRemoteMessage)
    {
      ac.e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(paramRemoteMessage.toString())));
      ac.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", paramRemoteMessage, "", new Object[0]);
      e.wTc.idkeyStat(901L, 36L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    if (((Map)localObject4).isEmpty())
    {
      ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
      h.wUl.kvStat(11250, "1,0");
      e.wTc.idkeyStat(901L, 29L, 1L, false);
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
    e.wTc.idkeyStat(901L, 32L, 1L, false);
    str7 = bs.aLJ(str7);
    int i;
    label650:
    long l2;
    label660:
    long l3;
    if (str4 == null)
    {
      i = -1;
      ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", new Object[] { paramRemoteMessage, localObject2, str1, str7, localObject3, str2, str3, Integer.valueOf(i), str5, str6, localObject4 });
      if (!bs.isNullOrNil((String)localObject2)) {
        break label778;
      }
      l1 = 0L;
      if (!bs.isNullOrNil(paramRemoteMessage)) {
        break label788;
      }
      l2 = 0L;
      if (!bs.isNullOrNil(str1)) {
        break label798;
      }
      l3 = 0L;
      label671:
      i = com.tencent.mm.kernel.a.agb();
      if ((l1 != 0L) && (Integer.toHexString(i).equals(Long.toHexString(l1)))) {
        break label809;
      }
      ac.e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + l1 + ", oldUin:" + i);
      h.wUl.kvStat(11250, "1,3");
      paramRemoteMessage = e.wTc;
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
      l1 = bs.getLong((String)localObject2, 0L);
      break label650;
      l2 = bs.getLong(paramRemoteMessage, 0L);
      break label660;
      l3 = bs.getLong(str1, 0L);
      break label671;
      paramRemoteMessage = qVv.iterator();
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
          ac.w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(l2)));
          e.wTc.idkeyStat(901L, 35L, 1L, false);
          AppMethodBeat.o(127594);
          return;
        }
        qVv.add(Pair.create(Long.valueOf(l3), Long.valueOf(l2)));
        if (qVv.size() > 60) {
          qVv.remove(0);
        }
        if (this.wakerlock == null)
        {
          this.wakerlock = new WakerLock((Context)localObject1, "MicroMsg.FCM.WCFirebaseMessagingService");
          ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
        }
        this.wakerlock.lock(200L, "FcmBroadcastReceiver.onReceive");
        ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
        paramRemoteMessage = new Intent(ai.getContext(), NotifyReceiver.NotifyService.class);
        paramRemoteMessage.putExtra("notify_option_type", 2);
        paramRemoteMessage.putExtra("notify_uin", com.tencent.mm.kernel.a.agb());
        paramRemoteMessage.putExtra("notify_respType", 2147480001);
        paramRemoteMessage.putExtra("notify_respBuf", new byte[0]);
        paramRemoteMessage.putExtra("notfiy_recv_time", bs.eWj());
        g.agS();
        paramRemoteMessage.putExtra("notify_skey", g.agQ().mp(1));
        d.aZ(paramRemoteMessage);
        ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
        AppMethodBeat.o(127594);
        return;
      }
    }
  }
  
  public final void a(String paramString, Exception paramException)
  {
    AppMethodBeat.i(127593);
    super.a(paramString, paramException);
    h.wUl.kvStat(11250, "1,1");
    e.wTc.idkeyStat(901L, 30L, 1L, false);
    AppMethodBeat.o(127593);
  }
  
  public final void onDeletedMessages()
  {
    AppMethodBeat.i(127592);
    super.onDeletedMessages();
    ac.i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
    h.wUl.kvStat(11250, "1,1");
    e.wTc.idkeyStat(901L, 31L, 1L, false);
    AppMethodBeat.o(127592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.WCFirebaseMessagingService
 * JD-Core Version:    0.7.0.1
 */