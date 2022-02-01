package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bx.a
{
  public int IKL;
  public float IKM;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276910);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.IKL);
      paramVarArgs.l(3, this.IKM);
      AppMethodBeat.o(276910);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vhJ);
      int i = i.a.a.b.b.a.cJ(2, this.IKL);
      int j = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(276910);
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
      AppMethodBeat.o(276910);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      cm localcm = (cm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(276910);
        return -1;
      case 1: 
        localcm.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(276910);
        return 0;
      case 2: 
        localcm.IKL = locala.ajGk.aar();
        AppMethodBeat.o(276910);
        return 0;
      }
      localcm.IKM = Float.intBitsToFloat(locala.ajGk.aax());
      AppMethodBeat.o(276910);
      return 0;
    }
    AppMethodBeat.o(276910);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */