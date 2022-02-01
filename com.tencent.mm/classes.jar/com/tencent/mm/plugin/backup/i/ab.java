package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ab
  extends com.tencent.mm.bx.a
{
  public int mAw;
  public b mAx;
  public int mBW;
  public int mBX;
  public long mBY;
  public long mBh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mAw);
      if (this.mAx != null) {
        paramVarArgs.c(2, this.mAx);
      }
      paramVarArgs.aR(3, this.mBW);
      paramVarArgs.aR(4, this.mBX);
      paramVarArgs.aG(5, this.mBY);
      paramVarArgs.aG(6, this.mBh);
      AppMethodBeat.o(22134);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mAw) + 0;
      paramInt = i;
      if (this.mAx != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.mAx);
      }
      i = f.a.a.b.b.a.bA(3, this.mBW);
      int j = f.a.a.b.b.a.bA(4, this.mBX);
      int k = f.a.a.b.b.a.q(5, this.mBY);
      int m = f.a.a.b.b.a.q(6, this.mBh);
      AppMethodBeat.o(22134);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localab.mAw = locala.KhF.xS();
        AppMethodBeat.o(22134);
        return 0;
      case 2: 
        localab.mAx = locala.KhF.fMu();
        AppMethodBeat.o(22134);
        return 0;
      case 3: 
        localab.mBW = locala.KhF.xS();
        AppMethodBeat.o(22134);
        return 0;
      case 4: 
        localab.mBX = locala.KhF.xS();
        AppMethodBeat.o(22134);
        return 0;
      case 5: 
        localab.mBY = locala.KhF.xT();
        AppMethodBeat.o(22134);
        return 0;
      }
      localab.mBh = locala.KhF.xT();
      AppMethodBeat.o(22134);
      return 0;
    }
    AppMethodBeat.o(22134);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ab
 * JD-Core Version:    0.7.0.1
 */