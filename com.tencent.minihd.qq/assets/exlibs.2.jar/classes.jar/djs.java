import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Comparator;

public class djs
  implements Comparator
{
  public djs(BaseChatPie paramBaseChatPie) {}
  
  public int a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (paramChatMessage1.time == paramChatMessage2.time) {
      if (paramChatMessage1.getId() <= paramChatMessage2.getId()) {}
    }
    while (paramChatMessage1.time > paramChatMessage2.time)
    {
      return 1;
      if (paramChatMessage1.getId() < paramChatMessage2.getId()) {
        return -1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djs
 * JD-Core Version:    0.7.0.1
 */