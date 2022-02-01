package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class c
{
  public final AccessibilityNodeInfo Rb;
  public int Rc = -1;
  
  private c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Rb = paramAccessibilityNodeInfo;
  }
  
  public static c a(c paramc)
  {
    return a(AccessibilityNodeInfo.obtain(paramc.Rb));
  }
  
  public static c a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new c(paramAccessibilityNodeInfo);
  }
  
  public final void H(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.Rb;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).RL)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.Rb.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.RK);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.Rb.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.Rb.addChild(paramView);
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
        if (this.Rb != null) {
          break;
        }
      } while (paramObject.Rb == null);
      return false;
    } while (this.Rb.equals(paramObject.Rb));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.Rb.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.Rb.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.Rb == null) {
      return 0;
    }
    return this.Rb.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Rb.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Rb.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Rb.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.Rb.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.Rb.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.Rb.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.Rb.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.Rb.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.Rb.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.Rb.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.Rb.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.Rb.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.Rb.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.Rb.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.Rb.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.Rb.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.Rb.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.Rb.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.Rb.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Rb.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Rb.setVisibleToUser(paramBoolean);
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
    localStringBuilder1.append("; packageName: ").append(this.Rb.getPackageName());
    localStringBuilder1.append("; className: ").append(this.Rb.getClassName());
    localStringBuilder1.append("; text: ").append(this.Rb.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.Rb.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.Rb.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.Rb.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.Rb.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.Rb.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.Rb.isFocused());
      localStringBuilder1.append("; selected: ").append(this.Rb.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.Rb.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.Rb.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.Rb.isEnabled());
      localStringBuilder1.append("; password: ").append(this.Rb.isPassword());
      localStringBuilder1.append("; scrollable: " + this.Rb.isScrollable());
      localStringBuilder1.append("; [");
      i = this.Rb.getActions();
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
    public static final a RA;
    public static final a RB;
    public static final a RC;
    public static final a RD;
    public static final a RE;
    public static final a RF;
    public static final a RG;
    public static final a RH;
    public static final a RI;
    public static final a RJ;
    public static final a Rd;
    public static final a Re;
    public static final a Rf;
    public static final a Rg;
    public static final a Rh;
    public static final a Ri;
    public static final a Rj;
    public static final a Rk;
    public static final a Rl;
    public static final a Rm;
    public static final a Rn;
    public static final a Ro;
    public static final a Rp;
    public static final a Rq;
    public static final a Rr;
    public static final a Rs;
    public static final a Rt;
    public static final a Ru;
    public static final a Rv;
    public static final a Rw;
    public static final a Rx;
    public static final a Ry;
    public static final a Rz;
    public final Object RK;
    
    static
    {
      Object localObject2 = null;
      Rd = new a(1);
      Re = new a(2);
      Rf = new a(4);
      Rg = new a(8);
      Rh = new a(16);
      Ri = new a(32);
      Rj = new a(64);
      Rk = new a(128);
      Rl = new a(256);
      Rm = new a(512);
      Rn = new a(1024);
      Ro = new a(2048);
      Rp = new a(4096);
      Rq = new a(8192);
      Rr = new a(16384);
      Rs = new a(32768);
      Rt = new a(65536);
      Ru = new a(131072);
      Rv = new a(262144);
      Rw = new a(524288);
      Rx = new a(1048576);
      Ry = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        Rz = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label532;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        RA = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label537;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        RB = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label542;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        RC = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label547;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        RD = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label552;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        RE = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label557;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label421:
        RF = new a(localObject1);
        if (Build.VERSION.SDK_INT < 24) {
          break label562;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label444:
        RG = new a(localObject1);
        if (Build.VERSION.SDK_INT < 26) {
          break label567;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label467:
        RH = new a(localObject1);
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
        RI = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        }
        RJ = new a(localObject1);
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
      this.RK = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object RL;
    
    public b(Object paramObject)
    {
      this.RL = paramObject;
    }
  }
  
  public static final class c
  {
    final Object RL;
    
    private c(Object paramObject)
    {
      this.RL = paramObject;
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