import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.theme.ThemeActiveLogic;
import com.tencent.mobileqq.theme.ThemeActiveLogic.ActiveThemeInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

public final class kux
  implements Runnable
{
  public kux(ClubContentJsonTask.TaskInfo paramTaskInfo, File paramFile, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, EmosmUtils.insertMtype("VIP_other", this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.b), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "updateJson, " + this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.b + ",ret=" + bool);
    }
    ThemeActiveLogic localThemeActiveLogic;
    Object localObject;
    if (bool)
    {
      ClubContentJsonTask.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.d, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.e.equals(ClubContentJsonTask.e.e))
      {
        localThemeActiveLogic = new ThemeActiveLogic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = localThemeActiveLogic.getActiveThemeJson();
        if (localObject != null) {
          break label130;
        }
      }
    }
    label130:
    do
    {
      return;
      localObject = ThemeActiveLogic.getActiveThemeInfo((JSONArray)localObject);
    } while ((localObject == null) || (!localThemeActiveLogic.ABListAuth((ThemeActiveLogic.ActiveThemeInfo)localObject)));
    localThemeActiveLogic.start((ThemeActiveLogic.ActiveThemeInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kux
 * JD-Core Version:    0.7.0.1
 */