import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class iqd
  implements Runnable
{
  public iqd(QfileRecentAllFileTabView paramQfileRecentAllFileTabView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
      if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
        this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
      }
      ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
    }
    this.a.i();
    this.a.setSelect(0);
    this.a.a(true);
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iqd
 * JD-Core Version:    0.7.0.1
 */