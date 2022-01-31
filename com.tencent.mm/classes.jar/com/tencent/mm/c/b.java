package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bv.a
{
  public String apkMd5;
  public int bWA;
  public boolean bWB;
  public int bWu;
  public String bWv;
  public int bWw;
  public String bWx;
  public String bWy;
  public boolean bWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125684);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: apkMd5");
        AppMethodBeat.o(125684);
        throw paramVarArgs;
      }
      if (this.apkMd5 != null) {
        paramVarArgs.e(1, this.apkMd5);
      }
      paramVarArgs.iR(2, this.bWu);
      if (this.bWv != null) {
        paramVarArgs.e(3, this.bWv);
      }
      paramVarArgs.iR(4, this.bWw);
      if (this.bWx != null) {
        paramVarArgs.e(5, this.bWx);
      }
      if (this.bWy != null) {
        paramVarArgs.e(6, this.bWy);
      }
      paramVarArgs.aS(7, this.bWz);
      paramVarArgs.iR(8, this.bWA);
      paramVarArgs.aS(9, this.bWB);
      AppMethodBeat.o(125684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label635;
      }
    }
    label635:
    for (paramInt = e.a.a.a.f(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.iO(2, this.bWu);
      paramInt = i;
      if (this.bWv != null) {
        paramInt = i + e.a.a.a.f(3, this.bWv);
      }
      i = paramInt + e.a.a.a.iO(4, this.bWw);
      paramInt = i;
      if (this.bWx != null) {
        paramInt = i + e.a.a.a.f(5, this.bWx);
      }
      i = paramInt;
      if (this.bWy != null) {
        i = paramInt + e.a.a.a.f(6, this.bWy);
      }
      paramInt = e.a.a.a.Wo(7);
      int j = e.a.a.a.iO(8, this.bWA);
      int k = e.a.a.a.Wo(9);
      AppMethodBeat.o(125684);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs);; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            paramVarArgs = new e.a.a.b("Not all required fields were included: apkMd5");
            AppMethodBeat.o(125684);
            throw paramVarArgs;
          }
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(125684);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125684);
          return -1;
        case 1: 
          localb.apkMd5 = locala.eqO();
          AppMethodBeat.o(125684);
          return 0;
        case 2: 
          localb.bWu = locala.eqN();
          AppMethodBeat.o(125684);
          return 0;
        case 3: 
          localb.bWv = locala.eqO();
          AppMethodBeat.o(125684);
          return 0;
        case 4: 
          localb.bWw = locala.eqN();
          AppMethodBeat.o(125684);
          return 0;
        case 5: 
          localb.bWx = locala.eqO();
          AppMethodBeat.o(125684);
          return 0;
        case 6: 
          localb.bWy = locala.eqO();
          AppMethodBeat.o(125684);
          return 0;
        case 7: 
          localb.bWz = locala.eqP();
          AppMethodBeat.o(125684);
          return 0;
        case 8: 
          localb.bWA = locala.eqN();
          AppMethodBeat.o(125684);
          return 0;
        }
        localb.bWB = locala.eqP();
        AppMethodBeat.o(125684);
        return 0;
      }
      AppMethodBeat.o(125684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.c.b
 * JD-Core Version:    0.7.0.1
 */