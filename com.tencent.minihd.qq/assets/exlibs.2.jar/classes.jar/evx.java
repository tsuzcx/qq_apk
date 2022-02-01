import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.activity.RecentSaidActivity.ListAdapter;
import java.util.List;

public class evx
  implements Handler.Callback
{
  public evx(RecentSaidActivity paramRecentSaidActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    RecentSaidActivity.a(this.a);
    switch (paramMessage.arg2)
    {
    }
    for (;;)
    {
      this.a.c = false;
      break;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 20: 
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131363752);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      case 21: 
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131363753);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        continue;
        if ((paramMessage.obj instanceof List))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity$ListAdapter.a((List)paramMessage.obj);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity$ListAdapter.notifyDataSetChanged();
        }
        switch (paramMessage.arg1)
        {
        }
        while (this.a.jdField_b_of_type_Boolean)
        {
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131363753);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (paramMessage.arg1 == 20)
        {
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131363751);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evx
 * JD-Core Version:    0.7.0.1
 */