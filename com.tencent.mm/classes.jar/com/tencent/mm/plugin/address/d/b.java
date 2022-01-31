package com.tencent.mm.plugin.address.d;

public final class b
  extends com.tencent.mm.bv.a
{
  public String ftB;
  public String ftC;
  public String ftD;
  public String ftE;
  public String ftF;
  public String ftG;
  public String ftH;
  public String ftI;
  public String ftJ;
  public int id;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.id);
      if (this.ftB != null) {
        paramVarArgs.d(2, this.ftB);
      }
      if (this.ftC != null) {
        paramVarArgs.d(3, this.ftC);
      }
      if (this.ftD != null) {
        paramVarArgs.d(4, this.ftD);
      }
      if (this.ftE != null) {
        paramVarArgs.d(5, this.ftE);
      }
      if (this.ftF != null) {
        paramVarArgs.d(6, this.ftF);
      }
      if (this.ftG != null) {
        paramVarArgs.d(7, this.ftG);
      }
      if (this.ftH != null) {
        paramVarArgs.d(8, this.ftH);
      }
      if (this.ftI != null) {
        paramVarArgs.d(9, this.ftI);
      }
      if (this.ftJ != null) {
        paramVarArgs.d(10, this.ftJ);
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
      i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.ftB != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ftB);
      }
      i = paramInt;
      if (this.ftC != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ftC);
      }
      paramInt = i;
      if (this.ftD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ftD);
      }
      i = paramInt;
      if (this.ftE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ftE);
      }
      paramInt = i;
      if (this.ftF != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ftF);
      }
      i = paramInt;
      if (this.ftG != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.ftG);
      }
      paramInt = i;
      if (this.ftH != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.ftH);
      }
      i = paramInt;
      if (this.ftI != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.ftI);
      }
      paramInt = i;
    } while (this.ftJ == null);
    return i + d.a.a.b.b.a.e(10, this.ftJ);
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
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.id = locala.xpH.oD();
        return 0;
      case 2: 
        localb.ftB = locala.xpH.readString();
        return 0;
      case 3: 
        localb.ftC = locala.xpH.readString();
        return 0;
      case 4: 
        localb.ftD = locala.xpH.readString();
        return 0;
      case 5: 
        localb.ftE = locala.xpH.readString();
        return 0;
      case 6: 
        localb.ftF = locala.xpH.readString();
        return 0;
      case 7: 
        localb.ftG = locala.xpH.readString();
        return 0;
      case 8: 
        localb.ftH = locala.xpH.readString();
        return 0;
      case 9: 
        localb.ftI = locala.xpH.readString();
        return 0;
      }
      localb.ftJ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */