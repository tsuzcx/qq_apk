package com.tencent.mm.plugin.game.d;

public final class am
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String euK;
  public String kRN;
  public String kRP;
  public String kTM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kTM != null) {
        paramVarArgs.d(1, this.kTM);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(3, this.kRN);
      }
      if (this.kRP != null) {
        paramVarArgs.d(4, this.kRP);
      }
      if (this.euK != null) {
        paramVarArgs.d(5, this.euK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kTM == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.kTM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRN);
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRP);
      }
      i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.euK);
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
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localam.kTM = locala.xpH.readString();
          return 0;
        case 2: 
          localam.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localam.kRN = locala.xpH.readString();
          return 0;
        case 4: 
          localam.kRP = locala.xpH.readString();
          return 0;
        }
        localam.euK = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.am
 * JD-Core Version:    0.7.0.1
 */