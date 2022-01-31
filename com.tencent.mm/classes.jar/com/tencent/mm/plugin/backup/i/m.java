package com.tencent.mm.plugin.backup.i;

import d.a.a.b;

public final class m
  extends com.tencent.mm.bv.a
{
  public String hQb;
  public String hQc;
  public String hQd;
  public String hQe;
  public String hQf;
  public int hQg;
  public long hQh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hQb == null) {
        throw new b("Not all required fields were included: DeviceID");
      }
      if (this.hQc == null) {
        throw new b("Not all required fields were included: DeviceName");
      }
      if (this.hQd == null) {
        throw new b("Not all required fields were included: Model");
      }
      if (this.hQe == null) {
        throw new b("Not all required fields were included: SystemName");
      }
      if (this.hQf == null) {
        throw new b("Not all required fields were included: SystemVersion");
      }
      if (this.hQb != null) {
        paramVarArgs.d(1, this.hQb);
      }
      if (this.hQc != null) {
        paramVarArgs.d(2, this.hQc);
      }
      if (this.hQd != null) {
        paramVarArgs.d(3, this.hQd);
      }
      if (this.hQe != null) {
        paramVarArgs.d(4, this.hQe);
      }
      if (this.hQf != null) {
        paramVarArgs.d(5, this.hQf);
      }
      paramVarArgs.gB(6, this.hQg);
      paramVarArgs.Y(7, this.hQh);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQb == null) {
        break label645;
      }
    }
    label645:
    for (int i = d.a.a.b.b.a.e(1, this.hQb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hQc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hQc);
      }
      i = paramInt;
      if (this.hQd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hQd);
      }
      paramInt = i;
      if (this.hQe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hQe);
      }
      i = paramInt;
      if (this.hQf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hQf);
      }
      return i + d.a.a.a.gy(6, this.hQg) + d.a.a.a.X(7, this.hQh);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hQb == null) {
          throw new b("Not all required fields were included: DeviceID");
        }
        if (this.hQc == null) {
          throw new b("Not all required fields were included: DeviceName");
        }
        if (this.hQd == null) {
          throw new b("Not all required fields were included: Model");
        }
        if (this.hQe == null) {
          throw new b("Not all required fields were included: SystemName");
        }
        if (this.hQf != null) {
          break;
        }
        throw new b("Not all required fields were included: SystemVersion");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localm.hQb = locala.xpH.readString();
          return 0;
        case 2: 
          localm.hQc = locala.xpH.readString();
          return 0;
        case 3: 
          localm.hQd = locala.xpH.readString();
          return 0;
        case 4: 
          localm.hQe = locala.xpH.readString();
          return 0;
        case 5: 
          localm.hQf = locala.xpH.readString();
          return 0;
        case 6: 
          localm.hQg = locala.xpH.oD();
          return 0;
        }
        localm.hQh = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.m
 * JD-Core Version:    0.7.0.1
 */