import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cdq
  implements Handler.Callback
{
  static final int jdField_d_of_type_Int = 0;
  static final int e = 1;
  static final int f = 2;
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  AsyncBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack;
  String jdField_a_of_type_JavaLangString = null;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  private AsyncBack jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack;
  String jdField_b_of_type_JavaLangString;
  protected boolean b;
  public int c;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private int g = 0;
  
  public cdq(Context paramContext, String paramString1, String paramString2, AsyncBack paramAsyncBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack = paramAsyncBack;
    this.d = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramContext = HtmlOffline.b(this.jdField_c_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramContext)) {
      this.jdField_a_of_type_JavaLangString = (paramContext + this.jdField_c_of_type_JavaLangString + ".zip");
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, paramInt1);
    }
    HtmlOffline.b(this.jdField_c_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "checkUpFinished code:" + paramInt1);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {}
    do
    {
      JSONArray localJSONArray;
      do
      {
        return;
        int j = paramJSONObject.optInt("expire", 0);
        if (1 == j) {
          HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, j);
        }
        localJSONArray = paramJSONObject.optJSONArray("expirelist");
      } while (localJSONArray == null);
      while (i < localJSONArray.length())
      {
        Object localObject = localJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("bid");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
          }
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, "expire list :" + paramJSONObject.toString());
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("HtmlCheckUpdate", 4, "downUpdateZip:" + paramString1);
    }
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new cdr(this, l, paramString2, paramInt1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  private void b()
  {
    if (HtmlOffline.f(this.jdField_c_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, this.jdField_c_of_type_JavaLangString + " is downloading");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, this.jdField_c_of_type_JavaLangString + "download");
        }
        if ((HtmlOffline.a == null) || (HtmlOffline.a.size() < 1)) {
          break;
        }
        HtmlOffline.a(this);
      } while (!QLog.isColorLevel());
      QLog.i("HtmlCheckUpdate", 2, this.jdField_c_of_type_JavaLangString + "add to queue");
      return;
      ThreadManager.a(new cdt(this));
      if (QLog.isColorLevel()) {
        QLog.i("HtmlCheckUpdate", 2, this.jdField_c_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
      }
      HtmlOffline.a(this.jdField_c_of_type_JavaLangString);
    } while (!QLog.isColorLevel());
    QLog.i("HtmlCheckUpdate", 2, this.jdField_c_of_type_JavaLangString + "start download");
  }
  
  public void a()
  {
    boolean bool = false;
    Object localObject1 = HtmlOffline.a(this.jdField_c_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (int i = ((JSONObject)localObject1).optInt("version", 0);; i = 0)
    {
      localObject1 = new HashMap(1);
      ((HashMap)localObject1).put(this.jdField_c_of_type_JavaLangString, i + "");
      String str = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, (HashMap)localObject1, this.d, 0);
      if (str == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "getUpdateConfig: null");
        }
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
        return;
      }
      Message localMessage;
      try
      {
        localObject1 = new JSONObject(str);
        j = ((JSONObject)localObject1).optInt("r", -1);
        if (j != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("HtmlCheckUpdate", 2, "doCheckUp get config fail: r=：" + j);
          }
          localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, 0);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("HtmlCheckUpdate", 2, "get config fail:JSONException");
        }
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        return;
      }
      int j = localMessage.optInt("type", -1);
      this.jdField_a_of_type_Int = j;
      Object localObject2;
      if (j > 0)
      {
        localObject2 = localMessage.optString("url");
        this.jdField_c_of_type_Int = localMessage.optInt("version");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          if ((localMessage.optInt("updateNotification") == 1) && (i != 0)) {
            if (this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
              this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack.a(str, 9);
            }
          }
        }
      }
      for (;;)
      {
        a(localMessage);
        return;
        i = localMessage.optInt("filesize", 0);
        str = localMessage.optString("full_package_url");
        if (localMessage.optInt("bsdiff") > 0) {
          bool = true;
        }
        this.jdField_b_of_type_Boolean = bool;
        a((String)localObject2, str, i, localMessage.optInt("base_filesize"));
        continue;
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 2, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        continue;
        localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 8, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      HtmlOffline.b(this.jdField_c_of_type_JavaLangString);
      continue;
      b();
      continue;
      a(paramMessage.arg1, paramMessage.arg2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdq
 * JD-Core Version:    0.7.0.1
 */