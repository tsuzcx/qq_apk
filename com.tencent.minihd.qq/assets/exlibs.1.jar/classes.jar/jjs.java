import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class jjs
  implements View.OnClickListener
{
  public jjs(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)paramView.getTag();
    if (localPicInfo == null) {
      return;
    }
    if (localPicInfo == NearbyProfileEditPanel.a(this.a).jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)
    {
      NearbyProfileEditPanel.a(this.a).a(false);
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(NearbyProfileEditPanel.a(this.a));
    localActionSheet.c("设为头像");
    localActionSheet.c("查看大图");
    if (NearbyProfileEditPanel.a(this.a).jdField_a_of_type_JavaUtilArrayList.size() > 2) {
      localActionSheet.a("删除照片", 3);
    }
    localActionSheet.e(2131365736);
    localActionSheet.a(new jjt(this, paramView, localPicInfo, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjs
 * JD-Core Version:    0.7.0.1
 */