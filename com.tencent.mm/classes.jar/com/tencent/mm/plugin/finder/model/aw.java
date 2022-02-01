package com.tencent.mm.plugin.finder.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderMentionUtil;", "", "()V", "TAG", "", "doMention", "", "context", "Landroid/content/Context;", "feedId", "", "opType", "", "callback", "Lkotlin/Function1;", "", "plugin-finder_release"})
public final class aw
{
  public static final aw zBj;
  
  static
  {
    AppMethodBeat.i(275244);
    zBj = new aw();
    AppMethodBeat.o(275244);
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt, kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(275243);
    p.k(paramContext, "context");
    p.k(paramb, "callback");
    Object localObject = new LinkedList();
    cyn localcyn = new cyn();
    localcyn.opType = paramInt;
    localcyn.xbk = paramLong;
    ((LinkedList)localObject).add(localcyn);
    localObject = new com.tencent.mm.plugin.finder.cgi.x(0, 0L, z.bdh(), (LinkedList)localObject, null, 16).e(paramContext, "", 100L).bhW();
    if (!(paramContext instanceof MMActivity)) {
      paramContext = null;
    }
    for (;;)
    {
      paramContext = ((f)localObject).a((com.tencent.mm.vending.e.b)paramContext);
      p.j(paramContext, "CgiFinderModMentioned(Cg…e(context as? MMActivity)");
      d.b((com.tencent.mm.vending.g.c)paramContext, (kotlin.g.a.b)new a(paramb));
      AppMethodBeat.o(275243);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<c.a<bex>, kotlin.x>
  {
    a(kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aw
 * JD-Core Version:    0.7.0.1
 */