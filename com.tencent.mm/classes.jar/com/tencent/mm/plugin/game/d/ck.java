package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class ck
  extends com.tencent.mm.bv.a
{
  public int kVG;
  public String kVH;
  public String kVI;
  public boolean kVJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVI == null) {
        throw new b("Not all required fields were included: MediaURL");
      }
      paramVarArgs.gB(1, this.kVG);
      if (this.kVH != null) {
        paramVarArgs.d(2, this.kVH);
      }
      if (this.kVI != null) {
        paramVarArgs.d(3, this.kVI);
      }
      paramVarArgs.aA(4, this.kVJ);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.kVG) + 0;
      paramInt = i;
      if (this.kVH != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVH);
      }
      i = paramInt;
      if (this.kVI != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVI);
      }
      return i + (d.a.a.b.b.a.dQ(4) + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.kVI == null) {
        throw new b("Not all required fields were included: MediaURL");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ck localck = (ck)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localck.kVG = locala.xpH.oD();
        return 0;
      case 2: 
        localck.kVH = locala.xpH.readString();
        return 0;
      case 3: 
        localck.kVI = locala.xpH.readString();
        return 0;
      }
      localck.kVJ = locala.cUr();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ck
 * JD-Core Version:    0.7.0.1
 */