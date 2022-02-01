package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends com.tencent.mm.bw.a
{
  public String ikm;
  public String uqn;
  public int urH;
  public int urI;
  public int urJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.urH);
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.urI);
      if (this.uqn != null) {
        paramVarArgs.d(4, this.uqn);
      }
      paramVarArgs.aS(5, this.urJ);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.urH) + 0;
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.urI);
      paramInt = i;
      if (this.uqn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqn);
      }
      i = f.a.a.b.b.a.bz(5, this.urJ);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localab.urH = locala.OmT.zc();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localab.ikm = locala.OmT.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localab.urI = locala.OmT.zc();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localab.uqn = locala.OmT.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localab.urJ = locala.OmT.zc();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ab
 * JD-Core Version:    0.7.0.1
 */