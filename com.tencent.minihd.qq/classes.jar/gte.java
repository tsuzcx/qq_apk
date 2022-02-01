import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class gte
  implements AdapterView.OnItemClickListener
{
  public gte(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (PhotoPreviewActivity.a(this.a))
    {
      PhotoPreviewActivity.a(this.a, false);
      this.a.a.setVisibility(4);
      this.a.b.setVisibility(4);
      return;
    }
    PhotoPreviewActivity.a(this.a, true);
    this.a.a.setVisibility(0);
    this.a.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gte
 * JD-Core Version:    0.7.0.1
 */