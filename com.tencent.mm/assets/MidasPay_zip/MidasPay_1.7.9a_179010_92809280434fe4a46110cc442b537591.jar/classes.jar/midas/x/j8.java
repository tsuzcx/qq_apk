package midas.x;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;

public abstract interface j8
{
  public abstract void a(WebView paramWebView, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(WebView paramWebView, String paramString);
  
  public abstract void a(WebView paramWebView, String paramString, Bitmap paramBitmap);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult);
  
  public abstract boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult);
  
  public abstract void b(WebView paramWebView, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j8
 * JD-Core Version:    0.7.0.1
 */