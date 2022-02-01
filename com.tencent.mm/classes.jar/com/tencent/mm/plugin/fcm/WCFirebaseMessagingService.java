package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WCFirebaseMessagingService
  extends FirebaseMessagingService
{
  static List<Pair<Long, Long>> tnI;
  private WakerLock wakerlock;
  
  static
  {
    AppMethodBeat.i(127596);
    tnI = new LinkedList();
    AppMethodBeat.o(127596);
  }
  
  public static void cXl()
  {
    AppMethodBeat.i(127595);
    tnI.clear();
    AppMethodBeat.o(127595);
  }
  
  public final void a(RemoteMessage paramRemoteMessage)
  {
    AppMethodBeat.i(127594);
    Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "on message received");
    Object localObject1 = b.cXf();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcmRegister is null");
      e.Cxv.idkeyStat(901L, 26L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    if (!((b)localObject1).cXj())
    {
      Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "fcm push not reg to server.");
      e.Cxv.idkeyStat(901L, 25L, 1L, false);
      AppMethodBeat.o(127594);
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = MMApplicationContext.getContext();
        if (l.cK((Context)localObject1))
        {
          Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Logout or exit MM. no need show Notification.");
          h.CyF.kvStat(11250, "1,2");
          e.Cxv.idkeyStat(901L, 28L, 1L, false);
          AppMethodBeat.o(127594);
          return;
        }
        Object localObject3 = paramRemoteMessage.yA();
        if (((Map)localObject3).isEmpty())
        {
          Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "msg data is empty: ");
          h.CyF.kvStat(11250, "1,0");
          e.Cxv.idkeyStat(901L, 29L, 1L, false);
          AppMethodBeat.o(127594);
          return;
        }
        paramRemoteMessage = (String)((Map)localObject3).get("seq");
        Object localObject2 = (String)((Map)localObject3).get("uin");
        String str1 = (String)((Map)localObject3).get("cmd");
        String str8 = (String)((Map)localObject3).get("username");
        String str2 = (String)((Map)localObject3).get("time");
        String str3 = (String)((Map)localObject3).get("collapse_key");
        String str4 = (String)((Map)localObject3).get("sound");
        String str5 = (String)((Map)localObject3).get("alert");
        String str6 = (String)((Map)localObject3).get("msgType");
        String str7 = (String)((Map)localObject3).get("badge");
        localObject3 = (String)((Map)localObject3).get("from");
        e.Cxv.idkeyStat(901L, 32L, 1L, false);
        str8 = Util.secPrint(str8);
        if (str5 == null)
        {
          i = -1;
          Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", new Object[] { paramRemoteMessage, localObject2, str1, str8, str2, str3, str4, Integer.valueOf(i), str6, str7, localObject3 });
          if (Util.isNullOrNil((String)localObject2))
          {
            l1 = 0L;
            if (!Util.isNullOrNil(paramRemoteMessage)) {
              continue;
            }
            l2 = 0L;
            if (!Util.isNullOrNil(str1)) {
              continue;
            }
            l3 = 0L;
            i = a.azs();
            if ((l1 != 0L) && (Integer.toHexString(i).equals(Long.toHexString(l1)))) {
              continue;
            }
            Log.e("MicroMsg.FCM.WCFirebaseMessagingService", "Logined user changed. no need show Notification.uin:" + l1 + ", oldUin:" + i);
            h.CyF.kvStat(11250, "1,3");
            paramRemoteMessage = e.Cxv;
            if (l1 != 0L) {
              break label971;
            }
            l1 = 33L;
            paramRemoteMessage.idkeyStat(901L, l1, 1L, false);
            AppMethodBeat.o(127594);
          }
        }
        else
        {
          i = str5.length();
          continue;
        }
        l1 = Util.getLong((String)localObject2, 0L);
        continue;
        long l2 = Util.getLong(paramRemoteMessage, 0L);
        continue;
        long l3 = Util.getLong(str1, 0L);
        continue;
        paramRemoteMessage = tnI.iterator();
        if (paramRemoteMessage.hasNext())
        {
          localObject2 = (Pair)paramRemoteMessage.next();
          if ((((Long)((Pair)localObject2).first).longValue() != l3) || (((Long)((Pair)localObject2).second).longValue() != l2)) {
            continue;
          }
          i = 1;
          if (i != 0)
          {
            Log.w("MicroMsg.FCM.WCFirebaseMessagingService", "already has this seq:".concat(String.valueOf(l2)));
            e.Cxv.idkeyStat(901L, 35L, 1L, false);
            AppMethodBeat.o(127594);
            return;
          }
          tnI.add(Pair.create(Long.valueOf(l3), Long.valueOf(l2)));
          if (tnI.size() > 60) {
            tnI.remove(0);
          }
          if (this.wakerlock == null)
          {
            this.wakerlock = new WakerLock((Context)localObject1, "MicroMsg.FCM.WCFirebaseMessagingService");
            Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "start new wakerlock");
          }
          this.wakerlock.lock(200L, "FcmBroadcastReceiver.onReceive");
          Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync");
          paramRemoteMessage = new Intent(MMApplicationContext.getContext(), NotifyReceiver.NotifyService.class);
          paramRemoteMessage.putExtra("notify_option_type", 2);
          paramRemoteMessage.putExtra("notify_uin", a.azs());
          paramRemoteMessage.putExtra("notify_respType", 2147480001);
          paramRemoteMessage.putExtra("notify_respBuf", new byte[0]);
          paramRemoteMessage.putExtra("notfiy_recv_time", Util.nowMilliSecond());
          g.aAi();
          paramRemoteMessage.putExtra("notify_skey", g.aAg().qe(1));
          c.startService(paramRemoteMessage);
          Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "summerauths tryDoSync end!");
          AppMethodBeat.o(127594);
          return;
        }
      }
      catch (Exception paramRemoteMessage)
      {
        Log.e("MicroMsg.FCM.WCFirebaseMessagingService", "onMessageReceived error :".concat(String.valueOf(paramRemoteMessage.toString())));
        Log.printErrStackTrace("MicroMsg.FCM.WCFirebaseMessagingService", paramRemoteMessage, "", new Object[0]);
        e.Cxv.idkeyStat(901L, 36L, 1L, false);
        AppMethodBeat.o(127594);
        return;
      }
      int i = 0;
      continue;
      label971:
      long l1 = 34L;
    }
  }
  
  public final void a(String paramString, Exception paramException)
  {
    AppMethodBeat.i(127593);
    super.a(paramString, paramException);
    h.CyF.kvStat(11250, "1,1");
    e.Cxv.idkeyStat(901L, 30L, 1L, false);
    AppMethodBeat.o(127593);
  }
  
  public final void onDeletedMessages()
  {
    AppMethodBeat.i(127592);
    super.onDeletedMessages();
    Log.i("MicroMsg.FCM.WCFirebaseMessagingService", "Deleted messages on server.");
    h.CyF.kvStat(11250, "1,1");
    e.Cxv.idkeyStat(901L, 31L, 1L, false);
    AppMethodBeat.o(127592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.WCFirebaseMessagingService
 * JD-Core Version:    0.7.0.1
 */