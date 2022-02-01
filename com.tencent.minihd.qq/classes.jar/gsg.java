import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class gsg
  implements URLDrawable.URLDrawableListener
{
  gsg(gsf paramgsf, String paramString, URLImageView paramURLImageView, URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewActivity", 2, "getView path = " + this.jdField_a_of_type_JavaLangString + ",URLDrawable onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewActivity", 2, "getView path = " + this.jdField_a_of_type_JavaLangString + ",URLDrawable onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraPreviewActivity", 2, "getView path = " + this.jdField_a_of_type_JavaLangString + ",URLDrawable onLoadSuccessed");
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gsg
 * JD-Core Version:    0.7.0.1
 */