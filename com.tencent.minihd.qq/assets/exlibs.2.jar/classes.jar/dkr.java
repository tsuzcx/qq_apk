import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import java.util.ArrayList;

public class dkr
  extends TroopObserver
{
  public dkr(Call paramCall) {}
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0) && ((TroopMemberCardInfo)paramArrayList.get(0) != null)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkr
 * JD-Core Version:    0.7.0.1
 */