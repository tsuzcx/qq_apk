package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d<E>
  implements Cloneable
{
  private static final Object RV;
  private boolean RW;
  private long[] RX;
  private Object[] RY;
  private int mSize;
  
  static
  {
    AppMethodBeat.i(194534);
    RV = new Object();
    AppMethodBeat.o(194534);
  }
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(194521);
    this.RW = false;
    paramByte = c.bh(10);
    this.RX = new long[paramByte];
    this.RY = new Object[paramByte];
    AppMethodBeat.o(194521);
  }
  
  private void lm()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.RX;
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
          arrayOfLong[j] = arrayOfLong[i];
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
  
  public final void a(long paramLong, E paramE)
  {
    AppMethodBeat.i(194581);
    int i = c.a(this.RX, this.mSize, paramLong);
    if (i >= 0)
    {
      this.RY[i] = paramE;
      AppMethodBeat.o(194581);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.RY[j] == RV))
    {
      this.RX[j] = paramLong;
      this.RY[j] = paramE;
      AppMethodBeat.o(194581);
      return;
    }
    i = j;
    if (this.RW)
    {
      i = j;
      if (this.mSize >= this.RX.length)
      {
        lm();
        i = c.a(this.RX, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.RX.length)
    {
      j = c.bh(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.RX, 0, localObject, 0, this.RX.length);
      System.arraycopy(this.RY, 0, arrayOfObject, 0, this.RY.length);
      this.RX = ((long[])localObject);
      this.RY = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.RX;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.RY;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.RX[i] = paramLong;
    this.RY[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(194581);
  }
  
  public final void b(long paramLong, E paramE)
  {
    AppMethodBeat.i(194634);
    if ((this.mSize != 0) && (paramLong <= this.RX[(this.mSize - 1)]))
    {
      a(paramLong, paramE);
      AppMethodBeat.o(194634);
      return;
    }
    if ((this.RW) && (this.mSize >= this.RX.length)) {
      lm();
    }
    int i = this.mSize;
    if (i >= this.RX.length)
    {
      int j = c.bh(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.RX, 0, arrayOfLong, 0, this.RX.length);
      System.arraycopy(this.RY, 0, arrayOfObject, 0, this.RY.length);
      this.RX = arrayOfLong;
      this.RY = arrayOfObject;
    }
    this.RX[i] = paramLong;
    this.RY[i] = paramE;
    this.mSize = (i + 1);
    AppMethodBeat.o(194634);
  }
  
  public final void bj(int paramInt)
  {
    if (this.RY[paramInt] != RV)
    {
      this.RY[paramInt] = RV;
      this.RW = true;
    }
  }
  
  public final long bk(int paramInt)
  {
    AppMethodBeat.i(194598);
    if (this.RW) {
      lm();
    }
    long l = this.RX[paramInt];
    AppMethodBeat.o(194598);
    return l;
  }
  
  public final E bl(int paramInt)
  {
    AppMethodBeat.i(194606);
    if (this.RW) {
      lm();
    }
    Object localObject = this.RY[paramInt];
    AppMethodBeat.o(194606);
    return localObject;
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
  
  public final E get(long paramLong, E paramE)
  {
    AppMethodBeat.i(194551);
    int i = c.a(this.RX, this.mSize, paramLong);
    if ((i < 0) || (this.RY[i] == RV))
    {
      AppMethodBeat.o(194551);
      return paramE;
    }
    paramE = this.RY[i];
    AppMethodBeat.o(194551);
    return paramE;
  }
  
  public final int j(long paramLong)
  {
    AppMethodBeat.i(194616);
    if (this.RW) {
      lm();
    }
    int i = c.a(this.RX, this.mSize, paramLong);
    AppMethodBeat.o(194616);
    return i;
  }
  
  public final d<E> ll()
  {
    AppMethodBeat.i(194541);
    try
    {
      d locald = (d)super.clone();
      locald.RX = ((long[])this.RX.clone());
      locald.RY = ((Object[])this.RY.clone());
      AppMethodBeat.o(194541);
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      AppMethodBeat.o(194541);
      throw localAssertionError;
    }
  }
  
  public final void remove(long paramLong)
  {
    AppMethodBeat.i(194559);
    int i = c.a(this.RX, this.mSize, paramLong);
    if ((i >= 0) && (this.RY[i] != RV))
    {
      this.RY[i] = RV;
      this.RW = true;
    }
    AppMethodBeat.o(194559);
  }
  
  public final int size()
  {
    AppMethodBeat.i(194591);
    if (this.RW) {
      lm();
    }
    int i = this.mSize;
    AppMethodBeat.o(194591);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194644);
    if (size() <= 0)
    {
      AppMethodBeat.o(194644);
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
      ((StringBuilder)localObject1).append(bk(i));
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
    AppMethodBeat.o(194644);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.d
 * JD-Core Version:    0.7.0.1
 */