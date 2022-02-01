package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class OnlineUser
  extends com.tencent.mm.bx.a
{
  public LinkedList<ChatroomUserData> chat_user_data;
  public Color icon_color;
  public String left_icon;
  public boolean need_fold;
  public long status;
  public String status_desc;
  public String status_icon;
  public TextInfo text_desc;
  
  public OnlineUser()
  {
    AppMethodBeat.i(275588);
    this.chat_user_data = new LinkedList();
    AppMethodBeat.o(275588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275600);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.chat_user_data);
      paramVarArgs.bv(2, this.status);
      if (this.status_icon != null) {
        paramVarArgs.g(3, this.status_icon);
      }
      if (this.icon_color != null)
      {
        paramVarArgs.qD(4, this.icon_color.computeSize());
        this.icon_color.writeFields(paramVarArgs);
      }
      if (this.status_desc != null) {
        paramVarArgs.g(5, this.status_desc);
      }
      if (this.text_desc != null)
      {
        paramVarArgs.qD(6, this.text_desc.computeSize());
        this.text_desc.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.need_fold);
      if (this.left_icon != null) {
        paramVarArgs.g(8, this.left_icon);
      }
      AppMethodBeat.o(275600);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.chat_user_data) + 0 + i.a.a.b.b.a.q(2, this.status);
      paramInt = i;
      if (this.status_icon != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.status_icon);
      }
      i = paramInt;
      if (this.icon_color != null) {
        i = paramInt + i.a.a.a.qC(4, this.icon_color.computeSize());
      }
      paramInt = i;
      if (this.status_desc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.status_desc);
      }
      i = paramInt;
      if (this.text_desc != null) {
        i = paramInt + i.a.a.a.qC(6, this.text_desc.computeSize());
      }
      i += i.a.a.b.b.a.ko(7) + 1;
      paramInt = i;
      if (this.left_icon != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.left_icon);
      }
      AppMethodBeat.o(275600);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.chat_user_data.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275600);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      OnlineUser localOnlineUser = (OnlineUser)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275600);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        AppMethodBeat.o(275600);
        return 0;
      case 2: 
        localOnlineUser.status = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(275600);
        return 0;
      case 3: 
        localOnlineUser.status_icon = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275600);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
        AppMethodBeat.o(275600);
        return 0;
      case 5: 
        localOnlineUser.status_desc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275600);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new TextInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((TextInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localOnlineUser.text_desc = ((TextInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275600);
        return 0;
      case 7: 
        localOnlineUser.need_fold = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(275600);
        return 0;
      }
      localOnlineUser.left_icon = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(275600);
      return 0;
    }
    AppMethodBeat.o(275600);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.OnlineUser
 * JD-Core Version:    0.7.0.1
 */