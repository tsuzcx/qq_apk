import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView.UIHandler;
import com.tencent.qphone.base.util.QLog;

public class kdq
  extends SosoInterface.OnLocationListener
{
  public kdq(NearbyTroopsView paramNearbyTroopsView, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyTroopsActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {}
    do
    {
      return;
      this.a.jdField_e_of_type_Int = ((int)(paramSosoLbsInfo.a.a * 1000000.0D));
      this.a.f = ((int)(paramSosoLbsInfo.a.b * 1000000.0D));
      this.a.jdField_e_of_type_JavaLangString = paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString;
    } while (this.a.a == null);
    this.a.a.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kdq
 * JD-Core Version:    0.7.0.1
 */