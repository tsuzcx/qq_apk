package com.tencent.mobileqq.activity.photo;

import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import gsn;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  public URLImageView a;
  
  void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ExtensionInfo localExtensionInfo = ((FriendsManagerImp)this.app.getManager(8)).a(this.app.a());
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getApplicationContext());
    if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid())) {
      this.jdField_a_of_type_AndroidOsHandler = new gsn(this, paramInt1, paramInt2, localExtensionInfo);
    }
    super.a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */