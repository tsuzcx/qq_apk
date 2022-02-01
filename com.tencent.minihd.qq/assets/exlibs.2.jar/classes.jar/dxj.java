import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.EmosmObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class dxj
  extends EmosmObserver
{
  public dxj(EmosmActivity paramEmosmActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmosmActivity", 2, "...........onUpdate.............");
    }
    if (paramInt == 1)
    {
      localObject1 = this.a;
      ((EmosmActivity)localObject1).jdField_a_of_type_Int += 1;
      paramObject = (EmosmResp)paramObject;
      this.a.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.b(paramObject.delEpId + "");
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.setNotifyOnChange(true);
      paramInt = 0;
      if (paramInt < this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getCount())
      {
        localObject1 = (EmoticonPackage)this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.getItem(paramInt);
        if (!((EmoticonPackage)localObject1).epId.equals(paramObject.delEpId + "")) {
          break label293;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.remove(localObject1);
        ((EmojiManager)this.a.app.getManager(42)).a.b((EmoticonPackage)localObject1);
        ReportController.b(this.a.app, "CliOper", "", "", "EmosmObserver", "EpDelete", 0, 0, "", "", "", "");
        if (3 == ((EmoticonPackage)localObject1).jobType) {
          ReportController.b(this.a.app, "CliOper", "", "", "MbGuanli", "MbDianjiShanchu", 0, 0, "", "", "", "");
        }
        this.a.a((EmoticonPackage)localObject1);
      }
    }
    label293:
    while ((paramInt != 2) || (!paramBoolean)) {
      for (;;)
      {
        if (this.a.b == this.a.jdField_a_of_type_Int) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        return;
        paramInt += 1;
      }
    }
    Object localObject1 = (EmoticonManager)this.a.app.getManager(13);
    Object localObject2 = (EmosmResp)paramObject;
    paramObject = ((EmosmResp)localObject2).data;
    paramObject.addAll(((EmosmResp)localObject2).magicData);
    paramInt = 0;
    int i = 0;
    label515:
    for (;;)
    {
      try
      {
        if (i < paramObject.size())
        {
          localObject2 = (EmoticonPackage)paramObject.get(i);
          EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject1).b(((EmoticonPackage)localObject2).epId);
          if ((localEmoticonPackage == null) || ((localEmoticonPackage.expiretime == ((EmoticonPackage)localObject2).expiretime) && (localEmoticonPackage.wordingId == ((EmoticonPackage)localObject2).wordingId) && (localEmoticonPackage.jobType == ((EmoticonPackage)localObject2).jobType))) {
            break label515;
          }
          localEmoticonPackage.expiretime = ((EmoticonPackage)localObject2).expiretime;
          localEmoticonPackage.wordingId = ((EmoticonPackage)localObject2).wordingId;
          localEmoticonPackage.jobType = ((EmoticonPackage)localObject2).jobType;
          ((EmoticonManager)localObject1).a(localEmoticonPackage);
          paramInt = 1;
          i += 1;
          continue;
        }
        if (paramInt == 0) {
          break;
        }
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
      this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxj
 * JD-Core Version:    0.7.0.1
 */