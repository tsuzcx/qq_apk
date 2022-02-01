package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneContactsFeedRequest
  extends QzoneExternalRequest
{
  public static final String a = "getAIONewestFeeds";
  private static final String b = "getAIONewestFeeds";
  private static final String c = "QzoneNewService.getAIONewestFeeds";
  private static final String d = "getAIONewestFeeds";
  
  public QzoneContactsFeedRequest(newest_feeds_req paramnewest_feeds_req)
  {
    super.a(paramnewest_feeds_req.login_uin);
    super.b(paramnewest_feeds_req.login_uin);
    super.a(paramnewest_feeds_req);
  }
  
  public static newest_feeds_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    newest_feeds_rsp localnewest_feeds_rsp;
    do
    {
      return paramArrayOfByte;
      localnewest_feeds_rsp = (newest_feeds_rsp)a(paramArrayOfByte, "getAIONewestFeeds");
      paramArrayOfByte = localnewest_feeds_rsp;
    } while (localnewest_feeds_rsp != null);
    return null;
  }
  
  public String a()
  {
    return "getAIONewestFeeds";
  }
  
  public String f()
  {
    return "QzoneNewService.getAIONewestFeeds";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedRequest
 * JD-Core Version:    0.7.0.1
 */