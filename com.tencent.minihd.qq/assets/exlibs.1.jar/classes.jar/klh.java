import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class klh
  extends AsyncTask
{
  public klh(VideoPlayLogic paramVideoPlayLogic, TroopInfoManager paramTroopInfoManager) {}
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b();
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) == null) || (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)))
    {
      if (TroopFileUtils.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)) == 0)
      {
        if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
          VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
        }
        QQToast.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getResources().getString(2131363842), 1).a();
        return;
      }
      if (TroopFileUtils.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)) != 2)
      {
        if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
          VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
        }
        DialogUtil.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), 230, VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getString(2131363346), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).getString(2131363479), 2131365736, 2131363480, new kli(this), new klj(this)).show();
        return;
      }
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic);
      return;
    }
    if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
    }
    if (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null)
    {
      new StructMsgForGeneralShare.GeneralClickHandler(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic), VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic)).a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic.a(VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic));
  }
  
  protected void onCancelled()
  {
    if ((VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic) != null) && (VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).isShowing() == true)) {
      VideoPlayLogic.a(this.jdField_a_of_type_ComTencentMobileqqTroopLogicVideoPlayLogic).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     klh
 * JD-Core Version:    0.7.0.1
 */