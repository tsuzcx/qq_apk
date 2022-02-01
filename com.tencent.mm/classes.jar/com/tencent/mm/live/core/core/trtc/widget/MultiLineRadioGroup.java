package com.tencent.mm.live.core.core.trtc.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiLineRadioGroup
  extends LinearLayout
{
  private int FZp;
  private CompoundButton.OnCheckedChangeListener qOb;
  private boolean qOc;
  private b qOd;
  private c qOe;
  
  public MultiLineRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205535);
    this.FZp = -1;
    this.qOc = false;
    this.FZp = -1;
    setOrientation(1);
    this.qOb = new a((byte)0);
    this.qOe = new c((byte)0);
    super.setOnHierarchyChangeListener(this.qOe);
    AppMethodBeat.o(205535);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205539);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof RadioButton))) {
      ((RadioButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(205539);
  }
  
  private LayoutParams i(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(205540);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(205540);
    return paramAttributeSet;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.FZp = paramInt;
  }
  
  public void addView(final View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205538);
    if ((paramView instanceof RadioButton)) {
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(205529);
          ((RadioButton)paramView).setChecked(true);
          MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton)paramView);
          if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
          {
            MultiLineRadioGroup.a(MultiLineRadioGroup.this);
            paramView.getId();
          }
          AppMethodBeat.o(205529);
          return true;
        }
      });
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(205538);
      return;
      if ((paramView instanceof LinearLayout))
      {
        int j = ((LinearLayout)paramView).getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = ((LinearLayout)paramView).getChildAt(i);
          if ((localObject instanceof RadioButton))
          {
            localObject = (RadioButton)localObject;
            ((RadioButton)localObject).setOnTouchListener(new View.OnTouchListener()
            {
              public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
              {
                AppMethodBeat.i(205530);
                this.qOg.setChecked(true);
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, this.qOg);
                if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
                {
                  MultiLineRadioGroup.a(MultiLineRadioGroup.this);
                  this.qOg.getId();
                }
                AppMethodBeat.o(205530);
                return true;
              }
            });
          }
          i += 1;
        }
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(205541);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(205541);
    return localLayoutParams;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.FZp;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(205537);
    super.onFinishInflate();
    if (this.FZp != -1)
    {
      this.qOc = true;
      c(this.FZp, true);
      this.qOc = false;
      setCheckedId(this.FZp);
    }
    AppMethodBeat.o(205537);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(205542);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(205542);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(205543);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(205543);
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.qOd = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(205536);
    c.a(this.qOe, paramOnHierarchyChangeListener);
    AppMethodBeat.o(205536);
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public LayoutParams()
    {
      super(-2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205532);
      if (paramTypedArray.hasValue(paramInt1)) {}
      for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
      {
        this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
        AppMethodBeat.o(205532);
        return;
      }
      this.height = -2;
      AppMethodBeat.o(205532);
    }
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(205531);
      if (MultiLineRadioGroup.b(MultiLineRadioGroup.this))
      {
        AppMethodBeat.o(205531);
        return;
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, true);
      if (MultiLineRadioGroup.c(MultiLineRadioGroup.this) != -1) {
        MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.c(MultiLineRadioGroup.this));
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, false);
      int i = paramCompoundButton.getId();
      MultiLineRadioGroup.b(MultiLineRadioGroup.this, i);
      AppMethodBeat.o(205531);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener nC;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(205533);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(paramView2.hashCode());
        }
        ((RadioButton)paramView2).setOnCheckedChangeListener(MultiLineRadioGroup.d(MultiLineRadioGroup.this));
      }
      if (this.nC != null) {
        this.nC.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(205533);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(205534);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton))) {
        ((RadioButton)paramView2).setOnCheckedChangeListener(null);
      }
      if (this.nC != null) {
        this.nC.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(205534);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup
 * JD-Core Version:    0.7.0.1
 */