package com.tencent.mobileqq.troop.activity;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class ImagePreviewActivity$ImageAdapter
  extends XBaseAdapter
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  
  public ImagePreviewActivity$ImageAdapter(ImagePreviewActivity paramImagePreviewActivity) {}
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.getLayoutInflater().inflate(2130903410, null);
      paramViewGroup = new ImagePreviewActivity.ImageAdapter.ImagePhotoHolder(this);
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131298132));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = a(paramInt);
      if (localObject == null) {
        break label158;
      }
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        try
        {
          paramViewGroup.a.setImageDrawable(URLDrawable.getDrawable(((File)localObject).toURL(), this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.b, this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.c, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null));
          return paramView;
          paramViewGroup = (ImagePreviewActivity.ImageAdapter.ImagePhotoHolder)paramView.getTag();
        }
        catch (MalformedURLException paramViewGroup)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("TroopBar", 2, paramViewGroup.getMessage());
          return paramView;
        }
      }
    }
    paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return paramView;
    label158:
    paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopActivityImagePreviewActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.ImagePreviewActivity.ImageAdapter
 * JD-Core Version:    0.7.0.1
 */