import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.troopbar.TroopBarDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class coo
  implements BusinessObserver
{
  public coo(TroopBarDetailActivity paramTroopBarDetailActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.a(2131363617);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int == 0) {
        TroopBarDetailActivity.a(this.a);
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cop(this), 1000L);
      return;
      Object localObject = new JSONObject();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        ((JSONObject)localObject).put("name", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        ((JSONObject)localObject).put("summary", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.qq.com");
        EventApiPlugin.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label461;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            if (this.a.d) {
              ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_b_of_type_JavaLangString, "mp_msg_sys_12", "scan_via", 0, 0, "", "", "", this.a.e);
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType = 1;
            TroopBarDetailActivity.b(this.a);
            TroopBarDetailActivity.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
            TroopBarDetailActivity.c(this.a);
            PublicAccountManager.a().a(this.a.getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_JavaLangString, null, true);
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (paramInt == 58)
        {
          this.a.a(2131363621);
          continue;
        }
        this.a.a(2131363617);
      }
      continue;
      label461:
      this.a.a(2131363617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coo
 * JD-Core Version:    0.7.0.1
 */