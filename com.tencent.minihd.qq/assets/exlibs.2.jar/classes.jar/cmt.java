import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cmt
  implements ActionSheet.OnButtonClickListener
{
  public cmt(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    this.a.d = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      if (!this.a.a)
      {
        this.a.c();
        if ((this.a.k & 0x1) != 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "", "", "0X800416E", "0X800416E", 0, 0, "", "", "", "");
          continue;
          if (!this.a.a)
          {
            this.a.d();
            if ((this.a.k & 0x1) != 0)
            {
              ReportController.b(this.a.app, "P_CliOper", "", "", "0X8004170", "0X8004170", 0, 0, "", "", "", "");
              continue;
              if (!this.a.a)
              {
                this.a.b();
                if ((this.a.k & 0x1) != 0) {
                  ReportController.b(this.a.app, "P_CliOper", "", "", "0X8004171", "0X8004171", 0, 0, "", "", "", "");
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cmt
 * JD-Core Version:    0.7.0.1
 */