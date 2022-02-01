package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;

public final class d
{
  public ajx dud;
  public g pyC;
  
  public d(g paramg, ajx paramajx)
  {
    this.pyC = paramg;
    this.dud = paramajx;
  }
  
  public final boolean cyG()
  {
    return this.dud.dataType == 4;
  }
  
  public final boolean cyH()
  {
    return (this.dud.dataType == 4) && (this.dud.GAu != null) && (this.dud.GAu.GBv != null);
  }
  
  public final boolean cyI()
  {
    return this.dud.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */