package com.tencent.mm.booter.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.f.d;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.wr;
import com.tencent.mm.autogen.a.wr.a;
import com.tencent.mm.bq.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.List;

class MMNotification$3
  extends IListener<wr>
{
  MMNotification$3(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(238930);
    this.__eventId = wr.class.getName().hashCode();
    AppMethodBeat.o(238930);
  }
  
  private boolean a(wr paramwr)
  {
    AppMethodBeat.i(19928);
    Object localObject1;
    int i;
    if ((paramwr != null) && ((paramwr instanceof wr)))
    {
      localObject1 = paramwr.iam.hYg;
      i = paramwr.iam.msgType;
      paramwr = this.ltQ;
    }
    try
    {
      Log.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
      Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramwr.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
      {
        localObject2 = new Intent(paramwr.context, ChattingUI.class);
        ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        localObject1 = PendingIntent.getActivity(paramwr.context, 35, (Intent)localObject2, 1073741824);
        localObject2 = a.cA(paramwr.context, a.iGp()).o(null).bt(System.currentTimeMillis()).l(paramwr.context.getString(R.l.app_pushcontent_title)).m(paramwr.context.getString(R.l.gNT));
        ((f.d)localObject2).bor = ((PendingIntent)localObject1);
        localObject1 = ((f.d)localObject2).DA();
        ((Notification)localObject1).icon = a.guX();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        paramwr.a(35, (Notification)localObject1, true);
      }
      AppMethodBeat.o(19928);
      return false;
    }
    catch (Exception paramwr)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MMNotification", paramwr, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.MMNotification.3
 * JD-Core Version:    0.7.0.1
 */