package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  AbstractImageListModel jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel;
  private AbstractProgressView jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView;
  
  private AbstractProgressView a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel != null) && (paramInt == this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b())) {
      return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView;
    }
    return null;
  }
  
  public static void a(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public AbstractImageListModel a()
  {
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel;
  }
  
  public GalleryImage a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a(paramInt);
  }
  
  protected void a(int paramInt)
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt1);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.b(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  public void a(AbstractProgressView paramAbstractProgressView)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView = paramAbstractProgressView;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt1);
    if ((localAbstractProgressView != null) && (localAbstractProgressView.a())) {
      localAbstractProgressView.b(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageAdapter
 * JD-Core Version:    0.7.0.1
 */