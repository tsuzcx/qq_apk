package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ad
  extends com.tencent.mm.cd.a
{
  public String CML;
  public int COg;
  public int COh;
  public int COi;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.COg);
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.COh);
      if (this.CML != null) {
        paramVarArgs.f(4, this.CML);
      }
      paramVarArgs.aY(5, this.COi);
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.COg) + 0;
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.COh);
      paramInt = i;
      if (this.CML != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CML);
      }
      i = g.a.a.b.b.a.bM(5, this.COi);
      AppMethodBeat.o(41722);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41722);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ad localad = (ad)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41722);
        return -1;
      case 1: 
        localad.COg = locala.abFh.AK();
        AppMethodBeat.o(41722);
        return 0;
      case 2: 
        localad.lVG = locala.abFh.readString();
        AppMethodBeat.o(41722);
        return 0;
      case 3: 
        localad.COh = locala.abFh.AK();
        AppMethodBeat.o(41722);
        return 0;
      case 4: 
        localad.CML = locala.abFh.readString();
        AppMethodBeat.o(41722);
        return 0;
      }
      localad.COi = locala.abFh.AK();
      AppMethodBeat.o(41722);
      return 0;
    }
    AppMethodBeat.o(41722);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */