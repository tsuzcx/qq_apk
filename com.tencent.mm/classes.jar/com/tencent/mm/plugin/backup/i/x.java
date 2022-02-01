package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b mAx;
  public String mBL;
  public int mBM;
  public int mBN;
  public int mBO;
  public int mBP;
  public int mBQ;
  public int mBR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.mBL != null) {
        paramVarArgs.d(1, this.mBL);
      }
      paramVarArgs.aR(2, this.mBM);
      paramVarArgs.aR(3, this.mBN);
      paramVarArgs.aR(4, this.mBO);
      paramVarArgs.aR(5, this.mBP);
      paramVarArgs.aR(6, this.mBQ);
      if (this.mAx != null) {
        paramVarArgs.c(7, this.mAx);
      }
      paramVarArgs.aR(8, this.mBR);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBL == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.b.b.a.e(1, this.mBL) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBM) + f.a.a.b.b.a.bA(3, this.mBN) + f.a.a.b.b.a.bA(4, this.mBO) + f.a.a.b.b.a.bA(5, this.mBP) + f.a.a.b.b.a.bA(6, this.mBQ);
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.mAx);
      }
      i = f.a.a.b.b.a.bA(8, this.mBR);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.mBL = locala.KhF.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.mBM = locala.KhF.xS();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.mBN = locala.KhF.xS();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.mBO = locala.KhF.xS();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.mBP = locala.KhF.xS();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.mBQ = locala.KhF.xS();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.mAx = locala.KhF.fMu();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.mBR = locala.KhF.xS();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */