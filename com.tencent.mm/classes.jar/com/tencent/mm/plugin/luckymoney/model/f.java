package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public int gaV;
  public String vzR;
  public String vzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gaV);
      if (this.vzR != null) {
        paramVarArgs.d(2, this.vzR);
      }
      if (this.vzS != null) {
        paramVarArgs.d(3, this.vzS);
      }
      AppMethodBeat.o(91251);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.gaV) + 0;
      paramInt = i;
      if (this.vzR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vzR);
      }
      i = paramInt;
      if (this.vzS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vzS);
      }
      AppMethodBeat.o(91251);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localf.gaV = locala.OmT.zc();
        AppMethodBeat.o(91251);
        return 0;
      case 2: 
        localf.vzR = locala.OmT.readString();
        AppMethodBeat.o(91251);
        return 0;
      }
      localf.vzS = locala.OmT.readString();
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