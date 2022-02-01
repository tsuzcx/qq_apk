package com.tencent.mm.plugin.finder.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.dpt;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderMentionUtil;", "", "()V", "TAG", "", "doMention", "", "context", "Landroid/content/Context;", "feedId", "", "opType", "", "callback", "Lkotlin/Function1;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba
{
  public static final ba EDs;
  
  static
  {
    AppMethodBeat.i(331885);
    EDs = new ba();
    AppMethodBeat.o(331885);
  }
  
  public static void a(Context paramContext, long paramLong, int paramInt, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(331876);
    s.u(paramContext, "context");
    s.u(paramb, "callback");
    Object localObject = new LinkedList();
    dpt localdpt = new dpt();
    localdpt.opType = paramInt;
    localdpt.hKN = paramLong;
    ah localah = ah.aiuX;
    ((LinkedList)localObject).add(localdpt);
    localObject = new aj(0, 0L, z.bAW(), (LinkedList)localObject, null, 16).e(paramContext, "", 100L).bFJ();
    if ((paramContext instanceof MMActivity)) {}
    for (paramContext = (MMActivity)paramContext;; paramContext = null)
    {
      paramContext = ((f)localObject).a((com.tencent.mm.vending.e.b)paramContext);
      s.s(paramContext, "CgiFinderModMentioned(Cg…e(context as? MMActivity)");
      d.b((com.tencent.mm.vending.g.c)paramContext, (kotlin.g.a.b)new a(paramb));
      AppMethodBeat.o(331876);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<b.a<bpy>, ah>
  {
    a(kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ba
 * JD-Core Version:    0.7.0.1
 */