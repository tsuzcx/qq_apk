package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.a;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/IFinderLivePlugin;", "vg", "Landroid/view/ViewGroup;", "liveStatus", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "CLEAR_RECOVERY_SCREEN_DURATION", "", "getCLEAR_RECOVERY_SCREEN_DURATION", "()J", "cacheVisibility", "", "getCacheVisibility", "()I", "setCacheVisibility", "(I)V", "clearStatus", "getClearStatus", "setClearStatus", "finderLiveAssistant", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "getFinderLiveAssistant", "()Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveAssistant;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveStatus", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "onNetworkChange", "com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1;", "screenClearAnim", "Landroid/animation/ObjectAnimator;", "getScreenClearAnim", "()Landroid/animation/ObjectAnimator;", "setScreenClearAnim", "(Landroid/animation/ObjectAnimator;)V", "screenRecoveryAnim", "getScreenRecoveryAnim", "setScreenRecoveryAnim", "getVg", "()Landroid/view/ViewGroup;", "canClearScreen", "", "clearScreen", "", "getPluginSize", "Lkotlin/Pair;", "isFinished", "mount", "name", "", "networkChange", "status", "onLandscapeAction", "extraMsg", "Landroid/os/Bundle;", "onLandscapeDelayAction", "delayMs", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitAction", "onPortraitDelayAction", "postLandscapeAction", "action", "key", "data", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;)V", "postPortraitAction", "postPortraitActionDelay", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;I)V", "recoveryScreen", "reset", "setVisible", "visible", "unMount", "plugin-finder_release"})
public class d
  extends a
{
  public int ulV;
  public int ulW;
  public ObjectAnimator ulX;
  public ObjectAnimator ulY;
  public final long ulZ;
  private final b uma;
  public final ViewGroup umb;
  final com.tencent.mm.live.c.b umc;
  
  public d(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246397);
    this.umb = paramViewGroup;
    this.umc = paramb;
    this.ulV = this.hwr.getVisibility();
    this.ulW = 65535;
    this.ulZ = 300L;
    this.uma = new b(this);
    AppMethodBeat.o(246397);
  }
  
  public void a(Bundle paramBundle, long paramLong) {}
  
  public void ai(Bundle paramBundle) {}
  
  public boolean dgK()
  {
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.live.viewmodel.g getLiveData()
  {
    AppMethodBeat.i(246389);
    Object localObject = this.umc;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout");
      AppMethodBeat.o(246389);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderBaseLivePluginLayout)localObject).getLiveData();
    AppMethodBeat.o(246389);
    return localObject;
  }
  
  public final boolean isFinished()
  {
    AppMethodBeat.i(246395);
    Context localContext = this.umb.getContext();
    if ((localContext != null) && ((localContext instanceof Activity)))
    {
      boolean bool1 = ((Activity)localContext).isFinishing();
      boolean bool2 = ((Activity)localContext).isDestroyed();
      AppMethodBeat.o(246395);
      return bool1 | bool2;
    }
    AppMethodBeat.o(246395);
    return false;
  }
  
  public void mount()
  {
    AppMethodBeat.i(246390);
    super.mount();
    com.tencent.mm.kernel.g.aAg().a((p)this.uma);
    AppMethodBeat.o(246390);
  }
  
  public String name()
  {
    AppMethodBeat.i(246392);
    String str = getClass().getSimpleName() + '@' + hashCode();
    AppMethodBeat.o(246392);
    return str;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void reset() {}
  
  public void rg(int paramInt)
  {
    AppMethodBeat.i(246396);
    this.ulV = paramInt;
    int i = paramInt;
    if (dgK())
    {
      i = paramInt;
      if (this.ulW == 8) {
        i = 8;
      }
    }
    super.rg(i);
    if (i == 0) {
      this.hwr.setAlpha(1.0F);
    }
    AppMethodBeat.o(246396);
  }
  
  public void uC(int paramInt) {}
  
  public void unMount()
  {
    AppMethodBeat.i(246391);
    super.unMount();
    com.tencent.mm.kernel.g.aAg().b((p)this.uma);
    AppMethodBeat.o(246391);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$clearScreen$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246386);
      this.umd.rg(this.umd.ulV);
      AppMethodBeat.o(246386);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$onNetworkChange$1", "Lcom/tencent/mm/network/IOnNetworkChange_AIDL$Stub;", "onNetworkChange", "", "st", "", "plugin-finder_release"})
  public static final class b
    extends p.a
  {
    public final void onNetworkChange(int paramInt)
    {
      AppMethodBeat.i(246387);
      this.umd.uC(paramInt);
      AppMethodBeat.o(246387);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin$recoveryScreen$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator) {}
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(246388);
      this.umd.rg(this.umd.ulV);
      AppMethodBeat.o(246388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.d
 * JD-Core Version:    0.7.0.1
 */