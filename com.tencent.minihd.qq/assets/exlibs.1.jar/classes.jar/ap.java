import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.XListView;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import mqq.app.MobileQQ;

public class ap
  implements View.OnClickListener
{
  public ap(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, DataLineMsgSet paramDataLineMsgSet, Context paramContext, String paramString, boolean paramBoolean) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    int i = 0;
    if (2131302491 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_copy");
      ((ClipboardManager)LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).getContext().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg);
      return;
    }
    Object localObject1;
    if (2131302483 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_delete");
      paramView = new aq(this);
      localObject1 = new ar(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131362060), this.jdField_a_of_type_AndroidContentContext.getString(2131362090), 2131365736, 2131362063, paramView, (DialogInterface.OnClickListener)localObject1).show();
      return;
    }
    Object localObject2;
    long l;
    if (2131298174 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_forward");
      if (this.jdField_a_of_type_JavaLangString.isEmpty())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
        localObject1 = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, ForwardRecentActivity.class);
        localObject2 = AppConstants.Y;
        ((Intent)localObject1).putExtra("forward_text", new QQText(paramView.msg, 13, 32, 6000).toString());
        ((Intent)localObject1).putExtra("forward_type", -1);
        ((Intent)localObject1).putExtra("isFromShare", true);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject1, 4);
        return;
      }
      l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
      paramView = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).b(10000);
      ((ForwardFileInfo)localObject1).d(6);
      ((ForwardFileInfo)localObject1).d(paramView);
      ((ForwardFileInfo)localObject1).d(l);
      ((ForwardFileInfo)localObject1).a(this.jdField_a_of_type_JavaLangString);
      ((ForwardFileInfo)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.entityID);
      localObject2 = new Intent(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, ForwardRecentActivity.class);
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        ((Intent)localObject2).putExtra("forward_text", paramView);
        if (this.jdField_a_of_type_Boolean) {
          i = 1;
        }
        ((Intent)localObject2).putExtra("forward_type", i);
        ((Intent)localObject2).putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject1);
        ((Intent)localObject2).putExtra("not_forward", true);
        ((Intent)localObject2).putExtra("isFromShare", true);
        if (this.jdField_a_of_type_Boolean) {
          ((Intent)localObject2).putExtra("forward_thumb", this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.path);
        }
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult((Intent)localObject2, 4);
        return;
        paramView = "已选择" + paramView + "。";
      }
    }
    if (2131298924 == paramView.getId())
    {
      if (this.jdField_a_of_type_JavaLangString.isEmpty())
      {
        QfavBuilder.a(null, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
        QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 1);
        return;
      }
      QfavBuilder.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app).a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app, 64, 3);
      return;
    }
    if (2131302492 == paramView.getId())
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(), "dl_save2weiyun");
      l = FileUtils.a(this.jdField_a_of_type_JavaLangString);
      localObject1 = FileManagerUtil.a(this.jdField_a_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
      if (((DataLineMsgRecord)localObject2).nWeiyunSessionId == 0L) {
        break label954;
      }
    }
    label954:
    for (paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);; paramView = null)
    {
      if ((FileManagerUtil.a()) && (l > 5242880L))
      {
        FMDialogUtil.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getActivity(), 2131362469, 2131362465, new as(this, paramView, (String)localObject1, (DataLineMsgRecord)localObject2));
        return;
      }
      if (paramView == null)
      {
        FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362431));
        ((DataLineMsgRecord)localObject2).nWeiyunSessionId = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_JavaLangString, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false).nSessionId;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a().c(((DataLineMsgRecord)localObject2).msgId);
        return;
      }
      FMToastUtil.b(FileManagerUtil.d((String)localObject1) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131362431));
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(((DataLineMsgRecord)localObject2).nWeiyunSessionId);
      return;
      if (2131302501 != paramView.getId()) {
        break;
      }
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a().a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, this.jdField_a_of_type_JavaLangString, 4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ap
 * JD-Core Version:    0.7.0.1
 */