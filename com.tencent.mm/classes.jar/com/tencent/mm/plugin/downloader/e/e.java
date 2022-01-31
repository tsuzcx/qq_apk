package com.tencent.mm.plugin.downloader.e;

import d.a.a.b;

public final class e
  extends com.tencent.mm.bv.a
{
  public int apptype;
  public String bOL;
  public String dRQ;
  public String iQn;
  public String iQo;
  public int status;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL == null) {
        throw new b("Not all required fields were included: appid");
      }
      if (this.dRQ == null) {
        throw new b("Not all required fields were included: appname");
      }
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.dRQ != null) {
        paramVarArgs.d(2, this.dRQ);
      }
      if (this.iQn != null) {
        paramVarArgs.d(3, this.iQn);
      }
      if (this.iQo != null) {
        paramVarArgs.d(4, this.iQo);
      }
      paramVarArgs.gB(5, this.apptype);
      paramVarArgs.gB(6, this.status);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label486;
      }
    }
    label486:
    for (int i = d.a.a.b.b.a.e(1, this.bOL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dRQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.dRQ);
      }
      i = paramInt;
      if (this.iQn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQn);
      }
      paramInt = i;
      if (this.iQo != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQo);
      }
      return paramInt + d.a.a.a.gy(5, this.apptype) + d.a.a.a.gy(6, this.status);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bOL == null) {
          throw new b("Not all required fields were included: appid");
        }
        if (this.dRQ != null) {
          break;
        }
        throw new b("Not all required fields were included: appname");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locale.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          locale.dRQ = locala.xpH.readString();
          return 0;
        case 3: 
          locale.iQn = locala.xpH.readString();
          return 0;
        case 4: 
          locale.iQo = locala.xpH.readString();
          return 0;
        case 5: 
          locale.apptype = locala.xpH.oD();
          return 0;
        }
        locale.status = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.e
 * JD-Core Version:    0.7.0.1
 */