package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class l
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String npU;
  public int nqC;
  public String nqa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111552);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(111552);
        throw paramVarArgs;
      }
      if (this.nqa == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(111552);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nqC);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.nqa != null) {
        paramVarArgs.e(3, this.nqa);
      }
      if (this.npU != null) {
        paramVarArgs.e(4, this.npU);
      }
      AppMethodBeat.o(111552);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nqC) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.nqa != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqa);
      }
      paramInt = i;
      if (this.npU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npU);
      }
      AppMethodBeat.o(111552);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(111552);
        throw paramVarArgs;
      }
      if (this.nqa == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(111552);
        throw paramVarArgs;
      }
      AppMethodBeat.o(111552);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111552);
        return -1;
      case 1: 
        locall.nqC = locala.CLY.sl();
        AppMethodBeat.o(111552);
        return 0;
      case 2: 
        locall.Name = locala.CLY.readString();
        AppMethodBeat.o(111552);
        return 0;
      case 3: 
        locall.nqa = locala.CLY.readString();
        AppMethodBeat.o(111552);
        return 0;
      }
      locall.npU = locala.CLY.readString();
      AppMethodBeat.o(111552);
      return 0;
    }
    AppMethodBeat.o(111552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.l
 * JD-Core Version:    0.7.0.1
 */