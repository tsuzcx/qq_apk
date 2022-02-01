import android.content.Intent;
import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import mqq.app.permission.PermissionCallback;

class kbp
  implements PermissionCallback
{
  kbp(kbo paramkbo) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.a, paramInt, paramArrayOfString, new kbq(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new Intent();
    paramArrayOfString.putExtra("audio_max_length", this.a.a.S);
    if (this.a.a.af != null)
    {
      paramArrayOfString.putExtra("from", "publish");
      paramArrayOfString.putExtra("bid", this.a.a.af);
      paramArrayOfString.putExtra("fromflag", this.a.a.ac);
      TroopBarUtils.a(this.a.a.ad, this.a.a.ae, "Clk_record", this.a.a.af, this.a.a.ac, "", "");
    }
    paramArrayOfString.setClass(this.a.a.a, AudioRecordActivity.class);
    this.a.a.startActivityForResult(paramArrayOfString, 1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbp
 * JD-Core Version:    0.7.0.1
 */