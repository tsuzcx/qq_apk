package android.support.v4.e;

public final class o<E>
  implements Cloneable
{
  private static final Object MP = new Object();
  public boolean MQ = false;
  private Object[] MS;
  public int[] Nf;
  public int mSize;
  
  public o()
  {
    this(10);
  }
  
  public o(int paramInt)
  {
    if (paramInt == 0) {
      this.Nf = d.MM;
    }
    for (this.MS = d.MO;; this.MS = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = d.idealIntArraySize(paramInt);
      this.Nf = new int[paramInt];
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.Nf[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.MQ) && (this.mSize >= this.Nf.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.Nf.length)
    {
      int j = d.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Nf, 0, arrayOfInt, 0, this.Nf.length);
      System.arraycopy(this.MS, 0, arrayOfObject, 0, this.MS.length);
      this.Nf = arrayOfInt;
      this.MS = arrayOfObject;
    }
    this.Nf[i] = paramInt;
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
  
  public final void delete(int paramInt)
  {
    paramInt = d.b(this.Nf, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.MS[paramInt] != MP))
    {
      this.MS[paramInt] = MP;
      this.MQ = true;
    }
  }
  
  public final o<E> fb()
  {
    try
    {
      o localo = (o)super.clone();
      localo.Nf = ((int[])this.Nf.clone());
      localo.MS = ((Object[])this.MS.clone());
      return localo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.Nf;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt, E paramE)
  {
    paramInt = d.b(this.Nf, this.mSize, paramInt);
    if ((paramInt < 0) || (this.MS[paramInt] == MP)) {
      return paramE;
    }
    return this.MS[paramInt];
  }
  
  public final int indexOfValue(E paramE)
  {
    if (this.MQ) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.MS[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.MQ) {
      gc();
    }
    return this.Nf[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = d.b(this.Nf, this.mSize, paramInt);
    if (i >= 0)
    {
      this.MS[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.MS[j] == MP))
    {
      this.Nf[j] = paramInt;
      this.MS[j] = paramE;
      return;
    }
    i = j;
    if (this.MQ)
    {
      i = j;
      if (this.mSize >= this.Nf.length)
      {
        gc();
        i = d.b(this.Nf, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.Nf.length)
    {
      j = d.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Nf, 0, localObject, 0, this.Nf.length);
      System.arraycopy(this.MS, 0, arrayOfObject, 0, this.MS.length);
      this.Nf = ((int[])localObject);
      this.MS = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.Nf;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.MS;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.Nf[i] = paramInt;
    this.MS[i] = paramE;
    this.mSize += 1;
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
 * Qualified Name:     android.support.v4.e.o
 * JD-Core Version:    0.7.0.1
 */