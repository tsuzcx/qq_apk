package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long nDF;
  public int nDI;
  public int nDJ;
  public int nDK;
  public long nDL;
  public long nDM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22120);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.aS(2, this.nDI);
      paramVarArgs.aS(3, this.nDJ);
      paramVarArgs.aS(4, this.nDK);
      paramVarArgs.aY(5, this.nDF);
      paramVarArgs.aY(6, this.nDL);
      paramVarArgs.aY(7, this.nDM);
      AppMethodBeat.o(22120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nDI);
      int j = f.a.a.b.b.a.bz(3, this.nDJ);
      int k = f.a.a.b.b.a.bz(4, this.nDK);
      int m = f.a.a.b.b.a.p(5, this.nDF);
      int n = f.a.a.b.b.a.p(6, this.nDL);
      int i1 = f.a.a.b.b.a.p(7, this.nDM);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22120);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22120);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22120);
          return -1;
        case 1: 
          localp.ID = locala.NPN.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.nDI = locala.NPN.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.nDJ = locala.NPN.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.nDK = locala.NPN.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.nDF = locala.NPN.zd();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.nDL = locala.NPN.zd();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.nDM = locala.NPN.zd();
        AppMethodBeat.o(22120);
        return 0;
      }
      AppMethodBeat.o(22120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */