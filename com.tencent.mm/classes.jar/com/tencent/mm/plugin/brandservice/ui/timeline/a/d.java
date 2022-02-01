package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.storage.v;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"TAG", "", "value", "", "isOpenFollow", "()Z", "setOpenFollow", "(Z)V", "isSupportStyle", "style", "", "isTLRecCardWrapperLegal", "wrapper", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "plugin-brandservice_release"})
public final class d
{
  private static boolean nBg = true;
  
  public static final boolean a(dgg paramdgg)
  {
    AppMethodBeat.i(198833);
    k.h(paramdgg, "wrapper");
    boolean bool = v.a(paramdgg);
    AppMethodBeat.o(198833);
    return bool;
  }
  
  public static final boolean bKd()
  {
    return nBg;
  }
  
  public static final void bKe()
  {
    AppMethodBeat.i(198834);
    if (((b)g.ab(b.class)).a(b.a.pQn, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      nBg = bool;
      AppMethodBeat.o(198834);
      return;
    }
  }
  
  public static final boolean yu(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.d
 * JD-Core Version:    0.7.0.1
 */