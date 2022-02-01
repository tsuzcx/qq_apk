import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class eeh
  implements View.OnClickListener
{
  public eeh(HotChatListActivity paramHotChatListActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((eep)paramView.getTag()).a;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatListActivity", 2, "进入附近热聊, position = " + i);
    }
    Common.WifiPOIInfo localWifiPOIInfo;
    eei localeei;
    if ((this.a.a != null) && (i >= 0) && (i < this.a.a.size()))
    {
      paramView = ((HotChatManager)this.a.app.getManager(58)).c();
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004412", "0X8004412", 1, 0, "", "", "", "");
      localWifiPOIInfo = (Common.WifiPOIInfo)this.a.a.get(i);
      localeei = new eei(this, localWifiPOIInfo);
      if (paramView == null) {
        localeei.run();
      }
    }
    else
    {
      return;
    }
    if (TextUtils.equals(paramView.uuid, localWifiPOIInfo.bytes_uid.get().toStringUtf8()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatListActivity", 2, "enter poi hotchat start aio, has joined");
      }
      HotChatListActivity.a(this.a, paramView.troopUin, paramView.troopCode, paramView.name);
      return;
    }
    this.a.a(localeei);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eeh
 * JD-Core Version:    0.7.0.1
 */