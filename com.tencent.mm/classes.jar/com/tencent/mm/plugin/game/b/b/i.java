package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public int Height;
  public int Width;
  public int tSp;
  public String tSq;
  public String tSr;
  public boolean tSs;
  public int tSt;
  public long tSu;
  public int tSv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.tSp);
      if (this.tSq != null) {
        paramVarArgs.d(2, this.tSq);
      }
      if (this.tSr != null) {
        paramVarArgs.d(3, this.tSr);
      }
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      paramVarArgs.bt(6, this.tSs);
      paramVarArgs.aS(7, this.tSt);
      paramVarArgs.aY(8, this.tSu);
      paramVarArgs.aS(9, this.tSv);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.tSp) + 0;
      paramInt = i;
      if (this.tSq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tSq);
      }
      i = paramInt;
      if (this.tSr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tSr);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Width);
      int j = f.a.a.b.b.a.bz(5, this.Height);
      int k = f.a.a.b.b.a.alV(6);
      int m = f.a.a.b.b.a.bz(7, this.tSt);
      int n = f.a.a.b.b.a.p(8, this.tSu);
      int i1 = f.a.a.b.b.a.bz(9, this.tSv);
      AppMethodBeat.o(40875);
      return i + paramInt + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        locali.tSp = locala.NPN.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.tSq = locala.NPN.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.tSr = locala.NPN.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.NPN.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.NPN.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.tSs = locala.NPN.grw();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.tSt = locala.NPN.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.tSu = locala.NPN.zd();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.tSv = locala.NPN.zc();
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