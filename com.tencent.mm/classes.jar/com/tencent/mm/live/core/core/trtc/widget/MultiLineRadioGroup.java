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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class MultiLineRadioGroup
  extends LinearLayout
{
  private int gJT;
  private CompoundButton.OnCheckedChangeListener gJU;
  private boolean gJV;
  private b gJW;
  private c gJX;
  
  public MultiLineRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216722);
    this.gJT = -1;
    this.gJV = false;
    this.gJT = -1;
    setOrientation(1);
    this.gJU = new a((byte)0);
    this.gJX = new c((byte)0);
    super.setOnHierarchyChangeListener(this.gJX);
    AppMethodBeat.o(216722);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(216726);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof RadioButton))) {
      ((RadioButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(216726);
  }
  
  private LayoutParams h(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(216727);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(216727);
    return paramAttributeSet;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.gJT = paramInt;
  }
  
  public void addView(final View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(216725);
    if ((paramView instanceof RadioButton)) {
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(216716);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/live/core/core/trtc/widget/MultiLineRadioGroup$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          ((RadioButton)paramView).setChecked(true);
          MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton)paramView);
          if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
          {
            MultiLineRadioGroup.a(MultiLineRadioGroup.this);
            paramView.getId();
          }
          a.a(true, this, "com/tencent/mm/live/core/core/trtc/widget/MultiLineRadioGroup$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(216716);
          return true;
        }
      });
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(216725);
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
                AppMethodBeat.i(216717);
                b localb = new b();
                localb.bd(paramAnonymousView);
                localb.bd(paramAnonymousMotionEvent);
                a.b("com/tencent/mm/live/core/core/trtc/widget/MultiLineRadioGroup$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
                this.gJZ.setChecked(true);
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, this.gJZ);
                if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
                {
                  MultiLineRadioGroup.a(MultiLineRadioGroup.this);
                  this.gJZ.getId();
                }
                a.a(true, this, "com/tencent/mm/live/core/core/trtc/widget/MultiLineRadioGroup$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(216717);
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
    AppMethodBeat.i(216728);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(216728);
    return localLayoutParams;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.gJT;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(216724);
    super.onFinishInflate();
    if (this.gJT != -1)
    {
      this.gJV = true;
      c(this.gJT, true);
      this.gJV = false;
      setCheckedId(this.gJT);
    }
    AppMethodBeat.o(216724);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(216729);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(216729);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(216730);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(216730);
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.gJW = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(216723);
    c.a(this.gJX, paramOnHierarchyChangeListener);
    AppMethodBeat.o(216723);
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
      AppMethodBeat.i(216719);
      if (paramTypedArray.hasValue(paramInt1)) {}
      for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
      {
        this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
        AppMethodBeat.o(216719);
        return;
      }
      this.height = -2;
      AppMethodBeat.o(216719);
    }
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(216718);
      if (MultiLineRadioGroup.b(MultiLineRadioGroup.this))
      {
        AppMethodBeat.o(216718);
        return;
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, true);
      if (MultiLineRadioGroup.c(MultiLineRadioGroup.this) != -1) {
        MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.c(MultiLineRadioGroup.this));
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, false);
      int i = paramCompoundButton.getId();
      MultiLineRadioGroup.b(MultiLineRadioGroup.this, i);
      AppMethodBeat.o(216718);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener qw;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(216720);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(paramView2.hashCode());
        }
        ((RadioButton)paramView2).setOnCheckedChangeListener(MultiLineRadioGroup.d(MultiLineRadioGroup.this));
      }
      if (this.qw != null) {
        this.qw.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(216720);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(216721);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton))) {
        ((RadioButton)paramView2).setOnCheckedChangeListener(null);
      }
      if (this.qw != null) {
        this.qw.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(216721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup
 * JD-Core Version:    0.7.0.1
 */