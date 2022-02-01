package com.tencent.mm.plugin.finder.share;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/video/IVideoCallBack;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "cancelDown", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "fakeVideoPlayIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderFullSeekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "hasFullGuideShow", "", "isNotAllow", "isShowing", "isVideoPaused", "leftTime", "", "progressAnimator", "Landroid/animation/ValueAnimator;", "progressBar", "Landroid/widget/ProgressBar;", "pullDown", "Lkotlin/Function2;", "delayTime", "pullUpUnit", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootLayout", "videoPlayIcon", "clear", "doInit", "pullUp", "doPullDown", "eventCode", "", "forbidToShow", "initBlur", "initClose", "initCover", "initDesc", "initProgressBar", "onDestroy", "onDismiss", "onFullGuideShow", "onVideoPause", "onVideoPlay", "removeCallback", "scrollToNext", "showGuideNextView", "updateProgress", "currentMs", "allMs", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements com.tencent.mm.plugin.finder.video.u
{
  public static final a FzC;
  private View DOL;
  public FinderFullSeekBarLayout FzD;
  public WeImageView FzE;
  public WeImageView FzF;
  private kotlin.g.a.b<? super View, ah> FzG;
  private m<? super View, ? super Long, ah> FzH;
  private kotlin.g.a.b<? super View, ah> FzI;
  private long FzJ;
  private boolean FzK;
  public boolean FzL;
  public boolean FzM;
  public FinderObject feedObject;
  public boolean fhR;
  private RecyclerView mkw;
  private ProgressBar progressBar;
  private ValueAnimator rtf;
  
  static
  {
    AppMethodBeat.i(330713);
    FzC = new a((byte)0);
    AppMethodBeat.o(330713);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(330650);
    AppMethodBeat.o(330650);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(330643);
    AppMethodBeat.o(330643);
  }
  
  private final void Ti(int paramInt)
  {
    AppMethodBeat.i(330658);
    Object localObject = this.mkw;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = c.a(1, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "scrollToNext", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((RecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "scrollToNext", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    localObject = this.DOL;
    if (localObject != null) {
      av((View)localObject, paramInt);
    }
    AppMethodBeat.o(330658);
  }
  
  private static final void a(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(330710);
    kotlin.g.b.s.u(parama, "this$0");
    if (paramValueAnimator == null) {}
    for (paramValueAnimator = null; paramValueAnimator == null; paramValueAnimator = paramValueAnimator.getAnimatedValue())
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(330710);
      throw parama;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = parama.progressBar;
    if (paramValueAnimator != null) {
      paramValueAnimator.setProgress(i);
    }
    if (i == 100) {
      parama.Ti(6);
    }
    AppMethodBeat.o(330710);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(330691);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.Ti(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330691);
  }
  
  private void av(View paramView, int paramInt)
  {
    AppMethodBeat.i(330678);
    kotlin.g.b.s.u(paramView, "view");
    Log.i("Finder.ShareGuideNextUIC", "[doPullDown]");
    m localm2 = this.FzH;
    m localm1 = localm2;
    if (localm2 == null)
    {
      kotlin.g.b.s.bIx("pullDown");
      localm1 = null;
    }
    localm1.invoke(paramView, Long.valueOf(0L));
    paramView = ac.Fsk;
    ac.eNa();
    ac.aw((Context)getActivity(), paramInt);
    clear();
    AppMethodBeat.o(330678);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(330698);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama.Ti(4);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330698);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(330705);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    localObject2 = parama.DOL;
    if (localObject2 != null)
    {
      localObject1 = parama.FzH;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("pullDown");
        paramView = null;
      }
      paramView.invoke(localObject2, Long.valueOf(0L));
    }
    paramView = ac.Fsk;
    ac.eNa();
    ac.aw((Context)parama.getActivity(), 5);
    parama.clear();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330705);
  }
  
  private final void clear()
  {
    AppMethodBeat.i(330665);
    ValueAnimator localValueAnimator = this.rtf;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.rtf = null;
    ePB();
    AppMethodBeat.o(330665);
  }
  
  private final void ePB()
  {
    AppMethodBeat.i(330671);
    Object localObject = this.mkw;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).fU(0);
      if (localObject != null)
      {
        localObject = ((RecyclerView.v)localObject).caK;
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(e.e.finder_banner_video_layout);
          if (!(localObject instanceof FinderVideoLayout)) {
            break label73;
          }
        }
      }
    }
    label73:
    for (localObject = (FinderVideoLayout)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FinderVideoLayout)localObject).a((com.tencent.mm.plugin.finder.video.u)this);
      }
      AppMethodBeat.o(330671);
      return;
    }
  }
  
  private static final void gH(View paramView)
  {
    AppMethodBeat.i(330686);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(330686);
  }
  
  public final void a(FinderObject paramFinderObject, RecyclerView paramRecyclerView, kotlin.g.a.b<? super View, ah> paramb1, m<? super View, ? super Long, ah> paramm, kotlin.g.a.b<? super View, ah> paramb2)
  {
    AppMethodBeat.i(330738);
    kotlin.g.b.s.u(paramFinderObject, "feedObject");
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramb1, "pullUp");
    kotlin.g.b.s.u(paramm, "pullDown");
    kotlin.g.b.s.u(paramb2, "cancelDown");
    Log.i("Finder.ShareGuideNextUIC", "[doInit]");
    this.mkw = paramRecyclerView;
    paramRecyclerView = paramRecyclerView.fU(0);
    View localView;
    Object localObject;
    int i;
    int j;
    if (paramRecyclerView != null)
    {
      localView = paramRecyclerView.caK;
      if (localView != null)
      {
        paramRecyclerView = localView.findViewById(e.e.finder_banner_video_layout);
        if (!(paramRecyclerView instanceof FinderVideoLayout)) {
          break label322;
        }
        paramRecyclerView = (FinderVideoLayout)paramRecyclerView;
        if (paramRecyclerView != null)
        {
          localObject = (com.tencent.mm.plugin.finder.video.u)this;
          kotlin.g.b.s.u(localObject, "callBack");
          paramRecyclerView.getVideoCallBackList().add(localObject);
        }
        this.FzE = ((WeImageView)localView.findViewById(e.e.float_play_icon));
        this.FzF = ((WeImageView)localView.findViewById(e.e.fake_float_play_icon));
        paramRecyclerView = new int[2];
        localObject = this.FzE;
        if (localObject != null) {
          ((WeImageView)localObject).getLocationInWindow(paramRecyclerView);
        }
        i = paramRecyclerView[0];
        j = paramRecyclerView[1];
        paramRecyclerView = this.FzF;
        if (paramRecyclerView != null) {
          paramRecyclerView.setVisibility(4);
        }
        paramRecyclerView = this.FzF;
        if (paramRecyclerView != null) {
          break label327;
        }
        paramRecyclerView = null;
        label213:
        if (!(paramRecyclerView instanceof FrameLayout.LayoutParams)) {
          break label335;
        }
      }
    }
    label322:
    label327:
    label335:
    for (paramRecyclerView = (FrameLayout.LayoutParams)paramRecyclerView;; paramRecyclerView = null)
    {
      if (paramRecyclerView != null)
      {
        paramRecyclerView.leftMargin = i;
        paramRecyclerView.topMargin = j;
        localObject = this.FzF;
        if (localObject != null) {
          ((WeImageView)localObject).setLayoutParams((ViewGroup.LayoutParams)paramRecyclerView);
        }
      }
      this.FzD = ((FinderFullSeekBarLayout)localView.findViewById(e.e.full_seek_bar_layout));
      paramRecyclerView = this.FzD;
      if (paramRecyclerView != null) {
        paramRecyclerView.setFakeFloatPlayIcon(this.FzF);
      }
      this.FzG = paramb1;
      this.FzH = paramm;
      this.FzI = paramb2;
      this.feedObject = paramFinderObject;
      AppMethodBeat.o(330738);
      return;
      paramRecyclerView = null;
      break;
      paramRecyclerView = paramRecyclerView.getLayoutParams();
      break label213;
    }
  }
  
  public final void au(long paramLong1, long paramLong2)
  {
    this.FzJ = (paramLong2 - paramLong1);
  }
  
  public final void ePA()
  {
    Object localObject3 = null;
    AppMethodBeat.i(330755);
    if ((this.fhR) || (this.FzK) || (this.FzM))
    {
      Log.i("Finder.ShareGuideNextUIC", "[showGuideNextView] return due to isShowing:" + this.fhR + " or isNotAllow:" + this.FzK + " or hasFullGuideShow:" + this.FzM);
      AppMethodBeat.o(330755);
      return;
    }
    if (this.DOL != null)
    {
      AppMethodBeat.o(330755);
      return;
    }
    Object localObject1 = this.mkw;
    label126:
    int i;
    label132:
    label147:
    label194:
    Object localObject2;
    Object localObject4;
    label271:
    Object localObject5;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof LinearLayoutManager)) {
        break label858;
      }
      localObject1 = (LinearLayoutManager)localObject1;
      if (localObject1 != null) {
        break label863;
      }
      i = -1;
      if (i != 0) {
        break label1102;
      }
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label871;
      }
      localObject1 = null;
      this.DOL = ((View)localObject1);
      localObject1 = this.DOL;
      if (localObject1 != null)
      {
        localObject1 = (RoundCornerRelativeLayout)((View)localObject1).findViewById(e.e.guide_next_content);
        if (localObject1 != null) {
          ((RoundCornerRelativeLayout)localObject1).setOnClickListener(a..ExternalSyntheticLambda4.INSTANCE);
        }
      }
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label928;
      }
      localObject1 = null;
      localObject2 = this.feedObject;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).media;
          if ((localObject2 != null) && (((LinkedList)localObject2).size() > 0))
          {
            localObject4 = (CharSequence)((FinderMedia)((LinkedList)localObject2).get(0)).coverUrl;
            if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
              break label942;
            }
            i = 1;
            if (i == 0) {
              break label947;
            }
            localObject5 = ((FinderMedia)((LinkedList)localObject2).get(0)).thumbUrl;
            localObject4 = ((FinderMedia)((LinkedList)localObject2).get(0)).thumb_url_token;
            localObject2 = localObject4;
            if (localObject4 == null) {
              localObject2 = "";
            }
            localObject2 = kotlin.g.b.s.X((String)localObject5, localObject2);
            label326:
            if (localObject1 != null)
            {
              localObject4 = p.ExI;
              localObject4 = p.eCl();
              localObject2 = new com.tencent.mm.plugin.finder.loader.s((String)localObject2, v.FKZ);
              localObject5 = p.ExI;
              ((com.tencent.mm.loader.d)localObject4).a(localObject2, p.a(p.a.ExZ)).d((ImageView)localObject1);
            }
          }
        }
      }
      if (localObject1 != null) {
        ((ImageView)localObject1).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label1001;
      }
      localObject2 = null;
      label404:
      if (localObject2 != null) {
        break label1016;
      }
      localObject1 = null;
      label411:
      aw.a((Paint)localObject1, 0.8F);
      if (localObject2 != null)
      {
        localObject1 = this.feedObject;
        if (localObject1 != null) {
          break label1025;
        }
        localObject1 = null;
        label437:
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      if (localObject2 != null) {
        ((TextView)localObject2).setOnClickListener(new a..ExternalSyntheticLambda2(this));
      }
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label1047;
      }
      localObject1 = null;
      label475:
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new a..ExternalSyntheticLambda3(this));
      }
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label1058;
      }
      localObject1 = null;
      label502:
      localObject2 = this.DOL;
      if (localObject2 != null) {
        break label1072;
      }
      localObject2 = null;
      label516:
      localObject4 = new com.tencent.mm.videocomposition.effect.a();
      i = ao.mX((Context)getContext()).width - com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 32);
      int j = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 122);
      localObject5 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject5).eraseColor(Color.parseColor("#61F0F0F0"));
      kotlin.g.b.s.s(localObject5, "bitmap");
      ((com.tencent.mm.videocomposition.effect.a)localObject4).setInputBitmap((Bitmap)localObject5);
      ((com.tencent.mm.videocomposition.effect.a)localObject4).setOutputSize(i, j);
      localObject5 = ((com.tencent.mm.videocomposition.effect.a)localObject4).HkF.GpO.jQj();
      ((com.tencent.mm.xeffect.effect.b)localObject5).setRadius(20.0F);
      ((com.tencent.mm.xeffect.effect.b)localObject5).eC(5.0F);
      ((com.tencent.mm.videocomposition.effect.a)localObject4).aW((kotlin.g.a.b)new b((ImageView)localObject1));
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)new ColorDrawable(getResources().getColor(e.b.Blur_3)));
      }
      localObject4 = this.DOL;
      if (localObject4 != null)
      {
        localObject2 = this.FzG;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("pullUpUnit");
          localObject1 = null;
        }
        ((kotlin.g.a.b)localObject1).invoke(localObject4);
      }
      this.fhR = true;
      localObject1 = ac.Fsk;
      ac.eNa();
      ac.aw((Context)getActivity(), 3);
      localObject1 = this.DOL;
      if (localObject1 != null) {
        break label1088;
      }
    }
    label928:
    label942:
    label947:
    label1088:
    for (localObject1 = localObject3;; localObject1 = (ProgressBar)((View)localObject1).findViewById(e.e.guide_next_progress))
    {
      this.progressBar = ((ProgressBar)localObject1);
      localObject1 = ValueAnimator.ofInt(new int[] { 0, 100 });
      ((ValueAnimator)localObject1).setDuration(3000L);
      localObject2 = ah.aiuX;
      this.rtf = ((ValueAnimator)localObject1);
      localObject1 = this.rtf;
      if (localObject1 != null) {
        ((ValueAnimator)localObject1).addUpdateListener(new a..ExternalSyntheticLambda0(this));
      }
      localObject1 = this.rtf;
      if (localObject1 != null) {
        ((ValueAnimator)localObject1).start();
      }
      Log.i("Finder.ShareGuideNextUIC", "[showGuideNextView] show");
      AppMethodBeat.o(330755);
      return;
      localObject1 = ((RecyclerView)localObject1).getLayoutManager();
      break;
      label858:
      localObject1 = null;
      break label126;
      label863:
      i = ((LinearLayoutManager)localObject1).Jw();
      break label132;
      label871:
      localObject1 = ((RecyclerView)localObject1).fU(0);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label147;
      }
      localObject1 = ((RecyclerView.v)localObject1).caK;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label147;
      }
      localObject1 = (ViewStub)((View)localObject1).findViewById(e.e.bottom_guide_next_layout);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label147;
      }
      localObject1 = ((ViewStub)localObject1).inflate();
      break label147;
      localObject1 = (ImageView)((View)localObject1).findViewById(e.e.guide_next_iv);
      break label194;
      i = 0;
      break label271;
      localObject5 = ((FinderMedia)((LinkedList)localObject2).get(0)).coverUrl;
      localObject4 = ((FinderMedia)((LinkedList)localObject2).get(0)).cover_url_token;
      localObject2 = localObject4;
      if (localObject4 == null) {
        localObject2 = "";
      }
      localObject2 = kotlin.g.b.s.X((String)localObject5, localObject2);
      break label326;
      label1001:
      localObject2 = (TextView)((View)localObject1).findViewById(e.e.guide_next_desc);
      break label404;
      label1016:
      localObject1 = ((TextView)localObject2).getPaint();
      break label411;
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label437;
      }
      localObject1 = ((FinderObjectDesc)localObject1).description;
      break label437;
      localObject1 = ((View)localObject1).findViewById(e.e.guide_next_close_expand);
      break label475;
      localObject1 = (ImageView)((View)localObject1).findViewById(e.e.bg_blur);
      break label502;
      localObject2 = (ImageView)((View)localObject2).findViewById(e.e.bg_mask);
      break label516;
    }
    label1025:
    label1047:
    label1058:
    label1072:
    label1102:
    ePB();
    AppMethodBeat.o(330755);
  }
  
  public final void ePC()
  {
    AppMethodBeat.i(330796);
    Log.i("Finder.ShareGuideNextUIC", "[onDrawerOpen]");
    this.FzK = true;
    if (!this.fhR)
    {
      AppMethodBeat.o(330796);
      return;
    }
    View localView = this.DOL;
    Object localObject;
    if (localView != null)
    {
      localObject = this.mkw;
      if (localObject != null) {
        break label90;
      }
      localObject = null;
      if (!(localObject instanceof LinearLayoutManager)) {
        break label98;
      }
      localObject = (LinearLayoutManager)localObject;
      label66:
      if (localObject != null) {
        break label103;
      }
    }
    label90:
    label98:
    label103:
    for (int i = -1;; i = ((LinearLayoutManager)localObject).Jw())
    {
      if (i == 0) {
        av(localView, 7);
      }
      AppMethodBeat.o(330796);
      return;
      localObject = ((RecyclerView)localObject).getLayoutManager();
      break;
      localObject = null;
      break label66;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(330783);
    super.onDestroy();
    clear();
    AppMethodBeat.o(330783);
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(330769);
    this.FzL = true;
    Object localObject = this.progressBar;
    if ((localObject != null) && (((ProgressBar)localObject).getVisibility() == 0))
    {
      ((ProgressBar)localObject).setVisibility(8);
      localObject = this.rtf;
      if (localObject != null) {
        ((ValueAnimator)localObject).pause();
      }
      View localView = this.DOL;
      if (localView != null)
      {
        kotlin.g.a.b localb = this.FzI;
        localObject = localb;
        if (localb == null)
        {
          kotlin.g.b.s.bIx("cancelDown");
          localObject = null;
        }
        ((kotlin.g.a.b)localObject).invoke(localView);
      }
    }
    AppMethodBeat.o(330769);
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(330763);
    this.FzL = false;
    Object localObject = this.progressBar;
    if ((localObject != null) && (((ProgressBar)localObject).getVisibility() == 8))
    {
      ((ProgressBar)localObject).setVisibility(0);
      localObject = this.rtf;
      if (localObject != null) {
        ((ValueAnimator)localObject).resume();
      }
      View localView = this.DOL;
      if (localView != null)
      {
        m localm = this.FzH;
        localObject = localm;
        if (localm == null)
        {
          kotlin.g.b.s.bIx("pullDown");
          localObject = null;
        }
        ((m)localObject).invoke(localView, Long.valueOf(this.FzJ));
      }
    }
    AppMethodBeat.o(330763);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/share/FinderShareGuideNextUIC$Companion;", "", "()V", "PROGRESSBAR_DURATION", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    b(ImageView paramImageView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.share.a
 * JD-Core Version:    0.7.0.1
 */