package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public String kLn;
  public String mediaId;
  public String path;
  public int type;
  public int vhF;
  public int vhG;
  public long vhH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhF);
      if (this.kLn != null) {
        paramVarArgs.g(2, this.kLn);
      }
      if (this.mediaId != null) {
        paramVarArgs.g(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.g(4, this.path);
      }
      paramVarArgs.bS(5, this.type);
      paramVarArgs.bS(6, this.vhG);
      paramVarArgs.bv(7, this.vhH);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.vhF) + 0;
      paramInt = i;
      if (this.kLn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.kLn);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.path);
      }
      i = i.a.a.b.b.a.cJ(5, this.type);
      int j = i.a.a.b.b.a.cJ(6, this.vhG);
      int k = i.a.a.b.b.a.q(7, this.vhH);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22126);
        return -1;
      case 1: 
        localu.vhF = locala.ajGk.aar();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.kLn = locala.ajGk.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.ajGk.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.ajGk.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.ajGk.aar();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.vhG = locala.ajGk.aar();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.vhH = locala.ajGk.aaw();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */