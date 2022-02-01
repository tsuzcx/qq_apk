package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class MessengerService$4
  extends CardObserver
{
  MessengerService$4(MessengerService paramMessengerService) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    long l2;
    long l1;
    int i;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.access$4600(this.this$0);
      if ((paramObject.templateRet == 0) && (localQQAppInterface != null) && (Utils.a(localQQAppInterface.a(), paramObject.uin)))
      {
        l2 = paramObject.lCurrentBgId;
        l1 = paramObject.lCurrentStyleId;
        i = 0;
        paramObject = new Bundle();
        paramObject.putLong("currentId", l2);
        paramObject.putLong("styleId", l1);
        paramObject.putInt("result", i);
        if (this.this$0.mOnCardDownloadBundle == null) {
          break label164;
        }
        this.this$0.mOnCardDownloadBundle.putBundle("response", paramObject);
        this.this$0.onRespToClient(this.this$0.mOnCardDownloadBundle);
      }
    }
    label164:
    while (!QLog.isColorLevel())
    {
      return;
      i = -1;
      l2 = 0L;
      l1 = 0L;
      break;
      i = -1;
      l2 = 0L;
      l1 = 0L;
      break;
    }
    QLog.d("MessengerService.onCardDownload", 2, "mOnCardDownloadBundle is null ");
  }
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    int j = -1;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramBoolean)
    {
      str1 = str2;
      i = j;
      if (paramObject != null)
      {
        if (!(paramObject instanceof Card)) {
          break label157;
        }
        i = 0;
        str1 = str2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (MessengerService.access$2000(this.this$0) != null)
      {
        paramObject = new Bundle();
        MessengerService.access$2000(this.this$0).putString("cmd", "card_setSummaryCard");
        paramObject.putInt("result", i);
        paramObject.putString("message", str1);
        MessengerService.access$2000(this.this$0).putBundle("response", paramObject);
        this.this$0.onRespToClient(MessengerService.access$2000(this.this$0));
        MessengerService.access$2002(this.this$0, null);
      }
      return;
      label157:
      str1 = str2;
      i = j;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str1 = (String)paramObject.second;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.4
 * JD-Core Version:    0.7.0.1
 */