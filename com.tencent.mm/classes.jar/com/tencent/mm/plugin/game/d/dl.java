package com.tencent.mm.plugin.game.d;

public final class dl
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kRO;
  public String kWo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.kWo != null) {
        paramVarArgs.d(3, this.kWo);
      }
      if (this.kRO != null) {
        paramVarArgs.d(4, this.kRO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.kWo != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWo);
      }
      paramInt = i;
      if (this.kRO != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRO);
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
        dl localdl = (dl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdl.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localdl.kRN = locala.xpH.readString();
          return 0;
        case 3: 
          localdl.kWo = locala.xpH.readString();
          return 0;
        }
        localdl.kRO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dl
 * JD-Core Version:    0.7.0.1
 */