import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.smallscreen.SmallScreenVideoLayerUI;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.session.QavSession;

public class bzf
  extends QavBussinessObserver
{
  public bzf(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    if (this.a.jdField_a_of_type_ComTencentQavSessionQavSession == null) {
      this.a.jdField_a_of_type_ComTencentQavSessionQavSession = QavBussinessCtrl.a().a();
    }
    if (this.a.jdField_a_of_type_ComTencentQavSessionQavSession != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b(this.a.jdField_a_of_type_ComTencentQavSessionQavSession.h, this.a.jdField_a_of_type_ComTencentQavSessionQavSession.f);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
    if (this.a.jdField_a_of_type_ComTencentQavAppQavAppInterface != null) {
      SmallScreenUtils.a(this.a.jdField_a_of_type_ComTencentQavAppQavAppInterface.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     bzf
 * JD-Core Version:    0.7.0.1
 */