package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.plugin.exdevice.f.b.a.d;

final class e
{
  int amH;
  d jHR;
  int jHS;
  
  private e(int paramInt1, int paramInt2, String paramString1, String paramString2, d paramd)
  {
    this.amH = paramInt1;
    this.jHS = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramd != null) {
        this.jHR = paramd;
      }
    }
    else {
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
    this.jHR = paramd;
  }
  
  public final String toString()
  {
    String str = "{ view type: " + this.amH + " display flag: " + this.jHS;
    if (this.jHR != null) {}
    for (str = str + this.jHR.toString();; str = str + " mExdeviceRankInfo is null") {
      return str + "}";
    }
  }
  
  static final class a
  {
    int amH;
    String jFa;
    d jHR = null;
    int jHS;
    String username;
    
    public final e aMV()
    {
      return new e(this.amH, this.jHS, this.jFa, this.username, this.jHR, (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.e
 * JD-Core Version:    0.7.0.1
 */