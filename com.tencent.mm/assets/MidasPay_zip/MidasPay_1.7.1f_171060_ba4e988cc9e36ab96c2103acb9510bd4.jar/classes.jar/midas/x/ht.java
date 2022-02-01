package midas.x;

import android.graphics.Bitmap;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;

public abstract interface ht
{
  public abstract void a(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(WebView paramWebView, String paramString);
  
  public abstract void a(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
  
  public abstract void b(WebView paramWebView, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ht
 * JD-Core Version:    0.7.0.1
 */