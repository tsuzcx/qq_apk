import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForHotChat;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupVisitorInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;

public class dpn
  extends BizTroopObserver
{
  public dpn(ChatSettingForHotChat paramChatSettingForHotChat) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList)
  {
    int i = 0;
    this.a.removeObserver(this);
    if (paramBoolean)
    {
      paramList = (cmd0x897.GroupVisitorInfo)paramList.get(0);
      if (!paramList.rpt_msg_visitor_info.isEmpty())
      {
        paramList = paramList.rpt_msg_visitor_info.get();
        j = paramList.size();
        if (j > 0)
        {
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_a_of_type_JavaUtilList.clear();
          paramInt = i;
          while ((paramInt < 6) && (paramInt < j))
          {
            if (((cmd0x897.VisitorInfo)paramList.get(paramInt)).uint64_visitor_uin.has())
            {
              l = ((cmd0x897.VisitorInfo)paramList.get(paramInt)).uint64_visitor_uin.get();
              str = ((cmd0x897.VisitorInfo)paramList.get(paramInt)).string_visitor_nick.get().toStringUtf8();
              localHashMap = new HashMap();
              localHashMap.put("memberUin", String.valueOf(l));
              localHashMap.put("memberName", String.valueOf(str));
              this.a.jdField_a_of_type_JavaUtilList.add(localHashMap);
            }
            paramInt += 1;
          }
          this.a.jdField_a_of_type_Dpp.notifyDataSetChanged();
        }
      }
    }
    while (paramInt != 3)
    {
      int j;
      long l;
      String str;
      HashMap localHashMap;
      return;
    }
    QQToast.a(this.a, this.a.getString(2131363271), 0).a();
  }
  
  protected void a(boolean paramBoolean, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramBoolean) && (paramGroupInfo != null))
    {
      int i = paramGroupInfo.uint32_group_visitor_cur_num.get();
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(i + "人");
      this.a.jdField_a_of_type_AndroidViewView.setContentDescription("热聊成员，  " + i + "人");
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "onGetHotChatInfo memberCount = " + i);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a(this.a.g, 6, new int[0]);
      return;
    }
    this.a.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpn
 * JD-Core Version:    0.7.0.1
 */