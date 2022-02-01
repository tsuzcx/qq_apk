package com.pay.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class APAccessibilityNodeInfoCompat
{
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  public static final int ACTION_CLEAR_FOCUS = 2;
  public static final int ACTION_CLEAR_SELECTION = 8;
  public static final int ACTION_CLICK = 16;
  public static final int ACTION_COPY = 16384;
  public static final int ACTION_CUT = 65536;
  public static final int ACTION_FOCUS = 1;
  public static final int ACTION_LONG_CLICK = 32;
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  public static final int ACTION_PASTE = 32768;
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  public static final int ACTION_SCROLL_FORWARD = 4096;
  public static final int ACTION_SELECT = 4;
  public static final int ACTION_SET_SELECTION = 131072;
  public static final int FOCUS_ACCESSIBILITY = 2;
  public static final int FOCUS_INPUT = 1;
  public static final AccessibilityNodeInfoImpl IMPL = new AccessibilityNodeInfoStubImpl();
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  public final Object mInfo;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 19)
    {
      IMPL = new AccessibilityNodeInfoKitKatImpl();
      return;
    }
    if (i >= 18)
    {
      IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
      return;
    }
    if (i >= 16)
    {
      IMPL = new AccessibilityNodeInfoJellybeanImpl();
      return;
    }
    if (i >= 14)
    {
      IMPL = new AccessibilityNodeInfoIcsImpl();
      return;
    }
  }
  
  public APAccessibilityNodeInfoCompat(Object paramObject)
  {
    this.mInfo = paramObject;
  }
  
  public static String getActionSymbolicName(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          return "ACTION_UNKNOWN";
        case 131072: 
          return "ACTION_SET_SELECTION";
        case 65536: 
          return "ACTION_CUT";
        case 32768: 
          return "ACTION_PASTE";
        case 16384: 
          return "ACTION_COPY";
        case 8192: 
          return "ACTION_SCROLL_BACKWARD";
        case 4096: 
          return "ACTION_SCROLL_FORWARD";
        case 2048: 
          return "ACTION_PREVIOUS_HTML_ELEMENT";
        case 1024: 
          return "ACTION_NEXT_HTML_ELEMENT";
        case 512: 
          return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        case 256: 
          return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        case 128: 
          return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        case 64: 
          return "ACTION_ACCESSIBILITY_FOCUS";
        case 32: 
          return "ACTION_LONG_CLICK";
        case 16: 
          return "ACTION_CLICK";
        case 8: 
          return "ACTION_CLEAR_SELECTION";
        }
        return "ACTION_SELECT";
      }
      return "ACTION_CLEAR_FOCUS";
    }
    return "ACTION_FOCUS";
  }
  
  public static APAccessibilityNodeInfoCompat obtain()
  {
    return wrapNonNullInstance(IMPL.obtain());
  }
  
  public static APAccessibilityNodeInfoCompat obtain(View paramView)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView));
  }
  
  public static APAccessibilityNodeInfoCompat obtain(View paramView, int paramInt)
  {
    return wrapNonNullInstance(IMPL.obtain(paramView, paramInt));
  }
  
  public static APAccessibilityNodeInfoCompat obtain(APAccessibilityNodeInfoCompat paramAPAccessibilityNodeInfoCompat)
  {
    return wrapNonNullInstance(IMPL.obtain(paramAPAccessibilityNodeInfoCompat.mInfo));
  }
  
  public static APAccessibilityNodeInfoCompat wrapNonNullInstance(Object paramObject)
  {
    if (paramObject != null) {
      return new APAccessibilityNodeInfoCompat(paramObject);
    }
    return null;
  }
  
  public void addAction(int paramInt)
  {
    IMPL.addAction(this.mInfo, paramInt);
  }
  
  public void addChild(View paramView)
  {
    IMPL.addChild(this.mInfo, paramView);
  }
  
  public void addChild(View paramView, int paramInt)
  {
    IMPL.addChild(this.mInfo, paramView, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (APAccessibilityNodeInfoCompat.class != paramObject.getClass()) {
      return false;
    }
    paramObject = (APAccessibilityNodeInfoCompat)paramObject;
    Object localObject = this.mInfo;
    if (localObject == null)
    {
      if (paramObject.mInfo != null) {
        return false;
      }
    }
    else if (!localObject.equals(paramObject.mInfo)) {
      return false;
    }
    return true;
  }
  
  public List<APAccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = IMPL.findAccessibilityNodeInfosByText(this.mInfo, paramString);
    int j = paramString.size();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new APAccessibilityNodeInfoCompat(paramString.get(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public APAccessibilityNodeInfoCompat findFocus(int paramInt)
  {
    return wrapNonNullInstance(IMPL.findFocus(this.mInfo, paramInt));
  }
  
  public APAccessibilityNodeInfoCompat focusSearch(int paramInt)
  {
    return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, paramInt));
  }
  
  public int getActions()
  {
    return IMPL.getActions(this.mInfo);
  }
  
  public void getBoundsInParent(Rect paramRect)
  {
    IMPL.getBoundsInParent(this.mInfo, paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect)
  {
    IMPL.getBoundsInScreen(this.mInfo, paramRect);
  }
  
  public APAccessibilityNodeInfoCompat getChild(int paramInt)
  {
    return wrapNonNullInstance(IMPL.getChild(this.mInfo, paramInt));
  }
  
  public int getChildCount()
  {
    return IMPL.getChildCount(this.mInfo);
  }
  
  public CharSequence getClassName()
  {
    return IMPL.getClassName(this.mInfo);
  }
  
  public CharSequence getContentDescription()
  {
    return IMPL.getContentDescription(this.mInfo);
  }
  
  public Object getInfo()
  {
    return this.mInfo;
  }
  
  public int getLiveRegion()
  {
    return IMPL.getLiveRegion(this.mInfo);
  }
  
  public int getMovementGranularities()
  {
    return IMPL.getMovementGranularities(this.mInfo);
  }
  
  public CharSequence getPackageName()
  {
    return IMPL.getPackageName(this.mInfo);
  }
  
  public APAccessibilityNodeInfoCompat getParent()
  {
    return wrapNonNullInstance(IMPL.getParent(this.mInfo));
  }
  
  public CharSequence getText()
  {
    return IMPL.getText(this.mInfo);
  }
  
  public String getViewIdResourceName()
  {
    return IMPL.getViewIdResourceName(this.mInfo);
  }
  
  public int getWindowId()
  {
    return IMPL.getWindowId(this.mInfo);
  }
  
  public int hashCode()
  {
    Object localObject = this.mInfo;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public boolean isAccessibilityFocused()
  {
    return IMPL.isAccessibilityFocused(this.mInfo);
  }
  
  public boolean isCheckable()
  {
    return IMPL.isCheckable(this.mInfo);
  }
  
  public boolean isChecked()
  {
    return IMPL.isChecked(this.mInfo);
  }
  
  public boolean isClickable()
  {
    return IMPL.isClickable(this.mInfo);
  }
  
  public boolean isEnabled()
  {
    return IMPL.isEnabled(this.mInfo);
  }
  
  public boolean isFocusable()
  {
    return IMPL.isFocusable(this.mInfo);
  }
  
  public boolean isFocused()
  {
    return IMPL.isFocused(this.mInfo);
  }
  
  public boolean isLongClickable()
  {
    return IMPL.isLongClickable(this.mInfo);
  }
  
  public boolean isPassword()
  {
    return IMPL.isPassword(this.mInfo);
  }
  
  public boolean isScrollable()
  {
    return IMPL.isScrollable(this.mInfo);
  }
  
  public boolean isSelected()
  {
    return IMPL.isSelected(this.mInfo);
  }
  
  public boolean isVisibleToUser()
  {
    return IMPL.isVisibleToUser(this.mInfo);
  }
  
  public boolean performAction(int paramInt)
  {
    return IMPL.performAction(this.mInfo, paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle)
  {
    return IMPL.performAction(this.mInfo, paramInt, paramBundle);
  }
  
  public void recycle()
  {
    IMPL.recycle(this.mInfo);
  }
  
  public void setAccessibilityFocused(boolean paramBoolean)
  {
    IMPL.setAccessibilityFocused(this.mInfo, paramBoolean);
  }
  
  public void setBoundsInParent(Rect paramRect)
  {
    IMPL.setBoundsInParent(this.mInfo, paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect)
  {
    IMPL.setBoundsInScreen(this.mInfo, paramRect);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    IMPL.setCheckable(this.mInfo, paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    IMPL.setChecked(this.mInfo, paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence)
  {
    IMPL.setClassName(this.mInfo, paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean)
  {
    IMPL.setClickable(this.mInfo, paramBoolean);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    IMPL.setContentDescription(this.mInfo, paramCharSequence);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    IMPL.setEnabled(this.mInfo, paramBoolean);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    IMPL.setFocusable(this.mInfo, paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean)
  {
    IMPL.setFocused(this.mInfo, paramBoolean);
  }
  
  public void setLiveRegion(int paramInt)
  {
    IMPL.setLiveRegion(this.mInfo, paramInt);
  }
  
  public void setLongClickable(boolean paramBoolean)
  {
    IMPL.setLongClickable(this.mInfo, paramBoolean);
  }
  
  public void setMovementGranularities(int paramInt)
  {
    IMPL.setMovementGranularities(this.mInfo, paramInt);
  }
  
  public void setPackageName(CharSequence paramCharSequence)
  {
    IMPL.setPackageName(this.mInfo, paramCharSequence);
  }
  
  public void setParent(View paramView)
  {
    IMPL.setParent(this.mInfo, paramView);
  }
  
  public void setParent(View paramView, int paramInt)
  {
    IMPL.setParent(this.mInfo, paramView, paramInt);
  }
  
  public void setPassword(boolean paramBoolean)
  {
    IMPL.setPassword(this.mInfo, paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    IMPL.setScrollable(this.mInfo, paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    IMPL.setSelected(this.mInfo, paramBoolean);
  }
  
  public void setSource(View paramView)
  {
    IMPL.setSource(this.mInfo, paramView);
  }
  
  public void setSource(View paramView, int paramInt)
  {
    IMPL.setSource(this.mInfo, paramView, paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    IMPL.setText(this.mInfo, paramCharSequence);
  }
  
  public void setViewIdResourceName(String paramString)
  {
    IMPL.setViewIdResourceName(this.mInfo, paramString);
  }
  
  public void setVisibleToUser(boolean paramBoolean)
  {
    IMPL.setVisibleToUser(this.mInfo, paramBoolean);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(super.toString());
    Object localObject = new Rect();
    getBoundsInParent((Rect)localObject);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInParent: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    getBoundsInScreen((Rect)localObject);
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("; boundsInScreen: ");
    localStringBuilder2.append(localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("; packageName: ");
    localStringBuilder1.append(getPackageName());
    localStringBuilder1.append("; className: ");
    localStringBuilder1.append(getClassName());
    localStringBuilder1.append("; text: ");
    localStringBuilder1.append(getText());
    localStringBuilder1.append("; contentDescription: ");
    localStringBuilder1.append(getContentDescription());
    localStringBuilder1.append("; viewId: ");
    localStringBuilder1.append(getViewIdResourceName());
    localStringBuilder1.append("; checkable: ");
    localStringBuilder1.append(isCheckable());
    localStringBuilder1.append("; checked: ");
    localStringBuilder1.append(isChecked());
    localStringBuilder1.append("; focusable: ");
    localStringBuilder1.append(isFocusable());
    localStringBuilder1.append("; focused: ");
    localStringBuilder1.append(isFocused());
    localStringBuilder1.append("; selected: ");
    localStringBuilder1.append(isSelected());
    localStringBuilder1.append("; clickable: ");
    localStringBuilder1.append(isClickable());
    localStringBuilder1.append("; longClickable: ");
    localStringBuilder1.append(isLongClickable());
    localStringBuilder1.append("; enabled: ");
    localStringBuilder1.append(isEnabled());
    localStringBuilder1.append("; password: ");
    localStringBuilder1.append(isPassword());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("; scrollable: ");
    ((StringBuilder)localObject).append(isScrollable());
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localStringBuilder1.append("; [");
    int i = getActions();
    while (i != 0)
    {
      int k = 1 << Integer.numberOfTrailingZeros(i);
      int j = i & (k ^ 0xFFFFFFFF);
      localStringBuilder1.append(getActionSymbolicName(k));
      i = j;
      if (j != 0)
      {
        localStringBuilder1.append(", ");
        i = j;
      }
    }
    localStringBuilder1.append("]");
    return localStringBuilder1.toString();
  }
  
  public static class AccessibilityNodeInfoIcsImpl
    extends APAccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl
  {
    public void addAction(Object paramObject, int paramInt)
    {
      APAccessibilityNodeInfoCompatIcs.addAction(paramObject, paramInt);
    }
    
    public void addChild(Object paramObject, View paramView)
    {
      APAccessibilityNodeInfoCompatIcs.addChild(paramObject, paramView);
    }
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return APAccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(paramObject, paramString);
    }
    
    public int getActions(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getActions(paramObject);
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect)
    {
      APAccessibilityNodeInfoCompatIcs.getBoundsInParent(paramObject, paramRect);
    }
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect)
    {
      APAccessibilityNodeInfoCompatIcs.getBoundsInScreen(paramObject, paramRect);
    }
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return APAccessibilityNodeInfoCompatIcs.getChild(paramObject, paramInt);
    }
    
    public int getChildCount(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getChildCount(paramObject);
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getClassName(paramObject);
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getContentDescription(paramObject);
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getPackageName(paramObject);
    }
    
    public Object getParent(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getParent(paramObject);
    }
    
    public CharSequence getText(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getText(paramObject);
    }
    
    public int getWindowId(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.getWindowId(paramObject);
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isCheckable(paramObject);
    }
    
    public boolean isChecked(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isChecked(paramObject);
    }
    
    public boolean isClickable(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isClickable(paramObject);
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isEnabled(paramObject);
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isFocusable(paramObject);
    }
    
    public boolean isFocused(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isFocused(paramObject);
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isLongClickable(paramObject);
    }
    
    public boolean isPassword(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isPassword(paramObject);
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isScrollable(paramObject);
    }
    
    public boolean isSelected(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.isSelected(paramObject);
    }
    
    public Object obtain()
    {
      return APAccessibilityNodeInfoCompatIcs.obtain();
    }
    
    public Object obtain(View paramView)
    {
      return APAccessibilityNodeInfoCompatIcs.obtain(paramView);
    }
    
    public Object obtain(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatIcs.obtain(paramObject);
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return APAccessibilityNodeInfoCompatIcs.performAction(paramObject, paramInt);
    }
    
    public void recycle(Object paramObject)
    {
      APAccessibilityNodeInfoCompatIcs.recycle(paramObject);
    }
    
    public void setBoundsInParent(Object paramObject, Rect paramRect)
    {
      APAccessibilityNodeInfoCompatIcs.setBoundsInParent(paramObject, paramRect);
    }
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect)
    {
      APAccessibilityNodeInfoCompatIcs.setBoundsInScreen(paramObject, paramRect);
    }
    
    public void setCheckable(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setCheckable(paramObject, paramBoolean);
    }
    
    public void setChecked(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setChecked(paramObject, paramBoolean);
    }
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence)
    {
      APAccessibilityNodeInfoCompatIcs.setClassName(paramObject, paramCharSequence);
    }
    
    public void setClickable(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setClickable(paramObject, paramBoolean);
    }
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence)
    {
      APAccessibilityNodeInfoCompatIcs.setContentDescription(paramObject, paramCharSequence);
    }
    
    public void setEnabled(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setEnabled(paramObject, paramBoolean);
    }
    
    public void setFocusable(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setFocusable(paramObject, paramBoolean);
    }
    
    public void setFocused(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setFocused(paramObject, paramBoolean);
    }
    
    public void setLongClickable(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setLongClickable(paramObject, paramBoolean);
    }
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence)
    {
      APAccessibilityNodeInfoCompatIcs.setPackageName(paramObject, paramCharSequence);
    }
    
    public void setParent(Object paramObject, View paramView)
    {
      APAccessibilityNodeInfoCompatIcs.setParent(paramObject, paramView);
    }
    
    public void setPassword(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setPassword(paramObject, paramBoolean);
    }
    
    public void setScrollable(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setScrollable(paramObject, paramBoolean);
    }
    
    public void setSelected(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatIcs.setSelected(paramObject, paramBoolean);
    }
    
    public void setSource(Object paramObject, View paramView)
    {
      APAccessibilityNodeInfoCompatIcs.setSource(paramObject, paramView);
    }
    
    public void setText(Object paramObject, CharSequence paramCharSequence)
    {
      APAccessibilityNodeInfoCompatIcs.setText(paramObject, paramCharSequence);
    }
  }
  
  public static abstract interface AccessibilityNodeInfoImpl
  {
    public abstract void addAction(Object paramObject, int paramInt);
    
    public abstract void addChild(Object paramObject, View paramView);
    
    public abstract void addChild(Object paramObject, View paramView, int paramInt);
    
    public abstract List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString);
    
    public abstract Object findFocus(Object paramObject, int paramInt);
    
    public abstract Object focusSearch(Object paramObject, int paramInt);
    
    public abstract int getActions(Object paramObject);
    
    public abstract void getBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void getBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract Object getChild(Object paramObject, int paramInt);
    
    public abstract int getChildCount(Object paramObject);
    
    public abstract CharSequence getClassName(Object paramObject);
    
    public abstract CharSequence getContentDescription(Object paramObject);
    
    public abstract int getLiveRegion(Object paramObject);
    
    public abstract int getMovementGranularities(Object paramObject);
    
    public abstract CharSequence getPackageName(Object paramObject);
    
    public abstract Object getParent(Object paramObject);
    
    public abstract CharSequence getText(Object paramObject);
    
    public abstract String getViewIdResourceName(Object paramObject);
    
    public abstract int getWindowId(Object paramObject);
    
    public abstract boolean isAccessibilityFocused(Object paramObject);
    
    public abstract boolean isCheckable(Object paramObject);
    
    public abstract boolean isChecked(Object paramObject);
    
    public abstract boolean isClickable(Object paramObject);
    
    public abstract boolean isEnabled(Object paramObject);
    
    public abstract boolean isFocusable(Object paramObject);
    
    public abstract boolean isFocused(Object paramObject);
    
    public abstract boolean isLongClickable(Object paramObject);
    
    public abstract boolean isPassword(Object paramObject);
    
    public abstract boolean isScrollable(Object paramObject);
    
    public abstract boolean isSelected(Object paramObject);
    
    public abstract boolean isVisibleToUser(Object paramObject);
    
    public abstract Object obtain();
    
    public abstract Object obtain(View paramView);
    
    public abstract Object obtain(View paramView, int paramInt);
    
    public abstract Object obtain(Object paramObject);
    
    public abstract boolean performAction(Object paramObject, int paramInt);
    
    public abstract boolean performAction(Object paramObject, int paramInt, Bundle paramBundle);
    
    public abstract void recycle(Object paramObject);
    
    public abstract void setAccessibilityFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setBoundsInParent(Object paramObject, Rect paramRect);
    
    public abstract void setBoundsInScreen(Object paramObject, Rect paramRect);
    
    public abstract void setCheckable(Object paramObject, boolean paramBoolean);
    
    public abstract void setChecked(Object paramObject, boolean paramBoolean);
    
    public abstract void setClassName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setContentDescription(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setEnabled(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocusable(Object paramObject, boolean paramBoolean);
    
    public abstract void setFocused(Object paramObject, boolean paramBoolean);
    
    public abstract void setLiveRegion(Object paramObject, int paramInt);
    
    public abstract void setLongClickable(Object paramObject, boolean paramBoolean);
    
    public abstract void setMovementGranularities(Object paramObject, int paramInt);
    
    public abstract void setPackageName(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setParent(Object paramObject, View paramView);
    
    public abstract void setParent(Object paramObject, View paramView, int paramInt);
    
    public abstract void setPassword(Object paramObject, boolean paramBoolean);
    
    public abstract void setScrollable(Object paramObject, boolean paramBoolean);
    
    public abstract void setSelected(Object paramObject, boolean paramBoolean);
    
    public abstract void setSource(Object paramObject, View paramView);
    
    public abstract void setSource(Object paramObject, View paramView, int paramInt);
    
    public abstract void setText(Object paramObject, CharSequence paramCharSequence);
    
    public abstract void setViewIdResourceName(Object paramObject, String paramString);
    
    public abstract void setVisibleToUser(Object paramObject, boolean paramBoolean);
  }
  
  public static class AccessibilityNodeInfoJellybeanImpl
    extends APAccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl
  {
    public void addChild(Object paramObject, View paramView, int paramInt)
    {
      APAccessibilityNodeInfoCompatJellyBean.addChild(paramObject, paramView, paramInt);
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return APAccessibilityNodeInfoCompatJellyBean.findFocus(paramObject, paramInt);
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return APAccessibilityNodeInfoCompatJellyBean.focusSearch(paramObject, paramInt);
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatJellyBean.getMovementGranularities(paramObject);
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(paramObject);
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatJellyBean.isVisibleToUser(paramObject);
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return APAccessibilityNodeInfoCompatJellyBean.obtain(paramView, paramInt);
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return APAccessibilityNodeInfoCompatJellyBean.performAction(paramObject, paramInt, paramBundle);
    }
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(paramObject, paramBoolean);
    }
    
    public void setMovementGranularities(Object paramObject, int paramInt)
    {
      APAccessibilityNodeInfoCompatJellyBean.setMovementGranularities(paramObject, paramInt);
    }
    
    public void setParent(Object paramObject, View paramView, int paramInt)
    {
      APAccessibilityNodeInfoCompatJellyBean.setParent(paramObject, paramView, paramInt);
    }
    
    public void setSource(Object paramObject, View paramView, int paramInt)
    {
      APAccessibilityNodeInfoCompatJellyBean.setSource(paramObject, paramView, paramInt);
    }
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean)
    {
      APAccessibilityNodeInfoCompatJellyBean.setVisibleToUser(paramObject, paramBoolean);
    }
  }
  
  public static class AccessibilityNodeInfoJellybeanMr2Impl
    extends APAccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl
  {
    public String getViewIdResourceName(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(paramObject);
    }
    
    public void setViewIdResourceName(Object paramObject, String paramString)
    {
      APAccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(paramObject, paramString);
    }
  }
  
  public static class AccessibilityNodeInfoKitKatImpl
    extends APAccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl
  {
    public int getLiveRegion(Object paramObject)
    {
      return APAccessibilityNodeInfoCompatKitKat.getLiveRegion(paramObject);
    }
    
    public void setLiveRegion(Object paramObject, int paramInt)
    {
      APAccessibilityNodeInfoCompatKitKat.setLiveRegion(paramObject, paramInt);
    }
  }
  
  public static class AccessibilityNodeInfoStubImpl
    implements APAccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl
  {
    public void addAction(Object paramObject, int paramInt) {}
    
    public void addChild(Object paramObject, View paramView) {}
    
    public void addChild(Object paramObject, View paramView, int paramInt) {}
    
    public List<Object> findAccessibilityNodeInfosByText(Object paramObject, String paramString)
    {
      return Collections.emptyList();
    }
    
    public Object findFocus(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public Object focusSearch(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getActions(Object paramObject)
    {
      return 0;
    }
    
    public void getBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void getBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public Object getChild(Object paramObject, int paramInt)
    {
      return null;
    }
    
    public int getChildCount(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getClassName(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getContentDescription(Object paramObject)
    {
      return null;
    }
    
    public int getLiveRegion(Object paramObject)
    {
      return 0;
    }
    
    public int getMovementGranularities(Object paramObject)
    {
      return 0;
    }
    
    public CharSequence getPackageName(Object paramObject)
    {
      return null;
    }
    
    public Object getParent(Object paramObject)
    {
      return null;
    }
    
    public CharSequence getText(Object paramObject)
    {
      return null;
    }
    
    public String getViewIdResourceName(Object paramObject)
    {
      return null;
    }
    
    public int getWindowId(Object paramObject)
    {
      return 0;
    }
    
    public boolean isAccessibilityFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isCheckable(Object paramObject)
    {
      return false;
    }
    
    public boolean isChecked(Object paramObject)
    {
      return false;
    }
    
    public boolean isClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isEnabled(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocusable(Object paramObject)
    {
      return false;
    }
    
    public boolean isFocused(Object paramObject)
    {
      return false;
    }
    
    public boolean isLongClickable(Object paramObject)
    {
      return false;
    }
    
    public boolean isPassword(Object paramObject)
    {
      return false;
    }
    
    public boolean isScrollable(Object paramObject)
    {
      return false;
    }
    
    public boolean isSelected(Object paramObject)
    {
      return false;
    }
    
    public boolean isVisibleToUser(Object paramObject)
    {
      return false;
    }
    
    public Object obtain()
    {
      return null;
    }
    
    public Object obtain(View paramView)
    {
      return null;
    }
    
    public Object obtain(View paramView, int paramInt)
    {
      return null;
    }
    
    public Object obtain(Object paramObject)
    {
      return null;
    }
    
    public boolean performAction(Object paramObject, int paramInt)
    {
      return false;
    }
    
    public boolean performAction(Object paramObject, int paramInt, Bundle paramBundle)
    {
      return false;
    }
    
    public void recycle(Object paramObject) {}
    
    public void setAccessibilityFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setBoundsInParent(Object paramObject, Rect paramRect) {}
    
    public void setBoundsInScreen(Object paramObject, Rect paramRect) {}
    
    public void setCheckable(Object paramObject, boolean paramBoolean) {}
    
    public void setChecked(Object paramObject, boolean paramBoolean) {}
    
    public void setClassName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setContentDescription(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setEnabled(Object paramObject, boolean paramBoolean) {}
    
    public void setFocusable(Object paramObject, boolean paramBoolean) {}
    
    public void setFocused(Object paramObject, boolean paramBoolean) {}
    
    public void setLiveRegion(Object paramObject, int paramInt) {}
    
    public void setLongClickable(Object paramObject, boolean paramBoolean) {}
    
    public void setMovementGranularities(Object paramObject, int paramInt) {}
    
    public void setPackageName(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setParent(Object paramObject, View paramView) {}
    
    public void setParent(Object paramObject, View paramView, int paramInt) {}
    
    public void setPassword(Object paramObject, boolean paramBoolean) {}
    
    public void setScrollable(Object paramObject, boolean paramBoolean) {}
    
    public void setSelected(Object paramObject, boolean paramBoolean) {}
    
    public void setSource(Object paramObject, View paramView) {}
    
    public void setSource(Object paramObject, View paramView, int paramInt) {}
    
    public void setText(Object paramObject, CharSequence paramCharSequence) {}
    
    public void setViewIdResourceName(Object paramObject, String paramString) {}
    
    public void setVisibleToUser(Object paramObject, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.v4.view.accessibility.APAccessibilityNodeInfoCompat
 * JD-Core Version:    0.7.0.1
 */