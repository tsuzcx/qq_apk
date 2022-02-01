import com.tencent.mobileqq.magicface.model.MagicfaceDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;

public class jeb
  implements Runnable
{
  public jeb(MagicfaceDecoder paramMagicfaceDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.a.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.a();
    }
    this.a.a();
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener.b();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jeb
 * JD-Core Version:    0.7.0.1
 */