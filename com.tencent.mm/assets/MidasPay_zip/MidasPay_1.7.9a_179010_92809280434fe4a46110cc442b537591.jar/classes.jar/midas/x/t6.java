package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;

public class t6
  extends ProgressDialog
{
  public boolean a = true;
  public String b = "请稍候...";
  public TextView c = null;
  public ProgressBar d = null;
  
  public t6(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      super.dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165235);
    this.d = ((ProgressBar)findViewById(2131100038));
    paramBundle = new AlphaAnimation(1.0F, 0.2F);
    paramBundle.setDuration(600L);
    paramBundle.setRepeatCount(-1);
    paramBundle.setRepeatMode(2);
    this.d.setAnimation(paramBundle);
    paramBundle.start();
    this.c = ((TextView)findViewById(2131099738));
    this.c.setText(this.b);
    setCancelable(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.a)
      {
        APLog.i("APProgressDialog", "isAllowCancel=true");
        cancel();
        return false;
      }
      APLog.i("APProgressDialog", "isAllowCancel=false");
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    super.setMessage(paramCharSequence);
    this.b = String.valueOf(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.t6
 * JD-Core Version:    0.7.0.1
 */