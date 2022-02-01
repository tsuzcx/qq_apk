package com.tencent.mm.plugin.finder.replay.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.replay.FinderLiveReplayPluginLayout;
import com.tencent.mm.plugin.finder.replay.viewmodel.c;
import com.tencent.mm.plugin.finder.replay.widget.f.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMiniViewPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canClearScreen", "", "miniWindow", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public b(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(332923);
    this.nfT = paramb;
    this.TAG = "FinderLiveReplayMiniView";
    paramViewGroup.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.plugin.b)this);
    AppMethodBeat.o(332923);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(332954);
    ((c)paramb.getBuContext().business(c.class)).tx(true);
    paramb = paramb.eoH();
    if ((paramb instanceof FinderLiveReplayPluginLayout)) {}
    for (paramb = (FinderLiveReplayPluginLayout)paramb;; paramb = null)
    {
      if (paramb != null)
      {
        paramb = paramb.getUiClickListener();
        if (paramb != null) {
          paramb.eLH();
        }
      }
      AppMethodBeat.o(332954);
      return;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(332941);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMiniViewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    if (!com.tencent.mm.compatible.e.b.dh(MMApplicationContext.getContext()))
    {
      Log.i(paramb.TAG, "miniWindow, permission denied");
      RequestFloatWindowPermissionDialog.a(paramb.mJe.getContext(), paramb.mJe.getContext().getString(p.h.Csf), (RequestFloatWindowPermissionDialog.a)new a(paramb), false, com.tencent.mm.bq.a.aQB());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMiniViewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(332941);
      return;
      a(paramb);
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMiniViewPlugin$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements RequestFloatWindowPermissionDialog.a
  {
    a(b paramb) {}
    
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(332885);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.i(this.FlY.TAG, "miniWindow, onResultAllow");
      paramRequestFloatWindowPermissionDialog.finish();
      b.b(this.FlY);
      AppMethodBeat.o(332885);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(332894);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.e(this.FlY.TAG, "miniWindow, onResultRefuse");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(332894);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(332899);
      s.u(paramRequestFloatWindowPermissionDialog, "dialog");
      Log.e(this.FlY.TAG, "miniWindow, onResultCancel");
      paramRequestFloatWindowPermissionDialog.finish();
      AppMethodBeat.o(332899);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.plugin.b
 * JD-Core Version:    0.7.0.1
 */