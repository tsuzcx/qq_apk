package cooperation.qwallet.open;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class AppPayActivity
  extends BaseActivity
{
  public static final int a = 21;
  private boolean a = false;
  
  private void a()
  {
    Intent localIntent = super.getIntent();
    if ((localIntent != null) && (!TextUtils.isEmpty(localIntent.getAction())) && (localIntent.getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(localIntent.getScheme())) && (localIntent.getScheme().equals("mqqwallet")))
    {
      a(true);
      return;
    }
    super.finish();
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject1 = new Intent(this, LoginActivity.class);
      ((Intent)localObject1).putExtra("isActionSend", true);
      ((Intent)localObject1).putExtras(localIntent);
      super.startActivityForResult((Intent)localObject1, 21);
      return;
    }
    Object localObject1 = null;
    try
    {
      String str = localIntent.getDataString();
      localObject1 = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
      localObject2 = new PayApi();
      if ("mqqwallet://open_pay/".compareTo((String)localObject1) != 0) {
        break label125;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).length() <= 9))
    {
      super.finish();
      return;
    }
    try
    {
      Object localObject2;
      ((PayApi)localObject2).b(localIntent.getExtras());
      label125:
      if (((PayApi)localObject2).a())
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("extra.key.pay.type", 1);
        ((Bundle)localObject1).putInt("extra.key.pay.from", 2);
        ((Bundle)localObject1).putString("appId", ((PayApi)localObject2).jdField_a_of_type_JavaLangString);
        ((Bundle)localObject1).putString("callbackSn", ((PayApi)localObject2).e);
        ((Bundle)localObject1).putString("nonce", ((PayApi)localObject2).j);
        ((Bundle)localObject1).putLong("timeStamp", ((PayApi)localObject2).jdField_a_of_type_Long);
        ((Bundle)localObject1).putString("sig", ((PayApi)localObject2).m);
        ((Bundle)localObject1).putString("sigType", ((PayApi)localObject2).l);
        ((Bundle)localObject1).putString("tokenId", ((PayApi)localObject2).i);
        ((Bundle)localObject1).putString("pubAcc", ((PayApi)localObject2).g);
        ((Bundle)localObject1).putString("pubAccHint", ((PayApi)localObject2).h);
        ((Bundle)localObject1).putString("bargainorId", ((PayApi)localObject2).k);
        ((Bundle)localObject1).putString("qVersion", "5.9.3");
        ((Bundle)localObject1).putString("packageName", ((PayApi)localObject2).n);
        ((Bundle)localObject1).putString("callbackScheme", ((PayApi)localObject2).f);
        localObject2 = new Intent(this, OpenPayActivity.class);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).addFlags(67108864);
        super.startActivity((Intent)localObject2);
      }
      super.finish();
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    try
    {
      super.doOnCreate(paramBundle);
      if ((mAppForground) || (!this.mCanLock) || (this.app == null) || (this.app.a() == null) || (!GesturePWDUtils.getJumpLock(this, this.app.a()))) {
        break label94;
      }
      this.a = true;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("qqBaseActivity", 2, "doOnCreate|exp:" + paramBundle.getMessage());
      return false;
    }
    return false;
    label94:
    a();
    return false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((!mShowGesture) && (this.a))
    {
      this.a = false;
      a();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qwallet.open.AppPayActivity
 * JD-Core Version:    0.7.0.1
 */