import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.richstatus.IIconListener;

public class hbm
  implements IIconListener
{
  private hbm(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      if (this.a.j != 0) {
        this.a.b = true;
      }
    }
    else {
      return;
    }
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hbm
 * JD-Core Version:    0.7.0.1
 */