package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private int[] hjo;
  private int[] hjp;
  private boolean hjq;
  private int size;
  int unit;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(186202);
    this.hjq = true;
    this.size = 5;
    this.hjo = new int[5];
    this.hjp = new int[5];
    this.unit = 61166;
    this.hjq = false;
    AppMethodBeat.o(186202);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.hjq) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.size)) {
      return;
    }
    this.hjo[paramInt1] = paramInt2;
    this.hjp[paramInt1] = paramInt3;
  }
  
  public final int pB(int paramInt)
  {
    if (this.hjq) {}
    for (;;)
    {
      return -1;
      int i = 0;
      int j = this.size - 1;
      while (i <= j)
      {
        int k = (i & j) + ((i ^ j) >> 1);
        int m = this.hjo[k];
        int n = this.hjp[k];
        if ((paramInt >= m) && (paramInt <= n)) {
          return k;
        }
        if (paramInt < m) {
          j = k - 1;
        } else {
          i = k + 1;
        }
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186203);
    if (this.hjq)
    {
      localObject = super.toString();
      AppMethodBeat.o(186203);
      return localObject;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.size)
    {
      int j = this.hjo[i];
      int k = this.hjp[i];
      ((StringBuilder)localObject).append("[").append(j).append(", ").append(k).append(")\n");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(186203);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.e.d
 * JD-Core Version:    0.7.0.1
 */