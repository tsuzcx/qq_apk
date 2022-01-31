package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class k
  extends com.tencent.mm.bv.a
{
  public String kSA;
  public String kSB;
  public String kSC;
  public String kSz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSz == null) {
        throw new b("Not all required fields were included: Message");
      }
      if (this.kSA == null) {
        throw new b("Not all required fields were included: GotoBtn");
      }
      if (this.kSB == null) {
        throw new b("Not all required fields were included: CancelBtn");
      }
      if (this.kSC == null) {
        throw new b("Not all required fields were included: Url");
      }
      if (this.kSz != null) {
        paramVarArgs.d(1, this.kSz);
      }
      if (this.kSA != null) {
        paramVarArgs.d(2, this.kSA);
      }
      if (this.kSB != null) {
        paramVarArgs.d(3, this.kSB);
      }
      if (this.kSC != null) {
        paramVarArgs.d(4, this.kSC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSz == null) {
        break label480;
      }
    }
    label480:
    for (int i = d.a.a.b.b.a.e(1, this.kSz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSA != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSA);
      }
      i = paramInt;
      if (this.kSB != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kSB);
      }
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSC);
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
        if (this.kSz == null) {
          throw new b("Not all required fields were included: Message");
        }
        if (this.kSA == null) {
          throw new b("Not all required fields were included: GotoBtn");
        }
        if (this.kSB == null) {
          throw new b("Not all required fields were included: CancelBtn");
        }
        if (this.kSC != null) {
          break;
        }
        throw new b("Not all required fields were included: Url");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localk.kSz = locala.xpH.readString();
          return 0;
        case 2: 
          localk.kSA = locala.xpH.readString();
          return 0;
        case 3: 
          localk.kSB = locala.xpH.readString();
          return 0;
        }
        localk.kSC = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.k
 * JD-Core Version:    0.7.0.1
 */