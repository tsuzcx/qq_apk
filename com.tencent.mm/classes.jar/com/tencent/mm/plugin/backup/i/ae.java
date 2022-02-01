package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b nIq;
  public String nJE;
  public int nJF;
  public int nJH;
  public int nJI;
  public int nJJ;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.nJE != null) {
        paramVarArgs.d(1, this.nJE);
      }
      paramVarArgs.aS(2, this.nJF);
      paramVarArgs.aS(3, this.nJH);
      paramVarArgs.aS(4, this.nJI);
      paramVarArgs.aS(5, this.nJb);
      paramVarArgs.aS(6, this.nJJ);
      if (this.nIq != null) {
        paramVarArgs.c(7, this.nIq);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJE == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.b.b.a.e(1, this.nJE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJF) + f.a.a.b.b.a.bz(3, this.nJH) + f.a.a.b.b.a.bz(4, this.nJI) + f.a.a.b.b.a.bz(5, this.nJb) + f.a.a.b.b.a.bz(6, this.nJJ);
      paramInt = i;
      if (this.nIq != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.nIq);
      }
      AppMethodBeat.o(22137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nJE == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.nJE = locala.OmT.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.nJF = locala.OmT.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.nJH = locala.OmT.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.nJI = locala.OmT.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.nJb = locala.OmT.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.nJJ = locala.OmT.zc();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.nIq = locala.OmT.gCk();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */