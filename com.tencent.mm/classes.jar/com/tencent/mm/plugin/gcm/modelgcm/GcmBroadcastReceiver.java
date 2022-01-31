package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.h.a.go;
import com.tencent.mm.kernel.l;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver
  extends BroadcastReceiver
{
  static List<Pair<Long, Long>> lhi = new LinkedList();
  private static volatile boolean lhj = false;
  private static WakerLock wakerlock = null;
  
  public static void baA()
  {
    lhi.clear();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
    String str1;
    String str2;
    if (paramIntent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION"))
    {
      localObject1 = a.baB();
      str1 = ((a)localObject1).baE();
      str2 = paramIntent.getStringExtra("registration_id");
      y.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + paramIntent.toString());
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("unregistered") == null) && (str2 != null) && (str1.compareTo(str2) != 0))
      {
        if (aa.Us() != null) {
          break label139;
        }
        y.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + str2);
      }
      for (;;)
      {
        f.nEG.a(452L, 25L, 1L, false);
        return;
        label139:
        ((a)localObject1).aq(paramContext, str2);
        aa.Us().post(new GcmBroadcastReceiver.2((a)localObject1));
      }
    }
    Object localObject1 = a.baB();
    if ((localObject1 == null) || (bk.bl(((a)localObject1).baE())))
    {
      boolean bool1;
      boolean bool2;
      if (localObject1 == null)
      {
        bool1 = true;
        if (localObject1 != null) {
          break label273;
        }
        bool2 = false;
        label203:
        y.i("GcmBroadcastReceiver", "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        h.nFQ.aC(11250, "1,2");
        paramContext = f.nEG;
        if (localObject1 != null) {
          break label283;
        }
      }
      label273:
      label283:
      for (l1 = 26L;; l1 = 27L)
      {
        paramContext.a(452L, l1, 1L, false);
        return;
        bool1 = false;
        break;
        bool2 = ((a)localObject1).baJ();
        break label203;
      }
    }
    if (((a)localObject1).baF())
    {
      f.nEG.a(452L, 42L, 1L, false);
      if (lhj)
      {
        y.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired and reNewalRegistting return");
        f.nEG.a(452L, 44L, 1L, false);
        return;
      }
      if (aa.Us() == null)
      {
        y.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired but handler is null wait for next push");
        return;
      }
      lhj = true;
      aa.Us().postDelayed(new GcmBroadcastReceiver.1(this, (a)localObject1), 500L);
      return;
    }
    lhj = false;
    try
    {
      if (l.bm(paramContext))
      {
        y.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
        h.nFQ.aC(11250, "1,2");
        f.nEG.a(452L, 28L, 1L, false);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramIntent = paramContext.toString();
      y.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + paramIntent);
      y.printErrStackTrace("GcmBroadcastReceiver", paramContext, "", new Object[0]);
      f.nEG.a(452L, 36L, 1L, false);
    }
    String str9;
    String str10;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    int i;
    do
    {
      for (;;)
      {
        y.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
        return;
        localObject2 = paramIntent.getExtras();
        str9 = GoogleCloudMessaging.getInstance(paramContext).getMessageType(paramIntent);
        if (((Bundle)localObject2).isEmpty())
        {
          y.i("GcmBroadcastReceiver", "Intent extras is empty: ");
          h.nFQ.aC(11250, "1,0");
          f.nEG.a(452L, 29L, 1L, false);
          return;
        }
        paramIntent = ((Bundle)localObject2).getString("seq");
        localObject1 = ((Bundle)localObject2).getString("uin");
        str1 = ((Bundle)localObject2).getString("cmd");
        str10 = ((Bundle)localObject2).getString("username");
        str2 = ((Bundle)localObject2).getString("time");
        str3 = ((Bundle)localObject2).getString("collapse_key");
        str4 = ((Bundle)localObject2).getString("sound");
        str5 = ((Bundle)localObject2).getString("alert");
        str6 = ((Bundle)localObject2).getString("msgType");
        str7 = ((Bundle)localObject2).getString("badge");
        str8 = ((Bundle)localObject2).getString("from");
        ((Bundle)localObject2).getString("ext");
        if ("send_error".equals(str9))
        {
          paramContext = bk.aac(str10);
          if (str5 == null) {}
          for (i = -1;; i = str5.length())
          {
            y.i("GcmBroadcastReceiver", "Send error:. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", new Object[] { paramIntent, localObject1, str1, paramContext, str2, str3, str4, Integer.valueOf(i), str6, str7, str8 });
            h.nFQ.aC(11250, "1,1");
            f.nEG.a(452L, 30L, 1L, false);
            break;
          }
        }
        if (!"deleted_messages".equals(str9)) {
          break;
        }
        y.i("GcmBroadcastReceiver", "Deleted messages on server.");
        h.nFQ.aC(11250, "1,1");
        f.nEG.a(452L, 31L, 1L, false);
      }
    } while (!"gcm".equals(str9));
    f.nEG.a(452L, 32L, 1L, false);
    Object localObject2 = bk.aac(str10);
    label881:
    long l2;
    label966:
    label976:
    long l3;
    if (str5 == null)
    {
      i = -1;
      y.i("GcmBroadcastReceiver", "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]", new Object[] { paramIntent, localObject1, str1, localObject2, str2, str3, str4, Integer.valueOf(i), str6, str7, str8 });
      if (!bk.bl((String)localObject1)) {
        break label1095;
      }
      l1 = 0L;
      if (!bk.bl(paramIntent)) {
        break label1106;
      }
      l2 = 0L;
      if (!bk.bl(str1)) {
        break label1116;
      }
      l3 = 0L;
      label987:
      i = com.tencent.mm.kernel.a.De();
      if ((l1 != 0L) && (Integer.toHexString(i).equals(Long.toHexString(l1)))) {
        break label1127;
      }
      y.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + l1 + ", oldUin:" + i);
      h.nFQ.aC(11250, "1,3");
      paramContext = f.nEG;
      if (l1 != 0L) {
        break label1351;
      }
    }
    label1351:
    for (long l1 = 33L;; l1 = 34L)
    {
      paramContext.a(452L, l1, 1L, false);
      return;
      i = str5.length();
      break label881;
      label1095:
      l1 = bk.getLong((String)localObject1, 0L);
      break label966;
      label1106:
      l2 = bk.getLong(paramIntent, 0L);
      break label976;
      label1116:
      l3 = bk.getLong(str1, 0L);
      break label987;
      label1127:
      paramIntent = lhi.iterator();
      do
      {
        if (!paramIntent.hasNext()) {
          break;
        }
        localObject1 = (Pair)paramIntent.next();
      } while ((((Long)((Pair)localObject1).first).longValue() != l3) || (((Long)((Pair)localObject1).second).longValue() != l2));
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          y.w("GcmBroadcastReceiver", "already has this seq:" + l2);
          f.nEG.a(452L, 35L, 1L, false);
          return;
        }
        lhi.add(Pair.create(Long.valueOf(l3), Long.valueOf(l2)));
        if (lhi.size() > 60) {
          lhi.remove(0);
        }
        if (wakerlock == null)
        {
          wakerlock = new WakerLock(paramContext, "GcmBroadcastReceiver");
          y.i("GcmBroadcastReceiver", "start new wakerlock");
        }
        wakerlock.lock(200L, "GcmBroadcastReceiver.onReceive");
        paramContext = new go();
        paramContext.bOp.type = 13;
        com.tencent.mm.sdk.b.a.udP.m(paramContext);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */