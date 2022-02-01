package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bw.b oTm;
  public int oUu;
  public int oUv;
  public int oUw;
  public int oUx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22127);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.oUu);
      if (this.ID != null) {
        paramVarArgs.e(2, this.ID);
      }
      if (this.oTm != null) {
        paramVarArgs.c(3, this.oTm);
      }
      paramVarArgs.aM(4, this.Version);
      paramVarArgs.aM(5, this.oUv);
      paramVarArgs.aM(6, this.oUw);
      paramVarArgs.aM(7, this.oUx);
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oUu) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ID);
      }
      i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.oTm);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Version);
      int j = g.a.a.b.b.a.bu(5, this.oUv);
      int k = g.a.a.b.b.a.bu(6, this.oUw);
      int m = g.a.a.b.b.a.bu(7, this.oUx);
      AppMethodBeat.o(22127);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.ID == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22127);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22127);
        return -1;
      case 1: 
        localv.oUu = locala.UbS.zi();
        AppMethodBeat.o(22127);
        return 0;
      case 2: 
        localv.ID = locala.UbS.readString();
        AppMethodBeat.o(22127);
        return 0;
      case 3: 
        localv.oTm = locala.UbS.hPo();
        AppMethodBeat.o(22127);
        return 0;
      case 4: 
        localv.Version = locala.UbS.zi();
        AppMethodBeat.o(22127);
        return 0;
      case 5: 
        localv.oUv = locala.UbS.zi();
        AppMethodBeat.o(22127);
        return 0;
      case 6: 
        localv.oUw = locala.UbS.zi();
        AppMethodBeat.o(22127);
        return 0;
      }
      localv.oUx = locala.UbS.zi();
      AppMethodBeat.o(22127);
      return 0;
    }
    AppMethodBeat.o(22127);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */