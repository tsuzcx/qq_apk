import com.tencent.mobileqq.activity.RecentSaidActivity;
import java.util.Calendar;

public abstract class evz
  implements Comparable
{
  public long a;
  public evy a;
  CharSequence a;
  
  public evz(RecentSaidActivity paramRecentSaidActivity, long paramLong)
  {
    this.a = paramLong;
  }
  
  public int a(evz paramevz)
  {
    int i = 1;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(this.a * 1000L);
    localCalendar2.setTimeInMillis(paramevz.a * 1000L);
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      i = 0;
    }
    while (localCalendar1.after(localCalendar2)) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evz
 * JD-Core Version:    0.7.0.1
 */