package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class NotificationBar
  extends com.tencent.mm.bx.a
{
  public LinkedList<Notification> notification_list;
  public String version;
  
  public NotificationBar()
  {
    AppMethodBeat.i(275561);
    this.notification_list = new LinkedList();
    AppMethodBeat.o(275561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275570);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.notification_list);
      if (this.version != null) {
        paramVarArgs.g(2, this.version);
      }
      AppMethodBeat.o(275570);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.notification_list) + 0;
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.version);
      }
      AppMethodBeat.o(275570);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.notification_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275570);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      NotificationBar localNotificationBar = (NotificationBar)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275570);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
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
        AppMethodBeat.o(275570);
        return 0;
      }
      localNotificationBar.version = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(275570);
      return 0;
    }
    AppMethodBeat.o(275570);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.NotificationBar
 * JD-Core Version:    0.7.0.1
 */