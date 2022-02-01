import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class fzm
  implements ActionSheet.OnDismissListener
{
  fzm(fzl paramfzl) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a.a.a, "CliOper", "", "", "0X8004862", "0X8004862", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzm
 * JD-Core Version:    0.7.0.1
 */