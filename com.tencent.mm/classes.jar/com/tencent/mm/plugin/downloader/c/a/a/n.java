package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int oGs;
  public boolean oGt;
  public long oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oGs);
      paramVarArgs.bl(2, this.oGt);
      paramVarArgs.aO(3, this.oGu);
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.oGs);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.p(3, this.oGu);
      AppMethodBeat.o(153056);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153056);
        return -1;
      case 1: 
        localn.oGs = locala.LVo.xF();
        AppMethodBeat.o(153056);
        return 0;
      case 2: 
        localn.oGt = locala.LVo.fZX();
        AppMethodBeat.o(153056);
        return 0;
      }
      localn.oGu = locala.LVo.xG();
      AppMethodBeat.o(153056);
      return 0;
    }
    AppMethodBeat.o(153056);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */