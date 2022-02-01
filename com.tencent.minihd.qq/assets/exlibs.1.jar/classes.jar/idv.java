import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class idv
  extends DatingObserver
{
  public idv(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    PublicDatingActivity.a(this.a, true);
    this.a.e();
    if (paramBoolean)
    {
      if (PublicDatingActivity.a(this.a).equals("userCenter"))
      {
        paramString2 = new Intent();
        paramString2.putExtra("new_id", paramString1);
        this.a.setIntent(paramString2);
        this.a.setResult(-1);
      }
      for (;;)
      {
        this.a.finish();
        return;
        if (PublicDatingActivity.a(this.a).equals("feed"))
        {
          paramString2 = new Intent(this.a, DatingUserCenterActivity.class);
          paramString2.putExtra("new_id", paramString1);
          this.a.startActivity(paramString2);
        }
        else if (PublicDatingActivity.a(this.a).equals("detail"))
        {
          this.a.setResult(-1);
        }
        else if (PublicDatingActivity.a(this.a).equals("web"))
        {
          if (this.a.getIntent() == null)
          {
            paramString2 = "";
            label177:
            if (TextUtils.isEmpty(paramString2)) {
              this.a.finish();
            }
          }
          try
          {
            paramString3 = new URL(paramString2).getHost();
            paramString2 = paramString3;
            if (TextUtils.isEmpty(paramString2)) {
              this.a.finish();
            }
            paramString3 = new ArrayList();
            paramString3.add(paramString2);
            paramString2 = new JSONObject();
          }
          catch (MalformedURLException paramString3)
          {
            try
            {
              paramString2.put("datingId", paramString1);
              paramString2.put("uin", this.a.app.a());
              EventApiPlugin.a("onDatingPublishSuccess", paramString2, paramString3, null);
              if (!this.a.e) {
                continue;
              }
              paramString2 = new Intent(this.a, DatingUserCenterActivity.class);
              paramString2.putExtra("new_id", paramString1);
              paramString2.putExtra("abp_flag", this.a.e);
              this.a.startActivity(paramString2);
              continue;
              paramString2 = this.a.getIntent().getStringExtra("webUrl");
              break label177;
              paramString3 = paramString3;
              if (QLog.isColorLevel()) {
                QLog.i("Q.dating", 2, "publish dating success, from web, getHost error: " + paramString2);
              }
              paramString2 = "";
            }
            catch (JSONException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
        }
        else if ((PublicDatingActivity.a(this.a).equals("guide")) && (this.a.e))
        {
          paramString2 = new Intent(this.a, DatingUserCenterActivity.class);
          paramString2.putExtra("new_id", paramString1);
          paramString2.putExtra("abp_flag", this.a.e);
          this.a.startActivity(paramString2);
        }
      }
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      this.a.a(2, paramString3, 0);
      return;
      paramString3 = this.a.getString(2131369792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idv
 * JD-Core Version:    0.7.0.1
 */