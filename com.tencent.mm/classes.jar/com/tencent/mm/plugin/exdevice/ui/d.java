package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d
{
  com.tencent.mm.plugin.exdevice.g.b.a.d yEC;
  int yED;
  int yf;
  
  private d(int paramInt1, int paramInt2, String paramString1, String paramString2, com.tencent.mm.plugin.exdevice.g.b.a.d paramd)
  {
    AppMethodBeat.i(24309);
    this.yf = paramInt1;
    this.yED = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramd != null)
      {
        this.yEC = paramd;
        AppMethodBeat.o(24309);
        return;
      }
      paramd = new com.tencent.mm.plugin.exdevice.g.b.a.d();
      paramd.field_username = paramString2;
      paramd.field_appusername = paramString1;
      paramd.field_ranknum = 0;
      paramd.field_selfLikeState = 0;
      paramd.field_rankID = "";
      paramd.field_likecount = 0;
      paramd.field_score = 0;
      this.yEC = paramd;
    }
    AppMethodBeat.o(24309);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24310);
    String str = "{ view type: " + this.yf + " display flag: " + this.yED;
    if (this.yEC != null) {}
    for (str = str + this.yEC.toString();; str = str + " mExdeviceRankInfo is null")
    {
      str = str + "}";
      AppMethodBeat.o(24310);
      return str;
    }
  }
  
  static final class a
  {
    String appusername;
    String username;
    com.tencent.mm.plugin.exdevice.g.b.a.d yEC = null;
    int yED;
    int yf;
    
    public final d dHo()
    {
      AppMethodBeat.i(24308);
      d locald = new d(this.yf, this.yED, this.appusername, this.username, this.yEC, (byte)0);
      AppMethodBeat.o(24308);
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.d
 * JD-Core Version:    0.7.0.1
 */