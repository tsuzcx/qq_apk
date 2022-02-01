package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;

public class VoteView
  extends RelativeLayout
{
  public static final String a = "VoteView";
  private double jdField_a_of_type_Double;
  public int a;
  public FrameLayout a;
  public TextView a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public TextView b;
  private boolean b;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Double = getResources().getDisplayMetrics().density;
    LayoutInflater.from(getContext()).inflate(2130903963, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300279));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131298051));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298052));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    Object localObject3;
    int j;
    Object localObject2;
    int i;
    Object localObject1;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Int > 0))
    {
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130841953;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.jdField_a_of_type_Int);
        i = j;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
          localObject1 = localObject2;
          i = j;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
        localObject3 = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label306;
        }
        localObject2 = "";
        label178:
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label333;
        }
        paramInt = 8;
        label198:
        ((TextView)localObject2).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      return;
      j = 2130841956;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = ((int)(11.0D * this.jdField_a_of_type_Double + 0.5D));
      }
      localObject2 = String.valueOf(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      i = j;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject3).width = -2;
      ((RelativeLayout.LayoutParams)localObject3).height = -2;
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
      i = j;
      localObject1 = localObject2;
      break;
      label306:
      localObject2 = "+" + this.jdField_b_of_type_Int;
      break label178;
      label333:
      paramInt = 0;
      break label198;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject1 = String.valueOf(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, NewVoteAnimHelper paramNewVoteAnimHelper)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (paramInt2 <= this.jdField_a_of_type_Int) {
        break label111;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int % 20);
      label39:
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break label133;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130841760, 0, 0, 0);
    }
    for (;;)
    {
      setContentDescription(this.jdField_a_of_type_Int + "人已赞过");
      if (this.jdField_b_of_type_Boolean) {
        break label148;
      }
      a(false, 8);
      return;
      paramInt1 = 0;
      break;
      label111:
      if (paramInt2 < 0)
      {
        this.jdField_b_of_type_Int = 0;
        break label39;
      }
      this.jdField_b_of_type_Int = paramInt2;
      break label39;
      label133:
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130841759, 0, 0, 0);
    }
    label148:
    if (paramNewVoteAnimHelper != null)
    {
      paramNewVoteAnimHelper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
    a(true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView
 * JD-Core Version:    0.7.0.1
 */