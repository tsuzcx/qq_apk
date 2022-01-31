package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class b
{
  public final AccessibilityNodeInfo Hq;
  public int Hr = -1;
  
  private b(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.Hq = paramAccessibilityNodeInfo;
  }
  
  public static b a(b paramb)
  {
    return a(AccessibilityNodeInfo.obtain(paramb.Hq));
  }
  
  public static b a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new b(paramAccessibilityNodeInfo);
  }
  
  public final void F(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo;
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAccessibilityNodeInfo = this.Hq;
      if (paramObject != null) {
        break label25;
      }
    }
    label25:
    for (paramObject = null;; paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).Ia)
    {
      localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.Hq.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.HZ);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.Hq.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.Hq.addChild(paramView);
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
        paramObject = (b)paramObject;
        if (this.Hq != null) {
          break;
        }
      } while (paramObject.Hq == null);
      return false;
    } while (this.Hq.equals(paramObject.Hq));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.Hq.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.Hq.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.Hq == null) {
      return 0;
    }
    return this.Hq.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Hq.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.Hq.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Hq.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.Hq.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.Hq.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.Hq.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.Hq.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.Hq.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.Hq.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.Hq.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.Hq.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.Hq.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.Hq.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.Hq.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.Hq.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.Hq.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.Hq.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.Hq.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.Hq.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Hq.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.Hq.setVisibleToUser(paramBoolean);
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
    localStringBuilder1.append("; packageName: ").append(this.Hq.getPackageName());
    localStringBuilder1.append("; className: ").append(this.Hq.getClassName());
    localStringBuilder1.append("; text: ").append(this.Hq.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.Hq.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.Hq.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.Hq.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.Hq.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.Hq.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.Hq.isFocused());
      localStringBuilder1.append("; selected: ").append(this.Hq.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.Hq.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.Hq.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.Hq.isEnabled());
      localStringBuilder1.append("; password: ").append(this.Hq.isPassword());
      localStringBuilder1.append("; scrollable: " + this.Hq.isScrollable());
      localStringBuilder1.append("; [");
      i = this.Hq.getActions();
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
    public static final a HA;
    public static final a HB;
    public static final a HC;
    public static final a HD;
    public static final a HE;
    public static final a HF;
    public static final a HG;
    public static final a HH;
    public static final a HI;
    public static final a HJ;
    public static final a HK;
    public static final a HL;
    public static final a HM;
    public static final a HN;
    public static final a HO;
    public static final a HP;
    public static final a HQ;
    public static final a HR;
    public static final a HS;
    public static final a HT;
    public static final a HU;
    public static final a HV;
    public static final a HW;
    public static final a HX;
    public static final a HY;
    public static final a Hs;
    public static final a Ht;
    public static final a Hu;
    public static final a Hv;
    public static final a Hw;
    public static final a Hx;
    public static final a Hy;
    public static final a Hz;
    final Object HZ;
    
    static
    {
      Object localObject2 = null;
      Hs = new a(1);
      Ht = new a(2);
      Hu = new a(4);
      Hv = new a(8);
      Hw = new a(16);
      Hx = new a(32);
      Hy = new a(64);
      Hz = new a(128);
      HA = new a(256);
      HB = new a(512);
      HC = new a(1024);
      HD = new a(2048);
      HE = new a(4096);
      HF = new a(8192);
      HG = new a(16384);
      HH = new a(32768);
      HI = new a(65536);
      HJ = new a(131072);
      HK = new a(262144);
      HL = new a(524288);
      HM = new a(1048576);
      HN = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        HO = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label532;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        HP = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label537;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        HQ = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label542;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        HR = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label547;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        HS = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label552;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        HT = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label557;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        label421:
        HU = new a(localObject1);
        if (Build.VERSION.SDK_INT < 24) {
          break label562;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        label444:
        HV = new a(localObject1);
        if (Build.VERSION.SDK_INT < 26) {
          break label567;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        label467:
        HW = new a(localObject1);
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
        HX = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 28) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        }
        HY = new a(localObject1);
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
      this.HZ = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object Ia;
    
    public b(Object paramObject)
    {
      this.Ia = paramObject;
    }
  }
  
  public static final class c
  {
    final Object Ia;
    
    private c(Object paramObject)
    {
      this.Ia = paramObject;
    }
    
    public static c b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
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
 * Qualified Name:     android.support.v4.view.a.b
 * JD-Core Version:    0.7.0.1
 */