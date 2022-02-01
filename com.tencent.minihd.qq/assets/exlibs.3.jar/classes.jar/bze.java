import android.widget.TextView;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.utils.UITools1;

public class bze
  implements Runnable
{
  public bze(SmallScreenVideoControlUI paramSmallScreenVideoControlUI, long paramLong) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long / 1000L;
    if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a == null) || (l != 0L))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a = UITools1.a(l);
      if (SmallScreenVideoControlUI.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI) != null)
      {
        SmallScreenVideoControlUI.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI).setContentDescription(UITools1.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a));
        SmallScreenVideoControlUI.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI).setText(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bze
 * JD-Core Version:    0.7.0.1
 */