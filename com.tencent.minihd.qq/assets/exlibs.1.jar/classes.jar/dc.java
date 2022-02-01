import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.litetransfersdk.ProgressInfo;
import java.util.Comparator;

public class dc
  implements Comparator
{
  public dc(DLRouterSessionListAdapter paramDLRouterSessionListAdapter) {}
  
  public int a(ProgressInfo paramProgressInfo1, ProgressInfo paramProgressInfo2)
  {
    if (paramProgressInfo1.GetWeight() > paramProgressInfo2.GetWeight()) {}
    do
    {
      return 1;
      if (paramProgressInfo1.GetWeight() < paramProgressInfo2.GetWeight()) {
        return -1;
      }
      if (paramProgressInfo1.GetTime() > paramProgressInfo2.GetTime()) {
        return -1;
      }
    } while (paramProgressInfo1.GetTime() < paramProgressInfo2.GetTime());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dc
 * JD-Core Version:    0.7.0.1
 */