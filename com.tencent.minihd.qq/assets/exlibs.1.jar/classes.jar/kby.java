import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;

public class kby
  extends SosoInterface.OnLocationListener
{
  public kby(AbsPublishIphoneTitleBarActivity paramAbsPublishIphoneTitleBarActivity, int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString, BaseActivity paramBaseActivity, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      double d1 = paramSosoLbsInfo.a.a;
      double d2 = paramSosoLbsInfo.a.b;
      TroopBarPublishLocationSelectActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (int)(d1 * 1000000.0D), (int)(d2 * 1000000.0D), 0, true, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kby
 * JD-Core Version:    0.7.0.1
 */