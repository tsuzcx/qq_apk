import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.StackBlur;

public class eax
  implements Runnable
{
  public eax(FriendProfileCardActivity paramFriendProfileCardActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.125F), (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.125F), true);
    StackBlur.a((Bitmap)localObject, 2);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.obtainMessage(12, localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eax
 * JD-Core Version:    0.7.0.1
 */