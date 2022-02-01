import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class hzy
  implements AdapterView.OnItemClickListener
{
  public hzy(DatingDestinationActivity paramDatingDestinationActivity, Dialog paramDialog) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DatingDestinationActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = paramAdapterView.a().getItem(paramInt);
    if (paramAdapterView != null)
    {
      paramAdapterView = (appoint_define.LocaleInfo)paramAdapterView;
      DatingDestinationActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity, paramAdapterView);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzy
 * JD-Core Version:    0.7.0.1
 */