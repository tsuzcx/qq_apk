package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public int nUs;
  public int nUt;
  public String nUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116410);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.nUs);
      paramVarArgs.bS(2, this.nUt);
      if (this.nUu != null) {
        paramVarArgs.g(3, this.nUu);
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.nUs) + 0 + i.a.a.b.b.a.cJ(2, this.nUt);
      paramInt = i;
      if (this.nUu != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nUu);
      }
      AppMethodBeat.o(116410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116410);
        return -1;
      case 1: 
        localo.nUs = locala.ajGk.aar();
        AppMethodBeat.o(116410);
        return 0;
      case 2: 
        localo.nUt = locala.ajGk.aar();
        AppMethodBeat.o(116410);
        return 0;
      }
      localo.nUu = locala.ajGk.readString();
      AppMethodBeat.o(116410);
      return 0;
    }
    AppMethodBeat.o(116410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.message.o
 * JD-Core Version:    0.7.0.1
 */