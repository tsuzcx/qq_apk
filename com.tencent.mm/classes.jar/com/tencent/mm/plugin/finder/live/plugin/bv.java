package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.TextView;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.ck;
import com.tencent.mm.plugin.finder.live.report.q.l;
import com.tencent.mm.plugin.finder.live.view.FinderLiveInterceptTouchRelativeLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "autoHideTipTask", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin$autoHideTipTask$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin$autoHideTipTask$1;", "clearView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveInterceptTouchRelativeLayout;", "clickTime", "", "downTime", "touchListeners", "Ljava/util/LinkedList;", "Landroid/view/View$OnTouchListener;", "vrTipGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "canClearScreenWhenSideBarShow", "", "checkVrMode", "", "clearScreeen", "clear", "handleVrEvent", "event", "Landroid/view/MotionEvent;", "hideVrTip", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "registerTouchListener", "touchListener", "screenAction", "(Ljava/lang/Boolean;)V", "screenClickLogic", "setVisible", "visible", "", "showVrTip", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "unRegisterTouchListener", "visibleInCurrentLiveMode", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bv
  extends b
{
  private FinderLiveInterceptTouchRelativeLayout DiI;
  private View DiJ;
  public LinkedList<View.OnTouchListener> DiK;
  private final b DiL;
  private final String TAG;
  private long mWR;
  private final com.tencent.mm.live.b.b nfT;
  private long tQb;
  
  public bv(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354099);
    this.nfT = paramb;
    this.TAG = "Finder.LiveScreenClearPlugin";
    if ((paramViewGroup instanceof FinderLiveInterceptTouchRelativeLayout)) {}
    for (paramb = (FinderLiveInterceptTouchRelativeLayout)paramViewGroup;; paramb = (FinderLiveInterceptTouchRelativeLayout)paramb)
    {
      this.DiI = paramb;
      this.DiJ = paramViewGroup.findViewById(p.e.BSh);
      this.tQb = SystemClock.elapsedRealtime();
      this.mWR = -1L;
      this.DiL = new b(this);
      this.DiI.setOnTouchListener(new bv..ExternalSyntheticLambda1(this));
      this.DiJ.setPadding(this.DiJ.getPaddingLeft(), this.DiJ.getPaddingTop(), this.DiJ.getPaddingRight(), bd.fromDPToPix(paramViewGroup.getContext(), 32) + bf.bk(paramViewGroup.getContext()));
      aw.a((Paint)((TextView)paramViewGroup.findViewById(p.e.BTX)).getPaint(), 0.8F);
      aw.a((Paint)((TextView)paramViewGroup.findViewById(p.e.BTW)).getPaint(), 0.8F);
      paramViewGroup.setImportantForAccessibility(4);
      paramViewGroup.setContentDescription((CharSequence)paramViewGroup.getContext().getString(p.h.finder_live_screen_clear_recovery_desc));
      AppMethodBeat.o(354099);
      return;
      paramb = paramViewGroup.findViewById(p.e.BSg);
      s.s(paramb, "root.findViewById(R.id.f…ive_screen_clear_ui_root)");
    }
  }
  
  private static final void a(bv parambv)
  {
    AppMethodBeat.i(354162);
    s.u(parambv, "this$0");
    parambv.DiJ.setTranslationY(bf.bf(parambv.mJe.getContext()).y / 2.0F);
    parambv.DiJ.setAlpha(0.0F);
    parambv.DiJ.setVisibility(0);
    parambv.DiJ.postDelayed((Runnable)parambv.DiL, 8000L);
    AppMethodBeat.o(354162);
  }
  
  private static final void a(bv parambv, View paramView)
  {
    AppMethodBeat.i(354186);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambv);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambv, "this$0");
    parambv.u(null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354186);
  }
  
  private static final boolean a(bv parambv, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(354151);
    s.u(parambv, "this$0");
    Object localObject;
    label25:
    label30:
    label54:
    label85:
    int i;
    if (paramMotionEvent == null)
    {
      localObject = null;
      if (localObject != null) {
        break label333;
      }
      if (localObject != null) {
        break label351;
      }
      if (paramMotionEvent != null)
      {
        localObject = (cc)parambv.getPlugin(cc.class);
        if (localObject != null) {
          break label400;
        }
        localObject = null;
        if (((e)parambv.business(e.class)).EcH)
        {
          if (!(localObject instanceof com.tencent.mm.live.core.core.d.a.b)) {
            break label410;
          }
          localObject = (com.tencent.mm.live.core.core.d.a.b)localObject;
          if ((localObject != null) && (((com.tencent.mm.live.core.core.d.a.b)localObject).mPA != null))
          {
            localObject = ((com.tencent.mm.live.core.core.d.a.b)localObject).mPA.mPT.mPK;
            if (((com.tencent.mm.live.core.core.d.a.a)localObject).mPz != null)
            {
              localObject = ((com.tencent.mm.live.core.core.d.a.a)localObject).mPz;
              if (((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQH)
              {
                i = paramMotionEvent.getAction() & 0xFF;
                if ((i != 1) && (i != 3)) {
                  break label416;
                }
                ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = -1.0F;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQj;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl", "handleGesturesOperation", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl", "handleGesturesOperation", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (paramMotionEvent.getActionMasked() == 1) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.axw(String.valueOf(q.ck.DFO.action));
      }
      parambv = parambv.DiK;
      if (parambv == null) {
        break label783;
      }
      parambv = ((Iterable)parambv).iterator();
      while (parambv.hasNext()) {
        ((View.OnTouchListener)parambv.next()).onTouch(paramView, paramMotionEvent);
      }
      localObject = Integer.valueOf(paramMotionEvent.getAction());
      break;
      label333:
      if (((Integer)localObject).intValue() != 0) {
        break label25;
      }
      parambv.mWR = SystemClock.elapsedRealtime();
      break label30;
      label351:
      if (((Integer)localObject).intValue() != 1) {
        break label30;
      }
      if ((parambv.mWR > 0L) && (SystemClock.elapsedRealtime() - parambv.mWR <= ViewConfiguration.getTapTimeout())) {
        parambv.u(null);
      }
      parambv.mWR = -1L;
      break label30;
      label400:
      localObject = ((cc)localObject).mJG;
      break label54;
      label410:
      localObject = null;
      break label85;
      label416:
      if (i == 5)
      {
        ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = com.tencent.mm.live.core.core.d.a.a.a.p(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1));
      }
      else if (i == 6)
      {
        if (paramMotionEvent.getPointerCount() > 2)
        {
          if (paramMotionEvent.getAction() >> 8 == 0) {
            ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = com.tencent.mm.live.core.core.d.a.a.a.p(paramMotionEvent.getX(1), paramMotionEvent.getY(1), paramMotionEvent.getX(2), paramMotionEvent.getY(2));
          } else if (paramMotionEvent.getAction() >> 8 == 1) {
            ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = com.tencent.mm.live.core.core.d.a.a.a.p(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(2), paramMotionEvent.getY(2));
          }
        }
        else {
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = -1.0F;
        }
      }
      else if ((i == 2) && (paramMotionEvent.getPointerCount() >= 2))
      {
        float f = com.tencent.mm.live.core.core.d.a.a.a.p(paramMotionEvent.getX(0), paramMotionEvent.getY(0), paramMotionEvent.getX(1), paramMotionEvent.getY(1));
        if (f != 0.0F)
        {
          if (((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ == -1.0F) {
            ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = f;
          }
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = ((((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ / f - 1.0F) * ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQK + ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.min(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQF);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.max(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQG);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.min(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, 65.0F / ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQm);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.min(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, 65.0F / ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQl);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.max(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, 20.0F / ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQm);
          ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI = Math.max(((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQI, 20.0F / ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQl);
        }
        ((com.tencent.mm.live.core.core.d.a.a.a)localObject).mQJ = f;
      }
    }
    label783:
    AppMethodBeat.o(354151);
    return true;
  }
  
  private static final void b(bv parambv)
  {
    AppMethodBeat.i(354168);
    s.u(parambv, "this$0");
    Object localObject = (cv)parambv.getPlugin(cv.class);
    if (localObject != null) {
      ((cv)localObject).esW();
    }
    localObject = (cc)parambv.getPlugin(cc.class);
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.live.core.core.d.a.b)) {
        break label93;
      }
    }
    label93:
    for (localObject = (com.tencent.mm.live.core.core.d.a.b)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.d.a.b)localObject).fG(true);
      }
      parambv.DiI.setInterceptTouch(true);
      AppMethodBeat.o(354168);
      return;
      localObject = ((cc)localObject).mJG;
      break;
    }
  }
  
  private static final void c(bv parambv)
  {
    AppMethodBeat.i(354175);
    s.u(parambv, "this$0");
    parambv.DiJ.setVisibility(8);
    Object localObject = (cc)parambv.getPlugin(cc.class);
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.live.core.core.d.a.b)) {
        break label83;
      }
    }
    label83:
    for (localObject = (com.tencent.mm.live.core.core.d.a.b)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.d.a.b)localObject).fG(false);
      }
      parambv.DiI.setInterceptTouch(false);
      AppMethodBeat.o(354175);
      return;
      localObject = ((cc)localObject).mJG;
      break;
    }
  }
  
  private final void erJ()
  {
    AppMethodBeat.i(354109);
    if (((e)business(e.class)).eyM())
    {
      if (((e)business(e.class)).EcH)
      {
        com.tencent.mm.plugin.finder.live.report.k.Doi.axw(String.valueOf(q.ck.DFN.action));
        this.DiJ.animate().alpha(1.0F).translationY(0.0F).withStartAction(new bv..ExternalSyntheticLambda2(this)).withEndAction(new bv..ExternalSyntheticLambda4(this)).start();
        AppMethodBeat.o(354109);
        return;
      }
      this.DiJ.removeCallbacks((Runnable)this.DiL);
      this.DiJ.animate().alpha(0.0F).translationY(bf.bf(this.mJe.getContext()).y / 2.0F).withEndAction(new bv..ExternalSyntheticLambda3(this)).start();
    }
    AppMethodBeat.o(354109);
  }
  
  private final void u(Boolean paramBoolean)
  {
    AppMethodBeat.i(354115);
    Log.i(this.TAG, "screenClickLogic");
    if (SystemClock.elapsedRealtime() - this.tQb < ViewConfiguration.getDoubleTapTimeout())
    {
      AppMethodBeat.o(354115);
      return;
    }
    this.tQb = SystemClock.elapsedRealtime();
    v(paramBoolean);
    erJ();
    AppMethodBeat.o(354115);
  }
  
  private final void v(Boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(354130);
    Object localObject = FinderLiveViewCallback.BwC;
    if (FinderLiveViewCallback.ehe() != 0)
    {
      paramBoolean = this.TAG;
      localObject = new StringBuilder("[screenAction] inNewGuideStatus:");
      FinderLiveViewCallback.a locala = FinderLiveViewCallback.BwC;
      Log.i(paramBoolean, FinderLiveViewCallback.ehe() + " return");
      AppMethodBeat.o(354130);
      return;
    }
    localObject = (n.a)((n)business(n.class)).Ehi.getValue();
    if (localObject != null)
    {
      if (((n.a)localObject).Ehp == -1.0F)
      {
        i = 1;
        if (i != 0) {
          break label175;
        }
        if (((n.a)localObject).Eho != -1.0F) {
          break label170;
        }
      }
      label170:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) || (s.p(((n.a)localObject).Ehq, ""))) {
          break label175;
        }
        ((n)business(n.class)).ezj();
        AppMethodBeat.o(354130);
        return;
        i = 0;
        break;
      }
    }
    label175:
    localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = this.DiI.getContext();
    s.s(localObject, "clearView.context");
    localObject = com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.sidebar.d.class);
    s.s(localObject, "UICProvider.of(clearView…veSideBarUIC::class.java)");
    localObject = (com.tencent.mm.plugin.finder.live.sidebar.d)localObject;
    if (((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGD)
    {
      paramBoolean = this.TAG;
      if (((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGE == null) {}
      for (bool = true;; bool = false)
      {
        Log.i(paramBoolean, s.X("inSideBarStatus, is NUll? ", Boolean.valueOf(bool)));
        ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGH.DGN = 3;
        paramBoolean = ((com.tencent.mm.plugin.finder.live.sidebar.d)localObject).DGE;
        if (paramBoolean != null) {
          paramBoolean.hide();
        }
        AppMethodBeat.o(354130);
        return;
      }
    }
    localObject = (e)business(e.class);
    if (paramBoolean == null) {
      if (!((e)business(e.class)).EcH)
      {
        ((e)localObject).EcH = bool;
        Log.i(this.TAG, s.X("screenAction business(LiveCommonSlice::class.java).screenClear:", Boolean.valueOf(((e)business(e.class)).EcH)));
        paramBoolean = new Bundle();
        paramBoolean.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((e)business(e.class)).EcH);
        this.nfT.statusChange(b.c.ndZ, paramBoolean);
        if (this.nfT.getLiveRole() == 0) {
          if (!((e)business(e.class)).EcH) {
            break label519;
          }
        }
      }
    }
    label519:
    for (paramBoolean = q.l.Dtf;; paramBoolean = q.l.Dtg)
    {
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(paramBoolean);
      if ((!((e)business(e.class)).EcH) || (!isLandscape()) || (Build.VERSION.SDK_INT < 21)) {
        break label542;
      }
      paramBoolean = this.mJe.getContext();
      if (paramBoolean != null) {
        break label526;
      }
      paramBoolean = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(354130);
      throw paramBoolean;
      bool = false;
      break;
      bool = paramBoolean.booleanValue();
      break;
    }
    label526:
    ((Activity)paramBoolean).getWindow().getDecorView().setSystemUiVisibility(3846);
    label542:
    AppMethodBeat.o(354130);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(354239);
    s.u(paramLinkedHashMap, "micUserMap");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramLinkedHashMap = paramLinkedHashMap.keySet();
      s.s(paramLinkedHashMap, "micUserMap.keys");
      paramBoolean = p.a((Iterable)paramLinkedHashMap, ((e)business(e.class)).eyF());
      Log.i(this.TAG, s.X("onMicUserChanged: contains self: ", Boolean.valueOf(paramBoolean)));
      this.DiI.setInterceptTouch(paramBoolean);
    }
    AppMethodBeat.o(354239);
  }
  
  public final boolean enH()
  {
    return false;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void erI()
  {
    AppMethodBeat.i(354226);
    u(Boolean.TRUE);
    AppMethodBeat.o(354226);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(354232);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    if (a.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (paramBundle == null) {}
      while (bool)
      {
        this.mJe.setImportantForAccessibility(1);
        this.mJe.setOnClickListener(new bv..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(354232);
        return;
        bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", false);
      }
      this.mJe.setImportantForAccessibility(4);
      this.mJe.setOnClickListener(null);
    }
    AppMethodBeat.o(354232);
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354247);
    String str = this.TAG;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, s.X("visibility:", Boolean.valueOf(bool)));
      super.tO(paramInt);
      AppMethodBeat.o(354247);
      return;
    }
  }
  
  public final void unMount()
  {
    this.DiK = null;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin$autoHideTipTask$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(bv parambv) {}
    
    private static final void e(bv parambv)
    {
      AppMethodBeat.i(356016);
      s.u(parambv, "this$0");
      bv.d(parambv).setVisibility(8);
      AppMethodBeat.o(356016);
    }
    
    public final void run()
    {
      AppMethodBeat.i(356024);
      if (bv.d(this.DiM).getVisibility() == 0) {
        bv.d(this.DiM).animate().alpha(0.0F).withEndAction(new bv.b..ExternalSyntheticLambda0(this.DiM)).start();
      }
      AppMethodBeat.o(356024);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bv
 * JD-Core Version:    0.7.0.1
 */