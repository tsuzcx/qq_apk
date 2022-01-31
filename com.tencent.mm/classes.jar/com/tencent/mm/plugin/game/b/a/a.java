package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public int niE;
  public String niF;
  public String niG;
  public boolean niH;
  public int niI;
  public long niJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151790);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.niE);
      if (this.niF != null) {
        paramVarArgs.e(2, this.niF);
      }
      if (this.niG != null) {
        paramVarArgs.e(3, this.niG);
      }
      paramVarArgs.aO(4, this.Width);
      paramVarArgs.aO(5, this.Height);
      paramVarArgs.aS(6, this.niH);
      paramVarArgs.aO(7, this.niI);
      paramVarArgs.am(8, this.niJ);
      AppMethodBeat.o(151790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.niE) + 0;
      paramInt = i;
      if (this.niF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.niF);
      }
      i = paramInt;
      if (this.niG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.niG);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.Width);
      int j = e.a.a.b.b.a.bl(5, this.Height);
      int k = e.a.a.b.b.a.eW(6);
      int m = e.a.a.b.b.a.bl(7, this.niI);
      int n = e.a.a.b.b.a.p(8, this.niJ);
      AppMethodBeat.o(151790);
      return i + paramInt + j + (k + 1) + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151790);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151790);
        return -1;
      case 1: 
        locala1.niE = locala.CLY.sl();
        AppMethodBeat.o(151790);
        return 0;
      case 2: 
        locala1.niF = locala.CLY.readString();
        AppMethodBeat.o(151790);
        return 0;
      case 3: 
        locala1.niG = locala.CLY.readString();
        AppMethodBeat.o(151790);
        return 0;
      case 4: 
        locala1.Width = locala.CLY.sl();
        AppMethodBeat.o(151790);
        return 0;
      case 5: 
        locala1.Height = locala.CLY.sl();
        AppMethodBeat.o(151790);
        return 0;
      case 6: 
        locala1.niH = locala.CLY.emu();
        AppMethodBeat.o(151790);
        return 0;
      case 7: 
        locala1.niI = locala.CLY.sl();
        AppMethodBeat.o(151790);
        return 0;
      }
      locala1.niJ = locala.CLY.sm();
      AppMethodBeat.o(151790);
      return 0;
    }
    AppMethodBeat.o(151790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */