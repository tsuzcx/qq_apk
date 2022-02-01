package com.tencent.mm.plugin.expt.hellhound.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fed;

public final class c
{
  public int chatFooterHeight = 0;
  public String finderLiveId = "";
  public String liveId;
  public int liveStatus;
  public String msgId;
  public int position;
  public fed zDG;
  public int zDH = -1;
  public boolean zDI = false;
  public String zDJ = "";
  public String zDK = "";
  public String zDL = "";
  
  final boolean LG(int paramInt)
  {
    AppMethodBeat.i(300140);
    int j = this.zDG.vpn + this.zDG.BqU;
    int i = j;
    if (paramInt != 0)
    {
      i = j;
      if (this.zDG.y == 0)
      {
        i = j;
        if (this.position == 0) {
          i = 0;
        }
      }
    }
    paramInt = this.zDG.pvg - this.zDG.virtualKeyHeight;
    j = Math.max(this.zDG.y, i);
    int k = this.zDG.y + this.zDG.height;
    int m = Math.min(k, paramInt);
    if (this.zDG.y >= paramInt)
    {
      AppMethodBeat.o(300140);
      return false;
    }
    if (k <= i)
    {
      AppMethodBeat.o(300140);
      return false;
    }
    if ((this.zDG.y >= i) && (k <= paramInt))
    {
      AppMethodBeat.o(300140);
      return true;
    }
    j = m - j;
    if (j / this.zDG.height >= 0.9F)
    {
      AppMethodBeat.o(300140);
      return true;
    }
    if (j / (paramInt - i) >= 0.5F)
    {
      AppMethodBeat.o(300140);
      return true;
    }
    AppMethodBeat.o(300140);
    return false;
  }
  
  public final String toString()
  {
    if (this.zDG.feedId == null) {
      return "NULL";
    }
    return this.zDG.feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.c
 * JD-Core Version:    0.7.0.1
 */