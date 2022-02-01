import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.qphone.base.util.QLog;

class fxw
  implements Runnable
{
  fxw(fxv paramfxv, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (fxu.a(this.jdField_a_of_type_Fxv.a) != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.jdField_a_of_type_Boolean);
      }
      ((AIOGalleryScene)fxu.b(this.jdField_a_of_type_Fxv.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
    if (fxu.a(this.jdField_a_of_type_Fxv.a) != null) {
      ((AIOImageListScene)fxu.b(this.jdField_a_of_type_Fxv.a)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxw
 * JD-Core Version:    0.7.0.1
 */