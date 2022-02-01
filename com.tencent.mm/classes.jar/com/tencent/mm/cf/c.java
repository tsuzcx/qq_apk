package com.tencent.mm.cf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public int GxT = -1;
  public int GxU;
  public int cUq;
  public int mHu;
  public int mHv;
  public int mHw;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mHu);
      paramVarArgs.aR(2, this.mHv);
      paramVarArgs.aR(3, this.mHw);
      paramVarArgs.aR(41, this.GxT);
      paramVarArgs.aR(5, this.GxU);
      paramVarArgs.aR(6, this.cUq);
      paramVarArgs.aR(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.mHu);
      int i = f.a.a.b.b.a.bx(2, this.mHv);
      int j = f.a.a.b.b.a.bx(3, this.mHw);
      int k = f.a.a.b.b.a.bx(41, this.GxT);
      int m = f.a.a.b.b.a.bx(5, this.GxU);
      int n = f.a.a.b.b.a.bx(6, this.cUq);
      int i1 = f.a.a.b.b.a.bx(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104918);
        return -1;
      case 1: 
        localc.mHu = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.mHv = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.mHw = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.GxT = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.GxU = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.cUq = locala.LVo.xF();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.LVo.xF();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cf.c
 * JD-Core Version:    0.7.0.1
 */