package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.f;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.s.ag;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "moreLiveEntrance", "Landroid/view/View;", "getReportObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "canClearScreen", "", "checkMoreLiveEntranceVisible", "", "plugin-finder_release"})
public final class av
  extends d
{
  final String TAG;
  private final com.tencent.mm.live.c.b hOy;
  final bbn reportObj;
  View utl;
  
  public av(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, bbn parambbn)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246938);
    this.hOy = paramb;
    this.reportObj = parambbn;
    this.TAG = "FinderLiveMoreLiveEntrancePlugin";
    this.utl = paramViewGroup.findViewById(2131301205);
    AppMethodBeat.o(246938);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dhJ()
  {
    AppMethodBeat.i(246937);
    Object localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
    if (com.tencent.mm.plugin.finder.utils.m.dBP())
    {
      rg(8);
      AppMethodBeat.o(246937);
      return;
    }
    localObject1 = o.ujN;
    localObject1 = o.dfY();
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.d)localObject1).ufx;
      if (localObject1 == null) {}
    }
    for (localObject1 = Integer.valueOf(((f)localObject1).tCE);; localObject1 = null)
    {
      Log.i(this.TAG, "checkMoreLiveEntranceState commentScene:".concat(String.valueOf(localObject1)));
      if ((localObject1 != null) && (((Integer)localObject1).intValue() != 94) && (((Integer)localObject1).intValue() != 80)) {
        break label126;
      }
      localObject1 = this.utl;
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(246937);
      return;
    }
    AppMethodBeat.o(246937);
    return;
    label126:
    rg(0);
    Object localObject2 = com.tencent.mm.plugin.finder.report.live.m.vli;
    com.tencent.mm.plugin.finder.report.live.m.a(s.ag.vqr);
    localObject2 = this.utl;
    if (localObject2 != null) {
      ((View)localObject2).post((Runnable)new a(this));
    }
    localObject2 = this.utl;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this, (Integer)localObject1));
    }
    if (isLandscape())
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.m.vVH;
      localObject1 = this.hwr.getContext();
      p.g(localObject1, "root.context");
      localObject2 = com.tencent.mm.plugin.finder.utils.m.vVH;
      int i = com.tencent.mm.plugin.finder.utils.m.B((Context)localObject1, com.tencent.mm.plugin.finder.utils.m.i(getLiveData()));
      localObject1 = this.utl;
      if (localObject1 != null) {}
      for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246937);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup.MarginLayoutParams)localObject1).setMarginEnd(i);
    }
    AppMethodBeat.o(246937);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(av paramav) {}
    
    public final void run()
    {
      AppMethodBeat.i(246935);
      Rect localRect = new Rect();
      Object localObject = this.utm.utl;
      if (localObject != null) {
        ((View)localObject).getHitRect(localRect);
      }
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      int i = ((Context)localObject).getResources().getDimensionPixelOffset(2131165314);
      localRect.inset(-i, -i);
      localObject = this.utm.utl;
      if (localObject != null) {}
      for (localObject = ((View)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(246935);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, this.utm.utl));
      AppMethodBeat.o(246935);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(av paramav, Integer paramInteger) {}
    
    public final void onClick(View paramView)
    {
      Intent localIntent = null;
      AppMethodBeat.i(246936);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.utm.getLiveData().uDz;
      String str;
      StringBuilder localStringBuilder;
      if (paramView != null)
      {
        paramView = paramView.liveInfo;
        if (paramView != null)
        {
          paramView = paramView.LGV;
          str = this.utm.TAG;
          localStringBuilder = new StringBuilder("moreLiveEntrance click,source tabType:").append(this.utn).append(",tabId:");
          if (paramView == null) {
            break label252;
          }
        }
      }
      label252:
      for (localObject = Integer.valueOf(paramView.LHQ);; localObject = null)
      {
        localStringBuilder = localStringBuilder.append(localObject).append(",tabName:");
        localObject = localIntent;
        if (paramView != null) {
          localObject = paramView.LHR;
        }
        Log.i(str, (String)localObject);
        localObject = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.ag.vqs);
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject = this.utm.hwr.getContext();
        p.g(localObject, "root.context");
        localIntent = new Intent();
        if (paramView != null) {
          localIntent.putExtra("nearby_live_go_to_square_pge_params_key", paramView.toByteArray());
        }
        paramView = this.utm.reportObj;
        if (paramView != null) {
          localIntent.putExtra("key_context_id", paramView.sGQ);
        }
        com.tencent.mm.plugin.finder.utils.a.Z((Context)localObject, localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreLiveEntrancePlugin$checkMoreLiveEntranceVisible$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246936);
        return;
        paramView = null;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.av
 * JD-Core Version:    0.7.0.1
 */