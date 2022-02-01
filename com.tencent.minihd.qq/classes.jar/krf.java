import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public final class krf
  implements Runnable
{
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CpuFrequency:" + DeviceInfoUtil.a() + "Khz\n").append("CpuNum:" + DeviceInfoUtil.b() + "\n").append("OsInfo:" + DeviceInfoUtil.a() + "\n").append("DeviceModel:" + DeviceInfoUtil.d() + "\n").append("DeviceOS:" + DeviceInfoUtil.e() + "\n").append("ManufactureInfo:" + DeviceInfoUtil.g() + "\n").append("QQVersion:" + DeviceInfoUtil.c() + "\n");
      long l1 = DeviceInfoUtil.c() / 1048576L;
      long l2 = DeviceInfoUtil.d() / 1048576L;
      localStringBuilder.append("TotalRam: " + l1 + "MB ,AvailRam: " + l2 + "MB\n");
      long[] arrayOfLong = DeviceInfoUtil.a();
      localStringBuilder.append("TotalRom: " + arrayOfLong[0] + "MB ,AvailRom: " + arrayOfLong[1] + "MB\n").append("BatteryInfo:" + DeviceInfoUtil.o() + "\n").append("Resolution:" + DeviceInfoUtil.k() + "\n").append("Top10P:" + DeviceInfoUtil.m() + "\n").append("Top10T:" + DeviceInfoUtil.n() + "\n");
      QLog.d("DeviceInfoUtil", 2, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("DeviceInfoUtil", 2, "error in getSystemState");
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     krf
 * JD-Core Version:    0.7.0.1
 */