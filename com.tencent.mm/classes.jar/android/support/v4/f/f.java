package android.support.v4.f;

public final class f<E>
  implements Cloneable
{
  public static final Object Ee = new Object();
  public boolean Ef = false;
  public long[] Eg;
  public Object[] Eh;
  public int mSize;
  
  public f()
  {
    this((byte)0);
  }
  
  private f(byte paramByte)
  {
    paramByte = c.as(10);
    this.Eg = new long[paramByte];
    this.Eh = new Object[paramByte];
    this.mSize = 0;
  }
  
  private f<E> dc()
  {
    try
    {
      f localf = (f)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localf.Eg = ((long[])this.Eg.clone());
        localf.Eh = ((Object[])this.Eh.clone());
        return localf;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.Eh;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.Ef = false;
  }
  
  public final void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.Eg;
    Object[] arrayOfObject = this.Eh;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != Ee)
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
    this.Ef = false;
    this.mSize = j;
  }
  
  public final E get(long paramLong)
  {
    int i = c.a(this.Eg, this.mSize, paramLong);
    if ((i < 0) || (this.Eh[i] == Ee)) {
      return null;
    }
    return this.Eh[i];
  }
  
  public final long keyAt(int paramInt)
  {
    if (this.Ef) {
      gc();
    }
    return this.Eg[paramInt];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = c.a(this.Eg, this.mSize, paramLong);
    if (i >= 0)
    {
      this.Eh[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.Eh[j] == Ee))
    {
      this.Eg[j] = paramLong;
      this.Eh[j] = paramE;
      return;
    }
    i = j;
    if (this.Ef)
    {
      i = j;
      if (this.mSize >= this.Eg.length)
      {
        gc();
        i = c.a(this.Eg, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.Eg.length)
    {
      j = c.as(this.mSize + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Eg, 0, arrayOfLong, 0, this.Eg.length);
      System.arraycopy(this.Eh, 0, arrayOfObject, 0, this.Eh.length);
      this.Eg = arrayOfLong;
      this.Eh = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.Eg, i, this.Eg, i + 1, this.mSize - i);
      System.arraycopy(this.Eh, i, this.Eh, i + 1, this.mSize - i);
    }
    this.Eg[i] = paramLong;
    this.Eh[i] = paramE;
    this.mSize += 1;
  }
  
  public final int size()
  {
    if (this.Ef) {
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
    if (this.Ef) {
      gc();
    }
    return this.Eh[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.f.f
 * JD-Core Version:    0.7.0.1
 */