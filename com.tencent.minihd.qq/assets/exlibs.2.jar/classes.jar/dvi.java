import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public final class dvi
  implements Runnable
{
  public dvi(long paramLong, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, Activity paramActivity, int paramInt, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    Object localObject4 = null;
    int j = 0;
    int i = 0;
    Object localObject3;
    label78:
    FriendManager localFriendManager;
    if (1L == this.jdField_a_of_type_Long)
    {
      if (SystemUtil.a()) {}
      for (Object localObject1 = AppConstants.aZ;; localObject1 = SystemUtil.jdField_a_of_type_JavaLangString + "head/_hd/")
      {
        localObject1 = (String)localObject1 + "default_discussion_icon.png";
        localObject3 = new File((String)localObject1);
        if (!((File)localObject3).exists()) {
          break;
        }
        i = 1;
        if (i != 0) {
          break label606;
        }
        localObject3 = "";
        AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a("推荐讨论组：" + this.c).e(this.d).a("邀请加入讨论组", null).a();
        localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject1 = localObject4;
        if (localFriendManager != null)
        {
          localObject1 = localFriendManager.a(this.jdField_a_of_type_JavaLangString);
          localObject4 = localFriendManager.a(this.jdField_a_of_type_JavaLangString, ((DiscussionInfo)localObject1).ownerUin);
          if (localObject4 == null) {
            break label564;
          }
          localObject1 = ContactUtils.a((DiscussionMemberInfo)localObject4, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        label205:
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = "创建者信息获取失败";
        }
        localObject1 = StructMsgElementFactory.a(2);
        ((AbsStructMsgItem)localObject1).a((String)localObject3, this.c, "创建人：" + (String)localObject4);
        localAbsShareMsg.addItem((AbsStructMsgElement)localObject1);
        localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        ((Intent)localObject1).putExtra("forward_type", -3);
        ((Intent)localObject1).putExtra("stuctmsg_bytes", localAbsShareMsg.getBytes());
        new Handler(Looper.getMainLooper()).post(new dvj(this, (Intent)localObject1));
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        return;
      }
    }
    for (;;)
    {
      try
      {
        ((File)localObject3).createNewFile();
        boolean bool = ((BitmapDrawable)ImageUtil.d()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream((File)localObject3));
        if (!bool) {
          break label621;
        }
        i = 1;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          localIOException.printStackTrace();
        }
        localObject2 = null;
      }
      break;
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(101, this.jdField_a_of_type_JavaLangString, 0));
      localObject2 = QZoneShareManager.a((ArrayList)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.b, "1");
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject3 = (String)((ArrayList)localObject2).get(0);
        localObject2 = localObject3;
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break;
        }
        if (!((String)localObject3).startsWith("http://"))
        {
          localObject2 = localObject3;
          i = j;
          if (!((String)localObject3).startsWith("https://")) {
            break;
          }
        }
        i = 1;
        localObject2 = localObject3;
        break;
        label564:
        if (localFriendManager.b(((DiscussionInfo)localObject2).ownerUin))
        {
          localObject2 = localFriendManager.c(((DiscussionInfo)localObject2).ownerUin);
          break label205;
        }
        localObject2 = ((DiscussionInfo)localObject2).ownerUin;
        break label205;
        label606:
        localObject3 = localObject2;
        break label78;
      }
      localObject2 = null;
      i = j;
      break;
      label621:
      localObject2 = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvi
 * JD-Core Version:    0.7.0.1
 */