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
import android.support.v4.app.s.a.a;
import android.support.v4.app.s.c;
import android.support.v4.app.s.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.km;
import com.tencent.mm.g.a.km.b;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  public static String fkR = "com.tencent.preference.notification.key.unread.msg";
  public static String fkS = "com.tencent.preference.notification.key.unread.talker";
  public static String fkT = "com.tencent.preference.notification.key.all.notified.msgid";
  public g cNn;
  Context mContext;
  
  public c()
  {
    AppMethodBeat.i(19958);
    this.mContext = aj.getContext();
    this.cNn = new g(this.mContext);
    AppMethodBeat.o(19958);
  }
  
  public static void TV()
  {
    AppMethodBeat.i(19972);
    com.tencent.mm.m.f.Yg().edit().putString(fkT, "").apply();
    AppMethodBeat.o(19972);
  }
  
  public static Notification TW()
  {
    AppMethodBeat.i(19959);
    Notification localNotification = new Notification();
    localNotification.icon = 2131232660;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    AppMethodBeat.o(19959);
    return localNotification;
  }
  
  public static int TX()
  {
    AppMethodBeat.i(19965);
    int i = com.tencent.mm.m.f.Yg().getInt(fkR, 0);
    AppMethodBeat.o(19965);
    return i;
  }
  
  public static ArrayList<a> TY()
  {
    AppMethodBeat.i(19966);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.ox(com.tencent.mm.m.f.Yg().getString(fkS, ""));
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList();
        AppMethodBeat.o(19966);
        return localArrayList1;
      }
      AppMethodBeat.o(19966);
      return localArrayList1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ad.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList3;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localException, "Justin_Exception:%s", new Object[] { localException.getMessage() });
      ArrayList localArrayList4 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList4;
    }
  }
  
  private static String TZ()
  {
    AppMethodBeat.i(19971);
    String str = com.tencent.mm.m.f.Yg().getString(fkT, "");
    AppMethodBeat.o(19971);
    return str;
  }
  
  public static boolean a(String paramString, bl parambl, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19960);
    ad.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!az.afw())
    {
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((parambl != null) && (li(parambl.field_msgSvrId)) && (!paramBoolean))
    {
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(parambl.field_msgSvrId) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    az.arV();
    if ((com.tencent.mm.model.c.aeG()) && (!u.mY(u.aqM())))
    {
      az.arV();
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.model.c.aeG()), Boolean.valueOf(u.mY(u.aqM())) });
      AppMethodBeat.o(19960);
      return false;
    }
    if (w.sv(paramString))
    {
      parambl = new km();
      parambl.doT.diR = 3;
      com.tencent.mm.sdk.b.a.ESL.l(parambl);
      if (!parambl.doU.dew)
      {
        parambl = new km();
        parambl.doT.diR = 1;
        parambl.doT.doV = paramString;
        parambl.doT.doW = 3;
        com.tencent.mm.sdk.b.a.ESL.l(parambl);
      }
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((w.tt(paramString)) || ((w.sl(paramString)) && (!w.ts(paramString)) && (parambl != null) && (!parambl.aIN(u.aqG())) && (parambl.getType() != 64) && (parambl != null) && (!parambl.eMC())))
    {
      ad.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    AppMethodBeat.o(19960);
    return true;
  }
  
  public static a c(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(19964);
    if ((paramList == null) || (paramString == null))
    {
      AppMethodBeat.o(19964);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if (locala.userName.equals(paramString))
      {
        AppMethodBeat.o(19964);
        return locala;
      }
    }
    AppMethodBeat.o(19964);
    return null;
  }
  
  public static void e(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(19967);
    if (paramArrayList == null)
    {
      com.tencent.mm.m.f.Yg().edit().putString(fkS, "").apply();
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        ad.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        AppMethodBeat.o(19967);
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          com.tencent.mm.m.f.Yg().edit().putString(fkS, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          ad.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          com.tencent.mm.m.f.Yg().edit().putString(fkS, "").apply();
        }
      }
      break;
    }
  }
  
  public static void kv(int paramInt)
  {
    AppMethodBeat.i(19968);
    paramInt = Math.max(0, paramInt);
    com.tencent.mm.m.f.Yg().edit().putInt(fkR, paramInt).apply();
    ad.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19968);
  }
  
  public static void lh(long paramLong)
  {
    AppMethodBeat.i(19969);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19969);
      return;
    }
    String str2 = TZ();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (li(paramLong))
    {
      AppMethodBeat.o(19969);
      return;
    }
    str1 = str1 + paramLong + "%";
    com.tencent.mm.m.f.Yg().edit().putString(fkT, str1).apply();
    ad.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    AppMethodBeat.o(19969);
  }
  
  public static boolean li(long paramLong)
  {
    AppMethodBeat.i(19970);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19970);
      return false;
    }
    String str = TZ();
    ad.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      AppMethodBeat.o(19970);
      return true;
    }
    AppMethodBeat.o(19970);
    return false;
  }
  
  static boolean ov(String paramString)
  {
    AppMethodBeat.i(191129);
    try
    {
      paramString = com.tencent.mm.am.f.ei(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(191129);
        return false;
      }
      boolean bool = paramString.Jg();
      if (!bool)
      {
        AppMethodBeat.o(191129);
        return false;
      }
      az.arV();
      paramString = com.tencent.mm.model.c.apM().aHY(paramString.Jm());
      if (paramString == null)
      {
        AppMethodBeat.o(191129);
        return false;
      }
      bool = paramString.Ny();
      AppMethodBeat.o(191129);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(191129);
    }
    return false;
  }
  
  public final int a(NotificationItem paramNotificationItem, g paramg)
  {
    AppMethodBeat.i(19961);
    if (q.ii(this.mContext))
    {
      ad.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((h.DEBUG) || (h.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")) && (q.a(localRunningAppProcessInfo) == 3)) {
              q.ih(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.EY != null))
    {
      paramNotificationItem.EY.priority = 1;
      if (!com.tencent.mm.m.f.Yh())
      {
        paramNotificationItem.EY.vibrate = new long[0];
        if ((!paramg.fmb) && (!paramg.fma)) {
          paramNotificationItem.EY.priority = 0;
        }
      }
    }
    int i = super.a(paramNotificationItem, paramg);
    AppMethodBeat.o(19961);
    return i;
  }
  
  @TargetApi(21)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt3, String paramString4, PendingIntent paramPendingIntent2, int paramInt4, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(19963);
    s.c localc = com.tencent.mm.br.a.bD(this.mContext, com.tencent.mm.br.a.euy());
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = com.tencent.mm.br.a.cYf();
    }
    localc.EY.ledARGB = -16711936;
    localc.EY.ledOnMS = 300;
    localc.EY.ledOffMS = 1000;
    if ((localc.EY.ledOnMS != 0) && (localc.EY.ledOffMS != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      Notification localNotification = localc.EY;
      int j = localc.EY.flags;
      if (paramInt1 != 0)
      {
        paramInt1 = 1;
        localNotification.flags = (paramInt1 | j & 0xFFFFFFFE);
        localc.as(i).i(paramString3).Ew = paramPendingIntent1;
        localc.EN = true;
        if (paramString1 != null) {
          localc.f(paramString1);
        }
        if (paramString2 != null) {
          localc.g(paramString2);
        }
        localc.EY.defaults = paramInt2;
        if ((paramInt2 & 0x4) != 0)
        {
          paramPendingIntent1 = localc.EY;
          paramPendingIntent1.flags |= 0x1;
        }
        if (paramBitmap != null) {
          localc.b(paramBitmap);
        }
        if (paramNotification != null)
        {
          if (paramNotification.sound != null) {
            localc.b(paramNotification.sound);
          }
          if (paramNotification.vibrate != null)
          {
            paramNotification = paramNotification.vibrate;
            localc.EY.vibrate = paramNotification;
          }
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (paramString4 != null)
          {
            paramNotification = new s.a.a(paramInt3, paramString4, paramPendingIntent2);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.Ek = false;
            }
            localc.a(paramNotification.dM());
          }
          if (paramString5 != null)
          {
            paramNotification = new s.a.a(paramInt4, paramString5, paramPendingIntent3);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.Ek = false;
            }
            localc.a(paramNotification.dM());
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localc.EQ = "msg";
          paramNotification = new x();
          paramNotification.dbP.username = paramString6;
          paramNotification.dbP.title = paramString1;
          com.tencent.mm.sdk.b.a.ESL.l(paramNotification);
          if (paramNotification.dbP.dbQ != null) {
            paramNotification.dbP.dbQ.a(localc);
          }
        }
        paramNotification = localc.build();
        if (Build.VERSION.SDK_INT < 29) {}
      }
      try
      {
        paramPendingIntent1 = Notification.class.getDeclaredField("mAllowSystemGeneratedContextualActions");
        paramPendingIntent1.setAccessible(true);
        paramPendingIntent1.set(paramNotification, Boolean.FALSE);
        AppMethodBeat.o(19963);
        return paramNotification;
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
      catch (Throwable paramPendingIntent1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", paramPendingIntent1, "[-] Failure.", new Object[0]);
        }
      }
    }
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19962);
    paramNotification = a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, 0, null, null, 0, null, null, paramString4);
    AppMethodBeat.o(19962);
    return paramNotification;
  }
  
  public static final class a
    implements Serializable
  {
    public int dmL;
    public String userName;
    
    public final String toString()
    {
      AppMethodBeat.i(19957);
      String str = "[" + this.userName + "(" + this.dmL + ")]";
      AppMethodBeat.o(19957);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */