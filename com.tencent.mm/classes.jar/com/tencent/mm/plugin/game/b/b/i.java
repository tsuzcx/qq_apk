package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int Width;
  public int sVK;
  public String sVL;
  public String sVM;
  public boolean sVN;
  public int sVO;
  public long sVP;
  public int sVQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40875);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sVK);
      if (this.sVL != null) {
        paramVarArgs.d(2, this.sVL);
      }
      if (this.sVM != null) {
        paramVarArgs.d(3, this.sVM);
      }
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      paramVarArgs.bl(6, this.sVN);
      paramVarArgs.aR(7, this.sVO);
      paramVarArgs.aO(8, this.sVP);
      paramVarArgs.aR(9, this.sVQ);
      AppMethodBeat.o(40875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.sVK) + 0;
      paramInt = i;
      if (this.sVL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sVL);
      }
      i = paramInt;
      if (this.sVM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sVM);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Width);
      int j = f.a.a.b.b.a.bx(5, this.Height);
      int k = f.a.a.b.b.a.fK(6);
      int m = f.a.a.b.b.a.bx(7, this.sVO);
      int n = f.a.a.b.b.a.p(8, this.sVP);
      int i1 = f.a.a.b.b.a.bx(9, this.sVQ);
      AppMethodBeat.o(40875);
      return i + paramInt + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        locali.sVK = locala.LVo.xF();
        AppMethodBeat.o(40875);
        return 0;
      case 2: 
        locali.sVL = locala.LVo.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 3: 
        locali.sVM = locala.LVo.readString();
        AppMethodBeat.o(40875);
        return 0;
      case 4: 
        locali.Width = locala.LVo.xF();
        AppMethodBeat.o(40875);
        return 0;
      case 5: 
        locali.Height = locala.LVo.xF();
        AppMethodBeat.o(40875);
        return 0;
      case 6: 
        locali.sVN = locala.LVo.fZX();
        AppMethodBeat.o(40875);
        return 0;
      case 7: 
        locali.sVO = locala.LVo.xF();
        AppMethodBeat.o(40875);
        return 0;
      case 8: 
        locali.sVP = locala.LVo.xG();
        AppMethodBeat.o(40875);
        return 0;
      }
      locali.sVQ = locala.LVo.xF();
      AppMethodBeat.o(40875);
      return 0;
    }
    AppMethodBeat.o(40875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.i
 * JD-Core Version:    0.7.0.1
 */