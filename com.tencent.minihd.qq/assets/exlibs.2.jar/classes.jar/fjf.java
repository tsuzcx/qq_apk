import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class fjf
  extends Handler
{
  public fjf(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {}
    label337:
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      default: 
        return;
      case 1: 
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 4)) {
          break;
        }
      case 2: 
        for (;;)
        {
          synchronized (this.a.jdField_a_of_type_JavaUtilList)
          {
            this.a.jdField_a_of_type_JavaUtilList.clear();
            this.a.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramMessage[1]);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[2]);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[3]);
            if (this.a.jdField_a_of_type_JavaUtilList.size() != 0)
            {
              this.a.g();
              if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter == null) {
                break label337;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.notifyDataSetChanged();
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setVisibility(0);
            }
            if (!this.a.d) {
              this.a.j();
            }
            this.a.d();
            return;
            this.a.j();
          }
          if ((paramMessage != null) && (paramMessage.length == 1))
          {
            synchronized (this.a.jdField_a_of_type_JavaUtilList)
            {
              this.a.jdField_a_of_type_JavaUtilList.clear();
              this.a.jdField_a_of_type_JavaUtilList.addAll((List)paramMessage[0]);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter = new TroopMemberListActivity.ListAdapter(this.a);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter);
          }
        }
      case 5: 
        this.a.j();
        return;
      case 6: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
        }
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131365831), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        return;
      case 7: 
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131365834), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        return;
      case 8: 
        paramMessage = (Object[])paramMessage.obj;
        boolean bool = ((Boolean)paramMessage[0]).booleanValue();
        paramMessage = (ArrayList)paramMessage[1];
        ChatSettingForTroop.a(this.a, this.a.i, bool, paramMessage);
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter == null);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjf
 * JD-Core Version:    0.7.0.1
 */