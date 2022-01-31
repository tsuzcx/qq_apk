package com.tencent.mm.plugin.backup.i;

public final class u
  extends com.tencent.mm.bv.a
{
  public String bUi;
  public String cQM;
  public int hQM;
  public int hQN;
  public long hQO;
  public String path;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQM);
      if (this.cQM != null) {
        paramVarArgs.d(2, this.cQM);
      }
      if (this.bUi != null) {
        paramVarArgs.d(3, this.bUi);
      }
      if (this.path != null) {
        paramVarArgs.d(4, this.path);
      }
      paramVarArgs.gB(5, this.type);
      paramVarArgs.gB(6, this.hQN);
      paramVarArgs.Y(7, this.hQO);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.hQM) + 0;
      paramInt = i;
      if (this.cQM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.cQM);
      }
      i = paramInt;
      if (this.bUi != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bUi);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.path);
      }
      return paramInt + d.a.a.a.gy(5, this.type) + d.a.a.a.gy(6, this.hQN) + d.a.a.a.X(7, this.hQO);
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
      u localu = (u)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localu.hQM = locala.xpH.oD();
        return 0;
      case 2: 
        localu.cQM = locala.xpH.readString();
        return 0;
      case 3: 
        localu.bUi = locala.xpH.readString();
        return 0;
      case 4: 
        localu.path = locala.xpH.readString();
        return 0;
      case 5: 
        localu.type = locala.xpH.oD();
        return 0;
      case 6: 
        localu.hQN = locala.xpH.oD();
        return 0;
      }
      localu.hQO = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.u
 * JD-Core Version:    0.7.0.1
 */