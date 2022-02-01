package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import com.pay.data.report.APDataReportManager;
import com.pay.ui.common.APUICommonMethod;

public class x0
  extends ProgressDialog
{
  public Context a;
  public int b = 0;
  
  public x0(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramInt;
  }
  
  public x0(Context paramContext, int paramInt, s0 params0)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramInt;
  }
  
  public final void a(Context paramContext)
  {
    setContentView(2131165264);
    setCancelable(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(this.a);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i = this.b;
    if (i == 3)
    {
      if (paramInt == 4)
      {
        cancel();
        APDataReportManager.getInstance().insertData("sdk.update.force.keyback", -1);
        APUICommonMethod.f();
        z5.a(2, "");
        return false;
      }
    }
    else
    {
      if (i == 2) {
        return true;
      }
      if ((i != 1) || (paramInt != 4)) {}
    }
    return false;
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x0
 * JD-Core Version:    0.7.0.1
 */