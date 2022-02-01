package com.tencent.mm.live.core.core.trtc.widget;

import android.content.Context;
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
  private int gqj;
  private CompoundButton.OnCheckedChangeListener gqk;
  private boolean gql;
  private b gqm;
  private c gqn;
  
  public MultiLineRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209068);
    this.gqj = -1;
    this.gql = false;
    this.gqj = -1;
    setOrientation(1);
    this.gqk = new a((byte)0);
    this.gqn = new c((byte)0);
    super.setOnHierarchyChangeListener(this.gqn);
    AppMethodBeat.o(209068);
  }
  
  private void c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209072);
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof RadioButton))) {
      ((RadioButton)localView).setChecked(paramBoolean);
    }
    AppMethodBeat.o(209072);
  }
  
  private MultiLineRadioGroup.LayoutParams h(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(209073);
    paramAttributeSet = new MultiLineRadioGroup.LayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(209073);
    return paramAttributeSet;
  }
  
  private void setCheckedId(int paramInt)
  {
    this.gqj = paramInt;
  }
  
  public void addView(final View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(209071);
    if ((paramView instanceof RadioButton)) {
      paramView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(209062);
          ((RadioButton)paramView).setChecked(true);
          MultiLineRadioGroup.a(MultiLineRadioGroup.this, (RadioButton)paramView);
          if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
          {
            MultiLineRadioGroup.a(MultiLineRadioGroup.this);
            paramView.getId();
          }
          AppMethodBeat.o(209062);
          return true;
        }
      });
    }
    for (;;)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(209071);
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
                AppMethodBeat.i(209063);
                this.gqp.setChecked(true);
                MultiLineRadioGroup.a(MultiLineRadioGroup.this, this.gqp);
                if (MultiLineRadioGroup.a(MultiLineRadioGroup.this) != null)
                {
                  MultiLineRadioGroup.a(MultiLineRadioGroup.this);
                  this.gqp.getId();
                }
                AppMethodBeat.o(209063);
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
    return paramLayoutParams instanceof MultiLineRadioGroup.LayoutParams;
  }
  
  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(209074);
    MultiLineRadioGroup.LayoutParams localLayoutParams = new MultiLineRadioGroup.LayoutParams();
    AppMethodBeat.o(209074);
    return localLayoutParams;
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.gqj;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(209070);
    super.onFinishInflate();
    if (this.gqj != -1)
    {
      this.gql = true;
      c(this.gqj, true);
      this.gql = false;
      setCheckedId(this.gqj);
    }
    AppMethodBeat.o(209070);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(209075);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(209075);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(209076);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MultiLineRadioGroup.class.getName());
    AppMethodBeat.o(209076);
  }
  
  public void setOnCheckedChangeListener(b paramb)
  {
    this.gqm = paramb;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    AppMethodBeat.i(209069);
    c.a(this.gqn, paramOnHierarchyChangeListener);
    AppMethodBeat.o(209069);
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(209064);
      if (MultiLineRadioGroup.b(MultiLineRadioGroup.this))
      {
        AppMethodBeat.o(209064);
        return;
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, true);
      if (MultiLineRadioGroup.c(MultiLineRadioGroup.this) != -1) {
        MultiLineRadioGroup.a(MultiLineRadioGroup.this, MultiLineRadioGroup.c(MultiLineRadioGroup.this));
      }
      MultiLineRadioGroup.a(MultiLineRadioGroup.this, false);
      int i = paramCompoundButton.getId();
      MultiLineRadioGroup.b(MultiLineRadioGroup.this, i);
      AppMethodBeat.o(209064);
    }
  }
  
  public static abstract interface b {}
  
  final class c
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener oD;
    
    private c() {}
    
    public final void onChildViewAdded(View paramView1, View paramView2)
    {
      AppMethodBeat.i(209066);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton)))
      {
        if (paramView2.getId() == -1) {
          paramView2.setId(paramView2.hashCode());
        }
        ((RadioButton)paramView2).setOnCheckedChangeListener(MultiLineRadioGroup.d(MultiLineRadioGroup.this));
      }
      if (this.oD != null) {
        this.oD.onChildViewAdded(paramView1, paramView2);
      }
      AppMethodBeat.o(209066);
    }
    
    public final void onChildViewRemoved(View paramView1, View paramView2)
    {
      AppMethodBeat.i(209067);
      if ((paramView1 == MultiLineRadioGroup.this) && ((paramView2 instanceof RadioButton))) {
        ((RadioButton)paramView2).setOnCheckedChangeListener(null);
      }
      if (this.oD != null) {
        this.oD.onChildViewRemoved(paramView1, paramView2);
      }
      AppMethodBeat.o(209067);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.widget.MultiLineRadioGroup
 * JD-Core Version:    0.7.0.1
 */