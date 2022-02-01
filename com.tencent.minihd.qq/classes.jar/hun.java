import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public final class hun
  extends SosoInterface.OnLocationListener
{
  public hun(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super(paramInt, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onLocationFinish() lock.notifyAll()");
    }
    synchronized (SosoInterface.a)
    {
      SosoInterface.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hun
 * JD-Core Version:    0.7.0.1
 */