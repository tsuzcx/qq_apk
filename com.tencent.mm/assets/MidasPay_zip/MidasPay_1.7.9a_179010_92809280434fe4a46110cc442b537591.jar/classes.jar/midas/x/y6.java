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

public class y6
  extends ProgressDialog
{
  public String a = "请稍候...";
  public TextView b = null;
  public boolean c = false;
  public boolean d = true;
  
  public y6(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setBackgroundDrawable(new ColorDrawable(0));
      paramBundle.setGravity(17);
    }
    if (this.c)
    {
      setContentView(2131165251);
      ((AnimationDrawable)((ImageView)findViewById(2131099655)).getDrawable()).start();
    }
    else
    {
      setContentView(2131165235);
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
      if (this.d)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y6
 * JD-Core Version:    0.7.0.1
 */