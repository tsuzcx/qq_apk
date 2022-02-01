import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class iqs
  implements Runnable
{
  public iqs(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.nFileType == 0)
      {
        if ((!FileUtil.b(localFileManagerEntity.strFilePath)) && (!FileUtil.b(localFileManagerEntity.strThumbPath)))
        {
          if (localFileManagerEntity.cloudType != 1) {
            break label206;
          }
          if (localFileManagerEntity.peerType != 3000) {
            break label179;
          }
          QfileRecentPicFileTabView.a(this.a).a().a(localFileManagerEntity, 3);
        }
        for (;;)
        {
          String str = QfileTimeUtils.a(localFileManagerEntity.srvTime);
          if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
            this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
          }
          ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
          break;
          label179:
          QfileRecentPicFileTabView.b(this.a).a().a(localFileManagerEntity.Uuid, 3, localFileManagerEntity.bSend, localFileManagerEntity);
          continue;
          label206:
          if (localFileManagerEntity.cloudType == 2) {
            QfileRecentPicFileTabView.c(this.a).a().a(localFileManagerEntity.WeiYunFileId, localFileManagerEntity.fileName, 3, localFileManagerEntity);
          }
        }
      }
    }
    this.a.i();
    this.a.setSelect(0);
    this.a.a(true);
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iqs
 * JD-Core Version:    0.7.0.1
 */