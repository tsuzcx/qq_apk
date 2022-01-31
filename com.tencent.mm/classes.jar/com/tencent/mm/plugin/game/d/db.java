package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class db
  extends com.tencent.mm.bv.a
{
  public String kRZ;
  public int kUV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ == null) {
        throw new b("Not all required fields were included: Name");
      }
      paramVarArgs.gB(1, this.kUV);
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.kUV) + 0;
      paramInt = i;
    } while (this.kRZ == null);
    return i + d.a.a.b.b.a.e(2, this.kRZ);
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
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      db localdb = (db)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localdb.kUV = locala.xpH.oD();
        return 0;
      }
      localdb.kRZ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.db
 * JD-Core Version:    0.7.0.1
 */