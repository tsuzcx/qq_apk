import com.tencent.device.DeviceHeadMgr;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class cwt
  implements Runnable
{
  public cwt(DeviceHeadMgr paramDeviceHeadMgr, String paramString, File paramFile) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, EmosmUtils.insertMtype("VIP_other", DeviceHeadMgr.a(this.jdField_a_of_type_JavaLangString)), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("DeviceHeadMgr", 2, "downloadAllIfNotExists, " + this.jdField_a_of_type_JavaLangString + ",ret=" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwt
 * JD-Core Version:    0.7.0.1
 */