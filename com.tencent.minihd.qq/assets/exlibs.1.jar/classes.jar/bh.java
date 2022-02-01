import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import cooperation.qqdataline.DatalinePluginProxyActivity;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class bh
  implements AdapterView.OnItemClickListener
{
  public bh(LiteActivity paramLiteActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = LiteActivity.a(this.a).a()[paramInt][1];
    paramAdapterView = (SplashActivity)SplashActivity.a();
    switch (paramInt)
    {
    default: 
      return;
    case 2130838002: 
      if ((!this.a.permissionManager.checkPermission("android.permission.CAMERA")) || (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        paramAdapterView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 200) }).requests(new bi(this, paramAdapterView));
        return;
      }
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_cktkphoto");
      this.a.a();
      ReportController.b(this.a.app, "CliOper", "", "", "0X800407A", "0X800407A", 0, 0, "", "", "", "");
      return;
    case 2130838012: 
      if (!this.a.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        paramAdapterView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).request(new bk(this));
        return;
      }
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckpic");
      this.a.c();
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004079", "0X8004079", 0, 0, "", "", "", "");
      return;
    case 2130838019: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckvideo");
      paramAdapterView = new Intent(this.a.getApplicationContext(), LiteVideoActivity.class);
      this.a.startActivityForResult(paramAdapterView, 1);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004086", "0X8004086", 0, 0, "", "", "", "");
      return;
    case 2130838016: 
      StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.a(), "dl_ckfile");
      paramAdapterView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramAdapterView.putExtra("category", 6);
      paramAdapterView.putExtra("selectMode", true);
      paramAdapterView.putExtra("targetUin", AppConstants.Y);
      paramAdapterView.putExtra("tab_tab_type", 5);
      paramAdapterView.putExtra("display_like_dialog", true);
      this.a.startActivityForResult(paramAdapterView, 2);
      ReportController.b(this.a.app, "CliOper", "", "", "0X800407C", "0X800407C", 0, 0, "", "", "", "");
      return;
    }
    paramAdapterView = new Intent();
    DatalinePluginProxyActivity.a(this.a, this.a.app.a(), paramAdapterView, "com.qqdataline.mpfile.LiteMpFileMainActivity", -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bh
 * JD-Core Version:    0.7.0.1
 */