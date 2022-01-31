package android.support.v4.f;

public final class n<E>
  implements Cloneable
{
  private static final Object Ee = new Object();
  public boolean Ef = false;
  private Object[] Eh;
  public int[] Ew;
  public int mSize;
  
  public n()
  {
    this(10);
  }
  
  public n(int paramInt)
  {
    if (paramInt == 0) {
      this.Ew = c.Eb;
    }
    for (this.Eh = c.Ed;; this.Eh = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = c.idealIntArraySize(paramInt);
      this.Ew = new int[paramInt];
    }
  }
  
  private n<E> df()
  {
    try
    {
      n localn = (n)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localn.Ew = ((int[])this.Ew.clone());
        localn.Eh = ((Object[])this.Eh.clone());
        return localn;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.Ew[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.Ef) && (this.mSize >= this.Ew.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.Ew.length)
    {
      int j = c.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Ew, 0, arrayOfInt, 0, this.Ew.length);
      System.arraycopy(this.Eh, 0, arrayOfObject, 0, this.Eh.length);
      this.Ew = arrayOfInt;
      this.Eh = arrayOfObject;
    }
    this.Ew[i] = paramInt;
    this.Eh[i] = paramE;
    this.mSize = (i + 1);
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
    int[] arrayOfInt = this.Ew;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt)
  {
    paramInt = c.a(this.Ew, this.mSize, paramInt);
    if ((paramInt < 0) || (this.Eh[paramInt] == Ee)) {
      return null;
    }
    return this.Eh[paramInt];
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.Ef) {
      gc();
    }
    return this.Ew[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = c.a(this.Ew, this.mSize, paramInt);
    if (i >= 0)
    {
      this.Eh[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.Eh[j] == Ee))
    {
      this.Ew[j] = paramInt;
      this.Eh[j] = paramE;
      return;
    }
    i = j;
    if (this.Ef)
    {
      i = j;
      if (this.mSize >= this.Ew.length)
      {
        gc();
        i = c.a(this.Ew, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.Ew.length)
    {
      j = c.idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Ew, 0, arrayOfInt, 0, this.Ew.length);
      System.arraycopy(this.Eh, 0, arrayOfObject, 0, this.Eh.length);
      this.Ew = arrayOfInt;
      this.Eh = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.Ew, i, this.Ew, i + 1, this.mSize - i);
      System.arraycopy(this.Eh, i, this.Eh, i + 1, this.mSize - i);
    }
    this.Ew[i] = paramInt;
    this.Eh[i] = paramE;
    this.mSize += 1;
  }
  
  public final void remove(int paramInt)
  {
    paramInt = c.a(this.Ew, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.Eh[paramInt] != Ee))
    {
      this.Eh[paramInt] = Ee;
      this.Ef = true;
    }
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
 * Qualified Name:     android.support.v4.f.n
 * JD-Core Version:    0.7.0.1
 */