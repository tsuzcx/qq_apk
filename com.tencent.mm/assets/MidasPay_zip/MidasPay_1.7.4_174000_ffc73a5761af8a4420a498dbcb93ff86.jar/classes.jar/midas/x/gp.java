package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;

public class gp
  extends ProgressDialog
{
  private boolean a = true;
  private String b = "请稍候...";
  private TextView c = null;
  private Context d = null;
  private ProgressBar e = null;
  
  public gp(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131165235);
    this.e = ((ProgressBar)findViewById(2131100038));
    paramBundle = new AlphaAnimation(1.0F, 0.2F);
    paramBundle.setDuration(600L);
    paramBundle.setRepeatCount(-1);
    paramBundle.setRepeatMode(2);
    this.e.setAnimation(paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gp
 * JD-Core Version:    0.7.0.1
 */