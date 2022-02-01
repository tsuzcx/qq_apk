package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.content.Intent;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneContactsFeedServlet
  extends MSFServlet
{
  private static final int jdField_a_of_type_Int = 60000;
  private static final String jdField_a_of_type_JavaLangString;
  private static final String b = "SQQzoneSvc.";
  
  static
  {
    a = QzoneContactsFeedServlet.class.getSimpleName();
  }
  
  private void b(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if ((paramBoolean) && (paramnewest_feeds_rsp != null))
    {
      a(paramBoolean, paramnewest_feeds_rsp);
      if (paramBoolean)
      {
        localQQAppInterface.a().a(paramnewest_feeds_rsp);
        localQQAppInterface.a().d();
        return;
      }
      localQQAppInterface.a().c();
      return;
    }
    localQQAppInterface.a().c();
  }
  
  protected void a(boolean paramBoolean, newest_feeds_rsp paramnewest_feeds_rsp)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "feedTime=" + paramnewest_feeds_rsp.last_feed_time);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
      if (localQQAppInterface != null)
      {
        Object localObject = paramnewest_feeds_rsp.vec_feed_info;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramnewest_feeds_rsp = (FriendsManager)localQQAppInterface.getManager(49);
          if (paramnewest_feeds_rsp != null)
          {
            ArrayList localArrayList = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              feed_info localfeed_info = (feed_info)((Iterator)localObject).next();
              ExtensionInfo localExtensionInfo = paramnewest_feeds_rsp.a(String.valueOf(localfeed_info.opuin));
              if (localExtensionInfo != null)
              {
                if (localfeed_info.has_pic == 1L) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  localExtensionInfo.feedHasPhoto = paramBoolean;
                  localExtensionInfo.feedContent = QzoneContactsFeedUtils.a(localfeed_info.strcontent, localQQAppInterface);
                  localExtensionInfo.feedTime = localfeed_info.time;
                  localArrayList.add(localExtensionInfo);
                  break;
                }
              }
            }
            paramnewest_feeds_rsp.b(localArrayList);
          }
          paramnewest_feeds_rsp = (FriendListHandler)localQQAppInterface.a(1);
          if (paramnewest_feeds_rsp != null) {
            paramnewest_feeds_rsp.a(2, true, null);
          }
        }
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = QzoneContactsFeedRequest.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        b(true, paramIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "inform QzoneContactsFeedServlet isSuccess false");
      }
      b(false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "inform QzoneContactsFeedServlet resultcode fail.");
    }
    b(false, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    byte[] arrayOfByte = new QzoneContactsFeedRequest(QzoneContactsFeedUtils.a(paramIntent)).b();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "getAIONewestFeeds");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedServlet
 * JD-Core Version:    0.7.0.1
 */