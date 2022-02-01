package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "closeLive", "", "doBlockOpLog", "username", "", "showGuide", "avatarUrl", "nickname", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "friendFollowCount", "", "followClick", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateForBizMode", "updateForNormalMode", "visibleInCurrentLiveMode", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends b
{
  private static final al.a CYW;
  private ck<bpq> CYX;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(355819);
    CYW = new al.a((byte)0);
    AppMethodBeat.o(355819);
  }
  
  private al(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(355756);
    this.nfT = paramb;
    AppMethodBeat.o(355756);
  }
  
  private final void a(String paramString1, String paramString2, FinderAuthInfo paramFinderAuthInfo, int paramInt, kotlin.g.a.a<ah> parama)
  {
    int j = 8;
    AppMethodBeat.i(355778);
    kotlin.g.a.a locala = (kotlin.g.a.a)new d(this);
    if (isLandscape()) {
      this.mJe.findViewById(p.e.BWg).getLayoutParams().width = this.mJe.getContext().getResources().getDimensionPixelSize(p.c.finder_40_A);
    }
    ((ImageView)this.mJe.findViewById(p.e.BWe)).setImageDrawable(this.mJe.getContext().getResources().getDrawable(p.d.default_round_avatar));
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label445;
      }
      paramString1 = this.mJe.findViewById(p.e.BWe);
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      label143:
      ((TextView)this.mJe.findViewById(p.e.BWi)).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(this.mJe.getContext(), (CharSequence)paramString2, ((TextView)this.mJe.findViewById(p.e.BWi)).getTextSize()));
      paramString2 = (ImageView)this.mJe.findViewById(p.e.BWl);
      if (paramFinderAuthInfo != null) {
        break label513;
      }
      paramString1 = null;
      if (paramString1 != null) {
        break label539;
      }
    }
    label513:
    label539:
    for (int i = ((Number)Integer.valueOf(8)).intValue();; i = paramString1.intValue())
    {
      paramString2.setVisibility(i);
      if (paramString2.getVisibility() == 0)
      {
        paramString1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
        s.s(paramString1, "service(IFinderCommonService::class.java)");
        paramString1 = (com.tencent.mm.plugin.h)paramString1;
        s.s(paramString2, "this");
        h.a.a(paramString1, paramString2, paramFinderAuthInfo, 0, null, 8);
      }
      paramString1 = (TextView)this.mJe.findViewById(p.e.BWf);
      paramString1.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_friend_follow, new Object[] { r.TP(paramInt) }));
      i = j;
      if (paramInt > 0) {
        i = 0;
      }
      paramString1.setVisibility(i);
      ((TextView)this.mJe.findViewById(p.e.BWh)).setOnClickListener(new al..ExternalSyntheticLambda1(parama));
      this.mJe.findViewById(p.e.BWj).setOnClickListener(new al..ExternalSyntheticLambda0(locala));
      tO(0);
      ce.a.a((ce)j.Dob, q.t.Dvs);
      ce.a.a((ce)j.Dob, q.t.Dvt);
      ce.a.a((ce)j.Dob, q.t.Dvu);
      AppMethodBeat.o(355778);
      return;
      i = 0;
      break;
      label445:
      localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramString1 = new com.tencent.mm.plugin.finder.loader.b(paramString1);
      Object localObject2 = this.mJe.findViewById(p.e.BWe);
      s.s(localObject2, "root.findViewById(R.id.liveFollowGuideAvatarIv)");
      localObject2 = (ImageView)localObject2;
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject1).a(paramString1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      break label143;
      if (paramFinderAuthInfo.authIconType > 0) {}
      for (i = 0;; i = 8)
      {
        paramString1 = Integer.valueOf(i);
        break;
      }
    }
  }
  
  private static final void e(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(355784);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$followClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355784);
  }
  
  private static final void f(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(355791);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$closeLive");
    parama.invoke();
    ce.a.a((ce)j.Dob, q.s.Duk);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355791);
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355850);
    s.u(paramc, "status");
    m localm;
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)
      {
        paramc = this.mJe.getContext().getResources().getString(p.h.finder_live_follow_guide_title_biz_dot, new Object[] { ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).mIK });
        s.s(paramc, "root.context.resources.g…:class.java).bizNickname)");
        a(null, paramc, null, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ech, (kotlin.g.a.a)new e(this));
        AppMethodBeat.o(355850);
        return;
      }
      paramc = com.tencent.mm.plugin.finder.api.d.AwY;
      localm = d.a.auT(getData().Ebr.mIC);
      if (localm != null) {
        break label217;
      }
      paramBundle = null;
      if (localm != null) {
        break label226;
      }
      paramc = "";
      label167:
      if (localm != null) {
        break label245;
      }
    }
    label217:
    label226:
    label245:
    for (Object localObject = null;; localObject = localm.field_authInfo)
    {
      a(paramBundle, paramc, (FinderAuthInfo)localObject, ((e)getBuContext().business(e.class)).friendFollowCount, (kotlin.g.a.a)new f(localm, this));
      AppMethodBeat.o(355850);
      return;
      paramBundle = localm.amx();
      break;
      localObject = localm.getNickname();
      paramc = (b.c)localObject;
      if (localObject != null) {
        break label167;
      }
      paramc = "";
      break label167;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(al paramal)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(al paramal)
    {
      super();
    }
    
    private static final void OY(int paramInt)
    {
      AppMethodBeat.i(353349);
      Log.i("Finder.FinderLiveFollowGuidePlugin", s.X("#updateForBizMode-follow biz result=", Integer.valueOf(paramInt)));
      AppMethodBeat.o(353349);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(m paramm, al paramal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.al
 * JD-Core Version:    0.7.0.1
 */