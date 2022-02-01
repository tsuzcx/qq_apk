package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ak;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class w
  implements am
{
  private final f sfg;
  final ase sfi;
  public final SpannableString stk;
  public final int stl;
  
  public w(ase paramase)
  {
    AppMethodBeat.i(203445);
    this.sfi = paramase;
    this.sfg = g.O((a)new a(this));
    this.stk = k.c(ak.getContext(), (CharSequence)this.sfi.dyI);
    this.stl = this.sfi.GIL;
    AppMethodBeat.o(203445);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(203443);
    p.h(parami, "obj");
    if (((parami instanceof w)) && (((w)parami).sfi.GIB == this.sfi.GIB) && (((w)parami).sfi.GIL == this.sfi.GIL) && (p.i(((w)parami).sfi.dyI, this.sfi.dyI)))
    {
      AppMethodBeat.o(203443);
      return 0;
    }
    AppMethodBeat.o(203443);
    return -1;
  }
  
  public final int bZz()
  {
    return 2011;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(203442);
    long l = ((Number)this.sfg.getValue()).longValue();
    AppMethodBeat.o(203442);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203444);
    String str = "ItemId=" + lP() + ",ItemType=2011 tipStyle=" + this.stl + " tip=" + this.stk;
    AppMethodBeat.o(203444);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.w
 * JD-Core Version:    0.7.0.1
 */