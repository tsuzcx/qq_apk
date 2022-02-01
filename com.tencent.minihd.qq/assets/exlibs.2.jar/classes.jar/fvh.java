import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder;

public class fvh
  implements View.OnClickListener
{
  public fvh(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.h = true;
    if (MixedMsgItemBuilder.a(this.a)) {
      return;
    }
    MixedMsgItemBuilder.a(this.a).onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvh
 * JD-Core Version:    0.7.0.1
 */