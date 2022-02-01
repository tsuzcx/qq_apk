package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.cd.a
{
  public String ID;
  public int rVU;
  public com.tencent.mm.cd.b rVk;
  public int rWs;
  public int rWt;
  public int rWu;
  public int rWv;
  public com.tencent.mm.cd.b rWx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.rWs);
      paramVarArgs.aY(2, this.rVU);
      if (this.ID != null) {
        paramVarArgs.f(3, this.ID);
      }
      if (this.rVk != null) {
        paramVarArgs.c(4, this.rVk);
      }
      paramVarArgs.aY(5, this.rWt);
      paramVarArgs.aY(6, this.rWu);
      paramVarArgs.aY(7, this.rWv);
      if (this.rWx != null) {
        paramVarArgs.c(8, this.rWx);
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWs) + 0 + g.a.a.b.b.a.bM(2, this.rVU);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ID);
      }
      i = paramInt;
      if (this.rVk != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.rVk);
      }
      i = i + g.a.a.b.b.a.bM(5, this.rWt) + g.a.a.b.b.a.bM(6, this.rWu) + g.a.a.b.b.a.bM(7, this.rWv);
      paramInt = i;
      if (this.rWx != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.rWx);
      }
      AppMethodBeat.o(22128);
      return paramInt;
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
        AppMethodBeat.o(22128);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22128);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22128);
        return -1;
      case 1: 
        localw.rWs = locala.abFh.AK();
        AppMethodBeat.o(22128);
        return 0;
      case 2: 
        localw.rVU = locala.abFh.AK();
        AppMethodBeat.o(22128);
        return 0;
      case 3: 
        localw.ID = locala.abFh.readString();
        AppMethodBeat.o(22128);
        return 0;
      case 4: 
        localw.rVk = locala.abFh.iUw();
        AppMethodBeat.o(22128);
        return 0;
      case 5: 
        localw.rWt = locala.abFh.AK();
        AppMethodBeat.o(22128);
        return 0;
      case 6: 
        localw.rWu = locala.abFh.AK();
        AppMethodBeat.o(22128);
        return 0;
      case 7: 
        localw.rWv = locala.abFh.AK();
        AppMethodBeat.o(22128);
        return 0;
      }
      localw.rWx = locala.abFh.iUw();
      AppMethodBeat.o(22128);
      return 0;
    }
    AppMethodBeat.o(22128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */