package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ab
  extends com.tencent.mm.bw.a
{
  public int ncx;
  public b ncy;
  public int ndX;
  public int ndY;
  public long ndZ;
  public long ndi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ncx);
      if (this.ncy != null) {
        paramVarArgs.c(2, this.ncy);
      }
      paramVarArgs.aR(3, this.ndX);
      paramVarArgs.aR(4, this.ndY);
      paramVarArgs.aO(5, this.ndZ);
      paramVarArgs.aO(6, this.ndi);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ncx) + 0;
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.ncy);
      }
      i = f.a.a.b.b.a.bx(3, this.ndX);
      int j = f.a.a.b.b.a.bx(4, this.ndY);
      int k = f.a.a.b.b.a.p(5, this.ndZ);
      int m = f.a.a.b.b.a.p(6, this.ndi);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22134);
        return -1;
      case 1: 
        localab.ncx = locala.LVo.xF();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.ncy = locala.LVo.gfk();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.ndX = locala.LVo.xF();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.ndY = locala.LVo.xF();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.ndZ = locala.LVo.xG();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.ndi = locala.LVo.xG();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */