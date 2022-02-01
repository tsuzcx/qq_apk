import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.data.CircleBuddy;
import java.util.Comparator;

public class hhf
  implements Comparator
{
  public hhf(CircleManager paramCircleManager) {}
  
  public int a(CircleBuddy paramCircleBuddy1, CircleBuddy paramCircleBuddy2)
  {
    return paramCircleBuddy2.randomCloseness - paramCircleBuddy1.randomCloseness;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hhf
 * JD-Core Version:    0.7.0.1
 */