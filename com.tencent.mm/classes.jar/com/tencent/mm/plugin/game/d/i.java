package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public boolean rZO;
  public boolean rZP;
  public boolean rZQ;
  public boolean rZR;
  public boolean rZS;
  public boolean rZT;
  public boolean rZU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.rZO);
      paramVarArgs.bg(2, this.rZP);
      paramVarArgs.bg(3, this.rZQ);
      paramVarArgs.bg(4, this.rZR);
      paramVarArgs.bg(5, this.rZS);
      paramVarArgs.bg(6, this.rZT);
      paramVarArgs.bg(7, this.rZU);
      AppMethodBeat.o(190562);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.fY(6);
      int i1 = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(190562);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(190562);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190562);
        return -1;
      case 1: 
        locali.rZO = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      case 2: 
        locali.rZP = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      case 3: 
        locali.rZQ = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      case 4: 
        locali.rZR = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      case 5: 
        locali.rZS = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      case 6: 
        locali.rZT = locala.KhF.fHu();
        AppMethodBeat.o(190562);
        return 0;
      }
      locali.rZU = locala.KhF.fHu();
      AppMethodBeat.o(190562);
      return 0;
    }
    AppMethodBeat.o(190562);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.i
 * JD-Core Version:    0.7.0.1
 */