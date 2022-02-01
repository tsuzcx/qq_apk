package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.jsbridge.JsBridge.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import lee;
import lef;

public class OpenJsBridge$OpenJsBridgeListener
  extends JsBridge.JsBridgeListener
{
  public long b;
  String jdField_b_of_type_JavaLangString;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public OpenJsBridge$OpenJsBridgeListener(WebView paramWebView, long paramLong, String paramString)
  {
    super(paramWebView, paramLong, paramString);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, Object paramObject)
  {
    WebView localWebView = (WebView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localWebView == null) || (paramObject == null)) {
      return;
    }
    String str = "'undefined'";
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).replace("\\", "\\\\").replace("'", "\\'");
      str = "'" + paramObject + "'";
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).post(new lee(this, paramString, str, localWebView));
      return;
      if (((paramObject instanceof Number)) || ((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Double)) || ((paramObject instanceof Float))) {
        str = paramObject.toString();
      } else if ((paramObject instanceof Boolean)) {
        str = paramObject.toString();
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    WebView localWebView = (WebView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new lef(this, paramString, localWebView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener
 * JD-Core Version:    0.7.0.1
 */