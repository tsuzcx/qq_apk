package com.tencent.mm.plugin.game.d;

public final class bt
  extends com.tencent.mm.bv.a
{
  public String dPV;
  public String desc;
  public String iQp;
  public String kVj;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dPV != null) {
        paramVarArgs.d(2, this.dPV);
      }
      if (this.iQp != null) {
        paramVarArgs.d(3, this.iQp);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.kVj != null) {
        paramVarArgs.d(5, this.kVj);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dPV != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.dPV);
      }
      i = paramInt;
      if (this.iQp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQp);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.desc);
      }
      i = paramInt;
      if (this.kVj != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kVj);
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
        bt localbt = (bt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbt.title = locala.xpH.readString();
          return 0;
        case 2: 
          localbt.dPV = locala.xpH.readString();
          return 0;
        case 3: 
          localbt.iQp = locala.xpH.readString();
          return 0;
        case 4: 
          localbt.desc = locala.xpH.readString();
          return 0;
        }
        localbt.kVj = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bt
 * JD-Core Version:    0.7.0.1
 */