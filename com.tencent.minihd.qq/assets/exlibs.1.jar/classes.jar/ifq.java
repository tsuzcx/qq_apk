import com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelView;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;

public class ifq
  implements Runnable
{
  public ifq(ClassicEmoticonPanelView paramClassicEmoticonPanelView) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.a();
      this.a.postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifq
 * JD-Core Version:    0.7.0.1
 */