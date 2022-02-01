package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.eqv;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.e.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/model/BizTLRecFeedUtil;", "", "()V", "TAG", "", "allMsgEnd", "", "getAllMsgEnd", "()Z", "setAllMsgEnd", "(Z)V", "firstGroupEnd", "getFirstGroupEnd", "setFirstGroupEnd", "showRecFeedList", "getShowRecFeedList", "setShowRecFeedList", "initTag", "", "reporter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "pos", "", "index", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "txtJumpLink", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "isShowBigPic", "cardMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "onAppMsgClick", "recommendItem", "plugin-brandservice_release"})
public final class a
{
  private static boolean pyI;
  private static boolean pyJ;
  private static boolean pyK;
  public static final a pyL;
  
  static
  {
    AppMethodBeat.i(195509);
    pyL = new a();
    pyI = true;
    AppMethodBeat.o(195509);
  }
  
  public static void a(Context paramContext, z paramz, dlb paramdlb)
  {
    AppMethodBeat.i(195507);
    p.h(paramContext, "context");
    p.h(paramz, "info");
    p.h(paramdlb, "recommendItem");
    if ((paramz.NQr == null) || (paramdlb.MOX == null) || (paramdlb.MOY == null))
    {
      Log.w("Micromsg.BizTimeLineRecFeedsHelper", "onAppMsgClick appMsg is null");
      AppMethodBeat.o(195507);
      return;
    }
    paramz = paramdlb.MOX;
    paramdlb = paramdlb.MOY;
    Object localObject1 = o.iBV;
    o.Aa(21L);
    Log.i("Micromsg.BizTimeLineRecFeedsHelper", "onClick jump to url:%s", new Object[] { paramdlb.KSj });
    localObject1 = new Intent();
    String str = m.d(paramdlb.KSj, 169, 200, 0);
    ((Intent)localObject1).putExtra("rawUrl", str);
    ((Intent)localObject1).putExtra("geta8key_scene", 56);
    ((Intent)localObject1).putExtra("geta8key_username", paramz.UserName);
    ((Intent)localObject1).putExtra("srcUsername", paramz.UserName);
    ((Intent)localObject1).putExtra("srcDisplayname", paramz.oUJ);
    ((Intent)localObject1).putExtra("prePublishId", "rec_feed");
    ((Intent)localObject1).putExtra("KPublisherId", "rec_feed");
    if (paramdlb.iAb == 5)
    {
      Object localObject2 = g.af(com.tencent.mm.plugin.brandservice.a.b.class);
      p.g(localObject2, "MMKernel.service(IBrandService::class.java)");
      if (((com.tencent.mm.plugin.brandservice.a.b)localObject2).cld())
      {
        ((Intent)localObject1).putExtra(e.b.OyQ, 169);
        ((Intent)localObject1).putExtra(e.b.OyR, 200);
        ((Intent)localObject1).putExtra("biz_video_session_id", ab.getSessionId());
        localObject2 = new com.tencent.mm.ag.x();
        ((com.tencent.mm.ag.x)localObject2).iAh = ((Intent)localObject1).getStringExtra("KPublisherId");
        ((com.tencent.mm.ag.x)localObject2).dHc = paramz.UserName;
        ((com.tencent.mm.ag.x)localObject2).iAg = paramz.oUJ;
        ((com.tencent.mm.ag.x)localObject2).iAi.url = str;
        ((com.tencent.mm.ag.x)localObject2).iAi.title = paramdlb.Title;
        ((com.tencent.mm.ag.x)localObject2).iAi.iAq = paramdlb.KSh;
        ((com.tencent.mm.ag.x)localObject2).iAi.iAo = paramdlb.KSl;
        ((com.tencent.mm.ag.x)localObject2).iAi.type = paramdlb.iAb;
        ((com.tencent.mm.ag.x)localObject2).iAi.time = paramdlb.CreateTime;
        paramz = paramdlb.Mjm;
        ((com.tencent.mm.ag.x)localObject2).iAi.iAs = paramz.KSx;
        ((com.tencent.mm.ag.x)localObject2).iAi.videoWidth = paramz.KSv;
        ((com.tencent.mm.ag.x)localObject2).iAi.videoHeight = paramz.KSw;
        ((com.tencent.mm.ag.x)localObject2).iAi.vid = paramz.KSu;
        ((com.tencent.mm.ag.x)localObject2).t((Intent)localObject1);
        Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to native video");
        ((Intent)localObject1).addFlags(268435456);
      }
    }
    if ((((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramContext, str, paramdlb.iAb, 169, 200, (Intent)localObject1)))
    {
      Log.i("Micromsg.BizTimeLineRecFeedsHelper", "jump to TmplWebview");
      AppMethodBeat.o(195507);
      return;
    }
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    AppMethodBeat.o(195507);
  }
  
  public static void a(final f paramf, final int paramInt, final z paramz, dlb paramdlb, TextView paramTextView, final Context paramContext)
  {
    AppMethodBeat.i(195506);
    p.h(paramf, "reporter");
    p.h(paramz, "info");
    p.h(paramdlb, "itemMsg");
    p.h(paramTextView, "txtJumpLink");
    p.h(paramContext, "context");
    Object localObject = (CharSequence)paramdlb.Luk;
    if ((localObject == null) || (n.aL((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label180;
      }
      localObject = (CharSequence)paramdlb.Luj;
      if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
        break label174;
      }
    }
    label174:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label180;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText((CharSequence)paramdlb.Luk);
      localObject = d.pMy;
      d.i(paramTextView);
      paramTextView.setOnClickListener((View.OnClickListener)new a.a((kotlin.g.a.b)new b(paramdlb, paramContext, paramf, paramz, paramInt, 0)));
      AppMethodBeat.o(195506);
      return;
      i = 0;
      break;
    }
    label180:
    paramTextView.setVisibility(8);
    AppMethodBeat.o(195506);
  }
  
  public static final boolean a(dkr paramdkr)
  {
    AppMethodBeat.i(195508);
    p.h(paramdkr, "cardMsg");
    boolean bool = af.a(paramdkr);
    AppMethodBeat.o(195508);
    return bool;
  }
  
  public static boolean cni()
  {
    return pyI;
  }
  
  public static boolean cnj()
  {
    return pyJ;
  }
  
  public static boolean cnk()
  {
    return pyK;
  }
  
  public static void kl(boolean paramBoolean)
  {
    pyI = paramBoolean;
  }
  
  public static void km(boolean paramBoolean)
  {
    pyJ = paramBoolean;
  }
  
  public static void kn(boolean paramBoolean)
  {
    pyK = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "opType", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<Integer, kotlin.x>
  {
    b(dlb paramdlb, Context paramContext, f paramf, z paramz, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.a
 * JD-Core Version:    0.7.0.1
 */