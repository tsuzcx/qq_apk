package android.support.v4.e;

public final class g<E>
  implements Cloneable
{
  public static final Object LS = new Object();
  public boolean LT = false;
  public long[] LU;
  public Object[] LV;
  public int mSize;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    paramByte = d.aI(10);
    this.LU = new long[paramByte];
    this.LV = new Object[paramByte];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.LU;
    Object[] arrayOfObject = this.LV;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != LS)
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
    this.LT = false;
    this.mSize = j;
  }
  
  public final void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.LU[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.LT) && (this.mSize >= this.LU.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.LU.length)
    {
      int j = d.aI(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.LU, 0, arrayOfLong, 0, this.LU.length);
      System.arraycopy(this.LV, 0, arrayOfObject, 0, this.LV.length);
      this.LU = arrayOfLong;
      this.LV = arrayOfObject;
    }
    this.LU[i] = paramLong;
    this.LV[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.LV;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.LT = false;
  }
  
  public final g<E> eS()
  {
    try
    {
      g localg = (g)super.clone();
      localg.LU = ((long[])this.LU.clone());
      localg.LV = ((Object[])this.LV.clone());
      return localg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    int i = d.a(this.LU, this.mSize, paramLong);
    if ((i < 0) || (this.LV[i] == LS)) {
      return paramE;
    }
    return this.LV[i];
  }
  
  public final int indexOfKey(long paramLong)
  {
    if (this.LT) {
      gc();
    }
    return d.a(this.LU, this.mSize, paramLong);
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.LT) {
      gc();
    }
    return this.LU[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = d.a(this.LU, this.mSize, paramLong);
    if (i >= 0)
    {
      this.LV[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.LV[j] == LS))
    {
      this.LU[j] = paramLong;
      this.LV[j] = paramE;
      return;
    }
    i = j;
    if (this.LT)
    {
      i = j;
      if (this.mSize >= this.LU.length)
      {
        gc();
        i = d.a(this.LU, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.LU.length)
    {
      j = d.aI(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.LU, 0, localObject, 0, this.LU.length);
      System.arraycopy(this.LV, 0, arrayOfObject, 0, this.LV.length);
      this.LU = ((long[])localObject);
      this.LV = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.LU;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.LV;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.LU[i] = paramLong;
    this.LV[i] = paramE;
    this.mSize += 1;
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.LV[paramInt] != LS)
    {
      this.LV[paramInt] = LS;
      this.LT = true;
    }
  }
  
  public final int size()
  {
    if (this.LT) {
      gc();
    }
    return this.mSize;
  }
  
  public final String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final E valueAt(int paramInt)
  {
    if (this.LT) {
      gc();
    }
    return this.LV[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.g
 * JD-Core Version:    0.7.0.1
 */