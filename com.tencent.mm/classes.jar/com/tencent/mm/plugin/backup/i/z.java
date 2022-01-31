package com.tencent.mm.plugin.backup.i;

import d.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bv.a
{
  public String hPQ;
  public LinkedList<String> hQI = new LinkedList();
  public long hRc;
  public long hRd;
  public String hRe;
  public String hRf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPQ == null) {
        throw new b("Not all required fields were included: BakChatName");
      }
      if (this.hRe == null) {
        throw new b("Not all required fields were included: MsgDataID");
      }
      if (this.hRf == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.hPQ != null) {
        paramVarArgs.d(1, this.hPQ);
      }
      paramVarArgs.Y(2, this.hRc);
      paramVarArgs.Y(3, this.hRd);
      if (this.hRe != null) {
        paramVarArgs.d(4, this.hRe);
      }
      if (this.hRf != null) {
        paramVarArgs.d(5, this.hRf);
      }
      paramVarArgs.d(6, 1, this.hQI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPQ == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = d.a.a.b.b.a.e(1, this.hPQ) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.hRc) + d.a.a.a.X(3, this.hRd);
      paramInt = i;
      if (this.hRe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.hRe);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hRf);
      }
      return i + d.a.a.a.c(6, 1, this.hQI);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hQI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hPQ == null) {
          throw new b("Not all required fields were included: BakChatName");
        }
        if (this.hRe == null) {
          throw new b("Not all required fields were included: MsgDataID");
        }
        if (this.hRf != null) {
          break;
        }
        throw new b("Not all required fields were included: NickName");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localz.hPQ = locala.xpH.readString();
          return 0;
        case 2: 
          localz.hRc = locala.xpH.oE();
          return 0;
        case 3: 
          localz.hRd = locala.xpH.oE();
          return 0;
        case 4: 
          localz.hRe = locala.xpH.readString();
          return 0;
        case 5: 
          localz.hRf = locala.xpH.readString();
          return 0;
        }
        localz.hQI.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */