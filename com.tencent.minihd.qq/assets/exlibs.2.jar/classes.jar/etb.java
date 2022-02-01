import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class etb
  extends SosoInterface.OnLocationListener
{
  public etb(QQMapActivity paramQQMapActivity, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null))
    {
      str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("get_location", 2, "onLocationFinish errCode=" + paramInt + " address=" + str);
      }
      if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label227;
      }
      paramSosoLbsInfo = new GeoPoint((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.jdField_b_of_type_Double * 1000000.0D));
      if (this.a.t)
      {
        this.a.a.setCenter(paramSosoLbsInfo);
        if (!this.a.k) {
          break label186;
        }
        label147:
        this.a.i();
        this.a.t = false;
      }
      this.a.a(paramSosoLbsInfo, str);
    }
    for (;;)
    {
      label186:
      label227:
      try
      {
        this.a.dismissDialog(0);
        return;
      }
      catch (IllegalArgumentException paramSosoLbsInfo) {}
      str = "";
      break;
      this.a.i = str;
      this.a.c.setVisibility(0);
      this.a.d.setVisibility(0);
      this.a.a(paramSosoLbsInfo);
      break label147;
      this.a.x();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etb
 * JD-Core Version:    0.7.0.1
 */