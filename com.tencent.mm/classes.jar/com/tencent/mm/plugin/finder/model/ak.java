package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ak
  implements bu
{
  final bjr xzB;
  private final f xzz;
  public final SpannableString zAK;
  public final int zAL;
  
  public ak(bjr parambjr)
  {
    AppMethodBeat.i(289383);
    this.xzB = parambjr;
    this.xzz = g.ar((a)new a(this));
    this.zAK = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), (CharSequence)this.xzB.wording);
    this.zAL = this.xzB.STx;
    AppMethodBeat.o(289383);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(289380);
    p.k(paramk, "obj");
    if (((paramk instanceof ak)) && (((ak)paramk).xzB.zAO == this.xzB.zAO) && (((ak)paramk).xzB.STx == this.xzB.STx) && (p.h(((ak)paramk).xzB.wording, this.xzB.wording)))
    {
      AppMethodBeat.o(289380);
      return 0;
    }
    AppMethodBeat.o(289380);
    return -1;
  }
  
  public final int bAQ()
  {
    return 2011;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(289376);
    long l = ((Number)this.xzz.getValue()).longValue();
    AppMethodBeat.o(289376);
    return l;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(289382);
    String str = "ItemId=" + mf() + ",ItemType=2011 tipStyle=" + this.zAL + " tip=" + this.zAK;
    AppMethodBeat.o(289382);
    return str;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Long>
  {
    a(ak paramak)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ak
 * JD-Core Version:    0.7.0.1
 */