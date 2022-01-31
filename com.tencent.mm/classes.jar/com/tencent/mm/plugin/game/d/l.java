package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class l
  extends com.tencent.mm.bv.a
{
  public String kRS;
  public String kRY;
  public String kRZ;
  public int kSD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRZ == null) {
        throw new b("Not all required fields were included: Name");
      }
      if (this.kRY == null) {
        throw new b("Not all required fields were included: IconURL");
      }
      paramVarArgs.gB(1, this.kSD);
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      if (this.kRY != null) {
        paramVarArgs.d(3, this.kRY);
      }
      if (this.kRS != null) {
        paramVarArgs.d(4, this.kRS);
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
      i = d.a.a.a.gy(1, this.kSD) + 0;
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRZ);
      }
      i = paramInt;
      if (this.kRY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRY);
      }
      paramInt = i;
    } while (this.kRS == null);
    return i + d.a.a.b.b.a.e(4, this.kRS);
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
      if (this.kRY == null) {
        throw new b("Not all required fields were included: IconURL");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locall.kSD = locala.xpH.oD();
        return 0;
      case 2: 
        locall.kRZ = locala.xpH.readString();
        return 0;
      case 3: 
        locall.kRY = locala.xpH.readString();
        return 0;
      }
      locall.kRS = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.l
 * JD-Core Version:    0.7.0.1
 */