import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class kgs
  implements BusinessObserver
{
  public kgs(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.b(false);
    if ((this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    TroopBarReplyActivity localTroopBarReplyActivity = this.a;
    this.a.getString(2131363870);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label531;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        if (paramInt == 0) {
          continue;
        }
        localObject = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          this.a.getWindow().setSoftInputMode(19);
          this.a.jdField_d_of_type_Boolean = true;
          paramBundle = null;
          JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("post");
          if (localJSONObject == null) {
            continue;
          }
          paramBundle = localJSONObject.optString("title");
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) {
            continue;
          }
          this.a.a(this.a.jdField_d_of_type_JavaLangString, (JSONObject)localObject, paramBundle);
          return;
          paramBundle = paramBundle;
          paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9992) });
        }
        catch (Exception paramBundle)
        {
          Object localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("IphoneTitleBarActivity", 2, QLog.getStackTraceString(paramBundle));
          continue;
          paramBundle = new Intent();
          paramBundle.putExtra("result", ((JSONObject)localObject).toString());
          this.a.setResult(-1, paramBundle);
          this.a.finish();
          return;
        }
      }
      this.a.jdField_a_of_type_Boolean = false;
      QQToast.a(localTroopBarReplyActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      TroopBarUtils.a("reply_page", "fail", this.a.af, "4", "", "");
      return;
      localObject = paramBundle.getJSONObject("result");
      paramBundle = new StringBuffer();
      if ((this.a.jdField_b_of_type_JavaUtilArrayList != null) && (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        paramBundle.append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        paramBundle.append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_b_of_type_AndroidWidgetEditText))) {
        paramBundle.append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        paramBundle.append("5");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo != null) {
        paramBundle.append("6");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo != null) {
        paramBundle.append("7");
      }
      TroopBarUtils.a("reply_page", "suc", this.a.af, "", paramBundle.toString(), "");
      label531:
      paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9991) });
      continue;
      paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgs
 * JD-Core Version:    0.7.0.1
 */