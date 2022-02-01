import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;

public class jxq
  extends URLDrawableDownListener.Adapter
{
  public jxq(StructMsgItemCover paramStructMsgItemCover) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxq
 * JD-Core Version:    0.7.0.1
 */