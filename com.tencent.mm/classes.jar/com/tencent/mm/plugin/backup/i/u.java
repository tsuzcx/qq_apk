package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.cd.a
{
  public String ilo;
  public String mediaId;
  public String path;
  public int rWp;
  public int rWq;
  public long rWr;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWp);
      if (this.ilo != null) {
        paramVarArgs.f(2, this.ilo);
      }
      if (this.mediaId != null) {
        paramVarArgs.f(3, this.mediaId);
      }
      if (this.path != null) {
        paramVarArgs.f(4, this.path);
      }
      paramVarArgs.aY(5, this.type);
      paramVarArgs.aY(6, this.rWq);
      paramVarArgs.bm(7, this.rWr);
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWp) + 0;
      paramInt = i;
      if (this.ilo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ilo);
      }
      i = paramInt;
      if (this.mediaId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.mediaId);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.path);
      }
      i = g.a.a.b.b.a.bM(5, this.type);
      int j = g.a.a.b.b.a.bM(6, this.rWq);
      int k = g.a.a.b.b.a.p(7, this.rWr);
      AppMethodBeat.o(22126);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(22126);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22126);
        return -1;
      case 1: 
        localu.rWp = locala.abFh.AK();
        AppMethodBeat.o(22126);
        return 0;
      case 2: 
        localu.ilo = locala.abFh.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 3: 
        localu.mediaId = locala.abFh.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 4: 
        localu.path = locala.abFh.readString();
        AppMethodBeat.o(22126);
        return 0;
      case 5: 
        localu.type = locala.abFh.AK();
        AppMethodBeat.o(22126);
        return 0;
      case 6: 
        localu.rWq = locala.abFh.AK();
        AppMethodBeat.o(22126);
        return 0;
      }
      localu.rWr = locala.abFh.AN();
      AppMethodBeat.o(22126);
      return 0;
    }
    AppMethodBeat.o(22126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */