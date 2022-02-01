package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class NotificationBar
  extends com.tencent.mm.cd.a
{
  public LinkedList<Notification> notification_list;
  public String version;
  
  public NotificationBar()
  {
    AppMethodBeat.i(195504);
    this.notification_list = new LinkedList();
    AppMethodBeat.o(195504);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.notification_list);
      if (this.version != null) {
        paramVarArgs.f(2, this.version);
      }
      AppMethodBeat.o(195507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.notification_list) + 0;
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.version);
      }
      AppMethodBeat.o(195507);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.notification_list.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      NotificationBar localNotificationBar = (NotificationBar)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195507);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          Notification localNotification = new Notification();
          if ((localObject != null) && (localObject.length > 0)) {
            localNotification.parseFrom((byte[])localObject);
          }
          localNotificationBar.notification_list.add(localNotification);
          paramInt += 1;
        }
        AppMethodBeat.o(195507);
        return 0;
      }
      localNotificationBar.version = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(195507);
      return 0;
    }
    AppMethodBeat.o(195507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.NotificationBar
 * JD-Core Version:    0.7.0.1
 */