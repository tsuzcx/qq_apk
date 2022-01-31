package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bv.a
{
  public String cBO;
  public String dGY;
  public int jKo;
  public int jKp;
  public long jKq;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18069);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKo);
      if (this.dGY != null) {
        paramVarArgs.e(2, this.dGY);
      }
      if (this.cBO != null) {
        paramVarArgs.e(3, this.cBO);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      paramVarArgs.aO(5, this.type);
      paramVarArgs.aO(6, this.jKp);
      paramVarArgs.am(7, this.jKq);
      AppMethodBeat.o(18069);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jKo) + 0;
      paramInt = i;
      if (this.dGY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.dGY);
      }
      i = paramInt;
      if (this.cBO != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cBO);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.path);
      }
      i = e.a.a.b.b.a.bl(5, this.type);
      int j = e.a.a.b.b.a.bl(6, this.jKp);
      int k = e.a.a.b.b.a.p(7, this.jKq);
      AppMethodBeat.o(18069);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18069);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18069);
        return -1;
      case 1: 
        localu.jKo = locala.CLY.sl();
        AppMethodBeat.o(18069);
        return 0;
      case 2: 
        localu.dGY = locala.CLY.readString();
        AppMethodBeat.o(18069);
        return 0;
      case 3: 
        localu.cBO = locala.CLY.readString();
        AppMethodBeat.o(18069);
        return 0;
      case 4: 
        localu.path = locala.CLY.readString();
        AppMethodBeat.o(18069);
        return 0;
      case 5: 
        localu.type = locala.CLY.sl();
        AppMethodBeat.o(18069);
        return 0;
      case 6: 
        localu.jKp = locala.CLY.sl();
        AppMethodBeat.o(18069);
        return 0;
      }
      localu.jKq = locala.CLY.sm();
      AppMethodBeat.o(18069);
      return 0;
    }
    AppMethodBeat.o(18069);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */