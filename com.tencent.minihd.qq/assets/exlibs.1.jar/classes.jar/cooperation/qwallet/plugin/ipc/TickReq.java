package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;

public class TickReq
  extends BaseReq
{
  public static final int a = 1;
  public static final int b = 2;
  public ArrayList a;
  public String b;
  public int c;
  
  private void b()
  {
    if (this.a != null)
    {
      int i = 0;
      if (i < this.a.size())
      {
        Object localObject = (String)this.a.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          if (QWalletHelper.a() != null)
          {
            StatisticCollector.a(BaseApplication.getContext()).d(QWalletHelper.a(), (String)localObject);
          }
          else
          {
            try
            {
              localObject = ((String)localObject + "|s").split("\\|");
              if (localObject.length < 12) {
                return;
              }
              ReportController.b(null, "P_CliOper", localObject[0], localObject[2], localObject[3], localObject[4], Integer.valueOf(localObject[5]).intValue(), Integer.valueOf(localObject[7]).intValue(), localObject[8], localObject[9], localObject[10], localObject[11]);
            }
            catch (Exception localException) {}
            if (QLog.isDevelopLevel()) {
              QLog.d("reportClickEvent", 4, "com.qwallet.QWalletUtils reportClickError:" + localException.getMessage());
            }
          }
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = QWalletHelper.a();
    if (localObject != null)
    {
      ((RedTouchManager)((QQAppInterface)localObject).getManager(35)).b(this.b);
      localObject = ((RedTouchManager)((QQAppInterface)localObject).getManager(35)).a(this.b);
      if (localObject != null)
      {
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).type != null) {
          ((BusinessInfoCheckUpdate.AppInfo)localObject).type.set(-1);
        }
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).buffer != null) {
          ((BusinessInfoCheckUpdate.AppInfo)localObject).buffer.set("");
        }
      }
    }
  }
  
  public void a()
  {
    switch (this.c)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    }
    c();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putInt("_qwallet_ipc_TickReq_tickType", this.c);
    paramBundle.putStringArrayList("_qwallet_ipc_TickReq_reportContents", this.a);
    paramBundle.putString("_qwallet_ipc_TickReq_redpointPath", this.b);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.c = paramBundle.getInt("_qwallet_ipc_TickReq_tickType");
    this.a = paramBundle.getStringArrayList("_qwallet_ipc_TickReq_reportContents");
    this.b = paramBundle.getString("_qwallet_ipc_TickReq_redpointPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.TickReq
 * JD-Core Version:    0.7.0.1
 */