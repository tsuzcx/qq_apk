package com.c.a.c;

public abstract class n<T>
  extends b
  implements p<T>
{
  public static final Object cqE = new Object();
  public static final a cqF = new a();
  protected transient Object[] cqC;
  protected final p<T> cqD = this;
  
  public n<T> Ku()
  {
    n localn = (n)super.clone();
    localn.cqC = ((Object[])this.cqC.clone());
    return localn;
  }
  
  public final int aG(T paramT)
  {
    if (paramT != null) {
      return paramT.hashCode();
    }
    return 0;
  }
  
  protected final int aH(T paramT)
  {
    Object[] arrayOfObject = this.cqC;
    int k = arrayOfObject.length;
    int m = this.cqD.aG(paramT) & 0x7FFFFFFF;
    int i = m % k;
    Object localObject2 = arrayOfObject[i];
    int j = i;
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      if (localObject2 != cqE)
      {
        j = i;
        localObject1 = localObject2;
        if (this.cqD.equals(localObject2, paramT)) {}
      }
      else
      {
        j = i;
        do
        {
          do
          {
            j -= m % (k - 2) + 1;
            i = j;
            if (j < 0) {
              i = j + k;
            }
            localObject2 = arrayOfObject[i];
            j = i;
            localObject1 = localObject2;
            if (localObject2 == null) {
              break;
            }
            j = i;
          } while (localObject2 == cqE);
          j = i;
        } while (!this.cqD.equals(localObject2, paramT));
        localObject1 = localObject2;
        j = i;
      }
    }
    if (localObject1 == null) {
      j = -1;
    }
    return j;
  }
  
  protected final int aI(T paramT)
  {
    Object[] arrayOfObject = this.cqC;
    int m = arrayOfObject.length;
    int j = this.cqD.aG(paramT) & 0x7FFFFFFF;
    int i = j % m;
    Object localObject1 = arrayOfObject[i];
    if (localObject1 == null) {
      return i;
    }
    if ((localObject1 != cqE) && (this.cqD.equals(localObject1, paramT))) {
      return -i - 1;
    }
    int n = j % (m - 2) + 1;
    if (localObject1 == cqE) {
      j = i;
    }
    for (;;)
    {
      int k = i - n;
      i = k;
      if (k < 0) {
        i = k + m;
      }
      localObject1 = arrayOfObject[i];
      k = j;
      if (j == -1)
      {
        k = j;
        if (localObject1 == cqE) {
          k = i;
        }
      }
      if ((localObject1 == null) || (localObject1 == cqE) || (this.cqD.equals(localObject1, paramT)))
      {
        if (localObject1 == cqE)
        {
          for (;;)
          {
            j = i;
            localObject2 = localObject1;
            if (localObject1 == null) {
              break;
            }
            if (localObject1 != cqE)
            {
              j = i;
              localObject2 = localObject1;
              if (this.cqD.equals(localObject1, paramT)) {
                break;
              }
            }
            j = i - n;
            i = j;
            if (j < 0) {
              i = j + m;
            }
            localObject1 = arrayOfObject[i];
          }
          j = -1;
          continue;
        }
        Object localObject2 = localObject1;
        j = i;
        if ((localObject2 != null) && (localObject2 != cqE)) {
          return -j - 1;
        }
        i = j;
        if (k == -1) {
          break;
        }
        return k;
      }
      j = k;
    }
  }
  
  public final boolean b(s<T> params)
  {
    Object[] arrayOfObject = this.cqC;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject[j] != null) && (arrayOfObject[j] != cqE) && (!params.aD(arrayOfObject[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  protected final int capacity()
  {
    return this.cqC.length;
  }
  
  public boolean contains(Object paramObject)
  {
    return aH(paramObject) >= 0;
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1.equals(paramT2);
    }
    return paramT2 == null;
  }
  
  protected int hw(int paramInt)
  {
    paramInt = super.hw(paramInt);
    this.cqC = new Object[paramInt];
    return paramInt;
  }
  
  protected void removeAt(int paramInt)
  {
    this.cqC[paramInt] = cqE;
    super.removeAt(paramInt);
  }
  
  protected final void w(Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =").append(paramObject1);
    Object localObject;
    if (paramObject1 == null)
    {
      localObject = "";
      localObject = localStringBuilder.append((String)localObject).append(", hashCode=").append(this.cqD.aG(paramObject1)).append("; object #2 =").append(paramObject2);
      if (paramObject2 != null) {
        break label125;
      }
    }
    label125:
    for (paramObject1 = "";; paramObject1 = " (" + paramObject2.getClass() + ")")
    {
      throw new IllegalArgumentException(paramObject1 + ", hashCode=" + this.cqD.aG(paramObject2));
      localObject = " (" + paramObject1.getClass() + ")";
      break;
    }
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.n
 * JD-Core Version:    0.7.0.1
 */