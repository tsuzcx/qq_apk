package b.a.a;

public final class g
  extends com.tencent.mm.bv.a
{
  public String mTc;
  public String xpC;
  public String xpD;
  public String xpE;
  public String xpF;
  public String xpG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mTc != null) {
        paramVarArgs.d(1, this.mTc);
      }
      if (this.xpC != null) {
        paramVarArgs.d(2, this.xpC);
      }
      if (this.xpD != null) {
        paramVarArgs.d(3, this.xpD);
      }
      if (this.xpE != null) {
        paramVarArgs.d(4, this.xpE);
      }
      if (this.xpF != null) {
        paramVarArgs.d(5, this.xpF);
      }
      if (this.xpG != null) {
        paramVarArgs.d(6, this.xpG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.mTc == null) {
        break label454;
      }
    }
    label454:
    for (int i = d.a.a.b.b.a.e(1, this.mTc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xpC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.xpC);
      }
      i = paramInt;
      if (this.xpD != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.xpD);
      }
      paramInt = i;
      if (this.xpE != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.xpE);
      }
      i = paramInt;
      if (this.xpF != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.xpF);
      }
      paramInt = i;
      if (this.xpG != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.xpG);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localg.mTc = locala.xpH.readString();
          return 0;
        case 2: 
          localg.xpC = locala.xpH.readString();
          return 0;
        case 3: 
          localg.xpD = locala.xpH.readString();
          return 0;
        case 4: 
          localg.xpE = locala.xpH.readString();
          return 0;
        case 5: 
          localg.xpF = locala.xpH.readString();
          return 0;
        }
        localg.xpG = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     b.a.a.g
 * JD-Core Version:    0.7.0.1
 */