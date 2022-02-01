package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class c
{
  public final AccessibilityNodeInfo Pm;
  public int Pn = -1;
  
  private c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Pm = paramAccessibilityNodeInfo;
  }
  
  public static c a(c paramc)
  {
    return a(AccessibilityNodeInfo.obtain(paramc.Pm));
  }
  
  public static c a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new c(paramAccessibilityNodeInfo);
  }
  
  public final void G(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.Pm;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).PW)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.Pm.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.PV);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.Pm.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.Pm.addChild(paramView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (c)paramObject;
        if (this.Pm != null) {
          break;
        }
      } while (paramObject.Pm == null);
      return false;
    } while (this.Pm.equals(paramObject.Pm));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.Pm.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.Pm.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.Pm == null) {
      return 0;
    }
    return this.Pm.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Pm.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Pm.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Pm.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.Pm.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.Pm.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.Pm.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.Pm.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.Pm.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.Pm.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.Pm.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.Pm.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.Pm.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.Pm.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.Pm.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.Pm.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.Pm.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.Pm.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.Pm.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.Pm.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Pm.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Pm.setVisibleToUser(paramBoolean);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder1.append("; boundsInParent: ".concat(String.valueOf(localObject)));
    getBoundsInScreen((Rect)localObject);
    localStringBuilder1.append("; boundsInScreen: ".concat(String.valueOf(localObject)));
    localStringBuilder1.append("; packageName: ").append(this.Pm.getPackageName());
    localStringBuilder1.append("; className: ").append(this.Pm.getClassName());
    localStringBuilder1.append("; text: ").append(this.Pm.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.Pm.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.Pm.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.Pm.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.Pm.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.Pm.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.Pm.isFocused());
      localStringBuilder1.append("; selected: ").append(this.Pm.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.Pm.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.Pm.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.Pm.isEnabled());
      localStringBuilder1.append("; password: ").append(this.Pm.isPassword());
      localStringBuilder1.append("; scrollable: " + this.Pm.isScrollable());
      localStringBuilder1.append("; [");
      i = this.Pm.getActions();
      label381:
      if (i == 0) {
        break label710;
      }
      int j = 1 << Integer.numberOfTrailingZeros(i);
      i = (j ^ 0xFFFFFFFF) & i;
      switch (j)
      {
      default: 
        localObject = "ACTION_UNKNOWN";
      }
    }
    for (;;)
    {
      localStringBuilder1.append((String)localObject);
      if (i != 0) {
        localStringBuilder1.append(", ");
      }
      break label381;
      localObject = null;
      break;
      localObject = "ACTION_FOCUS";
      continue;
      localObject = "ACTION_CLEAR_FOCUS";
      continue;
      localObject = "ACTION_SELECT";
      continue;
      localObject = "ACTION_CLEAR_SELECTION";
      continue;
      localObject = "ACTION_CLICK";
      continue;
      localObject = "ACTION_LONG_CLICK";
      continue;
      localObject = "ACTION_ACCESSIBILITY_FOCUS";
      continue;
      localObject = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
      continue;
      localObject = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
      continue;
      localObject = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
      continue;
      localObject = "ACTION_NEXT_HTML_ELEMENT";
      continue;
      localObject = "ACTION_PREVIOUS_HTML_ELEMENT";
      continue;
      localObject = "ACTION_SCROLL_FORWARD";
      continue;
      localObject = "ACTION_SCROLL_BACKWARD";
      continue;
      localObject = "ACTION_CUT";
      continue;
      localObject = "ACTION_COPY";
      continue;
      localObject = "ACTION_PASTE";
      continue;
      localObject = "ACTION_SET_SELECTION";
    }
    label710:
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public static final class a
  {
    public static final a PA;
    public static final a PB;
    public static final a PC;
    public static final a PD;
    public static final a PE;
    public static final a PF;
    public static final a PG;
    public static final a PH;
    public static final a PI;
    public static final a PJ;
    public static final a PK;
    public static final a PL;
    public static final a PM;
    public static final a PN;
    public static final a PO;
    public static final a PP;
    public static final a PQ;
    public static final a PR;
    public static final a PS;
    public static final a PT;
    public static final a PU;
    public static final a Po;
    public static final a Pp;
    public static final a Pq;
    public static final a Pr;
    public static final a Ps;
    public static final a Pt;
    public static final a Pu;
    public static final a Pv;
    public static final a Pw;
    public static final a Px;
    public static final a Py;
    public static final a Pz;
    public final Object PV;
    
    static
    {
      Object localObject2 = null;
      Po = new a(1);
      Pp = new a(2);
      Pq = new a(4);
      Pr = new a(8);
      Ps = new a(16);
      Pt = new a(32);
      Pu = new a(64);
      Pv = new a(128);
      Pw = new a(256);
      Px = new a(512);
      Py = new a(1024);
      Pz = new a(2048);
      PA = new a(4096);
      PB = new a(8192);
      PC = new a(16384);
      PD = new a(32768);
      PE = new a(65536);
      PF = new a(131072);
      PG = new a(262144);
      PH = new a(524288);
      PI = new a(1048576);
      PJ = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        PK = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label532;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        PL = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label537;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        PM = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label542;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        PN = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label547;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        PO = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label552;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        PP = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label557;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label421:
        PQ = new a(localObject1);
        if (Build.VERSION.SDK_INT < 24) {
          break label562;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label444:
        PR = new a(localObject1);
        if (Build.VERSION.SDK_INT < 26) {
          break label567;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label467:
        PS = new a(localObject1);
        if (Build.VERSION.SDK_INT < 28) {
          break label572;
        }
      }
      label532:
      label537:
      label542:
      label547:
      label552:
      label557:
      label562:
      label567:
      label572:
      for (Object localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;; localObject1 = null)
      {
        PT = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        }
        PU = new a(localObject1);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label306;
        localObject1 = null;
        break label329;
        localObject1 = null;
        break label352;
        localObject1 = null;
        break label375;
        localObject1 = null;
        break label398;
        localObject1 = null;
        break label421;
        localObject1 = null;
        break label444;
        localObject1 = null;
        break label467;
      }
    }
    
    private a(int paramInt) {}
    
    private a(Object paramObject)
    {
      this.PV = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object PW;
    
    public b(Object paramObject)
    {
      this.PW = paramObject;
    }
  }
  
  public static final class c
  {
    final Object PW;
    
    private c(Object paramObject)
    {
      this.PW = paramObject;
    }
    
    public static c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, false));
      }
      if (Build.VERSION.SDK_INT >= 19) {
        return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
      }
      return new c(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.a.c
 * JD-Core Version:    0.7.0.1
 */