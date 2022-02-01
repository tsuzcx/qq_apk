import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.ArrayList;
import java.util.List;

public class flp
  extends SearchResultDialog
{
  public flp(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramQQAppInterface, paramInt1, paramInt2);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramContext, paramQQAppInterface, 38654705664L, paramInt, false, null));
    return localArrayList;
  }
  
  protected void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i;
    if (paramInt == 0)
    {
      if (!AppConstants.Y.equals(paramString1))
      {
        paramContext = new ProfileActivity.AllInOne(paramString1, 1);
        paramContext.g = 60;
        ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramContext);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
      }
    }
    else
    {
      dismiss();
      paramContext = paramString3;
      if (paramString3 == null) {
        paramContext = "";
      }
      a(paramString2, paramString1, paramContext, paramInt);
      i = b(this.jdField_a_of_type_Int);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Search", "Search_into_AIO", i, 0, String.valueOf(a(paramInt)), String.valueOf(i), "", "");
      return;
    }
    for (;;)
    {
      try
      {
        paramContext = paramQQAppInterface.b();
        i = 0;
        if (i >= paramContext.size()) {
          break;
        }
        ResourcePluginInfo localResourcePluginInfo = (ResourcePluginInfo)paramContext.get(i);
        if ((localResourcePluginInfo == null) || (localResourcePluginInfo.strPkgName != AppConstants.Y)) {
          break label218;
        }
        paramContext = JumpParser.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), localResourcePluginInfo.strGotoUrl);
        if (paramContext == null) {
          break;
        }
        paramContext.b();
      }
      catch (Exception paramContext) {}
      break;
      label218:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flp
 * JD-Core Version:    0.7.0.1
 */