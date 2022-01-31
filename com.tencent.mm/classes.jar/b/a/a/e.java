package b.a.a;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public b xpA;
  public b xpB;
  public String xpt;
  public String xpu;
  public String xpv;
  public String xpw;
  public String xpx;
  public int xpy;
  public d xpz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.xpt != null) {
        paramVarArgs.d(1, this.xpt);
      }
      if (this.xpu != null) {
        paramVarArgs.d(2, this.xpu);
      }
      if (this.xpv != null) {
        paramVarArgs.d(3, this.xpv);
      }
      if (this.xpw != null) {
        paramVarArgs.d(4, this.xpw);
      }
      if (this.xpx != null) {
        paramVarArgs.d(5, this.xpx);
      }
      paramVarArgs.gB(6, this.xpy);
      if (this.xpz != null)
      {
        paramVarArgs.gD(7, this.xpz.btq());
        this.xpz.a(paramVarArgs);
      }
      if (this.xpA != null) {
        paramVarArgs.b(8, this.xpA);
      }
      if (this.xpB != null) {
        paramVarArgs.b(9, this.xpB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpt == null) {
        break label699;
      }
    }
    label699:
    for (int i = d.a.a.b.b.a.e(1, this.xpt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xpu != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.xpu);
      }
      i = paramInt;
      if (this.xpv != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.xpv);
      }
      paramInt = i;
      if (this.xpw != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.xpw);
      }
      i = paramInt;
      if (this.xpx != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.xpx);
      }
      i += d.a.a.a.gy(6, this.xpy);
      paramInt = i;
      if (this.xpz != null) {
        paramInt = i + d.a.a.a.gA(7, this.xpz.btq());
      }
      i = paramInt;
      if (this.xpA != null) {
        i = paramInt + d.a.a.a.a(8, this.xpA);
      }
      paramInt = i;
      if (this.xpB != null) {
        paramInt = i + d.a.a.a.a(9, this.xpB);
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
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locale.xpt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locale.xpu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locale.xpv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locale.xpw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          locale.xpx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          locale.xpy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locale.xpz = ((d)localObject1);
            paramInt += 1;
          }
        case 8: 
          locale.xpA = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        locale.xpB = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     b.a.a.e
 * JD-Core Version:    0.7.0.1
 */