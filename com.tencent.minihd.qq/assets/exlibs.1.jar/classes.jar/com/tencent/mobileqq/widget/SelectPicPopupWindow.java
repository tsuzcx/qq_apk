package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;

public class SelectPicPopupWindow
  extends PopupWindow
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  protected Context a;
  protected LayoutInflater a;
  public View.OnClickListener a;
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  public TextView a;
  public ArrayList a;
  public TextView b = null;
  public TextView c;
  
  public SelectPicPopupWindow(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903599, null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131298932));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297002));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298934));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298935));
    setContentView(this.jdField_a_of_type_AndroidViewView);
    setWidth(-1);
    setHeight(-1);
    setFocusable(true);
    setAnimationStyle(2131558926);
    setBackgroundDrawable(new ColorDrawable(-2147483648));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)) {
      return;
    }
    if (((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0) {
      ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    SelectPicPopupWindow.ViewHolder localViewHolder = (SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localViewHolder.jdField_a_of_type_AndroidViewView.setClickable(true);
    localViewHolder.jdField_a_of_type_AndroidViewView.setTag(Integer.valueOf(1));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt1) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1) == null)) {
      return;
    }
    ((SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt2);
  }
  
  public void a(Drawable paramDrawable, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903600, null);
    localView.setBackgroundResource(2130838151);
    localView.setPadding(20, 10, 20, 10);
    SelectPicPopupWindow.ViewHolder localViewHolder = new SelectPicPopupWindow.ViewHolder();
    localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297004));
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297003));
    localViewHolder.jdField_a_of_type_AndroidViewView = localView;
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298937));
    ((ImageView)localView.findViewById(2131296300)).setBackgroundDrawable(paramDrawable);
    ((TextView)localView.findViewById(2131297001)).setText(paramString1);
    paramDrawable = (TextView)localView.findViewById(2131297002);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramDrawable.setText(paramString2);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramString3);
      localView.setTag(Integer.valueOf(paramInt2));
      if (paramInt1 != 0) {
        break label244;
      }
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localView.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localViewHolder);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localView);
      return;
      paramDrawable.setVisibility(8);
      break;
      label244:
      if (paramInt1 == 1)
      {
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localView.setClickable(false);
        if (!TextUtils.isEmpty(paramString4)) {
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString4);
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(String paramString)
  {
    SelectPicPopupWindow.ViewHolder localViewHolder = (SelectPicPopupWindow.ViewHolder)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838090);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.c.setText(paramString);
    } while (paramInt <= 0);
    this.c.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, paramInt);
  }
  
  public void a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      if (paramInt > 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, paramInt);
      }
    } while (paramOnClickListener == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.b.setText(paramString);
      if (paramInt > 0) {
        this.b.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, paramInt);
      }
    } while (paramOnClickListener == null);
    this.b.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SelectPicPopupWindow
 * JD-Core Version:    0.7.0.1
 */