import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dvd
  implements DialogInterface.OnClickListener
{
  public dvd(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.a.getActivity()))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
      DiscussionInfoCardActivity.a(this.a).d(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue());
      this.a.a(this.a.getString(2131367795));
      DiscussionInfoCardActivity.a(this.a).show();
      return;
    }
    this.a.a(1, this.a.getString(2131367136));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvd
 * JD-Core Version:    0.7.0.1
 */