package androidx.core.g;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.a.c;
import androidx.core.g.a.d;
import androidx.core.g.a.d.a;
import androidx.core.g.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a
{
  private static final View.AccessibilityDelegate DEFAULT_DELEGATE;
  private final View.AccessibilityDelegate mBridge;
  private final View.AccessibilityDelegate mOriginalDelegate;
  
  static
  {
    AppMethodBeat.i(251393);
    DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    AppMethodBeat.o(251393);
  }
  
  public a()
  {
    this(DEFAULT_DELEGATE);
  }
  
  public a(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(251374);
    this.mOriginalDelegate = paramAccessibilityDelegate;
    this.mBridge = new a(this);
    AppMethodBeat.o(251374);
  }
  
  static List<d.a> getActionList(View paramView)
  {
    AppMethodBeat.i(251392);
    paramView = (List)paramView.getTag(a.c.tag_accessibility_actions);
    if (paramView == null)
    {
      paramView = Collections.emptyList();
      AppMethodBeat.o(251392);
      return paramView;
    }
    AppMethodBeat.o(251392);
    return paramView;
  }
  
  private boolean isSpanStillValid(ClickableSpan paramClickableSpan, View paramView)
  {
    AppMethodBeat.i(251391);
    if (paramClickableSpan != null)
    {
      paramView = d.u(paramView.createAccessibilityNodeInfo().getText());
      int i = 0;
      while ((paramView != null) && (i < paramView.length))
      {
        if (paramClickableSpan.equals(paramView[i]))
        {
          AppMethodBeat.o(251391);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(251391);
    return false;
  }
  
  private boolean performClickableSpanAction(int paramInt, View paramView)
  {
    AppMethodBeat.i(251390);
    Object localObject = (SparseArray)paramView.getTag(a.c.tag_accessibility_clickable_spans);
    if (localObject != null)
    {
      localObject = (WeakReference)((SparseArray)localObject).get(paramInt);
      if (localObject != null)
      {
        localObject = (ClickableSpan)((WeakReference)localObject).get();
        if (isSpanStillValid((ClickableSpan)localObject, paramView))
        {
          ((ClickableSpan)localObject).onClick(paramView);
          AppMethodBeat.o(251390);
          return true;
        }
      }
    }
    AppMethodBeat.o(251390);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251378);
    boolean bool = this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251378);
    return bool;
  }
  
  public e getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(251386);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = this.mOriginalDelegate.getAccessibilityNodeProvider(paramView);
      if (paramView != null)
      {
        paramView = new e(paramView);
        AppMethodBeat.o(251386);
        return paramView;
      }
    }
    AppMethodBeat.o(251386);
    return null;
  }
  
  View.AccessibilityDelegate getBridge()
  {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251381);
    this.mOriginalDelegate.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251381);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
  {
    AppMethodBeat.i(251382);
    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(paramView, paramd.Ov);
    AppMethodBeat.o(251382);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251380);
    this.mOriginalDelegate.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251380);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251383);
    boolean bool = this.mOriginalDelegate.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251383);
    return bool;
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(251389);
    List localList = getActionList(paramView);
    int i = 0;
    d.a locala;
    if (i < localList.size())
    {
      locala = (d.a)localList.get(i);
      if (locala.getId() != paramInt) {}
    }
    for (boolean bool2 = locala.i(paramBundle);; bool2 = false)
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT >= 16) {
          bool1 = this.mOriginalDelegate.performAccessibilityAction(paramView, paramInt, paramBundle);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == a.c.accessibility_action_clickable_span) {
          bool2 = performClickableSpanAction(paramBundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), paramView);
        }
      }
      AppMethodBeat.o(251389);
      return bool2;
      i += 1;
      break;
    }
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(251376);
    this.mOriginalDelegate.sendAccessibilityEvent(paramView, paramInt);
    AppMethodBeat.o(251376);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(251377);
    this.mOriginalDelegate.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(251377);
  }
  
  static final class a
    extends View.AccessibilityDelegate
  {
    final a MC;
    
    a(a parama)
    {
      this.MC = parama;
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(251360);
      boolean bool = this.MC.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(251360);
      return bool;
    }
    
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      AppMethodBeat.i(251369);
      paramView = this.MC.getAccessibilityNodeProvider(paramView);
      if (paramView != null)
      {
        paramView = (AccessibilityNodeProvider)paramView.Pr;
        AppMethodBeat.o(251369);
        return paramView;
      }
      AppMethodBeat.o(251369);
      return null;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(251361);
      this.MC.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(251361);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      int j = 0;
      AppMethodBeat.i(251363);
      d locald = d.a(paramAccessibilityNodeInfo);
      boolean bool = w.ao(paramView);
      label62:
      CharSequence localCharSequence;
      if (Build.VERSION.SDK_INT >= 28)
      {
        locald.Ov.setScreenReaderFocusable(bool);
        bool = w.aq(paramView);
        if (Build.VERSION.SDK_INT < 28) {
          break label250;
        }
        locald.Ov.setHeading(bool);
        localCharSequence = w.ap(paramView);
        if (Build.VERSION.SDK_INT < 28) {
          break label261;
        }
        locald.Ov.setPaneTitle(localCharSequence);
      }
      for (;;)
      {
        this.MC.onInitializeAccessibilityNodeInfo(paramView, locald);
        localCharSequence = paramAccessibilityNodeInfo.getText();
        if ((Build.VERSION.SDK_INT < 19) || (Build.VERSION.SDK_INT >= 26)) {
          break label535;
        }
        if (Build.VERSION.SDK_INT >= 19)
        {
          locald.Ov.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
          locald.Ov.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
          locald.Ov.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
          locald.Ov.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
        paramAccessibilityNodeInfo = d.az(paramView);
        if (paramAccessibilityNodeInfo == null) {
          break label325;
        }
        localObject1 = new ArrayList();
        i = 0;
        while (i < paramAccessibilityNodeInfo.size())
        {
          if (((WeakReference)paramAccessibilityNodeInfo.valueAt(i)).get() == null) {
            ((List)localObject1).add(Integer.valueOf(i));
          }
          i += 1;
        }
        locald.f(1, bool);
        break;
        label250:
        locald.f(2, bool);
        break label62;
        label261:
        if (Build.VERSION.SDK_INT >= 19) {
          locald.Ov.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", localCharSequence);
        }
      }
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        paramAccessibilityNodeInfo.remove(((Integer)((List)localObject1).get(i)).intValue());
        i += 1;
      }
      label325:
      Object localObject1 = d.u(localCharSequence);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        locald.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.c.accessibility_action_clickable_span);
        paramAccessibilityNodeInfo = d.az(paramView);
        if (paramAccessibilityNodeInfo != null) {
          break label581;
        }
        paramAccessibilityNodeInfo = new SparseArray();
        paramView.setTag(a.c.tag_accessibility_clickable_spans, paramAccessibilityNodeInfo);
      }
      label535:
      label581:
      for (;;)
      {
        i = 0;
        while ((localObject1 != null) && (i < localObject1.length))
        {
          int k = d.a(localObject1[i], paramAccessibilityNodeInfo);
          paramAccessibilityNodeInfo.put(k, new WeakReference(localObject1[i]));
          Object localObject2 = localObject1[i];
          Spanned localSpanned = (Spanned)localCharSequence;
          locald.F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(localSpanned.getSpanStart(localObject2)));
          locald.F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(localSpanned.getSpanEnd(localObject2)));
          locald.F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(localSpanned.getSpanFlags(localObject2)));
          locald.F("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(k));
          i += 1;
        }
        paramView = a.getActionList(paramView);
        i = j;
        while (i < paramView.size())
        {
          locald.a((d.a)paramView.get(i));
          i += 1;
        }
        AppMethodBeat.o(251363);
        return;
      }
    }
    
    public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(251365);
      this.MC.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(251365);
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(251366);
      boolean bool = this.MC.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      AppMethodBeat.o(251366);
      return bool;
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(251370);
      boolean bool = this.MC.performAccessibilityAction(paramView, paramInt, paramBundle);
      AppMethodBeat.o(251370);
      return bool;
    }
    
    public final void sendAccessibilityEvent(View paramView, int paramInt)
    {
      AppMethodBeat.i(251367);
      this.MC.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(251367);
    }
    
    public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(251368);
      this.MC.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(251368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a
 * JD-Core Version:    0.7.0.1
 */