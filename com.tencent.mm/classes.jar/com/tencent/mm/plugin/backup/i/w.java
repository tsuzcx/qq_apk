package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bw.b nIq;
  public int nJA;
  public int nJB;
  public com.tencent.mm.bw.b nJD;
  public int nJb;
  public int nJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22128);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nJz);
      paramVarArgs.aS(2, this.nJb);
      if (this.ID != null) {
        paramVarArgs.d(3, this.ID);
      }
      if (this.nIq != null) {
        paramVarArgs.c(4, this.nIq);
      }
      paramVarArgs.aS(5, this.Version);
      paramVarArgs.aS(6, this.nJA);
      paramVarArgs.aS(7, this.nJB);
      if (this.nJD != null) {
        paramVarArgs.c(8, this.nJD);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nJz) + 0 + f.a.a.b.b.a.bz(2, this.nJb);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ID);
      }
      i = paramInt;
      if (this.nIq != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.nIq);
      }
      i = i + f.a.a.b.b.a.bz(5, this.Version) + f.a.a.b.b.a.bz(6, this.nJA) + f.a.a.b.b.a.bz(7, this.nJB);
      paramInt = i;
      if (this.nJD != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.nJD);
      }
      AppMethodBeat.o(22128);
      return paramInt;
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
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22128);
        return -1;
      case 1: 
        localw.nJz = locala.OmT.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.nJb = locala.OmT.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.OmT.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.nIq = locala.OmT.gCk();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.Version = locala.OmT.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.nJA = locala.OmT.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.nJB = locala.OmT.zc();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.nJD = locala.OmT.gCk();
      AppMethodBeat.o(22128);
      return 0;
    }
    AppMethodBeat.o(22128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */