package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "context", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "hotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;Landroid/view/View;)V", "barContainer", "getBarContainer", "()Landroid/view/View;", "barContainer$delegate", "Lkotlin/Lazy;", "getContext", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "hotList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "getHotList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setHotList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getHotView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "initListEmpty", "", "getInitListEmpty", "()Z", "setInitListEmpty", "(Z)V", "isClickTitleLayout", "setClickTitleLayout", "isExpand", "", "()I", "setExpand", "(I)V", "listView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "getListView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "listView$delegate", "rightArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getRightArrow", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "rightArrow$delegate", "getRootView", "titleCountTv", "Landroid/widget/TextView;", "getTitleCountTv", "()Landroid/widget/TextView;", "titleCountTv$delegate", "titleLayout", "Landroid/widget/LinearLayout;", "getTitleLayout", "()Landroid/widget/LinearLayout;", "titleLayout$delegate", "titleTv", "getTitleTv", "titleTv$delegate", "doCollapseLiveBarAnimation", "", "doExpandLiveBarAnimation", "doItemAlphaAnimation", "expand", "doRightArrowAnimation", "view", "from", "", "to", "fromAlpha", "toAlpha", "hideVideoTitle", "initFinderLivesBar", "initList", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/BizFinderLiveInfo;", "fromType", "isLiveBarVisible", "marginLeftAnimation", "notifyDataChange", "onDestroy", "onLiveBarClick", "bizUserName", "", "onLiveStopStatusChange", "exportId", "scene", "onOrientationChange", "onPause", "onResume", "reportShow", "setLeftMargin", "marginLeft", "setOftenReadTitlePaddingLeft", "left", "setVideoTitlePaddingLeft", "sortList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showFinderLiveRedDot", "titleAlphaAnimation", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements k
{
  public static final a.a vOf;
  private static boolean vOr;
  private static final int vOs;
  private static final float vOt;
  private int nVf;
  final View rootView;
  private final BizTimeLineUI vOg;
  private final BizTimeLineHotView vOh;
  private final kotlin.j vOi;
  private final kotlin.j vOj;
  private final kotlin.j vOk;
  private final kotlin.j vOl;
  private final kotlin.j vOm;
  private final kotlin.j vOn;
  CopyOnWriteArrayList<e> vOo;
  private boolean vOp;
  private boolean vOq;
  
  static
  {
    AppMethodBeat.i(302399);
    vOf = new a.a((byte)0);
    vOs = 2;
    if (aw.isDarkMode()) {}
    for (float f = 0.9F;; f = 0.8F)
    {
      vOt = f;
      AppMethodBeat.o(302399);
      return;
    }
  }
  
  public a(BizTimeLineUI paramBizTimeLineUI, BizTimeLineHotView paramBizTimeLineHotView, View paramView)
  {
    AppMethodBeat.i(302276);
    this.vOg = paramBizTimeLineUI;
    this.vOh = paramBizTimeLineHotView;
    this.rootView = paramView;
    this.vOi = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.vOj = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.vOk = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.vOl = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.vOm = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.vOn = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.vOo = new CopyOnWriteArrayList();
    this.vOp = true;
    this.nVf = -1;
    deg().a((Context)this.vOg, (List)new ArrayList(), this.vOh.getReadReport(), (k)this, true);
    AppMethodBeat.o(302276);
  }
  
  private static final int a(boolean paramBoolean, e parame1, e parame2)
  {
    AppMethodBeat.i(302381);
    if (paramBoolean)
    {
      localc = c.XPt;
      if (s.p(c.iHj(), parame1.YIf))
      {
        AppMethodBeat.o(302381);
        return -1;
      }
    }
    if (paramBoolean)
    {
      localc = c.XPt;
      if (s.p(c.iHj(), parame2.YIf))
      {
        AppMethodBeat.o(302381);
        return 1;
      }
    }
    c localc = c.XPt;
    parame1.nXh = c.oZ(parame1.YIf, parame1.YSM);
    localc = c.XPt;
    parame2.nXh = c.oZ(parame2.YIf, parame2.YSM);
    if (parame1.nXh != parame2.nXh)
    {
      if (parame1.nXh)
      {
        AppMethodBeat.o(302381);
        return 1;
      }
      AppMethodBeat.o(302381);
      return -1;
    }
    AppMethodBeat.o(302381);
    return 0;
  }
  
  private static final void a(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(302376);
    s.u(paramView, "$view");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(302376);
      throw paramView;
    }
    paramView.setAlpha(((Float)paramValueAnimator).floatValue());
    AppMethodBeat.o(302376);
  }
  
  private static final void a(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(302362);
    s.u(parama, "this$0");
    com.tencent.mm.plugin.bizui.a.a locala = com.tencent.mm.plugin.bizui.a.a.vtB;
    parama = (View)parama.deg();
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(302362);
      throw parama;
    }
    com.tencent.mm.plugin.bizui.a.a.Z(parama, ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(302362);
  }
  
  private static final void a(a parama, View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(302368);
    s.u(parama, "this$0");
    s.u(paramView, "$view");
    parama = paramValueAnimator.getAnimatedValue();
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(302368);
      throw parama;
    }
    ae(paramView, ((Integer)parama).intValue());
    AppMethodBeat.o(302368);
  }
  
  private static final void a(a parama, List<? extends pi> paramList)
  {
    AppMethodBeat.i(302348);
    parama.nVf = 0;
    parama.dei().setRotation(0.0F);
    parama.deh().setVisibility(0);
    parama = c.XPt;
    c.xY(81L);
    h.OAn.b(23692, new Object[] { Integer.valueOf(1), Integer.valueOf(ad.getSessionId()), Integer.valueOf(paramList.size()), Integer.valueOf(1) });
    AppMethodBeat.o(302348);
  }
  
  private static final void a(a parama, List<? extends pi> paramList, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(302344);
    parama.nVf = 1;
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      pi localpi = (pi)((Iterator)localObject2).next();
      e locale = new e();
      locale.YIf = localpi.YIf;
      locale.YSM = localpi.YSM;
      locale.wrl = localpi.wrl;
      locale.YSN = localpi.YSN;
      locale.title = localpi.title;
      locale.vPS = localpi.nUM;
      if (paramInt == 1)
      {
        c localc = c.XPt;
        c.a(localpi);
      }
      ((Collection)localObject1).add(locale);
    }
    localObject2 = (List)localObject1;
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    d((ArrayList)localObject1, paramBoolean);
    localObject2 = parama.vOo;
    if (localObject2 != null) {
      ((CopyOnWriteArrayList)localObject2).clear();
    }
    localObject2 = parama.vOo;
    if (localObject2 != null) {
      ((CopyOnWriteArrayList)localObject2).addAll((Collection)localObject1);
    }
    parama.deg().setVisibility(0);
    localObject1 = (Collection)parama.vOo;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      parama.deh().setVisibility(8);
      if ((paramInt != 1) || (parama.vOp)) {
        break label458;
      }
      parama = c.XPt;
      c.xY(77L);
      Log.i("MicroMsg.BizFinderLiveBar", "doGetBizFinderLives refresh list on empty size");
      AppMethodBeat.o(302344);
      return;
    }
    if (paramInt == 0)
    {
      parama.vOp = false;
      localObject1 = c.XPt;
      c.xY(76L);
    }
    h.OAn.b(23692, new Object[] { Integer.valueOf(1), Integer.valueOf(ad.getSessionId()), Integer.valueOf(paramList.size()), Integer.valueOf(2) });
    parama.deh().setVisibility(0);
    parama.deg().f((List)parama.vOo, false);
    Log.d("MicroMsg.BizFinderLiveBar", "doGetBizFinderLives refresh data size=" + parama.vOo.size() + ", fromType=" + paramInt);
    label458:
    AppMethodBeat.o(302344);
  }
  
  private static final void a(a parama, List paramList, boolean paramBoolean, int paramInt, View paramView)
  {
    AppMethodBeat.i(302359);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramList);
    localb.fv(paramBoolean);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(paramList, "$validList");
    parama.vOh.getReadReport().vQd = true;
    parama.vOq = true;
    paramView = c.XPt;
    long l;
    int i;
    if (parama.nVf == 1)
    {
      l = 83L;
      c.xY(l);
      if (parama.nVf != 1) {
        break label300;
      }
      i = 2;
      label141:
      h.OAn.b(23692, new Object[] { Integer.valueOf(2), Integer.valueOf(ad.getSessionId()), Integer.valueOf(paramList.size()), Integer.valueOf(i) });
      if (parama.nVf != 0) {
        break label306;
      }
      a(parama, paramList, paramBoolean, paramInt);
      parama.del();
      parama.t((View)parama.dej(), 0, 0 - parama.dej().getMeasuredWidth());
      parama.az(0.9F, 0.3F);
      c((View)parama.dei(), 0.0F, 180.0F, vOt, 0.5F);
      parama.mW(true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(302359);
      return;
      l = 82L;
      break;
      label300:
      i = 1;
      break label141;
      label306:
      a(parama, paramList);
      parama.t((View)parama.dej(), 0 - parama.dej().getMeasuredWidth(), 0);
      parama.az(0.3F, 0.9F);
      c((View)parama.dei(), 180.0F, 0.0F, 0.5F, vOt);
      parama.mW(false);
    }
  }
  
  private static void ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(302328);
    if (paramView == null)
    {
      localObject = null;
      if (!(localObject instanceof RelativeLayout.LayoutParams)) {
        break label60;
      }
    }
    label60:
    for (Object localObject = (RelativeLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
        if (paramView != null) {
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(302328);
      return;
      localObject = paramView.getLayoutParams();
      break;
    }
  }
  
  private final void az(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(302316);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda2(this));
    localValueAnimator.start();
    AppMethodBeat.o(302316);
  }
  
  private static final void b(a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(302374);
    s.u(parama, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(302374);
      throw parama;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    parama.getTitleTv().setAlpha(f);
    parama.dej().setAlpha(f);
    AppMethodBeat.o(302374);
  }
  
  private static void c(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(302323);
    Object localObject = new RotateAnimation(paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject).setDuration(300L);
    ((RotateAnimation)localObject).setFillAfter(true);
    paramView.startAnimation((Animation)localObject);
    localObject = ValueAnimator.ofFloat(new float[] { paramFloat3, paramFloat4 });
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).addUpdateListener(new a..ExternalSyntheticLambda0(paramView));
    ((ValueAnimator)localObject).start();
    AppMethodBeat.o(302323);
  }
  
  private static void d(ArrayList<e> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(302334);
    if (((Collection)paramArrayList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(302334);
      return;
    }
    p.a((List)paramArrayList, new a..ExternalSyntheticLambda5(paramBoolean));
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    e locale;
    for (paramArrayList = null; localIterator.hasNext(); paramArrayList = locale)
    {
      locale = (e)localIterator.next();
      locale.vPR = false;
      if ((paramArrayList != null) && (!paramArrayList.nXh) && (locale.nXh))
      {
        locale.vPR = true;
        paramArrayList.vPR = true;
      }
    }
    AppMethodBeat.o(302334);
  }
  
  private View deh()
  {
    AppMethodBeat.i(302281);
    View localView = (View)this.vOj.getValue();
    AppMethodBeat.o(302281);
    return localView;
  }
  
  private WeImageView dei()
  {
    AppMethodBeat.i(302286);
    WeImageView localWeImageView = (WeImageView)this.vOk.getValue();
    AppMethodBeat.o(302286);
    return localWeImageView;
  }
  
  private TextView dej()
  {
    AppMethodBeat.i(302295);
    TextView localTextView = (TextView)this.vOm.getValue();
    AppMethodBeat.o(302295);
    return localTextView;
  }
  
  private TextView getTitleTv()
  {
    AppMethodBeat.i(302290);
    TextView localTextView = (TextView)this.vOl.getValue();
    AppMethodBeat.o(302290);
    return localTextView;
  }
  
  private final void mW(boolean paramBoolean)
  {
    AppMethodBeat.i(302303);
    AlphaAnimation localAlphaAnimation;
    int i;
    if (paramBoolean)
    {
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setStartOffset(100L);
      deg().startAnimation((Animation)localAlphaAnimation);
      i = BizTimeLineHotListView.fM((Context)this.vOg);
      if (!paramBoolean) {
        break label139;
      }
    }
    label139:
    for (ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, i });; localValueAnimator = ValueAnimator.ofInt(new int[] { i, 0 }))
    {
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda1(this));
      localAlphaAnimation.setAnimationListener((Animation.AnimationListener)new c(paramBoolean, this));
      localValueAnimator.start();
      AppMethodBeat.o(302303);
      return;
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      break;
    }
  }
  
  private final void t(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(302312);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new a..ExternalSyntheticLambda3(this, paramView));
    localValueAnimator.start();
    AppMethodBeat.o(302312);
  }
  
  public final void Q(String paramString1, String paramString2, int paramInt) {}
  
  public final void ajd(String paramString)
  {
    AppMethodBeat.i(302488);
    this.vOh.ajd(paramString);
    AppMethodBeat.o(302488);
  }
  
  public final void c(LinkedList<pi> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(302465);
    s.u(paramLinkedList, "list");
    label91:
    boolean bool;
    if (this.vOg.getIntent().getIntExtra("Main_BizFinderLiveRedDotType", 0) == 1)
    {
      localObject1 = c.XPt;
      localObject1 = (CharSequence)c.iHj();
      if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
      {
        i = 1;
        if (i != 0) {
          break label285;
        }
        localObject1 = c.XPt;
        localObject1 = (CharSequence)c.iHk();
        if ((localObject1 != null) && (!n.bp((CharSequence)localObject1))) {
          break label280;
        }
        i = 1;
        if (i != 0) {
          break label285;
        }
        bool = true;
        label98:
        if (bool)
        {
          localObject1 = c.XPt;
          c.co(paramLinkedList);
        }
        localObject1 = (Iterable)paramLinkedList;
        paramLinkedList = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
      }
    }
    label138:
    label280:
    label408:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label410;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      pi localpi = (pi)localObject2;
      Object localObject3 = c.XPt;
      s.u(localpi, "info");
      if (ab.IR(localpi.YIf))
      {
        localObject3 = (CharSequence)localpi.YSM;
        if ((localObject3 == null) || (n.bp((CharSequence)localObject3)))
        {
          i = 1;
          label213:
          if (i == 0) {
            break label296;
          }
        }
      }
      else
      {
        Log.i("MicroMsg.BizFinderLiveLogic", "canShowLiveBarItem return " + localpi.YIf + ' ' + localpi.YSM);
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label408;
        }
        paramLinkedList.add(localObject2);
        break label138;
        i = 0;
        break;
        i = 0;
        break label91;
        label285:
        bool = false;
        break label98;
        i = 0;
        break label213;
        label296:
        if ((!c.iHg()) && (!s.p(localpi.YIf, c.XPK)))
        {
          localObject3 = localpi.YIf;
          s.s(localObject3, "info.bizusername");
          i = c.im((String)localObject3, c.iHl());
          if ((i >= c.iHc()) && (!c.oZ(localpi.YIf, localpi.YSM)))
          {
            Log.i("MicroMsg.BizFinderLiveLogic", "canShowLiveBarItem " + localpi.YIf + " hasShowTimes = " + i);
            i = 0;
            continue;
          }
        }
        i = 1;
      }
    }
    label410:
    paramLinkedList = p.c((Iterable)paramLinkedList, 30);
    dej().setText((CharSequence)s.X(" ", this.vOg.getResources().getString(d.i.biz_time_line_finder_live_title_fold, new Object[] { Integer.valueOf(paramLinkedList.size()) })));
    ((LinearLayout)this.vOn.getValue()).setOnClickListener(new a..ExternalSyntheticLambda4(this, paramLinkedList, bool, paramInt));
    Object localObject1 = (Collection)paramLinkedList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      if ((!this.vOq) || (this.nVf != 0))
      {
        if ((this.vOq) || (bool)) {
          break;
        }
        localObject1 = c.XPt;
        if (!c.ms(paramLinkedList)) {
          break;
        }
      }
      getTitleTv().setAlpha(0.9F);
      dej().setAlpha(0.9F);
      dei().setRotation(0.0F);
      dei().setAlpha(vOt);
      deg().setVisibility(8);
      ae((View)dej(), 0);
      a(this, paramLinkedList);
      AppMethodBeat.o(302465);
      return;
    }
    getTitleTv().setAlpha(0.3F);
    dej().setAlpha(0.3F);
    dei().setRotation(180.0F);
    dei().setAlpha(0.5F);
    ae((View)dej(), 0 - com.tencent.mm.cd.a.fromDPToPix((Context)this.vOg, 200));
    a(this, paramLinkedList, bool, paramInt);
    AppMethodBeat.o(302465);
  }
  
  public final BizTimeLineHotListView deg()
  {
    AppMethodBeat.i(302432);
    BizTimeLineHotListView localBizTimeLineHotListView = (BizTimeLineHotListView)this.vOi.getValue();
    AppMethodBeat.o(302432);
    return localBizTimeLineHotListView;
  }
  
  public final void dek()
  {
    AppMethodBeat.i(302438);
    Object localObject1 = new WeakReference(this);
    kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new a.a.a((WeakReference)localObject1, null), 2);
    localObject1 = c.XPt;
    localObject1 = c.iHe();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (Collection)((pn)localObject1).YSX;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        break label198;
      }
    }
    label198:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = c.XPt;
        long l = c.iHd();
        localObject2 = c.XPt;
        i = vOs;
        i = kotlin.k.k.qu(c.atj().decodeInt(s.X("bar_list_keep_data_interval-", Integer.valueOf(i)), 0), 60);
        if (System.currentTimeMillis() - l < i * 1000)
        {
          Log.i("MicroMsg.BizFinderLiveBar", "initFinderLivesBar use cache");
          localObject2 = c.XPt;
          c.xY(75L);
          localObject1 = ((pn)localObject1).YSX;
          s.s(localObject1, "resp.live_info");
          c((LinkedList)localObject1, 0);
        }
      }
      AppMethodBeat.o(302438);
      return;
    }
  }
  
  public final void del()
  {
    AppMethodBeat.i(302443);
    label100:
    label109:
    label112:
    for (;;)
    {
      try
      {
        if ((this.nVf == 1) && (deh().getVisibility() == 0))
        {
          localObject = (Collection)this.vOo;
          if (localObject == null) {
            break label100;
          }
          if (!((Collection)localObject).isEmpty()) {
            break label109;
          }
          break label100;
        }
        AppMethodBeat.o(302443);
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.BizFinderLiveBar", (Throwable)localException, "reportShow", new Object[0]);
        AppMethodBeat.o(302443);
        return;
      }
      localObject = deg();
      if (localObject != null)
      {
        ((BizTimeLineHotListView)localObject).del();
        AppMethodBeat.o(302443);
        return;
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label112;
        }
        break;
      }
    }
  }
  
  public final boolean dem()
  {
    AppMethodBeat.i(302450);
    if (deh().getVisibility() == 0)
    {
      AppMethodBeat.o(302450);
      return true;
    }
    AppMethodBeat.o(302450);
    return false;
  }
  
  public final void den() {}
  
  public final void deo() {}
  
  public final void setOftenReadTitlePaddingLeft(float paramFloat) {}
  
  public final void setVideoTitlePaddingLeft(float paramFloat) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<View>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar$doItemAlphaAnimation$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animation.AnimationListener
  {
    c(boolean paramBoolean, a parama) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(302395);
      if (!this.vOw) {
        jdField_this.deg().setVisibility(8);
      }
      AppMethodBeat.o(302395);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<BizTimeLineHotListView>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WeImageView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    g(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<TextView>
  {
    h(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */