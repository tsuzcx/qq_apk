import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class dnk
  implements View.OnClickListener
{
  public dnk(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.j();
      if (this.a.a == 0)
      {
        VipUtils.a(this.a.app, "vip", "0X8004FAC", "0X8004FAC", 0, 0, new String[] { ChatHistoryForC2C.b(this.a) });
        if (QLog.isColorLevel()) {
          QLog.i("ChatHistoryForC2C", 2, "点击漫游设置按钮的 ，T ：0X8004FAC ， userIdentity" + ChatHistoryForC2C.b(this.a));
        }
        this.a.c();
      }
      return;
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnk
 * JD-Core Version:    0.7.0.1
 */