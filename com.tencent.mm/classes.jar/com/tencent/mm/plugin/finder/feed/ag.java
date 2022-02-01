package com.tencent.mm.plugin.finder.feed;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "wordingSpan", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getWordingSpan", "()Landroid/text/SpannableString;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  implements cc
{
  public final bwc AWZ;
  private final j AXa;
  public final SpannableString AXb;
  
  public ag(bwc parambwc)
  {
    AppMethodBeat.i(363119);
    this.AWZ = parambwc;
    this.AXa = kotlin.k.cm((a)new a(this));
    this.AXb = p.b(MMApplicationContext.getContext(), (CharSequence)this.AWZ.wording);
    AppMethodBeat.o(363119);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(363146);
    s.u(paramk, "obj");
    if (((paramk instanceof ag)) && (((ag)paramk).AWZ.ECY == this.AWZ.ECY) && (((ag)paramk).AWZ.aadB == this.AWZ.aadB) && (s.p(((ag)paramk).AWZ.wording, this.AWZ.wording)))
    {
      AppMethodBeat.o(363146);
      return 0;
    }
    AppMethodBeat.o(363146);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(363128);
    long l = ((Number)this.AXa.getValue()).longValue();
    AppMethodBeat.o(363128);
    return l;
  }
  
  public final int bZB()
  {
    return 2002;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(363152);
    String str = "ItemId=" + bZA() + ",ItemType=2002 wordingSpan=" + this.AXb;
    AppMethodBeat.o(363152);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Long>
  {
    a(ag paramag)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag
 * JD-Core Version:    0.7.0.1
 */