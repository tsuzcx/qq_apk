package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class HalfScreen
  extends com.tencent.mm.cd.a
{
  public int screen_height_dp;
  public float screen_height_percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195143);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.screen_height_dp);
      paramVarArgs.i(3, this.screen_height_percent);
      AppMethodBeat.o(195143);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.type);
      int i = g.a.a.b.b.a.bM(2, this.screen_height_dp);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(195143);
      return paramInt + 0 + i + (j + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195143);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      HalfScreen localHalfScreen = (HalfScreen)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195143);
        return -1;
      case 1: 
        localHalfScreen.type = locala.abFh.AK();
        AppMethodBeat.o(195143);
        return 0;
      case 2: 
        localHalfScreen.screen_height_dp = locala.abFh.AK();
        AppMethodBeat.o(195143);
        return 0;
      }
      localHalfScreen.screen_height_percent = Float.intBitsToFloat(locala.abFh.AO());
      AppMethodBeat.o(195143);
      return 0;
    }
    AppMethodBeat.o(195143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.HalfScreen
 * JD-Core Version:    0.7.0.1
 */