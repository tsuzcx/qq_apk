import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLRouterActivity;
import com.dataline.util.ItemHolder;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;
import java.util.Iterator;

public class dx
  implements View.OnClickListener
{
  public dx(RouterSessionAdapter paramRouterSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = ((ItemHolder)paramView.getTag()).a();
    if ((paramView == null) || (-1000 == paramView.msgtype)) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramView);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(10009);
    localForwardFileInfo.d(6);
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(paramView.filename);
    localForwardFileInfo.c(paramView.uSessionID);
    localForwardFileInfo.d(paramView.fileSize);
    localForwardFileInfo.a(paramView.filename);
    Intent localIntent = new Intent(this.a.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getApplicationContext(), FileBrowserActivity.class);
    ArrayList localArrayList = new ArrayList();
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.iterator();
      while (localIterator.hasNext())
      {
        RouterMsgRecord localRouterMsgRecord = (RouterMsgRecord)localIterator.next();
        if (FileManagerUtil.a(localRouterMsgRecord.filename) == localFileManagerEntity.nFileType) {
          if (localRouterMsgRecord != paramView) {
            localArrayList.add(String.valueOf(FileManagerUtil.a(localRouterMsgRecord).nSessionId));
          } else {
            localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
          }
        }
      }
      if (localArrayList.size() == 0) {
        localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      }
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    this.a.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.startActivityForResult(localIntent, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dx
 * JD-Core Version:    0.7.0.1
 */