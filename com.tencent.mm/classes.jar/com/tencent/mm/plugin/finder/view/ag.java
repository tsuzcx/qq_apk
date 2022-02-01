package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.cg;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.plugin.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/LiveLogoAssistant;", "Lcom/tencent/mm/plugin/findersdk/api/ILiveLogoAssistant;", "context", "Landroid/content/Context;", "anchorUsername", "", "position", "", "isLiveFeed", "", "(Landroid/content/Context;Ljava/lang/String;IZ)V", "getAnchorUsername", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "()Z", "getPosition", "()I", "gotoLive", "", "needAnim", "reportOnClick", "pageName", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  implements cg
{
  final boolean GFg;
  final Context context;
  final String mIC;
  final int position;
  
  public ag(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344635);
    this.context = paramContext;
    this.mIC = paramString;
    this.position = paramInt;
    this.GFg = paramBoolean;
    AppMethodBeat.o(344635);
  }
  
  public final void vc(final boolean paramBoolean)
  {
    AppMethodBeat.i(344644);
    Object localObject = (CharSequence)this.mIC;
    int i;
    g localg;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label92;
      }
      localg = (g)com.tencent.mm.kernel.h.ax(g.class);
      localObject = this.mIC;
      if (localObject != null) {
        break label89;
      }
      localObject = "";
    }
    label89:
    for (;;)
    {
      localg.a((String)localObject, (t)new a(this, paramBoolean)).bFJ();
      AppMethodBeat.o(344644);
      return;
      i = 0;
      break;
    }
    label92:
    localObject = FinderLiveOnliveWidget.GAF;
    Log.i(FinderLiveOnliveWidget.access$getTAG$cp(), "[LiveLogoAssistant]click live icon but username is empty!");
    AppMethodBeat.o(344644);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/LiveLogoAssistant$gotoLive$1", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements t
  {
    a(ag paramag, boolean paramBoolean) {}
    
    public final void a(final int paramInt1, int paramInt2, azf paramazf)
    {
      Object localObject1 = null;
      AppMethodBeat.i(344517);
      s.u(paramazf, "resp");
      Object localObject2 = paramazf.ZIo;
      if (localObject2 != null)
      {
        paramazf = ((FinderObject)localObject2).contact;
        if (paramazf == null) {}
        for (paramazf = null; s.p(paramazf, this.GFh.mIC); paramazf = paramazf.username)
        {
          paramazf = k.aeZF;
          paramInt1 = ((bn)k.nq(this.GFh.context).cq(bn.class)).fow();
          ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a((FinderObject)localObject2, paramInt1);
          d.uiThread((a)new a(this.GFh, (FinderObject)localObject2, paramInt1, paramBoolean));
          AppMethodBeat.o(344517);
          return;
        }
      }
      paramazf = FinderLiveOnliveWidget.GAF;
      String str = FinderLiveOnliveWidget.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.GFh.mIC).append(",remote username:");
      if (localObject2 == null) {
        paramazf = localObject1;
      }
      for (;;)
      {
        Log.i(str, paramazf);
        AppMethodBeat.o(344517);
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
      a(ag paramag, FinderObject paramFinderObject, int paramInt, boolean paramBoolean)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ag
 * JD-Core Version:    0.7.0.1
 */