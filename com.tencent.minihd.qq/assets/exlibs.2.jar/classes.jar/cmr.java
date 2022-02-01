import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class cmr
  implements View.OnClickListener
{
  public cmr(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    }
    for (;;)
    {
      this.a.b = null;
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
 * Qualified Name:     cmr
 * JD-Core Version:    0.7.0.1
 */