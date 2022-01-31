package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class ct
  extends com.tencent.mm.bv.a
{
  public String kSE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSE == null) {
        throw new b("Not all required fields were included: PkgId");
      }
      if (this.kSE != null) {
        paramVarArgs.d(1, this.kSE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSE == null) {
        break label210;
      }
    }
    label210:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSE) + 0;; paramInt = 0)
    {
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kSE != null) {
          break;
        }
        throw new b("Not all required fields were included: PkgId");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        }
        localct.kSE = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ct
 * JD-Core Version:    0.7.0.1
 */