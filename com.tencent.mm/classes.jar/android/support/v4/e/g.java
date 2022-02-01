package android.support.v4.e;

public final class g<E>
  implements Cloneable
{
  public static final Object MP = new Object();
  public boolean MQ = false;
  public long[] MR;
  public Object[] MS;
  public int mSize;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    paramByte = d.aI(10);
    this.MR = new long[paramByte];
    this.MS = new Object[paramByte];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.MR;
    Object[] arrayOfObject = this.MS;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != MP)
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
    this.MQ = false;
    this.mSize = j;
  }
  
  public final void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.MR[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.MQ) && (this.mSize >= this.MR.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.MR.length)
    {
      int j = d.aI(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.MR, 0, arrayOfLong, 0, this.MR.length);
      System.arraycopy(this.MS, 0, arrayOfObject, 0, this.MS.length);
      this.MR = arrayOfLong;
      this.MS = arrayOfObject;
    }
    this.MR[i] = paramLong;
    this.MS[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.MS;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.MQ = false;
  }
  
  public final g<E> fa()
  {
    try
    {
      g localg = (g)super.clone();
      localg.MR = ((long[])this.MR.clone());
      localg.MS = ((Object[])this.MS.clone());
      return localg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    int i = d.a(this.MR, this.mSize, paramLong);
    if ((i < 0) || (this.MS[i] == MP)) {
      return paramE;
    }
    return this.MS[i];
  }
  
  public final int indexOfKey(long paramLong)
  {
    if (this.MQ) {
      gc();
    }
    return d.a(this.MR, this.mSize, paramLong);
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.MQ) {
      gc();
    }
    return this.MR[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = d.a(this.MR, this.mSize, paramLong);
    if (i >= 0)
    {
      this.MS[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.MS[j] == MP))
    {
      this.MR[j] = paramLong;
      this.MS[j] = paramE;
      return;
    }
    i = j;
    if (this.MQ)
    {
      i = j;
      if (this.mSize >= this.MR.length)
      {
        gc();
        i = d.a(this.MR, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.MR.length)
    {
      j = d.aI(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.MR, 0, localObject, 0, this.MR.length);
      System.arraycopy(this.MS, 0, arrayOfObject, 0, this.MS.length);
      this.MR = ((long[])localObject);
      this.MS = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.MR;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.MS;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.MR[i] = paramLong;
    this.MS[i] = paramE;
    this.mSize += 1;
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.MS[paramInt] != MP)
    {
      this.MS[paramInt] = MP;
      this.MQ = true;
    }
  }
  
  public final int size()
  {
    if (this.MQ) {
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
    if (this.MQ) {
      gc();
    }
    return this.MS[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.g
 * JD-Core Version:    0.7.0.1
 */