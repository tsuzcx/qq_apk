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
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.aa.a;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.lu.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends a
{
  public static String gnL = "com.tencent.preference.notification.key.unread.msg";
  public static String gnM = "com.tencent.preference.notification.key.unread.talker";
  public static String gnN = "com.tencent.preference.notification.key.all.notified.msgid";
  public com.tencent.mm.booter.notification.a.g dnt;
  Context mContext;
  
  public d()
  {
    AppMethodBeat.i(19958);
    this.mContext = MMApplicationContext.getContext();
    this.dnt = new com.tencent.mm.booter.notification.a.g(this.mContext);
    AppMethodBeat.o(19958);
  }
  
  static boolean CZ(String paramString)
  {
    AppMethodBeat.i(231501);
    try
    {
      paramString = com.tencent.mm.al.g.fJ(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(231501);
        return false;
      }
      boolean bool = paramString.UH();
      if (!bool)
      {
        AppMethodBeat.o(231501);
        return false;
      }
      bg.aVF();
      paramString = com.tencent.mm.model.c.aSN().Kn(paramString.UN());
      if (paramString == null)
      {
        AppMethodBeat.o(231501);
        return false;
      }
      bool = paramString.Zx();
      AppMethodBeat.o(231501);
      return bool;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(231501);
    }
    return false;
  }
  
  public static boolean a(String paramString, ca paramca, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(19960);
    Log.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!bg.aAc())
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((paramca != null) && (yP(paramca.field_msgSvrId)) && (!paramBoolean))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(paramca.field_msgSvrId) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    bg.aVF();
    if ((com.tencent.mm.model.c.azn()) && (!z.aqE()))
    {
      bg.aVF();
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.model.c.azn()), Boolean.valueOf(z.aqE()) });
      AppMethodBeat.o(19960);
      return false;
    }
    if (ab.II(paramString))
    {
      paramca = new lu();
      paramca.dRh.dJY = 3;
      EventCenter.instance.publish(paramca);
      if (!paramca.dRi.dFE)
      {
        paramca = new lu();
        paramca.dRh.dJY = 1;
        paramca.dRh.dRj = paramString;
        paramca.dRh.dRk = 3;
        EventCenter.instance.publish(paramca);
      }
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    if ((ab.JJ(paramString)) || ((ab.Iw(paramString)) && (!ab.JI(paramString)) && (paramca != null) && (!paramca.bkz(z.aTY())) && (paramca.getType() != 64) && (paramca != null) && (!paramca.gDV())))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(19960);
      return false;
    }
    AppMethodBeat.o(19960);
    return true;
  }
  
  public static void alc()
  {
    AppMethodBeat.i(19972);
    com.tencent.mm.n.g.apL().edit().putString(gnN, "").apply();
    AppMethodBeat.o(19972);
  }
  
  public static Notification ald()
  {
    AppMethodBeat.i(19959);
    Notification localNotification = new Notification();
    localNotification.icon = 2131233070;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    AppMethodBeat.o(19959);
    return localNotification;
  }
  
  public static int ale()
  {
    AppMethodBeat.i(19965);
    int i = com.tencent.mm.n.g.apL().getInt(gnL, 0);
    AppMethodBeat.o(19965);
    return i;
  }
  
  public static ArrayList<a> alf()
  {
    AppMethodBeat.i(19966);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.Db(com.tencent.mm.n.g.apL().getString(gnM, ""));
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
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList3;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localException, "Justin_Exception:%s", new Object[] { localException.getMessage() });
      ArrayList localArrayList4 = new ArrayList();
      AppMethodBeat.o(19966);
      return localArrayList4;
    }
  }
  
  private static String alg()
  {
    AppMethodBeat.i(19971);
    String str = com.tencent.mm.n.g.apL().getString(gnN, "");
    AppMethodBeat.o(19971);
    return str;
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
  
  public static void h(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(19967);
    if (paramArrayList == null)
    {
      com.tencent.mm.n.g.apL().edit().putString(gnM, "").apply();
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        AppMethodBeat.o(19967);
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          com.tencent.mm.n.g.apL().edit().putString(gnM, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          com.tencent.mm.n.g.apL().edit().putString(gnM, "").apply();
        }
      }
      break;
    }
  }
  
  public static void nT(int paramInt)
  {
    AppMethodBeat.i(19968);
    paramInt = Math.max(0, paramInt);
    com.tencent.mm.n.g.apL().edit().putInt(gnL, paramInt).apply();
    Log.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(19968);
  }
  
  public static void yO(long paramLong)
  {
    AppMethodBeat.i(19969);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19969);
      return;
    }
    String str2 = alg();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (yP(paramLong))
    {
      AppMethodBeat.o(19969);
      return;
    }
    str1 = str1 + paramLong + "%";
    com.tencent.mm.n.g.apL().edit().putString(gnN, str1).apply();
    Log.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    AppMethodBeat.o(19969);
  }
  
  public static boolean yP(long paramLong)
  {
    AppMethodBeat.i(19970);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(19970);
      return false;
    }
    String str = alg();
    Log.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      AppMethodBeat.o(19970);
      return true;
    }
    AppMethodBeat.o(19970);
    return false;
  }
  
  public final int a(NotificationItem paramNotificationItem, com.tencent.mm.booter.notification.a.g paramg)
  {
    AppMethodBeat.i(19961);
    if (GreenManUtil.isAppVisibleForeground(this.mContext))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((BuildInfo.DEBUG) || (BuildInfo.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith(MMApplicationContext.getApplicationId())) && (GreenManUtil.reflectProcessState(localRunningAppProcessInfo) == 3)) {
              GreenManUtil.dumpRunningServices(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.HX != null))
    {
      paramNotificationItem.HX.priority = 1;
      if (!com.tencent.mm.n.g.apM())
      {
        paramNotificationItem.HX.vibrate = new long[0];
        if ((!paramg.goW) && (!paramg.goV)) {
          paramNotificationItem.HX.priority = 0;
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
    s.c localc = com.tencent.mm.bq.a.cd(this.mContext, com.tencent.mm.bq.a.glE());
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = com.tencent.mm.bq.a.ezb();
    }
    localc.HX.ledARGB = -16711936;
    localc.HX.ledOnMS = 300;
    localc.HX.ledOffMS = 1000;
    if ((localc.HX.ledOnMS != 0) && (localc.HX.ledOffMS != 0)) {
      paramInt1 = 1;
    }
    for (;;)
    {
      Notification localNotification = localc.HX;
      int j = localc.HX.flags;
      if (paramInt1 != 0)
      {
        paramInt1 = 1;
        localNotification.flags = (paramInt1 | j & 0xFFFFFFFE);
        localc.as(i).i(paramString3).Hv = paramPendingIntent1;
        localc.HM = true;
        if (paramString1 != null) {
          localc.f(paramString1);
        }
        if (paramString2 != null) {
          localc.g(paramString2);
        }
        localc.HX.defaults = paramInt2;
        if ((paramInt2 & 0x4) != 0)
        {
          paramPendingIntent1 = localc.HX;
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
            localc.HX.vibrate = paramNotification;
          }
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          if (paramString4 != null)
          {
            paramNotification = new s.a.a(paramInt3, paramString4, paramPendingIntent2);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.Hj = false;
            }
            localc.a(paramNotification.es());
          }
          if (paramString5 != null)
          {
            paramNotification = new s.a.a(paramInt4, paramString5, paramPendingIntent3);
            if (Build.VERSION.SDK_INT >= 29) {
              paramNotification.Hj = false;
            }
            localc.a(paramNotification.es());
          }
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          localc.HP = "msg";
          paramNotification = new aa();
          paramNotification.dCY.username = paramString6;
          paramNotification.dCY.title = paramString1;
          EventCenter.instance.publish(paramNotification);
          if (paramNotification.dCY.dCZ != null) {
            paramNotification.dCY.dCZ.a(localc);
          }
        }
        localc.E(true);
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
          Log.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", paramPendingIntent1, "[-] Failure.", new Object[0]);
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
    public int dOS;
    public String userName;
    
    public final String toString()
    {
      AppMethodBeat.i(19957);
      String str = "[" + this.userName + "(" + this.dOS + ")]";
      AppMethodBeat.o(19957);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */