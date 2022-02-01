package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  extends com.tencent.mm.bx.a
{
  public int ReqType;
  public String Url;
  public int hCZ;
  public String hDa;
  public long msgId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      paramVarArgs.aS(2, this.ReqType);
      paramVarArgs.aS(3, this.hCZ);
      if (this.hDa != null) {
        paramVarArgs.d(4, this.hDa);
      }
      paramVarArgs.aY(5, this.msgId);
      AppMethodBeat.o(116412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ReqType) + f.a.a.b.b.a.bz(3, this.hCZ);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hDa);
      }
      i = f.a.a.b.b.a.p(5, this.msgId);
      AppMethodBeat.o(116412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116412);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116412);
          return -1;
        case 1: 
          localq.Url = locala.NPN.readString();
          AppMethodBeat.o(116412);
          return 0;
        case 2: 
          localq.ReqType = locala.NPN.zc();
          AppMethodBeat.o(116412);
          return 0;
        case 3: 
          localq.hCZ = locala.NPN.zc();
          AppMethodBeat.o(116412);
          return 0;
        case 4: 
          localq.hDa = locala.NPN.readString();
          AppMethodBeat.o(116412);
          return 0;
        }
        localq.msgId = locala.NPN.zd();
        AppMethodBeat.o(116412);
        return 0;
      }
      AppMethodBeat.o(116412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.q
 * JD-Core Version:    0.7.0.1
 */