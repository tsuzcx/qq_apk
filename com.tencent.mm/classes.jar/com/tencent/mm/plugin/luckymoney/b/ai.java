package com.tencent.mm.plugin.luckymoney.b;

public final class ai
  extends com.tencent.mm.bv.a
{
  public String content;
  public int dwF;
  public String iconUrl;
  public int lRN;
  public int lRO;
  public String name;
  public String type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.dwF);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.gB(5, this.lRN);
      if (this.iconUrl != null) {
        paramVarArgs.d(6, this.iconUrl);
      }
      paramVarArgs.gB(7, this.lRO);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.dwF) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.type);
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.content);
      }
      i = paramInt + d.a.a.a.gy(5, this.lRN);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.iconUrl);
      }
      return paramInt + d.a.a.a.gy(7, this.lRO);
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
      ai localai = (ai)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localai.dwF = locala.xpH.oD();
        return 0;
      case 2: 
        localai.name = locala.xpH.readString();
        return 0;
      case 3: 
        localai.type = locala.xpH.readString();
        return 0;
      case 4: 
        localai.content = locala.xpH.readString();
        return 0;
      case 5: 
        localai.lRN = locala.xpH.oD();
        return 0;
      case 6: 
        localai.iconUrl = locala.xpH.readString();
        return 0;
      }
      localai.lRO = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.ai
 * JD-Core Version:    0.7.0.1
 */