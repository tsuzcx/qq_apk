import android.os.Bundle;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class hqh
  implements BusinessObserver
{
  public hqh(TroopManager paramTroopManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject = paramBundle.getByteArray("data");
    paramBundle = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramBundle.mergeFrom((byte[])localObject);
      paramBundle.uint32_result.get();
      localObject = new oidb_0x787.RspBody();
      ((oidb_0x787.RspBody)localObject).mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
      ((oidb_0x787.RspBody)localObject).rpt_msg_member_level_info.get();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hqh
 * JD-Core Version:    0.7.0.1
 */