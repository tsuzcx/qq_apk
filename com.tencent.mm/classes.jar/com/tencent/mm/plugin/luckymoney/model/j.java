package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public String Krq;
  public String Krr;
  public int lTH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lTH);
      if (this.Krq != null) {
        paramVarArgs.g(2, this.Krq);
      }
      if (this.Krr != null) {
        paramVarArgs.g(3, this.Krr);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.lTH) + 0;
      paramInt = i;
      if (this.Krq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Krq);
      }
      i = paramInt;
      if (this.Krr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Krr);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91251);
        return -1;
      case 1: 
        localj.lTH = locala.ajGk.aar();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        localj.Krq = locala.ajGk.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      localj.Krr = locala.ajGk.readString();
      AppMethodBeat.o(91251);
      return 0;
    }
    AppMethodBeat.o(91251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.j
 * JD-Core Version:    0.7.0.1
 */