package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderDescPanelUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "buzzwordCarouselFlag", "", "buzzwordCarouselHit", "buzzwordFavFlag", "buzzwordFavHit", "currKey", "", "currKeyMap", "", "", "descriptionItem", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC;", "getDescriptionItem", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC;", "descriptionItem$delegate", "Lkotlin/Lazy;", "holderRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "hotCommentFlag", "hotCommentHit", "hotCommentItem", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC;", "getHotCommentItem", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC;", "hotCommentItem$delegate", "isPausing", "isShownNext", "isTimerEnable", "isWaitingForDeepEnjoy", "lastFeedId", "nextMsgTime", "panelItemList", "", "panelItemMap", "Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "resumeDelayMs", "ringtoneFlag", "ringtoneHit", "ringtoneItem", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC;", "getRingtoneItem", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC;", "ringtoneItem$delegate", "selfFlag", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "videoFinishListener", "com/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC$videoFinishListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC$videoFinishListener$1;", "wordingItem", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC;", "getWordingItem", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC;", "wordingItem$delegate", "adjustSeekLayout", "", "holder", "animateOtherPullUp", "fromItem", "pullUpHeight", "checkFlag", "Lkotlin/Pair;", "key", "fromUser", "defaultPanelList", "disableTimer", "enableTimer", "findNextItem", "findPrevItem", "hitReport", "imageAdjustSeekLayout", "isConfigCanShow", "onBindView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusHolder", "onItemShown", "onPause", "onResume", "pauseTimer", "postTimerMsg", "delayMs", "realAdjustSeekLayout", "banner", "Landroid/view/View;", "seekLayout", "seekBar", "resumeTimer", "selfPanelList", "switch", "key2", "transformItems", "toItem", "tryReport", "tryShow", "tryShowNext", "tryShowPrev", "videoAdjustSeekbar", "getHeightInAdvance", "getMeasurements", "Landroid/graphics/Point;", "parent", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
  implements ab
{
  public static final a GNw;
  private long AVm;
  private boolean AXX;
  private boolean GNA;
  private boolean GNB;
  private long GNC;
  private long GND;
  private final MMHandler GNE;
  private WeakReference<com.tencent.mm.view.recyclerview.j> GNF;
  private final FinderDescPanelUIC.videoFinishListener.1 GNG;
  private final kotlin.j GNH;
  private final kotlin.j GNI;
  private final kotlin.j GNJ;
  private final kotlin.j GNK;
  public int GNL;
  public final List<Integer> GNM;
  private final Map<Integer, bh> GNN;
  private final boolean GNO;
  private final boolean GNP;
  private final boolean GNQ;
  private final boolean GNR;
  private final boolean GNS;
  private final boolean GNT;
  private final boolean GNU;
  private final boolean GNV;
  private final Map<Long, Integer> GNx;
  boolean GNy;
  private boolean GNz;
  
  static
  {
    AppMethodBeat.i(338205);
    GNw = new a((byte)0);
    AppMethodBeat.o(338205);
  }
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337818);
    this.GNx = ((Map)new LinkedHashMap());
    this.GNC = -1L;
    this.GND = -1L;
    this.GNE = new MMHandler(Looper.getMainLooper(), new l..ExternalSyntheticLambda0(this));
    this.GNG = new FinderDescPanelUIC.videoFinishListener.1(this, com.tencent.mm.app.f.hfK);
    this.GNH = k.cm((a)new b(this));
    this.GNI = k.cm((a)new e(this));
    this.GNJ = k.cm((a)new d(this));
    this.GNK = k.cm((a)new c(this));
    this.AVm = -1L;
    this.GNM = ((List)new ArrayList());
    this.GNN = ((Map)new LinkedHashMap());
    paramAppCompatActivity = d.FAy;
    if ((((Number)d.eYz().bmg()).intValue() == 2) || (h.baE().ban().getBoolean(at.a.adhw, false)))
    {
      bool1 = true;
      this.GNO = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYz().bmg()).intValue() == 0) && (!h.baE().ban().getBoolean(at.a.adhA, false))) {
        break label543;
      }
      bool1 = true;
      label270:
      this.GNP = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYz().bmg()).intValue() != 2) && (!h.baE().ban().getBoolean(at.a.adhx, false))) {
        break label548;
      }
      bool1 = true;
      label313:
      this.GNQ = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYz().bmg()).intValue() == 0) && (!h.baE().ban().getBoolean(at.a.adhB, false))) {
        break label553;
      }
      bool1 = true;
      label355:
      this.GNR = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYB().bmg()).intValue() != 2) && (!h.baE().ban().getBoolean(at.a.adhy, false))) {
        break label558;
      }
      bool1 = true;
      label398:
      this.GNS = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYB().bmg()).intValue() == 0) && (!h.baE().ban().getBoolean(at.a.adhC, false))) {
        break label563;
      }
      bool1 = true;
      label440:
      this.GNT = bool1;
      paramAppCompatActivity = d.FAy;
      if ((((Number)d.eYA().bmg()).intValue() != 2) && (!h.baE().ban().getBoolean(at.a.adhz, false))) {
        break label568;
      }
    }
    label543:
    label548:
    label553:
    label558:
    label563:
    label568:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.GNU = bool1;
      paramAppCompatActivity = d.FAy;
      if (((Number)d.eYA().bmg()).intValue() == 0)
      {
        bool1 = bool2;
        if (!h.baE().ban().getBoolean(at.a.adhD, false)) {}
      }
      else
      {
        bool1 = true;
      }
      this.GNV = bool1;
      AppMethodBeat.o(337818);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label270;
      bool1 = false;
      break label313;
      bool1 = false;
      break label355;
      bool1 = false;
      break label398;
      bool1 = false;
      break label440;
    }
  }
  
  private final void K(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(337870);
    Object localObject = d.FAy;
    if (((Number)d.eWp().bmg()).intValue() == 0)
    {
      localObject = (FinderMediaBanner)paramj.UH(e.e.media_banner);
      if (localObject == null)
      {
        AppMethodBeat.o(337870);
        return;
      }
      View localView1 = paramj.UH(e.e.finder_seek_bar_footer_layout);
      if (localView1 == null)
      {
        AppMethodBeat.o(337870);
        return;
      }
      View localView2 = localView1.findViewById(e.e.preview_full_seek_bar);
      if (localView2 != null) {
        localView2.post(new l..ExternalSyntheticLambda1(this, paramj, (FinderMediaBanner)localObject, localView1, localView2));
      }
    }
    AppMethodBeat.o(337870);
  }
  
  private final void P(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(337929);
    if (!this.AXX)
    {
      Iterator localIterator = ((Iterable)this.GNM).iterator();
      while (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        Object localObject = (bh)this.GNN.get(Integer.valueOf(i));
        if (localObject != null)
        {
          boolean bool1 = ((bh)localObject).R(paramj);
          localObject = aX(i, false);
          boolean bool2 = ((Boolean)((r)localObject).bsC).booleanValue();
          boolean bool3 = ((Boolean)((r)localObject).bsD).booleanValue();
          Log.i("Finder.DescPanelUIC", "tryReport key = " + i + " isHit = " + bool2 + " isNeedShow = " + bool1 + " isShow = " + bool3);
          if ((bool2) && (bool1))
          {
            switch (i)
            {
            default: 
              localObject = null;
            }
            while (localObject != null)
            {
              Log.i("Finder.DescPanelUIC", "hitReport key = " + i + " fromUser = false");
              c localc = (c)h.ax(c.class);
              if (localc == null) {
                break;
              }
              localc.a((c.a)localObject, 0);
              break;
              localObject = c.a.yKc;
              continue;
              localObject = c.a.yKe;
              continue;
              localObject = c.a.yKd;
            }
          }
        }
      }
    }
    AppMethodBeat.o(337929);
  }
  
  private static void Q(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338019);
    kotlin.g.b.s.u(paramj, "holder");
    View localView1 = paramj.UH(e.e.finder_seek_bar_footer_layout);
    if (localView1 == null)
    {
      AppMethodBeat.o(338019);
      return;
    }
    View localView2 = paramj.UH(e.e.image_banner_indicator);
    if (localView2 == null)
    {
      AppMethodBeat.o(338019);
      return;
    }
    View localView3 = localView1.findViewById(e.e.awesome_ground_layout);
    if (localView3 != null) {
      localView2.post(new l..ExternalSyntheticLambda2(paramj, localView2, localView1, localView3));
    }
    AppMethodBeat.o(338019);
  }
  
  private static final void a(l paraml, com.tencent.mm.view.recyclerview.j paramj, FinderMediaBanner paramFinderMediaBanner, View paramView1, View paramView2)
  {
    AppMethodBeat.i(338101);
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramFinderMediaBanner, "$banner");
    kotlin.g.b.s.u(paramView1, "$seekLayout");
    kotlin.g.b.s.u(paramView2, "$seekBar");
    View localView1 = (View)paramFinderMediaBanner;
    paraml = paramj.UH(e.e.footer_op_layout);
    Object localObject;
    View localView2;
    int i;
    int k;
    if (paraml != null)
    {
      localObject = (ViewGroup)paramj.UH(e.e.finder_feed_full_footer_layout);
      if (localObject != null)
      {
        localView2 = paramj.UH(e.e.finder_feed_wording_attribute_layout);
        if (localView2 != null)
        {
          i = 0;
          k = ((ViewGroup)localObject).getChildCount();
          if (k <= 0) {}
        }
      }
    }
    for (;;)
    {
      int j = i + 1;
      paramFinderMediaBanner = ((ViewGroup)localObject).getChildAt(i);
      label146:
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      if (paramFinderMediaBanner.getVisibility() == 0) {
        if (paramFinderMediaBanner.getAlpha() == 0.0F)
        {
          i = 1;
          if (i != 0) {
            break label340;
          }
          paraml = paramFinderMediaBanner;
          localObject = new int[2];
          paramFinderMediaBanner = new int[2];
          arrayOfInt1 = new int[2];
          arrayOfInt2 = new int[2];
          paramj.caK.getLocationInWindow((int[])localObject);
          localView1.getLocationInWindow(paramFinderMediaBanner);
          paramFinderMediaBanner[0] -= localObject[0];
          paramFinderMediaBanner[1] -= localObject[1];
          paraml.getLocationInWindow(arrayOfInt1);
          arrayOfInt1[0] -= localObject[0];
          arrayOfInt1[1] -= localObject[1];
          localView2.getLocationInWindow(arrayOfInt2);
          arrayOfInt2[0] -= localObject[0];
          arrayOfInt2[1] -= localObject[1];
          if (localView2.getVisibility() != 0) {
            break label356;
          }
          if (localView2.getAlpha() != 0.0F) {
            break label350;
          }
          i = 1;
          label288:
          if (i != 0) {
            break label356;
          }
        }
      }
      label340:
      label350:
      label356:
      for (i = Math.min(arrayOfInt1[1], arrayOfInt2[1]);; i = arrayOfInt1[1])
      {
        paraml = paramView1.getLayoutParams();
        if (paraml != null) {
          break label365;
        }
        paraml = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(338101);
        throw paraml;
        i = 0;
        break;
        if (j < k) {
          break label495;
        }
        break label146;
        i = 0;
        break label288;
      }
      label365:
      paraml = (FrameLayout.LayoutParams)paraml;
      j = paraml.topMargin;
      k = paramView2.getHeight();
      int m = paramView1.getHeight();
      if (paramFinderMediaBanner[1] + localView1.getHeight() + paramView1.getHeight() > i) {
        k = (int)paramj.context.getResources().getDimension(e.c.Edge_A);
      }
      for (paraml.topMargin = (i - paramView1.getHeight() - k);; paraml.topMargin = ((int)paramj.context.getResources().getDimension(e.c.Edge_1_5_A) + (paramFinderMediaBanner[1] + localView1.getHeight() - (m - k))))
      {
        if (paraml.topMargin != j) {
          paramView1.requestLayout();
        }
        AppMethodBeat.o(338101);
        return;
      }
      label495:
      i = j;
    }
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, long paramLong)
  {
    AppMethodBeat.i(337894);
    paramLong = SystemClock.uptimeMillis() + paramLong;
    paramj = this.GNE.obtainMessage(1, paramj);
    this.GNE.sendMessageAtTime(paramj, paramLong);
    this.GND = paramLong;
    AppMethodBeat.o(337894);
  }
  
  private final void a(com.tencent.mm.view.recyclerview.j paramj, bh parambh1, bh parambh2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(337966);
    Object localObject1 = paramj.CSA;
    if ((localObject1 instanceof BaseFinderFeed)) {}
    for (localObject1 = (BaseFinderFeed)localObject1; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(337966);
      return;
    }
    if (parambh1 == null)
    {
      AppMethodBeat.o(337966);
      return;
    }
    if (parambh2 == null)
    {
      AppMethodBeat.o(337966);
      return;
    }
    Object localObject2 = aX(parambh2.key, paramBoolean);
    boolean bool1 = ((Boolean)((r)localObject2).bsC).booleanValue();
    boolean bool2 = ((Boolean)((r)localObject2).bsD).booleanValue();
    if ((!this.AXX) && ((!bool1) || (!bool2)))
    {
      AppMethodBeat.o(337966);
      return;
    }
    localObject2 = parambh1.S(paramj);
    int i;
    if (localObject2 == null)
    {
      i = 0;
      localObject2 = parambh2.S(paramj);
      if (localObject2 != null) {
        break label232;
      }
    }
    for (;;)
    {
      parambh1.e(paramj, paramBoolean);
      parambh2.d(paramj, paramBoolean);
      h(paramj, j - i);
      this.GNL = parambh2.key;
      this.GNx.put(Long.valueOf(((BaseFinderFeed)localObject1).bZA()), Integer.valueOf(this.GNL));
      AppMethodBeat.o(337966);
      return;
      i = hk((View)localObject2);
      break;
      label232:
      j = hk((View)localObject2);
    }
  }
  
  private static final boolean a(l paraml, Message paramMessage)
  {
    AppMethodBeat.i(338073);
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramMessage, "msg");
    if (!paraml.GNy)
    {
      AppMethodBeat.o(338073);
      return true;
    }
    com.tencent.mm.view.recyclerview.j localj;
    BaseFinderFeed localBaseFinderFeed;
    bh localbh;
    int i;
    int j;
    boolean bool1;
    label257:
    Object localObject;
    if (paramMessage.what == 1)
    {
      paraml.GND = -1L;
      if (!paraml.GNz)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage instanceof com.tencent.mm.view.recyclerview.j)) {}
        for (localj = (com.tencent.mm.view.recyclerview.j)paramMessage; localj == null; localj = null)
        {
          AppMethodBeat.o(338073);
          return true;
        }
        paramMessage = localj.CSA;
        if ((paramMessage instanceof BaseFinderFeed)) {}
        for (localBaseFinderFeed = (BaseFinderFeed)paramMessage; localBaseFinderFeed == null; localBaseFinderFeed = null)
        {
          AppMethodBeat.o(338073);
          return true;
        }
        localbh = (bh)paraml.GNN.get(Integer.valueOf(paraml.GNL));
        i = paraml.GNL;
        i = paraml.GNM.indexOf(Integer.valueOf(i));
        int m = paraml.GNM.size();
        j = 0;
        if (j >= m - 1) {
          break label514;
        }
        int k = ((Number)paraml.GNM.get((i + 1) % paraml.GNM.size())).intValue();
        paramMessage = (bh)paraml.GNN.get(Integer.valueOf(k));
        if ((paramMessage != null) && (paramMessage.R(localj)))
        {
          bool1 = true;
          Log.i("Finder.DescPanelUIC", "findNextItem findKey = " + k + " isNeedShow = " + bool1);
          if (!bool1) {
            break label484;
          }
          localObject = paraml.aX(k, false);
          bool1 = ((Boolean)((r)localObject).bsC).booleanValue();
          boolean bool2 = ((Boolean)((r)localObject).bsD).booleanValue();
          if ((!paraml.AXX) && ((!bool1) || (!bool2))) {
            break label484;
          }
          i = k;
        }
      }
    }
    for (;;)
    {
      localObject = paramMessage;
      if (paramMessage == null)
      {
        localObject = (bh)paraml.GNN.get(Integer.valueOf(0));
        i = 0;
      }
      kotlin.g.b.s.checkNotNull(localObject);
      paramMessage = kotlin.v.Y(Integer.valueOf(i), localObject);
      paraml.P(localj);
      localObject = (bh)paramMessage.bsD;
      i = ((Number)paramMessage.bsC).intValue();
      Log.i("Finder.DescPanelUIC", "SHOW_NEXT item.desc = " + localBaseFinderFeed.feedObject.getDescription() + " nextKey = " + i);
      if (kotlin.g.b.s.p(localObject, localbh))
      {
        AppMethodBeat.o(338073);
        return true;
        bool1 = false;
        break label257;
        label484:
        j += 1;
        i += 1;
        break;
      }
      paraml.a(localj, localbh, (bh)localObject, false);
      AppMethodBeat.o(338073);
      return true;
      label514:
      i = -1;
      paramMessage = null;
    }
  }
  
  private final boolean aW(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(337943);
    r localr = aX(paramInt, paramBoolean);
    paramBoolean = ((Boolean)localr.bsC).booleanValue();
    boolean bool = ((Boolean)localr.bsD).booleanValue();
    if ((paramBoolean) && (bool))
    {
      AppMethodBeat.o(337943);
      return true;
    }
    AppMethodBeat.o(337943);
    return false;
  }
  
  private final r<Boolean, Boolean> aX(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(337999);
    switch (paramInt)
    {
    default: 
      localObject = Boolean.FALSE;
      localObject = kotlin.v.Y(localObject, localObject);
      AppMethodBeat.o(337999);
      return localObject;
    case 1: 
      if (paramBoolean)
      {
        localObject = kotlin.v.Y(Boolean.valueOf(this.GNR), Boolean.valueOf(this.GNQ));
        AppMethodBeat.o(337999);
        return localObject;
      }
      localObject = kotlin.v.Y(Boolean.valueOf(this.GNP), Boolean.valueOf(this.GNO));
      AppMethodBeat.o(337999);
      return localObject;
    case 2: 
      localObject = kotlin.v.Y(Boolean.valueOf(this.GNV), Boolean.valueOf(this.GNU));
      AppMethodBeat.o(337999);
      return localObject;
    case 3: 
      localObject = kotlin.v.Y(Boolean.valueOf(this.GNT), Boolean.valueOf(this.GNS));
      AppMethodBeat.o(337999);
      return localObject;
    }
    Object localObject = Boolean.TRUE;
    localObject = kotlin.v.Y(localObject, localObject);
    AppMethodBeat.o(337999);
    return localObject;
  }
  
  private static final void b(com.tencent.mm.view.recyclerview.j paramj, View paramView1, View paramView2, View paramView3)
  {
    AppMethodBeat.i(338120);
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramView1, "$indicator");
    kotlin.g.b.s.u(paramView2, "$seekLayout");
    kotlin.g.b.s.u(paramView3, "$awesome");
    Object localObject = new int[2];
    int[] arrayOfInt = new int[2];
    paramj.caK.getLocationInWindow((int[])localObject);
    paramView1.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] -= localObject[0];
    arrayOfInt[1] -= localObject[1];
    paramj = paramView1.getLayoutParams();
    if (paramj == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(338120);
      throw paramj;
    }
    paramj = (FrameLayout.LayoutParams)paramj;
    localObject = paramView2.getLayoutParams();
    if (localObject == null)
    {
      paramj = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(338120);
      throw paramj;
    }
    ((FrameLayout.LayoutParams)localObject).topMargin = (paramj.topMargin + (paramView1.getHeight() - paramView3.getHeight()) / 2);
    paramView2.requestLayout();
    AppMethodBeat.o(338120);
  }
  
  private final q fnl()
  {
    AppMethodBeat.i(337829);
    q localq = (q)this.GNH.getValue();
    AppMethodBeat.o(337829);
    return localq;
  }
  
  private final v fnm()
  {
    AppMethodBeat.i(337838);
    v localv = (v)this.GNI.getValue();
    AppMethodBeat.o(337838);
    return localv;
  }
  
  private final u fnn()
  {
    AppMethodBeat.i(337847);
    u localu = (u)this.GNJ.getValue();
    AppMethodBeat.o(337847);
    return localu;
  }
  
  private final s fno()
  {
    AppMethodBeat.i(337860);
    s locals = (s)this.GNK.getValue();
    AppMethodBeat.o(337860);
    return locals;
  }
  
  private final void fnp()
  {
    AppMethodBeat.i(337880);
    this.GNM.clear();
    this.GNN.clear();
    Object localObject = fnl();
    if (localObject != null)
    {
      ((bh)localObject).key = 0;
      this.GNM.add(Integer.valueOf(0));
      this.GNN.put(Integer.valueOf(0), localObject);
    }
    localObject = fnn();
    if (localObject != null)
    {
      ((bh)localObject).key = 2;
      this.GNM.add(Integer.valueOf(2));
      this.GNN.put(Integer.valueOf(2), localObject);
    }
    localObject = fnm();
    if (localObject != null)
    {
      ((bh)localObject).key = 1;
      this.GNM.add(Integer.valueOf(1));
      this.GNN.put(Integer.valueOf(1), localObject);
    }
    localObject = fno();
    if (localObject != null)
    {
      ((bh)localObject).key = 3;
      this.GNM.add(Integer.valueOf(3));
      this.GNN.put(Integer.valueOf(3), localObject);
    }
    AppMethodBeat.o(337880);
  }
  
  private static void h(com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(337983);
    paramj = (ViewGroup)paramj.UH(e.e.finder_feed_full_footer_layout);
    if (paramj == null)
    {
      AppMethodBeat.o(337983);
      return;
    }
    int i = 0;
    int k = paramj.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = paramj.getChildAt(i);
      if ((localView.getId() == e.e.finder_feed_full_footer_header_layout) || (localView.getId() == e.e.footer_op_layout))
      {
        AppMethodBeat.o(337983);
        return;
      }
      localView.setTranslationY(localView.getTranslationY() + paramInt);
      localView.animate().translationYBy(-paramInt).setDuration(250L).start();
      if (j >= k)
      {
        AppMethodBeat.o(337983);
        return;
      }
      i = j;
    }
  }
  
  private static int hk(View paramView)
  {
    AppMethodBeat.i(338032);
    int i = paramView.getHeight();
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      if ((i > 0) || (localObject == null)) {
        break label58;
      }
      i = p(paramView, (View)localObject).y;
    }
    label58:
    for (;;)
    {
      AppMethodBeat.o(338032);
      return i;
      localObject = null;
      break;
    }
  }
  
  private static Point p(View paramView1, View paramView2)
  {
    AppMethodBeat.i(338042);
    paramView1.measure(View.MeasureSpec.makeMeasureSpec(paramView2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramView2.getHeight(), 0));
    paramView1 = new Point(paramView1.getMeasuredWidth(), paramView1.getMeasuredHeight());
    AppMethodBeat.o(338042);
    return paramView1;
  }
  
  public final void L(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338281);
    kotlin.g.b.s.u(paramj, "holder");
    this.GNz = true;
    n(paramj);
    AppMethodBeat.o(338281);
  }
  
  public final void M(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338335);
    kotlin.g.b.s.u(paramj, "holder");
    this.GNF = new WeakReference(paramj);
    Object localObject1 = paramj.CSA;
    if ((localObject1 instanceof BaseFinderFeed)) {}
    for (localObject1 = (BaseFinderFeed)localObject1; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(338335);
      return;
    }
    boolean bool1;
    long l;
    Object localObject2;
    if (this.AVm != ((BaseFinderFeed)localObject1).bZA())
    {
      bool1 = true;
      l = this.AVm;
      if (!bool1) {
        break label268;
      }
      this.AVm = ((BaseFinderFeed)localObject1).bZA();
      localObject2 = this.GNx.get(Long.valueOf(((BaseFinderFeed)localObject1).bZA()));
      if (localObject2 != null) {
        break label361;
      }
      localObject2 = Integer.valueOf(0);
    }
    label268:
    label361:
    for (;;)
    {
      this.GNL = ((Number)localObject2).intValue();
      this.GNA = false;
      this.GND = -1L;
      this.GNC = -1L;
      this.GNB = false;
      if (this.GNL != 0) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        this.GNz = bool2;
        fnq();
        if (this.GNz) {
          break label268;
        }
        localObject2 = (dji)p.oL((List)((BaseFinderFeed)localObject1).feedObject.getMediaList());
        if (localObject2 != null) {
          break label233;
        }
        AppMethodBeat.o(338335);
        return;
        bool1 = false;
        break;
      }
      label233:
      if ((((dji)localObject2).aaPh == 0L) || (((dji)localObject2).aaPh > 30000L))
      {
        this.GNy = true;
        a(paramj, 30000L);
      }
      for (;;)
      {
        localObject2 = ((Iterable)this.GNM).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          int i = ((Number)((Iterator)localObject2).next()).intValue();
          bh localbh = (bh)this.GNN.get(Integer.valueOf(i));
          if (localbh != null) {
            localbh.b(paramj, bool1, l, ((BaseFinderFeed)localObject1).bZA());
          }
        }
        this.GNA = true;
      }
      AppMethodBeat.o(338335);
      return;
    }
  }
  
  public final void N(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338363);
    kotlin.g.b.s.u(paramj, "holder");
    this.GNE.removeMessages(1);
    long l = SystemClock.uptimeMillis();
    if (this.GND > 0L)
    {
      this.GNB = true;
      this.GNC = Math.max(0L, this.GND - l);
    }
    AppMethodBeat.o(338363);
  }
  
  public final void O(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338377);
    kotlin.g.b.s.u(paramj, "holder");
    if ((this.GNB) && (this.GNC > 0L))
    {
      this.GNE.removeMessages(1);
      this.GNB = false;
      a(paramj, this.GNC);
    }
    AppMethodBeat.o(338377);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(338391);
    kotlin.g.b.s.u(paramj, "holder");
    if (!this.GNM.contains(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(338391);
      return;
    }
    bh localbh1 = (bh)this.GNN.get(Integer.valueOf(paramInt));
    if (localbh1 == null)
    {
      AppMethodBeat.o(338391);
      return;
    }
    bh localbh2 = (bh)this.GNN.get(Integer.valueOf(this.GNL));
    if (localbh2 == null)
    {
      AppMethodBeat.o(338391);
      return;
    }
    if ((!kotlin.g.b.s.p(localbh1, localbh2)) && (localbh1.R(paramj)) && (aW(paramInt, paramBoolean)))
    {
      a(paramj, localbh2, localbh1, paramBoolean);
      this.GNL = paramInt;
      if (paramBoolean) {
        this.GNy = true;
      }
    }
    AppMethodBeat.o(338391);
  }
  
  public final void c(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(338267);
    kotlin.g.b.s.u(paramj, "holder");
    Object localObject1 = paramj.CSA;
    if ((localObject1 instanceof BaseFinderFeed)) {}
    for (localObject1 = (BaseFinderFeed)localObject1; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(338267);
      return;
    }
    if (this.AXX != paramBoolean) {
      this.AXX = paramBoolean;
    }
    Object localObject2;
    label224:
    label236:
    int i;
    if (this.AXX)
    {
      this.GNM.clear();
      this.GNN.clear();
      localObject2 = fnl();
      if (localObject2 != null)
      {
        ((bh)localObject2).key = 0;
        this.GNM.add(Integer.valueOf(0));
        this.GNN.put(Integer.valueOf(0), localObject2);
      }
      localObject2 = fnm();
      if (localObject2 != null)
      {
        ((bh)localObject2).key = 1;
        this.GNM.add(Integer.valueOf(1));
        this.GNN.put(Integer.valueOf(1), localObject2);
      }
      localObject2 = fnn();
      if (localObject2 == null)
      {
        localObject2 = null;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = fno();
        if (localObject2 != null) {
          break label371;
        }
        localObject2 = null;
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = this.GNx.get(Long.valueOf(((BaseFinderFeed)localObject1).bZA()));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Integer.valueOf(0);
        }
        i = ((Number)localObject1).intValue();
        localObject2 = ((Iterable)this.GNM).iterator();
      }
    }
    label398:
    for (;;)
    {
      label293:
      if (!((Iterator)localObject2).hasNext()) {
        break label400;
      }
      int j = ((Number)((Iterator)localObject2).next()).intValue();
      localObject1 = (bh)this.GNN.get(Integer.valueOf(j));
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = ((bh)localObject1).S(paramj))
      {
        if (localObject1 == null) {
          break label398;
        }
        ((View)localObject1).setVisibility(8);
        break label293;
        localObject2 = ((u)localObject2).S(paramj);
        break;
        label371:
        localObject2 = ((s)localObject2).S(paramj);
        break label224;
        fnp();
        break label236;
      }
    }
    label400:
    localObject1 = (bh)this.GNN.get(Integer.valueOf(i));
    if (localObject1 == null) {}
    for (paramj = null;; paramj = ((bh)localObject1).S(paramj))
    {
      if (paramj != null) {
        paramj.setVisibility(0);
      }
      AppMethodBeat.o(338267);
      return;
    }
  }
  
  public final void fnq()
  {
    AppMethodBeat.i(338347);
    this.GNE.removeCallbacksAndMessages(null);
    this.GNy = false;
    AppMethodBeat.o(338347);
  }
  
  public final void n(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(338404);
    kotlin.g.b.s.u(paramj, "holder");
    cc localcc = (cc)paramj.CSA;
    if ((localcc instanceof ah))
    {
      K(paramj);
      AppMethodBeat.o(338404);
      return;
    }
    if ((localcc instanceof com.tencent.mm.plugin.finder.model.v)) {
      Q(paramj);
    }
    AppMethodBeat.o(338404);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338295);
    super.onCreate(paramBundle);
    Log.i("Finder.DescPanelUIC", "Carousel Config：buzz_carousel = " + this.GNO + '+' + this.GNP + ", buzz_fav = " + this.GNQ + '+' + this.GNR + ", hot_comment = " + this.GNS + '+' + this.GNT + ", ringtone = " + this.GNU + '+' + this.GNV);
    fnp();
    AppMethodBeat.o(338295);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338316);
    super.onPause();
    this.GNG.dead();
    AppMethodBeat.o(338316);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338306);
    super.onResume();
    this.GNG.alive();
    AppMethodBeat.o(338306);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC$Companion;", "", "()V", "ITEM_DESCRIPTION", "", "ITEM_HOT_COMMENT", "ITEM_RINGTONE", "ITEM_WORDING", "TAG", "", "TIMER_SHOW_NEXT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedDescriptionUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements a<q>
  {
    b(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedHotCommentUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements a<s>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedRingtoneUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements a<u>
  {
    d(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedWordingUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements a<v>
  {
    e(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.l
 * JD-Core Version:    0.7.0.1
 */