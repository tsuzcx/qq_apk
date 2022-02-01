package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bx.a
{
  public boolean ufA;
  public boolean ufB;
  public boolean ufC;
  public boolean ufD;
  public boolean ufE;
  public boolean ufy;
  public boolean ufz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.ufy);
      paramVarArgs.bt(2, this.ufz);
      paramVarArgs.bt(3, this.ufA);
      paramVarArgs.bt(4, this.ufB);
      paramVarArgs.bt(5, this.ufC);
      paramVarArgs.bt(6, this.ufD);
      paramVarArgs.bt(7, this.ufE);
      AppMethodBeat.o(199575);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alV(1);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.alV(3);
      int k = f.a.a.b.b.a.alV(4);
      int m = f.a.a.b.b.a.alV(5);
      int n = f.a.a.b.b.a.alV(6);
      int i1 = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(199575);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(199575);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199575);
        return -1;
      case 1: 
        locali.ufy = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      case 2: 
        locali.ufz = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      case 3: 
        locali.ufA = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      case 4: 
        locali.ufB = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      case 5: 
        locali.ufC = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      case 6: 
        locali.ufD = locala.NPN.grw();
        AppMethodBeat.o(199575);
        return 0;
      }
      locali.ufE = locala.NPN.grw();
      AppMethodBeat.o(199575);
      return 0;
    }
    AppMethodBeat.o(199575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.i
 * JD-Core Version:    0.7.0.1
 */