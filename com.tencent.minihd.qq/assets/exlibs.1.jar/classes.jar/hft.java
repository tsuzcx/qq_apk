import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

public class hft
  extends TroopObserver
{
  public hft(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getString(2131363977), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        Switch localSwitch = (Switch)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
          localSwitch.setChecked(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramString));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hft
 * JD-Core Version:    0.7.0.1
 */