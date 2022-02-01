import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.qav.bussiness.QavBussinessCtrl;

public class bzq
  implements SeekBar.OnSeekBarChangeListener
{
  public bzq(QavPanel paramQavPanel) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_Int != paramInt)
    {
      if (paramBoolean) {
        this.a.jdField_a_of_type_AndroidWidgetSeekBar.setContentDescription(paramInt + "%");
      }
      this.a.jdField_a_of_type_Int = paramInt;
      paramSeekBar = QavBussinessCtrl.a().a();
      if (paramSeekBar != null) {
        paramSeekBar.d = this.a.jdField_a_of_type_Int;
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    QavBussinessCtrl.a().b(this.a.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzq
 * JD-Core Version:    0.7.0.1
 */