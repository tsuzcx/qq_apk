package b.a.a;

import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public String teX;
  public String url;
  public String xpf;
  public String xpg;
  public int xph;
  public f xpi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.xpf != null) {
        paramVarArgs.d(1, this.xpf);
      }
      if (this.xpg != null) {
        paramVarArgs.d(2, this.xpg);
      }
      paramVarArgs.gB(3, this.xph);
      if (this.teX != null) {
        paramVarArgs.d(4, this.teX);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.xpi != null)
      {
        paramVarArgs.gD(6, this.xpi.btq());
        this.xpi.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpf == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = d.a.a.b.b.a.e(1, this.xpf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xpg != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.xpg);
      }
      i += d.a.a.a.gy(3, this.xph);
      paramInt = i;
      if (this.teX != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.teX);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.url);
      }
      paramInt = i;
      if (this.xpi != null) {
        paramInt = i + d.a.a.a.gA(6, this.xpi.btq());
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locald.xpf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locald.xpg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locald.xph = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          locald.teX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          locald.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((f)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locald.xpi = ((f)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     b.a.a.d
 * JD-Core Version:    0.7.0.1
 */