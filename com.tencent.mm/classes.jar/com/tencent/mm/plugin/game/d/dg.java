package com.tencent.mm.plugin.game.d;

public final class dg
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRP;
  public String kSs;
  public String kSy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSy != null) {
        paramVarArgs.d(1, this.kSy);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kRP != null) {
        paramVarArgs.d(3, this.kRP);
      }
      if (this.kSs != null) {
        paramVarArgs.d(4, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSy == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.kSy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRP);
      }
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSs);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        dg localdg = (dg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdg.kSy = locala.xpH.readString();
          return 0;
        case 2: 
          localdg.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localdg.kRP = locala.xpH.readString();
          return 0;
        }
        localdg.kSs = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dg
 * JD-Core Version:    0.7.0.1
 */