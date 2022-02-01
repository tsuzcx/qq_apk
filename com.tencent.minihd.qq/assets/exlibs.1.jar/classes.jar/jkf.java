import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.nearpeople.FlingBrandListener;
import com.tencent.qphone.base.util.QLog;

public class jkf
  implements Runnable
{
  public jkf(FlingBrandListener paramFlingBrandListener, Context paramContext) {}
  
  public void run()
  {
    try
    {
      FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener, BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840441));
      FlingBrandListener.b(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener, BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130840437));
      FlingBrandListener localFlingBrandListener = this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener;
      if (FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).getWidth() > FlingBrandListener.b(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).getWidth()) {}
      for (int i = FlingBrandListener.a(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).getWidth();; i = FlingBrandListener.b(this.jdField_a_of_type_ComTencentMobileqqNearpeopleFlingBrandListener).getWidth())
      {
        FlingBrandListener.a(localFlingBrandListener, i);
        return;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FlingBrandListener", 2, "decode res to bitmap OutOfMemoryError happened!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jkf
 * JD-Core Version:    0.7.0.1
 */