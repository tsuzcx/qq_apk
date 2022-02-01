package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "avatar", "Landroid/widget/ImageView;", "coverBgView", "group", "Landroid/widget/RelativeLayout;", "hangupBtn", "Landroid/view/View;", "linkLeftGroup", "miniAnchorOptGroup", "Landroid/widget/LinearLayout;", "miniAnchorOptMute", "miniAnchorOptMuteIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "miniAnchorOptSwitch", "nickname", "Landroid/widget/TextView;", "userLevel", "widgetRoot", "fillContent", "", "goToFinderProfileImpl", "hideLinkMicBottomBar", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateCoverBg", "updateLinkMicBottomBar", "Companion", "plugin-finder_release"})
public final class ad
  extends ac
{
  public static final String TAG = "Finder.FinderLiveMicBottomBarWidget";
  public static final a zqb;
  private final ImageView mWb;
  private final View ymG;
  private final TextView zai;
  private final TextView zpA;
  public final ImageView zpV;
  private final View zpW;
  private final LinearLayout zpX;
  private final View zpY;
  private final View zpZ;
  private final RelativeLayout zpv;
  private final View zpz;
  private final WeImageView zqa;
  
  static
  {
    AppMethodBeat.i(275957);
    zqb = new a((byte)0);
    TAG = "Finder.FinderLiveMicBottomBarWidget";
    AppMethodBeat.o(275957);
  }
  
  public ad(final ViewGroup paramViewGroup, final com.tencent.mm.plugin.finder.live.plugin.d paramd, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramd, paramFinderLiveShadeView);
    AppMethodBeat.i(275956);
    paramFinderLiveShadeView = View.inflate(paramViewGroup.getContext(), b.g.finder_live_mic_bottom_widget_ui, null);
    p.j(paramFinderLiveShadeView, "View.inflate(root.contex…c_bottom_widget_ui, null)");
    this.zpz = paramFinderLiveShadeView;
    this.zpv = new RelativeLayout(paramViewGroup.getContext());
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_bottom_bar_avatar);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…o_link_bottom_bar_avatar)");
    this.mWb = ((ImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_bottom_bar_name);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…deo_link_bottom_bar_name)");
    this.zai = ((TextView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_bottom_bar_user_level);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…nk_bottom_bar_user_level)");
    this.zpA = ((TextView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_bottom_bar_hangup_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…_bottom_bar_hangup_group)");
    this.ymG = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_bottom_bar_left_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…nk_bottom_bar_left_group)");
    this.zpW = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.video_link_bottom_bar_mini_anchor_opt_group);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…ar_mini_anchor_opt_group)");
    this.zpX = ((LinearLayout)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.video_link_bottom_bar_mini_anchor_opt_switch_camera);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…anchor_opt_switch_camera)");
    this.zpY = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.finder_live_video_link_cover_bg);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…live_video_link_cover_bg)");
    this.zpV = ((ImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.video_link_bottom_bar_mini_anchor_opt_mute);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…bar_mini_anchor_opt_mute)");
    this.zpZ = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.zpz.findViewById(b.f.video_link_bottom_bar_mini_anchor_opt_mute_icon);
    p.j(paramFinderLiveShadeView, "widgetRoot.findViewById(…ini_anchor_opt_mute_icon)");
    this.zqa = ((WeImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.ymG;
    if (paramFinderLiveShadeView != null) {
      paramFinderLiveShadeView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(269259);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (paramd.yld.getLiveRole() == 0)
          {
            paramAnonymousView = m.yCt;
            m.ps(true);
          }
          localObject = new Bundle();
          paramAnonymousView = this.zqc.zpP;
          if (paramAnonymousView != null) {}
          for (paramAnonymousView = paramAnonymousView.sessionId;; paramAnonymousView = null)
          {
            ((Bundle)localObject).putString("PARAM_FINDER_LIVE_MIC_ID", paramAnonymousView);
            paramd.yld.statusChange(com.tencent.mm.live.c.b.c.kBa, (Bundle)localObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(269259);
            return;
          }
        }
      });
    }
    this.mWb.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        bid localbid = null;
        AppMethodBeat.i(291980);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        h localh = this.zqc.zpP;
        if ((localh != null) && (localh.zeF))
        {
          paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
            ad.e(this.zqc);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(291980);
          return;
        }
        k localk = k.yBj;
        paramAnonymousView = paramd.reportObj;
        long l1;
        label119:
        long l2;
        label153:
        label181:
        long l3;
        if (paramAnonymousView != null)
        {
          l1 = paramAnonymousView.BmO;
          paramAnonymousView = (c)paramd.business(c.class);
          if (paramAnonymousView == null) {
            break label311;
          }
          paramAnonymousView = paramAnonymousView.liveInfo;
          if (paramAnonymousView == null) {
            break label311;
          }
          paramAnonymousView = Long.valueOf(paramAnonymousView.liveId);
          l2 = paramAnonymousView.longValue();
          paramAnonymousView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramAnonymousView == null) {
            break label316;
          }
          paramAnonymousView = paramAnonymousView.kig;
          Object localObject2 = (c)paramd.business(c.class);
          localObject1 = localbid;
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).liveInfo;
            localObject1 = localbid;
            if (localObject2 != null) {
              localObject1 = Integer.valueOf(((bac)localObject2).yYz);
            }
          }
          l3 = ((Integer)localObject1).intValue();
          localObject1 = s.t.yGX;
          localbid = paramd.reportObj;
          if (localbid == null) {
            break label321;
          }
        }
        label311:
        label316:
        label321:
        for (int i = localbid.xkX;; i = 0)
        {
          k.a(localk, l1, l2, paramAnonymousView, -1L, l3, (s.t)localObject1, String.valueOf(i));
          m.yCt.dDp();
          this.zqc.aDh(localh.username);
          break;
          l1 = -1L;
          break label119;
          paramAnonymousView = null;
          break label153;
          paramAnonymousView = null;
          break label181;
        }
      }
    });
    this.zai.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        bid localbid = null;
        AppMethodBeat.i(285475);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        h localh = this.zqc.zpP;
        if ((localh != null) && (localh.zeF))
        {
          paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
            ad.e(this.zqc);
          }
        }
        else
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(285475);
          return;
        }
        k localk = k.yBj;
        paramAnonymousView = paramd.reportObj;
        long l1;
        label119:
        long l2;
        label153:
        label181:
        long l3;
        if (paramAnonymousView != null)
        {
          l1 = paramAnonymousView.BmO;
          paramAnonymousView = (c)paramd.business(c.class);
          if (paramAnonymousView == null) {
            break label311;
          }
          paramAnonymousView = paramAnonymousView.liveInfo;
          if (paramAnonymousView == null) {
            break label311;
          }
          paramAnonymousView = Long.valueOf(paramAnonymousView.liveId);
          l2 = paramAnonymousView.longValue();
          paramAnonymousView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
          if (paramAnonymousView == null) {
            break label316;
          }
          paramAnonymousView = paramAnonymousView.kig;
          Object localObject2 = (c)paramd.business(c.class);
          localObject1 = localbid;
          if (localObject2 != null)
          {
            localObject2 = ((c)localObject2).liveInfo;
            localObject1 = localbid;
            if (localObject2 != null) {
              localObject1 = Integer.valueOf(((bac)localObject2).yYz);
            }
          }
          l3 = ((Integer)localObject1).intValue();
          localObject1 = s.t.yGX;
          localbid = paramd.reportObj;
          if (localbid == null) {
            break label321;
          }
        }
        label311:
        label316:
        label321:
        for (int i = localbid.xkX;; i = 0)
        {
          k.a(localk, l1, l2, paramAnonymousView, -1L, l3, (s.t)localObject1, String.valueOf(i));
          m.yCt.dDp();
          this.zqc.aDh(localh.username);
          break;
          l1 = -1L;
          break label119;
          paramAnonymousView = null;
          break label153;
          paramAnonymousView = null;
          break label181;
        }
      }
    });
    paramFinderLiveShadeView = this.zpZ;
    if (paramFinderLiveShadeView != null) {
      paramFinderLiveShadeView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(278320);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs)
          {
            paramAnonymousView = ad.f(this.zqc);
            localObject = paramViewGroup.getContext();
            p.j(localObject, "root.context");
            paramAnonymousView.setIconColor(((Context)localObject).getResources().getColor(com.tencent.mm.plugin.finder.b.c.white_text_color));
            paramAnonymousView = ad.g(this.zqc);
            localObject = paramViewGroup.getContext();
            p.j(localObject, "root.context");
            paramAnonymousView.setBackground(((Context)localObject).getResources().getDrawable(b.e.finder_live_panel_btn_bg));
            paramAnonymousView = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.j(localObject, "root.context");
            w.cR(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_anchor_cancel_mute_toast_tip));
            paramAnonymousView = new Bundle();
            if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramd.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgs) {
              break label316;
            }
          }
          label316:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", bool);
            paramd.yld.statusChange(com.tencent.mm.live.c.b.c.kBu, paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(278320);
            return;
            ad.f(this.zqc).setIconColor(-16777216);
            paramAnonymousView = ad.g(this.zqc);
            localObject = paramViewGroup.getContext();
            p.j(localObject, "root.context");
            paramAnonymousView.setBackground(((Context)localObject).getResources().getDrawable(b.e.finder_live_panel_btn_white_bg));
            paramAnonymousView = paramViewGroup.getContext();
            localObject = paramViewGroup.getContext();
            p.j(localObject, "root.context");
            w.cR(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_anchor_mute_toast_tip));
            break;
          }
        }
      });
    }
    paramViewGroup = this.zpY;
    if (paramViewGroup != null)
    {
      paramViewGroup.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(283663);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.b.a(this.zpJ.yld, com.tencent.mm.live.c.b.c.kyX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(283663);
        }
      });
      AppMethodBeat.o(275956);
      return;
    }
    AppMethodBeat.o(275956);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(275954);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(275954);
  }
  
  public final void r(final Rect paramRect)
  {
    AppMethodBeat.i(275953);
    p.k(paramRect, "contentRect");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramRect));
    AppMethodBeat.o(275953);
  }
  
  public final void s(Rect paramRect)
  {
    AppMethodBeat.i(275955);
    p.k(paramRect, "contentRect");
    if (p.h(this.lastContentRect, paramRect))
    {
      Log.i(TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.lastContentRect + " contentRect:" + paramRect);
      AppMethodBeat.o(275955);
      return;
    }
    super.s(paramRect);
    Log.i(TAG, "updateLinkMicBottomBar contentRect:".concat(String.valueOf(paramRect)));
    this.zpv.setTranslationX(paramRect.left);
    this.zpv.setTranslationY(paramRect.top);
    ViewGroup.LayoutParams localLayoutParams = this.zpv.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.zpv.requestLayout();
      AppMethodBeat.o(275955);
      return;
    }
    AppMethodBeat.o(275955);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ad paramad)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(ad paramad, Rect paramRect)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.ad
 * JD-Core Version:    0.7.0.1
 */