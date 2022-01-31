package com.tencent.mm.plugin.luckymoney.b;

public final class n
  extends com.tencent.mm.bv.a
{
  public String lQL;
  public String lQM;
  public String lQN;
  public String lQO;
  public String lQb;
  public long lQy;
  public String lQz;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lQL != null) {
        paramVarArgs.d(1, this.lQL);
      }
      if (this.lQM != null) {
        paramVarArgs.d(2, this.lQM);
      }
      paramVarArgs.Y(3, this.lQy);
      if (this.lQz != null) {
        paramVarArgs.d(4, this.lQz);
      }
      if (this.lQN != null) {
        paramVarArgs.d(5, this.lQN);
      }
      if (this.lQb != null) {
        paramVarArgs.d(6, this.lQb);
      }
      if (this.lQO != null) {
        paramVarArgs.d(7, this.lQO);
      }
      if (this.userName != null) {
        paramVarArgs.d(8, this.userName);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.lQL == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = d.a.a.b.b.a.e(1, this.lQL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lQM != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.lQM);
      }
      i += d.a.a.a.X(3, this.lQy);
      paramInt = i;
      if (this.lQz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lQz);
      }
      i = paramInt;
      if (this.lQN != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.lQN);
      }
      paramInt = i;
      if (this.lQb != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.lQb);
      }
      i = paramInt;
      if (this.lQO != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.lQO);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.userName);
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
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.lQL = locala.xpH.readString();
          return 0;
        case 2: 
          localn.lQM = locala.xpH.readString();
          return 0;
        case 3: 
          localn.lQy = locala.xpH.oE();
          return 0;
        case 4: 
          localn.lQz = locala.xpH.readString();
          return 0;
        case 5: 
          localn.lQN = locala.xpH.readString();
          return 0;
        case 6: 
          localn.lQb = locala.xpH.readString();
          return 0;
        case 7: 
          localn.lQO = locala.xpH.readString();
          return 0;
        }
        localn.userName = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.n
 * JD-Core Version:    0.7.0.1
 */