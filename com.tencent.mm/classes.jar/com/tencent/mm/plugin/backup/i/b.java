package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int ncx;
  public com.tencent.mm.bw.b ncy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22102);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ncx);
      if (this.ncy != null) {
        paramVarArgs.c(2, this.ncy);
      }
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ncx) + 0;
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.ncy);
      }
      AppMethodBeat.o(22102);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22102);
        return -1;
      case 1: 
        localb.ncx = locala.LVo.xF();
        AppMethodBeat.o(22102);
        return 0;
      }
      localb.ncy = locala.LVo.gfk();
      AppMethodBeat.o(22102);
      return 0;
    }
    AppMethodBeat.o(22102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.b
 * JD-Core Version:    0.7.0.1
 */