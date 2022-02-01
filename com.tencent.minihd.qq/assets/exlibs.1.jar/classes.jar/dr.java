import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.ItemHolder;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.util.ArrayList;

public class dr
  implements View.OnClickListener
{
  public dr(PrinterSessionAdapter paramPrinterSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (PrinterItemMsgRecord)((ItemHolder)paramView.getTag()).a();
    if (localObject != null)
    {
      paramView = FileManagerUtil.a((PrinterItemMsgRecord)localObject);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10009);
      localForwardFileInfo.d(6);
      localForwardFileInfo.b(paramView.nSessionId);
      localForwardFileInfo.d(paramView.fileName);
      localForwardFileInfo.c(((PrinterItemMsgRecord)localObject).uSessionID);
      localForwardFileInfo.d(paramView.fileSize);
      localForwardFileInfo.a(paramView.strFilePath);
      localObject = new Intent(this.a.a.getApplicationContext(), FileBrowserActivity.class);
      if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramView.nSessionId));
        ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      this.a.a.startActivityForResult((Intent)localObject, 102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dr
 * JD-Core Version:    0.7.0.1
 */