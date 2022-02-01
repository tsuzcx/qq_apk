package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APUICommonMethod;

public class aw
  extends ProgressDialog
{
  private Context a;
  private int b = 0;
  
  public aw(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramInt;
  }
  
  public aw(Context paramContext, int paramInt, ar paramar)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramInt;
  }
  
  private void a(Context paramContext)
  {
    setContentView(2131165263);
    setCancelable(false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(this.a);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.b == 3)
    {
      if (paramInt == 4)
      {
        cancel();
        APDataReportManager.getInstance().insertData("sdk.update.force.keyback", -1);
        APUICommonMethod.b();
        fm.a(2, "");
        return false;
      }
    }
    else
    {
      if (this.b == 2) {
        return true;
      }
      if ((this.b == 1) && (paramInt == 4)) {
        return false;
      }
    }
    return false;
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.aw
 * JD-Core Version:    0.7.0.1
 */