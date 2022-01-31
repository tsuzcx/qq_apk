package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public final class a
{
  public final AccessibilityNodeInfo HJ;
  public int HK = -1;
  
  private a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.HJ = paramAccessibilityNodeInfo;
  }
  
  public static a a(a parama)
  {
    return a(AccessibilityNodeInfo.obtain(parama.HJ));
  }
  
  public static a a(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new a(paramAccessibilityNodeInfo);
  }
  
  public final void H(Object paramObject)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.HJ.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).Iq);
    }
  }
  
  public final boolean a(a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return this.HJ.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.Ip);
    }
    return false;
  }
  
  public final void addAction(int paramInt)
  {
    this.HJ.addAction(paramInt);
  }
  
  public final void addChild(View paramView)
  {
    this.HJ.addChild(paramView);
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
        paramObject = (a)paramObject;
        if (this.HJ != null) {
          break;
        }
      } while (paramObject.HJ == null);
      return false;
    } while (this.HJ.equals(paramObject.HJ));
    return false;
  }
  
  public final void getBoundsInParent(Rect paramRect)
  {
    this.HJ.getBoundsInParent(paramRect);
  }
  
  public final void getBoundsInScreen(Rect paramRect)
  {
    this.HJ.getBoundsInScreen(paramRect);
  }
  
  public final int hashCode()
  {
    if (this.HJ == null) {
      return 0;
    }
    return this.HJ.hashCode();
  }
  
  public final boolean isAccessibilityFocused()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.HJ.isAccessibilityFocused();
    }
    return false;
  }
  
  public final boolean isVisibleToUser()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return this.HJ.isVisibleToUser();
    }
    return false;
  }
  
  public final void setAccessibilityFocused(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.HJ.setAccessibilityFocused(paramBoolean);
    }
  }
  
  public final void setBoundsInParent(Rect paramRect)
  {
    this.HJ.setBoundsInParent(paramRect);
  }
  
  public final void setBoundsInScreen(Rect paramRect)
  {
    this.HJ.setBoundsInScreen(paramRect);
  }
  
  public final void setCheckable(boolean paramBoolean)
  {
    this.HJ.setCheckable(paramBoolean);
  }
  
  public final void setClassName(CharSequence paramCharSequence)
  {
    this.HJ.setClassName(paramCharSequence);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    this.HJ.setClickable(paramBoolean);
  }
  
  public final void setContentDescription(CharSequence paramCharSequence)
  {
    this.HJ.setContentDescription(paramCharSequence);
  }
  
  public final void setDismissable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      this.HJ.setDismissable(paramBoolean);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    this.HJ.setEnabled(paramBoolean);
  }
  
  public final void setFocusable(boolean paramBoolean)
  {
    this.HJ.setFocusable(paramBoolean);
  }
  
  public final void setFocused(boolean paramBoolean)
  {
    this.HJ.setFocused(paramBoolean);
  }
  
  public final void setLongClickable(boolean paramBoolean)
  {
    this.HJ.setLongClickable(paramBoolean);
  }
  
  public final void setPackageName(CharSequence paramCharSequence)
  {
    this.HJ.setPackageName(paramCharSequence);
  }
  
  public final void setParent(View paramView)
  {
    this.HJ.setParent(paramView);
  }
  
  public final void setScrollable(boolean paramBoolean)
  {
    this.HJ.setScrollable(paramBoolean);
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    this.HJ.setSelected(paramBoolean);
  }
  
  public final void setSource(View paramView)
  {
    this.HJ.setSource(paramView);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.HJ.setText(paramCharSequence);
  }
  
  public final void setVisibleToUser(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.HJ.setVisibleToUser(paramBoolean);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    localStringBuilder1.append("; boundsInParent: " + localObject);
    getBoundsInScreen((Rect)localObject);
    localStringBuilder1.append("; boundsInScreen: " + localObject);
    localStringBuilder1.append("; packageName: ").append(this.HJ.getPackageName());
    localStringBuilder1.append("; className: ").append(this.HJ.getClassName());
    localStringBuilder1.append("; text: ").append(this.HJ.getText());
    localStringBuilder1.append("; contentDescription: ").append(this.HJ.getContentDescription());
    StringBuilder localStringBuilder2 = localStringBuilder1.append("; viewId: ");
    int i;
    if (Build.VERSION.SDK_INT >= 18)
    {
      localObject = this.HJ.getViewIdResourceName();
      localStringBuilder2.append((String)localObject);
      localStringBuilder1.append("; checkable: ").append(this.HJ.isCheckable());
      localStringBuilder1.append("; checked: ").append(this.HJ.isChecked());
      localStringBuilder1.append("; focusable: ").append(this.HJ.isFocusable());
      localStringBuilder1.append("; focused: ").append(this.HJ.isFocused());
      localStringBuilder1.append("; selected: ").append(this.HJ.isSelected());
      localStringBuilder1.append("; clickable: ").append(this.HJ.isClickable());
      localStringBuilder1.append("; longClickable: ").append(this.HJ.isLongClickable());
      localStringBuilder1.append("; enabled: ").append(this.HJ.isEnabled());
      localStringBuilder1.append("; password: ").append(this.HJ.isPassword());
      localStringBuilder1.append("; scrollable: " + this.HJ.isScrollable());
      localStringBuilder1.append("; [");
      i = this.HJ.getActions();
      label394:
      if (i == 0) {
        break label726;
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
      break label394;
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
    label726:
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public static final class a
  {
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
    public static final a HZ;
    public static final a Ia;
    public static final a Ib;
    public static final a Ic;
    public static final a Id;
    public static final a Ie;
    public static final a If;
    public static final a Ig;
    public static final a Ih;
    public static final a Ii;
    public static final a Ij;
    public static final a Ik;
    public static final a Il;
    public static final a Im;
    public static final a In;
    public static final a Io;
    final Object Ip;
    
    static
    {
      Object localObject2 = null;
      HL = new a(1);
      HM = new a(2);
      HN = new a(4);
      HO = new a(8);
      HP = new a(16);
      HQ = new a(32);
      HR = new a(64);
      HS = new a(128);
      HT = new a(256);
      HU = new a(512);
      HV = new a(1024);
      HW = new a(2048);
      HX = new a(4096);
      HY = new a(8192);
      HZ = new a(16384);
      Ia = new a(32768);
      Ib = new a(65536);
      Ic = new a(131072);
      Id = new a(262144);
      Ie = new a(524288);
      If = new a(1048576);
      Ig = new a(2097152);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        Ih = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label463;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        label306:
        Ii = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label468;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        label329:
        Ij = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label473;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        label352:
        Ik = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label478;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        label375:
        Il = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label483;
        }
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        label398:
        Im = new a(localObject1);
        if (Build.VERSION.SDK_INT < 23) {
          break label488;
        }
      }
      label463:
      label468:
      label473:
      label478:
      label483:
      label488:
      for (Object localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;; localObject1 = null)
      {
        In = new a(localObject1);
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 24) {
          localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        }
        Io = new a(localObject1);
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
      }
    }
    
    private a(int paramInt) {}
    
    private a(Object paramObject)
    {
      this.Ip = paramObject;
    }
  }
  
  public static final class b
  {
    public final Object Iq;
    
    public b(Object paramObject)
    {
      this.Iq = paramObject;
    }
  }
  
  public static final class c
  {
    final Object Iq;
    
    private c(Object paramObject)
    {
      this.Iq = paramObject;
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
 * Qualified Name:     android.support.v4.view.a.a
 * JD-Core Version:    0.7.0.1
 */