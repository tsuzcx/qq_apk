import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.IconPopupWindow;

public class kfq
  implements View.OnClickListener
{
  public kfq(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131296568)
    {
      if ((TroopAvatarWallPreviewActivity.a(this.a) != null) && (TroopAvatarWallPreviewActivity.a(this.a).a()))
      {
        TroopAvatarWallPreviewActivity.a(this.a).a();
        TroopAvatarWallPreviewActivity.a(this.a, null);
      }
      TroopAvatarWallPreviewActivity.a(this.a, new IconPopupWindow(this.a));
      TroopAvatarWallPreviewActivity.a(this.a).a(2131368337, new kfr(this));
      TroopAvatarWallPreviewActivity.a(this.a).a(paramView, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfq
 * JD-Core Version:    0.7.0.1
 */