package com.tencent.mobileqq.jsbridge;

import com.tencent.biz.AuthorizeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Deprecated
public class JsBridge
{
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public void a(JsBridge.JsHandler paramJsHandler, String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramJsHandler);
  }
  
  public void a(String paramString)
  {
    if (paramString == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public void a(String paramString1, String paramString2, List paramList, JsBridge.JsBridgeListener paramJsBridgeListener)
  {
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          paramList.set(i, URLDecoder.decode((String)paramList.get(i), "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            if (QLog.isDevelopLevel()) {
              QLog.i("JB", 4, "decode failed: " + (String)paramList.get(i));
            }
          }
        }
      }
    }
    paramString1 = (JsBridge.JsHandler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (paramString1 != null) {
      paramString1.call(paramString2, paramList, paramJsBridgeListener);
    }
    while (paramJsBridgeListener == null) {
      return;
    }
    paramJsBridgeListener.a();
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (!paramString.startsWith("jsbridge://")) {
      return false;
    }
    List localList = Arrays.asList((paramString + "/#").split("/"));
    if (localList.size() < 6) {
      return false;
    }
    String str1 = (String)localList.get(2);
    String str2 = (String)localList.get(3);
    String str3 = (String)localList.get(4);
    for (;;)
    {
      try
      {
        long l = Long.parseLong(str3);
        localList = localList.subList(5, localList.size() - 1);
        if (QLog.isDevelopLevel()) {
          QLog.d("JB", 4, "calling " + str1 + "." + str2);
        }
        paramString = new JsBridge.JsBridgeListener(paramWebView, l, paramString);
        paramWebView = paramWebView.getUrl();
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
          this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
        }
        if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView, str1 + "." + str2))
        {
          a(str1, str2, localList, paramString);
          return true;
        }
      }
      catch (Exception paramWebView)
      {
        return false;
      }
      paramString.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsbridge.JsBridge
 * JD-Core Version:    0.7.0.1
 */