package midas.x;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import com.pay.ui.common.APUICommonMethod;

public class p8
  extends k8
{
  public static final long serialVersionUID = 1L;
  public Activity e = null;
  public e8 f = null;
  public ProgressDialog g = null;
  
  public p8()
  {
    c();
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(Activity paramActivity, e8 parame8, Bundle paramBundle)
  {
    super.a(paramActivity, parame8, paramBundle);
    this.e = paramActivity;
    this.f = parame8;
  }
  
  public void a(ProgressDialog paramProgressDialog)
  {
    super.a(paramProgressDialog);
    paramProgressDialog = this.g;
    if (paramProgressDialog != null) {
      paramProgressDialog.show();
    }
    paramProgressDialog = this.f;
    if (paramProgressDialog != null) {
      paramProgressDialog.b(f());
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
  }
  
  public boolean e()
  {
    this.e.finish();
    APUICommonMethod.a(this.e);
    return true;
  }
  
  public String f()
  {
    return "http://game.qq.com/contract.shtml";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p8
 * JD-Core Version:    0.7.0.1
 */