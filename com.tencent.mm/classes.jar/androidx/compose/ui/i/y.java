package androidx.compose.ui.i;

import androidx.compose.ui.a.g;
import androidx.compose.ui.c.c;
import androidx.compose.ui.e.u;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.ao;
import androidx.compose.ui.platform.av;
import androidx.compose.ui.platform.ba;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/Owner;", "", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AccessibilityManager;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill$annotations", "()V", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree$annotations", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "measureIteration", "", "getMeasureIteration", "()J", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "<set-?>", "", "showLayoutBounds", "getShowLayoutBounds", "()Z", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "calculateLocalPosition", "Landroidx/compose/ui/geometry/Offset;", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "createLayer", "Landroidx/compose/ui/node/OwnedLayer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "measureAndLayout", "onAttach", "node", "onDetach", "onLayoutChange", "layoutNode", "onRequestMeasure", "onRequestRelayout", "onSemanticsChange", "requestFocus", "requestRectangleOnScreen", "rect", "Landroidx/compose/ui/geometry/Rect;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface y
{
  public static final y.a aQj = y.a.aQk;
  
  public abstract void A(f paramf);
  
  public abstract void B(f paramf);
  
  public abstract long aJ(long paramLong);
  
  public abstract x b(kotlin.g.a.b<? super u, ah> paramb, kotlin.g.a.a<ah> parama);
  
  public abstract androidx.compose.ui.platform.b getAccessibilityManager();
  
  public abstract androidx.compose.ui.a.b getAutofill();
  
  public abstract g getAutofillTree();
  
  public abstract androidx.compose.ui.platform.s getClipboardManager();
  
  public abstract d getDensity();
  
  public abstract c getFocusManager();
  
  public abstract c.a getFontLoader();
  
  public abstract androidx.compose.ui.f.a getHapticFeedBack();
  
  public abstract n getLayoutDirection();
  
  public abstract long getMeasureIteration();
  
  public abstract boolean getShowLayoutBounds();
  
  public abstract aa getSnapshotObserver();
  
  public abstract androidx.compose.ui.m.c.s getTextInputService();
  
  public abstract ao getTextToolbar();
  
  public abstract av getViewConfiguration();
  
  public abstract ba getWindowInfo();
  
  public abstract boolean requestFocus();
  
  public abstract void setShowLayoutBounds(boolean paramBoolean);
  
  public abstract void x(f paramf);
  
  public abstract void y(f paramf);
  
  public abstract void yl();
  
  public abstract void ym();
  
  public abstract void z(f paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.y
 * JD-Core Version:    0.7.0.1
 */