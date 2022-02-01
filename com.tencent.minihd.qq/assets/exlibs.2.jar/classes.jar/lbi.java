import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.DeviceDeleteFriendChooserActivity;
import com.tencent.open.agent.DeviceFriendListOpenFrame.ViewHolder;

public class lbi
  implements Runnable
{
  public lbi(DeviceDeleteFriendChooserActivity paramDeviceDeleteFriendChooserActivity, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        DeviceFriendListOpenFrame.ViewHolder localViewHolder = (DeviceFriendListOpenFrame.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentDeviceDeleteFriendChooserActivity.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.jdField_a_of_type_JavaLangString))) {
          localViewHolder.b.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbi
 * JD-Core Version:    0.7.0.1
 */