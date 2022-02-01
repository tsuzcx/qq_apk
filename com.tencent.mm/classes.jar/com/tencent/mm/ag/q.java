package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bw.a
{
  public int ReqType;
  public String Url;
  public int iAb;
  public String iAc;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      paramVarArgs.aM(2, this.ReqType);
      paramVarArgs.aM(3, this.iAb);
      if (this.iAc != null) {
        paramVarArgs.e(4, this.iAc);
      }
      paramVarArgs.bb(5, this.msgId);
      AppMethodBeat.o(116412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ReqType) + g.a.a.b.b.a.bu(3, this.iAb);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAc);
      }
      i = g.a.a.b.b.a.r(5, this.msgId);
      AppMethodBeat.o(116412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
          localq.Url = locala.UbS.readString();
          AppMethodBeat.o(116412);
          return 0;
        case 2: 
          localq.ReqType = locala.UbS.zi();
          AppMethodBeat.o(116412);
          return 0;
        case 3: 
          localq.iAb = locala.UbS.zi();
          AppMethodBeat.o(116412);
          return 0;
        case 4: 
          localq.iAc = locala.UbS.readString();
          AppMethodBeat.o(116412);
          return 0;
        }
        localq.msgId = locala.UbS.zl();
        AppMethodBeat.o(116412);
        return 0;
      }
      AppMethodBeat.o(116412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.q
 * JD-Core Version:    0.7.0.1
 */