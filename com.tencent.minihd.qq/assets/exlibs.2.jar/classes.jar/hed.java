import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.MyFavSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.SongInfo;
import java.util.ArrayList;

public class hed
  implements DialogInterface.OnClickListener
{
  public hed(QQMusicWidget paramQQMusicWidget, SongInfo paramSongInfo, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MyFavSongManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo, false);
    this.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.a));
    QQMusicWidget.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicUiQQMusicWidget, false);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hed
 * JD-Core Version:    0.7.0.1
 */