package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzv;

public final class c
{
  public int chatFooterHeight = 0;
  public String finderLiveId = "";
  public String hJs;
  public int liveStatus;
  public String msgId;
  public int position;
  public dzv sBK;
  public int sBL = -1;
  public boolean sBM = false;
  public String sBN = "";
  
  final boolean GX(int paramInt)
  {
    AppMethodBeat.i(220454);
    int j = this.sBK.CHZ + this.sBK.udM;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.sBK.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.sBK.mEY - this.sBK.virtualKeyHeight;
    j = Math.max(this.sBK.y, i);
    int k = this.sBK.y + this.sBK.height;
    int m = Math.min(k, paramInt);
    if (this.sBK.y >= paramInt)
    {
      AppMethodBeat.o(220454);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(220454);
      return false;
    }
    if ((this.sBK.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(220454);
      return true;
    }
    j = m - j;
    if (j / this.sBK.height >= 0.9F)
    {
      AppMethodBeat.o(220454);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(220454);
      return true;
    }
    AppMethodBeat.o(220454);
    return false;
  }
  
  public final boolean bJw()
  {
    int i = this.sBK.CHZ;
    int j = this.sBK.udM;
    int k = this.sBK.mEY;
    int m = this.sBK.virtualKeyHeight;
    int n = this.sBK.y;
    int i1 = this.sBK.height;
    if (this.sBK.y >= k - m) {}
    while (n + i1 <= i + j) {
      return false;
    }
    return true;
  }
  
  public final boolean cOA()
  {
    int i = this.sBK.CHZ;
    int j = this.sBK.udM;
    int k = this.sBK.mEY;
    int m = this.sBK.virtualKeyHeight;
    int n = this.chatFooterHeight;
    int i1 = this.sBK.y;
    int i2 = this.sBK.height;
    if (this.sBK.y >= k - m - n) {}
    while (i1 + i2 <= i + j) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    if (this.sBK.feedId == null) {
      return "NULL";
    }
    return this.sBK.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */