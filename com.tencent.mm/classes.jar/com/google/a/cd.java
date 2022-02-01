package com.google.a;

import java.util.Arrays;

public final class cd
{
  private static final cd bZZ = new cd(0, new int[0], new Object[0], false);
  boolean bNd;
  private int bVY = -1;
  private Object[] bYp;
  private int[] caa;
  private int count;
  
  private cd()
  {
    this(0, new int[8], new Object[8], true);
  }
  
  private cd(int paramInt, int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.count = paramInt;
    this.caa = paramArrayOfInt;
    this.bYp = paramArrayOfObject;
    this.bNd = paramBoolean;
  }
  
  public static cd HR()
  {
    return bZZ;
  }
  
  static cd a(cd paramcd1, cd paramcd2)
  {
    int i = paramcd1.count + paramcd2.count;
    int[] arrayOfInt = Arrays.copyOf(paramcd1.caa, i);
    System.arraycopy(paramcd2.caa, 0, arrayOfInt, paramcd1.count, paramcd2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramcd1.bYp, i);
    System.arraycopy(paramcd2.bYp, 0, arrayOfObject, paramcd1.count, paramcd2.count);
    return new cd(i, arrayOfInt, arrayOfObject, true);
  }
  
  final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.count)
    {
      ay.a(paramStringBuilder, paramInt, String.valueOf(cj.gY(this.caa[i])), this.bYp[i]);
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
      if (!(paramObject instanceof cd)) {
        return false;
      }
      paramObject = (cd)paramObject;
      if (this.count == paramObject.count)
      {
        Object localObject = this.caa;
        int[] arrayOfInt = paramObject.caa;
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
          localObject = this.bYp;
          paramObject = paramObject.bYp;
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
  
  public final int hashCode()
  {
    int k = 17;
    int m = 0;
    int n = this.count;
    Object localObject = this.caa;
    int i1 = this.count;
    int j = 0;
    int i = 17;
    while (j < i1)
    {
      i = i * 31 + localObject[j];
      j += 1;
    }
    localObject = this.bYp;
    i1 = this.count;
    j = m;
    while (j < i1)
    {
      k = k * 31 + localObject[j].hashCode();
      j += 1;
    }
    return ((n + 527) * 31 + i) * 31 + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.cd
 * JD-Core Version:    0.7.0.1
 */