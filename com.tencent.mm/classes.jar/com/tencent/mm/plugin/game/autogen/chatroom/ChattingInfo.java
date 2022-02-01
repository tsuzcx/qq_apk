package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChattingInfo
  extends com.tencent.mm.bx.a
{
  public String avator;
  public int chating_type;
  public String desc;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275505);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.g(1, this.desc);
      }
      paramVarArgs.bS(2, this.chating_type);
      if (this.avator != null) {
        paramVarArgs.g(3, this.avator);
      }
      paramVarArgs.bS(4, this.version);
      AppMethodBeat.o(275505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = i.a.a.b.b.a.h(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.chating_type);
      paramInt = i;
      if (this.avator != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.avator);
      }
      i = i.a.a.b.b.a.cJ(4, this.version);
      AppMethodBeat.o(275505);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275505);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ChattingInfo localChattingInfo = (ChattingInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275505);
          return -1;
        case 1: 
          localChattingInfo.desc = locala.ajGk.readString();
          AppMethodBeat.o(275505);
          return 0;
        case 2: 
          localChattingInfo.chating_type = locala.ajGk.aar();
          AppMethodBeat.o(275505);
          return 0;
        case 3: 
          localChattingInfo.avator = locala.ajGk.readString();
          AppMethodBeat.o(275505);
          return 0;
        }
        localChattingInfo.version = locala.ajGk.aar();
        AppMethodBeat.o(275505);
        return 0;
      }
      AppMethodBeat.o(275505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChattingInfo
 * JD-Core Version:    0.7.0.1
 */