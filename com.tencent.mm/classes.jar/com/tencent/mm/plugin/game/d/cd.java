package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class cd
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRS;
  public String kRY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRY == null) {
        throw new b("Not all required fields were included: IconURL");
      }
      if (this.kRY != null) {
        paramVarArgs.d(1, this.kRY);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kRS != null) {
        paramVarArgs.d(3, this.kRS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRY == null) {
        break label321;
      }
    }
    label321:
    for (int i = d.a.a.b.b.a.e(1, this.kRY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kRS != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRS);
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
        if (this.kRY != null) {
          break;
        }
        throw new b("Not all required fields were included: IconURL");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cd localcd = (cd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcd.kRY = locala.xpH.readString();
          return 0;
        case 2: 
          localcd.bGw = locala.xpH.readString();
          return 0;
        }
        localcd.kRS = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cd
 * JD-Core Version:    0.7.0.1
 */