package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.w;
import com.tencent.mm.plugin.finder.live.model.cgi.w.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/LiveLogoAssistant;", "", "context", "Landroid/content/Context;", "anchorUsername", "", "position", "", "isLiveFeed", "", "(Landroid/content/Context;Ljava/lang/String;IZ)V", "getAnchorUsername", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "()Z", "getPosition", "()I", "gotoLive", "", "reportOnClick", "pageName", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public final class y
{
  final boolean Bcv;
  final Context context;
  final String kig;
  final int position;
  
  public y(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(232373);
    this.context = paramContext;
    this.kig = paramString;
    this.position = paramInt;
    this.Bcv = paramBoolean;
    AppMethodBeat.o(232373);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(232372);
    Object localObject = (CharSequence)this.kig;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label78;
      }
      localObject = this.kig;
      if (localObject != null) {
        break label96;
      }
      localObject = "";
    }
    label78:
    label96:
    for (;;)
    {
      new w((String)localObject, (w.a)new a(this)).bhW();
      AppMethodBeat.o(232372);
      return;
      i = 0;
      break;
      localObject = FinderLiveOnliveWidget.AZb;
      Log.i(FinderLiveOnliveWidget.access$getTAG$cp(), "[LiveLogoAssistant]click live icon but username is empty!");
      AppMethodBeat.o(232372);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/LiveLogoAssistant$gotoLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
  public static final class a
    implements w.a
  {
    public final void a(final int paramInt1, int paramInt2, aun paramaun)
    {
      Object localObject1 = null;
      AppMethodBeat.i(273997);
      p.k(paramaun, "resp");
      Object localObject2 = paramaun.SFP;
      if (localObject2 != null)
      {
        paramaun = ((FinderObject)localObject2).contact;
        if (paramaun != null) {}
        for (paramaun = paramaun.username; p.h(paramaun, this.Bcw.kig); paramaun = null)
        {
          paramaun = g.Xox;
          paramInt1 = ((aj)g.lm(this.Bcw.context).i(aj.class)).xkX;
          paramaun = n.zWF;
          n.a((FinderObject)localObject2, paramInt1);
          d.uiThread((a)new a(this, (FinderObject)localObject2, paramInt1));
          AppMethodBeat.o(273997);
          return;
        }
      }
      paramaun = FinderLiveOnliveWidget.AZb;
      String str = FinderLiveOnliveWidget.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.Bcw.kig).append(",remote username:");
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
      AppMethodBeat.o(273997);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(y.a parama, FinderObject paramFinderObject, int paramInt)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.y
 * JD-Core Version:    0.7.0.1
 */