package midas.x;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.midas.comm.APLog;

public class gj
  extends ProgressDialog
{
  private String a = "请稍候...";
  private TextView b = null;
  private Context c = null;
  private boolean d = false;
  private boolean e = true;
  
  public gj(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    }
    if (this.d)
    {
      setContentView(2131165250);
      ((AnimationDrawable)((ImageView)findViewById(2131099655)).getDrawable()).start();
    }
    else
    {
      setContentView(2131165234);
      paramBundle = (ProgressBar)findViewById(2131100038);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
      localAlphaAnimation.setDuration(600L);
      localAlphaAnimation.setRepeatCount(-1);
      localAlphaAnimation.setRepeatMode(2);
      paramBundle.setAnimation(localAlphaAnimation);
      localAlphaAnimation.start();
      this.b = ((TextView)findViewById(2131099738));
      this.b.setText(this.a);
    }
    setCancelable(false);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.e)
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
    this.a = String.valueOf(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gj
 * JD-Core Version:    0.7.0.1
 */