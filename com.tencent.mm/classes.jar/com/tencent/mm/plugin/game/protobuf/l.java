package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
  extends com.tencent.mm.cd.a
{
  public boolean CNr;
  public boolean CNs;
  public boolean CNt;
  public boolean CNu;
  public boolean CNv;
  public boolean CNw;
  public boolean CNx;
  public boolean CNy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207012);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.CNr);
      paramVarArgs.co(2, this.CNs);
      paramVarArgs.co(3, this.CNt);
      paramVarArgs.co(4, this.CNu);
      paramVarArgs.co(5, this.CNv);
      paramVarArgs.co(6, this.CNw);
      paramVarArgs.co(7, this.CNx);
      paramVarArgs.co(8, this.CNy);
      AppMethodBeat.o(207012);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      int i1 = g.a.a.b.b.a.gL(7);
      int i2 = g.a.a.b.b.a.gL(8);
      AppMethodBeat.o(207012);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207012);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207012);
        return -1;
      case 1: 
        locall.CNr = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 2: 
        locall.CNs = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 3: 
        locall.CNt = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 4: 
        locall.CNu = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 5: 
        locall.CNv = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 6: 
        locall.CNw = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      case 7: 
        locall.CNx = locala.abFh.AB();
        AppMethodBeat.o(207012);
        return 0;
      }
      locall.CNy = locala.abFh.AB();
      AppMethodBeat.o(207012);
      return 0;
    }
    AppMethodBeat.o(207012);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.l
 * JD-Core Version:    0.7.0.1
 */