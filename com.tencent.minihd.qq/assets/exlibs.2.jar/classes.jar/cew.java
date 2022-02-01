import android.os.Bundle;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class cew
  implements BusinessObserver
{
  public cew(EnterpriseDetailActivity paramEnterpriseDetailActivity) {}
  
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
      paramBundle.jdField_a_of_type_Int -= 1;
      if (this.a.jdField_a_of_type_Int == 0) {
        EnterpriseDetailActivity.b(this.a);
      }
      return;
      Object localObject = new JSONObject();
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.qq.com");
        EventApiPlugin.a("unfollow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label308;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.UnFollowResponse();
          ((mobileqq_mp.UnFollowResponse)localObject).mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)((mobileqq_mp.UnFollowResponse)localObject).ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "unfollow success");
            }
            this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
            EnterpriseDetailActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.b, 0);
            EnterpriseDetailActivity.a(this.a);
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
        this.a.a(2131363617);
      }
      continue;
      label308:
      this.a.a(2131363617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cew
 * JD-Core Version:    0.7.0.1
 */