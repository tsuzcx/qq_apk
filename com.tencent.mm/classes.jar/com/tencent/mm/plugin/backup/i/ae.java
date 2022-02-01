package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b mAx;
  public String mBL;
  public int mBM;
  public int mBO;
  public int mBP;
  public int mBQ;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.mBL != null) {
        paramVarArgs.d(1, this.mBL);
      }
      paramVarArgs.aR(2, this.mBM);
      paramVarArgs.aR(3, this.mBO);
      paramVarArgs.aR(4, this.mBP);
      paramVarArgs.aR(5, this.mBi);
      paramVarArgs.aR(6, this.mBQ);
      if (this.mAx != null) {
        paramVarArgs.c(7, this.mAx);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBL == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.b.b.a.e(1, this.mBL) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBM) + f.a.a.b.b.a.bA(3, this.mBO) + f.a.a.b.b.a.bA(4, this.mBP) + f.a.a.b.b.a.bA(5, this.mBi) + f.a.a.b.b.a.bA(6, this.mBQ);
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.mAx);
      }
      AppMethodBeat.o(22137);
      return paramInt;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.mBL = locala.KhF.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.mBM = locala.KhF.xS();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.mBO = locala.KhF.xS();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.mBP = locala.KhF.xS();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.mBi = locala.KhF.xS();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.mBQ = locala.KhF.xS();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.mAx = locala.KhF.fMu();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */