package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.qphone.base.util.QLog;
import fpg;
import java.util.ArrayList;

public class PanelAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int = 5;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  public int b = 0;
  int c = 2;
  
  public PanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void a(int paramInt, fpg paramfpg)
  {
    int m = this.jdField_a_of_type_Int;
    int n = this.c;
    paramfpg.jdField_a_of_type_Int = paramInt;
    int i = 0;
    int j = 0;
    while (j < this.c)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramfpg.getChildAt(j);
      int i1 = localLinearLayout.getChildCount();
      int k = 0;
      if (k < i1)
      {
        View localView = localLinearLayout.getChildAt(k);
        PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)localView.getTag();
        int i2 = m * n * paramInt + i;
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
          if (localPluginData.jdField_a_of_type_Boolean)
          {
            localViewHolder.b.setVisibility(0);
            label158:
            localViewHolder.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
            localView.setEnabled(true);
            localView.setContentDescription(localPluginData.b);
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
        }
        for (;;)
        {
          i += 1;
          k += 2;
          break;
          localViewHolder.b.setVisibility(8);
          break label158;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.b.setVisibility(8);
          localViewHolder.jdField_a_of_type_Int = 0;
          localView.setContentDescription(null);
          localView.setOnClickListener(null);
          localView.setEnabled(false);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          fpg localfpg = (fpg)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localfpg != null) && (paramInt == localfpg.jdField_a_of_type_Int))
          {
            a(paramInt, localfpg);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    fpg localfpg = (fpg)paramObject;
    ((ViewGroup)paramView).removeView(localfpg);
    localfpg.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.c == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.c - 1) / (this.jdField_a_of_type_Int * this.c);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    fpg localfpg2 = (fpg)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    fpg localfpg1 = localfpg2;
    if (localfpg2 == null) {
      localfpg1 = new fpg(this, this.jdField_a_of_type_AndroidContentContext, null);
    }
    localfpg1.jdField_a_of_type_Int = paramInt;
    a(paramInt, localfpg1);
    if ((localfpg1.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localfpg1);
    }
    return localfpg1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */