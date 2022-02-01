import android.view.View;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;

public class fhv
  extends BizTroopObserver
{
  public fhv(TroopManageActivity paramTroopManageActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      ((TroopInfo)localObject).dwGroupFlagExt ^= 0x40000000;
      localObject = (TroopManager)this.a.app.getManager(50);
      if (localObject != null) {
        ((TroopManager)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      }
      return;
    }
    this.a.a(1, this.a.getString(2131363836));
    Object localObject = ((FormSwitchItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131300632)).a();
    ((Switch)localObject).setOnCheckedChangeListener(null);
    if (!paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((Switch)localObject).setChecked(paramBoolean1);
      ((Switch)localObject).setOnCheckedChangeListener(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhv
 * JD-Core Version:    0.7.0.1
 */