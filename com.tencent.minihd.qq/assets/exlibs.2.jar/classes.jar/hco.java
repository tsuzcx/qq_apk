import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.IntentFactory;

public final class hco
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("downloadUrl", "https://dldir1.qq.com/music/qqmusichd_qqhd.apk");
    paramDialogInterface.putString("packageName", "com.tencent.qqmusicpad");
    paramDialogInterface = new DownloadInfo("", "https://dldir1.qq.com/music/qqmusichd_qqhd.apk", "com.tencent.qqmusicpad", "QQ_MUSIC_HD", "", IntentFactory.a(paramDialogInterface), 0, true);
    DownloadManager.a().a(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hco
 * JD-Core Version:    0.7.0.1
 */