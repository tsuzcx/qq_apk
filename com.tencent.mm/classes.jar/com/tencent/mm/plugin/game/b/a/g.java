package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String Url;
  public int oTW;
  public int oUv;
  public int xuA;
  public long xui;
  public String xuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204104);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xuz != null) {
        paramVarArgs.e(1, this.xuz);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(2, this.Md5);
      }
      paramVarArgs.aM(3, this.xuA);
      paramVarArgs.aM(4, this.oTW);
      paramVarArgs.aM(5, this.oUv);
      if (this.Url != null) {
        paramVarArgs.e(6, this.Url);
      }
      paramVarArgs.bb(7, this.xui);
      AppMethodBeat.o(204104);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuz == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.b.b.a.f(1, this.xuz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Md5);
      }
      i = i + g.a.a.b.b.a.bu(3, this.xuA) + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.oUv);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Url);
      }
      i = g.a.a.b.b.a.r(7, this.xui);
      AppMethodBeat.o(204104);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(204104);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(204104);
          return -1;
        case 1: 
          localg.xuz = locala.UbS.readString();
          AppMethodBeat.o(204104);
          return 0;
        case 2: 
          localg.Md5 = locala.UbS.readString();
          AppMethodBeat.o(204104);
          return 0;
        case 3: 
          localg.xuA = locala.UbS.zi();
          AppMethodBeat.o(204104);
          return 0;
        case 4: 
          localg.oTW = locala.UbS.zi();
          AppMethodBeat.o(204104);
          return 0;
        case 5: 
          localg.oUv = locala.UbS.zi();
          AppMethodBeat.o(204104);
          return 0;
        case 6: 
          localg.Url = locala.UbS.readString();
          AppMethodBeat.o(204104);
          return 0;
        }
        localg.xui = locala.UbS.zl();
        AppMethodBeat.o(204104);
        return 0;
      }
      AppMethodBeat.o(204104);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.g
 * JD-Core Version:    0.7.0.1
 */