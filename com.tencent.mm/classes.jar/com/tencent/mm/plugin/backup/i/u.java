package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public String fkx;
  public String mediaId;
  public int nEb;
  public int nEc;
  public long nEd;
  public String path;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEb);
      if (this.fkx != null) {
        paramVarArgs.d(2, this.fkx);
      }
      if (this.mediaId != null) {
        paramVarArgs.d(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.aS(5, this.type);
      paramVarArgs.aS(6, this.nEc);
      paramVarArgs.aY(7, this.nEd);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEb) + 0;
      paramInt = i;
      if (this.fkx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fkx);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.path);
      }
      i = f.a.a.b.b.a.bz(5, this.type);
      int j = f.a.a.b.b.a.bz(6, this.nEc);
      int k = f.a.a.b.b.a.p(7, this.nEd);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22126);
        return -1;
      case 1: 
        localu.nEb = locala.NPN.zc();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.fkx = locala.NPN.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.NPN.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.NPN.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.NPN.zc();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.nEc = locala.NPN.zc();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.nEd = locala.NPN.zd();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */