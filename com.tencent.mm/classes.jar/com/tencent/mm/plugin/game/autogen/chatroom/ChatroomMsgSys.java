package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgSys
  extends com.tencent.mm.cd.a
{
  public ChatroomMsgTpl chatroom_msg_tpl;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195463);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.chatroom_msg_tpl != null)
      {
        paramVarArgs.oE(2, this.chatroom_msg_tpl.computeSize());
        this.chatroom_msg_tpl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_msg_tpl != null) {
        i = paramInt + g.a.a.a.oD(2, this.chatroom_msg_tpl.computeSize());
      }
      AppMethodBeat.o(195463);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195463);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ChatroomMsgSys localChatroomMsgSys = (ChatroomMsgSys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195463);
          return -1;
        case 1: 
          localChatroomMsgSys.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(195463);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
        AppMethodBeat.o(195463);
        return 0;
      }
      AppMethodBeat.o(195463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgSys
 * JD-Core Version:    0.7.0.1
 */