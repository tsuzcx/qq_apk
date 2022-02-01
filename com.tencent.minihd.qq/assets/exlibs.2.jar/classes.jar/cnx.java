import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.BizTroopObserver;
import java.util.ArrayList;
import java.util.List;

public class cnx
  extends BizTroopObserver
{
  public cnx(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(String paramString, List paramList, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 25);
    localBundle.putString("pageUrl", paramString);
    localBundle.putStringArrayList("lstVideoUrl", (ArrayList)paramList);
    localBundle.putInt("totalTime", paramInt);
    this.a.a(5, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cnx
 * JD-Core Version:    0.7.0.1
 */