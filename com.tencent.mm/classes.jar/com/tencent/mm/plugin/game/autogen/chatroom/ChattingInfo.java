package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChattingInfo
  extends com.tencent.mm.cd.a
{
  public String avator;
  public int chating_type;
  public String desc;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195130);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.f(1, this.desc);
      }
      paramVarArgs.aY(2, this.chating_type);
      if (this.avator != null) {
        paramVarArgs.f(3, this.avator);
      }
      paramVarArgs.aY(4, this.version);
      AppMethodBeat.o(195130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.chating_type);
      paramInt = i;
      if (this.avator != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.avator);
      }
      i = g.a.a.b.b.a.bM(4, this.version);
      AppMethodBeat.o(195130);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195130);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ChattingInfo localChattingInfo = (ChattingInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195130);
          return -1;
        case 1: 
          localChattingInfo.desc = locala.abFh.readString();
          AppMethodBeat.o(195130);
          return 0;
        case 2: 
          localChattingInfo.chating_type = locala.abFh.AK();
          AppMethodBeat.o(195130);
          return 0;
        case 3: 
          localChattingInfo.avator = locala.abFh.readString();
          AppMethodBeat.o(195130);
          return 0;
        }
        localChattingInfo.version = locala.abFh.AK();
        AppMethodBeat.o(195130);
        return 0;
      }
      AppMethodBeat.o(195130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChattingInfo
 * JD-Core Version:    0.7.0.1
 */