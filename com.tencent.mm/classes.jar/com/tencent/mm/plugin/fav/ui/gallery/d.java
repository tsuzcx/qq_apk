package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;

public final class d
{
  public agx dhz;
  public g oOo;
  
  public d(g paramg, agx paramagx)
  {
    this.oOo = paramg;
    this.dhz = paramagx;
  }
  
  public final boolean crt()
  {
    return this.dhz.dataType == 4;
  }
  
  public final boolean cru()
  {
    return (this.dhz.dataType == 4) && (this.dhz.EzZ != null) && (this.dhz.EzZ.EBa != null);
  }
  
  public final boolean crv()
  {
    return this.dhz.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */