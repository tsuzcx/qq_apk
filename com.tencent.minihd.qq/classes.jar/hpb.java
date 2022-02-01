import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import com.tencent.qphone.base.util.BaseApplication;

public class hpb
  extends AsyncTask
{
  private hpb(SaveTrafficHandler paramSaveTrafficHandler) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)
    {
      paramVarArgs = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit();
      paramVarArgs.putBoolean("key_savetrafficmode", SaveTrafficHandler.jdField_a_of_type_Boolean);
      paramVarArgs.commit();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hpb
 * JD-Core Version:    0.7.0.1
 */