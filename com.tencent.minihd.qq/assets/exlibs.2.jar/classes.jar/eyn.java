import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.observer.AccountObserver;

public class eyn
  extends AccountObserver
{
  public eyn(RegisterSendUpSms paramRegisterSendUpSms) {}
  
  public void onRegisterQuerySmsStatResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("RegisterSendUpSms", 2, "RegisterPhoneNumActivity onRegisterQuerySmsStatResp");
    }
    if (this.a.isFinishing()) {}
    do
    {
      return;
      if (!paramBoolean)
      {
        RegisterSendUpSms.d(this.a);
        try
        {
          paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
          localObject = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            localObject = this.a.getString(2131366833);
          }
          this.a.a((String)localObject, 1);
          return;
        }
        catch (UnsupportedEncodingException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
            paramArrayOfByte = null;
          }
        }
      }
      if (paramArrayOfByte != null) {}
      try
      {
        localObject = new String(paramArrayOfByte, "utf-8");
        if (QLog.isColorLevel()) {
          QLog.d("RegisterSendUpSms", 2, "RegisterPhoneNumActivity onRegisterQuerySmsStatResp code = " + paramInt1 + ";strMsg = " + (String)localObject + ";next_chk_time =" + paramInt2 + ";total_time_over =" + paramInt3);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      RegisterSendUpSms.d(this.a);
      if (paramInt1 == 0)
      {
        RegisterVerifyCodeActivity.a(this.a.app, this.a, this.a.d, this.a.e, this.a.f, RegisterSendUpSms.a(this.a));
        RegisterSendUpSms.c(this.a);
        return;
      }
    } while (paramInt1 != 4);
    paramInt1 = paramInt3;
    if (paramInt3 <= 0) {
      paramInt1 = 60000;
    }
    paramInt3 = paramInt2;
    if (paramInt2 <= 60) {
      paramInt3 = 60;
    }
    this.a.b.post(new eyo(this, paramInt3));
    try
    {
      this.a.b.postDelayed(new eyp(this), paramInt1 * 1000);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyn
 * JD-Core Version:    0.7.0.1
 */