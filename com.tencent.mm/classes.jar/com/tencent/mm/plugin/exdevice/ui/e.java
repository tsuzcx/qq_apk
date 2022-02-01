package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.d;

final class e
{
  int azj;
  d qoQ;
  int qoR;
  
  private e(int paramInt1, int paramInt2, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(24309);
    this.azj = paramInt1;
    this.qoR = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramd != null)
      {
        this.qoQ = paramd;
        AppMethodBeat.o(24309);
        return;
      }
      paramd = new d();
      paramd.field_username = paramString2;
      paramd.field_appusername = paramString1;
      paramd.field_ranknum = 0;
      paramd.field_selfLikeState = 0;
      paramd.field_rankID = "";
      paramd.field_likecount = 0;
      paramd.field_score = 0;
      this.qoQ = paramd;
    }
    AppMethodBeat.o(24309);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24310);
    String str = "{ view type: " + this.azj + " display flag: " + this.qoR;
    if (this.qoQ != null) {}
    for (str = str + this.qoQ.toString();; str = str + " mExdeviceRankInfo is null")
    {
      str = str + "}";
      AppMethodBeat.o(24310);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */