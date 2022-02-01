import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;

public class ftj
  implements View.OnClickListener
{
  public ftj(DeviceSingleStructBuilder paramDeviceSingleStructBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (MessageForDeviceSingleStruct)AIOUtils.a(paramView);
    if (paramView == null) {
      return;
    }
    int i = FileManagerUtil.a(FileUtil.a(paramView.strMediaFileName));
    paramView = FileManagerUtil.a(paramView);
    Object localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).b(10009);
    ((ForwardFileInfo)localObject).d(8);
    ((ForwardFileInfo)localObject).b(paramView.nSessionId);
    ((ForwardFileInfo)localObject).d(paramView.fileName);
    ((ForwardFileInfo)localObject).c(paramView.uniseq);
    ((ForwardFileInfo)localObject).d(paramView.fileSize);
    ((ForwardFileInfo)localObject).a(paramView.strFilePath);
    Intent localIntent = new Intent(this.a.a, FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", (Parcelable)localObject);
    localObject = new ArrayList();
    if (i == 0) {
      ((ArrayList)localObject).add(String.valueOf(paramView.nSessionId));
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject);
    ((Activity)this.a.a).startActivityForResult(localIntent, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ftj
 * JD-Core Version:    0.7.0.1
 */