import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class hjg
  extends EmoticonPackageDownloadListener
{
  public hjg(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonManagerImp", 2, "json is complete,result ok: " + paramEmoticonPackage.epId);
      }
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.jdField_a_of_type_JavaUtilMap.get(paramEmoticonPackage.epId);
      if (localEmoticonPackage != null)
      {
        localEmoticonPackage.name = paramEmoticonPackage.name;
        localEmoticonPackage.mark = paramEmoticonPackage.mark;
        localEmoticonPackage.mobileFeetype = paramEmoticonPackage.mobileFeetype;
        localEmoticonPackage.downloadCount = paramEmoticonPackage.downloadCount;
        localEmoticonPackage.type = paramEmoticonPackage.type;
        this.a.a(localEmoticonPackage);
        this.a.a(localEmoticonPackage.epId);
        ((EmojiManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramEmoticonPackage);
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006649", "0X8006649", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hjg
 * JD-Core Version:    0.7.0.1
 */