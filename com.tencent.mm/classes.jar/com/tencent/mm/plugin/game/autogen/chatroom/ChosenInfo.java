package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ChosenInfo
  extends com.tencent.mm.bx.a
{
  public boolean can_be_chosen;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275513);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).di(1, this.can_be_chosen);
      AppMethodBeat.o(275513);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      AppMethodBeat.o(275513);
      return paramInt + 1 + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275513);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ChosenInfo localChosenInfo = (ChosenInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275513);
        return -1;
      }
      localChosenInfo.can_be_chosen = locala.ajGk.aai();
      AppMethodBeat.o(275513);
      return 0;
    }
    AppMethodBeat.o(275513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChosenInfo
 * JD-Core Version:    0.7.0.1
 */