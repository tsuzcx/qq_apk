import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class chn
  extends SosoInterface.OnLocationListener
{
  public chn(TroopNearByBigMapView paramTroopNearByBigMapView, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    try
    {
      if (TroopNearByBigMapView.a(this.a)) {
        return;
      }
      if (paramInt == 0)
      {
        TroopNearByBigMapView.a(this.a, Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue());
        TroopNearByBigMapView.b(this.a, Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue());
        TroopNearByBigMapView.b(this.a, TroopNearByBigMapView.a(this.a), TroopNearByBigMapView.b(this.a));
        TroopNearByBigMapView.a(this.a, TroopNearByBigMapView.a(this.a), TroopNearByBigMapView.b(this.a));
        return;
      }
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      TroopNearByBigMapView.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chn
 * JD-Core Version:    0.7.0.1
 */