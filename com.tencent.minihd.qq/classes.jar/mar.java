import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.CrashGuard;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.concurrent.atomic.AtomicBoolean;

public class mar
  implements Runnable
{
  public mar(CrashGuard paramCrashGuard, long paramLong) {}
  
  public void run()
  {
    CrashGuard.a(this.jdField_a_of_type_CooperationQzoneCrashGuard).set(true);
    QLog.i("QZLog", 1, "clear crash count with no crash");
    LocalMultiProcConfig.a("key_crash_count", 0, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mar
 * JD-Core Version:    0.7.0.1
 */