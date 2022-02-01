package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;

public class iw
  extends ir
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private ib g = null;
  private ProgressDialog h = null;
  
  public iw()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, ib paramib, Bundle paramBundle)
  {
    super.a(paramActivity, paramib, paramBundle);
    this.f = paramActivity;
    this.g = paramib;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    if (this.h != null) {
      this.h.show();
    }
    if (this.g != null) {
      this.g.b(b());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public boolean a()
  {
    this.f.finish();
    APUICommonMethod.b(this.f);
    return true;
  }
  
  public String b()
  {
    return "http://game.qq.com/contract.shtml";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.iw
 * JD-Core Version:    0.7.0.1
 */