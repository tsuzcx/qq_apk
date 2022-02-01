package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;

public final class d
{
  public aml dLo;
  public g qNT;
  
  public d(g paramg, aml paramaml)
  {
    this.qNT = paramg;
    this.dLo = paramaml;
  }
  
  public final boolean cWJ()
  {
    return this.dLo.dataType == 4;
  }
  
  public final boolean cWK()
  {
    return (this.dLo.dataType == 4) && (this.dLo.Lwh != null) && (this.dLo.Lwh.Lxi != null);
  }
  
  public final boolean cWL()
  {
    return this.dLo.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */