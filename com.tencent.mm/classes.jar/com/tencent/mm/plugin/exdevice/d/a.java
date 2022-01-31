package com.tencent.mm.plugin.exdevice.d;

public final class a
  extends com.tencent.mm.bv.a
{
  public int jwX;
  public String jwY;
  public String jwZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.jwX);
      if (this.jwY != null) {
        paramVarArgs.d(2, this.jwY);
      }
      if (this.jwZ != null) {
        paramVarArgs.d(3, this.jwZ);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.jwX) + 0;
      paramInt = i;
      if (this.jwY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.jwY);
      }
      i = paramInt;
    } while (this.jwZ == null);
    return paramInt + d.a.a.b.b.a.e(3, this.jwZ);
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
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locala1.jwX = locala.xpH.oD();
        return 0;
      case 2: 
        locala1.jwY = locala.xpH.readString();
        return 0;
      }
      locala1.jwZ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.d.a
 * JD-Core Version:    0.7.0.1
 */