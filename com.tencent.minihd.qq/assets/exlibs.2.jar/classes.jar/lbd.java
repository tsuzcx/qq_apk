import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.BragActivity;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class lbd
  implements ImageLoader.ImageLoadListener
{
  public lbd(BragActivity paramBragActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.a.a.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbd
 * JD-Core Version:    0.7.0.1
 */