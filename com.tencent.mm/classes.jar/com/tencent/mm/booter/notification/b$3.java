package com.tencent.mm.booter.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.bq.a;
import com.tencent.mm.h.a.pg;
import com.tencent.mm.h.a.pg.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.List;

final class b$3
  extends c<pg>
{
  b$3(b paramb)
  {
    this.udX = pg.class.getName().hashCode();
  }
  
  private boolean a(pg parampg)
  {
    Object localObject1;
    int i;
    if ((parampg != null) && ((parampg instanceof pg)))
    {
      localObject1 = parampg.bYT.bXl;
      i = parampg.bYT.msgType;
      parampg = this.djk;
    }
    try
    {
      y.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
      Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)parampg.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
      {
        localObject2 = new Intent(parampg.context, ChattingUI.class);
        ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        localObject1 = PendingIntent.getActivity(parampg.context, 35, (Intent)localObject2, 1073741824);
        localObject1 = new Notification.Builder(parampg.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(parampg.context.getString(R.l.app_pushcontent_title)).setContentText(parampg.context.getString(R.l.message_send_fail)).setContentIntent((PendingIntent)localObject1).getNotification();
        ((Notification)localObject1).icon = a.bSL();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        parampg.a(35, (Notification)localObject1, true);
      }
      return false;
    }
    catch (Exception parampg)
    {
      y.printErrStackTrace("MicroMsg.MMNotification", parampg, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b.3
 * JD-Core Version:    0.7.0.1
 */