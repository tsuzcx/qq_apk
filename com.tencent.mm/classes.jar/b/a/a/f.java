package b.a.a;

public final class f
  extends com.tencent.mm.bv.a
{
  public String tyu;
  public String tyv;
  public int tyw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tyu != null) {
        paramVarArgs.d(1, this.tyu);
      }
      if (this.tyv != null) {
        paramVarArgs.d(2, this.tyv);
      }
      paramVarArgs.gB(3, this.tyw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tyu == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.tyu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tyv != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tyv);
      }
      return i + d.a.a.a.gy(3, this.tyw);
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
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localf.tyu = locala.xpH.readString();
          return 0;
        case 2: 
          localf.tyv = locala.xpH.readString();
          return 0;
        }
        localf.tyw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     b.a.a.f
 * JD-Core Version:    0.7.0.1
 */