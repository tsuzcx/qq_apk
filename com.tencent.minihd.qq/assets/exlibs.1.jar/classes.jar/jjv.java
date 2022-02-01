import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.widget.CustomImgView;

public final class jjv
  implements View.OnLongClickListener
{
  private jjv(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (NearbyProfileEditPanel.a(this.a).getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new jke(this.a, paramView), paramView, 0);
    localObject = NearbyProfileEditPanel.a(this.a, (NearbyPeopleProfileActivity.PicInfo)paramView.getTag());
    ((CustomImgView)localObject).setVisibility(4);
    NearbyProfileEditPanel.a(this.a, (CustomImgView)localObject);
    int i = NearbyProfileEditPanel.a(this.a).indexOfChild(paramView);
    if (i != -1)
    {
      NearbyProfileEditPanel.a(this.a).removeView(paramView);
      NearbyProfileEditPanel.a(this.a).addView(NearbyProfileEditPanel.b(this.a), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jjv
 * JD-Core Version:    0.7.0.1
 */