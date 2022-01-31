package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class cf
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public String kVz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ == null) {
        throw new b("Not all required fields were included: Name");
      }
      if (this.kVz == null) {
        throw new b("Not all required fields were included: Color");
      }
      if (this.kRZ != null) {
        paramVarArgs.d(1, this.kRZ);
      }
      if (this.kVz != null) {
        paramVarArgs.d(2, this.kVz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRZ == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVz != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kVz);
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
        if (this.kRZ == null) {
          throw new b("Not all required fields were included: Name");
        }
        if (this.kVz != null) {
          break;
        }
        throw new b("Not all required fields were included: Color");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcf.kRZ = locala.xpH.readString();
          return 0;
        }
        localcf.kVz = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cf
 * JD-Core Version:    0.7.0.1
 */