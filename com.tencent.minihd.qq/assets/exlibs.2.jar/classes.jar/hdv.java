import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.widget.qqmusic.business.folder.FolderSongManager;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.mobileqq.activity.widget.qqmusic.data.FolderInfo;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicFolderSelectActivity;
import com.tencent.mobileqq.music.QQPlayerService;

class hdv
  implements DialogInterface.OnClickListener
{
  hdv(hdu paramhdu, FolderInfo paramFolderInfo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new FolderSongManager(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo).a(this.jdField_a_of_type_Hdu.a);
    MusicPreferences.a().a(0);
    MusicPreferences.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo.a());
    MusicPreferences.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo.b());
    MusicPreferences.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo.c());
    MusicPreferences.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataFolderInfo.a());
    QQPlayerService.b(QQPlayerService.a(6, ""));
    this.jdField_a_of_type_Hdu.a.finish();
    paramDialogInterface.dismiss();
    QQMusicFolderSelectActivity.a(this.jdField_a_of_type_Hdu.a, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdv
 * JD-Core Version:    0.7.0.1
 */