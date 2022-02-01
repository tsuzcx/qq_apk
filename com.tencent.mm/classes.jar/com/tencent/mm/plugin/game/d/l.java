package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public boolean uqS;
  public boolean uqT;
  public boolean uqU;
  public boolean uqV;
  public boolean uqW;
  public boolean uqX;
  public boolean uqY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.uqS);
      paramVarArgs.bC(2, this.uqT);
      paramVarArgs.bC(3, this.uqU);
      paramVarArgs.bC(4, this.uqV);
      paramVarArgs.bC(5, this.uqW);
      paramVarArgs.bC(6, this.uqX);
      paramVarArgs.bC(7, this.uqY);
      AppMethodBeat.o(221878);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.amF(5);
      int n = f.a.a.b.b.a.amF(6);
      int i1 = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(221878);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221878);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221878);
        return -1;
      case 1: 
        locall.uqS = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      case 2: 
        locall.uqT = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      case 3: 
        locall.uqU = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      case 4: 
        locall.uqV = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      case 5: 
        locall.uqW = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      case 6: 
        locall.uqX = locala.OmT.gvY();
        AppMethodBeat.o(221878);
        return 0;
      }
      locall.uqY = locala.OmT.gvY();
      AppMethodBeat.o(221878);
      return 0;
    }
    AppMethodBeat.o(221878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.l
 * JD-Core Version:    0.7.0.1
 */