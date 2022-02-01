import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.DatingShareHelper;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.qphone.base.util.QLog;

public final class jxi
  implements View.OnClickListener
{
  long a;
  
  public void onClick(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StructMsg", 4, "geneal struct msg onclick start ........");
    }
    if (SystemClock.uptimeMillis() - this.a < 1000L) {}
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    QQAppInterface localQQAppInterface;
    label351:
    int i;
    label556:
    label562:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.a = SystemClock.uptimeMillis();
                localObject1 = paramView.findViewById(2131296309);
              } while (localObject1 == null);
              localObject1 = ((View)localObject1).getTag(2131296309);
            } while ((localObject1 == null) || (!StructMsgForGeneralShare.class.isInstance(localObject1)));
            localObject1 = (StructMsgForGeneralShare)localObject1;
            localObject2 = paramView.getTag();
          } while ((localObject2 == null) || (!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)));
          localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          localObject4 = paramView.getContext();
        } while (!ChatActivity.class.isInstance(localObject4));
        localQQAppInterface = ((ChatActivity)localObject4).a();
      } while (localQQAppInterface == null);
      AbsShareMsg.doReport(localQQAppInterface, (AbsShareMsg)localObject1);
      if (((StructMsgForGeneralShare)localObject1).msgId > 0L) {
        ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForGeneralShare)localObject1).uin, "mp_msg_msgpic_click", "aio_morpic_click", 1, 0, "", "", Long.toString(((StructMsgForGeneralShare)localObject1).msgId), "");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("StructMsg", 4, "geneal struct msg onclick middle ........");
      }
      Util.a(localQQAppInterface, "", "click", ((StructMsgForGeneralShare)localObject1).mSourceAppid, ((StructMsgForGeneralShare)localObject1).mMsgServiceID, Util.a(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int));
      localObject2 = new StructMsgForGeneralShare.GeneralClickHandler(localQQAppInterface, paramView, (StructMsgForGeneralShare)localObject1);
      if ((localObject3 != null) && (((StructMsgForGeneralShare)localObject1).hasFlag(16)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PortalManager", 4, "qiang hong bao lala ......struct msg click report.........");
        }
        ThreadManager.b(new jxj(this, (StructingMsgItemBuilder.StructingMsgViewHolder)localObject3, localQQAppInterface));
      }
      if ("web".equals(((StructMsgForGeneralShare)localObject1).mMsgAction))
      {
        if (TextUtils.isEmpty(((StructMsgForGeneralShare)localObject1).mMsgActionData)) {}
        for (paramView = ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData;; paramView = ((StructMsgForGeneralShare)localObject1).mMsgActionData)
        {
          if ((TextUtils.isEmpty(paramView)) || (!paramView.startsWith("mqqapi://dating/"))) {
            break label351;
          }
          if (((StructMsgForGeneralShare.GeneralClickHandler)localObject2).c(DatingShareHelper.a(paramView), null)) {
            break;
          }
          ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
          return;
        }
        if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int == 1)
        {
          paramView = (TroopInfoManager)localQQAppInterface.getManager(36);
          if ((paramView != null) && (paramView.b(((StructMsgForGeneralShare)localObject1).mMsgUrl)) && (paramView.b()) && (!MultiForwardActivity.class.isInstance(localObject4)))
          {
            ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a("playVideo", ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
            return;
          }
          ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
          return;
        }
        if (((StructMsgForGeneralShare)localObject1).hasFlag(16))
        {
          localObject1 = ((StructMsgForGeneralShare)localObject1).mMsgUrl;
          paramView = (View)localObject1;
          if (localObject1 != null)
          {
            localObject4 = new StringBuilder().append((String)localObject1);
            if (((String)localObject1).indexOf('?') == -1) {
              break label556;
            }
            paramView = "&";
            paramView = ((StringBuilder)localObject4).append(paramView).append("f_hbType=");
            if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_Int != 1) {
              break label562;
            }
          }
          for (i = 1;; i = 2)
          {
            paramView = i + "&f_hbUin=" + ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).a.jdField_a_of_type_JavaLangString;
            if (QLog.isDevelopLevel()) {
              QLog.d("PortalManager", 4, paramView);
            }
            ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a(paramView);
            return;
            paramView = "?";
            break;
          }
        }
        ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a(((StructMsgForGeneralShare)localObject1).mMsgUrl);
        return;
      }
      if (!"plugin".equals(((StructMsgForGeneralShare)localObject1).mMsgAction)) {
        break;
      }
    } while (localQQAppInterface == null);
    ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).c(((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
    return;
    if ("viewMultiMsg".equals(((StructMsgForGeneralShare)localObject1).mMsgAction))
    {
      localObject2 = (ChatActivity)localObject4;
      i = ((ChatActivity)localObject2).a().a();
      paramView = ((ChatActivity)localObject2).a().a();
      localObject2 = ((ChatActivity)localObject2).a().c();
      localObject3 = new Intent((Context)localObject4, MultiForwardActivity.class);
      ((Intent)localObject3).putExtra("chat_subType", 3);
      ((Intent)localObject3).putExtra("uin", paramView);
      ((Intent)localObject3).putExtra("uintype", i);
      ((Intent)localObject3).putExtra("troop_code", (String)localObject2);
      ((Intent)localObject3).putExtra("multi_url", ((StructMsgForGeneralShare)localObject1).mResid);
      ((Intent)localObject3).putExtra("multi_uniseq", ((StructMsgForGeneralShare)localObject1).uniseq);
      ((Intent)localObject3).putExtra("multi_source", ((StructMsgForGeneralShare)localObject1).mSourceName);
      ((Context)localObject4).startActivity((Intent)localObject3);
      return;
    }
    ((StructMsgForGeneralShare.GeneralClickHandler)localObject2).a(((StructMsgForGeneralShare)localObject1).mMsgAction, ((StructMsgForGeneralShare)localObject1).mMsgUrl, ((StructMsgForGeneralShare)localObject1).mMsgActionData, ((StructMsgForGeneralShare)localObject1).mMsg_A_ActionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jxi
 * JD-Core Version:    0.7.0.1
 */