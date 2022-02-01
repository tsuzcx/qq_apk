import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.VideoItemBuilder;
import com.tencent.mobileqq.data.MessageForVideo;

public class fxr
  implements View.OnClickListener
{
  public fxr(VideoItemBuilder paramVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    AIOUtils.h = true;
    MessageForVideo localMessageForVideo = (MessageForVideo)AIOUtils.a(paramView);
    int i = localMessageForVideo.istroop;
    VideoItemBuilder.a(this.a, paramView, localMessageForVideo, false, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fxr
 * JD-Core Version:    0.7.0.1
 */