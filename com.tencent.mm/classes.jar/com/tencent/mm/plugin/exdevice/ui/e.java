package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.g.b.a.d;

final class e
{
  int axs;
  d pLl;
  int pLm;
  
  private e(int paramInt1, int paramInt2, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(24309);
    this.axs = paramInt1;
    this.pLm = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramd != null)
      {
        this.pLl = paramd;
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
      this.pLl = paramd;
    }
    AppMethodBeat.o(24309);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24310);
    String str = "{ view type: " + this.axs + " display flag: " + this.pLm;
    if (this.pLl != null) {}
    for (str = str + this.pLl.toString();; str = str + " mExdeviceRankInfo is null")
    {
      str = str + "}";
      AppMethodBeat.o(24310);
      return str;
    }
  }
  
  static final class a
  {
    int axs;
    String pIw;
    d pLl = null;
    int pLm;
    String username;
    
    public final e cib()
    {
      AppMethodBeat.i(24308);
      e locale = new e(this.axs, this.pLm, this.pIw, this.username, this.pLl, (byte)0);
      AppMethodBeat.o(24308);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */