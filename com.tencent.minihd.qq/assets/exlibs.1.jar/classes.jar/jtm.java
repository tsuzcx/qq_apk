import PersonalState.UserProfile;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.Comparator;

public class jtm
  implements Comparator
{
  public jtm(StatusManager paramStatusManager) {}
  
  public int a(UserProfile paramUserProfile1, UserProfile paramUserProfile2)
  {
    return (int)(paramUserProfile2.richTime - paramUserProfile1.richTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jtm
 * JD-Core Version:    0.7.0.1
 */