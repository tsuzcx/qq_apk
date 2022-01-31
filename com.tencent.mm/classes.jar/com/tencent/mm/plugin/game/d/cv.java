package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class cv
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int kVX;
  public long kVY;
  public String kVZ;
  public boolean kWa;
  public int kWb;
  public String kWc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      paramVarArgs.gB(2, this.kVX);
      paramVarArgs.Y(3, this.kVY);
      if (this.kVZ != null) {
        paramVarArgs.d(4, this.kVZ);
      }
      paramVarArgs.aA(5, this.kWa);
      paramVarArgs.gB(6, this.kWb);
      if (this.kWc != null) {
        paramVarArgs.d(7, this.kWc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPY) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kVX) + d.a.a.a.X(3, this.kVY);
      paramInt = i;
      if (this.kVZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVZ);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(5) + 1) + d.a.a.a.gy(6, this.kWb);
      paramInt = i;
      if (this.kWc != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kWc);
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
        if (this.hPY != null) {
          break;
        }
        throw new b("Not all required fields were included: UserName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcv.hPY = locala.xpH.readString();
          return 0;
        case 2: 
          localcv.kVX = locala.xpH.oD();
          return 0;
        case 3: 
          localcv.kVY = locala.xpH.oE();
          return 0;
        case 4: 
          localcv.kVZ = locala.xpH.readString();
          return 0;
        case 5: 
          localcv.kWa = locala.cUr();
          return 0;
        case 6: 
          localcv.kWb = locala.xpH.oD();
          return 0;
        }
        localcv.kWc = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cv
 * JD-Core Version:    0.7.0.1
 */