package com.google.b;

public final class db
{
  private static final db cbC = new db(new int[0], new Object[0], false);
  boolean bPc;
  private int bXW = -1;
  private Object[] bZT;
  private int[] cbD;
  private int count = 0;
  
  private db()
  {
    this(new int[8], new Object[8], true);
  }
  
  private db(int[] paramArrayOfInt, Object[] paramArrayOfObject, boolean paramBoolean)
  {
    this.cbD = paramArrayOfInt;
    this.bZT = paramArrayOfObject;
    this.bPc = paramBoolean;
  }
  
  public static db Jr()
  {
    return cbC;
  }
  
  final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < this.count)
    {
      by.a(paramStringBuilder, paramInt, String.valueOf(dh.hP(this.cbD[i])), this.bZT[i]);
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
      if (!(paramObject instanceof db)) {
        return false;
      }
      paramObject = (db)paramObject;
      if (this.count == paramObject.count)
      {
        Object localObject = this.cbD;
        int[] arrayOfInt = paramObject.cbD;
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
          localObject = this.bZT;
          paramObject = paramObject.bZT;
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
    Object localObject = this.cbD;
    int i1 = this.count;
    int j = 0;
    int i = 17;
    while (j < i1)
    {
      i = i * 31 + localObject[j];
      j += 1;
    }
    localObject = this.bZT;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.db
 * JD-Core Version:    0.7.0.1
 */