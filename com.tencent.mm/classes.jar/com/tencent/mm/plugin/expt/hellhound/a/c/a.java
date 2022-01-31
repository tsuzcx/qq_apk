package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.mm.protocal.protobuf.cdy;

final class a
{
  cdy mbc;
  
  final boolean bsw()
  {
    int i = this.mbc.qZo;
    int k = this.mbc.xOw + i;
    int m = this.mbc.iiX - this.mbc.xOv;
    int n;
    if (this.mbc.y >= k)
    {
      i = this.mbc.y;
      j = this.mbc.y;
      n = this.mbc.height + j;
      if (n < m) {
        break label102;
      }
    }
    label102:
    for (int j = m;; j = n)
    {
      if (this.mbc.y < m) {
        break label108;
      }
      return false;
      i = k;
      break;
    }
    label108:
    if (n <= k) {
      return false;
    }
    if ((this.mbc.y >= k) && (n <= m)) {
      return true;
    }
    i = j - i;
    if (i / this.mbc.height >= 0.9F) {
      return true;
    }
    return i / (m - k) >= 0.5F;
  }
  
  public final String toString()
  {
    return this.mbc.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */