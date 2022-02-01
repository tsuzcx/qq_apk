import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class eew
  implements View.OnClickListener
{
  public eew(IndividuationSetActivity paramIndividuationSetActivity, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new JSONObject();
    try
    {
      paramView.put("userId", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.put("openMonth", this.jdField_a_of_type_Int);
      paramView.put("aid", "mvip.gexinghua.android.zbcenter_native_xufei");
      paramView.put("offerId", "1450000515");
      paramView.put("serviceName", this.jdField_a_of_type_JavaLangString);
      paramView.put("serviceCode", this.b);
      paramView = paramView.toString();
      PayBridgeActivity.tenpay(this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity, paramView, 4, "IndividuationVIP");
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eew
 * JD-Core Version:    0.7.0.1
 */