package com.d.a.c;

public abstract class o<T>
  extends c
  implements q<T>
{
  public static final Object cmh = new Object();
  public static final o.a cmi = new o.a();
  protected transient Object[] cmf;
  protected final q<T> cmg = this;
  
  public o<T> Lp()
  {
    o localo = (o)super.clone();
    localo.cmf = ((Object[])this.cmf.clone());
    return localo;
  }
  
  public final int aD(T paramT)
  {
    if (paramT != null) {
      return paramT.hashCode();
    }
    return 0;
  }
  
  protected final int aE(T paramT)
  {
    Object[] arrayOfObject = this.cmf;
    int k = arrayOfObject.length;
    int m = this.cmg.aD(paramT) & 0x7FFFFFFF;
    int i = m % k;
    Object localObject2 = arrayOfObject[i];
    int j = i;
    Object localObject1 = localObject2;
    if (localObject2 != null) {
      if (localObject2 != cmh)
      {
        j = i;
        localObject1 = localObject2;
        if (this.cmg.equals(localObject2, paramT)) {}
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
          } while (localObject2 == cmh);
          j = i;
        } while (!this.cmg.equals(localObject2, paramT));
        localObject1 = localObject2;
        j = i;
      }
    }
    if (localObject1 == null) {
      j = -1;
    }
    return j;
  }
  
  protected final int aF(T paramT)
  {
    Object[] arrayOfObject = this.cmf;
    int m = arrayOfObject.length;
    int j = this.cmg.aD(paramT) & 0x7FFFFFFF;
    int i = j % m;
    Object localObject1 = arrayOfObject[i];
    if (localObject1 == null) {
      return i;
    }
    if ((localObject1 != cmh) && (this.cmg.equals(localObject1, paramT))) {
      return -i - 1;
    }
    int n = j % (m - 2) + 1;
    if (localObject1 == cmh) {
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
        if (localObject1 == cmh) {
          k = i;
        }
      }
      if ((localObject1 == null) || (localObject1 == cmh) || (this.cmg.equals(localObject1, paramT)))
      {
        if (localObject1 == cmh)
        {
          for (;;)
          {
            j = i;
            localObject2 = localObject1;
            if (localObject1 == null) {
              break;
            }
            if (localObject1 != cmh)
            {
              j = i;
              localObject2 = localObject1;
              if (this.cmg.equals(localObject1, paramT)) {
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
        if ((localObject2 != null) && (localObject2 != cmh)) {
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
  
  protected void aK(int paramInt)
  {
    this.cmf[paramInt] = cmh;
    super.aK(paramInt);
  }
  
  public final boolean b(t<T> paramt)
  {
    Object[] arrayOfObject = this.cmf;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject[j] != null) && (arrayOfObject[j] != cmh) && (!paramt.az(arrayOfObject[j]))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return aE(paramObject) >= 0;
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1.equals(paramT2);
    }
    return paramT2 == null;
  }
  
  protected int ip(int paramInt)
  {
    paramInt = super.ip(paramInt);
    this.cmf = new Object[paramInt];
    return paramInt;
  }
  
  protected final void p(Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =").append(paramObject1);
    Object localObject;
    if (paramObject1 == null)
    {
      localObject = "";
      localObject = localStringBuilder.append((String)localObject).append(", hashCode=").append(this.cmg.aD(paramObject1)).append("; object #2 =").append(paramObject2);
      if (paramObject2 != null) {
        break label125;
      }
    }
    label125:
    for (paramObject1 = "";; paramObject1 = " (" + paramObject2.getClass() + ")")
    {
      throw new IllegalArgumentException(paramObject1 + ", hashCode=" + this.cmg.aD(paramObject2));
      localObject = " (" + paramObject1.getClass() + ")";
      break;
    }
  }
  
  protected final int vh()
  {
    return this.cmf.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.o
 * JD-Core Version:    0.7.0.1
 */