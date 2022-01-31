package b.a.a;

import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public int tPH;
  public String url;
  public f xpi;
  public String xpj;
  public String xpk;
  public String xpl;
  public String xpm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.xpi != null)
      {
        paramVarArgs.gD(1, this.xpi.btq());
        this.xpi.a(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.xpj != null) {
        paramVarArgs.d(3, this.xpj);
      }
      if (this.xpk != null) {
        paramVarArgs.d(4, this.xpk);
      }
      paramVarArgs.gB(5, this.tPH);
      if (this.xpl != null) {
        paramVarArgs.d(6, this.xpl);
      }
      if (this.xpm != null) {
        paramVarArgs.d(7, this.xpm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpi == null) {
        break label591;
      }
    }
    label591:
    for (int i = d.a.a.a.gA(1, this.xpi.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.xpj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.xpj);
      }
      paramInt = i;
      if (this.xpk != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.xpk);
      }
      i = paramInt + d.a.a.a.gy(5, this.tPH);
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.xpl);
      }
      i = paramInt;
      if (this.xpm != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.xpm);
      }
      return i;
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localb.xpi = ((f)localObject1);
            paramInt += 1;
          }
        case 2: 
          localb.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localb.xpj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localb.xpk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localb.tPH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localb.xpl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localb.xpm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     b.a.a.b
 * JD-Core Version:    0.7.0.1
 */