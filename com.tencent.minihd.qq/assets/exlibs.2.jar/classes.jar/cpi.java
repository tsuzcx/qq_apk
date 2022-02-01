import android.os.Bundle;
import com.tencent.biz.webviewplugin.Ad;
import com.tencent.mobileqq.mp.SSOHttp.GdtAdResponse;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class cpi
  implements BusinessObserver
{
  public cpi(Ad paramAd) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    label4:
    do
    {
      SSOHttp.GdtAdResponse localGdtAdResponse;
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!paramBoolean);
          try
          {
            localGdtAdResponse = new SSOHttp.GdtAdResponse();
            paramBundle = paramBundle.getByteArray("data");
            if (paramBundle == null) {
              break label186;
            }
            localGdtAdResponse.mergeFrom(paramBundle);
            if (localGdtAdResponse.retcode.get() != 0) {
              break label177;
            }
            paramInt = localGdtAdResponse.adsType.get();
            if (paramInt == 0)
            {
              this.a.c = false;
              return;
            }
          }
          catch (Exception paramBundle)
          {
            this.a.c = false;
            return;
          }
          if (paramInt != 1) {
            break;
          }
          Ad.a(this.a, localGdtAdResponse.data.get());
          this.a.c = true;
        } while (!QLog.isColorLevel());
        QLog.d("qqbrowser ad", 2, Ad.a(this.a));
        return;
      } while (paramInt != 2);
      Ad.a(this.a, localGdtAdResponse.data.get());
      this.a.c = true;
    } while (!QLog.isColorLevel());
    QLog.d("qqbrowser ad", 2, Ad.a(this.a));
    return;
    label177:
    this.a.c = false;
    return;
    label186:
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpi
 * JD-Core Version:    0.7.0.1
 */