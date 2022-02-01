package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  implements cc
{
  final bwc AWZ;
  private final j AXa;
  public final SpannableString ECU;
  public final int ECV;
  
  public am(bwc parambwc)
  {
    AppMethodBeat.i(332143);
    this.AWZ = parambwc;
    this.AXa = kotlin.k.cm((a)new a(this));
    this.ECU = p.b(MMApplicationContext.getContext(), (CharSequence)this.AWZ.wording);
    this.ECV = this.AWZ.aadB;
    AppMethodBeat.o(332143);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    AppMethodBeat.i(332163);
    s.u(paramk, "obj");
    if (((paramk instanceof am)) && (((am)paramk).AWZ.ECY == this.AWZ.ECY) && (((am)paramk).AWZ.aadB == this.AWZ.aadB) && (s.p(((am)paramk).AWZ.wording, this.AWZ.wording)))
    {
      AppMethodBeat.o(332163);
      return 0;
    }
    AppMethodBeat.o(332163);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332152);
    long l = ((Number)this.AXa.getValue()).longValue();
    AppMethodBeat.o(332152);
    return l;
  }
  
  public final int bZB()
  {
    return 2011;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332169);
    String str = "ItemId=" + bZA() + ",ItemType=2011 tipStyle=" + this.ECV + " tip=" + this.ECU;
    AppMethodBeat.o(332169);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Long>
  {
    a(am paramam)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.am
 * JD-Core Version:    0.7.0.1
 */