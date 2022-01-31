package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class k
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public int jJy;
  public int jJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18057);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(18057);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.jJy);
      paramVarArgs.aO(2, this.jJz);
      if (this.jJA != null) {
        paramVarArgs.e(3, this.jJA);
      }
      AppMethodBeat.o(18057);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jJy) + 0 + e.a.a.b.b.a.bl(2, this.jJz);
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.jJA);
      }
      AppMethodBeat.o(18057);
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
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(18057);
        throw paramVarArgs;
      }
      AppMethodBeat.o(18057);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18057);
        return -1;
      case 1: 
        localk.jJy = locala.CLY.sl();
        AppMethodBeat.o(18057);
        return 0;
      case 2: 
        localk.jJz = locala.CLY.sl();
        AppMethodBeat.o(18057);
        return 0;
      }
      localk.jJA = locala.CLY.readString();
      AppMethodBeat.o(18057);
      return 0;
    }
    AppMethodBeat.o(18057);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */