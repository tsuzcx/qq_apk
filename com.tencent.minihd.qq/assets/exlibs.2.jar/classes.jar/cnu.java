import android.os.Bundle;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class cnu
  implements BusinessObserver
{
  public cnu(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      EditUniqueTitleActivity.a(this.a, -1);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    try
    {
      localOIDBSSOPkg.mergeFrom(paramBundle);
      paramInt = localOIDBSSOPkg.uint32_result.get();
      EditUniqueTitleActivity.a(this.a, paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      EditUniqueTitleActivity.a(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cnu
 * JD-Core Version:    0.7.0.1
 */