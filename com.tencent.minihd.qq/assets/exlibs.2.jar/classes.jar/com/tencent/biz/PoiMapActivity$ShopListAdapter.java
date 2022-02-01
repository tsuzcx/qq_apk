package com.tencent.biz;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import cbo;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;

public class PoiMapActivity$ShopListAdapter
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  int c;
  int d = 0;
  
  public PoiMapActivity$ShopListAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public PoiMapActivity.Shops a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PoiMapActivity.Shops)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.a((int)(PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), (int)(PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity) * 1000000.0D), this.jdField_c_of_type_Int, 10);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.b(paramString);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_c_of_type_Int != paramInt1) {
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 8;
    int k = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493257);
    int m = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493258);
    if (this.d == 0) {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903602, null);
        paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298949));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298951));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298943);
        paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298944);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298952));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298953));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131298955));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131298956));
        paramViewGroup.g = ((TextView)paramView.findViewById(2131298954));
        paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131298948);
        paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131298947);
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
        paramViewGroup.jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.e);
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label273;
        }
        paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup = paramView;
      }
    }
    label273:
    Object localObject1;
    Object localObject2;
    label542:
    label580:
    label585:
    do
    {
      return paramViewGroup;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      localObject1 = (PoiMapActivity.GeneralShops)a(paramInt);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).e);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).a);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      if (!TextUtils.isEmpty(((PoiMapActivity.GeneralShops)localObject1).f))
      {
        localObject2 = URLDrawable.getDrawable(((PoiMapActivity.GeneralShops)localObject1).f, k, m);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        ((URLDrawable)localObject2).setURLDrawableListener(new cbo(this, paramViewGroup.jdField_a_of_type_AndroidWidgetImageView));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.GeneralShops)localObject1).jdField_b_of_type_JavaLangString);
        localObject2 = new SpannableString(((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_JavaLangString);
        ((SpannableString)localObject2).setSpan(new StrikethroughSpan(), 0, ((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_JavaLangString.length(), 33);
        paramViewGroup.e.setText((CharSequence)localObject2);
        paramViewGroup.e.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
        paramViewGroup.f.setText(((PoiMapActivity.GeneralShops)localObject1).d);
        paramViewGroup.f.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
        paramViewGroup.g.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
        localObject2 = paramViewGroup.jdField_b_of_type_AndroidViewView;
        if (((PoiMapActivity.GeneralShops)localObject1).jdField_c_of_type_Int != 0) {
          break label580;
        }
        paramInt = 8;
        ((View)localObject2).setVisibility(paramInt);
        paramViewGroup = paramViewGroup.jdField_a_of_type_AndroidViewView;
        if (((PoiMapActivity.GeneralShops)localObject1).jdField_b_of_type_Int != 0) {
          break label585;
        }
      }
      for (;;)
      {
        paramViewGroup.setVisibility(i);
        return paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        break;
        paramInt = 0;
        break label542;
        i = 0;
      }
      paramViewGroup = paramView;
    } while (this.d != 1);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903603, null);
      paramViewGroup = new PoiMapActivity.ShopHolderView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131298948);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298957));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298949));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298951));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298943);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298944);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298958));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131298955));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131298960));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131298959));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(null);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.e);
      localObject1 = (PoiMapActivity.SingleShops)a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.SingleShops)localObject1).e);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      if (TextUtils.isEmpty(((PoiMapActivity.SingleShops)localObject1).f)) {
        break label943;
      }
      localObject2 = URLDrawable.getDrawable(((PoiMapActivity.SingleShops)localObject1).f, k, m);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      paramInt = j;
      label879:
      if (paramInt > 5) {
        break label992;
      }
      localObject2 = new ImageView(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (paramInt * 2 > ((PoiMapActivity.SingleShops)localObject1).d) {
        break label957;
      }
      ((ImageView)localObject2).setImageResource(2130839258);
    }
    for (;;)
    {
      paramInt += 1;
      break label879;
      paramViewGroup = (PoiMapActivity.ShopHolderView)paramView.getTag();
      break;
      label943:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramInt = j;
      break label879;
      label957:
      if (paramInt * 2 - 1 == ((PoiMapActivity.SingleShops)localObject1).d) {
        ((ImageView)localObject2).setImageResource(2130839257);
      } else {
        ((ImageView)localObject2).setImageResource(2130839256);
      }
    }
    label992:
    if ((TextUtils.isEmpty(((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_JavaLangString)) || (((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_JavaLangString.trim().startsWith("0")))
    {
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.i.setText(((PoiMapActivity.SingleShops)localObject1).jdField_c_of_type_JavaLangString);
      paramViewGroup.i.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      paramViewGroup.h.setText(((PoiMapActivity.SingleShops)localObject1).a);
      paramViewGroup.h.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.a);
      localObject2 = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_Int != 0) {
        break label1165;
      }
      paramInt = 8;
      ((View)localObject2).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_b_of_type_AndroidViewView;
      if (((PoiMapActivity.SingleShops)localObject1).jdField_c_of_type_Int != 0) {
        break label1170;
      }
    }
    for (;;)
    {
      label1107:
      paramViewGroup.setVisibility(i);
      return paramView;
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.e.setText(((PoiMapActivity.SingleShops)localObject1).jdField_b_of_type_JavaLangString);
      break;
      label1165:
      paramInt = 0;
      break label1107;
      label1170:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.ShopListAdapter
 * JD-Core Version:    0.7.0.1
 */