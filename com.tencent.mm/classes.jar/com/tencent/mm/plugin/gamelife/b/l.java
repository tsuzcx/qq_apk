package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
  extends com.tencent.mm.cd.a
{
  public int jump_type;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.f(2, this.jump_url);
      }
      AppMethodBeat.o(203955);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.jump_type) + 0;
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jump_url);
      }
      AppMethodBeat.o(203955);
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
      AppMethodBeat.o(203955);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203955);
        return -1;
      case 1: 
        locall.jump_type = locala.abFh.AK();
        AppMethodBeat.o(203955);
        return 0;
      }
      locall.jump_url = locala.abFh.readString();
      AppMethodBeat.o(203955);
      return 0;
    }
    AppMethodBeat.o(203955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.l
 * JD-Core Version:    0.7.0.1
 */