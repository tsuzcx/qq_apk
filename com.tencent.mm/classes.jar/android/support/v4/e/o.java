package android.support.v4.e;

public final class o<E>
  implements Cloneable
{
  private static final Object LS = new Object();
  public boolean LT = false;
  private Object[] LV;
  public int[] Mi;
  public int mSize;
  
  public o()
  {
    this(10);
  }
  
  public o(int paramInt)
  {
    if (paramInt == 0) {
      this.Mi = d.LP;
    }
    for (this.LV = d.LR;; this.LV = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = d.idealIntArraySize(paramInt);
      this.Mi = new int[paramInt];
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.Mi[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.LT) && (this.mSize >= this.Mi.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.Mi.length)
    {
      int j = d.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Mi, 0, arrayOfInt, 0, this.Mi.length);
      System.arraycopy(this.LV, 0, arrayOfObject, 0, this.LV.length);
      this.Mi = arrayOfInt;
      this.LV = arrayOfObject;
    }
    this.Mi[i] = paramInt;
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
  
  public final void delete(int paramInt)
  {
    paramInt = d.b(this.Mi, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.LV[paramInt] != LS))
    {
      this.LV[paramInt] = LS;
      this.LT = true;
    }
  }
  
  public final o<E> eT()
  {
    try
    {
      o localo = (o)super.clone();
      localo.Mi = ((int[])this.Mi.clone());
      localo.LV = ((Object[])this.LV.clone());
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
    int[] arrayOfInt = this.Mi;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt, E paramE)
  {
    paramInt = d.b(this.Mi, this.mSize, paramInt);
    if ((paramInt < 0) || (this.LV[paramInt] == LS)) {
      return paramE;
    }
    return this.LV[paramInt];
  }
  
  public final int indexOfValue(E paramE)
  {
    if (this.LT) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.LV[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.LT) {
      gc();
    }
    return this.Mi[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = d.b(this.Mi, this.mSize, paramInt);
    if (i >= 0)
    {
      this.LV[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.LV[j] == LS))
    {
      this.Mi[j] = paramInt;
      this.LV[j] = paramE;
      return;
    }
    i = j;
    if (this.LT)
    {
      i = j;
      if (this.mSize >= this.Mi.length)
      {
        gc();
        i = d.b(this.Mi, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.Mi.length)
    {
      j = d.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.Mi, 0, localObject, 0, this.Mi.length);
      System.arraycopy(this.LV, 0, arrayOfObject, 0, this.LV.length);
      this.Mi = ((int[])localObject);
      this.LV = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.Mi;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.LV;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.Mi[i] = paramInt;
    this.LV[i] = paramE;
    this.mSize += 1;
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
 * Qualified Name:     android.support.v4.e.o
 * JD-Core Version:    0.7.0.1
 */