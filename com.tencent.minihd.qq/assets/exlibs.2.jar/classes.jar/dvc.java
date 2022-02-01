import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class dvc
  implements CompoundButton.OnCheckedChangeListener
{
  public dvc(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (FriendsManagerImp)this.a.app.getManager(8);
    Object localObject = paramCompoundButton.a(DiscussionInfoCardActivity.a(this.a), this.a.app.a());
    int i = ((DiscussionMemberInfo)localObject).flag;
    if (paramBoolean)
    {
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag & 0xFFFFFFFE));
      if (i != ((DiscussionMemberInfo)localObject).flag)
      {
        i = (byte)(((DiscussionMemberInfo)localObject).flag & 0x1);
        paramCompoundButton.a((DiscussionMemberInfo)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d(DiscussionInfoCardActivity.a(), 4, "DiscussionMemberInfo.flag changed save now:" + ((DiscussionMemberInfo)localObject).flag + " flag:" + i);
        }
      }
      localObject = this.a.app;
      if (!paramBoolean) {
        break label189;
      }
    }
    label189:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, paramCompoundButton, "", "", "");
      return;
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag | 0x1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvc
 * JD-Core Version:    0.7.0.1
 */