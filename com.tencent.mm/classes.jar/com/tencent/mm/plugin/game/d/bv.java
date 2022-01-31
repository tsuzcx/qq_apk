package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class bv
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRS;
  public String kSY;
  public String kVi;
  public String kVl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kVi != null) {
        paramVarArgs.d(1, this.kVi);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kSY != null) {
        paramVarArgs.d(3, this.kSY);
      }
      if (this.kRS != null) {
        paramVarArgs.d(4, this.kRS);
      }
      if (this.kVl != null) {
        paramVarArgs.d(5, this.kVl);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVi == null) {
        break label431;
      }
    }
    label431:
    for (int i = d.a.a.b.b.a.e(1, this.kVi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kSY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kSY);
      }
      paramInt = i;
      if (this.kRS != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRS);
      }
      i = paramInt;
      if (this.kVl != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kVl);
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
        if (this.bGw != null) {
          break;
        }
        throw new b("Not all required fields were included: Title");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bv localbv = (bv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbv.kVi = locala.xpH.readString();
          return 0;
        case 2: 
          localbv.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localbv.kSY = locala.xpH.readString();
          return 0;
        case 4: 
          localbv.kRS = locala.xpH.readString();
          return 0;
        }
        localbv.kVl = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bv
 * JD-Core Version:    0.7.0.1
 */