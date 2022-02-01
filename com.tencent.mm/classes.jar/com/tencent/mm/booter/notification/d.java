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
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.le.b;
import com.tencent.mm.g.a.y;
import com.tencent.mm.g.a.y.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends a
{
  public static String fIx = "com.tencent.preference.notification.key.unread.msg";
  public static String fIy = "com.tencent.preference.notification.key.unread.talker";
  public static String fIz = "com.tencent.preference.notification.key.all.notified.msgid";
  public com.tencent.mm.booter.notification.a.g cWS;
  Context mContext;
  
  public d()
  {
    AppMethodBeat.i(19958);
    this.mContext = ak.getContext();
    this.cWS = new com.tencent.mm.booter.notification.a.g(this.mContext);
    AppMethodBeat.o(19958);
  }
  
  public static void Xp()
  {
    AppMethodBeat.i(19972);
    f.abM().edit().putString(fIz, "").apply();
    AppMethodBeat.o(19972);
  }
  
  public static Notification Xq()
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
  
  public static int Xr()
  {
    AppMethodBeat.i(19965);
    int i = f.abM().getInt(fIx, 0);
    AppMethodBeat.o(19965);
    return i;
  }
  
  public static ArrayList<d.a> Xs()
  {
    AppMethodBeat.i(19966);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.uL(f.abM().getString(fIy, ""));
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
      ae.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList3;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localException, "Justin_Exception:%s", new Object[] { localException.getMessage() });
      ArrayList localArrayList4 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList4;
    }
  }
  
  private static String Xt()
  {
    AppMethodBeat.i(19971);
    String str = f.abM().getString(fIz, "");
    AppMethodBeat.o(19971);
    return str;
  }
  
  public static boolean a(String paramString, bv parambv, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19960);
    ae.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!bc.ajM())
    {
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((parambv != null) && (qX(parambv.field_msgSvrId)) && (!paramBoolean))
    {
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(parambv.field_msgSvrId) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    bc.aCg();
    if ((com.tencent.mm.model.c.aiX()) && (!v.acG()))
    {
      bc.aCg();
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.model.c.aiX()), Boolean.valueOf(v.acG()) });
      AppMethodBeat.o(19960);
      return false;
    }
    if (x.Ae(paramString))
    {
      parambv = new le();
      parambv.dzu.dsO = 3;
      com.tencent.mm.sdk.b.a.IvT.l(parambv);
      if (!parambv.dzv.doq)
      {
        parambv = new le();
        parambv.dzu.dsO = 1;
        parambv.dzu.dzw = paramString;
        parambv.dzu.dzx = 3;
        com.tencent.mm.sdk.b.a.IvT.l(parambv);
      }
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((x.Be(paramString)) || ((x.zT(paramString)) && (!x.Bd(paramString)) && (parambv != null) && (!parambv.aVB(v.aAC())) && (parambv.getType() != 64) && (parambv != null) && (!parambv.fwp())))
    {
      ae.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    AppMethodBeat.o(19960);
    return true;
  }
  
  public static d.a c(List<d.a> paramList, String paramString)
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
      d.a locala = (d.a)paramList.next();
      if (locala.userName.equals(paramString))
      {
        AppMethodBeat.o(19964);
        return locala;
      }
    }
    AppMethodBeat.o(19964);
    return null;
  }
  
  public static void f(ArrayList<d.a> paramArrayList)
  {
    AppMethodBeat.i(19967);
    if (paramArrayList == null)
    {
      f.abM().edit().putString(fIy, "").apply();
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        ae.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        AppMethodBeat.o(19967);
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          f.abM().edit().putString(fIy, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          ae.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          f.abM().edit().putString(fIy, "").apply();
        }
      }
      break;
    }
  }
  
  public static void kR(int paramInt)
  {
    AppMethodBeat.i(19968);
    paramInt = Math.max(0, paramInt);
    f.abM().edit().putInt(fIx, paramInt).apply();
    ae.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19968);
  }
  
  public static void qW(long paramLong)
  {
    AppMethodBeat.i(19969);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19969);
      return;
    }
    String str2 = Xt();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (qX(paramLong))
    {
      AppMethodBeat.o(19969);
      return;
    }
    str1 = str1 + paramLong + "%";
    f.abM().edit().putString(fIz, str1).apply();
    ae.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    AppMethodBeat.o(19969);
  }
  
  public static boolean qX(long paramLong)
  {
    AppMethodBeat.i(19970);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19970);
      return false;
    }
    String str = Xt();
    ae.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      AppMethodBeat.o(19970);
      return true;
    }
    AppMethodBeat.o(19970);
    return false;
  }
  
  static boolean uJ(String paramString)
  {
    AppMethodBeat.i(186338);
    try
    {
      paramString = com.tencent.mm.al.g.eX(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(186338);
        return false;
      }
      boolean bool = paramString.Kx();
      if (!bool)
      {
        AppMethodBeat.o(186338);
        return false;
      }
      bc.aCg();
      paramString = com.tencent.mm.model.c.azF().BH(paramString.KD());
      if (paramString == null)
      {
        AppMethodBeat.o(186338);
        return false;
      }
      bool = paramString.Pd();
      AppMethodBeat.o(186338);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(186338);
    }
    return false;
  }
  
  public final int a(NotificationItem paramNotificationItem, com.tencent.mm.booter.notification.a.g paramg)
  {
    AppMethodBeat.i(19961);
    if (s.iI(this.mContext))
    {
      ae.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((j.DEBUG) || (j.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")) && (s.a(localRunningAppProcessInfo) == 3)) {
              s.iH(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.HN != null))
    {
      paramNotificationItem.HN.priority = 1;
      if (!f.abN())
      {
        paramNotificationItem.HN.vibrate = new long[0];
        if ((!paramg.fJH) && (!paramg.fJG)) {
          paramNotificationItem.HN.priority = 0;
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
    s.c localc = com.tencent.mm.bq.a.bJ(this.mContext, com.tencent.mm.bq.a.fct());
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = com.tencent.mm.bq.a.dzu();
    }
    localc.HN.ledARGB = -16711936;
    localc.HN.ledOnMS = 300;
    localc.HN.ledOffMS = 1000;
    if ((localc.HN.ledOnMS != 0) && (localc.HN.ledOffMS != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      Notification localNotification = localc.HN;
      int j = localc.HN.flags;
      if (paramInt1 != 0)
      {
        paramInt1 = 1;
        localNotification.flags = (paramInt1 | j & 0xFFFFFFFE);
        localc.as(i).i(paramString3).Hl = paramPendingIntent1;
        localc.HC = true;
        if (paramString1 != null) {
          localc.f(paramString1);
        }
        if (paramString2 != null) {
          localc.g(paramString2);
        }
        localc.HN.defaults = paramInt2;
        if ((paramInt2 & 0x4) != 0)
        {
          paramPendingIntent1 = localc.HN;
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
            localc.HN.vibrate = paramNotification;
          }
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (paramString4 != null)
          {
            paramNotification = new s.a.a(paramInt3, paramString4, paramPendingIntent2);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.GZ = false;
            }
            localc.a(paramNotification.eo());
          }
          if (paramString5 != null)
          {
            paramNotification = new s.a.a(paramInt4, paramString5, paramPendingIntent3);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.GZ = false;
            }
            localc.a(paramNotification.eo());
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localc.HF = "msg";
          paramNotification = new y();
          paramNotification.dlI.username = paramString6;
          paramNotification.dlI.title = paramString1;
          com.tencent.mm.sdk.b.a.IvT.l(paramNotification);
          if (paramNotification.dlI.dlJ != null) {
            paramNotification.dlI.dlJ.a(localc);
          }
        }
        localc.F(true);
        paramNotification = localc.build();
        if (Build.VERSION.SDK_INT < 29) {}
      }
      try
      {
        paramPendingIntent1 = b.findField(Notification.class, "mAllowSystemGeneratedContextualActions");
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
          ae.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", paramPendingIntent1, "[-] Failure.", new Object[0]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */