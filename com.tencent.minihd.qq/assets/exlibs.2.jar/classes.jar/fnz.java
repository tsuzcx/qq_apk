import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

public class fnz
  implements Comparator
{
  public fnz(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    long l = paramMessageRecord1.time - paramMessageRecord2.time;
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fnz
 * JD-Core Version:    0.7.0.1
 */