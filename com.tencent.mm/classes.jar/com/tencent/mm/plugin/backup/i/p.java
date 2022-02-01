package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bx.a
{
  public String ID;
  public long mBh;
  public int mBk;
  public int mBl;
  public int mBm;
  public long mBn;
  public long mBo;
  
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
      paramVarArgs.aR(2, this.mBk);
      paramVarArgs.aR(3, this.mBl);
      paramVarArgs.aR(4, this.mBm);
      paramVarArgs.aG(5, this.mBh);
      paramVarArgs.aG(6, this.mBn);
      paramVarArgs.aG(7, this.mBo);
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
      int i = f.a.a.b.b.a.bA(2, this.mBk);
      int j = f.a.a.b.b.a.bA(3, this.mBl);
      int k = f.a.a.b.b.a.bA(4, this.mBm);
      int m = f.a.a.b.b.a.q(5, this.mBh);
      int n = f.a.a.b.b.a.q(6, this.mBn);
      int i1 = f.a.a.b.b.a.q(7, this.mBo);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
          localp.ID = locala.KhF.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.mBk = locala.KhF.xS();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.mBl = locala.KhF.xS();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.mBm = locala.KhF.xS();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.mBh = locala.KhF.xT();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.mBn = locala.KhF.xT();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.mBo = locala.KhF.xT();
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