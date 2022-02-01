package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class NoticeMsg
  extends com.tencent.mm.bx.a
{
  public boolean highlight;
  public String notice_text;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275496);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.notice_text == null)
      {
        paramVarArgs = new b("Not all required fields were included: notice_text");
        AppMethodBeat.o(275496);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.seq);
      if (this.notice_text != null) {
        paramVarArgs.g(2, this.notice_text);
      }
      paramVarArgs.di(3, this.highlight);
      AppMethodBeat.o(275496);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.seq) + 0;
      paramInt = i;
      if (this.notice_text != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.notice_text);
      }
      i = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(275496);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.notice_text == null)
      {
        paramVarArgs = new b("Not all required fields were included: notice_text");
        AppMethodBeat.o(275496);
        throw paramVarArgs;
      }
      AppMethodBeat.o(275496);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      NoticeMsg localNoticeMsg = (NoticeMsg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275496);
        return -1;
      case 1: 
        localNoticeMsg.seq = locala.ajGk.aaw();
        AppMethodBeat.o(275496);
        return 0;
      case 2: 
        localNoticeMsg.notice_text = locala.ajGk.readString();
        AppMethodBeat.o(275496);
        return 0;
      }
      localNoticeMsg.highlight = locala.ajGk.aai();
      AppMethodBeat.o(275496);
      return 0;
    }
    AppMethodBeat.o(275496);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.NoticeMsg
 * JD-Core Version:    0.7.0.1
 */