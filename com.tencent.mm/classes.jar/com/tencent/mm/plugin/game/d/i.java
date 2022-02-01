package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bw.a
{
  public boolean thH;
  public boolean thI;
  public boolean thJ;
  public boolean thK;
  public boolean thL;
  public boolean thM;
  public boolean thN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.thH);
      paramVarArgs.bl(2, this.thI);
      paramVarArgs.bl(3, this.thJ);
      paramVarArgs.bl(4, this.thK);
      paramVarArgs.bl(5, this.thL);
      paramVarArgs.bl(6, this.thM);
      paramVarArgs.bl(7, this.thN);
      AppMethodBeat.o(190958);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(190958);
      return paramInt + 1 + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190958);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190958);
        return -1;
      case 1: 
        locali.thH = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      case 2: 
        locali.thI = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      case 3: 
        locali.thJ = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      case 4: 
        locali.thK = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      case 5: 
        locali.thL = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      case 6: 
        locali.thM = locala.LVo.fZX();
        AppMethodBeat.o(190958);
        return 0;
      }
      locali.thN = locala.LVo.fZX();
      AppMethodBeat.o(190958);
      return 0;
    }
    AppMethodBeat.o(190958);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.i
 * JD-Core Version:    0.7.0.1
 */