package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends com.tencent.mm.bx.a
{
  public boolean IHR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276914);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).di(1, this.IHR);
      AppMethodBeat.o(276914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      AppMethodBeat.o(276914);
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
      AppMethodBeat.o(276914);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(276914);
        return -1;
      }
      localab.IHR = locala.ajGk.aai();
      AppMethodBeat.o(276914);
      return 0;
    }
    AppMethodBeat.o(276914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ab
 * JD-Core Version:    0.7.0.1
 */