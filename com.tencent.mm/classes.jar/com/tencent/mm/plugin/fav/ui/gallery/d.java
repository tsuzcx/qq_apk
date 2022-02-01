package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;

public final class d
{
  public afy dke;
  public g okO;
  
  public d(g paramg, afy paramafy)
  {
    this.okO = paramg;
    this.dke = paramafy;
  }
  
  public final boolean cjM()
  {
    return this.dke.dataType == 4;
  }
  
  public final boolean cjN()
  {
    return (this.dke.dataType == 4) && (this.dke.DgT != null) && (this.dke.DgT.DhU != null);
  }
  
  public final boolean cjO()
  {
    return this.dke.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */