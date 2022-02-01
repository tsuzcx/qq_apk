package com.tencent.mm.accessibility.uitl;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import androidx.core.g.a;
import androidx.core.g.z;
import androidx.recyclerview.widget.u.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MapExpandKt;
import com.tencent.mm.accessibility.core.MMAccessibilityDelegateWrap;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/uitl/AccNodeUtil;", "", "()V", "TAG", "", "checkDelegate", "", "view", "Landroid/view/View;", "copy", "originNode", "Landroid/view/accessibility/AccessibilityNodeInfo;", "target", "getOriginDelegate", "Landroid/view/View$AccessibilityDelegate;", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccNodeUtil
{
  public static final AccNodeUtil INSTANCE;
  private static final String TAG = "MicroMsg.Acc.AccNodeUtil";
  
  static
  {
    AppMethodBeat.i(234116);
    INSTANCE = new AccNodeUtil();
    AppMethodBeat.o(234116);
  }
  
  public final void checkDelegate(View paramView)
  {
    AppMethodBeat.i(234130);
    s.u(paramView, "view");
    Object localObject2;
    if (MapExpandKt.canDelegate(paramView))
    {
      try
      {
        if (paramView.getAccessibilityDelegate() == null)
        {
          paramView.setAccessibilityDelegate((View.AccessibilityDelegate)new MMAccessibilityDelegateWrap(null, 1, null));
          AppMethodBeat.o(234130);
          return;
        }
        View.AccessibilityDelegate localAccessibilityDelegate = getOriginDelegate(paramView);
        if (localAccessibilityDelegate == null) {
          break label139;
        }
        if (!(localAccessibilityDelegate instanceof MMAccessibilityDelegateWrap)) {
          paramView.setAccessibilityDelegate((View.AccessibilityDelegate)new MMAccessibilityDelegateWrap(localAccessibilityDelegate));
        }
        AppMethodBeat.o(234130);
        return;
      }
      finally {}
      try
      {
        localObject2 = View.class.getDeclaredField("mAccessibilityDelegate").get(paramView);
        if ((localObject2 instanceof View.AccessibilityDelegate))
        {
          localObject2 = (View.AccessibilityDelegate)localObject2;
          if (localObject2 != null) {
            break label150;
          }
          paramView.setAccessibilityDelegate((View.AccessibilityDelegate)new MMAccessibilityDelegateWrap(null, 1, null));
          AppMethodBeat.o(234130);
        }
      }
      finally {}
    }
    label139:
    label150:
    do
    {
      AppMethodBeat.o(234130);
      return;
      localObject2 = null;
      break;
      localObject2 = getOriginDelegate(paramView);
    } while (localObject2 == null);
    if (!(localObject2 instanceof MMAccessibilityDelegateWrap)) {
      paramView.setAccessibilityDelegate((View.AccessibilityDelegate)new MMAccessibilityDelegateWrap((View.AccessibilityDelegate)localObject2));
    }
    AppMethodBeat.o(234130);
  }
  
  public final void copy(AccessibilityNodeInfo paramAccessibilityNodeInfo1, AccessibilityNodeInfo paramAccessibilityNodeInfo2)
  {
    AppMethodBeat.i(234122);
    s.u(paramAccessibilityNodeInfo1, "originNode");
    s.u(paramAccessibilityNodeInfo2, "target");
    paramAccessibilityNodeInfo2.setContentDescription(paramAccessibilityNodeInfo1.getContentDescription());
    paramAccessibilityNodeInfo2.setClassName(paramAccessibilityNodeInfo1.getClassName());
    paramAccessibilityNodeInfo2.setCheckable(paramAccessibilityNodeInfo1.isCheckable());
    paramAccessibilityNodeInfo2.setChecked(paramAccessibilityNodeInfo1.isChecked());
    paramAccessibilityNodeInfo2.setClickable(paramAccessibilityNodeInfo1.isClickable());
    paramAccessibilityNodeInfo2.setLongClickable(paramAccessibilityNodeInfo1.isLongClickable());
    paramAccessibilityNodeInfo2.setFocusable(paramAccessibilityNodeInfo1.isFocusable());
    paramAccessibilityNodeInfo1 = paramAccessibilityNodeInfo1.getActionList();
    s.s(paramAccessibilityNodeInfo1, "it.actionList");
    paramAccessibilityNodeInfo1 = ((Iterable)paramAccessibilityNodeInfo1).iterator();
    while (paramAccessibilityNodeInfo1.hasNext()) {
      paramAccessibilityNodeInfo2.addAction((AccessibilityNodeInfo.AccessibilityAction)paramAccessibilityNodeInfo1.next());
    }
    AppMethodBeat.o(234122);
  }
  
  public final View.AccessibilityDelegate getOriginDelegate(View paramView)
  {
    AppMethodBeat.i(234136);
    s.u(paramView, "view");
    a locala = z.M(paramView);
    if (locala != null)
    {
      Object localObject;
      if ((locala instanceof u.a))
      {
        localObject = u.a.class.getDeclaredField("mOriginalItemDelegates");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(locala);
        if ((localObject instanceof WeakHashMap))
        {
          localObject = (WeakHashMap)localObject;
          if (localObject != null) {
            break label123;
          }
          paramView = null;
          label64:
          if (!(paramView instanceof a)) {
            break label137;
          }
          paramView = (a)paramView;
          label76:
          if (paramView == null) {
            break label142;
          }
        }
      }
      for (;;)
      {
        localObject = a.class.getDeclaredField("mOriginalDelegate");
        ((Field)localObject).setAccessible(true);
        paramView = ((Field)localObject).get(paramView);
        if (!(paramView instanceof View.AccessibilityDelegate)) {
          break label147;
        }
        paramView = (View.AccessibilityDelegate)paramView;
        AppMethodBeat.o(234136);
        return paramView;
        localObject = null;
        break;
        label123:
        paramView = ((Map)localObject).get(paramView);
        break label64;
        label137:
        paramView = null;
        break label76;
        label142:
        paramView = locala;
      }
      label147:
      AppMethodBeat.o(234136);
      return null;
    }
    AppMethodBeat.o(234136);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.uitl.AccNodeUtil
 * JD-Core Version:    0.7.0.1
 */