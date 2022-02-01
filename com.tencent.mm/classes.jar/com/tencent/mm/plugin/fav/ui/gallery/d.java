package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;

public final class d
{
  public ajn dsX;
  public g prW;
  
  public d(g paramg, ajn paramajn)
  {
    this.prW = paramg;
    this.dsX = paramajn;
  }
  
  public final boolean cxf()
  {
    return this.dsX.dataType == 4;
  }
  
  public final boolean cxg()
  {
    return (this.dsX.dataType == 4) && (this.dsX.GhL != null) && (this.dsX.GhL.GiM != null);
  }
  
  public final boolean cxh()
  {
    return this.dsX.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */