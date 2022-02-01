import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.List;

public class drw
  extends SearchResultDialog
{
  public drw(Contacts paramContacts, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramInt2);
  }
  
  protected void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (paramInt == 0) {
      if (!AppConstants.Y.equals(paramString1))
      {
        paramContext = new ProfileActivity.AllInOne(paramString1, 1);
        paramContext.g = 60;
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityContacts.getActivity(), paramContext);
        paramContext = (FriendManager)paramQQAppInterface.getManager(8);
        if (paramContext != null)
        {
          paramContext = paramContext.c(paramString1);
          if ((paramContext != null) && (paramContext.gathtertype == 1)) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C58", "0X8004C58", 1, 0, "", "", "", "");
          }
        }
      }
    }
    for (;;)
    {
      dismiss();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "";
      }
      a(paramString2, paramString1, paramContext, paramInt);
      int i = b(this.jdField_a_of_type_Int);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(a(paramInt)), String.valueOf(i), "", "");
      return;
      for (;;)
      {
        try
        {
          paramContext = paramQQAppInterface.b();
          i = 0;
          if (i >= paramContext.size()) {
            break;
          }
          localObject = (ResourcePluginInfo)paramContext.get(i);
          if ((localObject == null) || (!((ResourcePluginInfo)localObject).strPkgName.equals(AppConstants.Y))) {
            break label255;
          }
          paramContext = JumpParser.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContacts.getActivity(), ((ResourcePluginInfo)localObject).strGotoUrl);
          if (paramContext == null) {
            break;
          }
          paramContext.b();
        }
        catch (Exception paramContext) {}
        break;
        label255:
        i += 1;
      }
      if (paramInt == 1004)
      {
        localObject = new ProfileActivity.AllInOne(paramString1, 46);
        ((ProfileActivity.AllInOne)localObject).k = paramString2;
        ((ProfileActivity.AllInOne)localObject).f = 3;
        ((ProfileActivity.AllInOne)localObject).d = paramString3;
        ProfileActivity.b(paramContext, (ProfileActivity.AllInOne)localObject);
      }
      else
      {
        if (paramInt != 1008) {
          break;
        }
        paramContext = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
        if (paramContext != null)
        {
          paramContext = paramContext.a(paramString1);
          if (paramContext != null) {
            Contacts.a(this.jdField_a_of_type_ComTencentMobileqqActivityContacts, paramContext);
          }
        }
      }
    }
    Object localObject = new Intent(paramContext, ChatActivity.class);
    ((Intent)localObject).putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      TroopInfo localTroopInfo = ((FriendManager)paramQQAppInterface.getManager(8)).a(paramString1);
      if ((localTroopInfo != null) && (localTroopInfo.troopcode != null)) {
        ((Intent)localObject).putExtra("troop_uin", localTroopInfo.troopcode);
      }
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("uintype", paramInt);
      ((Intent)localObject).putExtra("uinname", paramString2);
      paramContext.startActivity((Intent)localObject);
      break;
      if (paramInt != 3000) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drw
 * JD-Core Version:    0.7.0.1
 */