package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class OnlineUser
  extends com.tencent.mm.cd.a
{
  public LinkedList<ChatroomUserData> chat_user_data;
  public Color icon_color;
  public long status;
  public String status_desc;
  public String status_icon;
  
  public OnlineUser()
  {
    AppMethodBeat.i(195613);
    this.chat_user_data = new LinkedList();
    AppMethodBeat.o(195613);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.chat_user_data);
      paramVarArgs.bm(2, this.status);
      if (this.status_icon != null) {
        paramVarArgs.f(3, this.status_icon);
      }
      if (this.icon_color != null)
      {
        paramVarArgs.oE(4, this.icon_color.computeSize());
        this.icon_color.writeFields(paramVarArgs);
      }
      if (this.status_desc != null) {
        paramVarArgs.f(5, this.status_desc);
      }
      AppMethodBeat.o(195618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.chat_user_data) + 0 + g.a.a.b.b.a.p(2, this.status);
      paramInt = i;
      if (this.status_icon != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.status_icon);
      }
      i = paramInt;
      if (this.icon_color != null) {
        i = paramInt + g.a.a.a.oD(4, this.icon_color.computeSize());
      }
      paramInt = i;
      if (this.status_desc != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.status_desc);
      }
      AppMethodBeat.o(195618);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.chat_user_data.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      OnlineUser localOnlineUser = (OnlineUser)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195618);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomUserData();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomUserData)localObject2).parseFrom((byte[])localObject1);
          }
          localOnlineUser.chat_user_data.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195618);
        return 0;
      case 2: 
        localOnlineUser.status = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(195618);
        return 0;
      case 3: 
        localOnlineUser.status_icon = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(195618);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new Color();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((Color)localObject2).parseFrom((byte[])localObject1);
          }
          localOnlineUser.icon_color = ((Color)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195618);
        return 0;
      }
      localOnlineUser.status_desc = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(195618);
      return 0;
    }
    AppMethodBeat.o(195618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.OnlineUser
 * JD-Core Version:    0.7.0.1
 */