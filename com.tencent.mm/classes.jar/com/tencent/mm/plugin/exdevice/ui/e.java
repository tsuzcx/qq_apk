package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e
{
  int aoW;
  d lRp;
  int lRq;
  
  private e(int paramInt1, int paramInt2, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(20235);
    this.aoW = paramInt1;
    this.lRq = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramd != null)
      {
        this.lRp = paramd;
        AppMethodBeat.o(20235);
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
      this.lRp = paramd;
    }
    AppMethodBeat.o(20235);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(20236);
    String str = "{ view type: " + this.aoW + " display flag: " + this.lRq;
    if (this.lRp != null) {}
    for (str = str + this.lRp.toString();; str = str + " mExdeviceRankInfo is null")
    {
      str = str + "}";
      AppMethodBeat.o(20236);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */