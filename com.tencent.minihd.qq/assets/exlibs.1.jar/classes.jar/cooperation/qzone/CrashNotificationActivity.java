package cooperation.qzone;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import mas;

public class CrashNotificationActivity
  extends Activity
{
  private Dialog a = null;
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903387);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131298061);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131298060);
    localObject = (TextView)((Window)localObject).findViewById(2131298055);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131367562) + "5.9.3" + getString(2131367563));
    localObject = new mas(this);
    localButton1.setOnClickListener((View.OnClickListener)localObject);
    localButton2.setOnClickListener((View.OnClickListener)localObject);
    return localAlertDialog;
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    try
    {
      this.a = a();
      if (this.a != null)
      {
        this.a.setCancelable(false);
        this.a.show();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a();
      }
    }
  }
  
  public void a()
  {
    finish();
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903386);
    b();
  }
  
  public void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.CrashNotificationActivity
 * JD-Core Version:    0.7.0.1
 */