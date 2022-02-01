import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

public class dfu
  implements View.OnClickListener
{
  public dfu(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (FriendManager)this.a.app.getManager(8);
    if (paramView != null) {}
    for (boolean bool = paramView.b(AddRequestActivity.a(this.a));; bool = false)
    {
      if (bool)
      {
        paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 1);
        ProfileActivity.b(this.a, paramView);
        return;
      }
      switch (this.a.jdField_d_of_type_Int)
      {
      default: 
        if ((AddRequestActivity.a(this.a) != 3007) && (AddRequestActivity.a(this.a) != 3019) && (AddRequestActivity.a(this.a) != 2007) && (AddRequestActivity.a(this.a) != 2019)) {
          break label710;
        }
        paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
        if ((AddRequestActivity.a(this.a) != 3007) && (AddRequestActivity.a(this.a) != 2007)) {
          break;
        }
      }
      for (paramView.g = 14;; paramView.g = 15) {
        do
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("param_mode", 3);
          NearbyPeopleProfileActivity.a(this.a, paramView, localBundle);
          return;
          if ((AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 3019) || (AddRequestActivity.a(this.a) == 2007) || (AddRequestActivity.a(this.a) == 2019))
          {
            paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
            if ((AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 2007)) {}
            for (paramView.g = 14;; paramView.g = 15) {
              do
              {
                localBundle = new Bundle();
                localBundle.putInt("param_mode", 3);
                NearbyPeopleProfileActivity.a(this.a, paramView, localBundle);
                return;
              } while ((AddRequestActivity.a(this.a) != 3019) && (AddRequestActivity.a(this.a) != 2019));
            }
          }
          paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
          paramView.h = AddRequestActivity.a(this.a);
          paramView.jdField_d_of_type_JavaLangString = String.valueOf(AddRequestActivity.a(this.a));
          ProfileActivity.b(this.a, paramView);
          return;
          if ((AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 3019) || (AddRequestActivity.a(this.a) == 2007) || (AddRequestActivity.a(this.a) == 2019))
          {
            paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
            if ((AddRequestActivity.a(this.a) == 3007) || (AddRequestActivity.a(this.a) == 2007)) {}
            for (paramView.g = 14;; paramView.g = 15) {
              do
              {
                localBundle = new Bundle();
                localBundle.putInt("param_mode", 3);
                NearbyPeopleProfileActivity.a(this.a, paramView, localBundle);
                return;
              } while ((AddRequestActivity.a(this.a) != 3019) && (AddRequestActivity.a(this.a) != 2019));
            }
          }
          paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
          paramView.h = AddRequestActivity.a(this.a);
          paramView.jdField_d_of_type_JavaLangString = String.valueOf(AddRequestActivity.a(this.a));
          paramView.jdField_d_of_type_Int = 1;
          ProfileActivity.b(this.a, paramView);
          return;
        } while ((AddRequestActivity.a(this.a) != 3019) && (AddRequestActivity.a(this.a) != 2019));
      }
      label710:
      paramView = new ProfileActivity.AllInOne(AddRequestActivity.a(this.a), 25);
      ProfileActivity.b(this.a, paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfu
 * JD-Core Version:    0.7.0.1
 */