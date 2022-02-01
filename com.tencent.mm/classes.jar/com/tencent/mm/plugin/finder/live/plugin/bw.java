package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.r.a;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.blur.f;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "albumTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "backBtn", "Lcom/tencent/mm/ui/blur/BlurView;", "blankBtn", "Landroid/view/View;", "cardGroup", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "coverIv", "Landroid/widget/ImageView;", "curPlayingBgmId", "", "genreTv", "goQQMusicBtn", "moreGroup", "publishTimeTv", "singerTv", "songNameTv", "checkRefreshMusicPanel", "", "newMusicId", "fillMusicPanel", "hidePanel", "onClick", "v", "showPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "tryToUseBlurBackBtn", "plugin-finder_release"})
public final class bw
  extends d
  implements View.OnClickListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private final ImageView sDJ;
  private final RoundCornerRelativeLayout yvX;
  private final TextView yvY;
  private final TextView yvZ;
  private final TextView ywa;
  private final View ywb;
  private final TextView ywc;
  private final TextView ywd;
  private final BlurView ywe;
  private final View ywf;
  private final View ywg;
  private int ywh;
  
  public bw(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(290527);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveMusicInfoPanelPlugin";
    this.yvX = ((RoundCornerRelativeLayout)paramViewGroup.findViewById(b.f.finder_live_music_info_group));
    this.sDJ = ((ImageView)paramViewGroup.findViewById(b.f.finder_live_music_info_cover_iv));
    this.yvY = ((TextView)paramViewGroup.findViewById(b.f.finder_live_music_info_name));
    this.yvZ = ((TextView)paramViewGroup.findViewById(b.f.finder_live_music_info_singer));
    this.ywa = ((TextView)paramViewGroup.findViewById(b.f.finder_live_music_info_album));
    this.ywb = paramViewGroup.findViewById(b.f.finder_live_music_info_more_group);
    this.ywc = ((TextView)paramViewGroup.findViewById(b.f.finder_live_music_info_genre));
    this.ywd = ((TextView)paramViewGroup.findViewById(b.f.finder_live_music_info_publish_time));
    this.ywe = ((BlurView)paramViewGroup.findViewById(b.f.finder_live_music_info_bottom_panel));
    this.ywf = paramViewGroup.findViewById(b.f.finder_live_music_info_qqmusic_panel);
    this.ywg = paramViewGroup.findViewById(b.f.finder_live_music_info_blank_group);
    int i = com.tencent.mm.ci.a.aY(paramViewGroup.getContext(), b.d.Edge_20A);
    Object localObject = ar.hv(paramViewGroup.getContext());
    int j = ((Point)localObject).x;
    paramb = new RelativeLayout.LayoutParams(-1, -1);
    paramb.height = (j + i);
    paramb.width = ((Point)localObject).x;
    localObject = this.yvX;
    p.j(localObject, "cardGroup");
    ((RoundCornerRelativeLayout)localObject).setLayoutParams((ViewGroup.LayoutParams)paramb);
    float f = com.tencent.mm.ci.a.fromDPToPix(paramViewGroup.getContext(), 24);
    this.yvX.v(0.0F, 0.0F, f, f);
    try
    {
      paramb = this.ywe;
      localObject = paramb.T((ViewGroup)this.yvX);
      ImageView localImageView = this.sDJ;
      p.j(localImageView, "coverIv");
      ((BlurView)localObject).L(localImageView.getDrawable()).b((com.tencent.mm.ui.blur.b)new f(paramb.getContext())).cO(50.0F).hLy().cN(com.tencent.mm.ci.a.aY(paramb.getContext(), b.d.Edge_A)).hLz().auW(Color.parseColor("#61D2D2D2"));
      paramb = this.yvX;
      p.j(paramb, "cardGroup");
      paramb.setTranslationY(-ax.au(paramViewGroup.getContext()).y);
      this.ywe.setOnClickListener((View.OnClickListener)this);
      this.ywf.setOnClickListener((View.OnClickListener)this);
      this.ywg.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(290527);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.w(this.TAG, "not support RS, back to sold image btn");
        paramb = this.ywe;
        p.j(paramb, "backBtn");
        localObject = this.kiF.getContext();
        p.j(localObject, "root.context");
        paramb.setBackground(((Context)localObject).getResources().getDrawable(b.e.music_info_back_bg));
      }
    }
  }
  
  private final void dCl()
  {
    AppMethodBeat.i(290523);
    Log.i(this.TAG, "fillMusicPanel curPlayingBgmId:" + this.ywh);
    if (this.ywh != 0)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(this.ywh));
      Object localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject != null)
      {
        ((an)localObject).a(((c)getBuContext().business(c.class)).liveInfo.liveId, ((c)getBuContext().business(c.class)).kvN, z.bdh(), ((c)getBuContext().business(c.class)).xbk, 2, localLinkedList, (r.a)new b(this));
        AppMethodBeat.o(290523);
        return;
      }
    }
    AppMethodBeat.o(290523);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290526);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_music_info_blank_group;
      if (paramView != null) {
        break label103;
      }
      label59:
      i = b.f.finder_live_music_info_bottom_panel;
      if (paramView != null) {
        break label156;
      }
      i = b.f.finder_live_music_info_qqmusic_panel;
      if (paramView != null) {
        break label167;
      }
    }
    for (;;)
    {
      label75:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290526);
      return;
      paramView = null;
      break;
      label103:
      if (paramView.intValue() != i) {
        break label59;
      }
      for (;;)
      {
        this.yvX.animate().translationY(-ax.au(this.kiF.getContext()).y).setListener((Animator.AnimatorListener)new c(this)).start();
        break label75;
        label156:
        if (paramView.intValue() != i) {
          break;
        }
      }
      label167:
      if (paramView.intValue() == i)
      {
        paramView = ah.yhC;
        paramView = ah.getFinderLiveAssistant();
        if (paramView != null)
        {
          localObject = this.kiF.getContext();
          p.j(localObject, "root.context");
          paramView.ah((Context)localObject, this.ywh);
        }
        m.yCt.NG(s.ap.yJz.type);
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(290524);
    p.k(paramc, "status");
    switch (bx.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(290524);
      return;
    }
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("PARAM_LIVE_BGM_ID");; i = 0)
    {
      this.ywh = i;
      tU(0);
      this.yvX.animate().translationY(0.0F).setListener(null).start();
      dCl();
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(bw parambw, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin$fillMusicPanel$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder_release"})
  public static final class b
    implements r.a
  {
    b(bw parambw) {}
    
    public final void a(final int paramInt1, final int paramInt2, final ayq paramayq)
    {
      AppMethodBeat.i(287670);
      p.k(paramayq, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramayq) {});
      AppMethodBeat.o(287670);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin$hidePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(275418);
      this.ywi.tU(8);
      AppMethodBeat.o(275418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bw
 * JD-Core Version:    0.7.0.1
 */