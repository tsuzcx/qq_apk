package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bx.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bx.b nCV;
  public int nDG;
  public int nEe;
  public int nEf;
  public int nEg;
  public com.tencent.mm.bx.b nEi;
  
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
      paramVarArgs.aS(1, this.nEe);
      paramVarArgs.aS(2, this.nDG);
      if (this.ID != null) {
        paramVarArgs.d(3, this.ID);
      }
      if (this.nCV != null) {
        paramVarArgs.c(4, this.nCV);
      }
      paramVarArgs.aS(5, this.Version);
      paramVarArgs.aS(6, this.nEf);
      paramVarArgs.aS(7, this.nEg);
      if (this.nEi != null) {
        paramVarArgs.c(8, this.nEi);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEe) + 0 + f.a.a.b.b.a.bz(2, this.nDG);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ID);
      }
      i = paramInt;
      if (this.nCV != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.nCV);
      }
      i = i + f.a.a.b.b.a.bz(5, this.Version) + f.a.a.b.b.a.bz(6, this.nEf) + f.a.a.b.b.a.bz(7, this.nEg);
      paramInt = i;
      if (this.nEi != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.nEi);
      }
      AppMethodBeat.o(22128);
      return paramInt;
    }
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
        localw.nEe = locala.NPN.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.nDG = locala.NPN.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.NPN.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.nCV = locala.NPN.gxI();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.Version = locala.NPN.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.nEf = locala.NPN.zc();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.nEg = locala.NPN.zc();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.nEi = locala.NPN.gxI();
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