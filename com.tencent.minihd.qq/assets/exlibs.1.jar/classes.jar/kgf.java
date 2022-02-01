import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.utils.TroopBarShareUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class kgf
  implements BusinessObserver
{
  public kgf(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.b(false);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    TroopBarPublishActivity.a(this.a).setEnabled(true);
    TroopBarPublishActivity localTroopBarPublishActivity = this.a;
    this.a.getString(2131363870);
    if (paramBoolean)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label645;
        }
        localObject1 = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject1).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject1).ret.get();
        paramBundle = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject1).data.get());
        if (paramInt == 0) {
          break label237;
        }
        localObject1 = paramBundle.optString("msg");
        paramBundle = (Bundle)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(paramInt) });
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject1;
        for (;;)
        {
          paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9992) });
          continue;
          paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
        }
        paramBundle = new Intent();
        paramBundle.putExtra("result", ((JSONObject)localObject1).toString());
        this.a.setResult(-1, paramBundle);
        this.a.finish();
        return;
      }
      QQToast.a(localTroopBarPublishActivity, 1, paramBundle, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
        break label697;
      }
    }
    label645:
    label697:
    for (paramBundle = "0";; paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x)
    {
      TroopBarUtils.a("pub_page", "fail", paramBundle, "4", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.setItemEnable(true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.setEnabled(true);
      return;
      label237:
      localObject1 = paramBundle.getJSONObject("result");
      Object localObject2 = new StringBuffer();
      if ((this.a.jdField_b_of_type_JavaUtilArrayList != null) && (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
        ((StringBuffer)localObject2).append("0");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
        ((StringBuffer)localObject2).append("1");
      }
      if (!TextUtils.isEmpty(TroopBarUtils.a(this.a.jdField_b_of_type_AndroidWidgetEditText))) {
        ((StringBuffer)localObject2).append("2");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) {
        ((StringBuffer)localObject2).append("5");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataMusicInfo != null) {
        ((StringBuffer)localObject2).append("6");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo != null) {
        ((StringBuffer)localObject2).append("7");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar == null)
      {
        paramBundle = "0";
        TroopBarUtils.a("pub_page", "suc", paramBundle, this.a.ac, ((StringBuffer)localObject2).toString(), "");
        this.a.d = true;
        localObject2 = ((JSONObject)localObject1).optString("pid");
        if ((this.a.c) && (this.a.jdField_a_of_type_OrgJsonJSONObject != null))
        {
          String str = this.a.jdField_a_of_type_OrgJsonJSONObject.optString("share_app_name");
          long l = this.a.jdField_a_of_type_OrgJsonJSONObject.optLong("share_app_id");
          paramBundle = "";
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar != null) {
            paramBundle = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar.x;
          }
          TroopBarShareUtils.a(this.a, str, l, paramBundle, (String)localObject2);
          TroopBarShareUtils.a(this.a.app, "share_suc", paramBundle);
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) {
          break label608;
        }
        this.a.a((String)localObject2, (JSONObject)localObject1, this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      }
      label608:
      paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9991) });
      break;
      paramBundle = this.a.getString(2131363871, new Object[] { Integer.valueOf(9992) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgf
 * JD-Core Version:    0.7.0.1
 */