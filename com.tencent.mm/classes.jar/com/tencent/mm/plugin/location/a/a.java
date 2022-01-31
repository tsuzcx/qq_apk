package com.tencent.mm.plugin.location.a;

import d.a.a.b;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> bSX = new LinkedList();
  public String lCF;
  public double latitude;
  public double longitude;
  public long timestamp;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username == null) {
        throw new b("Not all required fields were included: username");
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.d(2, 1, this.bSX);
      paramVarArgs.b(3, this.longitude);
      paramVarArgs.b(4, this.latitude);
      if (this.lCF != null) {
        paramVarArgs.d(5, this.lCF);
      }
      paramVarArgs.Y(6, this.timestamp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label430;
      }
    }
    label430:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 1, this.bSX) + (d.a.a.b.b.a.dQ(3) + 8) + (d.a.a.b.b.a.dQ(4) + 8);
      paramInt = i;
      if (this.lCF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.lCF);
      }
      return paramInt + d.a.a.a.X(6, this.timestamp);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.bSX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.username != null) {
          break;
        }
        throw new b("Not all required fields were included: username");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locala1.username = locala.xpH.readString();
          return 0;
        case 2: 
          locala1.bSX.add(locala.xpH.readString());
          return 0;
        case 3: 
          locala1.longitude = locala.xpH.readDouble();
          return 0;
        case 4: 
          locala1.latitude = locala.xpH.readDouble();
          return 0;
        case 5: 
          locala1.lCF = locala.xpH.readString();
          return 0;
        }
        locala1.timestamp = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.a.a
 * JD-Core Version:    0.7.0.1
 */