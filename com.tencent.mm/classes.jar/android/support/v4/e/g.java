package android.support.v4.e;

public final class g<E>
  implements Cloneable
{
  public static final Object OF = new Object();
  public boolean OG = false;
  public long[] OH;
  public Object[] OI;
  public int mSize;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    paramByte = d.aI(10);
    this.OH = new long[paramByte];
    this.OI = new Object[paramByte];
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.OH;
    Object[] arrayOfObject = this.OI;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != OF)
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
    this.OG = false;
    this.mSize = j;
  }
  
  public final void append(long paramLong, E paramE)
  {
    if ((this.mSize != 0) && (paramLong <= this.OH[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.OG) && (this.mSize >= this.OH.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.OH.length)
    {
      int j = d.aI(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OH, 0, arrayOfLong, 0, this.OH.length);
      System.arraycopy(this.OI, 0, arrayOfObject, 0, this.OI.length);
      this.OH = arrayOfLong;
      this.OI = arrayOfObject;
    }
    this.OH[i] = paramLong;
    this.OI[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.OI;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.OG = false;
  }
  
  public final g<E> fr()
  {
    try
    {
      g localg = (g)super.clone();
      localg.OH = ((long[])this.OH.clone());
      localg.OI = ((Object[])this.OI.clone());
      return localg;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final E get(long paramLong, E paramE)
  {
    int i = d.a(this.OH, this.mSize, paramLong);
    if ((i < 0) || (this.OI[i] == OF)) {
      return paramE;
    }
    return this.OI[i];
  }
  
  public final int indexOfKey(long paramLong)
  {
    if (this.OG) {
      gc();
    }
    return d.a(this.OH, this.mSize, paramLong);
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.OG) {
      gc();
    }
    return this.OH[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = d.a(this.OH, this.mSize, paramLong);
    if (i >= 0)
    {
      this.OI[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.OI[j] == OF))
    {
      this.OH[j] = paramLong;
      this.OI[j] = paramE;
      return;
    }
    i = j;
    if (this.OG)
    {
      i = j;
      if (this.mSize >= this.OH.length)
      {
        gc();
        i = d.a(this.OH, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.OH.length)
    {
      j = d.aI(this.mSize + 1);
      localObject = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OH, 0, localObject, 0, this.OH.length);
      System.arraycopy(this.OI, 0, arrayOfObject, 0, this.OI.length);
      this.OH = ((long[])localObject);
      this.OI = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.OH;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.OI;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.OH[i] = paramLong;
    this.OI[i] = paramE;
    this.mSize += 1;
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.OI[paramInt] != OF)
    {
      this.OI[paramInt] = OF;
      this.OG = true;
    }
  }
  
  public final int size()
  {
    if (this.OG) {
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
    if (this.OG) {
      gc();
    }
    return this.OI[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.g
 * JD-Core Version:    0.7.0.1
 */