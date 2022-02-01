package com.tencent.mm.plugin.finder.uniComments.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.uniComments.action.a;
import com.tencent.mm.plugin.finder.uniComments.action.d;
import com.tencent.mm.plugin.finder.uniComments.action.d.c;
import com.tencent.mm.plugin.finder.uniComments.action.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/logic/UniLikeLogic;", "", "()V", "TAG", "", "likeComment", "", "feedItem", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "comment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "like", "", "InteractionIdentityType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c GaO;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(341501);
    GaO = new c();
    TAG = "MicroMsg.MusicUni.LikeLogic";
    AppMethodBeat.o(341501);
  }
  
  public static void a(com.tencent.mm.plugin.finder.uniComments.model.b paramb, com.tencent.mm.plugin.finder.uniComments.storge.b paramb1, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(341492);
    s.u(paramb, "feedItem");
    s.u(paramb1, "comment");
    Object localObject1 = d.Gao;
    d locald = d.fdB();
    s.u(paramb, "feedItem");
    s.u(paramb1, "comment");
    f localf = new f(paramb, paramb1, paramBoolean, paramInt);
    Object localObject2 = (ConcurrentMap)locald.Gaq;
    Long localLong = Long.valueOf(paramb.field_id);
    paramb = ((ConcurrentMap)localObject2).get(localLong);
    if (paramb == null)
    {
      localObject1 = new ConcurrentHashMap();
      localObject2 = ((ConcurrentMap)localObject2).putIfAbsent(localLong, localObject1);
      paramb = (com.tencent.mm.plugin.finder.uniComments.model.b)localObject2;
      if (localObject2 == null) {
        paramb = (com.tencent.mm.plugin.finder.uniComments.model.b)localObject1;
      }
    }
    for (;;)
    {
      paramb = (ConcurrentHashMap)paramb;
      s.s(paramb, "commentMap");
      ((Map)paramb).put(new d.c(paramb1.eZI().commentId, paramInt), localf);
      locald.a((a)localf);
      AppMethodBeat.o(341492);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.logic.c
 * JD-Core Version:    0.7.0.1
 */