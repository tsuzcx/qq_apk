package com.tencent.biz;

import android.content.Context;
import android.widget.TextView;
import cbl;
import cbm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class PoiMapActivity$PoiTab
{
  final int a;
  public TextView a;
  public PoiMapActivity.PoiItemAdapter a;
  public PoiMapActivity.TabView a;
  public XListView a;
  final int b;
  final int c;
  final int d = 4;
  public int e;
  public int f;
  public int g;
  
  public PoiMapActivity$PoiTab(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.e = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((PoiMapActivity)paramContext).findViewById(2131300678));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramPoiMapActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(paramContext);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter = new PoiMapActivity.PoiItemAdapter(paramPoiMapActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new cbl(this, paramPoiMapActivity));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new cbm(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131369265));
      return;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131369243));
      return;
    case 3: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131369350));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.d)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      if (paramInt >= 0) {
        PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt));
      }
      return;
    }
    if (this.e == 0) {
      if ((paramInt > 0) && (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean))
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_h_of_type_Boolean) {
          break label88;
        }
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_h_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      return;
      label88:
      PoiMapActivity.POI localPOI = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt);
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI);
      if (localPOI == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.n = localPOI.a;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.o = localPOI.jdField_b_of_type_JavaLangString;
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localPOI.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localPOI.jdField_c_of_type_Int;
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateTo(new GeoPoint(localPOI.jdField_b_of_type_Int, localPOI.jdField_c_of_type_Int));
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = (paramInt - 1);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(true);
      return;
      if (paramInt != -1) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(true);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramString);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      a(3);
    }
    do
    {
      return;
      if (paramArrayList == null)
      {
        a(1);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramArrayList, paramBoolean1, paramInt);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.l == this.e)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        a(4);
      }
    } while (!this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        a(4);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.setSelect(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "POI list update isfirst = " + paramBoolean);
    }
    if ((this.f != this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_h_of_type_Int) || (this.g != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_h_of_type_Int, this.jdField_a_of_type_ComTencentBizPoiMapActivity.i, "", this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.jdField_a_of_type_Int], this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int, 20);
      this.f = this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_h_of_type_Int;
      this.g = this.jdField_a_of_type_ComTencentBizPoiMapActivity.i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab
 * JD-Core Version:    0.7.0.1
 */