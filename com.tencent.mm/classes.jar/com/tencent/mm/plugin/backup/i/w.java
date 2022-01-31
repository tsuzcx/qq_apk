package com.tencent.mm.plugin.backup.i;

public final class w
  extends com.tencent.mm.bv.a
{
  public String ID;
  public com.tencent.mm.bv.b hPF;
  public int hQP;
  public int hQQ;
  public int hQR;
  public int hQS;
  public com.tencent.mm.bv.b hQU;
  public int hQq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ID == null) {
        throw new d.a.a.b("Not all required fields were included: ID");
      }
      paramVarArgs.gB(1, this.hQP);
      paramVarArgs.gB(2, this.hQq);
      if (this.ID != null) {
        paramVarArgs.d(3, this.ID);
      }
      if (this.hPF != null) {
        paramVarArgs.b(4, this.hPF);
      }
      paramVarArgs.gB(5, this.hQQ);
      paramVarArgs.gB(6, this.hQR);
      paramVarArgs.gB(7, this.hQS);
      if (this.hQU != null) {
        paramVarArgs.b(8, this.hQU);
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
      i = d.a.a.a.gy(1, this.hQP) + 0 + d.a.a.a.gy(2, this.hQq);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.ID);
      }
      i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(4, this.hPF);
      }
      i = i + d.a.a.a.gy(5, this.hQQ) + d.a.a.a.gy(6, this.hQR) + d.a.a.a.gy(7, this.hQS);
      paramInt = i;
    } while (this.hQU == null);
    return i + d.a.a.a.a(8, this.hQU);
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
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localw.hQP = locala.xpH.oD();
        return 0;
      case 2: 
        localw.hQq = locala.xpH.oD();
        return 0;
      case 3: 
        localw.ID = locala.xpH.readString();
        return 0;
      case 4: 
        localw.hPF = locala.cUs();
        return 0;
      case 5: 
        localw.hQQ = locala.xpH.oD();
        return 0;
      case 6: 
        localw.hQR = locala.xpH.oD();
        return 0;
      case 7: 
        localw.hQS = locala.xpH.oD();
        return 0;
      }
      localw.hQU = locala.cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */