package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ejv;

public final class c
{
  public int chatFooterHeight = 0;
  public String finderLiveId = "";
  public String kwM;
  public int liveStatus;
  public String msgId;
  public int position;
  public ejv whE;
  public int whF = -1;
  public boolean whG = false;
  public String whH = "";
  public String whI = "";
  
  final boolean KH(int paramInt)
  {
    AppMethodBeat.i(256911);
    int j = this.whE.INC + this.whE.xRu;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.whE.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.whE.pEk - this.whE.virtualKeyHeight;
    j = Math.max(this.whE.y, i);
    int k = this.whE.y + this.whE.height;
    int m = Math.min(k, paramInt);
    if (this.whE.y >= paramInt)
    {
      AppMethodBeat.o(256911);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(256911);
      return false;
    }
    if ((this.whE.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(256911);
      return true;
    }
    j = m - j;
    if (j / this.whE.height >= 0.9F)
    {
      AppMethodBeat.o(256911);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(256911);
      return true;
    }
    AppMethodBeat.o(256911);
    return false;
  }
  
  public final boolean bVd()
  {
    int i = this.whE.INC;
    int j = this.whE.xRu;
    int k = this.whE.pEk;
    int m = this.whE.virtualKeyHeight;
    int n = this.whE.y;
    int i1 = this.whE.height;
    if (this.whE.y >= k - m) {}
    while (n + i1 <= i + j) {
      return false;
    }
    return true;
  }
  
  public final boolean dds()
  {
    int i = this.whE.INC;
    int j = this.whE.xRu;
    int k = this.whE.pEk;
    int m = this.whE.virtualKeyHeight;
    int n = this.chatFooterHeight;
    int i1 = this.whE.y;
    int i2 = this.whE.height;
    if (this.whE.y >= k - m - n) {}
    while (i1 + i2 <= i + j) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    if (this.whE.feedId == null) {
      return "NULL";
    }
    return this.whE.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.c
 * JD-Core Version:    0.7.0.1
 */