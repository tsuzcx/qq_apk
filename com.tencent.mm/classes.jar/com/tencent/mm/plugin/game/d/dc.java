package com.tencent.mm.plugin.game.d;

public final class dc
  extends com.tencent.mm.bv.a
{
  public String color;
  public String kQS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.color != null) {
        paramVarArgs.d(1, this.color);
      }
      if (this.kQS != null) {
        paramVarArgs.d(2, this.kQS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.color == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = d.a.a.b.b.a.e(1, this.color) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kQS != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kQS);
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
        dc localdc = (dc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdc.color = locala.xpH.readString();
          return 0;
        }
        localdc.kQS = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dc
 * JD-Core Version:    0.7.0.1
 */