package cooperation.qqfav.widget;

import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqfav.QfavReport;
import java.lang.ref.WeakReference;

public class LocationDetailActivity$LocationActions
  extends FavoriteActionSheet.DefaultActions
{
  private WeakReference a;
  
  public LocationDetailActivity$LocationActions(LocationDetailActivity paramLocationDetailActivity)
  {
    this.a = new WeakReference(paramLocationDetailActivity);
  }
  
  public void a()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    localLocationDetailActivity.b(true);
    QfavReport.a(null, "User_Modify", 7, 0, localLocationDetailActivity.getIntent().getIntExtra("category", 1));
  }
  
  public void a(String paramString)
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {}
    while (localLocationDetailActivity.getString(2131364681).compareTo(paramString) != 0) {
      return;
    }
    LocationDetailActivity.a(localLocationDetailActivity);
  }
  
  public void b()
  {
    LocationDetailActivity localLocationDetailActivity = (LocationDetailActivity)this.a.get();
    if (localLocationDetailActivity == null) {
      return;
    }
    if ((localLocationDetailActivity.v != null) && (localLocationDetailActivity.w != null))
    {
      Intent localIntent = LocationDetailActivity.a(localLocationDetailActivity);
      localIntent.setClass(localLocationDetailActivity, ForwardRecentActivity.class);
      localIntent.putExtra("forward_type", -2).putExtra("forward_latitude", localLocationDetailActivity.h).putExtra("forward_longitude", localLocationDetailActivity.i).putExtra("forward_location", localLocationDetailActivity.o).putExtra("forward_location_string", localLocationDetailActivity.o).putExtra("forward_thumb", AppConstants.bu + localLocationDetailActivity.v + "_" + localLocationDetailActivity.w + ".png").putExtra("isFromFavorites", true).putExtra("title", localLocationDetailActivity.n).putExtra("summary", localLocationDetailActivity.o);
      localLocationDetailActivity.startActivityForResult(localIntent, 103);
      return;
    }
    QQToast.a(localLocationDetailActivity, 2131364641, 1, 2000).b(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.LocationActions
 * JD-Core Version:    0.7.0.1
 */