package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.sdk.platformtools.aj;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class v
  implements al
{
  private final f rWv;
  final arp rWx;
  public final SpannableString skn;
  public final int sko;
  
  public v(arp paramarp)
  {
    AppMethodBeat.i(202962);
    this.rWx = paramarp;
    this.rWv = g.O((a)new a(this));
    this.skn = k.c(aj.getContext(), (CharSequence)this.rWx.dxD);
    this.sko = this.rWx.Gpr;
    AppMethodBeat.o(202962);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(202960);
    p.h(parami, "obj");
    if (((parami instanceof v)) && (((v)parami).rWx.Gpl == this.rWx.Gpl) && (((v)parami).rWx.Gpr == this.rWx.Gpr) && (p.i(((v)parami).rWx.dxD, this.rWx.dxD)))
    {
      AppMethodBeat.o(202960);
      return 0;
    }
    AppMethodBeat.o(202960);
    return -1;
  }
  
  public final int bYk()
  {
    return 2011;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(202959);
    long l = ((Number)this.rWv.getValue()).longValue();
    AppMethodBeat.o(202959);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202961);
    String str = "ItemId=" + lP() + ",ItemType=2011 tipStyle=" + this.sko + " tip=" + this.skn;
    AppMethodBeat.o(202961);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.v
 * JD-Core Version:    0.7.0.1
 */