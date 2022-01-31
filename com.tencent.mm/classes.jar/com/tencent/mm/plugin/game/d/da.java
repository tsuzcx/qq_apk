package com.tencent.mm.plugin.game.d;

public final class da
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRO;
  public String kRP;
  public int kWj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRP != null) {
        paramVarArgs.d(2, this.kRP);
      }
      if (this.kRO != null) {
        paramVarArgs.d(3, this.kRO);
      }
      paramVarArgs.gB(4, this.kWj);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label324;
      }
    }
    label324:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRP);
      }
      i = paramInt;
      if (this.kRO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRO);
      }
      return i + d.a.a.a.gy(4, this.kWj);
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
        da localda = (da)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localda.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localda.kRP = locala.xpH.readString();
          return 0;
        case 3: 
          localda.kRO = locala.xpH.readString();
          return 0;
        }
        localda.kWj = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.da
 * JD-Core Version:    0.7.0.1
 */