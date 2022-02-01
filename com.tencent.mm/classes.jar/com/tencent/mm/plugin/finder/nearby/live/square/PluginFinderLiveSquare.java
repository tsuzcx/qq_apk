package com.tencent.mm.plugin.finder.nearby.live.square;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import com.tencent.c.a.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/PluginFinderLiveSquare;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/plugin/finder/nearby/api/IPluginFinderLiveSquare;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "enterFinderLiveOperationUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveSquare", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getTargetCommentScene", "", "commentScene", "getTargetLiveTabId", "getViewModelStore", "isEnableMoreEntrencePlugin", "", "isFinderLiveSquareCommentScene", "isFinderLiveSquareMoreCommentScene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parseTabCommentScene", "tabId", "plugin-finder-nearby_release"})
public final class PluginFinderLiveSquare
  extends f
  implements ab, d, c
{
  private final aa VK;
  
  public PluginFinderLiveSquare()
  {
    AppMethodBeat.i(203477);
    this.VK = new aa();
    AppMethodBeat.o(203477);
  }
  
  public final void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203457);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.zCs;
    com.tencent.mm.plugin.finder.nearby.a.enterFinderLiveOperationUI(paramContext, paramIntent);
    AppMethodBeat.o(203457);
  }
  
  public final void enterFinderLiveSquare(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(203453);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.zCs;
    com.tencent.mm.plugin.finder.nearby.a.u(paramContext, paramIntent);
    AppMethodBeat.o(203453);
  }
  
  public final void execute(g paramg) {}
  
  public final int getTargetCommentScene(int paramInt)
  {
    AppMethodBeat.i(203470);
    Object localObject = a.zGd;
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    paramInt = com.tencent.mm.plugin.finder.nearby.live.square.page.a.parseTabCommentScene(paramInt, a.getTargetLiveTabId());
    AppMethodBeat.o(203470);
    return paramInt;
  }
  
  public final int getTargetLiveTabId()
  {
    AppMethodBeat.i(203468);
    a locala = a.zGd;
    int i = a.getTargetLiveTabId();
    AppMethodBeat.o(203468);
    return i;
  }
  
  public final aa getViewModelStore()
  {
    return this.VK;
  }
  
  public final boolean isEnableMoreEntrencePlugin(int paramInt)
  {
    AppMethodBeat.i(203467);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    if (!com.tencent.mm.plugin.finder.nearby.live.square.page.a.isFinderLiveSquareCommentScene(paramInt))
    {
      locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      if (!com.tencent.mm.plugin.finder.nearby.live.square.page.a.isFinderLiveSquareMoreCommentScene(paramInt))
      {
        locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
        if (!com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ov(paramInt))
        {
          AppMethodBeat.o(203467);
          return true;
        }
      }
    }
    AppMethodBeat.o(203467);
    return false;
  }
  
  public final boolean isFinderLiveSquareCommentScene(int paramInt)
  {
    AppMethodBeat.i(203460);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    boolean bool = com.tencent.mm.plugin.finder.nearby.live.square.page.a.isFinderLiveSquareCommentScene(paramInt);
    AppMethodBeat.o(203460);
    return bool;
  }
  
  public final boolean isFinderLiveSquareMoreCommentScene(int paramInt)
  {
    AppMethodBeat.i(203461);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    boolean bool = com.tencent.mm.plugin.finder.nearby.live.square.page.a.isFinderLiveSquareMoreCommentScene(paramInt);
    AppMethodBeat.o(203461);
    return bool;
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease() {}
  
  public final int parseTabCommentScene(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203471);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    paramInt1 = com.tencent.mm.plugin.finder.nearby.live.square.page.a.parseTabCommentScene(paramInt1, paramInt2);
    AppMethodBeat.o(203471);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.PluginFinderLiveSquare
 * JD-Core Version:    0.7.0.1
 */