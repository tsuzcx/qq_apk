package com.tencent.mobileqq.vas;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;

public class SigTlpPaperAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray a;
  private AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  protected QQAppInterface a;
  private PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public SigTlpPaperAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, int[] paramArrayOfInt, AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private SigTlpGridViewAdapter a(int paramInt, ViewPager paramViewPager, GridView paramGridView)
  {
    if (paramInt >= this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)]) {}
    label135:
    for (int i = this.jdField_a_of_type_ArrayOfInt.length - 1;; i = 0)
    {
      SigTlpGridViewAdapter localSigTlpGridViewAdapter = null;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        localSigTlpGridViewAdapter = new SigTlpGridViewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramInt - this.jdField_a_of_type_ArrayOfInt[i], paramInt, paramViewPager, paramGridView);
        localSigTlpGridViewAdapter.a(com.tencent.mobileqq.app.SignatureManager.a[i].a);
      }
      return localSigTlpGridViewAdapter;
      i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_ArrayOfInt.length - 1) {
          break label135;
        }
        if ((paramInt >= this.jdField_a_of_type_ArrayOfInt[i]) && (paramInt < this.jdField_a_of_type_ArrayOfInt[(i + 1)])) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ViewPager localViewPager = (ViewPager)paramView;
    GridView localGridView2 = (GridView)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
    GridView localGridView1 = localGridView2;
    if (localGridView2 == null)
    {
      localGridView1 = (GridView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904136, localViewPager, false);
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setClickable(true);
      localGridView1.setFocusable(true);
      localGridView1.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    }
    localGridView1.setAdapter(a(paramInt, localViewPager, localGridView1));
    ((ViewPager)paramView).addView(localGridView1);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localGridView1);
    return localGridView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SigTlpPaperAdapter
 * JD-Core Version:    0.7.0.1
 */