package com.h.a.c;

public abstract class n<T>
  extends b
  implements p<T>
{
  public static final a ecA = new a();
  public static final Object ecz = new Object();
  protected transient Object[] ecx;
  protected final p<T> ecy = this;
  
  protected final void A(Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =").append(paramObject1);
    Object localObject;
    if (paramObject1 == null)
    {
      localObject = "";
      localObject = localStringBuilder.append((String)localObject).append(", hashCode=").append(this.ecy.bX(paramObject1)).append("; object #2 =").append(paramObject2);
      if (paramObject2 != null) {
        break label125;
      }
    }
    label125:
    for (paramObject1 = "";; paramObject1 = " (" + paramObject2.getClass() + ")")
    {
      throw new IllegalArgumentException(paramObject1 + ", hashCode=" + this.ecy.bX(paramObject2));
      localObject = " (" + paramObject1.getClass() + ")";
      break;
    }
  }
  
  protected final int UG()
  {
    return this.ecx.length;
  }
  
  public n<T> alq()
  {
    n localn = (n)super.clone();
    localn.ecx = ((Object[])this.ecx.clone());
    return localn;
  }
  
  public final boolean b(s<T> params)
  {
    Object[] arrayOfObject = this.ecx;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject[j] != null) && (arrayOfObject[j] != ecz) && (!params.bU(arrayOfObject[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public final int bX(T paramT)
  {
    if (paramT != null) {
      return paramT.hashCode();
    }
    return 0;
  }
  
  protected final int bY(T paramT)
  {
    Object[] arrayOfObject = this.ecx;
    int k = arrayOfObject.length;
    int m = this.ecy.bX(paramT) & 0x7FFFFFFF;
    int i = m % k;
    Object localObject2 = arrayOfObject[i];
    int j = i;
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      if (localObject2 != ecz)
      {
        j = i;
        localObject1 = localObject2;
        if (this.ecy.equals(localObject2, paramT)) {}
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
          } while (localObject2 == ecz);
          j = i;
        } while (!this.ecy.equals(localObject2, paramT));
        localObject1 = localObject2;
        j = i;
      }
    }
    if (localObject1 == null) {
      j = -1;
    }
    return j;
  }
  
  protected final int bZ(T paramT)
  {
    Object[] arrayOfObject = this.ecx;
    int m = arrayOfObject.length;
    int j = this.ecy.bX(paramT) & 0x7FFFFFFF;
    int i = j % m;
    Object localObject1 = arrayOfObject[i];
    if (localObject1 == null) {
      return i;
    }
    if ((localObject1 != ecz) && (this.ecy.equals(localObject1, paramT))) {
      return -i - 1;
    }
    int n = j % (m - 2) + 1;
    if (localObject1 == ecz) {
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
        if (localObject1 == ecz) {
          k = i;
        }
      }
      if ((localObject1 == null) || (localObject1 == ecz) || (this.ecy.equals(localObject1, paramT)))
      {
        if (localObject1 == ecz)
        {
          for (;;)
          {
            j = i;
            localObject2 = localObject1;
            if (localObject1 == null) {
              break;
            }
            if (localObject1 != ecz)
            {
              j = i;
              localObject2 = localObject1;
              if (this.ecy.equals(localObject1, paramT)) {
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
        if ((localObject2 != null) && (localObject2 != ecz)) {
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
  
  protected void bj(int paramInt)
  {
    this.ecx[paramInt] = ecz;
    super.bj(paramInt);
  }
  
  public boolean contains(Object paramObject)
  {
    return bY(paramObject) >= 0;
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1.equals(paramT2);
    }
    return paramT2 == null;
  }
  
  protected int lU(int paramInt)
  {
    paramInt = super.lU(paramInt);
    this.ecx = new Object[paramInt];
    return paramInt;
  }
  
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.h.a.c.n
 * JD-Core Version:    0.7.0.1
 */