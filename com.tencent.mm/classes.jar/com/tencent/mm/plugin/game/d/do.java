package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class do
  extends com.tencent.mm.bv.a
{
  public String euK;
  public String hPY;
  public String kSs;
  public String kSy;
  public String kVn;
  public String kWt;
  public int kWu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.euK != null) {
        paramVarArgs.d(1, this.euK);
      }
      if (this.kVn != null) {
        paramVarArgs.d(2, this.kVn);
      }
      if (this.kSy != null) {
        paramVarArgs.d(3, this.kSy);
      }
      if (this.hPY != null) {
        paramVarArgs.d(4, this.hPY);
      }
      if (this.kWt != null) {
        paramVarArgs.d(5, this.kWt);
      }
      paramVarArgs.gB(6, this.kWu);
      if (this.kSs != null) {
        paramVarArgs.d(7, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.euK == null) {
        break label529;
      }
    }
    label529:
    for (int i = d.a.a.b.b.a.e(1, this.euK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVn);
      }
      i = paramInt;
      if (this.kSy != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kSy);
      }
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hPY);
      }
      i = paramInt;
      if (this.kWt != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kWt);
      }
      i += d.a.a.a.gy(6, this.kWu);
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kSs);
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
        if (this.euK != null) {
          break;
        }
        throw new b("Not all required fields were included: AppId");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdo.euK = locala.xpH.readString();
          return 0;
        case 2: 
          localdo.kVn = locala.xpH.readString();
          return 0;
        case 3: 
          localdo.kSy = locala.xpH.readString();
          return 0;
        case 4: 
          localdo.hPY = locala.xpH.readString();
          return 0;
        case 5: 
          localdo.kWt = locala.xpH.readString();
          return 0;
        case 6: 
          localdo.kWu = locala.xpH.oD();
          return 0;
        }
        localdo.kSs = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.do
 * JD-Core Version:    0.7.0.1
 */