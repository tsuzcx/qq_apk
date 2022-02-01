package com.tencent.mm.plugin.finder.nearby.live.square;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.d.a.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.finder.nearby.live.square.page.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/PluginFinderLiveSquare;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/plugin/finder/nearby/api/IPluginFinderLiveSquare;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "enterFinderLiveEntrance", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterFinderLiveOperationUI", "enterFinderLiveSquare", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getTargetCommentScene", "", "commentScene", "tabId", "getTargetLiveTabId", "getViewModelStore", "isEnableMoreEntrencePlugin", "", "isFinderLiveSquareCommentScene", "isFinderLiveSquareMoreCommentScene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parseTabCommentScene", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderLiveSquare
  extends f
  implements ak, d, c
{
  private final aj er;
  
  public PluginFinderLiveSquare()
  {
    AppMethodBeat.i(341090);
    this.er = new aj();
    AppMethodBeat.o(341090);
  }
  
  public final void enterFinderLiveEntrance(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(341102);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.EFh;
    com.tencent.mm.plugin.finder.nearby.a.P(paramContext, paramIntent);
    AppMethodBeat.o(341102);
  }
  
  public final void enterFinderLiveOperationUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(341108);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.EFh;
    com.tencent.mm.plugin.finder.nearby.a.enterFinderLiveOperationUI(paramContext, paramIntent);
    AppMethodBeat.o(341108);
  }
  
  public final void enterFinderLiveSquare(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(341097);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.finder.nearby.a locala = com.tencent.mm.plugin.finder.nearby.a.EFh;
    com.tencent.mm.plugin.finder.nearby.a.O(paramContext, paramIntent);
    AppMethodBeat.o(341097);
  }
  
  public final void execute(g paramg) {}
  
  public final int getTargetCommentScene(int paramInt)
  {
    AppMethodBeat.i(341138);
    paramInt = getTargetCommentScene(paramInt, 0);
    AppMethodBeat.o(341138);
    return paramInt;
  }
  
  public final int getTargetCommentScene(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(341144);
    Object localObject = a.ELB;
    localObject = b.ELW;
    paramInt1 = b.parseTabCommentScene(paramInt1, a.hW(paramInt1, paramInt2));
    AppMethodBeat.o(341144);
    return paramInt1;
  }
  
  public final int getTargetLiveTabId()
  {
    AppMethodBeat.i(341133);
    a locala = a.ELB;
    int i = a.eFA();
    AppMethodBeat.o(341133);
    return i;
  }
  
  public final aj getViewModelStore()
  {
    return this.er;
  }
  
  public final boolean isEnableMoreEntrencePlugin(int paramInt)
  {
    AppMethodBeat.i(341130);
    b localb = b.ELW;
    if (!b.isFinderLiveSquareCommentScene(paramInt))
    {
      localb = b.ELW;
      if (!b.isFinderLiveSquareMoreCommentScene(paramInt))
      {
        localb = b.ELW;
        if (!b.QN(paramInt))
        {
          AppMethodBeat.o(341130);
          return true;
        }
      }
    }
    AppMethodBeat.o(341130);
    return false;
  }
  
  public final boolean isFinderLiveSquareCommentScene(int paramInt)
  {
    AppMethodBeat.i(341117);
    b localb = b.ELW;
    boolean bool = b.isFinderLiveSquareCommentScene(paramInt);
    AppMethodBeat.o(341117);
    return bool;
  }
  
  public final boolean isFinderLiveSquareMoreCommentScene(int paramInt)
  {
    AppMethodBeat.i(341121);
    b localb = b.ELW;
    boolean bool = b.isFinderLiveSquareMoreCommentScene(paramInt);
    AppMethodBeat.o(341121);
    return bool;
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease() {}
  
  public final int parseTabCommentScene(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(341150);
    b localb = b.ELW;
    paramInt1 = b.parseTabCommentScene(paramInt1, paramInt2);
    AppMethodBeat.o(341150);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.PluginFinderLiveSquare
 * JD-Core Version:    0.7.0.1
 */