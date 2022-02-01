package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget$goToFinderLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
public final class ac$e
  implements w.a
{
  ac$e(String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, aun paramaun)
  {
    Object localObject1 = null;
    AppMethodBeat.i(289331);
    p.k(paramaun, "resp");
    Object localObject2 = paramaun.SFP;
    if (localObject2 != null)
    {
      paramaun = ((FinderObject)localObject2).contact;
      if (paramaun != null) {}
      for (paramaun = paramaun.username; p.h(paramaun, this.mtC); paramaun = null)
      {
        d.uiThread((a)new a(this, (FinderObject)localObject2));
        AppMethodBeat.o(289331);
        return;
      }
    }
    String str = ac.a(this.zpT);
    StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.mtC).append(",remote username:");
    paramaun = localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((FinderObject)localObject2).contact;
      paramaun = localObject1;
      if (localObject2 != null) {
        paramaun = ((FinderContact)localObject2).username;
      }
    }
    Log.i(str, paramaun);
    AppMethodBeat.o(289331);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(ac.e parame, FinderObject paramFinderObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ac.e
 * JD-Core Version:    0.7.0.1
 */