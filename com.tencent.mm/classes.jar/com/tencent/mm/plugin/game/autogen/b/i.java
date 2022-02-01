package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.cd.a
{
  public long Cqz;
  public int Crm;
  public String Crn;
  public String Cro;
  public boolean Crp;
  public int Crq;
  public int Crr;
  public int Height;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Crm);
      if (this.Crn != null) {
        paramVarArgs.f(2, this.Crn);
      }
      if (this.Cro != null) {
        paramVarArgs.f(3, this.Cro);
      }
      paramVarArgs.aY(4, this.Width);
      paramVarArgs.aY(5, this.Height);
      paramVarArgs.co(6, this.Crp);
      paramVarArgs.aY(7, this.Crq);
      paramVarArgs.bm(8, this.Cqz);
      paramVarArgs.aY(9, this.Crr);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Crm) + 0;
      paramInt = i;
      if (this.Crn != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Crn);
      }
      i = paramInt;
      if (this.Cro != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Cro);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Width);
      int j = g.a.a.b.b.a.bM(5, this.Height);
      int k = g.a.a.b.b.a.gL(6);
      int m = g.a.a.b.b.a.bM(7, this.Crq);
      int n = g.a.a.b.b.a.p(8, this.Cqz);
      int i1 = g.a.a.b.b.a.bM(9, this.Crr);
      AppMethodBeat.o(40875);
      return i + paramInt + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(40875);
        return -1;
      case 1: 
        locali.Crm = locala.abFh.AK();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.Crn = locala.abFh.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.Cro = locala.abFh.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.abFh.AK();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.abFh.AK();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.Crp = locala.abFh.AB();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.Crq = locala.abFh.AK();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.Cqz = locala.abFh.AN();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.Crr = locala.abFh.AK();
      AppMethodBeat.o(40875);
      return 0;
    }
    AppMethodBeat.o(40875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.i
 * JD-Core Version:    0.7.0.1
 */