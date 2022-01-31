package android.support.v4.e;

public final class f<E>
  implements Cloneable
{
  public static final Object EU = new Object();
  public boolean EV = false;
  public long[] EW;
  public Object[] EX;
  public int mSize;
  
  public f()
  {
    this((byte)0);
  }
  
  private f(byte paramByte)
  {
    paramByte = c.aq(10);
    this.EW = new long[paramByte];
    this.EX = new Object[paramByte];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.EW;
    Object[] arrayOfObject = this.EX;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != EU)
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
    this.EV = false;
    this.mSize = j;
  }
  
  public final void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.EW[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.EV) && (this.mSize >= this.EW.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.EW.length)
    {
      int j = c.aq(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.EW, 0, arrayOfLong, 0, this.EW.length);
      System.arraycopy(this.EX, 0, arrayOfObject, 0, this.EX.length);
      this.EW = arrayOfLong;
      this.EX = arrayOfObject;
    }
    this.EW[i] = paramLong;
    this.EX[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.EX;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.EV = false;
  }
  
  public final f<E> dA()
  {
    try
    {
      f localf = (f)super.clone();
      localf.EW = ((long[])this.EW.clone());
      localf.EX = ((Object[])this.EX.clone());
      return localf;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    int i = c.a(this.EW, this.mSize, paramLong);
    if ((i < 0) || (this.EX[i] == EU)) {
      return paramE;
    }
    return this.EX[i];
  }
  
  public final int indexOfKey(long paramLong)
  {
    if (this.EV) {
      gc();
    }
    return c.a(this.EW, this.mSize, paramLong);
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.EV) {
      gc();
    }
    return this.EW[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = c.a(this.EW, this.mSize, paramLong);
    if (i >= 0)
    {
      this.EX[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.EX[j] == EU))
    {
      this.EW[j] = paramLong;
      this.EX[j] = paramE;
      return;
    }
    i = j;
    if (this.EV)
    {
      i = j;
      if (this.mSize >= this.EW.length)
      {
        gc();
        i = c.a(this.EW, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.EW.length)
    {
      j = c.aq(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.EW, 0, localObject, 0, this.EW.length);
      System.arraycopy(this.EX, 0, arrayOfObject, 0, this.EX.length);
      this.EW = ((long[])localObject);
      this.EX = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.EW;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.EX;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.EW[i] = paramLong;
    this.EX[i] = paramE;
    this.mSize += 1;
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.EX[paramInt] != EU)
    {
      this.EX[paramInt] = EU;
      this.EV = true;
    }
  }
  
  public final int size()
  {
    if (this.EV) {
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
    if (this.EV) {
      gc();
    }
    return this.EX[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.f
 * JD-Core Version:    0.7.0.1
 */