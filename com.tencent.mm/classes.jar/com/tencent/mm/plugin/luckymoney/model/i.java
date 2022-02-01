package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public int gGn;
  public String yUG;
  public String yUH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.gGn);
      if (this.yUG != null) {
        paramVarArgs.e(2, this.yUG);
      }
      if (this.yUH != null) {
        paramVarArgs.e(3, this.yUH);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.gGn) + 0;
      paramInt = i;
      if (this.yUG != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yUG);
      }
      i = paramInt;
      if (this.yUH != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.yUH);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        locali.gGn = locala.UbS.zi();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        locali.yUG = locala.UbS.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      locali.yUH = locala.UbS.readString();
      AppMethodBeat.o(91251);
      return 0;
    }
    AppMethodBeat.o(91251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.i
 * JD-Core Version:    0.7.0.1
 */