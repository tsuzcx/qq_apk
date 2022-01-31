package com.tencent.mm.plugin.backup.i;

import d.a.a.b;

public final class g
  extends com.tencent.mm.bv.a
{
  public String hPQ;
  public int hPR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPQ == null) {
        throw new b("Not all required fields were included: BakChatName");
      }
      if (this.hPQ != null) {
        paramVarArgs.d(1, this.hPQ);
      }
      paramVarArgs.gB(2, this.hPR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPQ == null) {
        break label244;
      }
    }
    label244:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPQ) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.hPR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hPQ != null) {
          break;
        }
        throw new b("Not all required fields were included: BakChatName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localg.hPQ = locala.xpH.readString();
          return 0;
        }
        localg.hPR = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.g
 * JD-Core Version:    0.7.0.1
 */