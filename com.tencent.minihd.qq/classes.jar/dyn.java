import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQCustomDialog;

class dyn
  implements Runnable
{
  dyn(dyl paramdyl, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Dyl.a != null) && (this.jdField_a_of_type_Dyl.a.isShowing()))
    {
      this.jdField_a_of_type_Dyl.a.setPreviewImage(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new dyo(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyn
 * JD-Core Version:    0.7.0.1
 */