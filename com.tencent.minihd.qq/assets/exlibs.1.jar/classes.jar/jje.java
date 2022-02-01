import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import java.util.LinkedList;

public class jje
  implements View.OnClickListener
{
  public jje(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = NearbyProfileEditPanel.a(this.a).getIntent();
    if ((paramView != null) && (paramView.getIntExtra("param_mode", 0) == 1))
    {
      NearbyProfileEditPanel.a(this.a).a(2131369840);
      return;
    }
    this.a.a();
    if (NearbyProfileEditPanel.a(this.a).r == 0)
    {
      NearbyProfileEditPanel.a(this.a).a(2131369840);
      return;
    }
    if ((NearbyProfileEditPanel.a(this.a).size() > 0) || (this.a.a()) || (NearbyProfileEditPanel.a(this.a).b))
    {
      NearbyProfileEditPanel.a(this.a).a(2131369841);
      return;
    }
    NearbyProfileEditPanel.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jje
 * JD-Core Version:    0.7.0.1
 */