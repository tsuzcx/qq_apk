package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public String fileName;
  public int hQa;
  public int hQb;
  public int hQc;
  public int maxSize;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileName != null) {
        paramVarArgs.d(1, this.fileName);
      }
      paramVarArgs.aR(2, this.hQa);
      paramVarArgs.aR(3, this.hQb);
      paramVarArgs.aR(4, this.hQc);
      paramVarArgs.aR(5, this.maxSize);
      AppMethodBeat.o(150830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileName == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.fileName) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.hQa);
      int j = f.a.a.b.b.a.bx(3, this.hQb);
      int k = f.a.a.b.b.a.bx(4, this.hQc);
      int m = f.a.a.b.b.a.bx(5, this.maxSize);
      AppMethodBeat.o(150830);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(150830);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150830);
          return -1;
        case 1: 
          localm.fileName = locala.LVo.readString();
          AppMethodBeat.o(150830);
          return 0;
        case 2: 
          localm.hQa = locala.LVo.xF();
          AppMethodBeat.o(150830);
          return 0;
        case 3: 
          localm.hQb = locala.LVo.xF();
          AppMethodBeat.o(150830);
          return 0;
        case 4: 
          localm.hQc = locala.LVo.xF();
          AppMethodBeat.o(150830);
          return 0;
        }
        localm.maxSize = locala.LVo.xF();
        AppMethodBeat.o(150830);
        return 0;
      }
      AppMethodBeat.o(150830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.m
 * JD-Core Version:    0.7.0.1
 */