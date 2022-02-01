import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dne
  extends DownloadListener
{
  public dne(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.z == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryForC2C", 2, "blue banner download success!");
      }
      localObject = new File(this.a.getFilesDir(), paramDownloadTask.a);
      if (((File)localObject).exists())
      {
        paramDownloadTask = this.a.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        localEditor = paramDownloadTask.edit();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray(FileUtils.a((File)localObject));
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label453;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
          break label459;
        }
        localEditor.putInt("blue_banner_cheak_update_internal", localJSONObject.getInt("updateinternal"));
        localEditor.putInt("blue_banner_show_internal", localJSONObject.getInt("showinternal"));
        localEditor.putInt("blue_banner_show_time", localJSONObject.getInt("showtime"));
        localEditor.putString("blue_banner_go_url", localJSONObject.getString("url"));
        localEditor.putString("blue_banner_notvip_text", localJSONObject.getString("notvip"));
        localEditor.putString("blue_banner_vip_text", localJSONObject.getString("vip"));
        localEditor.putString("blue_banner_svip_text", localJSONObject.getString("svip"));
        localEditor.commit();
        if (bool)
        {
          paramDownloadTask.edit().putLong("blue_banner_last_update_timestamp", NetConnInfoCenter.getServerTimeMillis()).commit();
          return;
        }
        if (!QLog.isColorLevel()) {
          break label458;
        }
        QLog.e("ChatHistoryForC2C", 2, "save sp error , isSaveSuccess" + bool);
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label458;
        }
        QLog.e("ChatHistoryForC2C", 2, "JSONException,blue banner parse json error : " + paramDownloadTask.toString());
        return;
      }
      catch (Exception paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label458;
        }
      }
      QLog.e("ChatHistoryForC2C", 2, "Exception,blue banner parse json error : " + paramDownloadTask.toString());
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("ChatHistoryForC2C", 2, "blue banner download file save failed!");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("ChatHistoryForC2C", 2, "blue banner download failed, task.status = " + paramDownloadTask.a() + " , task.errCode = " + paramDownloadTask.z);
          return;
          label453:
          bool = false;
          continue;
        }
      }
      label458:
      return;
      label459:
      i += 1;
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ChatHistoryForC2C", 2, "blue banner download progress!");
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ChatHistoryForC2C", 2, "blue banner download start!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dne
 * JD-Core Version:    0.7.0.1
 */