package com.tencent.mm.k.a.a;

public final class b
  extends com.tencent.mm.bv.a
{
  public String dtK;
  public int dtL;
  public String dtM;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.userName != null) {
        paramVarArgs.d(1, this.userName);
      }
      if (this.dtK != null) {
        paramVarArgs.d(2, this.dtK);
      }
      paramVarArgs.gB(3, this.dtL);
      if (this.dtM != null) {
        paramVarArgs.d(4, this.dtM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.userName == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.b.b.a.e(1, this.userName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dtK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.dtK);
      }
      i += d.a.a.a.gy(3, this.dtL);
      paramInt = i;
      if (this.dtM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.dtM);
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
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localb.userName = locala.xpH.readString();
          return 0;
        case 2: 
          localb.dtK = locala.xpH.readString();
          return 0;
        case 3: 
          localb.dtL = locala.xpH.oD();
          return 0;
        }
        localb.dtM = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.b
 * JD-Core Version:    0.7.0.1
 */