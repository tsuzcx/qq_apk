import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.MQPIntChkHandler;
import com.tencent.qphone.base.util.QLog;

public class hle
  extends BroadcastReceiver
{
  public hle(MQPIntChkHandler paramMQPIntChkHandler, DownloadManager paramDownloadManager) {}
  
  @SuppressLint({"NewApi"})
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    String str;
    Object localObject;
    if (MQPIntChkHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMQPIntChkHandler) == l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "download complete.");
      }
      str = "";
      localObject = new DownloadManager.Query();
      ((DownloadManager.Query)localObject).setFilterById(new long[] { l });
      paramIntent = null;
    }
    try
    {
      Cursor localCursor = this.jdField_a_of_type_AndroidAppDownloadManager.query((DownloadManager.Query)localObject);
      localObject = str;
      if (localCursor != null)
      {
        localObject = str;
        paramIntent = localCursor;
        if (localCursor.moveToFirst())
        {
          paramIntent = localCursor;
          localObject = localCursor.getString(localCursor.getColumnIndex("local_filename"));
        }
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if ((localObject != null) && (localObject != ""))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "install downloaded package:" + (String)localObject);
        }
        paramIntent = new Intent("android.intent.action.VIEW");
        paramIntent.setDataAndType(Uri.parse("file://" + (String)localObject), "application/vnd.android.package-archive");
        paramIntent.setFlags(268435456);
        paramContext.startActivity(paramIntent);
      }
      return;
    }
    finally
    {
      if (paramIntent != null) {
        paramIntent.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hle
 * JD-Core Version:    0.7.0.1
 */