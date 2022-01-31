package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class dk
  extends com.tencent.mm.bv.a
{
  public String kWn;
  public String kWo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWn == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.kWo == null) {
        throw new b("Not all required fields were included: TimeDesc");
      }
      if (this.kWn != null) {
        paramVarArgs.d(1, this.kWn);
      }
      if (this.kWo != null) {
        paramVarArgs.d(2, this.kWo);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWn == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kWo != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kWo);
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
        if (this.kWn == null) {
          throw new b("Not all required fields were included: FromUserName");
        }
        if (this.kWo != null) {
          break;
        }
        throw new b("Not all required fields were included: TimeDesc");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        dk localdk = (dk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdk.kWn = locala.xpH.readString();
          return 0;
        }
        localdk.kWo = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dk
 * JD-Core Version:    0.7.0.1
 */