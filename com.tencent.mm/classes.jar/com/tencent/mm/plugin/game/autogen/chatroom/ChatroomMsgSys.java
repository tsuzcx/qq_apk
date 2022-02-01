package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgSys
  extends com.tencent.mm.bx.a
{
  public ChatroomMsgTpl chatroom_msg_tpl;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275577);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.chatroom_msg_tpl != null)
      {
        paramVarArgs.qD(2, this.chatroom_msg_tpl.computeSize());
        this.chatroom_msg_tpl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_msg_tpl != null) {
        i = paramInt + i.a.a.a.qC(2, this.chatroom_msg_tpl.computeSize());
      }
      AppMethodBeat.o(275577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275577);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ChatroomMsgSys localChatroomMsgSys = (ChatroomMsgSys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275577);
          return -1;
        case 1: 
          localChatroomMsgSys.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275577);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ChatroomMsgTpl localChatroomMsgTpl = new ChatroomMsgTpl();
          if ((localObject != null) && (localObject.length > 0)) {
            localChatroomMsgTpl.parseFrom((byte[])localObject);
          }
          localChatroomMsgSys.chatroom_msg_tpl = localChatroomMsgTpl;
          paramInt += 1;
        }
        AppMethodBeat.o(275577);
        return 0;
      }
      AppMethodBeat.o(275577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgSys
 * JD-Core Version:    0.7.0.1
 */