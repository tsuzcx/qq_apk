package com.tencent.mm.plugin.backup.i;

import d.a.a.b;
import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bv.a
{
  public String hPQ;
  public LinkedList<Long> hRn = new LinkedList();
  public LinkedList<String> hRo = new LinkedList();
  public LinkedList<String> hRp = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPQ == null) {
        throw new b("Not all required fields were included: BakChatName");
      }
      paramVarArgs.d(1, 3, this.hRn);
      paramVarArgs.d(2, 1, this.hRo);
      paramVarArgs.d(3, 1, this.hRp);
      if (this.hPQ != null) {
        paramVarArgs.d(4, this.hPQ);
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
      i = d.a.a.a.c(1, 3, this.hRn) + 0 + d.a.a.a.c(2, 1, this.hRo) + d.a.a.a.c(3, 1, this.hRp);
      paramInt = i;
    } while (this.hPQ == null);
    return i + d.a.a.b.b.a.e(4, this.hPQ);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hRn.clear();
      this.hRo.clear();
      this.hRp.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.hPQ == null) {
        throw new b("Not all required fields were included: BakChatName");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      ag localag = (ag)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localag.hRn.add(Long.valueOf(locala.xpH.oE()));
        return 0;
      case 2: 
        localag.hRo.add(locala.xpH.readString());
        return 0;
      case 3: 
        localag.hRp.add(locala.xpH.readString());
        return 0;
      }
      localag.hPQ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ag
 * JD-Core Version:    0.7.0.1
 */