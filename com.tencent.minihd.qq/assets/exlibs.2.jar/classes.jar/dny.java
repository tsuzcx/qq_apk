import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.ChatHistoryForC2C.PlayingPttHistoryInfo;

public class dny
  implements AbsListView.OnScrollListener
{
  public dny(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.O = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((this.a.a != null) && (this.a.a.c == 1) && (!this.a.a.a)) {
      this.a.a.b();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dny
 * JD-Core Version:    0.7.0.1
 */