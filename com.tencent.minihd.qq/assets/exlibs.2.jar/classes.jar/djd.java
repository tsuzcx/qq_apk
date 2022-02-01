import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class djd
  extends FriendListObserver
{
  public djd(BaseChatPie paramBaseChatPie) {}
  
  protected void a() {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    while (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    String str = null;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
      str = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
        str = ContactUtils.j(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      UinFraudInfo.a().a(paramLong);
      return;
    }
    UinFraudInfo.a().a(paramLong, paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new dje(this, paramLong));
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.a.s();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      this.a.v();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramString == null)) {
      return;
    }
    int i = 0;
    label17:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    ChatMessage localChatMessage;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        localChatMessage = AIOUtils.a((View)localObject);
        if ((localViewHolder != null) && (localChatMessage.senderuin != null) && (paramString.equals(localChatMessage.senderuin)))
        {
          if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
            break label196;
          }
          localObject = localChatMessage.frienduin;
          label139:
          if ((localChatMessage.istroop != 1010) && (localChatMessage.istroop != 1001)) {
            break label206;
          }
        }
      }
    }
    label196:
    label206:
    for (Object localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, (String)localObject, true);; localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject))
    {
      localViewHolder.a.setHeaderIcon((Drawable)localObject);
      i += 1;
      break label17;
      break;
      localObject = localChatMessage.senderuin;
      break label139;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.j(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.c(false);
      return;
    }
    this.a.c(false);
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if (!paramHashMap.containsKey(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i = 0;
    label20:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramHashMap);
        paramHashMap = AIOUtils.a(paramHashMap);
        if ((localViewHolder != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000))
        {
          FriendManager localFriendManager = (FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001)) {
            break label177;
          }
        }
      }
    }
    label177:
    for (paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3000, paramHashMap.senderuin, true);; paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin))
    {
      localViewHolder.a.setHeaderIcon(paramHashMap);
      i += 1;
      break label20;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((!paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2130838242, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367044), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.s();
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    Set localSet = (Set)paramObject;
    int k = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label46:
    Object localObject;
    ChatMessage localChatMessage;
    label104:
    int j;
    if (i < k)
    {
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramObject);
        localChatMessage = AIOUtils.a(paramObject);
        if (!localChatMessage.isSend()) {
          break label242;
        }
        paramObject = localChatMessage.selfuin;
        FriendManager localFriendManager = (FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject != null) && (((BaseBubbleBuilder.ViewHolder)localObject).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          paramObject = localFriendManager.a(paramObject);
          if (paramObject != null)
          {
            paramObject = Long.valueOf(paramObject.pendantId);
            if (paramObject != null)
            {
              if (paramObject.longValue() == 0L) {
                break label299;
              }
              paramObject = ((AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a(paramObject.longValue());
              localObject = ((BaseBubbleBuilder.ViewHolder)localObject).a;
              if (i == k) {
                break label293;
              }
              j = 1;
              label222:
              paramObject.a((View)localObject, j, localChatMessage.uniseq);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label242:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label104;
      }
      paramObject = localChatMessage.senderuin;
      break label104;
      label293:
      j = 2;
      break label222;
      label299:
      if (((BaseBubbleBuilder.ViewHolder)localObject).a.a != null)
      {
        ((BaseBubbleBuilder.ViewHolder)localObject).a.a.setImageDrawable(null);
        ((BaseBubbleBuilder.ViewHolder)localObject).a.a.setVisibility(8);
      }
    }
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label302;
        }
        i = 1;
        break;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          MultiMsgManager.a().b.putAll((Map)paramObject);
        }
        if (MultiMsgManager.a().b.size() == 0) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131366117, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          this.a.a((Map)paramObject, MultiMsgManager.a().a);
        }
      }
      label302:
      i = 0;
    }
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (BaseChatPie.b(this.a) != 0)) {}
    while ((RichStatItemBuilder.a == 0L) || (!(paramObject instanceof RichStatus.SigZanInfo))) {
      return;
    }
    ThreadManager.b(new djf(this, (RichStatus.SigZanInfo)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djd
 * JD-Core Version:    0.7.0.1
 */