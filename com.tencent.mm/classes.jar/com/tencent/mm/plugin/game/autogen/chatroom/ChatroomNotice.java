package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChatroomNotice
  extends com.tencent.mm.bx.a
{
  public String notice_text;
  public long update_time;
  public int updater_uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.notice_text != null) {
        paramVarArgs.g(1, this.notice_text);
      }
      paramVarArgs.bv(2, this.update_time);
      paramVarArgs.bS(3, this.updater_uin);
      AppMethodBeat.o(275607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.notice_text == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.notice_text) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.update_time);
      int j = i.a.a.b.b.a.cJ(3, this.updater_uin);
      AppMethodBeat.o(275607);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275607);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ChatroomNotice localChatroomNotice = (ChatroomNotice)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275607);
          return -1;
        case 1: 
          localChatroomNotice.notice_text = locala.ajGk.readString();
          AppMethodBeat.o(275607);
          return 0;
        case 2: 
          localChatroomNotice.update_time = locala.ajGk.aaw();
          AppMethodBeat.o(275607);
          return 0;
        }
        localChatroomNotice.updater_uin = locala.ajGk.aar();
        AppMethodBeat.o(275607);
        return 0;
      }
      AppMethodBeat.o(275607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomNotice
 * JD-Core Version:    0.7.0.1
 */