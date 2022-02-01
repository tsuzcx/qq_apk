package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String apkMd5;
  public int cSc;
  public String cSd;
  public int cSe;
  public String cSf;
  public String cSg;
  public boolean cSh;
  public int cSi;
  public boolean cSj;
  
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
      paramVarArgs.lD(2, this.cSc);
      if (this.cSd != null) {
        paramVarArgs.d(3, this.cSd);
      }
      paramVarArgs.lD(4, this.cSe);
      if (this.cSf != null) {
        paramVarArgs.d(5, this.cSf);
      }
      if (this.cSg != null) {
        paramVarArgs.d(6, this.cSg);
      }
      paramVarArgs.bt(7, this.cSh);
      paramVarArgs.lD(8, this.cSi);
      paramVarArgs.bt(9, this.cSj);
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
      int i = paramInt + f.a.a.a.lA(2, this.cSc);
      paramInt = i;
      if (this.cSd != null) {
        paramInt = i + f.a.a.a.e(3, this.cSd);
      }
      i = paramInt + f.a.a.a.lA(4, this.cSe);
      paramInt = i;
      if (this.cSf != null) {
        paramInt = i + f.a.a.a.e(5, this.cSf);
      }
      i = paramInt;
      if (this.cSg != null) {
        i = paramInt + f.a.a.a.e(6, this.cSg);
      }
      paramInt = f.a.a.a.alP(7);
      int j = f.a.a.a.lA(8, this.cSi);
      int k = f.a.a.a.alP(9);
      AppMethodBeat.o(944);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs);; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs))
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
            paramVarArgs.gxE();
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
          localb.apkMd5 = locala.gxB();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.cSc = locala.gxA();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.cSd = locala.gxB();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.cSe = locala.gxA();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.cSf = locala.gxB();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.cSg = locala.gxB();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.cSh = locala.gxC();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.cSi = locala.gxA();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.cSj = locala.gxC();
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