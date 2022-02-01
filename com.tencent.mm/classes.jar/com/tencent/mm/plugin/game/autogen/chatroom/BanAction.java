package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BanAction
  extends com.tencent.mm.bx.a
{
  public String desc;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275519);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      AppMethodBeat.o(275519);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      AppMethodBeat.o(275519);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275519);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      BanAction localBanAction = (BanAction)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275519);
        return -1;
      case 1: 
        localBanAction.type = locala.ajGk.aar();
        AppMethodBeat.o(275519);
        return 0;
      }
      localBanAction.desc = locala.ajGk.readString();
      AppMethodBeat.o(275519);
      return 0;
    }
    AppMethodBeat.o(275519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.BanAction
 * JD-Core Version:    0.7.0.1
 */