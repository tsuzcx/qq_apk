package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class c
{
  public final AccessibilityNodeInfo Ro;
  public int Rp = -1;
  
  private c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Ro = paramAccessibilityNodeInfo;
  }
  
  public static c a(c paramc)
  {
    return a(AccessibilityNodeInfo.obtain(paramc.Ro));
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
      localAccessibilityNodeInfo = this.Ro;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).RY)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.Ro.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.RX);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.Ro.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.Ro.addChild(paramView);
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
        if (this.Ro != null) {
          break;
        }
      } while (paramObject.Ro == null);
      return false;
    } while (this.Ro.equals(paramObject.Ro));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.Ro.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.Ro.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.Ro == null) {
      return 0;
    }
    return this.Ro.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Ro.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Ro.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Ro.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.Ro.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.Ro.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.Ro.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.Ro.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.Ro.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.Ro.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.Ro.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.Ro.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.Ro.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.Ro.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.Ro.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.Ro.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.Ro.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.Ro.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.Ro.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.Ro.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Ro.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Ro.setVisibleToUser(paramBoolean);
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
    localStringBuilder1.append("; packageName: ").append(this.Ro.getPackageName());
    localStringBuilder1.append("; className: ").append(this.Ro.getClassName());
    localStringBuilder1.append("; text: ").append(this.Ro.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.Ro.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.Ro.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.Ro.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.Ro.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.Ro.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.Ro.isFocused());
      localStringBuilder1.append("; selected: ").append(this.Ro.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.Ro.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.Ro.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.Ro.isEnabled());
      localStringBuilder1.append("; password: ").append(this.Ro.isPassword());
      localStringBuilder1.append("; scrollable: " + this.Ro.isScrollable());
      localStringBuilder1.append("; [");
      i = this.Ro.getActions();
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
    public static final a RK;
    public static final a RL;
    public static final a RM;
    public static final a RN;
    public static final a RO;
    public static final a RP;
    public static final a RQ;
    public static final a RR;
    public static final a RS;
    public static final a RT;
    public static final a RU;
    public static final a RV;
    public static final a RW;
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
    public final Object RX;
    
    static
    {
      Object localObject2 = null;
      Rq = new a(1);
      Rr = new a(2);
      Rs = new a(4);
      Rt = new a(8);
      Ru = new a(16);
      Rv = new a(32);
      Rw = new a(64);
      Rx = new a(128);
      Ry = new a(256);
      Rz = new a(512);
      RA = new a(1024);
      RB = new a(2048);
      RC = new a(4096);
      RD = new a(8192);
      RE = new a(16384);
      RF = new a(32768);
      RG = new a(65536);
      RH = new a(131072);
      RI = new a(262144);
      RJ = new a(524288);
      RK = new a(1048576);
      RL = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        RM = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label532;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        RN = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label537;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        RO = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label542;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        RP = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label547;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        RQ = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label552;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        RR = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label557;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label421:
        RS = new a(localObject1);
        if (Build.VERSION.SDK_INT < 24) {
          break label562;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label444:
        RT = new a(localObject1);
        if (Build.VERSION.SDK_INT < 26) {
          break label567;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label467:
        RU = new a(localObject1);
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
        RV = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        }
        RW = new a(localObject1);
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
      this.RX = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object RY;
    
    public b(Object paramObject)
    {
      this.RY = paramObject;
    }
  }
  
  public static final class c
  {
    final Object RY;
    
    private c(Object paramObject)
    {
      this.RY = paramObject;
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