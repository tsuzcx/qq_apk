package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.vfs.u;

public final class d
{
  public arf hIT;
  public g xvD;
  
  public d(g paramg, arf paramarf)
  {
    this.xvD = paramg;
    this.hIT = paramarf;
  }
  
  public final String aJL()
  {
    AppMethodBeat.i(274523);
    if (dSI())
    {
      str = this.hIT.hDd;
      AppMethodBeat.o(274523);
      return str;
    }
    if ((dSH()) || (dSJ()))
    {
      str = b.a(this.hIT);
      AppMethodBeat.o(274523);
      return str;
    }
    String str = b.d(this.hIT);
    if (new u(str).jKS())
    {
      AppMethodBeat.o(274523);
      return str;
    }
    str = b.a(this.hIT);
    AppMethodBeat.o(274523);
    return str;
  }
  
  public final boolean dSH()
  {
    return this.hIT.dataType == 4;
  }
  
  public final boolean dSI()
  {
    return (this.hIT.dataType == 4) && (this.hIT.Zzy != null) && (this.hIT.Zzy.ZAz != null);
  }
  
  public final boolean dSJ()
  {
    return this.hIT.dataType == 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.d
 * JD-Core Version:    0.7.0.1
 */