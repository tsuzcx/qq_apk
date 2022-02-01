import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderListManager.LoadFolderListener;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.FolderListAdapter;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;

public class hdt
  implements FolderListManager.LoadFolderListener
{
  public hdt(QQMusicFolderSelectActivity paramQQMusicFolderSelectActivity) {}
  
  public void a()
  {
    QQMusicFolderSelectActivity.a(this.a, FolderListManager.a().a());
    QQMusicFolderSelectActivity.b(this.a, FolderListManager.a().b());
    QQMusicFolderSelectActivity.a(this.a).a(QQMusicFolderSelectActivity.a(this.a), QQMusicFolderSelectActivity.b(this.a));
    QQMusicFolderSelectActivity.a(this.a).notifyDataSetChanged();
  }
  
  public void a(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdt
 * JD-Core Version:    0.7.0.1
 */