import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.SmartHardwareActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import mqq.observer.BusinessObserver;

public class lck
  implements BusinessObserver
{
  public lck(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      SdkAuthorize.AuthorizeResponse localAuthorizeResponse = new SdkAuthorize.AuthorizeResponse();
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          paramBundle = (SdkAuthorize.AuthorizeResponse)localAuthorizeResponse.mergeFrom(paramBundle);
          if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.openid.get())) && (!TextUtils.isEmpty(paramBundle.access_token.get())))
          {
            SmartHardwareActivity.a(this.a.getActivity(), paramBundle.openid.get(), this.a.app.getAccount(), "1300000607");
            this.a.e = paramBundle.openid.get();
            SmartHardwareActivity.a(this.a, paramBundle.encrytoken.get(), paramBundle.access_token.get());
            this.a.a();
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        this.a.a.dismiss();
        LogUtility.e("SmartHardwareActivity", "Can't get openid!");
        ToastUtil.a().a(2131362638);
        this.a.finish();
        return;
      }
    }
    this.a.a.dismiss();
    LogUtility.e("SmartHardwareActivity", "Can't get openid!");
    ToastUtil.a().a(2131362638);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lck
 * JD-Core Version:    0.7.0.1
 */