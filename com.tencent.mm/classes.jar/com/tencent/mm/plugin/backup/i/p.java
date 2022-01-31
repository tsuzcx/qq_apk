package com.tencent.mm.plugin.backup.i;

import d.a.a.b;

public final class p
  extends com.tencent.mm.bv.a
{
  public String ID;
  public long hQp;
  public int hQs;
  public int hQt;
  public int hQu;
  public long hQv;
  public long hQw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ID == null) {
        throw new b("Not all required fields were included: ID");
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.gB(2, this.hQs);
      paramVarArgs.gB(3, this.hQt);
      paramVarArgs.gB(4, this.hQu);
      paramVarArgs.Y(5, this.hQp);
      paramVarArgs.Y(6, this.hQv);
      paramVarArgs.Y(7, this.hQw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = d.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.hQs) + d.a.a.a.gy(3, this.hQt) + d.a.a.a.gy(4, this.hQu) + d.a.a.a.X(5, this.hQp) + d.a.a.a.X(6, this.hQv) + d.a.a.a.X(7, this.hQw);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ID != null) {
          break;
        }
        throw new b("Not all required fields were included: ID");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localp.ID = locala.xpH.readString();
          return 0;
        case 2: 
          localp.hQs = locala.xpH.oD();
          return 0;
        case 3: 
          localp.hQt = locala.xpH.oD();
          return 0;
        case 4: 
          localp.hQu = locala.xpH.oD();
          return 0;
        case 5: 
          localp.hQp = locala.xpH.oE();
          return 0;
        case 6: 
          localp.hQv = locala.xpH.oE();
          return 0;
        }
        localp.hQw = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */