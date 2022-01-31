package com.tencent.mm.plugin.backup.i;

import d.a.a.b;

public final class aa
  extends com.tencent.mm.bv.a
{
  public String hPQ;
  public long hRc;
  public long hRd;
  public String hRe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPQ == null) {
        throw new b("Not all required fields were included: BakChatName");
      }
      if (this.hRe == null) {
        throw new b("Not all required fields were included: MsgDataID");
      }
      if (this.hPQ != null) {
        paramVarArgs.d(1, this.hPQ);
      }
      paramVarArgs.Y(2, this.hRc);
      paramVarArgs.Y(3, this.hRd);
      if (this.hRe != null) {
        paramVarArgs.d(4, this.hRe);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPQ == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPQ) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.hRc) + d.a.a.a.X(3, this.hRd);
      paramInt = i;
      if (this.hRe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hRe);
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
        if (this.hPQ == null) {
          throw new b("Not all required fields were included: BakChatName");
        }
        if (this.hRe != null) {
          break;
        }
        throw new b("Not all required fields were included: MsgDataID");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaa.hPQ = locala.xpH.readString();
          return 0;
        case 2: 
          localaa.hRc = locala.xpH.oE();
          return 0;
        case 3: 
          localaa.hRd = locala.xpH.oE();
          return 0;
        }
        localaa.hRe = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.aa
 * JD-Core Version:    0.7.0.1
 */