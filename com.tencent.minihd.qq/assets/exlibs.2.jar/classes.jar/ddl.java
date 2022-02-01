import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class ddl
  extends FriendListObserver
{
  public ddl(AccountManageActivity paramAccountManageActivity) {}
  
  void a(String paramString, int paramInt)
  {
    ThreadManager.a().post(new ddm(this, paramString, paramInt));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    label418:
    label421:
    for (;;)
    {
      return;
      Object localObject1 = (SubAccountManager)this.a.app.getManager(59);
      int i = ((SubAccountManager)localObject1).a();
      if (i == 0)
      {
        localObject1 = "";
        AccountManageActivity.a(this.a).setRightText((CharSequence)localObject1);
        AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject1);
        if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
          break label418;
        }
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      for (;;)
      {
        if (j >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label421;
        }
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131296582);
          Object localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131296583);
          ((TextView)localObject1).setText(ContactUtils.g(this.a.app, paramString));
          ((TextView)localObject2).setText(this.a.app.b(paramString));
          a(paramString, j);
          return;
          if (i == 1)
          {
            SubAccountInfo localSubAccountInfo = ((SubAccountManager)localObject1).a("sub.uin.default");
            localObject2 = ContactUtils.c(this.a.app, localSubAccountInfo.subuin, false);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break;
            }
            if (!TextUtils.isEmpty(localSubAccountInfo.subname))
            {
              localObject1 = localObject2;
              if (((String)localObject2).equals(localSubAccountInfo.subname)) {
                break;
              }
            }
            localSubAccountInfo.subname = ((String)localObject2);
            AccountManageActivity.a(this.a).setRightText((CharSequence)localObject2);
            AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
            localObject1 = localObject2;
            break;
          }
          localObject1 = i + "个";
          break;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddl
 * JD-Core Version:    0.7.0.1
 */