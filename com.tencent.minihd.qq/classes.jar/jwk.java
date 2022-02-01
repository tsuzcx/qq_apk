import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

public class jwk
  extends TimerTask
{
  public jwk(MainAcitivityReportHelper paramMainAcitivityReportHelper, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      MainAcitivityReportHelper.d((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwk
 * JD-Core Version:    0.7.0.1
 */