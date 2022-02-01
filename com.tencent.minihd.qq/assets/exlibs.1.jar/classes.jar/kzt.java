import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class kzt
  implements Runnable
{
  public kzt(MQPSensitiveMsgUtil paramMQPSensitiveMsgUtil, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = "sp_confirmed_sensmsg_" + MQPSensitiveMsgUtil.a();
    localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0).edit();
    ((SharedPreferences.Editor)localObject).putString(this.jdField_a_of_type_JavaLangString, this.b);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kzt
 * JD-Core Version:    0.7.0.1
 */