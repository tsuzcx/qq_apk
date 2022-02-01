import android.os.Handler;
import com.tencent.av.ui.QavPanelSoundWaveView;
import com.tencent.av.ui.QavPanelWave;
import java.util.Iterator;
import java.util.List;

public class bzr
  implements Runnable
{
  public bzr(QavPanelSoundWaveView paramQavPanelSoundWaveView) {}
  
  public void run()
  {
    if (this.a.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 200L);
      return;
    }
    Object localObject;
    if (!this.a.jdField_a_of_type_Boolean) {
      localObject = this.a;
    }
    for (((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 0.00048F;; ((QavPanelSoundWaveView)localObject).c += -this.a.jdField_a_of_type_Float * 0.00067F)
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((QavPanelWave)((Iterator)localObject).next()).a(this.a.c, 12.75F);
      }
      localObject = this.a;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 66L);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzr
 * JD-Core Version:    0.7.0.1
 */