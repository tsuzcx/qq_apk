import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.Comparator;

public class hko
  implements Comparator
{
  public hko(HotChatManager paramHotChatManager) {}
  
  public int a(HotChatInfo paramHotChatInfo1, HotChatInfo paramHotChatInfo2)
  {
    int i = 0;
    if (paramHotChatInfo1.leftTime > paramHotChatInfo2.leftTime) {
      i = 1;
    }
    while (paramHotChatInfo1.leftTime >= paramHotChatInfo2.leftTime) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hko
 * JD-Core Version:    0.7.0.1
 */