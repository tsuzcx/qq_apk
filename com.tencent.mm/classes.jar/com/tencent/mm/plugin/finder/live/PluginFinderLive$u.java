package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/PluginFinderLive$gotoLive$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLive$u
  implements t
{
  PluginFinderLive$u(String paramString, Context paramContext, PluginFinderLive paramPluginFinderLive, dwa paramdwa, brs parambrs) {}
  
  public final void a(final int paramInt1, int paramInt2, azf paramazf)
  {
    Object localObject1 = null;
    AppMethodBeat.i(350994);
    s.u(paramazf, "resp");
    Object localObject2 = paramazf.ZIo;
    if (localObject2 != null)
    {
      paramazf = ((FinderObject)localObject2).contact;
      if (paramazf == null) {}
      for (paramazf = null; s.p(paramazf, this.ByB); paramazf = paramazf.username)
      {
        paramazf = k.aeZF;
        paramInt1 = ((bn)k.nq(this.$context).cq(bn.class)).fow();
        ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((FinderObject)localObject2, paramInt1);
        d.uiThread((a)new a(this.ByB, this.$context, (FinderObject)localObject2, this.Byh, this.ByC, this.ByD, paramInt1));
        AppMethodBeat.o(350994);
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.ByB).append(",remote username:");
    if (localObject2 == null) {
      paramazf = localObject1;
    }
    for (;;)
    {
      Log.i("Plugin.FinderLive", paramazf);
      AppMethodBeat.o(350994);
      return;
      localObject2 = ((FinderObject)localObject2).contact;
      paramazf = localObject1;
      if (localObject2 != null) {
        paramazf = ((FinderContact)localObject2).username;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(String paramString, Context paramContext, FinderObject paramFinderObject, PluginFinderLive paramPluginFinderLive, dwa paramdwa, brs parambrs, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.PluginFinderLive.u
 * JD-Core Version:    0.7.0.1
 */