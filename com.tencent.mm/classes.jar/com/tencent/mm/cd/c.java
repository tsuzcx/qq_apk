package com.tencent.mm.cd;

public final class c
  extends com.tencent.mm.bv.a
{
  public int ebL;
  public int hxt;
  public int hxu;
  public int hxv;
  public int size;
  public int ukX = -1;
  public int ukY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hxt);
      paramVarArgs.gB(2, this.hxu);
      paramVarArgs.gB(3, this.hxv);
      paramVarArgs.gB(41, this.ukX);
      paramVarArgs.gB(5, this.ukY);
      paramVarArgs.gB(6, this.ebL);
      paramVarArgs.gB(7, this.size);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.hxt) + 0 + d.a.a.a.gy(2, this.hxu) + d.a.a.a.gy(3, this.hxv) + d.a.a.a.gy(41, this.ukX) + d.a.a.a.gy(5, this.ukY) + d.a.a.a.gy(6, this.ebL) + d.a.a.a.gy(7, this.size);
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
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localc.hxt = locala.xpH.oD();
        return 0;
      case 2: 
        localc.hxu = locala.xpH.oD();
        return 0;
      case 3: 
        localc.hxv = locala.xpH.oD();
        return 0;
      case 41: 
        localc.ukX = locala.xpH.oD();
        return 0;
      case 5: 
        localc.ukY = locala.xpH.oD();
        return 0;
      case 6: 
        localc.ebL = locala.xpH.oD();
        return 0;
      }
      localc.size = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cd.c
 * JD-Core Version:    0.7.0.1
 */