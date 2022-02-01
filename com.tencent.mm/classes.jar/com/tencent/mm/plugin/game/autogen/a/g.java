package com.tencent.mm.plugin.game.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.cd.a
{
  public String CqQ;
  public int CqR;
  public long Cqz;
  public String Md5;
  public String Url;
  public int rVU;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CqQ != null) {
        paramVarArgs.f(1, this.CqQ);
      }
      if (this.Md5 != null) {
        paramVarArgs.f(2, this.Md5);
      }
      paramVarArgs.aY(3, this.CqR);
      paramVarArgs.aY(4, this.rVU);
      paramVarArgs.aY(5, this.rWu);
      if (this.Url != null) {
        paramVarArgs.f(6, this.Url);
      }
      paramVarArgs.bm(7, this.Cqz);
      AppMethodBeat.o(203494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CqQ == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.b.b.a.g(1, this.CqQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Md5);
      }
      i = i + g.a.a.b.b.a.bM(3, this.CqR) + g.a.a.b.b.a.bM(4, this.rVU) + g.a.a.b.b.a.bM(5, this.rWu);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Url);
      }
      i = g.a.a.b.b.a.p(7, this.Cqz);
      AppMethodBeat.o(203494);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(203494);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203494);
          return -1;
        case 1: 
          localg.CqQ = locala.abFh.readString();
          AppMethodBeat.o(203494);
          return 0;
        case 2: 
          localg.Md5 = locala.abFh.readString();
          AppMethodBeat.o(203494);
          return 0;
        case 3: 
          localg.CqR = locala.abFh.AK();
          AppMethodBeat.o(203494);
          return 0;
        case 4: 
          localg.rVU = locala.abFh.AK();
          AppMethodBeat.o(203494);
          return 0;
        case 5: 
          localg.rWu = locala.abFh.AK();
          AppMethodBeat.o(203494);
          return 0;
        case 6: 
          localg.Url = locala.abFh.readString();
          AppMethodBeat.o(203494);
          return 0;
        }
        localg.Cqz = locala.abFh.AN();
        AppMethodBeat.o(203494);
        return 0;
      }
      AppMethodBeat.o(203494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.a.g
 * JD-Core Version:    0.7.0.1
 */