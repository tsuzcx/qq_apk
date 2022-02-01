package com.tencent.mm.plugin.finder.replay.plugin;

import android.content.Context;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.plugin.cg;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.replay.FinderLiveThumbPlayerProxy;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.m<-Ljava.lang.Long;-Lcom.tencent.mm.plugin.finder.replay.widget.c;Lkotlin.r<Lcom.tencent.mm.plugin.finder.replay.widget.c;Ljava.lang.Boolean;>;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "adoptedChildIdList", "", "", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Ljava/util/List;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getAdoptedChildIdList", "()Ljava/util/List;", "currentTimeTv", "Landroid/widget/TextView;", "getCurrentTimeTv", "()Landroid/widget/TextView;", "playerWidget", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "getPlayerWidget", "()Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "setPlayerWidget", "(Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;)V", "screenTouchListener", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin$ScreenTouchListener;", "getScreenTouchListener", "()Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin$ScreenTouchListener;", "screenTouchListener$delegate", "Lkotlin/Lazy;", "seekTimeLayout", "Landroid/view/View;", "totalTimeTv", "getTotalTimeTv", "activate", "", "playerGenerator", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "liveId", "sourcePlayerWidget", "Lkotlin/Pair;", "", "adjustPlayerLayout", "bindMediaInfo", "data", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "fromFloat", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isPlaying", "onSeekTime", "offset", "total", "seeking", "pauseVideo", "playVideo", "(Ljava/lang/Integer;Z)V", "prepareToFirstFrame", "removeChild", "container", "keepContainChildList", "seekTimeLayoutGenerator", "seekVideo", "to", "", "afterSeekPlay", "stopVideo", "Companion", "ScreenTouchListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final a Fmb;
  private final List<Integer> Fmc;
  public com.tencent.mm.plugin.finder.replay.widget.c Fmd;
  private View Fme;
  private final j Fmf;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(332960);
    Fmb = new a((byte)0);
    AppMethodBeat.o(332960);
  }
  
  public d(ViewGroup paramViewGroup, List<Integer> paramList, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(332927);
    this.Fmc = paramList;
    this.nfT = paramb;
    this.Fmf = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(332927);
  }
  
  private static final String RV(int paramInt)
  {
    AppMethodBeat.i(332953);
    if (paramInt >= 3600)
    {
      localObject = com.tencent.mm.live.model.r.mZi;
      localObject = r.a.a(paramInt, ":", true, false, false, 24);
      AppMethodBeat.o(332953);
      return localObject;
    }
    Object localObject = com.tencent.mm.live.model.r.mZi;
    localObject = r.a.a(paramInt, ":", false, false, false, 24);
    AppMethodBeat.o(332953);
    return localObject;
  }
  
  private static final void a(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, d paramd)
  {
    AppMethodBeat.i(332940);
    s.u(paramFinderLiveThumbPlayerProxy, "$it");
    s.u(paramd, "this$0");
    int[] arrayOfInt = new int[2];
    paramFinderLiveThumbPlayerProxy.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramFinderLiveThumbPlayerProxy.getHeight();
    paramFinderLiveThumbPlayerProxy = (cg)paramd.getPlugin(cg.class);
    if (paramFinderLiveThumbPlayerProxy != null) {
      cg.a(paramFinderLiveThumbPlayerProxy, j + i);
    }
    AppMethodBeat.o(332940);
  }
  
  private static final void b(FinderLiveThumbPlayerProxy paramFinderLiveThumbPlayerProxy, d paramd)
  {
    AppMethodBeat.i(332948);
    s.u(paramFinderLiveThumbPlayerProxy, "$it");
    s.u(paramd, "this$0");
    int[] arrayOfInt = new int[2];
    paramFinderLiveThumbPlayerProxy.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramFinderLiveThumbPlayerProxy.getHeight();
    paramFinderLiveThumbPlayerProxy = (cg)paramd.getPlugin(cg.class);
    if (paramFinderLiveThumbPlayerProxy != null) {
      cg.a(paramFinderLiveThumbPlayerProxy, j + i);
    }
    AppMethodBeat.o(332948);
  }
  
  public final void A(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(333033);
    String str1;
    if (!paramBoolean)
    {
      localObject = this.Fme;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        AppMethodBeat.o(333033);
      }
    }
    else
    {
      String str2 = RV(paramInt1);
      str1 = RV(paramInt2);
      localObject = this.Fme;
      if (localObject != null) {
        break label126;
      }
      localObject = null;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)str2);
      }
      localObject = this.Fme;
      if (localObject != null) {
        break label142;
      }
    }
    label142:
    for (Object localObject = null;; localObject = (TextView)((View)localObject).findViewById(p.e.total_time_tv))
    {
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)str1);
      }
      localObject = this.Fme;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(333033);
      return;
      label126:
      localObject = (TextView)((View)localObject).findViewById(p.e.current_time_tv);
      break;
    }
  }
  
  public final void a(Integer paramInteger, boolean paramBoolean)
  {
    AppMethodBeat.i(333005);
    Object localObject = new StringBuilder("replay_step3:playVideo,player:");
    com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
    if (localc != null) {}
    for (int i = localc.hashCode();; i = 0)
    {
      Log.i("FinderLiveReplayerPlugin", i + ",offset:" + paramInteger + ",fromFloat:" + paramBoolean + ", isPlaying:" + isPlaying() + '!');
      if (!paramBoolean) {
        break;
      }
      eLR();
      paramInteger = this.Fmd;
      if (paramInteger == null) {
        break label242;
      }
      paramInteger = paramInteger.Fni;
      if (paramInteger == null) {
        break label242;
      }
      paramInteger.postDelayed(new d..ExternalSyntheticLambda1(paramInteger, this), 100L);
      AppMethodBeat.o(333005);
      return;
    }
    localObject = this.Fmd;
    if (localObject != null)
    {
      Log.i("FinderLiveReplayerWidget", "playVideo " + ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).hashCode() + " playerView:" + ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).Fni.hashCode() + ",offset:" + paramInteger);
      ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).Fni.setLoop(false);
      ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).Fni.setMute(false);
      ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).Fni.setVideoViewFocused(true);
      ((com.tencent.mm.plugin.finder.replay.widget.c)localObject).Fni.r(paramInteger);
    }
    label242:
    AppMethodBeat.o(333005);
  }
  
  public final void dSW()
  {
    AppMethodBeat.i(333026);
    com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
    if (localc != null)
    {
      Log.i("FinderLiveReplayerWidget", "pauseVideo " + localc.hashCode() + " playerView:" + localc.Fni.hashCode());
      localc.Fni.pause();
    }
    AppMethodBeat.o(333026);
  }
  
  public final void eLR()
  {
    AppMethodBeat.i(333000);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).ejX();
    if ((eoH().getMeasuredWidth() > 0) && (eoH().getMeasuredHeight() > 0)) {}
    for (kotlin.r localr = new kotlin.r(Integer.valueOf(eoH().getMeasuredWidth()), Integer.valueOf(eoH().getMeasuredHeight()));; localr = null)
    {
      com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
      if (localc != null)
      {
        Context localContext = this.mJe.getContext();
        s.s(localContext, "root.context");
        localc.a(localContext, getBuContext(), bool, eoH().isLandscape(), (ViewGroup)eoH().getPreviewRoot(), localr);
      }
      AppMethodBeat.o(333000);
      return;
    }
  }
  
  public final void eLS()
  {
    AppMethodBeat.i(333019);
    com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
    if (localc != null) {
      localc.eLS();
    }
    AppMethodBeat.o(333019);
  }
  
  public final b eLT()
  {
    AppMethodBeat.i(333038);
    b localb = (b)this.Fmf.getValue();
    AppMethodBeat.o(333038);
    return localb;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(333028);
    com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
    if (localc == null)
    {
      AppMethodBeat.o(333028);
      return false;
    }
    boolean bool = localc.Fni.isPlaying();
    AppMethodBeat.o(333028);
    return bool;
  }
  
  public final void n(m<? super Long, ? super com.tencent.mm.plugin.finder.replay.widget.c, kotlin.r<com.tencent.mm.plugin.finder.replay.widget.c, Boolean>> paramm)
  {
    AppMethodBeat.i(332994);
    s.u(paramm, "playerGenerator");
    Object localObject1 = (kotlin.r)paramm.invoke(Long.valueOf(((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId), this.Fmd);
    int j = ((com.tencent.mm.plugin.finder.replay.widget.c)((kotlin.r)localObject1).bsC).hashCode();
    paramm = this.Fmd;
    if (paramm != null) {
      i = paramm.hashCode();
    }
    Object localObject2;
    label145:
    label169:
    label178:
    label218:
    Object localObject3;
    label293:
    label498:
    label503:
    int k;
    for (;;)
    {
      if (j != i)
      {
        paramm = this.mJe;
        localObject2 = this.Fmc;
      }
      try
      {
        if (paramm.getChildCount() == 0) {
          Log.i("FinderLiveReplayerPlugin", "remove child empty!");
        }
        for (;;)
        {
          this.Fmd = ((com.tencent.mm.plugin.finder.replay.widget.c)((kotlin.r)localObject1).bsC);
          paramm = new StringBuilder("activate playerWidget:");
          localObject2 = this.Fmd;
          if (localObject2 == null) {
            break label653;
          }
          i = localObject2.hashCode();
          localObject2 = paramm.append(i).append(",player:");
          paramm = this.Fmd;
          if (paramm != null) {
            break label658;
          }
          paramm = null;
          if (paramm == null) {
            break label666;
          }
          i = paramm.hashCode();
          Log.i("FinderLiveReplayerPlugin", i);
          if (!((Boolean)((kotlin.r)localObject1).bsD).booleanValue()) {
            break label745;
          }
          paramm = this.Fmd;
          if (paramm != null) {
            break label671;
          }
          paramm = null;
          localObject1 = paramm;
          if (paramm == null) {
            localObject1 = new Size(0, 0);
          }
          if (((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyC()) || (((Size)localObject1).getWidth() < ((Size)localObject1).getHeight()) || (((Size)localObject1).getHeight() <= 0)) && (!((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).mNQ)) {
            break label738;
          }
          paramm = i.e.XYM;
          localObject2 = this.Fmd;
          if (localObject2 != null)
          {
            localObject3 = this.mJe;
            s.u(localObject3, "newContainer");
            s.u(localObject1, "mediaSize");
            s.u(paramm, "scaleType");
            ((com.tencent.mm.plugin.finder.replay.widget.c)localObject2).a((ViewGroup)localObject3, Integer.valueOf(0), (Size)localObject1, paramm, false);
          }
          eLR();
          paramm = this.Fmd;
          if (paramm != null)
          {
            paramm = paramm.Fni;
            if (paramm != null) {
              paramm.postDelayed(new d..ExternalSyntheticLambda0(paramm, this), 100L);
            }
          }
          label387:
          paramm = this.Fmd;
          if (paramm != null) {
            break label878;
          }
          paramm = null;
          label398:
          this.Fme = paramm;
          if (!isLandscape()) {
            break label1008;
          }
          paramm = this.Fme;
          if (paramm == null) {
            break label1027;
          }
          paramm.setVisibility(8);
          AppMethodBeat.o(332994);
          return;
          i = 0;
          break;
          localObject3 = (Collection)localObject2;
          if (localObject3 == null) {
            break label1039;
          }
          if (!((Collection)localObject3).isEmpty()) {
            break label498;
          }
          break label1039;
          if (i == 0) {
            break label503;
          }
          paramm.removeAllViews();
          Log.i("FinderLiveReplayerPlugin", "remove all child!");
        }
      }
      catch (Exception paramm)
      {
        for (;;)
        {
          localObject2 = aw.Gjk;
          aw.a(paramm, "FinderLiveReplayerPlugin-removeChild");
          continue;
          i = 0;
        }
        localObject3 = new LinkedList();
        k = paramm.getChildCount();
        if (k <= 0) {
          break label565;
        }
      }
    }
    int i = 0;
    label525:
    j = i + 1;
    View localView = paramm.getChildAt(i);
    if (!((List)localObject2).contains(Integer.valueOf(localView.getId()))) {
      ((LinkedList)localObject3).add(localView);
    }
    for (;;)
    {
      label565:
      localObject2 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        paramm.removeView((View)localObject3);
        Log.i("FinderLiveReplayerPlugin", "remove child " + ((View)localObject3).getId() + '(' + ((View)localObject3).hashCode() + ')');
      }
      break;
      label653:
      i = 0;
      break label145;
      label658:
      paramm = paramm.Fni;
      break label169;
      label666:
      i = 0;
      break label178;
      label671:
      paramm = paramm.Fni;
      if (paramm == null)
      {
        paramm = null;
        break label218;
      }
      paramm = paramm.getVideoMediaInfo();
      if (paramm == null)
      {
        paramm = null;
        break label218;
      }
      paramm = paramm.ANK;
      if (paramm == null)
      {
        paramm = null;
        break label218;
      }
      paramm = paramm.eCF();
      if (paramm == null)
      {
        paramm = null;
        break label218;
      }
      paramm = i.a(paramm, true);
      break label218;
      label738:
      paramm = i.e.XYN;
      break label293;
      label745:
      paramm = this.Fmd;
      if (paramm == null) {
        break label387;
      }
      localObject1 = this.mJe;
      s.u(localObject1, "parent");
      Log.i("FinderLiveReplayerWidget", "attachToParentAsFirst " + paramm.hashCode() + " playerView:" + paramm.Fni.hashCode() + ",parent:" + ((ViewGroup)localObject1).hashCode() + ",childCount:" + ((ViewGroup)localObject1).getChildCount());
      s.u(localObject1, "parent");
      if (((ViewGroup)localObject1).indexOfChild((View)paramm.Fni) != -1) {
        break label387;
      }
      ((ViewGroup)localObject1).addView((View)paramm.Fni, 0);
      break label387;
      label878:
      paramm = paramm.Fni;
      if (paramm == null)
      {
        paramm = null;
        break label398;
      }
      localObject2 = (ViewGroup)paramm;
      localObject1 = ((ViewGroup)localObject2).findViewById(p.e.CaH);
      paramm = (m<? super Long, ? super com.tencent.mm.plugin.finder.replay.widget.c, kotlin.r<com.tencent.mm.plugin.finder.replay.widget.c, Boolean>>)localObject1;
      if (localObject1 == null) {
        paramm = null;
      }
      if (paramm == null)
      {
        paramm = LayoutInflater.from(((ViewGroup)localObject2).getContext()).inflate(p.f.Ceb, (ViewGroup)localObject2, false);
        Log.i("FinderLiveReplayerPlugin", s.X("seekTimeLayoutGenerator ", Integer.valueOf(paramm.hashCode())));
        localObject1 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject1).gravity = 17;
        localObject3 = ah.aiuX;
        ((ViewGroup)localObject2).addView(paramm, (ViewGroup.LayoutParams)localObject1);
        s.s(paramm, "run {\n            Layout…)\n            }\n        }");
      }
      for (;;)
      {
        break;
      }
      label1008:
      paramm = this.Fme;
      if (paramm != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        com.tencent.mm.plugin.finder.live.utils.a.gg(paramm);
      }
      label1027:
      AppMethodBeat.o(332994);
      return;
      label1039:
      do
      {
        i = j;
        break label525;
        i = 1;
        break;
      } while (j < k);
    }
  }
  
  public final void stopVideo()
  {
    AppMethodBeat.i(333012);
    com.tencent.mm.plugin.finder.replay.widget.c localc = this.Fmd;
    if (localc != null) {
      localc.stopVideo();
    }
    AppMethodBeat.o(333012);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin$ScreenTouchListener;", "Landroid/view/View$OnTouchListener;", "rReplayerPlugin", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin;", "(Ljava/lang/ref/WeakReference;)V", "downX", "", "downY", "hasStartTrackMove", "", "moveTime", "startTime", "touchSlop", "getTouchSlop", "()I", "touchSlop$delegate", "Lkotlin/Lazy;", "onTouch", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements View.OnTouchListener
  {
    private final WeakReference<d> Fmg;
    private boolean Fmh;
    private final j Fmi;
    private int Fmj;
    private int qjs;
    private int qjt;
    private int startTime;
    
    public b(WeakReference<d> paramWeakReference)
    {
      AppMethodBeat.i(332860);
      this.Fmg = paramWeakReference;
      this.Fmi = k.cm((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(332860);
    }
    
    private final int getTouchSlop()
    {
      AppMethodBeat.i(332872);
      int i = ((Number)this.Fmi.getValue()).intValue();
      AppMethodBeat.o(332872);
      return i;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(332897);
      d locald = (d)this.Fmg.get();
      if (locald == null)
      {
        AppMethodBeat.o(332897);
        return false;
      }
      if (paramMotionEvent == null)
      {
        locald.A(0, 0, false);
        AppMethodBeat.o(332897);
        return false;
      }
      paramView = locald.Fmd;
      if (paramView == null) {}
      int i;
      for (paramView = null;; paramView = paramView.Fni)
      {
        i = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)locald.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).FmQ;
        if ((paramView != null) && (i > 0)) {
          break;
        }
        this.Fmh = false;
        this.startTime = 0;
        this.Fmj = 0;
        locald.A(0, 0, false);
        AppMethodBeat.o(332897);
        return false;
      }
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(332897);
        return false;
        this.qjs = ((int)paramMotionEvent.getX());
        this.qjt = ((int)paramMotionEvent.getY());
        AppMethodBeat.o(332897);
        return true;
        if (paramMotionEvent.getPointerCount() > 1)
        {
          locald.A(0, 0, false);
          AppMethodBeat.o(332897);
          return false;
        }
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        if ((this.Fmh) || ((Math.abs((j - this.qjs) / (k - this.qjt)) > 1.0F) && (Math.abs(j - this.qjs) > getTouchSlop())))
        {
          if (!this.Fmh)
          {
            this.startTime = paramView.getCurrentPlaySecond();
            paramView.pause();
            Log.i("FinderLiveReplayerPlugin", "onFinderLiveTPProxyTouch: start track move, startTime = " + this.startTime + " videoTotalTime=" + i);
          }
          this.Fmh = true;
          float f = (j - this.qjs) / paramView.getWidth();
          j = this.startTime;
          this.Fmj = (kotlin.h.a.eH(f * i) + j);
          paramView = (e)locald.getPlugin(e.class);
          if (paramView != null) {
            paramView.RX(this.Fmj);
          }
          locald.A(this.Fmj, i, true);
          AppMethodBeat.o(332897);
          return true;
          if (this.Fmh)
          {
            Log.i("FinderLiveReplayerPlugin", s.X("onFinderLiveTPProxyTouch: seek end, target time = ", Integer.valueOf(this.Fmj)));
            this.Fmh = false;
            this.startTime = 0;
            locald.A(this.Fmj, i, false);
            paramView.b(this.Fmj, true);
            paramView.bNU();
            this.Fmj = 0;
            AppMethodBeat.o(332897);
            return true;
          }
          if ((Math.abs(paramMotionEvent.getX() - this.qjs) < getTouchSlop()) && (Math.abs(paramMotionEvent.getY() - this.qjt) < getTouchSlop()))
          {
            Log.i("FinderLiveReplayerPlugin", "onFinderLiveTPProxyTouch: performClick");
            paramView.performClick();
            locald.A(this.Fmj, i, false);
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<Integer>
    {
      a(d.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayerPlugin$ScreenTouchListener;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<d.b>
  {
    c(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.plugin.d
 * JD-Core Version:    0.7.0.1
 */