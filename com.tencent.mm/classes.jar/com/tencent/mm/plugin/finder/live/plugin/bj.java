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
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bb;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.l;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "albumTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "backBtn", "Lcom/tencent/mm/ui/blur/BlurView;", "blankBtn", "Landroid/view/View;", "cardGroup", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "coverIv", "Landroid/widget/ImageView;", "curPlayingBgmId", "", "genreTv", "goQQMusicBtn", "moreGroup", "publishTimeTv", "singerTv", "songNameTv", "checkRefreshMusicPanel", "", "newMusicId", "fillMusicPanel", "hidePanel", "onClick", "v", "showPanel", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "tryToUseBlurBackBtn", "visibleInCurrentLiveMode", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bj
  extends b
  implements View.OnClickListener
{
  private final RoundCornerRelativeLayout DgN;
  private final TextView DgO;
  private final TextView DgP;
  private final TextView DgQ;
  private final View DgR;
  private final TextView DgS;
  private final TextView DgT;
  private final BlurView DgU;
  private final View DgV;
  private final View DgW;
  private int DgX;
  private final String TAG;
  private final ImageView coverIv;
  private final com.tencent.mm.live.b.b nfT;
  
  public bj(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355136);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveMusicInfoPanelPlugin";
    this.DgN = ((RoundCornerRelativeLayout)paramViewGroup.findViewById(p.e.BPh));
    this.coverIv = ((ImageView)paramViewGroup.findViewById(p.e.BPf));
    this.DgO = ((TextView)paramViewGroup.findViewById(p.e.BPj));
    this.DgP = ((TextView)paramViewGroup.findViewById(p.e.BPm));
    this.DgQ = ((TextView)paramViewGroup.findViewById(p.e.BPc));
    this.DgR = paramViewGroup.findViewById(p.e.BPi);
    this.DgS = ((TextView)paramViewGroup.findViewById(p.e.BPg));
    this.DgT = ((TextView)paramViewGroup.findViewById(p.e.BPk));
    this.DgU = ((BlurView)paramViewGroup.findViewById(p.e.BPe));
    this.DgV = paramViewGroup.findViewById(p.e.BPl);
    this.DgW = paramViewGroup.findViewById(p.e.BPd);
    int i = com.tencent.mm.cd.a.br(paramViewGroup.getContext(), p.c.Edge_20A);
    paramb = aw.iQ(paramViewGroup.getContext());
    int j = paramb.x;
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).height = (j + i);
    ((RelativeLayout.LayoutParams)localObject).width = paramb.x;
    this.DgN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    float f = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 24);
    this.DgN.A(0.0F, 0.0F, f, f);
    try
    {
      paramb = this.DgU;
      localObject = paramb.ad((ViewGroup)this.DgN).V(this.coverIv.getDrawable()).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(paramb.getContext())).eb(50.0F);
      ((BlurView)localObject).aedd = true;
      ((BlurView)localObject).Rx = com.tencent.mm.cd.a.br(paramb.getContext(), p.c.Edge_A);
      ((BlurView)localObject).joa().aBy(Color.parseColor("#61D2D2D2"));
      this.DgN.setTranslationY(-bf.bf(paramViewGroup.getContext()).y);
      this.DgU.setOnClickListener((View.OnClickListener)this);
      this.DgV.setOnClickListener((View.OnClickListener)this);
      this.DgW.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(355136);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.w(this.TAG, "not support RS, back to sold image btn");
        this.DgU.setBackground(this.mJe.getContext().getResources().getDrawable(p.d.BBi));
      }
    }
  }
  
  private final void ers()
  {
    AppMethodBeat.i(355146);
    Log.i(this.TAG, s.X("fillMusicPanel curPlayingBgmId:", Integer.valueOf(this.DgX)));
    if (this.DgX != 0)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(this.DgX));
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null) {
        ((ap)localObject).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp, z.bAW(), ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, 2, localLinkedList, (t.a)new c(this));
      }
    }
    AppMethodBeat.o(355146);
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(355231);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BPd;
      if (paramView != null) {
        break label143;
      }
      label53:
      i = p.e.BPe;
      if (paramView != null) {
        break label156;
      }
      label61:
      i = 0;
      label63:
      if (i == 0) {
        break label169;
      }
      this.DgN.animate().translationY(-bf.bf(this.mJe.getContext()).y).setListener((Animator.AnimatorListener)new d(this)).start();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355231);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label143:
      if (paramView.intValue() != i) {
        break label53;
      }
      i = 1;
      break label63;
      label156:
      if (paramView.intValue() != i) {
        break label61;
      }
      i = 1;
      break label63;
      label169:
      i = p.e.BPl;
      if ((paramView != null) && (paramView.intValue() == i))
      {
        paramView = aj.CGT;
        paramView = aj.getFinderLiveAssistant();
        if (paramView != null)
        {
          localObject = this.mJe.getContext();
          s.s(localObject, "root.context");
          paramView.ar((Context)localObject, this.DgX);
        }
        k.Doi.Pm(q.bb.DAw.type);
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355220);
    s.u(paramc, "status");
    if (a.$EnumSwitchMapping$0[paramc.ordinal()] == 1) {
      if (paramBundle != null) {
        break label70;
      }
    }
    label70:
    for (int i = 0;; i = paramBundle.getInt("PARAM_LIVE_BGM_ID"))
    {
      this.DgX = i;
      tO(0);
      this.DgN.animate().translationY(0.0F).setListener(null).start();
      ers();
      AppMethodBeat.o(355220);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(bj parambj, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin$fillMusicPanel$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements t.a
  {
    c(bj parambj) {}
    
    public final void a(final int paramInt1, final int paramInt2, bfr parambfr)
    {
      AppMethodBeat.i(353496);
      s.u(parambfr, "resp");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(parambfr, this.DgY, paramInt1, paramInt2));
      AppMethodBeat.o(353496);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(bfr parambfr, bj parambj, int paramInt1, int paramInt2)
      {
        super();
      }
      
      private static final void a(bj parambj, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
      {
        AppMethodBeat.i(353412);
        s.u(parambj, "this$0");
        Log.i(bj.c(parambj), s.X("fillMusicPanel resource:", paramBitmap));
        if (paramBitmap != null)
        {
          parama = new com.tencent.mm.videocomposition.effect.a();
          parama.setInputBitmap(paramBitmap);
          int i = paramBitmap.getWidth();
          parama.setOutputSize(i, kotlin.h.a.eH(bj.d(parambj).getHeight() * 1.0F / bj.d(parambj).getWidth() * i));
          paramg = parama.HkF.GpO.jQk();
          VLogEffectJNI.INSTANCE.nSetGradientBlurEffectBlurBottom(paramg.ptr, false);
          paramg.setRadius(30.0F);
          VLogEffectJNI.INSTANCE.nSetGradientBlurEffectBlurMaskRatio(paramg.ptr, 1.0F);
          parama.aW((kotlin.g.a.b)new a(parambj));
        }
        AppMethodBeat.o(353412);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.b<Bitmap, ah>
      {
        a(bj parambj)
        {
          super();
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMusicInfoPanelPlugin$hidePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(bj parambj) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(353542);
      this.DgY.tO(8);
      AppMethodBeat.o(353542);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bj
 * JD-Core Version:    0.7.0.1
 */