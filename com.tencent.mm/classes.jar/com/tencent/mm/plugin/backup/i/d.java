package com.tencent.mm.plugin.backup.i;

import d.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public String ID;
  public h hPG;
  public int hPH;
  public int hPI;
  public int hPJ;
  public int hPK;
  public int hPL;
  public int hPM;
  public int hPN;
  public int hPO;
  public int hPP;
  
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
      if (this.hPG != null)
      {
        paramVarArgs.gD(2, this.hPG.btq());
        this.hPG.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.hPH);
      paramVarArgs.gB(4, this.hPI);
      paramVarArgs.gB(5, this.hPJ);
      paramVarArgs.gB(6, this.hPK);
      paramVarArgs.gB(7, this.hPL);
      paramVarArgs.gB(8, this.hPM);
      paramVarArgs.gB(9, this.hPN);
      paramVarArgs.gB(10, this.hPO);
      paramVarArgs.gB(11, this.hPP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label707;
      }
    }
    label707:
    for (paramInt = d.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPG != null) {
        i = paramInt + d.a.a.a.gA(2, this.hPG.btq());
      }
      return i + d.a.a.a.gy(3, this.hPH) + d.a.a.a.gy(4, this.hPI) + d.a.a.a.gy(5, this.hPJ) + d.a.a.a.gy(6, this.hPK) + d.a.a.a.gy(7, this.hPL) + d.a.a.a.gy(8, this.hPM) + d.a.a.a.gy(9, this.hPN) + d.a.a.a.gy(10, this.hPO) + d.a.a.a.gy(11, this.hPP);
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locald.ID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((h)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locald.hPG = ((h)localObject1);
            paramInt += 1;
          }
        case 3: 
          locald.hPH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          locald.hPI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          locald.hPJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          locald.hPK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          locald.hPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          locald.hPM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          locald.hPN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          locald.hPO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        locald.hPP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.d
 * JD-Core Version:    0.7.0.1
 */