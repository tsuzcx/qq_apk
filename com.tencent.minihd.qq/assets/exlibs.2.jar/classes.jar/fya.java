import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.statistics.ReportController;

public class fya
  implements View.OnClickListener
{
  public fya(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
    AIOGalleryScene.a(this.a, AIOGalleryScene.a(this.a), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fya
 * JD-Core Version:    0.7.0.1
 */