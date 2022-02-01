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
  private int hCc;
  private CompoundButton.OnCheckedChangeListener hCd;
  private boolean hCe;
  private b hCf;
  private c hCg;
  
  public MultiLineRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196311);
    this.hCc = -1;
    this.hCe = false;
    this.hCc = -1;
    setOrientation(1);
    this.hCd = new a((byte)0);
    this.hCg = new c((byte)0);
    super.setOnHierarchyChangeListener(this.hCg);
    AppMethodBeat.o(196311);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(196315);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof RadioButton))) {
      ((RadioButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(196315);
  }
  
  private LayoutParams h(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(196316);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(196316);
    return paramAttributeSet;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.hCc = paramInt;
  }
  
  public void addView(final View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(196314);
    if ((paramView instanceof RadioButton)) {
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(196305);
          ((RadioButton)paramView).setChecked(true);
          MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton)paramView);
          if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
          {
            MultiLineRadioGroup.a(MultiLineRadioGroup.this);
            paramView.getId();
          }
          AppMethodBeat.o(196305);
          return true;
        }
      });
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(196314);
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
                AppMethodBeat.i(196306);
                this.hCi.setChecked(true);
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, this.hCi);
                if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
                {
                  MultiLineRadioGroup.a(MultiLineRadioGroup.this);
                  this.hCi.getId();
                }
                AppMethodBeat.o(196306);
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
    AppMethodBeat.i(196317);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(196317);
    return localLayoutParams;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.hCc;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(196313);
    super.onFinishInflate();
    if (this.hCc != -1)
    {
      this.hCe = true;
      c(this.hCc, true);
      this.hCe = false;
      setCheckedId(this.hCc);
    }
    AppMethodBeat.o(196313);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(196318);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(196318);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(196319);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(196319);
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.hCf = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(196312);
    c.a(this.hCg, paramOnHierarchyChangeListener);
    AppMethodBeat.o(196312);
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
      AppMethodBeat.i(196308);
      if (paramTypedArray.hasValue(paramInt1)) {}
      for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
      {
        this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
        AppMethodBeat.o(196308);
        return;
      }
      this.height = -2;
      AppMethodBeat.o(196308);
    }
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(196307);
      if (MultiLineRadioGroup.b(MultiLineRadioGroup.this))
      {
        AppMethodBeat.o(196307);
        return;
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, true);
      if (MultiLineRadioGroup.c(MultiLineRadioGroup.this) != -1) {
        MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.c(MultiLineRadioGroup.this));
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, false);
      int i = paramCompoundButton.getId();
      MultiLineRadioGroup.b(MultiLineRadioGroup.this, i);
      AppMethodBeat.o(196307);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener qy;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(196309);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(paramView2.hashCode());
        }
        ((RadioButton)paramView2).setOnCheckedChangeListener(MultiLineRadioGroup.d(MultiLineRadioGroup.this));
      }
      if (this.qy != null) {
        this.qy.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(196309);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(196310);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton))) {
        ((RadioButton)paramView2).setOnCheckedChangeListener(null);
      }
      if (this.qy != null) {
        this.qy.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(196310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup
 * JD-Core Version:    0.7.0.1
 */