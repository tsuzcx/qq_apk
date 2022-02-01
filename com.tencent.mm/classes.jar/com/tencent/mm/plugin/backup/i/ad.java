package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ad
  extends com.tencent.mm.bx.a
{
  public String mBL;
  public int mBM;
  public int mBO;
  public int mBP;
  public int mBR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBL == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.mBL != null) {
        paramVarArgs.d(1, this.mBL);
      }
      paramVarArgs.aR(2, this.mBM);
      paramVarArgs.aR(3, this.mBO);
      paramVarArgs.aR(4, this.mBP);
      paramVarArgs.aR(5, this.mBR);
      AppMethodBeat.o(22136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBL == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.mBL) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mBM);
      int j = f.a.a.b.b.a.bA(3, this.mBO);
      int k = f.a.a.b.b.a.bA(4, this.mBP);
      int m = f.a.a.b.b.a.bA(5, this.mBR);
      AppMethodBeat.o(22136);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mBL == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(22136);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22136);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22136);
          return -1;
        case 1: 
          localad.mBL = locala.KhF.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.mBM = locala.KhF.xS();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.mBO = locala.KhF.xS();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.mBP = locala.KhF.xS();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.mBR = locala.KhF.xS();
        AppMethodBeat.o(22136);
        return 0;
      }
      AppMethodBeat.o(22136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */