import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class dex
  extends FriendListObserver
{
  private dex(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((AddFriendLogicActivity.b(this.a) == 1) && (paramInt1 == 147) && (String.valueOf(paramLong).equals(AddFriendLogicActivity.a(this.a))))
    {
      if ((!paramBoolean) || (paramInt2 == 0)) {
        AddFriendLogicActivity.a(this.a);
      }
    }
    else {
      return;
    }
    AddFriendLogicActivity.a(this.a, paramInt2);
    AntiFraudConfigFileUtil.a().a(this.a.app, "SecWarningCfg");
    try
    {
      AddFriendLogicActivity.a(this.a, DialogUtil.a(this.a, 230, "", "", this.a.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.a.b));
      AddFriendLogicActivity.b(this.a);
      AddFriendLogicActivity.a(this.a).setOnDismissListener(this.a.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      AddFriendLogicActivity.a(this.a).show();
      ReportController.b(this.a.app, "P_CliOper", "Safe_AntiFraud", this.a.app.a(), "AlertDialog", "Display", 0, AddFriendLogicActivity.c(this.a), "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    if (!AddFriendLogicActivity.a(this.a).equals(str)) {
      return;
    }
    if ((AddFriendLogicActivity.a(this.a) != null) && (AddFriendLogicActivity.a(this.a).isShowing())) {
      AddFriendLogicActivity.a(this.a).dismiss();
    }
    if (paramBoolean)
    {
      int i = paramBundle.getInt("friend_setting");
      ArrayList localArrayList = paramBundle.getStringArrayList("user_question");
      paramBundle = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
      if ((paramBundle.booleanValue()) && (i != 0))
      {
        if (AddFriendLogicActivity.a(this.a) == 3006) {
          this.a.getIntent().putExtra("sub_source_id", 2);
        }
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AutoRemarkActivity.class);
        return;
      }
      switch (i)
      {
      default: 
        QQToast.a(this.a.app.getApplication(), 2131366990, 0).b(this.a.getTitleBarHeight());
        this.a.finish();
        return;
      case 0: 
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AutoRemarkActivity.class);
        return;
      case 1: 
      case 3: 
      case 4: 
        this.a.a(i, paramBundle.booleanValue(), localArrayList, AddFriendVerifyActivity.class);
        return;
      case 2: 
        QQToast.a(this.a.app.getApplication(), 2131366989, 0).b(this.a.getTitleBarHeight());
        this.a.finish();
        return;
      }
      QQToast.a(this.a.app.getApplication(), "对方已经是你的好友了", 0).b(this.a.getTitleBarHeight());
      if (AddFriendLogicActivity.b(this.a) == 1) {
        ((FriendListHandler)this.a.app.a(1)).a(str, 0, 10004, "", true, false);
      }
      for (;;)
      {
        this.a.setResult(-1);
        this.a.finish();
        return;
        if (AddFriendLogicActivity.b(this.a) == 2) {
          ((PhoneContactManagerImp)this.a.app.getManager(10)).d();
        }
      }
    }
    QQToast.a(this.a.app.getApplication(), 2131366990, 0).b(this.a.getTitleBarHeight());
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dex
 * JD-Core Version:    0.7.0.1
 */