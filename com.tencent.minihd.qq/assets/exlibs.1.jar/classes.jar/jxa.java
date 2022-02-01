import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public final class jxa
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.findViewById(2131296309);
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      localObject1 = ((View)localObject1).getTag(2131296309);
      if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForAudioShare))) {
        continue;
      }
      localObject1 = (StructMsgForAudioShare)localObject1;
      Object localObject2 = paramView.getTag();
      if ((localObject2 == null) || (!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))) {
        continue;
      }
      localObject2 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
      Context localContext = paramView.getContext();
      try
      {
        paramView = (QQAppInterface)((BaseApplicationImpl)localContext.getApplicationContext()).getAppRuntime(((StructMsgForAudioShare)localObject1).currentAccountUin);
        AbsShareMsg.doReport(paramView, (AbsShareMsg)localObject1);
        if (paramView == null) {
          continue;
        }
        if (((StructMsgForAudioShare)localObject1).msgId > 0L) {
          ReportController.b(paramView, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForAudioShare)localObject1).uin, "mp_msg_msgpic_click", "aio_morpic_click", 1, 0, "", "", Long.toString(((StructMsgForAudioShare)localObject1).msgId), "");
        }
        Util.a(paramView, "", "click", ((StructMsgForAudioShare)localObject1).mSourceAppid, ((StructMsgForAudioShare)localObject1).mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject2).a.a));
        MediaPlayerManager.a(paramView).a(true);
        if (!"web".equals(((StructMsgForAudioShare)localObject1).mMsgAction)) {
          continue;
        }
        paramView = new Intent(localContext, QQBrowserDelegationActivity.class);
        paramView.putExtra("key_isReadModeEnabled", true);
        paramView.putExtra("url", ((StructMsgForAudioShare)localObject1).mMsgUrl);
        paramView.putExtra("param_force_internal_browser", true);
        paramView.putExtra("isAppShare", true);
        paramView.putExtra("appShareID", AppShareIDUtil.a(((StructMsgForAudioShare)localObject1).mSourceAppid));
        paramView.putExtra("fromAio", true);
        localContext.sendBroadcast(new Intent("qqplayer_exit_action"));
        PublicAccountUtil.a(paramView, ((StructMsgForAudioShare)localObject1).mMsgUrl);
        localContext.startActivity(paramView);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, ((StructMsgForAudioShare)localObject1).mMsgUrl, "", "", "");
        return;
      }
      catch (AccountNotMatchException paramView)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, paramView.getStackTrace().toString());
          }
          paramView = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxa
 * JD-Core Version:    0.7.0.1
 */