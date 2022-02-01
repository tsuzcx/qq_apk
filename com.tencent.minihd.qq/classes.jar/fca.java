import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SplashActivity;
import java.util.HashMap;

class fca
  implements Runnable
{
  fca(fbz paramfbz, Drawable paramDrawable) {}
  
  public void run()
  {
    Object localObject;
    if (SplashActivity.a(this.jdField_a_of_type_Fbz.a) != null)
    {
      localObject = (View)SplashActivity.a(this.jdField_a_of_type_Fbz.a).get("我");
      if (localObject != null)
      {
        localObject = (ImageView)((View)localObject).findViewById(2131297979);
        if (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
          break label87;
        }
        Bitmap localBitmap = SplashActivity.a(this.jdField_a_of_type_Fbz.a, ((BitmapDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getBitmap());
        if (localBitmap != null) {
          ((ImageView)localObject).setImageBitmap(localBitmap);
        }
      }
    }
    return;
    label87:
    ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fca
 * JD-Core Version:    0.7.0.1
 */