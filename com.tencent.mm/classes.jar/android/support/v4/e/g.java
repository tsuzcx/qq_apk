package android.support.v4.e;

public final class g<E>
  implements Cloneable
{
  public static final Object OT = new Object();
  public boolean OU = false;
  public long[] OV;
  public Object[] OW;
  public int mSize;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    paramByte = d.aI(10);
    this.OV = new long[paramByte];
    this.OW = new Object[paramByte];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.OV;
    Object[] arrayOfObject = this.OW;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != OT)
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
    this.OU = false;
    this.mSize = j;
  }
  
  public final void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.OV[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.OU) && (this.mSize >= this.OV.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.OV.length)
    {
      int j = d.aI(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OV, 0, arrayOfLong, 0, this.OV.length);
      System.arraycopy(this.OW, 0, arrayOfObject, 0, this.OW.length);
      this.OV = arrayOfLong;
      this.OW = arrayOfObject;
    }
    this.OV[i] = paramLong;
    this.OW[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.OW;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.OU = false;
  }
  
  public final g<E> fx()
  {
    try
    {
      g localg = (g)super.clone();
      localg.OV = ((long[])this.OV.clone());
      localg.OW = ((Object[])this.OW.clone());
      return localg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    int i = d.a(this.OV, this.mSize, paramLong);
    if ((i < 0) || (this.OW[i] == OT)) {
      return paramE;
    }
    return this.OW[i];
  }
  
  public final int indexOfKey(long paramLong)
  {
    if (this.OU) {
      gc();
    }
    return d.a(this.OV, this.mSize, paramLong);
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.OU) {
      gc();
    }
    return this.OV[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = d.a(this.OV, this.mSize, paramLong);
    if (i >= 0)
    {
      this.OW[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.OW[j] == OT))
    {
      this.OV[j] = paramLong;
      this.OW[j] = paramE;
      return;
    }
    i = j;
    if (this.OU)
    {
      i = j;
      if (this.mSize >= this.OV.length)
      {
        gc();
        i = d.a(this.OV, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.OV.length)
    {
      j = d.aI(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OV, 0, localObject, 0, this.OV.length);
      System.arraycopy(this.OW, 0, arrayOfObject, 0, this.OW.length);
      this.OV = ((long[])localObject);
      this.OW = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.OV;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.OW;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.OV[i] = paramLong;
    this.OW[i] = paramE;
    this.mSize += 1;
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.OW[paramInt] != OT)
    {
      this.OW[paramInt] = OT;
      this.OU = true;
    }
  }
  
  public final int size()
  {
    if (this.OU) {
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
    if (this.OU) {
      gc();
    }
    return this.OW[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.g
 * JD-Core Version:    0.7.0.1
 */