import android.os.Handler;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class eee
  extends HotChatObserver
{
  public eee(HotChatListActivity paramHotChatListActivity) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    this.a.b();
    if (paramString1 == null)
    {
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "加入热聊失败，请稍后再试。", 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (paramString1.equals(""))
    {
      HotChatListActivity.a(this.a).a(2, paramString3, 0);
      return;
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatListActivity", 2, "onJoinHotChat troopUin = " + paramString1 + " ; troopCode = " + paramString2 + " ; troopName = " + paramString4 + " ; isWifiHotChat = " + paramBoolean1);
      }
      HotChatListActivity.a(this.a, paramString1, paramString2, paramString4);
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "加入热聊失败，请稍后再试。", 0).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, Common.WifiPOIInfo paramWifiPOIInfo, List paramList)
  {
    if (paramBoolean2) {}
    do
    {
      return;
      this.a.c = true;
      if (paramBoolean1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        HotChatListActivity.a(this.a, paramWifiPOIInfo, paramList);
      }
      while ((!paramBoolean1) && (HotChatListActivity.a(this.a)))
      {
        this.a.finish();
        return;
        if (HotChatListActivity.a(this.a)) {
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "获取列表失败，请稍后再试。", 0).b(this.a.getTitleBarHeight());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 800L);
      HotChatListActivity.a(this.a, false);
    } while (this.a.b.getVisibility() != 0);
    this.a.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eee
 * JD-Core Version:    0.7.0.1
 */