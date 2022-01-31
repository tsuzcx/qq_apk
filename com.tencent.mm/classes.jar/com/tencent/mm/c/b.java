package com.tencent.mm.c;

public final class b
  extends com.tencent.mm.bv.a
{
  public String apkMd5;
  public int bvj;
  public String bvk;
  public int bvl;
  public String bvm;
  public String bvn;
  public boolean bvo;
  public int bvp;
  public boolean bvq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.apkMd5 == null) {
        throw new d.a.a.b("Not all required fields were included: apkMd5");
      }
      if (this.apkMd5 != null) {
        paramVarArgs.d(1, this.apkMd5);
      }
      paramVarArgs.gC(2, this.bvj);
      if (this.bvk != null) {
        paramVarArgs.d(3, this.bvk);
      }
      paramVarArgs.gC(4, this.bvl);
      if (this.bvm != null) {
        paramVarArgs.d(5, this.bvm);
      }
      if (this.bvn != null) {
        paramVarArgs.d(6, this.bvn);
      }
      paramVarArgs.aA(7, this.bvo);
      paramVarArgs.gC(8, this.bvp);
      paramVarArgs.aA(9, this.bvq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.apkMd5 == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = d.a.a.a.e(1, this.apkMd5) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gz(2, this.bvj);
      paramInt = i;
      if (this.bvk != null) {
        paramInt = i + d.a.a.a.e(3, this.bvk);
      }
      i = paramInt + d.a.a.a.gz(4, this.bvl);
      paramInt = i;
      if (this.bvm != null) {
        paramInt = i + d.a.a.a.e(5, this.bvm);
      }
      i = paramInt;
      if (this.bvn != null) {
        i = paramInt + d.a.a.a.e(6, this.bvn);
      }
      return i + d.a.a.a.KM(7) + d.a.a.a.gz(8, this.bvp) + d.a.a.a.KM(9);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs);; paramInt = com.tencent.mm.bv.a.a(paramVarArgs))
        {
          if (paramInt <= 0)
          {
            if (this.apkMd5 != null) {
              break;
            }
            throw new d.a.a.b("Not all required fields were included: apkMd5");
          }
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
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
          localb.apkMd5 = locala.cUq();
          return 0;
        case 2: 
          localb.bvj = locala.cUo();
          return 0;
        case 3: 
          localb.bvk = locala.cUq();
          return 0;
        case 4: 
          localb.bvl = locala.cUo();
          return 0;
        case 5: 
          localb.bvm = locala.cUq();
          return 0;
        case 6: 
          localb.bvn = locala.cUq();
          return 0;
        case 7: 
          localb.bvo = locala.cUr();
          return 0;
        case 8: 
          localb.bvp = locala.cUo();
          return 0;
        }
        localb.bvq = locala.cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.c.b
 * JD-Core Version:    0.7.0.1
 */