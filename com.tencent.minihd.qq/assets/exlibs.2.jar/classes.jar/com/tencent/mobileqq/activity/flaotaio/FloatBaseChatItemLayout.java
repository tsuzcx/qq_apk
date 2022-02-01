package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class FloatBaseChatItemLayout
  extends RelativeLayout
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int d = 2131296322;
  public static final int e = 114;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  public static final int r;
  public static final int s;
  public static final int t;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ImageView b;
  int c;
  public ImageView c;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    i = localResources.getDimensionPixelSize(2131493055);
    j = localResources.getDimensionPixelSize(2131493056);
    m = localResources.getDimensionPixelSize(2131493059);
    k = localResources.getDimensionPixelSize(2131493057);
    l = localResources.getDimensionPixelSize(2131493058);
    f = localResources.getDimensionPixelSize(2131493082);
    h = (int)(f - 114.0F * localResources.getDisplayMetrics().density);
    g = h - k - l;
    n = localResources.getDimensionPixelSize(2131493069);
    o = localResources.getDimensionPixelSize(2131493070);
    p = localResources.getDimensionPixelSize(2131493482);
    q = localResources.getDimensionPixelSize(2131493478);
    r = localResources.getDimensionPixelSize(2131493479);
    s = localResources.getDimensionPixelSize(2131493480);
    t = localResources.getDimensionPixelSize(2131493481);
  }
  
  public FloatBaseChatItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatBaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 0;
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence, ColorStateList paramColorStateList, boolean paramBoolean2)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i1;
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
        this.jdField_a_of_type_AndroidWidgetTextView.setId(2131296317);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(g);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.a(6.0F, getContext().getResources());
        localLayoutParams.addRule(3, 0);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296317);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      i1 = AIOUtils.a(6.0F, getContext().getResources());
      if (paramBoolean2)
      {
        localLayoutParams.rightMargin = i1;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(0, 2131296315);
        localLayoutParams.addRule(1, 0);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidViewView != null) {
            ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 2131296317);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramCharSequence);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
      }
    }
    do
    {
      do
      {
        return;
        localLayoutParams.leftMargin = i1;
        localLayoutParams.addRule(1, 2131296315);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.addRule(0, 0);
        break;
      } while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).addRule(3, 0);
  }
  
  public void setBubbleView(View paramView)
  {
    if (this.jdField_a_of_type_AndroidViewView != paramView)
    {
      removeView(this.jdField_a_of_type_AndroidViewView);
      addView(paramView);
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewView.setId(2131296322);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i1 = AIOUtils.a(6.0F, getContext().getResources());
      paramView.leftMargin = i1;
      paramView.rightMargin = i1;
    }
    paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (this.jdField_c_of_type_Int == 1)
    {
      paramView.addRule(0, 2131296315);
      paramView.addRule(1, 0);
    }
    while ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      paramView.addRule(3, 2131296317);
      return;
      paramView.addRule(1, 2131296315);
      paramView.addRule(0, 0);
    }
    paramView.addRule(3, 0);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.b == null)
    {
      this.b = new ImageView(getContext());
      this.b.setId(2131296321);
      this.b.setContentDescription(getContext().getString(2131369311));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = AIOUtils.a(8.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131296322);
      if (this.jdField_c_of_type_Int != 1) {
        break label152;
      }
      localLayoutParams.addRule(0, 2131296322);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.b, localLayoutParams);
      this.b.setImageResource(paramInt);
      this.b.setVisibility(0);
      this.b.setOnClickListener(paramOnClickListener);
      this.b.setTag(paramObject);
      return;
      label152:
      localLayoutParams.addRule(1, 2131296322);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130837622, paramOnClickListener);
    }
    while (this.b == null) {
      return;
    }
    this.b.setVisibility(8);
    this.b.setOnClickListener(null);
  }
  
  public void setHeaderIcon(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131296315);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      int i1 = AIOUtils.a(24.0F, getContext().getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
      localLayoutParams.topMargin = 0;
      if (this.jdField_c_of_type_Int == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, 0);
        addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = 0;
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.topMargin = 0;
    if (this.jdField_c_of_type_Int == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, 0);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt) {
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(getContext(), null, 0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131296320);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130838130));
        i1 = AIOUtils.a(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
        localLayoutParams.bottomMargin = AIOUtils.a(8.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131296322);
        if (this.jdField_c_of_type_Int == 1)
        {
          localLayoutParams.rightMargin = AIOUtils.a(8.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131296322);
          localLayoutParams.addRule(1, 0);
          addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      for (;;)
      {
        int i1;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = AIOUtils.a(8.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131296322);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void setUnread(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.a(8.0F, getContext().getResources());
      localLayoutParams.leftMargin = AIOUtils.a(-3.0F, getContext().getResources());
      localLayoutParams.addRule(6, 2131296322);
      localLayoutParams.addRule(1, 2131296322);
      addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841953);
    }
    while (this.jdField_c_of_type_AndroidWidgetImageView == null)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatBaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */