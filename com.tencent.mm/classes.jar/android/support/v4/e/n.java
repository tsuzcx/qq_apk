package android.support.v4.e;

public final class n<E>
  implements Cloneable
{
  private static final Object EU = new Object();
  public boolean EV = false;
  private Object[] EX;
  public int[] Fk;
  public int mSize;
  
  public n()
  {
    this(10);
  }
  
  public n(int paramInt)
  {
    if (paramInt == 0) {
      this.Fk = c.ER;
    }
    for (this.EX = c.ET;; this.EX = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = c.idealIntArraySize(paramInt);
      this.Fk = new int[paramInt];
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.Fk[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.EV) && (this.mSize >= this.Fk.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.Fk.length)
    {
      int j = c.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Fk, 0, arrayOfInt, 0, this.Fk.length);
      System.arraycopy(this.EX, 0, arrayOfObject, 0, this.EX.length);
      this.Fk = arrayOfInt;
      this.EX = arrayOfObject;
    }
    this.Fk[i] = paramInt;
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
  
  public final n<E> dB()
  {
    try
    {
      n localn = (n)super.clone();
      localn.Fk = ((int[])this.Fk.clone());
      localn.EX = ((Object[])this.EX.clone());
      return localn;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final void delete(int paramInt)
  {
    paramInt = c.b(this.Fk, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.EX[paramInt] != EU))
    {
      this.EX[paramInt] = EU;
      this.EV = true;
    }
  }
  
  public final void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.Fk;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt, E paramE)
  {
    paramInt = c.b(this.Fk, this.mSize, paramInt);
    if ((paramInt < 0) || (this.EX[paramInt] == EU)) {
      return paramE;
    }
    return this.EX[paramInt];
  }
  
  public final int indexOfValue(E paramE)
  {
    if (this.EV) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.EX[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.EV) {
      gc();
    }
    return this.Fk[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = c.b(this.Fk, this.mSize, paramInt);
    if (i >= 0)
    {
      this.EX[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.EX[j] == EU))
    {
      this.Fk[j] = paramInt;
      this.EX[j] = paramE;
      return;
    }
    i = j;
    if (this.EV)
    {
      i = j;
      if (this.mSize >= this.Fk.length)
      {
        gc();
        i = c.b(this.Fk, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.Fk.length)
    {
      j = c.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Fk, 0, localObject, 0, this.Fk.length);
      System.arraycopy(this.EX, 0, arrayOfObject, 0, this.EX.length);
      this.Fk = ((int[])localObject);
      this.EX = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.Fk;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.EX;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.Fk[i] = paramInt;
    this.EX[i] = paramE;
    this.mSize += 1;
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
 * Qualified Name:     android.support.v4.e.n
 * JD-Core Version:    0.7.0.1
 */