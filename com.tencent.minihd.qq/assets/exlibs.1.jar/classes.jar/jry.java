import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class jry
  implements IIconListener
{
  public jry(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((EditActivity.a(this.a).b == paramInt1) && (paramBitmap != null) && (paramInt2 == 200)) {
      EditActivity.a(this.a, false, this.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jry
 * JD-Core Version:    0.7.0.1
 */