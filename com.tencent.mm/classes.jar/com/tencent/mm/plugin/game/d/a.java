package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class a
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kRO;
  public String kRP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.kRO != null) {
        paramVarArgs.d(3, this.kRO);
      }
      if (this.kRP != null) {
        paramVarArgs.d(4, this.kRP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label376;
      }
    }
    label376:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.kRO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRO);
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRP);
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
        if (this.bGw != null) {
          break;
        }
        throw new b("Not all required fields were included: Title");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locala1.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          locala1.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          locala1.kRO = locala.xpH.readString();
          return 0;
        }
        locala1.kRP = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.a
 * JD-Core Version:    0.7.0.1
 */