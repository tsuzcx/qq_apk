package com.tencent.mm.accessibility.core;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.area.AreaProvider;
import com.tencent.mm.accessibility.core.provider.AccProviderFactory;
import com.tencent.mm.accessibility.uitl.AccNodeUtil;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/MMAccessibilityDelegateWrap;", "Landroid/view/View$AccessibilityDelegate;", "origin", "(Landroid/view/View$AccessibilityDelegate;)V", "nodeCache", "Landroid/view/accessibility/AccessibilityNodeInfo;", "nodeCacheTime", "", "getOrigin", "()Landroid/view/View$AccessibilityDelegate;", "getAccessibilityNodeProvider", "Landroid/view/accessibility/AccessibilityNodeProvider;", "host", "Landroid/view/View;", "getCache", "onInitializeAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "performAccessibilityAction", "", "action", "", "args", "Landroid/os/Bundle;", "saveCache", "Companion", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMAccessibilityDelegateWrap
  extends View.AccessibilityDelegate
{
  public static final long CACHE_TIME = 100L;
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Acc.MMAccessibilityDelegateWrap";
  private AccessibilityNodeInfo nodeCache;
  private long nodeCacheTime;
  private final View.AccessibilityDelegate origin;
  
  static
  {
    AppMethodBeat.i(234190);
    Companion = new Companion(null);
    AppMethodBeat.o(234190);
  }
  
  public MMAccessibilityDelegateWrap()
  {
    this(null, 1, null);
  }
  
  public MMAccessibilityDelegateWrap(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    this.origin = paramAccessibilityDelegate;
  }
  
  private final AccessibilityNodeInfo getCache()
  {
    AppMethodBeat.i(234178);
    if ((System.currentTimeMillis() - this.nodeCacheTime < 100L) && (AccUtil.INSTANCE.isEnableNodeInfoCache()))
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = this.nodeCache;
      AppMethodBeat.o(234178);
      return localAccessibilityNodeInfo;
    }
    AppMethodBeat.o(234178);
    return null;
  }
  
  private final void saveCache(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234171);
    if (AccUtil.INSTANCE.isEnableNodeInfoCache())
    {
      if (this.nodeCache != null)
      {
        AccessibilityNodeInfo localAccessibilityNodeInfo = this.nodeCache;
        if (localAccessibilityNodeInfo != null) {
          localAccessibilityNodeInfo.recycle();
        }
      }
      this.nodeCache = AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfo);
      this.nodeCacheTime = System.currentTimeMillis();
    }
    AppMethodBeat.o(234171);
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(234217);
    Object localObject = this.origin;
    if (localObject != null)
    {
      localObject = ((View.AccessibilityDelegate)localObject).getAccessibilityNodeProvider(paramView);
      if (localObject != null)
      {
        AppMethodBeat.o(234217);
        return localObject;
      }
    }
    if ((AccUtil.INSTANCE.canPreDeal()) && (paramView != null) && ((paramView.isClickable()) || (paramView.isLongClickable())))
    {
      paramView = AreaProvider.INSTANCE.buildAccessibilityProvider(paramView);
      AppMethodBeat.o(234217);
      return paramView;
    }
    AppMethodBeat.o(234217);
    return null;
  }
  
  public final View.AccessibilityDelegate getOrigin()
  {
    return this.origin;
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(234210);
    Object localObject = this.origin;
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      }
      if ((paramView != null) && (paramAccessibilityEvent != null) && ((AccUtil.INSTANCE.isAccessibilityEnabled()) || (AccUtil.INSTANCE.isEnableAccEnableForced()))) {
        AccProviderFactory.INSTANCE.dispatchAccEvent(paramView, paramAccessibilityEvent);
      }
      AppMethodBeat.o(234210);
      return;
      ((View.AccessibilityDelegate)localObject).onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234204);
    for (;;)
    {
      try
      {
        Object localObject = this.origin;
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            break label122;
          }
          super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
          break label122;
          AppMethodBeat.o(234204);
          return;
        }
        ((View.AccessibilityDelegate)localObject).onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
        localObject = ah.aiuX;
        continue;
        localObject = getCache();
        if (localObject != null)
        {
          AccNodeUtil.INSTANCE.copy((AccessibilityNodeInfo)localObject, paramAccessibilityNodeInfo);
          Log.d("MicroMsg.Acc.MMAccessibilityDelegateWrap", "node hit cache");
          AppMethodBeat.o(234204);
          return;
        }
      }
      catch (Exception paramView)
      {
        AppMethodBeat.o(234204);
        return;
      }
      if ((AccUtil.INSTANCE.isAccessibilityEnabled()) || (AccUtil.INSTANCE.isEnableAccEnableForced()))
      {
        AccProviderFactory.INSTANCE.dispatchNodeInfo(paramView, paramAccessibilityNodeInfo);
        saveCache(paramAccessibilityNodeInfo);
        AppMethodBeat.o(234204);
        return;
        label122:
        if (paramView != null) {
          if (paramAccessibilityNodeInfo != null) {}
        }
      }
    }
  }
  
  public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(234224);
    if (paramView != null) {
      AccProviderFactory.INSTANCE.dispatchOnAction(paramView, paramInt, paramBundle);
    }
    boolean bool = super.performAccessibilityAction(paramView, paramInt, paramBundle);
    AppMethodBeat.o(234224);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/MMAccessibilityDelegateWrap$Companion;", "", "()V", "CACHE_TIME", "", "TAG", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.MMAccessibilityDelegateWrap
 * JD-Core Version:    0.7.0.1
 */