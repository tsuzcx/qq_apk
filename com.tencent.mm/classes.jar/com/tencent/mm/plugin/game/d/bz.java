package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class bz
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kVs;
  public LinkedList<String> kVt = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kVs != null) {
        paramVarArgs.d(2, this.kVs);
      }
      paramVarArgs.d(3, 1, this.kVt);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label285;
      }
    }
    label285:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kVs);
      }
      return i + d.a.a.a.c(3, 1, this.kVt);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kVt.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        bz localbz = (bz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbz.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localbz.kVs = locala.xpH.readString();
          return 0;
        }
        localbz.kVt.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bz
 * JD-Core Version:    0.7.0.1
 */