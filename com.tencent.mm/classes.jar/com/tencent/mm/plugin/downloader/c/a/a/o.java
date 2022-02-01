package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public int limit;
  public long oGu;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153057);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.offset);
      paramVarArgs.aR(2, this.limit);
      paramVarArgs.aO(3, this.oGu);
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.offset);
      int i = f.a.a.b.b.a.bx(2, this.limit);
      int j = f.a.a.b.b.a.p(3, this.oGu);
      AppMethodBeat.o(153057);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153057);
        return -1;
      case 1: 
        localo.offset = locala.LVo.xF();
        AppMethodBeat.o(153057);
        return 0;
      case 2: 
        localo.limit = locala.LVo.xF();
        AppMethodBeat.o(153057);
        return 0;
      }
      localo.oGu = locala.LVo.xG();
      AppMethodBeat.o(153057);
      return 0;
    }
    AppMethodBeat.o(153057);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.o
 * JD-Core Version:    0.7.0.1
 */