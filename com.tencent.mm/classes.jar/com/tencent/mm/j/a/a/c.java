package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public long fBY;
  public long fBZ;
  public long fCa;
  public long fCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.fBY);
      paramVarArgs.aO(2, this.fBZ);
      paramVarArgs.aO(3, this.fCa);
      paramVarArgs.aO(4, this.fCb);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.fBY);
      int i = f.a.a.b.b.a.p(2, this.fBZ);
      int j = f.a.a.b.b.a.p(3, this.fCa);
      int k = f.a.a.b.b.a.p(4, this.fCb);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(42663);
        return -1;
      case 1: 
        localc.fBY = locala.LVo.xG();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.fBZ = locala.LVo.xG();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.fCa = locala.LVo.xG();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.fCb = locala.LVo.xG();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.j.a.a.c
 * JD-Core Version:    0.7.0.1
 */