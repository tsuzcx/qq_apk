import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class gzo
  implements DialogInterface.OnClickListener
{
  public gzo(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = this.a.getIntent();
    paramDialogInterface = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    Intent localIntent = new Intent();
    localIntent.setClassName((String)localObject, paramDialogInterface);
    localIntent.addFlags(603979776);
    localIntent.putExtra("file_send_path", ShortVideoPreviewActivity.a(this.a));
    localIntent.putExtra("file_send_size", ShortVideoPreviewActivity.b(this.a));
    localIntent.putExtra("file_send_duration", ShortVideoPreviewActivity.a(this.a));
    localIntent.putExtra("file_source", ShortVideoPreviewActivity.b(this.a));
    this.a.startActivity(localIntent);
    this.a.finish();
    localObject = new Intent("key_video_select_confirm_ok_click");
    ((Intent)localObject).putExtra("className", paramDialogInterface);
    this.a.sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gzo
 * JD-Core Version:    0.7.0.1
 */