import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;

class eam
  implements View.OnClickListener
{
  eam(eaj parameaj) {}
  
  public void onClick(View paramView)
  {
    if (eaj.a(this.a) == null) {}
    for (;;)
    {
      return;
      paramView = null;
      if ((eaj.a(this.a).a instanceof String)) {
        paramView = (String)eaj.a(this.a).a;
      }
      while (paramView != null)
      {
        this.a.a.b(paramView);
        ReportController.b(this.a.a.app, "CliOper", "", "", "P_prof", "Prof_copy", ProfileActivity.a(this.a.a.a.a.g), 0, Integer.toString(ProfileActivity.a(this.a.a.a.a)), "", "", "");
        return;
        if ((eaj.a(this.a).a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)eaj.a(this.a).a;
          if ((this.a.a.a != null) && (this.a.a.a.a != null) && (this.a.a.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eam
 * JD-Core Version:    0.7.0.1
 */