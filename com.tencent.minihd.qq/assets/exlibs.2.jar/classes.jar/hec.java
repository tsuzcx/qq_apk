import com.tencent.mobileqq.activity.widget.qqmusic.business.radio.GuessYouLikeManager;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.CircleProgressView;
import com.tencent.mobileqq.activity.widget.qqmusic.ui.QQMusicWidget;
import com.tencent.mobileqq.music.SongInfo;

class hec
  implements Runnable
{
  hec(hea paramhea, SongInfo paramSongInfo) {}
  
  public void run()
  {
    QQMusicWidget.a(this.jdField_a_of_type_Hea.a).setProgress(0);
    QQMusicWidget.a(this.jdField_a_of_type_Hea.a, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b == 1) && (GuessYouLikeManager.a().a(this.jdField_a_of_type_Hea.a.getContext()))) {
      return;
    }
    QQMusicWidget.b(this.jdField_a_of_type_Hea.a, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
    QQMusicWidget.d(this.jdField_a_of_type_Hea.a);
    QQMusicWidget.c(this.jdField_a_of_type_Hea.a, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
    QQMusicWidget.d(this.jdField_a_of_type_Hea.a, this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hec
 * JD-Core Version:    0.7.0.1
 */