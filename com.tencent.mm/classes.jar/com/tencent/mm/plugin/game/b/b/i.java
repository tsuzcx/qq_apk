package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int Width;
  public int udg;
  public String udh;
  public String udi;
  public boolean udj;
  public int udk;
  public long udl;
  public int udm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.udg);
      if (this.udh != null) {
        paramVarArgs.d(2, this.udh);
      }
      if (this.udi != null) {
        paramVarArgs.d(3, this.udi);
      }
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      paramVarArgs.bC(6, this.udj);
      paramVarArgs.aS(7, this.udk);
      paramVarArgs.aZ(8, this.udl);
      paramVarArgs.aS(9, this.udm);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.udg) + 0;
      paramInt = i;
      if (this.udh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.udh);
      }
      i = paramInt;
      if (this.udi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.udi);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Width);
      int j = f.a.a.b.b.a.bz(5, this.Height);
      int k = f.a.a.b.b.a.amF(6);
      int m = f.a.a.b.b.a.bz(7, this.udk);
      int n = f.a.a.b.b.a.p(8, this.udl);
      int i1 = f.a.a.b.b.a.bz(9, this.udm);
      AppMethodBeat.o(40875);
      return i + paramInt + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locali.udg = locala.OmT.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.udh = locala.OmT.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.udi = locala.OmT.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.OmT.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.OmT.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.udj = locala.OmT.gvY();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.udk = locala.OmT.zc();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.udl = locala.OmT.zd();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.udm = locala.OmT.zc();
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