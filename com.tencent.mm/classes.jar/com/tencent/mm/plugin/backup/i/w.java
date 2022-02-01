package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bx.a
{
  public int crz;
  public com.tencent.mm.bx.b vgA;
  public String vgy;
  public int vhI;
  public int vhJ;
  public int vhK;
  public com.tencent.mm.bx.b vhM;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22128);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.vhI);
      paramVarArgs.bS(2, this.vhk);
      if (this.vgy != null) {
        paramVarArgs.g(3, this.vgy);
      }
      if (this.vgA != null) {
        paramVarArgs.d(4, this.vgA);
      }
      paramVarArgs.bS(5, this.crz);
      paramVarArgs.bS(6, this.vhJ);
      paramVarArgs.bS(7, this.vhK);
      if (this.vhM != null) {
        paramVarArgs.d(8, this.vhM);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhI) + 0 + i.a.a.b.b.a.cJ(2, this.vhk);
      paramInt = i;
      if (this.vgy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.vgy);
      }
      i = paramInt;
      if (this.vgA != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.vgA);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.crz) + i.a.a.b.b.a.cJ(6, this.vhJ) + i.a.a.b.b.a.cJ(7, this.vhK);
      paramInt = i;
      if (this.vhM != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.vhM);
      }
      AppMethodBeat.o(22128);
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
      if (this.vgy == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22128);
        return -1;
      case 1: 
        localw.vhI = locala.ajGk.aar();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.vhk = locala.ajGk.aar();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.vgy = locala.ajGk.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.vgA = locala.ajGk.kFX();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.crz = locala.ajGk.aar();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.vhK = locala.ajGk.aar();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.vhM = locala.ajGk.kFX();
      AppMethodBeat.o(22128);
      return 0;
    }
    AppMethodBeat.o(22128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */