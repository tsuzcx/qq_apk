package b.a.a;

import java.util.LinkedList;

public final class a
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
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.xpi != null)
      {
        paramVarArgs.gD(5, this.xpi.btq());
        this.xpi.a(paramVarArgs);
      }
      if (this.teX != null) {
        paramVarArgs.d(6, this.teX);
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
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.xpi != null) {
        i = paramInt + d.a.a.a.gA(5, this.xpi.btq());
      }
      paramInt = i;
      if (this.teX != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.teX);
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
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locala.xpf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locala.xpg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locala.xph = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          locala.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((f)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locala.xpi = ((f)localObject1);
            paramInt += 1;
          }
        }
        locala.teX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     b.a.a.a
 * JD-Core Version:    0.7.0.1
 */