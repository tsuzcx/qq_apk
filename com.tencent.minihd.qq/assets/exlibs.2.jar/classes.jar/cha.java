import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public final class cha
  extends SosoInterface.OnLocationListener
{
  public cha(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, SharedPreferences paramSharedPreferences)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      SearchProtocol.a((float)paramSosoLbsInfo.a.a);
      SearchProtocol.b((float)paramSosoLbsInfo.a.b);
      this.a.edit().putFloat("search_lbs_latitude", SearchProtocol.a());
      this.a.edit().putFloat("search_lbs_logitude", SearchProtocol.b());
    }
    this.a.edit().putLong("search_lbs_timestamp", System.currentTimeMillis()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cha
 * JD-Core Version:    0.7.0.1
 */