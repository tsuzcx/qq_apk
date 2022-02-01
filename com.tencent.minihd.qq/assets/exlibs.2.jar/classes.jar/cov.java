import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.troopplugin.PluginJumpManager;

public class cov
  implements AsyncBack
{
  public cov(PluginJumpManager paramPluginJumpManager) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      HtmlOffline.a("urlplugin.cfg", this.a.mContext, "1007", new cow(this));
    }
    while (!TextUtils.isEmpty(this.a.mPref.getString("config_file_version", ""))) {
      return;
    }
    this.a.loadConfigFromFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cov
 * JD-Core Version:    0.7.0.1
 */