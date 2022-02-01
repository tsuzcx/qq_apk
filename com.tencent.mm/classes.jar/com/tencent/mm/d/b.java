package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public String apkMd5;
  public int cGY;
  public String cGZ;
  public int cHa;
  public String cHb;
  public String cHc;
  public boolean cHd;
  public int cHe;
  public boolean cHf;
  
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
      paramVarArgs.lo(2, this.cGY);
      if (this.cGZ != null) {
        paramVarArgs.d(3, this.cGZ);
      }
      paramVarArgs.lo(4, this.cHa);
      if (this.cHb != null) {
        paramVarArgs.d(5, this.cHb);
      }
      if (this.cHc != null) {
        paramVarArgs.d(6, this.cHc);
      }
      paramVarArgs.bl(7, this.cHd);
      paramVarArgs.lo(8, this.cHe);
      paramVarArgs.bl(9, this.cHf);
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
      int i = paramInt + f.a.a.a.ll(2, this.cGY);
      paramInt = i;
      if (this.cGZ != null) {
        paramInt = i + f.a.a.a.e(3, this.cGZ);
      }
      i = paramInt + f.a.a.a.ll(4, this.cHa);
      paramInt = i;
      if (this.cHb != null) {
        paramInt = i + f.a.a.a.e(5, this.cHb);
      }
      i = paramInt;
      if (this.cHc != null) {
        i = paramInt + f.a.a.a.e(6, this.cHc);
      }
      paramInt = f.a.a.a.aji(7);
      int j = f.a.a.a.ll(8, this.cHe);
      int k = f.a.a.a.aji(9);
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
            paramVarArgs.gfg();
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
          localb.apkMd5 = locala.gfd();
          AppMethodBeat.o(944);
          return 0;
        case 2: 
          localb.cGY = locala.gfc();
          AppMethodBeat.o(944);
          return 0;
        case 3: 
          localb.cGZ = locala.gfd();
          AppMethodBeat.o(944);
          return 0;
        case 4: 
          localb.cHa = locala.gfc();
          AppMethodBeat.o(944);
          return 0;
        case 5: 
          localb.cHb = locala.gfd();
          AppMethodBeat.o(944);
          return 0;
        case 6: 
          localb.cHc = locala.gfd();
          AppMethodBeat.o(944);
          return 0;
        case 7: 
          localb.cHd = locala.gfe();
          AppMethodBeat.o(944);
          return 0;
        case 8: 
          localb.cHe = locala.gfc();
          AppMethodBeat.o(944);
          return 0;
        }
        localb.cHf = locala.gfe();
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