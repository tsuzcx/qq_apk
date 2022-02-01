import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class jsw
  implements Runnable
{
  public jsw(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object[] arrayOfObject = (Object[])localEntry.getValue();
      this.a.a((String)localEntry.getKey(), ((Integer)arrayOfObject[0]).intValue(), (String)arrayOfObject[1], (SignatureTemplateInfo.DynamicItem)arrayOfObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jsw
 * JD-Core Version:    0.7.0.1
 */