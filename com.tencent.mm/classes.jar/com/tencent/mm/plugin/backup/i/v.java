package com.tencent.mm.plugin.backup.i;

public final class v
  extends com.tencent.mm.bv.a
{
  public String ID;
  public com.tencent.mm.bv.b hPF;
  public int hQP;
  public int hQQ;
  public int hQR;
  public int hQS;
  public int hQT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ID == null) {
        throw new d.a.a.b("Not all required fields were included: ID");
      }
      paramVarArgs.gB(1, this.hQP);
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.hPF != null) {
        paramVarArgs.b(3, this.hPF);
      }
      paramVarArgs.gB(4, this.hQQ);
      paramVarArgs.gB(5, this.hQR);
      paramVarArgs.gB(6, this.hQS);
      paramVarArgs.gB(7, this.hQT);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.hQP) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(3, this.hPF);
      }
      return i + d.a.a.a.gy(4, this.hQQ) + d.a.a.a.gy(5, this.hQR) + d.a.a.a.gy(6, this.hQS) + d.a.a.a.gy(7, this.hQT);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.ID == null) {
        throw new d.a.a.b("Not all required fields were included: ID");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localv.hQP = locala.xpH.oD();
        return 0;
      case 2: 
        localv.ID = locala.xpH.readString();
        return 0;
      case 3: 
        localv.hPF = locala.cUs();
        return 0;
      case 4: 
        localv.hQQ = locala.xpH.oD();
        return 0;
      case 5: 
        localv.hQR = locala.xpH.oD();
        return 0;
      case 6: 
        localv.hQS = locala.xpH.oD();
        return 0;
      }
      localv.hQT = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */