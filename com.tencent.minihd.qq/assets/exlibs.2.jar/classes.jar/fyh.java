import android.app.Activity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.util.ArrayList;

public final class fyh
  implements URLDrawable.URLDrawableListener
{
  public int a;
  public long a;
  public URLDrawable a;
  public int b;
  
  private fyh(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadCanceled URL():" + paramURLDrawable.getURL());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_JavaUtilArrayList.remove(this);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadFialed URL():" + paramURLDrawable.getURL());
    }
    QQToast.a(AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131368502), 0).a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_JavaUtilArrayList.remove(this);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "rawPhotoBtn decode onLoadSuccessed URL():" + paramURLDrawable.getURL());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(this.b).b = paramURLDrawable.getExifOrientation();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramURLDrawable, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.notifyDataSetChanged();
    AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_JavaUtilArrayList.remove(this);
    fyi localfyi = AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    paramURLDrawable = localfyi;
    if (localfyi == null)
    {
      paramURLDrawable = new fyi(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b.add(paramURLDrawable);
    }
    paramURLDrawable.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fyh
 * JD-Core Version:    0.7.0.1
 */