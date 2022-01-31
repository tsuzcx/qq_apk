package com.tencent.mm.plugin.collect.b;

import d.a.a.b;

public class t
  extends com.tencent.mm.bv.a
{
  public String bHY;
  public String bMY;
  public String dtK;
  public double iHP;
  public String iHQ;
  public int msgType;
  public int scene;
  public int status;
  public int timestamp;
  public String type;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username == null) {
        throw new b("Not all required fields were included: username");
      }
      if (this.bMY == null) {
        throw new b("Not all required fields were included: transactionId");
      }
      if (this.bHY == null) {
        throw new b("Not all required fields were included: feeType");
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.bMY != null) {
        paramVarArgs.d(2, this.bMY);
      }
      paramVarArgs.b(3, this.iHP);
      if (this.bHY != null) {
        paramVarArgs.d(4, this.bHY);
      }
      paramVarArgs.gB(5, this.timestamp);
      paramVarArgs.gB(6, this.scene);
      paramVarArgs.gB(7, this.status);
      if (this.dtK != null) {
        paramVarArgs.d(8, this.dtK);
      }
      if (this.iHQ != null) {
        paramVarArgs.d(9, this.iHQ);
      }
      paramVarArgs.gB(10, this.msgType);
      if (this.type != null) {
        paramVarArgs.d(11, this.type);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label757;
      }
    }
    label757:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bMY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bMY);
      }
      i += d.a.a.b.b.a.dQ(3) + 8;
      paramInt = i;
      if (this.bHY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bHY);
      }
      i = paramInt + d.a.a.a.gy(5, this.timestamp) + d.a.a.a.gy(6, this.scene) + d.a.a.a.gy(7, this.status);
      paramInt = i;
      if (this.dtK != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.dtK);
      }
      i = paramInt;
      if (this.iHQ != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.iHQ);
      }
      i += d.a.a.a.gy(10, this.msgType);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.type);
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
        if (this.username == null) {
          throw new b("Not all required fields were included: username");
        }
        if (this.bMY == null) {
          throw new b("Not all required fields were included: transactionId");
        }
        if (this.bHY != null) {
          break;
        }
        throw new b("Not all required fields were included: feeType");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localt.username = locala.xpH.readString();
          return 0;
        case 2: 
          localt.bMY = locala.xpH.readString();
          return 0;
        case 3: 
          localt.iHP = locala.xpH.readDouble();
          return 0;
        case 4: 
          localt.bHY = locala.xpH.readString();
          return 0;
        case 5: 
          localt.timestamp = locala.xpH.oD();
          return 0;
        case 6: 
          localt.scene = locala.xpH.oD();
          return 0;
        case 7: 
          localt.status = locala.xpH.oD();
          return 0;
        case 8: 
          localt.dtK = locala.xpH.readString();
          return 0;
        case 9: 
          localt.iHQ = locala.xpH.readString();
          return 0;
        case 10: 
          localt.msgType = locala.xpH.oD();
          return 0;
        }
        localt.type = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.t
 * JD-Core Version:    0.7.0.1
 */