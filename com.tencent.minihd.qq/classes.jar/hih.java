import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class hih
  extends BroadcastReceiver
{
  public hih(DataLineHandler paramDataLineHandler, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName())) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {
          break label101;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a();
      }
    }
    label101:
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE"));
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      if ((paramContext != null) && (paramContext.getState() == NetworkInfo.State.DISCONNECTED) && (paramContext.getType() == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.c();
        return;
      }
    } while ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED) || (paramContext.getType() != 1));
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hih
 * JD-Core Version:    0.7.0.1
 */