package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public int fYO;
  public String vnM;
  public String vnN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.fYO);
      if (this.vnM != null) {
        paramVarArgs.d(2, this.vnM);
      }
      if (this.vnN != null) {
        paramVarArgs.d(3, this.vnN);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.fYO) + 0;
      paramInt = i;
      if (this.vnM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vnM);
      }
      i = paramInt;
      if (this.vnN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vnN);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91251);
        return -1;
      case 1: 
        localf.fYO = locala.NPN.zc();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        localf.vnM = locala.NPN.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      localf.vnN = locala.NPN.readString();
      AppMethodBeat.o(91251);
      return 0;
    }
    AppMethodBeat.o(91251);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.f
 * JD-Core Version:    0.7.0.1
 */