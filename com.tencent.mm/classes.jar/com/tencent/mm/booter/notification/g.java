package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nr;
import com.tencent.mm.autogen.a.nr.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.booter.notification.queue.b;
import com.tencent.mm.k.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class g
  extends a
{
  private NotificationManager bpy;
  public e lui;
  private Context mContext;
  
  public g()
  {
    AppMethodBeat.i(19983);
    this.mContext = MMApplicationContext.getContext();
    this.bpy = ((NotificationManager)this.mContext.getSystemService("notification"));
    this.lui = new e();
    AppMethodBeat.o(19983);
  }
  
  public static boolean a(String paramString, cc paramcc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(238923);
    Log.d("MicroMsg.Notification.AppMsg.Handle", "preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (!bh.baz())
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](MMCore.accHasReady())preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(238923);
      return false;
    }
    if ((paramcc != null) && (e.hh(paramcc.field_msgSvrId)) && (!paramBoolean))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](msgInfo != null && NotificationQueueManager.getImpl().isAlreadyNotify(msgInfo.getMsgSvrId()), msgId: %d", new Object[] { Long.valueOf(paramcc.field_msgSvrId) });
      AppMethodBeat.o(238923);
      return false;
    }
    if ((paramInt & 0x1) == 0)
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[FALSE](tipsFlag & ConstantsProtocal.TEXT_NOTIFY_SVR_FLAG) == 0)preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(238923);
      return false;
    }
    bh.bCz();
    if ((c.bzw()) && (!z.aRx()))
    {
      bh.bCz();
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](MMCore.getAccStg().isWebWXOnline() && !ConfigStorageLogic.isWebWXNotificationOpen())preNotificationCheck, talker: %s, tipsFlag: %s isWebWXOnline: %B,isWebWXNotificationOpen: %B ", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(c.bzw()), Boolean.valueOf(z.aRx()) });
      AppMethodBeat.o(238923);
      return false;
    }
    if (au.bwK(paramString))
    {
      paramcc = new nr();
      paramcc.hQd.hHC = 3;
      paramcc.publish();
      if (!paramcc.hQe.hCQ)
      {
        paramcc = new nr();
        paramcc.hQd.hHC = 1;
        paramcc.hQd.hQf = paramString;
        paramcc.hQd.hQg = 3;
        paramcc.publish();
      }
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isLbsRoom(talker))preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(238923);
      return false;
    }
    if ((ab.Ja(paramString)) || ((au.bwE(paramString)) && (!ab.IZ(paramString)) && (paramcc != null) && (!paramcc.byr(z.bAM())) && (paramcc.getType() != 64) && (paramcc != null) && ((!paramcc.jcr()) || (!paramcc.jcs())) && (paramcc != null) && ((!paramcc.jcq()) || (v.Iv(paramString)))))
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](ContactStorageLogic.isMuteContact(talker) || (Contact.isWxOrOpenImChatRoom(talker) && !ContactStorageLogic.isChatRoomNotify(talker) && !msgInfo.isAtSomeone(ConfigStorageLogic.getUsernameFromUserInfo() && msgInfo.getType() != ConstantsProtocal.MM_DATA_MULTITALK)) && (msgInfo != null && !msgInfo.isChatRoomNotice(ConfigStorageLogic.getUsernameFromUserInfo())) )preNotificationCheck, talker: %s, tipsFlag: %s ", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(238923);
      return false;
    }
    if (paramcc != null)
    {
      paramString = XmlParser.parseXml(paramcc.field_reserved, "msg", null);
      if ((paramString != null) && (Util.getLong((String)paramString.get(".msg.videomsg.$overwritenewmsgid"), 0L) != 0L)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.i("MicroMsg.Notification.AppMsg.Handle", "[NO NOTIFICATION](msgInfo != null && ContactStorageLogic.isOriginVideoNotify(msgInfo.getContent())preNotificationCheck, origin video receive, no need to notify");
        AppMethodBeat.o(238923);
        return false;
      }
    }
    AppMethodBeat.o(238923);
    return true;
  }
  
  public static void cancel()
  {
    AppMethodBeat.i(19984);
    i locali = i.X(MMApplicationContext.getContext());
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.aLd().aLf();
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((Queue)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localStringBuilder.append(localInteger + ";");
      if (!localLinkedList.contains(localInteger))
      {
        b.aLd().a(locali, localInteger.intValue());
        localLinkedList.add(localInteger);
      }
    }
    Log.i("MicroMsg.Notification.Handle", "needRemoveNotificationId:%s", new Object[] { localStringBuilder });
    AppMethodBeat.o(19984);
  }
  
  public final int a(NotificationItem paramNotificationItem)
  {
    AppMethodBeat.i(19985);
    if (paramNotificationItem == null)
    {
      AppMethodBeat.o(19985);
      return -1;
    }
    int i = a(paramNotificationItem, null);
    AppMethodBeat.o(19985);
    return i;
  }
  
  public final Notification a(Notification paramNotification, int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4)
  {
    AppMethodBeat.i(19986);
    paramNotification = this.lui.a(paramNotification, paramInt1, paramInt2, paramPendingIntent, paramString1, paramString2, paramString3, paramBitmap, paramString4);
    AppMethodBeat.o(19986);
    return paramNotification;
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(19987);
    ArrayList localArrayList;
    if (this.lui != null)
    {
      Log.i("MicroMsg.Notification.AppMsg.Handle", "refreshTotalUnread, %d, %s", new Object[] { Integer.valueOf(paramInt), paramString });
      int i = paramInt;
      if (paramInt == -1) {
        i = h.aRz();
      }
      e.qi(i);
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label224;
      }
      localArrayList = e.aLa();
      if (localArrayList != null) {
        break label329;
      }
      localArrayList = new ArrayList();
    }
    label329:
    for (;;)
    {
      Object localObject2 = localArrayList.iterator();
      Object localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (e.a)((Iterator)localObject2).next();
        if (((e.a)localObject1).userName.equals(paramString)) {
          localArrayList.remove(localObject1);
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new e.a((byte)0);
        }
        ((e.a)localObject2).userName = paramString;
        ((e.a)localObject2).hND = h.DO(paramString);
        if ((((e.a)localObject2).hND == 0) && (localArrayList.isEmpty()))
        {
          e.k(null);
          AppMethodBeat.o(19987);
          return;
        }
        paramString = localArrayList;
        if (((e.a)localObject2).hND > 0)
        {
          localArrayList.add(localObject2);
          paramString = localArrayList;
        }
        e.k(paramString);
        AppMethodBeat.o(19987);
        return;
        label224:
        localArrayList = new ArrayList();
        localObject1 = h.rl(-1);
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = new ArrayList();
        }
        localObject1 = paramString.iterator();
        for (;;)
        {
          paramString = localArrayList;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject1).next();
          localObject2 = new e.a((byte)0);
          ((e.a)localObject2).userName = paramString;
          ((e.a)localObject2).hND = h.DO(paramString);
          localArrayList.add(localObject2);
        }
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.g
 * JD-Core Version:    0.7.0.1
 */