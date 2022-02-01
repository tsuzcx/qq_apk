import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import java.util.ArrayList;

class jby
  implements FMDialogUtil.FMDialogInterface
{
  jby(jbx paramjbx) {}
  
  public void a()
  {
    ArrayList localArrayList = FMDataCache.b();
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.a(this.a.a).setResult(-1, localIntent);
    SendBottomBar.a(this.a.a).finish();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jby
 * JD-Core Version:    0.7.0.1
 */