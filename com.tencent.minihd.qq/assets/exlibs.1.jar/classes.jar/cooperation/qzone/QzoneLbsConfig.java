package cooperation.qzone;

import common.config.service.QzoneConfig;

public class QzoneLbsConfig
{
  public static final int a = 20;
  public static final int b = 5;
  public static final int c = 3600000;
  
  public static int a()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "POICacheTime")).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 7;
  }
  
  public static int b()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "POICacheDistance")).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 1000;
  }
  
  public static int c()
  {
    try
    {
      i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "CoordinateCacheTime")).intValue();
      return i * 1000;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 300;
      }
    }
  }
  
  public static int d()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "LBSPreload", 1)).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 1;
  }
  
  public static int e()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "GPSPrelocateMaxTimeout")).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 20;
  }
  
  public static int f()
  {
    try
    {
      int i = Integer.valueOf(QzoneConfig.a().a("QZoneSetting", "GPSLocateMaxTimeout")).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QzoneLbsConfig
 * JD-Core Version:    0.7.0.1
 */