import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.SearchResultAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class lbs
  implements ImageLoader.ImageLoadListener
{
  public lbs(FriendChooser.SearchResultAdapter paramSearchResultAdapter, ImageView paramImageView) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbs
 * JD-Core Version:    0.7.0.1
 */