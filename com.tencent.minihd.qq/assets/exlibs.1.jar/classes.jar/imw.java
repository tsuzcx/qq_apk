import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.qqdataline.DatalinePluginProxyActivity;
import cooperation.weiyun.AlbumBackupInfo;
import cooperation.weiyun.AlbumBackupLaunchProxyActivity;
import cooperation.weiyun.AlbumBackupProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class imw
  implements View.OnClickListener
{
  public imw(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QfileFileAssistantActivity.a(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i(QfileFileAssistantActivity.c, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      return;
      QfileFileAssistantActivity.a(this.a);
      paramView = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      if (paramView.a == 0) {
        continue;
      }
      long l = paramView.a;
      Object localObject1;
      label451:
      Object localObject2;
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      JSONObject localJSONObject;
      switch ((int)l)
      {
      case 18: 
      default: 
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(QfileFileAssistantActivity.c, 2, "unknow category!!! return onClick");
        return;
      case 12: 
        paramView = new FileManagerReporter.fileAssistantReportData();
        paramView.b = "file_assistant_in";
        paramView.a = 1;
        FileManagerReporter.a(this.a.app.a(), paramView);
        paramView = new Intent(this.a.getApplicationContext(), LiteActivity.class);
      case 13: 
      case 14: 
      case 19: 
      case 15: 
        for (;;)
        {
          try
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("category", l);
            paramView.putExtra("bundle", (Bundle)localObject1);
            this.a.startActivityForResult(paramView, 101);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.b = "file_assistant_in";
          paramView.a = 2;
          FileManagerReporter.a(this.a.app.a(), paramView);
          paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
          paramView.putExtra("tab_tab_type", 0);
          continue;
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.b = "file_assistant_in";
          paramView.a = 3;
          FileManagerReporter.a(this.a.app.a(), paramView);
          QfileFileAssistantActivity.b(this.a);
          return;
          paramView = new Intent();
          DatalinePluginProxyActivity.a(this.a, this.a.app.a(), paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity", -1, null);
          return;
          paramView = new FileManagerReporter.fileAssistantReportData();
          paramView.b = "file_assistant_in";
          paramView.a = 10;
          FileManagerReporter.a(this.a.app.a(), paramView);
          paramView = new Intent(this.a.getApplicationContext(), FMActivity.class);
          paramView.putExtra("tab_tab_type", 1);
        }
      case 16: 
        if (AlbumBackupInfo.a(this.a.app.getApplication(), this.a.app.a()))
        {
          AlbumBackupProxyActivity.a(this.a, this.a.app.a());
          this.a.overridePendingTransition(2130968593, 2130968594);
          ReportController.b(this.a.app, "CliOper", "", "", "Weiyun_Backup", "Enter_Backup", 0, 0, "", "", "", "");
          if (paramView.c == null) {
            continue;
          }
          localObject1 = (RedTouchManager)this.a.app.getManager(35);
          localObject2 = String.valueOf("100160.100162");
          localAppInfo = ((RedTouchManager)localObject1).a((String)localObject2);
          if ((localAppInfo != null) && (localAppInfo.iNewFlag != null) && (localAppInfo.iNewFlag.get() != 0)) {
            localJSONObject = new JSONObject();
          }
        }
      case 17: 
        try
        {
          localJSONObject.put("service_type", 2);
          localJSONObject.put("act_id", 1002);
          localJSONObject.put("obj_id", "");
          localJSONObject.put("pay_amt", 0);
          ((RedTouchManager)localObject1).b(localAppInfo, localJSONObject.toString());
          label616:
          ((RedTouchManager)localObject1).b((String)localObject2);
          paramView.c.setVisibility(8);
          CustomWidgetUtil.a(paramView.c, 0, 0, 0);
          return;
          AlbumBackupLaunchProxyActivity.a(this.a, this.a.app.a());
          break label451;
          QfileFileAssistantActivity.c(this.a);
          paramView = (RedTouchManager)this.a.app.getManager(35);
          localObject1 = paramView.a(String.valueOf("100160.100161"));
          if ((localObject1 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 0)) {
            continue;
          }
          paramView.b(String.valueOf("100160.100161"));
          try
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("service_type", 2);
            ((JSONObject)localObject2).put("act_id", 1002);
            paramView.b((BusinessInfoCheckUpdate.AppInfo)localObject1, ((JSONObject)localObject2).toString());
            return;
          }
          catch (JSONException paramView)
          {
            paramView.printStackTrace();
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          break label616;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     imw
 * JD-Core Version:    0.7.0.1
 */