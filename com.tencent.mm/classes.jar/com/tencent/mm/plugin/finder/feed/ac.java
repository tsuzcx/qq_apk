package com.tencent.mm.plugin.finder.feed;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "wordingSpan", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getWordingSpan", "()Landroid/text/SpannableString;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ac
  implements bu
{
  public final SpannableString xzA;
  public final bjr xzB;
  private final f xzz;
  
  public ac(bjr parambjr)
  {
    AppMethodBeat.i(268696);
    this.xzB = parambjr;
    this.xzz = g.ar((a)new a(this));
    this.xzA = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.xzB.wording);
    AppMethodBeat.o(268696);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(268694);
    p.k(paramk, "obj");
    if (((paramk instanceof ac)) && (((ac)paramk).xzB.zAO == this.xzB.zAO) && (((ac)paramk).xzB.STx == this.xzB.STx) && (p.h(((ac)paramk).xzB.wording, this.xzB.wording)))
    {
      AppMethodBeat.o(268694);
      return 0;
    }
    AppMethodBeat.o(268694);
    return -1;
  }
  
  public final int bAQ()
  {
    return 2002;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(268692);
    long l = ((Number)this.xzz.getValue()).longValue();
    AppMethodBeat.o(268692);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268695);
    String str = "ItemId=" + mf() + ",ItemType=2002 wordingSpan=" + this.xzA;
    AppMethodBeat.o(268695);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac
 * JD-Core Version:    0.7.0.1
 */