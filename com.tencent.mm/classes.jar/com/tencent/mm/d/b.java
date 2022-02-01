package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String apkMd5;
  public int cSM;
  public String cSN;
  public int cSO;
  public String cSP;
  public String cSQ;
  public boolean cSR;
  public int cSS;
  public boolean cST;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(944);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: apkMd5");
        AppMethodBeat.o(944);
        throw paramVarArgs;
      }
      if (this.apkMd5 != null) {
        paramVarArgs.d(1, this.apkMd5);
      }
      paramVarArgs.lK(2, this.cSM);
      if (this.cSN != null) {
        paramVarArgs.d(3, this.cSN);
      }
      paramVarArgs.lK(4, this.cSO);
      if (this.cSP != null) {
        paramVarArgs.d(5, this.cSP);
      }
      if (this.cSQ != null) {
        paramVarArgs.d(6, this.cSQ);
      }
      paramVarArgs.bC(7, this.cSR);
      paramVarArgs.lK(8, this.cSS);
      paramVarArgs.bC(9, this.cST);
      AppMethodBeat.o(944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.a.e(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.lH(2, this.cSM);
      paramInt = i;
      if (this.cSN != null) {
        paramInt = i + f.a.a.a.e(3, this.cSN);
      }
      i = paramInt + f.a.a.a.lH(4, this.cSO);
      paramInt = i;
      if (this.cSP != null) {
        paramInt = i + f.a.a.a.e(5, this.cSP);
      }
      i = paramInt;
      if (this.cSQ != null) {
        i = paramInt + f.a.a.a.e(6, this.cSQ);
      }
      paramInt = f.a.a.a.amz(7);
      int j = f.a.a.a.lH(8, this.cSS);
      int k = f.a.a.a.amz(9);
      AppMethodBeat.o(944);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs);; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            paramVarArgs = new f.a.a.b("Not all required fields were included: apkMd5");
            AppMethodBeat.o(944);
            throw paramVarArgs;
          }
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(944);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(944);
          return -1;
        case 1: 
          localb.apkMd5 = locala.gCd();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.cSM = locala.gCc();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.cSN = locala.gCd();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.cSO = locala.gCc();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.cSP = locala.gCd();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.cSQ = locala.gCd();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.cSR = locala.gCe();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.cSS = locala.gCc();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.cST = locala.gCe();
        AppMethodBeat.o(944);
        return 0;
      }
      AppMethodBeat.o(944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.b
 * JD-Core Version:    0.7.0.1
 */