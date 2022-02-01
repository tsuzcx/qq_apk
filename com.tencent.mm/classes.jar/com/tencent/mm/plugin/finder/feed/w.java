package com.tencent.mm.plugin.finder.feed;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ak;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "wordingSpan", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getWordingSpan", "()Landroid/text/SpannableString;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class w
  implements am
{
  private final f sfg;
  public final SpannableString sfh;
  public final ase sfi;
  
  public w(ase paramase)
  {
    AppMethodBeat.i(202440);
    this.sfi = paramase;
    this.sfg = g.O((a)new a(this));
    this.sfh = k.c(ak.getContext(), (CharSequence)this.sfi.dyI);
    AppMethodBeat.o(202440);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202438);
    p.h(parami, "obj");
    if (((parami instanceof w)) && (((w)parami).sfi.GIB == this.sfi.GIB) && (((w)parami).sfi.GIL == this.sfi.GIL) && (p.i(((w)parami).sfi.dyI, this.sfi.dyI)))
    {
      AppMethodBeat.o(202438);
      return 0;
    }
    AppMethodBeat.o(202438);
    return -1;
  }
  
  public final int bZz()
  {
    return 2002;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202437);
    long l = ((Number)this.sfg.getValue()).longValue();
    AppMethodBeat.o(202437);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202439);
    String str = "ItemId=" + lP() + ",ItemType=2002 wordingSpan=" + this.sfh;
    AppMethodBeat.o(202439);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.w
 * JD-Core Version:    0.7.0.1
 */