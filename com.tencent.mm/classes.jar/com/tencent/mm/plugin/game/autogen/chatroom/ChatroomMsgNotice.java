package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgNotice
  extends com.tencent.mm.cd.a
{
  public ChatroomMsgTpl chatroom_msg_tpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_msg_tpl != null)
      {
        paramVarArgs.oE(1, this.chatroom_msg_tpl.computeSize());
        this.chatroom_msg_tpl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_msg_tpl == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.chatroom_msg_tpl.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(194712);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ChatroomMsgNotice localChatroomMsgNotice = (ChatroomMsgNotice)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194712);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ChatroomMsgTpl localChatroomMsgTpl = new ChatroomMsgTpl();
          if ((localObject != null) && (localObject.length > 0)) {
            localChatroomMsgTpl.parseFrom((byte[])localObject);
          }
          localChatroomMsgNotice.chatroom_msg_tpl = localChatroomMsgTpl;
          paramInt += 1;
        }
        AppMethodBeat.o(194712);
        return 0;
      }
      AppMethodBeat.o(194712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgNotice
 * JD-Core Version:    0.7.0.1
 */