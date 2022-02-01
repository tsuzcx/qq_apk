package com.tencent.mm.plugin.finder.live.viewmodel.state.visitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.protocal.protobuf.ayl;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/GetFeedDetailCallback;", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "", "livingUICRef", "Ljava/lang/ref/SoftReference;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/state/visitor/FinderLiveVisitorLivingUIC;", "tag", "", "(Ljava/lang/ref/SoftReference;Ljava/lang/String;)V", "getLivingUICRef", "()Ljava/lang/ref/SoftReference;", "setLivingUICRef", "(Ljava/lang/ref/SoftReference;)V", "getTag", "()Ljava/lang/String;", "invoke", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements kotlin.g.a.b<b.a<ayl>, ah>
{
  private SoftReference<b> Elb;
  private final String tag;
  
  public d(SoftReference<b> paramSoftReference, String paramString)
  {
    AppMethodBeat.i(357375);
    this.Elb = paramSoftReference;
    this.tag = paramString;
    AppMethodBeat.o(357375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.state.visitor.d
 * JD-Core Version:    0.7.0.1
 */