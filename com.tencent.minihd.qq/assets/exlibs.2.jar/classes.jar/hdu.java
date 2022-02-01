import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.FolderListAdapter;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnChildClickListener;
import java.util.ArrayList;
import java.util.HashMap;

public class hdu
  implements ExpandableListView.OnChildClickListener
{
  public hdu(QQMusicFolderSelectActivity paramQQMusicFolderSelectActivity) {}
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (!QQMusicFolderSelectActivity.a(this.a)) {
      return true;
    }
    paramExpandableListView = QQMusicFolderSelectActivity.a(this.a).a();
    if ((paramExpandableListView == null) || (paramExpandableListView.get(Integer.valueOf(paramInt1)) == null)) {
      return false;
    }
    paramExpandableListView = (FolderInfo)((ArrayList)paramExpandableListView.get(Integer.valueOf(paramInt1))).get(paramInt2);
    if (paramExpandableListView == null) {
      return false;
    }
    if (ApnManager.b())
    {
      new FolderSongManager(paramExpandableListView).a(this.a);
      MusicPreferences.a().a(0);
      MusicPreferences.a().a(paramExpandableListView.a());
      MusicPreferences.a().b(paramExpandableListView.b());
      MusicPreferences.a().c(paramExpandableListView.c());
      MusicPreferences.a().e(paramExpandableListView.a());
      QQPlayerService.b(QQPlayerService.a(6, ""));
      this.a.finish();
      QQMusicFolderSelectActivity.a(this.a, paramInt1);
    }
    for (;;)
    {
      return true;
      DialogUtil.a(this.a, 230, this.a.getResources().getString(2131365011), this.a.getResources().getString(2131365012), this.a.getResources().getString(2131365013), this.a.getResources().getString(2131365014), new hdv(this, paramExpandableListView, paramInt1), new hdw(this)).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdu
 * JD-Core Version:    0.7.0.1
 */