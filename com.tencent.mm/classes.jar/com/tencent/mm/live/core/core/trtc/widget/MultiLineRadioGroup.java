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
  private int mTY;
  private CompoundButton.OnCheckedChangeListener mTZ;
  private boolean mUa;
  private b mUb;
  private c mUc;
  
  public MultiLineRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(248341);
    this.mTY = -1;
    this.mUa = false;
    this.mTY = -1;
    setOrientation(1);
    this.mTZ = new a((byte)0);
    this.mUc = new c((byte)0);
    super.setOnHierarchyChangeListener(this.mUc);
    AppMethodBeat.o(248341);
  }
  
  private void F(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248359);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof RadioButton))) {
      ((RadioButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(248359);
  }
  
  private LayoutParams i(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(248367);
    paramAttributeSet = new LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(248367);
    return paramAttributeSet;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.mTY = paramInt;
  }
  
  public void addView(final View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(248409);
    if ((paramView instanceof RadioButton)) {
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(248328);
          ((RadioButton)paramView).setChecked(true);
          MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton)paramView);
          if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
          {
            MultiLineRadioGroup.a(MultiLineRadioGroup.this);
            paramView.getId();
          }
          AppMethodBeat.o(248328);
          return true;
        }
      });
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(248409);
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
                AppMethodBeat.i(248331);
                this.mUe.setChecked(true);
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, this.mUe);
                if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
                {
                  MultiLineRadioGroup.a(MultiLineRadioGroup.this);
                  this.mUe.getId();
                }
                AppMethodBeat.o(248331);
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
    AppMethodBeat.i(248416);
    LayoutParams localLayoutParams = new LayoutParams();
    AppMethodBeat.o(248416);
    return localLayoutParams;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.mTY;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(248406);
    super.onFinishInflate();
    if (this.mTY != -1)
    {
      this.mUa = true;
      F(this.mTY, true);
      this.mUa = false;
      setCheckedId(this.mTY);
    }
    AppMethodBeat.o(248406);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(248417);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(248417);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(248418);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(248418);
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.mUb = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(248403);
    c.a(this.mUc, paramOnHierarchyChangeListener);
    AppMethodBeat.o(248403);
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
      AppMethodBeat.i(248332);
      if (paramTypedArray.hasValue(paramInt1)) {}
      for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
      {
        this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
        AppMethodBeat.o(248332);
        return;
      }
      this.height = -2;
      AppMethodBeat.o(248332);
    }
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(248354);
      if (MultiLineRadioGroup.b(MultiLineRadioGroup.this))
      {
        AppMethodBeat.o(248354);
        return;
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, true);
      if (MultiLineRadioGroup.c(MultiLineRadioGroup.this) != -1) {
        MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.c(MultiLineRadioGroup.this));
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, false);
      int i = paramCompoundButton.getId();
      MultiLineRadioGroup.b(MultiLineRadioGroup.this, i);
      AppMethodBeat.o(248354);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener bnn;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(248364);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(paramView2.hashCode());
        }
        ((RadioButton)paramView2).setOnCheckedChangeListener(MultiLineRadioGroup.d(MultiLineRadioGroup.this));
      }
      if (this.bnn != null) {
        this.bnn.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(248364);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(248370);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton))) {
        ((RadioButton)paramView2).setOnCheckedChangeListener(null);
      }
      if (this.bnn != null) {
        this.bnn.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(248370);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup
 * JD-Core Version:    0.7.0.1
 */