import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.tencent.mobileqq.vas.ColorRingPlayer;

class kvc
  implements Runnable
{
  kvc(kvb paramkvb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        bool1 = this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
      }
      if ((this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (bool1)) {
        this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(this.jdField_a_of_type_Int * 100 / this.b);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_a_of_type_Kvb.a.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kvc
 * JD-Core Version:    0.7.0.1
 */