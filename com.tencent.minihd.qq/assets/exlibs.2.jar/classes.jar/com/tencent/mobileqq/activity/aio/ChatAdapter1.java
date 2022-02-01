package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForHypertext;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XBaseAdapter;
import fow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatAdapter1
  extends XBaseAdapter
{
  @Deprecated
  public static long a;
  @Deprecated
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ItemBuilderFactory a;
  public QQAppInterface a;
  fow jdField_a_of_type_Fow = new fow(this, null);
  public Boolean a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Long = -1L;
  }
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a();
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
      b(i, i);
    }
  }
  
  public void a(List paramList)
  {
    ChatMessage localChatMessage;
    int i;
    int j;
    if (paramList.size() > 0)
    {
      localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((localChatMessage instanceof MessageForGrayTips))
        {
          i += 1;
          if (paramList.size() - i >= 0)
          {
            localChatMessage = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            if ((localChatMessage instanceof MessageForMarketFace)) {
              break;
            }
          }
        }
      }
    }
    label407:
    label413:
    label431:
    for (;;)
    {
      label85:
      return;
      int k = i + 1;
      Object localObject1;
      Object localObject2;
      if (paramList.size() - k >= 0)
      {
        for (localObject1 = (ChatMessage)paramList.get(paramList.size() - k);; localObject1 = (ChatMessage)paramList.get(paramList.size() - k))
        {
          localObject2 = localObject1;
          i = j;
          if (!(localObject1 instanceof MessageForGrayTips)) {
            break label184;
          }
          k += 1;
          if (paramList.size() - k < 0) {
            break;
          }
        }
        i = 0;
        localObject2 = localObject1;
        label184:
        if (!(localObject2 instanceof MessageForMarketFace)) {
          break label407;
        }
        paramList = (List)localObject2;
      }
      for (;;)
      {
        if ((i == 0) || (localChatMessage == null) || (paramList == null)) {
          break label431;
        }
        localChatMessage.isMarketFaceFlow = false;
        paramList.isMarketFaceFlow = false;
        if ((localChatMessage.istroop != 1) && (localChatMessage.istroop != 3000)) {
          break label85;
        }
        localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        localObject2 = ((MessageForMarketFace)paramList).mMarkFaceMessage;
        if (localObject1 == null)
        {
          localChatMessage.parse();
          localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        }
        for (;;)
        {
          if (localObject2 == null) {
            paramList.parse();
          }
          for (paramList = ((MessageForMarketFace)paramList).mMarkFaceMessage;; paramList = (List)localObject2)
          {
            if ((localObject1 == null) || (paramList == null) || (((MarkFaceMessage)localObject1).dwTabID != paramList.dwTabID) || (!EmosmUtils.bytes2eId(((MarkFaceMessage)localObject1).sbufID, ((MarkFaceMessage)localObject1).mediaType).equals(EmosmUtils.bytes2eId(paramList.sbufID, paramList.mediaType)))) {
              break label413;
            }
            localChatMessage.isMarketFaceFlow = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", ((MarkFaceMessage)localObject1).dwTabID + "", "", "");
            return;
            localObject2 = null;
            i = 0;
            break label184;
            break;
          }
          break;
        }
        j = 1;
        break;
        paramList = null;
        localChatMessage = null;
        i = 1;
      }
    }
  }
  
  public void a(List paramList, CharSequence paramCharSequence)
  {
    int i = 0;
    for (;;)
    {
      ChatMessage localChatMessage;
      try
      {
        Iterator localIterator = paramList.iterator();
        localObject = null;
        if (localIterator.hasNext())
        {
          localChatMessage = (ChatMessage)localIterator.next();
          if (((localObject == null) || (localChatMessage.time - ((ChatMessage)localObject).time > 180L)) && (MessageUtils.b(localChatMessage.msgtype)))
          {
            localChatMessage.mNeedTimeStamp = true;
            if (i != paramList.size() - 1) {
              localChatMessage.isMarketFaceFlow = false;
            }
            if (!(localChatMessage instanceof MessageForStructing)) {
              break label241;
            }
            localChatMessage.parse();
            localObject = ((MessageForStructing)localChatMessage).structingMsg;
            if ((!(localObject instanceof StructMsgForHypertext)) || (((StructMsgForHypertext)localObject).mHpertextArray != null)) {
              break label241;
            }
            localIterator.remove();
            break label241;
          }
          localChatMessage.mNeedTimeStamp = false;
          continue;
        }
        this.jdField_a_of_type_JavaUtilList = paramList;
      }
      finally {}
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramCharSequence != null))
      {
        localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
        localChatMessage.mNeedGrayTips = true;
        localChatMessage.mMessageSource = paramCharSequence;
      }
      if ((localObject != null) && (!((ChatMessage)localObject).isMarketFaceFlow)) {
        a(paramList);
      }
      super.notifyDataSetChanged();
      return;
      label241:
      i += 1;
      Object localObject = localChatMessage;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Fow.a != null) {
      this.jdField_a_of_type_Fow.a.b();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
  }
  
  public int getItemViewType(int paramInt)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    StartupTracker.a(null, "AIO_ChatAdapter_getView | " + localChatMessage1.getClass().getName());
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage1, this);
    if (paramInt != 0)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      if ((localChatMessage2 != null) && ((localChatMessage2 instanceof MessageForTroopUnreadTips))) {
        localChatMessage1.mNeedTimeStamp = true;
      }
    }
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage1, paramView, paramViewGroup, this.jdField_a_of_type_Fow);
    if (paramView != null) {
      paramView.setTag(2131296312, localChatMessage1);
    }
    StartupTracker.a("AIO_ChatAdapter_getView | " + localChatMessage1.getClass().getName(), null);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "AIOTime getView " + localChatMessage1.getClass().getName());
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 37;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatAdapter1
 * JD-Core Version:    0.7.0.1
 */