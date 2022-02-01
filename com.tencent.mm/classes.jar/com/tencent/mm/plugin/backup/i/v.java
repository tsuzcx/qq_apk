package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.cd.a
{
  public String ID;
  public com.tencent.mm.cd.b rVk;
  public int rWs;
  public int rWt;
  public int rWu;
  public int rWv;
  public int rWw;
  
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
      paramVarArgs.aY(1, this.rWs);
      if (this.ID != null) {
        paramVarArgs.f(2, this.ID);
      }
      if (this.rVk != null) {
        paramVarArgs.c(3, this.rVk);
      }
      paramVarArgs.aY(4, this.rWt);
      paramVarArgs.aY(5, this.rWu);
      paramVarArgs.aY(6, this.rWv);
      paramVarArgs.aY(7, this.rWw);
      AppMethodBeat.o(22127);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWs) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ID);
      }
      i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.rVk);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.rWt);
      int j = g.a.a.b.b.a.bM(5, this.rWu);
      int k = g.a.a.b.b.a.bM(6, this.rWv);
      int m = g.a.a.b.b.a.bM(7, this.rWw);
      AppMethodBeat.o(22127);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        localv.rWs = locala.abFh.AK();
        AppMethodBeat.o(22127);
        return 0;
      case 2: 
        localv.ID = locala.abFh.readString();
        AppMethodBeat.o(22127);
        return 0;
      case 3: 
        localv.rVk = locala.abFh.iUw();
        AppMethodBeat.o(22127);
        return 0;
      case 4: 
        localv.rWt = locala.abFh.AK();
        AppMethodBeat.o(22127);
        return 0;
      case 5: 
        localv.rWu = locala.abFh.AK();
        AppMethodBeat.o(22127);
        return 0;
      case 6: 
        localv.rWv = locala.abFh.AK();
        AppMethodBeat.o(22127);
        return 0;
      }
      localv.rWw = locala.abFh.AK();
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