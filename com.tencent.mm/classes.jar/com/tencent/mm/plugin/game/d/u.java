package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class u
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String hPY;
  public String kRY;
  public String kSY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kSY == null) {
        throw new b("Not all required fields were included: Detail");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.kRY != null) {
        paramVarArgs.d(2, this.kRY);
      }
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kSY != null) {
        paramVarArgs.d(4, this.kSY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label412;
      }
    }
    label412:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRY);
      }
      i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bGw);
      }
      paramInt = i;
      if (this.kSY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSY);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kSY != null) {
          break;
        }
        throw new b("Not all required fields were included: Detail");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localu.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localu.kRY = locala.xpH.readString();
          return 0;
        case 3: 
          localu.bGw = locala.xpH.readString();
          return 0;
        }
        localu.kSY = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.u
 * JD-Core Version:    0.7.0.1
 */