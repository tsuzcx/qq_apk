import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.open.agent.SmartHardwareActivity;
import com.tencent.open.agent.SmartHardwareActivity.FriendListAdapter;
import java.util.ArrayList;

public class lci
  extends Handler
{
  public lci(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentOpenAgentSmartHardwareActivity$FriendListAdapter.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(4);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lci
 * JD-Core Version:    0.7.0.1
 */