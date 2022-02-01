package com.tencent.mm.plugin.finder.feed;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "wordingSpan", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getWordingSpan", "()Landroid/text/SpannableString;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class x
  implements bo
{
  private final f tON;
  public final SpannableString tOO;
  public final bcw tOP;
  
  public x(bcw parambcw)
  {
    AppMethodBeat.i(243999);
    this.tOP = parambcw;
    this.tON = g.ah((a)new a(this));
    this.tOO = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.tOP.dQx);
    AppMethodBeat.o(243999);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(243997);
    p.h(parami, "obj");
    if (((parami instanceof x)) && (((x)parami).tOP.uOx == this.tOP.uOx) && (((x)parami).tOP.LLE == this.tOP.LLE) && (p.j(((x)parami).tOP.dQx, this.tOP.dQx)))
    {
      AppMethodBeat.o(243997);
      return 0;
    }
    AppMethodBeat.o(243997);
    return -1;
  }
  
  public final int cxn()
  {
    return 2002;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(243996);
    long l = ((Number)this.tON.getValue()).longValue();
    AppMethodBeat.o(243996);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243998);
    String str = "ItemId=" + lT() + ",ItemType=2002 wordingSpan=" + this.tOO;
    AppMethodBeat.o(243998);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x
 * JD-Core Version:    0.7.0.1
 */