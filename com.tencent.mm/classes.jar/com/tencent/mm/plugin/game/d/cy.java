package com.tencent.mm.plugin.game.d;

public final class cy
  extends com.tencent.mm.bv.a
{
  public String kRP;
  public String kSy;
  public String kWd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWd != null) {
        paramVarArgs.d(1, this.kWd);
      }
      if (this.kSy != null) {
        paramVarArgs.d(2, this.kSy);
      }
      if (this.kRP != null) {
        paramVarArgs.d(3, this.kRP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWd == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.kWd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSy);
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRP);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcy.kWd = locala.xpH.readString();
          return 0;
        case 2: 
          localcy.kSy = locala.xpH.readString();
          return 0;
        }
        localcy.kRP = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cy
 * JD-Core Version:    0.7.0.1
 */