package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public String apkMd5;
  public int cJR;
  public String cJS;
  public int cJT;
  public String cJU;
  public String cJV;
  public boolean cJW;
  public int cJX;
  public boolean cJY;
  
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
      paramVarArgs.kY(2, this.cJR);
      if (this.cJS != null) {
        paramVarArgs.d(3, this.cJS);
      }
      paramVarArgs.kY(4, this.cJT);
      if (this.cJU != null) {
        paramVarArgs.d(5, this.cJU);
      }
      if (this.cJV != null) {
        paramVarArgs.d(6, this.cJV);
      }
      paramVarArgs.bg(7, this.cJW);
      paramVarArgs.kY(8, this.cJX);
      paramVarArgs.bg(9, this.cJY);
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
      int i = paramInt + f.a.a.a.kV(2, this.cJR);
      paramInt = i;
      if (this.cJS != null) {
        paramInt = i + f.a.a.a.e(3, this.cJS);
      }
      i = paramInt + f.a.a.a.kV(4, this.cJT);
      paramInt = i;
      if (this.cJU != null) {
        paramInt = i + f.a.a.a.e(5, this.cJU);
      }
      i = paramInt;
      if (this.cJV != null) {
        i = paramInt + f.a.a.a.e(6, this.cJV);
      }
      paramInt = f.a.a.a.agm(7);
      int j = f.a.a.a.kV(8, this.cJX);
      int k = f.a.a.a.agm(9);
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
            paramVarArgs.fMq();
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
          localb.apkMd5 = locala.fMn();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.cJR = locala.fMm();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.cJS = locala.fMn();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.cJT = locala.fMm();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.cJU = locala.fMn();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.cJV = locala.fMn();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.cJW = locala.fMo();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.cJX = locala.fMm();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.cJY = locala.fMo();
        AppMethodBeat.o(944);
        return 0;
      }
      AppMethodBeat.o(944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.b
 * JD-Core Version:    0.7.0.1
 */