import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qav.ui.C2CVideoLayer;
import com.tencent.qav.ui.C2CVideoView;

public class ljy
  extends CameraObserver
{
  public ljy(C2CVideoLayer paramC2CVideoLayer) {}
  
  public void onAfterSwitchCamera(boolean paramBoolean)
  {
    if ((paramBoolean) && (C2CVideoLayer.a(this.a) != null))
    {
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.clearCameraFrames();
      localGraphicRenderMgr.flushGlRender(C2CVideoLayer.a(this.a).a());
      C2CVideoLayer.a(this.a).setCameraIsBindData(false);
    }
  }
  
  public void onAfterSwitchFirstFrame()
  {
    boolean bool = CameraUtils.getInstance(C2CVideoLayer.a(this.a)).isFrontCamera();
    C2CVideoLayer.a(this.a).setMirror(bool);
    C2CVideoLayer.a(this.a).setCameraIsBindData(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */