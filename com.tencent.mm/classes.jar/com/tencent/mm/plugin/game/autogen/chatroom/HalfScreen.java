package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class HalfScreen
  extends com.tencent.mm.bx.a
{
  public int screen_height_dp;
  public float screen_height_percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275516);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.screen_height_dp);
      paramVarArgs.l(3, this.screen_height_percent);
      AppMethodBeat.o(275516);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.type);
      int i = i.a.a.b.b.a.cJ(2, this.screen_height_dp);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(275516);
      return paramInt + 0 + i + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275516);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      HalfScreen localHalfScreen = (HalfScreen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275516);
        return -1;
      case 1: 
        localHalfScreen.type = locala.ajGk.aar();
        AppMethodBeat.o(275516);
        return 0;
      case 2: 
        localHalfScreen.screen_height_dp = locala.ajGk.aar();
        AppMethodBeat.o(275516);
        return 0;
      }
      localHalfScreen.screen_height_percent = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(275516);
      return 0;
    }
    AppMethodBeat.o(275516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.HalfScreen
 * JD-Core Version:    0.7.0.1
 */