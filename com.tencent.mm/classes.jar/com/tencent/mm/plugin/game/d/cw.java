package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class cw
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String euK;
  public String kRN;
  public String kRO;
  public String kRP;
  public String kSs;
  public String kVn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVn == null) {
        throw new b("Not all required fields were included: AppName");
      }
      if (this.kVn != null) {
        paramVarArgs.d(1, this.kVn);
      }
      if (this.kRO != null) {
        paramVarArgs.d(2, this.kRO);
      }
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.kSs != null) {
        paramVarArgs.d(5, this.kSs);
      }
      if (this.kRP != null) {
        paramVarArgs.d(6, this.kRP);
      }
      if (this.euK != null) {
        paramVarArgs.d(7, this.euK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVn == null) {
        break label545;
      }
    }
    label545:
    for (int i = d.a.a.b.b.a.e(1, this.kVn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRO != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRO);
      }
      i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bGw);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.kSs != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSs);
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kRP);
      }
      i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.euK);
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
        if (this.kVn != null) {
          break;
        }
        throw new b("Not all required fields were included: AppName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcw.kVn = locala.xpH.readString();
          return 0;
        case 2: 
          localcw.kRO = locala.xpH.readString();
          return 0;
        case 3: 
          localcw.bGw = locala.xpH.readString();
          return 0;
        case 4: 
          localcw.kRN = locala.xpH.readString();
          return 0;
        case 5: 
          localcw.kSs = locala.xpH.readString();
          return 0;
        case 6: 
          localcw.kRP = locala.xpH.readString();
          return 0;
        }
        localcw.euK = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cw
 * JD-Core Version:    0.7.0.1
 */