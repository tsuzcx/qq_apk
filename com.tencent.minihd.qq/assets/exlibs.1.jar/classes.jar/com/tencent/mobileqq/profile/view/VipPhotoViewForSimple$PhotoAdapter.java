package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import joq;

public class VipPhotoViewForSimple$PhotoAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  List jdField_a_of_type_JavaUtilList;
  
  public VipPhotoViewForSimple$PhotoAdapter(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {}
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      paramList.j = 102;
      this.jdField_a_of_type_JavaUtilList.set(i - 1, paramList);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    QzonePhotoView.PhotoInfo localPhotoInfo = (QzonePhotoView.PhotoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new joq(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904126, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.f, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.g));
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131300956));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a.setTag(new DataTag(25, Integer.valueOf(paramInt)));
      paramViewGroup.a.setOnClickListener(VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
      if ((localPhotoInfo.j != 100) && (localPhotoInfo.j != 102)) {
        break label221;
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label213;
      }
      paramView.setBackground(null);
      paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.a.setImageDrawable(URLDrawable.getDrawable(localPhotoInfo.a(), this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.f, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.g));
    }
    label213:
    label221:
    while (localPhotoInfo.j != 101) {
      for (;;)
      {
        return paramView;
        paramViewGroup = (joq)paramView.getTag();
        break;
        paramView.setBackgroundDrawable(null);
      }
    }
    paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER);
    ProfileCardTemplate.a(paramViewGroup.a, "src", VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a, "simpleGridAddSrc");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipPhotoViewForSimple.PhotoAdapter
 * JD-Core Version:    0.7.0.1
 */