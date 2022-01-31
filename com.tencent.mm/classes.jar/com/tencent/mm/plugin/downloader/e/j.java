package com.tencent.mm.plugin.downloader.e;

public final class j
  extends com.tencent.mm.bv.a
{
  public boolean iQB;
  public String iQC;
  public String iQD;
  public String iQE;
  public int iQF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aA(1, this.iQB);
      if (this.iQC != null) {
        paramVarArgs.d(2, this.iQC);
      }
      if (this.iQD != null) {
        paramVarArgs.d(3, this.iQD);
      }
      if (this.iQE != null) {
        paramVarArgs.d(4, this.iQE);
      }
      paramVarArgs.gB(5, this.iQF);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.b.b.a.dQ(1) + 1 + 0;
      paramInt = i;
      if (this.iQC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.iQC);
      }
      i = paramInt;
      if (this.iQD != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQD);
      }
      paramInt = i;
      if (this.iQE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQE);
      }
      return paramInt + d.a.a.a.gy(5, this.iQF);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localj.iQB = locala.cUr();
        return 0;
      case 2: 
        localj.iQC = locala.xpH.readString();
        return 0;
      case 3: 
        localj.iQD = locala.xpH.readString();
        return 0;
      case 4: 
        localj.iQE = locala.xpH.readString();
        return 0;
      }
      localj.iQF = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.j
 * JD-Core Version:    0.7.0.1
 */