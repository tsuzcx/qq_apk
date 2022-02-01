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
  public final View.AccessibilityDelegate mOriginalDelegate;
  
  static
  {
    AppMethodBeat.i(195786);
    DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    AppMethodBeat.o(195786);
  }
  
  public a()
  {
    this(DEFAULT_DELEGATE);
  }
  
  public a(View.AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(195743);
    this.mOriginalDelegate = paramAccessibilityDelegate;
    this.mBridge = new a(this);
    AppMethodBeat.o(195743);
  }
  
  static List<d.a> getActionList(View paramView)
  {
    AppMethodBeat.i(195776);
    paramView = (List)paramView.getTag(a.c.tag_accessibility_actions);
    if (paramView == null)
    {
      paramView = Collections.emptyList();
      AppMethodBeat.o(195776);
      return paramView;
    }
    AppMethodBeat.o(195776);
    return paramView;
  }
  
  private boolean isSpanStillValid(ClickableSpan paramClickableSpan, View paramView)
  {
    AppMethodBeat.i(195767);
    if (paramClickableSpan != null)
    {
      paramView = d.w(paramView.createAccessibilityNodeInfo().getText());
      int i = 0;
      while ((paramView != null) && (i < paramView.length))
      {
        if (paramClickableSpan.equals(paramView[i]))
        {
          AppMethodBeat.o(195767);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(195767);
    return false;
  }
  
  private boolean performClickableSpanAction(int paramInt, View paramView)
  {
    AppMethodBeat.i(195756);
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
          AppMethodBeat.o(195756);
          return true;
        }
      }
    }
    AppMethodBeat.o(195756);
    return false;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195827);
    boolean bool = this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195827);
    return bool;
  }
  
  public e getAccessibilityNodeProvider(View paramView)
  {
    AppMethodBeat.i(195882);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = this.mOriginalDelegate.getAccessibilityNodeProvider(paramView);
      if (paramView != null)
      {
        paramView = new e(paramView);
        AppMethodBeat.o(195882);
        return paramView;
      }
    }
    AppMethodBeat.o(195882);
    return null;
  }
  
  View.AccessibilityDelegate getBridge()
  {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195851);
    this.mOriginalDelegate.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195851);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, d paramd)
  {
    AppMethodBeat.i(195860);
    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(paramView, paramd.buO);
    AppMethodBeat.o(195860);
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195840);
    this.mOriginalDelegate.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195840);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195871);
    boolean bool = this.mOriginalDelegate.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195871);
    return bool;
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(195890);
    List localList = getActionList(paramView);
    int i = 0;
    d.a locala;
    if (i < localList.size())
    {
      locala = (d.a)localList.get(i);
      if (locala.getId() != paramInt) {}
    }
    for (boolean bool2 = locala.l(paramBundle);; bool2 = false)
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
      AppMethodBeat.o(195890);
      return bool2;
      i += 1;
      break;
    }
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    AppMethodBeat.i(195804);
    this.mOriginalDelegate.sendAccessibilityEvent(paramView, paramInt);
    AppMethodBeat.o(195804);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(195816);
    this.mOriginalDelegate.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    AppMethodBeat.o(195816);
  }
  
  static final class a
    extends View.AccessibilityDelegate
  {
    final a bsG;
    
    a(a parama)
    {
      this.bsG = parama;
    }
    
    public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195859);
      boolean bool = this.bsG.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(195859);
      return bool;
    }
    
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      AppMethodBeat.i(195930);
      paramView = this.bsG.getAccessibilityNodeProvider(paramView);
      if (paramView != null)
      {
        paramView = (AccessibilityNodeProvider)paramView.bvJ;
        AppMethodBeat.o(195930);
        return paramView;
      }
      AppMethodBeat.o(195930);
      return null;
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195870);
      this.bsG.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(195870);
    }
    
    public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      int j = 0;
      AppMethodBeat.i(195888);
      d locald = d.a(paramAccessibilityNodeInfo);
      locald.aJ(z.aB(paramView));
      locald.aL(z.aD(paramView));
      locald.z(z.aC(paramView));
      locald.x(z.S(paramView));
      this.bsG.onInitializeAccessibilityNodeInfo(paramView, locald);
      CharSequence localCharSequence = paramAccessibilityNodeInfo.getText();
      Object localObject1;
      int i;
      if ((Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT < 26))
      {
        if (Build.VERSION.SDK_INT >= 19)
        {
          locald.buO.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
          locald.buO.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
          locald.buO.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
          locald.buO.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
        paramAccessibilityNodeInfo = d.aN(paramView);
        if (paramAccessibilityNodeInfo != null)
        {
          localObject1 = new ArrayList();
          i = 0;
          while (i < paramAccessibilityNodeInfo.size())
          {
            if (((WeakReference)paramAccessibilityNodeInfo.valueAt(i)).get() == null) {
              ((List)localObject1).add(Integer.valueOf(i));
            }
            i += 1;
          }
          i = 0;
          while (i < ((List)localObject1).size())
          {
            paramAccessibilityNodeInfo.remove(((Integer)((List)localObject1).get(i)).intValue());
            i += 1;
          }
        }
        localObject1 = d.w(localCharSequence);
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          locald.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", a.c.accessibility_action_clickable_span);
          paramAccessibilityNodeInfo = d.aN(paramView);
          if (paramAccessibilityNodeInfo != null) {
            break label497;
          }
          paramAccessibilityNodeInfo = new SparseArray();
          paramView.setTag(a.c.tag_accessibility_clickable_spans, paramAccessibilityNodeInfo);
        }
      }
      label497:
      for (;;)
      {
        i = 0;
        while ((localObject1 != null) && (i < localObject1.length))
        {
          int k = d.a(localObject1[i], paramAccessibilityNodeInfo);
          paramAccessibilityNodeInfo.put(k, new WeakReference(localObject1[i]));
          Object localObject2 = localObject1[i];
          Spanned localSpanned = (Spanned)localCharSequence;
          locald.az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(localSpanned.getSpanStart(localObject2)));
          locald.az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(localSpanned.getSpanEnd(localObject2)));
          locald.az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(localSpanned.getSpanFlags(localObject2)));
          locald.az("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(k));
          i += 1;
        }
        paramView = a.getActionList(paramView);
        i = j;
        while (i < paramView.size())
        {
          locald.a((d.a)paramView.get(i));
          i += 1;
        }
        AppMethodBeat.o(195888);
        return;
      }
    }
    
    public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195894);
      this.bsG.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(195894);
    }
    
    public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195902);
      boolean bool = this.bsG.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      AppMethodBeat.o(195902);
      return bool;
    }
    
    public final boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(195938);
      boolean bool = this.bsG.performAccessibilityAction(paramView, paramInt, paramBundle);
      AppMethodBeat.o(195938);
      return bool;
    }
    
    public final void sendAccessibilityEvent(View paramView, int paramInt)
    {
      AppMethodBeat.i(195910);
      this.bsG.sendAccessibilityEvent(paramView, paramInt);
      AppMethodBeat.o(195910);
    }
    
    public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      AppMethodBeat.i(195917);
      this.bsG.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
      AppMethodBeat.o(195917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.a
 * JD-Core Version:    0.7.0.1
 */