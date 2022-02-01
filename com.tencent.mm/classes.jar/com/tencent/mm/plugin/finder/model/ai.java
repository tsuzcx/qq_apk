package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ai
  implements bo
{
  private final f tON;
  final bcw tOP;
  public final SpannableString uOt;
  public final int uOu;
  
  public ai(bcw parambcw)
  {
    AppMethodBeat.i(248766);
    this.tOP = parambcw;
    this.tON = g.ah((a)new a(this));
    this.uOt = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.tOP.dQx);
    this.uOu = this.tOP.LLE;
    AppMethodBeat.o(248766);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248764);
    p.h(parami, "obj");
    if (((parami instanceof ai)) && (((ai)parami).tOP.uOx == this.tOP.uOx) && (((ai)parami).tOP.LLE == this.tOP.LLE) && (p.j(((ai)parami).tOP.dQx, this.tOP.dQx)))
    {
      AppMethodBeat.o(248764);
      return 0;
    }
    AppMethodBeat.o(248764);
    return -1;
  }
  
  public final int cxn()
  {
    return 2011;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248763);
    long l = ((Number)this.tON.getValue()).longValue();
    AppMethodBeat.o(248763);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248765);
    String str = "ItemId=" + lT() + ",ItemType=2011 tipStyle=" + this.uOu + " tip=" + this.uOt;
    AppMethodBeat.o(248765);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(ai paramai)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ai
 * JD-Core Version:    0.7.0.1
 */