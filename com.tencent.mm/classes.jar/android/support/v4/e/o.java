package android.support.v4.e;

public final class o<E>
  implements Cloneable
{
  private static final Object OF = new Object();
  public boolean OG = false;
  private Object[] OI;
  public int[] OW;
  public int mSize;
  
  public o()
  {
    this(10);
  }
  
  public o(int paramInt)
  {
    if (paramInt == 0) {
      this.OW = d.OC;
    }
    for (this.OI = d.OE;; this.OI = new Object[paramInt])
    {
      this.mSize = 0;
      return;
      paramInt = d.idealIntArraySize(paramInt);
      this.OW = new int[paramInt];
    }
  }
  
  public final void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.OW[(this.mSize - 1)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.OG) && (this.mSize >= this.OW.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.OW.length)
    {
      int j = d.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OW, 0, arrayOfInt, 0, this.OW.length);
      System.arraycopy(this.OI, 0, arrayOfObject, 0, this.OI.length);
      this.OW = arrayOfInt;
      this.OI = arrayOfObject;
    }
    this.OW[i] = paramInt;
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
  
  public final void delete(int paramInt)
  {
    paramInt = d.b(this.OW, this.mSize, paramInt);
    if ((paramInt >= 0) && (this.OI[paramInt] != OF))
    {
      this.OI[paramInt] = OF;
      this.OG = true;
    }
  }
  
  public final o<E> fs()
  {
    try
    {
      o localo = (o)super.clone();
      localo.OW = ((int[])this.OW.clone());
      localo.OI = ((Object[])this.OI.clone());
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
    int[] arrayOfInt = this.OW;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final E get(int paramInt, E paramE)
  {
    paramInt = d.b(this.OW, this.mSize, paramInt);
    if ((paramInt < 0) || (this.OI[paramInt] == OF)) {
      return paramE;
    }
    return this.OI[paramInt];
  }
  
  public final int indexOfValue(E paramE)
  {
    if (this.OG) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.OI[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.OG) {
      gc();
    }
    return this.OW[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = d.b(this.OW, this.mSize, paramInt);
    if (i >= 0)
    {
      this.OI[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.OI[j] == OF))
    {
      this.OW[j] = paramInt;
      this.OI[j] = paramE;
      return;
    }
    i = j;
    if (this.OG)
    {
      i = j;
      if (this.mSize >= this.OW.length)
      {
        gc();
        i = d.b(this.OW, this.mSize, paramInt) ^ 0xFFFFFFFF;
      }
    }
    Object localObject;
    if (this.mSize >= this.OW.length)
    {
      j = d.idealIntArraySize(this.mSize + 1);
      localObject = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.OW, 0, localObject, 0, this.OW.length);
      System.arraycopy(this.OI, 0, arrayOfObject, 0, this.OI.length);
      this.OW = ((int[])localObject);
      this.OI = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      localObject = this.OW;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
      localObject = this.OI;
      System.arraycopy(localObject, i, localObject, i + 1, this.mSize - i);
    }
    this.OW[i] = paramInt;
    this.OI[i] = paramE;
    this.mSize += 1;
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
 * Qualified Name:     android.support.v4.e.o
 * JD-Core Version:    0.7.0.1
 */