import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.activity.PCActiveNoticeActiviy;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class eox
  implements DialogInterface.OnKeyListener
{
  public eox(PCActiveNoticeActiviy paramPCActiveNoticeActiviy) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      SettingCloneUtil.writeValue(this.a, PCActiveNoticeActiviy.a(this.a), null, "pcactive_notice_key", false);
      this.a.finish();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eox
 * JD-Core Version:    0.7.0.1
 */