package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.mini.FinderMiniWindowFloatLayout;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "anchorUsername", "setAnchorUsername", "(Ljava/lang/String;)V", "closeBtn", "Landroid/widget/ImageView;", "closeGroup", "Landroid/widget/RelativeLayout;", "coverUrl", "setCoverUrl", "isAnchor", "", "multiAreaLayout", "Lcom/tencent/mm/plugin/finder/live/view/mini/FinderMiniWindowFloatLayout;", "getMultiAreaLayout", "()Lcom/tencent/mm/plugin/finder/live/view/mini/FinderMiniWindowFloatLayout;", "olympicsLayout", "Landroid/view/View;", "getOlympicsLayout", "()Landroid/view/View;", "state", "stateContainer", "stateIcon", "stateIv", "stateTv", "Landroid/widget/TextView;", "torchView", "Lorg/libpag/PAGView;", "getTorchView", "()Lorg/libpag/PAGView;", "applyState", "", "floatScene", "haveSetup", "inAnchorMode", "loadBackgroundImage", "releaseState", "setBgCoverUrl", "setState", "newState", "setupClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "closeClickListener", "setupMiniView", "showDisconnectView", "showFinishView", "showFreeTimeOverView", "showNorlView", "showPauseView", "showStateView", "showStateContainer", "showStateIcon", "text", "contentDesc", "enableAccessibilityEvent", "updateState", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveMiniView
  extends AbsLiveMiniView
{
  private final PAGView COO;
  private final View DOs;
  private final ImageView DOt;
  private final RelativeLayout DOu;
  private final FinderMiniWindowFloatLayout DOv;
  private final View DOw;
  private final TextView Dip;
  private final String TAG;
  private String coverUrl;
  public boolean hKC;
  private String mIC;
  private final ImageView nkq;
  private final ImageView pOB;
  private int state;
  
  public FinderLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(357597);
    AppMethodBeat.o(357597);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357603);
    AppMethodBeat.o(357603);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357585);
    this.TAG = "FinderLiveMiniView";
    this.coverUrl = "";
    this.mIC = "";
    View.inflate(paramContext, p.f.CeH, (ViewGroup)this);
    paramAttributeSet = findViewById(p.e.BOV);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder_live_multi_area_layout)");
    this.DOv = ((FinderMiniWindowFloatLayout)paramAttributeSet);
    paramAttributeSet = findViewById(p.e.BOJ);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder_live_mini_view_close_btn)");
    this.nkq = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(p.e.BOO);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder_live_mini_view_state_tv)");
    this.Dip = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(p.e.BOL);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder…ini_view_state_container)");
    this.DOs = paramAttributeSet;
    paramAttributeSet = findViewById(p.e.BON);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder_live_mini_view_state_iv)");
    this.DOt = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(p.e.BOM);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder…ive_mini_view_state_icon)");
    this.pOB = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(p.e.BOK);
    kotlin.g.b.s.s(paramAttributeSet, "findViewById(R.id.finder…ve_mini_view_close_group)");
    this.DOu = ((RelativeLayout)paramAttributeSet);
    this.DOu.setContentDescription((CharSequence)paramContext.getString(p.h.finder_live_close_iv_desc));
    paramContext = findViewById(p.e.BKy);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.finder…ve_float_olympics_layout)");
    this.DOw = paramContext;
    paramContext = findViewById(p.e.BXd);
    kotlin.g.b.s.s(paramContext, "findViewById(R.id.live_torch_view)");
    this.COO = ((PAGView)paramContext);
    this.DOw.setVisibility(8);
    this.DOt.setClipToOutline(true);
    this.DOt.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    this.DOt.setVisibility(8);
    this.DOs.setVisibility(8);
    AppMethodBeat.o(357585);
  }
  
  private static final void a(Bitmap paramBitmap, FinderLiveMiniView paramFinderLiveMiniView)
  {
    AppMethodBeat.i(357624);
    kotlin.g.b.s.u(paramBitmap, "$bitmap");
    kotlin.g.b.s.u(paramFinderLiveMiniView, "this$0");
    float f = aw.bf(MMApplicationContext.getContext()).y / aw.bf(MMApplicationContext.getContext()).x;
    int i = (int)(paramBitmap.getHeight() / f);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramFinderLiveMiniView, BitmapUtil.extractThumbNail(paramBitmap, paramBitmap.getHeight(), i, true, false)));
    AppMethodBeat.o(357624);
  }
  
  private static final void a(FinderLiveMiniView paramFinderLiveMiniView, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(357629);
    kotlin.g.b.s.u(paramFinderLiveMiniView, "this$0");
    if (paramBitmap == null) {}
    for (parama = null;; parama = h.ahAA.bm(new FinderLiveMiniView..ExternalSyntheticLambda1(paramBitmap, paramFinderLiveMiniView)))
    {
      if (parama == null) {
        Log.i(paramFinderLiveMiniView.getTAG(), "loadBackgroundImage resource is empty!");
      }
      AppMethodBeat.o(357629);
      return;
    }
  }
  
  private final void evs()
  {
    AppMethodBeat.i(357609);
    Object localObject1 = (CharSequence)this.coverUrl;
    label51:
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      localObject1 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject1 = d.a.auT(this.mIC);
      if (localObject1 != null) {
        break label124;
      }
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label140;
      }
    }
    label132:
    label140:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label145;
      }
      localObject2 = p.ExI;
      p.eCl().dk(new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKZ)).a(new FinderLiveMiniView..ExternalSyntheticLambda0(this)).Td();
      AppMethodBeat.o(357609);
      return;
      i = 0;
      break;
      label124:
      localObject1 = ((m)localObject1).field_liveCoverImg;
      break label51;
      localObject1 = this.coverUrl;
      break label51;
    }
    label145:
    Log.i(this.TAG, "loadBackgroundImage backgroundUrl is empty!");
    AppMethodBeat.o(357609);
  }
  
  private final void evt()
  {
    AppMethodBeat.i(357619);
    int k;
    if (com.tencent.mm.ae.d.ee(this.state, 4))
    {
      this.Dip.setText((CharSequence)getContext().getResources().getString(p.h.live_mini_state_has_closed));
      this.DOt.setVisibility(0);
      this.DOs.setVisibility(0);
      evs();
      this.pOB.setVisibility(0);
      k = getChildCount();
      if (k <= 0) {}
    }
    int j;
    label521:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = getChildAt(i);
      if (((View)localObject).getId() != p.e.BOI)
      {
        i = 1;
        if (i == 0) {
          break label162;
        }
      }
      for (;;)
      {
        if (localObject != null) {
          ((View)localObject).getVisibility();
        }
        if (j < k) {
          break label521;
        }
        setContentDescription((CharSequence)getContext().getResources().getString(p.h.talkback_live_finish));
        sendAccessibilityEvent(128);
        AppMethodBeat.o(357619);
        return;
        i = 0;
        break;
        label162:
        localObject = null;
      }
      if (com.tencent.mm.ae.d.ee(this.state, 2))
      {
        this.Dip.setText((CharSequence)getContext().getResources().getString(p.h.live_mini_state_pause));
        this.DOt.setVisibility(0);
        this.DOs.setVisibility(0);
        this.pOB.setVisibility(8);
        evs();
        setContentDescription((CharSequence)getContext().getResources().getString(p.h.talkback_live_pause));
        AppMethodBeat.o(357619);
        return;
      }
      if (com.tencent.mm.ae.d.ee(this.state, 1))
      {
        this.Dip.setText((CharSequence)getContext().getResources().getString(p.h.live_mini_state_disconnect));
        this.DOt.setVisibility(0);
        this.DOs.setVisibility(0);
        this.pOB.setVisibility(0);
        evs();
        setContentDescription((CharSequence)getContext().getResources().getString(p.h.talkback_live_net_bad));
        sendAccessibilityEvent(128);
        AppMethodBeat.o(357619);
        return;
      }
      if (com.tencent.mm.ae.d.ee(this.state, 8))
      {
        localObject = getContext().getResources().getString(p.h.live_mini_state_free_time_over);
        kotlin.g.b.s.s(localObject, "context.resources.getStr…ini_state_free_time_over)");
        String str = getContext().getResources().getString(p.h.talkback_live_free_time_over);
        kotlin.g.b.s.s(str, "context.resources.getStr…back_live_free_time_over)");
        this.DOt.setVisibility(0);
        this.DOs.setVisibility(0);
        this.pOB.setVisibility(8);
        this.Dip.setText((CharSequence)localObject);
        evs();
        setContentDescription((CharSequence)str);
        sendAccessibilityEvent(128);
        AppMethodBeat.o(357619);
        return;
      }
      this.DOt.setVisibility(8);
      this.DOs.setVisibility(8);
      setContentDescription((CharSequence)getContext().getResources().getString(p.h.talkback_live));
      AppMethodBeat.o(357619);
      return;
    }
  }
  
  private final void setAnchorUsername(String paramString)
  {
    AppMethodBeat.i(357593);
    Log.i(this.TAG, kotlin.g.b.s.X("set anchorUsername:", paramString));
    this.mIC = paramString;
    AppMethodBeat.o(357593);
  }
  
  private final void setCoverUrl(String paramString)
  {
    AppMethodBeat.i(357588);
    Log.i(this.TAG, kotlin.g.b.s.X("set coverUrl:", paramString));
    this.coverUrl = paramString;
    AppMethodBeat.o(357588);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(357704);
    kotlin.g.b.s.u(paramOnClickListener1, "clickListener");
    kotlin.g.b.s.u(paramOnClickListener2, "closeClickListener");
    setOnClickListener(paramOnClickListener1);
    this.nkq.setOnClickListener(paramOnClickListener2);
    this.nkq.setContentDescription((CharSequence)getContext().getResources().getString(p.h.talkback_live_close_btn));
    AppMethodBeat.o(357704);
  }
  
  public final int bfN()
  {
    return 15;
  }
  
  public final FinderMiniWindowFloatLayout getMultiAreaLayout()
  {
    return this.DOv;
  }
  
  public final View getOlympicsLayout()
  {
    return this.DOw;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final PAGView getTorchView()
  {
    return this.COO;
  }
  
  public final boolean hU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(357687);
    if ((kotlin.g.b.s.p(this.mIC, paramString1)) && (kotlin.g.b.s.p(this.coverUrl, paramString2)) && (!this.hKC))
    {
      AppMethodBeat.o(357687);
      return true;
    }
    AppMethodBeat.o(357687);
    return false;
  }
  
  public final void setBgCoverUrl(String paramString)
  {
    AppMethodBeat.i(357694);
    Log.i(this.TAG, kotlin.g.b.s.X("setCoverUrl:", paramString));
    setCoverUrl(paramString);
    AppMethodBeat.o(357694);
  }
  
  public void setState(int paramInt)
  {
    AppMethodBeat.i(357707);
    this.state = paramInt;
    Log.i(this.TAG, "setState newState:" + paramInt + ", state:" + this.state);
    evt();
    AppMethodBeat.o(357707);
  }
  
  public final void te(int paramInt)
  {
    AppMethodBeat.i(357715);
    this.state |= paramInt;
    Log.i(this.TAG, "applyState applyState:" + paramInt + ", state:" + this.state);
    evt();
    AppMethodBeat.o(357715);
  }
  
  public final void tf(int paramInt)
  {
    AppMethodBeat.i(357721);
    this.state &= (paramInt ^ 0xFFFFFFFF);
    Log.i(this.TAG, "releaseState releaseState:" + paramInt + ", state:" + this.state);
    evt();
    AppMethodBeat.o(357721);
  }
  
  public final void x(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(357699);
    Log.i(this.TAG, kotlin.g.b.s.X("setupMiniView isAnchor:", Boolean.valueOf(paramBoolean)));
    this.hKC = paramBoolean;
    if (paramBoolean)
    {
      this.DOu.setVisibility(8);
      this.DOv.setVisibility(8);
    }
    for (;;)
    {
      setAnchorUsername(paramString1);
      setCoverUrl(paramString2);
      this.DOt.setImageDrawable(null);
      AppMethodBeat.o(357699);
      return;
      this.DOv.setRadius(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8));
      this.DOv.setAdapter((com.tencent.mm.view.ratio.a)new com.tencent.mm.plugin.finder.live.view.mini.d());
      this.DOv.setLayoutManager(new com.tencent.mm.view.ratio.b());
      this.DOv.setVisibility(0);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(FinderLiveMiniView paramFinderLiveMiniView, Bitmap paramBitmap)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView
 * JD-Core Version:    0.7.0.1
 */