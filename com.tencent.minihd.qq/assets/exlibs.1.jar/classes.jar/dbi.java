import android.view.View;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import java.lang.ref.WeakReference;

public class dbi
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public WeakReference b;
  
  public dbi(DeviceComnFileMsgProcessor paramDeviceComnFileMsgProcessor, View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramDeviceFileItemCallback);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public MessageForDeviceFile.DeviceFileItemCallback a()
  {
    return (MessageForDeviceFile.DeviceFileItemCallback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbi
 * JD-Core Version:    0.7.0.1
 */