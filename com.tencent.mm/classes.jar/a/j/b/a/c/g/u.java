package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

final class u
  extends d
{
  private static final int[] CrV;
  private final int CrW;
  private final d CrX;
  private final d CrY;
  private final int CrZ;
  private final int Csa;
  private int pJe;
  
  static
  {
    AppMethodBeat.i(121619);
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    CrV = new int[localArrayList.size()];
    i = 0;
    while (i < CrV.length)
    {
      CrV[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(121619);
  }
  
  private u(d paramd1, d paramd2)
  {
    AppMethodBeat.i(121605);
    this.pJe = 0;
    this.CrX = paramd1;
    this.CrY = paramd2;
    this.CrZ = paramd1.size();
    this.CrW = (this.CrZ + paramd2.size());
    this.Csa = (Math.max(paramd1.emq(), paramd2.emq()) + 1);
    AppMethodBeat.o(121605);
  }
  
  static d a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(121606);
    Object localObject;
    int i;
    if ((paramd1 instanceof u))
    {
      localObject = (u)paramd1;
      if (paramd2.size() == 0) {
        break label298;
      }
      if (paramd1.size() == 0) {
        break label293;
      }
      i = paramd1.size() + paramd2.size();
      if (i >= 128) {
        break label68;
      }
      paramd1 = b(paramd1, paramd2);
    }
    label293:
    label298:
    for (;;)
    {
      AppMethodBeat.o(121606);
      return paramd1;
      localObject = null;
      break;
      label68:
      if ((localObject != null) && (((u)localObject).CrY.size() + paramd2.size() < 128))
      {
        paramd1 = b(((u)localObject).CrY, paramd2);
        paramd1 = new u(((u)localObject).CrX, paramd1);
      }
      else if ((localObject != null) && (((u)localObject).CrX.emq() > ((u)localObject).CrY.emq()) && (((u)localObject).Csa > paramd2.emq()))
      {
        paramd1 = new u(((u)localObject).CrY, paramd2);
        paramd1 = new u(((u)localObject).CrX, paramd1);
      }
      else
      {
        int j = Math.max(paramd1.emq(), paramd2.emq());
        if (i >= CrV[(j + 1)])
        {
          paramd1 = new u(paramd1, paramd2);
        }
        else
        {
          localObject = new u.a((byte)0);
          ((u.a)localObject).f(paramd1);
          ((u.a)localObject).f(paramd2);
          for (paramd2 = (d)((u.a)localObject).Csb.pop();; paramd2 = new u((d)((u.a)localObject).Csb.pop(), paramd2, (byte)0))
          {
            paramd1 = paramd2;
            if (((u.a)localObject).Csb.isEmpty()) {
              break;
            }
          }
          paramd1 = paramd2;
        }
      }
    }
  }
  
  private static p b(d paramd1, d paramd2)
  {
    AppMethodBeat.i(121607);
    int i = paramd1.size();
    int j = paramd2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramd1.h(arrayOfByte, 0, 0, i);
    paramd2.h(arrayOfByte, 0, i, j);
    paramd1 = new p(arrayOfByte);
    AppMethodBeat.o(121607);
    return paramd1;
  }
  
  protected final int aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121612);
    if (paramInt2 + paramInt3 <= this.CrZ)
    {
      paramInt1 = this.CrX.aQ(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(121612);
      return paramInt1;
    }
    if (paramInt2 >= this.CrZ)
    {
      paramInt1 = this.CrY.aQ(paramInt1, paramInt2 - this.CrZ, paramInt3);
      AppMethodBeat.o(121612);
      return paramInt1;
    }
    int i = this.CrZ - paramInt2;
    paramInt1 = this.CrX.aQ(paramInt1, paramInt2, i);
    paramInt1 = this.CrY.aQ(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(121612);
    return paramInt1;
  }
  
  protected final int aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121615);
    if (paramInt2 + paramInt3 <= this.CrZ)
    {
      paramInt1 = this.CrX.aR(paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(121615);
      return paramInt1;
    }
    if (paramInt2 >= this.CrZ)
    {
      paramInt1 = this.CrY.aR(paramInt1, paramInt2 - this.CrZ, paramInt3);
      AppMethodBeat.o(121615);
      return paramInt1;
    }
    int i = this.CrZ - paramInt2;
    paramInt1 = this.CrX.aR(paramInt1, paramInt2, i);
    paramInt1 = this.CrY.aR(paramInt1, 0, paramInt3 - i);
    AppMethodBeat.o(121615);
    return paramInt1;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121609);
    if (paramInt1 + paramInt2 <= this.CrZ)
    {
      this.CrX.b(paramOutputStream, paramInt1, paramInt2);
      AppMethodBeat.o(121609);
      return;
    }
    if (paramInt1 >= this.CrZ)
    {
      this.CrY.b(paramOutputStream, paramInt1 - this.CrZ, paramInt2);
      AppMethodBeat.o(121609);
      return;
    }
    int i = this.CrZ - paramInt1;
    this.CrX.b(paramOutputStream, paramInt1, i);
    this.CrY.b(paramOutputStream, 0, paramInt2 - i);
    AppMethodBeat.o(121609);
  }
  
  public final d.a emm()
  {
    AppMethodBeat.i(121617);
    u.c localc = new u.c(this, (byte)0);
    AppMethodBeat.o(121617);
    return localc;
  }
  
  public final boolean emn()
  {
    AppMethodBeat.i(121611);
    int i = this.CrX.aQ(0, 0, this.CrZ);
    if (this.CrY.aQ(i, 0, this.CrY.size()) == 0)
    {
      AppMethodBeat.o(121611);
      return true;
    }
    AppMethodBeat.o(121611);
    return false;
  }
  
  public final e emo()
  {
    AppMethodBeat.i(121616);
    e locale = e.P(new u.d(this));
    AppMethodBeat.o(121616);
    return locale;
  }
  
  protected final int emq()
  {
    return this.Csa;
  }
  
  protected final boolean emr()
  {
    return this.CrW >= CrV[this.Csa];
  }
  
  protected final int ems()
  {
    return this.pJe;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121613);
    if (paramObject == this)
    {
      AppMethodBeat.o(121613);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(121613);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.CrW != paramObject.size())
    {
      AppMethodBeat.o(121613);
      return false;
    }
    if (this.CrW == 0)
    {
      AppMethodBeat.o(121613);
      return true;
    }
    if (this.pJe != 0)
    {
      i = paramObject.ems();
      if ((i != 0) && (this.pJe != i))
      {
        AppMethodBeat.o(121613);
        return false;
      }
    }
    int j = 0;
    u.b localb1 = new u.b(this, (byte)0);
    p localp = (p)localb1.next();
    int i = 0;
    u.b localb2 = new u.b(paramObject, (byte)0);
    paramObject = (p)localb2.next();
    int k = 0;
    for (;;)
    {
      int i1 = localp.size() - j;
      int n = paramObject.size() - i;
      int m = Math.min(i1, n);
      if (j == 0) {}
      for (boolean bool = localp.a(paramObject, i, m); !bool; bool = paramObject.a(localp, j, m))
      {
        AppMethodBeat.o(121613);
        return false;
      }
      k += m;
      if (k >= this.CrW)
      {
        if (k == this.CrW)
        {
          AppMethodBeat.o(121613);
          return true;
        }
        paramObject = new IllegalStateException();
        AppMethodBeat.o(121613);
        throw paramObject;
      }
      if (m == i1)
      {
        j = 0;
        localp = (p)localb1.next();
      }
      for (;;)
      {
        if (m != n) {
          break label317;
        }
        i = 0;
        paramObject = (p)localb2.next();
        break;
        j += m;
      }
      label317:
      i += m;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(121614);
    int j = this.pJe;
    int i = j;
    if (j == 0)
    {
      j = aR(this.CrW, 0, this.CrW);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.pJe = i;
    }
    AppMethodBeat.o(121614);
    return i;
  }
  
  protected final void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121608);
    if (paramInt1 + paramInt3 <= this.CrZ)
    {
      this.CrX.i(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(121608);
      return;
    }
    if (paramInt1 >= this.CrZ)
    {
      this.CrY.i(paramArrayOfByte, paramInt1 - this.CrZ, paramInt2, paramInt3);
      AppMethodBeat.o(121608);
      return;
    }
    int i = this.CrZ - paramInt1;
    this.CrX.i(paramArrayOfByte, paramInt1, paramInt2, i);
    this.CrY.i(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
    AppMethodBeat.o(121608);
  }
  
  public final int size()
  {
    return this.CrW;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(121610);
    paramString = new String(toByteArray(), paramString);
    AppMethodBeat.o(121610);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.g.u
 * JD-Core Version:    0.7.0.1
 */