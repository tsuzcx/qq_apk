package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int Width;
  public int xuT;
  public String xuU;
  public String xuV;
  public boolean xuW;
  public int xuX;
  public int xuY;
  public long xui;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xuT);
      if (this.xuU != null) {
        paramVarArgs.e(2, this.xuU);
      }
      if (this.xuV != null) {
        paramVarArgs.e(3, this.xuV);
      }
      paramVarArgs.aM(4, this.Width);
      paramVarArgs.aM(5, this.Height);
      paramVarArgs.cc(6, this.xuW);
      paramVarArgs.aM(7, this.xuX);
      paramVarArgs.bb(8, this.xui);
      paramVarArgs.aM(9, this.xuY);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xuT) + 0;
      paramInt = i;
      if (this.xuU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xuU);
      }
      i = paramInt;
      if (this.xuV != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xuV);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Width);
      int j = g.a.a.b.b.a.bu(5, this.Height);
      int k = g.a.a.b.b.a.fS(6);
      int m = g.a.a.b.b.a.bu(7, this.xuX);
      int n = g.a.a.b.b.a.r(8, this.xui);
      int i1 = g.a.a.b.b.a.bu(9, this.xuY);
      AppMethodBeat.o(40875);
      return i + paramInt + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        locali.xuT = locala.UbS.zi();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.xuU = locala.UbS.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.xuV = locala.UbS.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.UbS.zi();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.UbS.zi();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.xuW = locala.UbS.yZ();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.xuX = locala.UbS.zi();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.xui = locala.UbS.zl();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.xuY = locala.UbS.zi();
      AppMethodBeat.o(40875);
      return 0;
    }
    AppMethodBeat.o(40875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.i
 * JD-Core Version:    0.7.0.1
 */