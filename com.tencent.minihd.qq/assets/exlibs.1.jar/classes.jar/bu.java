import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class bu
  implements DialogInterface.OnClickListener
{
  public bu(LiteAdvanceActivity paramLiteAdvanceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckclearmsg");
    paramDialogInterface = (DataLineHandler)this.a.app.a(8);
    paramDialogInterface.d(32);
    paramDialogInterface.f();
    this.a.app.a().a().a();
    this.a.getIntent().putExtra("clear_flag", true);
    this.a.setResult(-1, this.a.getIntent());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.7.0.1
 */