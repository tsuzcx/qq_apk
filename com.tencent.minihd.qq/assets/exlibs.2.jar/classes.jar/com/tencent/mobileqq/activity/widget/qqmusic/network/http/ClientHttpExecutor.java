package com.tencent.mobileqq.activity.widget.qqmusic.network.http;

import com.tencent.mobileqq.activity.widget.qqmusic.network.request.BaseCgiRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.network.request.CommonRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClientHttpExecutor
  extends BaseHttpExector
{
  private static volatile ClientHttpExecutor jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicNetworkHttpClientHttpExecutor;
  private static final String jdField_a_of_type_JavaLangString = "ClientHttpExecutor";
  
  public static ClientHttpExecutor a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ClientHttpExecutor();
      }
      return a;
    }
    finally {}
  }
  
  public HttpResponse a(CommonRequest paramCommonRequest)
  {
    if (paramCommonRequest == null) {
      MLog.a("ClientHttpExecutor", "request is empty");
    }
    while (!(paramCommonRequest instanceof BaseCgiRequest)) {
      return null;
    }
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    paramCommonRequest = a((BaseCgiRequest)paramCommonRequest);
    try
    {
      paramCommonRequest = localDefaultHttpClient.execute(paramCommonRequest);
      return paramCommonRequest;
    }
    catch (Exception paramCommonRequest)
    {
      paramCommonRequest.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.http.ClientHttpExecutor
 * JD-Core Version:    0.7.0.1
 */