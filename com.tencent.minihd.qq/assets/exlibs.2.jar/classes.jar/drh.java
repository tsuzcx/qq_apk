import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class drh
  implements View.OnClickListener
{
  public drh(ChatTextSizeSettingActivity paramChatTextSizeSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.e = 0;
    }
    for (;;)
    {
      this.a.a(this.a.e);
      ReportController.b(this.a.app, "CliOper", "", "", "Trends_tab", "Font_size", 0, 0, Integer.toString(this.a.e), "", "", "");
      return;
      this.a.e = 1;
      continue;
      this.a.e = 2;
      continue;
      this.a.e = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drh
 * JD-Core Version:    0.7.0.1
 */