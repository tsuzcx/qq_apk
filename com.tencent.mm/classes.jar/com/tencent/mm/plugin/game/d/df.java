package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class df
  extends com.tencent.mm.bx.a
{
  public String Label;
  public String nDo;
  public int ujD;
  public long ujE;
  public boolean ujF;
  public int ujG;
  public String ujH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41828);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      paramVarArgs.aS(2, this.ujD);
      paramVarArgs.aY(3, this.ujE);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      paramVarArgs.bt(5, this.ujF);
      paramVarArgs.aS(6, this.ujG);
      if (this.ujH != null) {
        paramVarArgs.d(7, this.ujH);
      }
      AppMethodBeat.o(41828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ujD) + f.a.a.b.b.a.p(3, this.ujE);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.bz(6, this.ujG);
      paramInt = i;
      if (this.ujH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ujH);
      }
      AppMethodBeat.o(41828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nDo == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41828);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41828);
          return -1;
        case 1: 
          localdf.nDo = locala.NPN.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 2: 
          localdf.ujD = locala.NPN.zc();
          AppMethodBeat.o(41828);
          return 0;
        case 3: 
          localdf.ujE = locala.NPN.zd();
          AppMethodBeat.o(41828);
          return 0;
        case 4: 
          localdf.Label = locala.NPN.readString();
          AppMethodBeat.o(41828);
          return 0;
        case 5: 
          localdf.ujF = locala.NPN.grw();
          AppMethodBeat.o(41828);
          return 0;
        case 6: 
          localdf.ujG = locala.NPN.zc();
          AppMethodBeat.o(41828);
          return 0;
        }
        localdf.ujH = locala.NPN.readString();
        AppMethodBeat.o(41828);
        return 0;
      }
      AppMethodBeat.o(41828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.df
 * JD-Core Version:    0.7.0.1
 */