import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.LBSObserver;

public class cny
  extends LBSObserver
{
  public cny(TroopMemberApiService paramTroopMemberApiService) {}
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 8);
    localBundle.putInt("iFilterId", paramInt);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2), paramRspGetNearbyGroup });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
  }
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 12);
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putSerializable("data", new Object[] { Boolean.valueOf(paramBoolean2), paramRspGetAreaList });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
    localBundle.putSerializable("", paramRspGetAreaList);
  }
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", 13);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putSerializable("data", new Object[] { paramRspGetGroupInArea });
    localBundle.putSerializable("observer_type", Integer.valueOf(1));
    this.a.a(3, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cny
 * JD-Core Version:    0.7.0.1
 */