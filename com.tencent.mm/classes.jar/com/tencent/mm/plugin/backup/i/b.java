package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bx.a
{
  public int mAw;
  public com.tencent.mm.bx.b mAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22102);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mAw);
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      AppMethodBeat.o(22102);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mAw) + 0;
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.mAx);
      }
      AppMethodBeat.o(22102);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localb.mAw = locala.KhF.xS();
        AppMethodBeat.o(22102);
        return 0;
      }
      localb.mAx = locala.KhF.fMu();
      AppMethodBeat.o(22102);
      return 0;
    }
    AppMethodBeat.o(22102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.b
 * JD-Core Version:    0.7.0.1
 */