package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class ChatroomSeq
  extends com.tencent.mm.bx.a
{
  public int channel_id;
  public String chatroom_name;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275529);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275529);
        throw paramVarArgs;
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(1, this.chatroom_name);
      }
      paramVarArgs.bS(2, this.channel_id);
      paramVarArgs.bv(3, this.seq);
      AppMethodBeat.o(275529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_name == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = i.a.a.b.b.a.h(1, this.chatroom_name) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.channel_id);
      int j = i.a.a.b.b.a.q(3, this.seq);
      AppMethodBeat.o(275529);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(275529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275529);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ChatroomSeq localChatroomSeq = (ChatroomSeq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275529);
          return -1;
        case 1: 
          localChatroomSeq.chatroom_name = locala.ajGk.readString();
          AppMethodBeat.o(275529);
          return 0;
        case 2: 
          localChatroomSeq.channel_id = locala.ajGk.aar();
          AppMethodBeat.o(275529);
          return 0;
        }
        localChatroomSeq.seq = locala.ajGk.aaw();
        AppMethodBeat.o(275529);
        return 0;
      }
      AppMethodBeat.o(275529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomSeq
 * JD-Core Version:    0.7.0.1
 */