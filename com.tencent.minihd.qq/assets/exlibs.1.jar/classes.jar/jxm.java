import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class jxm
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    localObject1 = paramView.findViewById(2131296309);
    if (localObject1 == null) {}
    Object localObject2;
    Context localContext;
    Object localObject3;
    Intent localIntent;
    for (;;)
    {
      return;
      localObject2 = ((View)localObject1).getTag(2131296309);
      if ((localObject2 instanceof StructMsgForImageShare))
      {
        localObject2 = (StructMsgForImageShare)localObject2;
        localContext = paramView.getContext();
        try
        {
          paramView = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(((StructMsgForImageShare)localObject2).currentAccountUin);
          AbsShareMsg.doReport(paramView, (AbsShareMsg)localObject2);
          if (((StructMsgForImageShare)localObject2).msgId > 0L) {
            ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForImageShare)localObject2).uin, "mp_msg_msgpic_click", "aio_morpic_click", 1, 0, "", "", Long.toString(((StructMsgForImageShare)localObject2).msgId), "");
          }
          localObject3 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
          if (localObject3 != null) {
            if ((!MsgUtils.b(((StructMsgForImageShare)localObject2).mIsSend)) && (((StructMsgItemImage)localObject3).a != null))
            {
              paramView = PicItemBuilder.a(localContext, ((StructMsgItemImage)localObject3).a);
              if (paramView != null) {
                if (paramView.getStatus() == 2)
                {
                  paramView.restartDownload();
                  return;
                }
              }
            }
          }
        }
        catch (AccountNotMatchException paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, paramView.getStackTrace().toString());
            }
            paramView = null;
          }
          if ((paramView.getStatus() == 0) && (!paramView.isDownloadStarted()))
          {
            paramView.startDownload();
            return;
          }
          localIntent = new Intent(localContext, AIOGalleryActivity.class);
          localIntent.putExtra("curType", ((StructMsgForImageShare)localObject2).uinType);
          localIntent.putExtra("_id", ((StructMsgForImageShare)localObject2).uniseq);
          localIntent.putExtra("urlAtServer", ((StructMsgItemImage)localObject3).k);
          localIntent.putExtra("KEY_FILE_ID", ((StructMsgItemImage)localObject3).c);
          localIntent.putExtra("picMD5", ((StructMsgItemImage)localObject3).l);
          localIntent.putExtra("url", ((StructMsgItemImage)localObject3).j);
          localIntent.putExtra("friendUin", ((StructMsgForImageShare)localObject2).uin);
          localIntent.putExtra("KEY_MSG_VERSION_CODE", ((StructMsgForImageShare)localObject2).messageVersion);
          localIntent.putExtra("isSend", ((StructMsgForImageShare)localObject2).mIsSend);
          localIntent.putExtra("KEY_BUSI_TYPE", 1030);
          localIntent.putExtra("IS_FROMOTHER_TERMINAL_KEY", MsgUtils.c(((StructMsgForImageShare)localObject2).mIsSend));
          localIntent.putExtra("uin", ((StructMsgForImageShare)localObject2).uin);
          if (((StructMsgForImageShare)localObject2).mIsSend != 1) {}
        }
      }
    }
    for (paramView = ((StructMsgForImageShare)localObject2).currentAccountUin;; paramView = ((StructMsgForImageShare)localObject2).uin)
    {
      localIntent.putExtra("KEY_TROOP_CODE", paramView);
      localIntent.putExtra("fileSize", ((StructMsgItemImage)localObject3).d);
      localIntent.putExtra("KEY_TIME", ((StructMsgItemImage)localObject3).e);
      localIntent.putExtra("KEY_SUB_VERSION", 5);
      localIntent.putExtra("KEY_FILE_SIZE_FLAG", 0);
      localIntent.putExtra("IS_APP_SHARE_PIC", true);
      localIntent.putExtra("uniSeq", ((StructMsgForImageShare)localObject2).uniseq);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", AnimationUtils.a((View)localObject1));
      localObject3 = ((StructMsgItemImage)localObject3).a;
      if (localObject3 == null) {
        break;
      }
      localIntent.addFlags(603979776);
      localObject1 = ((MessageForPic)localObject3).selfuin;
      paramView = (View)localObject1;
      if (((MessageForPic)localObject3).isMultiMsg) {}
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramView = (View)localObject1;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramView = localAppRuntime.getAccount();
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = (View)localObject1;
        }
      }
      paramView = new AIOImageProviderService(paramView, ((MessageForPic)localObject3).frienduin, ((MessageForPic)localObject3).istroop, (MessageForPic)localObject3);
      localObject1 = AIOGalleryUtils.a((MessageForPic)localObject3);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putParcelable("extra.IMAGE_PROVIDER", new BinderWarpper(paramView.asBinder()));
      ((Bundle)localObject3).putParcelable("extra.EXTRA_CURRENT_IMAGE", (Parcelable)localObject1);
      ((Bundle)localObject3).putInt("forward_source_uin_type", ((StructMsgForImageShare)localObject2).uinType);
      localIntent.putExtras((Bundle)localObject3);
      localContext.startActivity(localIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxm
 * JD-Core Version:    0.7.0.1
 */