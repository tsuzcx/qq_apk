import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class kfl
  implements AdapterView.OnItemLongClickListener
{
  public kfl(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.c) {
      TroopAvatarWallPreviewActivity.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfl
 * JD-Core Version:    0.7.0.1
 */