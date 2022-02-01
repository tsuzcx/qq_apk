package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.cd.a
{
  public String EyD;
  public String EyE;
  public int jqz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jqz);
      if (this.EyD != null) {
        paramVarArgs.f(2, this.EyD);
      }
      if (this.EyE != null) {
        paramVarArgs.f(3, this.EyE);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.jqz) + 0;
      paramInt = i;
      if (this.EyD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.EyD);
      }
      i = paramInt;
      if (this.EyE != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.EyE);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91251);
        return -1;
      case 1: 
        locali.jqz = locala.abFh.AK();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        locali.EyD = locala.abFh.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      locali.EyE = locala.abFh.readString();
      AppMethodBeat.o(91251);
      return 0;
    }
    AppMethodBeat.o(91251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.i
 * JD-Core Version:    0.7.0.1
 */