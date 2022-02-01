package com.tencent.mm.accessibility.core.area;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.core.provider.AccProviderFactory;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/VisualAreaNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "host", "Landroid/view/View;", "eLeft", "", "eTop", "eRight", "eBottom", "(Landroid/view/View;IIII)V", "tmpRect", "Landroid/graphics/Rect;", "tmpRect2", "createAccessibilityNodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "virtualViewId", "modifyNodeRect", "", "node", "performAction", "", "action", "arguments", "Landroid/os/Bundle;", "Companion", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VisualAreaNodeProvider
  extends AccessibilityNodeProvider
{
  public static final Companion Companion;
  public static final String TAG = "MicroMsg.Acc.VisualAreaNodeProvider";
  private final int eBottom;
  private final int eLeft;
  private final int eRight;
  private final int eTop;
  private final View host;
  private final Rect tmpRect;
  private final Rect tmpRect2;
  
  static
  {
    AppMethodBeat.i(234353);
    Companion = new Companion(null);
    AppMethodBeat.o(234353);
  }
  
  public VisualAreaNodeProvider(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234340);
    this.host = paramView;
    this.eLeft = paramInt1;
    this.eTop = paramInt2;
    this.eRight = paramInt3;
    this.eBottom = paramInt4;
    this.tmpRect = new Rect();
    this.tmpRect2 = new Rect();
    AppMethodBeat.o(234340);
  }
  
  private final void modifyNodeRect(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234348);
    paramAccessibilityNodeInfo.getBoundsInScreen(this.tmpRect);
    Rect localRect = this.tmpRect;
    localRect.left -= this.eLeft;
    localRect.top -= this.eTop;
    localRect.right += this.eRight;
    localRect.bottom += this.eBottom;
    paramAccessibilityNodeInfo.setBoundsInScreen(this.tmpRect);
    AccProviderFactory.INSTANCE.dispatchNodeInfo(this.host, paramAccessibilityNodeInfo);
    AppMethodBeat.o(234348);
  }
  
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    AppMethodBeat.i(234368);
    if (paramInt == -1)
    {
      AccessibilityNodeInfo localAccessibilityNodeInfo = AccessibilityNodeInfo.obtain(this.host);
      this.host.onInitializeAccessibilityNodeInfo(localAccessibilityNodeInfo);
      if ((this.host.isClickable()) || (this.host.isLongClickable()))
      {
        s.s(localAccessibilityNodeInfo, "node");
        modifyNodeRect(localAccessibilityNodeInfo);
      }
      AppMethodBeat.o(234368);
      return localAccessibilityNodeInfo;
    }
    AppMethodBeat.o(234368);
    return null;
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(234357);
    boolean bool = this.host.performAccessibilityAction(paramInt2, paramBundle);
    AppMethodBeat.o(234357);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/area/VisualAreaNodeProvider$Companion;", "", "()V", "TAG", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.area.VisualAreaNodeProvider
 * JD-Core Version:    0.7.0.1
 */