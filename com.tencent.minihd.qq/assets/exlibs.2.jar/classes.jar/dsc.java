import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.richstatus.IIconListener;

public class dsc
  implements IIconListener
{
  private dsc(Contacts paramContacts) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((this.a.a) && (paramBitmap != null) && (paramInt2 == 200)) {
      this.a.a(1400L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsc
 * JD-Core Version:    0.7.0.1
 */