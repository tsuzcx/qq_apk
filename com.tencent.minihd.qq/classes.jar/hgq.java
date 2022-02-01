import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class hgq
  extends BroadcastReceiver
{
  public hgq(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (localObject == null) {}
    do
    {
      do
      {
        ArrayList localArrayList;
        do
        {
          do
          {
            return;
            if (!((String)localObject).equals("com.tencent.process.exit")) {
              break;
            }
            localObject = paramIntent.getExtras();
          } while (localObject == null);
          localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
        } while ((!BrowserAppInterface.a(((Bundle)localObject).getString("verify"), localArrayList)) || (!BrowserAppInterface.a(localArrayList, MobileQQ.getContext())));
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        if (paramContext.size() < 1) {
          break;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
        if (QLog.isColorLevel()) {
          QLog.d(BrowserAppInterface.jdField_b_of_type_JavaLangString, 2, "runningActivity=" + paramContext);
        }
      } while ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("com.pay")) || (paramContext.contains("com.tenpay"))));
      if (BrowserAppInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        this.a.jdField_b_of_type_Boolean = true;
        this.a.jdField_a_of_type_AndroidContentIntent = paramIntent;
        return;
      }
      BrowserAppInterface.a(this.a, paramIntent);
      return;
    } while ((!this.a.isLogin()) && (((String)localObject).equals("mqq.intent.action.ACCOUNT_EXPIRED")));
    this.a.getApplication().otherProcessExit(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgq
 * JD-Core Version:    0.7.0.1
 */