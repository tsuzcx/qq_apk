package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class v
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String kSY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.kSY == null) {
        throw new b("Not all required fields were included: Detail");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.kSY != null) {
        paramVarArgs.d(2, this.kSY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kSY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kSY);
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
        if (this.hPY == null) {
          throw new b("Not all required fields were included: UserName");
        }
        if (this.kSY != null) {
          break;
        }
        throw new b("Not all required fields were included: Detail");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localv.hPY = locala.xpH.readString();
          return 0;
        }
        localv.kSY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */