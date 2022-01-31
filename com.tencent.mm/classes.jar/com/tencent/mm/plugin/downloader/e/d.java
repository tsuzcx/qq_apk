package com.tencent.mm.plugin.downloader.e;

import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public String dlQ;
  public String iQe;
  public long iQf;
  public String iQg;
  public int iQh;
  public int iQi;
  public String iQj;
  public l iQk;
  public String iQl;
  public String iQm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.iQe != null) {
        paramVarArgs.d(2, this.iQe);
      }
      paramVarArgs.Y(3, this.iQf);
      if (this.iQg != null) {
        paramVarArgs.d(4, this.iQg);
      }
      paramVarArgs.gB(6, this.iQh);
      paramVarArgs.gB(7, this.iQi);
      if (this.iQj != null) {
        paramVarArgs.d(8, this.iQj);
      }
      if (this.iQk != null)
      {
        paramVarArgs.gD(9, this.iQk.btq());
        this.iQk.a(paramVarArgs);
      }
      if (this.iQl != null) {
        paramVarArgs.d(10, this.iQl);
      }
      if (this.iQm != null) {
        paramVarArgs.d(11, this.iQm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = d.a.a.b.b.a.e(1, this.dlQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iQe != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.iQe);
      }
      i += d.a.a.a.X(3, this.iQf);
      paramInt = i;
      if (this.iQg != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQg);
      }
      i = paramInt + d.a.a.a.gy(6, this.iQh) + d.a.a.a.gy(7, this.iQi);
      paramInt = i;
      if (this.iQj != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.iQj);
      }
      i = paramInt;
      if (this.iQk != null) {
        i = paramInt + d.a.a.a.gA(9, this.iQk.btq());
      }
      paramInt = i;
      if (this.iQl != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.iQl);
      }
      i = paramInt;
      if (this.iQm != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.iQm);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          return -1;
        case 1: 
          locald.dlQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locald.iQe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locald.iQf = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          locald.iQg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          locald.iQh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          locald.iQi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          locald.iQj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((l)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locald.iQk = ((l)localObject1);
            paramInt += 1;
          }
        case 10: 
          locald.iQl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        locald.iQm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.d
 * JD-Core Version:    0.7.0.1
 */