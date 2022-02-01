package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.q.bu;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.live.sidebar.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.h;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicBottomStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "avatar", "Landroid/widget/ImageView;", "coverBgView", "group", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "hangupBtn", "Landroid/view/View;", "linkLeftGroup", "miniAnchorOptGroup", "Landroid/widget/LinearLayout;", "miniAnchorOptMute", "miniAnchorOptMuteIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "miniAnchorOptSwitch", "nickname", "Landroid/widget/TextView;", "userLevel", "widgetRoot", "adjustMiniAnchorOptGroup", "", "fillContent", "goToFinderProfileImpl", "hideLinkMicBottomBar", "onAvatarClick", "refreshMuteState", "showToast", "", "requestDisallowInterceptTouchEvent", "disallow", "showLinkMicBottomBar", "contentRect", "Landroid/graphics/Rect;", "updateCoverBg", "updateLinkMicBottomBar", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends aq
{
  public static final at.b EsD;
  public static final String TAG;
  private final View CVy;
  private final TextView DTO;
  public final ImageView EsE;
  private final View EsF;
  private final LinearLayout EsG;
  private final View EsH;
  private final View EsI;
  private final WeImageView EsJ;
  private final FinderLiveInterceptTouchRelativeLayout Esc;
  private final View Esf;
  private final TextView Esg;
  private final ImageView avatar;
  
  static
  {
    AppMethodBeat.i(361594);
    EsD = new at.b((byte)0);
    TAG = "Finder.FinderLiveMicBottomBarWidget";
    AppMethodBeat.o(361594);
  }
  
  public at(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, paramFinderLiveShadeView);
    AppMethodBeat.i(361455);
    paramFinderLiveShadeView = View.inflate(paramViewGroup.getContext(), p.f.CeE, null);
    s.s(paramFinderLiveShadeView, "inflate(root.context, R.…c_bottom_widget_ui, null)");
    this.Esf = paramFinderLiveShadeView;
    paramFinderLiveShadeView = paramViewGroup.getContext();
    s.s(paramFinderLiveShadeView, "root.context");
    this.Esc = new FinderLiveInterceptTouchRelativeLayout(paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTt);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…o_link_bottom_bar_avatar)");
    this.avatar = ((ImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTw);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…deo_link_bottom_bar_name)");
    this.DTO = ((TextView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTy);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…nk_bottom_bar_user_level)");
    this.Esg = ((TextView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTu);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…_bottom_bar_hangup_group)");
    this.CVy = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTv);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…nk_bottom_bar_left_group)");
    this.EsF = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.CbO);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…ar_mini_anchor_opt_group)");
    this.EsG = ((LinearLayout)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.CbR);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…anchor_opt_switch_camera)");
    this.EsH = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.BTz);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…live_video_link_cover_bg)");
    this.EsE = ((ImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.CbP);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…bar_mini_anchor_opt_mute)");
    this.EsI = paramFinderLiveShadeView;
    paramFinderLiveShadeView = this.Esf.findViewById(p.e.CbQ);
    s.s(paramFinderLiveShadeView, "widgetRoot.findViewById(…ini_anchor_opt_mute_icon)");
    this.EsJ = ((WeImageView)paramFinderLiveShadeView);
    paramFinderLiveShadeView = this.CVy;
    if (paramFinderLiveShadeView != null) {
      paramFinderLiveShadeView.setOnClickListener(new at..ExternalSyntheticLambda4(this, paramb));
    }
    this.avatar.setOnClickListener(new at..ExternalSyntheticLambda3(this));
    this.DTO.setOnClickListener(new at..ExternalSyntheticLambda2(this));
    paramFinderLiveShadeView = com.tencent.mm.plugin.finder.accessibility.a.Ate;
    paramViewGroup = paramViewGroup.getContext();
    s.s(paramViewGroup, "root.context");
    float f = com.tencent.mm.plugin.finder.accessibility.a.g(paramViewGroup, 14.0F);
    this.DTO.setTextSize(1, f);
    paramViewGroup = this.EsI;
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener(new at..ExternalSyntheticLambda1(paramb, this));
    }
    paramViewGroup = this.EsH;
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener(new at..ExternalSyntheticLambda0(paramb));
    }
    AppMethodBeat.o(361455);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, View paramView)
  {
    AppMethodBeat.i(361530);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$basePlugin");
    b.b.a(paramb.CTj, b.c.ncm);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361530);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.live.plugin.b paramb, at paramat, View paramView)
  {
    AppMethodBeat.i(361522);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$basePlugin");
    s.u(paramat, "this$0");
    paramView = (e)paramb.business(e.class);
    if (!((e)paramb.business(e.class)).Eem) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.Eem = bool;
      paramView = new Bundle();
      paramView.putBoolean("PARAM_FINDER_LIVE_IS_MUTE_MIC", ((e)paramb.business(e.class)).Eem);
      paramb.CTj.statusChange(b.c.neV, paramView);
      paramat.sD(true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(361522);
      return;
    }
  }
  
  private static final void a(at paramat, View paramView)
  {
    AppMethodBeat.i(361502);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramat, "this$0");
    paramat.eBj();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361502);
  }
  
  private static final void a(final at paramat, com.tencent.mm.plugin.finder.live.plugin.b paramb, View paramView)
  {
    AppMethodBeat.i(361492);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramat, "this$0");
    s.u(paramb, "$basePlugin");
    paramat.ar((kotlin.g.a.b)new a(paramb, paramat));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361492);
  }
  
  private static final void b(at paramat, View paramView)
  {
    AppMethodBeat.i(361510);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramat);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramat, "this$0");
    paramat.eBj();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(361510);
  }
  
  private final void eBj()
  {
    AppMethodBeat.i(361472);
    if (((e)this.CwG.business(e.class)).EcR == 2)
    {
      Log.i(TAG, "onAvatarClick cur mode couldn't click!");
      AppMethodBeat.o(361472);
      return;
    }
    Object localObject4 = this.Esy;
    if (localObject4 != null)
    {
      if (((h)localObject4).EbD)
      {
        Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label219;
          }
        }
        Object localObject6;
        label219:
        for (int i = 1;; i = 0) {
          for (;;)
          {
            localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
              break label224;
            }
            eBh();
            AppMethodBeat.o(361472);
            return;
            synchronized ((Iterable)localObject1)
            {
              localObject6 = ((Iterable)???).iterator();
              for (;;)
              {
                if (((Iterator)localObject6).hasNext())
                {
                  localObject1 = ((Iterator)localObject6).next();
                  boolean bool = Util.isEqual(((h)localObject1).mXL, ((e)this.CwG.business(e.class)).eyF());
                  if (bool)
                  {
                    localObject1 = (h)localObject1;
                    break;
                  }
                }
              }
              localObject1 = null;
            }
          }
        }
        label224:
        if (i != 0)
        {
          eBh();
          AppMethodBeat.o(361472);
          return;
        }
        localObject3 = com.tencent.mm.ui.component.k.aeZF;
        localObject3 = this.mJe.getContext();
        s.s(localObject3, "root.context");
        if (((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject3).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGD)
        {
          localObject3 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = this.mJe.getContext();
          s.s(localObject3, "root.context");
          localObject3 = ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject3).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGE;
          if (localObject3 != null) {
            ((c)localObject3).hide();
          }
          localObject3 = com.tencent.mm.ui.component.k.aeZF;
          localObject3 = this.mJe.getContext();
          s.s(localObject3, "root.context");
          ((com.tencent.mm.plugin.finder.live.sidebar.d)com.tencent.mm.ui.component.k.nq((Context)localObject3).q(com.tencent.mm.plugin.finder.live.sidebar.d.class)).DGH.DGN = 3;
          AppMethodBeat.o(361472);
          return;
        }
        ??? = (ce)com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = this.CwG.reportObj;
        long l3;
        long l1;
        label430:
        label453:
        long l2;
        label478:
        bui localbui;
        if (localObject3 == null)
        {
          l3 = -1L;
          localObject3 = (f)this.CwG.business(f.class);
          if (localObject3 != null) {
            break label566;
          }
          l1 = -1L;
          localObject3 = (e)this.CwG.business(e.class);
          if (localObject3 != null) {
            break label594;
          }
          localObject3 = null;
          localObject6 = (f)this.CwG.business(f.class);
          if (localObject6 != null) {
            break label604;
          }
          l2 = -1L;
          localObject6 = q.w.DwZ;
          localbui = this.CwG.reportObj;
          if (localbui != null) {
            break label635;
          }
        }
        label566:
        label594:
        label604:
        label635:
        for (i = 0;; i = localbui.AJo)
        {
          ce.a.a((ce)???, l3, l1, (String)localObject3, -1L, l2, (q.w)localObject6, String.valueOf(i));
          localObject3 = com.tencent.mm.plugin.finder.live.report.k.Doi;
          com.tencent.mm.plugin.finder.live.report.k.a(q.bu.DCD, "", 0L, null, null, null, 60);
          ayB(((h)localObject4).username);
          AppMethodBeat.o(361472);
          return;
          l3 = ((bui)localObject3).ADF;
          break;
          localObject3 = ((f)localObject3).liveInfo;
          if (localObject3 == null)
          {
            l1 = -1L;
            break label430;
          }
          l1 = ((bip)localObject3).liveId;
          break label430;
          localObject3 = ((e)localObject3).mIC;
          break label453;
          localObject6 = ((f)localObject6).liveInfo;
          if (localObject6 == null)
          {
            l2 = -1L;
            break label478;
          }
          l2 = ((bip)localObject6).DSe;
          break label478;
        }
      }
      localObject4 = ((e)this.CwG.business(e.class)).eyF();
      localObject3 = this.Esy;
      if (localObject3 != null) {
        break label697;
      }
    }
    label697:
    for (Object localObject3 = null;; localObject3 = ((h)localObject3).mXL)
    {
      if (!Util.isEqual((String)localObject4, (String)localObject3)) {
        eBh();
      }
      AppMethodBeat.o(361472);
      return;
    }
  }
  
  private final void eBk()
  {
    AppMethodBeat.i(361480);
    if (this.EsG.getVisibility() != 0)
    {
      AppMethodBeat.o(361480);
      return;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).EfM)
    {
      ??? = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)this.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efw;
      s.s(???, "basePlugin.business(Live…).audienceLinkMicUserList");
      for (;;)
      {
        synchronized ((Iterable)???)
        {
          Collection localCollection = (Collection)new ArrayList();
          Iterator localIterator = ((Iterable)???).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = localIterator.next();
          if (!s.p(((h)localObject3).EbK, Boolean.TRUE))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localCollection.add(localObject3);
          }
        }
        int i = 0;
      }
      List localList = (List)localObject2;
      if (localList.size() >= 2)
      {
        this.EsG.setOrientation(1);
        ??? = this.EsG.getLayoutParams();
        if ((??? instanceof ViewGroup.MarginLayoutParams)) {}
        for (??? = (ViewGroup.MarginLayoutParams)???; ??? != null; ??? = null)
        {
          ((ViewGroup.MarginLayoutParams)???).setMarginStart((int)this.mJe.getContext().getResources().getDimension(p.c.Edge_0_5_A));
          AppMethodBeat.o(361480);
          return;
        }
      }
    }
    this.EsG.setOrientation(0);
    ??? = this.EsG.getLayoutParams();
    if ((??? instanceof ViewGroup.MarginLayoutParams)) {}
    for (??? = (ViewGroup.MarginLayoutParams)???;; ??? = null)
    {
      if (??? != null) {
        ((ViewGroup.MarginLayoutParams)???).setMarginStart((int)this.mJe.getContext().getResources().getDimension(p.c.Edge_1_5_A));
      }
      AppMethodBeat.o(361480);
      return;
    }
  }
  
  public final void erb()
  {
    AppMethodBeat.i(361657);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(361657);
  }
  
  public final void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(361667);
    this.Esc.setInterceptTouch(paramBoolean);
    AppMethodBeat.o(361667);
  }
  
  public final void sD(final boolean paramBoolean)
  {
    AppMethodBeat.i(361644);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this, paramBoolean));
    AppMethodBeat.o(361644);
  }
  
  public final void x(final Rect paramRect)
  {
    AppMethodBeat.i(361648);
    s.u(paramRect, "contentRect");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramRect));
    AppMethodBeat.o(361648);
  }
  
  public final void y(Rect paramRect)
  {
    AppMethodBeat.i(361664);
    s.u(paramRect, "contentRect");
    if (s.p(this.Esz, paramRect))
    {
      Log.i(TAG, "skip updateLinkMicBottomBar, lastContentRect == contentRect. lastContentRect:" + this.Esz + " contentRect:" + paramRect);
      AppMethodBeat.o(361664);
      return;
    }
    super.y(paramRect);
    Log.i(TAG, s.X("updateLinkMicBottomBar contentRect:", paramRect));
    this.Esc.setTranslationX(paramRect.left);
    this.Esc.setTranslationY(paramRect.top);
    eBk();
    ViewGroup.LayoutParams localLayoutParams = this.Esc.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = paramRect.width();
      localLayoutParams.height = paramRect.height();
      this.Esc.requestLayout();
    }
    AppMethodBeat.o(361664);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    a(com.tencent.mm.plugin.finder.live.plugin.b paramb, at paramat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(at paramat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(at paramat, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(at paramat, Rect paramRect)
    {
      super();
    }
    
    private static final void c(at paramat, View paramView)
    {
      AppMethodBeat.i(362103);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramat);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramat, "this$0");
      paramat.eBh();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362103);
    }
    
    private static final void d(at paramat, View paramView)
    {
      AppMethodBeat.i(362114);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramat);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramat, "this$0");
      paramat.eBh();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362114);
    }
    
    private static final void e(at paramat, View paramView)
    {
      AppMethodBeat.i(362118);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramat);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramat, "this$0");
      paramat.eBh();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362118);
    }
    
    private static final void f(at paramat, View paramView)
    {
      AppMethodBeat.i(362123);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramat);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramat, "this$0");
      paramat.eBh();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLiveMicVideoStateWidget$showLinkMicBottomBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.at
 * JD-Core Version:    0.7.0.1
 */