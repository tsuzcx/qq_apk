package com.tencent.mm.plugin.game.d;

public final class cz
  extends com.tencent.mm.bv.a
{
  public String kRS;
  public String kRY;
  public String kWe;
  public String kWf;
  public String kWg;
  public boolean kWh;
  public boolean kWi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRY != null) {
        paramVarArgs.d(1, this.kRY);
      }
      if (this.kWe != null) {
        paramVarArgs.d(2, this.kWe);
      }
      if (this.kWf != null) {
        paramVarArgs.d(3, this.kWf);
      }
      if (this.kWg != null) {
        paramVarArgs.d(4, this.kWg);
      }
      if (this.kRS != null) {
        paramVarArgs.d(5, this.kRS);
      }
      paramVarArgs.aA(6, this.kWh);
      paramVarArgs.aA(7, this.kWi);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRY == null) {
        break label467;
      }
    }
    label467:
    for (int i = d.a.a.b.b.a.e(1, this.kRY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWe != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kWe);
      }
      i = paramInt;
      if (this.kWf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWf);
      }
      paramInt = i;
      if (this.kWg != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWg);
      }
      i = paramInt;
      if (this.kRS != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kRS);
      }
      return i + (d.a.a.b.b.a.dQ(6) + 1) + (d.a.a.b.b.a.dQ(7) + 1);
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
        cz localcz = (cz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcz.kRY = locala.xpH.readString();
          return 0;
        case 2: 
          localcz.kWe = locala.xpH.readString();
          return 0;
        case 3: 
          localcz.kWf = locala.xpH.readString();
          return 0;
        case 4: 
          localcz.kWg = locala.xpH.readString();
          return 0;
        case 5: 
          localcz.kRS = locala.xpH.readString();
          return 0;
        case 6: 
          localcz.kWh = locala.cUr();
          return 0;
        }
        localcz.kWi = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cz
 * JD-Core Version:    0.7.0.1
 */