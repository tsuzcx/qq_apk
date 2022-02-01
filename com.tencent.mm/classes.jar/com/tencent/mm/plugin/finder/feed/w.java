package com.tencent.mm.plugin.finder.feed;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "wordingSpan", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getWordingSpan", "()Landroid/text/SpannableString;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class w
  implements al
{
  private final f rWv;
  public final SpannableString rWw;
  public final arp rWx;
  
  public w(arp paramarp)
  {
    AppMethodBeat.i(201976);
    this.rWx = paramarp;
    this.rWv = g.O((a)new a(this));
    this.rWw = k.c(aj.getContext(), (CharSequence)this.rWx.dxD);
    AppMethodBeat.o(201976);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(201974);
    p.h(parami, "obj");
    if (((parami instanceof w)) && (((w)parami).rWx.Gpl == this.rWx.Gpl) && (((w)parami).rWx.Gpr == this.rWx.Gpr) && (p.i(((w)parami).rWx.dxD, this.rWx.dxD)))
    {
      AppMethodBeat.o(201974);
      return 0;
    }
    AppMethodBeat.o(201974);
    return -1;
  }
  
  public final int bYk()
  {
    return 2002;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(201973);
    long l = ((Number)this.rWv.getValue()).longValue();
    AppMethodBeat.o(201973);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201975);
    String str = "ItemId=" + lP() + ",ItemType=2002 wordingSpan=" + this.rWw;
    AppMethodBeat.o(201975);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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