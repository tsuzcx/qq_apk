package com.tencent.mobileqq.activity.widget.qqmusic.network.http;

import com.tencent.mobileqq.activity.widget.qqmusic.network.request.BaseCgiRequest;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;

public abstract class BaseHttpExector
{
  private static final String a = "liwei";
  private static final String b = "Content-Type";
  private static final String c = "application/x-www-form-urlencoded; charset=UTF-8";
  
  private String a(String paramString, HashMap paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("?");
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        localStringBuilder.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
        localStringBuilder.append("&");
      }
    }
    MLog.a("liwei", "getparams : " + paramHashMap.toString());
    MLog.a("liwei", "final url : " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  private void a(HttpPost paramHttpPost, BaseCgiRequest paramBaseCgiRequest)
  {
    Object localObject = paramBaseCgiRequest.a();
    if ((localObject != null) && (localObject.length > 0))
    {
      MLog.b("liwei", paramBaseCgiRequest.getClass().getSimpleName() + " post content : " + new String((byte[])localObject));
      paramHttpPost.setEntity(new ByteArrayEntity((byte[])localObject));
      return;
    }
    localObject = new ArrayList();
    paramBaseCgiRequest = paramBaseCgiRequest.b();
    if (paramBaseCgiRequest != null)
    {
      paramBaseCgiRequest = paramBaseCgiRequest.entrySet().iterator();
      while (paramBaseCgiRequest.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramBaseCgiRequest.next();
        ((List)localObject).add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    try
    {
      paramHttpPost.setEntity(new UrlEncodedFormEntity((List)localObject, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramHttpPost)
    {
      paramHttpPost.printStackTrace();
    }
  }
  
  protected String a(BaseCgiRequest paramBaseCgiRequest)
  {
    if (paramBaseCgiRequest != null) {
      return paramBaseCgiRequest.a();
    }
    return "";
  }
  
  protected HttpUriRequest a(BaseCgiRequest paramBaseCgiRequest)
  {
    Object localObject = paramBaseCgiRequest.a();
    String str = a(paramBaseCgiRequest);
    MLog.a("liwei", "url : " + str);
    switch (paramBaseCgiRequest.a())
    {
    default: 
      return null;
    case 0: 
      return new HttpGet(a(str, (HashMap)localObject));
    }
    localObject = new HttpPost(str);
    ((HttpPost)localObject).addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    a((HttpPost)localObject, paramBaseCgiRequest);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.network.http.BaseHttpExector
 * JD-Core Version:    0.7.0.1
 */