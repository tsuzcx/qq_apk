package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public int Height;
  public int Width;
  public int rNT;
  public String rNU;
  public String rNV;
  public boolean rNW;
  public int rNX;
  public long rNY;
  public int rNZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.rNT);
      if (this.rNU != null) {
        paramVarArgs.d(2, this.rNU);
      }
      if (this.rNV != null) {
        paramVarArgs.d(3, this.rNV);
      }
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      paramVarArgs.bg(6, this.rNW);
      paramVarArgs.aR(7, this.rNX);
      paramVarArgs.aG(8, this.rNY);
      paramVarArgs.aR(9, this.rNZ);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.rNT) + 0;
      paramInt = i;
      if (this.rNU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rNU);
      }
      i = paramInt;
      if (this.rNV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rNV);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Width);
      int j = f.a.a.b.b.a.bA(5, this.Height);
      int k = f.a.a.b.b.a.fY(6);
      int m = f.a.a.b.b.a.bA(7, this.rNX);
      int n = f.a.a.b.b.a.q(8, this.rNY);
      int i1 = f.a.a.b.b.a.bA(9, this.rNZ);
      AppMethodBeat.o(40875);
      return i + paramInt + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(40875);
        return -1;
      case 1: 
        locali.rNT = locala.KhF.xS();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.rNU = locala.KhF.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.rNV = locala.KhF.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.KhF.xS();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.KhF.xS();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.rNW = locala.KhF.fHu();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.rNX = locala.KhF.xS();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.rNY = locala.KhF.xT();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.rNZ = locala.KhF.xS();
      AppMethodBeat.o(40875);
      return 0;
    }
    AppMethodBeat.o(40875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.i
 * JD-Core Version:    0.7.0.1
 */