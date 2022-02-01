import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.DLRouterSessionInfoActivity;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqdataline.DatalinePluginProxyActivity;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class l
  implements AdapterView.OnItemClickListener
{
  public l(DLRouterActivity paramDLRouterActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (SmartDeviceProxyMgr)this.a.app.a(53);
    paramView = paramAdapterView.a(Long.parseLong(DLRouterActivity.b(this.a)));
    if ((paramView == null) || (paramView.userStatus == 20))
    {
      FMToastUtil.a(2131362207);
      return;
    }
    switch (DLRouterActivity.a(this.a).a()[paramInt][1])
    {
    default: 
      return;
    case 2130838003: 
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("sCurDIN", Long.parseLong(DLRouterActivity.b(this.a)));
      paramAdapterView.putExtra("sTitleID", 2131362293);
      DatalinePluginProxyActivity.a(this.a, this.a.app.getAccount(), paramAdapterView, "com.qqdataline.mpfile.LiteMpFileMainActivity", -1, null);
      return;
    case 2130838012: 
      paramAdapterView = new Intent(this.a, PhotoListActivity.class);
      paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", DLRouterActivity.class.getName());
      paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
      paramAdapterView.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramAdapterView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      paramAdapterView.putExtra(AlbumConstants.i, 55);
      paramAdapterView.putExtra("uin", DLRouterActivity.b(this.a));
      paramAdapterView.putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
      paramAdapterView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
      paramAdapterView.getExtras().remove("forward_type");
      paramAdapterView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      this.a.startActivity(paramAdapterView);
      AlbumUtil.a(this.a, false, true);
      return;
    case 2130838016: 
      paramAdapterView = new Intent(this.a.getApplicationContext(), FMActivity.class);
      paramAdapterView.putExtra("category", 6);
      paramAdapterView.putExtra("selectMode", true);
      paramAdapterView.putExtra("targetUin", DLRouterActivity.b(this.a));
      paramAdapterView.putExtra("busiType", 6);
      paramAdapterView.putExtra("peerType", 6002);
      paramAdapterView.putExtra("tab_tab_type", 5);
      this.a.startActivityForResult(paramAdapterView, 2);
      return;
    case 2130838011: 
      if (((DataLineHandler)this.a.app.a(8)).a().a(DLRouterActivity.b(this.a)))
      {
        paramAdapterView = new QQToast(this.a.app.a().getApplicationContext());
        paramAdapterView.b(2131362290);
        paramAdapterView.c(0);
        paramAdapterView.b(this.a.getTitleBarHeight());
        return;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("device_din", Long.parseLong(DLRouterActivity.b(this.a)));
      DatalinePluginProxyActivity.a(this.a, this.a.app.getAccount(), paramAdapterView, "com.qqdataline.activity.RouterWifiPhotoAlbumBackupActivity", -1, null);
      return;
    }
    paramView = new Intent(this.a.getApplicationContext(), DLRouterSessionInfoActivity.class);
    paramView.putExtra("uin", DLRouterActivity.b(this.a));
    paramView.putExtra(DLRouterSessionInfoActivity.b, paramAdapterView.a());
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     l
 * JD-Core Version:    0.7.0.1
 */