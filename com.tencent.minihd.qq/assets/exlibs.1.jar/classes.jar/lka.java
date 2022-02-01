import com.tencent.av.opengl.ui.GLVideoView;
import com.tencent.av.opengl.ui.animation.GLAnimation.AnimationListenerGL;
import com.tencent.qav.ui.C2CVideoLayer;

public class lka
  implements GLAnimation.AnimationListenerGL
{
  public lka(C2CVideoLayer paramC2CVideoLayer, GLVideoView paramGLVideoView1, GLVideoView paramGLVideoView2) {}
  
  public void onAnimationEnd()
  {
    C2CVideoLayer.b(this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer, this.jdField_a_of_type_ComTencentAvOpenglUiGLVideoView, this.b);
    C2CVideoLayer localC2CVideoLayer = this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer;
    if (!C2CVideoLayer.a(this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer)) {}
    for (boolean bool = true;; bool = false)
    {
      C2CVideoLayer.a(localC2CVideoLayer, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lka
 * JD-Core Version:    0.7.0.1
 */