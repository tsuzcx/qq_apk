package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class c
{
  public final AccessibilityNodeInfo Op;
  public int Oq = -1;
  
  private c(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Op = paramAccessibilityNodeInfo;
  }
  
  public static c a(c paramc)
  {
    return a(AccessibilityNodeInfo.obtain(paramc.Op));
  }
  
  public static c a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new c(paramAccessibilityNodeInfo);
  }
  
  public final void E(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.Op;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).Pb)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.Op.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.Pa);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.Op.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.Op.addChild(paramView);
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
        if (this.Op != null) {
          break;
        }
      } while (paramObject.Op == null);
      return false;
    } while (this.Op.equals(paramObject.Op));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.Op.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.Op.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.Op == null) {
      return 0;
    }
    return this.Op.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Op.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Op.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Op.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.Op.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.Op.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.Op.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.Op.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.Op.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.Op.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.Op.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.Op.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.Op.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.Op.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.Op.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.Op.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.Op.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.Op.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.Op.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.Op.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Op.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Op.setVisibleToUser(paramBoolean);
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
    localStringBuilder1.append("; packageName: ").append(this.Op.getPackageName());
    localStringBuilder1.append("; className: ").append(this.Op.getClassName());
    localStringBuilder1.append("; text: ").append(this.Op.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.Op.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.Op.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.Op.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.Op.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.Op.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.Op.isFocused());
      localStringBuilder1.append("; selected: ").append(this.Op.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.Op.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.Op.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.Op.isEnabled());
      localStringBuilder1.append("; password: ").append(this.Op.isPassword());
      localStringBuilder1.append("; scrollable: " + this.Op.isScrollable());
      localStringBuilder1.append("; [");
      i = this.Op.getActions();
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
    public static final a OA;
    public static final a OB;
    public static final a OC;
    public static final a OD;
    public static final a OE;
    public static final a OF;
    public static final a OG;
    public static final a OH;
    public static final a OI;
    public static final a OJ;
    public static final a OL;
    public static final a OM;
    public static final a OO;
    public static final a OP;
    public static final a OQ;
    public static final a OR;
    public static final a OS;
    public static final a OT;
    public static final a OU;
    public static final a OV;
    public static final a OW;
    public static final a OX;
    public static final a OY;
    public static final a OZ;
    public static final a Or;
    public static final a Os;
    public static final a Ot;
    public static final a Ou;
    public static final a Ov;
    public static final a Ow;
    public static final a Ox;
    public static final a Oy;
    public static final a Oz;
    public final Object Pa;
    
    static
    {
      Object localObject2 = null;
      Or = new a(1);
      Os = new a(2);
      Ot = new a(4);
      Ou = new a(8);
      Ov = new a(16);
      Ow = new a(32);
      Ox = new a(64);
      Oy = new a(128);
      Oz = new a(256);
      OA = new a(512);
      OB = new a(1024);
      OC = new a(2048);
      OD = new a(4096);
      OE = new a(8192);
      OF = new a(16384);
      OG = new a(32768);
      OH = new a(65536);
      OI = new a(131072);
      OJ = new a(262144);
      OL = new a(524288);
      OM = new a(1048576);
      OO = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        OP = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label532;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        OQ = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label537;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        OR = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label542;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        OS = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label547;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        OT = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label552;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        OU = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label557;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label421:
        OV = new a(localObject1);
        if (Build.VERSION.SDK_INT < 24) {
          break label562;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label444:
        OW = new a(localObject1);
        if (Build.VERSION.SDK_INT < 26) {
          break label567;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label467:
        OX = new a(localObject1);
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
        OY = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        }
        OZ = new a(localObject1);
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
      this.Pa = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object Pb;
    
    public b(Object paramObject)
    {
      this.Pb = paramObject;
    }
  }
  
  public static final class c
  {
    final Object Pb;
    
    private c(Object paramObject)
    {
      this.Pb = paramObject;
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