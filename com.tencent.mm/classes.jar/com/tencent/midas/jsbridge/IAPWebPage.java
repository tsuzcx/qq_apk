package com.tencent.midas.jsbridge;

import android.app.Activity;
import com.tencent.midas.api.request.APMidasBaseRequest;

public abstract interface IAPWebPage
{
  public abstract void initHead(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void initUI(Activity paramActivity);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void toPureH5Pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest);
  
  public abstract void updateWebViewSize(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.jsbridge.IAPWebPage
 * JD-Core Version:    0.7.0.1
 */