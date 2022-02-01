package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bx.a
{
  public int IHu;
  public int IHv;
  public int IHw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276890);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHu);
      paramVarArgs.bS(2, this.IHv);
      paramVarArgs.bS(3, this.IHw);
      AppMethodBeat.o(276890);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.IHu);
      int i = i.a.a.b.b.a.cJ(2, this.IHv);
      int j = i.a.a.b.b.a.cJ(3, this.IHw);
      AppMethodBeat.o(276890);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(276890);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(276890);
        return -1;
      case 1: 
        localk.IHu = locala.ajGk.aar();
        AppMethodBeat.o(276890);
        return 0;
      case 2: 
        localk.IHv = locala.ajGk.aar();
        AppMethodBeat.o(276890);
        return 0;
      }
      localk.IHw = locala.ajGk.aar();
      AppMethodBeat.o(276890);
      return 0;
    }
    AppMethodBeat.o(276890);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.k
 * JD-Core Version:    0.7.0.1
 */