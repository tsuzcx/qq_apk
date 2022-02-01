package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b nIq;
  public String nJE;
  public int nJF;
  public int nJG;
  public int nJH;
  public int nJI;
  public int nJJ;
  public int nJK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nJE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.nJE != null) {
        paramVarArgs.d(1, this.nJE);
      }
      paramVarArgs.aS(2, this.nJF);
      paramVarArgs.aS(3, this.nJG);
      paramVarArgs.aS(4, this.nJH);
      paramVarArgs.aS(5, this.nJI);
      paramVarArgs.aS(6, this.nJJ);
      if (this.nIq != null) {
        paramVarArgs.c(7, this.nIq);
      }
      paramVarArgs.aS(8, this.nJK);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nJE == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.b.b.a.e(1, this.nJE) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJF) + f.a.a.b.b.a.bz(3, this.nJG) + f.a.a.b.b.a.bz(4, this.nJH) + f.a.a.b.b.a.bz(5, this.nJI) + f.a.a.b.b.a.bz(6, this.nJJ);
      paramInt = i;
      if (this.nIq != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.nIq);
      }
      i = f.a.a.b.b.a.bz(8, this.nJK);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.nJE = locala.OmT.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.nJF = locala.OmT.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.nJG = locala.OmT.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.nJH = locala.OmT.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.nJI = locala.OmT.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.nJJ = locala.OmT.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.nIq = locala.OmT.gCk();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.nJK = locala.OmT.zc();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */