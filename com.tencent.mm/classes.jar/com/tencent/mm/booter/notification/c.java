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
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.jj.b;
import com.tencent.mm.g.a.v;
import com.tencent.mm.g.a.v.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends a
{
  public static String eaD = "com.tencent.preference.notification.key.unread.msg";
  public static String eaE = "com.tencent.preference.notification.key.unread.talker";
  public static String eaF = "com.tencent.preference.notification.key.all.notified.msgid";
  public g bZK;
  Context mContext;
  
  public c()
  {
    AppMethodBeat.i(15926);
    this.mContext = ah.getContext();
    this.bZK = new g(this.mContext);
    AppMethodBeat.o(15926);
  }
  
  public static void IH()
  {
    AppMethodBeat.i(15940);
    com.tencent.mm.m.f.Mv().edit().putString(eaF, "").apply();
    AppMethodBeat.o(15940);
  }
  
  public static Notification II()
  {
    AppMethodBeat.i(15927);
    Notification localNotification = new Notification();
    localNotification.icon = 2130839103;
    localNotification.ledARGB = -16711936;
    localNotification.ledOnMS = 300;
    localNotification.ledOffMS = 1000;
    AppMethodBeat.o(15927);
    return localNotification;
  }
  
  public static int IJ()
  {
    AppMethodBeat.i(15933);
    int i = com.tencent.mm.m.f.Mv().getInt(eaD, 0);
    AppMethodBeat.o(15933);
    return i;
  }
  
  public static ArrayList<a> IK()
  {
    AppMethodBeat.i(15934);
    try
    {
      ArrayList localArrayList1 = (ArrayList)com.tencent.mm.booter.notification.queue.c.kF(com.tencent.mm.m.f.Mv().getString(eaE, ""));
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList();
        AppMethodBeat.o(15934);
        return localArrayList1;
      }
      AppMethodBeat.o(15934);
      return localArrayList1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localClassNotFoundException, "", new Object[0]);
      ArrayList localArrayList2 = new ArrayList();
      AppMethodBeat.o(15934);
      return localArrayList2;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
      ArrayList localArrayList3 = new ArrayList();
      AppMethodBeat.o(15934);
      return localArrayList3;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localException, "Justin_Exception:%s", new Object[] { localException.getMessage() });
      ArrayList localArrayList4 = new ArrayList();
      AppMethodBeat.o(15934);
      return localArrayList4;
    }
  }
  
  private static String IL()
  {
    AppMethodBeat.i(15939);
    String str = com.tencent.mm.m.f.Mv().getString(eaF, "");
    AppMethodBeat.o(15939);
    return str;
  }
  
  public static boolean a(String paramString, bi parambi, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(15928);
    ab.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!aw.RG())
    {
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(15928);
      return false;
    }
    if ((parambi != null) && (fZ(parambi.field_msgSvrId)) && (!paramBoolean))
    {
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(parambi.field_msgSvrId) });
      AppMethodBeat.o(15928);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(15928);
      return false;
    }
    aw.aaz();
    if ((com.tencent.mm.model.c.Yw()) && (!r.kt(r.Zt())))
    {
      aw.aaz();
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(com.tencent.mm.model.c.Yw()), Boolean.valueOf(r.kt(r.Zt())) });
      AppMethodBeat.o(15928);
      return false;
    }
    if (t.nO(paramString))
    {
      parambi = new jj();
      parambi.cyO.ctW = 3;
      com.tencent.mm.sdk.b.a.ymk.l(parambi);
      if (!parambi.cyP.cpz)
      {
        parambi = new jj();
        parambi.cyO.ctW = 1;
        parambi.cyO.cyQ = paramString;
        parambi.cyO.cyR = 3;
        com.tencent.mm.sdk.b.a.ymk.l(parambi);
      }
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(15928);
      return false;
    }
    if ((t.oI(paramString)) || ((t.nI(paramString)) && (!t.oH(paramString)) && (parambi != null) && (!parambi.asi(r.Zn())) && (parambi.getType() != 64) && (parambi != null) && (!parambi.dyq())))
    {
      ab.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (ContactStorageLogic.isChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(15928);
      return false;
    }
    AppMethodBeat.o(15928);
    return true;
  }
  
  public static a b(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(15932);
    if ((paramList == null) || (paramString == null))
    {
      AppMethodBeat.o(15932);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      if (locala.userName.equals(paramString))
      {
        AppMethodBeat.o(15932);
        return locala;
      }
    }
    AppMethodBeat.o(15932);
    return null;
  }
  
  public static void e(ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(15935);
    if (paramArrayList == null)
    {
      com.tencent.mm.m.f.Mv().edit().putString(eaE, "").apply();
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      for (;;)
      {
        ab.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadTalker %s", new Object[] { paramArrayList });
        AppMethodBeat.o(15935);
        return;
        try
        {
          ArrayList localArrayList = new ArrayList(paramArrayList);
          com.tencent.mm.m.f.Mv().edit().putString(eaE, com.tencent.mm.booter.notification.queue.c.a(localArrayList)).apply();
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.Notification.AppMsg.Handle", localIOException, "", new Object[0]);
          com.tencent.mm.m.f.Mv().edit().putString(eaE, "").apply();
        }
      }
      break;
    }
  }
  
  public static void fY(long paramLong)
  {
    AppMethodBeat.i(15937);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(15937);
      return;
    }
    String str2 = IL();
    String str1 = str2;
    if (str2.length() > 3000) {
      str1 = str2.substring(str2.length() / 2, str2.length());
    }
    if (fZ(paramLong))
    {
      AppMethodBeat.o(15937);
      return;
    }
    str1 = str1 + paramLong + "%";
    com.tencent.mm.m.f.Mv().edit().putString(eaF, str1).apply();
    ab.d("MicroMsg.Notification.AppMsg.Handle", "setNotifiedMsgId: %s", new Object[] { str1 });
    AppMethodBeat.o(15937);
  }
  
  public static boolean fZ(long paramLong)
  {
    AppMethodBeat.i(15938);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(15938);
      return false;
    }
    String str = IL();
    ab.d("MicroMsg.Notification.AppMsg.Handle", "isAlreadyNotified: %s, msgId: %d", new Object[] { str, Long.valueOf(paramLong) });
    if (str.contains(paramLong + "%"))
    {
      AppMethodBeat.o(15938);
      return true;
    }
    AppMethodBeat.o(15938);
    return false;
  }
  
  public static void ij(int paramInt)
  {
    AppMethodBeat.i(15936);
    paramInt = Math.max(0, paramInt);
    com.tencent.mm.m.f.Mv().edit().putInt(eaD, paramInt).apply();
    ab.i("MicroMsg.Notification.AppMsg.Handle", "saveTotalUnreadMsg %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(15936);
  }
  
  public final int a(NotificationItem paramNotificationItem, g paramg)
  {
    AppMethodBeat.i(15929);
    if (o.gG(this.mContext))
    {
      ab.i("MicroMsg.Notification.AppMsg.Handle", "GreenManUtil.isAppVisibleForeground");
      if ((com.tencent.mm.sdk.platformtools.f.DEBUG) || (com.tencent.mm.sdk.platformtools.f.PRE_RELEASE))
      {
        Object localObject = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mm")) && (o.a(localRunningAppProcessInfo) == 3)) {
              o.gF(this.mContext);
            }
          }
        }
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (paramNotificationItem != null) && (paramNotificationItem.yC != null))
    {
      paramNotificationItem.yC.priority = 1;
      if (!com.tencent.mm.m.f.Mw())
      {
        paramNotificationItem.yC.vibrate = new long[0];
        if ((!paramg.ebP) && (!paramg.ebO)) {
          paramNotificationItem.yC.priority = 0;
        }
      }
    }
    int i = super.a(paramNotificationItem, paramg);
    AppMethodBeat.o(15929);
    return i;
  }
  
  @TargetApi(21)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent1, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt3, String paramString4, PendingIntent paramPendingIntent2, int paramInt4, String paramString5, PendingIntent paramPendingIntent3, String paramString6)
  {
    AppMethodBeat.i(15931);
    s.c localc = com.tencent.mm.bp.a.br(this.mContext, com.tencent.mm.bp.a.dkN());
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = com.tencent.mm.bp.a.bYt();
    }
    localc.cJ().Y(i).h(paramString3).ya = paramPendingIntent1;
    localc.yr = true;
    if (paramString1 != null) {
      localc.e(paramString1);
    }
    if (paramString2 != null) {
      localc.f(paramString2);
    }
    localc.Z(paramInt2);
    if (paramBitmap != null) {
      localc.c(paramBitmap);
    }
    if (paramNotification != null)
    {
      if (paramNotification.sound != null) {
        localc.b(paramNotification.sound);
      }
      if (paramNotification.vibrate != null) {
        localc.a(paramNotification.vibrate);
      }
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramString4 != null) {
        localc.a(paramInt3, paramString4, paramPendingIntent2);
      }
      if (paramString5 != null) {
        localc.a(paramInt4, paramString5, paramPendingIntent3);
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localc.yu = "msg";
      paramNotification = new v();
      paramNotification.cnb.username = paramString6;
      paramNotification.cnb.title = paramString1;
      com.tencent.mm.sdk.b.a.ymk.l(paramNotification);
      if (paramNotification.cnb.cnc != null) {
        localc.a(paramNotification.cnb.cnc);
      }
    }
    paramNotification = localc.build();
    AppMethodBeat.o(15931);
    return paramNotification;
  }
  
  @TargetApi(11)
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(15930);
    paramNotification = a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, 0, null, null, 0, null, null, paramString4);
    AppMethodBeat.o(15930);
    return paramNotification;
  }
  
  public static final class a
    implements Serializable
  {
    public int eaG;
    public String userName;
    
    public final String toString()
    {
      AppMethodBeat.i(15925);
      String str = "[" + this.userName + "(" + this.eaG + ")]";
      AppMethodBeat.o(15925);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.booter.notification.c
 * JD-Core Version:    0.7.0.1
 */