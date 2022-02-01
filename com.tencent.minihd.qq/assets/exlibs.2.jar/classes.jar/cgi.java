import android.os.Bundle;
import com.tencent.biz.helper.TroopCardAppInfoHelper;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class cgi
  implements BusinessObserver
{
  public cgi(TroopCardAppInfoHelper paramTroopCardAppInfoHelper) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (TroopCardAppInfoHelper.a(this.a)) {
      return;
    }
    if ((!paramBoolean) || (paramBundle == null))
    {
      TroopCardAppInfoHelper.a(this.a);
      return;
    }
    do
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramBundle);
        if ((localOIDBSSOPkg == null) || (!localOIDBSSOPkg.uint32_result.has()) || (localOIDBSSOPkg.uint32_result.get() != 0) || (!localOIDBSSOPkg.bytes_bodybuffer.has()) || (localOIDBSSOPkg.bytes_bodybuffer.get() == null))
        {
          TroopCardAppInfoHelper.a(this.a);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        TroopCardAppInfoHelper.a(this.a);
        return;
      }
      paramBundle = TroopCardAppInfoHelper.b(this.a, localOIDBSSOPkg);
    } while ((paramBundle == null) || (paramBundle.size() <= 0));
    TroopCardAppInfoHelper.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgi
 * JD-Core Version:    0.7.0.1
 */