package com.tencent.mm.plugin.finder.live.olympic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout;
import com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout.a;
import com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout.c;
import com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout.c.a;
import com.tencent.mm.plugin.finder.live.olympic.widget.DisperserDanmakuLayout.e;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRoomBgPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "getActivity", "()Lcom/tencent/mm/ui/MMActivity;", "adjustWhenVideoChanged", "", "canDanmuClick", "getCanDanmuClick", "()Z", "setCanDanmuClick", "(Z)V", "danmakuLayout", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout;", "kotlin.jvm.PlatformType", "isLighted", "lightObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicBaseData;", "living", "paddingHorizontal", "", "paddingVertical", "starView", "Lorg/libpag/PAGView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "canClearScreenWhenSideBarShow", "consumeComments", "", "stage", "", "adapter", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter;", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "Lcom/tencent/mm/protocal/protobuf/Comment;", "getValue", "", "start", "end", "percent", "initDanmakuLayout", "initStarView", "normalization", "current", "refreshBg", "refreshDanmakuLayout", "topMargin", "videoHeight", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateStarView", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  private static final int COF;
  public static final l.a COw;
  private static final String TAG;
  private boolean COA;
  private boolean COB;
  private final y<n.e> COC;
  private final int COD;
  boolean COE;
  private final PAGView COx;
  private final DisperserDanmakuLayout COy;
  private boolean COz;
  final MMActivity activity;
  final com.tencent.mm.live.b.b nfT;
  private final int ogE;
  
  static
  {
    AppMethodBeat.i(360557);
    COw = new l.a((byte)0);
    TAG = "Finder.FinderLiveOlympicsRoomPlugin";
    COF = 10;
    AppMethodBeat.o(360557);
  }
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb, MMActivity paramMMActivity)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(360458);
    this.nfT = paramb;
    this.activity = paramMMActivity;
    this.COx = ((PAGView)paramViewGroup.findViewById(p.e.BWp));
    this.COy = ((DisperserDanmakuLayout)paramViewGroup.findViewById(p.e.BWF));
    this.COz = true;
    this.COA = true;
    this.COC = new l..ExternalSyntheticLambda0(this);
    this.ogE = ((int)this.activity.getResources().getDimension(p.c.Edge_0_5_A));
    this.COD = ((int)this.activity.getResources().getDimension(p.c.Edge_A));
    paramViewGroup = TAG;
    paramb = bj.GlQ;
    Log.i(paramViewGroup, s.X("refreshBg isOlympicsLive:", Boolean.valueOf(bj.y(getBuContext()))));
    paramViewGroup = bj.GlQ;
    if ((bj.y(getBuContext())) && (!isLandscape()))
    {
      tO(0);
      AppMethodBeat.o(360458);
      return;
    }
    tO(8);
    AppMethodBeat.o(360458);
  }
  
  private static final void a(l paraml, n.e parame)
  {
    AppMethodBeat.i(360485);
    s.u(paraml, "this$0");
    boolean bool = paraml.COB;
    int i;
    String str;
    if ((parame != null) && (bool == parame.EhJ))
    {
      i = 1;
      if (i == 0)
      {
        str = TAG;
        if (parame != null) {
          break label75;
        }
      }
    }
    label75:
    for (parame = null;; parame = Boolean.valueOf(parame.EhJ))
    {
      Log.i(str, s.X("lightObserver ", parame));
      paraml.enG();
      AppMethodBeat.o(360485);
      return;
      i = 0;
      break;
    }
  }
  
  private static final void a(l paraml, Float paramFloat)
  {
    AppMethodBeat.i(360492);
    s.u(paraml, "this$0");
    if (paramFloat != null)
    {
      final float f = ((Number)paramFloat).floatValue();
      paraml.COA = false;
      d.a(0L, (kotlin.g.a.a)new g(paraml, f));
    }
    AppMethodBeat.o(360492);
  }
  
  private final void a(DisperserDanmakuLayout.a<DisperserDanmakuLayout.e, aep> parama)
  {
    AppMethodBeat.i(360475);
    if (this.COz) {
      DisperserDanmakuLayout.a.a(parama, ((n)business(n.class)).Dhw.Qf(COF));
    }
    AppMethodBeat.o(360475);
  }
  
  private final void enG()
  {
    AppMethodBeat.i(360465);
    n.e locale = (n.e)((n)business(n.class)).Ehd.getValue();
    if (locale == null) {}
    for (boolean bool = false;; bool = locale.EhJ)
    {
      this.COB = bool;
      d.z((kotlin.g.a.a)new h(this));
      AppMethodBeat.o(360465);
      return;
    }
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final void hH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(360599);
    Object localObject = bj.GlQ;
    if ((bj.y(getBuContext())) && (this.COA))
    {
      int j = com.tencent.mm.cd.a.fromDPToPix((Context)this.activity, 600);
      int i = paramInt1;
      if (paramInt2 > 0) {
        i = (int)(paramInt1 + paramInt2 / 2.0F - j / 2.0F);
      }
      localObject = this.COy.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(360599);
        throw ((Throwable)localObject);
      }
      ((ConstraintLayout.LayoutParams)localObject).topMargin = i;
    }
    AppMethodBeat.o(360599);
  }
  
  public final void statusChange(b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(360588);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(360588);
      return;
      if (!isLandscape())
      {
        this.COz = true;
        tO(0);
        Log.i(TAG, s.X("initStarView starView.isPlaying:", Boolean.valueOf(this.COx.isPlaying())));
        if (!this.COx.isPlaying())
        {
          enG();
          ((n)business(n.class)).Ehd.a((q)this.activity, this.COC);
        }
        this.COy.setVisibility(0);
        paramc = this.COy;
        paramBundle = new f(this);
        paramc.setAdapter((DisperserDanmakuLayout.a)paramBundle);
        int i = com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 100);
        int j = com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 300);
        DisperserDanmakuLayout.c.a locala = new DisperserDanmakuLayout.c.a();
        locala.CSs = i;
        locala.CSt = j;
        locala.CSu = new r(Float.valueOf(0.52F), Float.valueOf(1.0F));
        locala.CSv = new r(Float.valueOf(0.0F), Float.valueOf(1.0F));
        locala.duration = 3500;
        locala.interval = 1500;
        locala.spanCount = 5;
        locala.CSw = ((m)new c(this));
        locala.CSx = ((kotlin.g.a.a)new d(this, paramBundle));
        j = locala.duration;
        if (locala.interval <= 0) {}
        for (i = locala.duration;; i = locala.interval)
        {
          paramc.setAnimParam(new DisperserDanmakuLayout.c(j, i, locala.CSs, locala.CSt, locala.spanCount, locala.CSu, locala.CSv, locala.CSw, locala.CSx, (byte)0));
          ((n)business(n.class)).Dhw.EhB = ((kotlin.g.a.a)new e(this, paramBundle));
          a((DisperserDanmakuLayout.a)paramBundle);
          ((n)business(n.class)).Ehn.a((q)this.activity, new l..ExternalSyntheticLambda1(this));
          paramc = bj.GlQ;
          if (!bj.z(getBuContext())) {
            break;
          }
          this.COy.setAlpha(0.5F);
          this.COE = false;
          AppMethodBeat.o(360588);
          return;
        }
        this.COy.setAlpha(1.0F);
        this.COE = true;
        AppMethodBeat.o(360588);
        return;
        this.COy.animate().cancel();
        this.COy.animate().alpha(0.5F).setDuration(250L).start();
        this.COE = false;
        AppMethodBeat.o(360588);
        return;
        this.COy.animate().cancel();
        this.COy.animate().alpha(1.0F).setDuration(250L).start();
        this.COE = true;
        AppMethodBeat.o(360588);
        return;
        Log.i(TAG, "hide danmakuLayout FINDER_LIVE_CLEAR_OLYMPIC_SCREEN");
        this.COy.setVisibility(8);
        AppMethodBeat.o(360588);
        return;
        Log.i(TAG, "show danmakuLayout FINDER_LIVE_RECOVER_OLYMPIC_SCREEN");
        this.COy.setVisibility(0);
      }
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(360605);
    this.COz = false;
    this.COA = true;
    super.unMount();
    this.COx.setVisibility(8);
    this.COy.eow();
    AppMethodBeat.o(360605);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "progress", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<View, Float, ah>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(l paraml, l.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(l paraml, l.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRoomBgPlugin$initDanmakuLayout$1$adapter$1", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$Adapter;", "Lcom/tencent/mm/plugin/finder/live/olympic/widget/DisperserDanmakuLayout$ViewHolder;", "Lcom/tencent/mm/protocal/protobuf/Comment;", "onBindViewHolder", "", "viewHolder", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends DisperserDanmakuLayout.a<DisperserDanmakuLayout.e, aep>
  {
    f(l paraml) {}
    
    private static final void a(l paraml, TextView paramTextView, View paramView)
    {
      AppMethodBeat.i(360547);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paraml);
      localb.cH(paramTextView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRoomBgPlugin$initDanmakuLayout$1$adapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paraml, "this$0");
      s.u(paramTextView, "$tv");
      if (paraml.COE)
      {
        paramView = h.ax(ce.class);
        s.s(paramView, "service(IHellLiveReport::class.java)");
        ce.a.a((ce)paramView, q.s.Duh);
        paramView = ((n)paraml.business(n.class)).Ehi;
        float f1 = paramTextView.getX();
        float f2 = paramTextView.getY();
        paraml = paramTextView.getText();
        if (paraml == null) {}
        for (paraml = null;; paraml = paraml.toString())
        {
          paramView.t(new n.a(f1, f2, paraml));
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicsRoomBgPlugin$initDanmakuLayout$1$adapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(360547);
          return;
        }
      }
      paramTextView = (e)paraml.business(e.class);
      if (!((e)paraml.business(e.class)).EcH) {}
      for (boolean bool = true;; bool = false)
      {
        paramTextView.EcH = bool;
        Log.i("DanmakuLayout.Adapter", s.X("screenAction business(LiveCommonSlice::class.java).screenClear:", Boolean.valueOf(((e)paraml.business(e.class)).EcH)));
        paramTextView = new Bundle();
        paramTextView.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((e)paraml.business(e.class)).EcH);
        paraml.nfT.statusChange(b.c.ndZ, paramTextView);
        break;
      }
    }
    
    public final DisperserDanmakuLayout.e v(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(360565);
      s.u(paramViewGroup, "parent");
      paramViewGroup = new TextView((Context)this.COG.activity);
      paramViewGroup.setPadding(0, l.c(this.COG), l.d(this.COG), l.c(this.COG));
      paramViewGroup.setTextSize(0, this.COG.activity.getResources().getDimension(p.c.SmallTextSize));
      paramViewGroup.setMaxLines(1);
      paramViewGroup.setEllipsize(TextUtils.TruncateAt.END);
      i.setTextBold(paramViewGroup);
      paramViewGroup = new DisperserDanmakuLayout.e((View)paramViewGroup);
      AppMethodBeat.o(360565);
      return paramViewGroup;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(l paraml, float paramFloat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.l
 * JD-Core Version:    0.7.0.1
 */