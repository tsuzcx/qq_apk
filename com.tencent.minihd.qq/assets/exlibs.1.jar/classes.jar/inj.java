import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter.LocalItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public class inj
  implements View.OnClickListener
{
  public inj(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    FileInfo localFileInfo = null;
    if ((localObject instanceof QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)) {
      localFileInfo = (FileInfo)((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag()).a;
    }
    for (;;)
    {
      this.a.c(localFileInfo);
      return;
      if ((localObject instanceof QfileLocalImageExpandableListAdapter.ImageHolder)) {
        localFileInfo = (FileInfo)((QfileLocalImageExpandableListAdapter.ImageHolder)paramView.getTag()).a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     inj
 * JD-Core Version:    0.7.0.1
 */