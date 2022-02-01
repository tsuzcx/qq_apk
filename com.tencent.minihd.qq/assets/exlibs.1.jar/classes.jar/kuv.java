import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class kuv
  implements Runnable
{
  public kuv(ClubContentJsonTask.TaskInfo paramTaskInfo, File paramFile) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, EmosmUtils.insertMtype("VIP_emosm", this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.b), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "downloadIfNotExists, " + this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.a + ",ret=" + bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kuv
 * JD-Core Version:    0.7.0.1
 */