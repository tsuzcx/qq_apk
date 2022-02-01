package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.vfs.q;

public final class d
{
  public anm fEd;
  public g upg;
  
  public d(g paramg, anm paramanm)
  {
    this.upg = paramg;
    this.fEd = paramanm;
  }
  
  public final String apK()
  {
    AppMethodBeat.i(230060);
    if (dlS())
    {
      str = this.fEd.fyu;
      AppMethodBeat.o(230060);
      return str;
    }
    if ((dlR()) || (dlT()))
    {
      str = b.a(this.fEd);
      AppMethodBeat.o(230060);
      return str;
    }
    String str = b.d(this.fEd);
    if (new q(str).ifE())
    {
      AppMethodBeat.o(230060);
      return str;
    }
    str = b.a(this.fEd);
    AppMethodBeat.o(230060);
    return str;
  }
  
  public final boolean dlR()
  {
    return this.fEd.dataType == 4;
  }
  
  public final boolean dlS()
  {
    return (this.fEd.dataType == 4) && (this.fEd.SyG != null) && (this.fEd.SyG.SzH != null);
  }
  
  public final boolean dlT()
  {
    return this.fEd.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */