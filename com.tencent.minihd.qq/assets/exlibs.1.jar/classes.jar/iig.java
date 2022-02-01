import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class iig
  extends BroadcastReceiver
{
  NetworkInfo.State jdField_a_of_type_AndroidNetNetworkInfo$State = null;
  NetworkInfo.State b = null;
  
  public iig(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        break label27;
      }
    }
    label27:
    do
    {
      do
      {
        return;
      } while ((paramContext.getNetworkInfo(1) == null) || (paramContext.getNetworkInfo(0) == null));
      this.jdField_a_of_type_AndroidNetNetworkInfo$State = paramContext.getNetworkInfo(1).getState();
      this.b = paramContext.getNetworkInfo(0).getState();
      if ((this.jdField_a_of_type_AndroidNetNetworkInfo$State != null) && (this.b != null) && (NetworkInfo.State.CONNECTED != this.jdField_a_of_type_AndroidNetNetworkInfo$State) && (NetworkInfo.State.CONNECTED != this.b))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getApplication(), 2131367328, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.k = false;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.k);
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "reconnect network success, regist again");
    }
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.k = true;
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iig
 * JD-Core Version:    0.7.0.1
 */