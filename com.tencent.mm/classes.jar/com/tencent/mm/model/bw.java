package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bw
  extends com.tencent.mm.bx.a
{
  public String gPh;
  public long glk;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.key);
      if (this.gPh != null) {
        paramVarArgs.d(2, this.gPh);
      }
      paramVarArgs.aG(3, this.glk);
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.key) + 0;
      paramInt = i;
      if (this.gPh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gPh);
      }
      i = f.a.a.b.b.a.q(3, this.glk);
      AppMethodBeat.o(143730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bw localbw = (bw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143730);
        return -1;
      case 1: 
        localbw.key = locala.KhF.xS();
        AppMethodBeat.o(143730);
        return 0;
      case 2: 
        localbw.gPh = locala.KhF.readString();
        AppMethodBeat.o(143730);
        return 0;
      }
      localbw.glk = locala.KhF.xT();
      AppMethodBeat.o(143730);
      return 0;
    }
    AppMethodBeat.o(143730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */