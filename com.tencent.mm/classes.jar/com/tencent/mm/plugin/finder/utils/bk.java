package com.tencent.mm.plugin.finder.utils;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.x;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import org.libpag.PAGFile;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/OlympicsLiveRoomUtil;", "", "()V", "TAG", "", "animateView", "", "tag", "fromRect", "Landroid/graphics/Rect;", "toRect", "view", "Landroid/view/View;", "listener", "Landroid/animation/Animator$AnimatorListener;", "getRoomBgStarPag", "Lkotlin/Pair;", "Lorg/libpag/PAGFile;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getTorchPag", "context", "Landroid/content/Context;", "processAudienceEventInfo", "event_info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceEventInfo;", "setEventInfo", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveEventInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk
{
  public static final bk GlT;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333269);
    GlT = new bk();
    TAG = "Finder.OlympicsLiveRoomUtil";
    AppMethodBeat.o(333269);
  }
  
  public static r<PAGFile, String> A(a parama)
  {
    AppMethodBeat.i(333229);
    s.u(parama, "buContext");
    parama = (n.e)((n)parama.business(n.class)).Ehd.getValue();
    int i;
    label59:
    String str2;
    String str1;
    if ((parama != null) && (parama.EhJ == true))
    {
      i = 1;
      if (i == 0) {
        break label113;
      }
      parama = bl.GlV;
      parama = bl.b(b.j.ahpa);
      str2 = (String)parama.bsC;
      str1 = (String)parama.bsD;
      if (!y.ZC(str2)) {
        break label127;
      }
    }
    for (parama = PAGFile.Load(y.n(str2, false));; parama = null)
    {
      parama = new r(parama, str1);
      AppMethodBeat.o(333229);
      return parama;
      i = 0;
      break;
      label113:
      parama = bl.GlV;
      parama = bl.b(b.j.ahoZ);
      break label59;
      label127:
      Log.i(TAG, s.X("getRoomBgStarPag not exist, ", str2));
      str1 = "";
    }
  }
  
  public static r<PAGFile, String> a(Context paramContext, a parama, String paramString)
  {
    AppMethodBeat.i(333243);
    s.u(paramContext, "context");
    s.u(parama, "buContext");
    s.u(paramString, "tag");
    PAGFile localPAGFile = PAGFile.Load(paramContext.getAssets(), "star-countdown-12-animation.pag");
    n.e locale = (n.e)((n)parama.business(n.class)).Ehd.getValue();
    if ((locale != null) && (locale.EhJ == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = PAGFile.Load(paramContext.getAssets(), "star-countdown-0-animation.pag");
      parama = bl.GlV;
      parama = bl.b(b.j.ahoW);
      paramString = (String)parama.bsC;
      parama = (String)parama.bsD;
      if (!y.ZC(paramString)) {
        break label309;
      }
      paramContext = PAGFile.Load(y.n(paramString, false));
      label127:
      paramContext = new r(paramContext, parama);
      AppMethodBeat.o(333243);
      return paramContext;
    }
    i = ((n)parama.business(n.class)).Ehc;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED))
    {
      paramContext = d.FAy;
      if (((Number)d.eSK().bmg()).intValue() != 0)
      {
        paramContext = d.FAy;
        i = ((Number)d.eSK().bmg()).intValue();
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        Log.i(TAG, paramString + ", getTorchPag null, because remainDays:" + i);
        paramContext = new r(null, "");
        AppMethodBeat.o(333243);
        return paramContext;
      }
      int j;
      if (i == 0) {
        j = 1;
      }
      for (;;)
      {
        paramContext = bl.GlV;
        parama = bl.c(b.j.ahoV, j);
        paramContext = localPAGFile;
        break;
        j = i;
        if (i > 12) {
          j = 12;
        }
      }
      label309:
      parama = "{\"x\":0,\"y\":0.169,\"w\":1,\"h\":0.462,\"r\":0.5}";
      break label127;
    }
  }
  
  public static void a(e parame, String paramString, bgr parambgr)
  {
    AppMethodBeat.i(333216);
    s.u(parame, "<this>");
    s.u(paramString, "tag");
    s.u(parambgr, "event_info");
    parame.mIY = parambgr.mIY;
    parame.mJa = parambgr.mJa;
    parame.mIZ = parambgr.mIZ;
    parame.PY(parambgr.mJb);
    parame.EcB.clear();
    parame = parame.EcB;
    LinkedList localLinkedList = parambgr.ZQf;
    s.s(localLinkedList, "event_info.related_events");
    parame.addAll((Collection)localLinkedList);
    parame = TAG;
    paramString = new StringBuilder("setEventInfo ").append(paramString).append(", id:").append(parambgr.mIY).append(", event_status:").append(parambgr.mJa).append(", participant_identity:").append(parambgr.mIZ).append(", stream_status:").append(parambgr.mJb).append("related_events:");
    parambgr = parambgr.ZQf;
    s.s(parambgr, "event_info.related_events");
    Log.i(parame, p.a((Iterable)parambgr, null, null, null, 0, null, (kotlin.g.a.b)a.GlU, 31));
    AppMethodBeat.o(333216);
  }
  
  public static void a(String paramString, Rect paramRect1, Rect paramRect2, View paramView, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(333260);
    s.u(paramString, "tag");
    s.u(paramRect1, "fromRect");
    s.u(paramRect2, "toRect");
    s.u(paramView, "view");
    float f1 = paramRect2.width() / paramRect1.width();
    float f2 = paramRect2.height() / paramRect1.height();
    float f7 = paramRect1.left;
    float f8 = paramRect1.width() / 2.0F;
    float f3 = paramRect1.top;
    float f4 = paramRect1.height() / 2.0F;
    float f9 = paramRect2.left;
    float f10 = paramRect2.width() / 2.0F;
    float f5 = paramRect2.top;
    float f6 = paramRect2.height() / 2.0F;
    f7 = f9 + f10 - (f7 + f8);
    f3 = f5 + f6 - (f3 + f4);
    Log.i(TAG, paramString + " animateView fromRect:" + paramRect1 + ", toRect:" + paramRect2 + ", scaleX:" + f1 + ", scaleY:" + f2 + ", translateX:" + f7 + ", translateY:" + f3);
    paramView.animate().cancel();
    paramView.animate().setDuration(250L).translationX(f7).translationY(f3).scaleX(f1).scaleY(f2).setListener(paramAnimatorListener).start();
    AppMethodBeat.o(333260);
  }
  
  public static void a(String paramString, a parama, bfg parambfg)
  {
    AppMethodBeat.i(333204);
    s.u(paramString, "tag");
    s.u(parama, "buContext");
    s.u(parambfg, "event_info");
    e locale = (e)parama.business(e.class);
    String str = parambfg.ZPm;
    parama = str;
    if (str == null) {
      parama = "";
    }
    s.u(parama, "<set-?>");
    locale.token = parama;
    Log.i(TAG, "processAudienceEventInfo " + paramString + ", token:" + parambfg.ZPm);
    AppMethodBeat.o(333204);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/RelatedEventInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<epb, CharSequence>
  {
    public static final a GlU;
    
    static
    {
      AppMethodBeat.i(333929);
      GlU = new a();
      AppMethodBeat.o(333929);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bk
 * JD-Core Version:    0.7.0.1
 */