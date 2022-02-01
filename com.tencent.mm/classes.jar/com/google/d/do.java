package com.google.d;

import java.util.Arrays;

public final class do
{
  private static final do dWd = new do(new int[0], new Object[0], false);
  int count = 0;
  boolean dIE;
  int dRJ = -1;
  Object[] dUb;
  int[] dWe;
  
  private do()
  {
    this(new int[8], new Object[8], true);
  }
  
  private do(int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.dWe = paramArrayOfInt;
    this.dUb = paramArrayOfObject;
    this.dIE = paramBoolean;
  }
  
  public static do ajM()
  {
    return dWd;
  }
  
  static do ajN()
  {
    return new do();
  }
  
  private static void b(int paramInt, Object paramObject, dv paramdv)
  {
    int i = du.lE(paramInt);
    switch (du.lD(paramInt))
    {
    case 4: 
    default: 
      throw new RuntimeException(bk.aio());
    case 0: 
      paramdv.t(i, ((Long)paramObject).longValue());
      return;
    case 5: 
      paramdv.cI(i, ((Integer)paramObject).intValue());
      return;
    case 1: 
      paramdv.p(i, ((Long)paramObject).longValue());
      return;
    case 2: 
      paramdv.a(i, (h)paramObject);
      return;
    }
    if (paramdv.aaP() == dv.a.dXp)
    {
      paramdv.kz(i);
      ((do)paramObject).a(paramdv);
      paramdv.kA(i);
      return;
    }
    paramdv.kA(i);
    ((do)paramObject).a(paramdv);
    paramdv.kz(i);
  }
  
  public final void a(dv paramdv)
  {
    if (this.count == 0) {}
    for (;;)
    {
      return;
      int i;
      if (paramdv.aaP() == dv.a.dXp)
      {
        i = 0;
        while (i < this.count)
        {
          b(this.dWe[i], this.dUb[i], paramdv);
          i += 1;
        }
      }
      else
      {
        i = this.count - 1;
        while (i >= 0)
        {
          b(this.dWe[i], this.dUb[i], paramdv);
          i -= 1;
        }
      }
    }
  }
  
  final void b(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.count)
    {
      cg.a(paramStringBuilder, paramInt, String.valueOf(du.lE(this.dWe[i])), this.dUb[i]);
      i += 1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label130:
    label135:
    label142:
    label145:
    for (;;)
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof do)) {
        return false;
      }
      paramObject = (do)paramObject;
      if (this.count == paramObject.count)
      {
        Object localObject = this.dWe;
        int[] arrayOfInt = paramObject.dWe;
        int j = this.count;
        i = 0;
        if (i >= j) {
          break label130;
        }
        if (localObject[i] == arrayOfInt[i]) {
          break label123;
        }
        i = 0;
        label75:
        if (i != 0)
        {
          localObject = this.dUb;
          paramObject = paramObject.dUb;
          j = this.count;
          i = 0;
          label97:
          if (i >= j) {
            break label142;
          }
          if (localObject[i].equals(paramObject[i])) {
            break label135;
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          break label145;
        }
        return false;
        label123:
        i += 1;
        break;
        i = 1;
        break label75;
        i += 1;
        break label97;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    int i = this.dRJ;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    if (j < this.count)
    {
      int k = this.dWe[j];
      int m = du.lE(k);
      switch (du.lD(k))
      {
      case 4: 
      default: 
        throw new IllegalStateException(bk.aio());
      case 0: 
        i += k.r(m, ((Long)this.dUb[j]).longValue());
      }
      for (;;)
      {
        j += 1;
        break;
        ((Integer)this.dUb[j]).intValue();
        i += k.kh(m);
        continue;
        ((Long)this.dUb[j]).longValue();
        i += k.kj(m);
        continue;
        i += k.c(m, (h)this.dUb[j]);
        continue;
        k = k.ko(m);
        i += ((do)this.dUb[j]).getSerializedSize() + k * 2;
      }
    }
    this.dRJ = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 17;
    int m = 0;
    int n = this.count;
    Object localObject = this.dWe;
    int i1 = this.count;
    int j = 0;
    int i = 17;
    while (j < i1)
    {
      i = i * 31 + localObject[j];
      j += 1;
    }
    localObject = this.dUb;
    i1 = this.count;
    j = m;
    while (j < i1)
    {
      k = k * 31 + localObject[j].hashCode();
      j += 1;
    }
    return ((n + 527) * 31 + i) * 31 + k;
  }
  
  final void y(int paramInt, Object paramObject)
  {
    if (!this.dIE) {
      throw new UnsupportedOperationException();
    }
    if (this.count == this.dWe.length) {
      if (this.count >= 4) {
        break label100;
      }
    }
    label100:
    for (int i = 8;; i = this.count >> 1)
    {
      i += this.count;
      this.dWe = Arrays.copyOf(this.dWe, i);
      this.dUb = Arrays.copyOf(this.dUb, i);
      this.dWe[this.count] = paramInt;
      this.dUb[this.count] = paramObject;
      this.count += 1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.do
 * JD-Core Version:    0.7.0.1
 */