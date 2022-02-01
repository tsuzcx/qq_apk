import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;

public class hvm
  implements Runnable
{
  public hvm(VipBubbleDrawable paramVipBubbleDrawable) {}
  
  public void run()
  {
    Object localObject;
    if (VipBubbleDrawable.a(this.a).jdField_b_of_type_AndroidGraphicsNinePatch == null)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inDensity = 320;
      ((BitmapFactory.Options)localObject).inTargetDensity = VipBubbleDrawable.a(this.a).getDisplayMetrics().densityDpi;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(VipBubbleDrawable.a(this.a).jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      if (localObject != null)
      {
        byte[] arrayOfByte = ((Bitmap)localObject).getNinePatchChunk();
        VipBubbleDrawable.a(this.a).jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch((Bitmap)localObject, arrayOfByte, null);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label89:
      break label89;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hvm
 * JD-Core Version:    0.7.0.1
 */