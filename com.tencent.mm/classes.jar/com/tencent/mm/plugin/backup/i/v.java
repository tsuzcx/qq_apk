package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bw.b nIq;
  public int nJA;
  public int nJB;
  public int nJC;
  public int nJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nJz);
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.nIq != null) {
        paramVarArgs.c(3, this.nIq);
      }
      paramVarArgs.aS(4, this.Version);
      paramVarArgs.aS(5, this.nJA);
      paramVarArgs.aS(6, this.nJB);
      paramVarArgs.aS(7, this.nJC);
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJz) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.nIq != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.nIq);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Version);
      int j = f.a.a.b.b.a.bz(5, this.nJA);
      int k = f.a.a.b.b.a.bz(6, this.nJB);
      int m = f.a.a.b.b.a.bz(7, this.nJC);
      AppMethodBeat.o(22127);
      return i + paramInt + j + k + m;
    }
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
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22127);
        return -1;
      case 1: 
        localv.nJz = locala.OmT.zc();
        AppMethodBeat.o(22127);
        return 0;
      case 2: 
        localv.ID = locala.OmT.readString();
        AppMethodBeat.o(22127);
        return 0;
      case 3: 
        localv.nIq = locala.OmT.gCk();
        AppMethodBeat.o(22127);
        return 0;
      case 4: 
        localv.Version = locala.OmT.zc();
        AppMethodBeat.o(22127);
        return 0;
      case 5: 
        localv.nJA = locala.OmT.zc();
        AppMethodBeat.o(22127);
        return 0;
      case 6: 
        localv.nJB = locala.OmT.zc();
        AppMethodBeat.o(22127);
        return 0;
      }
      localv.nJC = locala.OmT.zc();
      AppMethodBeat.o(22127);
      return 0;
    }
    AppMethodBeat.o(22127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */