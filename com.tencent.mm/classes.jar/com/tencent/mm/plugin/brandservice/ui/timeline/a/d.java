package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.storage.u;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "isSupportStyle", "style", "", "isTLRecCardWrapperLegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "plugin-brandservice_release"})
public final class d
{
  private static boolean mYH = true;
  
  public static final boolean a(dau paramdau)
  {
    AppMethodBeat.i(193039);
    k.h(paramdau, "wrapper");
    boolean bool = u.a(paramdau);
    AppMethodBeat.o(193039);
    return bool;
  }
  
  public static final boolean bCV()
  {
    return mYH;
  }
  
  public static final void bCW()
  {
    AppMethodBeat.i(193040);
    if (((b)g.ab(b.class)).a(b.a.pmN, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      mYH = bool;
      AppMethodBeat.o(193040);
      return;
    }
  }
  
  public static final boolean xC(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 4: 
    default: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */