package com.tencent.biz;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import java.util.ArrayList;

public class PoiMapActivity$PoiItemAdapter
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PoiMapActivity$PoiItemAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PoiMapActivity.POI a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (i < 0)) {
      return null;
    }
    return (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    do
    {
      PoiMapActivity.POI localPOI;
      do
      {
        return;
        if (paramInt == this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_Int = paramInt;
        notifyDataSetChanged();
        if ((paramInt == -1) || (!paramBoolean)) {
          break;
        }
        localPOI = a(paramInt);
      } while (localPOI == null);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.n = localPOI.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.o = localPOI.jdField_b_of_type_JavaLangString;
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localPOI.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localPOI.jdField_c_of_type_Int;
      PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateTo(new GeoPoint(localPOI.jdField_b_of_type_Int, localPOI.jdField_c_of_type_Int));
    } while (!paramBoolean);
    PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, a(paramInt));
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramPOI.jdField_a_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPOI);
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 1;
    if (i < j)
    {
      PoiMapActivity.POI localPOI = (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPOI == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (((TextUtils.isEmpty(localPOI.jdField_a_of_type_JavaLangString)) || (!localPOI.jdField_a_of_type_JavaLangString.equals(paramPOI.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localPOI.jdField_b_of_type_JavaLangString)) || (!localPOI.jdField_b_of_type_JavaLangString.equals(paramPOI.jdField_b_of_type_JavaLangString))) && (!localPOI.jdField_a_of_type_Boolean)) {
          localArrayList.add(localPOI);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Int += 1;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        return i + (j - 1);
        i = 0;
      }
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_Boolean) {}
    for (i = j;; i = 0) {
      return i + k;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903601, null);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298939);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298941));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298945));
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131298946);
      paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131298947);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298938);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298942));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298943));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298944));
      paramView.setTag(paramViewGroup);
    }
    while ((paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) || ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return paramView;
      paramViewGroup = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    PoiMapActivity.POI localPOI = a(paramInt);
    if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
    }
    if (localPOI == null) {
      return null;
    }
    paramViewGroup.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPOI.jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.jdField_b_of_type_JavaLangString);
    String str = localPOI.jdField_a_of_type_JavaLangString + localPOI.jdField_b_of_type_JavaLangString;
    if (TextUtils.isEmpty(localPOI.g))
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!TextUtils.isEmpty(localPOI.d)) {
        break label623;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      label395:
      if (!TextUtils.isEmpty(localPOI.e)) {
        break label634;
      }
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      label415:
      if (paramInt != this.jdField_a_of_type_Int) {
        break label645;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (paramViewGroup = str + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131364130);; paramViewGroup = str + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131364131))
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!TextUtils.isEmpty(localPOI.h)) {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.h);
      }
      if (TextUtils.isEmpty(localPOI.i)) {
        break;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDrawable(2130839252);
      int i = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493248);
      int j = this.jdField_a_of_type_ComTencentBizPoiMapActivity.getResources().getDimensionPixelSize(2131493249);
      localObject = URLDrawable.getDrawable(localPOI.i, i, j, null, (Drawable)localObject);
      if (localObject == null) {
        break;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break;
      label623:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      break label395;
      label634:
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break label415;
      label645:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiItemAdapter
 * JD-Core Version:    0.7.0.1
 */