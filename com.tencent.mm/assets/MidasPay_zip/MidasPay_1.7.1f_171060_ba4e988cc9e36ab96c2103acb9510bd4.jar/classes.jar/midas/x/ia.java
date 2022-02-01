package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import com.pay.ui.common.APUICommonMethod;

public class ia
  extends hv
{
  private static final long serialVersionUID = 1L;
  private Activity f = null;
  private hp g = null;
  private ProgressDialog h = null;
  
  public ia()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, hp paramhp)
  {
    super.a(paramActivity, paramhp);
    this.f = paramActivity;
    this.g = paramhp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ia
 * JD-Core Version:    0.7.0.1
 */