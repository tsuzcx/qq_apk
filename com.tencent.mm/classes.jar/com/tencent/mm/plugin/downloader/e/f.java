package com.tencent.mm.plugin.downloader.e;

import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bv.a
{
  public String iQp;
  public LinkedList<String> iQq = new LinkedList();
  public String iQr;
  public String iQs;
  public LinkedList<String> iQt = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iQp != null) {
        paramVarArgs.d(1, this.iQp);
      }
      paramVarArgs.d(2, 1, this.iQq);
      if (this.iQr != null) {
        paramVarArgs.d(3, this.iQr);
      }
      if (this.iQs != null) {
        paramVarArgs.d(4, this.iQs);
      }
      paramVarArgs.d(5, 1, this.iQt);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iQp == null) {
        break label391;
      }
    }
    label391:
    for (paramInt = d.a.a.b.b.a.e(1, this.iQp) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 1, this.iQq);
      paramInt = i;
      if (this.iQr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iQr);
      }
      i = paramInt;
      if (this.iQs != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.iQs);
      }
      return i + d.a.a.a.c(5, 1, this.iQt);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iQq.clear();
        this.iQt.clear();
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
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localf.iQp = locala.xpH.readString();
          return 0;
        case 2: 
          localf.iQq.add(locala.xpH.readString());
          return 0;
        case 3: 
          localf.iQr = locala.xpH.readString();
          return 0;
        case 4: 
          localf.iQs = locala.xpH.readString();
          return 0;
        }
        localf.iQt.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.f
 * JD-Core Version:    0.7.0.1
 */