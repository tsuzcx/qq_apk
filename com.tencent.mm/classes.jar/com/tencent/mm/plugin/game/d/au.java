package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bw.a
{
  public int uqI;
  public String uqf;
  public int uss;
  public String ust;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uqI);
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      paramVarArgs.aS(3, this.uss);
      if (this.ust != null) {
        paramVarArgs.d(4, this.ust);
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uqI) + 0;
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqf);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.uss);
      paramInt = i;
      if (this.ust != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ust);
      }
      AppMethodBeat.o(149414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      au localau = (au)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149414);
        return -1;
      case 1: 
        localau.uqI = locala.OmT.zc();
        AppMethodBeat.o(149414);
        return 0;
      case 2: 
        localau.uqf = locala.OmT.readString();
        AppMethodBeat.o(149414);
        return 0;
      case 3: 
        localau.uss = locala.OmT.zc();
        AppMethodBeat.o(149414);
        return 0;
      }
      localau.ust = locala.OmT.readString();
      AppMethodBeat.o(149414);
      return 0;
    }
    AppMethodBeat.o(149414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.au
 * JD-Core Version:    0.7.0.1
 */