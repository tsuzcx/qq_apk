import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class gjx
  extends Handler
{
  public gjx(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(this.a.jdField_a_of_type_JavaUtilList);
        if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null)
        {
          this.a.jdField_a_of_type_Int = localArrayList.size();
          this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(localArrayList);
          continue;
          this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
          continue;
          this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c().size() == 0)) {
            this.a.a();
          }
          for (;;)
          {
            ShowExternalTroopListActivity.a(this.a);
            break;
            this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a();
            }
          }
          this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
          QQToast.a(this.a, 1, this.a.getString(2131363986), 0).b(this.a.getTitleBarHeight());
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.c().size() == 0))
          {
            this.a.a();
            continue;
            this.a.jdField_a_of_type_ComTencentWidgetXListView.B();
            QQToast.a(this.a, 1, this.a.getString(2131367361), 0).b(this.a.getTitleBarHeight());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gjx
 * JD-Core Version:    0.7.0.1
 */