package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.cd.a
{
  public String Url;
  public int lpw;
  public int lpx;
  public String lpy;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.f(1, this.Url);
      }
      paramVarArgs.aY(2, this.lpw);
      paramVarArgs.aY(3, this.lpx);
      if (this.lpy != null) {
        paramVarArgs.f(4, this.lpy);
      }
      paramVarArgs.bm(5, this.msgId);
      AppMethodBeat.o(116412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.b.b.a.g(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.lpw) + g.a.a.b.b.a.bM(3, this.lpx);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpy);
      }
      i = g.a.a.b.b.a.p(5, this.msgId);
      AppMethodBeat.o(116412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116412);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116412);
          return -1;
        case 1: 
          localq.Url = locala.abFh.readString();
          AppMethodBeat.o(116412);
          return 0;
        case 2: 
          localq.lpw = locala.abFh.AK();
          AppMethodBeat.o(116412);
          return 0;
        case 3: 
          localq.lpx = locala.abFh.AK();
          AppMethodBeat.o(116412);
          return 0;
        case 4: 
          localq.lpy = locala.abFh.readString();
          AppMethodBeat.o(116412);
          return 0;
        }
        localq.msgId = locala.abFh.AN();
        AppMethodBeat.o(116412);
        return 0;
      }
      AppMethodBeat.o(116412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aj.q
 * JD-Core Version:    0.7.0.1
 */