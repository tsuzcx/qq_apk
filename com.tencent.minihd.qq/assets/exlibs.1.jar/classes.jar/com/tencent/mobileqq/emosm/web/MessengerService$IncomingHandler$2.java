package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.util.Iterator;
import java.util.List;

class MessengerService$IncomingHandler$2
  implements Runnable
{
  MessengerService$IncomingHandler$2(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject2 = LebaShowListManager.a().a();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      LebaShowListManager.a().a(this.this$1.this$0, this.val$qqapp);
      localObject1 = LebaShowListManager.a().a();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId != this.val$resId));
    }
    for (int i = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      localObject1 = new Bundle();
      if (i == -1)
      {
        ((Bundle)localObject1).putInt("ret", 1);
        if (i != 0) {
          break label177;
        }
      }
      label177:
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject1).putInt("type", i);
        this.val$reqbundle.putBundle("response", (Bundle)localObject1);
        this.this$1.this$0.onRespToClient(this.val$reqbundle);
        return;
        ((Bundle)localObject1).putInt("ret", 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.2
 * JD-Core Version:    0.7.0.1
 */