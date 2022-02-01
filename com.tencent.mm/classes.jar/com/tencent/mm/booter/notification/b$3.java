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
import com.tencent.mm.br.a;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.sd.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.List;

final class b$3
  extends c<sd>
{
  b$3(b paramb)
  {
    AppMethodBeat.i(161273);
    this.__eventId = sd.class.getName().hashCode();
    AppMethodBeat.o(161273);
  }
  
  private boolean a(sd paramsd)
  {
    AppMethodBeat.i(19928);
    Object localObject1;
    int i;
    if ((paramsd != null) && ((paramsd instanceof sd)))
    {
      localObject1 = paramsd.dxM.dvQ;
      i = paramsd.dxM.msgType;
      paramsd = this.fkQ;
    }
    try
    {
      ad.w("showSendMsgFailNotification fromUserName:%s msgType:%d", (String)localObject1, new Object[] { Integer.valueOf(i) });
      Object localObject2 = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramsd.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity;
      if (!ChattingUI.class.getName().equals(((ComponentName)localObject2).getClassName()))
      {
        localObject2 = new Intent(paramsd.context, ChattingUI.class);
        ((Intent)localObject2).putExtra("nofification_type", "pushcontent_notification");
        ((Intent)localObject2).putExtra("Intro_Is_Muti_Talker", true);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        ((Intent)localObject2).putExtra("MainUI_User_Last_Msg_Type", i);
        ((Intent)localObject2).addFlags(536870912);
        ((Intent)localObject2).addFlags(67108864);
        localObject1 = PendingIntent.getActivity(paramsd.context, 35, (Intent)localObject2, 1073741824);
        localObject2 = a.bD(paramsd.context, a.euy()).i(null).g(System.currentTimeMillis()).f(paramsd.context.getString(2131755866)).g(paramsd.context.getString(2131761228));
        ((s.c)localObject2).Ew = ((PendingIntent)localObject1);
        localObject1 = ((s.c)localObject2).build();
        ((Notification)localObject1).icon = a.cYf();
        ((Notification)localObject1).defaults |= 0x1;
        ((Notification)localObject1).flags |= 0x10;
        paramsd.a(35, (Notification)localObject1, true);
      }
      AppMethodBeat.o(19928);
      return false;
    }
    catch (Exception paramsd)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MMNotification", paramsd, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.notification.b.3
 * JD-Core Version:    0.7.0.1
 */