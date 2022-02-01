package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.live.report.s.p;
import com.tencent.mm.plugin.finder.live.report.s.q;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "doBlockOpLog", "", "username", "", "showGuide", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class av
  extends d
{
  @Deprecated
  public static final a ypS;
  private final com.tencent.mm.live.c.b kCL;
  private com.tencent.mm.plugin.findersdk.a.aj<bep> ypR;
  
  static
  {
    AppMethodBeat.i(266937);
    ypS = new a((byte)0);
    AppMethodBeat.o(266937);
  }
  
  private av(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb, null);
    AppMethodBeat.i(266936);
    this.kCL = paramb;
    AppMethodBeat.o(266936);
  }
  
  public final void statusChange(final b.c paramc, Bundle paramBundle)
  {
    int j = 8;
    AppMethodBeat.i(266935);
    p.k(paramc, "status");
    switch (aw.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(266935);
      return;
    }
    paramc = (kotlin.g.a.a)new f(this);
    if (isLandscape())
    {
      paramBundle = (LinearLayout)((View)this.kiF).findViewById(b.f.liveFollowGuideContentRoot);
      p.j(paramBundle, "root.liveFollowGuideContentRoot");
      paramBundle = paramBundle.getLayoutParams();
      localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      paramBundle.width = ((Context)localObject1).getResources().getDimensionPixelSize(b.d.finder_40_A);
    }
    paramBundle = (ImageView)((View)this.kiF).findViewById(b.f.liveFollowGuideAvatarIv);
    Object localObject1 = this.kiF.getContext();
    p.j(localObject1, "root.context");
    paramBundle.setImageDrawable(((Context)localObject1).getResources().getDrawable(b.e.default_round_avatar));
    paramBundle = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramBundle = d.a.aAK(getData().zey.aJk());
    int i;
    if (paramBundle != null)
    {
      localObject1 = t.ztT;
      localObject1 = t.dJh();
      Object localObject2 = new e(paramBundle.Mm());
      Object localObject3 = (ImageView)((View)this.kiF).findViewById(b.f.liveFollowGuideAvatarIv);
      p.j(localObject3, "root.liveFollowGuideAvatarIv");
      Object localObject4 = t.ztT;
      ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, t.a(t.a.ztX));
      localObject1 = (TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideNameTv);
      p.j(localObject1, "root.liveFollowGuideNameTv");
      localObject2 = this.kiF.getContext();
      localObject3 = (CharSequence)paramBundle.getNickname();
      localObject4 = (TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideNameTv);
      p.j(localObject4, "root.liveFollowGuideNameTv");
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject2, (CharSequence)localObject3, ((TextView)localObject4).getTextSize()));
      localObject1 = (ImageView)((View)this.kiF).findViewById(b.f.liveFollowGuideTagIv);
      if (paramBundle.field_authInfo != null) {
        if (paramBundle.field_authInfo.authIconType > 0)
        {
          i = 0;
          label390:
          ((ImageView)localObject1).setVisibility(i);
          if (((ImageView)localObject1).getVisibility() == 0)
          {
            localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
            p.j(localObject1, "this");
            com.tencent.mm.plugin.finder.utils.aj.a((ImageView)localObject1, paramBundle.field_authInfo, 0);
          }
          localObject1 = (TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideCntTv);
          int k = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).friendFollowCount;
          localObject2 = this.kiF.getContext();
          p.j(localObject2, "root.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_friend_follow, new Object[] { com.tencent.mm.plugin.finder.utils.m.QF(k) }));
          i = j;
          if (k > 0) {
            i = 0;
          }
          ((TextView)localObject1).setVisibility(i);
          ((TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideFollowQuitBtnTv)).setOnClickListener((View.OnClickListener)new c(paramBundle, this, paramc));
        }
      }
    }
    for (;;)
    {
      ((TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideQuitBtnTv)).setOnClickListener((View.OnClickListener)new e(paramc));
      tU(0);
      paramc = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.q.yGy);
      paramc = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.q.yGz);
      paramc = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.q.yGA);
      break;
      i = 8;
      break label390;
      i = 8;
      break label390;
      ((TextView)((View)this.kiF).findViewById(b.f.liveFollowGuideFollowQuitBtnTv)).setOnClickListener((View.OnClickListener)new d(this, paramc));
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$doBlockOpLog$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.findersdk.a.aj<bep>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$1$3"})
  static final class c
    implements View.OnClickListener
  {
    c(i parami, av paramav, kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282050);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      boolean bool1 = com.tencent.mm.plugin.finder.utils.aj.j(this.xmS);
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      boolean bool2 = com.tencent.mm.plugin.finder.utils.aj.k(this.xmS);
      av.dBw();
      Log.i("Finder.FinderLiveFollowGuidePlugin", "liveFollowGuideQuitBtnTv click, nickName:" + this.xmS.getNickname() + ", isPrivate:" + bool1 + " , isBlock" + bool2);
      paramView = ai.zAJ;
      paramView = g.Xox;
      paramView = jdField_this.kiF.getContext();
      p.j(paramView, "root.context");
      paramView = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.lm(paramView).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY();
      localObject = this.xmS.getUsername();
      an localan = an.xci;
      ai.a(paramView, (String)localObject, an.dnL(), ((c)jdField_this.business(c.class)).xbk, bool1);
      w.cR(jdField_this.kiF.getContext(), jdField_this.kiF.getContext().getString(b.j.has_follow_tip));
      if (bool2) {
        av.a(jdField_this, this.xmS.getUsername());
      }
      paramc.invoke();
      paramView = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.p.yGv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282050);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(av paramav, kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273174);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramc.invoke();
      paramView = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.p.yGv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273174);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(kotlin.g.a.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288336);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.ypV.invoke();
      paramView = com.tencent.mm.plugin.finder.live.report.m.yCt;
      com.tencent.mm.plugin.finder.live.report.m.a(s.p.yGu);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveFollowGuidePlugin$showGuide$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(288336);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(av paramav)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.av
 * JD-Core Version:    0.7.0.1
 */