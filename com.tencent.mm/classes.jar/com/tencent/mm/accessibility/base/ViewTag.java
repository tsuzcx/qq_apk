package com.tencent.mm.accessibility.base;

import android.view.TouchDelegate;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/base/ViewTag;", "", "()V", "disableFocusFlag", "", "getDisableFocusFlag", "()Ljava/lang/Boolean;", "setDisableFocusFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "eBottom", "", "getEBottom", "()Ljava/lang/Integer;", "setEBottom", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "eLeft", "getELeft", "setELeft", "eRight", "getERight", "setERight", "eTop", "getETop", "setETop", "havenExpand", "getHavenExpand", "setHavenExpand", "havenInflate", "getHavenInflate", "setHavenInflate", "touchDelegate", "Ljava/lang/ref/WeakReference;", "Landroid/view/TouchDelegate;", "getTouchDelegate", "()Ljava/lang/ref/WeakReference;", "setTouchDelegate", "(Ljava/lang/ref/WeakReference;)V", "touchDelegateParent", "Landroid/view/ViewGroup;", "getTouchDelegateParent", "setTouchDelegateParent", "viewType", "", "getViewType", "()Ljava/lang/CharSequence;", "setViewType", "(Ljava/lang/CharSequence;)V", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ViewTag
{
  private Boolean disableFocusFlag;
  private Integer eBottom;
  private Integer eLeft;
  private Integer eRight;
  private Integer eTop;
  private Boolean havenExpand;
  private Boolean havenInflate;
  private WeakReference<TouchDelegate> touchDelegate;
  private WeakReference<ViewGroup> touchDelegateParent;
  private CharSequence viewType;
  
  public final Boolean getDisableFocusFlag()
  {
    return this.disableFocusFlag;
  }
  
  public final Integer getEBottom()
  {
    return this.eBottom;
  }
  
  public final Integer getELeft()
  {
    return this.eLeft;
  }
  
  public final Integer getERight()
  {
    return this.eRight;
  }
  
  public final Integer getETop()
  {
    return this.eTop;
  }
  
  public final Boolean getHavenExpand()
  {
    return this.havenExpand;
  }
  
  public final Boolean getHavenInflate()
  {
    return this.havenInflate;
  }
  
  public final WeakReference<TouchDelegate> getTouchDelegate()
  {
    return this.touchDelegate;
  }
  
  public final WeakReference<ViewGroup> getTouchDelegateParent()
  {
    return this.touchDelegateParent;
  }
  
  public final CharSequence getViewType()
  {
    return this.viewType;
  }
  
  public final void setDisableFocusFlag(Boolean paramBoolean)
  {
    this.disableFocusFlag = paramBoolean;
  }
  
  public final void setEBottom(Integer paramInteger)
  {
    this.eBottom = paramInteger;
  }
  
  public final void setELeft(Integer paramInteger)
  {
    this.eLeft = paramInteger;
  }
  
  public final void setERight(Integer paramInteger)
  {
    this.eRight = paramInteger;
  }
  
  public final void setETop(Integer paramInteger)
  {
    this.eTop = paramInteger;
  }
  
  public final void setHavenExpand(Boolean paramBoolean)
  {
    this.havenExpand = paramBoolean;
  }
  
  public final void setHavenInflate(Boolean paramBoolean)
  {
    this.havenInflate = paramBoolean;
  }
  
  public final void setTouchDelegate(WeakReference<TouchDelegate> paramWeakReference)
  {
    this.touchDelegate = paramWeakReference;
  }
  
  public final void setTouchDelegateParent(WeakReference<ViewGroup> paramWeakReference)
  {
    this.touchDelegateParent = paramWeakReference;
  }
  
  public final void setViewType(CharSequence paramCharSequence)
  {
    this.viewType = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.ViewTag
 * JD-Core Version:    0.7.0.1
 */