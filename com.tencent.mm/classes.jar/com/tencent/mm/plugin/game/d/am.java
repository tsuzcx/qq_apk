package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  extends com.tencent.mm.bx.a
{
  public String rZo;
  public int saK;
  public int sbg;
  public String sbh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.saK);
      if (this.rZo != null) {
        paramVarArgs.d(2, this.rZo);
      }
      paramVarArgs.aR(3, this.sbg);
      if (this.sbh != null) {
        paramVarArgs.d(4, this.sbh);
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.saK) + 0;
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZo);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.sbg);
      paramInt = i;
      if (this.sbh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sbh);
      }
      AppMethodBeat.o(149414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      am localam = (am)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149414);
        return -1;
      case 1: 
        localam.saK = locala.KhF.xS();
        AppMethodBeat.o(149414);
        return 0;
      case 2: 
        localam.rZo = locala.KhF.readString();
        AppMethodBeat.o(149414);
        return 0;
      case 3: 
        localam.sbg = locala.KhF.xS();
        AppMethodBeat.o(149414);
        return 0;
      }
      localam.sbh = locala.KhF.readString();
      AppMethodBeat.o(149414);
      return 0;
    }
    AppMethodBeat.o(149414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.am
 * JD-Core Version:    0.7.0.1
 */