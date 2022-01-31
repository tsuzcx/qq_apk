package com.tencent.mm.plugin.game.d;

public final class ca
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRP;
  public String kSy;
  public String kVu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kSy != null) {
        paramVarArgs.d(2, this.kSy);
      }
      if (this.kRP != null) {
        paramVarArgs.d(3, this.kRP);
      }
      if (this.kVu != null) {
        paramVarArgs.d(4, this.kVu);
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
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSy);
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRP);
      }
      paramInt = i;
      if (this.kVu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVu);
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
        ca localca = (ca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localca.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localca.kSy = locala.xpH.readString();
          return 0;
        case 3: 
          localca.kRP = locala.xpH.readString();
          return 0;
        }
        localca.kVu = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ca
 * JD-Core Version:    0.7.0.1
 */