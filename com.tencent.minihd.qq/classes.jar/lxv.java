import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QQProxyForQlink.WState;
import java.util.ArrayList;
import java.util.List;

public class lxv
  implements DialogInterface.OnClickListener
{
  public lxv(QQProxyForQlink paramQQProxyForQlink, String paramString, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_CooperationQlinkQQProxyForQlink.a("0X8004855", 1);
    Object localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_CooperationQlinkQQProxyForQlink.a(QQProxyForQlink.a(this.jdField_a_of_type_CooperationQlinkQQProxyForQlink).jdField_a_of_type_JavaLangString, (List)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("STRING_CONTINUE_SEND_TO_", true);
    QQProxyForQlink.a(this.jdField_a_of_type_AndroidAppActivity, 6, (Bundle)localObject);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lxv
 * JD-Core Version:    0.7.0.1
 */