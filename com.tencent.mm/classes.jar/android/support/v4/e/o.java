package android.support.v4.e;

public final class o<E>
  implements Cloneable
{
  private static final Object OT = new Object();
  public boolean OU = false;
  private Object[] OW;
  public int[] Pi;
  public int mSize;
  
  public o()
  {
    this(10);
  }
  
  public o(int paramInt)
  {
    if (paramInt == 0) {
      this.Pi = d.OQ;
    }
    for (this.OW = d.OS;; this.OW = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = d.idealIntArraySize(paramInt);
      this.Pi = new int[paramInt];
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.Pi[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.OU) && (this.mSize >= this.Pi.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.Pi.length)
    {
      int j = d.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Pi, 0, arrayOfInt, 0, this.Pi.length);
      System.arraycopy(this.OW, 0, arrayOfObject, 0, this.OW.length);
      this.Pi = arrayOfInt;
      this.OW = arrayOfObject;
    }
    this.Pi[i] = paramInt;
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
  
  public final void delete(int paramInt)
  {
    paramInt = d.b(this.Pi, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.OW[paramInt] != OT))
    {
      this.OW[paramInt] = OT;
      this.OU = true;
    }
  }
  
  public final o<E> fy()
  {
    try
    {
      o localo = (o)super.clone();
      localo.Pi = ((int[])this.Pi.clone());
      localo.OW = ((Object[])this.OW.clone());
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
    int[] arrayOfInt = this.Pi;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt, E paramE)
  {
    paramInt = d.b(this.Pi, this.mSize, paramInt);
    if ((paramInt < 0) || (this.OW[paramInt] == OT)) {
      return paramE;
    }
    return this.OW[paramInt];
  }
  
  public final int indexOfValue(E paramE)
  {
    if (this.OU) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.OW[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.OU) {
      gc();
    }
    return this.Pi[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = d.b(this.Pi, this.mSize, paramInt);
    if (i >= 0)
    {
      this.OW[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.OW[j] == OT))
    {
      this.Pi[j] = paramInt;
      this.OW[j] = paramE;
      return;
    }
    i = j;
    if (this.OU)
    {
      i = j;
      if (this.mSize >= this.Pi.length)
      {
        gc();
        i = d.b(this.Pi, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.Pi.length)
    {
      j = d.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Pi, 0, localObject, 0, this.Pi.length);
      System.arraycopy(this.OW, 0, arrayOfObject, 0, this.OW.length);
      this.Pi = ((int[])localObject);
      this.OW = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.Pi;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.OW;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.Pi[i] = paramInt;
    this.OW[i] = paramE;
    this.mSize += 1;
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
 * Qualified Name:     android.support.v4.e.o
 * JD-Core Version:    0.7.0.1
 */