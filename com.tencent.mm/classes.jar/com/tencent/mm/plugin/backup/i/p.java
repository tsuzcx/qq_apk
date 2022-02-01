package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long nJa;
  public int nJd;
  public int nJe;
  public int nJf;
  public long nJg;
  public long nJh;
  
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
      paramVarArgs.aS(2, this.nJd);
      paramVarArgs.aS(3, this.nJe);
      paramVarArgs.aS(4, this.nJf);
      paramVarArgs.aZ(5, this.nJa);
      paramVarArgs.aZ(6, this.nJg);
      paramVarArgs.aZ(7, this.nJh);
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
      int i = f.a.a.b.b.a.bz(2, this.nJd);
      int j = f.a.a.b.b.a.bz(3, this.nJe);
      int k = f.a.a.b.b.a.bz(4, this.nJf);
      int m = f.a.a.b.b.a.p(5, this.nJa);
      int n = f.a.a.b.b.a.p(6, this.nJg);
      int i1 = f.a.a.b.b.a.p(7, this.nJh);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localp.ID = locala.OmT.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.nJd = locala.OmT.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.nJe = locala.OmT.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.nJf = locala.OmT.zc();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.nJa = locala.OmT.zd();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.nJg = locala.OmT.zd();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.nJh = locala.OmT.zd();
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