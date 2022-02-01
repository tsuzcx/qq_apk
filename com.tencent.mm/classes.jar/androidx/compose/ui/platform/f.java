package androidx.compose.ui.platform;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.compose.ui.e.at;
import androidx.compose.ui.g.b;
import androidx.compose.ui.i.aa;
import androidx.compose.ui.i.z;
import androidx.compose.ui.k.i;
import androidx.compose.ui.k.l;
import androidx.compose.ui.k.o;
import androidx.compose.ui.k.w;
import androidx.core.g.a.d.a;
import androidx.core.g.a.d.b;
import androidx.core.g.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.u;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "isAccessibilityEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "Landroidx/collection/ArraySet;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "()V", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "getTextForTextField", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "", "requestAccessibilityFocus", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSemanticsStructureChangeEvents", "newNode", "oldNode", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "Api24Impl", "Api28Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends androidx.core.g.a
{
  public static final f.c aRW;
  private static final int[] aSs;
  final AndroidComposeView aRX;
  int aRY;
  private boolean aRZ;
  private androidx.core.g.a.e aSa;
  private int aSb;
  private androidx.b.h<androidx.b.h<CharSequence>> aSc;
  private androidx.b.h<Map<CharSequence, Integer>> aSd;
  private int aSe;
  private Integer aSf;
  private final androidx.b.b<androidx.compose.ui.i.f> aSg;
  private final kotlinx.coroutines.a.h<ah> aSh;
  boolean aSi;
  private e aSj;
  private Map<Integer, am> aSk;
  private androidx.b.b<Integer> aSl;
  private Map<Integer, f> aSm;
  private f aSn;
  boolean aSo;
  final Runnable aSp;
  private final List<al> aSq;
  private final kotlin.g.a.b<al, ah> aSr;
  private final AccessibilityManager accessibilityManager;
  final Handler handler;
  
  static
  {
    AppMethodBeat.i(207471);
    aRW = new f.c((byte)0);
    aSs = new int[] { androidx.compose.ui.g.a.accessibility_custom_action_0, androidx.compose.ui.g.a.accessibility_custom_action_1, androidx.compose.ui.g.a.accessibility_custom_action_2, androidx.compose.ui.g.a.accessibility_custom_action_3, androidx.compose.ui.g.a.accessibility_custom_action_4, androidx.compose.ui.g.a.accessibility_custom_action_5, androidx.compose.ui.g.a.accessibility_custom_action_6, androidx.compose.ui.g.a.accessibility_custom_action_7, androidx.compose.ui.g.a.accessibility_custom_action_8, androidx.compose.ui.g.a.accessibility_custom_action_9, androidx.compose.ui.g.a.accessibility_custom_action_10, androidx.compose.ui.g.a.accessibility_custom_action_11, androidx.compose.ui.g.a.accessibility_custom_action_12, androidx.compose.ui.g.a.accessibility_custom_action_13, androidx.compose.ui.g.a.accessibility_custom_action_14, androidx.compose.ui.g.a.accessibility_custom_action_15, androidx.compose.ui.g.a.accessibility_custom_action_16, androidx.compose.ui.g.a.accessibility_custom_action_17, androidx.compose.ui.g.a.accessibility_custom_action_18, androidx.compose.ui.g.a.accessibility_custom_action_19, androidx.compose.ui.g.a.accessibility_custom_action_20, androidx.compose.ui.g.a.accessibility_custom_action_21, androidx.compose.ui.g.a.accessibility_custom_action_22, androidx.compose.ui.g.a.accessibility_custom_action_23, androidx.compose.ui.g.a.accessibility_custom_action_24, androidx.compose.ui.g.a.accessibility_custom_action_25, androidx.compose.ui.g.a.accessibility_custom_action_26, androidx.compose.ui.g.a.accessibility_custom_action_27, androidx.compose.ui.g.a.accessibility_custom_action_28, androidx.compose.ui.g.a.accessibility_custom_action_29, androidx.compose.ui.g.a.accessibility_custom_action_30, androidx.compose.ui.g.a.accessibility_custom_action_31 };
    AppMethodBeat.o(207471);
  }
  
  public f(AndroidComposeView paramAndroidComposeView)
  {
    AppMethodBeat.i(206986);
    this.aRX = paramAndroidComposeView;
    this.aRY = -2147483648;
    paramAndroidComposeView = this.aRX.getContext().getSystemService("accessibility");
    if (paramAndroidComposeView == null)
    {
      paramAndroidComposeView = new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
      AppMethodBeat.o(206986);
      throw paramAndroidComposeView;
    }
    this.accessibilityManager = ((AccessibilityManager)paramAndroidComposeView);
    this.handler = new Handler(Looper.getMainLooper());
    this.aSa = new androidx.core.g.a.e(new d());
    this.aSb = -2147483648;
    this.aSc = new androidx.b.h();
    this.aSd = new androidx.b.h();
    this.aSe = -1;
    this.aSg = new androidx.b.b();
    this.aSh = kotlinx.coroutines.a.k.a(-1, null, 6);
    this.aSi = true;
    this.aSk = ak.kkZ();
    this.aSl = new androidx.b.b();
    this.aSm = ((Map)new LinkedHashMap());
    this.aSn = new f(this.aRX.getSemanticsOwner().Ae(), ak.kkZ());
    this.aRX.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(206668);
        kotlin.g.b.s.u(paramAnonymousView, "view");
        AppMethodBeat.o(206668);
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(206674);
        kotlin.g.b.s.u(paramAnonymousView, "view");
        f.a(this.aSt).removeCallbacks(f.b(this.aSt));
        AppMethodBeat.o(206674);
      }
    });
    this.aSp = ((Runnable)new j(this));
    this.aSq = ((List)new ArrayList());
    this.aSr = ((kotlin.g.a.b)new l(this));
    AppMethodBeat.o(206986);
  }
  
  private final int a(o paramo)
  {
    AppMethodBeat.i(207337);
    Object localObject = paramo.aSy;
    androidx.compose.ui.k.r localr = androidx.compose.ui.k.r.aXu;
    if (!((androidx.compose.ui.k.j)localObject).b(androidx.compose.ui.k.r.Af()))
    {
      localObject = paramo.aSy;
      localr = androidx.compose.ui.k.r.aXu;
      if (((androidx.compose.ui.k.j)localObject).b(androidx.compose.ui.k.r.Ax()))
      {
        paramo = paramo.aSy;
        localObject = androidx.compose.ui.k.r.aXu;
        i = androidx.compose.ui.m.s.aN(((androidx.compose.ui.m.s)paramo.a(androidx.compose.ui.k.r.Ax())).avp);
        AppMethodBeat.o(207337);
        return i;
      }
    }
    int i = this.aSe;
    AppMethodBeat.o(207337);
    return i;
  }
  
  private final AccessibilityEvent a(int paramInt, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString)
  {
    AppMethodBeat.i(207226);
    AccessibilityEvent localAccessibilityEvent = ag(paramInt, 8192);
    if (paramInteger1 != null) {
      localAccessibilityEvent.setFromIndex(((Number)paramInteger1).intValue());
    }
    if (paramInteger2 != null) {
      localAccessibilityEvent.setToIndex(((Number)paramInteger2).intValue());
    }
    if (paramInteger3 != null) {
      localAccessibilityEvent.setItemCount(((Number)paramInteger3).intValue());
    }
    if (paramString != null) {
      localAccessibilityEvent.getText().add(paramString);
    }
    AppMethodBeat.o(207226);
    return localAccessibilityEvent;
  }
  
  private void a(int paramInt, androidx.core.g.a.d paramd, o paramo)
  {
    AppMethodBeat.i(207144);
    kotlin.g.b.s.u(paramd, "info");
    kotlin.g.b.s.u(paramo, "semanticsNode");
    paramd.v((CharSequence)"android.view.View");
    Object localObject1 = paramo.aSy;
    Object localObject2 = androidx.compose.ui.k.r.aXu;
    localObject2 = (androidx.compose.ui.k.g)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.At());
    int j;
    boolean bool1;
    int k;
    if (localObject2 != null)
    {
      i = ((androidx.compose.ui.k.g)localObject2).value;
      if ((paramo.isFake) || (paramo.aA(false).isEmpty()))
      {
        localObject1 = androidx.compose.ui.k.g.aWD;
        j = androidx.compose.ui.k.g.zD();
        if (localObject2 != null) {
          break label960;
        }
        bool1 = false;
        if (!bool1) {
          break label975;
        }
        localObject1 = (CharSequence)this.aRX.getContext().getResources().getString(g.b.tab);
        if (Build.VERSION.SDK_INT >= 19) {
          paramd.buO.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", (CharSequence)localObject1);
        }
      }
      localObject1 = ah.aiuX;
      localObject1 = ah.aiuX;
    }
    else
    {
      if (g.h(paramo)) {
        paramd.v((CharSequence)"android.widget.EditText");
      }
      paramd.u((CharSequence)this.aRX.getContext().getPackageName());
      localObject1 = paramo.aA(true);
      k = ((List)localObject1).size() - 1;
      if (k < 0) {}
    }
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject3 = (o)((List)localObject1).get(i);
      Object localObject4;
      label300:
      label327:
      label359:
      boolean bool2;
      if (yG().containsKey(Integer.valueOf(((o)localObject3).id)))
      {
        localObject4 = (androidx.compose.ui.p.a)this.aRX.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(((o)localObject3).aOb);
        if (localObject4 != null) {
          paramd.aM((View)localObject4);
        }
      }
      else
      {
        if (j <= k) {
          continue;
        }
        if (this.aSb != paramInt) {
          break label1193;
        }
        paramd.aG(true);
        paramd.a(d.a.buZ);
        localObject1 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        localObject1 = (androidx.compose.ui.m.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Aw());
        if (localObject1 != null) {
          break label1208;
        }
        localObject1 = null;
        localObject3 = (SpannableString)j((CharSequence)localObject1);
        localObject1 = paramo.aSy;
        localObject4 = androidx.compose.ui.k.r.aXu;
        localObject1 = (List)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Av());
        if (localObject1 != null) {
          break label1232;
        }
        localObject1 = null;
        label404:
        localObject1 = (SpannableString)j((CharSequence)localObject1);
        if (localObject3 != null) {
          break label1277;
        }
        localObject1 = (CharSequence)localObject1;
        label429:
        paramd.setText((CharSequence)localObject1);
        localObject1 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        if (((androidx.compose.ui.k.j)localObject1).b(androidx.compose.ui.k.r.AC()))
        {
          paramd.EV();
          localObject1 = paramo.aSy;
          localObject3 = androidx.compose.ui.k.r.aXu;
          paramd.setError((CharSequence)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.AC()));
        }
        localObject1 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        paramd.x((CharSequence)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ag()));
        localObject1 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        localObject1 = (androidx.compose.ui.l.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.AA());
        if (localObject1 != null) {
          paramd.setCheckable(true);
        }
        switch (g.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          label584:
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
          localObject1 = paramo.aSy;
          localObject3 = androidx.compose.ui.k.r.aXu;
          localObject1 = (Boolean)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Az());
          if (localObject1 != null)
          {
            bool2 = ((Boolean)localObject1).booleanValue();
            localObject1 = androidx.compose.ui.k.g.aWD;
            i = androidx.compose.ui.k.g.zD();
            if (localObject2 == null)
            {
              bool1 = false;
              label648:
              if (!bool1) {
                break label1487;
              }
              paramd.setSelected(bool2);
              label659:
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
          }
          else
          {
            if ((!paramo.aSy.aXd) || (paramo.aA(false).isEmpty()))
            {
              localObject1 = paramo.aSy;
              localObject2 = androidx.compose.ui.k.r.aXu;
              localObject1 = (List)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Af());
              if (localObject1 != null) {
                break label1564;
              }
              localObject1 = null;
              label724:
              paramd.setContentDescription((CharSequence)localObject1);
            }
            if (paramo.aSy.aXd) {
              paramd.aJ(true);
            }
            localObject1 = paramo.aSy;
            localObject2 = androidx.compose.ui.k.r.aXu;
            if ((ah)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Am()) != null)
            {
              paramd.aL(true);
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
            bool1 = g.g(paramo);
            paramd.buO.setPassword(bool1);
            bool1 = g.h(paramo);
            if (Build.VERSION.SDK_INT >= 18) {
              paramd.buO.setEditable(bool1);
            }
            paramd.setEnabled(g.e(paramo));
            localObject1 = paramo.aSy;
            localObject2 = androidx.compose.ui.k.r.aXu;
            paramd.setFocusable(((androidx.compose.ui.k.j)localObject1).b(androidx.compose.ui.k.r.Ap()));
            if (paramd.buO.isFocusable())
            {
              localObject1 = paramo.aSy;
              localObject2 = androidx.compose.ui.k.r.aXu;
              paramd.aE(((Boolean)((androidx.compose.ui.k.j)localObject1).a(androidx.compose.ui.k.r.Ap())).booleanValue());
            }
            localObject1 = paramo.aSy;
            localObject2 = androidx.compose.ui.k.r.aXu;
            if (androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Aq()) != null) {
              break label1577;
            }
          }
          break;
        }
      }
      label1159:
      label1193:
      label1577:
      for (bool1 = true;; bool1 = false)
      {
        paramd.aF(bool1);
        localObject1 = paramo.aSy;
        localObject2 = androidx.compose.ui.k.r.aXu;
        if ((androidx.compose.ui.k.d)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ao()) == null) {
          break label1583;
        }
        AppMethodBeat.o(207144);
        throw null;
        label960:
        bool1 = androidx.compose.ui.k.g.C(((androidx.compose.ui.k.g)localObject2).value, j);
        break;
        label975:
        localObject1 = androidx.compose.ui.k.g.aWD;
        if (androidx.compose.ui.k.g.C(i, androidx.compose.ui.k.g.zz()))
        {
          localObject1 = "android.widget.Button";
          label996:
          localObject3 = androidx.compose.ui.k.g.aWD;
          i = androidx.compose.ui.k.g.zE();
          if (localObject2 != null) {
            break label1159;
          }
        }
        for (bool1 = false; (!bool1) || (g.a(paramo.aOb, (kotlin.g.a.b)i.aSA) == null) || (paramo.aSy.aXd); bool1 = androidx.compose.ui.k.g.C(((androidx.compose.ui.k.g)localObject2).value, i))
        {
          paramd.v((CharSequence)localObject1);
          break;
          localObject1 = androidx.compose.ui.k.g.aWD;
          if (androidx.compose.ui.k.g.C(i, androidx.compose.ui.k.g.zA()))
          {
            localObject1 = "android.widget.CheckBox";
            break label996;
          }
          localObject1 = androidx.compose.ui.k.g.aWD;
          if (androidx.compose.ui.k.g.C(i, androidx.compose.ui.k.g.zB()))
          {
            localObject1 = "android.widget.Switch";
            break label996;
          }
          localObject1 = androidx.compose.ui.k.g.aWD;
          if (androidx.compose.ui.k.g.C(i, androidx.compose.ui.k.g.zC()))
          {
            localObject1 = "android.widget.RadioButton";
            break label996;
          }
          localObject1 = androidx.compose.ui.k.g.aWD;
          if (androidx.compose.ui.k.g.C(i, androidx.compose.ui.k.g.zE()))
          {
            localObject1 = "android.widget.ImageView";
            break label996;
          }
          localObject1 = null;
          break label996;
        }
        paramd.z((View)this.aRX, ((o)localObject3).id);
        break label300;
        paramd.aG(false);
        paramd.a(d.a.buY);
        break label327;
        label1208:
        localObject1 = androidx.compose.ui.m.e.a.a((androidx.compose.ui.m.a)localObject1, this.aRX.getDensity(), this.aRX.getFontLoader());
        break label359;
        label1232:
        localObject1 = (androidx.compose.ui.m.a)kotlin.a.p.oL((List)localObject1);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label404;
        }
        localObject1 = androidx.compose.ui.m.e.a.a((androidx.compose.ui.m.a)localObject1, this.aRX.getDensity(), this.aRX.getFontLoader());
        break label404;
        label1277:
        localObject1 = (CharSequence)localObject3;
        break label429;
        paramd.setChecked(true);
        localObject1 = androidx.compose.ui.k.g.aWD;
        i = androidx.compose.ui.k.g.zB();
        if (localObject2 == null) {}
        for (bool1 = false; (bool1) && (paramd.ET() == null); bool1 = androidx.compose.ui.k.g.C(((androidx.compose.ui.k.g)localObject2).value, i))
        {
          paramd.x((CharSequence)this.aRX.getContext().getResources().getString(g.b.on));
          break;
        }
        paramd.setChecked(false);
        localObject1 = androidx.compose.ui.k.g.aWD;
        i = androidx.compose.ui.k.g.zB();
        if (localObject2 == null) {}
        for (bool1 = false; (bool1) && (paramd.ET() == null); bool1 = androidx.compose.ui.k.g.C(((androidx.compose.ui.k.g)localObject2).value, i))
        {
          paramd.x((CharSequence)this.aRX.getContext().getResources().getString(g.b.off));
          break;
        }
        if (paramd.ET() != null) {
          break label584;
        }
        paramd.x((CharSequence)this.aRX.getContext().getResources().getString(g.b.indeterminate));
        break label584;
        bool1 = androidx.compose.ui.k.g.C(((androidx.compose.ui.k.g)localObject2).value, i);
        break label648;
        label1487:
        paramd.setCheckable(true);
        paramd.setChecked(bool2);
        if (paramd.ET() != null) {
          break label659;
        }
        if (bool2) {}
        for (localObject1 = (CharSequence)this.aRX.getContext().getResources().getString(g.b.selected);; localObject1 = (CharSequence)this.aRX.getContext().getResources().getString(g.b.not_selected))
        {
          paramd.x((CharSequence)localObject1);
          break;
        }
        localObject1 = (String)kotlin.a.p.oL((List)localObject1);
        break label724;
      }
      label1564:
      label1583:
      paramd.setClickable(false);
      localObject1 = paramo.aSy;
      localObject2 = i.aWM;
      localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zG());
      label2030:
      label2164:
      float f1;
      label2094:
      label2248:
      float f2;
      if (localObject1 != null)
      {
        localObject2 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        bool2 = kotlin.g.b.s.p(androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject2, androidx.compose.ui.k.r.Az()), Boolean.TRUE);
        if (!bool2)
        {
          bool1 = true;
          paramd.setClickable(bool1);
          if ((g.e(paramo)) && (!bool2)) {
            paramd.a(new d.a(16, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          }
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
      }
      else
      {
        paramd.setLongClickable(false);
        localObject1 = paramo.aSy;
        localObject2 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zH());
        if (localObject1 != null)
        {
          paramd.setLongClickable(true);
          if (g.e(paramo)) {
            paramd.a(new d.a(32, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          }
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        localObject1 = paramo.aSy;
        localObject2 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zN());
        if (localObject1 != null)
        {
          paramd.a(new d.a(16384, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        if (g.e(paramo))
        {
          localObject1 = paramo.aSy;
          localObject2 = i.aWM;
          localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zM());
          if (localObject1 != null)
          {
            paramd.a(new d.a(2097152, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
          localObject1 = paramo.aSy;
          localObject2 = i.aWM;
          localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zO());
          if (localObject1 != null)
          {
            paramd.a(new d.a(65536, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
          localObject1 = paramo.aSy;
          localObject2 = i.aWM;
          localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zP());
          if (localObject1 != null)
          {
            if (paramd.buO.isFocused())
            {
              localObject2 = this.aRX.getClipboardManager().aQR.getPrimaryClipDescription();
              if (localObject2 != null) {
                break label3670;
              }
              bool1 = false;
              if (bool1) {
                paramd.a(new d.a(32768, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
              }
            }
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
          }
        }
        localObject1 = (CharSequence)c(paramo);
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label3683;
        }
        i = 1;
        if (i == 0)
        {
          i = a(paramo);
          j = b(paramo);
          if (Build.VERSION.SDK_INT >= 18) {
            paramd.buO.setTextSelection(i, j);
          }
          localObject1 = paramo.aSy;
          localObject2 = i.aWM;
          localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zL());
          if (localObject1 != null) {
            break label3689;
          }
          localObject1 = null;
          paramd.a(new d.a(131072, (CharSequence)localObject1));
          paramd.eu(256);
          paramd.eu(512);
          paramd.ev(11);
          localObject1 = paramo.aSy;
          localObject2 = androidx.compose.ui.k.r.aXu;
          localObject1 = (Collection)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Af());
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label3699;
          }
          i = 1;
          if (i != 0)
          {
            localObject1 = paramo.aSy;
            localObject2 = i.aWM;
            if (((androidx.compose.ui.k.j)localObject1).b(i.zF()))
            {
              if (!g.h(paramo)) {
                break label3705;
              }
              localObject1 = paramo.aSy;
              localObject2 = androidx.compose.ui.k.r.aXu;
              if (kotlin.g.b.s.p(androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ap()), Boolean.TRUE)) {
                break label3705;
              }
              i = 1;
              label2313:
              if (i == 0) {
                paramd.ev(paramd.EK() | 0x4 | 0x10);
              }
            }
          }
        }
        if (Build.VERSION.SDK_INT >= 26)
        {
          localObject1 = paramd.getText();
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label3799;
          }
          i = 1;
          label2363:
          if (i == 0)
          {
            localObject1 = paramo.aSy;
            localObject2 = i.aWM;
            if (((androidx.compose.ui.k.j)localObject1).b(i.zF()))
            {
              localObject1 = c.aQP;
              localObject2 = paramd.buO;
              kotlin.g.b.s.s(localObject2, "info.unwrap()");
              ((c)localObject1).a((AccessibilityNodeInfo)localObject2, kotlin.a.p.listOf("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY"));
            }
          }
        }
        localObject1 = paramo.aSy;
        localObject2 = androidx.compose.ui.k.r.aXu;
        localObject2 = (androidx.compose.ui.k.f)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ah());
        if (localObject2 != null)
        {
          localObject1 = paramo.aSy;
          localObject3 = i.aWM;
          if (!((androidx.compose.ui.k.j)localObject1).b(i.zK())) {
            break label3805;
          }
          paramd.v((CharSequence)"android.widget.SeekBar");
          label2483:
          localObject1 = androidx.compose.ui.k.f.aWy;
          if (localObject2 == androidx.compose.ui.k.f.zy()) {
            break label3943;
          }
          f1 = ((Number)((androidx.compose.ui.k.f)localObject2).aWA.klJ()).floatValue();
          f2 = ((Number)((androidx.compose.ui.k.f)localObject2).aWA.klK()).floatValue();
          float f3 = ((androidx.compose.ui.k.f)localObject2).aWz;
          if (Build.VERSION.SDK_INT < 19) {
            break label3818;
          }
          localObject1 = new d.d(AccessibilityNodeInfo.RangeInfo.obtain(1, f1, f2, f3));
          label2566:
          if (Build.VERSION.SDK_INT >= 19) {
            paramd.buO.setRangeInfo((AccessibilityNodeInfo.RangeInfo)((d.d)localObject1).bvI);
          }
          if (paramd.ET() == null)
          {
            localObject1 = ((androidx.compose.ui.k.f)localObject2).aWA;
            if (((Number)((kotlin.k.c)localObject1).klK()).floatValue() - ((Number)((kotlin.k.c)localObject1).klJ()).floatValue() != 0.0F) {
              break label3831;
            }
            i = 1;
            label2638:
            if (i == 0) {
              break label3837;
            }
            f1 = 0.0F;
            label2646:
            f1 = kotlin.k.k.C(f1, 0.0F, 1.0F);
            if (f1 != 0.0F) {
              break label3889;
            }
            i = 1;
            label2665:
            if (i == 0) {
              break label3895;
            }
            i = 0;
            label2673:
            paramd.x((CharSequence)this.aRX.getContext().getResources().getString(g.b.template_percent, new Object[] { Integer.valueOf(i) }));
          }
        }
      }
      for (;;)
      {
        localObject1 = paramo.aSy;
        localObject3 = i.aWM;
        if ((((androidx.compose.ui.k.j)localObject1).b(i.zK())) && (g.e(paramo)))
        {
          if (((androidx.compose.ui.k.f)localObject2).aWz < kotlin.k.k.bt(((Number)((androidx.compose.ui.k.f)localObject2).aWA.klK()).floatValue(), ((Number)((androidx.compose.ui.k.f)localObject2).aWA.klJ()).floatValue())) {
            paramd.a(d.a.bve);
          }
          if (((androidx.compose.ui.k.f)localObject2).aWz > kotlin.k.k.bu(((Number)((androidx.compose.ui.k.f)localObject2).aWA.klJ()).floatValue(), ((Number)((androidx.compose.ui.k.f)localObject2).aWA.klK()).floatValue())) {
            paramd.a(d.a.bvf);
          }
        }
        if (Build.VERSION.SDK_INT >= 24)
        {
          localObject1 = f.a.aSu;
          kotlin.g.b.s.u(paramd, "info");
          kotlin.g.b.s.u(paramo, "semanticsNode");
          if (g.e(paramo))
          {
            localObject1 = paramo.aSy;
            localObject2 = i.aWM;
            localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zK());
            if (localObject1 != null) {
              paramd.a(new d.a(16908349, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
            }
          }
        }
        kotlin.g.b.s.u(paramo, "node");
        kotlin.g.b.s.u(paramd, "info");
        localObject1 = paramo.Aa();
        localObject2 = androidx.compose.ui.k.r.aXu;
        localObject1 = (androidx.compose.ui.k.b)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ak());
        if (localObject1 == null) {
          break label3976;
        }
        i = ((androidx.compose.ui.k.b)localObject1).rowCount;
        j = ((androidx.compose.ui.k.b)localObject1).columnCount;
        paramd.aB(d.b.a(i, j, false, 0));
        label2994:
        androidx.compose.ui.platform.a.a.a(paramo, paramd);
        localObject1 = paramo.aSy;
        localObject2 = androidx.compose.ui.k.r.aXu;
        localObject2 = (androidx.compose.ui.k.h)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ar());
        localObject1 = paramo.aSy;
        localObject3 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zI());
        if ((localObject2 != null) && (localObject1 != null))
        {
          f1 = ((Number)((androidx.compose.ui.k.h)localObject2).aWJ.invoke()).floatValue();
          f2 = ((Number)((androidx.compose.ui.k.h)localObject2).aWK.invoke()).floatValue();
          bool1 = ((androidx.compose.ui.k.h)localObject2).aWL;
          paramd.v((CharSequence)"android.widget.HorizontalScrollView");
          if (f2 > 0.0F) {
            paramd.aH(true);
          }
          if ((g.e(paramo)) && (f1 < f2))
          {
            paramd.a(d.a.bve);
            if (bool1) {
              break label4179;
            }
            paramd.a(d.a.bvt);
          }
          label3156:
          if ((g.e(paramo)) && (f1 > 0.0F))
          {
            paramd.a(d.a.bvf);
            if (bool1) {
              break label4189;
            }
            paramd.a(d.a.bvr);
          }
        }
        label3189:
        localObject2 = paramo.aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
        localObject2 = (androidx.compose.ui.k.h)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject2, androidx.compose.ui.k.r.As());
        if ((localObject2 != null) && (localObject1 != null))
        {
          f1 = ((Number)((androidx.compose.ui.k.h)localObject2).aWJ.invoke()).floatValue();
          f2 = ((Number)((androidx.compose.ui.k.h)localObject2).aWK.invoke()).floatValue();
          bool1 = ((androidx.compose.ui.k.h)localObject2).aWL;
          paramd.v((CharSequence)"android.widget.ScrollView");
          if (f2 > 0.0F) {
            paramd.aH(true);
          }
          if ((g.e(paramo)) && (f1 < f2))
          {
            paramd.a(d.a.bve);
            if (bool1) {
              break label4199;
            }
            paramd.a(d.a.bvs);
          }
          label3322:
          if ((g.e(paramo)) && (f1 > 0.0F))
          {
            paramd.a(d.a.bvf);
            if (bool1) {
              break label4209;
            }
            paramd.a(d.a.bvq);
          }
        }
        label3355:
        localObject1 = paramo.aSy;
        localObject2 = androidx.compose.ui.k.r.aXu;
        paramd.z((CharSequence)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ai()));
        if (!g.e(paramo)) {
          break label4406;
        }
        localObject1 = paramo.aSy;
        localObject2 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zQ());
        if (localObject1 != null)
        {
          paramd.a(new d.a(262144, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        localObject1 = paramo.aSy;
        localObject2 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zR());
        if (localObject1 != null)
        {
          paramd.a(new d.a(524288, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
        localObject1 = paramo.aSy;
        localObject2 = i.aWM;
        localObject1 = (androidx.compose.ui.k.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, i.zS());
        if (localObject1 != null)
        {
          paramd.a(new d.a(1048576, (CharSequence)((androidx.compose.ui.k.a)localObject1).label));
          paramd = ah.aiuX;
          paramd = ah.aiuX;
        }
        paramd = paramo.aSy;
        localObject1 = i.aWM;
        if (!paramd.b(i.zT())) {
          break label4406;
        }
        paramd = paramo.aSy;
        paramo = i.aWM;
        paramd = (List)paramd.a(i.zT());
        if (paramd.size() < aSs.length) {
          break label4219;
        }
        paramd = new IllegalStateException("Can't have more than " + aSs.length + " custom actions for one widget");
        AppMethodBeat.o(207144);
        throw paramd;
        bool1 = false;
        break;
        label3670:
        bool1 = ((ClipDescription)localObject2).hasMimeType("text/plain");
        break label2030;
        label3683:
        i = 0;
        break label2094;
        label3689:
        localObject1 = ((androidx.compose.ui.k.a)localObject1).label;
        break label2164;
        label3699:
        i = 0;
        break label2248;
        label3705:
        localObject1 = g.a(paramo.aOb, (kotlin.g.a.b)g.a.aSE);
        if (localObject1 != null)
        {
          localObject1 = androidx.compose.ui.k.p.G((androidx.compose.ui.i.f)localObject1);
          if (localObject1 == null) {
            bool1 = false;
          }
          for (;;)
          {
            if (bool1) {
              break label3793;
            }
            i = 1;
            break;
            localObject1 = ((w)localObject1).AE();
            if (localObject1 == null)
            {
              bool1 = false;
            }
            else
            {
              localObject2 = androidx.compose.ui.k.r.aXu;
              bool1 = kotlin.g.b.s.p(androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ap()), Boolean.TRUE);
            }
          }
        }
        label3793:
        i = 0;
        break label2313;
        label3799:
        i = 0;
        break label2363;
        label3805:
        paramd.v((CharSequence)"android.widget.ProgressBar");
        break label2483;
        label3818:
        localObject1 = new d.d(null);
        break label2566;
        label3831:
        i = 0;
        break label2638;
        label3837:
        f1 = (((androidx.compose.ui.k.f)localObject2).aWz - ((Number)((kotlin.k.c)localObject1).klJ()).floatValue()) / (((Number)((kotlin.k.c)localObject1).klK()).floatValue() - ((Number)((kotlin.k.c)localObject1).klJ()).floatValue());
        break label2646;
        label3889:
        i = 0;
        break label2665;
        label3895:
        if (f1 == 1.0F) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label3923;
          }
          i = 100;
          break;
        }
        label3923:
        i = kotlin.k.k.bQ(kotlin.h.a.eH(100.0F * f1), 1, 99);
        break label2673;
        label3943:
        if (paramd.ET() == null) {
          paramd.x((CharSequence)this.aRX.getContext().getResources().getString(g.b.in_progress));
        }
      }
      label3976:
      localObject1 = (List)new ArrayList();
      localObject2 = paramo.Aa();
      localObject3 = androidx.compose.ui.k.r.aXu;
      if (androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject2, androidx.compose.ui.k.r.Aj()) != null)
      {
        localObject2 = paramo.aA(false);
        k = ((List)localObject2).size() - 1;
        if (k < 0) {}
      }
      for (i = 0;; i = j)
      {
        j = i + 1;
        localObject3 = (o)((List)localObject2).get(i);
        localObject4 = ((o)localObject3).Aa();
        androidx.compose.ui.k.r localr = androidx.compose.ui.k.r.aXu;
        if (((androidx.compose.ui.k.j)localObject4).b(androidx.compose.ui.k.r.Az())) {
          ((List)localObject1).add(localObject3);
        }
        if (j > k)
        {
          if (!((Collection)localObject1).isEmpty())
          {
            i = 1;
            label4112:
            if (i == 0) {
              break label4156;
            }
            bool1 = androidx.compose.ui.platform.a.a.S((List)localObject1);
            if (!bool1) {
              break label4158;
            }
          }
          label4156:
          label4158:
          for (i = 1;; i = ((Collection)localObject1).size())
          {
            if (!bool1) {
              break label4173;
            }
            j = ((Collection)localObject1).size();
            break;
            i = 0;
            break label4112;
            break label2994;
          }
          label4173:
          j = 1;
          break;
          label4179:
          paramd.a(d.a.bvr);
          break label3156;
          label4189:
          paramd.a(d.a.bvt);
          break label3189;
          label4199:
          paramd.a(d.a.bvq);
          break label3322;
          label4209:
          paramd.a(d.a.bvs);
          break label3355;
          label4219:
          paramo = new androidx.b.h();
          localObject1 = (Map)new LinkedHashMap();
          if (this.aSd.bp(paramInt))
          {
            localObject2 = (Map)this.aSd.d(paramInt, null);
            localObject3 = kotlin.a.k.af(aSs);
            localObject4 = (List)new ArrayList();
            if (paramd.size() - 1 >= 0)
            {
              paramd.get(0);
              kotlin.g.b.s.checkNotNull(localObject2);
              AppMethodBeat.o(207144);
              throw null;
            }
            if (((List)localObject4).size() - 1 >= 0)
            {
              ((List)localObject4).get(0);
              ((Number)((List)localObject3).get(0)).intValue();
              AppMethodBeat.o(207144);
              throw null;
            }
          }
          else if (paramd.size() - 1 >= 0)
          {
            paramd.get(0);
            AppMethodBeat.o(207144);
            throw null;
          }
          this.aSc.put(paramInt, paramo);
          this.aSd.put(paramInt, localObject1);
          label4406:
          AppMethodBeat.o(207144);
          return;
        }
      }
    }
  }
  
  private final void a(o paramo, f paramf)
  {
    int j = 0;
    AppMethodBeat.i(207296);
    Object localObject = (Set)new LinkedHashSet();
    List localList = paramo.aA(false);
    int m = localList.size() - 1;
    if (m >= 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      o localo = (o)localList.get(i);
      if (yG().containsKey(Integer.valueOf(localo.id)))
      {
        if (!paramf.aSz.contains(Integer.valueOf(localo.id)))
        {
          F(paramo.aOb);
          AppMethodBeat.o(207296);
          return;
        }
        ((Set)localObject).add(Integer.valueOf(localo.id));
      }
      if (k > m)
      {
        paramf = paramf.aSz.iterator();
        while (paramf.hasNext()) {
          if (!((Set)localObject).contains(Integer.valueOf(((Number)paramf.next()).intValue())))
          {
            F(paramo.aOb);
            AppMethodBeat.o(207296);
            return;
          }
        }
        paramo = paramo.aA(false);
        k = paramo.size() - 1;
        if (k >= 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          paramf = (o)paramo.get(i);
          if (yG().containsKey(Integer.valueOf(paramf.id)))
          {
            localObject = this.aSm.get(Integer.valueOf(paramf.id));
            kotlin.g.b.s.checkNotNull(localObject);
            a(paramf, (f)localObject);
          }
          if (j > k)
          {
            AppMethodBeat.o(207296);
            return;
          }
        }
      }
    }
  }
  
  private final void a(al paramal)
  {
    AppMethodBeat.i(207265);
    if (!paramal.isValid())
    {
      AppMethodBeat.o(207265);
      return;
    }
    this.aRX.getSnapshotObserver().a((z)paramal, this.aSr, (kotlin.g.a.a)new k(paramal, this));
    AppMethodBeat.o(207265);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Integer paramInteger, List<String> paramList)
  {
    AppMethodBeat.i(207178);
    if ((paramInt1 == -2147483648) || (!isAccessibilityEnabled()))
    {
      AppMethodBeat.o(207178);
      return false;
    }
    AccessibilityEvent localAccessibilityEvent = ag(paramInt1, paramInt2);
    if (paramInteger != null) {
      localAccessibilityEvent.setContentChangeTypes(paramInteger.intValue());
    }
    if (paramList != null) {
      localAccessibilityEvent.setContentDescription((CharSequence)androidx.compose.ui.h.a(paramList, (CharSequence)","));
    }
    boolean bool = a(localAccessibilityEvent);
    AppMethodBeat.o(207178);
    return bool;
  }
  
  private final boolean a(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(207212);
    if (!isAccessibilityEnabled())
    {
      AppMethodBeat.o(207212);
      return false;
    }
    boolean bool = this.aRX.getParent().requestSendAccessibilityEvent((View)this.aRX, paramAccessibilityEvent);
    AppMethodBeat.o(207212);
    return bool;
  }
  
  private final boolean a(o paramo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Integer localInteger = null;
    AppMethodBeat.i(207324);
    Object localObject1 = paramo.aSy;
    Object localObject2 = i.aWM;
    if ((((androidx.compose.ui.k.j)localObject1).b(i.zL())) && (g.e(paramo)))
    {
      paramo = paramo.aSy;
      localObject1 = i.aWM;
      paramo = (kotlin.g.a.q)((androidx.compose.ui.k.a)paramo.a(i.zL())).aWk;
      if (paramo == null)
      {
        AppMethodBeat.o(207324);
        return false;
      }
      paramo = (Boolean)paramo.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean));
      if (paramo == null)
      {
        AppMethodBeat.o(207324);
        return false;
      }
      paramBoolean = paramo.booleanValue();
      AppMethodBeat.o(207324);
      return paramBoolean;
    }
    if ((paramInt1 == paramInt2) && (paramInt2 == this.aSe))
    {
      AppMethodBeat.o(207324);
      return false;
    }
    String str = c(paramo);
    if (str == null)
    {
      AppMethodBeat.o(207324);
      return false;
    }
    if ((paramInt1 >= 0) && (paramInt1 == paramInt2) && (paramInt2 <= str.length()))
    {
      this.aSe = paramInt1;
      if (((CharSequence)str).length() <= 0) {
        break label293;
      }
      paramInt1 = 1;
      label205:
      paramInt2 = cZ(paramo.id);
      if (paramInt1 == 0) {
        break label298;
      }
      localObject1 = Integer.valueOf(this.aSe);
      label227:
      if (paramInt1 == 0) {
        break label304;
      }
    }
    label293:
    label298:
    label304:
    for (localObject2 = Integer.valueOf(this.aSe);; localObject2 = null)
    {
      if (paramInt1 != 0) {
        localInteger = Integer.valueOf(str.length());
      }
      a(a(paramInt2, (Integer)localObject1, (Integer)localObject2, localInteger, str));
      da(paramo.id);
      AppMethodBeat.o(207324);
      return true;
      paramInt1 = -1;
      break;
      paramInt1 = 0;
      break label205;
      localObject1 = null;
      break label227;
    }
  }
  
  private final int b(o paramo)
  {
    AppMethodBeat.i(207346);
    Object localObject = paramo.aSy;
    androidx.compose.ui.k.r localr = androidx.compose.ui.k.r.aXu;
    if (!((androidx.compose.ui.k.j)localObject).b(androidx.compose.ui.k.r.Af()))
    {
      localObject = paramo.aSy;
      localr = androidx.compose.ui.k.r.aXu;
      if (((androidx.compose.ui.k.j)localObject).b(androidx.compose.ui.k.r.Ax()))
      {
        paramo = paramo.aSy;
        localObject = androidx.compose.ui.k.r.aXu;
        i = androidx.compose.ui.m.s.aO(((androidx.compose.ui.m.s)paramo.a(androidx.compose.ui.k.r.Ax())).avp);
        AppMethodBeat.o(207346);
        return i;
      }
    }
    int i = this.aSe;
    AppMethodBeat.o(207346);
    return i;
  }
  
  private static String c(o paramo)
  {
    AppMethodBeat.i(207358);
    if (paramo == null)
    {
      AppMethodBeat.o(207358);
      return null;
    }
    Object localObject = paramo.aSy;
    androidx.compose.ui.k.r localr = androidx.compose.ui.k.r.aXu;
    if (((androidx.compose.ui.k.j)localObject).b(androidx.compose.ui.k.r.Af()))
    {
      paramo = paramo.aSy;
      localObject = androidx.compose.ui.k.r.aXu;
      paramo = androidx.compose.ui.h.a((List)paramo.a(androidx.compose.ui.k.r.Af()), (CharSequence)",");
      AppMethodBeat.o(207358);
      return paramo;
    }
    if (g.h(paramo))
    {
      paramo = d(paramo);
      AppMethodBeat.o(207358);
      return paramo;
    }
    paramo = paramo.aSy;
    localObject = androidx.compose.ui.k.r.aXu;
    paramo = (List)androidx.compose.ui.k.k.a(paramo, androidx.compose.ui.k.r.Av());
    if (paramo == null)
    {
      AppMethodBeat.o(207358);
      return null;
    }
    paramo = (androidx.compose.ui.m.a)kotlin.a.p.oL(paramo);
    if (paramo == null)
    {
      AppMethodBeat.o(207358);
      return null;
    }
    paramo = paramo.text;
    AppMethodBeat.o(207358);
    return paramo;
  }
  
  private final void c(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(207278);
    AccessibilityEvent localAccessibilityEvent = ag(cZ(paramInt1), 32);
    localAccessibilityEvent.setContentChangeTypes(paramInt2);
    if (paramString != null) {
      localAccessibilityEvent.getText().add(paramString);
    }
    a(localAccessibilityEvent);
    AppMethodBeat.o(207278);
  }
  
  private final boolean cY(int paramInt)
  {
    return this.aSb == paramInt;
  }
  
  private static String d(o paramo)
  {
    AppMethodBeat.i(207366);
    if (paramo == null)
    {
      AppMethodBeat.o(207366);
      return null;
    }
    Object localObject1 = paramo.aSy;
    Object localObject2 = androidx.compose.ui.k.r.aXu;
    localObject1 = (androidx.compose.ui.m.a)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Aw());
    localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {
      i = 1;
    }
    while (i != 0)
    {
      paramo = paramo.aSy;
      localObject1 = androidx.compose.ui.k.r.aXu;
      paramo = (List)androidx.compose.ui.k.k.a(paramo, androidx.compose.ui.k.r.Av());
      if (paramo == null)
      {
        AppMethodBeat.o(207366);
        return null;
        i = 0;
      }
      else
      {
        paramo = (androidx.compose.ui.m.a)kotlin.a.p.oL(paramo);
        if (paramo == null)
        {
          AppMethodBeat.o(207366);
          return null;
        }
        paramo = paramo.text;
        AppMethodBeat.o(207366);
        return paramo;
      }
    }
    paramo = ((androidx.compose.ui.m.a)localObject1).text;
    AppMethodBeat.o(207366);
    return paramo;
  }
  
  private final void da(int paramInt)
  {
    AppMethodBeat.i(207308);
    e locale = this.aSj;
    if (locale != null)
    {
      if (paramInt != locale.aQI.id)
      {
        AppMethodBeat.o(207308);
        return;
      }
      if (SystemClock.uptimeMillis() - locale.aSx <= 1000L)
      {
        AccessibilityEvent localAccessibilityEvent = ag(cZ(locale.aQI.id), 131072);
        localAccessibilityEvent.setFromIndex(locale.aqt);
        localAccessibilityEvent.setToIndex(locale.aqu);
        localAccessibilityEvent.setAction(locale.action);
        localAccessibilityEvent.setMovementGranularity(locale.aSw);
        localAccessibilityEvent.getText().add(c(locale.aQI));
        a(localAccessibilityEvent);
      }
    }
    this.aSj = null;
    AppMethodBeat.o(207308);
  }
  
  private static <T extends CharSequence> T j(T paramT)
  {
    int j = 99999;
    AppMethodBeat.i(207237);
    if ((paramT == null) || (paramT.length() == 0)) {}
    for (int i = 1; (i != 0) || (paramT.length() <= 100000); i = 0)
    {
      AppMethodBeat.o(207237);
      return paramT;
    }
    if ((Character.isHighSurrogate(paramT.charAt(99999))) && (Character.isLowSurrogate(paramT.charAt(100000)))) {}
    for (i = j;; i = 100000)
    {
      paramT = paramT.subSequence(0, i);
      AppMethodBeat.o(207237);
      return paramT;
    }
  }
  
  private final Map<Integer, am> yG()
  {
    AppMethodBeat.i(207000);
    Object localObject;
    Map localMap;
    if (this.aSi)
    {
      localObject = this.aRX.getSemanticsOwner();
      kotlin.g.b.s.u(localObject, "<this>");
      localObject = ((androidx.compose.ui.k.q)localObject).Ae();
      localMap = (Map)new LinkedHashMap();
      if (((o)localObject).aOb.aOw) {
        break label77;
      }
    }
    for (;;)
    {
      this.aSk = localMap;
      this.aSi = false;
      localObject = this.aSk;
      AppMethodBeat.o(207000);
      return localObject;
      label77:
      Region localRegion = new Region();
      localRegion.set(at.f(((o)localObject).zX()));
      g.a(localRegion, (o)localObject, localMap, (o)localObject);
    }
  }
  
  private final void yH()
  {
    AppMethodBeat.i(207252);
    Object localObject2 = this.aSl.iterator();
    Object localObject3;
    label55:
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      localObject1 = (am)yG().get(localObject3);
      if (localObject1 == null)
      {
        localObject1 = null;
        if ((localObject1 != null) && (g.f((o)localObject1))) {
          break label128;
        }
        this.aSl.remove(localObject3);
        kotlin.g.b.s.s(localObject3, "id");
        i = ((Integer)localObject3).intValue();
        localObject1 = (f)this.aSm.get(localObject3);
        if (localObject1 != null) {
          break label130;
        }
      }
      for (localObject1 = null;; localObject1 = (String)androidx.compose.ui.k.k.a((androidx.compose.ui.k.j)localObject1, androidx.compose.ui.k.r.Ai()))
      {
        c(i, 32, (String)localObject1);
        break;
        localObject1 = ((am)localObject1).aVg;
        break label55;
        label128:
        break;
        label130:
        localObject1 = ((f)localObject1).aSy;
        localObject3 = androidx.compose.ui.k.r.aXu;
      }
    }
    this.aSm.clear();
    Object localObject1 = yG().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((g.f(((am)((Map.Entry)localObject2).getValue()).aVg)) && (this.aSl.add(((Map.Entry)localObject2).getKey())))
      {
        i = ((Number)((Map.Entry)localObject2).getKey()).intValue();
        localObject3 = ((am)((Map.Entry)localObject2).getValue()).aVg.aSy;
        androidx.compose.ui.k.r localr = androidx.compose.ui.k.r.aXu;
        c(i, 16, (String)((androidx.compose.ui.k.j)localObject3).a(androidx.compose.ui.k.r.Ai()));
      }
      this.aSm.put(((Map.Entry)localObject2).getKey(), new f(((am)((Map.Entry)localObject2).getValue()).aVg, yG()));
    }
    this.aSn = new f(this.aRX.getSemanticsOwner().Ae(), yG());
    AppMethodBeat.o(207252);
  }
  
  final void F(androidx.compose.ui.i.f paramf)
  {
    AppMethodBeat.i(207549);
    if (this.aSg.add(paramf)) {
      this.aSh.iV(ah.aiuX);
    }
    AppMethodBeat.o(207549);
  }
  
  public final AccessibilityEvent ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207492);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    kotlin.g.b.s.s(localAccessibilityEvent, "obtain(eventType)");
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName((CharSequence)"android.view.View");
    localAccessibilityEvent.setPackageName((CharSequence)this.aRX.getContext().getPackageName());
    localAccessibilityEvent.setSource((View)this.aRX, paramInt1);
    am localam = (am)yG().get(Integer.valueOf(paramInt1));
    if (localam != null) {
      localAccessibilityEvent.setPassword(g.g(localam.aVg));
    }
    AppMethodBeat.o(207492);
    return localAccessibilityEvent;
  }
  
  final int cZ(int paramInt)
  {
    AppMethodBeat.i(207556);
    if (paramInt == this.aRX.getSemanticsOwner().Ae().id)
    {
      AppMethodBeat.o(207556);
      return -1;
    }
    AppMethodBeat.o(207556);
    return paramInt;
  }
  
  public final Object g(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(207536);
    Object localObject1;
    if ((paramd instanceof h))
    {
      localObject1 = (h)paramd;
      if ((((h)localObject1).label & 0x80000000) != 0) {
        ((h)localObject1).label += -2147483648;
      }
    }
    Object localObject8;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject8 = ((h)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((h)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207536);
        throw paramd;
        localObject1 = new h(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject8);
    for (;;)
    {
      try
      {
        localObject5 = new androidx.b.b();
        localObject6 = this.aSh.kCW();
        paramd = this;
        localObject4 = localObject1;
        localObject1 = paramd;
        paramd = (kotlin.d.d<? super ah>)localObject1;
      }
      finally
      {
        Object localObject4;
        androidx.compose.ui.i.f localf;
        label473:
        paramd = this;
        label527:
        paramd.aSg.clear();
        AppMethodBeat.o(207536);
      }
      try
      {
        localObject4.L$0 = localObject1;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.Uf = localObject5;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.VC = localObject6;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.label = 1;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject7 = ((kotlinx.coroutines.a.j)localObject6).aC(localObject4);
        paramd = (kotlin.d.d<? super ah>)localObject7;
        localObject8 = paramd;
        if (paramd == locala)
        {
          AppMethodBeat.o(207536);
          return locala;
          localObject6 = (kotlinx.coroutines.a.j)((h)localObject1).VC;
          localObject5 = (androidx.b.b)((h)localObject1).Uf;
          localObject7 = (f)((h)localObject1).L$0;
          paramd = (kotlin.d.d<? super ah>)localObject7;
          ResultKt.throwOnFailure(localObject8);
          localObject4 = localObject1;
          localObject1 = localObject7;
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        if (!((Boolean)localObject8).booleanValue()) {
          continue;
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        ((kotlinx.coroutines.a.j)localObject6).next();
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject7 = ah.aiuX;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        if (!((f)localObject1).isAccessibilityEnabled()) {
          continue;
        }
        i = 0;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        k = ((f)localObject1).aSg.size() - 1;
        if (k < 0) {
          continue;
        }
      }
      finally
      {
        continue;
        paramd = (kotlin.d.d<? super ah>)localObject5;
        localObject5 = localObject6;
        continue;
        do
        {
          i = j;
          break;
          break label527;
          if (localObject7 != null) {
            break label473;
          }
        } while (j <= k);
        continue;
      }
      j = i + 1;
      paramd = (kotlin.d.d<? super ah>)localObject1;
      localObject7 = localObject1.aSg.RQ[i];
      paramd = (kotlin.d.d<? super ah>)localObject1;
      kotlin.g.b.s.checkNotNull(localObject7);
      paramd = (kotlin.d.d<? super ah>)localObject1;
      kotlin.g.b.s.s(localObject7, "subtreeChangedLayoutNodes.valueAt(i)!!");
      paramd = (kotlin.d.d<? super ah>)localObject1;
      localf = (androidx.compose.ui.i.f)localObject7;
      paramd = (kotlin.d.d<? super ah>)localObject1;
      if (!localf.isAttached()) {
        break label857;
      }
      paramd = (kotlin.d.d<? super ah>)localObject1;
      if (((Map)((f)localObject1).aRX.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder()).containsKey(localf)) {
        break label857;
      }
      paramd = (kotlin.d.d<? super ah>)localObject1;
      localObject8 = androidx.compose.ui.k.p.G(localf);
      localObject7 = localObject8;
      if (localObject8 == null)
      {
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject7 = g.a(localf, (kotlin.g.a.b)n.aSD);
        if (localObject7 == null)
        {
          localObject7 = null;
          break label849;
        }
      }
      else
      {
        paramd = (kotlin.d.d<? super ah>)localObject1;
        if (((w)localObject7).AE().aXd) {
          break label846;
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject8 = g.a(localf, (kotlin.g.a.b)m.aSC);
        if (localObject8 == null) {
          break label846;
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject8 = androidx.compose.ui.k.p.G((androidx.compose.ui.i.f)localObject8);
        if (localObject8 == null) {
          break label846;
        }
        localObject7 = localObject8;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        i = ((l)((w)localObject7).wb()).getId();
        paramd = (kotlin.d.d<? super ah>)localObject1;
        if (!((androidx.b.b)localObject5).add(Integer.valueOf(i))) {
          break label857;
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        a((f)localObject1, ((f)localObject1).cZ(i), 2048, Integer.valueOf(1), 8);
        break label857;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        ((androidx.b.b)localObject5).clear();
        paramd = (kotlin.d.d<? super ah>)localObject1;
        if (!((f)localObject1).aSo)
        {
          paramd = (kotlin.d.d<? super ah>)localObject1;
          ((f)localObject1).aSo = true;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          ((f)localObject1).handler.post(((f)localObject1).aSp);
        }
        paramd = (kotlin.d.d<? super ah>)localObject1;
        ((f)localObject1).aSg.clear();
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.L$0 = localObject1;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.Uf = localObject5;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.VC = localObject6;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject4.label = 2;
        paramd = (kotlin.d.d<? super ah>)localObject1;
        localObject7 = bb.e(100L, localObject4);
        if (localObject7 != locala) {
          break label831;
        }
        AppMethodBeat.o(207536);
        return locala;
      }
      paramd = (kotlin.d.d<? super ah>)localObject1;
      localObject7 = androidx.compose.ui.k.p.G((androidx.compose.ui.i.f)localObject7);
      break label849;
      localObject6 = (kotlinx.coroutines.a.j)((h)localObject1).VC;
      localObject7 = (androidx.b.b)((h)localObject1).Uf;
      localObject5 = (f)((h)localObject1).L$0;
      paramd = (kotlin.d.d<? super ah>)localObject5;
      ResultKt.throwOnFailure(localObject8);
      localObject4 = localObject1;
      localObject1 = localObject5;
      paramd = (kotlin.d.d<? super ah>)localObject7;
      localObject5 = localObject6;
      localObject6 = localObject5;
      localObject5 = paramd;
    }
    ((f)localObject1).aSg.clear();
    paramd = ah.aiuX;
    AppMethodBeat.o(207536);
    return paramd;
  }
  
  public final androidx.core.g.a.e getAccessibilityNodeProvider(View paramView)
  {
    return this.aSa;
  }
  
  final boolean isAccessibilityEnabled()
  {
    AppMethodBeat.i(207479);
    if ((this.aRZ) || ((this.accessibilityManager.isEnabled()) && (this.accessibilityManager.isTouchExplorationEnabled())))
    {
      AppMethodBeat.o(207479);
      return true;
    }
    AppMethodBeat.o(207479);
    return false;
  }
  
  final void updateHoveredVirtualView(int paramInt)
  {
    AppMethodBeat.i(207499);
    if (this.aRY == paramInt)
    {
      AppMethodBeat.o(207499);
      return;
    }
    int i = this.aRY;
    this.aRY = paramInt;
    a(this, paramInt, 128, null, 12);
    a(this, i, 256, null, 12);
    AppMethodBeat.o(207499);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends AccessibilityNodeProvider
  {
    public d()
    {
      AppMethodBeat.i(206655);
      AppMethodBeat.o(206655);
    }
    
    public final void addExtraDataToAccessibilityNodeInfo(int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(206663);
      kotlin.g.b.s.u(paramAccessibilityNodeInfo, "info");
      kotlin.g.b.s.u(paramString, "extraDataKey");
      f.a(this.aSt, paramInt, paramAccessibilityNodeInfo, paramString, paramBundle);
      AppMethodBeat.o(206663);
    }
    
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
    {
      AppMethodBeat.i(206657);
      AccessibilityNodeInfo localAccessibilityNodeInfo = f.b(this.aSt, paramInt);
      AppMethodBeat.o(206657);
      return localAccessibilityNodeInfo;
    }
    
    public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(206660);
      boolean bool = f.a(this.aSt, paramInt1, paramInt2, paramBundle);
      AppMethodBeat.o(206660);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
  {
    final o aQI;
    final int aSw;
    final long aSx;
    final int action;
    final int aqt;
    final int aqu;
    
    public e(o paramo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
    {
      AppMethodBeat.i(206656);
      this.aQI = paramo;
      this.action = paramInt1;
      this.aSw = paramInt2;
      this.aqt = paramInt3;
      this.aqu = paramInt4;
      this.aSx = paramLong;
      AppMethodBeat.o(206656);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    final androidx.compose.ui.k.j aSy;
    final Set<Integer> aSz;
    
    public f(o paramo, Map<Integer, am> paramMap)
    {
      AppMethodBeat.i(206652);
      this.aSy = paramo.aSy;
      this.aSz = ((Set)new LinkedHashSet());
      paramo = paramo.aA(false);
      int k = paramo.size() - 1;
      if (k >= 0)
      {
        int j;
        do
        {
          j = i + 1;
          o localo = (o)paramo.get(i);
          if (paramMap.containsKey(Integer.valueOf(localo.id))) {
            this.aSz.add(Integer.valueOf(localo.id));
          }
          i = j;
        } while (j <= k);
      }
      AppMethodBeat.o(206652);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    h(f paramf, kotlin.d.d<? super h> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(206608);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.aSt.g((kotlin.d.d)this);
      AppMethodBeat.o(206608);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "parent", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.i.f, Boolean>
  {
    public static final i aSA;
    
    static
    {
      AppMethodBeat.i(206609);
      aSA = new i();
      AppMethodBeat.o(206609);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    implements Runnable
  {
    j(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(206612);
      f.c(this.aSt);
      f.d(this.aSt);
      AppMethodBeat.o(206612);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(al paramal, f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/platform/ScrollObservationScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<al, ah>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.i.f, Boolean>
  {
    public static final m aSC;
    
    static
    {
      AppMethodBeat.i(206604);
      aSC = new m();
      AppMethodBeat.o(206604);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<androidx.compose.ui.i.f, Boolean>
  {
    public static final n aSD;
    
    static
    {
      AppMethodBeat.i(206599);
      aSD = new n();
      AppMethodBeat.o(206599);
    }
    
    n()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.f
 * JD-Core Version:    0.7.0.1
 */