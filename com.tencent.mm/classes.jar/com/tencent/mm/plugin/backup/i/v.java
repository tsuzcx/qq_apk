package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bx.a
{
  public int crz;
  public com.tencent.mm.bx.b vgA;
  public String vgy;
  public int vhI;
  public int vhJ;
  public int vhK;
  public int vhL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22127);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.vhI);
      if (this.vgy != null) {
        paramVarArgs.g(2, this.vgy);
      }
      if (this.vgA != null) {
        paramVarArgs.d(3, this.vgA);
      }
      paramVarArgs.bS(4, this.crz);
      paramVarArgs.bS(5, this.vhJ);
      paramVarArgs.bS(6, this.vhK);
      paramVarArgs.bS(7, this.vhL);
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhI) + 0;
      paramInt = i;
      if (this.vgy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vgy);
      }
      i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.vgA);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.crz);
      int j = i.a.a.b.b.a.cJ(5, this.vhJ);
      int k = i.a.a.b.b.a.cJ(6, this.vhK);
      int m = i.a.a.b.b.a.cJ(7, this.vhL);
      AppMethodBeat.o(22127);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.vgy == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22127);
        return -1;
      case 1: 
        localv.vhI = locala.ajGk.aar();
        AppMethodBeat.o(22127);
        return 0;
      case 2: 
        localv.vgy = locala.ajGk.readString();
        AppMethodBeat.o(22127);
        return 0;
      case 3: 
        localv.vgA = locala.ajGk.kFX();
        AppMethodBeat.o(22127);
        return 0;
      case 4: 
        localv.crz = locala.ajGk.aar();
        AppMethodBeat.o(22127);
        return 0;
      case 5: 
        localv.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(22127);
        return 0;
      case 6: 
        localv.vhK = locala.ajGk.aar();
        AppMethodBeat.o(22127);
        return 0;
      }
      localv.vhL = locala.ajGk.aar();
      AppMethodBeat.o(22127);
      return 0;
    }
    AppMethodBeat.o(22127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */