package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.cd.a
{
  public String EyH;
  public String EyI;
  public int tpK;
  public boolean tpu;
  public String ufC;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.tpu);
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.ufC != null) {
        paramVarArgs.f(3, this.ufC);
      }
      paramVarArgs.aY(4, this.tpK);
      if (this.EyH != null) {
        paramVarArgs.f(5, this.EyH);
      }
      if (this.EyI != null) {
        paramVarArgs.f(6, this.EyI);
      }
      AppMethodBeat.o(257558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.ufC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ufC);
      }
      i += g.a.a.b.b.a.bM(4, this.tpK);
      paramInt = i;
      if (this.EyH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.EyH);
      }
      i = paramInt;
      if (this.EyI != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.EyI);
      }
      AppMethodBeat.o(257558);
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
      AppMethodBeat.o(257558);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257558);
        return -1;
      case 1: 
        locall.tpu = locala.abFh.AB();
        AppMethodBeat.o(257558);
        return 0;
      case 2: 
        locall.wording = locala.abFh.readString();
        AppMethodBeat.o(257558);
        return 0;
      case 3: 
        locall.ufC = locala.abFh.readString();
        AppMethodBeat.o(257558);
        return 0;
      case 4: 
        locall.tpK = locala.abFh.AK();
        AppMethodBeat.o(257558);
        return 0;
      case 5: 
        locall.EyH = locala.abFh.readString();
        AppMethodBeat.o(257558);
        return 0;
      }
      locall.EyI = locala.abFh.readString();
      AppMethodBeat.o(257558);
      return 0;
    }
    AppMethodBeat.o(257558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */