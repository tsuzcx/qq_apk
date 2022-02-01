package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long ndi;
  public int ndl;
  public int ndm;
  public int ndn;
  public long ndo;
  public long ndp;
  
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
      paramVarArgs.aR(2, this.ndl);
      paramVarArgs.aR(3, this.ndm);
      paramVarArgs.aR(4, this.ndn);
      paramVarArgs.aO(5, this.ndi);
      paramVarArgs.aO(6, this.ndo);
      paramVarArgs.aO(7, this.ndp);
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
      int i = f.a.a.b.b.a.bx(2, this.ndl);
      int j = f.a.a.b.b.a.bx(3, this.ndm);
      int k = f.a.a.b.b.a.bx(4, this.ndn);
      int m = f.a.a.b.b.a.p(5, this.ndi);
      int n = f.a.a.b.b.a.p(6, this.ndo);
      int i1 = f.a.a.b.b.a.p(7, this.ndp);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localp.ID = locala.LVo.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.ndl = locala.LVo.xF();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.ndm = locala.LVo.xF();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.ndn = locala.LVo.xF();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.ndi = locala.LVo.xG();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.ndo = locala.LVo.xG();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.ndp = locala.LVo.xG();
        AppMethodBeat.o(22120);
        return 0;
      }
      AppMethodBeat.o(22120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */