package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class h<E>
  implements Cloneable
{
  public static final Object RV;
  public boolean RW;
  public Object[] RY;
  public int[] Sk;
  public int mSize;
  
  static
  {
    AppMethodBeat.i(194545);
    RV = new Object();
    AppMethodBeat.o(194545);
  }
  
  public h()
  {
    this((byte)0);
  }
  
  public h(byte paramByte)
  {
    AppMethodBeat.i(194523);
    this.RW = false;
    paramByte = c.idealIntArraySize(10);
    this.Sk = new int[paramByte];
    this.RY = new Object[paramByte];
    AppMethodBeat.o(194523);
  }
  
  private void lm()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.Sk;
    Object[] arrayOfObject = this.RY;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != RV)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.RW = false;
    this.mSize = j;
  }
  
  public final void bj(int paramInt)
  {
    if (this.RY[paramInt] != RV)
    {
      this.RY[paramInt] = RV;
      this.RW = true;
    }
  }
  
  public final E bl(int paramInt)
  {
    AppMethodBeat.i(194660);
    if (this.RW) {
      lm();
    }
    Object localObject = this.RY[paramInt];
    AppMethodBeat.o(194660);
    return localObject;
  }
  
  public final int bo(int paramInt)
  {
    AppMethodBeat.i(194643);
    if (this.RW) {
      lm();
    }
    paramInt = this.Sk[paramInt];
    AppMethodBeat.o(194643);
    return paramInt;
  }
  
  public final boolean bp(int paramInt)
  {
    AppMethodBeat.i(194686);
    if (this.RW) {
      lm();
    }
    if (c.a(this.Sk, this.mSize, paramInt) >= 0)
    {
      AppMethodBeat.o(194686);
      return true;
    }
    AppMethodBeat.o(194686);
    return false;
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.RY;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.RW = false;
  }
  
  public final E d(int paramInt, E paramE)
  {
    AppMethodBeat.i(194576);
    paramInt = c.a(this.Sk, this.mSize, paramInt);
    if ((paramInt < 0) || (this.RY[paramInt] == RV))
    {
      AppMethodBeat.o(194576);
      return paramE;
    }
    paramE = this.RY[paramInt];
    AppMethodBeat.o(194576);
    return paramE;
  }
  
  public final void e(int paramInt, E paramE)
  {
    AppMethodBeat.i(194719);
    if ((this.mSize != 0) && (paramInt <= this.Sk[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      AppMethodBeat.o(194719);
      return;
    }
    if ((this.RW) && (this.mSize >= this.Sk.length)) {
      lm();
    }
    int i = this.mSize;
    if (i >= this.Sk.length)
    {
      int j = c.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Sk, 0, arrayOfInt, 0, this.Sk.length);
      System.arraycopy(this.RY, 0, arrayOfObject, 0, this.RY.length);
      this.Sk = arrayOfInt;
      this.RY = arrayOfObject;
    }
    this.Sk[i] = paramInt;
    this.RY[i] = paramE;
    this.mSize = (i + 1);
    AppMethodBeat.o(194719);
  }
  
  public final h<E> lo()
  {
    AppMethodBeat.i(194561);
    try
    {
      h localh = (h)super.clone();
      localh.Sk = ((int[])this.Sk.clone());
      localh.RY = ((Object[])this.RY.clone());
      AppMethodBeat.o(194561);
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      AppMethodBeat.o(194561);
      throw localAssertionError;
    }
  }
  
  public final void put(int paramInt, E paramE)
  {
    AppMethodBeat.i(194614);
    int i = c.a(this.Sk, this.mSize, paramInt);
    if (i >= 0)
    {
      this.RY[i] = paramE;
      AppMethodBeat.o(194614);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.RY[j] == RV))
    {
      this.Sk[j] = paramInt;
      this.RY[j] = paramE;
      AppMethodBeat.o(194614);
      return;
    }
    i = j;
    if (this.RW)
    {
      i = j;
      if (this.mSize >= this.Sk.length)
      {
        lm();
        i = c.a(this.Sk, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.Sk.length)
    {
      j = c.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Sk, 0, localObject, 0, this.Sk.length);
      System.arraycopy(this.RY, 0, arrayOfObject, 0, this.RY.length);
      this.Sk = ((int[])localObject);
      this.RY = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.Sk;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.RY;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.Sk[i] = paramInt;
    this.RY[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(194614);
  }
  
  public final int size()
  {
    AppMethodBeat.i(194629);
    if (this.RW) {
      lm();
    }
    int i = this.mSize;
    AppMethodBeat.o(194629);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194738);
    if (size() <= 0)
    {
      AppMethodBeat.o(194738);
      return "{}";
    }
    Object localObject1 = new StringBuilder(this.mSize * 28);
    ((StringBuilder)localObject1).append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        ((StringBuilder)localObject1).append(", ");
      }
      ((StringBuilder)localObject1).append(bo(i));
      ((StringBuilder)localObject1).append('=');
      Object localObject2 = bl(i);
      if (localObject2 != this) {
        ((StringBuilder)localObject1).append(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject1).append("(this Map)");
      }
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(194738);
    return localObject1;
  }
  
  public final int z(E paramE)
  {
    AppMethodBeat.i(194673);
    if (this.RW) {
      lm();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.RY[i] == paramE)
      {
        AppMethodBeat.o(194673);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(194673);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.h
 * JD-Core Version:    0.7.0.1
 */