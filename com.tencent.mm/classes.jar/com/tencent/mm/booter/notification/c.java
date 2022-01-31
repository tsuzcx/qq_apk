package com.tencent.mm.booter.notification;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.x.c;
import android.support.v4.app.x.e;
import com.tencent.mm.R.g;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.h.a.ja;
import com.tencent.mm.h.a.ja.b;
import com.tencent.mm.h.a.v;
import com.tencent.mm.h.a.v.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.m.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  public static String djl = "com.tencent.preference.notification.key.unread.msg";
  public static String djm = "com.tencent.preference.notification.key.unread.talker";
  public static String djn = "com.tencent.preference.notification.key.all.notified.msgid";
  public g bxJ = new g(this.mContext);
  Context mContext = ae.getContext();
  
  public static c.a a(List<c.a> paramList, String paramString)
  {
    if ((paramList == null) || (paramString == null)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      c.a locala = (c.a)paramList.next();
      if (locala.userName.equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  public static boolean a(String paramString, bi parambi, int paramInt, boolean paramBoolean)
  {
    y.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!au.DK())
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    if ((parambi != null) && (bp(parambi.field_msgSvrId)) && (!paramBoolean))
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    au.Hx();
    if ((com.tencent.mm.model.c.Fs()) && (!q.hH(q.Gp())))
    {
      au.Hx();
      y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.model.c.Fs()), Boolean.valueOf(q.hH(q.Gp())) });
      return false;
    }
    if (s.hf(paramString))
    {
      parambi = new ja();
      parambi.bRm.bMC = 3;
      com.tencent.mm.sdk.b.a.udP.m(parambi);
      if (!parambi.bRn.bIe)
      {
        parambi = new ja();
        parambi.bRm.bMC = 1;
        parambi.bRm.bRo = paramString;
        parambi.bRm.bRp = 3;
        com.tencent.mm.sdk.b.a.udP.m(parambi);
      }
      y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    if ((s.hZ(paramString)) || ((s.gZ(paramString)) && (!s.hY(paramString)) && (parambi != null) && (!parambi.abY(q.Gj())) && (parambi.getType() != 64) && (parambi != null) && (!parambi.cvJ())))
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    return true;
  }
  
  public static void bo(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      String str2 = ww();
      str1 = str2;
      if (str2.length() > 3000) {
        str1 = str2.substring(str2.length() / 2, str2.length());
      }
    } while (bp(paramLong));
    String str1 = str1 + paramLong + "%";
    f.zO().edit().putString(djn, str1).apply();
    y.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
  }
  
  public static boolean bp(long paramLong)
  {
    if (paramLong == 0L) {}
    String str;
    do
    {
      return false;
      str = ww();
      y.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    } while (!str.contains(paramLong + "%"));
    return true;
  }
  
  public static void e(ArrayList<c.a> paramArrayList)
  {
    if (paramArrayList == null)
    {
      f.zO().edit().putString(djm, "").apply();
      if (paramArrayList != null) {
        break label131;
      }
    }
    label131:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        y.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          f.zO().edit().putString(djm, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          y.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          f.zO().edit().putString(djm, "").apply();
        }
      }
      break;
    }
  }
  
  public static void fV(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    f.zO().edit().putInt(djl, paramInt).apply();
    y.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void ws()
  {
    f.zO().edit().putString(djn, "").apply();
  }
  
  public static Notification wt()
  {
    Notification localNotification = new Notification();
    localNotification.icon = R.g.icon;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    return localNotification;
  }
  
  public static int wu()
  {
    return f.zO().getInt(djl, 0);
  }
  
  public static ArrayList<c.a> wv()
  {
    try
    {
      ArrayList localArrayList2 = (ArrayList)com.tencent.mm.booter.notification.queue.c.eA(f.zO().getString(djm, ""));
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null) {
        localArrayList1 = new ArrayList();
      }
      return localArrayList1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      y.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      return new ArrayList();
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
    }
    return new ArrayList();
  }
  
  private static String ww()
  {
    return f.zO().getString(djn, "");
  }
  
  public final int a(NotificationItem paramNotificationItem, g paramg)
  {
    if (l.ft(this.mContext))
    {
      y.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((d.DEBUG) || (d.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")) && (l.a(localRunningAppProcessInfo) == 3)) {
              l.fs(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.yb != null))
    {
      paramNotificationItem.yb.priority = 1;
      if (!f.zP())
      {
        paramNotificationItem.yb.vibrate = new long[0];
        if ((!paramg.dku) && (!paramg.dkt)) {
          paramNotificationItem.yb.priority = 0;
        }
      }
    }
    return super.a(paramNotificationItem, paramg);
  }
  
  @TargetApi(21)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt3, String paramString4, PendingIntent paramPendingIntent2, int paramInt4, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    Object localObject = paramNotification;
    int i;
    Notification localNotification;
    int j;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = new x.c(this.mContext, (byte)0);
      i = paramInt1;
      if (paramInt1 == -1) {
        i = com.tencent.mm.bq.a.bSL();
      }
      ((x.c)localObject).yb.ledARGB = -16711936;
      ((x.c)localObject).yb.ledOnMS = 300;
      ((x.c)localObject).yb.ledOffMS = 1000;
      if ((((x.c)localObject).yb.ledOnMS == 0) || (((x.c)localObject).yb.ledOffMS == 0)) {
        break label394;
      }
      paramInt1 = 1;
      localNotification = ((x.c)localObject).yb;
      j = ((x.c)localObject).yb.flags;
      if (paramInt1 == 0) {
        break label399;
      }
    }
    label394:
    label399:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      localNotification.flags = (paramInt1 | j & 0xFFFFFFFE);
      ((x.c)localObject).ah(i).e(paramString3).xz = paramPendingIntent1;
      ((x.c)localObject).xQ = true;
      if (paramString1 != null) {
        ((x.c)localObject).c(paramString1);
      }
      if (paramString2 != null) {
        ((x.c)localObject).d(paramString2);
      }
      ((x.c)localObject).yb.defaults = paramInt2;
      if ((paramInt2 & 0x4) != 0)
      {
        paramPendingIntent1 = ((x.c)localObject).yb;
        paramPendingIntent1.flags |= 0x1;
      }
      if (paramBitmap != null) {
        ((x.c)localObject).xC = paramBitmap;
      }
      if (paramNotification != null)
      {
        if (paramNotification.sound != null) {
          ((x.c)localObject).b(paramNotification.sound);
        }
        if (paramNotification.vibrate != null)
        {
          paramNotification = paramNotification.vibrate;
          ((x.c)localObject).yb.vibrate = paramNotification;
        }
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (paramString4 != null) {
          ((x.c)localObject).a(paramInt3, paramString4, paramPendingIntent2);
        }
        if (paramString5 != null) {
          ((x.c)localObject).a(paramInt4, paramString5, paramPendingIntent3);
        }
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        ((x.c)localObject).mCategory = "msg";
        paramNotification = new v();
        paramNotification.bFU.username = paramString6;
        paramNotification.bFU.title = paramString1;
        com.tencent.mm.sdk.b.a.udP.m(paramNotification);
        if (paramNotification.bFU.bFV != null) {
          paramNotification.bFU.bFV.a((x.c)localObject);
        }
      }
      localObject = ((x.c)localObject).build();
      return localObject;
      paramInt1 = 0;
      break;
    }
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    return a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, 0, null, null, 0, null, null, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */