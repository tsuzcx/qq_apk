package com.tencent.mm.booter.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.a;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.g.a.ql.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.List;

final class b$3
  extends c<ql>
{
  b$3(b paramb)
  {
    AppMethodBeat.i(15895);
    this.__eventId = ql.class.getName().hashCode();
    AppMethodBeat.o(15895);
  }
  
  private boolean a(ql paramql)
  {
    AppMethodBeat.i(15896);
    Object localObject1;
    int i;
    if ((paramql != null) && ((paramql instanceof ql)))
    {
      localObject1 = paramql.cHa.cFh;
      i = paramql.cHa.msgType;
      paramql = this.eaC;
    }
    try
    {
      ab.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
      Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramql.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
      {
        localObject2 = new Intent(paramql.context, ChattingUI.class);
        ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        localObject1 = PendingIntent.getActivity(paramql.context, 35, (Intent)localObject2, 1073741824);
        localObject2 = a.br(paramql.context, a.dkN()).h(null).g(System.currentTimeMillis()).e(paramql.context.getString(2131297049)).f(paramql.context.getString(2131301557));
        ((s.c)localObject2).ya = ((PendingIntent)localObject1);
        localObject1 = ((s.c)localObject2).build();
        ((Notification)localObject1).icon = a.bYt();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        paramql.a(35, (Notification)localObject1, true);
      }
      AppMethodBeat.o(15896);
      return false;
    }
    catch (Exception paramql)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMNotification", paramql, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b.3
 * JD-Core Version:    0.7.0.1
 */