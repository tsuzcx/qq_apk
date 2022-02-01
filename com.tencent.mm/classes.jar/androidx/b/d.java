package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d<E>
  implements Cloneable
{
  public static final Object zI;
  public int mSize;
  public boolean zJ;
  public long[] zK;
  public Object[] zL;
  
  static
  {
    AppMethodBeat.i(210247);
    zI = new Object();
    AppMethodBeat.o(210247);
  }
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(210218);
    this.zJ = false;
    paramByte = c.aI(10);
    this.zK = new long[paramByte];
    this.zL = new Object[paramByte];
    this.mSize = 0;
    AppMethodBeat.o(210218);
  }
  
  private void ff()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.zK;
    Object[] arrayOfObject = this.zL;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != zI)
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
    this.zJ = false;
    this.mSize = j;
  }
  
  public final void a(long paramLong, E paramE)
  {
    AppMethodBeat.i(210223);
    int i = c.a(this.zK, this.mSize, paramLong);
    if (i >= 0)
    {
      this.zL[i] = paramE;
      AppMethodBeat.o(210223);
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.zL[j] == zI))
    {
      this.zK[j] = paramLong;
      this.zL[j] = paramE;
      AppMethodBeat.o(210223);
      return;
    }
    i = j;
    if (this.zJ)
    {
      i = j;
      if (this.mSize >= this.zK.length)
      {
        ff();
        i = c.a(this.zK, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.zK.length)
    {
      j = c.aI(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.zK, 0, localObject, 0, this.zK.length);
      System.arraycopy(this.zL, 0, arrayOfObject, 0, this.zL.length);
      this.zK = ((long[])localObject);
      this.zL = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.zK;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.zL;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.zK[i] = paramLong;
    this.zL[i] = paramE;
    this.mSize += 1;
    AppMethodBeat.o(210223);
  }
  
  public final void aK(int paramInt)
  {
    if (this.zL[paramInt] != zI)
    {
      this.zL[paramInt] = zI;
      this.zJ = true;
    }
  }
  
  public final long aL(int paramInt)
  {
    AppMethodBeat.i(210227);
    if (this.zJ) {
      ff();
    }
    long l = this.zK[paramInt];
    AppMethodBeat.o(210227);
    return l;
  }
  
  public final E aM(int paramInt)
  {
    AppMethodBeat.i(210230);
    if (this.zJ) {
      ff();
    }
    Object localObject = this.zL[paramInt];
    AppMethodBeat.o(210230);
    return localObject;
  }
  
  public final void b(long paramLong, E paramE)
  {
    AppMethodBeat.i(210237);
    if ((this.mSize != 0) && (paramLong <= this.zK[(this.mSize - 1)]))
    {
      a(paramLong, paramE);
      AppMethodBeat.o(210237);
      return;
    }
    if ((this.zJ) && (this.mSize >= this.zK.length)) {
      ff();
    }
    int i = this.mSize;
    if (i >= this.zK.length)
    {
      int j = c.aI(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.zK, 0, arrayOfLong, 0, this.zK.length);
      System.arraycopy(this.zL, 0, arrayOfObject, 0, this.zL.length);
      this.zK = arrayOfLong;
      this.zL = arrayOfObject;
    }
    this.zK[i] = paramLong;
    this.zL[i] = paramE;
    this.mSize = (i + 1);
    AppMethodBeat.o(210237);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.zL;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.zJ = false;
  }
  
  public final int d(long paramLong)
  {
    AppMethodBeat.i(210232);
    if (this.zJ) {
      ff();
    }
    int i = c.a(this.zK, this.mSize, paramLong);
    AppMethodBeat.o(210232);
    return i;
  }
  
  public final d<E> fe()
  {
    AppMethodBeat.i(210219);
    try
    {
      d locald = (d)super.clone();
      locald.zK = ((long[])this.zK.clone());
      locald.zL = ((Object[])this.zL.clone());
      AppMethodBeat.o(210219);
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      AssertionError localAssertionError = new AssertionError(localCloneNotSupportedException);
      AppMethodBeat.o(210219);
      throw localAssertionError;
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    AppMethodBeat.i(210220);
    int i = c.a(this.zK, this.mSize, paramLong);
    if ((i < 0) || (this.zL[i] == zI))
    {
      AppMethodBeat.o(210220);
      return paramE;
    }
    paramE = this.zL[i];
    AppMethodBeat.o(210220);
    return paramE;
  }
  
  public final int size()
  {
    AppMethodBeat.i(210225);
    if (this.zJ) {
      ff();
    }
    int i = this.mSize;
    AppMethodBeat.o(210225);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210240);
    if (size() <= 0)
    {
      AppMethodBeat.o(210240);
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
      ((StringBuilder)localObject1).append(aL(i));
      ((StringBuilder)localObject1).append('=');
      Object localObject2 = aM(i);
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
    AppMethodBeat.o(210240);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.d
 * JD-Core Version:    0.7.0.1
 */