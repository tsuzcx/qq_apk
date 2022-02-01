package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomJumpDetail
  extends com.tencent.mm.bx.a
{
  public String desc;
  public JumpInfo jump_info;
  public ShowIcon show_icon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275592);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.jump_info != null)
      {
        paramVarArgs.qD(1, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      if (this.show_icon != null)
      {
        paramVarArgs.qD(2, this.show_icon.computeSize());
        this.show_icon.writeFields(paramVarArgs);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      AppMethodBeat.o(275592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jump_info == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.jump_info.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.show_icon != null) {
        paramInt = i + i.a.a.a.qC(2, this.show_icon.computeSize());
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      AppMethodBeat.o(275592);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomJumpDetail localChatroomJumpDetail = (ChatroomJumpDetail)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275592);
          return -1;
        case 1: 
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
            localChatroomJumpDetail.jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275592);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ShowIcon();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ShowIcon)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomJumpDetail.show_icon = ((ShowIcon)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275592);
          return 0;
        }
        localChatroomJumpDetail.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275592);
        return 0;
      }
      AppMethodBeat.o(275592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomJumpDetail
 * JD-Core Version:    0.7.0.1
 */