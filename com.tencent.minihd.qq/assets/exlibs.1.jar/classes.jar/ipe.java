import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ipe
  implements Runnable
{
  public ipe(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB thread start");
    }
    if ((this.a.b != null) && (this.a.b.trim().length() != 0)) {}
    for (List localList = QfileBaseRecentFileTabView.a(this.a).a().a(this.a.b);; localList = QfileBaseRecentFileTabView.b(this.a).a().a())
    {
      if (localList != null) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
      }
      if (QLog.isColorLevel()) {
        QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB end size[" + this.a.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      this.a.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ipe
 * JD-Core Version:    0.7.0.1
 */