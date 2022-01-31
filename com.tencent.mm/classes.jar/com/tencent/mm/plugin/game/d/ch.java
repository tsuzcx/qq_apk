package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class ch
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public String kRP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRN == null) {
        throw new b("Not all required fields were included: Desc");
      }
      if (this.kRN != null) {
        paramVarArgs.d(1, this.kRN);
      }
      if (this.kRP != null) {
        paramVarArgs.d(2, this.kRP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRN == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRP);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kRN != null) {
          break;
        }
        throw new b("Not all required fields were included: Desc");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ch localch = (ch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localch.kRN = locala.xpH.readString();
          return 0;
        }
        localch.kRP = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ch
 * JD-Core Version:    0.7.0.1
 */