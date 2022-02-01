import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.AbsPublishIphoneTitleBarActivity;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.troop.data.VideoInfo;
import java.io.File;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;

public class kcc
  extends Thread
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo;
  private WeakReference jdField_a_of_type_MqqUtilWeakReference;
  
  public kcc(AbsPublishIphoneTitleBarActivity paramAbsPublishIphoneTitleBarActivity, BaseActivity paramBaseActivity, Handler paramHandler, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo == null) {
      return;
    }
    Object localObject2 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    Object localObject1 = ((BaseActivity)localObject2).app.a();
    localObject2 = ((TicketManager)((BaseActivity)localObject2).app.getManager(2)).getSkey((String)localObject1);
    Bundle localBundle = new Bundle();
    localBundle.putString("cat", "原创");
    localBundle.putString("file_path", this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.b);
    localBundle.putString("tags", "部落");
    localBundle.putString("title", new File(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.b).getName());
    localObject1 = TroopBarShortVideoUploadUtil.a(localBundle, (String)localObject1, (String)localObject2);
    localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    if ((localObject1 != null) && (((TroopBarShortVideoUploadUtil.ApplyUploadRsp)localObject1).f != null))
    {
      ((Message)localObject2).what = 1003;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishIphoneTitleBarActivity.jdField_a_of_type_ComTencentMobileqqTroopDataVideoInfo.e = ((TroopBarShortVideoUploadUtil.ApplyUploadRsp)localObject1).f;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      return;
      ((Message)localObject2).what = 1008;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcc
 * JD-Core Version:    0.7.0.1
 */