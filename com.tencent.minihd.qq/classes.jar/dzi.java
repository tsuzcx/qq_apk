import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dzi
  extends Thread
{
  public dzi(ForwardOperations paramForwardOperations) {}
  
  public void run()
  {
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || ((this.a.c) && (!TextUtils.isEmpty((CharSequence)localObject1)))) {
        if ((this.a.v != 11) || (ForwardOperations.b(this.a))) {
          break label82;
        }
      }
      label82:
      Object localObject2;
      HashMap localHashMap;
      try
      {
        Thread.sleep(1000L);
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
        i += 1;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    if ((!this.a.c) || (TextUtils.isEmpty(this.a.G)))
    {
      ForwardOperations.b(this.a);
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new dzj(this));
      return;
    }
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()))
    {
      this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new dzk(this));
      return;
    }
    if (this.a.w == 5)
    {
      this.a.c();
      return;
    }
    localObject2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("image_url");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("Connection", "keep-alive");
      ((Map)localObject1).put("Referer", "https://www.qq.com");
      localHashMap = new HashMap();
      localHashMap.put("share_image", localObject2);
      localObject2 = new HashMap();
      ((Map)localObject2).put("mType", "qb_share");
      localObject1 = HttpUtil.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.a.G, (Map)localObject2, localHashMap, (Map)localObject1);
      if (localObject1 != null) {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          if ((((JSONObject)localObject1).getInt("retcode") == 0) && (((JSONObject)localObject1).has("result")))
          {
            localObject1 = ((JSONObject)localObject1).getJSONObject("result");
            this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
            this.a.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", ((JSONObject)localObject1).getString("url"));
            this.a.c();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOperations", 2, localJSONException.getMessage());
          }
        }
      }
      this.a.c();
      return;
    }
    this.a.jdField_a_of_type_AndroidOsBundle.remove("image_url");
    this.a.c();
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dzi
 * JD-Core Version:    0.7.0.1
 */