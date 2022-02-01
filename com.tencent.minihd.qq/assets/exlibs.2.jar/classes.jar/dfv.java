import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dfv
  implements View.OnClickListener
{
  public dfv(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
    {
      if (this.a.d != -1011) {
        break label111;
      }
      this.a.a(AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ArrayOfByte, this.a.q, AddRequestActivity.b(this.a), AddRequestActivity.c(this.a), AddRequestActivity.b(this.a));
    }
    for (;;)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      return;
      label111:
      this.a.a(AddRequestActivity.a(this.a), AddRequestActivity.b(this.a), null, AddRequestActivity.c(this.a), AddRequestActivity.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfv
 * JD-Core Version:    0.7.0.1
 */