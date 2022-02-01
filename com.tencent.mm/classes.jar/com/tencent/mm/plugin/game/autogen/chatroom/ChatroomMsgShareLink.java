package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgShareLink
  extends com.tencent.mm.bx.a
{
  public String desc;
  public JumpInfo jump_info;
  public String pic_url;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275509);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pic_url != null) {
        paramVarArgs.g(1, this.pic_url);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      if (this.jump_info != null)
      {
        paramVarArgs.qD(4, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pic_url == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.b.b.a.h(1, this.pic_url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.jump_info.computeSize());
      }
      AppMethodBeat.o(275509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ChatroomMsgShareLink localChatroomMsgShareLink = (ChatroomMsgShareLink)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275509);
          return -1;
        case 1: 
          localChatroomMsgShareLink.pic_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275509);
          return 0;
        case 2: 
          localChatroomMsgShareLink.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275509);
          return 0;
        case 3: 
          localChatroomMsgShareLink.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275509);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          JumpInfo localJumpInfo = new JumpInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localJumpInfo.parseFrom((byte[])localObject);
          }
          localChatroomMsgShareLink.jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(275509);
        return 0;
      }
      AppMethodBeat.o(275509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgShareLink
 * JD-Core Version:    0.7.0.1
 */