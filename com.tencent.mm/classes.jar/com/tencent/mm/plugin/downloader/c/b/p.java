package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.cd.a
{
  public String jump_url;
  public String mKO;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153076);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.mKO != null) {
        paramVarArgs.f(2, this.mKO);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(3, this.jump_url);
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.mKO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mKO);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jump_url);
      }
      AppMethodBeat.o(153076);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153076);
        return -1;
      case 1: 
        localp.type = locala.abFh.AK();
        AppMethodBeat.o(153076);
        return 0;
      case 2: 
        localp.mKO = locala.abFh.readString();
        AppMethodBeat.o(153076);
        return 0;
      }
      localp.jump_url = locala.abFh.readString();
      AppMethodBeat.o(153076);
      return 0;
    }
    AppMethodBeat.o(153076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.p
 * JD-Core Version:    0.7.0.1
 */