package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Lbs
  extends com.tencent.mm.bx.a
{
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.longitude);
      paramVarArgs.l(2, this.latitude);
      AppMethodBeat.o(275503);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(275503);
      return paramInt + 4 + 0 + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275503);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      Lbs localLbs = (Lbs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275503);
        return -1;
      case 1: 
        localLbs.longitude = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(275503);
        return 0;
      }
      localLbs.latitude = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(275503);
      return 0;
    }
    AppMethodBeat.o(275503);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Lbs
 * JD-Core Version:    0.7.0.1
 */