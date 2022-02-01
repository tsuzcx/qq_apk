package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgApp
  extends com.tencent.mm.bx.a
{
  public String bg_pic_url;
  public Color button_bg_color;
  public String button_des;
  public String des;
  public JumpInfo jump_info;
  public String second_des;
  public String title;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275506);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.des != null) {
        paramVarArgs.g(2, this.des);
      }
      if (this.button_des != null) {
        paramVarArgs.g(3, this.button_des);
      }
      if (this.bg_pic_url != null) {
        paramVarArgs.g(4, this.bg_pic_url);
      }
      paramVarArgs.bS(5, this.type);
      if (this.second_des != null) {
        paramVarArgs.g(6, this.second_des);
      }
      if (this.button_bg_color != null)
      {
        paramVarArgs.qD(8, this.button_bg_color.computeSize());
        this.button_bg_color.writeFields(paramVarArgs);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(7, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label766;
      }
    }
    label766:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.des != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.des);
      }
      i = paramInt;
      if (this.button_des != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.button_des);
      }
      paramInt = i;
      if (this.bg_pic_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.bg_pic_url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.second_des != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.second_des);
      }
      i = paramInt;
      if (this.button_bg_color != null) {
        i = paramInt + i.a.a.a.qC(8, this.button_bg_color.computeSize());
      }
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(7, this.jump_info.computeSize());
      }
      AppMethodBeat.o(275506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomMsgApp localChatroomMsgApp = (ChatroomMsgApp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275506);
          return -1;
        case 1: 
          localChatroomMsgApp.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275506);
          return 0;
        case 2: 
          localChatroomMsgApp.des = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275506);
          return 0;
        case 3: 
          localChatroomMsgApp.button_des = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275506);
          return 0;
        case 4: 
          localChatroomMsgApp.bg_pic_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275506);
          return 0;
        case 5: 
          localChatroomMsgApp.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275506);
          return 0;
        case 6: 
          localChatroomMsgApp.second_des = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275506);
          return 0;
        case 8: 
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
            localChatroomMsgApp.button_bg_color = ((Color)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275506);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new JumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localChatroomMsgApp.jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275506);
        return 0;
      }
      AppMethodBeat.o(275506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgApp
 * JD-Core Version:    0.7.0.1
 */